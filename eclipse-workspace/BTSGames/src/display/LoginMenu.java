package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class LoginMenu extends JPanel {

	private static LoginMenu menu = null;
	private JPanel panel = new JPanel();
	
	public static LoginMenu getInstance() {
		if (menu == null) {
			menu = new LoginMenu();
			return menu;
		}
		else {
			return menu;
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private LoginMenu() {
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 400);
		
		JLabel label = new JLabel("Select a Profile");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 50));
		label.setBounds(10, 11, 380, 99);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(100, 257, 200, 50);
		panel.add(panel_1);
		
		JButton button = new JButton("Select");
		button.setBounds(115, 15, 75, 20);
		panel_1.add(button);
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(10, 15, 100, 20);
		panel_1.add(formattedTextField);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(100, 121, 200, 125);
		panel.add(panel_2);
		
		JLabel label_1 = new JLabel("Top Scores:");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_1.setBounds(50, 10, 100, 25);
		panel_2.add(label_1);
		
		JLabel lblBbb = new JLabel("BBB");
		lblBbb.setHorizontalAlignment(SwingConstants.CENTER);
		lblBbb.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblBbb.setBounds(75, 45, 50, 15);
		panel_2.add(lblBbb);
		
		JLabel label_3 = new JLabel("AAA");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(75, 70, 50, 15);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("AAA");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(75, 95, 50, 15);
		panel_2.add(label_4);
	}

	public JPanel getPanel() {
		return panel;
	}
	
}
