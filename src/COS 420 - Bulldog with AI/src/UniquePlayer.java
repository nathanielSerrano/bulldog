/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * UniquePlayer represents a unique player with a custom rolling strategy.
 */
public class UniquePlayer extends Player {
    public UniquePlayer(String name) {
        super(name);
    }

    public int play() {
        int turnTotal = 0;
        int rolls = 0;
        while (true) {
            int roll = dice.roll();
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) return 0;
            turnTotal += roll;
            rolls++;
            if (turnTotal > 10 && rolls >= 3) return turnTotal;
        }
    }
}
