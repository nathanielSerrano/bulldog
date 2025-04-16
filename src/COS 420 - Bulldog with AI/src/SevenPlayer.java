/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 * 
 * SevenPlayer represents a player that rolls until reaching at least 7 points or rolling a 6.
 */
public class SevenPlayer extends Player {
    
    protected final FakeRandom dice = new FakeRandom(6);		// SevenPlayer uses a FakeRandom dice for testing purposes.
    private static final int TARGET_TURN_SCORE = 7;

    /**
     * Constructor - Creates a new SevenPlayer object
     * @param name A String that will serve as the player's name
     */
    public SevenPlayer(String name) {
        super(name);
    }
    
    /**
     * getDice() - Used to get FakeRandom dice object
     * (For JUnit testing purposes)
     * @return FakeRandom dice
     */
    public FakeRandom getDice() {
    	return dice;
    }
    

    
    /**
     * Decision logic for whether this player will continue the turn.
     * SevenPlayer stops once their turn total reaches 7 or more.
     * 
     * @param status snapshot of the current turn state
     * @return true to continue rolling, false to stop
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        return status.getTurnTotal() < TARGET_TURN_SCORE && (status.getTurnTotal()+status.getCurrentScore() < Prog6.WINNING_SCORE);
    }
}
