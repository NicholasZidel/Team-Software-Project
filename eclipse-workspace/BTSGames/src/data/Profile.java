package data;

import java.io.File;


import org.json.JSONException;
import org.json.JSONObject;


public class Profile {
	
	private File file;
	private String dirPath = "Output/Profiles/";
	private JSONObject jsonObject;
	
	private static String playerNameKey = "PlayerName";
	private static String gameKey = "";
	
	private String name;
	private File playerFile;
	
	public Profile() {
		
	}
	
	public Profile(String name) {
		this.name = name;
		createDirFilePath();
	}
	
	public Profile(JSONObject jsonObject) {
		this.jsonObject = jsonObject;
		try {
			this.name = (String)this.jsonObject.get(playerNameKey);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void createDirFilePath() {
		file = new File(dirPath);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	public String getJSONString() {
		jsonObject = new JSONObject();
		try {
			jsonObject.put(playerNameKey, name);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	
	public String writeJSONFile() {
		Buffer buffer = new Buffer();
		buffer.writeFile(this.getJSONString(), dirPath + name + ".json");
		return dirPath + name + ".json";
	}
	/*
	public String createStringForFile() {
		String forFile = playerNameKey + split + name + "\n" +
						playerProfileKey + split + profileName;
		return forFile;
	}*/
	
	public void updateScore(String game, int score) {
		if(jsonObject.has(game)) {
			try {
				int currentScore = jsonObject.getInt(game);
				if( currentScore < score ) {
					jsonObject.put(game, score);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			try {
				jsonObject.put(game, score);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public int getScore(String game) {
		int score = 0;
		try {
			score = jsonObject.getInt(game);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return score;
	}
	
	public String getDirPath() {
		return dirPath;
	}
}
