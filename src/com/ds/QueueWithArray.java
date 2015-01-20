/**
 * 
 */
package com.ds;

/**
 * @author Milind
 *
 */
public class QueueWithArray {
	int head;
	int tail;
	int queue[];
	int length;
	/**
	 * 
	 */
	public QueueWithArray(int len) {
		head = 0;
		tail = 0;
		length = len;
		queue = new int[(len+1)];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private void enqueue(QueueWithArray q, int x){
		q.queue[q.tail] = x;
		if (q.tail == q.length)
			q.tail = 0;
		q.tail = q.tail + 1;
	}
	
	private int dequeue(QueueWithArray q){
		int x = q.queue[q.head];
		if (q.head==q.length)
			q.head = 0;
		else
			q.head = q.head + 1;
		return x;
	}
	
	private boolean empty(QueueWithArray q){
		if(q.head==q.tail)
			return true;
		return false;
	}
	
	private boolean full(QueueWithArray q){
		if ((q.tail == q.head - 1) || ((q.tail == q.length) && (q.head != 0)))
			return true;
		return false;
	}
}
