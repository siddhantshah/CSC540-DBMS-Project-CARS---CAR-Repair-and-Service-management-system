package view;

import java.sql.*;
import java.util.Scanner;
import helper.Helper;
import starter.MainMenu;
import data.DataOps;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Customer {
	Statement stmt = null;
    ResultSet rs = null;
    Helper H = new Helper();
	
	private
		int customerId;
		String loginId;
		String email;
		String name;
		int phoneNumber;
		String address;
		String password;
		
		
	public Customer(int customerId) {
		this.customerId = customerId;
		String custQuery = "SELECT email FROM Customer WHERE customerId=" + customerId;
		ResultSet custrs = DataOps.getInstance().retrieve(custQuery);
		try {
			custrs.next();
			loginId = custrs.getString("email");
			email = custrs.getString("email");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			DataOps.destroyInstance();
			e.printStackTrace();
		}

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
		sc.nextLine();
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
			MainMenu m = new MainMenu();
			System.out.println("Thanks You For Visiting");
			System.out.println();
			m.display(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			displayLandingPage(sc);
		}
	}
	
	 public void displayProfilePage(Scanner sc) {
		System.out.println("======================Profile Menu======================");
		System.out.println("1. View Profile");
		System.out.println("2. Update Profile");
		System.out.println("3. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		sc.nextLine();
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
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			displayProfilePage(sc);
		}	 
	 }
	 
	 public void viewProfile(Scanner sc) {
		System.out.println("======================View Profile======================");
		String query = "SELECT customerId, name, address, email, phoneNumber FROM Customer WHERE customerId="+customerId;
		rs = DataOps.getInstance().retrieve(query);
		try {
			String license = "";
			while(rs.next()) {
 				System.out.println("CustomerId: "+rs.getString("customerId"));
 				System.out.println("Name: "+rs.getString("name"));
 				System.out.println("Address: "+rs.getString("address"));
 				System.out.println("Email Address: "+rs.getString("email"));
 				System.out.println("Phone Number: "+rs.getString("phoneNumber"));
			}
			query = "SELECT licensePlate FROM Owns o WHERE customerId="+customerId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				license = license + ", " + rs.getString("licensePlate");
			}
				System.out.println("License Plate of Cars: "+ license);
		} catch (SQLException e) {
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
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			viewProfile(sc);
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
		sc.nextLine();
		switch(choice) {
		case 1:
			System.out.println("Please enter your Name.");
			String name = sc.nextLine();
			query = "UPDATE Customer SET name='" + name + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 2:
			System.out.println("Please enter your Address.");
			String address = sc.nextLine();
			query = "UPDATE Customer SET address='" + address + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 3:
			System.out.println("Please enter your Phone Number.");
			String phoneNumber = sc.nextLine();
			query = "UPDATE Customer SET phoneNumber='" + phoneNumber + "' WHERE customerId=" + customerId;
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 4:
			System.out.println("Please enter your Password.");
			String password = sc.nextLine();
			query = "UPDATE Users SET password='" + password + "' WHERE loginId='" + loginId + "'";
			DataOps.getInstance().insertInto(query);
			updateProfile(sc);
			break;
		case 5:
			displayProfilePage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			updateProfile(sc);
		}	 	 
	 }
	 
	 public void registerCar(Scanner sc) {
		System.out.println("======================Register Car======================");
		System.out.println("Enter the following details:");
		
		System.out.println("A. Customer Email Address");
		String email = sc.nextLine();
		if(!validateCustomerEmail(email)) {
			System.err.println("Invalid Customer Email, Please enter correct details");
			displayLandingPage(sc);
		}
		
		System.out.println("Enter License Plate:");
		String licensePlate = sc.nextLine();
		if(!validateLicenseRegister(licensePlate, email)) {
			System.err.println("The license Plate might already have been Registered, Please enter correct details");
			displayLandingPage(sc);
		}
		
		
		System.out.println("Enter Purchase Date(yyyy-mm-dd):");
		String purchaseDate = sc.nextLine();
		
		System.out.println("Enter Make:");
		String make = sc.nextLine();
		
		if(!(make.equals("Honda") || make.equals("Toyota") || make.equals("Nissan"))) {
			System.err.println("Only Honda, Toyota or Nissan are allowed");
			displayLandingPage(sc);
		}
		
		System.out.println("Enter Model:");
		String model = sc.nextLine();
		
		System.out.println("Enter Year:");
		int year = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Current Mileage:");
		int currentMileage = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter Last Service Date (Optional):");
		String lastServiceDate = sc.nextLine();
		
		String query = "select servicecenterId, name from servicecenter";
		rs = DataOps.getInstance().retrieve(query);
		System.out.println("Choose the Service Center to Register your car to:");
		try {
			while(rs.next()) {
				System.out.println(rs.getInt("servicecenterId") + ": " + rs.getString("name"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		int serviceCenterId = Integer.parseInt(sc.nextLine());
		System.out.println("1. Register");
		System.out.println("2. Cancel");
		System.out.println("Please select your choice.");
		
		int retrievedId = 0;
		
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			query = "INSERT INTO Vehicle(licensePlate, model, dateOfPurchase, lastRecordedMileage, make, yearManufactured, serviceCenterId) "
					+ "VALUES('" + licensePlate + "','" + model + "','" + purchaseDate + "'," + currentMileage + ",'" + make + "'," + year + "," + serviceCenterId +")";
			DataOps.getInstance().insertInto(query);
			if(!lastServiceDate.equals("")) {
				query = "UPDATE Vehicle SET dateOfLastService = '" + lastServiceDate + "' WHERE licensePlate = '" + licensePlate + "'";
				DataOps.getInstance().insertInto(query);
			}
			
			try {
				query = "SELECT customerId FROM Customer WHERE email = '" + email +"'";
				rs = DataOps.getInstance().retrieve(query);
				rs.next();
				retrievedId = rs.getInt("customerId");
				query = "INSERT INTO OWNS VALUES('" + licensePlate + "'," + retrievedId + ")";
				DataOps.getInstance().insertInto(query);
			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}	
			displayLandingPage(sc);
		case 2:
			displayLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			updateProfile(sc);
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
		sc.nextLine();
		switch(choice) {
		case 1:
			viewServiceHistory(sc);
			break;
		case 2:
			scheduleService(sc);
			break;
		case 3:
			rescheduleServicePage1(sc);
			break;
		case 4:
			displayLandingPage(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			service(sc);
		}
		 
	 }
		
	 public void viewServiceHistory(Scanner sc) {
		 System.out.println("======================Customer Service History======================");
			try {
				String query = "SELECT B.appointmentId, B.serviceId, B.licensePlate, A.typeOfService, A.mechId, A.timeIn, A.Status FROM Books B, Appointment A"
						+ " WHERE A.appointmentId = B.appointmentId AND B.customerId = " + customerId;
				rs = DataOps.getInstance().retrieve(query);
				while(rs.next()) {
					String serviceType = null;
					query = "SELECT name FROM Employee WHERE employeeId = " + rs.getInt("mechId");
					ResultSet rs1 = null;
					rs1 = DataOps.getInstance().retrieve(query);
					rs1.next();
					String mechname = rs1.getString("name");
					System.out.println("Appointment Id: "+rs.getString("appointmentId"));
					System.out.println("License Plate: "+rs.getString("licensePlate"));
					System.out.println("Service Type: "+rs.getString("typeOfService"));
					System.out.println("Mechanic Name: "+mechname);
					System.out.println("Service Start Date: "+rs.getString("timeIn"));
					System.out.println("Service Status: "+rs.getString("Status"));
					System.out.println();
				}
			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			System.out.println("1. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				service(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				service(sc);
			}
	 }
	 
	 public void scheduleService(Scanner sc) {
			System.out.println("======================Customer Schedule Service======================");
			System.out.println("A. License Plate");
			String license = sc.nextLine();
			if(!validateLicense(license, email)) {
				System.err.println("Invalid License Plate, Please enter correct details");
				scheduleService(sc);
			}
			
			System.out.println("B. Current Mileage");
			int mileage = Integer.parseInt(sc.nextLine());
			if(!validateMileage(license, mileage)) {
				System.err.println("Current Mileage Cannot be less then last recorded mileage, Please enter correct details");
				scheduleService(sc);
			}
			
			System.out.println("C. Mechanic Preference");
			String mechanic = sc.nextLine();
			if(!validateMechanic(mechanic, license)) {
				System.err.println("Invalid Mechanic, Please enter correct details");
				scheduleService(sc);
			}

			System.out.println("1. Schedule Maintainence");
			System.out.println("2. Schedule Repair");
			System.out.println("3. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				scheduleMaintenancePage1(sc, customerId, license, mileage, mechanic);
				break;
			case 2:
				scheduleRepairPage1(sc, customerId, license, mileage, mechanic);
				break;
			case 3:
				service(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				service(sc);
			}	 
		 
	 }

	 public void scheduleMaintenancePage1(Scanner sc, int customerId , String license, int mileage, String mechanic) {
		System.out.println("======================Schedule Maintenance Page 1======================");
		System.out.println("1. Find Service Date");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			Appointment appointment = new Appointment();
			try {
				appointment = H.scheduleMaintenanceHelper(customerId, license, mechanic, mileage);
				if(!appointment.canSchedule) {
					System.out.println(appointment.errorReport);
					scheduleService(sc);
				} else{
					scheduleMaintenancePage2(sc, customerId, license, mileage, mechanic, appointment);
				}
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			scheduleService(sc);
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			scheduleMaintenancePage1(sc, customerId, license, mileage, mechanic);
		} 
	 }
	 
	 public void scheduleMaintenancePage2(Scanner sc, int customerId , String license, int mileage, String mechanic, Appointment appointment) {
		 System.out.println("======================Schedule Maintainence Page 2======================");
			System.out.println("Select Date Of Appointment");
			System.out.println("1. " + appointment.proposedDates[0]);
			System.out.println("2. " + appointment.proposedDates[1]);
			int choice = sc.nextInt();
			sc.nextLine();
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
				scheduleMaintenancePage2(sc, customerId, license, mileage, mechanic, appointment);
			}
			System.out.println("1. Schedule on Date");
			System.out.println("2. Go Back");
			System.out.println("Please select your choice.");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				if(!H.scheduleAppointment(appointment)) {
					System.out.println("Cannot Book The Requested Appointment Successfully");
				}
				service(sc);
				break;
			case 2:
				scheduleMaintenancePage1(sc, customerId, license, mileage, mechanic);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				scheduleMaintenancePage2(sc, customerId, license, mileage, mechanic, appointment);
			} 
	 }
	 
	 public void scheduleRepairPage1(Scanner sc,  int customerId , String license, int mileage, String mechanic) {
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
			Appointment appointment = new Appointment();
			int choice = sc.nextInt();
			sc.nextLine();
			try {
				switch(choice) {
				case 1:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 1);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 2:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 2);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 3:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 3);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 4:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 4);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 5:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 5);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 6:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 6);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 7:
					appointment = H.scheduleRepairHelper(customerId, license, mechanic, mileage, 7);
					if(!appointment.canSchedule) {
						System.out.println(appointment.errorReport);
						scheduleService(sc);
					} else {
						scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
					}
				case 8:
					scheduleService(sc);
				default:
					System.err.println("Please Enter Correct Choice");
					System.out.println();
					scheduleService(sc);
				}
			} catch (ParseException | SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}
		 
	 }
	 
	 public void scheduleRepairPage2(Scanner sc, int customerId , String license, int mileage, String mechanic, Appointment appointment) {
		 System.out.println("======================Schedule Repair Page 2======================");
			System.out.println("Diagnostic Report:" +appointment.diagnosticReport);
			System.out.println("Fee: " + appointment.diagnosticFee);
			System.out.println("Select Date Of Appointment");
			System.out.println("1. " + appointment.proposedDates[0]);
			System.out.println("2. " + appointment.proposedDates[1]);
			int choice = sc.nextInt();
			sc.nextLine();
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
				scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
			}
			System.out.println("1. Repair on Date");
			System.out.println("2. Go Back");
			System.out.println("Please select your choice.");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				if(!H.scheduleAppointment(appointment)) {
					System.out.println("Cannot BookThe Requested Appointment Successfully");
				}
				service(sc);
				break;
			case 2:
				scheduleRepairPage1(sc, customerId, license, mileage, mechanic);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				scheduleRepairPage2(sc, customerId, license, mileage, mechanic, appointment);
			} 
	 }
	 
	 public void rescheduleServicePage1(Scanner sc) {
			System.out.println("======================Reschedule Service Page 1======================");
			int app = 0;
			Appointment appointment = new Appointment();
			String query = null;
			try {
				
				query = "SELECT B.appointmentId From Books B, Appointment A WHERE B.appointmentId = A.appointmentId AND B.customerId = " + customerId + " AND A.status = 'Pending'";
				rs = DataOps.getInstance().retrieve(query);
				while(rs.next()) {
					System.out.println(rs.getInt("appointmentId")+", ");
				}
			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			System.out.println("1. Pick A Service");
			System.out.println("2. Go Back");
			System.out.println("Please select your choice.");
			int choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Enter Service ID:");
				app = sc.nextInt();
				sc.nextLine();
				appointment = H.rescheduleAppointmentHelper(app);
				if(!appointment.canSchedule) {
					System.out.println(appointment.errorReport);
					scheduleService(sc);
				} else {
					rescheduleServicePage2(sc, appointment);
				}
				break;
			
			case 2:
				displayLandingPage(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				displayLandingPage(sc);
			}
		 
	 }
	 public void rescheduleServicePage2(Scanner sc, Appointment appointment) {
			System.out.println("======================Reschedule Service Page 2======================");
			System.out.println("Select Date Of Appointment");
			System.out.println("1. " + appointment.proposedDates[0]);
			System.out.println("2. " + appointment.proposedDates[1]);
			int choice = sc.nextInt();
			sc.nextLine();
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
				rescheduleServicePage2(sc, appointment);
			}
			System.out.println("1. ReSchedule on Date");
			System.out.println("2. Go Back");
			System.out.println("Please select your choice.");
			choice = sc.nextInt();
			sc.nextLine();
			switch(choice) {
			case 1:
				if(!H.rescheduleAppointment(appointment)) {
					System.out.println("Cannot Book The Requested Appointment Successfully");
				}
				service(sc);
				break;
			case 2:
				rescheduleServicePage1(sc);
				break;
			default:
				System.err.println("Please Enter Correct Choice");
				System.out.println();
				rescheduleServicePage2(sc, appointment);
			}	
		 
	 }
	 
	 public void invoice(Scanner sc) {
		System.out.println("======================Invoice======================");
		try {
			String name = null;
			String query = "SELECT name FROM Customer where customerId =" + customerId;
			rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				name = rs.getString("name");
			}
			
		    query = "SELECT * from invoice where customername = '"+ name + "'";
		    rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("AppointmentId: "+rs.getString("appointmentId"));
				System.out.println("Start Date: "+rs.getString("startdate"));
				System.out.println("License Plate: "+rs.getString("licenseplate"));
				System.out.println("Service Type: "+rs.getString("servicetype"));
				System.out.println("Mechanic Name: "+rs.getString("mechanicname"));
				System.out.println("Total Service Cost: "+rs.getString("totalservicecost"));
				System.out.println();
			} 
		} catch (SQLException e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		
		System.out.println("1. View Invoic Details");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			viewInvoiceDetails(sc); 
			break;
		case 2:
			displayLandingPage(sc); 
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			displayLandingPage(sc);
		}	
	 }
	 
	 public void viewInvoiceDetails(Scanner sc) {
		System.out.println("======================View Invoice Details======================");
		try {
			System.out.println("Enter AppointmentId: ");
			int id = Integer.parseInt(sc.nextLine());
		    String query = "SELECT * from invoice where appointmentId = " + id;
		    rs = DataOps.getInstance().retrieve(query);
			while(rs.next()) {
				System.out.println("AppointmentId: "+rs.getString("appointmentId"));
				System.out.println("Start Date: "+rs.getString("startdate"));
				System.out.println("License Plate: "+rs.getString("licenseplate"));
				System.out.println("Service Type: "+rs.getString("servicetype"));
				System.out.println("Mechanic Name: "+rs.getString("mechanicname"));
				System.out.println("Parts Used: "+rs.getString("partsused"));
				System.out.println("Total cost for parts: "+rs.getString("costs"));
				System.out.println("Total Labour Hours: "+rs.getString("totallabourhours"));
				System.out.println("Total Labour Wages: "+rs.getString("totallabourwages"));
				System.out.println("Total Service Cost: "+rs.getString("totalservicecost"));
				System.out.println();
			} 
		} catch (SQLException e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		}
		
		System.out.println("1. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			invoice(sc); 
			break;
		default:
			System.err.println("Please Enter Correct Choice");
			System.out.println();
			invoice(sc);
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
			 query = "SELECT servicecenterId FROM Vehicle where licensePlate = '" + license + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 int serviceCenterId = rs.getInt("serviceCenterId");
			 
			 query = "SELECT count(licensePlate) as count FROM Vehicle WHERE serviceCenterId = " + serviceCenterId + " AND licensePlate = '" + license + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") != 1) {
				 rs.close();
				 return(false);
			 }
			 rs.close();
		 }catch (SQLException e) {
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public boolean validateLicenseRegister(String license, String email) {
		 try {
			 String query = "SELECT count(licensePlate) as count FROM Vehicle WHERE licensePlate = '" + license +"'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") == 1) {
				 rs.close();
				 return(false);
			 }
			 query = "SELECT count(O.licensePlate) as count FROM Owns O, Customer C WHERE C.customerId = O.customerId AND C.email = '" + email + "' AND O.licensePlate = '" + license + "'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(rs.getInt("count") == 1) {
				 rs.close();
				 return(false);
			 }
			 rs.close();
		 }catch (SQLException e) {
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public boolean validateMileage(String license, int mileage) {
		 try {
			 String query = "SELECT lastRecordedMileage FROM Vehicle WHERE licensePlate = '" + license +"'";
			 rs = DataOps.getInstance().retrieve(query);
			 rs.next();
			 if(mileage < rs.getInt("lastRecordedMileage")) {
				 rs.close();
				 return(false);
			 }
			 rs.close();
		 }catch (SQLException e) {
			 DataOps.destroyInstance();
			 e.printStackTrace();
		 }
		 return(true);
	 }
	 
	 public boolean validateMechanic(String mechanic, String license) {
		 try {
			 if(!mechanic.equals("")) {
				 String query = "SELECT servicecenterId FROM Vehicle where licensePlate = '" + license + "'";
					rs = DataOps.getInstance().retrieve(query);
					rs.next();
					int serviceCenterId = rs.getInt("serviceCenterId");
				 
					query = "SELECT count(W.employeeId) as count FROM Employee E, works_in W WHERE W.employeeId = E.employeeId AND E.name = '" + mechanic + "' AND W.serviceCenterId = " + serviceCenterId;
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
	 
	 
}
