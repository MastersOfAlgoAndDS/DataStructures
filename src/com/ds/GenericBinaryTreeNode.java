/**
 * Basic LinkedList Node. This node is generic i.e. the content can be anything. 
 * The datatype of the content of the node can be anything. 
 * So we can make a linked list of any type.
 * 
 * */

package com.ds;

public class GenericBinaryTreeNode<T> {

	private T val;
	private GenericBinaryTreeNode<T> left;
	private GenericBinaryTreeNode<T> right;

	/**
	 * @param t
	 */
	public GenericBinaryTreeNode(T t) {
		val = t;
		left = null;
		right = null;
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
	public void setVal(Integer val) {
		this.val = (T) val;
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
		// return "GenericBinaryTreeNode [val=" + val + ", left=" + left
		// + ", right=" + right + "]";
		return "[" + val + ", " + left + ", " + right + "]";
	}

	public static GenericBinaryTreeNode searchNode(GenericBinaryTreeNode root,
			int nodeValue) {
		if (root == null)
			return null;
		if ((int) root.getVal() == nodeValue)
			return root;
		GenericBinaryTreeNode node_in_left = searchNode(root.getLeft(),
				nodeValue);
		if (node_in_left == null)
			return searchNode(root.getRight(), nodeValue);
		return node_in_left;
	}

}
