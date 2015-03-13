package com.ds;

public class DoublyEndedNode<T> {
	T val;
	DoublyEndedNode<T> next;
	DoublyEndedNode<T> prev;
	
	public DoublyEndedNode(T t){
		val=t;
		next=prev=null;
	}

	public T getVal() {
		return val;
	}

	public void setVal(T val) {
		this.val = val;
	}

	public DoublyEndedNode<T> getNext() {
		return next;
	}

	public void setNext(DoublyEndedNode<T> next) {
		this.next = next;
	}

	public DoublyEndedNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DoublyEndedNode<T> prev) {
		this.prev = prev;
	}	
	
}

