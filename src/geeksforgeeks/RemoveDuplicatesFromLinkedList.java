/**
 * Program to remove duplicate elements from the linked list.
 * Traverse the list and keep putting the elements in the hashmap.
 * 
 * */
package geeksforgeeks;

import java.util.HashMap;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class RemoveDuplicatesFromLinkedList {

	public static void RemoveDuplicatesFromLinkedList(Node head) {
		if (head == null) {
			System.out.println("LL is empty!!!");
		} else {
			HashMap<Integer, Node> hash = new HashMap<Integer, Node>();
			Node trav = head;
			Node prev = null;
			while (trav != null) {
				Node check = null;
				if (hash.get(trav.getVal()) != null)
					check = (Node) hash.get(trav.getVal());
				if (check == null) {
					hash.put(trav.getVal(), trav);
					prev=trav;
				} else {
					prev.setNext(trav.getNext());
				}
				trav = trav.getNext();
			}
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		int len = 7;
		for (int i = len-1; i >=0; i--) {
			sll.insertAtLast(i + 10);
			sll.insertAtLast(i + 10);
		}
		sll.insertAtLast(11);
		sll.insertAtPosition(14, 9);
		sll.print(sll.getHead());
		RemoveDuplicatesFromLinkedList(sll.getHead());
		sll.print(sll.getHead());
	}

}
