package com.ds;

public class SinglyLinkedList {
	Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	SinglyLinkedList() {
		head = null;
	}

	public void insertAtLast(int value) {
		Node node = new Node(value);
		Node temp = head;
		if (head == null)
			head = node;
		else {
			while (temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
		}
		print(head);
	}

	public void insertAtFirst(int value) {
		Node node = new Node(value);
		Node temp = head;
		if (head == null)
			head = node;
		else {
			node.setNext(head);
			head = node;
		}
		print(head);
	}

	public void insertAfterElement(int value, int element) {
		Node node = new Node(value);
		Node temp = head;

		if (temp == null)
			System.out.println("List is empty");
		else {
			while (temp != null) {
				if (temp.getVal() == element) {
					node.setNext(temp.getNext());
					temp.setNext(node);
				}
				temp = temp.getNext();

			}
		}
		print(head);
	}

	public void insertAtPosition(int value, int position) {
		Node node = new Node(value);
		Node temp = head;
		int cnt = 1;
		if (position == 1)
			insertAtFirst(value);
		else {
			while (temp != null) {
				if (cnt == position - 1) {

					node.setNext(temp.getNext());
					temp.setNext(node);
				}
				temp = temp.getNext();
				cnt++;

			}
		}
		print(head);
	}

	public void print(Node head) {
		Node temp = head;
		if (temp == null)
			System.out.println("List is empty");
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	public void deleteFromLast() {
		Node temp = head;
		if (temp == null)
			System.out.println("List is empty");
		if (temp != null) {

		}
	}

	public Node search(int value) {
		Node temp = head;
		int cnt = 1;
		if (temp == null)
			System.out.println("List is empty");
		while (temp != null) {
			if (temp.getVal() == value) {
				System.out.println("Found " + value + " at position: " + cnt);
				return temp;
			}
			cnt++;
			temp = temp.getNext();
		}

		System.out.println("Did not find the given value in the linked list");
		return null;
	}

	public Node reverseInPlaceIterative(Node head) {
		Node prev, temp, next;
		if (head == null)
			System.out.println("List is empty");
		else {
			prev = null;
			temp = head;
			while (temp != null) {
				next = temp.getNext();
				temp.setNext(prev);
				prev=temp;
				temp = next;
			}
			head = prev;
		}
		return head;
	}
	
	
/*	public Node reverseWithRecursion(Node p){
		if(pit.getNext()==null)
			return head;
		else{
			Node temp = head;
			Node prev = temp;
			Node next = reverseWithRecursion(head.getNext());
			//System.out.print(temp + " ");
			while(temp.getNext()!=null){
				temp=temp.getNext();
			}
			temp.setNext(new Node(next.val));
			return prev;
		}
	}
*/	
	public void printReverse(Node head){
		if(head.getNext()==null)
			System.out.print(head.getVal() + " ");
		else{
			int temp = head.getVal();
			
			printReverse(head.getNext());
			System.out.print(temp + " ");
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtLast(1);
		sll.insertAtLast(2);
		sll.insertAtLast(3);
/*		sll.insertAtFirst(14);
		sll.insertAtLast(5);
		sll.insertAtFirst(13);
*/		sll.insertAtLast(4);
/*		sll.insertAfterElement(24, 13);
		sll.insertAtPosition(99, 2);
*/		Node newHead = sll.reverseInPlaceIterative(sll.getHead());
		sll.print(newHead);
		//newHead = sll.reverseWithRecursion(newHead);
		sll.printReverse(newHead);
	}

}
