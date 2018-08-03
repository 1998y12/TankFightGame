package manager;

import java.util.ArrayList;
import java.util.List;

import element.Bullet;
import element.CommonWall;
import element.Home;
import element.MetalWall;
import element.Tank;
import element.Tree;
import element.bomb;
import gameUtil.CreateElementThread;

public class ElementManager {
	private static ElementManager elementManager = null;
	public Tank heroTank;
	public List<Tank> enemyTankList;
	public List<Bullet> heroTankBullet;
	public List<Bullet> enemyTankBullet;
	public List<CommonWall> homeWallList;
	public List<CommonWall> otherWallList;
	public List<MetalWall> metalWallList;
	public List<Tree> treeList;
	public List<bomb> bombList;
	public Home home ;// 实例化home	373, 545
	
	public CreateElementThread ceThread;
	
	
	private ElementManager() {
		enemyTankList = new ArrayList<Tank>();
		heroTankBullet = new ArrayList<Bullet>();
		enemyTankBullet = new ArrayList<Bullet>();
		homeWallList = new ArrayList<CommonWall>();
		otherWallList = new ArrayList<CommonWall>();
		metalWallList = new ArrayList<MetalWall>();
		treeList = new ArrayList<Tree>();
		bombList = new ArrayList<bomb>();
	}
	public static synchronized ElementManager getElementManager() {
		if(elementManager==null)
			elementManager = new ElementManager();
		return elementManager;
	}
	
	
	
	public Home getHome() {
		return home;
	}
	public void setHome(Home home) {
		this.home = home;
	}
	public CreateElementThread getCeThread() {
		return ceThread;
	}
	public void setCeThread(CreateElementThread ceThread) {
		this.ceThread = ceThread;
	}
	public Tank getHeroTank() {
		return heroTank;
	}
	public void setHeroTank(Tank heroTank) {
		this.heroTank = heroTank;
	}
	public List<Tank> getSoliderTankList() {
		return enemyTankList;
	}
	public void setSoliderTankList(List<Tank> soliderTankList) {
		this.enemyTankList = soliderTankList;
	}
	public List<Bullet> getHeroTankBullet() {
		return heroTankBullet;
	}
	public void setHeroTankBullet(List<Bullet> heroTankBullet) {
		this.heroTankBullet = heroTankBullet;
	}
	public List<Bullet> getEnemyTankBullet() {
		return enemyTankBullet;
	}
	public void setEnemyTankBullet(List<Bullet> soliderTankBullet) {
		this.enemyTankBullet = soliderTankBullet;
	}
	public List<CommonWall> getHomeWallList() {
		return homeWallList;
	}
	public void setHomeWallList(List<CommonWall> homeWallList) {
		this.homeWallList = homeWallList;
	}
	public List<CommonWall> getOtherWallList() {
		return otherWallList;
	}
	public void setOtherWallList(List<CommonWall> otherWallList) {
		this.otherWallList = otherWallList;
	}
	public List<MetalWall> getMetalWallList() {
		return metalWallList;
	}
	public void setMetalWallList(List<MetalWall> metalWallList) {
		this.metalWallList = metalWallList;
	}
	public List<Tree> getTreeList() {
		return treeList;
	}
	public void setTreeList(List<Tree> treeList) {
		this.treeList = treeList;
	}
	
	
}
