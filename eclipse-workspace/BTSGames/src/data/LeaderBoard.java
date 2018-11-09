package data;

import java.io.File;

import org.json.JSONException;
import org.json.JSONObject;

public class LeaderBoard {
	
	private String highScoreKey = "HighScore";
	private String nameKey = "Name";
	private String filePath = "Output/LeaderBoard.json";
	private File file;
	private Buffer buffer = new Buffer();
	
	private JSONObject jsonObject;
	
	public LeaderBoard() {
		if( !(new File(filePath)).exists() ) {
			file = new File(filePath);
		}
		jsonObject = new JSONObject();
	}
	
	public LeaderBoard(JSONObject jsonObject) {
		super();
		this.jsonObject = jsonObject;
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
				JSONObject highScoreJSON = (JSONObject)jsonObject.get(highScoreKey);
				if( score > highScoreJSON.getDouble(highScoreKey) ) {
					jsonObject.put(game, currentScoreJSON);
					jsonObject.accumulate(game, currentNameJSON);
				}
			} else {
				jsonObject.put(game, currentScoreJSON);
				jsonObject.accumulate(game, currentNameJSON);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//buffer.writeFile(jsonObject.toString(), file.getPath());
	}
	
	
	public String getJSONString() {
		return jsonObject.toString();
	}
	
	public JSONObject getJSONObject() {
		return jsonObject;
	}
}
