package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import element.Bullet;
import element.Tank;
import gameUtil.GameStartUtil;
import manager.ElementManager;

public class MyJPanel extends JPanel implements Runnable{

	public static boolean SUCCESSFLAG = false;
	public static boolean FAILFLAG = false;
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
//		System.out.println("paint");
		paintBG(g);
		paintOthers(g);
		
		if(SUCCESSFLAG)
		{
			Font f = g.getFont();
			g.setFont(new Font("TimesRoman",Font.BOLD,60));
			g.drawString("YOU   WIN !", 220, 300);
		}
		else if(FAILFLAG) {
			Font f = g.getFont();
			g.setFont(new Font("TimesRoman",Font.BOLD,60));
			g.drawString("YOU   LOSE !", 220, 300);
		}
	}
	
	public void paintBG(Graphics g) {
		GameStartUtil.screenImage = this.createImage(GameStartUtil.FrameWidth, GameStartUtil.FrameHeight);
		Graphics gg = GameStartUtil.screenImage.getGraphics();
		Color c = gg.getColor();
		gg.setColor(Color.GRAY);
		gg.fillRect(0, 0, GameStartUtil.FrameWidth, GameStartUtil.FrameHeight);
		gg.setColor(c);
		paintOthers(gg);
		g.drawImage(GameStartUtil.screenImage, 0, 0, null);
	}
	
	public void paintOthers(Graphics g) {
		// TODO Auto-generated method stub
		Color c = g.getColor();
		g.setColor(Color.RED);
		
		g.setFont(new Font("TimesRoman", Font.BOLD, 20));
		g.drawString("剩余生命值: ", 580, 32);
		g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		g.drawString("" + ElementManager.getElementManager().heroTank.getLife(), 715, 35);
		
//		if(ElementManager.getElementManager().soliderTankList.isEmpty() && ElementManager.getElementManager().heroTank.isExist && ElementManager.getElementManager().home.isExist) {
//			g.setFont(new Font("TimesRoman", Font.ITALIC, 30));
//			g.drawString("You win ! ",310,300);
//		}
		
		heroShow(g);
		
		treeShow(g);
//		
//		riverShow(g);
//		
		homeShow(g);
		
		homewallShow(g);
		
		otherWallShow(g);
		
		metalWallShow(g);
		
		showEnemyList(ElementManager.getElementManager().enemyTankList,g);
		
		showBulletList(ElementManager.getElementManager().heroTankBullet,g);
		
		showBulletList(ElementManager.getElementManager().enemyTankBullet,g);
//		
		bombShow(g);
		
	}


	private void bombShow(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<ElementManager.getElementManager().bombList.size();i++)
			ElementManager.getElementManager().bombList.get(i).draw(g);
	}

	private void showEnemyList(List<Tank> enemyTankList, Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<enemyTankList.size();i++) {
			enemyTankList.get(i).draw(g);
		}
	}

	private void treeShow(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<ElementManager.getElementManager().getTreeList().size();i++) {
			ElementManager.getElementManager().getTreeList().get(i).draw(g);
		}
	}

	private void metalWallShow(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<ElementManager.getElementManager().getMetalWallList().size();i++) {
			ElementManager.getElementManager().getMetalWallList().get(i).draw(g);
		}
	}

	private void otherWallShow(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<ElementManager.getElementManager().getOtherWallList().size();i++) {
			ElementManager.getElementManager().getOtherWallList().get(i).draw(g);
		}
	}

	private void homewallShow(Graphics g) {
		// TODO Auto-generated method stub
		for(int i = 0;i<ElementManager.getElementManager().getHomeWallList().size();i++) {
			ElementManager.getElementManager().getHomeWallList().get(i).draw(g);
		}
	}

	private void homeShow(Graphics g) {
		// TODO Auto-generated method stub
		ElementManager.getElementManager().home.draw(g);
	}

	private void showBulletList(List<Bullet> list, Graphics g) {
		// TODO Auto-generated method stub
//		System.out.println(heroTankBullet.size());
		for(int i = 0;i<list.size();i++) {
			list.get(i).draw(g);
		}
	}

	public void heroShow(Graphics g) {
		// TODO Auto-generated method stub
		ElementManager.getElementManager().heroTank.draw(g);
//		System.out.println(ElementManager.getElementManager().heroTank.getX()+","+ElementManager.getElementManager().heroTank.getY());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			if(MyJFrame.FLAG)
				repaint();
			try {
				Thread.sleep(GameStartUtil.FrameSleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
