package Centipede;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

public class GameClock extends Timer {

	public GameClock(int delay, ActionListener listener) {
		super(delay, listener);
	}

	private static GameClock self;
	static int delay = 30;
	
	public static GameClock initialize(ActionListener task) {
		if (self == null) {
			self = new GameClock(delay, task);
			return self;
		}
		else {
			return self;
		}
	}

	
}
