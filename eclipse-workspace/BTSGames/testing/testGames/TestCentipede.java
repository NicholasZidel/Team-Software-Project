package testGames;

import static org.junit.Assert.assertEquals;

import javax.swing.JFrame;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import org.junit.jupiter.api.Test;

import Centipede.Mushroom;
import Centipede.gameData;

public class TestCentipede {

	JFrame frame = new JFrame();
	gameData test = gameData.getInstance(frame);
	
	public void runAllTests() {
		testGameDataSinglton();
		checkShroomCount();
	}
	
	@Test
	void testGameDataSinglton() {
		gameData test2 = gameData.getInstance(frame);
		
		assertEquals(test, test2);
	}
	
	@Test
	void testGetPlayer() {
		frame.addKeyListener(test.getPlayer());
		boolean check = test.getPlayer().equals(frame.getKeyListeners()[0]);
		
		assertEquals(true, check);
		
	}
	
	@Test
	void checkShroomCount() {
		int count = 0;
		for (Mushroom col[] : test.getMushrooms()) {
			for (Mushroom mush: col) {
				if (mush != null) {
					count++;
				}
			}
		}
		assertEquals(55, count);
	}
	
	@Test
	void testCentipedeMove() {
		int oldCol = test.getCentipede()[0].getCol();
		int oldRow = test.getCentipede()[0].getRow();
		
		test.getCentipede()[0].move();
		
		int newCol = test.getCentipede()[0].getCol();
		int newRow = test.getCentipede()[0].getRow();
		
		boolean colChange = (oldCol != newCol);
		boolean rowChange = (oldRow != newRow);
		
//		the col should change but not the row
		boolean check = (colChange == true && rowChange == false);
		
		assertEquals(true, check);
	}
	
	@Test
	void testUpdateShroomSpot1() {
		int col = 30;
		int row = 30;
		
		test.updateShroomSpots(col, row, true);
		assertEquals(true, test.getShroomSpots(col, row));
	}
	
	@Test
	void testUpdateShroomSpot2() {
		int col = 30;
		int row = 30;
		
		test.updateShroomSpots(col, row, false);
		assertEquals(false, test.getShroomSpots(col, row));
	}
	
	@Test
	void testHit() {
		test.getCentipede()[1].hit();
		assertEquals(100, test.getScore());
				
	}
	
	//just checks that the game doesnt crash after running for a bit
	@Test
	void runClock() {
		try {
			test.getClock().start();
	        try {
	            Thread.sleep(40000);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
		}
		catch (NullPointerException e) {
			assertEquals(false, true);
		}
		assertEquals(true, true);
	}
}
