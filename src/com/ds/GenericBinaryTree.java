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
 * @author Milind Gokhale
 * 
 * @Info This program is specially written for easier and quicker test data
 *       preparation of various problems related to binary trees. The input
 *       needs to be a ArrayList of the data structure whose tree is to be
 *       created.
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
	 * @return boolean
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
	 * @return void
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
	 * @return void
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
	 * @return void
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
	 * @return void
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

	public int diameterImproved(GenericBinaryTreeNode<T> head,
			GenericNode<Integer> height) {
		if (head == null) {
			height.setVal(0);
			return 0;
		}
		GenericNode<Integer> leftHt = new GenericNode<Integer>(0);
		GenericNode<Integer> rightHt = new GenericNode<Integer>(0);

		int lDiam = 0, rDiam = 0;
		lDiam = diameterImproved(head.getLeft(), leftHt);
		rDiam = diameterImproved(head.getRight(), rightHt);

		height.setVal(Math.max(leftHt.getVal(), rightHt.getVal()) + 1);
		return Math.max(leftHt.getVal() + rightHt.getVal() + 1,
				Math.max(lDiam, rDiam));
	}

	/**
	 * Main Test Client for testing various functions of the tree program
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		// Object[] a = new Object[1000];
		// tree.printPaths(tree.getRoot(),(Integer[]) a,0);
		GenericBinaryTree<Integer> tree = createSampleTree(999999);
		long start=System.currentTimeMillis();
		testDiameterImproved(tree);
		long time = System.currentTimeMillis()-start;
		System.out.println("Time required for this function: " + time + " secs");
		
		start=System.currentTimeMillis();
		testDiameter(tree);
		time = System.currentTimeMillis()-start;
		System.out.println("Time required for this function: " + time + " secs");
		
	}

	/**
	 * Function to take input of the tree from user
	 * 
	 * @return tree
	 */
	public static GenericBinaryTree takeTreeInput() {
		Scanner in = new Scanner(System.in);
		int numberOfNodes = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numberOfNodes; i++) {
			list.add(in.nextInt());
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println("Tree Created.");
		System.out.println(tree);
		return tree;
	}

	/**
	 * Function to print the various tree traversals taking the input of the
	 * treeas paramter.
	 * 
	 * @param tree
	 * @return void
	 */
	public static void testTreeTraversals(GenericBinaryTree tree) {
		tree.preOrder(tree.getRoot());
		System.out.println();
		tree.inOrder(tree.getRoot());
		System.out.println();
		tree.postOrder(tree.getRoot());
		System.out.println();
		tree.levelOrder(tree.getRoot());
		System.out.println();
		tree.levelOrderSpiral(tree.getRoot());

	}

	/**
	 * Function to test the mirror tree function
	 * 
	 * @return void
	 */
	public static void testMirrorTree() {
		GenericBinaryTree tree = createSampleTree();
		System.out.println("Before mirroring the tree: ");
		System.out.println(tree.getRoot());
		System.out.println("After mirroring the tree: ");
		System.out.println(tree.mirrorTree(tree.getRoot()));
		tree.mirrorTree(tree.getRoot());

	}

	/**
	 * Function to test the delete tree function
	 * 
	 * @return void
	 */
	public static void testDeleteTree() {
		GenericBinaryTree<Integer> treeRandom = new GenericBinaryTree<Integer>();
		treeRandom.setRoot(new GenericBinaryTreeNode<Integer>(20));
		treeRandom.getRoot().setLeft(new GenericBinaryTreeNode<Integer>(10));
		treeRandom.getRoot().getLeft()
				.setLeft(new GenericBinaryTreeNode<Integer>(30));
		treeRandom.getRoot().getLeft().getLeft()
				.setLeft(new GenericBinaryTreeNode<Integer>(40));
		treeRandom.getRoot().setRight(new GenericBinaryTreeNode<Integer>(70));
		System.out.println(treeRandom.toString());
		System.out.println("Height of random tree is: "
				+ treeRandom.height(treeRandom.getRoot()));

		System.out.println("Tree before deleting: " + treeRandom);
		treeRandom.deleteTree(treeRandom.getRoot());
		System.out.println("Tree after deleting: " + treeRandom);

	}

	/**
	 * Function to test the sametrees function.
	 * 
	 * @return void
	 * 
	 */
	public static void testIdenticalTrees() {
		GenericBinaryTree tree1 = createSampleTree();
		GenericBinaryTree tree2 = createSampleTree();
		tree1.sameTrees(tree1.getRoot(), tree2.getRoot());
	}

	/**
	 * Function to create a sample tree for testing. This is the function mostly
	 * changed for any test performed.
	 * 
	 * @return tree
	 */
	public static GenericBinaryTree createSampleTree() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		return tree;
	}

	/**
	 * Function to create a sample tree for testing given input number of nodes
	 * in the tree. This is the function mostly changed for any test performed.
	 * @param int numOfNodes
	 * @return tree
	 */
	public static GenericBinaryTree createSampleTree(int numOfNodes) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=numOfNodes; i++){
			list.add(i);
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		return tree;
	}

	/**
	 * Function to test the height and size of the tree functions.
	 * 
	 * @return void
	 */
	public static void testHeightSizeAndLeafCount() {
		GenericBinaryTree tree = createSampleTree();
		System.out.println();
		System.out.println("Tree size is: " + tree.size(tree.getRoot()));
		System.out.println("Height of the tree is: "
				+ tree.height(tree.getRoot()));
		System.out.println("Number of leaf nodes is: "
				+ tree.getLeafCount(tree.getRoot()));

	}

	/**
	 * Function to test isChildrenSumPropertyValid tree function
	 * 
	 * @return void
	 */
	public static void testIsChildrenSumProperty() {
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(10);
		list3.add(8);
		list3.add(2);
		list3.add(3);
		list3.add(5);
		list3.add(2);

		GenericBinaryTree<Integer> tree3 = new GenericBinaryTree<Integer>(list3);
		System.out.println(tree3.isChildrenSumPropertyValid(tree3.getRoot()));

	}

	/**
	 * Function to test the diameter function.
	 * 
	 * @return void
	 */
	public static void testDiameter() {
		// diameter test
		ArrayList<Integer> list = new ArrayList<Integer>();
		// list4.add(1);
		// list4.add(2);
		// list4.add(3);
		// list4.add(4);
		// list4.add(5);

		list.add(10);
		list.add(15);
		list.add(5);
		list.add(7);
		list.add(4);
		list.add(3);
		list.add(12);
		list.add(6);
		list.add(17);

		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println("Diameter of tree is:"
				+ tree.diameter(tree.getRoot()));
	}

	/**
	 * Function to test the diameter function given a tree as input.
	 * 
	 * @param GenericBinaryTree
	 *            tree
	 * @return void
	 */
	public static void testDiameter(GenericBinaryTree tree) {
		System.out.println("Diameter of tree is:"
				+ tree.diameter(tree.getRoot()));
	}

	/**
	 * Function to test the diameter function.
	 * 
	 * @return void
	 */
	public static void testDiameterImproved() {
		// diameter test
		ArrayList<Integer> list = new ArrayList<Integer>();
		// list4.add(1);
		// list4.add(2);
		// list4.add(3);
		// list4.add(4);
		// list4.add(5);

		list.add(10);
		list.add(15);
		list.add(5);
		list.add(7);
		list.add(4);
		list.add(3);
		list.add(12);
		list.add(6);
		list.add(17);

		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println("Diameter of tree with improved algorithm is:"
				+ tree.diameterImproved(tree.getRoot(),
						new GenericNode<Integer>(0)));
	}

	/**
	 * Function to test the diameter function given a tree as input.
	 * 
	 * @param GenericBinaryTree
	 *            tree
	 * @return void
	 */
	public static void testDiameterImproved(GenericBinaryTree tree) {
		System.out.println("Diameter of tree with improved algorithm is:"
				+ tree.diameterImproved(tree.getRoot(),
						new GenericNode<Integer>(0)));
	}

}
