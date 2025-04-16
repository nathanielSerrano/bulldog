/**
 * RandomPlayer randomly decides whether to continue or end their turn.
 * Uses a 2-sided die for randomness.
 * 
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 */
public class RandomPlayer extends Player {
    private final RandomDice coin;

    public RandomPlayer(String name) {
        super(name);
        this.coin = new RandomDice(2); // simulate coin flip
    }

    /**
     * Randomly returns true or false using a 2-sided die.
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        return coin.roll() == 1; // continue if result is 1
    }
}

