package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

/**
 * 
 * Panel which will support the graphical UI of the application.
 * 
 * Nodes are generated as circles / spheres by clicking on empty space.
 * A node can be dragged and dropped.
 * A node can be deleted - [TODO]
 * An edge will be created as a line between nodes.
 * 
 * @author Antonios Georgiadis
 *
 */

public class GraphPanel extends JPanel {

	private int mode;
	private BufferedImage bi;
	private Shape circle;
	private List<Shape> shapesList;

	public GraphPanel() {
		this.addMouseListener(new ClickListener());
		this.addMouseMotionListener(new ClickListener());
		this.setBackground(Color.WHITE);

		shapesList = new ArrayList<Shape>();
		bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);

	}


	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//System.out.println(shapesList.size());

		//Click / Mouse Release saves on the image.
		if (mode == 1) {
			Graphics2D graphics = bi.createGraphics();
			graphics.setColor(Color.RED);
			graphics.draw(circle);
		}
		//Dragging the circle draws the circle temporarily on the panel.
		else if (mode == 2) {
			Graphics2D graphics = (Graphics2D) g;
			graphics.setColor(Color.RED);
			graphics.draw(circle);
		}
		//Cleaning mode.
		else if (mode == -1) {
			Graphics2D graphics = bi.createGraphics();
			graphics.setColor(Color.WHITE);
			graphics.draw(circle);
		}
		g.drawImage(bi, 0,0,null);
	}



	/**
	 * 
	 * @author Antonios Georgiadis
	 *
	 */

	class ClickListener implements MouseListener, MouseMotionListener {

		public void mouseClicked(MouseEvent e) {
			//System.out.println("Mouse Clicked");

			if (isShape(e.getX(), e.getY())) {
				//Change to "select" a node instead of making it disappear.
				shapesList.remove(circle);
				mode = -1;
				repaint();
			}
			else {
				circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
				mode = 1;
				repaint();
				shapesList.add(circle);
			}
		}
		
		/*
		 * Determines if the given coordinates lie in a shape / Node.
		 */

		private boolean isShape(double x, double y) {
			for (Shape shape : shapesList) {
				if (shape.contains(x, y)) {
					circle = shape;
					return true;
				}
			}
			return false;

		}

		public void mousePressed(MouseEvent e) {
			if (isShape(e.getX(), e.getY())) {
				shapesList.remove(circle);
				mode = -1;
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {
			if (mode == 2) {
				shapesList.add(circle);
				mode = 1;
				repaint();
			}
		}
		
		public void mouseDragged(MouseEvent e) {
			mode = 2;
			circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
			repaint();
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}

	}
}
