//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.io.File; 
import java.io.IOException;
import java.util.Scanner;
import java.util.Arrays;
import static java.lang.System.*;

public class WordRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner file = new Scanner(new File("C:\\Users\\chyun\\OneDrive\\Documents\\School\\CSA\\words.dat"));

		int size = file.nextInt();
		Word[] words = new Word[size];
		for (int i = 0; i < size; i++) {
			words[i] = new Word(file.next());
		}
		System.out.println(Arrays.toString(words));
		Arrays.sort(words);
		System.out.println(Arrays.toString(words));
		

	}
}