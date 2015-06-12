/**
 * Basic Tree Node. This node is generic i.e. the content can be anything. 
 * The datatype of the content of the node can be anything. 
 * So we can can make a tree of any type of object.
 * 
 * */

package com.ds;

public class GenericNode<T> {

	T val;
	GenericNode<T> next;
	public T getVal() {
		return val;
	}
	public void setVal(T val) {
		this.val = val;
	}
	public GenericNode<T> getNext() {
		return next;
	}
	public void setNext(GenericNode<T> next) {
		this.next = next;
	}
	
	
	
}
