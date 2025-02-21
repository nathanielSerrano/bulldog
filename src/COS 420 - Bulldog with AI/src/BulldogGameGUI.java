/**
 * @authors - Nathaniel Serrano, ChatGPT 4o
 * @version - February 20, 2025
 * 
 * BulldogGameGUI represents the graphical user interface for the Bulldog game.
 * It manages the players, their turns, scores, and interactions with the game.
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class BulldogGameGUI {
    private static final int WINNING_SCORE = 104;
	private JFrame frame;
    private JButton rollButton, endTurnButton;
    private JPanel playerPanel;
    private ArrayList<Player> players;
    private HashMap<Player, JPanel> playerPanels;
    private HashMap<Player, JLabel> playerScoreLabels;
    private HashMap<Player, JTextArea> playerLogs;
    private int currentPlayerIndex;
    private int turnScore;
    private boolean gameOver;

    /**
     * Constructor initializes the game with an empty list of players.
     */
    public BulldogGameGUI() {
        players = new ArrayList<>();
        playerPanels = new HashMap<>();
        playerScoreLabels = new HashMap<>();
        playerLogs = new HashMap<>();
        setupPlayers();
        initializeGUI();
        startTurn();
    }
    
    /**
     * Constructor initializes the game with a given list of players.
     * @param players List of players participating in the game.
     */
    public BulldogGameGUI(ArrayList<Player> players) {
    	this.players = players;
        playerPanels = new HashMap<>();
        playerScoreLabels = new HashMap<>();
        playerLogs = new HashMap<>();
        setupPlayers();
        initializeGUI();
        startTurn();
    }
    
    /**
     * Starts the turn for the current player. If the player is not human, plays automatically.
     */
    private void startTurn() {
        if (gameOver) return;
        Player player = players.get(currentPlayerIndex);
        turnScore = 0;
        updatePlayerBorders();
        updatePlayerScores();

        if (!(player instanceof HumanPlayer)) {
            int score = player.play();
            logToPlayerColumn(player, player.getName() + " played and scored " + score + " this turn.");
            turnScore = score;
            endTurn();
        }
    }
    
    /**
     * Updates the visual borders of player panels to highlight the current player's turn.
     */
    private void updatePlayerBorders() {
        for (Player player : players) {
            JPanel panel = playerPanels.get(player);
            if (panel != null) {
                if (player == players.get(currentPlayerIndex) && player instanceof HumanPlayer) {
                    panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
                } else {
                    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                }
            }
        }
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    /**
     * Initializes the list of players and game variables.
     */
    private void setupPlayers() {
        currentPlayerIndex = 0;
        turnScore = 0;
        gameOver = false;
    }

    /**
     * Initializes the graphical user interface components.
     */
    private void initializeGUI() {
        frame = new JFrame("Bulldog Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        playerPanel = new JPanel();
        playerPanel.setLayout(new GridLayout(1, Math.min(players.size(), 5)));
        frame.add(new JScrollPane(playerPanel), BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        rollButton = new JButton("Roll Dice");
        endTurnButton = new JButton("End Turn");

        rollButton.addActionListener(e -> rollDice());
        endTurnButton.addActionListener(e -> endTurn());

        controlPanel.add(rollButton);
        controlPanel.add(endTurnButton);
        frame.add(controlPanel, BorderLayout.NORTH);

        initializePlayerPanels();
        frame.setVisible(true);
    }

    /*
     * Initializes components of game screen.
     */
    private void initializePlayerPanels() {
        playerPanel.removeAll();
        playerPanels.clear();
        playerScoreLabels.clear();
        
        for (Player player : players) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
            JLabel nameLabel = new JLabel(player.getName());
            JLabel scoreLabel = new JLabel("Score: " + player.getScore());
            JTextArea playerLog = new JTextArea(5, 15);
            playerLog.setEditable(false);
            playerLog.setLineWrap(true);
            playerLog.setWrapStyleWord(true);
            JScrollPane logScrollPane = new JScrollPane(playerLog);
            logScrollPane.setPreferredSize(new Dimension(150, 80));
            
            panel.add(nameLabel);
            panel.add(scoreLabel);
            panel.add(logScrollPane);
            
            if (player == players.get(currentPlayerIndex) && player instanceof HumanPlayer) {
                panel.setBorder(BorderFactory.createLineBorder(Color.BLUE, 3));
            } else {
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
            }
            
            playerPanels.put(player, panel);
            playerScoreLabels.put(player, scoreLabel);
            playerLogs.put(player, playerLog);
            playerPanel.add(panel);
        }
        playerPanel.revalidate();
        playerPanel.repaint();
    }

    /**
     * Updates the UI components of the players' scores.
     */
    private void updatePlayerScores() {
        for (Player player : players) {
            playerScoreLabels.get(player).setText("Score: " + player.getScore());
        }
    }

    /**
     * Rolls the dice for the current player and updates the turn score.
     */
    private void rollDice() {
        int roll = (int) (Math.random() * 6 + 1);
        Player player = players.get(currentPlayerIndex);
        logToPlayerColumn(player, player.getName() + " rolled " + roll);

        if (roll == 6) {
            logToPlayerColumn(player, player.getName() + " lost their turn!");
            turnScore = 0;
            endTurn();
            return;
        }
        turnScore += roll;
        logToPlayerColumn(player, "Current turn score: " + turnScore);
        updatePlayerScores();
    }

    /**
     * Ends the current player's turn and checks for a winner.
     */
    private void endTurn() {
        Player player = players.get(currentPlayerIndex);
        player.setScore(player.getScore() + turnScore);
        logToPlayerColumn(player, player.getName() + " ends turn with " + player.getScore() + " total points.");
        updatePlayerScores();

        if (player.getScore() >= WINNING_SCORE) {
            logToPlayerColumn(player, player.getName() + " wins the game!");
            gameOver = true;
            rollButton.setEnabled(false);
            endTurnButton.setEnabled(false);
            showWinnerPopup(player);
            return;
        }

        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        startTurn();
    }

    /**
     * Displays a popup announcing the winner of the game.
     * @param winner The player who won the game.
     */
    private void showWinnerPopup(Player winner) {
        frame.setEnabled(false);
        JFrame popup = new JFrame("Game Over");
        popup.setSize(500, 150);
        popup.setLayout(new BorderLayout());
        
        JLabel message = new JLabel(winner.getName() + " wins with " + winner.getScore() + " points!", SwingConstants.CENTER);
        popup.add(message, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        JButton newGameButton = new JButton("New Game");
        JButton quitButton = new JButton("Quit");
        JButton againButton = new JButton("Play Again");
        
        newGameButton.addActionListener(e -> {
            popup.dispose();
            frame.dispose();
            new PlayerSetupScreen();
        });
        
        quitButton.addActionListener(e -> System.exit(0));
        
        againButton.addActionListener(e -> {
        	popup.dispose();
        	frame.dispose();
        	for (Player p: players) {
        		p.setScore(0);
        	}
        	new BulldogGameGUI(players);
        });
        
        buttonPanel.add(newGameButton);
        buttonPanel.add(againButton);
        buttonPanel.add(quitButton);
        popup.add(buttonPanel, BorderLayout.SOUTH);
        
        popup.setLocationRelativeTo(frame);
        popup.setVisible(true);
    }

    /**
     * Logs messages to the player's column in the UI.
     * @param player The player whose log is updated.
     * @param message The message to display.
     */
    private void logToPlayerColumn(Player player, String message) {
        JTextArea playerLog = playerLogs.get(player);
        if (playerLog != null) {
            playerLog.append(message + "\n");
            playerLog.setCaretPosition(playerLog.getDocument().getLength());
        }
    }

    /**
     * The main entry point for the game, initializes the player setup screen.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(PlayerSetupScreen::new);
    }
}


/**
 * The PlayerSetupScreen class provides a graphical interface for setting up players before starting the game.
 */
class PlayerSetupScreen {
    private JFrame setupFrame;
    private DefaultTableModel tableModel;
    private JTable playerTable;
    private ArrayList<Player> players;
    
    /**
     * Constructor initializes the setup screen UI.
     */
    public PlayerSetupScreen() {
        players = new ArrayList<>();
        setupFrame = new JFrame("Bulldog - Player Setup");
        setupFrame.setSize(600, 400);
        setupFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setupFrame.setLayout(new BorderLayout());
        
        JLabel titleLabel = new JLabel("Bulldog", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        setupFrame.add(titleLabel, BorderLayout.NORTH);
        
        String[] columnNames = {"Name", "Type"};
        tableModel = new DefaultTableModel(columnNames, 0);
        playerTable = new JTable(tableModel);
        playerTable.setRowHeight(30);
        
        JComboBox<String> typeDropdown = new JComboBox<>(new String[]{"HumanPlayer", "RandomPlayer", "FifteenPlayer", "UniquePlayer", "WimpPlayer"});
        typeDropdown.setBorder(BorderFactory.createEtchedBorder());
        typeDropdown.setBackground(Color.LIGHT_GRAY);
        typeDropdown.setFocusable(false);
        
        playerTable.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(typeDropdown));
        playerTable.getColumnModel().getColumn(1).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                JComboBox<String> comboBox = new JComboBox<>(new String[]{"HumanPlayer", "RandomPlayer", "FifteenPlayer", "UniquePlayer", "WimpPlayer"});
                comboBox.setSelectedItem(value);
                comboBox.setBorder(BorderFactory.createEtchedBorder());
                comboBox.setBackground(Color.LIGHT_GRAY);
                return comboBox;
            }
        });
        
        setupFrame.add(new JScrollPane(playerTable), BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        
        JButton addPlayerButton = new JButton("Add Player");
        JButton removePlayerButton = new JButton("Remove Player");
        JButton resetButton = new JButton("Reset");
        JButton startGameButton = new JButton("Start Game");
        
        addPlayerButton.addActionListener(e -> promptPlayerName());
        removePlayerButton.addActionListener(e -> removePlayer());
        resetButton.addActionListener(e -> resetPlayers());
        startGameButton.addActionListener(e -> startGame());
        
        buttonPanel.add(addPlayerButton);
        buttonPanel.add(removePlayerButton);
        buttonPanel.add(resetButton);
        buttonPanel.add(startGameButton);
        
        setupFrame.add(buttonPanel, BorderLayout.EAST);
        setupFrame.setVisible(true);
    }

    /**
     * Prompts the user to enter a player name via a dialog box.
     */
    private void promptPlayerName() {
        String name = JOptionPane.showInputDialog(setupFrame, "Enter player name:", "New Player", JOptionPane.PLAIN_MESSAGE);
        if (name != null && !name.trim().isEmpty()) {
            addPlayer(name);
        }
    }

    /**
     * Adds a new player to the table.
     * @param name Name of the player to add.
     */
    private void addPlayer(String name) {
        tableModel.addRow(new Object[]{name, "HumanPlayer"});
    }

    /**
     * Removes the selected player from the table.
     */
    private void removePlayer() {
        int index = playerTable.getSelectedRow();
        if (index != -1) {
            tableModel.removeRow(index);
        }
    }

    /**
     * Resets the player table by removing all players.
     */
    private void resetPlayers() {
        tableModel.setRowCount(0);
    }

    /**
     * Starts the game with the players currently in the table.
     * A game needs at least 2 players to begin.
     */
    private void startGame() {
        if (tableModel.getRowCount() < 2) {
            JOptionPane.showMessageDialog(setupFrame, "At least 2 players are required to start the game.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        ArrayList<Player> gamePlayers = new ArrayList<>();
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String name = (String) tableModel.getValueAt(i, 0);
            String type = (String) tableModel.getValueAt(i, 1);
            switch (type) {
                case "HumanPlayer" -> gamePlayers.add(new HumanPlayer(name));
                case "RandomPlayer" -> gamePlayers.add(new RandomPlayer(name));
                case "FifteenPlayer" -> gamePlayers.add(new FifteenPlayer(name));
                case "UniquePlayer" -> gamePlayers.add(new UniquePlayer(name));
                case "WimpPlayer" -> gamePlayers.add(new WimpPlayer(name));
                default -> gamePlayers.add(new RandomPlayer(name));
            }
        }
        setupFrame.dispose();
        new BulldogGameGUI(gamePlayers);
    }
}