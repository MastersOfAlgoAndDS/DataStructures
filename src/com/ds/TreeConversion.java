/**
 * Convert an arbitrary Binary Tree to a tree that holds Children Sum Property
 * Must revise again!!
 * To see the detailed problem statement go to the link below: 
 * http://www.geeksforgeeks.org/convert-an-arbitrary-binary-tree-to-a-tree-that-holds-children-sum-property/
 */
package com.ds;

import java.util.ArrayList;

/**
 * @author Milind
 *
 */
public class TreeConversion {

	public static void convertTree(GenericBinaryTreeNode<Integer> head) {
		int leftVal = 0, rightVal = 0, diff = 0;
		if (head == null || (head.getLeft() == null && head.getRight() == null))
			return;
		else {
			convertTree(head.getLeft());
			convertTree(head.getRight());

			if (head.getLeft() != null)
				leftVal = head.getLeft().getVal();

			if (head.getRight() != null)
				rightVal = head.getRight().getVal();

			diff = leftVal + rightVal - head.getVal();

			if (diff > 0)
				head.setVal(head.getVal() + diff);

			if (diff < 0) // THis is quite tricky as to why call the increment
							// function rather than directly increment the left
							// node's data value.
				increment(head, -diff);

		}
	}

	private static void increment(GenericBinaryTreeNode<Integer> head,
			int difference) {
		if (head.getLeft() != null) {
			head.getLeft().setVal(head.getLeft().getVal() + difference);
			increment(head.getLeft(), difference);
		} else if (head.getRight() != null) {
			head.getRight().setVal(head.getRight().getVal() + difference);
			increment(head.getRight(), difference);
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(50);
		list.add(7);
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(1);
		list.add(30);

		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);

		System.out.println("Tree:" + tree);
		tree.isChildrenSumPropertyValid(tree.getRoot());
		convertTree(tree.getRoot());
		System.out.println("Tree:" + tree);
		System.out.println(tree.isChildrenSumPropertyValid(tree.getRoot()));

	}

}
