package display;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import TicTacToe.DemoMenu;

public class GameMenu extends JPanel{

	private static GameMenu panel = null;
	private static JButton btnReturn = new JButton("Return");
	
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
		
		CardLayout cl = new CardLayout();
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cl);
		panel.add(cardPanel, BorderLayout.CENTER);
		
		//First game panel demo
		JPanel gamePanel = new JPanel();
		cardPanel.add(gamePanel, "One");
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
		//First game panel demo end
		
		DemoMenu DM = DemoMenu.getInstance();
		cardPanel.add(DM, "DM");
				
		panel.add(btnReturn, BorderLayout.SOUTH);
		
		leftbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.previous(cardPanel);
			}
		});
		
		rightbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(cardPanel);
			}
		});
	}
	
	public void setReturnButton(ActionListener action) {
		btnReturn.addActionListener(action);
	}
}
