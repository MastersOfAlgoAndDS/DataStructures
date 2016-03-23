package LogicMonitor;

import java.util.HashMap;

/**
 * @author Milind
 * @Problem: // Input: String str
 * 
 *           // Description: Return the length of the longest substring in str
 *           that contains no repeat characters
 * 
 *           // Output: int len
 * 
 * @Solution: Place all the unique characters along with the index in hashmap
 *            and as you get a repeat character, compare the new index - prev
 *            index (from hashmap) difference against the maxDiff and get the
 *            max diff.
 * 
 *            Side by side you can also have the start and end index of the
 *            substring by updating the 2 size array whenever maxSize is
 *            updated.
 *
 *
 * @Tricky: [The tricky part in the problem is to do it in Linear time. To do
 *          this, maintain the maxLen and ansStart variables to track the
 *          maxLenght of answer and the starting index of the answer
 *          respectively.]
 *
 *          Example 1: Ex. 1: str = "abcdabc" ------> 4
 * 
 *          Example 2: Ex. 2: str = "abca" -----> 3
 */
public class Prob1 {

	public static void main(String[] args) {
		// String input = "ccaccaa";
		// String input = "abaababaababacaba";
		String input = "abccba";
		System.out.println(longestSubNoRep(input));
		System.out.println(longestSubNoRepLinearTime(input));
		// input = "abcabcdc";
		// System.out.println(longestSubNoRep(input));
		// System.out.println(longestSubNoRepLinearTime(input));
	}

	/**
	 * @param str
	 * @return
	 * @Runtime: O(n)
	 * 
	 * 
	 */
	public static int longestSubNoRepLinearTime(String str) {
		int maxLen = 0;
		int nonRepSubStringStart = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int i = 0;
		for (i = 0; i < str.length(); i++) {
			char currChar = str.charAt(i);
			if (map.containsKey(currChar)) {
				if (maxLen < (i - nonRepSubStringStart)) {
					maxLen = i - nonRepSubStringStart;
				}
				nonRepSubStringStart = Math.max(nonRepSubStringStart,
						map.get(currChar) + 1);
				map.put(currChar, i);
			} else {
				map.put(currChar, i);
			}
		}
		if (i == str.length()) {
			if (maxLen < (str.length() - nonRepSubStringStart)) {
				maxLen = str.length() - nonRepSubStringStart;
			}
		}

		return maxLen;
	}

	/**
	 * @param str
	 * @return
	 * 
	 *         2 for loops. trying to check the start of the longestSubstring
	 *         with no repeats from each of the characters in string.
	 * 
	 *         O(n^2)
	 * 
	 */
	public static int longestSubNoRep(String str) {
		int maxLen = 0;
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (j = i; j < str.length(); j++) {
				if (map.containsKey(str.charAt(j)))
					break;
				else {
					map.put(str.charAt(j), 1);
				}
			}
			if (maxLen < j - i) {
				maxLen = j - i;
			}
		}
		return maxLen;
	}

}
