package display;
import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import Centipede.CDemoMenu;
import Hangman.HMDemoMenu;
import Hangman.HMTutorial;
import Hangman.HangmanGame;
import Minesweeper.MSDemoMenu;
import Minesweeper.MSGame;
import Minesweeper.MSTutorial;
import TicTacToe.DemoMenu;
import TicTacToe.DifficultyPanel;
import TicTacToe.TTTTutorial;
import TicTacToe.TicTacToeGame;

public class GameMenu extends JPanel{

	private static GameMenu panel = null;
	private static JButton btnReturn = new JButton("Return");
	
	public static GameMenu getInstance() {
		
		if (panel == null) {
			panel = new GameMenu();
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
	public GameMenu() {
	}
	//-------------------------------------------------------------------
	//makes sure you can only open once at a time per game
	static TicTacToeGame ttt = null;	
	public static void resetTTT() {			
		ttt = null;
	}
	static HangmanGame hm = null;
	public static void resetHM() {
		hm = null;
	}
	static MSGame ms = null;
	public static void resetMS() {
		ms = null;
	}
	//-------------------------------------------------------------------
	/**
	 * Initialize the contents of the frame.
	 */
	private static void initialize() {
		
		panel.setLayout(new BorderLayout(0, 0));
		
		JButton leftbutton = new JButton("<");
		leftbutton.setBackground(Color.GRAY);
		leftbutton.setForeground(Color.YELLOW);
		panel.add(leftbutton, BorderLayout.WEST);
		
		JButton rightbutton = new JButton(">");
		rightbutton.setBackground(Color.GRAY);
		rightbutton.setForeground(Color.YELLOW);
		panel.add(rightbutton, BorderLayout.EAST);
		
		CardLayout cl = new CardLayout();
		JPanel cardPanel = new JPanel();
		cardPanel.setLayout(cl);
		panel.add(cardPanel, BorderLayout.CENTER);
		
		DemoMenu DM = DemoMenu.getInstance();
		cardPanel.add(DM, "DM");
		
		MSDemoMenu MSM = MSDemoMenu.getInstance();
		cardPanel.add(MSM, "MSM");
		
		CDemoMenu CDM = CDemoMenu.getInstance();
		cardPanel.add(CDM, "CDM");
		
		//------------------------------------------------------------------------
		HMDemoMenu HMM = HMDemoMenu.getInstance();
		cardPanel.add(HMM, "HMM");
		
		HMM.setTutorialButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					HMTutorial.main(null);
			}
		});
		HMM.setPlayButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DP.setVisible(true);
				//cl.show(cardPanel, "DP");
				
				if (hm == null) {
					hm = new HangmanGame();
					hm.createHangman();							//runs hangman game
				}

			}
		});
		
		//------------------------------------------------------------------------
		//DifficultyPanel DP = DifficultyPanel.getInstance();
		//cardPanel.add(DP, "DP");
		

		DM.setPlayButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DP.setVisible(true);
				//cl.show(cardPanel, "DP");
				
				if (ttt == null) {
					ttt = new TicTacToeGame();
					ttt.createFrame();							//runs tictactoe game
				}

			}
		});
		
		DM.setTutorialButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TTTTutorial.main(null);
			}
		});
		//--------------------------------------------------------------------------
		MSM.setSweepButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (ms == null) {
					ms = new MSGame();
					ms.createFrame();							//runs Minesweeper game
				}

			}
		});
		
		MSM.setTutorialButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MSTutorial.main(null);
			}
		});
		//------------------------------------------------------------------------
			
		btnReturn.setBackground(Color.GRAY);
		btnReturn.setForeground(Color.YELLOW);
		panel.add(btnReturn, BorderLayout.SOUTH);

		
		leftbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.previous(cardPanel);
			}
		});
		
		rightbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.next(cardPanel);
			}
		});
	}
	
	public void setReturnButton(ActionListener action) {
		btnReturn.addActionListener(action);
	}
}
