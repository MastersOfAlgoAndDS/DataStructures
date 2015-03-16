/**
 * 
 * To detect whether the elements of the given linked list are palindrome or not.
 * For this we can have many methods. 
 * We go with a O(n) method with a single pass which is most efficient.
 * So we use the logic of going to the middle element. 
 * Fast pointer will reach the end of list and slow pointer will reach the middle.
 * So slow pointer will also be pushed on the stack.
 * After reaching middle, we will pop the element and keep comparing with the remaining list.
 * 
 * */

package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class PalindromeLL {

	public static boolean PalindromeLL(Node head) {
		if (head == null) {
			System.out.println("There is no linked list. Empty!!!");
		} else {
			StackUsingLL stack = new StackUsingLL();
			Node slow = head;
			Node fast = head;
			// Reach till middle of the list and keep pushing the elements to
			// stack.
			while (fast != null && fast.getNext() != null) {
				stack.push(slow.getVal());
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}
			// Then check whether list is even or odd.
			// if fast==null that means list is odd.
			// if fast.getNext == null that means linked list has odd elements.
			if(fast==null){}	//Even elements
			else if (fast.getNext() == null)	//Odd elements.
				slow=slow.getNext();
			//if the elements are odd 
			//then the slow pointer is exactly at the middle 
			//so increment slow pointer to next element for comparing with stack.
			
			
			while (slow != null) {
				if (slow.getVal() != stack.peek()) {
					return false;
				}
				slow = slow.getNext();
				stack.pop();
			}
		}
		return true;
	}

	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		int len = 4;
		for (int i = 0; i < len; i++) {
			sll.insertAtLast(i + 10);
		}
		for (int i = len; i >= 0; i--) {
			sll.insertAtLast(i + 10);
		}
		//sll.insertAtLast(123);
		System.out.println(PalindromeLL(sll.getHead()));
	}

}
