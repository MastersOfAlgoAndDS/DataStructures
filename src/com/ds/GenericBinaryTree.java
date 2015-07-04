/*
 * This program is specially written for easier and quicker test data preparation
 * of various problems related to binary trees.
 * The input needs to be a ArrayList of the data structure whose tree is to be created.
 * 
 * */

package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author Milind This program is specially written for easier and quicker test
 *         data preparation of various problems related to binary trees. The
 *         input needs to be a ArrayList of the data structure whose tree is to
 *         be created.
 * 
 * @param <T>
 */
public class GenericBinaryTree<T> {
	GenericBinaryTreeNode<T> root;

	public GenericBinaryTree() {
		root = null;
	}

	/**
	 * contructor The contructor is responsible for creation of the tree so that
	 * the tree is returned on the new contructor call.
	 * 
	 * @param list
	 */
	public GenericBinaryTree(ArrayList<T> list) {
		int len = list.size();
		int iterator = 0;
		boolean currTreeNodeFullFlag = false;
		LinkedList<GenericBinaryTreeNode<T>> queue = new LinkedList<GenericBinaryTreeNode<T>>();
		if (list.isEmpty())
			root = null;
		else {
			root = new GenericBinaryTreeNode<T>(list.get(iterator));
			iterator++;
			queue.add(root);
		}
		while (iterator < len && !queue.isEmpty()) {
			T nextListItem = list.get(iterator);
			GenericBinaryTreeNode<T> nextTreeNode = new GenericBinaryTreeNode<T>(
					nextListItem);
			GenericBinaryTreeNode<T> currQueueItem = queue.peek();
			if (!isTreeNodeRipe(currQueueItem)) {
				if (currQueueItem.getLeft() == null)
					currQueueItem.setLeft(nextTreeNode);
				else if (currQueueItem.getRight() == null) {
					currQueueItem.setRight(nextTreeNode);
					queue.remove();
				}
			}
			// currQueueItem.setLeft(new
			// GenericBinaryTreeNode<T>(list.get(iterator)));
			queue.add(nextTreeNode);
			iterator++;
			// if(iterator<len){
			// currQueueItem.setRight(new
			// GenericBinaryTreeNode<T>(list.get(iterator)));
			// queue.add(currQueueItem.getRight());
			// iterator++;
			// }
		}
	}

	/**
	 * Returns true if the tree node is ripe i.e. both left and right children
	 * of the tree node are assigned. i.e. both left and right are not null
	 * 
	 * @param currQueueItem
	 * @return
	 */
	private boolean isTreeNodeRipe(GenericBinaryTreeNode<T> currQueueItem) {
		if (currQueueItem.getLeft() != null && currQueueItem.getRight() != null)
			return true;
		return false;
	}

	/*
	 * This toString function prints the tree with parentheses (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// return "GenericBinaryTree [root=" + root + "]";
		return "[" + root + "]";
	}

	/**
	 * Test function for testing various functions of the tree program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfNodes = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfNodes; i++) {
			list.add(in.nextInt());
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree);
	}
}
