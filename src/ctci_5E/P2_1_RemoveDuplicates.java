package ctci_5E;

import java.util.HashSet;
import java.util.Set;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * @Problem_2_1 Write code to remove duplicates from an unsorted linked list.
 * 
 *              FOLLOW UP
 * 
 *              How would you solve this problem if a temporary buffer is not
 *              allowed?
 * 
 * @author Milind
 *
 */
public class P2_1_RemoveDuplicates {

	public static void main(String[] args) {
		P2_1_RemoveDuplicates s = new P2_1_RemoveDuplicates();
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertAtLast(3);
		ll.insertAtLast(5);
		ll.insertAtLast(4);
		ll.insertAtLast(3);
		ll.print(ll.getHead());
		s.removeDuplicates(ll);
		ll.print(ll.getHead());
	}

	/**
	 * @Solution: Using a set.
	 * @Runtime: O(n)
	 * @Space: O(n)
	 * 
	 * @param ll
	 */
	private void removeDuplicates(SinglyLinkedList ll) {
		Set<Integer> unique = new HashSet<Integer>();
		for (Node node = ll.getHead(); node != null; node = node.getNext()) {
			if (unique.contains(node.getVal()))
				ll.delete(node);
			else
				unique.add(node.getVal());
		}
	}
}
