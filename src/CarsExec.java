

import java.util.Scanner;

import data.DataOps;


public class CarsExec {

	public static void main(String[] args) {
		MainMenu m = new MainMenu();
		Scanner sc = new Scanner(System.in);
		m.display(sc);
		sc.close();
		DataOps.destroyInstance();
	}

}
