/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 8 April, 2025
 * 
 * SevenPlayer represents a player that rolls until reaching at least 7 points or rolling a 6.
 */
public class SevenPlayer extends Player {
    private static final int WINNING_SCORE = 104;
    
    protected final FakeRandom dice = new FakeRandom(6);		// SevenPlayer uses a FakeRandom dice for testing purposes.
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
    

    
    
    public int play() {
        int tempScore = 0;
        while (tempScore < 7) {
            int roll = dice.roll();
            if (roll == 6) return 0;
            tempScore += roll;
            if (tempScore >= WINNING_SCORE) return tempScore;
        }
        return tempScore;
    }
}
