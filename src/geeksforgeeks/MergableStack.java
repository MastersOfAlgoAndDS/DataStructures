package geeksforgeeks;

import com.ds.Node;

public class MergableStack {
	Node top;
	Node bottom;

	
	
	public Node getTop() {
		return top;
	}

	public void setTop(Node top) {
		this.top = top;
	}

	public Node getBottom() {
		return bottom;
	}

	public void setBottom(Node bottom) {
		this.bottom = bottom;
	}

	MergableStack(){
		top=null;
		bottom=null;
	}
	
	public void push(int val){
		Node n = new Node(val);
		if(top==null){
			top=bottom=n;
		}
		else{
			n.setNext(top);
			top=n;
		}
	}
	
	public int pop(){
		if(!isEmpty()){
			Node temp = top;
			top = top.getNext();
			return temp.getVal();
		}
		return -1;
	}

	public boolean isEmpty(){
		if(top==null)
			return true;
		return false;
	}
	
	public void Merge(MergableStack s2){
		bottom.setNext(s2.getTop
				());
		bottom = s2.getBottom();
	}
	
	public void printMergableStack(){
		Node nn = top;
		while(nn!=null){
			System.out.print(nn.getVal() + " ");
			nn=nn.getNext();
		}
		System.out.println();
	}
	
	public static void main(String[] args){
		MergableStack s1 = new MergableStack();
		MergableStack s2 = new MergableStack();
		int i =1;
		while(i<10){
			s1.push(i);
			s2.push(i+10);
			i++;
		}
		
		s1.printMergableStack();
		s1.pop();
		s2.printMergableStack();
		s2.pop();
		s1.Merge(s2);
		s1.printMergableStack();
		s1.pop();
		s1.printMergableStack();
	}
}

