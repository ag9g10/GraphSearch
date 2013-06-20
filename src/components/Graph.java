package components;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Antonios Georgiadis
 *
 */


public class Graph {

	private List<Node> nodesList;
	private List<Edge> edgeList;

	public Graph() {
		nodesList = new ArrayList<Node>();
		edgeList = new ArrayList<Edge>();
	}

	public void addNode(Node node) {
		if (!nodesList.contains(node)) {
			nodesList.add(node);
		}
	}
	
	public boolean removeNode(Node node) {
		return nodesList.remove(node);
	}
	
	public void addEdge(Node originator, Node destination) {
		edgeList.add(new Edge(originator, destination, false));
	}
	
	public void addEdge(Edge edge) {
		edgeList.add(edge);
	}
	
	public boolean removeEdge(Edge edge) {
		return edgeList.remove(edge);
	}

}
