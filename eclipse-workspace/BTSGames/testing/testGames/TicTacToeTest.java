package testGames;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;

import TicTacToe.TicTacToeGame;

class TicTacToeTest {

	@Test
	void testGameGUI() {
		TicTacToeGame tester = new TicTacToeGame();
		tester.createFrame();
		tester.NButtonPress();
		tester.button1press();
		tester.button5press();
		int[][] board = tester.getBoard();
		
		int[][] arrayCase1 = new int[3][3];
		arrayCase1[0][0] = 1;
		arrayCase1[1][1] = 1;
		arrayCase1[2][2] = 2;
		arrayCase1[0][1] = 2;
		int[][] arrayCase2 = new int[3][3];
		arrayCase2[0][0] = 1;
		arrayCase2[1][1] = 1;
		arrayCase2[2][2] = 2;
		arrayCase2[0][2] = 2;
		int[][] arrayCase3 = new int[3][3];
		arrayCase3[0][0] = 1;
		arrayCase3[1][1] = 1;
		arrayCase3[2][2] = 2;
		arrayCase3[1][0] = 2;
		int[][] arrayCase4 = new int[3][3];
		arrayCase4[0][0] = 1;
		arrayCase4[1][1] = 1;
		arrayCase4[2][2] = 2;
		arrayCase4[1][2] = 2;
		int[][] arrayCase5 = new int[3][3];
		arrayCase5[0][0] = 1;
		arrayCase5[1][1] = 1;
		arrayCase5[2][2] = 2;
		arrayCase5[2][0] = 2;
		int[][] arrayCase6 = new int[3][3];
		arrayCase6[0][0] = 1;
		arrayCase6[1][1] = 1;
		arrayCase6[2][2] = 2;
		arrayCase6[2][1] = 2;
		
		boolean pass1 = true;
		boolean pass2 = true;
		boolean pass3 = true;
		boolean pass4 = true;
		boolean pass5 = true;
		boolean pass6 = true;
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase1[i][j]) {
					pass1 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase2[i][j]) {
					pass2 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase3[i][j]) {
					pass3 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase4[i][j]) {
					pass4 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase5[i][j]) {
					pass5 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] != arrayCase6[i][j]) {
					pass6 = false;
				}
			}
		}
		
		if (pass1 || pass2 || pass3 || pass4 || pass5 || pass6) {
			assertTrue(true);
		} else {
			fail("");
		}
	}

}
