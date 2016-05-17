package ctci_5E;

import java.util.ArrayList;
import java.util.LinkedList;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @Problem: Given a binary tree, design an algorithm which creates a linked
 *           list of all the nodes at each depth (e.g., if you have a tree with
 *           depth D, you'll have D linked lists).
 * 
 * @Solution: We use the levelwise tree printing approach. I.e. we use queue and
 *            sentinel node to indicate change of level
 * 
 * @Runtime: O(n) where n is the number of nodes in the tree.
 * 
 * @author Milind
 *
 */
public class P4_4_Btree_LevelWiseLL {

	/**
	 * 
	 * ArrayList index indicates the level and the value i.e. linkedlist is the
	 * linked list of tree nodes at that level
	 * 
	 * @param root
	 * @return
	 */
	public static ArrayList<LinkedList<GenericBinaryTreeNode>> createBtreeLLs(
			GenericBinaryTreeNode root) {
		if (root == null)
			return null;
		ArrayList<LinkedList<GenericBinaryTreeNode>> llTree = new ArrayList<LinkedList<GenericBinaryTreeNode>>();
		LinkedList<GenericBinaryTreeNode> q = new LinkedList<GenericBinaryTreeNode>();

		LinkedList<GenericBinaryTreeNode> ll = new LinkedList<GenericBinaryTreeNode>();

		q.add(root); // enqueue root
		GenericBinaryTreeNode<Character> sentinel = new GenericBinaryTreeNode<Character>(
				'$');
		q.add(sentinel); // enqueue sentinel
		while (q.size() > 1) {
			GenericBinaryTreeNode node = q.pollFirst();

			if (node != null) {
				// Sentinel found, so create a new linkedlist and add the old
				// list to the llTree at last enqueue the sentinel again to the
				// queue.
				if (node.getVal() instanceof Character) {
					llTree.add(ll);
					ll = new LinkedList<GenericBinaryTreeNode>();
					q.add(sentinel);
				} else { // normal node then process node and
					ll.add(node);
					if (node.getLeft() != null)
						q.add(node.getLeft());
					if (node.getRight() != null)
						q.add(node.getRight());
				}
			}
		}
		return llTree;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = 20;
		for (int i = 0; i < size; i++) {
			list.add(i + 20);
		}
		System.out.println(list);
		GenericBinaryTreeNode<Integer> root = P4_3_CreateHeightBalanceBST
				.createBSTFromList(list, 0, size - 1);
		System.out.println(root);
		ArrayList<LinkedList<GenericBinaryTreeNode>> llTree = createBtreeLLs(root);
		for (LinkedList<GenericBinaryTreeNode> linkedList : llTree) {
			for (GenericBinaryTreeNode genericBinaryTreeNode : linkedList) {
				System.out.print(genericBinaryTreeNode.getVal() + " ");
			}
			System.out.println();
		}

	}

}
