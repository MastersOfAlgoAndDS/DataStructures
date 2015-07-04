/*
 * This program is specially written for easier and quicker test data preparation
 * of various problems related to binary trees.
 * The input needs to be a ArrayList of the data structure whose tree is to be created.
 * 
 * Includes
 * 	Basic Binary tree construction
 *  Add node
 *  Inorder tree traversal
 *  Preorder tree traversal
 *  Postorder tree traversal
 *  Size of tree function
 *  Comapre identical trees
 *  calculate height/max depth of the tree
 *  delete tree
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

	public GenericBinaryTreeNode<T> getRoot() {
		return root;
	}

	public void setRoot(GenericBinaryTreeNode<T> root) {
		this.root = root;
	}

	/**
	 * The default constructor
	 */
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
	 * Function to print the preorder traversal of the tree output
	 * 
	 * @param head
	 * @return
	 */
	public void preOrder(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return;
		else {
			System.out.print(head.getVal());
			preOrder(head.getLeft());
			preOrder(head.getRight());
		}
	}

	/**
	 * Function to print the inorder traversal of the tree output
	 * 
	 * @param head
	 * @return
	 */
	public void inOrder(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			inOrder(head.getLeft());
			System.out.print(head.getVal());
			inOrder(head.getRight());
		}
	}

	/**
	 * Function to print the postorder traversal of the tree output
	 * 
	 * @param head
	 * @return
	 */
	public void postOrder(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			postOrder(head.getLeft());
			postOrder(head.getRight());
			System.out.print(head.getVal());
		}
	}

	/**
	 * 
	 * Function to calculate the size of the tree
	 * 
	 * @param head
	 * @return
	 */
	public int size(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return 0;
		else
			return size(head.getLeft()) + 1 + size(head.getRight());
	}

	/**
	 * 
	 * To compare two trees given their roots. If the two trees are exactly the
	 * same, true is returned.
	 * 
	 * @param head1
	 * @param head2
	 * @return
	 */
	public boolean sameTrees(GenericBinaryTreeNode<T> head1,
			GenericBinaryTreeNode<T> head2) {
		if (head1 == null && head2 == null)
			return true;
		if (head1 != null && head2 != null) {
			return (head1.getVal() == head2.getVal()
					&& sameTrees(head1.getLeft(), head2.getLeft()) && sameTrees(
						head1.getRight(), head2.getRight()));
		}
		return false;
	}

	/**
	 * 
	 * Function to calculate the height of the tree. I.e. maximum depth if the
	 * tree is unbalanced.
	 * 
	 * @return
	 */
	public int height(GenericBinaryTreeNode<T> head) {
		if(head==null)
			return 0;
		return Math.max(height(head.getLeft()),height(head.getRight())) + 1;
	}

	public void deleteTree(GenericBinaryTreeNode<T> head){
		root=null;
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
		tree.preOrder(tree.getRoot());
		System.out.println();
		tree.inOrder(tree.getRoot());
		System.out.println();
		tree.postOrder(tree.getRoot());
		System.out.println();
		System.out.println("Tree size is: " + tree.size(tree.getRoot()));

		Scanner in2 = new Scanner(System.in);
		int numberOfNodes2 = in2.nextInt();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < numberOfNodes2; i++) {
			list2.add(in2.nextInt());
		}
		GenericBinaryTree<Integer> tree2 = new GenericBinaryTree<Integer>(list2);
		System.out.println(tree.sameTrees(tree.getRoot(), tree2.getRoot()));
		
		System.out.println("Height of the tree is: " + tree.height(tree.getRoot()));
		GenericBinaryTree<Integer> treeRandom = new GenericBinaryTree<Integer>();
		treeRandom.setRoot(new GenericBinaryTreeNode<Integer>(20));
		treeRandom.getRoot().setLeft(new GenericBinaryTreeNode<Integer>(10));
		treeRandom.getRoot().getLeft().setLeft(new GenericBinaryTreeNode<Integer>(30));
		treeRandom.getRoot().getLeft().getLeft().setLeft(new GenericBinaryTreeNode<Integer>(40));
		treeRandom.getRoot().setRight(new GenericBinaryTreeNode<Integer>(70));
		System.out.println(treeRandom.toString());
		System.out.println("Height of random tree is: " + treeRandom.height(treeRandom.getRoot()));
		
		System.out.println("Tree before deleting: " + treeRandom);
		treeRandom.deleteTree(treeRandom.getRoot());
		System.out.println("Tree after deleting: " + treeRandom);
		
		
	}
}
