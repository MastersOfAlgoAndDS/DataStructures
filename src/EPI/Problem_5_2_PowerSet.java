package EPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Milind
 * 
 * @Problem: Implement a method that takes as input a set S of distinct
 *           elements, and prints the power set of S. Print the subsets one per
 *           line, with elements separated by commas.
 *
 * @Solution: Approach here is to map the set contents to 2^k unique outputs
 *            where k is the number of contents of input set.
 * 
 *            Then we basically check for each binary number from k times 0...k
 *            to k times 1 111..k i.e and give the set output for whichever bits
 *            were set to 1. Example: input = {A,B} Then k = 2 so check from 00
 *            to 11 We get sets as {00 i.e. Null-set, 01 i.e. A, 10 i.e. B and
 *            11 A,B}
 * 
 *
 */
public class Problem_5_2_PowerSet {

	public static void main(String[] args) {
		Set<Integer> input = new HashSet<Integer>();
		input.add(1);
		input.add(2);
		input.add(3);
		input.add(8);
		getPowerSet(input);
	}

	/**
	 * 
	 * Approach here is to map the set contents to 2^k unique outputs where k is
	 * the number of contents of input set.
	 * 
	 * Then we basically check for each binary number from k times 0...k to k
	 * times 1 111..k i.e and give the set output for whichever bits were set to
	 * 1. Example: input = {A,B} Then k = 2 so check from 00 to 11 We get sets
	 * as {00 i.e. Null-set, 01 i.e. A, 10 i.e. B and 11 A,B}
	 * 
	 * @param input
	 * @Runtime: O(n2^n) where n is the number of characters or digits in the
	 *           input set.
	 * 
	 * 
	 */
	private static void getPowerSet(Set<Integer> input) {
		int size = input.size();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int keySeq = 0;
		for (Integer integer : input) {
			map.put((int) Math.pow(2, keySeq), integer);
			keySeq++;
		}

		// run the for loop from 0 till 2^size
		for (int i = 0; i < Math.pow(2, size); i++) {
			System.out.print(i + ": ");

			// check the 3 bits and print corresponding map value for each bit.
			// example: 010 = {2};
			for (int j = 0; j < input.size(); j++) {
				int raiseTo = (int) Math.pow(2, j);
				if ((raiseTo & i) == raiseTo) {
					System.out.print(map.get(raiseTo));
				}
			}
			System.out.println();
		}
	}

	// Something tried with Rakshe
	// public static void newPowerSet(Set<Integer> input) {
	// ArrayList<Integer> buff = new ArrayList<Integer>();
	// for (int i = 0; i < input.size(); i++) {
	// for (int j = i; j < input.size(); j++) {
	// System.out.print(i + ", " + j);
	// if (input.size() > 2) {
	// for (Integer integer : input) {
	//
	// }
	// }
	//
	// }
	// }
	// }
}
