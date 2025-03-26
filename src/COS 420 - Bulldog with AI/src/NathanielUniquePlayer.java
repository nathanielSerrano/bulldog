/**
 * @author Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 * COS 420, Spring 2025
 * Program 5
 * 
 * NathanielUniquePlayer Represents Nathaniel's unique playing strategy.
 * A NathanielUniquePlyaer will roll again if their previous roll was an odd number.
 */
public class NathanielUniquePlayer extends Player {
    public NathanielUniquePlayer(String name) {
        super(name);
    }

    public int play() {
        int tempScore = 0;
        boolean activeTurn = true;
        while (activeTurn) {
            int roll = dice.roll();
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
