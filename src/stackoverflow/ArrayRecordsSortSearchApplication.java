package stackoverflow;

import java.util.Scanner;

public class ArrayRecordsSortSearchApplication {

	private static final String STUDENT_FILENAME = "students25.txt";

	public static void main(String args[]) {
		Student[] sortedStudents = null;
		ClassPeriod p1 = new ClassPeriod("PERIOD 1");
		readClass(p1);
		Scanner console = new Scanner(System.in);
		// ConsoleIO console = new ConsoleIO();
		char choice;

		do {
			showMenu();
			choice = console.nextLine().charAt(0);
			System.out.println();
			switch (choice) {
			case '1':
				showStudents(p1.getStudents());
			case '2':
				break;
			default:
				System.out.println("That's not a choice");
				break;
			}
		} while (choice != '2');
	}

	public static void showMenu() {
		System.out.println();
		System.out.println("1)  Show students in original order");
		System.out.println("2)  Quit?");
		System.out.print("choice: ");
	}

	public static void showStudents(Student[] studs) {
		System.out.print("studs.length: " + studs.length + "\n");
		for (int i = 0; i < studs.length; i++)
			System.out.println(studs[i]);
	}

	public static void readClass(ClassPeriod p1) {
		System.out.println("Please wait while data file loads...");
		Scanner infile = new Scanner(STUDENT_FILENAME);

		do {
			int id = infile.nextInt();
			double gpa = infile.nextDouble();
			String name = infile.nextLine();
			Student s = new Student(name, null, id, gpa);
			p1.addStudent(s);
		} while (infile.hasNext());

		infile.close();
	}
}