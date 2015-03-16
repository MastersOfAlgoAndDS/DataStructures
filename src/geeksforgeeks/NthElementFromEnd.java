/**
 * http://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
 * Take 2 pointers N1 and N2
 * Count till the Nth element from front is reached.
 * THen increment both the pointers till the second/leading pointer reaches the end. 
 * Meanwhile the pointer n1 reaches nth node from the end.
 * */
package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class NthElementFromEnd {

	public static int NthElementFromEnd(Node head, int n){
		if(head==null){
			return -1;
		}
		Node n1=head;
		Node n2=head;
		int cnt=1;
		while(cnt<n){
			cnt++;
			n2=n2.getNext();
		}
		while(n2.getNext()!=null){
			n2=n2.getNext();
			n1=n1.getNext();
		}
		
		return n1.getVal();
	}
	
	public static void main(String[] args){
		SinglyLinkedList sll = new SinglyLinkedList();
		int len = 7;
		for(int i=0; i<len; i++){
			sll.insertAtLast(i+10);
		}
		int nthFromEnd = 4;
		System.out.println(nthFromEnd + " element from the end is: " + NthElementFromEnd(sll.getHead(),nthFromEnd));
	}
}
