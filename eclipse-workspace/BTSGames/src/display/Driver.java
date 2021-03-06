package display;

import java.awt.EventQueue;
import java.awt.FlowLayout;

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
import data.LeaderBoard;
import data.Profile;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Driver {
	
	private JFrame frame;
	private static LoginMenu LM = LoginMenu.getInstance();
	private static MainMenu MM = MainMenu.getInstance();
	private static GameMenu GM = GameMenu.getInstance();
	private static StatisticsMenu SM = StatisticsMenu.getInstance();
	private static Poppup pop = Poppup.getInstance();
	public static Profile currentUser;
	boolean login = true;
	private static CardLayout cl = new CardLayout();
	private static ActionListener loginAction;
	private static ActionListener createAction;
	
	public void createWorld(Driver drive) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					drive.frame.setVisible(true);
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
		
		loginButtonSetup();
		
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
				//create leaderboard
				LeaderBoard board = new LeaderBoard();
				
				//need to display statistics
				SM.displayData(currentUser, board);
			}
		});
		
		SM.setReturnButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SM.clear();
				cl.show(frame.getContentPane(), "MM");
			}
		});
		
		GM.setReturnButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl.show(frame.getContentPane(), "MM");
			}
		});
		
		pop.setAREbutton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				pop.hideARE();
			}
		});
		
		pop.setDNEbutton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setEnabled(true);
				pop.hideDNE();
			}
		});
		
		frame = new JFrame("BTS Games");
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
	
	private void loginButtonSetup() {
		LM.setLoginButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (setProfileWhenSelectButtonClicked()) {
					MM.setLoggedInAsName(currentUser.getName());
					cl.show(frame.getContentPane(), "MM");
				}
				else {
					frame.setEnabled(false);
					pop.showDNE();
				}
			}
		});
		
		LM.setCreateButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!setProfileWhenSelectButtonClicked()) {
					currentUser = new Profile(LM.getProfileName());
					currentUser.writeJSONFile();

					MM.setLoggedInAsName(currentUser.getName());
					cl.show(frame.getContentPane(), "MM");
				}
				else {
					frame.setEnabled(false);
					pop.showARE();
					//stop. retry login.
				}
			}
		});
	}
}
