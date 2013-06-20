package test;

/**
 * Test for the Graph class.
 * Check to see if a graph can be modelled correctly.
 * 
 * Source: http://upload.wikimedia.org/wikipedia/commons/thumb/6/67/Sorted_binary_tree.svg/500px-Sorted_binary_tree.svg.png
 * 
 */

import algorithms.BFS;
import components.Edge;
import components.Graph;
import components.Node;

public class GraphTest {
	
	public static void main(String[] args) {
		
		Graph graph = new Graph();
		
		Node nodeA = new Node ("A");
		Node nodeB = new Node ("B");
		Node nodeC = new Node ("C");
		Node nodeD = new Node ("D");
		Node nodeE = new Node ("E");
		Node nodeF = new Node ("F");
		Node nodeG = new Node ("G");
		Node nodeH = new Node ("H");
		Node nodeI = new Node ("I");
				
		Edge edgeFB = new Edge(nodeF, nodeB);
		Edge edgeBA = new Edge(nodeB, nodeA);
		Edge edgeBD = new Edge(nodeB, nodeD);
		Edge edgeDC = new Edge(nodeD, nodeC);
		Edge edgeDE = new Edge(nodeD, nodeE);
		Edge edgeFG = new Edge(nodeF, nodeG);
		Edge edgeGI = new Edge(nodeG, nodeI);
		Edge edgeIH = new Edge(nodeI, nodeH);
		
		graph.addEdge(edgeFB);
		graph.addEdge(edgeBA);
		graph.addEdge(edgeBD);
		graph.addEdge(edgeDC);
		graph.addEdge(edgeDE);
		graph.addEdge(edgeFG);
		graph.addEdge(edgeGI);
		graph.addEdge(edgeIH);
		
		BFS.bfs(graph, nodeF);
		
	}

}
