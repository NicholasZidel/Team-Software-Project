package Minesweeper;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MSTutorial {
	private JFrame frame;
	private static MSTutorial window;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					if (window == null) {
						window = new MSTutorial();
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
	public MSTutorial() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 363, 211);
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
		txtrTheObjectOf.setText("In the 10x10 grid there are 10 mines placed. In order to win\r\nthe game you must dig up all the spaces where a mine isn't\r\npresent. With the dig button selected click on a tile to dig\r\nthere. If it is a mine the game is lost, if it is not near a mine\r\nit digs all nearby spaces recursively. If it is near a mine it\r\nwill only show the number of mines that are nearby. Use\r\nthe flag button to label the tiles you believe the mines are\r\nlocated to keep track of them.");
		txtrTheObjectOf.setBounds(0, 0, 532, 307);
		frame.getContentPane().add(txtrTheObjectOf);
	}
}
