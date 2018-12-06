package Centipede;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CDemoMenu extends JPanel{

	private static CDemoMenu instance = null;
	
	public static CDemoMenu getInstance() {
		if (instance == null) {
			instance = new CDemoMenu();
			initialize();
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private CDemoMenu() {
		
	}
	
	private static void initialize() {
		instance.setBorder(null);
		instance.setForeground(Color.GREEN);
		instance.setSize(new Dimension(310, 380));
		instance.setBackground(Color.BLACK);
		instance.setLayout(null);
		
		JLabel title = new JLabel("Centipede");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.GREEN);
		title.setFont(new Font("Courier New", Font.PLAIN, 30));
		title.setBounds(55, 50, 200, 60);
		instance.add(title);
		
		JButton btnPlay = new JButton("Play Game");
		btnPlay.setFont(new Font("Courier New", Font.PLAIN, 18));
		btnPlay.setFocusable(false);
		btnPlay.setForeground(Color.RED);
		btnPlay.setBorder(null);
		btnPlay.setBackground(Color.BLACK);
		btnPlay.setBounds(80, 150, 150, 50);
		
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CentipedeGame.createCentipede();
			}
		});
		
		instance.add(btnPlay);
		
		JButton btnTutorial = new JButton("Tutorial");
		btnTutorial.setFont(new Font("Courier New", Font.PLAIN, 18));
		btnTutorial.setFocusable(false);
		btnTutorial.setForeground(Color.RED);
		btnTutorial.setBorder(null);
		btnTutorial.setBackground(Color.BLACK);
		btnTutorial.setBounds(80, 210, 150, 50);
		instance.add(btnTutorial);
	}
	
}
