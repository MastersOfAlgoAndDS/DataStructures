/**
 * Basic LinkedList Node. This node is generic i.e. the content can be anything. 
 * The datatype of the content of the node can be anything. 
 * So we can make a linked list of any type.
 * 
 * */

package com.ds;

public class GenericBinaryTreeNode<T> {

	T val;
	GenericBinaryTreeNode<T> left;
	GenericBinaryTreeNode<T> right;
	public GenericBinaryTreeNode(T t) {
		val = t;
		left=null;
		right=null;
	}
	public T getVal() {
		return val;
	}
	public void setVal(T val) {
		this.val = val;
	}
	public GenericBinaryTreeNode<T> getLeft() {
		return left;
	}
	public void setLeft(GenericBinaryTreeNode<T> left) {
		this.left = left;
	}
	public GenericBinaryTreeNode<T> getRight() {
		return right;
	}
	public void setRight(GenericBinaryTreeNode<T> right) {
		this.right = right;
	}
	
	
	
	
	
}
