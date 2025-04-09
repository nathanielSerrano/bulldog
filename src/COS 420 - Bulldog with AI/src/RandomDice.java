/**
 * RandomDice - An abstract class that Dice.java and FakeRandom.java extend.
 * Describes a basic die object.
 * @author Nathaniel Serrano
 * @version 8 April, 2025
 *
 */
public abstract class RandomDice {

	protected final int sides;

    /**
     * Constructor - Initializes a RandomDice object with a given number of sides.
     * @param sides The number of sides on the die.
     */
	public RandomDice(int sides) {
		super();
		this.sides = sides;
	}
	
	abstract int roll();

}