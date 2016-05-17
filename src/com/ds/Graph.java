package com.ds;

/**
 * 
 *  @TestCase to create graph
 * 
 1 2
 1 3 
 1 4 
 1 5 
 2 3 
 3 4 
 4 5 
 2 5 
 done
 * 
 * 
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * @author Milind
 *
 */
public class Graph {

	private HashMap<Integer, GraphNode> graph;

	public HashMap<Integer, GraphNode> getGraph() {
		return graph;
	}

	public void setGraph(HashMap<Integer, GraphNode> graph) {
		this.graph = graph;
	}

	public ArrayList<Integer> getNodesList(ArrayList<Integer[]> edges) {
		ArrayList<Integer> nodes = new ArrayList<Integer>();

		// get all the nodes based on the edges in the graph
		for (int i = 0; i < edges.size(); i++) {

			// get starting node of the edge
			if (!nodes.contains(edges.get(i)[0])) {
				nodes.add(edges.get(i)[0]);
			}

			// get ending node of the edge
			if (!nodes.contains(edges.get(i)[1])) {
				nodes.add(edges.get(i)[1]);
			}
		}
		System.out.println("Nodes in the graph are: " + nodes);

		return nodes;
	}

	public void buildDirectedGraph(ArrayList<Integer[]> edges) {
		ArrayList<Integer> nodes = getNodesList(edges);

		System.out.println("Constructing the graph");
		createGraphNodes(nodes);

		// inserting the adjacent nodes
		for (int i = 0; i < edges.size(); i++) {
			// create Graph edge from starting node to ending node. A -> B
			getGraph().get(edges.get(i)[0]).insertAdjacentNode(
					getGraph().get(edges.get(i)[1]));
		}

		System.out.println("Graph constructed.");
		System.out.println(graph);
	}

	public void buildUndirectedGraph(ArrayList<Integer[]> edges) {
		ArrayList<Integer> nodes = getNodesList(edges);

		System.out.println("Constructing the graph");
		createGraphNodes(nodes);

		// inserting the adjacent nodes
		for (int i = 0; i < edges.size(); i++) {
			// create Graph edge from starting node to ending node. A -> B
			getGraph().get(edges.get(i)[0]).insertAdjacentNode(
					getGraph().get(edges.get(i)[1]));
			// create Graph edge from ending node to starting node. B -> A
			getGraph().get(edges.get(i)[1]).insertAdjacentNode(
					getGraph().get(edges.get(i)[0]));
		}

		System.out.println("Graph constructed.");
		System.out.println(graph);
	}

	private void createGraphNodes(ArrayList<Integer> nodes) {
		// creating graph nodes
		for (int i : nodes) {
			if (getGraph() == null) {
				setGraph(new HashMap<Integer, GraphNode>());
			}
			getGraph().put(i, new GraphNode(i));
		}

	}

	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}

	public void DFS(int value) {
		GraphNode node = getGraph().get(value);
		if (node == null) {
			System.out.println("node does not exist in the graph");
		} else {
			if (!node.isVisited()) {
				System.out.print(node.getValue() + " ");
				node.setVisitState(GraphNode.State.VISITED);
				HashMap<Integer, GraphNode> adjacentNodes = node
						.getAdjacentNodes();
				if (adjacentNodes != null) {
					for (GraphNode adjacentNode : adjacentNodes.values()) {
						DFS(adjacentNode.getValue());
					}
				}
			}
		}
	}

	public void BFS(int value) {
		resetVisitedForNodes();
		GraphNode node = getGraph().get(value);
		if (node == null) {
			System.out.println("node does not exist in the graph");
		} else {
			LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
			queue.add(node);
			while (!queue.isEmpty()) {
				node = queue.pollFirst();
				if (!node.isVisited()) {
					System.out.print(node.getValue() + " ");
					node.setVisitState(GraphNode.State.VISITED);
					HashMap<Integer, GraphNode> adjacentNodes = node
							.getAdjacentNodes();
					if (adjacentNodes != null) {
						for (GraphNode adjacentNode : adjacentNodes.values()) {
							queue.add(adjacentNode);
						}
					}
				}
			}
		}
	}

	public void resetVisitedForNodes() {
		for (GraphNode node : getGraph().values()) {
			node.setVisitState(GraphNode.State.UNVISITED);
		}
	}

	public boolean isConnectByPath(int value1, int value2) {
		BFS(value1);
		// System.out.println();
		if (getGraph().get(value1).isVisited() == true
				&& getGraph().get(value2).isVisited() == true) {
			resetVisitedForNodes();
			return true;
		}
		resetVisitedForNodes();
		return false;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer[]> edges = new ArrayList<Integer[]>();
		while (in.hasNextInt()) {
			Integer[] edge = new Integer[2];
			edge[0] = in.nextInt();
			edge[1] = in.nextInt();
			edges.add(edge);
		}
		Graph g = new Graph();
		g.buildDirectedGraph(edges);
		System.out.println("DFS Traversal");
		g.DFS(g.getGraph().entrySet().iterator().next().getValue().getValue());
		System.out.println("");
		g.resetVisitedForNodes();
		System.out.println("Testing connection between 5 and 1: "
				+ g.isConnectByPath(5, 1));
		System.out.println("Testing connection between 1 and 4: "
				+ g.isConnectByPath(1, 4));
		System.out.println("Testing connection between 2 and 5: "
				+ g.isConnectByPath(2, 5));
		g.DFS(2);
		System.out.println();
		g.BFS(2);
	}

}
