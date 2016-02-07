package snapchat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Problem: To find the simple words in the below test case. Compund words to
 *           be removed. Compound words are the words which are formed from the
 *           simple words in the dictionary.
 * 
 *           12 words
 * 
 *           chat ever snapchat snap salesperson per person sales son whatsoever
 *           what so
 * 
 * 
 * @author Milind
 *
 */
public class DictionaryProblem {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		// Get number of words
		int N = in.nextInt();

		// Each line is a word
		ArrayList<String> dictionary = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			String word = in.next();
			dictionary.add(word);
		}
		ArrayList<String> answer = getSolution(dictionary);
		answer.forEach(word -> System.out.println(word));
	}

	private static ArrayList<String> getSolution(ArrayList<String> wordList) {
		ArrayList<String> answer = new ArrayList<String>();

		wordList.forEach(word -> {
			System.out.println("current word is: " + word);
			Set<String> dictionary = new HashSet<String>();
			wordList.forEach(p -> {
				if (!p.equals(word))
					dictionary.add(p);
			});
			boolean val = wordBreak(word, dictionary);
			System.out.println("value is: " + val);
			if (val == false) {
				answer.add(word);
			}
		});
		return answer;

	}

	public static boolean wordBreak(String word, Set<String> dictionary) {
		if (word.length() == 0)
			return true;
		for (int i = 0; i < word.length(); i++) {
			if (dictionary.contains(word.substring(0, i))
					&& wordBreak(word.substring(i, word.length() - 1),
							dictionary)) {
				return true;
			}
		}
		return false;
	}
}