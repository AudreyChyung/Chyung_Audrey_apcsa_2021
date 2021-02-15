//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
//Date -

public class RayOddToEven
{
	public static int go(int[] ray)
	{
		int oddInd;
		int evenInd;
		
		for(int i = 0; i < ray.length; i++) {
			if (ray[i]%2 != 0) {
				oddInd = i;
				for (int j = oddInd; j < ray.length; j++) {
					if (ray[j]%2 == 0) {
						evenInd = j;
						return evenInd - oddInd;
					}
				}
			}
		}
		return -1;
	}
}