package components;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * [TODO] Check for Edge and Node duplication.
 * 
 * @author Antonios Georgiadis
 *
 */


public class Graph {

	private List<Node> nodeList;
	private List<Edge> edgeList;

	public Graph() {
		nodeList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}
	
	public List getNodes() {
		return nodeList;
	}
	
	public List getEdges() {
		return edgeList;
	}

	public void addNode(Node node) {
		if (!nodeList.contains(node)) {
			nodeList.add(node);
		}
	}
	
	public boolean removeNode(Node node) {
		return nodeList.remove(node);
	}
	
	public void addEdge(Node originator, Node destination, int weight) {
		edgeList.add(new Edge(originator, destination, weight));
	}
	
	public void addUndirectedEdge (Node node1, Node node2, int weight) {
		edgeList.add(new Edge(node1, node2, weight));
		edgeList.add(new Edge(node2, node1, weight));
	}
	
	public void addEdge(Edge edge) {
		edgeList.add(edge);
	}
	
	public void addUndirectedEdge(Edge edge) {
		edgeList.add(new Edge(edge.destination, edge.origin, edge.getWeight()));
	}
	
	public boolean removeEdge(Edge edge) {
		return edgeList.remove(edge);
	}

}
