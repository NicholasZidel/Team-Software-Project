package Centipede;

import java.awt.Point;

import javax.swing.JPanel;

public class Mushroom extends JPanel {

	private int row;
	private int col;
	private int damage = 0;					//When shot this number will go up. once it reaches 3 it will disappear
	boolean status = true;			//Turns to false once damage = 3
	private static gameData data;
	
	public Mushroom(int col, int row) {
		this.row = row;
		this.col = col;
	}
	
	public void sendData(gameData gamedata) {
		data = gamedata;
	}
	
	public void Damage() {
		damage++;
		if (damage == 3) {
			status = false;
			data.updateShroomSpots(col, row, status);
		}
	}
	
	public int getRow() {
		return row;
	}
	
	public int getCol() {
		return col;
	}
	
	public boolean getStatus() {
		return status;
	}
}
