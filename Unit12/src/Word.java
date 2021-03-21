//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Word implements Comparable<Word>
{
	private String word;

	public Word( String s )
	{
		word = s;
	}
	
	public String getWord() {
		return word;
	}

	public int compareTo( Word rhs )
	{		
		if (word.length() < rhs.getWord().length())
			return -1;
		else if (word.length() > rhs.getWord().length())
			return 1;
		else {
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) < rhs.getWord().charAt(i))
					return -1;
				else if (word.charAt(i) > rhs.getWord().charAt(i))
					return 1;
			}
			return 0;
		}	
	}

	public String toString()
	{
		return word;
	}
}