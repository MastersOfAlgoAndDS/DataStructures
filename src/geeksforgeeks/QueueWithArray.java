/**
 * Queue implementation using Array
 * http://geeksquiz.com/queue-set-1introduction-and-array-implementation/
 * 
 * */

package geeksforgeeks;

public class QueueWithArray {
	public int[] array;
	public int start;
	public int end;
	public int queueSize;
	public int maxSize;

	public QueueWithArray(int size) {
		maxSize = size;
		array = new int[size];
		start = end = -1;
		queueSize = 0;
	}

	public boolean isEmpty() {
		if (start == -1 && end == -1) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (queueSize == maxSize)
			return true;
		return false;
	}

	public void enqueue(int elem) {
		if (!isFull()) {
			if (start == -1)
				start++;
			end = (end + 1) % maxSize;
			array[end] = elem;
			queueSize++;
		} else {
			System.out.println("Queue is full");
		}
	}

	public int dequeue() {
		if (start == end) {
			int retElem = array[start];
			start = end = -1;
			queueSize--;
			return retElem;
		} else if (!isEmpty()) {
			int retElem = array[start];
			start = (start + 1) % maxSize;
			queueSize--;
			return retElem;
		} else {
			System.out.println("Queue is empty");
			return -1;
		}
	}

	public void print() {
		if (!isEmpty()) {
			int trav = start;
			while (trav != end) {
				trav=(trav+1)%maxSize;
				System.out.print(array[trav] + " ");
			}
			System.out.print(array[trav] + " ");
		} else {
			System.out.println("Queue is empty");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int sizeOfQueue = 10;
		QueueWithArray q = new QueueWithArray(sizeOfQueue);
		for (int i = 0; i < sizeOfQueue; i++) {
			q.enqueue(i);
			q.print();
		}
		q.print();
		for (int i = 0; i < sizeOfQueue-4; i++) {
			q.dequeue();
			q.print();
		}
		q.print();
		for (int i = 0; i < sizeOfQueue; i++) {
			q.enqueue(i+10);
			q.print();
		}
		for (int i = 0; i < sizeOfQueue-4; i++) {
			q.dequeue();
			q.print();
		}
		for (int i = 0; i < sizeOfQueue; i++) {
			q.enqueue(i+20);
			q.print();
		}
	}
	
}
