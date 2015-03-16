/**
 * http://www.geeksforgeeks.org/write-a-c-function-to-print-the-middle-of-the-linked-list/
 * Two pointers one slow and one fast. 
 * When the fast pointer reaches the end of the list the slow pointer reaches the middle of the list.
 * */

package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class PrintMiddleOfLinkedList {

	public static void PrintMiddleOfLinkedList(Node head) {
		Node slow = head;
		Node fast = head;
		if (head == null) {
			System.out.println("LinkedList is null. There is no linked list");
		} else {
			while (fast != null && fast.getNext() != null) {
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			System.out.println(slow.getVal());
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		int len = 7;
		for (int i = 0; i < len; i++) {
			sll.insertAtLast(i + 10);
		}
		PrintMiddleOfLinkedList(sll.getHead());
	}
}
