package ctci_5E;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @Problem: You have two very large binary trees: Tl, with millions of nodes,
 *           and T2, with hundreds of nodes. Create an algorithm to decide if T2
 *           is a subtree of Tl. A tree T2 is a subtree of Tl if there exists a
 *           node n in Tl such that the subtree ofn is identical to T2. That is,
 *           if you cut off the tree at node n, the two trees would be
 *           identical.
 * 
 * @Solution: 1. One approach can be to get the preorder and inorder traversals
 *            of T1 and T2 and then check if T2 traversal string is a substring
 *            of T1 traversal. HOWEVER - CARE needs to be taken to represent
 *            null nodes also with some sentinel or unique characters.
 * 
 *            BETTER APPROACH Search the root of T2 in T1 and then match the
 *            trees to find your T2 in the T1 tree.
 * 
 * @author Milind
 *
 */
public class P4_8_CheckIfSubtree {

	public static boolean isT2SubtreeOfT2(GenericBinaryTreeNode rootT1,
			GenericBinaryTreeNode rootT2) {
		if (rootT1 == null)
			return false;
		if (rootT2 == null)
			return true;
		GenericBinaryTreeNode node = rootT1.searchNode(rootT1,
				(int) rootT2.getVal());
		if (node != null) {
			return matchTrees(node, rootT2);
		}
		return false;
	}

	public static boolean matchTrees(GenericBinaryTreeNode rootT1,
			GenericBinaryTreeNode rootT2) {
		if (rootT1 == null && rootT2 == null)
			return true;
		if (rootT1 == null || rootT2 == null)
			return false;
		if (rootT1.getVal() != rootT2.getVal())
			return false;
		return matchTrees(rootT1.getLeft(), rootT2.getLeft())
				&& matchTrees(rootT1.getRight(), rootT2.getRight());
	}

	public static void main(String[] args) {
		GenericBinaryTree tree2 = GenericBinaryTree.createSampleTree(8);
		GenericBinaryTree tree1 = GenericBinaryTree.createSampleTree(8);
		tree2.inOrder(tree2);
		System.out.println();
		GenericBinaryTreeNode node = new GenericBinaryTreeNode<Integer>(20);
		node.setLeft(tree1.getRoot());
		tree1.setRoot(node);
		tree1.getRoot().setRight(new GenericBinaryTreeNode(18));
		tree1.inOrder(tree1);
		System.out.println();
		// tree1 = GenericBinaryTree.createSampleBST();
		System.out.println(isT2SubtreeOfT2(tree1.getRoot(), tree2.getRoot()));
	}
}
