package view;
import model.CustomerModel;
import java.util.Scanner;

public class Customer {
	
	static CustomerModel customerModelObject = new CustomerModel();
	
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
			// go back to customer landing page
		}	 
	 }
	 
	 public static void viewProfile(Scanner sc) {
		System.out.println("======================View Profile======================");
		// Display the following details followed by the menu. A. Customer ID B. Name C. Address D. Email Address E. Phone Number F. List of All Cars (and their details)
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
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Please enter your Name.");
			String name = sc.next();
			//customerModelObject.setName(name);
		case 2:
			System.out.println("Please enter your Address.");
			String address = sc.next();
			// setAddress();
		case 3:
			System.out.println("Please enter your Phone Number.");
			int phoneNumber = sc.nextInt();
			// setPhoneNumber();
		case 4:
			System.out.println("Please enter your Password.");
			String password = sc.next();
			// setPassword();
		case 5:
			// exit;
		}	 	 
		 
	 }
	 
	 public static void registerCar(Scanner sc) {
		System.out.println("======================Register Car======================");
		// Take input from user, see documentation
		System.out.println("1. Register");
		System.out.println("2. Cancel");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// registerWith Details();
		case 2:
			// exit/go back;
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
			// viewServiceHistory();
		case 2:
			// scheduleService();
		case 3:
			// rescheduleServicePage1();
		case 4:
			// exit/go back to displayLandingPage ;
		}
		 
	 }
		
	 public static void viewServiceHistory(Scanner sc) {
		System.out.println("======================View Service History======================");
		// Take input and Display service history
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		} 
	 }
	 
	 public static void scheduleService(Scanner sc) {
		System.out.println("======================Schedule Service======================");
		// Take input and schedule service 
		System.out.println("1. Schedule Maintenance");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// viewServiceHistory();
		case 2:
			// scheduleService();
		case 3:
			// exit/go back to displayLandingPage ;
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
			// see documentation;
		case 2:
			// exit/go back to displayLandingPage
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
			// see documentation;
		case 2:
			// exit/go back to displayLandingPage
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
			// View Invoice Details
		case 2:
			// exit/go back to Customer: Landing page
		}	
	 }
	 
	 public static void viewInvoiceDetails(Scanner sc) {
		 // Ask user to input the following detail in order to show the described output followed by an option to go back as shown under “Menu”. A. Service ID
		System.out.println("======================View Invoice Details======================");
		// Take input
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit/go back to Customer: Landing page
		}	
		 
	 }
}
