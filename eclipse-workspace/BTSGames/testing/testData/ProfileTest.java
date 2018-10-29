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
		Profile profile = new Profile("John", "j_money");
		
		String stringToWrite = profile.getJSONString();
		
		Buffer buffer = new Buffer();
		assertTrue(buffer.writeFile(stringToWrite, profile.getFilePath() + "john.json"));
		
		
		String result = buffer.readFile(profile.getFilePath() + "john.json");
		System.out.println(result);
		
		assertEquals(result,stringToWrite);
		
		try {
			JSONObject jsonObject = new JSONObject(result);
			System.out.println(jsonObject.get("PLayerName"));
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
