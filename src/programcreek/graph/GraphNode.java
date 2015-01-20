package programcreek.graph;

public class GraphNode {
	int val;
	GraphNode next;
	GraphNode[] neighbors;
	boolean visited;
	
	GraphNode(int x){
		val = x;
	}
	
	GraphNode(int x, GraphNode[] n){
		val = x;
		neighbors = n;
	}
	
	public String toString(){
		return "value: " + val;
	}
}
