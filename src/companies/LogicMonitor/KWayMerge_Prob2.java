package companies.LogicMonitor;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * @author Milind
 * @Problem: Merge k sorted linked lists and return it as one sorted list.
 *           Analyze and describe its complexity.
 * 
 *           /** Definition for singly-linked list. public class ListNode { int
 *           val; ListNode next; ListNode(int x) { val = x; next=null; } }
 * 
 * @Solution: Iterate over the lists and use the merge logic of merge sort. Only
 *            tricky part is to traverse or increment list pointer of only one
 *            of the lists from which the minimum element was chosen. ALways
 *            create a new list and return in answer. Its tough to keep track of
 *            the lists later.
 * 
 * 
 */

public class KWayMerge_Prob2 {

	public static Node mergeKLists(Node[] lists) {
		int numOfLists = lists.length;
		Node[] iterators = Arrays.copyOf(lists, numOfLists);
		Node trav = null;
		Node head = null;

		// Create priority queue heap.
		PriorityQueue<Node> heap = new PriorityQueue<Node>(
				new Comparator<Node>() {
					@Override
					public int compare(Node o1, Node o2) {
						return Integer.compare(o1.getVal(), o2.getVal());
					}
				});

		// Main logic
		// Add first elements of all the lists into the heap.
		for (Node node : lists) {
			if (node != null) {
				heap.add(node);
			}
		}

		// Then while the heap is not empty, keep removing the smalles element
		// from heap and add next element from one of the lists into the heap
		while (!heap.isEmpty()) {

			// remove the minimum element from the heap and add the next element
			// from the linked list whose node was chosen as the minNode
			Node minNode = heap.remove();
			if (minNode.getNext() != null) {
				heap.add(minNode.getNext());
			}

			// Construct and maintain the answer Linked list
			if (trav == null) {
				trav = new Node(minNode.getVal());
			} else {
				trav.setNext(new Node(minNode.getVal()));
				trav = trav.getNext();
			}
			if (head == null) {
				head = trav;
			}

		}
		return head;
	}

	public static void main(String[] args) {
		// Make linkedList 1
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.insertAtLast(10);
		list1.insertAtLast(20);
		list1.insertAtLast(30);
		// Make linkedList 2
		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.insertAtLast(15);
		list2.insertAtLast(16);
		list2.insertAtLast(31);
		// Make linkedList 3
		SinglyLinkedList list3 = new SinglyLinkedList();
		list3.insertAtLast(11);
		list3.insertAtLast(12);
		list3.insertAtLast(13);

		// Make linkedList 4
		SinglyLinkedList list4 = new SinglyLinkedList();
		list4.insertAtLast(111);
		list4.insertAtLast(112);
		list4.insertAtLast(131);

		Node[] lists = new Node[4];
		lists[0] = list1.getHead();
		lists[1] = list2.getHead();
		lists[2] = list3.getHead();
		lists[3] = list4.getHead();

		System.out.println("Input Lists:");
		for (Node node : lists) {
			list1.print(node);
		}

		System.out.println("Output merged list:");
		Node resultHead = mergeKLists(lists);
		list1.print(resultHead);
	}

}
