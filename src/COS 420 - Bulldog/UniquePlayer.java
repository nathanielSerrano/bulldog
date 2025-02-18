/**
 * @author Nathaniel Serrano
 * @version 17 February, 2025
 * COS 420, Spring 2025
 * Program 1
 * UniquePlayer class: extends Player class
 * 
 * A UniquePlayer will roll again if their previous roll was an odd number
 */
public class UniquePlayer extends Player {
	
	/**
	 * Constructor - UniquePlayer
	 * Purpose: Create a default UniquePlayer
	 * Parameters:
	 * 	none
	 */
	public UniquePlayer() {
		this("Unique");
	}
	
	/**
	 * Constructor - UniquePlayer
	 * Purpose: Create a new UniquePlayer object
	 * Parameters:
	 * 	String name: the name of the Player being created
	 */
	public UniquePlayer(String name) {
		super(name);
	}

	
	
	/**
	 * Method - play
	 * Purpose: Take one turn for this player
		   UniquePlayer thinks that odd numbers are lucky, so will only continue 
		   to roll when their previous roll was an odd number. Their total score 
		   has no affect on whether they roll or not.
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
		while (activeTurn) {
			int roll = (int) (Math.random()*6 + 1);
			System.out.println("   Player " + getName() + " rolled " + roll );
			if (roll != 6) {
				tempScore+=roll;
				System.out.println("Current Round Score: "+tempScore);
				if (roll%2==1) {
					System.out.println("  Previous roll was lucky, so Player " + getName() + " will roll again.");
				} else {
					System.out.println("  Previous roll was unlucky, so Player "+ getName() + " ends their turn.");
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