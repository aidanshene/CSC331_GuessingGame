import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class StatsGUI extends JFrame {
	private static final long serialVersionUID = -6194704301528590576L;
	
	ArrayList<Player> playerList;
	Player currentPlayer;

	ButtonGroup leftBG = new ButtonGroup();
	ButtonGroup midBG = new ButtonGroup();

	JRadioButton level1 = new JRadioButton("Level 1");
	JRadioButton level2 = new JRadioButton("Level 2");
	JRadioButton level3 = new JRadioButton("Level 3");
	JRadioButton level4 = new JRadioButton("Level 4");
	JRadioButton level5 = new JRadioButton("Level 5");


	DefaultListModel<String> stats= new DefaultListModel<String>();
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
			
			JRadioButton check = getSelectedRadioButton(midBG);
			System.out.println(check.getText());
			if(check.getText().equals(level1.getText())) {

				String number = level1.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);


				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);

				for(String[] stringArray : dataDump) {
					System.out.println(stringArray[1]);
					stats.addElement(stringArray[1]);
				}

			}else if (check.getText().equals(level2.getText())) {
				String number = level2.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if(check.getText().equals(level3.getText())) {
				String number = level3.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if (check.getText().equals(level4.getText())) {
				String number = level4.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}else if (check.getText().equals(level5.getText())) {
				String number = level5.getText().substring(6,7);
				Integer num=0;
				num += num.parseInt(number);
				ArrayList<String[]> dataDump = currentPlayerScoreKeeper.UniversalGetter(num);
			}


		}

	}

	private JRadioButton getSelectedRadioButton(ButtonGroup bg) {
		Enumeration<AbstractButton> abs = bg.getElements();
		JRadioButton radButton = null;
		while(abs.hasMoreElements()) {
			radButton = (JRadioButton) abs.nextElement();
			if(radButton.isSelected())
				break;
		}
		return radButton;
	
	}

	public void addPanels() {

		stats = new DefaultListModel<String>();
		JList<String> statsList = new JList<String>(stats);
		JScrollPane scroll = new JScrollPane(statsList);

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
		c.gridx = 0;
		c.gridy = 0;
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
		level2.addActionListener(new currentPlayerStatsListener());

		add(leftPanel);
		add(midPanel);
		add(rightPanel);

		setVisible(true);
	}

}
