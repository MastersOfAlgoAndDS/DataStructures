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
 *  Levelorder tree traversal with levelwise printing - Google Question!!
 *  Size of tree function
 *  Compare identical trees
 *  calculate height/max depth of the tree
 *  isTheTreeHeightBalanced - To determine if a binary tree is height balanced
 *  delete tree
 *  mirror the tree in place
 *  print the paths of the tree from root to each of the leaves.
 *  getting the leaf count
 *  Level order traversal in spiral form - [using two stacks]
 *  Check whether tree conserves the children sum property
 *  Diameter of a tree
 *  Diameter of a tree - 	Optimized. Here the height of the tree is being calculated in the same recursion when the diameter is being calculated. 
 *  						So complexity is O(n) instead of O(n^2) in the simple approach.
 *  						Also another thing noticed was in C program there were pointers to pass the height as a parameter along. However in Java we don;t have pointers, 
 *  						so when the the Simple LinkedList Node was used as a pointer structure, the performance surprisingly degraded instead of improving. Hence the second parameter of the optimized function was changed to a single element array.
 *  To determine if there exists a path - (Root to leaf path) sum equal to a given number or not
 *  Construct Tree from given Inorder and Preorder traversals
 *  PrintAll root to leaf paths
 *  Double Tree - program that converts a given tree to its Double tree. To create Double tree of the given tree, create a new duplicate for each node, and insert the duplicate as the left child of the original node.
 *  Foldable Binary Tree - Given a binary tree, find out if the tree can be folded or not.
 *  isSumTree - A SumTree is a Binary Tree where the value of a node is equal to sum of the nodes present in its left subtree and right subtree. An empty tree is SumTree and sum of an empty tree can be considered as 0. A leaf node is also considered as SumTree.
 *  
 * */

package com.ds;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
				if (currQueueItem.getLeft() == null) {
					if (nextTreeNode.getVal() == null)
						currQueueItem.setLeft(null);
					else
						currQueueItem.setLeft(nextTreeNode);
				} else if (currQueueItem.getRight() == null) {
					if (nextTreeNode.getVal() == null)
						currQueueItem.setRight(null);
					else
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
			System.out.print(head.getVal() + " ");
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
			System.out.print(head.getVal() + " ");
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
			System.out.print(head.getVal() + " ");
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
					System.out.print(curr.getVal() + " ");
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
					System.out.print(curr.getVal() + " ");
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
				System.out.print(temp.getVal() + " ");
				if (temp.getLeft() != null)
					q.add(temp.getLeft());
				if (temp.getRight() != null)
					q.add(temp.getRight());
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
	public void levelOrderLevelwisePrint(GenericBinaryTreeNode<T> head) {
		if (head != null) {
			Queue<GenericBinaryTreeNode<T>> q = new LinkedList<GenericBinaryTreeNode<T>>();
			q.add(head);
			q.add(null);
			while (q.size() > 1) {
				GenericBinaryTreeNode<T> temp = q.remove();
				if (temp == null) {
					System.out.print("\n");
					q.add(null);
				} else {
					System.out.print(temp.getVal() + " ");
					if (temp.getLeft() != null)
						q.add(temp.getLeft());
					if (temp.getRight() != null)
						q.add(temp.getRight());
				}
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
	 * 
	 * 
	 * balance checker by trying to avoid the height calculation everytime but
	 * do height calculation as you go up the tree.
	 * 
	 * This improved algorithm works by checking the height of each subtree as
	 * we recurse down from the root. On each node, we recursively get the
	 * heights of the left and right subtrees through the checkHeight method. If
	 * the subtree is balanced, then check- Height will return the actual height
	 * of the subtree. If the subtree is not balanced, then checkHeight will
	 * return -1. We will immediately break and return -1 from the current call.
	 * 
	 * @Runtime: O(n)
	 * @Space: O(logn)
	 * 
	 * @param head
	 * @param height
	 * @return
	 */
	public boolean isTreeHeightBalancedOptimized(GenericBinaryTreeNode head) {
		return checkTreeHeight(head) != -1;
	}

	/**
	 * 
	 * helper function for isTreeHeightBalancedOptimized
	 * 
	 * @param root
	 * @return
	 */
	private int checkTreeHeight(GenericBinaryTreeNode root) {
		if (root == null)
			return 0;

		// check if left tree is balanced
		int leftHeight = checkTreeHeight(root.getLeft());
		if (leftHeight == -1)
			return -1;

		// check if right tree is balanced
		int rightHeight = checkTreeHeight(root.getRight());
		if (rightHeight == -1)
			return -1;

		// check if the current root is balanced
		if (Math.abs(leftHeight - rightHeight) > 1) {
			return -1;
		}
		return Math.max(leftHeight, rightHeight) + 1;
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
	 *            [path in string till now]
	 * @return void
	 */
	public void printRootToLeafPaths(GenericBinaryTreeNode<T> head, String path) {
		if (head == null) {
			// System.out.println(path);
		} else if (head.getLeft() == null && head.getRight() == null) {
			System.out.println(path + " " + head.getVal());
		} else {
			printRootToLeafPaths(head.getLeft(), path + " " + head.getVal());
			printRootToLeafPaths(head.getRight(), path + " " + head.getVal());
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
					System.out.print(temp.getVal() + " ");
					if (temp.getLeft() != null)
						s2.push(temp.getLeft());
					if (temp.getRight() != null)
						s2.push(temp.getRight());
				}
				System.out.println();
				while (!s2.isEmpty()) {
					GenericBinaryTreeNode<T> temp = s2.pop();
					System.out.print(temp.getVal() + " ");
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
	 * Convert Arbitrary Binary Tree to null
	 * 
	 * @param root
	 */
	public void convertBinTreeToChildrenSumProperty(
			GenericBinaryTreeNode<T> root) {
		if (root == null)
			return;
		else if (root.getLeft() == null && root.getRight() == null)
			return;
		else {
			convertBinTreeToChildrenSumProperty(root.getLeft());
			convertBinTreeToChildrenSumProperty(root.getRight());
			int leftVal = (Integer) (root.getLeft() == null ? 0 : root
					.getLeft().getVal());
			int rightVal = (Integer) (root.getRight() == null ? 0 : root
					.getRight().getVal());
			int diff = leftVal + rightVal - (Integer) root.getVal();
			if (diff == 0)
				return;
			else if (diff > 0) {
				root.setVal(Integer.valueOf(root.getVal().toString()) + diff);
			} else if (diff < 0) {
				if (root.getLeft() != null) {
					root.getLeft().setVal(
							Integer.valueOf(root.getLeft().getVal().toString())
									- diff);
					convertBinTreeToChildrenSumProperty(root.getLeft());
				} else {
					root.getRight()
							.setVal(Integer.valueOf(root.getRight().getVal()
									.toString())
									- diff);
					convertBinTreeToChildrenSumProperty(root.getRight());

				}
			}
		}
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

	/**
	 * Function to calculate the diameter of a tree. Diameter is the longest
	 * path from any of the leaf to another leaf in the tree. This diameter may
	 * or may not pass via the root. Basically diameter is the max of the
	 * following 3 max height on left subtree + max height on right subtree + 1
	 * longest diameter in the left subtree longest diameter in the right
	 * subtree
	 * 
	 * In this function along with the tree head, the height array is also
	 * passed in recursion to calculate height as we go down the tree. Array is
	 * the main reason since array is pass by value, i.e. as we go down the tree
	 * the value stored in array is saved in array and continue downwards.
	 * 
	 * @param head
	 * @param height
	 * @return
	 */
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
	 * This method determines if there exists a path - (Root to leaf path) sum
	 * equal to a given number or not
	 * 
	 * 
	 * @param root
	 * @param sum
	 * @param given
	 * @return
	 */
	private boolean rootLeafPathSumCompare(GenericBinaryTreeNode<T> root,
			int sum, int given) {
		if (root == null) {
			if (given == sum)
				return true;
			return false;
		} else {
			sum += Integer.valueOf(root.getVal().toString());
			return rootLeafPathSumCompare(root.getLeft(), sum, given)
					|| rootLeafPathSumCompare(root.getRight(), sum, given);
		}
	}

	public boolean rootLeafPathSumCompare(GenericBinaryTreeNode<T> root,
			int given) {
		if (root == null && given == 0)
			return true;
		else
			return rootLeafPathSumCompare(root, 0, given);
	}

	public GenericBinaryTreeNode<Integer> constructFromInPre(
			ArrayList<Integer> preorder, ArrayList<Integer> inorder,
			GenericBinaryTreeNode<Integer> root) {

		ArrayList<Integer> inleft = new ArrayList<Integer>();
		ArrayList<Integer> inright = new ArrayList<Integer>();
		ArrayList<Integer> preleft = new ArrayList<Integer>();
		ArrayList<Integer> preright = new ArrayList<Integer>();

		if (preorder.size() > 0) {
			// get the root current from the preorder string
			root = new GenericBinaryTreeNode<Integer>(preorder.get(0));
			preorder.remove(0);

			// set left and right parts of the sub problem based on root
			// position in inorder string
			boolean flag = false;
			HashMap<Integer, Boolean> ignoreList = new HashMap<Integer, Boolean>();
			int i = 0;

			while (i < inorder.size()) {
				// if root is found in inorder string then set flag
				if (inorder.get(i) == root.getVal()) {
					flag = true;
				} else if (flag == false) {
					inleft.add(inorder.get(i));
					ignoreList.put(inorder.get(i), true);
				} else {
					inright.add(inorder.get(i));
				}
				i++;
			}

			// prepare new preorder strings for subproblems
			i = 0;
			while (i < preorder.size()) {
				if (ignoreList.containsKey(preorder.get(i))) {
					preleft.add(preorder.get(i));
				} else {
					preright.add(preorder.get(i));
				}
				i++;
			}
			root.setLeft(constructFromInPre(preleft, inleft, root.getLeft()));
			root.setRight(constructFromInPre(preright, inright, root.getRight()));
		}
		return root;

	}

	/**
	 * 
	 * program that converts a given tree to its Double tree. To create Double
	 * tree of the given tree, create a new duplicate for each node, and insert
	 * the duplicate as the left child of the original node.
	 * 
	 * @param root
	 */
	public void doubleTree(GenericBinaryTreeNode<T> root) {
		if (root != null) {
			GenericBinaryTreeNode<T> newNode = new GenericBinaryTreeNode<T>(
					root.getVal());
			newNode.setLeft(root.getLeft());
			root.setLeft(newNode);
			doubleTree(newNode.getLeft());
			doubleTree(root.getRight());
		}
	}

	public boolean isFoldable(GenericBinaryTree<T> tree) {
		if (tree.getRoot() == null || tree == null)
			return true;
		else
			return isStructurallyMirror(tree.getRoot().getLeft(), tree
					.getRoot().getRight());
	}

	private boolean isStructurallyMirror(GenericBinaryTreeNode<T> left,
			GenericBinaryTreeNode<T> right) {
		if (left == null && right == null)
			return true;
		else if ((left != null && right == null)
				|| (left == null && right != null))
			return false;
		return isStructurallyMirror(left.getLeft(), right.getRight())
				&& isStructurallyMirror(left.getRight(), right.getLeft());
	}

	public boolean isLeaf(GenericBinaryTreeNode<T> node) {
		if (node.getLeft() == null && node.getRight() == null)
			return true;
		return false;
	}

	/**
	 * returns true if the given Binary Tree is SumTree else false
	 * 
	 * @param root
	 * @return
	 */
	public boolean isSumTree(GenericBinaryTreeNode<T> root) {
		int leftSum;
		int rightSum;
		// if root is null or leaf node, then it is a sumTree
		if (root == null || (root.getLeft() == null && root.getRight() == null)) {
			return true;
		}
		if (isSumTree(root.getLeft()) && isSumTree(root.getRight())) {
			if (root.getLeft() == null)
				leftSum = 0;
			else if (root.getLeft().getLeft() == null
					&& root.getLeft().getRight() == null) {
				leftSum = Integer.valueOf(root.getLeft().getVal().toString());
			} else {
				leftSum = 2 * Integer.valueOf(root.getLeft().getVal()
						.toString());
			}

			if (root.getRight() == null)
				rightSum = 0;
			else if (root.getRight().getLeft() == null
					&& root.getRight().getRight() == null) {
				rightSum = Integer.valueOf(root.getRight().getVal().toString());
			} else {
				rightSum = 2 * Integer.valueOf(root.getRight().getVal()
						.toString());
			}

			if (Integer.valueOf(root.getVal().toString()) == leftSum + rightSum) {
				return true;
			} else
				return false;
		}
		return false;
	}

	/**
	 * Given a sorted (increasing order) array list with unique integer elements
	 * we create a binary search tree with minimal height.
	 * 
	 * @param list
	 * @param start
	 * @param end
	 * @return
	 */
	public static GenericBinaryTreeNode<Integer> createBSTFromList(
			ArrayList<Integer> list, int start, int end) {
		if (list == null || end < start)
			return null;

		int middle = (start + end) / 2; // getting the middle is the trick.
		GenericBinaryTreeNode<Integer> root = new GenericBinaryTreeNode<Integer>(
				list.get(middle));
		// if (start < middle)
		root.setLeft(createBSTFromList(list, start, middle - 1));
		// if (middle < end)
		root.setRight(createBSTFromList(list, middle + 1, end));
		return root;
	}

	/**
	 * Main Test Client for testing various functions of the tree program
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		// testIsTreeHeightBalanced();
		createSampleBST(20);
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
		tree.preOrderRecur(tree.getRoot());
		System.out.println();
		tree.preOrder(tree);
		System.out.println();
		tree.inOrderRecur(tree.getRoot());
		System.out.println();
		tree.inOrder(tree);
		System.out.println();
		tree.postOrderRecur(tree.getRoot());
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
	 * 
	 * @param int numOfNodes
	 * @return tree
	 */
	public static GenericBinaryTree createSampleTree(int numOfNodes) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 1; i <= numOfNodes; i++) {
			list.add(i);
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		return tree;
	}

	/**
	 * Function to create a sample tree for testing. This is the function mostly
	 * changed for any test performed.
	 * 
	 * @return tree
	 */
	public static GenericBinaryTree createSampleTree(int[] array) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			list.add(array[i]);
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		return tree;
	}

	/**
	 * Function to create a sample Binary Search tree for testing. This is the
	 * function mostly changed for any test performed.
	 * 
	 * @return tree
	 */
	public static GenericBinaryTree createSampleBST() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = 7;
		for (int i = 0; i < size; i++) {
			list.add(i + 0);
		}
		System.out.println(list);
		GenericBinaryTreeNode<Integer> root = createBSTFromList(list, 0,
				size - 1);
		GenericBinaryTree tree = new GenericBinaryTree<Integer>();
		tree.setRoot(root);
		return tree;
	}

	/**
	 * Function to create a sample Binary Search Tree for testing. This is the
	 * function mostly changed for any test performed. But this method will
	 * create a randomized tree with random values every time it is called.
	 * 
	 * @return tree
	 */
	public static GenericBinaryTree createSampleBST(int n) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = n;
		for (int i = 0; i < size; i++) {
			list.add((int) (Math.random() * size * 5));
		}

		Collections.sort(list);
		System.out.println(list);
		GenericBinaryTreeNode<Integer> root = createBSTFromList(list, 0,
				size - 1);
		GenericBinaryTree tree = new GenericBinaryTree<Integer>();
		tree.setRoot(root);
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
				+ tree.diameterImproved(tree.getRoot(), new int[] { 0 }));
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
				+ tree.diameterImproved(tree.getRoot(), new int[] { 0 }));
	}

	public static void testIsTreeHeightBalanced() {
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
		System.out.println("Tree Created: " + tree);
		// Code to add extra leaf node in the left subtree so that the tree is
		// imbalanced and test fails.
		// tree.getRoot().getLeft().getLeft().getLeft()
		// .setLeft(new GenericBinaryTreeNode<Integer>(100));
		// System.out.println("One more leaf added: " + tree);

		// Code to remove some child nodes from the left subtree to actually
		// make only the left subtree of the root imbalanced in height. The code
		// should give false output.
		// tree.getRoot().getLeft().setRight(null);

		System.out
				.println("The tree after impairing right child of the left subtree: ");
		System.out.println(tree);
		System.out.println(tree.isTreeHeightBalancedOptimized(tree.getRoot()));

		tree = new GenericBinaryTree<Integer>();
		tree.setRoot(new GenericBinaryTreeNode<Integer>(1));
		tree.getRoot().setRight(new GenericBinaryTreeNode<Integer>(2));
		tree.getRoot().getRight()
				.setRight(new GenericBinaryTreeNode<Integer>(3));
		System.out.println(tree.isTreeHeightBalancedOptimized(tree.getRoot()));
	}

}
