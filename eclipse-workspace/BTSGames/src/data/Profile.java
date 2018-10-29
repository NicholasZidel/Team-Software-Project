package data;

import java.io.File;

import org.json.JSONObject;


public class Profile {
	
	private File file;
	private String path = "Output/Profiles/";
	
	private static String playerNameKey = "PLayerName";
	private static String playerProfileKey = "ProfileName";
	private static String split = ":";
	
	private String name;
	private String profileName;
	private File playerFile;
	
	public Profile(String name, String profileName) {
		this.name = name;
		this.profileName = profileName;
		createFilePath();
	}
	
	public void createFilePath() {
		file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
	}
	
	public String getJSONString() {
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.accumulate(playerNameKey, name);
			jsonObject.accumulate(playerProfileKey, profileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonObject.toString();
	}
	/*
	public String createStringForFile() {
		String forFile = playerNameKey + split + name + "\n" +
						playerProfileKey + split + profileName;
		return forFile;
	}*/
	
	public String getFilePath() {
		return path;
	}
}
