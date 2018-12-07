package Centipede;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class gameData {

	private static gameData self = null;
	private static JFrame frame;
	private static JLabel score;
	private static CentipedePiece[] centipede = new CentipedePiece[10];
	private static Mushroom[][] mushrooms = new Mushroom[55][55];
	private static boolean[][] shroomSpots = new boolean[55][55];
	private static Ship player;
	private static Blaster laser;
	private GameClock clock = GameClock.initialize(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			for(CentipedePiece i : centipede) {
				i.move();
				i.setLocation(i.getCol() * 11 + 1, i.getRow() * 11 + 1);
			}
			player.move();
			player.setLocation(player.getCol() * 11 + 1, player.getRow() * 11 + 1);
			laser.setLocation(laser.getCol() * 11 + 4, laser.getRow() * 11 + 1);
		}
	});
	
	
	private static int playerScore = 0;
	
	private gameData() {
		createPlayer();
		createCentipede();
		placeShrooms();
		createLaser();
	}
	
	public static gameData getInstance(JFrame gameframe) {
		if (self == null) {
			self = new gameData();
			frame = gameframe;
			sendData();
			addToFrame();
			return self;
		}
		else {
			return self;
		}
	}
	
	
	public CentipedePiece[] getCentipede() {
		return centipede;
	}
	
	public void scoreUp() {
		playerScore += 100;
		score.setText(Integer.toString(playerScore));
		if (playerScore % 1000 == 0) {
			resetCentipede();
		}
	}
	
	public int getScore() {
		return playerScore;
	}
	
	public Mushroom getMushrooms(int col, int row) {
		return mushrooms[col][row];
	}
	
	public Mushroom[][] getMushrooms() {
		return mushrooms;
	}
	
	public boolean getShroomSpots(int col, int row) {
		return shroomSpots[col][row];
	}
	
	public void updateShroomSpots(int col, int row, boolean state) {
		shroomSpots[col][row] = state;
		if (state) {
			mushrooms[col][row] = new Mushroom(row, col);
			mushrooms[col][row].sendData(self);
			mushrooms[col][row].setBounds(col * 11 + 1, row * 11 + 1, 10, 10);
			frame.getContentPane().add(mushrooms[col][row]);
		}
		else {
			frame.getContentPane().remove(mushrooms[col][row]);
			mushrooms[col][row] = null;
		}
	}
	
	public Ship getPlayer() {
		return player;
	}
	
	public Blaster getLaser() {
		return laser;
	}
	
	public GameClock getClock() {
		return clock;
	}
	
	
//	--------------------------------------------------------------------
	
	
//	Creates the player
	
	private void createPlayer() {
		player = new Ship();
		player.setBackground(Color.BLUE);
	}
	
//	--------------------------------------------------------------------	

	
//	Creates the centipede
	
	private void createCentipede() {
		for (int i = 0; i < centipede.length; i++) {
			centipede[i] = new CentipedePiece(i, 0);
		}
	}
//	--------------------------------------------------------------------
	
	
//	Creates and places the mushrooms, also creates mushroom location array
	
	private void placeShrooms() {
		for (int i = 0; i < 55; i++) {
			boolean placed = false;
			while (!placed) {
				int rndX = (int) (Math.random() * 45);
				int rndY = (int) (Math.random() * 46 + 1);
				if (!shroomSpots[rndX][rndY]) {
					mushrooms[rndX][rndY] = new Mushroom(rndX, rndY);
					shroomSpots[rndX][rndY] = true;
					placed = true;
				}
			}
			
		}
	}
//	--------------------------------------------------------------------
	
	
//	Creates the blaster and passes it the information it needs
	
	private void createLaser() {
		laser = new Blaster(30, -1);
	}
//	--------------------------------------------------------------------
	
	
//	Adds everything to the frame
	
	public static void addToFrame() {
		int i = 0;
		for (CentipedePiece c : centipede) {
			c.setBounds(i++ * 11 + 1, 1, 10, 10);
			frame.getContentPane().add(c);
			c.setVisible(true);
		}
		
		for (int x = 0; x < 50; x++) {
			for (int y = 0; y < 50; y++) {
				if (shroomSpots[x][y]) {
					mushrooms[x][y].setBounds(x * 11 + 1, y * 11 + 1, 10, 10);
					frame.getContentPane().add(mushrooms[x][y]);
				}
			}
		}
		
		player.setBounds(254, 441, 10, 10);
		frame.getContentPane().add(player);
		frame.addKeyListener(player);
		laser.setBounds(laser.getCol() * 11  + 3, laser.getRow() * 11 + 1, 4, 10);
		frame.getContentPane().add(laser);
		
		score = new JLabel(Integer.toString(playerScore));
		score.setBounds(400, 10, 100, 20);
		score.setForeground(Color.WHITE);
		frame.getContentPane().add(score);
	}
	
	
//	--------------------------------------------------------------------
	
	
//	sends the gameData to all of the classes that need to be able to access it.
	
	private static void sendData() {
		for (CentipedePiece c : centipede) {
			c.sendData(self);
		}
		for(Mushroom col[] : mushrooms) {
			for (Mushroom mush : col) {
				if (mush != null) {
					mush.sendData(self);
				}
			}
		}
		laser.sendData(self);
		player.sendData(self);
	}
	
//	--------------------------------------------------------------------
	
	
//	resets the centipede
	
	private void resetCentipede() {
		centipede = new CentipedePiece[10];
		createCentipede();
		int i = 0;
		for (CentipedePiece c : centipede) {
			c.sendData(self);
			c.setBounds(i++ * 11 + 1, 1, 10, 10);
			frame.getContentPane().add(c);
			c.setVisible(true);
		}
	}
}
