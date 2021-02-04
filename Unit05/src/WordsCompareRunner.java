//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
	   WordsCompare test = new WordsCompare();
	   //add test cases
	   test.setWords("abe", "ape");
	   System.out.print(test);
	   test.setWords("giraffe", "gorilla");
	   System.out.print(test);
	   test.setWords("one", "two");
	   System.out.print(test);
	   test.setWords("fun", "funny");
	   System.out.print(test);
	   test.setWords("123", "19");
	   System.out.print(test);
	   test.setWords("193", "1910");
	   System.out.print(test);
	   test.setWords("goofy", "godfather");
	   System.out.print(test);
	   test.setWords("funnel", "fun");
	   System.out.print(test);
	}
}