package ctci_5E;

import java.util.Stack;

/**
 * @Problem: How would you design a stack which, in addition to push and pop,
 *           also has a function min which returns the minimum element? Push,
 *           pop and min should all operate in 0(1) time
 * 
 * @Solution: Maintain 2 stacks one with values and other with the minimum
 *            value. Keep updating the min stack also only if the new value
 *            being inserted is lesser than or equal to current min
 * 
 *            We can also keep inserting the current min value for each new push
 *            and replicate stack size. However we can save on the size by using
 *            the above approach
 * 
 * @author Milind
 *
 */
public class P3_2_StackWithMin {
	private Stack<Integer> stack;
	private Stack<Integer> mins;

	public P3_2_StackWithMin() {
		stack = new Stack<Integer>();
		mins = new Stack<Integer>();
	}

	public void push(int item) {
		stack.push(item);
		if (mins.isEmpty())
			mins.push(item);
		else if (item <= mins.peek())
			mins.push(item);
	}

	public int pop() {
		if (stack.peek() == mins.peek())
			mins.pop();
		return stack.pop();
	}

	public int getMin() {
		return mins.peek();
	}

	public boolean isEmpty() {
		return stack.isEmpty();
	}

	@Override
	public String toString() {
		return "P3_2_StackWithMin [stack=" + stack + "]";
	}

	public static void main(String[] args) {
		P3_2_StackWithMin stack = new P3_2_StackWithMin();
		stack.push(5);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(6);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(3);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(7);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.push(3);
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.getMin());
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.getMin());

	}
}
