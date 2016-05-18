package ctci_5E;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @Problem: Design an algorithm and write code to find the first common
 *           ancestor of two nodes in a binary tree. Avoid storing additional
 *           nodes in a data structure. NOTE: This is not necessarily a binary
 *           search tree.
 * 
 * @Solution: If we have parent links - then answer is straight. Keep Comparing
 *            parents until they become same.
 * 
 *            But expected answer is without parent links. can be done using
 *            recursion with cases
 * 
 *            case 1. p and q are same nodes
 * 
 *            case 2. p and q are on the same side of the tree. then we go ahead
 *            and get deep in the subtree.
 * 
 *            case 3. P and q are not on the same side of the tree, then sub
 *            cases
 * 
 *            // 31. either root itself is common ancestor -
 * 
 *            // a. because both nodes are present on either sides OR
 * 
 *            // b. because one of the p and q is the common ancestor
 * 
 *            // 32. Both the nodes or one of the nodes is not present in the
 *            tree.
 * 
 * 
 * @author Milind
 *
 */
public class P4_7_CommonAncestor {

	/**
	 * Returns true if p is contained in the subtree of root
	 * 
	 * @param root
	 * @param p
	 * @return
	 */
	public static boolean covers(GenericBinaryTreeNode root,
			GenericBinaryTreeNode p) {
		if (root == null)
			return false;
		if (root == p)
			return true;
		return covers(root.getLeft(), p) || covers(root.getRight(), p);
	}

	public static GenericBinaryTreeNode getCommonAncestorBasicHelper(
			GenericBinaryTreeNode root, GenericBinaryTreeNode p,
			GenericBinaryTreeNode q) {
		if (root == null)
			return null;
		if (root == p || root == q)
			return root;

		boolean is_p_on_left = covers(root.getLeft(), p);
		boolean is_q_on_left = covers(root.getLeft(), q);

		// if both p and q are not on the left, that means both are on the
		// either side of root and thus root is the common ancestor.
		if (is_p_on_left != is_q_on_left)
			return root;

		GenericBinaryTreeNode child_side = is_p_on_left ? root.getLeft() : root
				.getRight();
		return getCommonAncestorBasicHelper(child_side, p, q);

	}

	/**
	 * This function will do a check whether both the nodes are actually present
	 * in the tree and if any of them is not present, will return null as common
	 * ancestor.
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static GenericBinaryTreeNode getCommonAncestorBasic(
			GenericBinaryTreeNode root, GenericBinaryTreeNode p,
			GenericBinaryTreeNode q) {
		if (!covers(root, p) || !covers(root, q))
			return null;
		return getCommonAncestorBasicHelper(root, p, q);
	}

	/**
	 * in finding the common ancestor of p and q, the calling function can't
	 * distinguish between the two cases:
	 * 
	 * • Case 1: p is a child of q (or, q is a child of p)
	 * 
	 * • Case 2: p is in the tree and q is not (or, q is in the tree and p is
	 * not)
	 * 
	 * We somehow need to distinguish between these two cases, and this is what
	 * the code below does. This code solves the problem by returning two
	 * values: the node itself and a flag indicating whether this node is
	 * actually the common ancestor.
	 * 
	 * @author Milind
	 *
	 */
	static class Result {
		private GenericBinaryTreeNode node;
		private boolean ancestor;

		public Result(GenericBinaryTreeNode node, boolean isAncestor) {
			this.node = node;
			this.ancestor = isAncestor;
		}

		public GenericBinaryTreeNode getNode() {
			return node;
		}

		public boolean isAncestor() {
			return ancestor;
		}

	}

	/**
	 * optimized helper funcion
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static Result getCommonAncestorOptimizedHelper(
			GenericBinaryTreeNode root, GenericBinaryTreeNode p,
			GenericBinaryTreeNode q) {
		if (root == null)
			return new Result(null, false);
		if (root == p && root == q) // p and q are same nodes
			return new Result(root, true);

		// Found common ancestor on left side
		Result rx = getCommonAncestorOptimizedHelper(root.getLeft(), p, q);
		if (rx.isAncestor())
			return rx;

		// Found common ancestor on right side
		Result ry = getCommonAncestorOptimizedHelper(root.getRight(), p, q);
		if (ry.isAncestor())
			return ry;

		// did not find common ancestor in both sides.
		// So
		// 1. either root itself is common ancestor -
		// a. because both nodes are present on either sides OR
		// b. because one of the p and q is the common ancestor
		// 2. Both the nodes or one of the nodes is not present in the tree.
		//
		if (rx.getNode() != null && ry.getNode() != null) // CASE 1.a Found p
															// and q on
															// either side of
															// the tree.
			return new Result(root, true);
		else if (root == p || root == q) { // either p or q is the root
											// so it can be case 1.b or case 2
			boolean ancestor = rx.getNode() != null || ry.getNode() != null ? true
					: false; // if case 1.b then true else false
			return new Result(root, ancestor);
		} else {
			return new Result(rx.getNode() != null ? rx.getNode() // case 2.
																	// Either
																	// one of
																	// the node
																	// or both
																	// are not
																	// present
																	// in the
																	// tree
					: ry.getNode(), false);
		}
	}

	/**
	 * optimized function using Result class
	 * 
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public static GenericBinaryTreeNode getCommonAncestorOptimized(
			GenericBinaryTreeNode root, GenericBinaryTreeNode p,
			GenericBinaryTreeNode q) {
		Result r = getCommonAncestorOptimizedHelper(root, p, q);
		if (r.isAncestor())
			return r.getNode();
		return null;
	}

	public static void main(String[] args) {
		GenericBinaryTree tree = GenericBinaryTree.createSampleTree(10);
		tree.inOrder(tree);
		System.out.println(tree);
		GenericBinaryTreeNode nodeP = GenericBinaryTree.searchNode(
				tree.getRoot(), 3);
		GenericBinaryTreeNode nodeQ = GenericBinaryTree.searchNode(
				tree.getRoot(), 4);
		GenericBinaryTreeNode nodeR = GenericBinaryTree.searchNode(
				tree.getRoot(), 41);
		System.out.println(nodeP);
		System.out.println(getCommonAncestorBasicHelper(tree.getRoot(), nodeP,
				nodeQ));
		// Problem here is that the function returns node 3 even when the node q
		// does not exist in the tree at all. Thus we have put this main code in
		// helper function and called it initially from another function. as
		// below.
		System.out
				.println(getCommonAncestorBasic(tree.getRoot(), nodeP, nodeR)); // That
																				// solved
																				// it.

		// Now we also need to optimize the code because covers is called too
		// many times.
		System.out.println(getCommonAncestorOptimized(tree.getRoot(), nodeP,
				nodeQ));

	}
}
