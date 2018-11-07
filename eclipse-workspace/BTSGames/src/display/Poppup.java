package display;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Poppup {
	
	JFrame DNEpoppup = new JFrame("User does not exist");
	JFrame AREpoppup = new JFrame("User already exists");
	JButton DNEbtnOK = new JButton("OK");
	JButton AREbtnOK = new JButton("OK");
	private static Poppup instance;
	
	public static Poppup getInstance() {
		if (instance == null) {
			instance = new Poppup();
			return instance;
		}
		else {
			return instance;
		}
	}
	
	private Poppup() {
		initialize();
	}
	
	private void initialize() {
		DNEpoppup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		DNEpoppup.setLayout(new FlowLayout());
		DNEpoppup.setSize(275, 125);
		DNEpoppup.setResizable(false);
		JLabel DNElbl1 = new JLabel("Error: User does not exists.");
		JLabel DNElbl2 = new JLabel("Check your spelling or create a new user.");
		DNEpoppup.getContentPane().add(DNElbl1);
		DNEpoppup.getContentPane().add(DNElbl2);
		DNEpoppup.getContentPane().add(DNEbtnOK);
		
		AREpoppup.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		AREpoppup.setLayout(new FlowLayout());
		AREpoppup.setSize(275, 125);
		AREpoppup.setResizable(false);
		JLabel ARElbl1 = new JLabel("Error: User already exists.");
		JLabel ARElbl2 = new JLabel("Try a differnet username.");
		AREpoppup.getContentPane().add(ARElbl1);
		AREpoppup.getContentPane().add(ARElbl2);
		AREpoppup.getContentPane().add(AREbtnOK);
	}

	public void setDNEbutton(ActionListener action) {
		DNEbtnOK.addActionListener(action);
	}
	
	public void setAREbutton(ActionListener action) {
		AREbtnOK.addActionListener(action);
	}
	
	public void showDNE() {
		DNEpoppup.setVisible(true);
	}
	
	public void showARE() {
		AREpoppup.setVisible(true);
	}

	public void hideDNE() {
		DNEpoppup.setVisible(false);
	}
	
	public void hideARE() {
		AREpoppup.setVisible(false);
	}
}
