
public class testGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OneGame og = new OneGame(25);
		Integer guesses = og.OneGameGuessingGame();
		System.out.println("You took " + guesses.toString() + " to guess the correct answer");
	}

}
