package display;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainMenuTest {

	public void runAllTests() {
		testTests();
		testSingleton();
	}
	
	@Test
	void testTests() {
		MainMenu MMtest = null;
		assertEquals(MMtest, null);
	}
	
	@Test
	void testSingleton() {
		MainMenu MMtest = MainMenu.getInstance();
		MainMenu MMtest2 = MainMenu.getInstance();
//		Should be equal because singleton should return a pointer to the same LoginMenu
		assertEquals(MMtest, MMtest2);
	}
}
