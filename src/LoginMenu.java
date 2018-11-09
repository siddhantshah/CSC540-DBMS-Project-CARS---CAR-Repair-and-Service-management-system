

import java.util.Scanner;

public class LoginMenu extends AbstractMenu {

	@Override
	public void display(Scanner sc) {
		System.out.println("======================Login Menu======================");
		System.out.print("Enter User Id:");
		String user = sc.next();
		System.out.print("Enter Password:");
		String password = sc.next();
		
		

	}

}
