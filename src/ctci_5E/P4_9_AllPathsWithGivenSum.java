package ctci_5E;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

/**
 * @Problem: You are given a binary tree in which each node contains a value.
 *           Design an algorithm to print all paths which sum to a given value.
 *           The path does not need to start or end at the root or a leaf.
 * 
 * @Solution: If we solve only using the assumption that the path will be from
 *            root to any node or leaf, then it is simple. Keep adding sum and
 *            checking on every node whether we match the sum with that node's
 *            value included. If yes, print else keep going deeper.
 * 
 *            BUT THE problem expects you to find path from any node to any
 *            node. Thus it becomes interesting and can be solved using
 *            recursion again. - Keep all the values in a path in array with
 *            index being the level in tree. So each index indicates level and
 *            value at that index indicates value of node at that level. Thus we
 *            will have unique node at each level. Keep checking at every level
 *            whether we have a match
 * 
 * 
 * @author Milind
 *
 */
public class P4_9_AllPathsWithGivenSum {

	public static void allPathsWithGivenSumFromRoot(GenericBinaryTreeNode root,
			int currentSum, String currentPath, int givenSum) {
		if (root != null) {
			if (currentSum + (int) root.getVal() == givenSum)
				System.out.println(currentPath + root.getVal());
			allPathsWithGivenSumFromRoot(root.getLeft(), currentSum
					+ (int) root.getVal(), currentPath + root.getVal(),
					givenSum);
			allPathsWithGivenSumFromRoot(root.getRight(), currentSum
					+ (int) root.getVal(), currentPath + root.getVal(),
					givenSum);
		}
	}

	public static void allPathsWithGivenSum(GenericBinaryTreeNode node,
			int sum, int[] currentPath, int level) {
		if (node == null)
			return;

		// insert current node into path
		currentPath[level] = (int) node.getVal();

		// Look for paths with a sum that ends at this current node.
		int calcSum = 0;
		for (int i = level; i >= 0; i--) {
			calcSum += currentPath[i];
			if (calcSum == sum)
				printPath(currentPath, i, level);
		}

		// recurse in left and right subtree
		allPathsWithGivenSum(node.getLeft(), sum, currentPath, level + 1);
		allPathsWithGivenSum(node.getRight(), sum, currentPath, level + 1);

		currentPath[level] = Integer.MIN_VALUE;

	}

	private static void printPath(int[] currentPath, int start, int end) {
		for (int i = start; i <= end; i++) {
			System.out.print(currentPath[i]);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		GenericBinaryTree tree = GenericBinaryTree.createSampleBST();
		tree.levelOrderLevelwisePrint(tree.getRoot());
		System.out.println();
		int depth = tree.height(tree.getRoot());
		System.out.println(depth);
		int sum = 6;
		System.out.println("All the paths from root with sum " + sum
				+ " are as below:");
		allPathsWithGivenSumFromRoot(tree.getRoot(), 0, "", sum);
		System.out.println("All the paths with sum " + sum + " are as below:");
		allPathsWithGivenSum(tree.getRoot(), sum, new int[depth], 0);
		sum = 4;
		System.out.println("All the paths from root with sum " + sum
				+ " are as below:");
		allPathsWithGivenSumFromRoot(tree.getRoot(), 0, "", sum);
		System.out.println("All the paths with sum " + sum + " are as below:");
		allPathsWithGivenSum(tree.getRoot(), sum, new int[depth], 0);
	}
}
