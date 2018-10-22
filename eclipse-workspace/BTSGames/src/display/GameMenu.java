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

public class GameMenu {

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
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		
		JPanel panel = new JPanel();

		panel.setLayout(new BorderLayout(0, 0));
		
		JButton button = new JButton("<");
		panel.add(button, BorderLayout.WEST);
		
		JButton button_1 = new JButton(">");
		panel.add(button_1, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblGameTitle = new JLabel("Game Title");
		lblGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGameTitle.setBounds(77, 38, 159, 50);
		panel_1.add(lblGameTitle);
		
		JButton btnStart = new JButton("Start");
		btnStart.setBounds(99, 188, 89, 23);
		panel_1.add(btnStart);
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setBounds(99, 235, 89, 23);
		panel_1.add(btnTutorial);
	}
}
