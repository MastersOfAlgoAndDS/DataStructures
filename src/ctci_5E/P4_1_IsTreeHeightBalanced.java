package ctci_5E;

import java.util.ArrayList;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @Problem: Implement a function to check if a binary tree is balanced. For the
 *           purposes of this question, a balanced tree is defined to be a tree
 *           such that the heights of the two subtrees of any node never differ
 *           by more than one
 * 
 * @Solution As solved in the GenericBinaryTree class in com.ds package and also
 *           described in the comments below
 * 
 * @author Milind
 *
 */
public class P4_1_IsTreeHeightBalanced {

	/**
	 * 
	 * Function to calculate the height of the tree. I.e. maximum depth if the
	 * tree is unbalanced.
	 * 
	 * @param head
	 * @return int
	 */
	public int height(GenericBinaryTreeNode<Integer> head) {
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
	 * Main Test Client for testing various functions of the tree program
	 * 
	 * @param args
	 * @return void
	 */
	public static void main(String[] args) {
		testIsTreeHeightBalanced();
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
