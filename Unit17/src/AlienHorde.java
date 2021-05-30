//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
	private List<Alien> aliens;

	public AlienHorde(int size)
	{
		aliens = new ArrayList<Alien>();
		for(int i = 0; i < size/2; i++) {
			add(new Alien(50*i,10,60,60,1));
		}
		for(int i = 0; i < size/2; i++) {
			add(new Alien(50*i,70,60,60,1));
		}
	}

	public void add(Alien al)
	{
		aliens.add(al);
	}

	public void drawEmAll( Graphics window )
	{
		for (Alien a : aliens) {
			a.draw(window);
		}
	}

	public void moveEmAll()
	{
		for (Alien a : aliens) {
			a.move("RIGHT");
			if(a.getX()>730) {
                a.setX(0);
                a.setY(a.getY()+60);
            }
		}
	}
	
	public void cleanEmUp() {
		for (int i = aliens.size()-1; i >= 0; i--) {
			if (aliens.get(i).getY() > 550) {
				aliens.remove(i);
			}
		}
	}

	public void removeDeadOnes(Bullets shots)
	{
		List<Ammo> shotsList = shots.getList();
		for (int i = aliens.size()-1; i >= 0; i--) {
			for(int j = shotsList.size()-1; j >= 0; j--)
            {
				Alien a = aliens.get(i);
				Ammo s = shotsList.get(j);
                if((s.getY() <= a.getY()+a.getHeight()+s.getSpeed()) &&
                   (s.getX() >= a.getX() &&
                    s.getX() <= a.getX()+a.getWidth() ||
                    s.getX()+5 >= a.getX() &&
                    s.getX()+5 < a.getX()+a.getWidth()))
                {
                    aliens.remove(i);
                    shots.remove(j);
                }

            }
		}
	}

	public String toString()
	{
		String output = "";
		for (Alien a : aliens)
			output += a.toString() + "\n";
		return output;
	}
}
