/**
 * Problem 7.3 : Let h1 and h2 be the heads of lists L1 and L2, respectively. Assume
 * that L1 and L2 are well-formed, that is each consists of a finite sequence of nodes. (In
 * particular, neither list has a cycle.) How would you determine if there exists a node r 
 * reachable from both h1 and h2 by following the next fields? If such a node exists,
 * find the node that appears earliest when traversing the lists. You are constrained to
 * use no more than constant additional storage.
 * 
 * Solution 1: Keep a hashmap of all the visited nodes by 1 and then 
 * see if any node in 2 has any of the nodes visited in 1.
 * O(n) space
 * O(n) time
 * 
 * Solution 2: 
 * Another approach would be to have an attribute for node which will mark the node as visited.
 * This will give the solution even in less than O(n) time. But an attribute is 
 * increased in all the nodes, thus increasing space by O(n).
 * O(n) space
 * O(n) time
 * 
 * 
 * Solution 3:
 * Naive approach is to have two for loops one inside other. And traverse one list and check for each node, whether it exists 
 * in the the second list by traversing the second list. So O(n^2) times.
 * O(1) space
 * O(n) time
 * 
 * 
 * Solution 4: BEST!!
 * find list lengths and difference.
 * Traverse the longer list by the difference first. Then traverse both the lists together 
 * at same time and check for same nodes. If found then return answer if not found then 
 * return null and so no overlap.
 * 
 * */

package EPI;

import com.ds.Node;
import com.ds.Utilities;

public class Problem_7_3_LLOverlap {

	public Node detectOverlapStart(Node head1, Node head2) {
		// if any of the lists is blank - No overlap.
		if (head1 == null || head2 == null)
			return null;

		// find the length of both lists and the difference.
		int len1 = Utilities.getListLength(head1);
		int len2 = Utilities.getListLength(head2);
		int diff = Math.abs(len1 - len2);
		Node trav1 = head1, trav2 = head2;

		// traverse the longer list by difference first and then continue to
		// traverse them together.
		if (len1 > len2) {
			while (diff != 0) {
				trav1 = trav1.getNext();
				diff--;
			}
		} else if (len2 > len1) {
			while (diff != 0) {
				trav2 = trav2.getNext();
				diff--;
			}
		}

		while (trav1 != trav2 && trav1 != null && trav2 != null) {
			trav1 = trav1.getNext();
			trav2 = trav2.getNext();
		}

		if (trav1 == trav2)
			return trav1;
		return null;
	}

	public static void main(String[] args) {
		Node temp;
		Node head1 = new Node(20);
		Node head2 = new Node(10);
		head1.setNext(new Node(23));
		temp = head1.getNext();
		temp.setNext(new Node(130));
		temp = temp.getNext();
		temp.setNext(new Node(132));
		temp = temp.getNext();
		Node start = new Node(28);
		temp.setNext(start);
		temp = temp.getNext();
		temp.setNext(new Node(30));
		temp = temp.getNext();
		temp.setNext(new Node(32));
		temp = temp.getNext();
		temp.setNext(new Node(35));
		temp = temp.getNext();
		temp.setNext(new Node(38));
		temp = temp.getNext();
		temp.setNext(new Node(33));
		temp = temp.getNext();
		temp.setNext(new Node(40));
		head2.setNext(start);
		head1.printNode();
		head2.printNode();

		Problem_7_3_LLOverlap p = new Problem_7_3_LLOverlap();
		Node result = p.detectOverlapStart(head1, head2);
		System.out.println(result == null ? null : result.getVal());

	}

}
