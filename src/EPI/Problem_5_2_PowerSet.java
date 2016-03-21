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
 * @Solution:
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

	public static void newPowerSet(Set<Integer> input) {
		ArrayList<Integer> buff = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {
			for (int j = i; j < input.size(); j++) {
				System.out.print(i + ", " + j);
				if (input.size() > 2) {
					for (Integer integer : input) {
						
					}
				}

			}
		}
	}
}
