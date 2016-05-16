package ctci_5E;

import java.util.ArrayList;
import java.util.Stack;

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
