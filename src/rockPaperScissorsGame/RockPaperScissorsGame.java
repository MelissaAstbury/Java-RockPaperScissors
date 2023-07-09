package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialise variables
		int roundsToPlay = 0;
		String output = "";
		int playerOneOption = -1;
		int playerTwoOption = -1;
		
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		
		int rock = 0;
		int paper = 1;
		int scissors = 2;
		
		// Method called to get a value for the number of rounds the users wish to play
		roundsToPlay = ChosenNumberOfRounds();
		// Construct and display message to users to display the amount of rounds they have chosen 
		output = "You have chosen to play " + roundsToPlay + " games. Let the games begin!";
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
		
		// Loop through each round so the users can choose different options (rock, paper or scissors) on each round
		for(int i = 0; i < roundsToPlay; i++) {
			// Player must choose rock, paper or scissors which corresponds to a number. This number must be 0, 1 or 2. If not the user will be asked again for another number.
			while (playerOneOption == -1) {
				String playerOneInput = JOptionPane.showInputDialog("Player 1, choose one of the following: \n Rock: 0 \n Paper: 1 \n Scissors: 2");
				if(IsIntegerInRange(playerOneInput, 0, 2)) {
					playerOneOption = Integer.parseInt(playerOneInput);
				};
			}
			while(playerTwoOption == -1) {
				String playerTwoInput = JOptionPane.showInputDialog("Player 2, choose one of the following: \n Rock: 0 \n Paper: 1 \n Scissors: 2");
				if(IsIntegerInRange(playerTwoInput, 0, 2)) {
					playerTwoOption = Integer.parseInt(playerTwoInput);
				};
			}
	
			// Calculate the points each player is to get depending on their chosen option
			// Only put a condition in for the times you are to win against component
			if (playerOneOption == rock && playerTwoOption == scissors || playerOneOption == paper && playerTwoOption == rock || playerOneOption == scissors && playerTwoOption == paper){
				// Give a point to player one
				playerOnePoints = playerOnePoints + 1;
			} else if (playerTwoOption == rock && playerOneOption == scissors || playerTwoOption == paper && playerOneOption == rock || playerTwoOption == scissors && playerOneOption == paper){
				// Give a point to player two
				playerTwoPoints = playerTwoPoints + 1;
			}
			// After each calculation the options need to be reset to allow the users to choose another option to play with in the next round
			playerOneOption = -1;
			playerTwoOption = -1;
			
			// Construct output to be displayed back to the user
			output = "PlayerOnePoints: " + playerOnePoints + " and PlayerTwoPoints " + playerTwoPoints;
			// Display the message showing how many rounds the user has chosen to play
			JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public static int ChosenNumberOfRounds() {
		// Prompt user to state how many rounds they wish to play
		String userInput = JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors! \n How many rounds would you wish to play?");
		// Change input from a string to an integer so we can use this number to determine how many rounds to play
		return Integer.parseInt(userInput);
	}
	
	// Validation for user number inputs
	public static Boolean IsIntegerInRange(String text, int minValue, int maxValue) {
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
	// 5. Calculate the rounds for points - DONE
	// 6. Display the winner of each round
	// 7. Announce the winner of the total rounds and ask if they wish to play again
}
