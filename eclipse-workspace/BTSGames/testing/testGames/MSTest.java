package testGames;

import static org.junit.jupiter.api.Assertions.*;
import Minesweeper.MSGame;
import Minesweeper.Tile;
import org.junit.jupiter.api.Test;

class MSTest {

	@Test
	void testPlay() {
		MSGame tester = new MSGame();
		tester.createFrame();
		Tile testee = tester.getRandom();
		int x = testee.getXCoord();
		int y = testee.getYCoord();
		tester.getTile(x, y).doClick();
		if (tester.getTile(x, y).getType() == 9 ) {
			testPlay();
		} else if (tester.getDug() > 0) {
			assertTrue(true);
		}
	}

}
