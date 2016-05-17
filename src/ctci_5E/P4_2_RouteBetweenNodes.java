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

package ctci_5E;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

import com.ds.Graph;
import com.ds.GraphNode;
import com.ds.GraphNode.State;

/**
 * @Problem: Given a directed graph, design an algorithm to find out whether
 *           there is a route between two nodes.
 * 
 * @Solution: We use the BFS strategy here. We set the nodes being processed as
 *            VISITING and the nodes processing completed as VISITED. During the
 *            processing if we reach till the end node in question, we return
 *            true otherwise we continue the BFS traversal
 *
 *            We use hashmap of hashmap for our graph.
 *            
 * 
 * @author Milind
 *
 */
public class P4_2_RouteBetweenNodes {

	public static boolean isThereRouteBetween(Graph g, int x, int y) {
		// Using BFS strategy here

		LinkedList<GraphNode> q = new LinkedList<GraphNode>();

		g.resetVisitedForNodes();

		q.add(g.getGraph().get(x));
		while (!q.isEmpty()) {
			GraphNode u = q.pollFirst();
			if (u != null) {
				if (u.getAdjacentNodes() != null) {
					for (GraphNode v : u.getAdjacentNodes().values()) {
						if (v.getValue() == y)
							return true;
						else {
							v.setVisitState(State.VISITING);
							q.add(v);
						}
					}
				}
				u.setVisitState(State.VISITED);
			}
		}
		return false;
	}

	public static void main(String[] args) {
		/*
		 * 
		 * 1 2 1 3 1 4 1 5 2 3 3 4 4 5 2 5 done
		 */
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

		System.out.println(isThereRouteBetween(g, 1, 5));
		System.out.println(isThereRouteBetween(g, 1, 1));
		System.out.println(isThereRouteBetween(g, 5, 1));
		System.out.println(isThereRouteBetween(g, 5, 2));
		System.out.println(isThereRouteBetween(g, 3, 5));

	}
}
