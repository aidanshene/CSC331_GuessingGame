import java.util.ArrayList;

public class Player {
	
	String playerName;
	ArrayList<Levels> levelsList = new ArrayList<Levels>();
	ArrayList<OtherGame> otherGameList = new ArrayList<OtherGame>();
	Long timePlayed = (long) 0;
	
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
	
	public void AddLevel( Levels NewLevelObject ) {
		this.levelsList.add( NewLevelObject );
	}
	
	public void addPlayTime ( long newSession ) {
		timePlayed += newSession;
	}
	
	public void setPlayTime ( long gameTime ) {
		timePlayed = gameTime;
	}
	
	public String getPlayTime () {
		return this.timePlayed.toString();
	}
}
