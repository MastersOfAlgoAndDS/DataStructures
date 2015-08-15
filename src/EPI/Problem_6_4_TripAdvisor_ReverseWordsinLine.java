/**
 * Implement a function for reversing the words in a string. Your function
 * should use O(1) space. 
 * should use O(n) time.
 * 
 * Simple strategy: 
 * 1. Reverse the complete line 
 * 2. Traverse again and reverse each word as it comes along.
 * 
 * This problem can be done using a string or character array. 
 * Its better to do it with character array - 
 * TripAdvisor internship test was character array based.
 * 
 * */

package EPI;

public class Problem_6_4_TripAdvisor_ReverseWordsinLine {

	String reverseWords(String input) {
		// first reverse the complete input string
		input = reverse(input);
		// then traverse and reverse each word.
		int start = 0;
		int end = 0;
		String str = "";
		String output = "";
		while (end < input.length()) {
			String temp = input.substring(start);
			end += temp.indexOf(' ');
			if(temp.indexOf(' ') == -1)
				break;
			str = input.substring(start, end);
			String retStr = reverse(str);
			output = output + retStr + " ";
			start = end+1;
			end += 1;
		}
		output = output + reverse(input.substring(start));
		return output;
	}

	String reverse(String word) {
		String retStr = "";
		int j = word.length() - 1;
		while (j >= 0) {
			retStr = retStr + word.charAt(j);
			j--;
		}
		return retStr;
	}

	public static void main(String[] args) {
		String input = "Hello World is here";
		Problem_6_4_TripAdvisor_ReverseWordsinLine p = new Problem_6_4_TripAdvisor_ReverseWordsinLine();
		System.out.println(p.reverseWords(input));
	}

}
