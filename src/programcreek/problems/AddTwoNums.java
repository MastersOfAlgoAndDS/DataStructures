package programcreek.problems;
/*Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
*/
public class AddTwoNums {

	private class ListNode{
		int val;
		ListNode next;
		ListNode(int n){
			val=n;
			next=null;
		}
	}
	
	public ListNode addTwoNums(ListNode l1Head, ListNode l2Head){
		ListNode newHead = new ListNode(0);
		
		ListNode p3 = newHead;
		ListNode p1 = l1Head;
		ListNode p2 = l2Head;
		boolean prevSumGt10 = false;
		
		
		while (p1!=null &&  p2!=null){
		
			p3.val = p1.val+p2.val;
			if(prevSumGt10==true){
				p3.val=p3.val+1;
				prevSumGt10=false;
			}
			if(p3.val>=10){
				p3.val= p3.val%10;
				prevSumGt10 = true;				
			}
			p1=p1.next;
			p2=p2.next;
			p3.next = new ListNode(0);
			p3=p3.next;
			
		}
		
		if(prevSumGt10==true){
			//p3.next = new ListNode(0);
			//p3 = p3.next;
			p3.val=1;
		}
		else
			p3=null;
		
		return newHead;
	}
	
	public void printList(ListNode head){
		while(head!=null){
			System.out.print(head.val);
			head = head.next;
		}
	}
	
	
	public static void main(String [] args){
		AddTwoNums a1 = new AddTwoNums();
		
		ListNode l1Head = a1.new ListNode(2);
		ListNode l1 = l1Head;
		l1.next = a1.new ListNode(4);
		l1 = l1.next;
		l1.next = a1.new ListNode(3);
		l1 = l1.next;
		a1.printList(l1Head);
		
		
		ListNode l2Head = a1.new ListNode(5);
		ListNode l2 = l2Head;
		l2.next = a1.new ListNode(6);
		l2 = l2.next;
		l2.next = a1.new ListNode(4);
		l2 = l2.next;
		a1.printList(l2Head);
		ListNode l3Head = a1.addTwoNums(l1Head, l2Head);
		a1.printList(l3Head);
	}

	
	
}
