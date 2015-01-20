package programcreek;

public class Stack {
	Node top;
	
	//peek
	int peek(){
		if(top==null)
			return -1;
		return top.val; 
	}
	
	//pop
	Node pop(){
		if(top==null)
			return null;
		else{
		Node temp = top;
		top = top.next;
		return temp;
		}
	}
	
	//push
	void push(Node n){
		n.next=top;
		top=n;
	}
	
	boolean isEmpty(){
		if(top==null)
			return true;
		return false;
	}

	void print(Stack st){
		if(st.isEmpty())
			System.out.println("Stack is empty");
		else{
			Node temp = top;
			while(temp!=null){
				System.out.print(" " + temp.val);
				temp= temp.next;
			}
			System.out.print("\n");
		}
	}
	
	
	public static void main(String[] args){
		Stack st = new Stack();
		System.out.println("my stack top is " + st.peek());
		
		st.push(new Node(10));
		st.print(st);
		st.push(new Node(20));
		st.print(st);
		st.push(new Node(30));
		st.print(st);
		st.push(new Node(50));
		st.print(st);
		
		System.out.println("my stack top is " + st.peek());
		st.pop().print();
		for(int i = 0; i<10; i++){
			st.pop();
			System.out.println("my stack top is " + st.peek());
		}
		System.out.println("my stack top is " + st.peek());
		
		
		
	}
	
}
