//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import static java.lang.System.*;

public class ToyStore
{
	private ArrayList<Toy> toyList;

	public ToyStore()
	{
		toyList = new ArrayList<Toy>();
	}

	public void loadToys( String toys )
	{
		for (String name : toys.split(" ")) {
			if (getThatToy(name) == null) {
				toyList.add(new Toy(name, 1));
			} else {
				getThatToy(name).setCount(getThatToy(name).getCount() + 1);
			}
		}
	}
  
  	public Toy getThatToy( String nm )
  	{
  		for (int i = 0; i < toyList.size(); i++) {
  			if (toyList.get(i).getName().equals(nm))
  				return toyList.get(i);
  		}
  		return null;
  	}
  
  	public String getMostFrequentToy()
  	{
  		int ind = 0;
  		for (int i = 0; i < toyList.size(); i++) {
  			if (toyList.get(i).getCount() > toyList.get(ind).getCount()) {
  				ind = i;
  			}
  		}
  		
  		return "max == " + toyList.get(ind).getName();
  	}  
  
  	public void sortToysByCount()
  	{
  	}  
  	  
	public String toString()
	{
		String output = "[";
		for (int i = 0; i < toyList.size(); i++) {
			output += toyList.get(i);
			if (i < toyList.size() - 1)
				output += ", ";
		}
	   return output + "]";
	}
}