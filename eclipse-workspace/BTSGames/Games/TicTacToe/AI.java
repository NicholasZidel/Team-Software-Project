package TicTacToe;

import java.util.ArrayList;

public class AI {
	private int[][] board = null;
	private int difficulty = -1;
	
	public AI (int diff) {
		difficulty = diff;
	}
	
	public int[][] decision (int[][] state) {
		board = state;
		int[][] dead = new int[3][3];
		if (difficulty == 0) {
			return easy();
		} else if (difficulty == 1) {
			return normal();
		} else  if (difficulty == 2) {
			return hard();
		} else {
			return dead;
		}
	}
	
	private int[][] easy() {
		ArrayList<Integer> possible = new ArrayList<Integer>();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[i][j] == 0) {
					if (i == 0) {
						possible.add(j+1);
					} else if (i == 1) {
						possible.add(j+4);
					} else {
						possible.add(j+7);
					}
				}
			}
		}
		int move = possible.get((int) Math.floor(Math.random() * possible.size() + 1) - 1);
		
		if (move == 1) {
			board[0][0] = 2;
		} else if (move == 2) {
			board[0][1] = 2;
		} else if (move == 3) {
			board[0][2] = 2;
		} else if (move == 4) {
			board[1][0] = 2;
		} else if (move == 5) {
			board[1][1] = 2;
		} else if (move == 6) {
			board[1][2] = 2;
		} else if (move == 7) {
			board[2][0] = 2;
		} else if (move == 8) {
			board[2][1] = 2;
		} else {
			board[2][2] =2;
		}
		
		return board;
	}
	
	private int[][] normal() {
		ArrayList<Integer> possible = new ArrayList<Integer>();
		/*
		 * rows is a 2D array listing all the 3 row combinations in tic tac toe
		 * rows 0-2 are columns 1-3
		 * rows 3-5 are rows 1-3
		 * row 6 is diagonal from upper left to lower right
		 * row 7 is diagonal from upper right to lower left
		 */
		int[][] rows = new int[8][3];
		
		//fills the row 2d array with proper places
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[j][count];
			}
			count++;
		}
		count = 0;
		for(int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[count][j];
			}
			count++;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			rows[6][i] = board[count][i];
			count++;
		}
		count = 2;
		for (int i = 0; i < 3; i++) {
			rows[7][i] = board[count][i];
			count--;
		}
		//checks to see if player has two in a row and then plays in that row
		for (int i = 0; i < 8; i++) {
			count = 0;
			for (int j = 0; j < 3; j++) {
				if (rows[i][j] == 1) {
					count++;
				}
				if (rows[i][j] == 2) {
					count = 100;
				}
			}
			if (count == 2) {
				return aha(i);
			}
		}
		return easy();
	}
	
	private int[][] hard () {
		ArrayList<Integer> possible = new ArrayList<Integer>();
		/*
		 * rows is a 2D array listing all the 3 row combinations in tic tac toe
		 * rows 0-2 are columns 1-3
		 * rows 3-5 are rows 1-3
		 * row 6 is diagonal from upper left to lower right
		 * row 7 is diagonal from upper right to lower left
		 */
		int[][] rows = new int[8][3];
		
		//fills the row 2d array with proper places
		int count = 0;
		for(int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[j][count];
			}
			count++;
		}
		count = 0;
		for(int i = 3; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				rows[i][j] = board[count][j];
			}
			count++;
		}
		count = 0;
		for (int i = 0; i < 3; i++) {
			rows[6][i] = board[count][i];
			count++;
		}
		count = 2;
		for (int i = 0; i < 3; i++) {
			rows[7][i] = board[count][i];
			count--;
		}
		//checks to see if computer has two in a row and then plays in that row
		for (int i = 0; i < 8; i++) {
			count = 0;
			for (int j = 0; j < 3; j++) {
				if (rows[i][j] == 2) {
					count++;
				}
				if (rows[i][j] == 1) {
					count = 100;
				}
			}
			if (count == 2) {
				return aha(i);
			}
		}
		return normal();
	}
	
	private int[][] aha (int row) {
		//plays move in specified column
		if (row >= 0 && row < 3) {
			for(int i = 0; i < 3; i++) {
				if (board[i][row] == 0) {
					board[i][row] = 2;
					return board;
				}
			}
		}
		
		//plays move in specified row
		if (row >= 3 && row < 6) {
			for(int i = 0; i < 3; i++) {
				if (board[row-3][i] == 0) {
					board[row-3][i] = 2;
					return board;
				}
			}
		}
		
		//plays move in diagonal from upper left to lower right
		if (row == 6) {
			if (board[0][0] == 0) {
				board[0][0] = 2;
				return board;
			}
			if (board[1][1] == 0) {
				board[1][1] = 2;
				return board;
			}
			if (board[2][2] == 0) {
				board[2][2] = 2;
				return board;
			}
		}
		
		//plays move in diagonal from upper right to lower left
		if (board[2][0] == 0) {
			board[2][0] = 2;
			return board;
		}
		if (board[1][1] == 0) {
			board[1][1] = 2;
			return board;
		}
		board[0][2] = 2;
		return board;
	}
}
