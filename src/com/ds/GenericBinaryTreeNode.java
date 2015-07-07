package com.ds;
/**
 * Basic LinkedList Node. This node is generic i.e. the content can be anything. 
 * The datatype of the content of the node can be anything. 
 * So we can make a linked list of any type.
 * 
 * */


public class GenericBinaryTreeNode<T> {

	private T val;
	private GenericBinaryTreeNode<T> left;
	private GenericBinaryTreeNode<T> right;
	
	/**
	 * @param t
	 */
	public GenericBinaryTreeNode(T t) {
		val = t;
		left=null;
		right=null;
	}
	
	/**
	 * @return
	 */
	public T getVal() {
		return val;
	}
	
	/**
	 * @param val
	 */
	public void setVal(T val) {
		this.val = val;
	}
	
	/**
	 * @return
	 */
	public GenericBinaryTreeNode<T> getLeft() {
		return left;
	}
	
	/**
	 * @param left
	 */
	public void setLeft(GenericBinaryTreeNode<T> left) {
		this.left = left;
	}
	
	/**
	 * @return
	 */
	public GenericBinaryTreeNode<T> getRight() {
		return right;
	}
	
	/**
	 * @param right
	 */
	public void setRight(GenericBinaryTreeNode<T> right) {
		this.right = right;
	}

	@Override
	public String toString() {
//		return "GenericBinaryTreeNode [val=" + val + ", left=" + left
//				+ ", right=" + right + "]";
		return "[" + val + ", " + left
				+ ", " + right + "]";
	}
	
	
	
	
	
}
