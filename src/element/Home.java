package element;

import java.awt.Graphics;
import java.awt.Image;

public class Home extends BasicElement {

	public Home(int x, int y, Image[] images) {
		super(x, y, images);
	
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
			g.drawImage(images[0],x,y,null);

			
//			for(int i = 0;i<homeWall.size;i++) {
//				CommonWall w = homeWall.get(i);
//				w.draw(g);
//			}
	}
	

}
