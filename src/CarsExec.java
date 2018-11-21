import java.util.Scanner;

public class CarsExec {

	public static void main(String[] args) {
		MainMenu m = new MainMenu();
		Scanner sc = new Scanner(System.in);
		m.display(sc);
		sc.close();
	}

}
