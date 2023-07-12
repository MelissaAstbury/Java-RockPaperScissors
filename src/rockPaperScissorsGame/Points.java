package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class Points {
	int playerOne;
	int playerTwo;

	public Points CalculatePoints(int playerOneOption, int playerTwoOption) {
		String output = "";
		int rock = 0;
		int paper = 1;
		int scissors = 2;
		
		Points playersPoints = new Points();
		
		// Calculate the points each player is to get depending on their chosen option
		// Only put a condition in for the times you are to win against component
		if (playerOneOption == rock && playerTwoOption == scissors || playerOneOption == paper && playerTwoOption == rock || playerOneOption == scissors && playerTwoOption == paper){
			playersPoints.playerOne = this.playerOne + 1;
			//Construct output to be displayed back to the user
			output = "Player 1 won this round!";
			// Display the message showing how many rounds the user has chosen to play
			DisplayMessage(output);
		} else if (playerTwoOption == rock && playerOneOption == scissors || playerTwoOption == paper && playerOneOption == rock || playerTwoOption == scissors && playerOneOption == paper){
			playersPoints.playerTwo = this.playerTwo  + 1;
			//Construct output to be displayed back to the user
			output = "Player 2 won this round!";
			// Display the message showing how many rounds the user has chosen to play
			DisplayMessage(output);
		} else {
			//Construct output to be displayed back to the user
			output = "This round was a draw!";
			// Display the message showing how many rounds the user has chosen to play
			DisplayMessage(output);
		}
		
		return playersPoints;
	}
	
	private static void DisplayMessage(String output) {
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE);
	}
}