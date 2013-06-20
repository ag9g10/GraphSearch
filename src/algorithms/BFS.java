package algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import components.Edge;
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

		List<Node> nodeList = graph.getNodes();
		List<Edge> edgeList = graph.getEdges();

		Node current;
		queue.add(root);
		visited.add(root);

		while (queue.size() > 0) {
			current = queue.poll();
			System.out.println(current.ID + " ");

			for (Edge connection : current.getConnections()) {
				queue.add(connection.destination);
				visited.add(connection.destination);
			}
		}
	}
}
