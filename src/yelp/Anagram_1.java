package yelp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Milind
 * 
 *         Yelp online assessment question v4.
 *
 */
public class Anagram_1 {

	public static void main(String[] args) throws java.lang.Exception {

		
		
		String[] strs = { "tea", "eta", "eat", "gab" };
		anagrams(strs);
	}

	public static List<String> anagrams(String[] strs) {
		ArrayList<String> result = null;
		if (strs == null || strs.length == 0)
			return result;

		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
		for (int i = 0; i < strs.length; i++) {
			char[] arr = strs[i].toCharArray();
			Arrays.sort(arr);
			String t = String.valueOf(arr);
			if (map.get(t) == null) {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(i);
				map.put(t, l);
			} else {
				map.get(t).add(i);
			}
		}

		for (ArrayList<Integer> l : map.values()) {
			result = new ArrayList<String>();
			if (l.size() > 1) {
				for (Integer i : l) {
					result.add(strs[i]);

				}
				System.out.println(result);
			}
		}

		return result;
	}
}