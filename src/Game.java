
public abstract class  Game {
	
	int level;
	String clue;
	int guesses;
	
	public abstract int getLevel();
	
	public abstract String checkValue(String guess);
	
	public abstract boolean gameOver();	
	
}
