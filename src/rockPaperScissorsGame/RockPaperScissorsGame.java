package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// Initialise variables
		int roundsToPlay = 0;
		String output = "";
		int playerOneOption = -1;
		int playerTwoOption = -1;
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		Boolean playAgain = true;
		
		Points playersPoints = new Points();
		
		// Keep playing the game
		while (playAgain) {
			
		// Method called to get a value for the number of rounds the users wish to play
		roundsToPlay = ChosenNumberOfRounds();
		// Construct and display message to users to display the amount of rounds they have chosen 
		output = "You have chosen to play " + roundsToPlay + " games. Let the games begin!";
		DisplayMessage(output);
		
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
			
			playersPoints = playersPoints.CalculatePoints(playerOneOption, playerTwoOption);
			// Store result in local variable
			playerOnePoints += playersPoints.playerOne;
			playerTwoPoints += playersPoints.playerTwo;
			// After each calculation the options need to be reset to allow the users to choose another option to play with in the next round
			playerOneOption = -1;
			playerTwoOption = -1;
		}
		
			AnnounceWinner(playerOnePoints, playerTwoPoints);
			
			int result = JOptionPane.showConfirmDialog(null, "Do you wish to play again?", "Confirmation", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.NO_OPTION) {
				playAgain = false;
			}
		}
	}
	
	// Generic message functionality
	public static void DisplayMessage(String output) {
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// PLayers to choose how many rounds they wish to play
	public static int ChosenNumberOfRounds() {
		int roundsToPlay = 0;
		while (roundsToPlay == 0) {
			// Prompt user to state how many rounds they wish to play
			String userInput = JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors! \n How many rounds would you wish to play?");
			// Change input from a string to an integer so we can use this number to determine how many rounds to play
			roundsToPlay = Integer.parseInt(userInput);
		}
		return roundsToPlay;
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
	
	// Check which player has the most points and reveal the winner of the game after all rounds have been played
	public static void AnnounceWinner(int playerOnePoints, int playerTwoPoints) {
		String winnerOutput = "";
		
		if (playerOnePoints > playerTwoPoints) {
			// Construct output to be displayed back to the user
			winnerOutput = "Player 1 has won the game!";
			// Display the message showing how many rounds the user has chosen to play
			JOptionPane.showMessageDialog(null, winnerOutput, "", JOptionPane.INFORMATION_MESSAGE);
		} else if (playerTwoPoints > playerOnePoints) {
			// Construct output to be displayed back to the user
			winnerOutput = "Player 2 has won the game!";
			// Display the message showing how many rounds the user has chosen to play
			JOptionPane.showMessageDialog(null, winnerOutput, "", JOptionPane.INFORMATION_MESSAGE);
		} else {
			// Construct output to be displayed back to the user
			winnerOutput = "This game was a draw!";
			// Display the message showing how many rounds the user has chosen to play
			JOptionPane.showMessageDialog(null, winnerOutput, "", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	
	// NOTES:
	// 1. Ask users how many rounds they wish to play - DONE
	// 2. Ask player one for a number - DONE
	// 3. Ask player two for a number - DONE
	// 4. Add validation to step 2 & 3 - DONE
	// 5. Calculate the rounds for points - DONE
	// 6. Display the winner of each round - DONE
	// 7. Announce the winner of the total rounds - DONE
	// 8. Ask if they wish to play again - DONE
}
