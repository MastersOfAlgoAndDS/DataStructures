package com.ds;

public class Node {
	private int val;
	private Node next;

	public Node(int value) {
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

	@Override
	public String toString() {
		return "Node [val=" + val + ", next="
				+ (next == null ? null : next.getVal()) + "]";
	}

	public void printNode() {
		Node trav = this;
		System.out.print("head");
		while (trav != null) {
			System.out.print("->" + trav.getVal());
			trav = trav.getNext();
		}
		System.out.println();
	}

}
