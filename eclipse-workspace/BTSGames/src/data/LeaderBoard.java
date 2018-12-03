package data;

import java.io.File;
import java.util.Iterator;

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
	private static int nameIndex = 1;
	private String profileLocation = "Output/Profiles/";
	
	private JSONObject jsonObject;
	
	public LeaderBoard() {
		//actually want to load from profiles
		jsonObject = new JSONObject();
		generateLeaderBoard();
		buffer.writeFile(jsonObject.toString(), filePath);
	}
	
	public void generateLeaderBoard() {
		File[] files = new File(profileLocation).listFiles();
		for( File file: files ) {
			String fileName = file.getName();
			
			if( fileName.endsWith(".json") && fileName.substring(0,1) != "") {
				//System.out.println(profileLocation + fileName);
				//read in file to leaderboard
				JSONObject currentProfile = buffer.readFileJSONObject("Output/Profiles/" + file.getName());
				Iterator<String> keys = currentProfile.keys();
				
				try {
					while(keys.hasNext()) {
						String gameKey = keys.next();
						if(!gameKey.equals("PlayerName"))
							update(gameKey, fileName.substring(0, fileName.length() - 5), currentProfile.getInt(gameKey));
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
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
				JSONObject leaderName = (JSONObject)((JSONArray)jsonObject.get(game)).get(nameIndex);
				if( score > highScore.getInt(highScoreKey) ) {
					highScore.put(highScoreKey, score);
					leaderName.put(nameKey, name);
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
	
	public int getScoreIndex() {
		return scoreIndex;
	}
	
	public int getNameIndex() {
		return nameIndex;
	}
	
	public String getScoreKey() {
		return highScoreKey;
	}
	
	public String getNameKey() {
		return nameKey;
	}
}
