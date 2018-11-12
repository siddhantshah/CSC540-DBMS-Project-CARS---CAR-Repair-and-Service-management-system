package view;

import java.util.Scanner;

public class Customer {
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
			// displayProfilePage();
		case 2:
			// registerCar();
		case 3:
			// service();
		case 4:
			// invoice();
		case 5:
			// exit;
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
			// viewProfile();
		case 2:
			// updateProfile();
		case 3:
			// exit;
		}	 
	 }
	 
	 public static void viewProfile(Scanner sc) {
		System.out.println("======================View Profile======================");
		// Display profile
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
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
			// setName();
		case 2:
			// setAddress();
		case 3:
			// setPhoneNumber();
		case 4:
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
	 public static void scheduleMaintenancePage2() {
		 
		 
	 }
	 public static void scheduleRepairPage1() {
		 
		 
	 }
	 public static void scheduleRepairPage2() {
		 
		 
	 }
	 public static void rescheduleServicePage1() {
		 
		 
	 }
	 public static void rescheduleServicePage2() {
		 
		 
	 }
	 public static void invoice() {
		 
		 
	 }
	 public static void viewInvoiceDetails() {
		 
		 
	 }
}
