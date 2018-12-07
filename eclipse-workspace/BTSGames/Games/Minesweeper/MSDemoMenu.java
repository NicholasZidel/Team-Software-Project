package Minesweeper;

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

public class MSDemoMenu extends JPanel {

	private static MSDemoMenu panel = null;
	static JButton btnSweep = null;
	static JButton btnTutorial = null;
	
	public static MSDemoMenu getInstance() {
		
		if (panel == null) {
			panel = new MSDemoMenu();
			initialize();
			return panel;
		}
		else {
			return panel;
		}
	}
	
	private MSDemoMenu() {
	}
	
	private static void initialize() {
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 310, 380);
		panel.setLayout(null);
		
		JLabel lblMinesweeper = new JLabel("MINESWEEPER");
		lblMinesweeper.setForeground(new Color(204, 0, 0));
		lblMinesweeper.setBounds(56, 30, 197, 34);
		lblMinesweeper.setFont(new Font("Sitka Subheading", Font.BOLD, 27));
		panel.add(lblMinesweeper);
		
		btnSweep = new JButton("Sweep");
		btnSweep.setForeground(Color.BLACK);
		btnSweep.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnSweep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnSweep.setBackground(Color.ORANGE);
		btnSweep.setBounds(90, 121, 130, 29);
		panel.add(btnSweep);
		
		btnTutorial = new JButton("Tutorial");
		btnTutorial.setFont(new Font("Stencil", Font.PLAIN, 18));
		btnTutorial.setBackground(Color.ORANGE);
		btnTutorial.setBounds(90, 200, 130, 29);
		panel.add(btnTutorial);
	}
	
	public void setSweepButton(ActionListener a) {
		btnSweep.addActionListener(a);
	}
	
	public void setTutorialButton(ActionListener a) {
		btnTutorial.addActionListener(a);
	}
}
