package testData;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.json.JSONObject;
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
		System.out.println(result);
		
		assertEquals(result,stringToWrite);
		
		try {
			JSONObject jsonObject = new JSONObject(result);
			System.out.println(jsonObject.get("PlayerName"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testProfilewriteJSONFile() {
		Profile profile = new Profile("Jim");
		
		profile.writeJSONFile();
	}
}
