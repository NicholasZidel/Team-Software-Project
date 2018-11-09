package display;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatisticsMenuTest {

	public void runAllTests() {
		testTests();
		testSingleton();
	}
	
	@Test
	void testTests() {
		StatisticsMenu SMtest = null;
		assertEquals(SMtest, null);
	}
	
	@Test
	void testSingleton() {
		StatisticsMenu SMtest = StatisticsMenu.getInstance();
		StatisticsMenu SMtest2 = StatisticsMenu.getInstance();
//		Should be equal because singleton should return a pointer to the same LoginMenu
		assertEquals(SMtest, SMtest2);
	}

}
