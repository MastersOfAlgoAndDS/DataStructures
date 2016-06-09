package google;

import java.util.ArrayList;

/**
 * 
 * @Problem: find consecutive integers in a list that give you the biggest sum
 * 
 *           Like for -2 5 -1 7 -3 it would be 5 -1 7
 * 
 * @Solution Kadane's Algorithm
 * 
 * @author Milind
 *
 */
public class BiggestSumSubstring {

	class Item {
		int i;
		int j;
		/**
		 * sum will store the sum of numbers from indices i up to j
		 */
		int sum;

		Item() {
			i = Integer.MIN_VALUE;
			j = Integer.MIN_VALUE;
			sum = Integer.MIN_VALUE;
		}

		@Override
		public String toString() {
			return "Item [i=" + i + ", j=" + j + ", sum=" + sum + "]";
		}

	}

	public static void main(String[] args) {
		int[] numbers = { -2, 5, -1, 7, -3 };
		int[] input = { 1, 3, -5, 3, 2, 1, -3, 4, 2, -12, 2, 3 };
		Item ans = getBiggestSumSubstring(input);
		System.out.println(ans);
		System.out.print("[");
		for (int i = ans.i; i < ans.j; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.print(input[ans.j] + "]");
		System.out.println();
	}

	private static Item getBiggestSumSubstring(int[] input) {
		BiggestSumSubstring s = new BiggestSumSubstring();
		Item maxCur = s.new Item();
		Item max = s.new Item();
		ArrayList<Item> result = new ArrayList<Item>();
		for (int i = 0; i < input.length; i++) {
			if (maxCur.sum < 0) {
				maxCur.i = i;
				maxCur.j = i;
				maxCur.sum = input[i];
			} else {
				maxCur.j = i;
				maxCur.sum += input[i];
			}
			if (max.sum < maxCur.sum) {
				max.i = maxCur.i;
				max.j = maxCur.j;
				max.sum = maxCur.sum;
			}
			result.add(max);
		}
		return result.get(input.length - 1);
	}
}
