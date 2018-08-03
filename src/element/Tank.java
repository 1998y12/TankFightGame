package element;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import gameUtil.GameStartUtil;

public class Tank extends BasicElement{

	public String type;
	public int step = 0;
	public int speed = 6;
	public int life;
	public int oldX , oldY;
	public boolean isExist = true;
	public  Random r = new Random();
	public String dir;
	public String lastDir;
	private static Map<String, Image> map = new HashMap<String, Image>();
	
	
		
	
	public int getFireX() {
		int tempX = x;
		switch(dir) {
		case "U":
			tempX+=map.get("U").getWidth(null)/2 - 5;
			break;
		case "D":
			tempX+=map.get("D").getWidth(null)/2 - 5;
			break;
		case "R":
			tempX+=map.get("R").getWidth(null) - 2;
			break;
		default:
			break;
		}
		return tempX;
	}
	
	public int getFireY()
	{	
		int tempY = y;
		switch(dir) {
		case "L":
			tempY+=map.get("L").getHeight(null)/2 - 2;
			break;
		case "R":
			tempY+=map.get("R").getHeight(null)/2 - 2 ;
			break;
		case "D":
			tempY+=map.get("D").getHeight(null) - 2;
			break;
		case "U":
			tempY+=-2;
		default:
			break;
		}
		return tempY;	
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getOldX() {
		return oldX;
	}

	public void setOldX(int oldX) {
		this.oldX = oldX;
	}

	public int getOldY() {
		return oldY;
	}

	public void setOldY(int oldY) {
		this.oldY = oldY;
	}

	public boolean isExist() {
		return isExist;
	}

	public void setExist(boolean isExist) {
		this.isExist = isExist;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public Tank(int x, int y, Image[] images, String type) {
		super(x, y, images);
		map.put("L", images[0]);
		map.put("U", images[1]);
		map.put("R", images[2]);
		map.put("D", images[3]);
		// TODO Auto-generated constructor stub
		this.dir = "D";
		this.lastDir = this.dir;
		this.type = type;
		this.oldX = x;
		this.oldY = y;
	}
	
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		if(dir.equals("STOP"))
			g.drawImage(map.get(lastDir), x, y, map.get(lastDir).getWidth(null)  , map.get(lastDir).getHeight(null)  ,null);
		else
			g.drawImage(map.get(dir), x, y, map.get(dir).getWidth(null)  , map.get(dir).getHeight(null)  ,null);
	}
	
	public void move() {
		this.oldX = x;
		this.oldY = y;
		
		if(!type.equals("HERO")) {
			if(step==0) {
				step = r.nextInt(15) + 5;
				int rn = r.nextInt(5);
				if(!dir.equals("STOP"))
					lastDir = dir;
				switch(rn) {
				case 0:
					dir = "L";
					break;
				case 1:
					dir = "U";
					break;
				case 2:
					dir = "R";
					break;
				case 3:
					dir = "D";
					break;
				case 4:
					dir = "STOP";
					break;
				default:
					break;
				}
			}
			step--;

		}
		
		switch(dir) {
		case "L":
			x-=speed;
			break;
		case "R":
			x+=speed;
			break;
		case "U":
			y-=speed;
			break;
		case "D":
			y+=speed;
			break;
		case "STOP":
			break;
		default:
			break;
		}
		if(x<0)
			x = 0;
		if(y<28)
			y = 28;
		if(x + this.getWidth() > GameStartUtil.FrameWidth)
			x = GameStartUtil.FrameWidth - this.getWidth();
		if(y + this.getHeight() > GameStartUtil.FrameHeight-41)
			y = GameStartUtil.FrameHeight-41 - this.getHeight();
	}
	
	public void backBackBack() {
		x = oldX;
		y = oldY;
	}
	
	@Override
	public void setWidth(int width) {
		// TODO Auto-generated method stub
		super.setWidth(width);
	}
	
	@Override
	public void setHeight(int height) {
		// TODO Auto-generated method stub
		super.setHeight(height);
	}
	
	@Override
	public int getWidth() {
		// TODO Auto-generated method stub
		switch(dir) {
		case "L":
			return 35;
	
		case "R":
			return 35;
		
		case "U":
			return 34;
			
		case "D":
			return 34;
			
		default:
			return 35;
		}
	}
	
	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		switch(dir) {
		case "U":
			return 35;
	
		case "D":
			return 35;
		
		case "L":
			return 34;
			
		case "R":
			return 34;
			
		default:
			return 35;
		}
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return super.getRect();
	}
	
	@Override
	public boolean bang(BasicElement e) {
		// TODO Auto-generated method stub
		return super.bang(e);
	}
	
	public int getRandom() {
		return r.nextInt(47);
	}
}
