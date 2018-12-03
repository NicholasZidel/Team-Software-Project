package Minesweeper;

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
		panel.setBackground(new Color(165, 42, 42));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel Label = new JLabel();
		if (i == 0) {
			Label.setText("You Lose!");
		}
		if (i == 1) {
			Label.setText("You Win!");
		}
		Label.setForeground(Color.ORANGE);
		Label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		Label.setMinimumSize(new Dimension(150, 75));
		panel.add(Label);
		frame.setResizable(false);
		frame.setBounds(200, 200, 200, 80);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
