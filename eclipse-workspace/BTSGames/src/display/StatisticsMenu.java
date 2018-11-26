package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class StatisticsMenu extends JPanel {

	public StatisticsMenu() {
	}

	private static StatisticsMenu menu = null;
	
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JButton btnReturnButton = new JButton("Return");
	
	public static StatisticsMenu getInstance() {
		if (menu == null) {
			menu = new StatisticsMenu();
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
		
		JPanel statsPanel = new JPanel();
		statsPanel.setBounds(3, 3, 400, 400);
		statsPanel.setLayout(null);
		menu.add(statsPanel);
		
		JLabel title = new JLabel("STATISTICS");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(new Color(238, 238, 238));
		title.setBounds(130, 6, 140, 41);
		statsPanel.add(title);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblGame.setBounds(6, 50, 79, 27);
		statsPanel.add(lblGame);
		
		JLabel lblPersonal = new JLabel("Player Score");
		lblPersonal.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPersonal.setBounds(70, 50, 100, 29);
		statsPanel.add(lblPersonal);
		
		JLabel lblNewLabel_1 = new JLabel("High Score");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(173, 55, 90, 20);
		statsPanel.add(lblNewLabel_1);
		
		JLabel lblLeaderboard = new JLabel("LeaderBoard");
		lblLeaderboard.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblLeaderboard.setBounds(276, 58, 120, 16);
		statsPanel.add(lblLeaderboard);
		
		btnReturnButton.setBounds(130, 350, 140, 35);
		statsPanel.add(btnReturnButton);
		
		
		//text fields that will be updated
		//parse json file row by row
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 77, 70, 261);
		statsPanel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(70, 77, 100, 261);
		statsPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(168, 77, 100, 261);
		statsPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setBounds(267, 77, 124, 261);
		statsPanel.add(textField_3);
		textField_3.setColumns(10);
	}
	
	public void displayData() {
		//System.out.println("hello");
	}
	
	public void setReturnButton(ActionListener action) {
		btnReturnButton.addActionListener(action);
	}
}
