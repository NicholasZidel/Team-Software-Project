package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import java.awt.Point;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class MainMenu extends JPanel {

	private static MainMenu menu = null;
	private static JButton btnLogOut = new JButton("Log out");
	private static JButton btnGameSelect = new JButton("Game Select");
	private static JButton btnStatistics = new JButton("Statistics");
	private static JLabel lblLoggedInAs = new JLabel("Logged in as: ");
	private String name;
	
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
		menu.setBackground(Color.GRAY);
		//menu.setForeground(Color.YELLOW);
		
		JLabel lblTitle = new JLabel("MAIN MENU");
		lblTitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTitle.setLocation(new Point(5, 0));
		lblTitle.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 30));
		lblTitle.setBounds(140, 40, 104, 66);
		menu.add(lblTitle);
		
		lblLoggedInAs.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblLoggedInAs.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 20));
		lblLoggedInAs.setBounds(100, 300, 200, 66);
		menu.add(lblLoggedInAs);
		
		btnGameSelect.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnGameSelect.setBackground(Color.LIGHT_GRAY);
		btnGameSelect.setForeground(Color.YELLOW);
		btnGameSelect.setBounds(124, 125, 137, 29);
		menu.add(btnGameSelect);
		
		btnStatistics.setBounds(124, 200, 137, 29);
		btnStatistics.setBackground(Color.LIGHT_GRAY);
		btnStatistics.setForeground(Color.YELLOW);
		menu.add(btnStatistics);
		
		btnLogOut.setBounds(124, 275, 137, 29);
		btnLogOut.setBackground(Color.LIGHT_GRAY);
		btnLogOut.setForeground(Color.YELLOW);
		menu.add(btnLogOut);
	}
	
	public void setLogoutButton(ActionListener action) {
		btnLogOut.addActionListener(action);
	}
	
	public void setGameSelectButton(ActionListener action) {
		btnGameSelect.addActionListener(action);
	}
	
	public void setStatisticsButton(ActionListener action) {
		btnStatistics.addActionListener(action);
	}
	
	public void setLoggedInAsName(String name) {
		lblLoggedInAs.setText("Logged in as: " + name);
	}
}
