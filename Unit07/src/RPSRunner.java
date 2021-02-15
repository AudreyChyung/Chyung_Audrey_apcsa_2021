//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		Scanner keyboard = new Scanner(System.in);
		RockPaperScissors game = new RockPaperScissors();
		char response = 'y';
		
		//add in a do while loop after you get the basics up and running
		do {
			String player = "";
		
			out.print("type in your prompt [R,P,S] :: ");
			
			//read in the player value
			player = keyboard.next();
			game.setPlayers(player);
			System.out.println(game);
			
			//ask to redo game
			System.out.println("Do you want to play again? [y,n] ");
			response = keyboard.next().charAt(0);
		} while (response == 'y');			
	}
}



