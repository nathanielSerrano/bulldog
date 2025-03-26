/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * The Dice class represents a dice with a specified number of sides.
 * It generates random rolls using a static random number generator.
 */
import java.util.*;

public class Dice {
    private static final Random random = new Random();
    private final int sides;

    /**
     * Constructor - Initializes a Dice object with a given number of sides.
     * @param sides The number of sides on the dice.
     */
    public Dice(int sides) {
        this.sides = sides;
    }

    /**
     * Rolls the dice and returns a random number between 1 and the number of sides.
     * @return A randomly generated integer from 1 to the number of sides.
     */
    public int roll() {
        return random.nextInt(sides) + 1;
    }
}
