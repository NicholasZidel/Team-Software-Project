package testGames;

import TicTacToe.AI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TicTacToeAITest {

	@Test
	void easy() {
		AI testerAI = new AI(0);
		int[][] startArray = new int[3][3];
		startArray[0][0] = 1;
		startArray[0][1] = 2;
		startArray[0][2] = 2;
		startArray[1][0] = 1;
		startArray[1][1] = 1;
		startArray[1][2] = 2;
		startArray[2][0] = 1;
		int[][] arrayCase1 = new int[3][3];
		arrayCase1[0][0] = 1;
		arrayCase1[0][1] = 2;
		arrayCase1[0][2] = 2;
		arrayCase1[1][0] = 1;
		arrayCase1[1][1] = 1;
		arrayCase1[1][2] = 2;
		arrayCase1[2][0] = 1;
		arrayCase1[2][1] = 2;
		int[][] arrayCase2 = new int[3][3];
		arrayCase2[0][0] = 1;
		arrayCase2[0][1] = 2;
		arrayCase2[0][2] = 2;
		arrayCase2[1][0] = 1;
		arrayCase2[1][1] = 1;
		arrayCase2[1][2] = 2;
		arrayCase2[2][0] = 1;
		arrayCase2[2][2] = 2;
		startArray = testerAI.decision(startArray);
		
		boolean passed1 = true;
		boolean passed2 = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (startArray[i][j] != arrayCase1[i][j]) {
					passed1 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (startArray[i][j] != arrayCase2[i][j]) {
					passed2 = false;
				}
			}
		}
		
		if (passed1 || passed2) {
			assertTrue(true);
		} else {
			fail("");
		}
	}
	
	@Test
	void normal1() {
		AI testerAI = new AI(1);
		int[][] startArray = new int[3][3];
		startArray[0][0] = 1;
		startArray[0][1] = 2;
		startArray[1][1] = 1;
		int[][] arrayCase = new int[3][3];
		arrayCase[0][0] = 1;
		arrayCase[0][1] = 2;
		arrayCase[1][1] = 1;
		arrayCase[2][2] = 2;
		startArray = testerAI.decision(startArray);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (startArray[i][j] != arrayCase[i][j]) {
					fail("");
				}
			}
		}
		assertTrue(true);
	}
	
	@Test
	void normal2() {
		AI testerAI = new AI(1);
		int[][] startArray = new int[3][3];
		startArray[0][0] = 1;
		startArray[0][1] = 2;
		startArray[0][2] = 2;
		startArray[1][0] = 1;
		startArray[1][1] = 1;
		startArray[1][2] = 2;
		startArray[2][0] = 1;
		int[][] arrayCase1 = new int[3][3];
		arrayCase1[0][0] = 1;
		arrayCase1[0][1] = 2;
		arrayCase1[0][2] = 2;
		arrayCase1[1][0] = 1;
		arrayCase1[1][1] = 1;
		arrayCase1[1][2] = 2;
		arrayCase1[2][0] = 1;
		arrayCase1[2][1] = 2;
		int[][] arrayCase2 = new int[3][3];
		arrayCase2[0][0] = 1;
		arrayCase2[0][1] = 2;
		arrayCase2[0][2] = 2;
		arrayCase2[1][0] = 1;
		arrayCase2[1][1] = 1;
		arrayCase2[1][2] = 2;
		arrayCase2[2][0] = 1;
		arrayCase2[2][2] = 2;
		startArray = testerAI.decision(startArray);
		
		boolean passed1 = true;
		boolean passed2 = true;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (startArray[i][j] != arrayCase1[i][j]) {
					passed1 = false;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (startArray[i][j] != arrayCase2[i][j]) {
					passed2 = false;
				}
			}
		}
		
		if (passed1 || passed2) {
			assertTrue(true);
		} else {
			fail("");
		}
	}
}
