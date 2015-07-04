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
			root = new GenericBinaryTreeNode<T>(list.get(iterator));
//			root.setVal(list.get(iterator));
//			root.setLeft(null);
//			root.setRight(null);
			iterator++;
			queue.add(root);
		}
		while(iterator<len && !queue.isEmpty()){
			T nextListItem = list.get(iterator);
			GenericBinaryTreeNode<T> nextTreeNode = new GenericBinaryTreeNode<T>(nextListItem);
			GenericBinaryTreeNode<T> currQueueItem = queue.peek();
			if(!isTreeNodeRipe(currQueueItem))
			{
				if(currQueueItem.getLeft()==null)
					currQueueItem.setLeft(nextTreeNode);
				else if (currQueueItem.getRight()==null)
				{
					currQueueItem.setRight(nextTreeNode);
					queue.remove();
				}
			}
//			currQueueItem.setLeft(new GenericBinaryTreeNode<T>(list.get(iterator)));
			queue.add(nextTreeNode);
			iterator++;
//			if(iterator<len){
//				currQueueItem.setRight(new GenericBinaryTreeNode<T>(list.get(iterator)));
//				queue.add(currQueueItem.getRight());
//				iterator++;
//			}
		}
	}
	
	
	/**
	 * Returns true if the tree node is ripe 
	 * i.e. both left and right children of the tree node are assigned.
	 * i.e. both left and right are not null 
	 * @param currQueueItem
	 * @return
	 */
	private boolean isTreeNodeRipe(GenericBinaryTreeNode<T> currQueueItem) {
		if(currQueueItem.getLeft()!=null && currQueueItem.getRight()!=null)
			return true;
		return false;
	}
	
	

	@Override
	public String toString() {
//		return "GenericBinaryTree [root=" + root + "]";
		return "[" + root + "]";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfNodes = in.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<numberOfNodes; i++){
			list.add(in.nextInt());
		}
		GenericBinaryTree<Integer> tree = new GenericBinaryTree<Integer>(list);
		System.out.println(tree);
	}
}
