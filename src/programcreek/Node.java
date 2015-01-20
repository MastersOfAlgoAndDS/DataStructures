package programcreek;

public class Node {
	int val;
	Node next;
	
	Node(int x){
		val=x;
		next=null;
	}
	
	void print(){
		System.out.println(val);
	}
	
	public static void main(String[] args){
		Node temp = new Node(10);
		System.out.print("Temp node is "); 
		temp.print();
	}
}

