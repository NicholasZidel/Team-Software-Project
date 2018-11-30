package Minesweeper;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;

import display.GameMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JLabel;
import java.awt.Font;

public class MSGame {

	private boolean digging = true;
	private static ArrayList<ArrayList<Tile>> field;
	private int dugCount;
	
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
	
	public void createFrame() {
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
		dugCount = 0;
		field = new ArrayList<ArrayList<Tile>>();
		buildField();
		initialize();
		addActions();
//		for (int i = 0; i < 10; i++) {
//			for (int j = 0; j < 10; j++) {
//				field.get(i).get(j).setText(Integer.toString(field.get(i).get(j).getType()));
//			}
//		}
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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            	GameMenu.resetMS();
                //System.exit(0);
            }
        });
		
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
		btnDig.setEnabled(false);
		
		JButton btnReset = new JButton("Reset");
		southBar.add(btnReset);
		
		//action listener for btnReset
				btnReset.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reset();
					}
				});
		
		//action listener for btnFlag
		btnFlag.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				digging = false;
				btnDig.setEnabled(true);
				btnFlag.setEnabled(false);
			}
		});
		
		//action listener for btnDig
				btnDig.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						digging = true;
						btnDig.setEnabled(false);
						btnFlag.setEnabled(true);
					}
				});
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				board.add(field.get(j).get(i));
			}
		}
	}
	
	//adds action listener
	private void addActions() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int di = i;
				int dj = j;
				Tile temp = field.get(i).get(j);
				field.get(i).get(j).addActionListener(new ActionListener() {
					private int x = field.get(di).get(dj).getXCoord();
					private int y = field.get(di).get(dj).getYCoord();
					public void actionPerformed(ActionEvent e) {
						if (!digging) {
							flagging(x, y);
						} else {
							dig(temp);
							checkWin();
						}
					}
				});
			}
		}
	}
	
	//digging action
	private void dig(Tile current) {
		int xcoord = current.getXCoord();
		int ycoord = current.getYCoord();
		if (field.get(xcoord).get(ycoord).getIsDug()) {
			return;
		}
		if (current == null) {
			return;
		}
		int type = field.get(xcoord).get(ycoord).getType();
		
		if (type == 9) {
			lost();
		} else if (type == 0) {
			dugCount++;
			field.get(xcoord).get(ycoord).setEnabled(false);
			field.get(xcoord).get(ycoord).setIsDug(true);
			if (!(current.getNorthWest() == null)) {
				dig(current.getNorthWest());
			}
			if (!(current.getNorth() == null)) {
				dig(current.getNorth());
			}
			if (!(current.getNorthEast() == null)) {
				dig(current.getNorthEast());
			}
			if (!(current.getEast() == null)) {
				dig(current.getEast());
			}
			if (!(current.getSouthEast() == null)) {
				dig(current.getSouthEast());
			}
			if (!(current.getSouth() == null)) {
				dig(current.getSouth());
			}
			if (!(current.getSouthWest() == null)) {
				dig(current.getSouthWest());
			}
			if (!(current.getWest() == null)) {
				dig(current.getWest());
			}
		} else {
			dugCount++;
			field.get(xcoord).get(ycoord).setEnabled(false);
			field.get(xcoord).get(ycoord).setText(Integer.toString(type));
			field.get(xcoord).get(ycoord).setForeground(Color.BLUE);
			field.get(xcoord).get(ycoord).setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			field.get(xcoord).get(ycoord).setIsDug(true);
		}
	}
	
	//flagging action
	private void flagging(int xcoord, int ycoord) {
		Tile temp = field.get(xcoord).get(ycoord);
		if (!field.get(xcoord).get(ycoord).getIsFlag()) {
			field.get(xcoord).get(ycoord).setText("F");
			field.get(xcoord).get(ycoord).setForeground(Color.RED);
			field.get(xcoord).get(ycoord).setFont(new Font("Trebuchet MS", Font.BOLD, 20));
			field.get(xcoord).get(ycoord).setIsFlag(true);
		} else {
			field.get(xcoord).get(ycoord).setText(null);
			field.get(xcoord).get(ycoord).setIsFlag(false);
		}
	}
	
	//handles lost game
	private void lost() {
		Popup.createPopup(0);
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (field.get(i).get(j).getType() == 9) {
					field.get(i).get(j).setEnabled(false);
					field.get(i).get(j).setText("B");
					field.get(i).get(j).setFont(new Font("Trebuchet MS", Font.BOLD, 20));
				} else {
					field.get(i).get(j).setEnabled(false);
				}
			}
		}
	}
	
	//handles won game
	private void checkWin() {
		if (dugCount == 90) {
			Popup.createPopup(1);
			for (int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					if (field.get(i).get(j).getType() == 9) {
						field.get(i).get(j).setEnabled(false);
						field.get(i).get(j).setText("B");
						field.get(i).get(j).setFont(new Font("Trebuchet MS", Font.BOLD, 20));
					}
				}
			}
		}
	}
	
	private void reset() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				field.get(i).get(j).setEnabled(true);
				field.get(i).get(j).setType(0);
				field.get(i).get(j).setText(null);
				field.get(i).get(j).setIsDug(false);
				field.get(i).get(j).setIsFlag(false);
			}
		}
		dugCount = 0;
		addBomb();
		addReferences();
	}
	
	private void buildField() {
		//adds all 10 columns to field
		for (int i = 0; i < 10; i++) {
			field.add(new ArrayList<Tile>());
		}
		
		//adds all tiles to field
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				field.get(i).add(new Tile(false, i, j));
			}
		}
	
		addBomb();
		addReferences();
	}
	
	private void addBomb() {
		int count = 0;
		int x;
		int y;
		while (count < 10) {
			x = (int) (Math.random() * 9);
			y = (int) (Math.random() * 9);
			if (field.get(x).get(y).getType() != 9) {
				field.get(x).get(y).setType(9);
				count++;
			}
		}
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
