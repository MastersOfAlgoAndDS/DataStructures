package ctci_5E;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class P_2_3_DeleteFromMiddle {

	public static void main(String[] args) {
		P_2_3_DeleteFromMiddle s = new P_2_3_DeleteFromMiddle();
		SinglyLinkedList ll = new SinglyLinkedList();
		ll.insertAtLast(3);
		ll.insertAtLast(5);
		ll.insertAtLast(4);
		ll.insertAtLast(3);
		ll.print(ll.getHead());
		s.delete(ll, 5);
		ll.print(ll.getHead());
	}

	private void delete(SinglyLinkedList ll, int i) {
		Node temp = ll.getHead();
		Node prev = null;
		while (temp != null) {
			if (temp.getVal() == i) {
				if (temp.getNext() != null)
					ll.delete(temp);
				else {
					prev.setNext(temp.getNext());
					temp = null;
				}
			}
			prev = temp;
			temp = temp.getNext();
		}
	}

}
