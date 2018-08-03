package game;

import java.util.List;

import element.BasicElement;
import gameUtil.GameStartUtil;
import manager.ElementManager;

public class GameRunThread extends Thread{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(GameStartUtil.FrameSleep);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(MyJFrame.FLAG)
			{
				tankMove();
				enemyTankAttack();
				bulletListMove();
				elementCollide();
				outOfBound();
				elementRemove();
				checkGame();
			}
			
		}
	}

	private void checkGame() {
		// TODO Auto-generated method stub
		if(ElementManager.getElementManager().treeList.size()==0)
			return ;
		if(ElementManager.getElementManager().heroTank.life<=0 || !ElementManager.getElementManager().home.isExist)
		{
			MyJPanel.FAILFLAG = true;
			ElementManager.getElementManager().enemyTankBullet.clear();
			ElementManager.getElementManager().enemyTankList.clear();
			ElementManager.getElementManager().heroTankBullet.clear();
			ElementManager.getElementManager().otherWallList.clear();
			ElementManager.getElementManager().homeWallList.clear();
			ElementManager.getElementManager().metalWallList.clear();
			
		}
		else if(ElementManager.getElementManager().heroTank.life>=0 && ElementManager.getElementManager().enemyTankList.isEmpty() && ElementManager.getElementManager().home.isExist)
		{
			MyJPanel.SUCCESSFLAG = true;
			ElementManager.getElementManager().enemyTankBullet.clear();
			ElementManager.getElementManager().enemyTankList.clear();
			ElementManager.getElementManager().heroTankBullet.clear();
			ElementManager.getElementManager().otherWallList.clear();
			ElementManager.getElementManager().homeWallList.clear();
			ElementManager.getElementManager().metalWallList.clear();
		}
	}

	private void tankMove() {
		enemyTankMove();
		heroTankMove();
	}
	
	private void enemyTankAttack() {
		// TODO Auto-generated method stub
	
		if(ElementManager.getElementManager().treeList.size()==0)
			return ;
		
		for(int i = 0;i<ElementManager.getElementManager().enemyTankList.size();i++) {
			
			int num = ElementManager.getElementManager().enemyTankList.get(i).getRandom();
			if(num > 45)
			{
				ElementManager.getElementManager().getCeThread().addEnemyBulletToList(ElementManager.getElementManager().enemyTankList.get(i));
	
			}
			
		}
	}

	
	
	private void elementCollide() {
		// TODO Auto-generated method stub
	
//		System.out.println("Collide");
		
			
		
		for(int i = 0;i<ElementManager.getElementManager().enemyTankList.size();i++) {
			
			if( ElementManager.getElementManager().heroTank!=null && ElementManager.getElementManager().heroTank.bang(ElementManager.getElementManager().enemyTankList.get(i)))
			{
				ElementManager.getElementManager().enemyTankList.get(i).backBackBack();
				ElementManager.getElementManager().heroTank.backBackBack();
			}
			
			for(int j = 0;j<ElementManager.getElementManager().otherWallList.size();j++) {
				
				if(ElementManager.getElementManager().enemyTankList.get(i).bang(ElementManager.getElementManager().otherWallList.get(j)))
					ElementManager.getElementManager().enemyTankList.get(i).backBackBack();
				if(ElementManager.getElementManager().heroTank.bang(ElementManager.getElementManager().otherWallList.get(j)))
				{
					System.out.println("herotank 撞到了！！！");
					ElementManager.getElementManager().heroTank.backBackBack();
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().homeWallList.size();j++) {
				
				if(ElementManager.getElementManager().enemyTankList.get(i).bang(ElementManager.getElementManager().homeWallList.get(j)))
					ElementManager.getElementManager().enemyTankList.get(i).backBackBack();
				
				if(ElementManager.getElementManager().heroTank.bang(ElementManager.getElementManager().homeWallList.get(j)))
				{
					System.out.println("herotank 撞到了！！！");
					ElementManager.getElementManager().heroTank.backBackBack();
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().metalWallList.size();j++) {
				if(ElementManager.getElementManager().enemyTankList.get(i).bang(ElementManager.getElementManager().metalWallList.get(j)))
					ElementManager.getElementManager().enemyTankList.get(i).backBackBack();
				if(ElementManager.getElementManager().heroTank.bang(ElementManager.getElementManager().metalWallList.get(j)))
				{
					System.out.println("herotank 撞到了！！！");
					ElementManager.getElementManager().heroTank.backBackBack();
				}
			}
			
						
			for(int j = 0;j<ElementManager.getElementManager().enemyTankList.size();j++) {
				if(i!=j && (ElementManager.getElementManager().enemyTankList.get(i).bang(ElementManager.getElementManager().enemyTankList.get(j))) )
				{
					ElementManager.getElementManager().enemyTankList.get(i).backBackBack();
					ElementManager.getElementManager().enemyTankList.get(j).backBackBack();
				}
			}		
			
		}
		
		
		
		
		for(int i = 0;i<ElementManager.getElementManager().heroTankBullet.size();i++) {

			if(ElementManager.getElementManager().home!=null && ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().home))
			{
				ElementManager.getElementManager().home.isExist = false;
				System.out.println("home hit!");
				break;
			}
			for(int j = 0;j<ElementManager.getElementManager().otherWallList.size();j++) {
				if(ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().otherWallList.get(j))) {
					ElementManager.getElementManager().heroTankBullet.get(i).isExist = false;
					ElementManager.getElementManager().otherWallList.get(j).isExist = false;
					break;
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().homeWallList.size();j++) {
				if(ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().homeWallList.get(j))) {
					ElementManager.getElementManager().heroTankBullet.get(i).isExist = false;
					ElementManager.getElementManager().homeWallList.get(j).isExist = false;
					break;
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().metalWallList.size();j++) {
				if(ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().metalWallList.get(j))) {
					ElementManager.getElementManager().heroTankBullet.get(i).isExist = false;
					break;
					
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().treeList.size();j++) {
				if(ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().treeList.get(j))) {
					ElementManager.getElementManager().heroTankBullet.get(i).isExist = false;
					break;
					
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().enemyTankList.size();j++) {
				if(ElementManager.getElementManager().heroTankBullet.get(i).bang(ElementManager.getElementManager().enemyTankList.get(j))) {
					ElementManager.getElementManager().getCeThread().addBomb(ElementManager.getElementManager().enemyTankList.get(j));
					ElementManager.getElementManager().heroTankBullet.get(i).isExist = false;
					ElementManager.getElementManager().enemyTankList.get(j).isExist = false;
					break;
				}
			}
		}
		
		
		
		
		for(int i = 0;i<ElementManager.getElementManager().getEnemyTankBullet().size();i++) {
			
			if(ElementManager.getElementManager().home!=null && ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().home))
			{
				ElementManager.getElementManager().home.isExist = false;
				System.out.println("home hit!");
				break;
			}
			
			for(int j = 0;j<ElementManager.getElementManager().otherWallList.size();j++) {
				if(ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().otherWallList.get(j))) {
					ElementManager.getElementManager().enemyTankBullet.get(i).isExist = false;
					ElementManager.getElementManager().otherWallList.get(j).isExist = false;
					break;
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().homeWallList.size();j++) {
				if(ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().homeWallList.get(j))) {
					ElementManager.getElementManager().enemyTankBullet.get(i).isExist = false;
					ElementManager.getElementManager().homeWallList.get(j).isExist = false;
					break;
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().metalWallList.size();j++) {
				if(ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().metalWallList.get(j))) {
					ElementManager.getElementManager().enemyTankBullet.get(i).isExist = false;
					break;
					
				}
			}
			
			for(int j = 0;j<ElementManager.getElementManager().treeList.size();j++) {
				if(ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().treeList.get(j))) {
					ElementManager.getElementManager().enemyTankBullet.get(i).isExist = false;
					break;
					
				}
			}
			
			if(ElementManager.getElementManager().heroTank!=null && ElementManager.getElementManager().enemyTankBullet.get(i).bang(ElementManager.getElementManager().heroTank)) {
				ElementManager.getElementManager().getCeThread().addBomb(ElementManager.getElementManager().heroTank);
				ElementManager.getElementManager().enemyTankBullet.get(i).isExist = false;
				ElementManager.getElementManager().heroTank.setLife(ElementManager.getElementManager().heroTank.life-20);
				
			}
			
			
		}
		
		
	}

	private void enemyTankMove() {
		// TODO Auto-generated method stub
		if(ElementManager.getElementManager().treeList.size()==0)
			return ;
		for(int i = 0;i<ElementManager.getElementManager().enemyTankList.size();i++) {
			if(ElementManager.getElementManager().enemyTankList.get(i).isExist)
				ElementManager.getElementManager().enemyTankList.get(i).move();;
		}
	}

	private void heroTankMove() {
		// TODO Auto-generated method stub
		
//		
		if(MyJFrame.HERO_UP) {
			ElementManager.getElementManager().heroTank.setDir("U");
			ElementManager.getElementManager().heroTank.move();
			
		}
		else if(MyJFrame.HERO_DOWN) {
			ElementManager.getElementManager().heroTank.setDir("D");
			ElementManager.getElementManager().heroTank.move();
			
		}
		else if(MyJFrame.HERO_LEFT) {
			ElementManager.getElementManager().heroTank.setDir("L");
			ElementManager.getElementManager().heroTank.move();
			
		}
		else if(MyJFrame.HERO_RIGHT) {
			ElementManager.getElementManager().heroTank.setDir("R");
			ElementManager.getElementManager().heroTank.move();
			
		}
		
	}
	
	private void bulletListMove() {
		
		for(int i = 0;i<ElementManager.getElementManager().getEnemyTankBullet().size();i++) {
			if(ElementManager.getElementManager().getEnemyTankBullet().get(i).isExist)
				ElementManager.getElementManager().getEnemyTankBullet().get(i).move();
		}
		
		for(int i = 0;i<ElementManager.getElementManager().getHeroTankBullet().size();i++) {
			if(ElementManager.getElementManager().getHeroTankBullet().get(i).isExist)
				ElementManager.getElementManager().getHeroTankBullet().get(i).move();
		}
	}

	private void outOfBound() {
		for(int i = 0;i<ElementManager.getElementManager().getEnemyTankBullet().size();i++) {
			if(ElementManager.getElementManager().getEnemyTankBullet().get(i).outOfBounds())
				ElementManager.getElementManager().getEnemyTankBullet().get(i).isExist = false;
		}
		
		for(int i = 0;i<ElementManager.getElementManager().getHeroTankBullet().size();i++) {
			if(ElementManager.getElementManager().getHeroTankBullet().get(i).outOfBounds())
				ElementManager.getElementManager().getHeroTankBullet().get(i).isExist = false;
		}
	}
	
	private void elementRemove() {
		//removeList(ElementManager.getElementManager().enemyTankBullet);
		for(int i = 0;i<ElementManager.getElementManager().enemyTankBullet.size();i++) {
			if(!ElementManager.getElementManager().enemyTankBullet.get(i).isExist)
				ElementManager.getElementManager().enemyTankBullet.remove(i--);
		}
		
		for(int i = 0;i<ElementManager.getElementManager().heroTankBullet.size();i++) {
			if(!ElementManager.getElementManager().heroTankBullet.get(i).isExist)
				ElementManager.getElementManager().heroTankBullet.remove(i--);
		}
		
		for(int i = 0;i<ElementManager.getElementManager().otherWallList.size();i++) {
			if(!ElementManager.getElementManager().otherWallList.get(i).isExist)
				ElementManager.getElementManager().otherWallList.remove(i--);
		}
		
		for(int i = 0;i<ElementManager.getElementManager().homeWallList.size();i++) {
			if(!ElementManager.getElementManager().homeWallList.get(i).isExist)
				ElementManager.getElementManager().homeWallList.remove(i--);
		}
		
		for(int i = 0;i<ElementManager.getElementManager().enemyTankList.size();i++) {
			if(!ElementManager.getElementManager().enemyTankList.get(i).isExist)
				ElementManager.getElementManager().enemyTankList.remove(i--);
		}
		
		for(int i = 0;i<ElementManager.getElementManager().bombList.size();i++) {
			if(!ElementManager.getElementManager().bombList.get(i).isExist)
				ElementManager.getElementManager().bombList.remove(i--);
		}
		
//		removeList(ElementManager.getElementManager().enemyTankList);
//		removeList(ElementManager.getElementManager().heroTankBullet);
//		removeList(ElementManager.getElementManager().homeWallList);
//		removeList(ElementManager.getElementManager().otherWallList);
//		removeList(ElementManager.getElementManager().treeList);
	}
	
	private void removeList(List<?extends BasicElement> list) {
		for(int i = 0;i<list.size();i++) {
			if(!list.get(i).isExist)
				list.remove(i--);
		}
	}

}
