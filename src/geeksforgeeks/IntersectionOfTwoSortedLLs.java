/**
 * Program to find intersection of 2 sorted linked lists.
 * Approach: Take 2 lists and traverse them and compare each node with the other lists node.
 * If at any place the node values are same, then put it in the new list and increment pointers of all 3 lists.
 * Then if pointer to list1 is smaller than pointer to list 2 then increment pointer 1 else increment pointer 2.
 * Finally you get the common elements in a new linked list.
 * */
package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class IntersectionOfTwoSortedLLs {

	public static Node IntersectionOfTwoSortedLLs(Node head1, Node head2) {
		if (head1 == null || head2 == null) {
			System.out.println("One of the given Linked Lists is empty!!!");
			return null;
		} else {
			Node trav1 = head1;
			Node trav2 = head2;
			Node newListTrav = null;
			Node newHead=null;
			while (trav1 != null && trav2 != null) {
				if (trav1.getVal() == trav2.getVal()) {
					if (newListTrav == null) {
						newListTrav = new Node(trav1.getVal());
						newHead=newListTrav;
					} else {
						newListTrav.setNext(new Node(trav1.getVal()));
						newListTrav=newListTrav.getNext();
					}
					trav1=trav1.getNext();
					trav2=trav2.getNext();
				} else if(trav1.getVal()<trav2.getVal()) {
					trav1=trav1.getNext();
				} else trav2=trav2.getNext();
			}
			return newHead;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		int len1 = 3;
		for (int i = 0; i < len1; i++) {
			sll1.insertAtLast(i + 10);
		}

		SinglyLinkedList sll2 = new SinglyLinkedList();
		int len2 = 5;
		for (int i = 0; i <len2; i++) {
			sll2.insertAtLast(i + 10);
		}
		SinglyLinkedList newList= new SinglyLinkedList();
		newList.setHead(IntersectionOfTwoSortedLLs(sll1.getHead(), sll2.getHead()));
		newList.print(newList.getHead());
		
	}

}
