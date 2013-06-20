package components;

/**
 * 
 * Every node has an identifier specified at generation.
 * 
 * @author Antonios Georgiadis
 */

public class Node {
	
	public final String ID;
	private int x_cord;
	private int y_cord;
	
	public Node (String ID) {
		this.ID = ID;
	}
	
	public Node (String ID, int x, int y) {
		this.ID = ID;
		this.x_cord = x;
		this.y_cord = y;
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
	
}
