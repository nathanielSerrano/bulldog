/**
 * @author Nathaniel Serrano
 * @version 17 February, 2025
 * COS 420, Spring 2025
 * Program 1
 * 
 * prog6 is the program that runs the Bulldog Game.
 */
import java.util.*;

public class Prog6 {

	private static final int WINNING_SCORE = 104;

	/**
	 * Method - main
	 * Purpose: Runs Bulldog game. Creates a roster of players
	 * before beginning the game.
	 * Parameters:
	 * 	String[] args: unused in this program
	 * Returns: 
	 * 	none
	 * 
	 */
	public static void main(String[] args) {
		ArrayList<Player> players = new ArrayList<>();
		Scanner s = new Scanner(System.in);
		
		System.out.println("How many HumanPlayers?");
		int num = s.nextInt();
		addPlayers(players, "Human", num);
		System.out.println("How many WimpPlayers?");
		num = s.nextInt();
		addPlayers(players, "Wimp", num);
		System.out.println("How many RandomPlayers?");
		num = s.nextInt();
		addPlayers(players, "Random", num);
		System.out.println("How many FifteenPlayers?");
		num = s.nextInt();
		addPlayers(players, "Fifteen", num);
		System.out.println("How many UniquePlayers?");
		num = s.nextInt();
		addPlayers(players, "Unique", num);
		
		playGame(players);

		s.close();
	}

	/**
	 * Method - playGame
	 * Purpose: Run Bulldog game until a player's score is >= WINNING_SCORE
	 * Parameters:
	 * 	ArrayList<Player> players: Game roster
	 * Returns:
	 * 	none
	 */
	public static void playGame(ArrayList<Player> players) {
		boolean gameOver = false;
		List<Integer> scores = new ArrayList<>();
		while (!gameOver) {
			
			for (Player p: players) {
				p.setScore(p.getScore()+p.play());
			}
			checkScores(players, gameOver);

			/**
			 * Check gameOver condition here:
			 * End game when one player has at least WINNING_SCORE points
			 */
			for (int i=0; i<players.size(); i++) {
				scores.add(i, players.get(i).getScore());
			}
			
			for (int i=0; i<players.size(); i++) {
				if (scores.get(i) >= WINNING_SCORE) {
					System.out.println("Game Over!\n"+players.get(scores.indexOf(Collections.max(scores))).getName()+" wins with a score of "+players.get(i).getScore());
					gameOver=true;
				} 
			}
			if (!gameOver) {
				System.out.println("----BEGIN NEXT TURN----");
			}
		}
		checkScores(players, gameOver);
	}
	
	/**
	 * Method - checkScores
	 * Purpose: Print out the current scores of all players,
	 * 				typically at the end of a round.
	 * Parameters:
	 * 	ArrayList<Player> players: Roster of players currently playing
	 * 	boolean gameOver: Changes print statement depending on state of the game
	 * Returns:
	 * 	none
	 */
	private static void checkScores(ArrayList<Player> players, boolean gameOver) {
		if (!gameOver) {
			System.out.println("--Current Scores:");
		} else {
			System.out.println("--Final Scores:");
		}
		for (Player p: players) {
			System.out.println(p.getName()+": "+p.getScore());
		}
	}
	
	/**
	 * Method - addPlayers
	 * Purpose: Add players to the roster as requested by the user
	 * Parameters:
	 * 	ArrayList<Player> list: List that the roster is stored in
	 * 	String name: Determines the kind of Player (FifteenPlayer, WimpPlayer, etc.)
	 * 	int num: Determines how many of that type of player to add to the roster
	 * Returns:
	 * 	none
	 */
	public static void addPlayers(ArrayList<Player> list, String name, int num) {
		for (int i = 0; i < num; i++) {
			switch (name) {
			case "Human":
				list.add(new HumanPlayer("Human["+i+"]"));
				break;
			case "Wimp":
				list.add(new WimpPlayer("Wimp["+i+"]"));
				break;
			case "Random":
				list.add(new RandomPlayer("Random["+i+"]"));
				break;
			case "Fifteen":
				list.add(new FifteenPlayer("Fifteen["+i+"]"));
				break;
			case "Unique":
				list.add(new UniquePlayer("Unique["+i+"]"));
				break;
			default:
				break;
			}
		}
	}
}
