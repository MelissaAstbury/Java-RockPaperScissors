package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialise variables
		int roundsToPlay = 0;
		String output = "";
		int playerOne = -1;
		int playerTwo = -1;
		
		// PART ONE - How many rounds does the user want to play?
		roundsToPlay = ChosenNumberOfRounds();
		// Construct output to be displayed back to the user
		output = "You have chosen to play " + roundsToPlay + " games. Let the games begin!";
		// Display the message showing how many rounds the user has chosen to play
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
		
		// PART TWO - Players to choose their numbers
		// Player must enter a number they wish to play with. This number must be between (or include) the numbers 0-2
		while (playerOne == -1) {
			String playerOneInput = JOptionPane.showInputDialog("Player 1, choose one of the following: \n Rock: 0 \n Paper: 1 \n Scissors: 2");
			if(IsIntegerInRange(playerOneInput, 0, 2)) {
				playerOne = Integer.parseInt(playerOneInput);
			};
		}
		while(playerTwo == -1) {
			String playerTwoInput = JOptionPane.showInputDialog("Player 2, choose one of the following: \n Rock: 0 \n Paper: 1 \n Scissors: 2");
			if(IsIntegerInRange(playerTwoInput, 0, 2)) {
				playerTwo = Integer.parseInt(playerTwoInput);
			};
		}
		// Construct output to be displayed back to the user
		output = "PlayerOne: " + playerOne + " and PlayerTwo " + playerTwo;
		// Display the message showing how many rounds the user has chosen to play
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	private static int ChosenNumberOfRounds() {
		// Prompt user to state how many rounds they wish to play
		String userInput = JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors! \n How many rounds would you wish to play?");
		// Change input from a string to an integer so we can use this number to determine how many rounds to play
		return Integer.parseInt(userInput);
	}
	
	// Validation for user number inputs
	private static Boolean IsIntegerInRange(String text, int minValue, int maxValue) {
		try {
			int value = Integer.parseInt(text);
			return value >= minValue && value <= maxValue;
		}
		catch (Exception e) {
			return false;
		}
	}
	
	// NOTES:
	// 1. Ask users how many rounds they wish to play - DONE
	// 2. Ask player one for a number - DONE
	// 3. Ask player two for a number - DONE
	// 4. Add validation to step 2 & 3 - DONE
	// 5. Calculate the rounds for points
	// 6. Display the winner of each round
	// 7. Announce the winner of the total rounds and ask if they wish to play again
}
