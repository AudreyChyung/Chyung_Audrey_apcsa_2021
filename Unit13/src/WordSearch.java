//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import java.io.*; 

public class WordSearch
{
    private String[][] m;

    public WordSearch( int size, String str )
    {
    	m = new String[size][size];
    	for (int i = 0; i < size; i++) {
    		m[i] = str.substring(size * i, size * i + 8).split("");
    	}
    }

    public boolean isFound( String word )
    {
    	boolean found = false;
    	for (int r = 0; !found && r < m.length; r++) {
    		for (int c = 0; !found && c < m.length; c++) {
    			if (word.substring(0,1).equals(m[r][c])) { //if location in matrix has first letter of word, check all directions
    				found = checkRight(word, r, c) ||
    						checkLeft(word, r, c) ||
    						checkUp(word, r, c) ||
    						checkDown(word, r, c) ||
    						checkDiagUpRight(word, r, c) ||
    						checkDiagUpLeft(word, r, c) ||
    						checkDiagDownLeft(word, r, c) ||
    						checkDiagDownRight(word, r, c);
    			}
    		}
    	}
    	return found;
    }

	public boolean checkRight(String w, int r, int c)
   {
		int i = 0;
		while ( i < w.length() ) {
			if ( c+i < 0 || c+i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r][c+i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkLeft(String w, int r, int c)
	{
		int i = 0;
		while ( i < w.length() ) {
			if ( c-i < 0 || c-i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r][c-i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkUp(String w, int r, int c)
	{
		int i = 0;
		while ( i < w.length() ) {
			if ( r-i < 0 || r-i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r-i][c]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDown(String w, int r, int c)
   {
		int i = 0;
		while ( i < w.length() ) {
			if ( r+i < 0 || r+i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r+i][c]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagUpRight(String w, int r, int c)
	{
		int i = 0;
		while ( i < w.length() ) {
			if ( r-i < 0 || r-i >= m.length || c+i < 0 || c+i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r-i][c+i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagUpLeft(String w, int r, int c)
	{
		int i = 0;
		while ( i < w.length() ) {
			if ( r-i < 0 || r-i >= m.length || c-i < 0 || c-i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r-i][c-i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagDownLeft(String w, int r, int c)
   {
		int i = 0;
		while ( i < w.length() ) {
			if ( r+i < 0 || r+i >= m.length || c-i < 0 || c-i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r+i][c-i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

	public boolean checkDiagDownRight(String w, int r, int c)
	{
		int i = 0;
		while ( i < w.length() ) {
			if ( r+i < 0 || r+i >= m.length || c+i < 0 || c+i >= m.length ) //out of bounds
				return false;
			if ( !w.substring(i,i+1).equals(m[r+i][c+i]) ) //next letter doesn't match
				return false;
			i++;
		}
		return true;
	}

    public String toString()
    {
    	String output = "";
    	for (String[] r : m) {
    		for (String c : r) {
    			output += c + " ";
    		}
    		output += "\n";
    	}
 		return output;
    }
}
