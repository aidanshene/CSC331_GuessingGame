import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class StatsGUI extends JFrame {
	
	ArrayList<Player> playerList;
	Player currentPlayer;
	
	ButtonGroup leftBG = new ButtonGroup();
	ButtonGroup midBG = new ButtonGroup();
	
	JRadioButton level1 = new JRadioButton("Level 1");
	JRadioButton level2 = new JRadioButton("Level 2");
	JRadioButton level3 = new JRadioButton("Level 3");
	JRadioButton level4 = new JRadioButton("Level 4");
	JRadioButton level5 = new JRadioButton("Level 5");
	
	
	DefaultListModel<String> stats = new DefaultListModel<String>();
	JScrollPane scroll = new JScrollPane();
	JList<String> statsList = new JList<String>(stats);
	

	public StatsGUI(String title, ArrayList<Player> playersList, Player currentPlayer) {
		
		super(title);
		setSize(500,425);
		this.playerList = playersList;
		this.currentPlayer = currentPlayer;
		
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,3));
		setResizable(false);
		
		
		
	}
	
	public class currentPlayerStatsListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			
			ScoreKeeper currentPlayerScoreKeeper = new ScoreKeeper(currentPlayer);
			
			System.out.println("Action Listnener engaged");
			System.out.println(level1.isSelected());
			
			if(level1.isSelected() == false) {
				
				String number = level1.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				

				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
				
				for(String[] stringArray : dataDump) {
					System.out.println(stringArray[1]);
					stats.addElement("New Element");
					
				}
				
				
				
			}else if (level2.isSelected()) {
				String number = level2.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if(level3.isSelected()) {
				String number = level3.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if (level4.isSelected()) {
				String number = level4.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if (level5.isSelected()) {
				String number = level5.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}
			
			
		}
		
	}
	
	
	
	public void addPanels() {
		
		DefaultListModel<String> stats;
		stats = new DefaultListModel<String>();
		JScrollPane scroll = new JScrollPane();
		JList<String> statsList = new JList<String>(stats);
		scroll.add(statsList);
		
		scroll.setSize(100, 100);
		
		JPanel leftPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		ButtonGroup rightBG = new ButtonGroup();
		
		JRadioButton currentUserButt = new JRadioButton("Current Player Stats");
		JRadioButton globalButt = new JRadioButton("All Players Stats");
		
		leftBG.add(currentUserButt);
		leftBG.add(globalButt);
		
		leftPanel.add(currentUserButt);
		leftPanel.add(globalButt);
		
		
		leftPanel.setLayout(new GridLayout(2,1));
		midPanel.setLayout(new GridLayout(5,1));
		rightPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 350;
		c.ipadx = 150;
		
		JRadioButton level1 = new JRadioButton("Level 1");
		JRadioButton level2 = new JRadioButton("Level 2");
		JRadioButton level3 = new JRadioButton("Level 3");
		JRadioButton level4 = new JRadioButton("Level 4");
		JRadioButton level5 = new JRadioButton("Level 5");
		
		midBG.add(level1);
		midBG.add(level2);
		midBG.add(level3);
		midBG.add(level4);
		midBG.add(level5);
		
		midPanel.add(level1);
		midPanel.add(level2);
		midPanel.add(level3);
		midPanel.add(level4);
		midPanel.add(level5);
		
		rightPanel.add(scroll,c);
		
		level1.addActionListener(new currentPlayerStatsListener());
			
		add(leftPanel);
		add(midPanel);
		add(rightPanel);
		
		setVisible(true);
	}

}
