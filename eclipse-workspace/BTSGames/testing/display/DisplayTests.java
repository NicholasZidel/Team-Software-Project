package display;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DisplayTests {

	GameMenuTest GMT = new GameMenuTest();
	LoginMenuTest LMT = new LoginMenuTest();
	MainMenuTest MMT = new MainMenuTest();
	StatisticsMenuTest SMT = new StatisticsMenuTest();
	
	@Test
	void TestAllDisplay() {
		GMT.runAllTests();
		LMT.runAllTests();
		MMT.runAllTests();
		SMT.runAllTests();
	}
	
}
