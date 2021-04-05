//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Grid
{
   private String[][] grid;

   //load vals into the rows x cols grid randomly
	public Grid(int rows, int cols, String[] vals)
	{
		grid = new String[rows][cols];
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				int random = (int)(Math.random() * vals.length);
				grid[row][col] = vals[random];
			}
		}
	}

	//find out which of the vals occurs the most
	public String findMax(String[] vals)
	{
		int maxInd = 0;
		for (int i = 1; i < vals.length; i++)
			if (countVals(vals[maxInd]) < countVals(vals[i])) 
				maxInd = i;
		return vals[maxInd] + " occurs the most.";
	}

	//returns a count of how many times val occurs in the matrix
	private int countVals( String val )
	{
		int count = 0;
		for (String[] row : grid) {
			for (String item : row) {
				if (item.equals(val)) count++;
			}
		}
		return count;
	}

	//display the grid
	public String toString()
	{
		String output="";
		for (String[] row : grid) {
			for (String item : row) {
				output += item + " ";
			}
			output += "\n";
		}
		return output;
	}
}