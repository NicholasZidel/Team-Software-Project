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

	static String[] words = {"understand","computer","java", "jake", "amount", "hangman",
			"destroy","caterpillar","specific","why","goat","quantum","juno","sacrifice",
			"lemonade","theatre","rocket","faucet","contemporary","loser","college","amphitheatre",
			"sloth","magical","mistake","stratosphere"};
	static int count = 0;
	static int x = 0;
	static int len = words.length;
	static String  theWord;
	
	static String  newWord = "";
	static String replaceWord = "-";
	private JFrame frame;
	private MyGraphics panel;

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
		txtLabel.setText("");
		newWord = "";
		replaceWord = "-";
		count = 0;
	}
	
	public void wordPlacer() {
		String w = new String("");
		int num = (int) (Math.random()*len); //picks a random word
		theWord = words[num];
		for(int i = 0; i < theWord.length(); i++)
		{
			w = w + "-";
			
		}
		wordLabel.setText(w);
	}
	
	private static String wordPlacer2() {
		for(int i = 0; i < theWord.length(); i++)
		{
			newWord += replaceWord;
		}
		return newWord;
	}
	
	private static boolean checkLoss(int c) {
		boolean loss = false;
		if (c >= 6 )
			loss = true;
		return loss;
	}
	

	static JLabel promptLabel, wordLabel;
	static JTextField txtLabel;
	private static char letter;
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
		
		promptLabel = new JLabel("prompt");
		promptLabel.setBounds(302, 59, 118, 35);
		panel.add(promptLabel);
		
		txtLabel = new JTextField("user text");
		txtLabel.setBounds(302, 107, 75, 25);
		panel.add(txtLabel);
		
		wordLabel = new JLabel("game word");
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font("Sitka Subheading", Font.PLAIN, 23));
		wordLabel.setBounds(25, 175, 352, 25);
		panel.add(wordLabel);
		
		JButton submit = new JButton(">");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.MAGENTA);
		submit.setBounds(377, 107, 40, 25);
		submit.setFont(new Font("Sitka Subheading", Font.PLAIN, 10));
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				letter = txtLabel.getText().charAt(0);
				System.out.println("theWord: " + theWord + "  newWord: " + newWord);
				promptLabel.setText("Enter a Letter");
				x = 0;
				for (int i = 0; i < theWord.length(); i++) {
					if (letter == (theWord.charAt(i))) {
						newWord = (newWord.substring(0,i) + letter + newWord.substring(i + 1, newWord.length()));
						x = 1;
					}
				}
				System.out.println("theWord: " + theWord + "   newWord: " + newWord);
				wordLabel.setText(newWord);
				if(x == 0) {
					count++;
					//System.out.print("strike " + count + ": ");
					if (count == 1) {
						setHead(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (count == 2) {
						setBody(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (count == 3) {
						setLarm(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (count == 4) {
						setRarm(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (count == 5) {
						setLleg(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (count == 6) {
						setRleg(true);
						promptLabel.setText("strike " + count + ": ");
					}
					if (checkLoss(count)) {     								// if checkLoss is true, player has lost
						 return;
					}
					//hangmanGraphics.repaint();
					
					//check win
					if (theWord == wordLabel.getText()) {
						promptLabel.setText("Nice Job!");
						resetMan();
					}
				}
			}
		});
		panel.add(submit);
		
		JButton replayButton = new JButton("Play");
		replayButton.setBackground(Color.BLACK);
		replayButton.setForeground(Color.MAGENTA);
		replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetMan();
				promptLabel.setText("Enter a Letter");
				wordPlacer();
				newWord = wordPlacer2();
				System.out.println("theWord: "  + theWord + "      newWord: " + newWord);
			}
		});
		replayButton.setBounds(280, 213, 97, 25);
		panel.add(replayButton);
	}
	
	//-----------------------------------------------------------------------------------------
	//Graphics for hangman
	
	public static boolean head;
	public static boolean body;
	public static boolean Rarm;
	public static boolean Larm;
	public static boolean Rleg;
	public static boolean Lleg;		
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
    			g2d.drawLine(140, 112, 150, 135 );		//right leg
    		if (Lleg)
    			g2d.drawLine(140, 112, 130, 135 );		// left leg
        }
    }
    
	//-----------------------------------------------------------------------------------------
	public static void setHead(boolean b) { //head
		head = b;
	}
	public static void setBody(boolean b) { //body
		body = b;
	}
	public static void setLarm(boolean b) { //left arm
		Larm = b;
	}
	public static void setRarm(boolean b) {//right arm
		Rarm = b;
	}
	public static void setLleg(boolean b) { //left leg
		Lleg = b;
	}
	public static void setRleg(boolean b) { //right leg
		Rleg = b;
	}
	
}
