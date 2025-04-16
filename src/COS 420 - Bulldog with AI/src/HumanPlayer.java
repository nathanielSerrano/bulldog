import java.util.Scanner;

/**
 * HumanPlayer supports both CLI-based and GUI-based interaction.
 * A flag determines whether input is requested from the console.
 * 
 * If useConsoleInput is true, it prompts the user via the terminal.
 * If false, it assumes the GUI will control the turn externally.
 * 
 * @author 
 *     Nathaniel Serrano, ChatGPT AI
 * @version 15 April, 2025
 */
public class HumanPlayer extends Player {
    private static final Scanner scanner = new Scanner(System.in);
    private final boolean useConsoleInput;

    /**
     * Constructor for HumanPlayer.
     * @param name Name of the player
     * @param useConsoleInput True for CLI interaction, false for GUI-based play
     */
    public HumanPlayer(String name, boolean useConsoleInput) {
        super(name);
        this.useConsoleInput = useConsoleInput;
    }

    /**
     * Decides whether to continue the turn based on CLI input or GUI mode.
     * @param status GameStatus snapshot
     * @return true to roll again, false to end turn
     */
    @Override
    public boolean continueTurn(GameStatus status) {
        if (!useConsoleInput) {
            return false; // GUI controls the turn, end here
        }

        System.out.println(getName() + ", you rolled a " + status.getRollValue() + ".");
        System.out.println("Turn total: " + status.getTurnTotal() + 
                           " | Projected score: " + (status.getCurrentScore() + status.getTurnTotal()));
        System.out.print("Do you want to roll again? (y/n): ");
        String input = scanner.nextLine().trim().toLowerCase();
        return input.equals("y") || input.equals("yes");
    }
}