//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 
import java.util.Scanner;

public class AddSubMult
{
	public static double check( double a, double b )
	{
		double result;
		if (a > b) {
			result = a-b;
		} else if (b > a) {
			result = b-a;
		} else {
			result = a*b;
		}
		return result;
	}
}