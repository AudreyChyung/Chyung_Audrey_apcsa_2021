//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MilesPerHour
{
	private int distance, hours, minutes;
	private int mph;

	public MilesPerHour()
	{
		setNums(0,0,0);
		mph=0;
	}

	public MilesPerHour(int dist, int hrs, int mins)
	{
		setNums(dist, hrs, mins);
		mph=0;
	}

	public void setNums(int dist, int hrs, int mins)
	{
		distance = dist;
		hours = hrs;
		minutes = mins;
	}

	public void calcMPH()
	{
		double time = hours + minutes/60.0;
		mph = (int) Math.round(distance/time);	
	}
	
	public double getMPH() {
		calcMPH();
		return mph;
	}
	
	public void print()
	{
		System.out.println(distance + " miles in " + hours + " hour(s) and " + minutes + " minute(s) = " + mph + " MPH.");
	}

	public String toString()
	{
		return ""+distance+" "+hours+" "+minutes+" "+mph;
	}
}