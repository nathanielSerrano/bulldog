import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Viewer class represents the Scoreboard.
 * It observes a PlayerList (model) and displays names/scores.
 * Updating the model should update this view.
 * 
 * Note: This version simply reads from the model when told to refresh.
 * For a reactive design, consider adding a listener system later.
 */
public class Viewer extends JPanel {
    private final PlayerList model;
    private final ArrayList<JLabel> labels;

    /**
     * Constructs a Viewer (scoreboard) from a PlayerList model.
     * @param model the PlayerList containing players and scores
     */
    public Viewer(PlayerList model) {
        this.model = model;
        this.labels = new ArrayList<>();
        setLayout(new GridLayout(0, 1));
        refresh();
    }

    /**
     * Refreshes the labels on the panel based on the current model state.
     */
    public void refresh() {
        this.removeAll();
        labels.clear();

        for (int i = 0; i < model.size(); i++) {
            String display = model.getPlayerName(i) + ": " + model.getPlayerScore(i);
            JLabel label = new JLabel(display);
            labels.add(label);
            this.add(label);
        }

        revalidate();
        repaint();
    }
   
   /* Viewer Demo
    * Demonstrates use of Viewer with PlayerList model.
    * Populates a roster, displays the scoreboard, and updates a score after a pause.
    */
   public static void main(String[] args) {
       // Create model and populate with Players
       PlayerList playerList = new PlayerList();
       playerList.addPlayer(new RandomPlayer("Alice"));
       playerList.addPlayer(new FifteenPlayer("Bob"));
       playerList.addPlayer(new UniquePlayer("Charlie"));

       // Set initial scores for testing
       playerList.setPlayerScore(0, 10);
       playerList.setPlayerScore(1, 15);
       playerList.setPlayerScore(2, 20);

       // Create JFrame window and attach Viewer
       JFrame frame = new JFrame("Scoreboard Viewer");
       Viewer viewer = new Viewer(playerList);
       frame.add(viewer);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setSize(300, 200);
       frame.setVisible(true);

       // Pause with JOptionPane
       JOptionPane.showMessageDialog(frame, "Click OK to update Charlie's score...");

       // Change the model (score)
       playerList.setPlayerScore(2, 42);

       // Refresh the viewer manually
       viewer.refresh();
   }
}
