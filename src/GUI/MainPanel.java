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
 * @author Antonios Georgiadis
 *
 */

public class MainPanel extends JPanel {

	private int mode;
	private BufferedImage bi;
	private Shape circle;
	private List<Shape> shapesList;

	public MainPanel() {
		this.addMouseListener(new ClickListener());
		this.addMouseMotionListener(new ClickListener());
		this.setBackground(Color.WHITE);

		shapesList = new ArrayList<Shape>();
		bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);

	}


	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		
		System.out.println(shapesList.size());

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
				//System.out.println("HEY!!!!");
				shapesList.remove(circle);
				//circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
				mode = -1;
				repaint();
			}
			else {
				//System.out.println("YOLO");
				circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
				mode = 1;
				repaint();
				shapesList.add(circle);
			}
		}
		
		private boolean isShape(double x, double y) {
			for (Shape shape : shapesList) {
				if (shape.contains(x, y)) {
					circle = shape;
					return true;
				}
				//System.out.println("Iteration");
			}
			//System.out.println("Returns false");
			return false;
			
		}

		public void mousePressed(MouseEvent e) {
			if (isShape(e.getX(), e.getY())) {
				//System.out.println("Mouse Pressed!");
				shapesList.remove(circle);
				//circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
				mode = -1;
				repaint();
			}
		}

		public void mouseReleased(MouseEvent e) {
			//System.out.println("Mouse Released");
			/*
			circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
			mode = 1;
			repaint();
			*/
			if (mode == 2) {
				shapesList.add(circle);
				mode = 1;
				repaint();
			}
		}

		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}

		public void mouseDragged(MouseEvent e) {
			mode = 2;
			circle = new Ellipse2D.Double(e.getX() - 10, e.getY() - 10, 20, 20);
			repaint();
		}

	}
}
