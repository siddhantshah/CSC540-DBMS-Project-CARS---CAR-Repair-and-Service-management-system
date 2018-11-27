package view;

import java.util.Scanner;
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
		switch(choice) {
		case 1:
			System.out.println("Please Enter Your Name");
			System.out.println();
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET name ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET address ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET email ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			receptionistUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
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
		switch(choice) {
		case 1:
			System.out.println("Please Enter Your Name");
			System.out.println();
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET name ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET address ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET email ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber ='" + input + "' Where employeeId =" + employeeId;
			DataOps.getInstance().insertInto(query);
			managerUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
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
		email = sc.nextLine();
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
		email = sc.nextLine();
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
		email = sc.nextLine();
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
		email = sc.nextLine();
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
		System.out.println("======================Schedule Service======================");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		System.out.println("B. License Plate");
		String license = sc.nextLine();
		System.out.println("C. Current Mileage");
		int mileage = Integer.parseInt(sc.nextLine());
		System.out.println("D. Input any Mechanice Preference Id (If no preference press enter)");
		String query = "SELECT name, employeeId FROM Employee WHERE serviceCenterId = " + serviceCenterId;
		try {
			
			Object[][] table = new String[1][];
			table[0] = new String[] { "Mechanic Id", "Name"};

			for (Object[] row : table) {
			    System.out.format("%15s%15s\n", row);
			}
			
			
			while(rs.next()) {
				table[0] = new String[] { rs.getString("employeeId"), rs.getString("name")};

				for (Object[] row : table) {
				    System.out.format("%15s%15s\n", row);
				}		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}

		int prefMechId = Integer.parseInt(sc.nextLine());
		System.out.println("1. Schedule Maintainence");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			receptionistScheduleMaintainencePage1(sc, email, license, mileage, prefMechId);
			break;
		
		case 2:
			receptionistScheduleRepairPage1(sc, email, license, mileage, prefMechId);
			
		case 3:
			receptionistLandingPage(sc);
		}
		 
	 }
	
	public  void receptionistScheduleMaintainencePage1(Scanner sc, String email , String license, int mileage, int prefMechId) {
		System.out.println("======================Schedule Maintainence Page 1======================");
		String query = "SELECT Count(*) AS valid FROM Vehicle WHERE licensePlate = "+ license;
		try {
			while(rs.next()) {
				int count = rs.getInt("valid");
				if(count == 0) {
					System.out.println("Car Not Registered");
					receptionistScheduleService(sc);
					break;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// call back end function to register
			// retrieve and print
			
			boolean possible = true;
			
			if(possible) {
				//System.out.println(); // print date1 and date2
				int mechId = 0; // has to be retrieved and changed
				receptionistScheduleMaintainencePage2(sc,email, license, mileage, prefMechId, mechId);
			} else {
				// print not possible
			}
			break;
		case 2:
			receptionistScheduleService(sc);
			break;
		}
		 
	 }
	
	public  void receptionistScheduleMaintainencePage2(Scanner sc, String email , String license, int mileage, int prefMechId, int mechId) {
		System.out.println("======================Schedule Maintainence Page 2======================");
		Date appointmentDate;
		System.out.println("Select Date Of Appointment");
		appointmentDate =  getDate(sc.nextLine());
		System.out.println("1. Schedule on Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		int random = 0; // has to be changed at back end to genrate autonatic id
		switch(choice) {
		case 1:
			// 
			//String query = "INSERT INTO APPOINTMENT(appointmentId, mechanicPref, Status, timeOut, timeIn, mechId, typeOfService) VALUES(" + random + "," + prefMechId + "," + "PENDING" + "," +  + "," + "," ")";
			//String query = "INSERT INtO BOOKS VALUES()"
			break;
		case 2:
			receptionistScheduleMaintainencePage1(sc, email, license, mileage, prefMechId);
		}
		 
	 }
	
	public  void receptionistScheduleRepairPage1(Scanner sc,  String email , String license, int mileage, int PrefMechId) {
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
	
	public  void receptionistDailyTaskUpdateInventory(Scanner sc) {
		System.out.println("======================Daily Task Uodate Inventory======================");
		//display
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;

		}
		 
	 }
	
	public  void receptionistDailyTaskRecordDeliveries(Scanner sc) {
		System.out.println("======================Daily Task Record Deliveries======================");
		System.out.println("1. Enter Order ID (CSV)");
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
	
	 public  void managerAddNewEmployees(Scanner sc) {
		System.out.println("======================Add Employess Menu======================");
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
		System.out.println("1. Add");
		System.out.println("2. Go Back");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			if(role == "Receptionist") {
				String query = "INSERT INTO Employees() VALUES";
				
			}
			
			else if (role == "Mechanic"){
				String query = "INSERT INTO Employees() VALUES";
			}
			
			else {
				System.out.println("Bad Option");
			}
		case 2:
			//
		}	 
	 }
	 
	 public  void managerPayroll(Scanner sc) {
			System.out.println("======================Payroll======================");
			System.out.println("Employee ID");
			String employeeid = sc.nextLine();
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}	 
		 }
	 
	 public  void managerInventory(Scanner sc) {
			System.out.println("======================Inventory======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}	 
		 }
	 
	 public  void managerOrders(Scanner sc) {
			System.out.println("======================Orders======================");
			System.out.println("1. Order History");
			System.out.println("2. New Order");
			System.out.println("3. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
				
			case 2:
				// 
				
			case 3:
				// 
			}	 
		 }
	 
	 public  void managerOrderHistory(Scanner sc) {
			System.out.println("======================Order History======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}	 
		 }
	 
	 public  void managerNewOrder(Scanner sc) {
			System.out.println("======================New Order======================");
			System.out.println("A. Part ID");
			String partid = sc.nextLine();
			System.out.println("B. Quantity");
			String qty = sc.nextLine();
			System.out.println("1. Place Order");
			System.out.println("2. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			case 2:
				// 
			}	 
		 }
	 
	 public  void managerNotifications(Scanner sc) {
			System.out.println("======================Notifications======================");
			//display
			System.out.println("1. Order ID");
			System.out.println("2. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			case 2:
				// 
			}
		 }
	 
	 public  void managerNotificationsDetail(Scanner sc) {
			System.out.println("======================Notifications Detail======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
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
			
			class servicea {
				String miles;
				String months;
				String partlist;
			}
			
			class serviceb {
				String miles;
				String months;
				String additionalPartList;
			}
			
			class servicec {
				String miles;
				String months;
				String additionalPartList;
			}
			
			
			
			servicea sa = new servicea();
			serviceb sb = new serviceb();
			servicec scc = new servicec();
			
			System.out.println("D. -----Service A----");
			System.out.println("a. Miles");
			sa.miles = sc.nextLine();  
			System.out.println("b. Months");
			sa.months = sc.nextLine();  
			System.out.println("c. Parts List");
			sa.partlist = sc.nextLine();
			
			System.out.println("E. -----Service B----");
			System.out.println("a. Miles");
			sb.miles = sc.nextLine();  
			System.out.println("b. Months");
			sb.months = sc.nextLine();  
			System.out.println("c. Additional Parts List");
			sb.additionalPartList = sc.nextLine();  
			
			System.out.println("F. -----Service C----");
			System.out.println("a. Miles");
			scc.miles = sc.nextLine();  
			System.out.println("b. Months");
			scc.months = sc.nextLine();  
			System.out.println("c. Additional Parts List");
			scc.additionalPartList = sc.nextLine();
			
			System.out.println("1. Add Car");
			System.out.println("2. Go Back");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			case 2:
				// 
			}
		 }
	 
	 public  void managerCarServiceDetails(Scanner sc) {
			System.out.println("======================Manager Car Service Details======================");
			System.out.println("A. Make");
			String make = sc.nextLine();
			System.out.println("B. Model");
			String model = sc.nextLine();
			System.out.println("C. Year");
			String year = sc.nextLine();
			
			class servicea {
				String miles;
				String basicservicelist;
			}
			
			class serviceb {
				String miles;
				String basicservicelist;
			}
			
			class servicec {
				String miles;
				String basicservicelist;
			}
			
			
			
			servicea sa = new servicea();
			serviceb sb = new serviceb();
			servicec scc = new servicec();
			
			System.out.println("D. -----Service A----");
			System.out.println("a. Miles");
			sa.miles = sc.nextLine();  
			System.out.println("c. Parts List");
			sa.basicservicelist = sc.nextLine();
			
			System.out.println("E. -----Service B----");
			System.out.println("a. Miles");
			sb.miles = sc.nextLine();  
			System.out.println("c. Parts List");
			sb.basicservicelist = sc.nextLine();
			
			System.out.println("F. -----Service C----");
			System.out.println("a. Miles");
			scc.miles = sc.nextLine();  
			System.out.println("c. Parts List");
			scc.basicservicelist = sc.nextLine();
			
			System.out.println("1. Go Back");
			
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}
		 }
	 
	 public  void managerServiceHistory(Scanner sc) {
			System.out.println("======================Manager Service History======================");
			String mechname = null;
			String query = null;
			try {
				query = "SELECT B.appointmentId, C.name, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.Status FROM Books B, Appointment A, Customer C"
						+ " WHERE A.appointmentId = B.appointmentId AND B.customerId = C.customerId";
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
			    query = "SELECT appointmentId from Appointment";
			    rs = DataOps.getInstance().retrieve(query);
			    Object[][] table = new String[1][];
				table[0] = new String[] { "AppointmentId", "Customer Name", "Start Date" , "License Plate", "Service Type", "Mechanic Name", "Parts Used", "Total cost for parts", "Total Labour Hours", "Total Labour Wages", "Total Service Cost" };

				for (Object[] row : table) {
				    System.out.format("%35s%35s%35s%35s%35s%35s%35s%50s%35s%35s%35s%35s\n", row);
				}
				while(rs.next()) {
					int appointmentId = rs.getInt("appointmentId");
					Map<String, Object> result = new HashMap<String, Object>();
					Helper helper = new Helper();
					result = helper.invoiceGenerator(appointmentId);
					String parts=null;
					String costs=null;
					for (Map.Entry<String, Object> entry : result.entrySet()) {
					    parts = parts + ", "+entry.getKey();
					    costs = costs + ", "+entry.getValue();
					}
					table = new String[1][];
					table[0] = new String[] { (String)result.get("appointmentId"), (String)result.get("customerName"),(String)result.get("startDate"),(String)result.get("licensePlate"),(String)result.get("serviceType"),(String)result.get("Mechanic Name"),parts,costs,(String)result.get("Total Labour Hours"),(String)result.get("Total Labour Wages"),(String)result.get("Total Service Cost")};

					for (Object[] row : table) {
					    System.out.format("%15s%15s\n", row);
					}
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
			switch(choice) {
			case 1:
				// go back
			}
		 }
	 
	 public  Date getDate(String date) {
		 	
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		 Date d = new Date();
		 
	     try { 
		     d = df.parse(date);
	      }
	     
	      catch(ParseException e) {
	    	  DataOps.destroyInstance();
	         System.out.println("Unable to parse " + date);
	      }
	     
		 return d;
	 }
	 
	 public  List getList(String s) {
		 List<String> list = new ArrayList<String>(Arrays.asList(s.split(" , ")));
		 return list;
	 }
	 
	 public  Date getDateTime(String s) {
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		 Date d = new Date();
		 
	     try { 
		     d = df.parse(s);
	      }
	     
	      catch(ParseException e) {
	    	  DataOps.destroyInstance();
	         System.out.println("Unable to parse " + s);
	      }
	     
		 return d;
	 }
}
