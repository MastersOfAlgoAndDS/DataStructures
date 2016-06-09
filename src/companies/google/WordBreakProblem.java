package companies.google;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * @author Milind
 * @Problem: Given an input string and a dictionary of words, find out if the
 *           input string can be segmented into a space-separated sequence of
 *           dictionary words. See following examples for more details.
 *
 *           Consider the following dictionary { i, like, sam, sung, samsung,
 *           mobile, ice, cream, icecream, man, go, mango}
 * 
 *           Input: ilike Output: Yes The string can be segmented as "i like".
 * 
 *           Input: ilikesamsung Output: Yes The string can be segmented as
 *           "i like samsung" or "i like sam sung".
 *
 */
public class WordBreakProblem {
	HashSet<String> dictionary;

	public HashSet<String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(String[] dictionary) {
		for (String string : dictionary) {
			if (this.dictionary == null)
				this.dictionary = new HashSet<String>();
			this.dictionary.add(string.toLowerCase());
		}
	}

	public boolean isWord(String word) {
		return dictionary.contains(word.toLowerCase());
	}

	/**
	 * This can be done by recursion, by checking at each index starting from 1,
	 * can we get left and right parts as words from dictionary.
	 * 
	 * However due to recursion the run time will be bad.!!!
	 * 
	 * @param str
	 * @return
	 */
	public boolean wordBreak(String str) {
		int size = str.length();

		if (size == 0)
			return true;
		for (int i = 1; i <= size; i++) {
			if (isWord(str.substring(0, i))
					&& wordBreak(str.substring(i, size)))
				return true;
		}

		return false;
	}

	public String insertSpaces(ArrayList<String> words, String input) {
		String output = "";
		for (int i = 0; i < words.size(); i++) {
			if (i == words.size() - 1)
				output += words.get(i);
			else
				output += words.get(i) + " ";
		}
		return output;
	}

	/**
	 * This can be done by recursion, by checking at each index starting from 1,
	 * can we get left and right parts as words from dictionary.
	 * 
	 * However due to recursion the run time will be bad.!!! So we go with DP
	 * approach, which is basically checking all the combinations in the problem
	 * search space however using the already calculated things to reduce the
	 * run time. [MEMOIZATION of some form]
	 * 
	 * @param str
	 * @return
	 */
	public boolean wordBreakDP(String str) {
		int size = str.length();
		boolean[] wb = new boolean[size + 1]; // This is the boolean array we
												// use for memoization i.e. for
												// storing the parts of the
												// answer as true of false.
		for (int i = 1; i <= size; i++) {

			// At every step from index=1,check whether the words till index
			// form a word from the dictionary and only then do further
			// calculation, otherwise continue
			if (wb[i] == false && isWord(str.substring(0, i)))
				wb[i] = true;

			if (wb[i] == true) {
				if (i == size)
					return true;

				// If we see that words before index form some dictionary words,
				// proceed and solve the sub problems in the remaining string
				// calculation, otherwise continue
				for (int j = i + 1; j <= size; j++) {
					if (wb[j] == false && isWord(str.substring(j, size)))
						wb[j] = true;

					if (j == size && wb[j] == true)
						return true;
				}
			}

		}

		return false;

	}

	public static void main(String[] args) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i", "like", "ice", "cream" };
		WordBreakProblem s = new WordBreakProblem();
		s.setDictionary(dictionary);

		if (s.wordBreak("ilikesamsung"))
			System.out.println("Yes");
		else
			System.out.println("No");
		if (s.wordBreakDP("ilikesamsung"))
			System.out.println("Yes");
		else
			System.out.println("No");
	}

}
