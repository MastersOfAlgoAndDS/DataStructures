package ctci_5E;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 
 * @Problem: Imagine a (literal) stack of plates. If the stack gets too high, it
 *           migh t topple. Therefore, in real life, we would likely start a new
 *           stack when the previous stack exceeds some threshold. Implement a
 *           data structure SetOfStacks that mimics this. SetOf- Stacks should
 *           be composed of several stacks and should create a new stack once
 *           the previous one exceeds capacity. SetOfStacks.push() and
 *           SetOfStacks. pop () should behave identically to a single stack
 *           (that is, pop () should return the same values as it would if there
 *           were just a single stack).
 * 
 *           FOLLOW UP
 * 
 *           Implement a function popAt(int index) which performs a pop
 *           operation on a specific sub-stack.
 * 
 * @Solution we can implement it using the arraylist of stacks and keeping a
 *           size limit for each of the sub-stacks.
 * 
 *           For the follow up question, we can easily implement the push and
 *           pop on a particular stack, however, we need to discuss with the
 *           interviewer about the cases whether we need to adjust the smaller
 *           stacks in the process, by shifting elements from the remaining
 *           stacks on the empty/small stacks.
 * 
 * 
 * @author Milind
 *
 */
public class P3_3_SetOfStacks {
	private ArrayList<Stack<Integer>> stacks;
	private int maxStackSize;

	public P3_3_SetOfStacks(int maxStackSize) {
		stacks = new ArrayList<Stack<Integer>>();
		this.maxStackSize = maxStackSize;
	}

	public boolean isEmpty() {
		return (stacks.size() == 0 || stacks.get(0).isEmpty());

	}

	public void push(int item) {
		if (stacks.size() == 0
				|| stacks.get(stacks.size() - 1).size() == maxStackSize) {
			stacks.add(new Stack<Integer>());
		}
		stacks.get(stacks.size() - 1).add(item);
	}

	public int pop() throws Exception {
		if (isEmpty())
			throw new Exception("Stack is empty");
		int value = stacks.get(stacks.size() - 1).pop();
		if (stacks.get(stacks.size() - 1).size() == 0) {
			stacks.remove(stacks.size() - 1);
		}
		return value;
	}

	@Override
	public String toString() {
		return "P3_3_SetOfStacks [stacks=" + stacks + ", maxStackSize="
				+ maxStackSize + "]";
	}

	public static void main(String[] args) {
		P3_3_SetOfStacks stackSet = new P3_3_SetOfStacks(3);
		try {
			stackSet.pop();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		stackSet.push(1);
		System.out.println(stackSet);
		stackSet.push(2);
		System.out.println(stackSet);
		stackSet.push(3);
		System.out.println(stackSet);
		stackSet.push(4);
		System.out.println(stackSet);
		stackSet.push(5);
		System.out.println(stackSet);
		stackSet.push(5);
		System.out.println(stackSet);
		stackSet.push(5);
		System.out.println(stackSet);
		stackSet.push(5);
		System.out.println(stackSet);
		stackSet.push(5);
		System.out.println(stackSet);
		try {
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
			stackSet.pop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(stackSet);
	}

}
