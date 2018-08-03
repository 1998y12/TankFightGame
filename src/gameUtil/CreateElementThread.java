package gameUtil;

import java.awt.Image;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.ImageIcon;

import element.Bullet;
import element.CommonWall;
import element.Home;
import element.MetalWall;
import element.Tank;
import element.Tree;
import element.bomb;
import manager.ElementManager;

public class CreateElementThread extends Thread{

	private Map<String,Image> heroImageMap;
	private Map<String,Image> enemyImageMap;
	private Map<String,Image> bulletImageMap;
	private Map<String,Image> staticthingImageMap;
	
	Image[] heroImgs = new Image[4];
	Image[] bulletImgs = new Image[4];
	Image[] enemyImgs = new Image[4];
	Image[] bombImgs = new Image[10];
	
	int[] homeLoc = new int[2];
	int[] homewallSize = new int[2];
	
	int[] homePicSize = new int[2];
	int[] commonWallPicSize = new int[2];
	int[] metalWallPicSize = new int[2];
 	
	int[] otherwallSize1 = new int[2];
	int[] otherwallLoc1 = new int[2];
	int[] otherwallLoc2 = new int[2];
	int[] otherwallSize2 = new int[2];
	int[] otherwallSize3 = new int[2];
	int[] otherwallLoc3 = new int[2];
	int[] otherwallSize4 = new int[2];
	int[] otherwallLoc4 = new int[2];
	int[] otherwallSize5 = new int[2];
	int[] otherwallLoc5 = new int[2];
	int[] otherwallSize6 = new int[2];
	int[] otherwallLoc6 = new int[2];
	
	int[] metalwallSize1 = new int[2];
	int[] metalwallSize2 = new int[2];
	int[] metalwallLoc1 = new int[2];
	int[] metalwallLoc2 = new int[2];

	int[] treeSize1 = new int[2];
	int[] treeLoc1 = new int[2];
	
	public  CreateElementThread() {
		// TODO Auto-generated constructor stub
		heroImageMap = new HashMap<String,Image>();
		enemyImageMap = new HashMap<String,Image>();
		bulletImageMap = new HashMap<String,Image>();
		staticthingImageMap= new HashMap<String,Image>();
	}
	
	public void readHeroPro(String fileName) {

		Properties ps = GameStartUtil.getProperties(fileName);
		
		Set<Object> set = ps.keySet();
		
		for(Object o : set) {
			if(o.equals("img")) {
				UpdateHashMap(heroImageMap , ps.getProperty("img"));
				heroImgs = new Image[]{heroImageMap.get("L") , heroImageMap.get("U") , heroImageMap.get("R") , heroImageMap.get("D")};
			}
		}
	}
	
	public void readBulletPro(String fileName) {

		Properties ps = GameStartUtil.getProperties(fileName);
		
		Set<Object> set = ps.keySet();
		
		for(Object o : set) {
			if(o.equals("img")) {
				UpdateHashMap(bulletImageMap , ps.getProperty("img"));
				bulletImgs = new Image[]{bulletImageMap.get("L") , bulletImageMap.get("U") , bulletImageMap.get("R") , bulletImageMap.get("D")};
			}
		}
	}
	
	public void readStaticthingPro(String fileName) {
		
		Properties ps = GameStartUtil.getProperties(fileName);
		
		Set<Object> set = ps.keySet();
		
		for(Object o:set) {
			if(o.equals("img")) {
				UpdateHashMap(staticthingImageMap, ps.getProperty("img"));
			}
			else if(o.equals("home")) {
				String[] xy = ps.getProperty("home").split(":");
				homeLoc[0] = Integer.parseInt(xy[0]);
				homeLoc[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("homesize")) {
				String[] xy = ps.getProperty("homesize").split(":");
				homePicSize[0] = Integer.parseInt(xy[0]);
				homePicSize[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("commonwallsize")) {
				String[] xy = ps.getProperty("commonwallsize").split(":");
				commonWallPicSize[0] = Integer.parseInt(xy[0]);
				commonWallPicSize[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("metalwallsize")) {
				String[] xy = ps.getProperty("metalwallsize").split(":");
				metalWallPicSize[0] = Integer.parseInt(xy[0]);
				metalWallPicSize[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("homewall")) {
				String[] xy = ps.getProperty("homewall").split(":");
				homewallSize[0] = Integer.parseInt(xy[0]);
				homewallSize[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("otherwall1")) {
				String[] sstr = ps.getProperty("otherwall1").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				
				otherwallSize1[0] = Integer.parseInt(size[0]);
				otherwallSize1[1] = Integer.parseInt(size[1]);
				otherwallLoc1[0] = Integer.parseInt(xy[0]);
				otherwallLoc1[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("otherwall2")) {
				String[] sstr = ps.getProperty("otherwall2").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				otherwallSize2[0] = Integer.parseInt(size[0]);
				otherwallSize2[1] = Integer.parseInt(size[1]);
				otherwallLoc2[0] = Integer.parseInt(xy[0]);
				otherwallLoc2[1] = Integer.parseInt(xy[1]);
			} 
			else if(o.equals("otherwall3")) {
				String[] sstr = ps.getProperty("otherwall3").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				
				otherwallSize3[0] = Integer.parseInt(size[0]);
				otherwallSize3[1] = Integer.parseInt(size[1]);
				otherwallLoc3[0] = Integer.parseInt(xy[0]);
				otherwallLoc3[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("otherwall4")) {
				String[] sstr = ps.getProperty("otherwall4").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				
				otherwallSize4[0] = Integer.parseInt(size[0]);
				otherwallSize4[1] = Integer.parseInt(size[1]);
				otherwallLoc4[0] = Integer.parseInt(xy[0]);
				otherwallLoc4[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("otherwall5")) {
				String[] sstr = ps.getProperty("otherwall5").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				
				otherwallSize5[0] = Integer.parseInt(size[0]);
				otherwallSize5[1] = Integer.parseInt(size[1]);
				otherwallLoc5[0] = Integer.parseInt(xy[0]);
				otherwallLoc5[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("otherwall6")) {
				String[] sstr = ps.getProperty("otherwall6").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				
				otherwallSize6[0] = Integer.parseInt(size[0]);
				otherwallSize6[1] = Integer.parseInt(size[1]);
				otherwallLoc6[0] = Integer.parseInt(xy[0]);
				otherwallLoc6[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("metalwall1")) {
				String[] sstr = ps.getProperty("metalwall1").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				metalwallSize1[0] = Integer.parseInt(size[0]);
				metalwallSize1[1] = Integer.parseInt(size[1]);
				metalwallLoc1[0] = Integer.parseInt(xy[0]);
				metalwallLoc1[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("metalwall2")) {
				String[] sstr = ps.getProperty("metalwall2").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				metalwallSize2[0] = Integer.parseInt(size[0]);
				metalwallSize2[1] = Integer.parseInt(size[1]);
				metalwallLoc2[0] = Integer.parseInt(xy[0]);
				metalwallLoc2[1] = Integer.parseInt(xy[1]);
			}
			else if(o.equals("tree1")) {
				String[] sstr = ps.getProperty("tree1").split(";");
				
				String[] size = sstr[0].split(":");
				String[] xy = sstr[1].split(":");
				treeSize1[0] = Integer.parseInt(size[0]);
				treeSize1[1] = Integer.parseInt(size[1]);
				treeLoc1[0] = Integer.parseInt(xy[0]);
				treeLoc1[1] = Integer.parseInt(xy[1]);
			}
			else {
				String str = ps.getProperty((String)o);
				String[] xy = str.split(":");
				ElementManager.getElementManager().enemyTankList.add(new Tank(Integer.parseInt(xy[0]), Integer.parseInt(xy[1]), enemyImgs, "ENEMY"));
				System.out.println(":  "+Integer.parseInt(xy[0])+" , " + Integer.parseInt(xy[1]));
			}
			
			
		}
	}

	public void readEnemyPro(String fileName) {
		Properties ps = GameStartUtil.getProperties(fileName);
		
		Set<Object> set = ps.keySet();
		
		for(Object o : set) {
			if(o.equals("img")) {
				UpdateHashMap(enemyImageMap , ps.getProperty("img"));
				enemyImgs = new Image[]{enemyImageMap.get("L") , enemyImageMap.get("U") , enemyImageMap.get("R") , enemyImageMap.get("D")};
			}
		}
	}
	
	public void readBombPro(String fileName) {
		Properties ps = GameStartUtil.getProperties(fileName);
		
		Set<Object> set = ps.keySet();
		
		int i = 0;
		int j = 0;
		for(Object o : set) {
			if(o.equals("img")) {
				String[] str = ps.getProperty("img").split(";");
				while(j<10)
				{
					System.out.println(str[j]);
					bombImgs[i++] = new ImageIcon(str[j++]).getImage();
				}
			}
		}
	}
	
	public void UpdateHashMap(Map<String, Image> map, String s) {
		// TODO Auto-generated method stub
		map.clear();
		String[] arr = s.split(";");
		
		for(String str : arr) {
			String tempStr[] = str.split(":");
			map.put(tempStr[0], new ImageIcon(tempStr[1]).getImage());
		}
	}

	public void createOtherWall() {
		Image[] imgs = new Image[]{ staticthingImageMap.get("commonwall") };
		for(int i = 0;i<otherwallSize1[1];i++) {
			for(int j = 0;j<otherwallSize1[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc1[0] + 21*i , otherwallLoc1[1] + 22*j , imgs));
	
			}
		}
		otherwallSize1 = null;
		otherwallLoc1 = null;
		
		for(int i = 0;i<otherwallSize2[1];i++) {
			for(int j = 0;j<otherwallSize2[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc2[0] + 21*i , otherwallLoc2[1] + 22*j , imgs));

			}
		}
		otherwallSize2 = null;
		otherwallLoc2 = null;
		
		for(int i = 0;i<otherwallSize3[1];i++) {
			for(int j = 0;j<otherwallSize3[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc3[0] + 21*i , otherwallLoc3[1] + 22*j , imgs));

			}
		}
		otherwallSize3 = null;
		otherwallLoc3 = null;
		
		for(int i = 0;i<otherwallSize4[1];i++) {
			for(int j = 0;j<otherwallSize4[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc4[0] + 21*i , otherwallLoc4[1] + 22*j , imgs));

			}
		}
		otherwallSize4 = null;
		otherwallLoc4 = null;
		
		for(int i = 0;i<otherwallSize5[1];i++) {
			for(int j = 0;j<otherwallSize5[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc5[0] + 21*i , otherwallLoc5[1] + 22*j , imgs));

			}
		}
		otherwallSize5 = null;
		otherwallLoc5 = null;
		
		for(int i = 0;i<otherwallSize6[1];i++) {
			for(int j = 0;j<otherwallSize6[0];j++) {
				ElementManager.getElementManager().otherWallList.add(new CommonWall(otherwallLoc6[0] + 21*i , otherwallLoc6[1] + 22*j , imgs));

			}
		}
		otherwallSize6 = null;
		otherwallLoc6 = null;
		
	}
	
	public void createMetalWall() {
		Image[] imgs = new Image[] {	staticthingImageMap.get("metalwall")};
		for(int i = 0;i<metalwallSize1[1];i++) {
			for(int j = 0;j<metalwallSize1[0];j++) {
				ElementManager.getElementManager().metalWallList.add(new MetalWall(metalwallLoc1[0] + 37*i , metalwallLoc1[1] + 36*j , imgs));
	
			}
		}
		
		for(int i = 0;i<metalwallSize2[1];i++) {
			for(int j = 0;j<metalwallSize2[0];j++) {
				ElementManager.getElementManager().metalWallList.add(new MetalWall(metalwallLoc2[0] + 37*i , metalwallLoc2[1] + 36*j , imgs));

			}
		}
	}
	
	public void createHeroTank() {
		ElementManager.getElementManager().setHeroTank(new Tank(376, 466, heroImgs, "HERO"));
		ElementManager.getElementManager().heroTank.dir = "U";
		ElementManager.getElementManager().heroTank.setLife(200);
		
	}
	
	public void createHome() {
		ElementManager.getElementManager().setHome( new Home( homeLoc[0] , homeLoc[1] , new Image[]{staticthingImageMap.get("home")} ) );
	}
	
	public void createHomewall() {

		for(int i = 0;i< 2 *( homewallSize[0] - 1) + homewallSize[1];i++) {
			if (i < 4)
				ElementManager.getElementManager().getHomeWallList().add(
						new CommonWall(350, 580 - 21 * i, new Image[]{ staticthingImageMap.get("commonwall") }));
			else if (i < 7)
				ElementManager.getElementManager().getHomeWallList().add(
						new CommonWall(372 + 22 * (i - 4), 517, new Image[]{ staticthingImageMap.get("commonwall") }));
			else
				ElementManager.getElementManager().getHomeWallList().add(
						new CommonWall(416, 538 + (i - 7) * 21, new Image[]{ staticthingImageMap.get("commonwall") }));			
		}
	}
	
	public void createTree() {
		Image[] imgs = new Image[] {	staticthingImageMap.get("tree")};
		for(int i = 0;i<treeSize1[1];i++) {
			for(int j = 0;j<treeSize1[0];j++) {
				ElementManager.getElementManager().treeList.add(new Tree(treeLoc1[0] + 36*i , treeLoc1[1] + 36*j , imgs));
	
			}
		}
		
		
	}
	
	public void addHeroBulletToList() {
		Bullet b = new Bullet(ElementManager.getElementManager().heroTank.getFireX(), ElementManager.getElementManager().heroTank.getFireY(), bulletImgs, ElementManager.getElementManager().heroTank.getDir(), "HERO");
		b.isExist = true;
		ElementManager.getElementManager().getHeroTankBullet().add(b);
	}
	
	public void addEnemyBulletToList(Tank e) {
		Bullet b = new Bullet(e.getFireX(),e.getFireY(),bulletImgs,e.getDir(),"ENEMY");
		b.isExist = true;
		ElementManager.getElementManager().enemyTankBullet.add(b);
	}
	
	public void addBomb(Tank e) {
		bomb b = new bomb(e.getX(), e.getY(), bombImgs);
		b.isExist = true;
		ElementManager.getElementManager().bombList.add(b);
	}
	
	public void createElement() throws InterruptedException {
		Thread.sleep(1000);
		
		createHeroTank();
		
		createHome();
		
		createHomewall();
		
		createOtherWall();
		
		createMetalWall();

		createTree();
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		readHeroPro("hero.pro");
		readBulletPro("bullet.pro");
		readEnemyPro("enemy.pro");
		readBombPro("bomb.pro");
		readStaticthingPro("staticthing.pro");
		try {
			createElement();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
