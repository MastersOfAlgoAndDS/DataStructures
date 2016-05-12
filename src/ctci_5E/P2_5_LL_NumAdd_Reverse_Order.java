package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

/**
 * 
 * @Problem_2_5 You have two numbers represented by a linked list, where each
 *              node contains a single digit. The digits are stored in reverse
 *              order, such that the Ts digit is at the head of the list. Write
 *              a function that adds the two numbers and returns the sum as a
 *              linked list.
 * 
 *              EXAMPLE
 * 
 *              Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is, 617 + 295. Output:
 *              2 -> 1 -> 9.That is, 912.
 * 
 * 
 *              FOLLOW UP
 * 
 *              Suppose the digits are stored in forward order. Repeat the above
 *              problem.
 * 
 *              EXAMPLE
 * 
 *              Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is, 617 + 295. Output:
 *              9 -> 1 -> 2.That is, 912.
 * 
 * @Solution: 1. First create a linked list which stores the numbers in reverse
 *            format and then run loop simultaneously on each linkedlist to add
 *            corresponding number along with a carry on variable. At last if
 *            any of the linked lists is over run the loop over reaming of the
 *            larger list along with the carry variable and print the answer.
 * 
 *            2. Follow up - First get the numbers in the format straight. Then
 *            using the inplace reverse linkedlist logic, reverse both the
 *            numbers and then use the same solution above to get the answer.
 *            Finally reverse the answer linkedlist.
 * 
 * 
 * 
 * @author Milind
 *
 */
public class P2_5_LL_NumAdd_Reverse_Order {

	public static void main(String[] args) {
		int number1 = 61711;
		int number2 = 295;
		P2_5_LL_NumAdd_Reverse_Order s = new P2_5_LL_NumAdd_Reverse_Order();
		SinglyLinkedList num1 = s.createLLFromNumReverse(number1);
		SinglyLinkedList num2 = s.createLLFromNumReverse(number2);
		num1.print(num1.getHead());
		num2.print(num2.getHead());
		SinglyLinkedList ans = addReverse(num1, num2);
		ans.print(ans.getHead());

		// Now straight order
		SinglyLinkedList ll1 = s.createLLFromNum(number1);
		SinglyLinkedList ll2 = s.createLLFromNum(number2);
		ll1.print(ll1.getHead());
		ll2.print(ll2.getHead());
		SinglyLinkedList ans2 = addStraight(ll1, ll2);
		ans2.print(ans2.getHead());

	}

	private static SinglyLinkedList addReverse(SinglyLinkedList num1,
			SinglyLinkedList num2) {
		Node trav1 = num1.getHead();
		Node trav2 = num2.getHead();
		SinglyLinkedList ans = new SinglyLinkedList();
		Node trav3 = ans.getHead();
		int carry = 0;
		while (trav1 != null && trav2 != null) {
			int numAdd = trav1.getVal() + trav2.getVal() + carry;
			if (numAdd > 9) {
				carry = numAdd / 10;
				numAdd = numAdd % 10;
			} else {
				carry = 0;
			}
			Node item = new Node(numAdd);
			if (ans.getHead() == null) {
				trav3 = item;
				ans.setHead(trav3);
			} else {
				trav3.setNext(item);
				trav3 = trav3.getNext();
			}
			trav1 = trav1.getNext();
			trav2 = trav2.getNext();
		}
		if (trav1 != null) {
			while (trav1 != null) {
				int numAdd = trav1.getVal() + carry;
				if (numAdd > 9) {
					carry = numAdd / 10;
					numAdd = numAdd % 10;
				} else {
					carry = 0;
				}
				Node item = new Node(numAdd);
				if (ans.getHead() == null) {
					trav3 = item;
					ans.setHead(trav3);
				} else {
					trav3.setNext(item);
					trav3 = trav3.getNext();
				}
				trav1 = trav1.getNext();
			}
		}

		if (trav2 != null) {
			while (trav2 != null) {
				int numAdd = trav2.getVal() + carry;
				if (numAdd > 9) {
					carry = numAdd / 10;
					numAdd = numAdd % 10;
				} else {
					carry = 0;
				}
				Node item = new Node(numAdd);
				if (ans.getHead() == null) {
					trav3 = item;
					ans.setHead(trav3);
				} else {
					trav3.setNext(item);
					trav3 = trav3.getNext();
				}
				trav2 = trav2.getNext();
			}
		}

		return ans;
	}

	private static SinglyLinkedList addStraight(SinglyLinkedList num1,
			SinglyLinkedList num2) {
		SinglyLinkedList ans = new SinglyLinkedList();
		num1.reverseInPlaceIterative(num1.getHead());
		num2.reverseInPlaceIterative(num2.getHead());
		ans = addReverse(num1, num2);
		ans.reverseInPlaceIterative(ans.getHead());
		return ans;
	}

	private SinglyLinkedList createLLFromNumReverse(int number) {
		SinglyLinkedList numLL = new SinglyLinkedList();
		Node trav = numLL.getHead();
		while (number > 0) {
			Node temp = new Node(number % 10);
			if (numLL.getHead() == null) {
				trav = temp;
				numLL.setHead(trav);
			} else {
				trav.setNext(temp);
				trav = trav.getNext();
			}
			number = number / 10;
		}
		return numLL;
	}

	private SinglyLinkedList createLLFromNum(int number) {
		SinglyLinkedList numLL = new SinglyLinkedList();

		while (number > 0) {
			Node temp = new Node(number % 10);
			if (numLL.getHead() != null) {
				Node currHead = numLL.getHead();
				temp.setNext(currHead);
			}
			numLL.setHead(temp);
			number = number / 10;
		}
		return numLL;
	}

}
