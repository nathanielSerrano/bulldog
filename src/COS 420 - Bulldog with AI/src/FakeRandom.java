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
	private String seed = "163524651243";		// Default seed value
	
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
		if (str.matches("\\d+")) {
			seed = str;
		} else {
			System.out.println("Invalid seed inputted, set to default value.");
		}
	}
	
	public int roll() {
		char resultChar = seed.charAt(i);
	    int result = resultChar - '0';
	    if (i<seed.length()-1) {
	    	i++;
	    } else {
	    	i = 0;
	    }
		return result;
	}

}
