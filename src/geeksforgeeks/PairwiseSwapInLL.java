/**
 * Pairwise swap the elements from the starting
 * 
 * */
package geeksforgeeks;

import com.ds.Node;
import com.ds.SinglyLinkedList;

public class PairwiseSwapInLL {

	public static void PairwiseSwapInLL(Node head){
		if(head==null){
			System.out.println("LL is empty!!!");
		}
		Node trav=head.getNext();
		Node prev=head;
		
		while(trav!=null && prev!=null){
			prev.setVal(prev.getVal()+trav.getVal());
			trav.setVal(prev.getVal()-trav.getVal());
			prev.setVal(prev.getVal()-trav.getVal());
			if(prev.getNext()!=null){
				prev=prev.getNext().getNext();
			}
			if(trav.getNext()!=null){
				trav=trav.getNext().getNext();
			}
			
		}
	}
	
	public static void main(String[] args) {
		SinglyLinkedList sll = new SinglyLinkedList();
		int len = 3;
		for (int i = len-1; i >=0; i--) {
			sll.insertAtLast(i + 10);
		}
		PairwiseSwapInLL(sll.getHead());
		sll.print(sll.getHead());
	}

}
