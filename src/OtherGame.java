import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import java.util.StringTokenizer;

public class OtherGame extends Game implements IGame{
	//Guesses will be used in statistics
	int guesses;
	
	String clue;	
	
	int lvl;
	
	ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public OtherGame(int level) {
		
		lvl = level;
		
		for(int i=0; i<level; i++) {
			
			Random randNumGen = new Random();
			
			int num = randNumGen.nextInt(10);
			
//			System.out.println(num);
			
			answer.add(num);
			
		}
	}


	@Override
	public String checkValue(String input) {
		// TODO Auto-generated method stub
		
		// this method takes in a string input that will come from the gui. Then checks if it is in
		// the correct answer at all and counts how many times it is correct and how many times it is 
		// also in the correct spot.
		
		StringTokenizer token = new StringTokenizer(input,",");
		
		int i = 0;
		int numberRight = 0;
		int positionRight = 0;
		
		int max = token.countTokens();
		
		String returnString = "(" + input + ")";
		
		while(i != max) {

			
			String guess = token.nextToken();
			String actual = answer.get(i).toString();
			
			i++;
			
//			System.out.println("guess " + guess + "\t actual " + actual);

			
			Integer guessInt = 0;
			
			guessInt = guessInt.parseInt(guess); //used to check if the guess is in the answer at all
			
			if(answer.contains(guessInt)) {
				// I'm running this for loop because it could have the number more than once and it should
				// count that for more than 1 appearance of the number
				

				numberRight ++;
					
			}
				
			if (guess.contentEquals(actual)) { //this checks the guess with the direct position it came in
				positionRight ++;
			}
				continue;
				
			}
			
//			System.out.println(numberRight);
//			System.out.println(positionRight);
		
		
			clue = "("+numberRight+","+positionRight+")";
			returnString += " " + clue;
			
			
			guesses++;
			
			return returnString;
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}
	
	
	public boolean gameOver() {
		
		String check = "("+ lvl +"," + lvl+")";
		
		if(clue.contentEquals(check)) {
			return true;
		}
		
		return false;
	}
	
	public int getLevel() {
		return this.lvl;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OtherGame test = new OtherGame(3);
		
		while (true){
			
			Scanner input = new Scanner(System.in);
				
			String guess = input.nextLine();
			
			System.out.println(test.checkValue(guess));
		
			System.out.println(test.clue);
			
			if(test.gameOver()) {
				
				System.out.println(test.guesses);
				break;
			}
		}
		
	

	}

}
