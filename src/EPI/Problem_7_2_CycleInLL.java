/**
 * Problem 7.2 : Given a reference to the head of a singly linked list L, how would you 
 * determine whether L ends in a null or reaches a cycle of nodes? Write a function
 * that returns null if there does not exist a cycle, and the reference to the start of the
 * cycle if a cycle is present. (You do not know the length of the list in advance.)
 * 
 * 
 */

package EPI;

import com.ds.Node;

public class Problem_7_2_CycleInLL {

	public Node detectCycle(Node head) {
		Node start = null;
		if (head == null)
			return start;
		Node slow = head, fast = head;
		while (slow != null && fast != null && slow.getNext() != null
				&& fast.getNext() != null && fast.getNext().getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();

			// If slow becomes equal to fast that means there is a cycle
			if (slow == fast)
				break;
		}

		if (slow == fast) {
			// Reinit slow to head and decrease the speed of fast so that cycle
			// start can be found.
			// Both slow and fast will meet at the start and become equal.
			slow = head;
			while (slow != fast) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			start = slow; // OR start = fast;
		}
		return start;
	}

	public static void main(String[] args) {
		Node head = new Node(20);
		Node trav = head;
		Node start = null;
		for (int i = 0; i <= 20; i++) {
			trav.setNext(new Node(i + 20));
			trav = trav.getNext();
			if (i == 9) {
				start = trav;
			}
		}
		head.printNode();
		trav.setNext(start);
		//head.printNode();
		Problem_7_2_CycleInLL p = new Problem_7_2_CycleInLL();
		System.out.println((p.detectCycle(head)).getVal());
	}

}
