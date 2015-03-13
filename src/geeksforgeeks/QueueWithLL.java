/*
 * Queue implementation using Linked List
 * http://geeksquiz.com/queue-set-2-linked-list-implementation/
 * **/

package geeksforgeeks;

import com.ds.Node;

public class QueueWithLL {
	private Node start;
	private Node end;

	public boolean isEmpty() {
		if (start == null && end == null) {
			return true;
		}
		return false;
	}

	public void enqueue(int elem) {
		Node nn = new Node(elem);
		if (end == null && start == null) {
			end = start = nn;
		} else {
			end.setNext(nn);
			end=nn;
		}
	}

	public int dequeue() {
		if (!isEmpty()) {
			int retNum = start.getVal();
			if (start == end) {
				start = end = null;
			} else {
				start = start.getNext();
			}
			return retNum;
		} else {
			return -1;
		}
	}

	public void print() {
		if (!isEmpty()) {
			Node temp = start;
			while (temp != null) {
				System.out.print(temp.getVal() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		} else
			System.out.println("Queue is empty");
	}

	public static void main(String[] args) {
		
		QueueWithLL q = new QueueWithLL();
		for (int i = 1; i <= 10; i++) {
			q.enqueue(i);
			q.print();
		}
		for (int i = 1; i <= 10; i++) {
			q.dequeue();
			q.print();
		}
	}

}
