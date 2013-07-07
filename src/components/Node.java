package components;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Every node has an identifier specified at generation.
 * 
 * @author Antonios Georgiadis
 */

public class Node  {
	
	public final String ID;
	private List<Edge> connections;
	private int x_cord;
	private int y_cord;
	
	public Node (String ID) {
		this.ID = ID;
		connections = new ArrayList<Edge>();
	}
	
	public Node (String ID, int x, int y) {
		this.ID = ID;
		this.x_cord = x;
		this.y_cord = y;
		connections = new ArrayList<Edge>();
	}
	
	public void setX (int x) {
		x_cord = x;
	}
	
	public void setY (int y) {
		y_cord = y;
	}
	
	public int getX () {
		return x_cord;
	}
	
	public int getY () {
		return y_cord;
	}
	
	public void addConn(Edge edge) {
		if (edge.origin.equals(this)) {
			connections.add(edge);
		}
		else {
			System.out.println("You are trying to add a connection that shouldn't be here.");
		}
	}
	
	public void removeConn(Edge edge) {
		connections.remove(edge);
	}
	
	public List<Edge> getConnections() {
		return connections;
	}
	
}
