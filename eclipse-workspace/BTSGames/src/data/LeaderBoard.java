package data;

import java.io.File;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class LeaderBoard {
	
	private String highScoreKey = "HighScore";
	private String nameKey = "Name";
	private String filePath = "Output/LeaderBoard.json";
	private File file;
	private Buffer buffer = new Buffer();
	private static int scoreIndex = 0;
	
	private JSONObject jsonObject;
	
	public LeaderBoard() {
		if( !(new File(filePath).exists()) ) {
			file = new File(filePath);
			jsonObject = new JSONObject();
		}
		else {
			jsonObject = getJSONObjectFromFile();
		}
	}
	/*
	public LeaderBoard(JSONObject jsonObject) {
		super();
		this.jsonObject = jsonObject;
	}*/
	
	public JSONObject getJSONObjectFromFile() {
		Buffer buffer = new Buffer();
		String json = buffer.readFile(filePath);
		JSONObject temp = null;
		try {
			temp = new JSONObject(json);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}
	
	public void update(String game, String name, int score) {
		//create two json objects. Keep track of name and score.
		//both objects will be mapped to the "game" key.
		JSONObject currentNameJSON = new JSONObject();
		JSONObject currentScoreJSON = new JSONObject();
		//jsonObject = buffer.readFileJSONObject(file.getPath()); 
		try {
			currentNameJSON.put(nameKey, name);
			currentScoreJSON.put(highScoreKey, score);
			
			if( jsonObject.has(game) ) {
				JSONObject highScore = (JSONObject)((JSONArray)jsonObject.get(game)).get(scoreIndex);
				if( score > highScore.getInt(highScoreKey) ) {
					highScore.put(highScoreKey, score);
				}
			} else {
				jsonObject.put(game, currentScoreJSON);
				jsonObject.accumulate(game, currentNameJSON);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		buffer.writeFile(jsonObject.toString(), filePath);
	}
	
	
	public String getJSONString() {
		return jsonObject.toString();
	}
	
	public JSONObject getJSONObject() {
		return jsonObject;
	}
}
