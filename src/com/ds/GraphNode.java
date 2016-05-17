package com.ds;

import java.util.HashMap;

public class GraphNode {
	public enum State { // These are basically for understanding of ENUM. These
						// can be visit - true or false.
		UNVISITED, VISITED, VISITING;
	}

	private int value;
	private State visitState;
	private HashMap<Integer, GraphNode> adjacentNodes;

	public GraphNode(int value) {
		this.value = value;
		visitState = State.UNVISITED;
		adjacentNodes = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public boolean isVisited() {
		return visitState == State.VISITED;
	}

	public State getVisitState() {
		return visitState;
	}

	public void setVisitState(State state) {
		this.visitState = state;
	}

	public HashMap<Integer, GraphNode> getAdjacentNodes() {
		return adjacentNodes;
	}

	public void setAdjacentNodes(HashMap<Integer, GraphNode> adjacentNodes) {
		this.adjacentNodes = adjacentNodes;
	}

	public void insertAdjacentNode(GraphNode node) {
		if (adjacentNodes == null) {
			adjacentNodes = new HashMap<Integer, GraphNode>();
		}
		adjacentNodes.put(node.getValue(), node);
	}

	@Override
	public String toString() {
		return "GraphNode [value=" + value + ", visited=" + visitState
				+ ", adjacentNodes="
				+ (adjacentNodes != null ? adjacentNodes.keySet() : null)
				+ "]\n";
	}

}
