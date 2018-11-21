package helper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import data.DataOps;

public class Helper {
	
	public void scheduleMaintenanceHelper(int customerId, String licensePlate, String mechanic, int currentMileage) throws SQLException, ParseException{
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
			}
			if(!shortage) {
				if(mechanic.equals("")) {

				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//Print diagnostic report and basic services for this repair

		//For each basic service check if parts are available, order if they are not, and print next available dates.
	}
	
	public void scheduleRepairHelper(int customerId, String licensePlate, String mechanic, int currentMileage, int problem) throws ParseException, SQLException{
		String mileageQuery="select servicecenterid from vehicle where licenseplate='"+licensePlate+"'";
		ResultSet mileageRS = DataOps.getInstance().retrieve(mileageQuery); 
		
		int servicecenterid = mileageRS.getInt("servicecenterid");
		String updateMileageQuery="update Vehicle set lastrecordedmileage="+currentMileage+" where licenseplate='"+licensePlate+"'";
		DataOps.getInstance().insertInto(updateMileageQuery);
		//Get basic services for this repair
		String deficitQuery = "select j2.partid, j2.currentquantity,j2.requiredquantity,j3.schduledquantity from \n" + 
				"(select h.partid, h.currentquantity, j1.requiredquantity from has h join \n" + 
				"(select U.partid, U.quantity as requiredquantity from Uses U where basicserviceid in (select C.basicserviceid from Repair R join Contains C on r.serviceid = c.serviceid where c.serviceid="+(3+problem)+") \n" + 
				"and (U.make, U.model) in (select V.make, v.model from vehicle V where v.licenseplate='"+licensePlate+"')) J1 on h.partid = j1.partid where h.servicecenterid ='"+servicecenterid+"') J2 join (select partid, sum(quantity) as schduledquantity from outgoingparts where servicecenterid ="+servicecenterid+" group by partid)j3\n" + 
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
			}
			if(!shortage) {
				if(mechanic.equals("")) {
					
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Print diagnostic report and basic services for this repair
		
		//For each basic service check if parts are available, order if they are not, and print next available dates.
		
	}
	
	public void invoiceGenerator(int appointmentId) {
		
	}
	
	public Date orderParts(int servicecenterid, int partId, int quantity) throws SQLException {
		String minThresQuery="select MIMINUMORDERTHRESHOLD from Has where servicecenterid="+servicecenterid+" partid="+partId;
		ResultSet minThreshRS = DataOps.getInstance().retrieve(minThresQuery);
		int minThresh = minThreshRS.getInt("MIMINUMORDERTHRESHOLD");
		int orderQuant = (quantity < minThresh) ? minThresh : quantity;
		String checkOtherCenterQuery = "select servicecenterid, currentquantity, MIMINUMORDERTHRESHOLD from Has where servicecenterid != "+servicecenterid+" order by currentquantity desc";
		ResultSet checkOtherCenterRS = DataOps.getInstance().retrieve(checkOtherCenterQuery);
		while(checkOtherCenterRS.next()) {
			int serv = checkOtherCenterRS.getInt("servicecenterid");	
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
