

import java.io.*;
import java.util.Scanner;

public class MainMenu extends AbstractMenu{

	@Override
	public void display(Scanner sc) {
		System.out.println("Welcome to Cars! Please select one of the following");
		System.out.println("1. Login");
		System.out.println("2. Sign Up");
		System.out.println("3. Exit");
		System.out.print("Select 1,2, or 3 and press enter... ");
		int option = sc.nextInt();
		switch(option) {
		case 1:
			//Login Screen;
		case 2:
			// Sign up User;
		case 3:
			//Exit
		}
		
	}

}
