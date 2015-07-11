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
 *  Levelorder tree traversal
 *  Size of tree function
 *  Comapre identical trees
 *  calculate height/max depth of the tree
 *  delete tree
 *  mirror the tree in place
 *  print the paths of the tree from root to each of the leaves. - NOT Complete yet.
 *  getting the leaf count
 *  Level order traversal in spiral form - [using two stacks]
 *  Check whether tree conserves the children sum property
 *  Diameter of a tree
 *  
 * */

package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Milind This program is specially written for easier and quicker test
 *         data preparation of various problems related to binary trees. The
 *         input needs to be a ArrayList of the data structure whose tree is to
 *         be created.
 * 
 * @param <T>
 */
public class GenericBinaryTree<T> {
	private GenericBinaryTreeNode<T> root;

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
	 * Function to print the tree in level order (level-by-level)
	 * 
	 * @param head
	 */
	public void levelOrder(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			Queue<GenericBinaryTreeNode<T>> q = new LinkedList<GenericBinaryTreeNode<T>>();
			q.add(head);
			while (!q.isEmpty()) {
				GenericBinaryTreeNode<T> temp = q.remove();
				System.out.print(temp.getVal());
				if (temp.getRight() != null)
					q.add(temp.getRight());
				if (temp.getLeft() != null)
					q.add(temp.getLeft());
			}
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
		if (head == null)
			return 0;
		return Math.max(height(head.getLeft()), height(head.getRight())) + 1;
	}

	public void deleteTree(GenericBinaryTreeNode<T> head) {
		root = null;
	}

	public GenericBinaryTreeNode<T> mirrorTree(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return null;
		if (head.getLeft() == null && head.getRight() == null)
			return head;
		else {
			mirrorTree(head.getLeft());
			mirrorTree(head.getRight());
			GenericBinaryTreeNode<T> temp = head.getLeft();
			head.setLeft(head.getRight());
			head.setRight(temp);
			return head;
		}
	}

	public void printPaths(GenericBinaryTreeNode<T> head, T[] path, int pathlen) {
		if (head == null)
			return;
		else {
			// path.add(head.getVal());
			path[pathlen] = head.getVal();
			pathlen++;
		}
		if (head.getLeft() == null && head.getRight() == null) {
			// print the path from the root to the leaf
			for (T item : path) {
				System.out.print(item.toString());
			}
			System.out.println();
		} else {
			printPaths(head.getLeft(), path, pathlen);
			printPaths(head.getRight(), path, pathlen);
		}
	}

	public int getLeafCount(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return 0;
		else if (head.getLeft() == null && head.getRight() == null)
			return 1;
		else
			return getLeafCount(head.getLeft()) + getLeafCount(head.getRight());
	}

	/**
	 * Function to print tree in levelorder, however spirally. i.e. print L>R
	 * and R>L at alternate levels
	 * 
	 * @param head
	 */
	public void levelOrderSpiral(GenericBinaryTreeNode<T> head) {
		Stack<GenericBinaryTreeNode<T>> s1 = new Stack<GenericBinaryTreeNode<T>>();
		Stack<GenericBinaryTreeNode<T>> s2 = new Stack<GenericBinaryTreeNode<T>>();
		if (head != null) {
			s1.push(head);
			while (!s1.isEmpty() || !s2.isEmpty()) {
				while (!s1.isEmpty()) {
					GenericBinaryTreeNode<T> temp = s1.pop();
					System.out.print(temp.getVal());
					if (temp.getLeft() != null)
						s2.push(temp.getLeft());
					if (temp.getRight() != null)
						s2.push(temp.getRight());
				}
				System.out.println();
				while (!s2.isEmpty()) {
					GenericBinaryTreeNode<T> temp = s2.pop();
					System.out.print(temp.getVal());
					if (temp.getRight() != null)
						s1.push(temp.getRight());
					if (temp.getLeft() != null)
						s1.push(temp.getLeft());
				}
				System.out.println();
			}
		}
	}

	/**
	 * 
	 * This function returns true only if the tree is empty, leaf node or the
	 * property of children sum is valid for all subtrees. Else it returns
	 * false.
	 * 
	 * @param head
	 * @return
	 */
	public boolean isChildrenSumPropertyValid(
			GenericBinaryTreeNode<Integer> head) {
		if (head == null || (head.getLeft() == null && head.getRight() == null))
			return true;
		if (head.getVal() == ((head.getLeft() == null ? 0 : head.getLeft()
				.getVal()) + (head.getRight() == null ? 0 : head.getRight()
				.getVal())))
			return isChildrenSumPropertyValid(head.getLeft())
					&& isChildrenSumPropertyValid(head.getRight());
		else
			return false;
	}
	
	
	/**
	 * Function to calculate the diameter of a tree.
	 * Diameter is the longest path from any of the leaf to another leaf in the tree.
	 * This diameter may or may not pass via the root.
	 * Basically diameter is the max of the following 3
	 * 		max height on left subtree + max height on right subtree + 1
	 * 		longest diameter in the left subtree
	 * 		longest diameter in the right subtree
	 * @param head
	 */
	public int diameter(GenericBinaryTreeNode<T> head){
		if (head==null)
			return 0;
		int leftHt=0, rightHt=0;
		leftHt = height(head.getLeft());
		rightHt = height(head.getRight());
		return Math.max(leftHt + rightHt + 1,Math.max(diameter(head.getLeft()), diameter(head.getRight())));
	}

	/**
	 * Test function for testing various functions of the tree program
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		int numberOfNodes = in.nextInt();
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < numberOfNodes; i++) {
//			list.add(in.nextInt());
//		}
//		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
//		System.out.println(tree);
//		tree.preOrder(tree.getRoot());
//		System.out.println();
//		tree.inOrder(tree.getRoot());
//		System.out.println();
//		tree.postOrder(tree.getRoot());
//		System.out.println();
//		System.out.println("Tree size is: " + tree.size(tree.getRoot()));
//
//		Scanner in2 = new Scanner(System.in);
//		int numberOfNodes2 = in2.nextInt();
//		ArrayList<Integer> list2 = new ArrayList<Integer>();
//		for (int i = 0; i < numberOfNodes2; i++) {
//			list2.add(in2.nextInt());
//		}
//		GenericBinaryTree<Integer> tree2 = new GenericBinaryTree<Integer>(list2);
//		System.out.println(tree.sameTrees(tree.getRoot(), tree2.getRoot()));
//
//		System.out.println("Height of the tree is: "
//				+ tree.height(tree.getRoot()));
//		GenericBinaryTree<Integer> treeRandom = new GenericBinaryTree<Integer>();
//		treeRandom.setRoot(new GenericBinaryTreeNode<Integer>(20));
//		treeRandom.getRoot().setLeft(new GenericBinaryTreeNode<Integer>(10));
//		treeRandom.getRoot().getLeft()
//				.setLeft(new GenericBinaryTreeNode<Integer>(30));
//		treeRandom.getRoot().getLeft().getLeft()
//				.setLeft(new GenericBinaryTreeNode<Integer>(40));
//		treeRandom.getRoot().setRight(new GenericBinaryTreeNode<Integer>(70));
//		System.out.println(treeRandom.toString());
//		System.out.println("Height of random tree is: "
//				+ treeRandom.height(treeRandom.getRoot()));
//
//		System.out.println("Tree before deleting: " + treeRandom);
//		treeRandom.deleteTree(treeRandom.getRoot());
//		System.out.println("Tree after deleting: " + treeRandom);
//
//		System.out.println("Before mirroring the tree: ");
//		System.out.println(tree.getRoot());
//		System.out.println("After mirroring the tree: ");
//		System.out.println(tree.mirrorTree(tree.getRoot()));
//		tree.mirrorTree(tree.getRoot());
//		// Object[] a = new Object[1000];
//		// tree.printPaths(tree.getRoot(),(Integer[]) a,0);
//		System.out.println();
//		tree.levelOrder(tree.getRoot());
//		System.out.println("Number of leaf nodes is: "
//				+ tree.getLeafCount(tree.getRoot()));
//
//		tree.levelOrderSpiral(tree.getRoot());
//
//		ArrayList<Integer> list3 = new ArrayList<Integer>();
//		list3.add(10);
//		list3.add(8);
//		list3.add(2);
//		list3.add(3);
//		list3.add(5);
//		list3.add(2);
//
//		GenericBinaryTree<Integer> tree3 = new GenericBinaryTree<Integer>(list3);
//		System.out.println(tree3.isChildrenSumPropertyValid(tree3.getRoot()));

		//diameter test
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(1);
		list4.add(2);
		list4.add(3);
		list4.add(4);
		list4.add(5);
		GenericBinaryTree<Integer> tree4 = new GenericBinaryTree<Integer>(list4);
		System.out.println("Diameter of tree4 is:" + tree4.diameter(tree4.getRoot()));
		
	}
}
