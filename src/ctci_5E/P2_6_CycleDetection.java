package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * 
 * @Problem_2_6 Given a circular linked list, implement an algorithm which
 *              returns the node at the beginning of the loop.
 * 
 * 
 * @Solution: We can have two pointers slow and fast. Slow incrementing 1 node
 *            and fast incrementing 2 nodes at a time. When both nodes are
 *            equal, loop is present. When loop is detected, reset the slow
 *            pointer to the head and move both pointers one node at a time
 *            forward. When the pointers become equal, that is the start of the
 *            loop.
 * 
 * @Runtime: O(n)
 * 
 * @author Milind
 *
 */
public class P2_6_CycleDetection {

	/**
	 * 
	 * Runtime: O(n)
	 * 
	 * @param head
	 * @return
	 */
	public static Node detectLoopStart(Node head) {
		Node turtle, hare;
		turtle = hare = head;
		turtle = turtle.getNext();
		hare = hare.getNext().getNext();
		while (turtle != hare) {
			hare = hare.getNext().getNext();
			turtle = turtle.getNext();
		}

		Node temp = head;
		while (temp != turtle) {
			temp = temp.getNext();
			turtle = turtle.getNext();
		}
		System.out.println("Content of TurtleNode right now is "
				+ turtle.getVal());
		return turtle;

	}

	public static void main(String[] args) {
		// Create a new Linked list with loop
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtLast(1);
		sll.insertAtLast(44);
		sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(8);
		sll.insertAtLast(13);
		sll.insertAtLast(22);
		sll.insertAtLast(111);
		sll.insertAtLast(80);
		sll.insertAtLast(65);
		sll.insertAtLast(87);

		// setup the cycle in the linked list
		int looper = 4;
		Node loopstart = sll.getHead();

		while (loopstart.getVal() != looper) {
			loopstart = loopstart.getNext();
		}

		Node lastNode = loopstart;
		while (lastNode.getNext() != null) {
			lastNode = lastNode.getNext();
		}

		lastNode.setNext(loopstart);

		// sll.print(sll.getHead());
		// Printing the loop goes into infinite loop means our linked list with

		System.out.println("Loopstart is at this element: "
				+ detectLoopStart(sll.getHead()).getVal());

		// loop is ready.

	}

}
