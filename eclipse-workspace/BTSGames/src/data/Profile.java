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
	private Buffer buffer = new Buffer();
	
	public Profile() {
		
	}
	
	public Profile(String name) {
		this.name = name;
		jsonObject = new JSONObject();
		try {
			jsonObject.put(playerNameKey, name);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	
	public boolean createDirFilePath() {
		file = new File(dirPath);
		
		boolean fileExists = !file.exists();
		if(fileExists) {
			file.mkdirs();
		}
		return fileExists;
	}
	
	public String getJSONString() {
		return jsonObject.toString();
	}
	
	public JSONObject getJSONObject() {
		return jsonObject;
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
	
	public int updateScore(String game) {
		gameKey = game;
		int currentScore = 0;
		//read file
		jsonObject = buffer.readFileJSONObject(dirPath + name + ".json"); 
		
		if(jsonObject.has(gameKey)) {
			try {
				currentScore = jsonObject.getInt(gameKey);
				jsonObject.put(gameKey, currentScore + 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				jsonObject.put(gameKey, 1);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		
		writeJSONFile();
		return currentScore + 1;
	}
	
	public int getScore(String game) {
		jsonObject = buffer.readFileJSONObject(dirPath + name + ".json"); 
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
