package programcreek;

import java.util.*;

public class TreeNode {
	int val;
	TreeNode left, right;
	public TreeNode(int x){
		val=x;
		left=right=null;
	}
	
	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	void print(TreeNode root){		
		Queue<TreeNode> q1 = new Queue<TreeNode>();
		q1.enqueue(root);
		while(!q1.isEmpty()){
			TreeNode temp = q1.dequeue();
			System.out.print("" + temp.val);
			System.out.print(" ");
			if(temp.left!=null){
				q1.enqueue(temp.left);
			}
			if(temp.right!=null){
				q1.enqueue(temp.right);
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
		root.left = c1; root.right = c2;
		c1.left = c3; c1.right = c4;
		c2.left = c5; c2.right = c6;
		c3.left = c7; c3.right = c8;
		c4.left = c9; c4.right = c10;
		c5.left = c11; c5.right = c12;
		c6.left = c13; c6.right = c14;
		
		root.print(root);
	}
	
}
