package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Milind
 * @Problem: Given a 2D matrix of integers, sort it such that:
 * 
 *           - every row is sorted in ascending order from left to right - every
 *           column is sorted in ascending order from top to down - all items in
 *           the same row are unique
 * 
 *           You may assume the input matrix is always valid, meaning that such
 *           a sort is always possible.
 * 
 *           For example: for input matrix</p>
 *
 * @Solution: First take the 2D array into a list and sort the list. Then fill
 *            the output matrix starting from top left in a diagonal fashion
 *            from top right to bottom left. So the index order will be
 *
 *            00,01,10,20,11,02,12,21,22
 *
 */
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
		// int[][] input = { { 3, 4, 6 }, { 1, 6, 9 }, { 7, 7, 5 } };
		int[][] input = { { 1, 3, 5 }, { 3, 2, 4 } };
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
