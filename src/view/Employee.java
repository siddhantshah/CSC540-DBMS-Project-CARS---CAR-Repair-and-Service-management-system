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

public class Employee {
	
	Statement stmt = null;
    static ResultSet rs = null;
	
	private
		static int employeeId;
		static String serviceCenterId;
		static String name;
		
		
	public Employee(int employeeId) {
		this.employeeId = employeeId;
	}	
	
	public static void receptionistLandingPage(Scanner sc) {
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
		}
	}
	
	
	public static void managerLandingPage(Scanner sc) {
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
		}
	}
	
	public static void receptionistProfile(Scanner sc) {
		System.out.println("======================Employee Profile======================");
		// Display profile
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
		}	 	 
		 
	 }
	
	public static void managerProfile(Scanner sc) {
		System.out.println("======================Employee Profile======================");
		// Display profile
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
		}	 	 
		 
	 }
	
	
	public static void receptionistViewProfile(Scanner sc) {
		System.out.println("======================View Employee Profile======================");
		// Display profile
		String query = "SELECT E.employeeId, E.name, E.address, E.email, E.phoneNumebr, W.serviceCenterId"
				+ " E.startDate, R.salary FROM Employee E, Works_In W, Receptionist R"
				+ "WHERE E.employeeId = W.employeeId AND R.employeeId = E.employeeId AND E.employeeId = " + employeeId;
		
		Object[][] table = new String[1][];
		table[0] = new String[] { "EmployeeId", "Name", "Address", "Email Address" , "Phone Number", "Service Center", "Role", "Start Date", "Compensation($)", "Compensation(freq)" };

		for (Object[] row : table) {
		    System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
		}
		
		try {
			while(rs.next()) {
				
				table[0] = new String[] {rs.getString("employeeId"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNumebr"), rs.getString("serviceCenterId"), "Receptionist", rs.getString("startDate"), rs.getString("salary"), "Monthly"};

				for (Object[] row : table) {
					System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			receptionistProfile(sc);
		}
		 
	 }
	
	public static void managerViewProfile(Scanner sc) {
		System.out.println("======================View Employee Profile======================");
		// Display profile
		String query = "SELECT E.employeeId, E.name, E.address, E.email, E.phoneNumebr, W.serviceCenterId"
				+ " E.startDate, M.salary FROM Employee E, Works_In W, Manager M"
				+ "WHERE E.employeeId = W.employeeId AND M.employeeId = E.employeeId AND E.employeeId = " + employeeId;
		
		Object[][] table = new String[1][];
		table[0] = new String[] { "EmployeeId", "Name", "Address", "Email Address" , "Phone Number", "Service Center", "Role", "Start Date", "Compensation($)", "Compensation(freq)" };

		for (Object[] row : table) {
		    System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
		}
		
		try {
			while(rs.next()) {
				
				table[0] = new String[] {rs.getString("employeeId"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNumebr"), rs.getString("serviceCenterId"), "Manager", rs.getString("startDate"), rs.getString("salary"), "Monthly"};

				for (Object[] row : table) {
					System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			managerProfile(sc);
		}
		 
		 
	 }
	
	public static void receptionistUpdateProfile(Scanner sc) {
		System.out.println("======================Update Profile======================");
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
			input = sc.nextLine();
			query = "UPDATE Employee SET name =" + input + "Where employeeId =" + employeeId;
			receptionistUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET address =" + input + "Where employeeId =" + employeeId;
			receptionistUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET email =" + input + "Where employeeId =" + employeeId;
			receptionistUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber =" + input + "Where employeeId =" + employeeId;
			receptionistUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
			query = "UPDATE Users SET password =" + input + "Where loginId =" + employeeId;
			receptionistUpdateProfile(sc);
			break;
		case 6:
			receptionistProfile(sc);
			break;
		}	 	 
		 
	 }
	
	public static void managerUpdateProfile(Scanner sc) {
		System.out.println("======================Update Profile======================");
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
			input = sc.nextLine();
			query = "UPDATE Employee SET name =" + input + "Where employeeId =" + employeeId;
			managerUpdateProfile(sc);
			break;
		case 2:
			System.out.println("Please Enter Your Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET address =" + input + "Where employeeId =" + employeeId;
			managerUpdateProfile(sc);
			break;
		case 3:
			System.out.println("Please Enter Your Email Address");
			input = sc.nextLine();
			query = "UPDATE Employee SET email =" + input + "Where employeeId =" + employeeId;
			managerUpdateProfile(sc);
			break;
		case 4:
			System.out.println("Please Enter Your Phone Number");
			input = sc.nextLine();
			query = "UPDATE Employee SET phoneNumber =" + input + "Where employeeId =" + employeeId;
			managerUpdateProfile(sc);
			break;
		case 5:
			System.out.println("Please Enter Your password");
			input = sc.nextLine();
			query = "UPDATE Users SET password =" + input + "Where loginId =" + employeeId;
			managerUpdateProfile(sc);
			break;
		case 6:
			managerProfile(sc);
			break;
		}	 	 
		 
	 }
	
	public static void receptionistViewCustomerProfile(Scanner sc) {
		System.out.println("======================View Customer Profile======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		String query1 = "SELECT C.customerId, C.name, C.address, C.email, C.phoneNumber FROM  Customer C "
				+ " WHERE C.email = " + email;
		
		int retrievedId = 0;
		
		Object[][] table = new String[1][];
		table[0] = new String[] { "CustomerId", "Name", "Address", "Email Address" , "Phone Number"};

		for (Object[] row : table) {
		    System.out.format("%35s%35s%35s%35s%35s\n", row);
		}
		
		try {
			while(rs.next()) {
				retrievedId = rs.getInt("customerId");
				table[0] = new String[] { rs.getString("employeeId"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNumebr")};

				for (Object[] row : table) {
				    System.out.format("%35s%35s%35s%35s%35s\n", row);
				}
			}
			
			String query2 = "SELECT V.licencsePlate, V.model, V.dateOfPurchase, V.lastRecordedMileage, V.make, V.typeOfLastService "
					+ ", V.dateOfLastService, V.yearManufactured FROM Vehicle V, Owns O"
					+ "WHERE O.customerId = "+ retrievedId;
			
			table[0] = new String[] { "License Plate", "Make", "Model", "Date Of Purchase" , "Last Recorded Mileage", "Types Of Last Service", "Date Of Last Service", "Manufactured Year"};
			
			for (Object[] row : table) {
				System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
			}
			
			while(rs.next()) {
					
				table[0] = new String[] {rs.getString("licensePlate"), rs.getString("make"), rs.getString("model"), rs.getString("dateOfPurchase"), rs.getString("lastRecordedMileage"), rs.getString("typeOfLastService"), rs.getString("dateOfLastService"), rs.getString("yearManufactured")};

				for (Object[] row : table) {
					System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			receptionistLandingPage(sc);
			break;
		}
		 
	 }
	
	public static void managerViewCustomerProfile(Scanner sc) {
		System.out.println("======================View Customer Profile======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		String query1 = "SELECT C.customerId, C.name, C.address, C.email, C.phoneNumber FROM  Customer C "
				+ " WHERE C.email = " + email;
		
		int retrievedId = 0;
		
		Object[][] table = new String[1][];
		table[0] = new String[] { "CustomerId", "Name", "Address", "Email Address" , "Phone Number"};

		for (Object[] row : table) {
		    System.out.format("%35s%35s%35s%35s%35s\n", row);
		}
		
		try {
			while(rs.next()) {
				retrievedId = rs.getInt("customerId");
				table[0] = new String[] { rs.getString("employeeId"), rs.getString("name"), rs.getString("address"), rs.getString("email"), rs.getString("phoneNumebr")};

				for (Object[] row : table) {
				    System.out.format("%35s%35s%35s%35s%35s\n", row);
				}
			}
			
			String query2 = "SELECT V.licencsePlate, V.model, V.dateOfPurchase, V.lastRecordedMileage, V.make, V.typeOfLastService "
					+ ", V.dateOfLastService, V.yearManufactured FROM Vehicle V, Owns O"
					+ "WHERE O.customerId = "+ retrievedId;
			
			table[0] = new String[] { "License Plate", "Make", "Model", "Date Of Purchase" , "Last Recorded Mileage", "Types Of Last Service", "Date Of Last Service", "Manufactured Year"};
			
			for (Object[] row : table) {
				System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
			}
			
			while(rs.next()) {
					
				table[0] = new String[] {rs.getString("licensePlate"), rs.getString("make"), rs.getString("model"), rs.getString("dateOfPurchase"), rs.getString("lastRecordedMileage"), rs.getString("typeOfLastService"), rs.getString("dateOfLastService"), rs.getString("yearManufactured")};

				for (Object[] row : table) {
					System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			managerLandingPage(sc);
			break;
		}
		 
	 }
	
	public static void receptionistRegisterCar(Scanner sc) {
		System.out.println("======================Register Car======================");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		System.out.println("B. License Plate");
		String license = sc.nextLine();
		System.out.println("C. Purchase Date");
		String purdate = sc.nextLine();
		Date purchasedate = getDate(purdate);
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
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			String query1 = "INSERT INTO Vehicle(licensePlate, model, dateOfPurchase, lastRecordedMileage, make, yearManufactured) "
					+ "VALUES(" + license + "," + model + "," + purchasedate + "," + mileage + "," + make + "," + year + ")";
			if(serdate != "") {
				Date servicedate = getDate(serdate);
				String query2 = "UPDATE Vehicle SET dateOfLastService = " + servicedate + "WHERE licensePlate = " + license; 
			}
			
			String query3 = "SELECT customerId FROM Customer WHERE email = " + email;
			
			try {
				while(rs.next()) {
					retrievedId = rs.getInt("customerId");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			String query4 = "INSERT INTO OWNS VALUES(" + license + "," + retrievedId + ")";
			receptionistLandingPage(sc);
			break;
		case 2:
			receptionistLandingPage(sc);
			break;
		}
		 
	 }
	
	public static void receptionistServiceHistory(Scanner sc) {
		System.out.println("======================Service History======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		int retrievedId = 0;
		String mechname = null;
		String query = null;
		//String query1 = "SELECT FROM Record WHERE " + email; 
		try {
			query = "SELECT C.customerId FROM CUSTOMER C WHERE C.email = " + email;
			while(rs.next()) {
				retrievedId = rs.getInt("customerId");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		query = "SELECT B.appointmentId, B.serviceId, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.timeOut, A.Status FROM Books B, Appointment A"
				+ " WHERE A.appointmentId = B.appointmentId AND B.cutomerId = " + retrievedId;
		
		Object[][] table = new String[1][];
		table[0] = new String[] { "Appointment Id", "License Plate", "Type Of Service", "Service Type", "Mechanic Name" , "Service Start Date", "Service End Date", "Service Status"};

		for (Object[] row : table) {
		    System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
		}
		
		try {
			while(rs.next()) {
				String serviceType = null;
				query = "SELECT name FROM Employee WHERE employeeId = " + rs.getInt("mechId");
				ResultSet rs1 = null;
				while(rs1.next()) {
					mechname = rs1.getString("name");
				}
				
				if(rs.getString("typeOfService") == "Maintenance") {
					query = "SELECT serviceType FROM Maintenance WHERE serviceId = " + rs.getInt("serviceId");
					while(rs1.next()) {
						serviceType = rs1.getString("serviceType");
					}
				}
				
				table[0] = new String[] { rs.getString("appointmentId"), rs.getString("licensePlate"), rs.getString("typeOfService"), serviceType, mechname,  rs.getString("timeIn"), rs.getString("timeOut"), rs.getString("Status")};
	
				for (Object[] row : table) {
				    System.out.format("%35s%35s%35s%35s%35s%35s%35s%35s\n", row);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			receptionistLandingPage(sc);
			break;
		}
		 
	 }
	
	public static void receptionistScheduleService(Scanner sc) {
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
	
	public static void receptionistScheduleMaintainencePage1(Scanner sc, String email , String license, int mileage, int prefMechId) {
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
	
	public static void receptionistScheduleMaintainencePage2(Scanner sc, String email , String license, int mileage, int prefMechId, int mechId) {
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
	
	public static void receptionistScheduleRepairPage1(Scanner sc,  String email , String license, int mileage, int PrefMechId) {
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
	
	public static void receptionistScheduleRepairPage2(Scanner sc) {
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
	
	
	public static void receptionistReScheduleServicePage1(Scanner sc) {
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
	
	public static void receptionistReScheduleServicePage2(Scanner sc) {
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
	
	public static void receptionistInvoices(Scanner sc) {
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
	
	public static void receptionistDailyTaskUpdateInventory(Scanner sc) {
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
	
	public static void receptionistDailyTaskRecordDeliveries(Scanner sc) {
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
	
	 public static void managerAddNewEmployees(Scanner sc) {
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
	 
	 public static void managerPayroll(Scanner sc) {
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
	 
	 public static void managerInventory(Scanner sc) {
			System.out.println("======================Inventory======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}	 
		 }
	 
	 public static void managerOrders(Scanner sc) {
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
	 
	 public static void managerOrderHistory(Scanner sc) {
			System.out.println("======================Order History======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}	 
		 }
	 
	 public static void managerNewOrder(Scanner sc) {
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
	 
	 public static void managerNotifications(Scanner sc) {
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
	 
	 public static void managerNotificationsDetail(Scanner sc) {
			System.out.println("======================Notifications Detail======================");
			//display
			System.out.println("1. Go Back");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// 
			}
		 }
	 
	 public static void managerNewCarModel(Scanner sc) {
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
	 
	 public static void managerCarServiceDetails(Scanner sc) {
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
	 
	 public static void managerServiceHistory(Scanner sc) {
			System.out.println("======================Manager Service History======================");
			String query = "SELECT B.appointmentId, FROM Books B, Appointment A WHERE";
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				//go back
			}
		 }
	 
	 public static void managerInvoices(Scanner sc) {
			System.out.println("======================Manager Invoices======================");
			try {
				int count = 0;
				
				
				String query = "SELECT Count(*) AS totalCount FROM Inventory";
				
				while(rs.next()) {
					count = rs.getInt("totalCount");
				}
				
				int[] partsArray = new int[count];
				int[] partsCostArray = new int[count];
				
			    query = "SELECT B.appointmentId, C.name, A.timeIn, A.timeOut, A.typeOfService, B.licensePlate, V.make, V.model, M.serviceTime, E.name"
						+ "FROM BOOKS B, CUSTOMER C , Maintenance M, Employee E, Appointment A , Vehicle V"
						+ "WHERE A.mechId = E.employeeId AND B.appointmentId = A.apointmentId AND B.customerId = C.customerId AND"
						+ "B.serviceId = M.serviceId AND V.licensePlate = B.licensePlate";
				
				while(rs.next()) {
					float totalcost = 0;
					String sids = null;
					String make = null;
					String model = null;
					String typeOfService = null;
					int totalDiagnosticFee = 0;
					float totalHours = 0;
					float totalLabourCharge = 0;
					float totalPartsCost = 0;
					sids = rs.getString("appointmentId");
					make = rs.getString("make");
					model = rs.getString("model");
					typeOfService = rs.getString("typeOfService");
					ResultSet rs1 = null;
					if(typeOfService == "Repair") {
						List<String> sidlist = getList(sids);
						for(String current:sidlist){
							  int sid = Integer.parseInt(current);
							  query = "SELECT diagnosticFee FROM Repair WHERE serviceId = " + sid;
							  // execute query
							  while(rs1.next()) {
								 totalDiagnosticFee = totalDiagnosticFee + rs1.getInt("diagnosticFee");
							  }

							  query = "SELECT Sum(B.hoursRequired) AS totalHours , Sum(B.laborChargeRate) AS totalLabourCharge FROM Basicservice B, Contains C "
							  		+ "WHERE C.basicServiceId = B.basicServiceId AND C.serviceID = " + sid + " AND C.make = " + make + " C.model = " + model;
							  //ResultSet rs1 = null;
							  while(rs1.next()) {
								  totalHours = totalHours + rs1.getFloat("totalHours");
								  totalLabourCharge = totalLabourCharge + (rs1.getInt("totalLabourCharge") *  rs1.getFloat("totalHours"));
							  }
							  
							  query = "SELECT B.basicServiceId FROM Basicservice B, Contains C "
								  		+ "WHERE C.basicServiceId = B.basicServiceId AND C.serviceID = " + sid + " AND C.make "
								  				+ "= " + make + " C.model = " + model;
								  //ResultSet rs1 = null;
							  while(rs1.next()) {
								  int basicServiceId = rs1.getInt("basicServiceId");
								  ResultSet rs2 = null;
								  query = "SELECT U.partId, U.number FROM Uses U WHERE U.basicServiceId = " + basicServiceId + " AND U.make = " + make + " AND U.model = " + model;
								  while(rs2.next()) {
									  partsArray[rs2.getInt("partId")-1] = partsArray[rs2.getInt("partId")-1] + rs2.getInt("number");
									  ResultSet rs3 = null;
									  query = "SELECT W.cost FROM Warranty W WHERE W.partId = " + rs2.getInt("partId") + "AND W.make = " + make;
									  while(rs3.next()) {
										  partsCostArray[rs2.getInt("partId")-1] = partsCostArray[rs2.getInt("partId")-1] + (rs3.getInt("cost")*rs2.getInt("number"));
									  }
								  }
							  }
							  
						}
						
						for(int i = 0 ; i < count ; i++) {
							totalPartsCost = totalPartsCost + partsCostArray[i];
						}
						
						totalcost = totalLabourCharge + totalDiagnosticFee + totalPartsCost;
						
					} /*else {
						// maintenance 
						  query = "SELECT Sum(B.hoursRequired) AS totalHours , Sum(B.laborChargeRate) AS totalLabourCharge FROM Basicservice B, Contains C "
						  		+ "WHERE C.basicServiceId = B.basicServiceId AND C.make = " + make + " C.model = " + model;
						 // ResultSet rs1 = null;
						  while(rs1.next()) {
							  totalHours = rs1.getFloat("totalHours");
							  totalLabourCharge = rs1.getInt("totalLabourCharge");
						  }
					}*/
					
					/*final Object[][] table = new String[4][];
					table[0] = new String[] { "foo", "bar", "baz" };
					table[1] = new String[] { "bar2", "foo2", "baz2" };
					table[2] = new String[] { "baz3", "bar3", "foo3" };
					table[3] = new String[] { "foo4", "bar4", "baz4" };

					for (final Object[] row : table) {
					    System.out.format("%15s%15s%15s\n", row);
					}*/
					
				} 
				
				// print here
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String query2 = "SELECT FROM PARTS P, ";	// complete after repair thing has been thought of
			
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// go back
			}
		 }
	 
	 public static Date getDate(String date) {
		 	
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy");
		 Date d = new Date();
		 
	     try { 
		     d = df.parse(date);
	      }
	     
	      catch(ParseException e) {
	         System.out.println("Unable to parse " + date);
	      }
	     
		 return d;
	 }
	 
	 public static List getList(String s) {
		 List<String> list = new ArrayList<String>(Arrays.asList(s.split(" , ")));
		 return list;
	 }
	 
	 public static Date getDateTime(String s) {
		 DateFormat df = new SimpleDateFormat("dd/mm/yyyy HH:mm");
		 Date d = new Date();
		 
	     try { 
		     d = df.parse(s);
	      }
	     
	      catch(ParseException e) {
	         System.out.println("Unable to parse " + s);
	      }
	     
		 return d;
	 }
}