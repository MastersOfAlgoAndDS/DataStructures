package companies.servicenow;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @Problem: find consecutive integers in a list that give you the biggest sum
 * 
 *           Like for -2 5 -1 7 -3 it would be 5 -1 7 Like for 5 6 05 5 -11 5 it
 *           would be 5 -1 7
 * 
 * @Solution Kadane's Algorithm
 * 
 * @author Milind
 *
 */
public class BiggestZeroSumSubArray {

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
		int[] interviewInput = { 5, 6, -5, 5, -12, 5 };
		int[] input = { 1, 3, -5, 3, 2, 1, -3, 4, 2, -12, 2, 3 };
		Item ans = getBiggestSumSubstring(input);
		System.out.println(ans);
		System.out.print("[");
		for (int i = ans.i; i < ans.j; i++) {
			System.out.print(input[i] + ", ");
		}
		System.out.print(input[ans.j] + "]");
		System.out.println();
		System.out.println(maxLen(interviewInput));
		// System.out.println(new BiggestZeroSumSubArray()
		// .getMaxLenZeroSumSubArray(input));
	}

	private static Item getBiggestSumSubstring(int[] input) {
		BiggestZeroSumSubArray s = new BiggestZeroSumSubArray();
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

	static int maxLen(int arr[]) {
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0; // Initialize sum of elements
		int max_len = 0; // Initialize result

		// Traverse through the given array
		for (int i = 0; i < arr.length; i++) {
			// Add current element to sum
			sum += arr[i];

			if (arr[i] == 0 && max_len == 0)
				max_len = 1;

			if (sum == 0)
				max_len = i + 1;

			// Look this sum in hash table
			Integer prev_i = hM.get(sum);

			// If this sum is seen before, then update max_len
			// if required
			if (prev_i != null)
				max_len = Math.max(max_len, i - prev_i);
			else
				// Else put this sum in hash table
				hM.put(sum, i);
		}

		return max_len;
	}

	public Item getMaxLenZeroSumSubArray(int[] input) {
		// calculate sum of aaray
		int left = 0;
		int right = input.length - 1;
		int sum = 0;
		Item ans = new BiggestZeroSumSubArray.Item();
		for (int i : input) {
			sum += i;
		}

		while (left < right) {
			if (sum > 0) {
				if (input[left] > 0 && input[right] > 0
						&& input[left] + input[right] <= sum) {
					sum = sum - input[left] - input[right];
					left++;
					right--;
				} else if (input[left] > 0 && input[left] <= sum) {
					sum = sum - input[left];
					left++;
				} else if (input[right] > 0 && input[right] <= sum) {
					sum = sum - input[right];
					right--;
				} else if (sum < 0) // same as the above.
				{
					sum = sum - input[right];
					right--;
				} else {
					ans.i = left;
					ans.j = right;
					ans.sum = sum;
				}
			}
		}
		return ans;
	}
}
