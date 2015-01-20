package programcreek.problems;

import java.util.Stack;

import programcreek.TreeNode;

public class TreePreorder {
	public void preorderTraversal(TreeNode root){	
		if(root==null)
			System.out.println("null");
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode temp = stack.pop();
			System.out.print(temp.getVal() + " ");
			
			if(temp.getRight()!=null){
				stack.push(temp.getRight());
			}

			if(temp.getLeft()!=null){
				stack.push(temp.getLeft());
			}
		}
	}
	
	public static void main(String[] args){
		TreeNode root = new TreeNode(10);
		TreeNode c1 = new TreeNode(20);
		TreeNode c2 = new TreeNode(30);
		TreeNode c3 = new TreeNode(40);
		TreeNode c4 = new TreeNode(50);
		TreeNode c5 = new TreeNode(60);
		TreeNode c6 = new TreeNode(70);
		TreeNode c7 = new TreeNode(80);
		TreeNode c8 = new TreeNode(90);
		TreeNode c9 = new TreeNode(100);
		TreeNode c10 = new TreeNode(110);
		TreeNode c11 = new TreeNode(120);
		TreeNode c12 = new TreeNode(130);
		TreeNode c13 = new TreeNode(140);
		TreeNode c14 = new TreeNode(150);
		root.setLeft(c1); root.setRight(c2);
		c1.setLeft(c3); c1.setRight(c4);
		c2.setLeft(c5); c2.setRight(c6);
		c3.setLeft(c7); c3.setRight(c8);
		c4.setLeft(c9); c4.setRight(c10);
		c5.setLeft(c11); c5.setRight(c12);
		c6.setLeft(c13); c6.setRight(c14);
		
		TreePreorder preoder = new TreePreorder();
		preoder.preorderTraversal(root);
	}

}
