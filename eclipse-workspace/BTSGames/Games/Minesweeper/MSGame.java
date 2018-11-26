package Minesweeper;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class MSGame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MSGame window = new MSGame();
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
	public MSGame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(400, 400));
		frame.setSize(new Dimension(400, 400));
		frame.setPreferredSize(new Dimension(400, 400));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel border = new JPanel();
		border.setBackground(new Color(255, 153, 102));
		frame.getContentPane().add(border, BorderLayout.CENTER);
		border.setLayout(new BorderLayout(0, 0));
		
		JPanel board = new JPanel();
		board.setSize(new Dimension(300, 300));
		board.setPreferredSize(new Dimension(300, 300));
		board.setMaximumSize(new Dimension(300, 300));
		board.setBackground(Color.WHITE);
		border.add(board, BorderLayout.CENTER);
		board.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel westBar = new JPanel();
		westBar.setPreferredSize(new Dimension(47, 10));
		westBar.setSize(new Dimension(30, 10));
		westBar.setBackground(new Color(204, 153, 102));
		border.add(westBar, BorderLayout.WEST);
		
		JPanel northBar = new JPanel();
		northBar.setPreferredSize(new Dimension(10, 35));
		northBar.setBackground(new Color(204, 153, 102));
		border.add(northBar, BorderLayout.NORTH);
		
		JPanel eastBar = new JPanel();
		eastBar.setBackground(new Color(204, 153, 102));
		eastBar.setPreferredSize(new Dimension(47, 10));
		border.add(eastBar, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(10, 33));
		panel.setBackground(new Color(204, 153, 102));
		border.add(panel, BorderLayout.SOUTH);
	}

}
