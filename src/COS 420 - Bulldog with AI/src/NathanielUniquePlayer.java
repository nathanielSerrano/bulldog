/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 * COS 420, Spring 2025
 * 
 * NathanielUniquePlayer Represents Nathaniel's unique playing strategy.
 * A NathanielUniquePlyaer will roll again if their previous roll was an odd number.
 */
public class NathanielUniquePlayer extends Player {
    public NathanielUniquePlayer(String name) {
        super(name);
    }

    /**
     * NathanielUniquePlayer rolls again if the previous roll was odd.
     * Ends turn otherwise.
     * @param status snapshot of current turn state
     * @return true if roll was odd, false if even
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        return status.getRollValue() % 2 == 1 && (status.getCurrentScore() + status.getTurnTotal() < Prog6.WINNING_SCORE);
    }
}
