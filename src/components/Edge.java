package components;

/**
 * 
 * An edge will connect two nodes together. 
 * An edge may be weighted, or unweighted, directed or undirected. 
 * An unweighted edge can be assumed to have a weight of 1. 
 * An undirected edge can be replaced by two directed edges.
 * 
 * @author Antonios Georgiadis
 *
 */

public class Edge {
	
	private int weight = 1;
	public final Node origin;
	public final Node destination;

	
	public Edge (Node origin, Node destination) {
		this.origin = origin;
		this.destination = destination;
	}
	
	public Edge (Node origin, Node destination, int weight) {
		this.origin = origin;
		this.destination = destination;
		this.weight = weight;
	}

	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
	

}
