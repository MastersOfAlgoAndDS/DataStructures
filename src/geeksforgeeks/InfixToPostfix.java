package geeksforgeeks;

import java.util.Stack;

public class InfixToPostfix {

	public static String InfixToPostfix(String input) {
		String postfix = "";
		Stack<Character> st = new Stack<Character>();
		st.push('$');
		char[] infix = input.toCharArray();
		for (int i = 0; i < infix.length; i++) {
			char c = infix[i];
			//char top = st.peek();
			switch (c) {
			case '(':
				st.push(c);
				break;
			case ')':
				while (st.peek() != '(') {
					postfix = postfix.concat(st.pop().toString());
				}
				st.pop();
				break;
			case '-':
			case '+':
				while (st.peek() == '+' || st.peek() == '^' || st.peek() == '-'
						|| st.peek() == '/' || st.peek() == '*') {
					postfix = postfix.concat(st.pop().toString());
				}
				st.push(c);
				break;
			case '*':
			case '/':
				while (st.peek() == '*' || st.peek() == '^' || st.peek() == '/') {
					postfix = postfix.concat(st.pop().toString());
				}
				st.push(c);
				break;
			case '^':
				while (st.peek() == '^') {
					postfix = postfix.concat(st.pop().toString());
				}
				st.push(c);
				break;

			default:
				postfix = postfix.concat(Character.toString(c));
			}
		}
		while (!st.isEmpty()) {
			char temp = st.peek();
			if(temp=='$')
				break;
			else
				postfix = postfix.concat(st.pop().toString());
		}

		return postfix;
	}

	public static void main(String[] args) {
		//InfixToPostfix i2p = new InfixToPostfix();
		System.out.println(InfixToPostfix("a+b*c").equals("abc*+") ? "Correct" : "WRONG!!!");
		System.out.println(InfixToPostfix("(a+b)*c").equals("ab+c*") ? "Correct" : "WRONG!!!");
		System.out.println(InfixToPostfix("a+b*(c^d-e)^(f+g*h)-i").equals("abcd^e-fgh*+^*+i-") ? "Correct" : "WRONG!!!");
		System.out.println(InfixToPostfix("a+b*(c^d-e)^(f+g*h)-i"));
	}
}
