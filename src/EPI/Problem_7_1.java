/**
 * Problem 7.1 : Write a function that takes L and F, and returns the merge of L and F. 
 * Your code should use O(1) additional storage—it should reuse the nodes from 
 * the lists provided as input. Your function should use O(1) additional storage, as 
 * illustrated in Figure 7.3. The only field you can change in a node is next.
 * 
 * */

package EPI;

import java.util.LinkedList;

import com.ds.Node;

public class Problem_7_1 {

	public Node mergeLL(Node l_head, Node f_head) {
		Node new_head = null;
		Node new_trav = null;

		if (l_head == null)
			return f_head;

		if (f_head == null)
			return l_head;

		if (l_head != null && f_head != null) {
			if (l_head.getVal() <= f_head.getVal()) {
				new_head = l_head;
				l_head = l_head.getNext();
			} else {
				new_head = f_head;
				f_head = f_head.getNext();
			}
			new_head.setNext(new_trav);
			new_trav = new_head;
		}

		while (l_head != null && f_head != null) {
			if (l_head.getVal() <= f_head.getVal()) {
				new_trav.setNext(l_head);
				l_head = l_head.getNext();
			} else {
				new_trav.setNext(f_head);
				f_head = f_head.getNext();
			}
			new_trav = new_trav.getNext();
		}

		if (l_head != null) {
			new_trav.setNext(l_head);
		}
		if (f_head != null) {
			new_trav.setNext(f_head);
		}
		return new_head;
	}

	public static void main(String[] args) {
		Node l_head = new Node(2);
		l_head.setNext(new Node(5));
		l_head.getNext().setNext(new Node(7));

		Node f_head = new Node(3);
		f_head.setNext(new Node(11));

		l_head.printNode();
		f_head.printNode();
		Problem_7_1 p = new Problem_7_1();
		Node new_ll = p.mergeLL(l_head, f_head);
		new_ll.printNode();
	}

}
