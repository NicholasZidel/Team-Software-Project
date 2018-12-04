package display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import data.LeaderBoard;
import data.Profile;

public class StatisticsMenu extends JPanel {

	public StatisticsMenu() {
	}

	private static StatisticsMenu menu = null;
	
	private static JLabel gameField;
	private static JLabel highScoreField;
	private static JLabel playerScoreField;
	private static JLabel leaderBoardField;
	private static JButton btnReturnButton = new JButton("Return");
	
	public static StatisticsMenu getInstance() {
		if (menu == null) {
			menu = new StatisticsMenu();
			Initialize();
			return menu;
		}
		else {
			return menu;
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private static void Initialize() {
		menu.setLayout(null);
		menu.setBounds(0, 0, 400, 400);
		menu.setBackground(Color.LIGHT_GRAY);
		JPanel statsPanel = new JPanel();
		statsPanel.setBounds(3, 3, 400, 400);
		statsPanel.setBackground(Color.LIGHT_GRAY);
		statsPanel.setLayout(null);
		menu.add(statsPanel);
		
		JLabel title = new JLabel("STATISTICS");
		title.setFont(new Font("Lucida Grande", Font.PLAIN, 24));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBackground(new Color(238, 238, 238));
		title.setBounds(130, 6, 140, 41);
		statsPanel.add(title);
		
		JLabel lblGame = new JLabel("Game");
		lblGame.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblGame.setBounds(30, 50, 79, 30);
		statsPanel.add(lblGame);
		
		JLabel lblPersonal = new JLabel("Player Score");
		lblPersonal.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblPersonal.setBounds(130, 50, 100, 30);
		statsPanel.add(lblPersonal);
		
		JLabel lblLeaderboard = new JLabel("LeaderBoard");
		lblLeaderboard.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		lblLeaderboard.setBounds(265, 50, 150, 30);
		statsPanel.add(lblLeaderboard);
		
		btnReturnButton.setBounds(130, 350, 140, 35);
		btnReturnButton.setBackground(Color.gray);
		btnReturnButton.setForeground(Color.YELLOW);
		statsPanel.add(btnReturnButton);
		
		
		//text fields that will be updated
		//parse json file row by row
		gameField = new JLabel();
		gameField.setBounds(30, 77, 90, 261);
		statsPanel.add(gameField);
		gameField.setHorizontalAlignment(SwingConstants.LEFT);
		gameField.setVerticalAlignment(SwingConstants.TOP);
		gameField.setForeground(Color.blue);
		
		playerScoreField = new JLabel();
		playerScoreField.setBounds(130, 77, 80, 261);
		statsPanel.add(playerScoreField);
		playerScoreField.setHorizontalAlignment(SwingConstants.LEFT);
		playerScoreField.setVerticalAlignment(SwingConstants.TOP);
		playerScoreField.setForeground(Color.blue);
		
		
//		highScoreField = new JLabel();
//		highScoreField.setBounds(168, 77, 100, 261);
//		statsPanel.add(highScoreField);
//		highScoreField.setHorizontalAlignment(SwingConstants.LEFT);
//		highScoreField.setVerticalAlignment(SwingConstants.TOP);
//		highScoreField.setForeground(Color.blue);
		
		leaderBoardField = new JLabel();
		leaderBoardField.setBounds(265, 77, 224, 261);
		statsPanel.add(leaderBoardField);
		leaderBoardField.setHorizontalAlignment(SwingConstants.LEFT);
		leaderBoardField.setVerticalAlignment(SwingConstants.TOP);
		leaderBoardField.setForeground(Color.blue);
	}
	
	public int displayData( Profile player, LeaderBoard board ) {
		//leaderboard needs to be updated from profiles
		
		JSONObject jsonObject = board.getJSONObject();
		
		//if jsonObject is empty there is nothing to do
		if( jsonObject.length() == 0 ) {
			return 0;
		}
		
		//iterate through each key (game) then update that row.
		Iterator<String> keys = jsonObject.keys();
		
		try {
			while(keys.hasNext()) {
				String key = keys.next();
				JSONObject highScore = (JSONObject)((JSONArray)jsonObject.get(key)).get(board.getScoreIndex());
				JSONObject leaderName = (JSONObject)((JSONArray)jsonObject.get(key)).get(board.getNameIndex());
				//set values in leaderboard
				System.out.println(gameField.getText()+key);
				gameField.setText("<html>" + gameField.getText() + "<br/>" + key);
				leaderBoardField.setText("<html>" + leaderBoardField.getText() + "<br/>" +
							leaderName.get(board.getNameKey()) + " " + highScore.get(board.getScoreKey()));
				
				//need player score to match the game
				JSONObject playerJson = player.getJSONObject();
				if( playerJson.has(key)) {
					playerScoreField.setText("<html>" + playerScoreField.getText() + "<br/>" + 
														playerJson.get(key));
				} else {
					playerScoreField.setText("<html>" + playerScoreField.getText() + "<br/>" + 
														"null");
				}
				
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 1;
	}
	
	public void clear() {
		gameField.setText("");
		leaderBoardField.setText("");
		playerScoreField.setText("");
	}
	
	public void setReturnButton(ActionListener action) {
		btnReturnButton.addActionListener(action);
	}
}
