package display;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GameMenuTest {

	public void runAllTests() {
		testTests();
		testSingleton();
	}
	
	@Test
	void testTests() {
		GameMenu GMtest = null;
		assertEquals(GMtest, null);
	}
	
	@Test
	void testSingleton() {
		GameMenu GMtest = GameMenu.getInstance();
		GameMenu GMtest2 = GameMenu.getInstance();
//		Should be equal because singleton should return a pointer to the same GameMenu
		assertEquals(GMtest, GMtest2);
	}

}
