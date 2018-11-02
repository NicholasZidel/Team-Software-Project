package TicTacToe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class TicTacToeGame {

	JButton Button1, Button2, Button3, Button4, Button5, Button6, Button7, Button8, Button9;
	private int counter = 0;
	private JFrame frmTicTacToe;
	private JButton resetButton;

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public TicTacToeGame() {
		initialize();
	}
	
	public void setPlay(JButton b, int count) {
		if (count % 2 == 0)
			b.setText("X");
		else
			b.setText("O");
		counter++;
	}
	
	public void reset() {
		Button1.setText(" ");
		Button2.setText(" ");
		Button3.setText(" ");
		Button4.setText(" ");
		Button5.setText(" ");
		Button6.setText(" ");
		Button7.setText(" ");
		Button8.setText(" ");
		Button9.setText(" ");
		counter = 0;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTicTacToe = new JFrame();
		frmTicTacToe.setTitle("Tic Tac Toe");
		frmTicTacToe.setMinimumSize(new Dimension(350, 400));
		frmTicTacToe.setBounds(100, 100, 450, 300);
		frmTicTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		frmTicTacToe.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
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
				setPlay(Button1, counter);
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
				setPlay(Button2, counter);
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
				setPlay(Button3, counter);
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
				setPlay(Button4, counter);
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
				setPlay(Button5, counter);
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
				setPlay(Button6, counter);
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
				setPlay(Button7, counter);
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
				setPlay(Button8, counter);
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
				setPlay(Button9, counter);
			}
		});
		Button9.setFont(new Font("Tahoma", Font.PLAIN, 76));
		Button9.setPreferredSize(new Dimension(100, 100));
		GridBagConstraints gbc_Button9 = new GridBagConstraints();
		gbc_Button9.insets = new Insets(0, 0, 0, 5);
		gbc_Button9.gridx = 2;
		gbc_Button9.gridy = 3;
		panel.add(Button9, gbc_Button9);
	}

}
