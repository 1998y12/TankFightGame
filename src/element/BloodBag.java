package element;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

public class BloodBag extends BasicElement {

	public BloodBag(int x, int y, Image[] images) {
		super(x, y, images);
		// TODO Auto-generated constructor stub
	}
	
	public int step = 0;
	public boolean isExist = false;
	public static Random r;
	public int[][] position = { { 155, 196 }, { 500, 58 }, { 80, 340 },
			{ 99, 199 }, { 345, 456 }, { 123, 321 }, { 258, 413 } };
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(r.nextInt(100) > 98) {
			isExist = true;
			move();
		}
		if(!isExist) {
			return ;
		}
		g.drawImage(this.images[0], x, y, null);
	}

	private void move() {
		// TODO Auto-generated method stub
		step++;
		if(step==position.length) {
			step = 0;
		}
		this.x = position[step][0];
		this.y = position[step][1];
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	
	
	
	

}
