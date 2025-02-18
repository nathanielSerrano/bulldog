/**
 * @author Nathaniel Serrano
 * @version 17 February, 2025
 * COS 420, Spring 2025
 * Program 1
 * FifteenPlayer class: extends Player class
 * 
 * A FifteenPlayer will roll again if their current turn's score is less than 15
 */
public class FifteenPlayer extends Player {
	
	/**
	 * Constructor - FifteenPlayer
	 * Purpose: Create a default FifteenPlayer
	 * Parameters:
	 * 	none
	 */
	public FifteenPlayer() {
		this("Fifteen");
	}
	
	/**
	 * Constructor - FifteenPlayer
	 * Purpose: Create a new FifteenPlayer object
	 * Parameters:
	 * 	String name: the name of the Player being created
	 */
	public FifteenPlayer(String name) {
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
		int tempScore=0;
		boolean activeTurn = true;
		while (activeTurn) {
			int roll = (int) (Math.random()*6 + 1);
			System.out.println("   Player " + getName() + " rolled " + roll );
			if (roll != 6) {
				tempScore+=roll;
				System.out.println("Current Round Score: "+tempScore);
				if (tempScore < 15)	{
					System.out.println("Score is below 15, so Player " + getName() + " continues their turn.");
				} else {
					System.out.println("Score is at least 15, so Player " + getName() + " ends their turn. ");
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