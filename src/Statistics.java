import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Statistics {
	File BasicDatabase = new File("Statistics.csv");
	ArrayList<Player> MasterPlayerList = new ArrayList<Player>();
	ArrayList<String> PlayerNames;
	
	// https://www.mkyong.com/java/how-do-calculate-elapsed-execute-time-in-java/
	long CPST; // Current Player Start Time
	
	public Statistics() throws IOException {
		
		
		try {
			// Sourced From: https://alvinalexander.com/blog/post/java/how-open-read-file-java-string-array-list
			BufferedReader FileBuffer = new BufferedReader ( new FileReader ( BasicDatabase ) );
			String CurrentIndex;
			while( ( CurrentIndex = FileBuffer.readLine() ) != null ) {
				GetPlayerNames();  //Updates string list of player names
				String[] CurrentPlayerEntry = CurrentIndex.split(",");
				int PlayerIndex = PlayerNames.indexOf(CurrentPlayerEntry[0]); // .indexOf returns -1 if item not in list
				if ( PlayerIndex != -1 ) { 
					
					// Creates a new level based off the second half of the current .csv line
					Levels TempLevel = new Levels( Integer.parseInt( CurrentPlayerEntry[1] ) );
					for ( int i = 3 ; i < CurrentPlayerEntry.length ; i++ ) {
						TempLevel.addStats( Integer.parseInt( CurrentPlayerEntry[i] ) );
					}
					
					// Adds Level to current player object
					MasterPlayerList.get( PlayerIndex ).AddLevel( TempLevel );
					MasterPlayerList.get( PlayerIndex ).setPlayTime( Long.parseLong( CurrentPlayerEntry[2] ) );
				}
			}
		} catch ( IOException   e) {
			BasicDatabase.createNewFile();
		} 
	}
	
	private void GetPlayerNames() {
		/*
		 * Routes through current player list, and updates the PlayerName variables with all current player names
		 */
		
		ArrayList<String> TempPlayerNames = new ArrayList<String>();
		for ( Player P : MasterPlayerList ) {
			TempPlayerNames.add(P.getPlayerName());
		}
		
		PlayerNames = TempPlayerNames;
	}
	
	public Player NewPlayer( String PlayerName ) {
		int PlayerIndex = PlayerNames.indexOf( PlayerName ); // .indexOf returns -1 if item not in list
		if ( PlayerIndex != -1 ) {
			CPST = System.currentTimeMillis();
			return MasterPlayerList.get( PlayerIndex );
		} else {
			CPST = System.currentTimeMillis();
			return new Player( PlayerName );
		}
	}
	
	public void CloseCurrentPlayer( Player CurrentPlayer ) {
		CurrentPlayer.addPlayTime( ( System.currentTimeMillis() - CPST ) / 1000 / 60 );
	}
}
