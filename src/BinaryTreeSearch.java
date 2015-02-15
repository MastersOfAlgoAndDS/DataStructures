import java.util.LinkedList;

import programcreek.*;

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
	
	
	public static boolean searchIterative(TreeNode root,int data){
		Queue<TreeNode> queue = new Queue<TreeNode>();
		TreeNode temp = root;
		if(root.getVal()==data){
			return true;
		}else{
			while(!queue.isEmpty()){
				if (temp.getLeft()!=null)
					queue.enqueue(temp.getLeft());
				if (temp.getRight()!=null)
					queue.enqueue(temp.getRight());
				temp=queue.dequeue();
				if(temp.getVal()==data)
					return true;
			}
			//temp=queue.dequeue();
			
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
		// Tree is ready

		System.out.println(searchIterative(root, 7));

	}
}
