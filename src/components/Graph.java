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

	/*
	 * [TODO] Take care of connections.
	 */
	public boolean removeNode(Node node) {
		return nodeList.remove(node);
	}

	public void addEdge(Node originator, Node destination, int weight) {
		Edge edge = new Edge(originator, destination, weight);
		edgeList.add(edge);
		originator.addConn(edge);
	}

	public void addUndirectedEdge (Node node1, Node node2, int weight) {
		Edge edge = new Edge(node1, node2, weight);
		edgeList.add(edge);
		node1.addConn(edge);
		
		edge = new Edge(node2, node1, weight);
		edgeList.add(edge);
		node2.addConn(edge);
	}

	public void addEdge(Edge edge) {
		edgeList.add(edge);
		edge.origin.addConn(edge);
	}

	public void addUndirectedEdge(Edge edge) {
		edgeList.add(edge);
		edge.origin.addConn(edge);
		
		Edge new_edge = new Edge(edge.destination, edge.origin, edge.getWeight());
		edgeList.add(new_edge);
	}

	/*
	 * [TODO] Take care of connections in Node.
	 */
	public boolean removeEdge(Edge edge) {
		return edgeList.remove(edge);
	}

}
