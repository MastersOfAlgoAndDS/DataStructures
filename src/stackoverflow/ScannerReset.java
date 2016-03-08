package stackoverflow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class ScannerReset {

	Scanner newInput;
	Scanner forCapturing;

	public static void main(String[] args) throws IOException {
		ScannerReset s = new ScannerReset();
		FileInputStream inputFile = new FileInputStream(
				new File(
						"C:/Users/Milind/OneDrive/Documents/Indiana University Bloomington/Info and coursework/Courses/MyCourses/Z604_BigData/Homework/Homework2/Worksheet.txt"));
		FileOutputStream outputFile = new FileOutputStream(
				new File(
						"C:/Users/Milind/OneDrive/Documents/Indiana University Bloomington/Info and coursework/Courses/MyCourses/Z604_BigData/Homework/Homework2/Output.txt"));

		s.correctListItems(inputFile, outputFile);
	}

	public void correctListItems(FileInputStream inputFile,
			FileOutputStream outputFile) throws IOException {

		newInput = new Scanner(inputFile);

		int aNumber = numOfObjects();
		newInput.close();
		inputFile.close();
		inputFile = new FileInputStream(
				new File(
						"C:/Users/Milind/OneDrive/Documents/Indiana University Bloomington/Info and coursework/Courses/MyCourses/Z604_BigData/Homework/Homework2/Worksheet.txt"));

		Scanner forCapturing = new Scanner(inputFile);
		System.out.println(aNumber);
		int i = 0;
		while (forCapturing.hasNextLine()) {

			forCapturing.nextLine();
			System.out.println("-----------------------------------\n");
			i++;
		}
	}

	private int numOfObjects() {
		int count = 0;
		while (newInput.hasNextLine()) {
			count++;
			newInput.nextLine(); // if this isn't included you'll experience an
									// infinite loop
		}
		System.out.println(count);
		newInput.close();
		return count;
	}
}
