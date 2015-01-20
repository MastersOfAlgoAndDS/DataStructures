package programcreek;

public class NodesQueue {
	Node head;
	Node tail;
	
	void enqueue(Node n){
		if(head==null){
			head=n;
			tail=head;
		}else{
			tail.next=n;
			tail=n;
		}
	}
	
	Node dequeue(){
		if(head==null)
			return null;
		else{
			Node temp = head;
			head = head.next;
			return temp;
		}
	}
	
	void print(){
		if(!isEmpty()){
			Node temp = head;
			while(temp!=null){
				System.out.print(" " + temp.val);
				temp = temp.next;
			}
			System.out.print("\n");
		}else
			System.out.println("empty");
	}
	
	boolean isEmpty(){
		if(head==null)
			return true;
		return false;
	}
	
	
	public static void main(String[] args){
		NodesQueue q1 = new NodesQueue();
		System.out.println("Currently the queue is ");
		q1.print();
		
		q1.enqueue(new Node(10));
		q1.print();
		q1.enqueue(new Node(20));
		q1.print();
		q1.enqueue(new Node(30));
		q1.print();
		q1.enqueue(new Node(40));
		q1.print();
		
		q1.dequeue();
		q1.print();
		q1.dequeue();
		q1.print();
		q1.dequeue();
		q1.print();
		q1.dequeue();
		q1.print();
		q1.dequeue();
		q1.print();
	}
}
