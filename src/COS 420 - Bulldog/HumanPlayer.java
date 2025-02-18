/**
 * @author Nathaniel Serrano
 * @version 17 February, 2025
 * COS 420, Spring 2025
 * Program 1
 * HumanPlayer class: extends Player class
 * 
 * A HumanPlayer will roll again depending on user input
 */
import java.util.Scanner;

public class HumanPlayer extends Player {
	
	/**
	 * Constructor - HumanPlayer
	 * Purpose: Create a default HumanPlayer
	 * Parameters:
	 * 	none
	 */
	public HumanPlayer() {
		this("Human");
	}
	
	/**
	 * Constructor - HumanPlayer
	 * Purpose: Create a new HumanPlayer object
	 * Parameters:
	 * 	String name: the name of the player being created
	 */
	public HumanPlayer(String name) {
		super(name);
	}

	/**
	 * Method - play
	 * Purpose: Take one turn for this player
	 * Parameters:
	 * 	none
	 * Returns:
	 * 	the score earned by the player on this turn,
	 * 		which will be zero if a six was rolled.
	 */
	@Override
	public int play() {
		int tempScore = 0;
		boolean activeTurn = true;
		Scanner s = new Scanner(System.in);
		while (activeTurn) {
			int roll = (int) (Math.random()*6 + 1);
			System.out.println("   Player " + getName() + " rolled " + roll );
			if (roll != 6) {
				tempScore+=roll;
				System.out.println("Current Round Score: "+tempScore);
				System.out.println("To roll again, type '1'.");
				int num = s.nextInt();
				if (num != 1) {
					System.out.println(getName()+" chose to end their turn.");
					return tempScore;
				} else {
					System.out.println(getName() + " chose to roll again.");
				}
			} else {
				System.out.println(" and scored 0 for the turn.");
				return 0;
			}
	
		}	
		return tempScore;
	}
	


	
}
