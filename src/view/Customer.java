package view;
//import model.CustomerModel;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	private
		static String customerId;
		static String name;
		static int phoneNumber;
		static String address;
		static String password;	

	public static void displayLandingPage(Scanner sc) {
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
			// logout and return to home page
		}
	}
	
	 public static void displayProfilePage(Scanner sc) {
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
	 
	 public static void viewProfile(Scanner sc) {
		System.out.println("======================View Profile======================");
		// Display the following details followed by the menu. A. Customer ID B. Name C. Address D. Email Address E. Phone Number F. List of All Cars (and their details)
		String query = "SELECT customerId, name, address, email, phoneNmuber, licensePlate FROM Customer c, Owns o WHERE c.customerId="+customerId+"AND c.customerId=o.customerId";
		// Execute query
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			displayProfilePage(sc);
			break;
		}	 	 
		 
	 }
	 
	 public static void updateProfile(Scanner sc) {
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
			query = "UPDATE Customer SET name=" + name + " WHERE customerId=" + customerId;
			updateProfile(sc);
			// Execute query
			break;
		case 2:
			System.out.println("Please enter your Address.");
			String address = sc.next();
			query = "UPDATE Customer SET address=" + address + " WHERE customerId=" + customerId;
			updateProfile(sc);
			break;
		case 3:
			System.out.println("Please enter your Phone Number.");
			int phoneNumber = sc.nextInt();
			query = "UPDATE Customer SET phoneNumber=" + phoneNumber + " WHERE customerId=" + customerId;
			updateProfile(sc);
			break;
		case 4:
			System.out.println("Please enter your Password.");
			String password = sc.next();
			query = "UPDATE Customer SET password=" + password + " WHERE customerId=" + customerId;
			updateProfile(sc);
			break;
		case 5:
			viewProfile(sc);
			break;
		}	 	 
		 
	 }
	 
	 public static void registerCar(Scanner sc) {
		System.out.println("======================Register Car======================");
		// Take input from user, see documentation
		System.out.println("Enter the following details:");
		
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
		
		String query;
		
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			query = "INSERT INTO Vehicle VALUES " + licensePlate + "," + purchaseDate + "," + make + "," + model + "," + year + "," + currentMileage + "," + lastServiceDate;
			// Execute query
		case 2:
			displayLandingPage(sc);
			break;
		}	 	 
		 
	 }
	 
	 public static void service(Scanner sc) {
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
		
	 public static void viewServiceHistory(Scanner sc) {
		System.out.println("======================View Service History======================");
		// Take input and Display service history
		// String query = "SELECT * FROM ";
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			service(sc);
			break;
		} 
	 }
	 
	 public static void scheduleService(Scanner sc) {
		System.out.println("======================Schedule Service======================");
		// Take input and schedule service 
		System.out.println("Enter the following details:");
		
		System.out.println("Enter License Plate:");
		String licensePlate = sc.next();
		
		System.out.println("Enter Current Mileage:");
		int currentMileage = sc.nextInt();
		
		System.out.println("Enter Mechanic Name: (optional)");
		String mechanic = sc.next();
		
		
		System.out.println("1. Schedule Maintenance");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			scheduleMaintenancePage1(sc);
			break;
		case 2:
			scheduleRepairPage1(sc);
			break;
		case 3:
			service(sc);
			break;
		}	 
		 
	 }

	 public static void scheduleMaintenancePage1(Scanner sc) {
		System.out.println("======================Schedule Maintenance Page 1======================");
		// Take input and schedule service 
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// HEAVY LOGIC;
		case 2:
			service(sc);
			break;		
		}	 
	 }
	 
	 public static void scheduleMaintenancePage2(Scanner sc) {
		 // Display the two identified service dates and mechanic name found based on the inputs in the
		 // previous page to the user, followed by the menu.
		System.out.println("======================Schedule Maintenance Page 2======================");
		// Take input and schedule service 
		System.out.println("1. Schedule on Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// Enter Choice (1-2) If the user chooses 1, ask him to pick one of the two dates shown.
			// If the user chooses 1, create a new service record for maintenance service on the chosen date,
			// and go back to Customer: Schedule Service page
		case 2:
			scheduleMaintenancePage1(sc);
			break;
		}	 
	 }
	 
	 public static void scheduleRepairPage1(Scanner sc) {
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
	 
	 public static void scheduleRepairPage2(Scanner sc) {
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
	 
	 public static void rescheduleServicePage1(Scanner sc) {
		 // Display the following details for all upcoming services for this customer, followed by the menu
		 // A. License Plate B. Service ID C. Service Date D. Service Type (Maintenance/Re pair) E. Service Details (Service A/B/C or Problem)
	 	System.out.println("======================Reschedule Service Page 1======================");
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
	 public static void rescheduleServicePage2(Scanner sc) {
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
	 
	 public static void invoice(Scanner sc) {
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
	 
	 public static void viewInvoiceDetails(Scanner sc) {
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
	 
	 
}
