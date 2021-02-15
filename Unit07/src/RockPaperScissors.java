//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
		int random = (int) (2 * Math.random());
		if (random == 0)
			compChoice = "R";
		else if (random == 1)
			compChoice = "P";
		else
			compChoice = "S";
	}

	public String determineWinner()
	{
		String winner = "";
		
		if (playChoice.equals(compChoice))
			winner = "!Draw Game!";
		else if (playChoice.equals("R") && compChoice.equals("S"))
			winner = "!Player wins <<Rock Breaks Scissors>>!";
		else if (playChoice.equals("P") && compChoice.equals("R"))
			winner = "!Player wins <<Paper Covers Rock>>!";
		else if (playChoice.equals("S") && compChoice.equals("P"))
			winner = "!Player wins <<Scissors Cuts Paper>>!";
		else if (playChoice.equals("R") && compChoice.equals("P"))
			winner = "!Computer wins <<Paper Covers Rock>>!";
		else if (playChoice.equals("P") && compChoice.equals("S"))
			winner = "!Computer wins <<Scissors Cuts Paper>>!";
		else if (playChoice.equals("S") && compChoice.equals("R"))
			winner = "!Computer wins <<Rock Breaks Scissors>>!";
		else
			winner = "Something went wrong";
		
		return winner;
	}

	public String toString()
	{
		String output="player had " + playChoice + "\ncomputer had " + compChoice + "\n" + determineWinner();
		return output;
	}
}