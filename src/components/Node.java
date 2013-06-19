package components;

/**
 * 
 * Every node has an identifier specified at generation.
 * 
 * @author Antonios Georgiadis
 */

public class Node<T> {
	
	public final T ID;
	
	public Node (T ID) {
		this.ID = ID;
	}
}
