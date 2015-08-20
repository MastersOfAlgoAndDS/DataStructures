/**
 * Problem 8.1 : Design a stack that supports a max operation, which returns the maximumvalue
 * stored in the stack, and throws an exception if the stack is empty. Assume
 * elements are comparable. All operations must be O(1) time. You can use O(n) additional
 * space, beyond what is required for the elements themselves.
 * 
 * 
 * */

package EPI;

import java.util.Stack;

public class Problem_8_1_MaxStack {

	Stack<Integer> mainStack;
	Stack<Integer> max;

	public Problem_8_1_MaxStack() {
		mainStack = new Stack<Integer>();
		max = new Stack<Integer>();
	}

	public void push(int item) {
		mainStack.push(item);
		if (!max.empty()) {
			if (max.peek() < item) {
				max.push(item);
			}
		} else
			max.push(item);
	}

	public int pop() {
		if (max.peek() == mainStack.peek()) {
			max.pop();
		}
		return mainStack.pop();
	}

	public int getMax() {
		if (!max.empty())
			return max.peek();
		return 0;
	}

	@Override
	public String toString() {
		return "MaxStack [mainStack=" + mainStack + ", max=" + max + "]";
	}

	public static void main(String[] args) {
		Problem_8_1_MaxStack m = new Problem_8_1_MaxStack();
		System.out.println(m);
		m.push(20);
		m.push(21);
		m.push(10);
		m.push(100);
		m.push(-10);
		System.out.println(m);
		m.pop();
		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());
		m.pop();
		System.out.println(m.getMax());
	}

}
