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

import display.GameMenu;

import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class HangmanGame {

	HangmanAI ai = new HangmanAI();  
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
		//resetMan();
		initialize();
	}

	public void resetMan() {
		head = false;
		body = false;
		Rarm = false;
		Larm = false;
		Rleg = false;
		Lleg = false;
	}
	
	//-----------------------------------------------------------------------------------------
	//Graphics for hangman
	
	public boolean head, body, Rarm, Larm, Rleg, Lleg;		
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
    		if (head)
    			g2d.drawOval(130, 60, 20, 20); 			//head
    		if (body)
    			g2d.drawLine(140, 80, 140, 112);		//body
    		if (Larm)
    			g2d.drawLine(140, 85, 120, 108);		//left arm
    		if (Rarm)
    			g2d.drawLine(140, 85, 160, 108);		//right arm
    		if (Rleg)
    			g2d.drawLine(140, 112, 150, 135 );	//right leg
    		if (Lleg)
    			g2d.drawLine(140, 112, 130, 135 );	// left leg
    		
        }
    }
	//-----------------------------------------------------------------------------------------
	static JLabel promptLabel, wordLabel, txtLabel;
	
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Hangman");
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	GameMenu.resetHM();
                //System.exit(0);
            }
        });
		
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
		
		promptLabel = new JLabel("promt");
		promptLabel.setBounds(302, 59, 118, 35);
		panel.add(promptLabel);
		
		txtLabel = new JLabel("user text");
		txtLabel.setBounds(302, 107, 75, 25);
		panel.add(txtLabel);
		
		wordLabel = new JLabel("game word");
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 23));
		wordLabel.setBounds(25, 175, 352, 25);
		panel.add(wordLabel);
		
		JButton replayButton = new JButton("Play");
		replayButton.setBackground(Color.BLACK);
		replayButton.setForeground(Color.MAGENTA);
		replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetMan();
				ai.wordPlacer();
				ai.start();
			}
		});
		replayButton.setBounds(280, 213, 97, 25);
		panel.add(replayButton);
	}
	
	public static void setPromt(String prompt) {
		promptLabel.setText(prompt);
	}
	public static void setTxt(String usertxt) {
		txtLabel.setText(usertxt);
	}
	public static void setWord(String word) {
		wordLabel.setText(word);
	}
	
}
