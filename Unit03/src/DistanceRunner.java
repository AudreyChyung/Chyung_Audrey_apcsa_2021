//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		//Get coordinates from user input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter X1 : : ");
		int xOne = keyboard.nextInt();
		System.out.print("Enter Y1 :: ");
		int yOne = keyboard.nextInt();
		System.out.print("Enter X2 :: ");
		int xTwo = keyboard.nextInt();
		System.out.print("Enter Y2 :: ");
		int yTwo = keyboard.nextInt();
		
		//Calculate and display distance
		Distance test = new Distance();
		test.setCoordinates(xOne,yOne,xTwo,yTwo);
		System.out.println("Distance == " + String.format("%.3f", test.getDistance()));
	}
}