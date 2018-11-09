package display;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoginMenuTest {

	public void runAllTests() {
		testTests();
		testSingleton();
	}
	
	@Test
	void testTests() {
		LoginMenu LMtest = null;
		assertEquals(LMtest, null);
	}
	
	@Test
	void testSingleton() {
		LoginMenu LMtest = LoginMenu.getInstance();
		LoginMenu LMtest2 = LoginMenu.getInstance();
//		Should be equal because singleton should return a pointer to the same LoginMenu
		assertEquals(LMtest, LMtest2);
	}


}
