package com.ds;
//check this website for a wonderful solution to this problem - http://www.quora.com/How-does-Floyds-cycle-finding-algorithm-work
public class CycleDetectionInLinkedList {
	
	public static Node detectLoopStart(Node head){
		Node turtle, hare;
		turtle = hare = head;
		turtle = turtle.getNext();
		hare = hare.getNext().getNext();
		while(turtle!=hare){
			hare = hare.getNext().getNext();
			turtle = turtle.getNext();
		}
		
		Node temp = head;
		while(temp!=turtle){
			temp = temp.getNext();
			turtle = turtle.getNext();
		}
		System.out.println("Content of TurtleNode right now is " + turtle.getVal());
		return turtle;
		
		
	}
	
	public static void main(String[] args){
		//Create a new Linked list with loop
		SinglyLinkedList sll = new SinglyLinkedList();
		sll.insertAtLast(1);
		sll.insertAtLast(44);
		sll.insertAtLast(3);
		sll.insertAtLast(4);
		sll.insertAtLast(5);
		sll.insertAtLast(8);
		sll.insertAtLast(13);
		sll.insertAtLast(22);
		sll.insertAtLast(111);
		sll.insertAtLast(80);
		sll.insertAtLast(65);
		sll.insertAtLast(87);
		
		int looper = 4;
		Node loopstart = sll.getHead();
		
		while(loopstart.getVal()!=looper){
			loopstart = loopstart.getNext();
		}
		
		Node lastNode = loopstart;
		while(lastNode.getNext()!=null){
			lastNode = lastNode.getNext();
		}
		
		lastNode.setNext(loopstart);
		
		//sll.print(sll.getHead());
		//Printing the loop goes into infinite loop means our linked list with loop is ready.
		System.out.println("Loopstart is at this element: " + detectLoopStart(sll.getHead()).getVal());
		
	}
	
	
}
