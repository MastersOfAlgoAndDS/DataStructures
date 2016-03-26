package stackoverflow;

import java.util.HashMap;

public class CharacterMap {

	public static void main(String[] args) {
		String str = "hello";
		char[] charArray = str.toCharArray();
		int i = 0;
		HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
		for (char c : charArray) {
			if (!charMap.containsKey(c)) {
				charMap.put(c, i++);
			}
		}

		System.out.println(str);
		for (char c : charArray) {
			System.out.print(charMap.get(c) + "-");
		}
		System.out.println();

		str = "1 2 3 4 5";
		String[] array = str.split("\\s");
		String output = array[1];
		System.out.println(output);
	}

}
