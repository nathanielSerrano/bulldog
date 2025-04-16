/**
 * GameStatus encapsulates the current state of a player's turn in the Bulldog game.
 * This is used by players to decide whether to continue or end their turn.
 * 
 * It provides access to key turn-related data such as the current roll,
 * total accumulated points this turn, and the player's current score.
 * 
 * @author 
 *     Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 */
public class GameStatus {
    private final int rollValue;
    private final int turnTotal;
    private final int currentScore;

    /**
     * Constructor initializes the GameStatus snapshot.
     * @param rollValue The most recent dice roll.
     * @param turnTotal The cumulative score this turn.
     * @param currentScore The player's total score before this turn.
     */
    public GameStatus(int rollValue, int turnTotal, int currentScore) {
        this.rollValue = rollValue;
        this.turnTotal = turnTotal;
        this.currentScore = currentScore;
    }

    public int getRollValue() {
        return rollValue;
    }

    public int getTurnTotal() {
        return turnTotal;
    }

    public int getCurrentScore() {
        return currentScore;
    }
}
