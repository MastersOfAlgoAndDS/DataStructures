/**
 * @author Milind Gokhale
 * 
 * @Info This program is specially written for easier and quicker test data
 *      preparation of various problems related to binary trees. The input needs
 *      to be a ArrayList of the data structure whose tree is to be created.
 * 
 * 	Includes
 * 	Basic Binary tree construction
 *  Add node
 *  Inorder tree traversal - Recursive Strategy
 *  Preorder tree traversal - Recursive Strategy
 *  Inorder tree traversal - Iterative Strategy
 *  Preorder tree traversal - Iterative Strategy
 *  Postorder tree traversal - Recursive Strategy
 *  Levelorder tree traversal - Iterative Strategy
 *  Size of tree function
 *  Comapre identical trees
 * */

package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

	/**contructor
	 * @param list
	 */
	public GenericBinaryTree(ArrayList<T> list) {
		int len = list.size();
		int iterator = 0;
		boolean currTreeNodeFullFlag = false;
		LinkedList<GenericBinaryTreeNode<T>> queue = new LinkedList<GenericBinaryTreeNode<T>>();
		if(list.isEmpty())
			root=null;
		else{
			root.setVal(list.get(iterator));
			root.setLeft(null);
			root.setRight(null);
			iterator++;
			queue.add(root);
		}
		while(iterator<len || !queue.isEmpty()){
			GenericBinaryTreeNode<T> currQueueItem = queue.remove();
			currQueueItem.setLeft(new GenericBinaryTreeNode<T>(list.get(iterator)));
			queue.add(currQueueItem.getLeft());
			iterator++;
			if(iterator<len){
				currQueueItem.setRight(new GenericBinaryTreeNode<T>(list.get(iterator)));
				queue.add(currQueueItem.getRight());
				iterator++;
			}
		}
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
	 * Function to print the preorder traversal of the tree output This function
	 * uses recursive strategy
	 * 
	 * @param head
	 * @return void
	 */
	public static void preOrderRecur(GenericBinaryTreeNode head) {
		if (head == null)
			return;
		else {
			System.out.print(head.getVal());
			preOrderRecur(head.getLeft());
			preOrderRecur(head.getRight());
		}
	}

	/**
	 * Function to print the inorder traversal of the tree output This function
	 * uses recursive strategy
	 * 
	 * @param head
	 * @return void
	 */
	public void inOrderRecur(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			inOrderRecur(head.getLeft());
			System.out.print(head.getVal());
			inOrderRecur(head.getRight());
		}
	}

	/**
	 * Function to print the postorder traversal of the tree output This
	 * function uses recursive strategy
	 * 
	 * @param head
	 * @return void
	 */
	public void postOrderRecur(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			postOrderRecur(head.getLeft());
			postOrderRecur(head.getRight());
			System.out.print(head.getVal());
		}
	}

	/**
	 * Function to print the postorder traversal of the tree output This
	 * function uses iterative strategy
	 * 
	 * @param head
	 * @return void
	 */
	public void preOrder(GenericBinaryTree<T> tree) {
		if (tree != null) {
			Stack st = new Stack<GenericBinaryTreeNode>();
			GenericBinaryTreeNode curr = tree.getRoot();

			while (curr != null || !st.isEmpty()) {

				if (curr != null) {
					System.out.print(curr.getVal());
					st.push(curr);
					curr = curr.getLeft();
				} else if (!st.isEmpty()) {
					curr = (GenericBinaryTreeNode) st.pop();
					curr = curr.getRight();
				}
			}

		}
	}

	/**
	 * Function to print the postorder traversal of the tree output This
	 * function uses iterative strategy
	 * 
	 * 1) Create an empty stack S. 2) Initialize current node as root 3) Push
	 * the current node to S and set current = current->left until current is
	 * NULL 4) If current is NULL and stack is not empty then a) Pop the top
	 * item from stack. b) Print the popped item, set current =
	 * popped_item->right c) Go to step 3. 5) If current is NULL and stack is
	 * empty then we are done.
	 * 
	 * 
	 * @param head
	 * @return void
	 */
	public void inOrder(GenericBinaryTree<T> tree) {
		if (tree != null) {
			Stack st = new Stack<GenericBinaryTreeNode>();
			GenericBinaryTreeNode curr = tree.getRoot();

			while (curr != null || !st.isEmpty()) {

				if (curr != null) {
					st.push(curr);
					curr = curr.getLeft();
				} else if (!st.isEmpty()) {
					curr = (GenericBinaryTreeNode) st.pop();
					System.out.print(curr.getVal());
					curr = curr.getRight();
				}
			}

		}
	}

	/**
	 * 
	 * Function to print the tree in level order (level-by-level)
	 * 
	 * @param head
	 * @return void
	 */
	public void levelOrder(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			Queue<GenericBinaryTreeNode<T>> q = new LinkedList<GenericBinaryTreeNode<T>>();
			q.add(head);
			while (!q.isEmpty()) {
				GenericBinaryTreeNode<T> temp = q.remove();
				System.out.print(temp.getVal());
				if (temp.getLeft() != null)
					q.add(temp.getLeft());
				if (temp.getRight() != null)
					q.add(temp.getRight());
			}
		}

	}

	/**
	 * 
	 * Function to calculate the size of the tree
	 * 
	 * @param head
	 * @return int
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
	 * @return boolean
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
	 * @param head
	 * @return int
	 */
	public int height(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return 0;
		return Math.max(height(head.getLeft()), height(head.getRight())) + 1;
	}

	/**
	 * Here we consider the balancing scheme where following conditions should
	 * be checked to determine if a binary tree is balanced. An empty tree is
	 * height-balanced. A non-empty binary tree T is balanced if: 1) Left
	 * subtree of T is balanced 2) Right subtree of T is balanced 3) The
	 * difference between heights of left subtree and right subtree is not more
	 * than 1.
	 * 
	 * This function can also be optimized by calculating height along with the
	 * recursion instead of calling height for every node. (Similar to how it is
	 * done in the diameterOptimization function)
	 * 
	 * @param head
	 * @return boolean
	 */
	public boolean isTreeHeightBalanced(GenericBinaryTreeNode head) {
		if (head == null)
			return true;
		int leftHt = 0, rightHt = 0;
		leftHt = height(head.getLeft());
		rightHt = height(head.getRight());
		if ((Math.abs(leftHt - rightHt) <= 1)
				&& isTreeHeightBalanced(head.getLeft())
				&& isTreeHeightBalanced(head.getRight()))
			return true;
		return false;
	}

	/**
	 * Function to delete a tree
	 * 
	 * @param head
	 * @return void
	 */
	public void deleteTree(GenericBinaryTreeNode<T> head) {
		root = null;
	}

	/**
	 * Function to convert a tree into its mirror. i.e. left becomes right and
	 * right becomes left
	 * 
	 * @param head
	 * @return mirrored tree head
	 */
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

	/**
	 * Function to print the tree paths from the root to each of the leaves.
	 * 
	 * @param head
	 * @param path
	 * @param pathlen
	 *            pathlen is 0 when the program begins
	 * @return void
	 */
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

	/**
	 * Function to count the number of leaf nodes in the tree.
	 * 
	 * @param head
	 * @return int
	 */
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
	 * @return void
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
	 * @return boolean
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
	 * Function to calculate the diameter of a tree. Diameter is the longest
	 * path from any of the leaf to another leaf in the tree. This diameter may
	 * or may not pass via the root. Basically diameter is the max of the
	 * following 3 max height on left subtree + max height on right subtree + 1
	 * longest diameter in the left subtree longest diameter in the right
	 * subtree
	 * 
	 * @param head
	 * @return int
	 */
	public int diameter(GenericBinaryTreeNode<T> head) {
		if (head == null)
			return 0;
		int leftHt = 0, rightHt = 0;
		leftHt = height(head.getLeft());
		rightHt = height(head.getRight());
		return Math.max(leftHt + rightHt + 1,
				Math.max(diameter(head.getLeft()), diameter(head.getRight())));
	}

	public int diameterImproved(GenericBinaryTreeNode<T> head, int[] height) {
		if (head == null) {
			height[0] = 0;
			return 0;
		}
		int[] leftHt = { 0 };
		int[] rightHt = { 0 };

		int lDiam = 0, rDiam = 0;
		lDiam = diameterImproved(head.getLeft(), leftHt);
		rDiam = diameterImproved(head.getRight(), rightHt);

		height[0] = Math.max(leftHt[0], rightHt[0]) + 1;
		return Math.max(leftHt[0] + rightHt[0] + 1, Math.max(lDiam, rDiam));
	}

	/**
	 * Main Test Client for testing various functions of the tree program
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int numberOfNodes=4;
		for(int i=0; i<numberOfNodes; i++){
			list.add(in.nextInt());
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree);
	}
}
