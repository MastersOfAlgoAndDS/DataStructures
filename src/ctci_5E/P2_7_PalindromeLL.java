package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * 
 * @Problem_2_7 Implement a function to check if a linked list is a palindrome
 * 
 * @Solution: 1.Reverse the list and compare 2 lists node by node. runtime: O(n)
 *            space: O(n)
 * 
 *            2. Use stack runtime: O(n) and space: O(n). Here the tricky thing
 *            is to know the middle of the list. For this use the 2 pointers
 *            approach fast and slow to get to till the middle of the list.
 * 
 * @author Milind
 *
 */
public class P2_7_PalindromeLL {

	/**
	 * Using Reverse and compare
	 * 
	 * Runtime: O(n)
	 * 
	 * Space: O(n)
	 * 
	 * @param ll
	 * @return
	 */
	public static boolean checkPalindrome(SinglyLinkedList ll) {
		SinglyLinkedList reverseList = new SinglyLinkedList();
		Node iter1 = ll.getHead();
		while (iter1 != null) {
			Node node = new Node(iter1.getVal());
			node.setNext(reverseList.getHead());
			reverseList.setHead(node);
			iter1 = iter1.getNext();
		}
		// reverseList.print(reverseList.getHead());
		iter1 = ll.getHead();
		Node iter2 = reverseList.getHead();
		while (iter1 != null && iter2 != null) {
			if (iter1.getVal() != iter2.getVal()) {
				return false;
			}
			iter1 = iter1.getNext();
			iter2 = iter2.getNext();
		}
		return true;
	}

	public static void main(String[] args) {
		SinglyLinkedList ll = new SinglyLinkedList();
		Node n = new Node(0);
		ll.setHead(n);
		n = new Node(1);
		n.setNext(ll.getHead());
		ll.setHead(n);
		n = new Node(2);
		n.setNext(ll.getHead());
		ll.setHead(n);
		n = new Node(1);
		n.setNext(ll.getHead());
		ll.setHead(n);
		n = new Node(0);
		n.setNext(ll.getHead());
		ll.setHead(n);
		ll.print(ll.getHead());
		System.out.println(checkPalindrome(ll));

		ll = new SinglyLinkedList();
		n = new Node(0);
		ll.setHead(n);
		n = new Node(1);
		n.setNext(ll.getHead());
		ll.setHead(n);
		n = new Node(2);
		n.setNext(ll.getHead());
		ll.setHead(n);
		n = new Node(1);
		n.setNext(ll.getHead());
		ll.setHead(n);
		ll.print(ll.getHead());
		System.out.println(checkPalindrome(ll));

	}

}
