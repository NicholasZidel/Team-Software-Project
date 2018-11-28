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
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class HangmanGame {
	
	static String[] words = {"awkward", "bagpipes", "banjo", "bungler",  "croquet", "crypt", "dwarves", 
			"fishhook", "fjord", "gazebo", "gypsy", "haiku", "haphazard", "hyphen", "ivory", "jazzy", "jiffy", "ostracize", 
			"oxygen", "pajama", "yacht", "colossal", "attach", "irate", "print", "degree", "outgoing",
			"giants", "big", "passenger", "screeching", "look",
			"driving", "route", "fearless",  "knot", "haunt", "lying", "playground", "breakable", "account", "discover", 
			"imaginary", "skip", "smoke", "clip", "marry", "honorable", "celery", "unarmed",
			"whimsical", "vague", "frail", "omniscient", "clever", "rake", "bump", "barbarous", "sheep",
			"understand","computer","java", "jake", "amount", "hangman",
			"destroy","caterpillar","specific","why","goat","quantum","juno","sacrifice",
			"lemonade","theatre","rocket","faucet","contemporary","loser","college","amphitheatre",
			"sloth","magical","mistake","stratosphere"};
	static int count = 0;
	static int x = 0;
	static int len = words.length;
	static String  theWord;
	static boolean submitAllow = false;
	public static String  newWord = "";
	static String replaceWord = "-";
	private JFrame frame;
	private static MyGraphics panel;
	private static char[] letters = new char[ ] {' ', ' ', ' ', ' ', ' ', ' ', ' '} ;
	private static String list = "";

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
	
	public static String toString(char[] l) {
		list = "";
		for (int i = 0; i < l.length; i++) {
			list = list + " " + l[i];
		}
		return list;
	}
	
	//reset properties
	public void resetMan() {
		head = false;
		body = false;
		Rarm = false;
		Larm = false;
		Rleg = false;
		Lleg = false;
		face = false;
		txtLabel.setText("");
		newWord = "";
		list = "";
		replaceWord = "-";
		count = 0;
		promptLabel.setText("Enter a Letter");
		wordPlacer(); 				//sets the label to be dashes
		newWord = wordPlacer2(); 	//sets new word to be dashes
		submitAllow = false;
		//for used letters
		for (int i = 0; i < 7; i++) {
			letters[i] = ' ';
		}
		usedLetters.setText(toString(letters));
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
		if (c >= 7 )
			loss = true;
		return loss;
	}
	
	private static void run() {
	
		if (submitAllow == true) {	
			if (txtLabel.getText().equals("") || txtLabel.getText().equals(" "))
				return;
		letter = txtLabel.getText().charAt(0);
		letter2 = txtLabel.getText().charAt(0);
		//System.out.println("theWord1: " + theWord + "  newWord: " + newWord);
		promptLabel.setText("Enter a Letter");
		x = 0;
		for (int i = 0; i < theWord.length(); i++) {
			if (letter == (theWord.charAt(i))) {
				newWord = (newWord.substring(0,i) + letter + newWord.substring(i + 1, newWord.length()));
				x = 1;
			}
		}
		txtLabel.setText("");
		//System.out.println("theWord2: " + theWord + "   newWord: " + newWord);
		wordLabel.setText(newWord);
		if(x == 0) {
			for (int i = 0; i < 7; i++) {		//for used letters
				if (letters[i] == letter2)
					break;
				if (letters[i] == ' ') {
					letters[i] = letter2;
					usedLetters.setText("");
					usedLetters.setText(toString(letters));
					break;
				}
			}
				count++;
				//System.out.print("strike " + count + ": ");
				if (count == 1) {
					head = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 2) {
				body = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 3) {
					Larm = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 4) {
					Rarm = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 5) {
					Lleg = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 6) {
					Rleg = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (count == 7) {
					face = true;
					promptLabel.setText("strike " + count + ": ");
				}
				if (checkLoss(count)) {     								// if checkLoss is true, player has lost
					promptLabel.setText("Nice try!");
					submitAllow = false;
				}
		}
		panel.repaint();
		//check win
		if (theWord.equals(wordLabel.getText())) {
			promptLabel.setText("Nice Job!");
			submitAllow = false;
		}
	  }
	}

	JButton replayButton;
	JButton submit;
	static JLabel promptLabel;
	public static JLabel wordLabel;
	static JLabel usedLetters;
	static JLabel usedLettersLabel;
	static JTextField txtLabel;
	private static char letter, letter2;
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
		panel.setBackground(Color.lightGray);
		//frame.add(hangmanGraphics, BorderLayout.WEST); //add graphics for hangman
		panel.setLayout(null);
		
		JLabel lblHangman = new JLabel("Hangman");
		lblHangman.setFont(new Font("Sitka Subheading", Font.PLAIN, 25));
		lblHangman.setBounds(154, 0, 114, 38);
		panel.add(lblHangman);
		
		promptLabel = new JLabel("Click Play!");
		promptLabel.setBounds(302, 59, 118, 35);
		panel.add(promptLabel);
		
		wordLabel = new JLabel("game word");
		wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
		wordLabel.setFont(new Font("courier", Font.PLAIN, 28));
		wordLabel.setBounds(25, 175, 352, 35);
		panel.add(wordLabel);
		
		usedLettersLabel = new JLabel("used letters");
		usedLettersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usedLettersLabel.setBounds(302, 132, 100, 20);
		usedLettersLabel.setForeground(Color.magenta);
		panel.add(usedLettersLabel);
		
		usedLetters = new JLabel("-");
		usedLetters.setHorizontalAlignment(SwingConstants.CENTER);
		usedLetters.setBounds(302, 153, 100, 20);
		usedLetters.setForeground(Color.BLACK);
		panel.add(usedLetters);
		
		txtLabel = new JTextField(" Input");
		txtLabel.setBounds(302, 107, 75, 25);
		txtLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		panel.add(txtLabel);
		
		submit = new JButton(">");
		submit.setBackground(Color.BLACK);
		submit.setForeground(Color.MAGENTA);
		submit.setBounds(377, 107, 40, 25);
		submit.setFont(new Font("Sitka Subheading", Font.PLAIN, 10));
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				run();
			}
		});
		panel.add(submit);
		
		replayButton = new JButton("Play [reset]");
		replayButton.setBackground(Color.BLACK);
		replayButton.setForeground(Color.MAGENTA);
		replayButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetMan();
				panel.repaint();
				submitAllow = true;
			}
		});
		replayButton.setBounds(280, 213, 130, 25);
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
	public static boolean face;	
	MyGraphics hangmanGraphics = new MyGraphics();
	
    public class MyGraphics extends JPanel{
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
    		if (face) {
    			g2d.drawLine(136, 73, 144, 73 );		// mouth
    		    g2d.fillOval(144, 66, 2, 2);			// right eye
    			g2d.fillOval(135, 66, 2, 2);		// left eye
    		}
        }
    }
    
    //Button pressing for tests
	public void replaypress() {
		replayButton.doClick();
	}
	public void sumbitpress() {
		submit.doClick();
	}
	
    
}

