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
		String query = "SELECT * FROM Users WHERE loginId=" + userId;
		ResultSet rs = DataOps.getInstance().retrieve(query);
		try {
			while(rs.next()) {
				String role = rs.getString("employeeOrCustomer");
				if(role=="Customer") {
					String custQuery = "SELECT * FROM Customer WHERE emailAddress=" + userId;
					ResultSet custrs = DataOps.getInstance().retrieve(custQuery);
					int customerId = custrs.getInt("customerId");
					Customer newCustomer = new Customer(customerId);				
					newCustomer.displayLandingPage(sc);
				} else if(role=="Receptionist") {
					String empQuery = "SELECT * FROM Employee WHERE emailAddress=" + userId;
					ResultSet emprs = DataOps.getInstance().retrieve(empQuery);
					int employeeId = emprs.getInt("employeeId");
					Employee newEmployee = new Employee(employeeId);				
					newEmployee.receptionistLandingPage(sc);
				} else if(role=="Manager") {
					String empQuery = "SELECT * FROM Employee WHERE emailAddress=" + userId;
					ResultSet emprs = DataOps.getInstance().retrieve(empQuery);
					int employeeId = emprs.getInt("employeeId");
					Employee newEmployee = new Employee(employeeId);				
					newEmployee.managerLandingPage(sc);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
