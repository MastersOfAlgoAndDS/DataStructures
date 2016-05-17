package ctci_5E;

import java.util.Stack;

/**
 * @Problem: Implement a MyQueue class which implements a queue using two
 *           stacks.
 * 
 * @Solution: We solve this using 2 stacks. 1 to carry out only enqueue and
 *            other to carry out dequeue
 * 
 *            Only during dequeue-ing if the deqStack is empty, then try
 *            shifting elements from enqStack to deqStack
 * 
 * @author Milind
 *
 */
public class P3_5_MyQueue {
	private Stack<Integer> enqStack; // enqueue operations happen only on this
										// stack
	private Stack<Integer> deqStack; // dequeue operations happen only on this
										// stack

	public P3_5_MyQueue() {
		enqStack = new Stack<Integer>();
		deqStack = new Stack<Integer>();
	}

	public void enqueue(int item) {
		enqStack.push(item);
	}

	/**
	 * method to move elements from enqStack to deqStack
	 */
	public void shiftElems() {
		if (deqStack.isEmpty()) {
			while (!enqStack.isEmpty()) {
				deqStack.push(enqStack.pop());
			}
		}
	}

	public int dequeue() throws Exception {
		shiftElems();
		if (isEmpty())
			throw new Exception("Queue is Empty!!!");
		return deqStack.pop();
	}

	public boolean isEmpty() {
		return (deqStack.isEmpty() && enqStack.isEmpty());
	}

	public static void main(String[] args) {
		P3_5_MyQueue queue = new P3_5_MyQueue();
		for (int i = 0; i < 5; i++) {
			queue.enqueue(i);
		}
		try {
			System.out.println(queue.dequeue());
			System.out.println(queue.dequeue());
			queue.enqueue(15);
			queue.enqueue(16);
			while (!queue.isEmpty()) {
				System.out.println(queue.dequeue());
			}
			queue.dequeue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
