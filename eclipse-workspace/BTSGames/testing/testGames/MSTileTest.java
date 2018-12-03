package testGames;

import static org.junit.jupiter.api.Assertions.*;
import Minesweeper.Tile;
import org.junit.jupiter.api.Test;

class MSTileTest {

	@Test
	void testCreate() {
		Tile test = new Tile(true, 3, 5);
		if (test.getType() == 9) {
			assertTrue(true);
		}
	}
	
	@Test
	void testReference() {
		Tile test1 = new Tile(true, 3, 5);
		Tile test2 = new Tile(false, 4, 5);
		Tile test3 = new Tile(false, 3, 4);
		Tile test4 = new Tile(false, 4, 4);
		test1.setNorth(test3);
		test1.setNorthEast(test4);
		test1.setEast(test2);
		test2.setWest(test1);
		test2.setNorthWest(test3);
		test2.setNorth(test4);
		test3.setSouth(test1);
		test3.setSouthEast(test2);
		test3.setEast(test4);
		test4.setSouth(test2);
		test4.setSouthWest(test1);
		test4.setWest(test3);
		if (test1.getEast().getNorth().getWest().getSouth().getNorthEast().getWest().getSouthEast().getWest().getType() == 9) {
			assertTrue(true);
		}
	}

}
