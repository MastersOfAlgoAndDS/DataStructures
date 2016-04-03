package stackoverflow.assignmentaverage;

import java.util.Arrays;
import java.util.Scanner;

public class average {
	private int data[] = new int[5];
	private double mean = 0;
	Scanner keyboard = new Scanner(System.in);
	int i = 1;
	int index = 0;

	average() {
		for (int num : data) {
			System.out.print("Enter score for student " + i + " : ");
			i++;
			data[index] = keyboard.nextInt();
			index++;
		}
		selectionSort();
		calculateMean();
	}

	public void calculateMean() {
		double total = 0;

		for (int num : data) {
			total = total + num;
		}

		mean = total / data.length;
	}

	public String toString() {
		return "Data after selection sort (lowest to highest): "
				+ Arrays.toString(data) + "\nAverage score is: " + mean;
	}

	public void selectionSort() {

		java.util.Arrays.sort(data);

	}
}