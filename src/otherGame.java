import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;

public class otherGame implements IGame{
	
	ArrayList<Integer> answer = new ArrayList<Integer>();
	
	public otherGame(int level) {
		
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
		
		String returnString = input;
		
		while(i != max) {

			
			String guess = token.nextToken();
			String actual = answer.get(i).toString();
			
			i++;
			
			System.out.println("guess " + guess + "\t actual " + actual);

			
			Integer guessInt = 0;
			
			guessInt = guessInt.parseInt(guess); //used to check if the guess is in the answer at all
			
			if(answer.contains(guessInt)) {
				// I'm running this for loop because it could have the number more than once and it should
				// count that for more than 1 appearance of the number
				
				for(int num : answer) {
					if (num == guessInt) {
						numberRight ++;
					}
				}		
			}
				
			if (guess.contentEquals(actual)) { //this checks the guess with the direct position it came in
				positionRight ++;
			}
				continue;
			}
			
			System.out.println(numberRight);
			System.out.println(positionRight);
			
			returnString += " (" + numberRight + ", "+ positionRight + ")";
			
			return returnString;
		
	}

	@Override
	public void getInput() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	

	}

}
