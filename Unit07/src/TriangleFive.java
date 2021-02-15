//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		setLetter(' ');
		setAmount(0);
	}

	public TriangleFive(char c, int amt)
	{
		setLetter(c);
		setAmount(amt);
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}
	
	public String toString()
	{
		String output="";
		
		for (int i = 0; i < amount; i++) {
			char tempLetter = letter;
			for (int j = 0; j < amount - i; j++) {
				for (int k = 0; k < amount - j; k++) {
					output += tempLetter;
				}
				output += " ";
				
				//get the next letter, wrapping around to A if the letter is Z
				if (tempLetter == 'Z')
					tempLetter = 'A';
				else 
					tempLetter++;
			}
			output += '\n';
		}
		
		return output;
	}
}
	