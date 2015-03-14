/*
 * Post fix evaluation
 * 
 * 
 * **/

package geeksforgeeks;

import java.util.Stack;

public class PostfixEvaluation {

	public static boolean isOperand(char character) {
		switch (character) {
		case '+':
		case '-':
		case '*':
		case '/':
		case '^':
			return false;
		default:
			return true;
		}
	}

	public static long postfixEvaluation(String input) {
		long eval = 0;
		char[] charArray = input.toCharArray();
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < charArray.length; i++) {
			char c = charArray[i];
			if (isOperand(charArray[i])) {
				st.push(Integer.valueOf(String.valueOf(charArray[i])));
			} else {
				int b = st.pop();
				int a = st.pop();
				switch (c) {
				case '+':
					st.push(a + b);
					break;
				case '-':
					st.push(a - b);
					break;
				case '*':
					st.push(a * b);
					break;
				case '/':
					st.push(a / b);
					break;
				case '^':
					st.push((int) Math.pow(a, b));
					break;
				}

			}
		}
		return st.pop();
	}
	
	public static void main(String[] args){
		System.out.println(postfixEvaluation("231*+9-"));
	}
}
