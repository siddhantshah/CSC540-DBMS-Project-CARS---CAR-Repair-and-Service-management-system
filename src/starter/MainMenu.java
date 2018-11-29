package starter;


import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import data.DataOps;

public class MainMenu extends AbstractMenu{

	@Override
	public void display(Scanner sc) {
		System.out.println("Welcome to Cars! Please select one of the following");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		System.out.println("Select 1,2, or 3 and press enter... ");
		MainMenu mm = new MainMenu();
		int option = sc.nextInt();
		sc.nextLine();
		switch(option) {
		case 1:
			LoginMenu m = new LoginMenu();
			m.display(sc);
			break;
		case 2:
			createCustomerProfile(sc);
			break;
		case 3:
			System.out.println("Good Bye!!");
			System.exit(0);
			break;
		default:
				System.err.println("Invalid Choice, Please enter correct choice");
				System.out.println();
				display(sc);
		}
		
	}
	
	public void createCustomerProfile(Scanner sc) {
		System.out.println("======================Customer Signup======================");
		System.out.println("Enter Email Address");
		String email = sc.nextLine();
		System.out.println("Enter Password");
		String pass = sc.nextLine();
		System.out.println("Enter Name");
		String name = sc.nextLine();
		System.out.println("Enter Address");
		String address = sc.nextLine();
		System.out.println("Enter Phone Number");
		String phone = sc.nextLine();
		
		System.out.println("1. Sign Up");
		System.out.println("2. Go Back");
		System.out.println("Please select your choice.");
		int choice = sc.nextInt();
		sc.nextLine();
		switch(choice) {
		case 1:
			try {
				String query = "select max(customerId) AS max from customer";
				int newCustomerId = 0;
				ResultSet rs = DataOps.getInstance().retrieve(query);
				rs.next();
				newCustomerId = rs.getInt("max") + 1;
				
				query = "INSERT INTO Users VALUES('"+email+ "','" + pass + "','Customer')";
				DataOps.getInstance().insertInto(query);
				query = "INSERT INTO Customer VALUES(" + newCustomerId + ",'" + name + "','" + phone + "','" + address + "','" + email + "','" + email + "')";
				DataOps.getInstance().insertInto(query);

			} catch (SQLException e) {
				DataOps.destroyInstance();
				e.printStackTrace();
			}
			LoginMenu lm = new LoginMenu();
			lm.display(sc);
			break;
		case 2:
			MainMenu mm = new MainMenu();
			mm.display(sc);
		default:
			System.err.println("Please Enter Correct Choice");
			createCustomerProfile(sc);
		}
		 
	 }

}
