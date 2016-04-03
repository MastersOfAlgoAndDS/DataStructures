package stackoverflow;

import java.lang.reflect.Array;
import java.util.Scanner;

public class GradeBooks {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		gradesentered(input);

	}

	public static void gradesentered(Scanner input) {

		int grades = NumberReader.readPositiveInt(input,
				"Please enter the number of grades: ",
				"Error: Invalid data entered");

		int numOfGrades = grades;

		double[] mogrades = new double[numOfGrades];

		for (int i = 0; i < mogrades.length; i++) {

			System.out.println("Enter grade " + (i + 1) + ": ");

			mogrades[i] = NumberReader.readPositiveDouble(input,
					"Enter grade: ", "Invalid data entered");
			// Displays Grades contained in the Gradebook
			System.out.println("The Grade book contains: ");
			printArray(mogrades);

		}

	}

	public static void printArray(double[] mogrades) {

		for (int i = 0; i < mogrades.length; i++) {
			// Display Grades
			System.out.print("Grade " + (i + 1) + " is: " + mogrades[i] + ", ");

		}

	}

}