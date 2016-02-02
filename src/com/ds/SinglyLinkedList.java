package com.ds;

public class SinglyLinkedList {
	Node head;

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public SinglyLinkedList() {
		head = null;
	}

	@Override
	public String toString() {
		return "SinglyLinkedList [head=" + head + "]";
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

	public int length(Node head) {
		Node temp = head;
		int count = 0;
		while (temp != null) {
			temp = temp.getNext();
			count++;
		}
		return count;
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
			System.out.print(temp.getVal() + " ");
			temp = temp.getNext();
		}
		System.out.println();
	}

	// This is recursive method for printing the list in reverse order
	public void printReverse(Node head) {
		if (head == null)
			return;
		else {
			printReverse(head.getNext());
			System.out.print(head.getVal() + " ");
		}
	}

	public void delete(int i) {
		Node temp = head;
		Node prev = null;
		while (temp != null) {
			if (temp.getVal() == i) {
				if (temp.getNext() != null)
					delete(temp);
				else {
					prev.setNext(temp.getNext());
					temp = null;
				}
			}
			prev = temp;
			temp = temp.getNext();
		}
	}

	public void delete(Node node) {
		Node nodeNext = node.getNext();
		if (nodeNext != null) {
			node.setVal(nodeNext.getVal());
			node.setNext(nodeNext.getNext());
			nodeNext = null;
		} else if (node == head) {
			head = null;
		} else {
			Node temp = head;
			Node prev = null;
			while (temp != node) {
				prev = temp;
				temp = temp.getNext();
			}
			prev.setNext(temp.getNext());
			temp = null;
		}
	}

	public void deleteFromLast() {
		Node temp = head;
		if (temp == null)
			System.out.println("List is empty");
		if (temp != null) {

		}
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
				prev = temp;
				temp = next;
			}
			head = prev;
			this.head = prev;
		}
		return head;
	}

	public Node reverseWithRecursion(Node node) { // IMPORTANT function to check
		Node first = node;
		Node rest = node.getNext();
		Node returnedNode;
		if (rest == null) {
			this.head = first;
			return first;
		} else {

			returnedNode = reverseWithRecursion(rest);
		}

		if (returnedNode != null) {
			returnedNode.setNext(first);
			first.setNext(null);
		}
		return first;
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtLast(1);
		sll.insertAtLast(2);
		sll.insertAtLast(3);
		/*
		 * sll.insertAtFirst(14); sll.insertAtLast(5); sll.insertAtFirst(13);
		 */sll.insertAtLast(4);
		/*
		 * sll.insertAfterElement(24, 13); sll.insertAtPosition(99, 2);
		 */
		System.out.println("Length of list is: " + sll.length(sll.getHead()));
		System.out.println("Print LinkList");
		sll.print(sll.getHead());
		/*
		 * System.out.println("Reversing the list and print"); Node newHead =
		 * sll.reverseInPlaceIterative(sll.getHead()); sll.print(sll.getHead());
		 * System.out
		 * .println("Print LinkList in reverse order of the current order");
		 */sll.printReverse(sll.getHead());
		System.out.println();

		System.out.println("Reversing the list with recursion and print ");
		sll.reverseWithRecursion(sll.getHead());
		sll.print(sll.getHead());

	}

}
