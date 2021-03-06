package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * 
 * @Problem_2_2 Implement an algorithm to find the kth to last element of a
 *              singly linked list.
 * 
 * @Solution: We can use two pointers, move first one k times from start and
 *            second one at head. Then move both the pointers forward untill the
 *            first one reaches end. Automatically the second one is k elements
 *            from the last of the linked list.
 * 
 * @Runtime: O(n)
 * 
 * 
 * @author Milind
 *
 */
public class P2_2_KthToLastElement {

	public static void main(String[] args) {
		P2_2_KthToLastElement s = new P2_2_KthToLastElement();
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertAtLast(3);
		ll.insertAtLast(5);
		ll.insertAtLast(4);
		ll.insertAtLast(3);
		ll.print(ll.getHead());
		Node elem = s.kthToLastElement(ll, 2);
		if (elem != null) {
			System.out.println(elem.getVal());
		}
	}

	/**
	 * O(n)
	 * 
	 * @param ll
	 * @param k
	 * @return
	 */
	private Node kthToLastElement(SinglyLinkedList ll, int k) {
		if (ll != null && ll.getHead() != null) {
			Node temp = ll.getHead();
			Node prev = temp;
			while (k > 0 && temp != null) {
				temp = temp.getNext();
				k--;
			}
			while (temp != null) {
				temp = temp.getNext();
				prev = prev.getNext();
			}
			return prev;
		}
		return null;
	}
}
