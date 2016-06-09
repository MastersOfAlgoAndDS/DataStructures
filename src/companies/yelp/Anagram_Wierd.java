package yelp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Anagram_Wierd {

	public static boolean isAnagram(String A, String B) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		if (A.length() != B.length())
			return false;
		for (char character : A.toCharArray()) {
			if (!map.containsKey(character))
				map.put(Character.toLowerCase(character), 1);
			else
				map.put(character, map.get(character) + 1);
		}
		for (char character : B.toCharArray()) {
			if (map.containsKey(Character.toLowerCase(character))) {
				map.put(Character.toLowerCase(character),
						map.get(Character.toLowerCase(character)) - 1);
			} else
				return false;
		}

		for (Entry<Character, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 0)
				return false;
		}
		return true;
	}

	public static boolean isAnagramList(List<String> input) {
		if (input == null)
			return false;
		else {
			int length = input.get(0).length();
			HashMap<Character, Integer> map = new HashMap<Character, Integer>();
			for (char character : input.get(0).toCharArray()) {
				if (!map.containsKey(character))
					map.put(Character.toLowerCase(character), 1);
				else
					map.put(character, map.get(character) + 1);
			}

			int i = 1;
			while (i < input.size()) {
				HashMap<Character, Integer> bufferMap = (HashMap<Character, Integer>) map
						.clone();
				if (length != input.get(i).length())
					return false;
				else {

					for (char character : input.get(i).toCharArray()) {
						if (bufferMap.containsKey(Character
								.toLowerCase(character))) {
							bufferMap
									.put(Character.toLowerCase(character),
											map.get(Character
													.toLowerCase(character)) - 1);
						} else
							return false;
					}

					for (Entry<Character, Integer> entry : bufferMap.entrySet()) {
						if (entry.getValue() != 0)
							return false;
					}

				}
				i++;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		// String A = sc.next();
		// String B = sc.next();
		// boolean ret = isAnagram(A, B);
		// if (ret)
		// System.out.println("Anagrams");
		// else
		// System.out.println("Not Anagrams");

		ArrayList<String> input = new ArrayList<String>();
		input.add("pot");
		input.add("poter");
		input.add("top");
		boolean ans = isAnagramList(input);
		if (ans)
			System.out.println("true");
		else
			System.out.println("false");

	}
}
