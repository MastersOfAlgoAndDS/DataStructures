package ctci_5E;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @Problem_1_3 Given two strings, write a method to decide if one is a
 *              permutation of the other.
 * 
 * 
 *              1. Sort both the strings and then compare them. If sorted
 *              strings are same then permutation is true. O(nlogn)
 * 
 *              2. Put each character from first string in to the hashmap. and
 *              increase count for repeat characters. On iterating second string
 *              keep removing characters from the hashmap. If the hashmap is
 *              empty at the end, and the string is completely traversed, we
 *              found the permutation. other wise NO permutation. O(n)
 * @author Milind
 *
 */
public class P1_3_StringIsPermutation {

	public static void main(String[] args) {
		String str1 = "Hello";
		String str2 = "olleH";
		P1_3_StringIsPermutation s = new P1_3_StringIsPermutation();
		System.out.println(s.isStringPermutation(str1, str2));
	}

	private boolean isStringPermutation(String str1, String str2) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < str1.length(); i++) {
			if (map.containsKey(str1.charAt(i))) {
				map.put(str1.charAt(i), map.get(str1.charAt(i)) + 1);
			} else {
				map.put(str1.charAt(i), 1);
			}
		}
		for (int i = 0; i < str2.length(); i++) {
			if (map.containsKey(str2.charAt(i))) {
				map.put(str2.charAt(i), map.get(str2.charAt(i)) - 1);
			} else {
				return false;
			}
		}
		boolean flag = true;
		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0) {
				flag = false;
			}
		}
		return flag;
	}
}
