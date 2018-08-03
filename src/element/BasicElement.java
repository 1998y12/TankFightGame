package element;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class BasicElement {
	public  int width;
	public  int height;
	int x,y;
	public  Image[] images = null;
	public boolean isExist ;
	
	public BasicElement(int x,int y,Image[] images) {
		this.x = x;
		this.y = y;
		this.images  = images;
		this.width = images[0].getWidth(null);
		this.height = images[0].getHeight(null);
		this.isExist = true;
	}
	
	public void draw(Graphics g) {
		g.drawImage(images[0],x,y,images[0].getWidth(null),images[0].getHeight(null),null);
	}
	
	public Rectangle getRect() {
		Rectangle r = new Rectangle(x,y,getWidth(),getHeight());
		r.grow(1, 1);
		return r;
	}

	public boolean bang(BasicElement e) {
		
	//	if(this.getRect().intersects(e.getRect()))
	//		System.out.println("撞到了！！！");
		return this.getRect().intersects(e.getRect());
	}
	
	public  int getWidth() {
		return width;
	}

	public  void setWidth(int width) {
		width = width;
	}

	public  int getHeight() {
		return height;
	}

	public  void setHeight(int height) {
		height = height;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public  Image[] getImages() {
		return images;
	}

	public  void setImages(Image[] images) {
		images = images;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}
	
	
	
	
}
