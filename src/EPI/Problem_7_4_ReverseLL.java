/**
 * Problem 7.4 : Give a linear time non-recursive function that reverses a singly linked
 * list. The function should use no more than constant storage beyond that needed for
 * the list itself.
 * 
 * 
 * 
 * 
 * */

package EPI;

import com.ds.Node;

public class Problem_7_4_ReverseLL {

	public Node reverseLL(Node head) {
		if (head == null)
			return null;

		Node trav = head, next = head;
		Node prev = null;
		while (next != null) {
			next = trav.getNext();
			trav.setNext(prev);
			prev = trav;
			trav = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Node ll = new Node(20);
		Node trav = ll;
		for (int i = 0; i <= 5; i++) {
			trav.setNext(new Node((int) Math.ceil((Math.random() * 10))));
			trav = trav.getNext();
		}
		ll.printNode();
		
		Problem_7_4_ReverseLL p = new Problem_7_4_ReverseLL();
		p.reverseLL(ll).printNode();
		
		ll.printNode();
	}

}
