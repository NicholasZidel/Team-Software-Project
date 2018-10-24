package display;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Driver {
	
	private JFrame frame;
	private static LoginMenu LM = LoginMenu.getInstance();
	private static MainMenu MM = MainMenu.getInstance();
	private static GameMenu GM = GameMenu.getInstance();
	
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
	
	private void initialize() {
		LM.setSelectButton(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LM.setVisible(false);
				MM.setVisible(true);
				frame.getContentPane().remove(LM);
			}
		});
		
		frame = new JFrame();
		frame.setMinimumSize(new Dimension(406, 429));
		frame.setMaximumSize(new Dimension(406, 429));
		frame.setResizable(false);
		frame.setBounds(100, 100, 352, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(LM);
		frame.getContentPane().add(MM);
		MM.setVisible(false);
	}
}
