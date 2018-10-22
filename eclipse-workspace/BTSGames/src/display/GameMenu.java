package display;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GameMenu extends JPanel{

	private static GameMenu panel = null;
	
	public static GameMenu getInstance() {
		
		if (panel == null) {
			panel = new GameMenu();
			initialize();
			return panel;
		}
		else {
			return panel;
		}
	}

	/**
	 * Create the application.
	 */
	public GameMenu() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton leftbutton = new JButton("<");
		panel.add(leftbutton, BorderLayout.WEST);
		
		JButton rightbutton = new JButton(">");
		panel.add(rightbutton, BorderLayout.EAST);
		
		JPanel gamePanel = new JPanel();
		panel.add(gamePanel, BorderLayout.CENTER);
		gamePanel.setLayout(null);
		
		JLabel lblGameTitle = new JLabel("Game Title");
		lblGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGameTitle.setBounds(77, 38, 159, 50);
		gamePanel.add(lblGameTitle);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(99, 188, 89, 23);
		gamePanel.add(btnStart);
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setBounds(99, 235, 89, 23);
		gamePanel.add(btnTutorial);
	}
}
