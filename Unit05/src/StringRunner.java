//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class StringRunner
{
	public static void main ( String[] args )
	{
		Scanner keyboard = new Scanner(System.in);
		StringOddOrEven test = new StringOddOrEven();
		
		//get input from the user and check if it is odd or even. display the result
		System.out.println("Enter a word :: ");
		String word = keyboard.next();
		test.setString(word);
		test.isEven();
		System.out.println(test);
	}
}