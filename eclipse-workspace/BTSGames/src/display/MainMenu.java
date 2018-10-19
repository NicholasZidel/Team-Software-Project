package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Point;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainMenu {

	private JFrame frame;
	private JLabel lblTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(new Dimension(406, 429));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		lblTitle = new JLabel("MAIN MENU");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setLocation(new Point(5, 0));
		lblTitle.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblTitle.setBounds(140, 40, 104, 66);
		panel.add(lblTitle);
		
		JButton btnGameSelect = new JButton("Game Select");
		btnGameSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGameSelect.setBounds(124, 125, 137, 29);
		panel.add(btnGameSelect);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(124, 200, 137, 29);
		panel.add(btnStatistics);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(124, 275, 137, 29);
		panel.add(btnLogOut);
	}
}
