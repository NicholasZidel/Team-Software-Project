package data;

import org.json.JSONException;
import org.json.JSONObject;

public class LeaderBoard {
	
	private String highScoreKey = "HighScore";
	private String nameKey = "Name";
	
	private JSONObject jsonObject = new JSONObject();
	
	public LeaderBoard() {
		
	}
	
	public LeaderBoard(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
	}
	
	public void update(String game, String name, int score) {
		//create two json objects. Keep track of name and score.
		//both objects will be mapped to the "game" key.
		JSONObject currentNameJSON = new JSONObject();
		JSONObject currentScoreJSON = new JSONObject();
		
		try {
			currentNameJSON.put(nameKey, name);
			currentScoreJSON.put(highScoreKey, score);
			
			if( jsonObject.get(highScoreKey) != null ) {
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
	}
	
	
	public String getJSONString() {
		return jsonObject.toString();
	}
	
	public JSONObject getJSONObject() {
		return jsonObject;
	}
}
