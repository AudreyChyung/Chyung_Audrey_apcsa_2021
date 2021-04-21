//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

   //instance variables

   public SpeedUpBall()
   {
	   super();
   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y,xSpd,ySpd);
   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,xSpd,ySpd);
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y,wid,ht,col,xSpd,ySpd);
   }

   //set xSpeed to 1 extra unit faster whenever setXSpeed or setYSpeed are called
   
   public void setXSpeed( int xSpd )
   {
	   if (xSpd < 0)
		   super.setXSpeed(xSpd-1);
	   else
		   super.setXSpeed(xSpd+1);
   }

   public void setYSpeed( int ySpd )
   {
	   super.setYSpeed(ySpd);
	   
	   if (getXSpeed() < 0)
		   super.setXSpeed(getXSpeed()-1);
	   else
		   super.setXSpeed(getXSpeed()+1);
   }
}

