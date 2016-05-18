package ctci_5E;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * 
 * 
 * 
 * @solution: Here in base case we check whether both root and its subtrees on
 *            both sides follow the property of BST ie. min<=root<max
 * 
 * @author Milind
 *
 */
public class P4_5_CheckBST {

	public static boolean checkBST(GenericBinaryTreeNode root) {
		return checkBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == true;
	}

	/**
	 * Here in base case we check whether both root and its subtrees on both
	 * sides follow the property of BST ie. min<=root<max
	 * 
	 * @param root
	 * @param minValue
	 * @param maxValue
	 * @return
	 */
	private static boolean checkBSTHelper(GenericBinaryTreeNode<Integer> root,
			int minValue, int maxValue) {
		if (root == null)
			return true;
		// if root satisfies the property of BST and left subtree and right
		// subtree also satisfy the property of BST only then its true;
		return root.getVal() >= minValue
				&& root.getVal() < maxValue
				&& checkBSTHelper(root.getLeft(), minValue, root.getVal())
				&& checkBSTHelper(root.getRight(), root.getVal(), maxValue) == true;
	}

	public static void main(String[] args) {
		GenericBinaryTree tree = GenericBinaryTree.createSampleBST(20);
		tree.levelOrderLevelwisePrint(tree.getRoot());
		System.out.println();
		tree.inOrder(tree);
		System.out.println();
		// tree = GenericBinaryTree.createSampleTree();
		System.out.println(checkBST(tree.getRoot()));
	}

}
