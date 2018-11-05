package display;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class LoginMenu extends JPanel {
	public LoginMenu() {
	}

	private static LoginMenu menu = null;
	private static JButton loginButton;
	private static JButton createProfile;
	private static JFormattedTextField textField;
	
	public static LoginMenu getInstance() {
		if (menu == null) {
			menu = new LoginMenu();
			Initialize();
			return menu;
		}
		else {
			return menu;
		}
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private static void Initialize() {
		menu.setLayout(null);
		menu.setBounds(0, 0, 400, 400);
		
		JLabel title = new JLabel("Select a Profile");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 50));
		title.setBounds(10, 11, 380, 99);
		menu.add(title);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(100, 200, 200, 100);
		loginPanel.setBackground(new Color(0, 0, 255));
		menu.add(loginPanel);
		
		loginButton = new JButton("Login");
		loginButton.setBounds(115, 15, 75, 20);
		loginPanel.add(loginButton);
		
		textField = new JFormattedTextField();
		textField.setBounds(10, 15, 100, 20);
		loginPanel.add(textField);
		
		createProfile = new JButton("Create profile");
		createProfile.setBounds(10, 45, 180, 20);
		loginPanel.add(createProfile);
	}
	
	public void setSelectButton(ActionListener action) {
		loginButton.addActionListener(action);
	}
	
	public void setCreateProfileButton(ActionListener action) {
		createProfile.addActionListener(action);
	}
	
	public void setSelectButtonText(String str) {
		loginButton.setText(str);
	}
	
	public void setCreateProfileButtonText(String str) {
		createProfile.setText(str);
	}
	
	public String getProfileName() {
		return textField.getText();
	}
}
