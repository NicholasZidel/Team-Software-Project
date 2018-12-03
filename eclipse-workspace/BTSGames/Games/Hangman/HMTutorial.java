package Hangman;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextArea;

public class HMTutorial {

	private JFrame frame;
	private static HMTutorial window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (window == null) {
						window = new HMTutorial();
						window.frame.setVisible(true);
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HMTutorial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 345, 220);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosing(WindowEvent e) {
					window = null;
			}
		});
		
		JTextArea txtrTheObjectOf = new JTextArea();
		txtrTheObjectOf.setText("The object of the game is to complete the \r\nword which is randomly chosen for you.\r\nGuess single letters at a time\r\nand don't let the man get hung!.\r\n");
		txtrTheObjectOf.setBounds(0, 0, 520, 307);
		frame.getContentPane().add(txtrTheObjectOf);
	}
}

