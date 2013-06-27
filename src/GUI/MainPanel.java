package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class MainPanel extends JPanel {

	private int x;
	private int y;
	private int mode;
	private BufferedImage bi;

	public MainPanel() {
		this.addMouseListener(new ClickListener());
		this.setBackground(Color.BLACK);
		
		bi = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
	
	}

	
	
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		if (mode == 1) {
			Graphics2D g2 = bi.createGraphics();
			g2.setColor(Color.RED);
			g2.fillOval(x - 10, y - 10, 20, 20);
			g.drawImage(bi, 0,0,null);
		}
	}



	/**
	 * 
	 * @author antonio
	 *
	 */

	class ClickListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			mode = 1;
			repaint();
		}

		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}
	}

}
