package Centipede;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;

public class CentipedeGame {

	private static JFrame frame;
	
	private static gameData data;


	
	/**
	 * Launch the application.
	 */
	public static void createCentipede() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CentipedeGame window = new CentipedeGame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CentipedeGame() {
		initialize();
	}
//	--------------------------------------------------------------------

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 502, 580);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		data = gameData.getInstance(frame);
		data.getClock().start();
	}
}
