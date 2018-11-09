package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;

import display.GameMenu;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DifficultyPanel  extends JPanel {

	private static DifficultyPanel Dpanel = null;

	public static DifficultyPanel getInstance() {
		
		if (Dpanel == null) {
			Dpanel = new DifficultyPanel();
			initialize();
			return Dpanel;
		}
		else {
			return Dpanel;
		}
	}

	/**
	 * Create the application.
	 */
	public DifficultyPanel() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private static JButton EButton, NButton, HButton;
	private static void initialize() {
		
		Dpanel.setBackground(Color.GRAY);
		Dpanel.setLayout(null);
		
		JLabel lblSelectDifficulty = new JLabel("Select Difficulty");
		lblSelectDifficulty.setForeground(Color.CYAN);
		lblSelectDifficulty.setBackground(Color.WHITE);
		lblSelectDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblSelectDifficulty.setBounds(122, 39, 188, 43);
		Dpanel.add(lblSelectDifficulty);
		
		EButton = new JButton("Easy");
		EButton.setBackground(Color.GREEN);
		EButton.setBounds(158, 145, 97, 25);
		Dpanel.add(EButton);
		
		NButton = new JButton("Normal");
		NButton.setBackground(Color.CYAN);
		NButton.setBounds(158, 183, 97, 25);
		Dpanel.add(NButton);
		
		HButton = new JButton("Hard");
		HButton.setBackground(Color.RED);
		HButton.setBounds(158, 221, 97, 25);
		Dpanel.add(HButton);
		
	}
	
	public void setEButton(ActionListener a) {
		EButton.addActionListener(a);
	}
	
	public void setNButton(ActionListener a) {
		NButton.addActionListener(a);
	}
	
	public void setHButton(ActionListener a) {
		HButton.addActionListener(a);
	}
	
	public void pressE() {
		EButton.doClick();
	}
	
	public void pressN() {
		NButton.doClick();
	}
	
	public void pressH() {
		HButton.doClick();
	}
}
