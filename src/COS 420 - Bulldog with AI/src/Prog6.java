import java.util.*;

public class Prog6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<>();

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
                case 1 -> players.add(new HumanPlayer(name, scanner));
                case 2 -> players.add(new RandomPlayer(name));
                case 3 -> players.add(new FifteenPlayer(name));
                case 4 -> players.add(new UniquePlayer(name));
                case 5 -> players.add(new WimpPlayer(name));
                case 6 -> players.add(new NathanielUniquePlayer(name));
                default -> {
                    System.out.println("Invalid choice, defaulting to RandomPlayer.");
                    players.add(new RandomPlayer(name));
                }
            }
        }

        boolean gameOver = false;
        while (!gameOver) {
            for (Player player : players) {
                System.out.println("\n" + player.getName() + "'s turn:");
                int turnScore = player.play();
                player.setScore(player.getScore() + turnScore);
                System.out.println("Total score for " + player.getName() + ": " + player.getScore());
                if (player.getScore() >= 104) {
                    System.out.println(player.getName() + " wins!");
                    gameOver = true;
                    break;
                }
            }
        }
        scanner.close();
    }
}

class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    public int play() {
        int turnTotal = 0;
        while (true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) {
                System.out.println(getName() + " loses turn.");
                return 0;
            }
            turnTotal += roll;
            System.out.print("Continue rolling? (y/n): ");
            if (!scanner.nextLine().equalsIgnoreCase("y")) {
                return turnTotal;
            }
        }
    }
}

class RandomPlayer extends Player {
    public RandomPlayer(String name) {
        super(name);
    }

    public int play() {
        int turnTotal = 0;
        Random random = new Random();
        while (true) {
            int roll = random.nextInt(6) + 1;
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) return 0;
            turnTotal += roll;
            if (random.nextBoolean()) return turnTotal;
        }
    }
}

class FifteenPlayer extends Player {
    public FifteenPlayer(String name) {
        super(name);
    }

    public int play() {
        int turnTotal = 0;
        while (turnTotal < 15) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) return 0;
            turnTotal += roll;
        }
        return turnTotal;
    }
}

class UniquePlayer extends Player {
    /**
     * The UniquePlayer class follows a custom strategy:
     * - It rolls the die continuously unless a 6 is rolled, which ends the turn with a score of 0.
     * - The player keeps rolling while accumulating points.
     * - The turn automatically stops if the player has rolled at least 3 times AND has accumulated more than 10 points.
     * - This balances risk and reward, ensuring a moderate level of aggression.
     */
    public UniquePlayer(String name) {
        super(name);
    }

    public int play() {
        int turnTotal = 0;
        int rolls = 0;
        while (true) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println(getName() + " rolled " + roll);
            if (roll == 6) return 0;
            turnTotal += roll;
            rolls++;
            if (turnTotal > 10 && rolls >= 3) return turnTotal;
        }
    }
}

class NathanielUniquePlayer extends Player {
    /**
     * @author Nathaniel Serrano
     * NathanielUniquePlayer follows a custom strategy:
     * - Continues rolling only if the previous roll was an odd number.
     * - If a 6 is rolled, the turn ends with 0 points.
     * - The accumulated score does not influence whether the player rolls again.
     */
    public NathanielUniquePlayer(String name) {
        super(name);
    }

    public int play() {
        int tempScore = 0;
        boolean activeTurn = true;
        while (activeTurn) {
            int roll = (int) (Math.random() * 6 + 1);
            System.out.println("   Player " + getName() + " rolled " + roll);
            if (roll != 6) {
                tempScore += roll;
                System.out.println("Current Round Score: " + tempScore);
                if (roll % 2 == 1) {
                    System.out.println("  Previous roll was lucky, so Player " + getName() + " will roll again.");
                } else {
                    System.out.println("  Previous roll was unlucky, so Player " + getName() + " ends their turn.");
                    return tempScore;
                }
            } else {
                System.out.println(" and scored 0 for the turn.");
                return 0;
            }
        }
        return tempScore;
    }
}

