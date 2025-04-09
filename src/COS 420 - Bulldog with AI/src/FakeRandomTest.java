import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * FakeRandomTest - A Test suite meant to utilize FakeRandom.java to test SevenPlayer.java
 * @author Nathaniel Serrano
 * @version 9 April, 2025
 *
 */
class FakeRandomTest {


	// Basic test that shows the play() method returns 
	// the score for that turn.
	@Test
	void testSevenPlayer() {
		SevenPlayer test = new SevenPlayer("test");
		test.getDice().setSeed("1234");
		assertEquals(0,test.getScore());
		assertEquals(10,test.play());
	}
	
	// Test that a SevenPlayer will stop once it reaches a score of 7.
	@Test 
	void testSevenLimit() {
		SevenPlayer test = new SevenPlayer("test");
		test.getDice().setSeed("1111111111");		// 10 1's in a String
		assertEquals(7, test.play());
				
	}
	
	// At a score of 6, SevenPlayer should roll again
	// Note: FakeRandom will repeat the seed once it reaches the end
	@Test
	void test6Score() {
		SevenPlayer test = new SevenPlayer("test");
		test.getDice().setSeed("222");
		int score = test.play();
		assertEquals(8, score);
		assertNotEquals(0, score);
	}
	
	// Test SevenPlayer's max score per turn of 11
	// Should stop once it reaches 11 and not roll the 6 in the seed.
	@Test 
	void testMaxScore() {
		SevenPlayer test = new SevenPlayer("test");
		test.getDice().setSeed("4256");
		int score = test.play();
		assertEquals(11, score);
		assertNotEquals(0, score);
	}
	
	// Test that a SevenPlayer's turn score is set to 0 upon rolling a 6
	@Test
	void testRoll6() {
		SevenPlayer test = new SevenPlayer("test");
		test.getDice().setSeed("1236");
		int score = test.play();
		assertEquals(0, score);
		assertNotEquals(12, score);
	}
	
	
	
	
	/**
	 * 	 Some tests specifically for FakeRandom.java
	 * 	 Not required for assignment but show FakeRandom works
	 */

	// Test that the custom constructor changes the FakeRandom object's seed value and sets the number of sides.
	@Test
	void testFakeRandomConstruction() {
		FakeRandom test = new FakeRandom(6, "238123");
		assertEquals(6,test.getSides());
		assertEquals("238123", test.getSeed());
		assertNotEquals("163524651243", test.getSeed());
	}
	/**
	 *  Test a seed that has fewer numbers then the number of times roll() is called.
	 */
	@Test
	void testSmallSeed() {
		RandomDice die = new FakeRandom(6, "1");
		String str="";
		for (int i=0;i<3;i++) {
			str+= die.roll();
		}
		assertEquals("111", str, "Error in inputted seed");
	}
	
	/** 
	 * Test that two different FakeRandom objects with the same seed value function without 
	 * affecting each other.
	 */
	@Test
	void testMultipleSameSeed() {
		RandomDice die1 = new FakeRandom(6, "1423");
		RandomDice die2 = new FakeRandom(6, "1423");
		
		die1.roll();
		int secondRoll1=die1.roll();
		assertEquals(4,secondRoll1);
		assertEquals(1,die2.roll());
		
		die2.roll();
		int thirdRoll2=die2.roll();
		assertEquals(4,secondRoll1);
		assertEquals(2, thirdRoll2);
		
		assertEquals(2, die1.roll());
	}
	


}
