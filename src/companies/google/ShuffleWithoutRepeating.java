package companies.google;

import java.util.HashMap;
import java.util.Map.Entry;

public class ShuffleWithoutRepeating {

	/**
	 * 
	 * http://www.careercup.com/question?id=5681030989086720
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "aaaaaabbccc";
		boolean ans = isPossible(input);
		System.out.println(ans);

	}

	private static boolean isPossible(String input) {
		int length = input.length();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char[] inputArray = input.toCharArray();
		for (int i = 0; i < length; i++) {
			if (!map.containsKey(inputArray[i])) {
				map.put(inputArray[i], 1);
			} else {
				map.put(inputArray[i], map.get(inputArray[i]) + 1);
			}
		}
		int maxCnt = 0;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() > maxCnt)
				maxCnt = entry.getValue();
		}
		System.out.println((length + 1) / 2);
		System.out.println(maxCnt);
		if (maxCnt <= (length + 1) / 2)
			return true;
		return false;
	}
}
