/********************************************************/
/* David Levine                                         */
/* Login ID: david.b.levine@maine.edu                   */
/* COS 497, Summer 2024                                 */
/* Programming Assignment 6                             */
/* abstract Player class: holds generic info about a    */
/*           player of the game Bulldog                 */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/
/* Updated by Nathaniel Serrano, ChatGPT 4o 			*/
/* @version 15 April, 2025 								*/

public abstract class Player {
	
	private String name;   	// The name of the Player
	
	private int score;		// The score earned by this Player during the game
	
    protected final Dice dice;	// Dice object for each Player

	
	/********************************************************/
	/* Constructor: Player                                  */
	/* Purpose: Create a new Player object                  */
	/* Parameters:                                          */
	/*   String name:  the name of the Player being created */
	/********************************************************/
	public Player (String name) {
		this.name = name;
		this.score = 0;
		this.dice = new RandomDice(6);		// Create new Dice object
	}
	
	/********************************************************/
	/* Method:  getName                                     */
	/* Purpose: return the name of this Player              */
	/* Parameters:                                          */
	/*   none                                               */
	/* Returns:                                             */
	/*   the name of this Player                            */
	/********************************************************/
	public String getName() {
		return this.name;
	}

	/********************************************************/
	/* Method:  getScore                                    */
	/* Purpose: return the current score of this Player     */
	/* Parameters:                                          */
	/*   none                                               */
	/* Returns:                                             */
	/*   the current score of this Player                   */
	/********************************************************/
	public int getScore() {
		return this.score;
	}
	
	/********************************************************/
	/* Method:  setScore                                    */
	/* Purpose: set the current score of this Player        */
	/* Parameters:                                          */
	/*   int score - the new value of the score             */
	/* Returns:                                             */
	/*   none                                               */
	/********************************************************/
	public void setScore(int score) {
		this.score = score;
	}
	
    /********************************************************/
    /* Method:  play                                        */
    /* Purpose: runs a complete turn for this Player        */
    /* Returns:                                             */
    /*   the score earned by the player on this turn,       */
    /*   which will be zero if a six was rolled             */
    /********************************************************/
    public int play() {
        int turnTotal = 0;

        while (true) {
            int roll = dice.roll();
            System.out.println(getName() + " rolled " + roll);

            if (roll == 6) {
                return 0; // rolling a 6 ends turn with zero points
            }

            turnTotal += roll;

            GameStatus status = new GameStatus(roll, turnTotal, score);

            if (!continueTurn(status)) {
                return turnTotal;
            }
        }
    }

    /********************************************************/
    /* Method:  continueTurn                                */
    /* Purpose: Abstract strategy decision on whether to    */
    /*          continue playing this turn or stop          */
    /* Parameters:                                          */
    /*   GameStatus status - snapshot of current turn info  */
    /* Returns:                                             */
    /*   true if player should roll again, false to stop    */
    /********************************************************/
    public abstract boolean continueTurn(GameStatus status);
	
}