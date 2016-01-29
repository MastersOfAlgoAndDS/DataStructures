package crackingthecodinginterview;

/**
 * @Problem_1_5 Implement a method to perform basic string compression using the
 *              counts of repeated characters. For example, the string
 *              aabcccccaaa would become a2blc5a3. If the "compressed" string
 *              would not become smaller than the original string, your method
 *              should return the original string.
 * 
 * @author Milind
 *
 */
public class P1_5_StringCompression {
	public static void main(String[] args) {
		String input = "abc";
		P1_5_StringCompression s = new P1_5_StringCompression();
		System.out.println(s.compress(input));
		input = "aabbcc";
		System.out.println(s.compress(input));
		input = "aabcccccaaa";
		System.out.println(s.compress(input));

	}

	private char[] compress(String input) {
		char[] output = input.toCharArray();
		int i = 0, j = 0;
		char currChar = input.charAt(0);
		int currCharCount = 0;
		while (i < input.length()) {
			if (input.charAt(i) == currChar) {
				currCharCount++;
				i++;
			} else {
				output[j++] = currChar;
				// Condition to see If the "compressed" string would not become
				// smaller than the original string, your method should return
				// the original string.
				if (j >= input.length())
					return input.toCharArray();
				output[j++] = (char) (currCharCount + 48);
				currChar = input.charAt(i);
				currCharCount = 0;
			}
		}

		// These two lines specifically for considering the last currCharacter
		// in the string.
		output[j++] = currChar;
		if (j >= input.length())
			return input.toCharArray();
		output[j++] = (char) (currCharCount + 48);

		char[] finalOutput = new char[j];
		for (int k = 0; k < finalOutput.length; k++) {
			finalOutput[k] = output[k];
		}
		return finalOutput;
	}
}
