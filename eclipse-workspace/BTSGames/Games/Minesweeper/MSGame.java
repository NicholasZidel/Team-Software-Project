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
		buildField();
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
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				board.add(field.get(j).get(i).getButton());
			}
		}
	}
	
	private static boolean getRandomBoolean() {
	       return Math.random() < 0.5;
	   }
	
	private void buildField() {
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
					checkNearbyBomb("NW", i, j);
				}
				//checks condition for adding N
				if (j != 0) {
					field.get(i).get(j).setNorth(field.get(i).get(j-1));
					checkNearbyBomb("N", i, j);
				}
				//checks condition for adding NE
				if (i != 9 && j != 0) {
					field.get(i).get(j).setNorthEast(field.get(i+1).get(j-1));
					checkNearbyBomb("NE", i, j);
				}
				//checks condition for adding E
				if (i != 9) {
					field.get(i).get(j).setEast(field.get(i+1).get(j));
					checkNearbyBomb("E", i, j);
				}
				//checks condition for adding SE
				if (i != 9 && j != 9) {
					field.get(i).get(j).setSouthEast(field.get(i+1).get(j+1));
					checkNearbyBomb("SE", i, j);
				}
				//checks condition for adding S
				if (j != 9) {
					field.get(i).get(j).setSouth(field.get(i).get(j+1));
					checkNearbyBomb("S", i, j);
				}
				//checks condition for adding SW
				if (i != 0 && j != 9) {
					field.get(i).get(j).setSouthWest(field.get(i-1).get(j+1));
					checkNearbyBomb("SW", i, j);
				}
				//checks condition for adding W
				if (i != 0) {
					field.get(i).get(j).setWest(field.get(i-1).get(j));
					checkNearbyBomb("W", i, j);
				}
			}
		}
	}
	
	private void checkNearbyBomb(String direction, int xcoord, int ycoord) {
		int type = field.get(xcoord).get(ycoord).getType();
		//stops if checked tile is bomb
		if (type == 9) {
			return;
		}
		//checks if NW is bomb
		if (direction.equals("NW")) {
			if (field.get(xcoord).get(ycoord).getNorthWest().getType() == 9 ) {
				field.get(xcoord).get(ycoord).setType(type + 1);
			}
			return;
		}
		//checks if N is bomb
			if (direction.equals("N")) {
				if (field.get(xcoord).get(ycoord).getNorth().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if NE is bomb
			if (direction.equals("NE")) {
				if (field.get(xcoord).get(ycoord).getNorthEast().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if E is bomb
			if (direction.equals("E")) {
				if (field.get(xcoord).get(ycoord).getEast().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if SE is bomb
			if (direction.equals("SE")) {
				if (field.get(xcoord).get(ycoord).getSouthEast().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if S is bomb
			if (direction.equals("S")) {
				if (field.get(xcoord).get(ycoord).getSouth().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if SW is bomb
			if (direction.equals("SW")) {
				if (field.get(xcoord).get(ycoord).getSouthWest().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
			//checks if W is bomb
			if (direction.equals("W")) {
				if (field.get(xcoord).get(ycoord).getWest().getType() == 9 ) {
					field.get(xcoord).get(ycoord).setType(type + 1);
				}
				return;
			}
	}

}
