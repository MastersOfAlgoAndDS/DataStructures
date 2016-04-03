package stackoverflow;

import java.util.Arrays;

public class RandomPrintNumbers {

	public static void main(String[] args) {
		// Create an array to generate 200 numbers
		int Numbers[] = new int[200];

		// Create an array to split the numbers up into 5 categories
		int Count[] = new int[5];

		// Start a new loop
		for (int i = 0; i < Numbers.length; i++) {
			// Generate numbers between 1 and 100
			Numbers[i] = (int) (Math.random() * 100) + 1;
		}

		// Sort the array from least to greatest
		Arrays.sort(Numbers);

		for (int i = 1; i <= Numbers.length; i++) {
			//
			if (i >= 19 && i % 20 == 0) {
				//
				System.out.print(Numbers[i - 1] + "\n");
			}

			//
			else {
				//
				System.out.print(Numbers[i - 1] + " ");

			}

		}

	}
}
