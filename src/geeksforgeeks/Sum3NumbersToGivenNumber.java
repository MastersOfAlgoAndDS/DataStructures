package geeksforgeeks;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Milind
 * @Problem: Given an array and a value, find if there is a triplet in array
 *           whose sum is equal to the given value. If there is such a triplet
 *           present in array, then print the triplet and return true. Else
 *           return false. For example, if the given array is {12, 3, 4, 1, 6,
 *           9} and given sum is 24, then there is a triplet (12, 3 and 9)
 *           present in array whose sum is 24.
 * 
 * @solution: Sort the numbers. THen take each number from start one at a time
 *            and apply 2 number sum to get targetSum-removedNumber algorithm to
 *            get the answer
 */
public class Sum3NumbersToGivenNumber {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(7);
		list.add(8);
		list.add(1);
		list.add(2);
		answer(list, 10);
	}

	private static void answer(ArrayList<Integer> list, int targetSum) {
		Collections.sort(list);
		for (int i = 0; i < list.size() - 2; i++) {
			int start = 1;
			int end = list.size() - 1;
			while (start < end) {
				if (list.get(i) + list.get(start) + list.get(end) == targetSum) {
					System.out.println(i + " " + start + " " + end);
					return;
				} else if (list.get(i) + list.get(start) + list.get(end) < targetSum) {
					start++;
				} else {
					end--;
				}
			}
		}
		System.out.println("No combination of numbers form targetSum");
	}
}
