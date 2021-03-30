import java.util.Arrays;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class MatrixCount1Runner
{
	public static void main( String args[] ) throws Exception
	{
		//add code
		int[][] arr = {{ 1, 2, 3, 4, 5},
				{ 6, 7, 8, 9, 0},
				{ 6, 7, 1, 2, 5},
				{ 6, 7, 8, 9, 0},
				{ 5, 4, 3, 2, 1}};
		System.out.println("Matrix values");
		for (int i = 0; i < arr.length; i++)
            System.out.println(Arrays.toString(arr[i]));
		
		System.out.println();
		
		System.out.println("The " + 7 + " count is :: " + MatrixCount1.count(7));
		System.out.println("The " + 8 + " count is :: " + MatrixCount1.count(8));
		System.out.println("The " + 6 + " count is :: " + MatrixCount1.count(6));
		System.out.println("The " + 21 + " count is :: " + MatrixCount1.count(21));
		
	}
}



