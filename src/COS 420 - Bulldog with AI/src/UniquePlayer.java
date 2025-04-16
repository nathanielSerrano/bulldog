/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * UniquePlayer represents a unique player with a custom rolling strategy.
 */
public class UniquePlayer extends Player {
    private int rolls = 0;

    public UniquePlayer(String name) {
        super(name);
    }

    /**
     * Continue until roll count >= 3 and turn total > 10.
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        rolls++;
        boolean continueRolling = (rolls < 3 || status.getTurnTotal() <= 10) && (status.getTurnTotal()+status.getCurrentScore() < Prog6.WINNING_SCORE);
        if (!continueRolling) {
            rolls = 0; // reset for next turn
        }
        return continueRolling;
    }

}
