/**
 * Problem 8.2, pg. 57: Given the root node r of a binary tree, print all the keys in level order at
 * 						r and its descendants. Specifically, the nodes should be printed in order of their level, with all
 * 						keys at a given level in a single line, and the next line corresponding to keys at the next level.
 *						You cannot use recursion. You may use a single queue, and constant additional storage. For
 * 						example, you should print
 * 						314
 * 						6 6
 * 						271 561 2 271
 * 						28 0 3 1 28
 * 						17 401 257
 * 						641
 * 
 * 
 * 
 * Solution: 	We achieve the level wise printing by using queue and 
 * 				sentinel to indicate when to enter a new line.
 * 
 * 
 * 
 * */

package EPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

public class Problem_8_2_LevelOrderBinTree {

	public void levelOrder(GenericBinaryTreeNode<Integer> head) {
		if (head != null) {
			Queue<GenericBinaryTreeNode<Integer>> q = new LinkedList<GenericBinaryTreeNode<Integer>>();
			q.add(head);
			GenericBinaryTreeNode<Integer> sentinel = new GenericBinaryTreeNode<Integer>(
					-999);
			q.add(sentinel);
			while (!q.isEmpty() && q.size() > 1) {
				GenericBinaryTreeNode<Integer> temp = q.remove();
				if (temp == sentinel) {
					System.out.println();
					q.add(sentinel);
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

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(new Integer((int) Math.ceil(Math.random() * 100)));
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree.getRoot());

		Problem_8_2_LevelOrderBinTree p = new Problem_8_2_LevelOrderBinTree();
		p.levelOrder(tree.getRoot());
		System.out.println();

		list = new ArrayList<Integer>();
		list.add(314);
		list.add(6);
		list.add(6);
		list.add(271);
		list.add(561);
		list.add(2);
		list.add(271);
		tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree);

		tree.getRoot().getLeft().getLeft()
				.setLeft(new GenericBinaryTreeNode<Integer>(28));
		tree.getRoot().getLeft().getLeft()
				.setRight(new GenericBinaryTreeNode<Integer>(0));
		tree.getRoot().getLeft().getRight()
				.setRight(new GenericBinaryTreeNode<Integer>(3));
		tree.getRoot().getLeft().getRight().getRight()
				.setLeft(new GenericBinaryTreeNode<Integer>(17));
		tree.getRoot().getRight().getLeft()
				.setRight(new GenericBinaryTreeNode<Integer>(1));
		tree.getRoot().getRight().getLeft().getRight()
				.setLeft(new GenericBinaryTreeNode<Integer>(401));
		tree.getRoot().getRight().getLeft().getRight()
				.setRight(new GenericBinaryTreeNode<Integer>(257));
		tree.getRoot().getRight().getLeft().getRight().getLeft()
				.setRight(new GenericBinaryTreeNode<Integer>(641));
		tree.getRoot().getRight().getRight()
				.setRight(new GenericBinaryTreeNode<Integer>(28));

		System.out.println(tree);
		p.levelOrder(tree.getRoot());
		System.out.println();
	}

}
