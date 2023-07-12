package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// Initialise variables
		String output = "";
		int roundsToPlay = 0;
		Boolean playAgain = true;
		int playerOneOption = -1;
		int playerTwoOption = -1;
		int playerOnePoints = 0;
		int playerTwoPoints = 0;
		
		// Initialise object to be used
		Points playersPoints = new Points();
		
		// Keep playing the game
		while (playAgain) {
			
		// Method called to ask for number of games the users wish to play
		roundsToPlay = ChosenNumberOfRounds();
		
		if (roundsToPlay != 0) {
			//Construct output to be displayed back to the user
			output = "You have chosen to play " + roundsToPlay + " games. Let the games begin!";
			DisplayMessage(output);
			
			// Loop through each round so the users can choose different options (rock, paper or scissors)
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
				
				// Method called to calculate points
				playersPoints = playersPoints.CalculatePoints(playerOneOption, playerTwoOption);
				// Store points in a local variable
				playerOnePoints += playersPoints.playerOne;
				playerTwoPoints += playersPoints.playerTwo;
				// After each calculation the options need to be reset to allow the users to choose another option to play with in the next round
				playerOneOption = -1;
				playerTwoOption = -1;
			}
			
				// Call method to reveal the winner
				AnnounceWinner(playerOnePoints, playerTwoPoints);
				
				// Once all rounds are complete and the winner is revealed ask users if they wish to play again
				int result = JOptionPane.showConfirmDialog(null, "Do you wish to play again?", "Confirmation", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.NO_OPTION) {
					playAgain = false;
				} else {
					// Reset points for both players
					playerOnePoints = 0;
					playerTwoPoints = 0;
				}
			}
		}
	}
	
	// Method that displayed a window to show information to the user
	public static void DisplayMessage(String output) {
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Players to choose how many rounds they wish to play
	public static int ChosenNumberOfRounds() {
		// Prompt user to state how many rounds they wish to play
		String userInput = JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors! \n How many rounds would you wish to play?");
		// Change input from a string to an integer so we can use this number to determine how many rounds to play
		return Integer.parseInt(userInput);
	}
	
	// Validation for user number inputs for their options (rock, paper, scissors)
	public static Boolean IsIntegerInRange(String text, int minValue, int maxValue) {
		try {
			int value = Integer.parseInt(text);
			return value >= minValue && value <= maxValue;
		}
		catch (Exception e) {
			return false;
		}
	}	
	
	// Method to display the who won the game
	// Check which player has the most points and reveal the winner of the game after all rounds have been played
	public static void AnnounceWinner(int playerOnePoints, int playerTwoPoints) {
		String winnerOutput = "";
		
		if (playerOnePoints > playerTwoPoints) {
			// Construct output to be displayed back to the user
			winnerOutput = "Player 1 has won the game!";
			DisplayMessage(winnerOutput);
		} else if (playerTwoPoints > playerOnePoints) {
			// Construct output to be displayed back to the user
			winnerOutput = "Player 2 has won the game!";
			DisplayMessage(winnerOutput);
		} else {
			// Construct output to be displayed back to the user
			winnerOutput = "This game was a draw!";
			DisplayMessage(winnerOutput);
		}
	}
}
