package crackingthecodinginterview;

import java.util.HashMap;

/**
 * 
 * @Problem_1_1 Implement an algorithm to determine if a string has all unique
 *              characters. What if you cannot use additional data structures
 * 
 * @author Milind
 *
 */
public class P1_1_UniqChars {

	/**
	 * This is very optimal method provided we limit the input characters to A-Z
	 * or a-z Basically since the bitwise operators operate in 32 bits it
	 * confuses 1<<A = 2 and 1<<a = 2 i.e. 1<<65 = 2^1 and also 1<<97 = 2^1 i.e.
	 * both A and a seem to be same. This is because in ASCII code there are 256
	 * numbers while bitwise operators only work for 32 unique characters since
	 * we work in bitwise operators we work in 256 characters/8 bits = 32 bytes
	 * i.e. 32 unique characters can be distinguished by bitwise holder. so it
	 * works for 26 characters A-Z or a-z
	 * 
	 * Runtime: O(n) | Space: O(1) BUT HERE NO ADDITIONAL DATASTRUCTURE IS USED
	 * 
	 * @param str
	 * @return
	 */
	public boolean isAllCharsUniqueBitwise(String str) {
		int checker = 0;
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			System.out.println("val before shifting is: " + val);
			System.out.println("val = " + (1 << val) + " | checker = "
					+ checker);
			if ((checker & (1 << val)) > 0) {
				return false;
			}
			checker |= (1 << val);
		}
		return true;
	}

	/**
	 * Runtime: O(n) | Space: O(1) i.e. 256 bytes BUT HERE DATASTRUCTURE ARRAY
	 * IS USED
	 * 
	 * @param str
	 * @return
	 */
	public boolean isAllCharsUniqueArr(String str) {
		boolean[] checker = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			if (checker[str.charAt(i)] == true)
				return false;
			checker[str.charAt(i)] = true;
		}
		return true;
	}

	/**
	 * 
	 * Runtime: O(n) | Space: O(1) i.e. < 256 bytes BUT HERE DATASTRUCTURE
	 * HASHMAP IS USED
	 * 
	 * @param str
	 * @return
	 */
	public boolean isAllCharsUniqueMap(String str) {
		HashMap<Character, Boolean> checker = new HashMap<Character, Boolean>();
		for (int i = 0; i < str.length(); i++) {
			if (checker.get(str.charAt(i)) != null)
				return false;
			checker.put(str.charAt(i), true);
		}
		return true;
	}

	public static void main(String[] args) {
		String str = "AeloL";
		P1_1_UniqChars s = new P1_1_UniqChars();
		System.out.println(s.isAllCharsUniqueBitwise(str));
		System.out.println(s.isAllCharsUniqueArr(str));
		System.out.println(s.isAllCharsUniqueMap(str));
	}
}
