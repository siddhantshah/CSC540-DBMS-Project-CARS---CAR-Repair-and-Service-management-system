package view;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;
import data.DataOps;
import helper.Helper;
import java.util.HashMap;
import java.util.Map;

public class Employee {
	
	Statement stmt = null;
    ResultSet rs = null;
    String dummy = null;
    Helper H = new Helper();
	
	private
		 int employeeId;
		 String serviceCenterId;
		 String name;
		 String email;
		
		
	public Employee(int employeeId) {
		this.employeeId = employeeId;
		try {
			String custQuery = "SELECT name FROM Employee WHERE employeeId=" + employeeId;
			ResultSet custrs = DataOps.getInstance().retrieve(custQuery);
			custrs.next();
			this.name = custrs.getString("name");
			
		    custQuery = "SELECT serviceCenterId FROM works_in WHERE employeeId=" + employeeId;
			custrs = DataOps.getInstance().retrieve(custQuery);
			custrs.next();
			this.serviceCenterId = custrs.getString("serviceCenterId");
			
			custQuery = "SELECT email FROM Employee WHERE employeeId=" + employeeId;
			custrs = DataOps.getInstance().retrieve(custQuery);
			custrs.next();
			this.email = custrs.getString("email");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}

	}	
	
	public  void receptionistLandingPage(Scanner sc) {
		System.out.println("======================Receptionist Menu======================");
		System.out.println("1. Profile");
		System.out.println("2. View Customer Profile");
		System.out.println("3. Register Car");
		System.out.println("4. Service History");
		System.out.println("5. Schedule Service");
		System.out.println("6. Reschedule Service");
		System.out.println("7. Invoices");
		System.out.println("8. Daily Task-Update Inventory");
		System.out.println("9. Daily Task-Record Deliveries");
		System.out.println("10. Logout");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistProfile(sc);
			break;
		case 2:
			receptionistViewCustomerProfile(sc);
			break;
		case 3:
			 receptionistRegisterCar(sc);
			 break;
		case 4:
			receptionistServiceHistory(sc);
			break;
		case 5:
			receptionistScheduleService(sc);
			break;
		case 6:
			receptionistReScheduleServicePage1(sc);
			break;
		case 7:
			receptionistInvoices(sc);
			break;
		case 8:
			receptionistDailyTaskUpdateInventory(sc);
			break;
		case 9:
			receptionistDailyTaskRecordDeliveries(sc);
			break;
		case 10:
			// login
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistLandingPage(sc);
		}
	}
	
	
	public  void managerLandingPage(Scanner sc) {
		System.out.println("======================Manager Menu======================");
		System.out.println("1. Profile");
		System.out.println("2. View Customer Profile");
		System.out.println("3. Add New Employees");
		System.out.println("4. Payroll");
		System.out.println("5. Inventory");
		System.out.println("6. Orders");
		System.out.println("7. Notifications");
		System.out.println("8. New Car Model");
		System.out.println("9. Car Service Details");
		System.out.println("10. Service History");
		System.out.println("11. Invoices");
		System.out.println("12. Logout");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			managerProfile(sc);
			break;
		case 2:
			managerViewCustomerProfile(sc);
			break;
		case 3:
			managerAddNewEmployees(sc);
			break;
		case 4:
			managerPayroll(sc);
			break;
		case 5:
			managerInventory(sc);
			break;
		case 6:
			managerOrders(sc);
			break;
		case 7:
			managerNotifications(sc);
			break;
		case 8:
			managerNewCarModel(sc);
			break;
		case 9:
			managerCarServiceDetails(sc);
			break;
		case 10:
			managerServiceHistory(sc);
			break;
		case 11:
			managerInvoices(sc);
			break;
		case 12:
			//login
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerLandingPage(sc);
		}
	}
	
	public  void receptionistProfile(Scanner sc) {
		System.out.println("======================Receptionist Profile======================");
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistViewProfile(sc);
			break;
		case 2:
			receptionistUpdateProfile(sc);
			break;
		case 3:
			receptionistLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistProfile(sc);
		}	 	 
		 
	 }
	
	public  void managerProfile(Scanner sc) {
		System.out.println("======================Manager Profile======================");
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			managerViewProfile(sc);
			break;
		case 2:
			managerUpdateProfile(sc);
			break;
		case 3:
			managerLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerProfile(sc);
		}	 	 
		 
	 }
	
	
	public  void receptionistViewProfile(Scanner sc) {
		System.out.println("======================View Receptionist Profile======================");
		String query = "SELECT E.employeeId, E.name, E.address, E.email, E.phoneNumber, W.serviceCenterId,"
				+ " E.startDate, R.salary FROM Employee E, Works_In W, Receptionist R "
				+ "WHERE E.employeeId = W.employeeId AND R.employeeId = E.employeeId AND E.employeeId = " + employeeId;
		
		rs = DataOps.getInstance().retrieve(query);
		try {
			while(rs.next()) {
				System.out.println("EmployeeId: "+rs.getString("employeeId"));
				System.out.println("Name: "+rs.getString("name"));
				System.out.println("Address: "+rs.getString("address"));
				System.out.println("Email Address: "+rs.getString("email"));
				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
				System.out.println("Service Center: "+rs.getString("serviceCenterId"));
				System.out.println("Role: "+"Receptionist");
				System.out.println("Start Date: "+rs.getString("startDate"));
				System.out.println("Compensation($): "+rs.getString("salary"));
				System.out.println("Compensation(freq): "+"Monthly");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistProfile(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistViewProfile(sc);
		}
		 
	 }
	
	public  void managerViewProfile(Scanner sc) {
		System.out.println("======================View Manager Profile======================");
		String query = "SELECT E.employeeId, E.name, E.address, E.email, E.phoneNumber, W.serviceCenterId,"
				+ " E.startDate, M.salary FROM Employee E, Works_In W, Manager M "
				+ "WHERE E.employeeId = W.employeeId AND M.employeeId = E.employeeId AND E.employeeId = " + employeeId;
		

		rs = DataOps.getInstance().retrieve(query);		
		
		try {
			while(rs.next()) {
				System.out.println("EmployeeId: "+rs.getString("employeeId"));
				System.out.println("Name: "+rs.getString("name"));
				System.out.println("Address: "+rs.getString("address"));
				System.out.println("Email Address: "+rs.getString("email"));
				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
				System.out.println("Service Center: "+rs.getString("serviceCenterId"));
				System.out.println("Role: "+"Manager");
				System.out.println("Start Date: "+rs.getString("startDate"));
				System.out.println("Compensation($): "+rs.getString("salary"));
				System.out.println("Compensation(freq): "+"Monthly");
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			managerProfile(sc);
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerViewProfile(sc);
		}
		 
		 
	 }
	
	public  void receptionistUpdateProfile(Scanner sc) {
		System.out.println("======================Update Receptionist Profile======================");
		System.out.println("1. Update Name");
		System.out.println("2. Update Address");
		System.out.println("3. Update Email Address");
		System.out.println("4. Update Phone Number");
		System.out.println("5. Update Password");
		System.out.println("6. Go Back");
		String query;
		String input;
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Please Enter Your Name");
			System.out.println();
			input = sc.nextLine();
			query = "UPDATE Employee SET name ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET address ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET email ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
			query = "SELECT loginId FROM employee WHERE employeeId=" + employeeId;
			rs = DataOps.getInstance().retrieve(query);
			String loginId =null;
			try {
				rs.next();
			    loginId = rs.getString("loginId");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			query = "UPDATE Users SET password ='" + input + "' Where loginId ='" + loginId+"'";
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 6:
			receptionistProfile(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistUpdateProfile(sc);
		}	 	 
		 
	 }
	
	public  void managerUpdateProfile(Scanner sc) {
		System.out.println("======================Update Manager Profile======================");
		System.out.println("1. Update Name");
		System.out.println("2. Update Address");
		System.out.println("3. Update Email Address");
		System.out.println("4. Update Phone Number");
		System.out.println("5. Update Password");
		System.out.println("6. Go Back");
		String query;
		String input;
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Please Enter Your Name");
			System.out.println();
			input = sc.nextLine();
			query = "UPDATE Employee SET name ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET address ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET email ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
			query = "SELECT loginId FROM employee WHERE employeeId=" + employeeId;
			rs = DataOps.getInstance().retrieve(query);
			String loginId =null;
			try {
				rs.next();
			    loginId = rs.getString("loginId");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			query = "UPDATE Users SET password ='" + input + "' Where loginId ='" + loginId+"'";
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 6:
			managerProfile(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerUpdateProfile(sc);
		}	
		 
	 }
	
	public  void receptionistViewCustomerProfile(Scanner sc) {
		System.out.println("======================Receptionist View Customer Profile======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		int retrievedId = 0;
		
		try {
			String query = "SELECT C.customerId, C.name, C.address, C.email, C.phoneNumber FROM  Customer C "
					+ " WHERE C.email = '" + email+"'";
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("CustomerId: "+rs.getString("customerId"));
				System.out.println("Name: "+rs.getString("name"));
				System.out.println("Address: "+rs.getString("address"));
				System.out.println("Email Address: "+rs.getString("email"));
				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
				retrievedId = rs.getInt("customerId");
				System.out.println();
			}
			query = "SELECT V.licensePlate, V.model, V.dateOfPurchase, V.lastRecordedMileage, V.make, V.typeOfLastService,"
					+ "V.dateOfLastService, V.yearManufactured FROM Vehicle V, Owns O"
					+ " WHERE O.licensePlate = V.licensePlate AND O.customerId = "+ retrievedId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("License Plate: "+rs.getString("licensePlate"));
				System.out.println("Make: "+rs.getString("make"));
				System.out.println("Model: "+rs.getString("model"));
				System.out.println("Date Of Purchase: "+rs.getString("dateOfPurchase"));
				System.out.println("Last Recorded Mileage: "+rs.getInt("lastRecordedMileage"));
				System.out.println("Types Of Last Service: "+rs.getInt("typeOfLastService"));
				System.out.println("Date Of Last Service: "+rs.getString("dateOfLastService"));
				System.out.println("Manufactured Year: "+rs.getInt("yearManufactured"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistViewCustomerProfile(sc);
		}
		 
	 }
	
	public  void managerViewCustomerProfile(Scanner sc) {
		System.out.println("======================Manager View Customer Profile======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		int retrievedId = 0;
		
		try {
			String query = "SELECT C.customerId, C.name, C.address, C.email, C.phoneNumber FROM  Customer C "
					+ " WHERE C.email = '" + email+"'";
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("CustomerId: "+rs.getString("customerId"));
				System.out.println("Name: "+rs.getString("name"));
				System.out.println("Address: "+rs.getString("address"));
				System.out.println("Email Address: "+rs.getString("email"));
				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
				retrievedId = rs.getInt("customerId");
				System.out.println();
			}
			query = "SELECT V.licensePlate, V.model, V.dateOfPurchase, V.lastRecordedMileage, V.make, V.typeOfLastService,"
					+ "V.dateOfLastService, V.yearManufactured FROM Vehicle V, Owns O"
					+ " WHERE O.licensePlate = V.licensePlate AND O.customerId = "+ retrievedId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("License Plate: "+rs.getString("licensePlate"));
				System.out.println("Make: "+rs.getString("make"));
				System.out.println("Model: "+rs.getString("model"));
				System.out.println("Date Of Purchase: "+rs.getString("dateOfPurchase"));
				System.out.println("Last Recorded Mileage: "+rs.getInt("lastRecordedMileage"));
				System.out.println("Types Of Last Service: "+rs.getInt("typeOfLastService"));
				System.out.println("Date Of Last Service: "+rs.getString("dateOfLastService"));
				System.out.println("Manufactured Year: "+rs.getInt("yearManufactured"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			managerLandingPage(sc); 
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerViewCustomerProfile(sc);
		}
		 
	 }
	
	public  void receptionistRegisterCar(Scanner sc) {
		System.out.println("======================Receptionist Register Car======================");
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		System.out.println("B. License Plate");
		String license = sc.nextLine();
		System.out.println("C. Purchase Date");
		String purchasedate = sc.nextLine();
		System.out.println("D. Make");
		String make = sc.nextLine();
		System.out.println("E. Model");
		String model = sc.nextLine();
		System.out.println("F. Year");
		int year = Integer.parseInt(sc.nextLine());
		System.out.println("G. Current Mileage");
		int mileage = Integer.parseInt(sc.nextLine());
		System.out.println("H. Last Service Date");
		String serdate = sc.nextLine();
		System.out.println("1. Register");
		System.out.println("2. Cancel");
		System.out.println("Please select your choice.");
		int retrievedId = 0;
		String query = null;
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			query = "INSERT INTO Vehicle(licensePlate, model, dateOfPurchase, lastRecordedMileage, make, yearManufactured, serviceCenterId) "
					+ "VALUES('" + license + "','" + model + "','" + purchasedate + "'," + mileage + ",'" + make + "'," + year + "," + serviceCenterId +")";
			DataOps.getInstance().insertInto(query);
			if(!serdate.equals("")) {
				query = "UPDATE Vehicle SET dateOfLastService = '" + serdate + "' WHERE licensePlate = '" + license +"'";
				DataOps.getInstance().insertInto(query);
			}
			query = "SELECT customerId FROM Customer WHERE email = '" + email +"'";
			rs = DataOps.getInstance().retrieve(query);
			try {
				rs.next();
				retrievedId = rs.getInt("customerId");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			query = "INSERT INTO OWNS VALUES('" + license + "'," + retrievedId + ")";
			DataOps.getInstance().insertInto(query);
			receptionistLandingPage(sc);
			break;
		case 2:
			receptionistLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistLandingPage(sc);
		}
		 
	 }
	
	public  void receptionistServiceHistory(Scanner sc) {
		System.out.println("======================Receptionist Service History======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		int retrievedId = 0;
		String mechname = null;
		String query = null;
		try {
			query = "SELECT customerId FROM Customer WHERE email = '" + email +"'";
			rs = DataOps.getInstance().retrieve(query);
			rs.next();
			retrievedId = rs.getInt("customerId");
			query = "SELECT B.appointmentId, B.serviceId, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.Status FROM Books B, Appointment A"
					+ " WHERE A.appointmentId = B.appointmentId AND B.customerId = " + retrievedId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				String serviceType = null;
				query = "SELECT name FROM Employee WHERE employeeId = " + rs.getInt("mechId");
				ResultSet rs1 = null;
				rs1 = DataOps.getInstance().retrieve(query);
				rs1.next();
				mechname = rs1.getString("name");
				System.out.println("Appointment Id: "+rs.getString("appointmentId"));
				System.out.println("License Plate: "+rs.getString("licensePlate"));
				System.out.println("Service Type: "+rs.getString("typeOfService"));
				System.out.println("Mechanic Name: "+mechname);
				System.out.println("Service Start Date: "+rs.getString("timeIn"));
				System.out.println("Service Status: "+rs.getString("Status"));
				System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistLandingPage(sc);
		}
		 
	 }
	
	public  void receptionistScheduleService(Scanner sc) {
		System.out.println("======================Receptionist Schedule Service======================");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		if(!validateCustomerEmail(email)) {
			System.err.println("Invalid Customer Email, Please enter correct details");
			receptionistScheduleService(sc);
		}
		System.out.println("B. License Plate");
		String license = sc.nextLine();
		if(!validateLicense(license, email)) {
			System.err.println("Invalid License Plate, Please enter correct details");
			receptionistScheduleService(sc);
		}
		System.out.println("C. Current Mileage");
		int mileage = Integer.parseInt(sc.nextLine());
		System.out.println("D. Mechanic Preference");
		String mechanic = sc.nextLine();
		if(!validateMechanic(mechanic)) {
			System.err.println("Invalid Mechanic, Please enter correct details");
			receptionistScheduleService(sc);
		}
		int customerId =0;
		String query = "Select customerId from customer where email = '" + email +"'";
		rs = DataOps.getInstance().retrieve(query);
		try {
			rs.next();
			customerId = rs.getInt("customerId");
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("1. Schedule Maintainence");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			receptionistScheduleMaintainencePage1(sc, customerId, license, mileage, mechanic);
			break;
		
		case 2:
			receptionistScheduleRepairPage1(sc, customerId, license, mileage, mechanic);
			
		case 3:
			receptionistLandingPage(sc);
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistLandingPage(sc);
		}
		 
	 }
	
	public  void receptionistScheduleMaintainencePage1(Scanner sc, int customerId , String license, int mileage, String mechanic) {
		System.out.println("======================Schedule Maintainence Page 1======================");
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			Appointment appointment = new Appointment();
			try {
				appointment = H.scheduleMaintenanceHelper(customerId, license, mechanic, mileage);
				if(!appointment.canSchedule) {
					System.out.println(appointment.errorReport);
					receptionistScheduleService(sc);
				} else{
					receptionistScheduleMaintainencePage2(sc, customerId, license, mileage, mechanic, appointment);
				}
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			receptionistScheduleService(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistScheduleMaintainencePage1(sc, customerId, license, mileage, mechanic);
		}
		 
	 }
	
	public  void receptionistScheduleMaintainencePage2(Scanner sc, int customerId , String license, int mileage, String mechanic, Appointment appointment) {
		System.out.println("======================Schedule Maintainence Page 2======================");
		System.out.println("Select Date Of Appointment");
		System.out.println("1. " + appointment.proposedDates[0]);
		System.out.println("2. " + appointment.proposedDates[1]);
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			appointment.assignedDate = appointment.proposedDates[0];
			break;
		case 2:
			appointment.assignedDate = appointment.proposedDates[1];
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistScheduleMaintainencePage2(sc, customerId, license, mileage, mechanic, appointment);
		}
		System.out.println("1. Schedule on Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			if(!H.scheduleAppointment(appointment)) {
				System.out.println("Cannot BookThe Requested Appointment Successfully");
			}
			receptionistScheduleService(sc);
			break;
		case 2:
			receptionistScheduleMaintainencePage1(sc, customerId, license, mileage, mechanic);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			receptionistScheduleMaintainencePage2(sc, customerId, license, mileage, mechanic, appointment);
		}
		 
	 }
	
	public  void receptionistScheduleRepairPage1(Scanner sc,  int CustomerId , String license, int mileage, String mechanic) {
		System.out.println("======================Schedule Repair Page 1======================");
		System.out.println("1. Engine Knock");
		System.out.println("2. Car Drifts in a Particular Direction");
		System.out.println("3. Battery Does Not Hold Charge");
		System.out.println("4. Black/Unclean Exhaust");
		System.out.println("5. A/C-Heater Not Working");
		System.out.println("6. Headlamps/Tailklamps Not Working");
		System.out.println("7. Check Engine Light");
		System.out.println("8. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
			
		case 3:
			// exit;
		
		case 4:
			// exit;
			
		case 5:
			// exit;
		
		case 6:
			// exit;
			
		case 7:
			// exit;
		
		case 8:
			// exit;
		}
		 
	 }
	
	public  void receptionistScheduleRepairPage2(Scanner sc) {
		System.out.println("======================Schedule Repair Page 2======================");
		//display
		System.out.println("1. Repair On Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
		}
		 
	 }
	
	
	public  void receptionistReScheduleServicePage1(Scanner sc) {
		System.out.println("======================Reschedule Service Page 1======================");
		System.out.println("Customer Email Address");
		String email = sc.nextLine();
		int retrievedId = 0;
		
		try {
			String query = "SELECT C.customerId FROM CUSTOMER C WHERE C.email = " + email;
			while(rs.next()) {
				retrievedId = rs.getInt("customerId");
			}
			
			query = "SELECT B.appointmentId, A.timeIn, A.timeOut FROM Books B, Appointment A WHERE B.appointmentId = A.appointmentId AND B.customerId = " + retrievedId;
					
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1. Pick A Service");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
		}
		 
	 }
	
	public  void receptionistReScheduleServicePage2(Scanner sc) {
		System.out.println("======================Reschedule Service Page 2======================");
		//display
		System.out.println("1. Reschdule Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
		}
		 
	 }
	
	public  void receptionistInvoices(Scanner sc) {
		System.out.println("======================invoices======================");
		System.out.println("Customer Email Address");
		String email = sc.nextLine();
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		}
		 
	 }
	
	public void receptionistLeftUpdateTask(Scanner sc){
	 	// update payroll here
	 	// update appintment status here

		try {
			H.updatePayroll();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String query = "Select B.appointmentid from vehicle V, Books B where V.licenseplate = B.licensePlate and V.serviceCenterId = " + serviceCenterId;

		rs = DataOps.getInstance().retrieve(query);
		
		try {
			while(rs.next()) {
				query = "update appointment set status = completed where appointmentid = " + rs.getInt("appointmentid");
				DataOps.getInstance().insertInto(query);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}

	}
	
	public  void receptionistDailyTaskUpdateInventory(Scanner sc) {
		System.out.println("======================Daily Task Update Inventory======================");
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date currDate = new Date();
		currDate.setDate(currDate.getDate()-1);
		String currentDate = dateformat.format(currDate);

		String query = "Select O.quantity, O.partid, H.currentquantity, H.minimumquantitythreshold, OR.quantity as incomingqty From outgoingparts O, Has H where O.scheduledate = " + currentDate + " and O.serviceCenterId = " + serviceCenterId + " and O.partId = H.partId and O.serviceCenterId = H.serviceCenterId and OR.partId = H.partId and OR.destination = " + serviceCenterId;
			
		rs = DataOps.getInstance().retrieve(query);
		
		try {
			while(rs.next()) {

				int newqty = rs.getInt("currentquantity") - rs.getInt("quantity") + rs.getInt("incomingqty");

				if(newqty < rs.getInt("minimumquantitythreshold")){
					String query2 = "update Has set currentquantity = "+newqty+" where partId = "+rs.getInt("partid")+" and serviceCenterId = " + serviceCenterId;
					DataOps.getInstance().insertInto(query2);
					H.orderParts(Integer.parseInt(serviceCenterId), rs.getInt("partId"), rs.getInt("quantity"));
				}

				else {
					String query2 = "update Has set currentquantity = "+newqty+" where partId = "+rs.getInt("partid")+" and serviceCenterId = " + serviceCenterId;
					DataOps.getInstance().insertInto(query2);
				}
				
				System.out.println("Task Successful");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Task Did Not Complete");
			DataOps.destroyInstance();
			e.printStackTrace();
		}

		receptionistLeftUpdateTask(sc);	// additional update task receptionist need to run everyday

		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			receptionistLandingPage(sc);
		}
		 
	 }
	
	public  void receptionistDailyTaskRecordDeliveries(Scanner sc) {
		System.out.println("======================Daily Task Record Deliveries======================");
		
		DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date currDate = new Date();
		currDate.setDate(currDate.getDate()-1);
		String currentDate = dateformat.format(currDate);
		
		System.out.println("1. Enter Order ID (CSV)");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter the comma seperated list of orders");
			String csv = sc.nextLine();
			List csvList = getList(csv);

			for(int i = 0 ; i < csvList.size() ; i++){

				try {
					String query = "Update orders set status = Completed, actualdeliverydate = " + currentDate +" where orderId = " + csvList.get(i) + " and destination = " + serviceCenterId;
					DataOps.getInstance().insertInto(query);
					query = "Delete from notification where orderId = " + csvList.get(i);
					DataOps.getInstance().insertInto(query);
					System.out.println("Task Completed");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					System.out.println("Task Did Not Complete");
					DataOps.destroyInstance();
					e.printStackTrace();
				}
			}

			receptionistDailyTaskRecordDeliveries(sc);

		case 2:

			String query = "Select expectedDeliveryDate, source, orderId from orders where status = pending and destination = " + serviceCenterId;
			
			rs = DataOps.getInstance().retrieve(query);
		
			try {
				while(rs.next()) {
					String expectedDate = rs.getString("expecteddeliverydate");
					Date expectedDeliveryDate = getDate(expectedDate);

					if((getDate(currentDate).compareTo(expectedDeliveryDate)) < 0){
						String query2 = "insert into notification values(" + currentDate + "," + rs.getInt("orderId") + "," + rs.getString("expectedDeliveryDate") + "," + rs.getInt("source") + ")";
						DataOps.getInstance().insertInto(query2);
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}

			receptionistLandingPage(sc);
		}	 
	 }
	
	 public  void managerAddNewEmployees(Scanner sc) {
		System.out.println("======================Manager Add Employess Menu======================");
		System.out.println("A. Name");
		String name = sc.nextLine();
		System.out.println("B. Address");
		String address = sc.nextLine();
		System.out.println("C. Email Address");
		String email = sc.nextLine();
		System.out.println("D. Phone Number");
		String phone = sc.nextLine();
		System.out.println("E. Role");
		String role = sc.nextLine();
		System.out.println("F. Start Date");
		String startdate = sc.nextLine();
		System.out.println("G. Compensation($)");
		String compensation = sc.nextLine();
		String query = "select max(employeeId) AS max from employee";
		int newEmployeeId = 0;

		rs = DataOps.getInstance().retrieve(query);
		try {
			rs.next();
			newEmployeeId = rs.getInt("max") + 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1. Add");
		System.out.println("2. Go Back");
		int choice = sc.nextInt();
		dummy = sc.nextLine();
		int possible = 0;
		switch(choice) {
		case 1:
			if(role.equals("Receptionist")) {
				query = "select count(W.employeeId) AS count from works_in W, employee E, Users U where W.employeeId = E.employeeId AND U.loginId = E.loginId AND W.serviceCenterId = " + serviceCenterId + " AND U.role='Receptionist'";
				rs = DataOps.getInstance().retrieve(query);
				try {
					rs.next();
					if(rs.getInt("count") == 1) {
						System.err.println("A Receptionist is already present");
						managerLandingPage(sc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				query = "INSERT INTO Users VALUES('"+email+ "','12345678','Receptionist')";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(" + newEmployeeId + ",'" + name + "','" + phone + "','" + address + "','" + email + "','" + startdate + "','" + email + "')";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(" + serviceCenterId + "," + newEmployeeId + ")";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Receptionist(employeeId,salary) VALUES(" + newEmployeeId + "," + compensation + ")";
				DataOps.getInstance().insertInto(query);
			}
			
			else if (role.equals("Mechanic")){
				query = "select count(W.employeeId) AS count from works_in W, employee E, Users U where W.employeeId = E.employeeId AND U.loginId = E.loginId AND W.serviceCenterId = " + serviceCenterId + " AND U.role='Mechanic'";
				rs = DataOps.getInstance().retrieve(query);
				try {
					rs.next();
					if(rs.getInt("count") == 5) {
						System.err.println("5 Mechanics are already present");
						managerLandingPage(sc);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				query = "INSERT INTO Users VALUES('"+email+ "','12345678','Mechanic')";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Employee(employeeId,name,phoneNumber,address,email,startDate,loginId) VALUES(" + newEmployeeId + ",'" + name + "','" + phone + "','" + address + "','" + email + "','" + startdate + "','" + email + "')";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Works_In(serviceCenterId,employeeId) VALUES(" + serviceCenterId + "," + newEmployeeId + ")";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Mechanic(employeeId,hourlyWages) VALUES(" + newEmployeeId + "," + compensation + ")";
				DataOps.getInstance().insertInto(query);
			}
			else {
				System.err.println("Bad Option");
			}
			managerLandingPage(sc);
			
		case 2:
			managerLandingPage(sc);
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			managerLandingPage(sc);
		}	 
	 }
	 
	 public  void managerPayroll(Scanner sc) {
			System.out.println("======================Payroll======================");
			System.out.println("Employee ID");
			String employeeid = sc.next();
			
			String payrollQuery = "select PAYDATE, NAME, HOURLYWAGES, HOURSWORKED, AMOUNTPAID from PAYROLL join EMPLOYEE on PAYROLL.EMPLOYEEID = EMPLOYEE.EMPLOYEEID join MECHANIC on PAYROLL.EMPLOYEEID = MECHANIC.EMPLOYEEID where PAYROLL.EMPLOYEEID = '"+employeeid+"'";
			rs = DataOps.getInstance().retrieve(payrollQuery);
			
			
			try {
				while (rs.next()) {
					System.out.println(rs.getString("NAME"));
					System.out.println("A. Paycheck date - " + rs.getString("PAYDATE"));
					System.out.println("B. Pay period - " + get_prev_date(rs.getString("PAYDATE")) + " to " + rs.getString("PAYDATE"));
					System.out.println("C. Employee ID - " + employeeid);
					System.out.println("D. Employee Name - " + rs.getString("NAME"));
					System.out.println("E. Compensation ($) - " + rs.getInt("HOURLYWAGES"));
					System.out.println("F. Compensation Frequency - hourly");
					System.out.println("G. Units - " + rs.getDouble("HOURSWORKED"));
					System.out.println("H. Earnings - " + rs.getDouble("AMOUNTPAID"));
					
					String start_date = rs.getString("PAYDATE").substring(0, 4) + "-01-01";
					String totalPayQuery = "select SUM(AMOUNTPAID) as total_earnings from PAYROLL where EMPLOYEEID='"+employeeid+"' and PAYDATE between '"+start_date+"' and '"+rs.getString("PAYDATE") + "'";
					ResultSet tmp_rs = DataOps.getInstance().retrieve(totalPayQuery);
					double earnings = 0;
					if (tmp_rs.next()) {
						earnings = tmp_rs.getDouble("total_earnings");
					}
					System.out.println("I. Earnings (Year-to-date) - " + earnings);
				}
			} catch (Exception e) {}
			
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				managerLandingPage(sc);
				break;
			}	 
		 }
	 
	 public String get_prev_date(String salary_date) {
		 String[] date_arr = salary_date.split("-");
			String year = date_arr[0];
			String month = date_arr[1];
			String day = date_arr[2];
			
			if (day.equals("01")) {
				day = "15";
				if (month.equals("01")) {
					year = Integer.toString(Integer.parseInt(year) - 1);
					month = "12";
				} else {
					int mn = Integer.parseInt(month) - 1;
					if (mn < 10) {
						month = "0" + Integer.toString(mn);
					} else {
						month = Integer.toString(mn);
					}
				}
			} else if (day.equals("15")) {
				day = "01";
			} else {
				return "";
			}
			
			String prev_date = year + "-" + month + "-" + day;
			return prev_date;
	 }
	 
	 public  void managerInventory(Scanner sc) {
	 		// Here we do not need to display make and model so we might see similar data because each part may have the same id for different make and model
			System.out.println("====================== Manager Inventory======================");
			String query = "Select I.partId, I.name, H.currentquantity, I.make, I.unitprice, H.minimumquantitythreshold, H.minimumorderthreshold" +
			" From Inventory I, Has H Where I.partId = H.partId And H.serviceCenterId = " + serviceCenterId;
			rs = DataOps.getInstance().retrieve(query);		
			
			try {
				while(rs.next()) {
					System.out.println("PartId: "+rs.getInt("partId"));
					System.out.println("Name: "+rs.getString("name"));
					System.out.println("Make: "+rs.getString("make"));
					System.out.println("Quantity: "+rs.getInt("currentquantity"));
					System.out.println("Unit Price: "+rs.getInt("unitprice"));
					System.out.println("Minium Quantity Threshold: "+rs.getInt("minimumquantitythreshold"));
					System.out.println("Minum Order Threshold: "+ rs.getInt("minimumorderthreshold"));
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}

			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				managerLandingPage(sc);
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerLandingPage(sc);
			}	 
		 }
	 
	 public  void managerOrders(Scanner sc) {
			System.out.println("======================Manager Orders======================");
			System.out.println("1. Order History");
			System.out.println("2. New Order");
			System.out.println("3. Go Back");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				managerOrderHistory(sc);
				break;
			case 2:
				managerNewOrder(sc);
				break;
			case 3:
				managerLandingPage(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerOrders(sc);
			}	 
		 }
	 
	 public  void managerOrderHistory(Scanner sc) {
			System.out.println("======================ManagerOrder History======================");
			
			String query = "select O.orderId, O.actualdeliverydate, I.name, O.source, S.name as centername,O.quantity, I.unitprice, O.status from Orders O, Inventory I, Servicecenter S where I.partid  = O.partid and O.destination = " + serviceCenterId + " and S.servicecenterid = " + serviceCenterId;	


			rs = DataOps.getInstance().retrieve(query);		
			
			try {
				while(rs.next()) {
					System.out.println("OrderId: "+rs.getInt("orderId"));
					System.out.println("Delivery Date If Done: "+rs.getString("actualdeliverydate"));
					System.out.println("Part Name: "+rs.getString("name"));
					int sourceId = rs.getInt("source");
					
					if(sourceId >= 1000) {
						System.out.println("Distributor: " + sourceId);	
					}

					else {
						String query2 = "select name from servicecenter where servicecenterid = " + sourceId;
						ResultSet rs1 = DataOps.getInstance().retrieve(query2);
						rs1.next();
						System.out.println("Source Service Center: "+rs1.getString("name"));
					}
					
					System.out.println("Destination Service Center: "+rs.getString("centername"));
					int qty = rs.getInt("quantity");
					System.out.println("Quantity: "+rs.getInt("quantity"));
					int unitPrice = rs.getInt("unitprice");
					System.out.println("Unit Price: "+rs.getInt("unitprice"));
					System.out.println("Total Price: "+(qty*unitPrice));
					System.out.println("Order Status: "+rs.getString("status"));
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				managerOrders(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerOrders(sc);
			
			}	 
		 }
	 
	 public  void managerNewOrder(Scanner sc) {
			System.out.println("======================New Order======================");
			System.out.println("A. Part ID");
			int partid = Integer.parseInt(sc.nextLine());
			System.out.println("B. Quantity");
			int qty = Integer.parseInt(sc.nextLine());
			System.out.println("1. Place Order");
			System.out.println("2. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				 try {
					H.orderParts(Integer.parseInt(serviceCenterId), partid, qty);
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 break;
			case 2:
				 managerOrders(sc);
				 break;
			}	 
		 }
	 
	 public  void managerNotifications(Scanner sc) {
			System.out.println("======================Manager Notifications======================");
			
			String query = "select N.notificationId, N.notificationDate, N.orderId, N.supplierId, N.expecteddeliverydate from Notification N, Orders O where N.orderId  = O.orderId and O.destination = " + serviceCenterId;	

			rs = DataOps.getInstance().retrieve(query);
			
			try {
				while(rs.next()) {
					System.out.println("NotificationId: "+rs.getInt("notificationId"));
					System.out.println("Notification Date: "+rs.getString("notificationDate"));
					System.out.println("OrderId: "+rs.getInt("orderId"));
					int sourceId = rs.getInt("supplierId");
					
					if(sourceId >= 1000) {
						System.out.println("Supplier Id (Distributor): " + sourceId);	
					}

					else {
						String query2 = "select name from servicecenter where servicecenterid = " + sourceId;
						ResultSet rs1 = DataOps.getInstance().retrieve(query2);
						rs1.next();
						System.out.println("Supplier Service Center: "+rs1.getString("name"));
					}
					
					String expectedDate = rs.getString("expecteddeliverydate");
					System.out.println("Expected Delivery Date: "+rs.getString("expecteddeliverydate"));
					
					Date expectedDeliveryDate=null;
					try {
						expectedDeliveryDate = new SimpleDateFormat("yyyy-MM-dd").parse(expectedDate);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					DateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
					Date currDate = new Date();
					dateformat.format(currDate);

					if(currDate.compareTo(expectedDeliveryDate) < 0) {
						System.out.println("Not Delayed Yet");
					}

					else {
						int days = currDate.getDate() - expectedDeliveryDate.getDate();
						System.out.println("Delayed By: "+days+" days");	
					}

					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}

			System.out.println("1. Order ID");
			System.out.println("2. Go Back");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Select The Order Id From Above");
				int orderId = Integer.parseInt(sc.nextLine());
				managerNotificationsDetail(sc, orderId);
			case 2:
				managerLandingPage(sc);
				break;
			}
		 }
	 
	 public  void managerNotificationsDetail(Scanner sc, int orderId) {
			System.out.println("======================Notifications Detail======================");
			
			String query = "select O.orderId, O.actualdeliverydate, I.name, O.source, S.name as centername,O.quantity, I.unitprice, O.status from Orders O, Inventory I, Servicecenter S where I.partid  = O.partid and O.destination = " + serviceCenterId + " and O.orderId = " + orderId + " and S.servicecenterid = " + serviceCenterId;	


			rs = DataOps.getInstance().retrieve(query);		
			
			try {
				while(rs.next()) {
					System.out.println("OrderId: "+rs.getInt("orderId"));
					System.out.println("Delivery Date If Done: "+rs.getString("actualdeliverydate"));
					System.out.println("Part Name: "+rs.getString("name"));
					int sourceId = rs.getInt("source");
					
					if(sourceId >= 1000) {
						System.out.println("Distributor: " + sourceId);	
					}

					else {
						String query2 = "select name from servicecenter where servicecenterid = " + sourceId;
						ResultSet rs1 = DataOps.getInstance().retrieve(query2);
						rs1.next();
						System.out.println("Source Service Center: "+rs1.getString("name"));
					}
					
					System.out.println("Destination Service Center: "+rs.getString("centername"));
					int qty = rs.getInt("quantity");
					System.out.println("Quantity: "+rs.getInt("quantity"));
					int unitPrice = rs.getInt("unitprice");
					System.out.println("Unit Price: "+rs.getInt("unitprice"));
					System.out.println("Total Price"+(qty*unitPrice));
					System.out.println("Order Status: "+rs.getString("status"));
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}

			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				managerNotifications(sc);
			}
		 }
	 
	 public  void managerNewCarModel(Scanner sc) {
		 System.out.println("======================New Car Model======================");
		 System.out.println("A. Make");
		 String make = sc.nextLine();
		 System.out.println("B. Model");
		 String model = sc.nextLine();
		 System.out.println("C. Year");
		 String year = sc.nextLine();
			
			if(!(make.equals("Honda") || make.equals("Toyota") || make.equals("Nissan"))) {
				System.out.println("Only Honda, Toyota or Nissan are allowed");
				managerLandingPage(sc);
			}
			
			class servicea {
				String miles;
				String months;
				String basicServiceList;
			}
			
			class serviceb {
				String miles;
				String months;
				String basicServiceList;
			}
			
			class servicec {
				String miles;
				String months;
				String basicServiceList;
			}
			
			servicea sa = new servicea();
			serviceb sb = new serviceb();
			servicec scc = new servicec();
			
			System.out.println("D. -----Service A----");
			System.out.println("a. Miles");
			sa.miles = sc.nextLine();  
			System.out.println("b. Months");
			sa.months = sc.nextLine();  
			System.out.println("c. Basic Service List");
			sa.basicServiceList = sc.nextLine();
			
			System.out.println("E. -----Service B----");
			System.out.println("a. Miles");
			sb.miles = sc.nextLine();  
			System.out.println("b. Months");
			sb.months = sc.nextLine();  
			System.out.println("c. Basic Service List");
			sb.basicServiceList = sc.nextLine();
			sb.basicServiceList = sb.basicServiceList + ',' + sa.basicServiceList;
			
			System.out.println("F. -----Service C----");
			System.out.println("a. Miles");
			scc.miles = sc.nextLine();  
			System.out.println("b. Months");
			scc.months = sc.nextLine();  
			System.out.println("c. Basic Service List");
			scc.basicServiceList = sc.nextLine();
			scc.basicServiceList = scc.basicServiceList + ',' + sb.basicServiceList;
			
			System.out.println("1. Add Car");
			System.out.println("2. Go Back");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
			
				String query = "Insert into servicemiles values( '" + make + "','" + model + "'," + sa.miles + "," + 1 + ")";
				DataOps.getInstance().insertInto(query);
				List list = getList(sa.basicServiceList);
				for(int i = 0 ; i < list.size() ; i++){
					query = "Insert into contains values( " + list.get(i) + "," + 1 + ",'" + make + "','" + model + "')";
					DataOps.getInstance().insertInto(query);
				}
			
				query = "Insert into servicemiles values( '" + make + "','" + model + "'," + sb.miles + "," + 2 + ")";
				DataOps.getInstance().insertInto(query);
				list = getList(sb.basicServiceList);
				for(int i = 0 ; i < list.size() ; i++){
					query = "Insert into contains values( " + list.get(i) + "," + 2 + ",'" + make + "','" + model + "')";
					DataOps.getInstance().insertInto(query);
				}
			
				query = "Insert into servicemiles values( '" + make + "','" + model + "'," + sb.miles + "," + 3 + ")";
				DataOps.getInstance().insertInto(query);
				list = getList(scc.basicServiceList);
				for(int i = 0 ; i < list.size() ; i++){
					query = "Insert into contains values( " + list.get(i) + "," + 3 + ",'" + make + "','" + model + "')";
					DataOps.getInstance().insertInto(query);
				}
			
				managerLandingPage(sc);
				break;
			case 2:
				managerLandingPage(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerLandingPage(sc);
			}
		 }
	 
	 public void managerCarServiceDetails(Scanner sc) {
		 System.out.println("======================Manager Car Service Details======================");
		 ResultSet rs2 = null;
		 String query = "Select make, model, yearManufactured From vehicle Where serviCecenterId = " + serviceCenterId;
		 rs = DataOps.getInstance().retrieve(query);		
		 try {
			 while(rs.next()) {
				 int serviceamiles = 0;
				 int servicebmiles = 0;
				 int servicecmiles = 0;
				 String basicservicelista = "";
				 String basicservicelistb = "";
				 String basicservicelistc = "";
				 
				 System.out.println("Make: "+rs.getString("make"));
				 System.out.println("Model: "+rs.getString("model"));
				 System.out.println("Year Manufactured In: "+rs.getString("yearManufactured"));
				 query = "Select miles, serviceId from servicemiles where make ='" + rs.getString("make") + "' AND model = '" + rs.getString("model") + "'";
				 rs2 = DataOps.getInstance().retrieve(query);
				 while(rs2.next()) {
					 if(rs2.getInt("serviceId") == 1) {
						 serviceamiles = rs2.getInt("miles");
					 }
					 if(rs2.getInt("serviceId") == 2) {
						 servicebmiles = rs2.getInt("miles");
					 }
					 if(rs2.getInt("serviceId") == 3) {
						 servicecmiles = rs2.getInt("miles");
					 }
				 }
				 query = "Select basicServiceId, serviceId from contains where make ='" + rs.getString("make") + "' AND model = '" + rs.getString("model") + "'";
				 rs2 = DataOps.getInstance().retrieve(query);
				 while(rs2.next()) {
					 if(rs2.getInt("serviceId") == 1) {
						 basicservicelista = basicservicelista + ", " + rs2.getInt("basicServiceId");
					 }
					 if(rs2.getInt("serviceId") == 2) {
						 basicservicelistb = basicservicelistb + ", " + rs2.getInt("basicServiceId");
					 }
					 if(rs2.getInt("serviceId") == 3) {
						 basicservicelistc = basicservicelistc + ", " + rs2.getInt("basicServiceId");
					 }
				 }
				System.out.println("For Service A (make/model)");
				System.out.println("Miles: " + serviceamiles);
				System.out.println("Basic Service List: " + basicservicelista);
				System.out.println("For Service B (make/model)");
				System.out.println("Miles: " + servicebmiles);
				System.out.println("Basic Service List: " + basicservicelistb);
				System.out.println("For Service C (make/model)");
				System.out.println("Miles: " + servicecmiles);
				System.out.println("Basic Service List: " + basicservicelistc);
				System.out.println();
				}
			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				managerLandingPage(sc);
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerLandingPage(sc);
			}
		 }
	 
	 public  void managerServiceHistory(Scanner sc) {
			System.out.println("======================Manager Service History======================");
			String mechname = null;
			String query = null;
			try {
				query = "SELECT B.appointmentId, C.name, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.Status FROM Books B, Appointment A, Customer C, Vehicle V"
						+ " WHERE A.appointmentId = B.appointmentId AND B.customerId = C.customerId AND V.licensePlate = B.LicensePlate AND V.serviceCenterId = " + serviceCenterId;
				rs = DataOps.getInstance().retrieve(query);
				while(rs.next()) {
					String serviceType = null;
					query = "SELECT name FROM Employee WHERE employeeId = " + rs.getInt("mechId");
					ResultSet rs1 = null;
					rs1 = DataOps.getInstance().retrieve(query);
					rs1.next();
					mechname = rs1.getString("name");
					System.out.println("Appointment Id: "+rs.getString("appointmentId"));
					System.out.println("Customer Name: "+rs.getString("name"));
					System.out.println("License Plate: "+rs.getString("licensePlate"));
					System.out.println("Service Type: "+rs.getString("typeOfService"));
					System.out.println("Mechanic Name: "+mechname);
					System.out.println("Service Start Date: "+rs.getString("timeIn"));
					System.out.println("Service Status: "+rs.getString("Status"));
					System.out.println();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				receptionistLandingPage(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				managerLandingPage(sc);
			}
		 }
	 
	 public  void managerInvoices(Scanner sc) {
			System.out.println("======================Manager Invoices======================");
			try {
				String query = null;
			    query = "SELECT B.appointmentId from Books B, Vehicle V Where B.licensePlate = V.licensePlate AND V.serviceCenterId= " + serviceCenterId;
			    rs = DataOps.getInstance().retrieve(query);
				while(rs.next()) {
					int appointmentId = rs.getInt("appointmentId");
					Map<String, Object> result = new HashMap<String, Object>();
					Helper helper = new Helper();
					result = helper.invoiceGenerator(appointmentId);
					String parts="";
					String costs="";
					for (Map.Entry<String, Object> entry : ((Map<String, Object>)result.get("Parts Used")).entrySet()) {
					    parts = parts + ", "+entry.getKey();
					    costs = costs + ", "+entry.getValue();
					}
					System.out.println("AppointmentId: "+(Integer)result.get("appointmentId"));
					System.out.println("Customer Name: "+(String)result.get("customerName"));
					System.out.println("Start Date: "+(Date)result.get("startDate"));
					System.out.println("License Plate: "+(String)result.get("licensePlate"));
					System.out.println("Service Type: "+(String)result.get("serviceType"));
					System.out.println("Mechanic Name: "+(String)result.get("Mechanic Name"));
					System.out.println("Parts Used: "+ parts);
					System.out.println("Total cost for parts: "+ costs);
					System.out.println("Total Labour Hours: "+(Float)result.get("Total Labour Hours"));
					System.out.println("Total Labour Wages: "+(Float)result.get("Total Labour Wages"));
					System.out.println("Total Service Cost: "+(Float)result.get("Total Service Cost"));
					System.out.println();
				} 
				
				// print here
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			dummy = sc.nextLine();
			switch(choice) {
			case 1:
				// go back
			}
		 }
	 
	 public boolean validateCustomerEmail(String email) {
		 try {
			 String query = "SELECT count(customerId) as count FROM Customer WHERE email = '" + email +"'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") != 1) {
				 rs.close();
				 return(false);
			 }
			 query = "SELECT U.Role FROM Users U, Customer C WHERE U.loginId = C.loginId AND C.email = '" + email + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(!rs.getString("role").equals("Customer")) {
				 rs.close();
				 return(false);
			 }
			 rs.close();
		 }catch (SQLException e) {
			 // TODO Auto-generated catch block
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public boolean validateLicense(String license, String email) {
		 try {
			 String query = "SELECT count(licensePlate) as count FROM Vehicle WHERE licensePlate = '" + license +"'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") != 1) {
				 rs.close();
				 return(false);
			 }
			 query = "SELECT count(O.licensePlate) as count FROM Owns O, Customer C WHERE C.customerId = O.customerId AND C.email = '" + email + "' AND O.licensePlate = '" + license + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") != 1) {
				 rs.close();
				 return(false);
			 }
			 query = "SELECT count(licensePlate) as count FROM Vehicle WHERE serviceCenterId = " + serviceCenterId + " AND licensePlate = '" + license + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") != 1) {
				 rs.close();
				 return(false);
			 }
			 rs.close();
		 }catch (SQLException e) {
			 // TODO Auto-generated catch block
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public boolean validateMechanic(String mechanic) {
		 try {
			 if(!mechanic.equals("")) {
					String query = "SELECT count(W.employeeId) as count FROM Employee E, works_in W WHERE W.employeeId = E.employeeId AND E.name = '" + mechanic + "' AND W.serviceCenterId = " + serviceCenterId;
					rs = DataOps.getInstance().retrieve(query);
					rs.next();
					if(rs.getInt("count") != 1) {
						 rs.close();
						 return(false);
					}
					query = "SELECT U.Role FROM Users U, Employee E WHERE U.loginId = E.loginId AND E.name = '" + mechanic + "'";
					 rs = DataOps.getInstance().retrieve(query);
					 rs.next();
					 if(!rs.getString("role").equals("Mechanic")) {
						 rs.close();
						 return(false);
					 }
				}
			 rs.close();
		 }catch (SQLException e) {
			 // TODO Auto-generated catch block
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public  Date getDate(String date) {
		 DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		 Date d = new Date();
	     try { 
		     d = df.parse(date);
	      } catch(ParseException e) {
	    	  DataOps.destroyInstance();
	         System.err.println("Unable to parse " + date);
	      }
		 return d;
	 }
	 
	 public  List getList(String s) {
		 List<String> list = new ArrayList<String>(Arrays.asList(s.split(",")));
		 return list;
	 }
	 
	 public  Date getDateTime(String s) {
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		 Date d = new Date();
	     try { 
		     d = df.parse(s);
	      } catch(ParseException e) {
	    	  DataOps.destroyInstance();
	         System.err.println("Unable to parse " + s);
	      }
		 return d;
	 }
}
