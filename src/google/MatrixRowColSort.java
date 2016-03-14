package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MatrixRowColSort {

	public static void rowColSort(int[][] input) {
		List<Integer> list = new ArrayList<Integer>();
		for (int[] array : input) {
			for (int i : array) {
				list.add(i);
			}
		}

		Collections.sort(list);

		int rows = input.length;
		int cols = input[0].length;
		for (Integer integer : list) {
			System.out.print(integer + " ");
		}
		System.out.println();

		int number = 0;
		for (int i = 0; number < list.size(); i++) {
			// start each diagonal at the top row and from the right
			int row = 0;
			int col = i;

			do {
				// make sure row and length are within the bounds of the matrix
				if (row < input.length && col < input[row].length) {
					input[row][col] = list.get(number);
					number++;
				}

				// we decrement col while incrementing row in order to traverse
				// down and left
				row++;
				col--;
			} while (col >= 0);
		}
	}

	public static void main(String[] args) {
		int[][] input = { { 3, 4, 6 }, { 1, 6, 9 }, { 7, 7, 5 } };
		for (int[] is : input) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		rowColSort(input);
		for (int[] is : input) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
