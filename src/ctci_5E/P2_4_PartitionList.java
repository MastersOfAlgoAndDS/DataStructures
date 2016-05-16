package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * @Problem_2_4 Write code to partition a linked list around a value x, such
 *              that all nodes less than x come before all nodes greater than or
 *              equal to x.
 * 
 * @Solution: Make 3 lists - for less than, equal to and greater than elements
 *            and later join these 3 lists in order. Make each of these lists
 *            using a pointer and keep adding new elements to their head.
 * 
 * @Runtime: O(n)
 *
 * 
 * @author Milind
 *
 */
public class P2_4_PartitionList {

	public static void main(String[] args) {
		P2_4_PartitionList s = new P2_4_PartitionList();
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertAtLast(13);
		ll.insertAtLast(5);
		ll.insertAtLast(4);
		ll.insertAtLast(13);
		ll.insertAtLast(3);
		ll.insertAtLast(2);
		ll.insertAtLast(1);
		ll.insertAtLast(56);
		ll.print(ll.getHead());
		s.partition(ll, 4);
		ll.print(ll.getHead());
	}

	/**
	 * Runtime: O(n)
	 * 
	 * 
	 * @param ll
	 * @param i
	 */
	private void partition(SinglyLinkedList ll, int i) {
		// make list 1 of smaller elements
		SinglyLinkedList llSmall = new SinglyLinkedList();

		// make another list of equal value or greater elements
		SinglyLinkedList llLarge = new SinglyLinkedList();
		// make another list of equal value or greater elements
		SinglyLinkedList llEqual = new SinglyLinkedList();

		// and then join these three formed lists.
		Node trav = ll.getHead();
		Node prev = null;
		while (trav != null) {
			if (trav.getVal() < i) {
				Node temp = llSmall.getHead();
				Node item = trav;
				trav = trav.getNext();
				item.setNext(temp);
				llSmall.setHead(item);
			} else if (trav.getVal() > i) {
				Node temp = llLarge.getHead();
				Node item = trav;
				trav = trav.getNext();
				item.setNext(temp);
				llLarge.setHead(item);
			} else {
				Node temp = llEqual.getHead();
				Node item = trav;
				trav = trav.getNext();
				item.setNext(temp);
				llEqual.setHead(item);
			}
		}
		ll.setHead(llSmall.getHead());
		Node tail = ll.getHead();
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(llEqual.getHead());
		while (tail.getNext() != null) {
			tail = tail.getNext();
		}
		tail.setNext(llLarge.getHead());
	}
}
