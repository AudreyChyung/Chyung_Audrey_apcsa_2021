//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		StringEquality test = new StringEquality();
		//add test cases
		test.setWords("hello", "goodbye");
		System.out.print(test);
		test.setWords("one", "two");
		System.out.print(test);
		test.setWords("three", "four");
		System.out.print(test);
		test.setWords("TCEA", "UIL");
		System.out.print(test);
		test.setWords("State", "Champions");
		System.out.print(test);
		test.setWords("ABC", "ABC");
		System.out.print(test);
		test.setWords("ABC", "CBA");
		System.out.print(test);
		test.setWords("Same", "Same");
		System.out.print(test);
	}
}