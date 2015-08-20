/**
 * Problem 7.5 : Implement a function which takes as input a pointer to the head of a
 * postings list L, and returns a copy of the postings list. Your function should take O(n)
 * time, where n is the length of the postings list and should use O(1) storage beyond
 * that required for the n nodes in the copy. You can modify the original list, but must
 * restore it to its initial state before returning.
 * 
 * This problem is also called deep copy of a linkedList. 
 * Here the postings list is being called linkedlist.
 * 
 * Solution:
 * BEST Solution in 3 steps step-by-step.
 * Step 1: 	Start preparing a new list and copy all the nodes and make their next pointers to 
 * 			the next pointers of corresponding node in original list. 
 * 			Also then change all the nodes to point to their corresponding node on new list 
 * 			as their next node.
 * 			i.e. newNode->Next = oldNode->Next and then oldNode->Next = newNode  
 * Step 2: 	Create the jumper pointers on newNode.
 * 			You will get the pointers from the oldNode->Jumper.
 * 			i.e. newNode->Jumper = oldNode->Jumper->Next.
 * Step 3: 	Again change back the newList's pointers and then oldList's pointers to their places.
 * 			i.e. node->Next = node->Next->Next since now there is a zipzag arrangement of nodes.
 * 				 
 * */

package EPI;

import com.ds.NodeWithJump;

public class Problem_7_5_DeepCopy_LL {

	public NodeWithJump deepCopy(NodeWithJump head) {
		if (head == null)
			return null;
		// Step 1
		NodeWithJump trav = head;
		NodeWithJump newTrav = new NodeWithJump(head.getVal());
		NodeWithJump newHead = newTrav;
		newTrav.setNext(head.getNext());
		head.setNext(newTrav);
		trav = newTrav.getNext();
		while (trav != null) {
			newTrav = new NodeWithJump(trav.getVal());
			newTrav.setNext(trav.getNext());
			trav.setNext(newTrav);
			trav = newTrav.getNext();
		}

		// Step 2
		trav = head;
		while (trav != null && trav.getNext() != null) {
			trav.getNext().setJump(trav.getJump().getNext());
			trav = trav.getNext().getNext();
		}

		trav = head;
		while (trav != null && trav.getNext() != null
				&& trav.getNext().getNext() != null) {
			newTrav = trav.getNext();
			trav.setNext(newTrav.getNext());
			newTrav.setNext(trav.getNext().getNext());
			trav = trav.getNext();
		}

		// fix the last node of the old list.
		newTrav = trav.getNext();
		trav.setNext(newTrav.getNext());

		return newHead;
	}

	public static void main(String[] args) {
		NodeWithJump ll = new NodeWithJump(20);
		NodeWithJump trav = ll;
		for (int i = 0; i <= 2; i++) {
			trav.setNext(new NodeWithJump((int) Math.ceil(Math.random() * 100)));
			trav = trav.getNext();
		}
		ll.printNodeWithJump();
		System.out.println();
		ll.setJump(ll.getNext().getNext());
		ll.getNext().setJump(ll.getNext().getNext().getNext());
		ll.getNext().getNext().setJump(ll.getNext());
		ll.getNext().getNext().getNext()
				.setJump(ll.getNext().getNext().getNext());
		ll.printNodeWithJump();

		Problem_7_5_DeepCopy_LL p = new Problem_7_5_DeepCopy_LL();
		NodeWithJump newLL = p.deepCopy(ll);
		ll.printNodeWithJump();
		newLL.printNodeWithJump();
	}

}
