/**
 * FifteenPlayer rolls until they reach a turn total of at least 15,
 * unless they roll a 6, in which case they lose the turn.
 * This class overrides the continueTurn strategy.
 * 
 * Now uses the common Player.play() method from the superclass.
 * Only decision logic is implemented here.
 * 
 * @author 
 *     Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 */
public class FifteenPlayer extends Player {
    private static final int TARGET_TURN_SCORE = 15;


    public FifteenPlayer(String name) {
        super(name);
    }

    /**
     * Decision logic for whether this player will continue the turn.
     * FifteenPlayer stops once their turn total reaches 15 or more.
     * 
     * @param status snapshot of the current turn state
     * @return true to continue rolling, false to stop
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        return status.getTurnTotal() < TARGET_TURN_SCORE && (status.getTurnTotal()+status.getCurrentScore() < Prog6.WINNING_SCORE);
    }
}
