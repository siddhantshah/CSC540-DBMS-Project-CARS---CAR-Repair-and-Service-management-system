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
		System.out.print("Enter Password:");
		String password = sc.next();
		if(!password.equals("password")) {
			System.out.println("Incorrect password.");
			System.exit(1);
		}
		String query = "SELECT * FROM Users WHERE loginId='" + userId+"'";
		ResultSet rs = DataOps.getInstance().retrieve(query);
		try {
			while(rs.next()) {
				String role = rs.getString("role");
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
					int employeeId = emprs.getInt("employeeId");
					Employee newEmployee = new Employee(employeeId);				
					newEmployee.receptionistLandingPage(sc);
				} else if(role.equals("Manager")) {
					String empQuery = "SELECT * FROM Employee WHERE email='" + userId+"'";
					ResultSet emprs = DataOps.getInstance().retrieve(empQuery);
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

}
