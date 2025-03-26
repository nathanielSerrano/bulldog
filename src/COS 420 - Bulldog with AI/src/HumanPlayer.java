/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * HumanPlayer represents a human player.
 */
public class HumanPlayer extends Player {
    public HumanPlayer(String name) {
        super(name);
    }

    @Override
    public int play() {
        return 0; // GUI handles turns for HumanPlayer
    }
}
