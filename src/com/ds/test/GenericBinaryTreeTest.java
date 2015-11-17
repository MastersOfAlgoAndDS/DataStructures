/**
 * 
 */
package com.ds.test;

import org.junit.Test;

import com.ds.GenericBinaryTree;

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

}
