package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.GregorianCalendar;


import data.DataOps;
import view.Appointment;

public class Helper {
	
	static ResultSet rs = null;
	static ResultSet rs1 = null;
	static ResultSet rs2 = null;
	static ResultSet rs3 = null;
	
	public Appointment scheduleMaintenanceHelper(int customerId, String licensePlate, String mechanic, int currentMileage) throws SQLException, ParseException{
		Appointment ap = new Appointment();
		String mileageQuery="select LASTRECORDEDMILEAGE,make,model,servicecenterid from vehicle where licenseplate='"+licensePlate+"'";
		ResultSet mileageRS = DataOps.getInstance().retrieve(mileageQuery); 
		int lastRecordedMileage = mileageRS.getInt("LASTRECORDEDMILEAGE");
		String make = mileageRS.getString("make");
		String model = mileageRS.getString("model");
		int servicecenterid = mileageRS.getInt("servicecenterid");
		String updateMileageQuery="update Vehicle set lastrecordedmileage="+currentMileage+" where licenseplate='"+licensePlate+"'";
		DataOps.getInstance().insertInto(updateMileageQuery);
		int maintenanceType;
		if(lastRecordedMileage - currentMileage < 10000 ) {
			maintenanceType=1;
		}
		else if(lastRecordedMileage - currentMileage < 25000) {
			maintenanceType=2;
		}
		else {
			maintenanceType=3;
		}
		ap.customerId=customerId;
		ap.licensePlate = licensePlate;
		ap.serviceId=maintenanceType;
		//Get basic services for this repair
		String deficitQuery = "select j2.partid, j2.currentquantity,j2.requiredquantity,j3.schduledquantity from \n" + 
				"(select h.partid, h.currentquantity, j1.requiredquantity from has h join \n" + 
				"(select U.partid, U.quantity as requiredquantity from Uses U where basicserviceid in (select C.basicserviceid from Repair R join Contains C on r.serviceid = c.serviceid where c.serviceid="+maintenanceType+"and c.make='"+make+"' and c.model='"+model+"') \n" + 
				"and (U.make, U.model) in (select V.make, v.model from vehicle V where v.licenseplate='"+licensePlate+"')) J1 on h.partid = j1.partid where h.servicecenterid ="+servicecenterid+") J2 join (select partid, sum(quantity) as schduledquantity from outgoingparts where servicecenterid ="+servicecenterid+" group by partid)j3\n" + 
				"on j2.partid = j3.partid";
		ResultSet rs = DataOps.getInstance().retrieve(deficitQuery);
		int partId, currentquantity,requiredquantity, schduledquantity,deficit;
		boolean shortage=false;
		Date maxDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
		try {
			while(rs.next()) {
				partId = rs.getInt("partid");
				currentquantity = rs.getInt("currentquantity");
				requiredquantity = rs.getInt("requiredquantity");
				schduledquantity =  rs.getInt("schduledquantity");
				deficit = currentquantity-requiredquantity-schduledquantity;
				if(deficit < 0) {
					String pendingOrderQuery = "select sum(quantity) as orderedPartQuantity, max(expecteddeliverydate) as expected from Orders where partId="+partId+"and status='Pending'";
					ResultSet rs1= DataOps.getInstance().retrieve(pendingOrderQuery);
					while(rs1.next()) {
						int orderedPartQuantity = rs.getInt("orderedPartQuantity");
						Date expectedDate = rs.getTimestamp("ordered");
						if(orderedPartQuantity+currentquantity-requiredquantity-schduledquantity > 0) {
							if(expectedDate.compareTo(maxDate) ==1) {
								maxDate=expectedDate;
							}
						}
						else {
							Date order = orderParts(servicecenterid,partId, -1);
							if(order.compareTo(maxDate) ==1) {
								maxDate=order;
							}
						}
					}
					shortage=true;
				}
				else {
					ap.partsRequired.put(partId, requiredquantity);
				}
			}
			if(!shortage) {
				
				String hoursReqdQuery = "select sum(hoursrequired) as totalhoursrequired from (select basicserviceid from contains where serviceid="+maintenanceType+" and (make,model) in (select make,model from vehicle where licenseplate='"+licensePlate+"')) j1 join basicservice b on j1.basicserviceid=b.basicserviceid";
				ResultSet hoursReqdRS = DataOps.getInstance().retrieve(hoursReqdQuery);
				hoursReqdRS.next();
				ap.hoursReqd = hoursReqdRS.getInt("totalhoursrequired");
				
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date today = new Date();
				String date = sdfDate.format(today);
				
				
				String mechQuery;
				if(mechanic== null || mechanic.length()==0) {
					mechQuery = "select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where r.day > '"+date+"' and 8-r.hours >="+ap.hoursReqd+" order by r.day"  ;
					ResultSet mechRS = DataOps.getInstance().retrieve(mechQuery);
					mechRS.next();
					String availableSlots = mechRS.getString("availableslots");
					String[] availableSlotsList = availableSlots.split(",");
					while (availableSlotsList.length < ap.hoursReqd) {
						if (!mechRS.next()) {
							ap.canSchedule = false;
							ap.errorReport = "Cannot schedule appointment with preferred mechanic. Please choose another preference or leave field blank";
							return ap;
						}
					}
					availableSlots = mechRS.getString("availableslots");
					availableSlotsList = availableSlots.split(",");
					ap.assignedMechanic = mechRS.getString("name");
					ap.assignedMechanicId = mechRS.getInt("employeeid");
					String dayString = mechRS.getString("day");
					SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date startOfDay = hourFormat.parse(dayString + " 08:00");
					ap.proposedDates[0] = hourFormat.format(new Date(
							startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
					StringBuffer slotBuffer = new StringBuffer();
					double hoursReqd = ap.hoursReqd;
					for (int j = 0; j < hoursReqd; j++) {
						slotBuffer.append(availableSlotsList[j] + ",");

					}
					slotBuffer.deleteCharAt(slotBuffer.length() - 1);
					ap.proposedSlots[0] = slotBuffer.toString();
					mechQuery="select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where e.name='"+ap.assignedMechanic+"' and r.day > '"+ap.proposedDates[0].substring(0, 10)+"' order by r.day" ;
					mechRS = DataOps.getInstance().retrieve(mechQuery);
				
					
						mechRS.next();
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						while (availableSlotsList.length < ap.hoursReqd) {
							if (!mechRS.next()) {
								ap.canSchedule = false;
								ap.errorReport = "Cannot schedule appointment. Please try later";
								return ap;
							}
						}
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						dayString = mechRS.getString("day");
						hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						startOfDay = hourFormat.parse(dayString + " 08:00");
						ap.proposedDates[1] = hourFormat.format(new Date(
								startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
						slotBuffer = new StringBuffer();
						hoursReqd = ap.hoursReqd;
						for (int j = 0; j < hoursReqd; j++) {
							slotBuffer.append(availableSlotsList[j] + ",");

						}
						slotBuffer.deleteCharAt(slotBuffer.length() - 1);
						ap.proposedSlots[1] = slotBuffer.toString();
				
				
				}
				
				else {
	
					mechQuery="select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where e.name='"+mechanic+"' and r.day > '"+date+"' order by r.day" ;
					ResultSet mechRS = DataOps.getInstance().retrieve(mechQuery);
				
					for (int i = 0; i < 2; i++) {
						mechRS.next();
						String availableSlots = mechRS.getString("availableslots");
						String[] availableSlotsList = availableSlots.split(",");
						while (availableSlotsList.length < ap.hoursReqd) {
							if (!mechRS.next()) {
								ap.canSchedule = false;
								ap.errorReport = "Cannot schedule appointment with preferred mechanic. Please choose another preference or leave field blank";
								return ap;
							}
						}
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						ap.assignedMechanic = mechanic;
						ap.assignedMechanicId = mechRS.getInt("employeeid");
						String dayString = mechRS.getString("day");
						SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date startOfDay = hourFormat.parse(dayString + " 08:00");
						ap.proposedDates[i] = hourFormat.format(new Date(
								startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
						StringBuffer slotBuffer = new StringBuffer();
						double hoursReqd = ap.hoursReqd;
						for (int j = 0; j < hoursReqd; j++) {
							slotBuffer.append(availableSlotsList[j] + ",");

						}
						slotBuffer.deleteCharAt(slotBuffer.length() - 1);
						ap.proposedSlots[i] = slotBuffer.toString();
					}
					
					
					
				}
				ap.canSchedule=true;
				return ap;
			}
			else {
				ap.canSchedule=false;
				ap.errorReport="Cannot schedule due to inventory shortage. Please schedule appointment after: "+maxDate;
				return ap;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		return null;
		//Print diagnostic report and basic services for this repair

		//For each basic service check if parts are available, order if they are not, and print next available dates.
	}
	
	public Appointment scheduleRepairHelper(int customerId, String licensePlate, String mechanic, int currentMileage, int problem) throws ParseException, SQLException{
		Appointment ap = new Appointment();
		ap.customerId=customerId;
		ap.licensePlate = licensePlate;
		ap.serviceId=3+problem;
		String mileageQuery="select servicecenterid from vehicle where licenseplate='"+licensePlate+"'";
		ResultSet mileageRS = DataOps.getInstance().retrieve(mileageQuery); 
		mileageRS.next();
		int servicecenterid = mileageRS.getInt("servicecenterid");
		String updateMileageQuery="update Vehicle set lastrecordedmileage="+currentMileage+" where licenseplate='"+licensePlate+"'";
		DataOps.getInstance().insertInto(updateMileageQuery);
		//Get basic services for this repair
		String deficitQuery = "select j2.partid, j2.currentquantity,j2.requiredquantity,NVL(j3.schduledquantity,0) as schduledquantity from \n" + 
				"(select h.partid, h.currentquantity, j1.requiredquantity from has h join \n" + 
				"(select U.partid, U.quantity as requiredquantity from Uses U where basicserviceid in (select C.basicserviceid from Repair R join Contains C on r.serviceid = c.serviceid where c.serviceid="+(3+problem)+") \n" + 
				"and (U.make, U.model) in (select V.make, v.model from vehicle V where v.licenseplate='"+licensePlate+"')) J1 on h.partid = j1.partid where h.servicecenterid ='"+servicecenterid+"') J2 left join (select partid, sum(quantity) as schduledquantity from outgoingparts where servicecenterid ="+servicecenterid+" group by partid)j3\n" + 
				"on j2.partid = j3.partid";
		ResultSet rs = DataOps.getInstance().retrieve(deficitQuery);
		int partId, currentquantity,requiredquantity, schduledquantity,deficit;
		boolean shortage=false;
		Date maxDate = new SimpleDateFormat("yyyy-MM-dd").parse("1970-01-01");
		try {
			while(rs.next()) {
				partId = rs.getInt("partid");
				currentquantity = rs.getInt("currentquantity");
				requiredquantity = rs.getInt("requiredquantity");
				schduledquantity =  rs.getInt("schduledquantity");
				deficit = currentquantity-requiredquantity-schduledquantity;
				if(deficit < 0) {
					String pendingOrderQuery = "select sum(quantity) as orderedPartQuantity, max(expecteddeliverydate) as expected from Orders where partId="+partId+"and status='Pending'";
					ResultSet rs1= DataOps.getInstance().retrieve(pendingOrderQuery);
					while(rs1.next()) {
						int orderedPartQuantity = rs.getInt("orderedPartQuantity");
						Date expectedDate = rs.getTimestamp("ordered");
						if(orderedPartQuantity+currentquantity-requiredquantity-schduledquantity > 0) {
							if(expectedDate.compareTo(maxDate) ==1) {
								maxDate=expectedDate;
							}
						}
						else {
							Date order = orderParts(servicecenterid,partId, schduledquantity+requiredquantity-currentquantity-orderedPartQuantity);
							if(order.compareTo(maxDate) ==1) {
								maxDate=order;
							}
						}
					}
					shortage=true;
				}
				else {
					ap.partsRequired.put(partId, requiredquantity);
				}
			}
			if(!shortage) {
				String diagQuery = "select diagnosticfee, diagnosticDescription from Repair where serviceid="+(3+problem);
				ResultSet diagRS = DataOps.getInstance().retrieve(diagQuery);
				diagRS.next();
				ap.diagnosticReport=diagRS.getString("diagnosticDescription");
				ap.diagnosticFee=diagRS.getInt("diagnosticFee");
				
				String hoursReqdQuery = "select sum(hoursrequired) as totalhoursrequired from (select basicserviceid from contains where serviceid="+(3+problem)+" and (make,model) in (select make,model from vehicle where licenseplate='"+licensePlate+"')) j1 join basicservice b on j1.basicserviceid=b.basicserviceid";
				ResultSet hoursReqdRS = DataOps.getInstance().retrieve(hoursReqdQuery);
				hoursReqdRS.next();
				ap.hoursReqd = hoursReqdRS.getInt("totalhoursrequired");
				
				SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
				Date today = new Date();
				String date = sdfDate.format(today);
				
				
				String mechQuery;
				if(mechanic== null || mechanic.length()==0) {
					mechQuery = "select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where r.day > '"+date+"' and 8-r.hours >="+ap.hoursReqd+" order by r.day"  ;
					ResultSet mechRS = DataOps.getInstance().retrieve(mechQuery);
					mechRS.next();
					String availableSlots = mechRS.getString("availableslots");
					String[] availableSlotsList = availableSlots.split(",");
					while (availableSlotsList.length < ap.hoursReqd) {
						if (!mechRS.next()) {
							ap.canSchedule = false;
							ap.errorReport = "Cannot schedule appointment with preferred mechanic. Please choose another preference or leave field blank";
							return ap;
						}
					}
					availableSlots = mechRS.getString("availableslots");
					availableSlotsList = availableSlots.split(",");
					ap.assignedMechanic = mechRS.getString("name");
					ap.assignedMechanicId = mechRS.getInt("employeeid");
					String dayString = mechRS.getString("day");
					SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					Date startOfDay = hourFormat.parse(dayString + " 08:00");
					ap.proposedDates[0] = hourFormat.format(new Date(
							startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
					StringBuffer slotBuffer = new StringBuffer();
					double hoursReqd = ap.hoursReqd;
					for (int j = 0; j < hoursReqd; j++) {
						slotBuffer.append(availableSlotsList[j] + ",");

					}
					slotBuffer.deleteCharAt(slotBuffer.length() - 1);
					ap.proposedSlots[0] = slotBuffer.toString();
					mechQuery="select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where e.name='"+ap.assignedMechanic+"' and r.day > '"+ap.proposedDates[0].substring(0, 10)+"' order by r.day" ;
					mechRS = DataOps.getInstance().retrieve(mechQuery);
				
					
						mechRS.next();
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						while (availableSlotsList.length < ap.hoursReqd) {
							if (!mechRS.next()) {
								ap.canSchedule = false;
								ap.errorReport = "Cannot schedule appointment. Please try later";
								return ap;
							}
						}
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						dayString = mechRS.getString("day");
						hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						startOfDay = hourFormat.parse(dayString + " 08:00");
						ap.proposedDates[1] = hourFormat.format(new Date(
								startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
						slotBuffer = new StringBuffer();
						hoursReqd = ap.hoursReqd;
						for (int j = 0; j < hoursReqd; j++) {
							slotBuffer.append(availableSlotsList[j] + ",");

						}
						slotBuffer.deleteCharAt(slotBuffer.length() - 1);
						ap.proposedSlots[1] = slotBuffer.toString();
				
				
				}
				
				else {
	
					mechQuery="select r.day, e.employeeid ,e.name, r.availableslots, r.hours from Mechanic m join employee e on m.employeeid=e.employeeid join MecRec r on r.employeeid=e.employeeid where e.name='"+mechanic+"' and r.day > '"+date+"' order by r.day" ;
					ResultSet mechRS = DataOps.getInstance().retrieve(mechQuery);
				
					for (int i = 0; i < 2; i++) {
						mechRS.next();
						String availableSlots = mechRS.getString("availableslots");
						String[] availableSlotsList = availableSlots.split(",");
						while (availableSlotsList.length < ap.hoursReqd) {
							if (!mechRS.next()) {
								ap.canSchedule = false;
								ap.errorReport = "Cannot schedule appointment with preferred mechanic. Please choose another preference or leave field blank";
								return ap;
							}
						}
						availableSlots = mechRS.getString("availableslots");
						availableSlotsList = availableSlots.split(",");
						ap.assignedMechanic = mechanic;
						ap.assignedMechanicId = mechRS.getInt("employeeid");
						String dayString = mechRS.getString("day");
						SimpleDateFormat hourFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
						Date startOfDay = hourFormat.parse(dayString + " 08:00");
						ap.proposedDates[i] = hourFormat.format(new Date(
								startOfDay.getTime() + (Integer.parseInt(availableSlotsList[0]) - 1) * 3600 * 1000));
						StringBuffer slotBuffer = new StringBuffer();
						double hoursReqd = ap.hoursReqd;
						for (int j = 0; j < hoursReqd; j++) {
							slotBuffer.append(availableSlotsList[j] + ",");

						}
						slotBuffer.deleteCharAt(slotBuffer.length() - 1);
						ap.proposedSlots[i] = slotBuffer.toString();
					}
					
					
					
				}
				ap.canSchedule=true;
				return ap;
			}
			else {
				ap.canSchedule=false;
				ap.errorReport="Cannot schedule due to inventory shortage. Please schedule appointment after: "+maxDate;
				return ap;
			}
		} catch (SQLException e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		return null;
				
	}
	
	public Map<String, Object> invoiceGenerator(int appointmentId) {
		String query = null;
		Map<String, Object> result = new HashMap<String, Object>();
		try {
		    query = "SELECT B.serviceId, C.name AS cname, A.timeIn, A.timeOut, B.licensePlate, A.typeOfService, E.name as mname, V.make, V.model"
					+ "FROM BOOKS B, CUSTOMER C , Employee E, Appointment A, Vehicle V"
					+ "WHERE A.mechId = E.employeeId AND B.appointmentId = A.apointmentId AND B.customerId = C.customerId AND V.licensePlate = B.licensePlate AND B.appointmentId =" + appointmentId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				int typeOfService = rs.getInt("typeOfService");
				int serviceId = rs.getInt("serviceId");
				float totalLabourHours = 0;
				float totalLabourCharge = 0;
				float totalPartCost = 0;
				float totalCost =0;
				ResultSet rs1 = null;
				Map<String,Object> partsUsed = new HashMap<String, Object>();
				if(typeOfService == 2) {
					int diagnosticFee = 0;
					Map<String, Object> resultTemp = new HashMap<String, Object>();
					query = "SELECT diagnosticFee FROM Repair WHERE serviceId =" + serviceId;
					rs1 = DataOps.getInstance().retrieve(query);
					while(rs1.next()) {
						diagnosticFee = rs1.getInt("diagnosticFee");
					}
					resultTemp = getTotalCost(serviceId, appointmentId);
					partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
					totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
					totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
					totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
					totalCost = totalCost+diagnosticFee;
					result.put("appointmentId", new Integer(appointmentId));
					result.put("customerName", rs.getString("cname"));
					result.put("startDate", rs.getDate("timeIn"));
					result.put("endDate", rs.getDate("timeOut"));
					result.put("licensePlate", rs.getInt("licensePlate"));
					result.put("serviceType", "Repair");
					result.put("Mechanic Name", rs.getString("mname"));
					result.put("Parts Used", partsUsed);
					result.put("Total Labour Hours", new Float(totalLabourHours));
					result.put("Total Labour Wages", new Float(totalLabourCharge));
					result.put("Total Service Cost", new Float(totalCost));
					
				} else if(typeOfService == 1){
					Map<String, Object> resultTemp = new HashMap<String, Object>();
					if(serviceId == 1) {
						resultTemp = getTotalCost(1, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = (Float)resultTemp.get("Total Labour Wages");
						totalCost = (Float)resultTemp.get("Total Service Cost");
						
					}
					
					if(serviceId == 2) {
						resultTemp = getTotalCost(1, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
						totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
						resultTemp = getTotalCost(2, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
						totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
						
					}
					if(serviceId == 3) {
						resultTemp = getTotalCost(1, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
						totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
						resultTemp = getTotalCost(2, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
						totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
						resultTemp = getTotalCost(3, appointmentId);
						partsUsed.putAll((Map<String, Object>)resultTemp.get("Parts Used"));
						totalLabourHours = totalLabourHours+ (Float)resultTemp.get("Total Labour Hours");
						totalLabourCharge = totalLabourCharge+ (Float)resultTemp.get("Total Labour Wages");
						totalCost = totalCost+ (Float)resultTemp.get("Total Service Cost");
					}
					result.put("appointmentId", new Integer(appointmentId));
					result.put("customerName", rs.getString("cname"));
					result.put("startDate", rs.getDate("timeIn"));
					result.put("endDate", rs.getDate("timeOut"));
					result.put("licensePlate", rs.getInt("licensePlate"));
					result.put("serviceType", "Maintenance");
					result.put("Mechanic Name", rs.getString("mname"));
					result.put("Parts Used", partsUsed);
					result.put("Total Labour Hours", new Float(totalLabourHours));
					result.put("Total Labour Wages", new Float(totalLabourCharge));
					result.put("Total Service Cost", new Float(totalCost));
				}
			} 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		return result;
	}
	
	public Map<String, Object> getTotalCost(int serviceId, int appointmentId) {
		String query = null;
		float totalCost =0;
		float totalLabourHours = 0;
		float totalLabourCharge = 0;
		float totalPartCost = 0;
		Map<String,Object> partsUsed = new HashMap<String, Object>();
		Map<String, Object> result = new HashMap<String, Object>();
		query = "SELECT B.basicServiceId, B.hoursRequired, B.laborChargeRate FROM Basicservice B, Contains C "
		  		+ "WHERE C.basicServiceId = B.basicServiceId AND C.serviceID = " + serviceId;
	try {
		rs1 = DataOps.getInstance().retrieve(query);
		while(rs1.next()) {
			totalLabourHours = totalLabourHours + rs1.getFloat("hoursRequired");
			totalLabourCharge = totalLabourCharge + (rs1.getInt("laborChargeRate") *  rs1.getFloat("hoursRequired"));
			int basicServiceId = rs1.getInt("basicServiceId");
			Date lastDate = null;
			query = "SELECT B.serviceId, B.appointmentId, A.timeIn FROM Books B, Appointment A where B.appointmentId = A.appointmentId AND B.licensePlate=" + rs.getInt("licensePlate") + "ORDER BY A.timeIn DESC";
			rs2 = DataOps.getInstance().retrieve(query);
			while(rs2.next()) {
				if(appointmentId != rs2.getInt("appointmentId")) {
					int sid = rs2.getInt(serviceId);
					query = "SELECT basicServiceId FROM Contains WHERE serviceId="+sid;
					rs3 = DataOps.getInstance().retrieve(query);
					while(rs3.next()) {
						if(rs3.getInt("basicServiceId")==basicServiceId) {
							lastDate = rs2.getDate("timeIn");
							break;
						}
					}
					if(lastDate!=null) {
						break;
					}
				}
			}
			query = "SELECT U.partId, U.name, U.quantity, I.unitPrice, I.warranty FROM Uses U, Inventory I WHERE U.partId = I.partId AND U.basicServiceId =" + basicServiceId + " AND U.make = " + rs.getString("make") + " AND U.model = " + rs.getInt("model") + "AND I.make=" + rs.getString("make");
			rs2 = DataOps.getInstance().retrieve(query);
			while(rs2.next()) {
				partsUsed.put(rs2.getString("name"),new Integer(rs2.getInt("quantity")*rs2.getInt("unitprice")));
				if(lastDate!=null) {
					Calendar startCalendar = new GregorianCalendar();
					startCalendar.setTime(rs.getDate("timeIn"));
					Calendar endCalendar = new GregorianCalendar();
					endCalendar.setTime(lastDate);

					int diffYear = endCalendar.get(Calendar.YEAR) - startCalendar.get(Calendar.YEAR);
					int diffMonth = diffYear * 12 + endCalendar.get(Calendar.MONTH) - startCalendar.get(Calendar.MONTH);
					int warranty = rs2.getInt("warranty");
					if(warranty!=0 && diffMonth> warranty) {
						totalCost = totalCost+rs2.getInt("quantity")*rs2.getInt("unitprice") + (rs1.getInt("laborChargeRate") *  rs1.getFloat("hoursRequired"));
					}
					if(warranty==0) {
						totalCost = totalCost+rs2.getInt("quantity")*rs2.getInt("unitprice") + (rs1.getInt("laborChargeRate") *  rs1.getFloat("hoursRequired"));
					}
				}
				if(lastDate==null) {
					totalCost = totalCost+rs2.getInt("quantity")*rs2.getInt("unitprice");
				}
			}
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		DataOps.destroyInstance();
		e.printStackTrace();
	}
	result.put("Parts Used", partsUsed);
	result.put("Total Labour Hours", new Float(totalLabourHours));
	result.put("Total Labour Wages", new Float(totalLabourCharge));
	result.put("Total Service Cost", new Float(totalCost));
	return result;
	}
	
	
	public Date orderParts(int servicecenterid, int partId, int quantity) throws SQLException {
		String minThresQuery="select MIMINUMORDERTHRESHOLD from Has where servicecenterid="+servicecenterid+" partid="+partId;
		ResultSet minThreshRS = DataOps.getInstance().retrieve(minThresQuery);
		int minThresh = minThreshRS.getInt("MIMINUMORDERTHRESHOLD");
		int orderQuant = (quantity < minThresh) ? minThresh : quantity;
		String checkOtherCenterQuery = "select servicecenterid, currentquantity, MIMINUMORDERTHRESHOLD from Has where servicecenterid != "+servicecenterid+" order by currentquantity desc";
		ResultSet checkOtherCenterRS = DataOps.getInstance().retrieve(checkOtherCenterQuery);
		while(checkOtherCenterRS.next()) {
			int serv = checkOtherCenterRS.getInt("servicecbenterid");	
			int currentQ = checkOtherCenterRS.getInt("currentquantity");
			int minimumQ = checkOtherCenterRS.getInt("MIMINUMORDERTHRESHOLD");
			SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
			Date today = new Date();
			Calendar c = Calendar.getInstance(); 
			c.setTime(today); 
			c.add(Calendar.DATE, 1);
			Date tomorrow = c.getTime();
		    String strDate = sdfDate.format(tomorrow);
			if(currentQ-orderQuant >minimumQ) {
				String order="insert into Orders (partid,status, quantity, source,destination, EXPECTEDELIVERYDATE) values ("+partId+", 'Pending', "+orderQuant+", "+serv+", "+servicecenterid+", "+strDate+")";
				DataOps.getInstance().insertInto(order);
				return tomorrow;
			}
		}
		String checkDistQuery = "select DISTRIBUTORID, deliveryWindow from Supplies where partId = "+partId+" order by deliverWindow asc";
		ResultSet checkDistRS = DataOps.getInstance().retrieve(checkDistQuery);
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		Calendar c = Calendar.getInstance(); 
		c.setTime(today); 
		c.add(Calendar.DATE, checkDistRS.getInt("deliveryWindow"));
		Date delDate = c.getTime();
	    String strDate = sdfDate.format(delDate);
		String order="insert into Orders (partid,status, quantity, source,destination, EXPECTEDELIVERYDATE) values ("+partId+", 'Pending', "+orderQuant+", "+checkDistRS.getInt("DISTRIBUTORID")+", "+servicecenterid+", "+strDate+")";
		DataOps.getInstance().insertInto(order);
		return delDate;
	}
	
	
	
}
