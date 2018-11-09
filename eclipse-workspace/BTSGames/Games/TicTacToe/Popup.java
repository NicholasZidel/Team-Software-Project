package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class Popup {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Popup window = new Popup();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	public static void createPopup(int x) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Popup window = new Popup(x);
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
	public Popup(int j) {
		initialize(j);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int i) {
		frame = new JFrame();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel Label = new JLabel("You Win!");
		if (i == 0) {
			Label.setText("You Lose!");
		}
		if (i == 1) {
			Label.setText("You Win!");
		}
		if (i == 3) {
			Label.setText("Tie Game!");
		}
		Label.setForeground(Color.CYAN);
		Label.setFont(new Font("Ravie", Font.PLAIN, 21));
		Label.setMinimumSize(new Dimension(150, 75));
		panel.add(Label);
		frame.setBounds(200, 200, 200, 80);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
