package com.ds;

public class BinarySearchTree {

	private GenericBinaryTreeNode<Integer> root;

	public GenericBinaryTreeNode<Integer> getRoot() {
		return root;
	}

	public void setRoot(GenericBinaryTreeNode<Integer> root) {
		this.root = root;
	}

	/**
	 * @param root
	 */
	public BinarySearchTree(GenericBinaryTreeNode<Integer> root) {
		super();
		this.root = root;
	}

	public GenericBinaryTreeNode search(GenericBinaryTreeNode node, int key) {
		int nodeVal = (int) node.getVal();
		if (node == null || nodeVal == key) {
			return node;
		} else if (key > nodeVal) {
			return search(node.getRight(), key);
		} else // if(key < nodeVal){
		{
			return search(node.getLeft(), key);
		}
	}

	public GenericBinaryTreeNode insert(GenericBinaryTreeNode node, int key) {
		if (node == null) {
			return new GenericBinaryTreeNode<Integer>(key);
		} 
		int val = (int) node.getVal();
		if (key < val) {
			node.setLeft(insert(node.getLeft(), key));
		} else if (key > val) {
			node.setRight(insert(node.getRight(), key));
		} else { // key = val
			System.out.println("cannot insert value since it already exists.");
		}
		return node;
	}

	public void printInorder(GenericBinaryTreeNode node) {
		if (node == null) {
			System.out.print("");
		} else {
			printInorder(node.getLeft());
			System.out.print(" " + node.getVal());
			printInorder(node.getRight());
		}
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree(
				new GenericBinaryTreeNode<Integer>(9));
		for (int i = 1; i < 20; i++) {
			bst.insert(bst.getRoot(), i);
		}
		bst.printInorder(bst.getRoot());
	}

}
