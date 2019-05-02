import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class StatsGUI extends JFrame {
	
	
	public StatsGUI(String title) {
		
		super(title);
		setSize(400,400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(1,3));
		
	}
	
	
	public void addPanels() {
		DefaultListModel<String> stats;
		stats = new DefaultListModel<String>();
		JScrollPane scroll = new JScrollPane();
		JList<String> statsList = new JList<String>(stats);
		
		JPanel leftPanel = new JPanel();
		JPanel midPanel = new JPanel();
		JPanel rightPanel = new JPanel();
		
		ButtonGroup leftBG = new ButtonGroup();
		ButtonGroup midBG = new ButtonGroup();
		ButtonGroup rightBG = new ButtonGroup();
		
		JRadioButton currentUserButt = new JRadioButton("Current Player Stats");
		JRadioButton globalButt = new JRadioButton("All Players Stats");
		
		leftBG.add(currentUserButt);
		leftBG.add(globalButt);
		
		leftPanel.add(currentUserButt);
		leftPanel.add(globalButt);
		
		
		leftPanel.setLayout(new GridLayout(2,1));
		midPanel.setLayout(new GridLayout(5,1));
		
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
		
		
		
		rightPanel.add(scroll);
		scroll.add(statsList);
		
			
		
		add(leftPanel);
		add(midPanel);
		add(rightPanel);
		
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		StatsGUI ui = new StatsGUI("Stats");
		ui.addPanels();

	}

}
