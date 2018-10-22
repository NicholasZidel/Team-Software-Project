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

public class MainMenu extends JPanel {

	private static MainMenu menu = null;
	
	public static MainMenu getInstance() {
		if (menu == null) {
			menu = new MainMenu();
			initialize();
			return menu;
		}
		else {
			return menu;
		}
	}
	
	public MainMenu() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		menu.setLayout(null);
		menu.setBounds(0, 0, 400, 400);
		
		JLabel lblTitle = new JLabel("MAIN MENU");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setLocation(new Point(5, 0));
		lblTitle.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblTitle.setBounds(140, 40, 104, 66);
		menu.add(lblTitle);
		
		JButton btnGameSelect = new JButton("Game Select");
		btnGameSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGameSelect.setBounds(124, 125, 137, 29);
		menu.add(btnGameSelect);
		
		JButton btnStatistics = new JButton("Statistics");
		btnStatistics.setBounds(124, 200, 137, 29);
		menu.add(btnStatistics);
		
		JButton btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(124, 275, 137, 29);
		menu.add(btnLogOut);
	}
}
