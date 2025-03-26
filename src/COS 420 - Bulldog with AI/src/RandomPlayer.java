/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * RandomPlayer represents a player that makes random decisions when playing.
 */
public class RandomPlayer extends Player {
	
	private Dice randomPlayerDice = new Dice(2);
	
    public RandomPlayer(String name) {
        super(name);
    }

    public int play() {
        int turnTotal = 0;
        while (true) {
            int roll = dice.roll();
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) return 0;
            turnTotal += roll;
            if (randomPlayerDice.roll()==2) return turnTotal;
        }
    }
}
