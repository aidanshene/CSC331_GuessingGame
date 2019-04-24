import java.util.ArrayList;

public class Player {
	
	String playerName;
	ArrayList<Levels> levelsList = new ArrayList<Levels>();
	ArrayList<OtherGame> otherGameList = new ArrayList<OtherGame>();
	
	public Player(String name) {
		this.playerName = name;
	}
	
	public void addOtherGame(OtherGame game) {
		otherGameList.add(game);
	}
	
	public void setPlayerName(String newName) {
		this.playerName = newName;
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setOtherGameList(ArrayList<OtherGame> newList) {
		this.otherGameList = newList;
	}
	
	public ArrayList<OtherGame> getOtherGameList() {
		return this.otherGameList;
	}
	
}
