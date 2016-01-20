/**
 * 
 */
package com.ds.test;

import java.util.ArrayList;

import org.junit.Test;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @author Milind
 *
 */
public class GenericBinaryTreeTest {

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#preOrderRecur(com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testPreOrderRecur() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.preOrderRecur(tree.getRoot());
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#inOrderRecur(com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testInOrderRecur() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.inOrderRecur(tree.getRoot());
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#postOrderRecur(com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testPostOrderRecur() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.postOrderRecur(tree.getRoot());
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#preOrder(com.ds.GenericBinaryTree)}.
	 */
	@Test
	public void testPreOrder() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.preOrder(tree);
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#inOrder(com.ds.GenericBinaryTree)}.
	 */
	@Test
	public void testInOrder() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.inOrder(tree);
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#levelOrder(com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testLevelOrder() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(9);
		tree.levelOrder(tree.getRoot());
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#doubleTree(com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testDoubleTree() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(5);
		tree.doubleTree(tree.getRoot());
		tree.preOrder(tree);
		System.out.println();
		tree.levelOrderLevelwisePrint(tree.getRoot());

	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#constructFromInPre(java.util.ArrayList, java.util.ArrayList, com.ds.GenericBinaryTreeNode)}
	 * .
	 */
	@Test
	public void testConstructFromInPre() throws Exception {
		ArrayList<Integer> inorder = new ArrayList<>();
		inorder.add(4);
		inorder.add(2);
		inorder.add(5);
		inorder.add(1);
		inorder.add(6);
		inorder.add(7);
		inorder.add(3);
		inorder.add(8);

		ArrayList<Integer> preorder = new ArrayList<Integer>();
		preorder.add(1);
		preorder.add(2);
		preorder.add(4);
		preorder.add(5);
		preorder.add(3);
		preorder.add(7);
		preorder.add(6);
		preorder.add(8);

		GenericBinaryTreeNode<Integer> constructedTreeRoot = null;
		GenericBinaryTree<Integer> constructedTree = new GenericBinaryTree<Integer>();
		try {
			constructedTreeRoot = constructedTree.constructFromInPre(preorder,
					inorder, new GenericBinaryTreeNode<Integer>(null));
		} catch (Exception e) {
			e.printStackTrace();
			constructedTree.levelOrderLevelwisePrint(constructedTreeRoot);
		}
		constructedTree.setRoot(constructedTreeRoot);
		constructedTree.levelOrderLevelwisePrint(constructedTreeRoot);
		System.out.println();
		constructedTree.inOrder(constructedTree);
		System.out.println();
	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#isFoldable(com.ds.GenericBinaryTree)}.
	 */
	@Test
	public void testIsFoldable() throws Exception {
		GenericBinaryTree<Integer> tree = GenericBinaryTree.createSampleTree(6);
		tree.levelOrderLevelwisePrint(tree.getRoot());
		System.out.println();
		System.out.println(tree.isFoldable(tree));
		System.out.println();
		tree.setRoot(new GenericBinaryTreeNode<Integer>(10));
		tree.getRoot().setLeft(new GenericBinaryTreeNode<Integer>(7));
		tree.getRoot().setRight(new GenericBinaryTreeNode<Integer>(15));
		tree.getRoot().getLeft()
				.setRight(new GenericBinaryTreeNode<Integer>(9));
		tree.getRoot().getRight()
				.setLeft(new GenericBinaryTreeNode<Integer>(11));
		tree.levelOrderLevelwisePrint(tree.getRoot());
		System.out.println();
		System.out.println(tree.isFoldable(tree));

	}

	/**
	 * Test method for
	 * {@link com.ds.GenericBinaryTree#isSumTree(com.ds.GenericBinaryTreeNode)}.
	 */
	@Test
	public void testIsSumTree() throws Exception {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(26);
		list.add(10);
		list.add(3);
		list.add(4);
		list.add(6);
		list.add(null);
		list.add(3);
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<>(list);
		tree.levelOrderLevelwisePrint(tree.getRoot());
		System.out.println();
		System.out.println(tree.isSumTree(tree.getRoot()));

	}

}
