package com.ds;
/**
 * 
 */

/**
 * @author Milind
 * 
 */
public class StackWithArray {
	private int top;
	private int[] Stack;

	/**
	 * 
	 */
	public StackWithArray(int len) {
		top = 0;
		Stack = new int[(len + 1)];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StackWithArray s = new StackWithArray(10);

		s.printStack(s);
		/* Test case 1 */
		/* Trying to empty the already empty stack */
		if (s.empty(s))
			System.out.println("The stack is empty");
		else
			System.out.println("The stack is not empty");

		System.out.println("Now Populating the stack");
		s.push(s, 5);
		s.push(s, 15);
		s.push(s, 3);
		s.push(s, 566);
		s.push(s, 10);
		if (s.empty(s))
			System.out.println("The stack is empty");
		else
			System.out.println("The stack is not empty");

		if (s.full(s))
			System.out.println("The stack is full");
		else
			System.out
					.println("The stack is not full yet. You can add more elements");

		s.printStack(s);
		s.push(s, 25);
		s.push(s, 100);
		s.push(s, 93);
		s.push(s, 76);
		s.push(s, 87);

		/*
		 * Stack is full now but trying to add more elements to get the stack is
		 * full error
		 */
		s.push(s, 88);

		if (s.full(s))
			System.out.println("The stack is full");
		else
			System.out
					.println("The stack is not full yet. You can add more elements");

		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);
		System.out.println("Popped element " + s.pop(s) + " from the stack");
		s.printStack(s);

		/*
		 * Stack is empty but still trying to use pop method to give the message
		 * of stack empty.
		 */
		s.pop(s);

		if (s.empty(s))
			System.out.println("The stack is empty");
		else
			System.out.println("The stack is not empty");

	}

	private void push(StackWithArray S, int x) {
		if (S.full(S)) {
			System.out
					.println("The stack is full now. You cannot add any more elements into the stack.");
		} else {
			S.Stack[S.top] = x;
			S.top = S.top + 1;
		}
	}

	private int pop(StackWithArray S) {
		if (S.empty(S)) {
			System.out
					.println("The stack is empty now. Nothing more to pop from the stack.");
			return 0;
		} else {
			S.top = S.top - 1;
			return Stack[S.top];
		}
	}

	private boolean empty(StackWithArray S) {
		if (S.top == 0)
			return true;
		return false;
	}

	private boolean full(StackWithArray S) {
		if (S.top == S.Stack.length - 1)
			return true;
		return false;
	}

	private void printStack(StackWithArray S) {
		System.out.print("******** The Stack is: [");
		for (int i = 0; i < S.top; i++) {
			System.out.print(" " + S.Stack[i] + ",");
		}
		System.out.print("]");
		System.out.println("\nThe top of the stack is: " + S.top);
	}
}
