package ctci_5E;

import com.ds.GenericBinTreeNodeWParent;

/**
 * @Problem: Write an algorithm to find the 'next'node (i.e., in-order
 *           successor) of a given node in a binary search tree. You may assume
 *           that each node has a link to its parent.
 * 
 * @solution: We follow 3 cases
 * 
 *            // Case 1: I am parent and want to find successor in right
 *            subtree. Then // successor is the leftmost node in the right
 *            subtree.
 * 
 *            // Case 2: I am child but I am on the right side of the parent.
 *            Then // successor is the parent such that my subtree is on the
 *            left of this // parent.
 * 
 *            // Case 3: I am child but I am left child of my parent, then this
 *            parent // directly is the successor
 * 
 * 
 * @author Milind
 *
 */
public class P4_6_SuccessorNode {

	/**
	 * Gets the leftmost child of the node. If there is no left child, then
	 * returns self as the leftmost child
	 * 
	 * @param node
	 * @return
	 */
	public static GenericBinTreeNodeWParent getLeftMostChildNode(
			GenericBinTreeNodeWParent node) {
		GenericBinTreeNodeWParent leftMostChild = node;
		while (leftMostChild.getLeft() != null) {
			leftMostChild = leftMostChild.getLeft();
		}
		return leftMostChild;
	}

	public static GenericBinTreeNodeWParent getSuccessor(
			GenericBinTreeNodeWParent node) {
		// three cases,
		// Case 1: I am parent and want to find successor in right subtree. Then
		// successor is the leftmost node in the right subtree.
		if (node.getRight() != null) {
			return getLeftMostChildNode(node.getRight());
		}

		// Case 2: I am child but I am on the right side of the parent. Then
		// successor is the parent such that my subtree is on the left of this
		// parent.
		GenericBinTreeNodeWParent mayBeParent = node.getParent();
		while (mayBeParent != null && node != mayBeParent.getLeft()) {
			node = mayBeParent;
			mayBeParent = node.getParent();
		}

		// Case 3: I am child but I am left child of my parent, then this parent
		// directly is the successor
		return mayBeParent;
	}

	public static void main(String[] args) {
		GenericBinTreeNodeWParent root = GenericBinTreeNodeWParent
				.createSampleBSTWithParents();
		System.out.println(root);
		System.out.println(getSuccessor(root));
		System.out.println(getSuccessor(root.getLeft()));
		System.out.println(getSuccessor(root.getLeft().getLeft()));
		System.out.println(getSuccessor(root.getLeft().getRight()));
	}
}
