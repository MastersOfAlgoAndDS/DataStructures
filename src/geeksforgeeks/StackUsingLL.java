package geeksforgeeks;

import com.ds.Node;

public class StackUsingLL {
	Node top;

	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}
	
	public void push(int newTop){
		Node nn = new Node(newTop);
		if(top==null){
			top =nn;
		}else{
			nn.setNext(top);
			top = nn;
		}
	}
	
	public Node pop(){
		if(top==null){
			System.out.println("Stack is empty");
			return null;
		}else{
			Node nn = top;
			top = nn.getNext();
			return top;
		}
	}
	
	public int peek(){
		if(top==null){
			System.out.println("Stack is empty");
			return -1;
		}else{
			return top.getVal();
		}
	}
	
	public boolean isEmpty(){
		if(top==null)
			return true;
			return false;
	}
	
	public static void main(String[] args){
		StackUsingLL stack = new StackUsingLL();
		if(stack.isEmpty())	System.out.println("Stack is empty");
		stack.push(3);
		stack.push(4);
		stack.push(5);
		if(!stack.isEmpty())	System.out.println("Stack is Not empty!!");
		stack.pop();
		System.out.println(stack.peek());
		stack.pop();
		stack.pop();
		stack.pop();
	}
	
}
