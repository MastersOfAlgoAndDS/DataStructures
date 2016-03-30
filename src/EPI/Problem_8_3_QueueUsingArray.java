/**
 * Problem 8.3, pg. 58:	
 * 			Implement a queue API using an array for storing elements. Your
 *			API should include a constructor function, which takes as argument the capacity of the queue,
 *			enqueue and dequeue functions, a size function, which returns the number of elements
 * 			stored, and implement dynamic resizing.
 * 
 * Solution: 
 * 	Here the trick is not to use the condition that front should always be less than rear.
 * 	Anyone can be anywhere. Play with % operator for that.
 * 	Always keep track of number of elements using elemCount variable
 * 	
 * 	Dynamic resizing is important!!! For that you better make a new queue object and then copy all 
 *  dequeue all the elements present in old queue to new queue and then replace all attributes of 
 *  old queue with the new queue properties. Then you're done correctly. 
 * 	
 * 
 * 
 * 
 * 
 * 
 * */

package EPI;

import java.util.Arrays;

public class Problem_8_3_QueueUsingArray {

	int[] array;
	int capacity;
	int front;
	int rear;
	int elemCount;

	public Problem_8_3_QueueUsingArray(int capacity) {
		this.capacity = capacity;
		this.array = new int[this.capacity];
		this.front = this.rear = -1;
		this.elemCount = 0;
	}

	public void enqueue(int element) {
		if (elemCount < capacity) {
			rear = (rear + 1) % capacity;
			array[rear] = element;
			elemCount += 1;
		} else {
			// System.out.println("queue is full!");

			Problem_8_3_QueueUsingArray tempQueue = new Problem_8_3_QueueUsingArray(
					capacity * 2);
			int i = 0;
			while (!isEmpty())
				tempQueue.enqueue(dequeue());
			this.array = tempQueue.array;
			this.capacity = tempQueue.capacity;
			this.rear = tempQueue.rear;
			this.front = tempQueue.front;
			this.elemCount = tempQueue.elemCount;
			tempQueue = null;
			enqueue(element);
		}
	}

	public int dequeue() {
		if (elemCount > 0) {
			elemCount--;
			front = (front + 1) % capacity;
			return array[front];
		} else
			System.out.println("queue is empty!");
		return -999;
	}

	public int size() {
		return elemCount;
	}

	@Override
	public String toString() {
		return "Problem_8_3_QueueUsingArray [array=" + Arrays.toString(array)
				+ ", capacity=" + capacity + ", front=" + front + ", rear="
				+ rear + ", elemCount=" + elemCount + "]";
	}

	public boolean isEmpty() {
		if (elemCount == 0)
			return true;
		return false;
	}

	public boolean isFull() {
		if (elemCount == capacity)
			return true;
		return false;
	}

	public static void main(String[] args) {
		Problem_8_3_QueueUsingArray queue = new Problem_8_3_QueueUsingArray(5);
		int temp;
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		queue.enqueue(6);
		queue.enqueue(7);
		queue.enqueue(8);
		queue.enqueue(9);
		queue.enqueue(10);
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		queue.enqueue(11);
		temp = queue.dequeue();
		if (temp != -999)
			System.out.println(temp + " removed");
		// temp = queue.dequeue();
		// if (temp != -999)
		// System.out.println(temp + " removed");
		queue.enqueue(12);
		queue.enqueue(13);
		queue.enqueue(14);
		queue.enqueue(15);
		queue.enqueue(16);
		queue.enqueue(17);
		queue.enqueue(18);
		queue.enqueue(19);
		queue.enqueue(20);
		queue.enqueue(21);
		queue.enqueue(22);
		System.out.println(queue);
	}

}
