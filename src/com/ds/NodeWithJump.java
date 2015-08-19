package com.ds;

public class NodeWithJump {
	private int val;
	private NodeWithJump next;
	private NodeWithJump jump;

	public NodeWithJump(int value) {
		val = value;
		next = null;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int value) {
		this.val = value;
	}

	public NodeWithJump getNext() {
		return next;
	}

	public void setNext(NodeWithJump next) {
		this.next = next;
	}

	public NodeWithJump getJump() {
		return jump;
	}

	public void setJump(NodeWithJump jump) {
		this.jump = jump;
	}

	public void printNodeWithJump() {
		NodeWithJump trav = this;
		System.out.print("head");
		while (trav != null) {
			System.out.print("->" + trav.getVal());
			trav = trav.getNext();
		}
		System.out.println();
		System.out.print("head");
		trav = this;
		while (trav != null) {
			NodeWithJump jumper = trav.getJump();
			System.out.print("-> [" + trav.getVal() + " jumpto-> "
					+ (jumper == null ? null : jumper.getVal()) + "] ");
			trav = trav.getNext();
		}
		System.out.println();
	}

}
