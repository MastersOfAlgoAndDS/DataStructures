package companies.beepi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Milind
 * @Problem: words = {ab, bc, cd, ab, ed,df, ab, cd, ef}
 * 
 *           return top N-most frequent words
 * 
 *           input: words, n
 * 
 *           N = 1 Ouput: ab N = 2 Output: ab, cd N = 3 Output: {ab, cd, df} or
 *           {ab, cd, bc}
 * 
 * 
 *
 */
public class MapSorting {
	public static void main(String[] args) {
		ArrayList<String> input = new ArrayList<String>();
		input.add("ab");
		input.add("bc");
		input.add("cd");
		input.add("ab");
		input.add("ed");
		input.add("df");
		input.add("ab");
		input.add("cd");
		input.add("ef");
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for (String string : input) {
			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}
		}

		HashMap<String, Integer> outputMap = new HashMap<>();
		ArrayList<Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>();
		for (Entry<String, Integer> entry : map.entrySet()) {
			// System.out.println(entry.getKey() + ": " + entry.getValue());
			list.add(entry);
			map.put(entry.getKey(), entry.getValue());
		}

		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		System.out.println();

		// Collections.sort(list, new Comparator<Entry<K, V>>() {
		//
		// @Override
		// public int compare(Entry<K, V> o1, Entry<K, V> o2) {
		//
		// return 0;
		// }
		//
		// });

	}
}
