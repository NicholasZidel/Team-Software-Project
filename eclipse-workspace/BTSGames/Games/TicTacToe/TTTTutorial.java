package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class TTTTutorial {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TTTTutorial window = new TTTTutorial();
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
	public TTTTutorial() {
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
		
		JTextArea txtrTheObjectOf = new JTextArea();
		txtrTheObjectOf.setText("The object of the game is to get three\r\n of your shape in a row on the board.\r\nThe two players (You and the computer)\r\n take turns playing their shape\r\n(you are X computer is O). You cannot \r\nplay on already played on squares.\r\nGame is a tie if all squares are filled \r\nand neither player wins.");
		txtrTheObjectOf.setBounds(0, 0, 520, 307);
		frame.getContentPane().add(txtrTheObjectOf);
	}
}
