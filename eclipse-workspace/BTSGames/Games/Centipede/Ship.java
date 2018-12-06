package Centipede;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class Ship extends JPanel implements KeyListener {
	int currentCol = 22;
	int currentRow = 41;
	private boolean upPressed;
	private boolean leftPressed;
	private boolean downPressed;
	private boolean rightPressed;
	int livesRemaining;
	
	private static gameData data;
	
	public Ship() {
		livesRemaining = 2;
	}

	public void sendData(gameData gamedata) {
		data = gamedata;
	}
	
	public void move() {
		data.getLaser().move();
		if (upPressed) {
			moveUp();
		}
		if (leftPressed) {
			moveLeft();
		}
		if (downPressed) {
			moveDown();
		}
		if (rightPressed) {
			moveRight();
		}
	}
	
	private void moveUp() {
		if (currentRow > 39) {
			if (!data.getShroomSpots(currentCol, currentRow - 1)) {
				currentRow--;
			}
		}
	}
	
	private void moveLeft() {
		if (currentCol > 0) {
			if (!data.getShroomSpots(currentCol - 1, currentRow)) {
				currentCol--;
			}
		}
	}
	
	private void moveDown() {
		if (currentRow < 49) {
			if (!data.getShroomSpots(currentCol, currentRow + 1)) {
				currentRow++;
			}
		}
	}
	
	private void moveRight() {
		if (currentCol < 44) {
			if (!data.getShroomSpots(currentCol + 1, currentRow)) {
				currentCol++;
			}
		}
		
	}
	
	public int getCol() {
		return currentCol;
	}
	
	public int getRow() {
		return currentRow;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_UP) : 
			upPressed = true;
		break;
		case (KeyEvent.VK_LEFT) :
			leftPressed = true;
		break;
		case (KeyEvent.VK_DOWN) :
			downPressed = true;
		break;
		case (KeyEvent.VK_RIGHT) :
			rightPressed = true;
		break;
		case (KeyEvent.VK_SPACE) :
			data.getLaser().startPoint(currentRow, currentCol);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case (KeyEvent.VK_UP) : 
			upPressed = false;
		break;
		case (KeyEvent.VK_LEFT) :
			leftPressed = false;
		break;
		case (KeyEvent.VK_DOWN) :
			downPressed = false;
		break;
		case (KeyEvent.VK_RIGHT) :
			rightPressed = false;
		break;
		}
	}
	
}
