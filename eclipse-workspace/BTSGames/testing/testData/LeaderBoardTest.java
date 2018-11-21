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

}
