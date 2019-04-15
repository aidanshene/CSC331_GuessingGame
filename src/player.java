import java.util.ArrayList;

public class player {
	
	String playerName;
	
	ArrayList<otherGame> otherGameList = new ArrayList<otherGame>();
	
	public player(String name) {
		this.playerName = name;
		
	}
	
	public void addOtherGame(otherGame game) {
		otherGameList.add(game);
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
