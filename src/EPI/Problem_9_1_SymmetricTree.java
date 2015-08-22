/**
 * Problem 9.1 : Write a function that takes as input the root of a binary tree and returns
 * true or false depending on whether the tree is symmetric.
 * 
 * Here we see recursive algorithm
 * */

package EPI;

import java.util.ArrayList;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

public class Problem_9_1_SymmetricTree {
	public boolean isSymmetric(GenericBinaryTreeNode root) {
		if (root == null) {
			return true;
		} else
			return isSymmetricHelper(root.getLeft(), root.getRight());
	}

	public boolean isSymmetricHelper(GenericBinaryTreeNode left,
			GenericBinaryTreeNode right) {
		if (left == null && right == null)
			return true;
		else if (left != null && right != null) {
			return left.getVal() == right.getVal()
					&& isSymmetricHelper(left.getLeft(), right.getRight())
					&& isSymmetricHelper(left.getRight(), right.getLeft());
		} else
			return false;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		for (int i = 1; i < 8; i++) {
			list1.add(i);
		}
		GenericBinaryTree<Integer> tree1 = new GenericBinaryTree<Integer>(list1);
		GenericBinaryTree<Integer> tree2 = new GenericBinaryTree<Integer>(list1);
		System.out.println(tree1);
		System.out.println(tree2);
		tree2.mirrorTree(tree2.getRoot());
		System.out.println(tree2);

		GenericBinaryTree<Integer> parentTree = new GenericBinaryTree<Integer>();
		parentTree.setRoot(new GenericBinaryTreeNode<Integer>(100));
		parentTree.getRoot().setLeft(tree1.getRoot());
		parentTree.getRoot().setRight(tree2.getRoot());
		System.out.println(parentTree);

		Problem_9_1_SymmetricTree p = new Problem_9_1_SymmetricTree();
		System.out.println(p.isSymmetric(parentTree.getRoot()));
	}
}
