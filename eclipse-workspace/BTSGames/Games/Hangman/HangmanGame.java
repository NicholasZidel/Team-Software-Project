package Hangman;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HangmanGame {

	private JFrame frame;
	private MyGraphics panel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					HangmanGame window = new HangmanGame();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	/**
	 * Launch the application.
	 */
	public void createHangman() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HangmanGame window = new HangmanGame();
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
	public HangmanGame() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	
	//-----------------------------------------------------------------------------------------
	//Graphics for hangman
	MyGraphics hangmanGraphics = new MyGraphics();
    public class MyGraphics extends JPanel{
        private static final long serialVersionUID = 1L;

        MyGraphics() {
            setPreferredSize(new Dimension(400, 400));
        	//setOpaque(false);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
    		g2d.setColor( Color.BLACK );
    		g2d.fillRect(50, 150, 70, 10); 				//base horizontal
    		g2d.fillRect(75, 50 , 10, 100);				//base vertical
    		g2d.fillRect(75, 50, 75, 10);					//base top horizontal
    		g2d.drawOval(130, 60, 20, 20); 			//head
    		g2d.drawLine(140, 80, 140, 112);		//body
    		g2d.drawLine(140, 85, 120, 108);		//left arm
    		g2d.drawLine(140, 85, 160, 108);		//right arm
    		g2d.drawLine(140, 112, 150, 135 );	//right leg
    		g2d.drawLine(140, 112, 130, 135 );	// left leg
    		
        }
    }
	//-----------------------------------------------------------------------------------------
    
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hangman");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		panel = new MyGraphics();
		panel.setMinimumSize(new Dimension(400, 400));
		panel.setFont(new Font("Sitka Text", Font.PLAIN, 25));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setBackground(Color.MAGENTA);
		//frame.add(hangmanGraphics, BorderLayout.WEST); //add graphics for hangman
		panel.setLayout(null);
		
		JLabel lblHangman = new JLabel("Hangman");
		lblHangman.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		lblHangman.setBounds(154, 0, 114, 38);
		panel.add(lblHangman);
		
		JLabel promptLabel = new JLabel("promt");
		promptLabel.setBounds(302, 59, 118, 35);
		panel.add(promptLabel);
		
		JLabel txtLabel = new JLabel("user text");
		txtLabel.setBounds(302, 107, 75, 25);
		panel.add(txtLabel);
		
		JLabel wordLabel = new JLabel("game word");
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setBounds(25, 175, 352, 25);
		panel.add(wordLabel);
		
		JButton replayButton = new JButton("Play Again");
		replayButton.setBackground(Color.BLACK);
		replayButton.setForeground(Color.MAGENTA);
		replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		replayButton.setBounds(280, 213, 97, 25);
		panel.add(replayButton);
	}
	
}
