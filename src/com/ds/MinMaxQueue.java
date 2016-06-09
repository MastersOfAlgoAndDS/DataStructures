package com.ds;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class MinMaxQueue {

	PriorityQueue<Integer> MinQueue = new PriorityQueue<Integer>();
	PriorityQueue<Integer> MaxQueue = new PriorityQueue<Integer>(
			Collections.reverseOrder());

	void push(Integer val) {
		MinQueue.add(val);
		MaxQueue.add(val);
	}

	Integer popMin() {
		MaxQueue.remove(MinQueue.peek());
		return MinQueue.remove();
	}

	Integer popMax() {
		MinQueue.remove(MaxQueue.peek());
		return MaxQueue.remove();
	}

	int size() {
		return MinQueue.size();

	}

	@Override
	public String toString() {
		return "MinMaxQueue [MinQueue=" + MinQueue + ", MaxQueue=" + MaxQueue
				+ "]";
	}

	public static void main(String[] args) {
		MinMaxQueue queue = new MinMaxQueue();
		for (int i = 0; i < 10; i++) {
			queue.push((int) (Math.random() * 100));
		}
		System.out.println(queue);
		System.out.println(queue.popMax());
		System.out.println(queue.popMin());
		System.out.println(queue);

	}
}