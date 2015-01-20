package programcreek.problems;

import programcreek.ListNode;

public class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
       int carry =0;
 
        ListNode newHead = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p3=newHead;
 
        while(p1 != null || p2 != null){
            if(p1 != null){
                carry += p1.getVal();
                p1 = p1.getNext();
            }
 
            if(p2 != null){
                carry += p2.getVal();
                p2 = p2.getNext();
            }
 
            p3.setNext(new ListNode(carry%10));
            p3 = p3.getNext();
            carry /= 10;
        }
 
        if(carry==1) 
            p3.setNext(new ListNode(1));
 
        return newHead.getNext();
    }
    
	public static void printList(ListNode head){
		while(head!=null){
			System.out.print(head.getVal());
			head = head.getNext();
		}
	}

    
	public static void main(String [] args){
		
		ListNode l1Head = new ListNode(2);
		ListNode l1 = l1Head;
		l1.setNext(new ListNode(4));
		l1 = l1.getNext();
		l1.setNext(new ListNode(3));
		l1 = l1.getNext();
		l1.setNext(new ListNode(3));
		l1 = l1.getNext();
		l1.setNext(new ListNode(3));
		l1 = l1.getNext();
		l1.setNext(new ListNode(3));
		l1 = l1.getNext();
		l1.setNext(new ListNode(3));
		l1 = l1.getNext();
		printList(l1Head);
		
		
		ListNode l2Head = new ListNode(5);
		ListNode l2 = l2Head;
		l2.setNext(new ListNode(6));
		l2 = l2.getNext();
		l2.setNext(new ListNode(4));
		l2 = l2.getNext();
		l2.setNext(new ListNode(4));
		l2 = l2.getNext();
		l2.setNext(new ListNode(4));
		l2 = l2.getNext();
		printList(l2Head);
		ListNode l3Head = addTwoNumbers(l1Head, l2Head);
		printList(l3Head);
	}

    
}