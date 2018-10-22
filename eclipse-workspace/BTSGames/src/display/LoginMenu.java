package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
		loginPanel.setBounds(100, 257, 200, 50);
		menu.add(loginPanel);
		
		JButton loginButton = new JButton("Select");
		loginButton.setBounds(115, 15, 75, 20);
		loginPanel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(false);
				//listen to this method call
			}
		});
		
		JFormattedTextField textField = new JFormattedTextField();
		textField.setBounds(10, 15, 100, 20);
		loginPanel.add(textField);
		
		JPanel scoreBoardPanel = new JPanel();
		scoreBoardPanel.setLayout(null);
		scoreBoardPanel.setBounds(100, 121, 200, 125);
		menu.add(scoreBoardPanel);
		
		JLabel topScoreTitle = new JLabel("Top Scores:");
		topScoreTitle.setHorizontalAlignment(SwingConstants.CENTER);
		topScoreTitle.setFont(new Font("Tahoma", Font.BOLD, 15));
		topScoreTitle.setBounds(50, 10, 100, 25);
		scoreBoardPanel.add(topScoreTitle);
		
		JLabel score1 = new JLabel("BBB");
		score1.setHorizontalAlignment(SwingConstants.CENTER);
		score1.setFont(new Font("Tahoma", Font.BOLD, 13));
		score1.setBounds(75, 45, 50, 15);
		scoreBoardPanel.add(score1);
		
		JLabel score2 = new JLabel("AAA");
		score2.setHorizontalAlignment(SwingConstants.CENTER);
		score2.setFont(new Font("Tahoma", Font.BOLD, 13));
		score2.setBounds(75, 70, 50, 15);
		scoreBoardPanel.add(score2);
		
		JLabel score3 = new JLabel("AAA");
		score3.setHorizontalAlignment(SwingConstants.CENTER);
		score3.setFont(new Font("Tahoma", Font.BOLD, 13));
		score3.setBounds(75, 95, 50, 15);
		scoreBoardPanel.add(score3);
	}
}
