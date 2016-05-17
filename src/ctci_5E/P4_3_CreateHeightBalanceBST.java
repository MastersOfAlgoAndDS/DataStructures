package ctci_5E;

import java.util.ArrayList;
import java.util.Arrays;

import com.ds.GenericBinaryTreeNode;

/**
 * 
 * @Problem: Given a sorted (increasing order) array with unique integer
 *           elements, write an algorithm to create a binary search tree with
 *           minimal height.
 * 
 * @Solution: We take an optimum approach, we can traverse through the list and
 *            keep making middle element as the root and repeat the process on
 *            the left and right halves of the list.
 * 
 *            Thus this can be said to be a Divide and Conquer approach.
 * 
 * @Runtime: O(n) since each node is traversed and analyzed once.
 * 
 * 
 * @author Milind
 *
 */
public class P4_3_CreateHeightBalanceBST {

	public static GenericBinaryTreeNode<Integer> createBSTFromList(
			ArrayList<Integer> list, int start, int end) {
		if (list == null || end < start)
			return null;

		int middle = (start + end) / 2; // getting the middle is the trick.
		GenericBinaryTreeNode<Integer> root = new GenericBinaryTreeNode<Integer>(
				list.get(middle));
		// if (start < middle)
		root.setLeft(createBSTFromList(list, start, middle - 1));
		// if (middle < end)
		root.setRight(createBSTFromList(list, middle + 1, end));
		return root;
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int size = 20;
		for (int i = 0; i < size; i++) {
			list.add(i + 20);
		}
		System.out.println(list);
		GenericBinaryTreeNode<Integer> root = createBSTFromList(list, 0,
				size - 1);
		System.out.println(root);
	}
}
