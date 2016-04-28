/**
 * To find the element in a binary tree.
 * 
 * 
 * */

package programcreek.Tree;

import programcreek.Queue;
import programcreek.TreeNode;

public class BinaryTreeSearch {

	public static void insert(TreeNode node, TreeNode root) {
		if (root == null) {
			root = node;
		} else if (root.getLeft() == null) {
			root.setLeft(node);
		} else if (root.getRight() == null) {
			root.setRight(node);
		} else if (root.getLeft().getLeft() != null
				&& root.getLeft().getRight() != null)
			insert(node, root.getRight());
		else
			insert(node, root.getLeft());
	}

	/**
	 * Look for the element in the current node. Look for the element in the
	 * left node. Look for the element in the right node.
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static boolean searchRecursive(TreeNode root, int data) {
		boolean temp;
		if (root == null)
			return false;
		else {
			if (root.getVal() == data)
				return true;
			else {
				temp = searchRecursive(root.getLeft(), data);
				if (temp == true)
					return temp;
				else
					return searchRecursive(root.getRight(), data);
			}
		}
	}

	/**
	 * 
	 * Put root in queue. Then one by one, pick each node from queue and enqueue
	 * left and right node of each of the dequeued node from queue and check the
	 * node's data with element every time.
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public static boolean searchIterative(TreeNode root, int data) {
		Queue<TreeNode> queue = new Queue<TreeNode>();
		TreeNode temp = root;
		if (root == null)
			return false;
		if (root.getVal() == data) {
			return true;
		} else {
			if (root.getLeft() != null)
				queue.enqueue(root.getLeft());
			if (root.getRight() != null)
				queue.enqueue(root.getRight());
			while (!queue.isEmpty()) {
				temp = queue.dequeue();
				if (temp.getVal() == data)
					return true;
			}
		}

		return false;

	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		insert(new TreeNode(3), root);
		insert(new TreeNode(8), root);
		insert(new TreeNode(2), root);
		insert(new TreeNode(5), root);
		root.print(root);
		System.out.println();
		// Tree is ready

		System.out.println(searchIterative(root, 8));
		System.out.println(searchRecursive(root, 8));

	}
}
