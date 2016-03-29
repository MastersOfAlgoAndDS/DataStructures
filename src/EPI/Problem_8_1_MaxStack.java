/**
 * Problem 8.1 : Design a stack that supports a max operation, which returns the maximumvalue
 * stored in the stack, and throws an exception if the stack is empty. Assume
 * elements are comparable. All operations must be O(1) time. You can use O(n) additional
 * space, beyond what is required for the elements themselves.
 * 
 * 
 * Solution: We solve this problem by using 2 stacks.
 * 
 * MaxOperation: 	2 stacks will be 1 called mail stack and other maxStack. 
 * 					maxStack will always store the current max element in the mainStack.
 * 					While pushing in mainStack, peek and check in the maxStack and if we
 * 					have a new max element being pushed in the main stack, then push it 
 * 					in maxStack as well. Similarly while popping, if the max element is 
 * 					popped from the main stack, then we also pop it from the maxStack.
 * 
 * 					!!!Here the tricky part is the condition of the maxStack while pushing.
 * 					If the element being pushed in the mainStack is <= (don't miss the =)
 * 					Because we want to maintain the max element in the maxStack even when the 
 * 					same maxElement is added inthe main stack repeatedly.
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
			if (max.peek() <= item) {
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
		m.push(21);
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
