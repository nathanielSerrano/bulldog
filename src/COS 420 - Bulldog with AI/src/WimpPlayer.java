public class WimpPlayer extends Player {

	/********************************************************/
	/* Constructor: WimpPlayer                              */
	/* Purpose: Create a default WimpPlayer                 */
	/* Parameters:                                          */
	/*   none                                               */
	/********************************************************/
	public WimpPlayer () {
		this("Wimp");
	}

	/********************************************************/
	/* Constructor: WimpPlayer                              */
	/* Purpose: Create a new WimpPlayer object              */
	/* Parameters:                                          */
	/*   String name:  the name of the Player being created */
	/********************************************************/
	public WimpPlayer (String name) {
		super(name);
	}

	/********************************************************/
	/* Method: continueTurn()                               */
	/* Purpose: WimpPlayer never continues their turn       */
	/* Parameters:                                          */
	/*   GameStatus status:  current status of game         */
	/********************************************************/
    @Override
    public boolean continueTurn(GameStatus status) {
        return false;
    
	}

}