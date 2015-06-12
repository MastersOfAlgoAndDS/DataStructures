package com.ds;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class GenericBinaryTree<T> {
	GenericBinaryTreeNode<T> root; 

	public GenericBinaryTree() {
		root = null;
	}

	/**contructor
	 * @param list
	 */
	public GenericBinaryTree(ArrayList<T> list) {
		int len = list.size();
		int iterator = 0;
		boolean currTreeNodeFullFlag = false;
		LinkedList<GenericBinaryTreeNode<T>> queue = new LinkedList<GenericBinaryTreeNode<T>>();
		if(list.isEmpty())
			root=null;
		else{
			root.setVal(list.get(iterator));
			root.setLeft(null);
			root.setRight(null);
			iterator++;
			queue.add(root);
		}
		while(iterator<len || !queue.isEmpty()){
			GenericBinaryTreeNode<T> currQueueItem = queue.remove();
			currQueueItem.setLeft(new GenericBinaryTreeNode<T>(list.get(iterator)));
			queue.add(currQueueItem.getLeft());
			iterator++;
			if(iterator<len){
				currQueueItem.setRight(new GenericBinaryTreeNode<T>(list.get(iterator)));
				queue.add(currQueueItem.getRight());
				iterator++;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		int numberOfNodes=4;
		for(int i=0; i<numberOfNodes; i++){
			list.add(in.nextInt());
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree);
	}
}
