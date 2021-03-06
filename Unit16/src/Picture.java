import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count++;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\flower1.jpg");
    Picture flower2 = new Picture("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\collage.jpg");
  }
  
  
  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel currentPixel = null;
    Pixel rightPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    Color bottomColor = null;
    for (int row = 0; row < pixels.length-1; row++)
    {
      for (int col = 0; col < pixels[0].length-1; col++)
      {
        currentPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        bottomPixel = pixels[row+1][col];
        bottomColor = bottomPixel.getColor();
        if (currentPixel.colorDistance(rightColor) > edgeDist || currentPixel.colorDistance(bottomColor) > edgeDist)
        	currentPixel.setColor(Color.BLACK);
        else
        	currentPixel.setColor(Color.WHITE);
      }
    }
  }
  
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void keepOnlyRed()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void keepOnlyGreen()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void negate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255-pixelObj.getRed());
        pixelObj.setBlue(255-pixelObj.getBlue());
        pixelObj.setGreen(255-pixelObj.getGreen());
      }
    }
  }
  
  public void grayscale()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	int avg = (pixelObj.getRed()+pixelObj.getGreen()+pixelObj.getBlue())/3;
        pixelObj.setRed(avg);
        pixelObj.setBlue(avg);
        pixelObj.setGreen(avg);
      }
    }
  }
  
  public void fixUnderwater()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
    	  //if (pixelObj.getRed() > 30 || pixelObj.getBlue() < 153 ) {
    		int newBlue = pixelObj.getBlue()-70;
    		if (newBlue < 0) newBlue = 0;
    		pixelObj.setBlue(newBlue);
    		int newGreen = pixelObj.getGreen()-70;
    		if (newGreen < 0) newGreen = 0;
    		pixelObj.setGreen(newGreen);
    	  //}
      }
    }
  }
  
  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int row = 0; row < pixels.length / 2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[pixels.length - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    } 
  }
  
  public void mirrorHorizontalBotToTop()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    for (int row = 0; row < pixels.length / 2; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[pixels.length - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    } 
  }
  
  public void mirrorArms()
  {
    int mirrorPoint = 195;
    Pixel topPixel = null;
    Pixel botPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 157; row < mirrorPoint; row++)
    {
      for (int col = 100; col < 170; col++)
      {
        topPixel = pixels[row][col];      
        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        botPixel.setColor(topPixel.getColor());
      }
      
      for (int col = 240; col < 300; col++)
      {
        topPixel = pixels[row][col];      
        botPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        botPixel.setColor(topPixel.getColor());
      }
    }
  }
  
  public void mirrorGull()
  {
    int mirrorPoint = 350;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 225; row < 325; row++)
    {
      for (int col = 228; col < mirrorPoint; col++)
      {
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  public void mirrorDiagonal()
  {
    Pixel onePixel = null;
    Pixel twoPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels.length; col++)
      {
        onePixel = pixels[row][col];      
        twoPixel = pixels[col][row];
        onePixel.setColor(twoPixel.getColor());
      }
    }
  }
  
  public void copy(Picture fromPic, int fromStartRow, int fromEndRow, int fromStartCol, 
		  			int fromEndCol, int toStartRow, int toStartCol)
	{
		Pixel fromPixel = null;
		Pixel toPixel = null;
		Pixel[][] toPixels = this.getPixels2D();
		Pixel[][] fromPixels = fromPic.getPixels2D();
		for (int fromRow = fromStartRow, toRow = toStartRow; 
		  fromRow < fromEndRow &&
		  toRow < toPixels.length; 
		  fromRow++, toRow++)
		{
			for (int fromCol = fromStartCol, toCol = toStartCol; 
			    fromCol < fromEndCol &&
			    toCol < toPixels[0].length;  
			    fromCol++, toCol++)
				{
				 fromPixel = fromPixels[fromRow][fromCol];
				 toPixel = toPixels[toRow][toCol];
				 toPixel.setColor(fromPixel.getColor());
				}
		}   
	}
  
  public void createCopy()
  {
	  Picture flower = new Picture("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\flower1.jpg");
	  this.copy(flower,0,35,28,68,20,40);
	  this.write("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\canvas.jpg");
  }
  
  public void myCollage()
  {
	  Picture flower = new Picture("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\flower1.jpg");
	  this.copy(flower,0,35,28,68,20,40);
	  this.keepOnlyGreen();
	  this.copy(flower,0,35,28,68,80,20);
	  this.zeroBlue();
	  this.copy(flower,0,35,28,68,140,40);
	  this.mirrorVertical();
	  this.negate();
	  this.write("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\canvas.jpg");
  }
  
  public void chromakey(Picture newBack)
  {
	  Pixel fromPixel = null;
	  Pixel toPixel = null;
	  Pixel[][] fromPixels = newBack.getPixels2D();
	  Pixel[][] toPixels = this.getPixels2D();
	  
	  for (int row = 0; row < this.getHeight(); row++) {
		  for (int col = 0; col < this.getWidth(); col++) {
			  toPixel = toPixels[row][col];
			  if (toPixel.getBlue() > toPixel.getRed() && toPixel.getBlue() > toPixel.getGreen()) {
				  fromPixel = fromPixels[row][col];
				  toPixel.setColor(fromPixel.getColor());
			  }
		  }
	  }
  }
  
  public void getCountRedOverValue(int val)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pixelObj = null;
	  int cnt = 0;
	  for (int r = 0; r < this.getHeight(); r++) {
		  for (int c = 0; c < this.getWidth(); c++) {
			  pixelObj = pixels[r][c];
			  if (pixelObj.getRed() > val)
				  cnt++;
		  }
	  }
	  System.out.println(cnt);
  }
  
  public void setRedToHalfValueInTopHalf()
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pixelObj = null;
	  for (int r = 0; r < this.getHeight()/2; r++) {
		  for (int c = 0; c < this.getWidth(); c++) {
			  pixelObj = pixels[r][c];
			  pixelObj.setRed(pixelObj.getRed()/2);
		  }
	  }
  }
  
  public void clearBlueOverValue(int val)
  {
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pixelObj = null;
	  for (int r = 0; r < this.getHeight()/2; r++) {
		  for (int c = 0; c < this.getWidth(); c++) {
			  pixelObj = pixels[r][c];
			  if (pixelObj.getBlue() > val)
				  pixelObj.setBlue(0);
		  }
	  }
  }
  
  public void blur(int x, int y, int w, int h) {
	  System.out.println("Audrey Chyung, Period 3, 5/25/2021");
	  Pixel[][] pixels = this.getPixels2D();
	  Pixel pixelObj = null;
	  Pixel one = null;
	  Pixel two = null;
	  Pixel three = null;
	  Pixel four = null;
	  Pixel five = null;
	  Pixel six = null;
	  Pixel seven = null;
	  Pixel eight = null;
	  int avgR;
	  int avgG;
	  int avgB;
	  
	  if (x < 1)
		  x = 1;
	  if (y < 1)
		  y = 1;
	  
	  for (int r = x; r < x+h; r++) {
		  for (int c = y; c < y+w; c++) {
			  pixelObj = pixels[r][c];
			  //8 surrounding pixels
			  one = pixels[r-1][c];
			  two = pixels[r+1][c];
			  three = pixels[r][c-1];
			  four = pixels[r][c+1];
			  five = pixels[r-1][c-1];
			  six = pixels[r-1][c+1];
			  seven = pixels[r+1][c-1];
			  eight = pixels[r+1][c+1];
			  avgR = (pixelObj.getRed() + one.getRed() + two.getRed() + three.getRed() + four.getRed() + five.getRed() + six.getRed() + seven.getRed() + eight.getRed())/9;
			  avgG = (pixelObj.getGreen() + one.getGreen() + two.getGreen() + three.getGreen() + four.getGreen() + five.getGreen() + six.getGreen() + seven.getGreen() + eight.getGreen())/9;
			  avgB = (pixelObj.getBlue() + one.getBlue() + two.getBlue() + three.getBlue() + four.getBlue() + five.getBlue() + six.getBlue() + seven.getBlue() + eight.getBlue())/9;
			  pixelObj.setRed(avgR);
			  pixelObj.setGreen(avgG);
			  pixelObj.setBlue(avgB);
			  
		  }
	  }
  }
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("C:\\\\Users\\\\chyun\\\\OneDrive\\\\Documents\\\\GitHub\\\\Chyung_Audrey_apcsa_2021\\\\Unit16\\\\src\\\\images\\\\beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
