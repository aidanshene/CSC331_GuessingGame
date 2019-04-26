import java.util.ArrayList;

public class Levels {
	
	ArrayList<Integer> scores = new ArrayList<Integer>();
	
	int level;
	int lowestScore = 100;
	int highestScore = 0;
	int totalGuesses = 0;
	double avgGuesses;
	
	public Levels(int level) {
		this.level = level;
	}
	
	public void addStats(int guesses) {
		this.scores.add(guesses);
	}
	
	public void getLowestScore() {
		
		for (Integer i : scores) {
			if(i < lowestScore) {
				lowestScore = i;
			}
		}
	}
	
	public void getHighestScore() {
		for(Integer i : scores) {
			if(i > highestScore) {
				highestScore =i;
			}
		}
	}
	
	public void getAverage() {
		avgGuesses = this.totalGuesses / scores.size();	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public void setScores ( ArrayList<Integer> newScores ) {
		this.scores = newScores;
	}

}
