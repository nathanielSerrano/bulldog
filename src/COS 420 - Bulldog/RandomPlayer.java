/**
 * @author Nathaniel Serrano
 * @version 17 February, 2025
 * COS 420, Spring 2025
 * Program 1
 * RandomPlayer class: extends Player class
 * 
 * A RandomPlayer has a 50% chance of choosing to roll again or ending its turn.
 */
public class RandomPlayer extends Player {
	
	/**
	 * Constructor - RandomPlayer
	 * Purpose: Create a default RandomPlayer
	 * Parameters:
	 * 	none
	 */
	public RandomPlayer() {
		this("Random");
	}
	
	/**
	 * Constructor - RandomPlayer
	 * Purpose: Create a new RandomPlayer object
	 * Parameters:
	 * 	String name: the name of the Player being created
	 */
	public RandomPlayer(String name) {
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
	public int play() {
		int tempScore=0;
		boolean activeTurn = true;
		while (activeTurn) {
			int roll = (int) (Math.random()*6 + 1);
			System.out.println("   Player " + getName() + " rolled " + roll );
			if (roll != 6) {
				tempScore+=roll;
				System.out.println("Current Round Score: "+tempScore);
				if (Math.random()>0.5) {
					System.out.println(getName()+" randomly chose to roll again.");
				} else {
					System.out.println(getName()+" randomly chose to end their turn, scoring "+ tempScore + " for the turn.");
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