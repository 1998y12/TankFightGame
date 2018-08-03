package element;

import java.awt.Graphics;
import java.awt.Image;

public class bomb extends BasicElement{

	public int step = 0;
	public bomb(int x, int y, Image[] images) {
		super(x, y, images);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(step == images.length) {
			step = 0;
			isExist = false;
			return ;
		}
		g.drawImage(images[step] , x , y , null);
		step++;
		
	}
	
}
