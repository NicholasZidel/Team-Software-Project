package testGames;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Hangman.HangmanGame;

class HangmanTest {

	@Test
	void testReset() {
		
		HangmanGame game = new HangmanGame();
		game.replaypress();
		if (game.wordLabel.getText().equals(game.newWord)) {
		assertTrue(true);
		} else {
			fail("Not yet implemented");
		}
	}

}
