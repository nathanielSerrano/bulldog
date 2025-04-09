/**
 * Referee - A singleton class responsible for running the Bulldog game.
 * Lazily instantiated to optimize memory usage and startup time.
 * 
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 8 April, 2025
 */
public class Referee {
    // The one and only instance (created on demand)
    private static Referee instance = null;

    /**
     * Private constructor to prevent external instantiation.
     */
    private Referee() {
        // Optional setup
    }

    /**
     * Provides access to the single Referee instance using lazy instantiation.
     * @return The singleton instance of Referee.
     */
    public static Referee getInstance() {
        if (instance == null) {
            instance = new Referee();
        }
        return instance;
    }

    /**
     * Runs the Bulldog game with the provided player list and winning score.
     * @param playerList The list of players.
     * @param WINNING_SCORE The score threshold to win.
     */
    public void playGame(PlayerList playerList, int WINNING_SCORE) {
        boolean gameOver = false;
        while (!gameOver) {
            for (int i = 0; i < playerList.size(); i++) {
                Player player = playerList.getPlayer(i);
                System.out.println("\n" + player.getName() + "'s turn:");
                int turnScore = player.play();
                int newScore = player.getScore() + turnScore;
                playerList.setPlayerScore(i, newScore);
                System.out.println("Total score for " + player.getName() + ": " + newScore);

                if (newScore >= WINNING_SCORE) {
                    System.out.println(player.getName() + " wins!");
                    gameOver = true;
                    break;
                }
            }
        }
    }
}
