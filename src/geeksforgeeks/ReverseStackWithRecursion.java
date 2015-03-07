package geeksforgeeks;

import java.util.Stack;

public class ReverseStackWithRecursion {

	//static Stack<Integer> st;
	public static Stack<Integer> reverseStackWithRecursion(Stack<Integer> input, Stack<Integer> output) {
		int temp = -1;
		if (input.isEmpty()) {
			return output;
		} else {
			temp = input.pop();
			output.push(temp);
			return reverseStackWithRecursion(input,output);
			//st.push(temp);
		}
	}

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		Stack<Integer> sout = new Stack<Integer>();
		st.push(1);
		st.push(2);
		st.push(3);
		st.push(4);
		System.out.println(st.toString());
		sout = reverseStackWithRecursion(st,sout);
		System.out.println(sout.toString());

	}
}
