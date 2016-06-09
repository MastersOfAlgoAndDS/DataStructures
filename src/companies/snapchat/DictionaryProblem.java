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
 * @Solution: Referred the word break problem was used to find the answer for
 *            this.
 *            http://www.geeksforgeeks.org/dynamic-programming-set-32-word-
 *            break-problem/
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
		ArrayList<String> inputWordList = new ArrayList<String>();
		for (int i = 0; i < N; i++) {
			String word = in.next();
			inputWordList.add(word);
		}
		ArrayList<String> answer = getSolution(inputWordList);
		answer.forEach(word -> System.out.println(word));
	}

	private static ArrayList<String> getSolution(ArrayList<String> inputWordList) {
		ArrayList<String> answer = new ArrayList<String>();

		Set<String> dictionary = new HashSet<String>();
		dictionary.addAll(inputWordList);
		for (int i = 0; i < inputWordList.size(); i++) {

			dictionary.remove(inputWordList.get(i));
			if (!wordBreak(inputWordList.get(i), dictionary)) {
				answer.add(inputWordList.get(i));
			}
			dictionary.add(inputWordList.get(i));
		}
		return answer;

	}

	/**
	 * 
	 * 
	 * 
	 * @param word
	 * @param dictionary
	 * @return
	 */
	public static boolean wordBreak(String word, Set<String> dictionary) {
		if (word.length() == 0)
			return true;
		for (int i = 1; i <= word.length(); i++) {
			if (dictionary.contains(word.substring(0, i))
					&& wordBreak(word.substring(i, word.length()), dictionary)) {
				return true;
			}
		}
		return false;
	}

}