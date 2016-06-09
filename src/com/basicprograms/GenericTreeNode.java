
public class GenericTreeNode<T> {
	T data;
	GenericTreeNode<T> leftChild;
	GenericTreeNode<T> rightChild;
	
	public GenericTreeNode(T inputData){
		data=inputData;
		leftChild=null;
		rightChild=null;
	}
}
