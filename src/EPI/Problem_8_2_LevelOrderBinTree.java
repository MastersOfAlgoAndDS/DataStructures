package EPI;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.ds.GenericBinaryTree;
import com.ds.GenericBinaryTreeNode;

public class Problem_8_2_LevelOrderBinTree {

	public void levelOrder(GenericBinaryTreeNode<Integer> head) {
		if (head != null) {
			Queue<GenericBinaryTreeNode<Integer>> q = new LinkedList<GenericBinaryTreeNode<Integer>>();
			q.add(head);
			while (!q.isEmpty()) {
				GenericBinaryTreeNode<Integer> temp = q.remove();
				System.out.print(temp.getVal() + " ");
				if (temp.getLeft() != null)
					q.add(temp.getLeft());
				if (temp.getRight() != null)
					q.add(temp.getRight());
			}
		}

	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(new Integer((int) Math.ceil(Math.random() * 100)));
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree.getRoot());

		Problem_8_2_LevelOrderBinTree p = new Problem_8_2_LevelOrderBinTree();
		p.levelOrder(tree.getRoot());
	}

}
