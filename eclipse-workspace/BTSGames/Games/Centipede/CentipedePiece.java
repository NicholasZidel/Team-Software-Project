package Centipede;

import java.awt.Color;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

public class CentipedePiece extends JPanel {
	
	static CentipedePiece self = null;
	boolean dead = false;				//determines whether or not this piece has been shot and should be a mushroom
	boolean reachedBottom = false;
	int travelUpDown = 0;				//0 for down, 1 for up
	int travelLeftRight = 1;			//0 for left, 1 for right
	
	private int currentRow = 0;
	private int currentCol;
	private static gameData data;

	public CentipedePiece(int x, int y) {
		currentCol = x;
		currentRow = y;
//		add the code for the visuals of the centipede
	}
	
	public void sendData(gameData gamedata) {
		data = gamedata;
	}
	
	public void hit() {
		dead = true;
		data.updateShroomSpots(currentRow, currentCol, true);
		data.scoreUp();
		currentCol = -1;
	}
	
	public int getCol() {
		return currentCol;
	}
	
	public int getRow() {
		return currentRow;
	}
	
	public void move()
	{
		if (!dead) {
			if (travelLeftRight == 0) {
				moveLeft();
			}
			else {
				moveRight();
			}
		}
	}
	
	//this method changes the X coordinate of the piece to move it left by 5 pixels
	private void moveLeft() {
		if (currentCol == 0 || checkShrooms()) {
			if (reachedBottom && travelUpDown == 1) {
				upSwitch();
			}
			else {
				downSwitch();
			}
		}
		else {
			currentCol--;
		}
	}
	
	//this method changes the X coordinate of the piece to move it right by 5 pixels
	private void moveRight() {
		if (currentCol == 45 || checkShrooms()) {
			if (reachedBottom && travelUpDown == 1) {
				upSwitch();
			}
			else {
				downSwitch();
			}
		}
		else {
			currentCol++;
		}
	}
	
	//check if there is a shroom in the next spot
	private boolean checkShrooms() {
		if (travelLeftRight == 0) {
			return data.getShroomSpots(currentCol - 1, currentRow);
		}
		else {
			return data.getShroomSpots(currentCol + 1, currentRow);
		}
	}
	
	private void downSwitch() {
		if (currentRow == 48) {
			reachedBottom = true;
			travelUpDown = 1;
		}
		
		currentRow++;
		if (travelLeftRight == 0) {
			travelLeftRight = 1;
		}
		else {
			travelLeftRight = 0;
		}
	}
	
	private void upSwitch() {
		
		if (currentRow == 35) {
			travelUpDown = 0;
		}
		
		currentRow--;
		if (travelLeftRight == 0) {
			travelLeftRight = 1;
		}
		else {
			travelLeftRight = 0;
		}
	}
	
}
