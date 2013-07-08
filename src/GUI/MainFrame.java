package GUI;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 
 * @author Antonios Georgiadis
 *
 */

public class MainFrame extends JFrame {


	public MainFrame(String title) {
		super(title);
	}


	public void init() {

		JPanel mainPanel = new GraphPanel();
		this.setContentPane(mainPanel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setVisible(true);


	}

	/*
	 * public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowUI();
            }
        });
    }
	 */


}
