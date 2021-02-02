//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class Line
{
	public static double getSlope( int x1, int y1, int x2, int y2 )
	{
		double dx1 = x1, dx2 = x2, dy1 = y1, dy2 = y2;
		return (dy2-dy1)/(dx2-dx1);
	}

}