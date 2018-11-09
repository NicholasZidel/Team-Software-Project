package testData;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import data.LeaderBoard;
import data.Profile;

class LeaderBoardTest {

	@Test
	void updateTest() {
		LeaderBoard leaderBoard = new LeaderBoard();
		Profile profile = new Profile();
		
		leaderBoard.update("TicTacToe", "John", profile.getScore("TicTacToe"));
		System.out.println(leaderBoard.getJSONString());
		//assertEquals("{\"TicTacToe\":[{\"HighScore\":0},{\"Name\":\"John\"}]}", leaderBoard.getJSONString());
	}

}
