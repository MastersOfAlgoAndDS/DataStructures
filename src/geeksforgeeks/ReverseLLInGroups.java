/**
 * Reverse a Linked List in groups of given size
 * http://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 * 
 * Approach:
 * Keep traversing the list while traversal element is not null and putting the elements one by one on the new top of new list called worker list.
 * Now keep also keep counting the counter value till it reaches given value of k.
 * Once it reaches given value of k, append the worker list to the end of the final answer list to be returned.
 * after the while loop is over then append the worker list to the end of the new list. 
 * */
package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class ReverseLLInGroups {

	public static SinglyLinkedList ReverseLLInGroups(Node head, int k) {
		if (head == null) {
			return null;
		} else {
			int cnt = 1;
			Node trav = head;
			SinglyLinkedList workerList = new SinglyLinkedList();
			SinglyLinkedList finalList = new SinglyLinkedList();
			Node finalListTrav = null;
			while (trav != null) {
				while (cnt <= k && trav!=null) { // Reverse the list elements until the
									// counter reaches k value.
					workerList.insertAtFirst(trav.getVal());
					trav=trav.getNext();
					cnt++;
				}
				
				// if the final list is empty initialize it
				// else simple point the end of the final list to head of worker
				// list
				if (finalList.getHead() == null && workerList.getHead() != null) {
					finalList.setHead(workerList.getHead());
					finalListTrav = finalList.getHead();
				} else {
					finalListTrav.setNext(workerList.getHead());
				}

				// traverse the final list to keep the finalListTrav pointer
				// always to the end of the list.
				while (finalListTrav.getNext() != null) {
					finalListTrav = finalListTrav.getNext();
				}
				//reinitialize cnt to 1 to begin next group reversal.
				//reinitialize workerList to new SinglyLinkedList for next group traversal.
				cnt=1;
				workerList = new SinglyLinkedList();

			}			
			return finalList;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList sll1 = new SinglyLinkedList();
		int len1 = 27;
		for (int i = 0; i < len1; i++) {
			sll1.insertAtLast(i + 10);
		}
		SinglyLinkedList finalList = ReverseLLInGroups(sll1.getHead(),4);
		finalList.print(finalList.getHead());
	}

}
