package display;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
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
	private static JButton createButton;
	private static JButton loginProfile;
	private static JFormattedTextField textField;
	private static JFormattedTextField textField2;	
	private static CardLayout cl = new CardLayout();
	private static JPanel textPanel = new JPanel();
	private static boolean showingLogin = true;
	
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
		menu.setBackground(new Color(255, 251, 48));
		
		JLabel title = new JLabel("Select a Profile");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setFont(new Font("Tahoma", Font.BOLD, 50));
		title.setBounds(10, 11, 380, 99);
		menu.add(title);
		
		textPanel.setLayout(cl);
		textPanel.setBounds(99, 199, 202, 82);
		menu.add(textPanel);
		
//		login panel contains all the buttons for logging in
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(null);
		loginPanel.setBounds(100, 200, 200, 80);
		loginPanel.setBackground(new Color(255, 251, 48));
		textPanel.add(loginPanel, "LP");
		
		loginButton = new JButton("Login");
		loginButton.setBackground(new Color(255, 251, 48));
		loginButton.setForeground(new Color(0, 0, 0));
		loginButton.setBounds(115, 15, 75, 20);
		loginPanel.add(loginButton);
		
		textField = new JFormattedTextField();
		textField.setBounds(10, 15, 100, 20);
		loginPanel.add(textField);
		
		createProfile = new JButton("Create profile");
		createProfile.setBackground(new Color(255, 251, 48));
		createProfile.setForeground(new Color(0, 0, 0));
		createProfile.setBounds(10, 45, 180, 20);
		loginPanel.add(createProfile);
		createProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(textPanel, "CP");
				showingLogin = false;
			}
		});
		
//		create panel contains all the buttons for creating a new profile
		JPanel createPanel = new JPanel();
		createPanel.setLayout(null);
		createPanel.setBounds(100, 200, 200, 80);
		createPanel.setBackground(new Color(255, 251, 48));
		textPanel.add(createPanel, "CP");
		
		createButton = new JButton("Create");
		createButton.setBackground(new Color(255, 251, 48));
		createButton.setForeground(new Color(0, 0, 0));
		createButton.setBounds(115, 15, 75, 20);
		createPanel.add(createButton);
		
		textField2 = new JFormattedTextField();
		textField2.setBounds(10, 15, 100, 20);
		createPanel.add(textField2);
		
		loginProfile = new JButton("Use existing profile");
		loginProfile.setBackground(new Color(255, 251, 48));
		loginProfile.setForeground(new Color(0, 0, 0));
		loginProfile.setBounds(10, 45, 180, 20);
		createPanel.add(loginProfile);
		loginProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(textPanel, "LP");
				showingLogin = true;
			}
		});
		
		cl.show(textPanel, "LP");
	}
	
	public void setLoginButton(ActionListener action) {
		loginButton.addActionListener(action);
		textField.addActionListener(action);
	}
	
	public void setCreateButton(ActionListener action) {
		createButton.addActionListener(action);
		textField2.addActionListener(action);
	}
	
	public void setSelectButtonText(String str) {
		loginButton.setText(str);
	}
	
	public void setCreateProfileButtonText(String str) {
		createProfile.setText(str);
	}
	
	public String getProfileName() {
		if (showingLogin) {
			return textField.getText();
		}
		else {
			return textField2.getText();
		}
	}
}
