package testData;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.LeaderBoard;
import data.Profile;

class LeaderBoardTest {

	@Test
	void updateTest() {
		LeaderBoard leaderBoard = new LeaderBoard();
		Profile profile = new Profile("John");
		
		leaderBoard.update("TicTacToe", "John", 10);
		
		System.out.println(leaderBoard.getJSONString());
		//assertEquals("{\"TicTacToe\":[{\"HighScore\":" + score + "},{\"Name\":\"John\"}]}", leaderBoard.getJSONString());
	}
	
	@Test
	void updateWithNewName() {
		LeaderBoard board = new LeaderBoard();
		
		board.update("Hangman", "Jim", 3);
		board.update("Hangman", "Jim", 2);
		board.update("Hangman", "Jim", 5);
		board.update("Hangman", "Tim", 3);
		board.update("Hangman", "Tim", 7);
		board.update("Hangman", "BILL", 10);
		board.update("Hangman", "Sara", 13);
		board.update("Hangman", "Sara", 11);
		board.update("TicTacToe", "John", 13);
	}
	
	
	@Test
	void createLeaderBoard() {
		LeaderBoard board = new LeaderBoard();
	}

}
