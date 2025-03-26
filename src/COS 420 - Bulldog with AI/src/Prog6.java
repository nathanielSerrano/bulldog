/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 25 March, 2025
 * COS 420, Spring 2025
 * 
 * Prog6 is the program that runs the Bulldog Game.
 * This version uses PlayerList as the Model (MVC architecture).
 */

import java.util.Scanner;

public class Prog6 {
    private static final int WINNING_SCORE = 104;

    /**
     * Main method - Runs the Bulldog game.
     * It sets up the players and handles the game loop.
     * @param args Command-line arguments (unused).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PlayerList playerList = new PlayerList();  // ← Replaces ArrayList<Player>

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numPlayers; i++) {
            System.out.println("Choose player type for Player " + (i + 1) + ":");
            System.out.println("1. HumanPlayer\n2. RandomPlayer\n3. FifteenPlayer\n4. UniquePlayer\n5. WimpPlayer\n6. NathanielUniquePlayer");
            int choice = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter player name: ");
            String name = scanner.nextLine();

            switch (choice) {
                case 1 -> playerList.addPlayer(new HumanPlayer(name));
                case 2 -> playerList.addPlayer(new RandomPlayer(name));
                case 3 -> playerList.addPlayer(new FifteenPlayer(name));
                case 4 -> playerList.addPlayer(new UniquePlayer(name));
                case 5 -> playerList.addPlayer(new WimpPlayer(name));
                case 6 -> playerList.addPlayer(new NathanielUniquePlayer(name));
                default -> {
                    System.out.println("Invalid choice, defaulting to RandomPlayer.");
                    playerList.addPlayer(new RandomPlayer(name));
                }
            }
        }

        // Gameplay loop using PlayerList
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

        scanner.close();
    }
}
