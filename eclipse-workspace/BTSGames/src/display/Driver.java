package display;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.CardLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.SwingConstants;

import org.json.JSONObject;

import data.Buffer;
import data.Profile;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Driver {
	
	private JFrame frame;
	private static LoginMenu LM = LoginMenu.getInstance();
	private static MainMenu MM = MainMenu.getInstance();
	private static GameMenu GM = GameMenu.getInstance();
	private static StatisticsMenu SM = StatisticsMenu.getInstance();
	private static Profile currentUser;
	
	public void createWorld() {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Driver window = new Driver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Driver() {
		initialize();
	}
	
	private static boolean setProfileWhenSelectButtonClicked() {
		Profile temp = new Profile();
		Buffer buffer = new Buffer();
		//get file path
		String profileName = LM.getProfileName();
		String filePath = temp.getDirPath() + profileName + ".json";
		
		if( new File(filePath).exists() ) {
			JSONObject jsonObject =  buffer.readFileJSONObject(filePath);
			//create the instance using jsonObject 
			currentUser = new Profile(jsonObject);
			return true;
		}
		return false;
	}
	
	private void initialize() {
		CardLayout cl = new CardLayout();
		
		LM.setSelectButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Boolean profileExists = setProfileWhenSelectButtonClicked();
				if( profileExists == true ) {
					MM.setLoggedInAsName(currentUser.getName());
					cl.show(frame.getContentPane(), "MM");
				}
				else {
//					Create popup menu
				}
			}
		});
		
		MM.setLogoutButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentUser = null;
				cl.show(frame.getContentPane(), "LM");
			}
		});
		
		MM.setGameSelectButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "GM");
			}
		});
		
		MM.setStatisticsButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "SM");
			}
		});
		
		SM.setReturnButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "MM");
			}
		});
		
		GM.setReturnButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "MM");
			}
		});
		
		
		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(406, 429));
		frame.setMaximumSize(new Dimension(406, 429));
		frame.setResizable(false);
		frame.setBounds(100, 100, 352, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(cl);
		frame.getContentPane().add(LM, "LM");
		frame.getContentPane().add(MM, "MM");
		frame.getContentPane().add(SM, "SM");
		frame.getContentPane().add(GM, "GM");
		cl.show(frame.getContentPane(), "LM");
	}
}
