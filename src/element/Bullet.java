package element;

import java.awt.Graphics;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

import gameUtil.GameStartUtil;

public class Bullet extends BasicElement{

	public String dir;
	public static int speed = 10;
	public boolean isExist = false;
	public String type;
	private static Map<String, Image> map = new HashMap<String, Image>();
	
		
	
	
	public Bullet(int x, int y, Image[] images, String dir,String type) {
		super(x, y, images);
		// TODO Auto-generated constructor stub
		this.dir = dir;
		this.type = type;

		map.put("L", images[0]);
		map.put("U", images[1]);
		map.put("R", images[2]);
		map.put("D", images[3]);
	}

	public void move() {
	
		switch(dir) {
		case "L":
			x-=speed;
			break;
		case "U":
			y-=speed;
			break;
		case "R":
			x+=speed;
			break;
		case "D":
			y+=speed;
			break;
		default:
			break;
		
		}
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(map.get(dir),x,y,null);
	}
	
	
	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public static int getSpeed() {
		return speed;
	}

	public static void setSpeed(int speed) {
		Bullet.speed = speed;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public boolean outOfBounds() {
		if(x<0 || y<0 || x>GameStartUtil.FrameWidth || y>GameStartUtil.FrameHeight)
			return true;
		return false;
	}
	
}
