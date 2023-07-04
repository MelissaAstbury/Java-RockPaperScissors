package rockPaperScissorsGame;

import javax.swing.JOptionPane;

public class RockPaperScissorsGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialise variables
		int roundsToPlay = 0;
		String output = "";
		
		// PART ONE - How many rounds does the user want to play?
		roundsToPlay = ChosenNumberOfRounds();
		// Construct output to be displayed back to the user
		output = "You have chosen to play " + roundsToPlay + " games. Let the games begin!";
		// Display the message showing how many rounds the user has chosen to play
		JOptionPane.showMessageDialog(null, output, "", JOptionPane.INFORMATION_MESSAGE); 
	}
	
	public static int ChosenNumberOfRounds() {
		// Prompt user to state how many rounds they wish to play
		String userInput = JOptionPane.showInputDialog("Welcome to Rock, Paper, Scissors! \n How many rounds would you wish to play?");
		// Change input from a string to an integer so we can use this number to determine how many rounds to play
		return Integer.parseInt(userInput);
	}
	
	// NOTES:
	// 1. Ask users how many rounds they wish to play - DONE
	// 2. Ask player one for a number 
	// 3. Ask player two for a number 
	// 4. Add validation to step 2 & 3
	// 5. Calculate the rounds for points
	// 6. Display the winner of each round
	// 7. Announce the winner of the total rounds and ask if they wish to play again
}
