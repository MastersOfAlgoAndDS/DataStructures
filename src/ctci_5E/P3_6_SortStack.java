package ctci_5E;

import java.util.Stack;

/**
 * @Problem: Write a program to sort a stack in ascending order (with biggest
 *           items on top). You may use at most one additional stack to hold
 *           items, but you may not copy the elements into any other data
 *           structure (such as an array). The stack supports the following
 *           operations: push, pop, peek, and isEmpty.
 * 
 * @Solution: We can do this using another stack. Always keep the constraint
 *            that the elements in the other stack must always be in the order.
 *            In our case buffer stack is the stack which is always sorted. Then
 *            we keep popping elements from first stack and pushing into buffer
 *            stack in their proper place. To push elements in proper place, we
 *            use first stack as the stack to temporarily store elements
 * 
 * @Runtime: O(n^2)
 * @Space: O(n)
 * 
 * @author Milind
 *
 */
public class P3_6_SortStack {
	private Stack<Integer> stack;
	private Stack<Integer> bufferStack;

	public P3_6_SortStack() {
		stack = new Stack<Integer>();
		bufferStack = new Stack<Integer>();
	}

	public void sortAsc() {
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!bufferStack.isEmpty() && bufferStack.peek() < temp) {
				stack.push(bufferStack.pop());
			}
			bufferStack.push(temp);
		}
		Stack<Integer> tempStk = stack;
		stack = bufferStack;
		bufferStack = tempStk;
	}

	public void sortDesc() {
		while (!stack.isEmpty()) {
			int temp = stack.pop();
			while (!bufferStack.isEmpty() && bufferStack.peek() > temp) {
				stack.push(bufferStack.pop());
			}
			bufferStack.push(temp);
		}
		Stack<Integer> tempStk = stack;
		stack = bufferStack;
		bufferStack = tempStk;
	}

	public static void main(String[] args) {
		P3_6_SortStack stk = new P3_6_SortStack();
		for (int i = 0; i < 10; i++) {
			stk.stack.push(i);
			stk.stack.push(i - 1);
		}
		System.out.println(stk.stack);

		stk.sortAsc();
		System.out.println(stk.stack);
		stk.sortDesc();
		System.out.println(stk.stack);

	}

}
