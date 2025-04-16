/**
 * FakeRandom - Extends RandomDice and acts similar to a Dice object but does not
 * actually use any form of randomness. The results are scripted according to 
 * a String attribute.
 * @author Nathaniel Serrano
 * @version 8 April, 2025
 *
 */
public class FakeRandom extends RandomDice {
	
	private int i = 0;
	private String seed = "1 6 3 5 2 4 6 5 1 2 4 3";		// Default seed value
	
    /**
     * Constructor - Initializes a FakeRandom object with a given number of sides.
     * @param sides The number of sides on the die.
     */
	public FakeRandom(int sides) {
		super(sides);
	}
	
	/**
	 * Constructor - Allows user to specify "random" numbers that will be returned
	 * upon calling roll().
	 * @param sides The number of sides on the die.
	 * @param str A String consisting of only numbers that will become the new seed value.
	 */
	public FakeRandom(int sides, String str) {
		super(sides);
		setSeed(str);
		
	}
	
	public int getSides() {
		return sides;
	}
	
	public String getSeed() {
		return seed;
	}
	
	public void setSeed(String str) {
		for (String n: str.split(" ")) {
			if (!n.matches("\\d+")) {
				System.out.println("Invalid seed inputted, set to default value.");
				break;
			} else {
				seed = str;
			}
		}
	}
	
	public int roll() {
		String[] nums = seed.split(" ");
		String resultChar = nums[i];
		int result = Integer.parseInt(resultChar);
	    if (i<nums.length-1) {
	    	i++;
	    } else {
	    	i = 0;
	    }
		return result;
	}

}
