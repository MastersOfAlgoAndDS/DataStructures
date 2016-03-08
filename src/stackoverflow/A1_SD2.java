package stackoverflow;

import java.util.Scanner;

public class A1_SD2 {

	int n, sum;
	String name[] = null;
	int grade[] = new int[n];
	int menu = 0;
	double avg = 0;
	Scanner in = new Scanner(System.in);

	public void display() {
		System.out
				.println("Please enter the number of students you would like to grade  -  (2 - 25)");
		System.out
				.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		n = in.nextInt();
		while ((n < 2) || (n > 25)) {
			System.out
					.println(">>>>>>>>>>>>>>>> Please enter a number between 2 and 25 <<<<<<<<<<<<<<<<");
			n = in.nextInt();
		}
		name = new String[n];
	}

	public void grades() {
		for (int i = 0; i < name.length; i++) {
			System.out.println("Please enter the name of the " + (i + 1)
					+ "° student");
			name[i] = in.next();
			System.out.println("Please enter the grade for the " + (i + 1)
					+ "° student");
			grade[i] = in.nextInt();
			while ((grade[i] < 1) || (grade[i] > 100)) {
				System.out
						.println(">>>>>>>>>>>>>>>> Please enter a number between 1 and 100 <<<<<<<<<<<<<<<<");
				grade[i] = in.nextInt();
			}
		}
		do {
			System.out
					.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out
					.println("The grades for all students have been accepted. Choose one option below:");
			System.out
					.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out
					.println("***************************** MENU ************************************ ");
			System.out
					.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			System.out
					.println("1. Display average class grade                                          ");
			System.out
					.println("2. Display lowest class grade                                           ");
			System.out
					.println("3. Display highest class grade                                          ");
			System.out
					.println("4. Sort and display the grades in ascending order                      ");
			System.out
					.println("5. Search for an individual student by name                             ");
			System.out
					.println("6. Exit                                                                 ");
			System.out
					.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
			menu = in.nextInt();
			switch (menu) {
			case 1:
				System.out.println("The average grade for the class is: ");
				break;
			case 2:
				System.out.println("The lowest grade for the class is: ");
				break;
			case 3:
				System.out.println("The highest grade for the class is: ");
				break;
			case 4:
				System.out
						.println("The grades in ascending order are as follows:");
				break;
			case 5:
				System.out.println("The grades for the student are:");
				break;
			case 6:
				System.out
						.println("======Thank you for using this program!======");
				break;
			default:
				System.out
						.println("=====Invalid selection! use 1 - 6 only!=====");
				break;
			}
		} while (menu != 6);
	}

	public static void main(String[] args) {
		final A1_SD2 A1 = new A1_SD2();
		A1.display();
		A1.grades();
	}
}