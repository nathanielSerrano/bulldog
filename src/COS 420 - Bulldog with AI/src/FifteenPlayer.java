/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * FifteenPlayer represents a player that rolls until reaching 15 points or rolling a 6.
 */
public class FifteenPlayer extends Player {
    private static final int WINNING_SCORE = 104;
    
    public FifteenPlayer(String name) {
        super(name);
    }

    public int play() {
        int tempScore = 0;
        while (tempScore < 15) {
            int roll = dice.roll();
            if (roll == 6) return 0;
            tempScore += roll;
            if (tempScore >= WINNING_SCORE) return tempScore;
        }
        return tempScore;
    }
}
