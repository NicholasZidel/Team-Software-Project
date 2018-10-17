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

public class LoginMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginMenu window = new LoginMenu();
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
	public LoginMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(406, 429));
		frame.setMaximumSize(new Dimension(406, 429));
		frame.setResizable(false);
		frame.setBounds(100, 100, 352, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 400, 400);
		frame.getContentPane().add(panel);
		
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
		
		JLabel label_2 = new JLabel("AAA");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(75, 45, 50, 15);
		panel_2.add(label_2);
		
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

}
