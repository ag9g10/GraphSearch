package algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import components.Graph;
import components.Node;

/**
 * 
 * Temporary implementaton for testing purposes.
 * 
 * @author Antonios Georgiadis
 *
 */

public class BFS {

	public static void bfs(Graph graph, Node root) {
		
		Queue<Node> queue = new LinkedList<Node>();
		Set<Node> visited = new HashSet<Node>();
		
		List nodeList = graph.getNodes();
		List edgeList = graph.getEdges();
		
		Node current = root;
		visited.add(current);
		
		while (visited.size() < nodeList.size()) {
			System.out.println(queue.poll().ID);
			
			
		}


	}
}
