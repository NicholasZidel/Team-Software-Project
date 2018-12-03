package Hangman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import display.GameMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class HMDemoMenu extends JPanel {

	static HMDemoMenu panel = null;
	public static HMDemoMenu getInstance() {
		
		if (panel == null) {
			panel = new HMDemoMenu();
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
	public HMDemoMenu() {
	}

	/**
	 * Initialize the contents of the frame.
	 */
	static JButton btnPlay;
	static JButton btnTutorial;
	private static void initialize() {

		
		panel.setBackground(Color.MAGENTA);
		panel.setForeground(new Color(135, 206, 235));
		panel.setSize(new Dimension(310, 380));
		panel.setMinimumSize(new Dimension(310, 380));
		panel.setLayout(null);
		
		JLabel lblHangman = new JLabel("Hangman");
		lblHangman.setFont(new Font("Stencil", Font.PLAIN, 33));
		lblHangman.setBounds(71, 13, 167, 44);
		panel.add(lblHangman);
		
		btnPlay = new JButton("Play");
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setForeground(Color.MAGENTA);
		btnPlay.setBounds(106, 144, 97, 25);
		panel.add(btnPlay);
		
		btnTutorial = new JButton("Tutorial");
		btnTutorial.setBackground(Color.BLACK);
		btnTutorial.setForeground(Color.MAGENTA);
		btnTutorial.setBounds(106, 182, 97, 25);
		panel.add(btnTutorial);
	}
	
	public void setPlayButton(ActionListener a) {
		btnPlay.addActionListener(a);
	}
	public void setTutorialButton(ActionListener a) {
		btnTutorial.addActionListener(a);
	}

}
