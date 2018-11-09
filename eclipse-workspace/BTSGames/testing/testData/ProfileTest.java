package testData;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import data.Buffer;
import data.Profile;

class ProfileTest {
	
	@Test
	void testStringForFile() {
		Profile profile = new Profile("John");
		String stringToWrite = profile.getJSONString();
		
		Buffer buffer = new Buffer();
		assertTrue(buffer.writeFile(stringToWrite, profile.getDirPath() + "john.json"));
		
		
		String result = buffer.readFile(profile.getDirPath() + "john.json");
		
		
		assertEquals(result,stringToWrite);
		
		try {
			JSONObject jsonObject = new JSONObject(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testProfilewriteJSONFile() {
		Profile profile = new Profile("Jim");
		
		profile.writeJSONFile();
	}
	
	@Test
	void createDirFilePathTest() {
		Profile profile = new Profile("John");
		//assertfalse because if the file path is already created no use for creating file path again
		assertFalse(profile.createDirFilePath());
	}
	
	@Test
	void JSONContructorTest() {
		Profile profile = new Profile("John");
		Profile copy = new Profile(profile.getJSONObject());
		
		assertEquals(profile.getJSONString(), copy.getJSONString());
	}
	
	@Test
	void writeJSONFileTest() {
		Profile profile = new Profile("John");
		String path = profile.writeJSONFile();
		
		Buffer buffer = new Buffer();
		JSONObject temp = buffer.readFileJSONObject(profile.getDirPath() + profile.getName() + ".json");
		
		assertEquals(temp.toString(), profile.getJSONString());
		assertEquals(path, profile.getDirPath() + "John.json");
		
	}
	
	/**
	 * Test is not performing correctly. Score is not being updated.
	 */
	@Test
	void updateScoreTest() {
		Profile profile = new Profile("John");
		try {
			assertEquals(profile.updateScore("TicTacToe"), profile.getJSONObject().getInt("TicTacToe"));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
