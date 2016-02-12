package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * 
 * @Problem_2_3 Implement an algorithm to delete a node in the middle of a
 *              singly linked list, given only access to that node.
 * 
 *              EXAMPLE
 * 
 *              Input: the node c from the linked list a->b->c->d->e
 * 
 *              Result: nothing is returned, but the new linked list looks like
 *              a- >b- >d->e
 * 
 * 
 * @author Milind
 *
 */
public class P2_3_DeleteFromMiddle {

	public static void main(String[] args) {
		P2_3_DeleteFromMiddle s = new P2_3_DeleteFromMiddle();
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertAtLast(3);
		ll.insertAtLast(5);
		ll.insertAtLast(4);
		ll.insertAtLast(3);
		ll.print(ll.getHead());
		s.delete(ll, 5);
		ll.print(ll.getHead());
	}

	private void delete(SinglyLinkedList ll, int i) {
		Node temp = ll.getHead();
		Node prev = null;
		while (temp != null) {
			if (temp.getVal() == i) {
				if (temp.getNext() != null)
					ll.delete(temp);
				else {
					prev.setNext(temp.getNext());
					temp = null;
				}
			}
			prev = temp;
			temp = temp.getNext();
		}
	}

}
