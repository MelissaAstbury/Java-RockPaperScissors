package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class Points {
	int playerOne;
	int playerTwo;

	public Points CalculatePoints(int playerOneOption, int playerTwoOption) {
		// Initialise variables
		String output = "";
		int rock = 0;
		int paper = 1;
		int scissors = 2;
		
		// Initialise object to be used
		Points playersPoints = new Points();
		
		// Calculate the points to be given to a single player. The condition to be only based on the winning options
		if (playerOneOption == rock && playerTwoOption == scissors || playerOneOption == paper && playerTwoOption == rock || playerOneOption == scissors && playerTwoOption == paper){
			// players points are added on top of the points a player already has
			playersPoints.playerOne = this.playerOne + 1;
			//Construct output to be displayed back to the user
			output = "Player 1 won this round!";
			// Display message back to user
			DisplayMessage(output);
			// This is the same functionality for player two also
		} else if (playerTwoOption == rock && playerOneOption == scissors || playerTwoOption == paper && playerOneOption == rock || playerTwoOption == scissors && playerOneOption == paper){
			playersPoints.playerTwo = this.playerTwo  + 1;
			output = "Player 2 won this round!";
			DisplayMessage(output);
		} else {
			// Message to be displayed to the user if none of the above conditions match (i.e a draw)
			output = "This round was a draw!";
			DisplayMessage(output);
		}
		return playersPoints;
	}
	
	// Method that displayed a window to show information to the user
	private static void DisplayMessage(String output) {
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
	}
}