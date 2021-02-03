//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		Discount test = new Discount();
		
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		System.out.print("Bill after discount :: " + String.format("%.2f\n", test.getDiscountedBill(amt)));

	}
}