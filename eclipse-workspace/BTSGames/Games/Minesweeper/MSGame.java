package Minesweeper;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class MSGame {

	private static ArrayList<ArrayList<Tile>> field;
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MSGame window = new MSGame();
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
	public MSGame() {
		field = new ArrayList<ArrayList<Tile>>();
		build();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(600, 600));
		frame.setSize(new Dimension(400, 400));
		frame.setPreferredSize(new Dimension(400, 400));
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel border = new JPanel();
		border.setBackground(new Color(255, 153, 102));
		frame.getContentPane().add(border, BorderLayout.CENTER);
		border.setLayout(new BorderLayout(0, 0));
		
		JPanel board = new JPanel();
		board.setMinimumSize(new Dimension(450, 450));
		board.setFont(new Font("Tahoma", Font.PLAIN, 5));
		board.setSize(new Dimension(300, 300));
		board.setPreferredSize(new Dimension(450, 450));
		board.setMaximumSize(new Dimension(450, 450));
		board.setBackground(Color.WHITE);
		border.add(board, BorderLayout.CENTER);
		board.setLayout(new GridLayout(10, 10));
		
		JPanel westBar = new JPanel();
		westBar.setPreferredSize(new Dimension(47, 10));
		westBar.setSize(new Dimension(30, 10));
		westBar.setBackground(new Color(204, 153, 102));
		border.add(westBar, BorderLayout.WEST);
		
		JPanel northBar = new JPanel();
		northBar.setPreferredSize(new Dimension(10, 35));
		northBar.setBackground(new Color(204, 153, 102));
		border.add(northBar, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Minesweeper");
		lblTitle.setForeground(Color.DARK_GRAY);
		lblTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		northBar.add(lblTitle);
		
		JPanel eastBar = new JPanel();
		eastBar.setBackground(new Color(204, 153, 102));
		eastBar.setPreferredSize(new Dimension(47, 10));
		border.add(eastBar, BorderLayout.EAST);
		
		JPanel southBar = new JPanel();
		southBar.setPreferredSize(new Dimension(10, 33));
		southBar.setBackground(new Color(204, 153, 102));
		border.add(southBar, BorderLayout.SOUTH);
		
		JButton btnFlag = new JButton("Flag");
		southBar.add(btnFlag);
		
		JButton btnDig = new JButton("Dig");
		southBar.add(btnDig);
		
	}
	
	private static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	   }
	
	private void build () {
		int bombCount = 0;
		boolean temp;
		
		//adds all 10 columns to field
		for (int i = 0; i < 10; i++) {
			field.add(new ArrayList<Tile>());
		}
		
		//adds all tiles to field
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (bombCount < 10) {
					temp = getRandomBoolean();
					field.get(i).add(new Tile(temp, i, j));
				} else {
					field.get(i).add(new Tile(false, i, j));
				}
			}
		}
		
		addReferences();
	}
	
	private void addReferences() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				//checks condition for adding NW
				if (i != 0 && j != 0) {
					field.get(i).get(j).setNorthWest(field.get(i-1).get(j-1));
				}
				//checks condition for adding N
				if (j != 0) {
					field.get(i).get(j).setNorth(field.get(i).get(j-1));
				}
				//checks condition for adding NE
				if (i != 10 && j != 0) {
					field.get(i).get(j).setNorthEast(field.get(i+1).get(j-1));
				}
				//checks condition for adding E
				if (i != 10) {
					field.get(i).get(j).setEast(field.get(i+1).get(j));
				}
				//checks condition for adding SE
				if (i != 10 && j != 10) {
					field.get(i).get(j).setSouthEast(field.get(i+1).get(j+1));
				}
				//checks condition for adding S
				if (j != 10) {
					field.get(i).get(j).setSouth(field.get(i).get(j+1));
				}
				//checks condition for adding SW
				if (i != 0 && j != 10) {
					field.get(i).get(j).setSouthWest(field.get(i-1).get(j+1));
				}
				//checks condition for adding W
				if (i != 0) {
					field.get(i).get(j).setWest(field.get(i-1).get(j));
				}
			}
		}
	}
	
	private void checkNearbyBomb() {
		//used during addReferences to change the number of a tile according to number
		//of nearby bombs
	}

}
