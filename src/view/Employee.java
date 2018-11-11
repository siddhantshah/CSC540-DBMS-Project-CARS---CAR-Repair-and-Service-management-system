package view;

import java.util.Scanner;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

public class Employee {
	
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
			// displayProfilePage();
		case 2:
			// registerCar();
		case 3:
			// service();
		case 4:
			// invoice();
		case 5:
			// exit;
		case 6:
			// exit;
		case 7:
			// exit;
		case 8:
			// exit;
		case 9:
			// exit;
		case 10:
			// exit;
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
			// displayProfilePage();
		case 2:
			// registerCar();
		case 3:
			// service();
		case 4:
			// invoice();
		case 5:
			// exit;
		case 6:
			// exit;
		case 7:
			// exit;
		case 8:
			// exit;
		case 9:
			// exit;
		case 10:
			// exit;
		case 11:
			// exit;
		case 12:
			// exit;
		}
	}
	
	public static void employeeProfile(Scanner sc) {
		System.out.println("======================Employee Profile======================");
		// Display profile
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		case 2:
			// exit;
		case 3:
			// exit;
		}	 	 
		 
	 }
	
	public static void employeeViewProfile(Scanner sc) {
		System.out.println("======================View Employee Profile======================");
		// Display profile
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		}
		 
	 }
	
	public static void employeeUpdateProfile(Scanner sc) {
		System.out.println("======================Update Profile======================");
		System.out.println("1. Update Name");
		System.out.println("2. Update Address");
		System.out.println("3. Update Email Address");
		System.out.println("4. Update Phone Number");
		System.out.println("5. Update Password");
		System.out.println("6. Go Back");
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
		case 6:
			// exit;
		}	 	 
		 
	 }
	
	public static void employeeViewCustomerProfile(Scanner sc) {
		System.out.println("======================View Customer Profile======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
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
		System.out.println("D. Make");
		String make = sc.nextLine();
		System.out.println("E. Model");
		String model = sc.nextLine();
		System.out.println("F. Year");
		String year = sc.nextLine();
		System.out.println("G. Current Mileage");
		String mileage = sc.nextLine();
		System.out.println("H. Last Service Date");
		String serdate = sc.nextLine();
		System.out.println("1. Register");
		System.out.println("2. Cancel");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
		}
		 
	 }
	
	public static void receptionistServiceHistory(Scanner sc) {
		System.out.println("======================Service History======================");
		System.out.println("Enter customer email address");
		String email = sc.nextLine();
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		}
		 
	 }
	
	public static void receptionistScheduleService(Scanner sc) {
		System.out.println("======================Schedule Service======================");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		System.out.println("B. License Plate");
		String license = sc.nextLine();
		System.out.println("C. Current Mileage");
		String mileage = sc.nextLine();
		System.out.println("D. Mechanic name");
		String mechname = sc.nextLine();
		System.out.println("1. Schedule Maintainence");
		System.out.println("2. Schedule Repair");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		switch(choice) {
		case 1:
			// exit;
		
		case 2:
			// exit;
			
		case 3:
			// exit;
		}
		 
	 }
	
	public static void receptionistScheduleMaintainencePage1(Scanner sc) {
		System.out.println("======================Schedule Maintainence Page 1======================");
		System.out.println("1. Find Service Date");
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
	
	public static void receptionistScheduleMaintainencePage2(Scanner sc) {
		System.out.println("======================Schedule Maintainence Page 2======================");
		System.out.println("1. Schedule on Date");
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
	
	public static void receptionistScheduleRepairPage1(Scanner sc) {
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
			// 
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
			//display
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// exit;

			}
			 
		 }
	 
	 public static void managerInvoices(Scanner sc) {
			System.out.println("======================Manager Invoices======================");
			//display
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			switch(choice) {
			case 1:
				// exit;

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
}