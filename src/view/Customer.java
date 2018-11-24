package view;

import java.sql.*;
import java.util.Scanner;
import helper.Helper;
import data.DataOps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	Statement stmt = null;
    ResultSet rs = null;
	
	private
		int customerId;
		String name;
		int phoneNumber;
		String address;
		String password;
		
		
	public Customer(int customerId) {
		this.customerId = customerId;
	}

	public void displayLandingPage(Scanner sc) {
		System.out.println("======================Customer Menu======================");
		System.out.println("1. Profile");
		System.out.println("2. Register Car");
		System.out.println("3. Service");
		System.out.println("4. Invoices");
		System.out.println("5. Logout");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			displayProfilePage(sc);
			break;
		case 2:
			registerCar(sc);
			break;
		case 3:
			service(sc);
			break;
		case 4:
			invoice(sc);
			break;
		case 5:
			//customerId = null;
			// logout and return to home page
		}
	}
	
	 public void displayProfilePage(Scanner sc) {
		System.out.println("======================Profile Menu======================");
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			viewProfile(sc);
			break;
		case 2:
			updateProfile(sc);
			break;
		case 3:
			displayLandingPage(sc);
			break;
		}	 
	 }
	 
	 public void viewProfile(Scanner sc) {
		System.out.println("======================View Profile======================");
		// Display the following details followed by the menu. A. Customer ID B. Name C. Address D. Email Address E. Phone Number F. List of All Cars (and their details)
		String query = "SELECT c.customerId, name, address, email, phoneNumber, licensePlate FROM Customer c, Owns o WHERE c.customerId="+customerId+" AND c.customerId=o.customerId";
		rs = DataOps.getInstance().retrieve(query);
		try {
			while(rs.next()) {
 				System.out.println("CustomerId: "+rs.getString("customerId"));
 				System.out.println("Name: "+rs.getString("name"));
 				System.out.println("Address: "+rs.getString("address"));
 				System.out.println("Email Address: "+rs.getString("email"));
 				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
 				System.out.println("License Plate of Car: "+rs.getString("licensePlate"));
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
			displayProfilePage(sc);
			break;
		}	 	 
		 
	 }
	 
	 public void updateProfile(Scanner sc) {
		System.out.println("======================Update Profile======================");
		System.out.println("1. Update Name");
		System.out.println("2. Update Address");
		System.out.println("3. Update Phone Number");
		System.out.println("4. Update Password");
		System.out.println("5. Go Back");
		String query;
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Please enter your Name.");
			String name = sc.next();
			query = "UPDATE Customer SET name='" + name + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 2:
			System.out.println("Please enter your Address.");
			String address = sc.next();
			query = "UPDATE Customer SET address='" + address + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 3:
			System.out.println("Please enter your Phone Number.");
			int phoneNumber = sc.nextInt();
			query = "UPDATE Customer SET phoneNumber='" + phoneNumber + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 4:
			System.out.println("Please enter your Password.");
			String password = sc.next();
			query = "UPDATE Users SET password='" + password + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 5:
			viewProfile(sc);
			break;
		}	 	 
		 
	 }
	 
	 public void registerCar(Scanner sc) {
		System.out.println("======================Register Car======================");
		// Take input from user, see documentation
		System.out.println("Enter the following details:");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		
		System.out.println("Enter License Plate:");
		String licensePlate = sc.next();
		
		System.out.println("Enter Purchase Date:");
		String pDate = sc.next();
		Date purchaseDate = getDate(pDate);
		
		System.out.println("Enter Make:");
		String make = sc.next();
		
		System.out.println("Enter Model:");
		String model = sc.next();
		
		System.out.println("Enter Year:");
		int year = sc.nextInt();
		
		System.out.println("Enter Current Mileage:");
		int currentMileage = sc.nextInt();
		
		System.out.println("Enter Last Service Date (Optional):");
		String lsDate = sc.next();
		if(lsDate=="") lsDate=null;
		Date lastServiceDate = getDate(lsDate);
		
		System.out.println("1. Register");
		System.out.println("2. Cancel");
		System.out.println("Please select your choice.");
		
		int retrievedId = 0;
		String query;
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// query = "INSERT INTO Vehicle VALUES(" + licensePlate + "," + purchaseDate + "," + make + "," + model + "," + year + "," + currentMileage + "," + lastServiceDate;
			query = "INSERT INTO Vehicle(licensePlate, model, dateOfPurchase, lastRecordedMileage, make, yearManufactured) "
					+ "VALUES(" + licensePlate + "," + model + "," + purchaseDate + "," + currentMileage + "," + make + "," + year + ")";
			if(lsDate != "") {
				String query2 = "UPDATE Vehicle SET dateOfLastService = " + lastServiceDate + "WHERE licensePlate = " + licensePlate; 
			}
			String query3 = "SELECT customerId FROM Customer WHERE email = " + email;
			
			try {
				while(rs.next()) {
					retrievedId = rs.getInt("customerId");
				}
			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}	
			String query4 = "INSERT INTO OWNS VALUES(" + licensePlate + "," + retrievedId + ")";
			displayLandingPage(sc);
		case 2:
			displayLandingPage(sc);
			break;
		}	 	 
		 
	 }
	 
	 public void service(Scanner sc) {
		System.out.println("======================Service======================");
		System.out.println("1. View Service History");
		System.out.println("2. Schedule Service");
		System.out.println("3. Reschedule Service");
		System.out.println("4. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			viewServiceHistory(sc);
			break;
		case 2:
			scheduleService(sc);
			break;
		case 3:
			rescheduleServicePage2(sc);
			break;
		case 4:
			displayLandingPage(sc);
			break;
		}
		 
	 }
		
	 public void viewServiceHistory(Scanner sc) {
		System.out.println("======================View Service History======================");
		String query = null;
		String mechname = null;
		query = "SELECT B.appointmentId, B.serviceId, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.timeOut, A.Status FROM Books B, Appointment A"
				+ " WHERE A.appointmentId = B.appointmentId AND B.cutomerId = " + customerId;
		
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
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			service(sc);
			break;
		} 
	 }
	 
	 public void scheduleService(Scanner sc) {
		System.out.println("======================Schedule Service======================");
		// Take input and schedule service 
		System.out.println("Enter the following details:");
		
		System.out.println("Customer Email Address");
		String email = sc.nextLine();
		
		System.out.println("Enter License Plate:");
		String licensePlate = sc.next();
		
		System.out.println("Enter Current Mileage:");
		int currentMileage = sc.nextInt();
		
		System.out.println("Enter Service Centre Id:");
		int serviceCenterId = sc.nextInt();
		
		System.out.println("Enter Mechanic Name: (optional)");
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
		System.out.println("1. Schedule Maintenance");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			scheduleMaintenancePage1(sc, email, licensePlate, currentMileage, prefMechId);
			break;
		case 2:
			scheduleRepairPage1(sc, email, licensePlate, currentMileage, prefMechId);
			break;
		case 3:
			service(sc);
			break;
		}	 
		 
	 }

	 public void scheduleMaintenancePage1(Scanner sc, String email , String license, int mileage, int prefMechId) {
		System.out.println("======================Schedule Maintenance Page 1======================");
		// Take input and schedule service 
		String query = "SELECT Count(*) AS valid FROM Vehicle WHERE licensePlate = "+ license;
		try {
			while(rs.next()) {
				int count = rs.getInt("valid");
				if(count == 0) {
					System.out.println("Car Not Registered");
					scheduleService(sc);
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
							scheduleMaintenancePage2(sc,email, license, mileage, prefMechId, mechId);
						} else {
							// print not possible
						}
						break;
		case 2:
			service(sc);
			break;		
		}	 
	 }
	 
	 public void scheduleMaintenancePage2(Scanner sc, String email , String license, int mileage, int prefMechId, int mechId) {
		 // Display the two identified service dates and mechanic name found based on the inputs in the
		 // previous page to the user, followed by the menu.
		System.out.println("======================Schedule Maintenance Page 2======================");
		// Take input and schedule service 
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
			// Enter Choice (1-2) If the user chooses 1, ask him to pick one of the two dates shown.
			// If the user chooses 1, create a new service record for maintenance service on the chosen date,
			// and go back to Customer: Schedule Service page
			// 
						//String query = "INSERT INTO APPOINTMENT(appointmentId, mechanicPref, Status, timeOut, timeIn, mechId, typeOfService) VALUES(" + random + "," + prefMechId + "," + "PENDING" + "," +  + "," + "," ")";
						//String query = "INSERT INtO BOOKS VALUES()"
		case 2:
			scheduleMaintenancePage1(sc, email, license, mileage, prefMechId);
			break;
		}	 
	 }
	 
	 public void scheduleRepairPage1(Scanner sc, String email , String license, int mileage, int prefMechId) {
		 // Display the menu to allow the user to pick on of the possible problems.
		System.out.println("======================Schedule Repair Page 1======================");
		System.out.println("1. Engine knock");
		System.out.println("2. Car drifts in a particular direction");
		System.out.println("3. Battery does not hold charge");
		System.out.println("4. Black/unclean exhaust");
		System.out.println("5. A/C-Heater not working");
		System.out.println("6. Headlamps/Tail lamps not working");
		System.out.println("7. Check engine light");
		System.out.println("8. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// Engine knock
			//scheduleRepairHelper(customerId, licensePlate, prefMechId, );
		case 2:
			// Car drifts in a particular direction
		case 3:
			// Battery does not hold charge
		case 4:
			// Black/unclean exhaust
		case 5:
			// A/C-Heater not working
		case 6:
			// Headlamps/Tail lamps not working
		case 7:
			// Check engine light
		case 8:
			// exit/go back 
		}	
		 
	 }
	 
	 public void scheduleRepairPage2(Scanner sc) {
		// Display the diagnostic report and the two identified service dates and mechanic name found based on the inputs in the previous page to the user, followed by the menu.	 
		System.out.println("======================Schedule Repair Page 2======================");
		System.out.println("1. Repair on Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// Repair on Date
		case 2:
			// exit/go back 
		}	 
	 }
	 
	 public void rescheduleServicePage1(Scanner sc) {
		 // Display the following details for all upcoming services for this customer, followed by the menu
		 // A. License Plate B. Service ID C. Service Date D. Service Type (Maintenance/Re pair) E. Service Details (Service A/B/C or Problem)
	 	System.out.println("======================Reschedule Service Page 1======================");
	 	System.out.println("Enter your Email Address");
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
			DataOps.destroyInstance();
			e.printStackTrace();
		}
	 	
	 	
	 	System.out.println("1. Pick a service");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// Pick a service
		case 2:
			// exit/go back 
		}	
		 
	 }
	 public void rescheduleServicePage2(Scanner sc) {
		 // Display the two identified service dates and mechanic name, followed by the menu.
		 	System.out.println("======================Reschedule Service Page 2======================");
			System.out.println("1. Reschedule Date");
			System.out.println("2. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// Reschedule Date
			case 2:
				// exit/go back 
			}	
		 
	 }
	 
	 public void invoice(Scanner sc) {
		 // Display the following details for all the services that are complete followed by the menu. A. Service ID B. Service Start Date/Time
		 // C. Service End Date/Time D. Licence Plate E. Service Type F. Mechanic Name G. Total
		System.out.println("======================Invoice======================");
		System.out.println("1. View Invoice Details");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			viewInvoiceDetails(sc);
			break;
		case 2:
			displayLandingPage(sc);
			break;
		}	
	 }
	 
	 public void viewInvoiceDetails(Scanner sc) {
		 // Ask user to input the following detail in order to show the described output followed by an option to go back as shown under “Menu”. A. Service ID
		System.out.println("======================View Invoice Details======================");
		// Take input
		System.out.println("Enter Service Id;");
		String serviceId = sc.next();
		String query = "SELECT serviceId, partId, additionalCharges FROM Service s, Charges c, Invoice i WHERE s.serviceId="+ serviceId + " AND s.serviceId=c.serviceId";
		// Execute query
		// Show detailed description of a service including following details. A. Service ID B. Service Start Date/Time C. Service End Date/Time D. Licence Plate E. Service Type F. Mechanic Name G. Parts Used in service with cost of each part H. Total labor hours I. Labor wages per hour J. Total Service Cost
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			invoice(sc);
			break;
		}
	 }
	 
	 public Date getDate(String date) {
		 	
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
	 
	 
}
