import java.util.ArrayList;

/**
 * PlayerList acts as the model in an MVC architecture.
 * It encapsulates a list of Player objects and provides
 * methods to manipulate and retrieve player data.
 * 
 * This class allows clients to:
 * - Add a Player
 * - Get a Player's name or score by index
 * - Set a Player's score by index
 * - Remove a Player by index
 * - Retrieve the total number of players
 * - Access the full Player object if needed
 * 
 * @author
 *     Nathaniel Serrano, ChatGPT AI
 * @version 2 March, 2025
 */
public class PlayerList {
    private final ArrayList<Player> players;

    /**
     * Constructor - Initializes the player list.
     */
    public PlayerList() {
        players = new ArrayList<>();
    }

    /**
     * Adds a player to the list.
     * @param player The player to add.
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * Removes the player at the specified index from the list.
     * @param index The index of the player to remove.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public void removePlayer(int index) {
        players.remove(index);
    }

    /**
     * Returns the name of the player at the given index.
     * @param index The index of the player.
     * @return The player's name.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public String getPlayerName(int index) {
        return players.get(index).getName();
    }

    /**
     * Returns the score of the player at the given index.
     * @param index The index of the player.
     * @return The player's score.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public int getPlayerScore(int index) {
        return players.get(index).getScore();
    }

    /**
     * Sets the score of the player at the given index.
     * @param index The index of the player.
     * @param score The new score to set.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public void setPlayerScore(int index, int score) {
        players.get(index).setScore(score);
    }

    /**
     * Returns the total number of players in the list.
     * @return The number of players.
     */
    public int size() {
        return players.size();
    }

    /**
     * Gets the Player object at a specific index.
     * @param index The index of the player.
     * @return The Player object.
     * @throws IndexOutOfBoundsException if index is invalid.
     */
    public Player getPlayer(int index) {
        return players.get(index);
    }

    /**
     * Clears all players from the list.
     */
    public void clear() {
        players.clear();
    }

    /**
     * Returns the list of all players.
     * Useful for iterating in a view or controller.
     * @return A copy of the list of players.
     */
    public ArrayList<Player> getAllPlayers() {
        return new ArrayList<>(players); // Defensive copy
    }
}
