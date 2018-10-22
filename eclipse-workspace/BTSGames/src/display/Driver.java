package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Driver {
	
	private JFrame frame;
	
	public void createWorld() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver window = new Driver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Driver() {
		initialize();
	}
	
	private void initialize() {
		LoginMenu LM = LoginMenu.getInstance();
		MainMenu MM = MainMenu.getInstance();
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(406, 429));
		frame.setMaximumSize(new Dimension(406, 429));
		frame.setResizable(false);
		frame.setBounds(100, 100, 352, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(LM);
		frame.getContentPane().add(MM);
	}
}
