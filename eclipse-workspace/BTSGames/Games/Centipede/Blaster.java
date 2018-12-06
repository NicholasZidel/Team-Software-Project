package Centipede;

import javax.swing.JPanel;

public class Blaster extends JPanel {

	private static gameData data;
	
	private int currentRow;
	private int col;
	private boolean traveling = false;
	
	public Blaster(int row, int col) {
		currentRow = row;
		this.col = col;
	}
	
	public void sendData(gameData gamedata) {
		data = gamedata;
	}
	
	public void move() {
 		if (traveling) {
			if (currentRow < 0) {
				traveling = false;
			}
			else if (checkShroom()) {
				traveling = false;
				currentRow = -1;
			}
			else if (checkCentipede()) {
				traveling = false;
				currentRow = -1;
			}
			else {
				currentRow = currentRow - 2;
			}
		}
	}
	
	public void startPoint(int row, int col) {
		if (!traveling) {
			traveling = true;
			currentRow = row;
			this.col = col;
		}
	}
	
	public int getRow() {
		return currentRow;
	}
	
	public int getCol() {
		return col;
	}
	
	private boolean checkShroom() {
		
		if (data.getShroomSpots(col, currentRow + 1)) {
			data.getMushrooms(col, currentRow + 1).Damage();
			return true;
		}
		else if (data.getShroomSpots(col, currentRow)) {
			data.getMushrooms(col, currentRow).Damage();
			return true;
		}
		else {
			return false;
		}

	}
	
	private boolean checkCentipede() {
		for (CentipedePiece c : data.getCentipede()) {
			if (c.getCol() == col && c.getRow() == currentRow - 1) {
				c.hit();
				return true;
			}
			else if (c.getCol() == col && c.getRow() == currentRow) {
				c.hit();
				return true;
			}
		}
		return false;
	}
	
}
