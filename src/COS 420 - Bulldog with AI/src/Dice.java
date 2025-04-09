import java.util.*;

/**
 * Dice - The Dice class represents a dice with a specified number of sides.
 * All Dice share a single Random object to ensure consistency across randomness.
 * 
 * This is a partial Singleton design for the Random object only.
 * 
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 8 April, 2025
 */
public class Dice extends RandomDice {
    // Lazily instantiated Singleton Random instance (shared across all Dice)
    private static Random sharedRandom = null;

    /**
     * Constructor - Initializes a Dice object with a given number of sides.
     * @param sides The number of sides on the dice.
     */
    public Dice(int sides) {
        super(sides);
    }

    /**
     * Rolls the dice and returns a random number between 1 and the number of sides.
     * @return A randomly generated integer from 1 to the number of sides.
     */
    public int roll() {
        if (sharedRandom == null) {
            sharedRandom = new Random();
        }
        return sharedRandom.nextInt(sides) + 1;
    }
}
