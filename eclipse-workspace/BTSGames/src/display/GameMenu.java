package display;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class GameMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameMenu window = new GameMenu();
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
	public GameMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton button = new JButton("<");
		frame.getContentPane().add(button, BorderLayout.WEST);
		
		JButton button_1 = new JButton(">");
		frame.getContentPane().add(button_1, BorderLayout.EAST);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblGameTitle = new JLabel("Game Title");
		lblGameTitle.setBounds(82, 5, 187, 48);
		lblGameTitle.setFont(new Font("Tahoma", Font.PLAIN, 39));
		panel.add(lblGameTitle);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setBounds(131, 135, 89, 23);
		panel.add(btnPlay);
		
		JButton btnLeaderboard = new JButton("Tutorial");
		btnLeaderboard.setBounds(131, 169, 89, 23);
		panel.add(btnLeaderboard);
	}
}
