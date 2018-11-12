package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import display.Driver;
import display.GameMenu;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToeGame {

	JButton Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
	private JLabel winStatement;
	private JFrame frmTicTacToe;
	private JButton resetButton;
	private int[][] board;
	private int[][] board2;
	private int[] buttonPosition;
	private AI computer;
	private int gameEnd;
	private DifficultyPanel Dp;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGame window = new TicTacToeGame();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/
	//------------------------------------------------------------------------
	
	public void createFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TicTacToeGame window = new TicTacToeGame();
					window.frmTicTacToe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TicTacToeGame() {
		board = new int[3][3];
		board2 = new int[3][3];
		buttonPosition = new int[2];
		initialize();
	}
	
	private void setPlay(JButton b) {
		if (!b.getText().equals(" ")) {
			return;
		}

		board[buttonPosition[0]][buttonPosition[1]] = 1;
		board2[buttonPosition[0]][buttonPosition[1]] = 1;
		b.setText("X");
		gameEnd++;
		 if (checkWin(0)) {
			 return;
		 }
		if (gameEnd == 9) {
			return;
		}
		
		board2 = computer.decision(board2);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != board2[i][j]) {
					buttonPosition[0] = i;
					buttonPosition[1] = j;
				}
			}
		}
		board[buttonPosition[0]][buttonPosition[1]] = 2;
		
		if (buttonPosition[0] == 0) {
			if (buttonPosition[1] == 0) {
				Button1.setText("O");
			}
			if (buttonPosition[1] == 1) {
				Button2.setText("O");
			}
			if (buttonPosition[1] == 2) {
				Button3.setText("O");
			}
		}
		if (buttonPosition[0] == 1) {
			if (buttonPosition[1] == 0) {
				Button4.setText("O");
			}
			if (buttonPosition[1] == 1) {
				Button5.setText("O");
			}
			if (buttonPosition[1] == 2) {
				Button6.setText("O");
			}
		}
		if (buttonPosition[0] == 2) {
			if (buttonPosition[1] == 0) {
				Button7.setText("O");
			}
			if (buttonPosition[1] == 1) {
				Button8.setText("O");
			}
			if (buttonPosition[1] == 2) {
				Button9.setText("O");
			}
		}
		gameEnd++;
		if (checkWin(1)) {
			return;
		}
	}
	
	private void endGame() {
		Button1.setEnabled(false);
		Button2.setEnabled(false);
		Button3.setEnabled(false);
		Button4.setEnabled(false);
		Button5.setEnabled(false);
		Button6.setEnabled(false);
		Button7.setEnabled(false);
		Button8.setEnabled(false);
		Button9.setEnabled(false);
	}
	
	//add ability to updated profile later
	private boolean checkWin(int currentTurn) {
		/*
		 * rows is a 2D array listing all the 3 row combinations in tic tac toe
		 * rows 0-2 are columns 1-3
		 * rows 3-5 are rows 1-3
		 * row 6 is diagonal from upper left to lower right
		 * row 7 is diagonal from lower left to upper right
		 */
		int[][] rows = new int[8][3];
		
		//fills the row 2d array with proper places
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[j][count];
			}
			count++;
		}
		count = 0;
		for(int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[count][j];
			}
			count++;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			rows[6][i] = board[count][i];
			count++;
		}
		count = 2;
		for (int i = 0; i < 3; i++) {
			rows[7][i] = board[count][i];
			count--;
		}
//		for (int i = 0; i < 8; i++) {
//			for (int j = 0; j < 3; j++) {
//				System.out.print(rows[i][j]);
//			}
//			System.out.print("\n");
//		}
//		System.out.print("\n");
		
		//check to see if there are 3 in a row
		int rowCheck = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++ ) {
				if (rows[i][j] != 0) {
					rowCheck++;
				}
			}
			if (rowCheck == 3) {
				if (rows[i][0] == 1 && rows[i][1] == 1 && rows[i][2] == 1) {
					win(i, 0);
					endGame();
					return true;
				}
			}
			if (rowCheck == 3) {
				if (rows[i][0] == 2 && rows[i][1] == 2 && rows[i][2] == 2) {
					win(i, 1);
					endGame();
					return true;
				}
			}
			rowCheck = 0;
		}
		
		if (gameEnd == 9) {
			//winStatement.setText("TIE GAME");
			//winStatement.setVisible(true);
			Popup.createPopup(3);		
			endGame();
			return true;
		}
		
		return false;
	}
	
	private void win(int currentRow, int currentTurn) {
		//passing current row for ability to mark where win was
		if (currentTurn == 0) {
			//winStatement.setText("YOU WIN!!");
			//winStatement.setVisible(true);
			Popup.createPopup(1);
			Driver.currentUser.updateScore("TicTacToe");
		} else {
			//winStatement.setText("YOU LOSE");
			//winStatement.setVisible(true);
			Popup.createPopup(0);
		}
	}
	
	private void reset() {
		Button1.setEnabled(true);
		Button2.setEnabled(true);
		Button3.setEnabled(true);
		Button4.setEnabled(true);
		Button5.setEnabled(true);
		Button6.setEnabled(true);
		Button7.setEnabled(true);
		Button8.setEnabled(true);
		Button9.setEnabled(true);
		Button1.setText(" ");
		Button2.setText(" ");
		Button3.setText(" ");
		Button4.setText(" ");
		Button5.setText(" ");
		Button6.setText(" ");
		Button7.setText(" ");
		Button8.setText(" ");
		Button9.setText(" ");
		board = new int[3][3];
		board2 = new int[3][3];
		winStatement.setVisible(false);
		gameEnd = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setMinimumSize(new Dimension(550, 400));
		frmTicTacToe.setResizable(false);
		frmTicTacToe.setBounds(100, 100, 450, 300);
		frmTicTacToe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
        frmTicTacToe.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	GameMenu.resetTTT();
                //System.exit(0);
            }
        });

		
		JPanel panel = new JPanel();
		//panel.setVisible(false);
		
		panel.setBackground(Color.GRAY);
		//frmTicTacToe.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		
		//-------------------------------------------------------------------------------
		Dp = DifficultyPanel.getInstance();
		Dp.setVisible(true);
		frmTicTacToe.getContentPane().add(Dp);
		
		Dp.setEButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dp.setVisible(false);
				computer = new AI(0);
				frmTicTacToe.getContentPane().remove(Dp);
				frmTicTacToe.getContentPane().add(panel, BorderLayout.CENTER);
			}
		});
		
		Dp.setNButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dp.setVisible(false);
				computer = new AI(1);
				frmTicTacToe.getContentPane().remove(Dp);
				frmTicTacToe.getContentPane().add(panel, BorderLayout.CENTER);
			}
		});
		
		Dp.setHButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Dp.setVisible(false);
				computer = new AI(1);
				frmTicTacToe.getContentPane().remove(Dp);
				frmTicTacToe.getContentPane().add(panel, BorderLayout.CENTER);
			}
		});
		
		
		
//		DemoMenu DM = DemoMenu.getInstance();
//		
//		DifficultyPanel DP = DifficultyPanel.getInstance();
//		panel.add(DP, "DP");
//		
//		DM.setPlayButton(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				createFrame();
//				cl.show(panel, "DP");
//			}
//		});
//		
		//-------------------------------------------------------------------------------
		
		
		
		//Reset button----------------------------------------------------------------------------------------------------------------------
		resetButton = new JButton("Reset");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		resetButton.setForeground(Color.CYAN);
		resetButton.setBackground(Color.BLUE);
		GridBagConstraints gbc_resetButton = new GridBagConstraints();
		gbc_resetButton.insets = new Insets(0, 0, 5, 0);
		gbc_resetButton.gridx = 4;
		gbc_resetButton.gridy = 1;
		panel.add(resetButton, gbc_resetButton);
		
		//Labels for game title ----------------------------------------------------------------------------------------------------------
		JLabel titleLabel1 = new JLabel("Tic");
		titleLabel1.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		titleLabel1.setForeground(Color.BLUE);
		GridBagConstraints gbc_titleLabel1 = new GridBagConstraints();
		gbc_titleLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel1.gridx = 0;
		gbc_titleLabel1.gridy = 0;
		panel.add(titleLabel1, gbc_titleLabel1);
		
		JLabel titleLabel2 = new JLabel("Tac");
		titleLabel2.setForeground(Color.BLUE);
		titleLabel2.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		GridBagConstraints gbc_titleLabel2 = new GridBagConstraints();
		gbc_titleLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel2.gridx = 1;
		gbc_titleLabel2.gridy = 0;
		panel.add(titleLabel2, gbc_titleLabel2);
		
		JLabel titleLabel3 = new JLabel("Toe");
		titleLabel3.setFont(new Font("Snap ITC", Font.PLAIN, 20));
		titleLabel3.setForeground(Color.BLUE);
		GridBagConstraints gbc_titleLabel3 = new GridBagConstraints();
		gbc_titleLabel3.insets = new Insets(0, 0, 5, 5);
		gbc_titleLabel3.gridx = 2;
		gbc_titleLabel3.gridy = 0;
		panel.add(titleLabel3, gbc_titleLabel3);
		
		//Buttons 1  ---------------------------------------------------------------------------------------------------------------
		Button1 = new JButton(" ");
		Button1.setBackground(Color.CYAN);
		Button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 0;
				buttonPosition[1] = 0;
				setPlay(Button1);
			}
		});
		Button1.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button1.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button1 = new GridBagConstraints();
		gbc_Button1.insets = new Insets(0, 0, 5, 5);
		gbc_Button1.gridx = 0;
		gbc_Button1.gridy = 1;
		panel.add(Button1, gbc_Button1);
		
		//Buttons 2 ---------------------------------------------------------------------------------------------------------------
		Button2 = new JButton(" ");
		Button2.setBackground(Color.CYAN);
		Button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 0;
				buttonPosition[1] = 1;
				setPlay(Button2);
			}
		});
		Button2.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button2.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button2 = new GridBagConstraints();
		gbc_Button2.insets = new Insets(0, 0, 5, 5);
		gbc_Button2.gridx = 1;
		gbc_Button2.gridy = 1;
		panel.add(Button2, gbc_Button2);
		
		//Buttons 3 ---------------------------------------------------------------------------------------------------------------
		Button3 = new JButton(" ");
		Button3.setBackground(Color.CYAN);
		Button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 0;
				buttonPosition[1] = 2;
				setPlay(Button3);
			}
		});
		Button3.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button3.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button3 = new GridBagConstraints();
		gbc_Button3.insets = new Insets(0, 0, 5, 5);
		gbc_Button3.gridx = 2;
		gbc_Button3.gridy = 1;
		panel.add(Button3, gbc_Button3);
		
		//Buttons 4 ---------------------------------------------------------------------------------------------------------------
		Button4 = new JButton(" ");
		Button4.setBackground(Color.CYAN);
		Button4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 1;
				buttonPosition[1] = 0;
				setPlay(Button4);
			}
		});
		Button4.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button4.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button4 = new GridBagConstraints();
		gbc_Button4.insets = new Insets(0, 0, 5, 5);
		gbc_Button4.gridx = 0;
		gbc_Button4.gridy = 2;
		panel.add(Button4, gbc_Button4);
		
		//Buttons 5 ---------------------------------------------------------------------------------------------------------------
		Button5 = new JButton(" ");
		Button5.setBackground(Color.CYAN);
		Button5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 1;
				buttonPosition[1] = 1;
				setPlay(Button5);
			}
		});
		Button5.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button5.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button5 = new GridBagConstraints();
		gbc_Button5.insets = new Insets(0, 0, 5, 5);
		gbc_Button5.gridx = 1;
		gbc_Button5.gridy = 2;
		panel.add(Button5, gbc_Button5);
		
		//Buttons 6 ---------------------------------------------------------------------------------------------------------------
		Button6 = new JButton(" ");
		Button6.setBackground(Color.CYAN);
		Button6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 1;
				buttonPosition[1] = 2;
				setPlay(Button6);
			}
		});
		Button6.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button6.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button6 = new GridBagConstraints();
		gbc_Button6.insets = new Insets(0, 0, 5, 5);
		gbc_Button6.gridx = 2;
		gbc_Button6.gridy = 2;
		panel.add(Button6, gbc_Button6);
		
		//Buttons 7 ---------------------------------------------------------------------------------------------------------------
		Button7 = new JButton(" ");
		Button7.setBackground(Color.CYAN);
		Button7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 2;
				buttonPosition[1] = 0;
				setPlay(Button7);
			}
		});
		Button7.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button7.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button7 = new GridBagConstraints();
		gbc_Button7.insets = new Insets(0, 0, 0, 5);
		gbc_Button7.gridx = 0;
		gbc_Button7.gridy = 3;
		panel.add(Button7, gbc_Button7);
		
		//Buttons 8 ---------------------------------------------------------------------------------------------------------------
		Button8 = new JButton(" ");
		Button8.setBackground(Color.CYAN);
		Button8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 2;
				buttonPosition[1] = 1;
				setPlay(Button8);
			}
		});
		Button8.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button8.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button8 = new GridBagConstraints();
		gbc_Button8.insets = new Insets(0, 0, 0, 5);
		gbc_Button8.gridx = 1;
		gbc_Button8.gridy = 3;
		panel.add(Button8, gbc_Button8);
		
		//Buttons 9 ---------------------------------------------------------------------------------------------------------------
		Button9 = new JButton(" ");
		Button9.setBackground(Color.CYAN);
		Button9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonPosition[0] = 2;
				buttonPosition[1] = 2;
				setPlay(Button9);
			}
		});
		Button9.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button9.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button9 = new GridBagConstraints();
		gbc_Button9.insets = new Insets(0, 0, 0, 5);
		gbc_Button9.gridx = 2;
		gbc_Button9.gridy = 3;
		panel.add(Button9, gbc_Button9);
		
		//Win Label ----------------------------------------------------------------------------
		winStatement = new JLabel("");
		winStatement.setFont(new Font("Tahoma", Font.PLAIN, 30));
		winStatement.setPreferredSize(new Dimension(100, 300));
		winStatement.setVisible(false);
		panel.add(winStatement);

	}
	
	//button pressing methods for testing
	public void button1press() {
		Button1.doClick();
	}

	public void button2press() {
		Button2.doClick();
	}
	
	public void button3press() {
		Button3.doClick();
	}
	
	public void button4press() {
		Button4.doClick();
	}
	
	public void button5press() {
		Button5.doClick();
	}
	
	public void button6press() {
		Button6.doClick();
	}
	
	public void button7press() {
		Button7.doClick();
	}
	
	public void button8press() {
		Button8.doClick();
	}
	
	public void button9press() {
		Button9.doClick();
	}
	
	public void EButtonPress() {
		Dp.pressE();
	}
	
	public void NButtonPress() {
		Dp.pressN();
	}
	
	public void HButtonPress() {
		Dp.pressH();
	}
	
	public int[][] getBoard() {
		return board;
	}
}