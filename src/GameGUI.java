import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GameGUI extends JFrame {
	private static final long serialVersionUID = 70625052682885262L;
	
	public GridBagConstraints c;
	public JMenuBar mainMenuBar;
	public JMenu menuNew;
	public JMenu subMenuNewGame;
	public JMenu menuStats;
	public JMenuItem newPlayer;
	public JMenuItem clear;
	public JMenuItem lvlOne;
	public JMenuItem lvlTwo;
	public JMenuItem lvlThree;
	public JMenuItem lvlFour;
	public JMenuItem lvlFive;
	public JCheckBoxMenuItem time;
	public JCheckBoxMenuItem numPlays;
	public JCheckBoxMenuItem topPlayer;
	public JCheckBoxMenuItem mostDifGame;
	public JPanel panelA;
	public JList<String> listGuesses;
	public DefaultListModel<String> guesses;
	public JList<String> listClues;
	public DefaultListModel<String> clues;
	public JTextField textGuess;
	public JButton enter;
	
	public OtherGame currentGame;
	public Player currentPlayer;
	
	public GameGUI(String title) {
		super(title);
		c = new GridBagConstraints();
		setSize(500, 500);
		setLocation(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainMenuBar = new JMenuBar(); // Creates the menu bar which houses all menu options.
		
		menuNew = new JMenu("New"); // Creates the two sub menus that branch directly from the main menu bar.
		mainMenuBar.add(menuNew);
		menuStats = new JMenu("Statistics");
		mainMenuBar.add(menuStats);
		
		subMenuNewGame = new JMenu("New Game..."); // Creates and the menu and menu items within "New."
		menuNew.add(subMenuNewGame);
		newPlayer = new JMenuItem("New Player");
		menuNew.add(newPlayer);
		clear = new JMenuItem("Clear");
		menuNew.add(clear);
		lvlOne = new JMenuItem("Level 1");
		subMenuNewGame.add(lvlOne);
		
		lvlTwo = new JMenuItem("Level 2");
		lvlTwo.addActionListener(new newOtherGameListener());
		subMenuNewGame.add(lvlTwo);
		
		lvlThree = new JMenuItem("Level 3");
		lvlThree.addActionListener(new newOtherGameListener());
		subMenuNewGame.add(lvlThree);
		
		lvlFour = new JMenuItem("Level 4");
		lvlFour.addActionListener(new newOtherGameListener());
		subMenuNewGame.add(lvlFour);
		
		lvlFive = new JMenuItem("Level 5");
		lvlFive.addActionListener(new newOtherGameListener());
		subMenuNewGame.add(lvlFive);
		
		time = new JCheckBoxMenuItem("Time"); // Creates the menu and menu items within "Statistics."
		menuStats.add(time);
		numPlays = new JCheckBoxMenuItem("# of Plays");
		menuStats.add(numPlays);
		topPlayer = new JCheckBoxMenuItem("Top Player");
		menuStats.add(topPlayer);
		mostDifGame = new JCheckBoxMenuItem("Most Difficult Game");
		menuStats.add(mostDifGame);
		
		panelA = new JPanel(); // Creates panelA and sets layout as GridBag, below sets constraints for formatting.
		panelA.setLayout(new GridBagLayout()); 
		guesses = new DefaultListModel<String>();
		listGuesses = new JList<String>(guesses); 
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 300; // Sets height value constraint
		c.gridx = 0; // Position on grid in x direction
		c.gridy = 0; // Position on grid in y direction
		panelA.add(listGuesses, c); // Adds listGuesses to panelA, adhering to the constraints of the GridBag
		
		clues = new DefaultListModel<String>();
		listClues = new JList<String>(clues);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 1;
		c.gridy = 0;
		panelA.add(listClues, c);
		
		textGuess = new JTextField();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0; // sets height value constraint
		c.weightx = 0.5;
		c.gridx = 0;
		c.gridy = 1;
		panelA.add(textGuess, c);
		
		enter = new JButton("Enter");
		enter.addActionListener(new EnterListener());
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 1;
		panelA.add(enter, c); // End of GridBag formatting.
		
		String initName = JOptionPane.showInputDialog("Enter player name:"); // Prompts user for a player name before starting the game.
		currentPlayer = new Player(initName);   
	
		add(panelA);
		setJMenuBar(mainMenuBar);
		setVisible(true);
	}
	
	public class newOtherGameListener implements ActionListener { // Action listener for New Game -> Level 2-5.
		public void actionPerformed(ActionEvent ae) {
			if(ae.getSource() == lvlTwo) {
				currentGame = new OtherGame(2);
				currentPlayer.addOtherGame(currentGame);
			}
			else if(ae.getSource() == lvlThree) {
				currentGame = new OtherGame(3);
				currentPlayer.addOtherGame(currentGame);
			}
			else if(ae.getSource() == lvlFour) {
				currentGame = new OtherGame(4);
				currentPlayer.addOtherGame(currentGame);
			}
			else if(ae.getSource() == lvlFive) {
				currentGame = new OtherGame(5);
				currentPlayer.addOtherGame(currentGame);
			}
			guesses.clear();
			clues.clear();
		}
	}
	
	public class newPlayerListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
		}
	}
	
	public class EnterListener implements ActionListener { // Action listener for the Enter button.
		public void actionPerformed(ActionEvent ae) {
			String guess = textGuess.getText();
			String clue = currentGame.checkValue(guess);
			guesses.addElement(guess);
			clues.addElement(clue);
		}
	}
	
	public static void main(String[] args) {
		new GameGUI("Numbers Game");
	}	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

