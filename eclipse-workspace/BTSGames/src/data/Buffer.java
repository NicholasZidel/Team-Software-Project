package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.Scanner;

import org.json.JSONException;
import org.json.JSONObject;

public class Buffer {
	
	public boolean writeFile(String toWrite, String path) {
	
		try {
			File file = new File(path);
			if( file.exists() ) {
				file.delete();
			}
			FileWriter writer = new FileWriter(file);
			writer.write(toWrite, 0, toWrite.length());
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}
	
	public String readFile(File fileToRead) {
		return "hello";
	}

	public JSONObject readFileJSONObject(String path) {
		String jsonString = readFile(path);
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = new JSONObject(jsonString);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonObject;
	}
	
	public String readFile(String path) {
		//JSONObject jsonObject = new JSONObject();
		String jsonString = "";
		if (path.substring(path.length() - 4, path.length()).equals("json")) {
			try {
				File file = new File(path);
				BufferedReader reader = new BufferedReader(new FileReader(file));
				String current = reader.readLine();
				while(current != null) {
					jsonString += current;
					current = reader.readLine();
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			/*
			try {
				jsonObject = new JSONObject(jsonString);
			} catch (Exception e) {
				e.printStackTrace();
			}*/
		}
		return jsonString;
	}
}

