package com.ds;

/**
 * Basic LinkedList Node. This node is generic i.e. the content can be anything.
 * The datatype of the content of the node can be anything. So we can make a
 * linked list of any type.
 * 
 * */

public class GenericBinTreeNodeWParent<T> {

	private T val;
	private GenericBinTreeNodeWParent<T> left;
	private GenericBinTreeNodeWParent<T> right;
	private GenericBinTreeNodeWParent<T> parent;

	/**
	 * @param t
	 */
	public GenericBinTreeNodeWParent(T t) {
		val = t;
		left = null;
		right = null;
		parent = null;
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
	public GenericBinTreeNodeWParent<T> getLeft() {
		return left;
	}

	/**
	 * @param left
	 */
	public void setLeft(GenericBinTreeNodeWParent<T> left) {
		this.left = left;
	}

	/**
	 * @return
	 */
	public GenericBinTreeNodeWParent<T> getRight() {
		return right;
	}

	/**
	 * @param right
	 */
	public void setRight(GenericBinTreeNodeWParent<T> right) {
		this.right = right;
	}

	/**
	 * @return
	 */
	public GenericBinTreeNodeWParent<T> getParent() {
		return parent;
	}

	/**
	 * @param parent
	 */
	public void setParent(GenericBinTreeNodeWParent<T> parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		// return "GenericBinTreeNodeWParent [val=" + val + ", left=" + left
		// + ", right=" + right + "]";
		return "[" + val + " -> " + left + ", " + right + "]";
	}

	public static GenericBinTreeNodeWParent createSampleBSTWithParents() {
		GenericBinTreeNodeWParent root = new GenericBinTreeNodeWParent<Integer>(
				11);
		root.setLeft(new GenericBinTreeNodeWParent<Integer>(2));
		root.getLeft().setParent(root);
		root.setRight(new GenericBinTreeNodeWParent<Integer>(15));
		root.getRight().setParent(root);

		root.getLeft().setLeft(new GenericBinTreeNodeWParent<Integer>(1));
		root.getLeft().getLeft().setParent(root.getLeft());
		root.getLeft().setRight(new GenericBinTreeNodeWParent<Integer>(3));
		root.getLeft().getRight().setParent(root.getLeft());

		root.getRight().setLeft(new GenericBinTreeNodeWParent<Integer>(14));
		root.getRight().getLeft().setParent(root.getRight());
		root.getRight().setRight(new GenericBinTreeNodeWParent<Integer>(16));
		root.getRight().getRight().setParent(root.getRight());

		root.getRight().getLeft()
				.setLeft(new GenericBinTreeNodeWParent<Integer>(13));
		root.getRight().getLeft().getLeft()
				.setParent(root.getRight().getLeft());

		root.getRight().getRight()
				.setRight(new GenericBinTreeNodeWParent<Integer>(17));
		root.getRight().getRight().getRight()
				.setParent(root.getRight().getRight());
		return root;
	}
}
