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
 * @Solution: Here the trick - if the current element is to be deleted, then
 *            copy the next element value into current element and delete the
 *            next element.
 * 
 * @Runtime: Constant, O(1) since it does not depend on the size of the linked
 *           list.
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

	/**
	 * O(n) because we need to traverse and get the pointer to the element to be
	 * deleted. But if the pointer is known then it should be constant time.
	 * 
	 * @param ll
	 * @param i
	 */
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
