package com.ds;

public class Node {
	int val;
	Node next;
	
	Node(int value){
		val = value;
		next = null;
	}
	
	public int getVal() {
		return val;
	}
	public void setVal(int value) {
		this.val = value;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	
	
}
