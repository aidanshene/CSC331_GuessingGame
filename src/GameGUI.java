import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class GameGUI extends JFrame {
	private static final long serialVersionUID = 70625052682885262L;
	
	public JPanel display;
	public DefaultListModel<String> guesses;
	public DefaultListModel<String> clues;
	public JTextField textGuess;
	
	public OtherGame currentGame;
	public Player currentPlayer;
	public ArrayList<Player> playerList;
	
	public GameGUI(String title) {
		super(title);
		setSize(500, 500);
		setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		playerList = new ArrayList<Player>();
		JTextField name = new JTextField();
		String[] levels = {"Level 1", "Level 2", "Level 3", "Level 4", "Level 5"};
		JComboBox<String> lvl = new JComboBox<String>(levels);
		Object[] fields = {"Player Name:", name, "Level:", lvl};

		int dialogResult = JOptionPane.showConfirmDialog(null, fields, "Enter name & select difficulty", JOptionPane.OK_CANCEL_OPTION); // Prompts user for a player name before starting the game.
		if(dialogResult == JOptionPane.CANCEL_OPTION)
			System.exit(0);
		else {
			currentPlayer = new Player(name.getText());
			currentGame = new OtherGame((int)lvl.getSelectedItem().toString().charAt(6));
			currentPlayer.addOtherGame(currentGame);
			createDisplay();
			setVisible(true);
		}
	}
	
	public class lvlTwoListener implements ActionListener { // Action listener for New Game -> Level 2
		public void actionPerformed(ActionEvent ae) {
			currentGame = new OtherGame(2);
			currentPlayer.addOtherGame(currentGame);
			guesses.clear();
			clues.clear(); }}
	
	public class lvlThreeListener implements ActionListener { // Action listener for New Game -> Level 3
		public void actionPerformed(ActionEvent ae) {
			currentGame = new OtherGame(3);
			currentPlayer.addOtherGame(currentGame);
			guesses.clear();
			clues.clear(); }}
	
	public class lvlFourListener implements ActionListener { // Action listener for New Game -> Level 4
		public void actionPerformed(ActionEvent ae) {
			currentGame = new OtherGame(4);
			currentPlayer.addOtherGame(currentGame);
			guesses.clear();
			clues.clear(); }}
	
	public class lvlFiveListener implements ActionListener { // Action listener for New Game -> Level 5
		public void actionPerformed(ActionEvent ae) {
			currentGame = new OtherGame(5);
			currentPlayer.addOtherGame(currentGame);
			guesses.clear();
			clues.clear(); }}
	
	public class newPlayerListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			playerList.add(currentPlayer);
			String newUser = JOptionPane.showInputDialog("Please enter your name: ");
			Player newPlayer = new Player(newUser);
			currentPlayer = newPlayer;
		}
	}
	
	public class EnterListener implements ActionListener { // Action listener for the Enter button.
		public void actionPerformed(ActionEvent ae) {
			String guess = textGuess.getText();
			String result = currentGame.checkValue(guess);
			String clue = currentGame.clue;
			guesses.addElement(guess);
			clues.addElement(clue);
			
			
			if (currentGame.gameOver()) {
				String endMessage = "You win! You took ";
				String guessesMessage = currentGame.guesses + " guesses.";
				
				if (currentPlayer.levelsList.contains(currentGame.lvl)) {
					int gameLvl = currentGame.lvl;
					currentPlayer.levelsList.get(gameLvl).addStats(currentGame.guesses);
				}
				else{
					Levels lvl = new Levels(currentGame.lvl);
					lvl.addStats(currentGame.guesses);
					currentPlayer.levelsList.add(lvl);	
				}
				
				JOptionPane.showMessageDialog(null, endMessage + guessesMessage);
				
//				currentPlayer.addOtherGame(currentGame);
			}
			
		}
	}
	
	public void createDisplay() {
		
		JMenuBar mainMenuBar = new JMenuBar(); // Creates the menu bar which houses all menu options.
		JMenu menuNew = new JMenu("New"); // Creates the two sub menus that branch directly from the main menu bar.
		mainMenuBar.add(menuNew);
		JMenu menuStats = new JMenu("Statistics");
		mainMenuBar.add(menuStats);
		
		JMenu subMenuNewGame = new JMenu("New Game..."); // Creates and the menu and menu items within "New."
		menuNew.add(subMenuNewGame);
		JMenuItem newPlayer = new JMenuItem("New Player");
		newPlayer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.ALT_MASK));
		menuNew.add(newPlayer);
		newPlayer.addActionListener(new newPlayerListener());
		JMenuItem clear = new JMenuItem("Clear");
		menuNew.add(clear);
		
		JMenuItem lvlOne = new JMenuItem("Level 1"); // Creates sub-items within "New Game..."
		subMenuNewGame.add(lvlOne);
		//add action listener for lvlOne
		lvlOne.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.ALT_MASK));
		JMenuItem lvlTwo = new JMenuItem("Level 2"); // Create menu item.
		lvlTwo.addActionListener(new lvlTwoListener()); // Add appropriate listener.
		lvlTwo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.ALT_MASK));
		subMenuNewGame.add(lvlTwo); // Add to sub-menu.
		JMenuItem lvlThree = new JMenuItem("Level 3");
		lvlThree.addActionListener(new lvlThreeListener());
		lvlThree.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.ALT_MASK));
		subMenuNewGame.add(lvlThree);
		JMenuItem lvlFour = new JMenuItem("Level 4");
		lvlFour.addActionListener(new lvlFourListener());
		lvlFour.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.ALT_MASK));
		subMenuNewGame.add(lvlFour);
		JMenuItem lvlFive = new JMenuItem("Level 5");
		lvlFive.addActionListener(new lvlFiveListener());
		lvlFive.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_5, ActionEvent.ALT_MASK));
		subMenuNewGame.add(lvlFive);
		
		JCheckBoxMenuItem time = new JCheckBoxMenuItem("Time"); // Creates the menu and menu items within "Statistics."
		menuStats.add(time);
		JCheckBoxMenuItem numPlays = new JCheckBoxMenuItem("# of Plays");
		menuStats.add(numPlays);
		JCheckBoxMenuItem topPlayer = new JCheckBoxMenuItem("Top Player");
		menuStats.add(topPlayer);
		JCheckBoxMenuItem mostDifGame = new JCheckBoxMenuItem("Most Difficult Game");
		menuStats.add(mostDifGame);
		
		display = new JPanel(); // Creates display and sets layout as GridBag, below sets constraints for formatting.
		display.setLayout(new GridBagLayout()); 
		GridBagConstraints c = new GridBagConstraints(); // Sets constraints, must adjust to liking before adding to display.
		
		guesses = new DefaultListModel<String>(); // Actual list that guesses are stored in.
		JList<String> listGuesses = new JList<String>(guesses); // listGuesses component contains the guesses list model.
		JScrollPane guessPane = new JScrollPane(listGuesses); // guessPane contains the JList and allows scroll-ability.
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 300; // Sets height value constraint
		c.gridx = 0; // Position on grid in x direction
		c.gridy = 0; // Position on grid in y direction
		display.add(guessPane, c); // Adds listGuesses to display, adhering to the constraints of the GridBag
		
		clues = new DefaultListModel<String>();
		JList<String> listClues = new JList<String>(clues);
		JScrollPane cluePane = new JScrollPane(listClues);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		display.add(cluePane, c);
		
		textGuess = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // Sets height value constraint
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		display.add(textGuess, c);
		
		JButton enter = new JButton("Enter");
		enter.addActionListener(new EnterListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		display.add(enter, c);
		
		JLabel player = new JLabel(currentPlayer.getPlayerName());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 2;
		display.add(player, c); // End of GridBag formatting.
		
		JLabel level = new JLabel("Level " + currentGame.getLevel());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 2;
		display.add(level, c); // End of GridBag formatting.
		
		add(display);
		setJMenuBar(mainMenuBar);
	}
	
	public static void main(String[] args) {
		new GameGUI("Numbers Game");
	}	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

