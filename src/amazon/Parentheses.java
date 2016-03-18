package amazon;

//Asked in amazon test of akshay

import java.util.Stack;

//DONT FOR 

public class Parentheses {
	public static int validateParentheses(String str) {
		int count = -1;
		if (str.equals("") || str == null) {
			return count;
		}

		Stack<Character> st = new Stack<Character>();
		for (char c : str.toCharArray()) {
			switch (c) {
			case '(':
				st.push(c);
				break;
			case ')':
				if (st.isEmpty() || st.pop() != '(')
					return -1;
				else
					count++;
				break;
			default:
				break;

			}
		}
		if (st.isEmpty())
			return ++count;
		else
			return -1;
	}

	public static void main(String[] args) {
		String input1 = "(())";
		String input2 = "";
		int answer = validateParentheses(input1);
		if (answer > 0) {
			System.out.println(true);
		} else
			System.out.println(false);
		System.out.println(answer);

	}
}
