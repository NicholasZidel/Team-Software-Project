package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import display.GameMenu;

public class DemoMenu extends JPanel {
	
	private static DemoMenu panel = null;
	
	public static DemoMenu getInstance() {
		
		if (panel == null) {
			panel = new DemoMenu();
			initialize();
			return panel;
		}
		else {
			return panel;
		}
	}
	
	public DemoMenu() {
	}
	
	private static void initialize() {
		panel.setBackground(Color.CYAN);
		panel.setMinimumSize(new Dimension(310, 380));
		panel.setSize(new Dimension(310, 380));
		panel.setBounds(0, 0, 310, 380);
		panel.setLayout(null);
		
		JLabel lblTicTacToe = new JLabel("Tic Tac Toe");
		lblTicTacToe.setBackground(Color.CYAN);
		lblTicTacToe.setFont(new Font("Snap ITC", Font.PLAIN, 30));
		lblTicTacToe.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblTicTacToe.setBounds(55, 55, 200, 60);
		panel.add(lblTicTacToe);
		
		JButton btnPlay = new JButton("Play!");
		btnPlay.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnPlay.setBackground(Color.BLUE);
		btnPlay.setBounds(95, 150, 120, 30);
		panel.add(btnPlay);
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnTutorial.setForeground(Color.BLACK);
		btnTutorial.setBackground(Color.BLUE);
		btnTutorial.setBounds(95, 200, 120, 30);
		panel.add(btnTutorial);
	}
}
