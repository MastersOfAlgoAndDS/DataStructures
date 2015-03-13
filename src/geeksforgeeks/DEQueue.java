/**
 * Double Ended Queue
 * http://geeksquiz.com/deque-set-1-introduction-applications/
 * */

package geeksforgeeks;

import com.ds.DoublyEndedNode;

public class DEQueue<T> {
	DoublyEndedNode<T> front;
	DoublyEndedNode<T> rear;

	public DEQueue() {
		front = rear = null;
	}

	public DoublyEndedNode<T> getFront() {
		return front;
	}

	public void setFront(DoublyEndedNode<T> front) {
		this.front = front;
	}

	public DoublyEndedNode<T> getRear() {
		return rear;
	}

	public void setEnd(DoublyEndedNode<T> rear) {
		this.rear = rear;
	}

	public boolean isEmpty() {
		if (front == null && rear == null) {
			return true;
		}
		return false;
	}

	public void insertAtFront(T elem) {
		DoublyEndedNode<T> nn = new DoublyEndedNode(elem);
		if (!isEmpty()) {
			front.setPrev(nn);
			nn.setNext(front);
			front = front.getPrev();
		} else {
			front = rear = nn;
		}
	}

	public void insertAtRear(T elem) {
		DoublyEndedNode<T> nn = new DoublyEndedNode(elem);
		if (!isEmpty()) {
			rear.setNext(nn);
			nn.setPrev(rear);
			rear = rear.getNext();
		} else {
			front = rear = nn;
		}
	}

	public T removeFromFront() {
		if (!isEmpty()) {
			if (front == rear) {
				T temp = front.getVal();
				front = rear = null;
				return temp;
			} else {
				T temp = front.getVal();
				front = front.getNext();
				front.setPrev(null);
			}
		} else {
			System.out.println("Queue is Empty!!");
			return null;
		}
		return null;
	}

	public T removeFromRear() {
		if (!isEmpty()) {
			if (front == rear) {
				T temp = front.getVal();
				front = rear = null;
				return temp;
			} else {
				T temp = rear.getVal();
				rear = rear.getPrev();
				rear.setNext(null);
			}
		} else {
			System.out.println("Queue is Empty!!");
			return null;
		}
		return null;
	}

	public void print() {
		if (!isEmpty()) {
			DoublyEndedNode<T> temp = front;
			while (temp != null) {
				System.out.print(temp.getVal() + " ");
				temp = temp.getNext();
			}
			System.out.println();
		} else
			System.out.println("Queue is Empty!!");
	}

	public static void main(String[] args) {
		DEQueue<Integer> q = new DEQueue<Integer>();

		for (int i = 1; i < 10; i+=2) {
			q.insertAtFront(i);
			q.print();
			q.insertAtRear(i+1);
			q.print();
		}

		for (int i = 1; i < 10; i+=2) {
			q.removeFromFront();
			q.print();
			q.removeFromRear();
			q.print();
		}

	}
}
