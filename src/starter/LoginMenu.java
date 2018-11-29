package starter;
import view.Customer;
import view.Employee;
import java.sql.*;
import java.util.Scanner;

import data.DataOps;

public class LoginMenu extends AbstractMenu {

	@Override
	public void display(Scanner sc) {
		System.out.println("======================Login Menu======================");
		System.out.print("Enter User Id: (email address)");
		String userId = sc.next();
		if(!validateLogin(userId)) {
			System.err.println("Invalid User Name, Please enter correct details");
			MainMenu mm = new MainMenu();
			mm.display(sc);
		}
		System.out.print("Enter Password:");
		String password = sc.next();
		String query = "SELECT * FROM Users WHERE loginId='" + userId+"'";
		ResultSet rs = DataOps.getInstance().retrieve(query);
		try {
			while(rs.next()) {
				String role = rs.getString("role");
				String passwordRetrieved = rs.getString("password");
				if(!password.equals(passwordRetrieved)) {
					System.err.println("Incorrect password.");
					System.out.println();
					MainMenu mm = new MainMenu();
					mm.display(sc);
					System.exit(1);
				}
				if(role.equals("Customer")) {
					String custQuery = "SELECT * FROM Customer WHERE email='" + userId+"'";
					ResultSet custrs = DataOps.getInstance().retrieve(custQuery);
					custrs.next();
					int customerId = custrs.getInt("customerId");
					Customer newCustomer = new Customer(customerId);				
					newCustomer.displayLandingPage(sc);
				} else if(role.equals("Receptionist")) {
					String empQuery = "SELECT * FROM Employee WHERE email='" + userId+"'";
					ResultSet emprs = DataOps.getInstance().retrieve(empQuery);
					emprs.next();
					int employeeId = emprs.getInt("employeeId");
					Employee newEmployee = new Employee(employeeId);				
					newEmployee.receptionistLandingPage(sc);
				} else if(role.equals("Manager")) {
					String empQuery = "SELECT * FROM Employee WHERE email='" + userId+"'";
					ResultSet emprs = DataOps.getInstance().retrieve(empQuery);
					emprs.next();
					int employeeId = emprs.getInt("employeeId");
					Employee newEmployee = new Employee(employeeId);				
					newEmployee.managerLandingPage(sc);
				}
			}
		} catch(Exception e) {
			DataOps.destroyInstance();
			e.printStackTrace();
		}
	}
	
	public boolean validateLogin(String email) {
		 try {
			 ResultSet rs =null;
			 String query = "SELECT count(loginId) as count FROM users WHERE loginId = '" + email +"'";
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

}
