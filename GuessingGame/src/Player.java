import java.util.ArrayList;

public class Player {
	
	private String playerName;
	private ArrayList<OtherGame> otherGameList = new ArrayList<OtherGame>();
	
	public Player(String name) {
		this.playerName = name;
	}
	
	public void addOtherGame(OtherGame game) {
		otherGameList.add(game);
	}
	
	public String getPlayerName() {
		return this.playerName;
	}
	
	public void setPlayerName(String name) {
		this.playerName = name;
	}
	
	public ArrayList<OtherGame> getOtherGameList() {
		return this.otherGameList;
	}
	
	public void setOtherGameList(ArrayList<OtherGame> newList) {
		this.otherGameList = newList;
	}
}
