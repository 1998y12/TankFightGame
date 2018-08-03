package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


import gameUtil.CreateElementThread;
import gameUtil.GameStartUtil;
import manager.ElementManager;

public class MyJFrame extends JFrame implements ActionListener{
	
	public static JMenuBar setting = null;
	public static JMenu m1 = null , m2 = null, m3= null , m4 = null;
	public static JMenuItem m11 = null , m12 = null,  m21 = null, m22 = null, m31 = null, m41 = null, m42 = null, m43 = null, m44 = null;
	public static boolean HERO_LEFT = false;
	public static boolean HERO_RIGHT = false;
	public static boolean HERO_UP = false;
	public static boolean HERO_DOWN = false;
	
	public static final int KEY_UP = 38;
	public static final int KEY_DOWN = 40;
	public static final int KEY_LEFT = 37;
	public static final int KEY_RIGHT = 39;
	public static final int KEY_SHOOT = 70;
	
	public static boolean FLAG = true;
	
	
	public MyJFrame() {
		
		init();
		
	}
	
	public void init() {
		this.setSize(GameStartUtil.FrameWidth,GameStartUtil.FrameHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);	//居中
		this.setResizable(false);
		this.setVisible(true);
		createMenu();
		this.add(setting);
		this.setJMenuBar(setting);
		this.setVisible(true);
			
	}
	
	public void gameShow(JPanel jp) {
		
		this.add(jp);	
		this.setVisible(true);

		ElementManager.getElementManager().setCeThread(new CreateElementThread());
		ElementManager.getElementManager().getCeThread().start();
		
		if(jp instanceof Runnable) {
			new Thread((Runnable)jp).start();
			System.out.println("JPanel start");
		}
		
		new GameRunThread().start();
		
		
	}
	
	
	public void createMenu() {
		// 创建菜单及菜单选项
		System.out.println("Hello");
				setting = new JMenuBar();
				m1 = new JMenu("游戏");
				m2 = new JMenu("暂停/继续");
				m3 = new JMenu("帮助");
				m4 = new JMenu("游戏级别");
				m1.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
				m2.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
				m3.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体
				m4.setFont(new Font("TimesRoman", Font.BOLD, 15));// 设置菜单显示的字体

				m11 = new JMenuItem("开始新游戏");
				m12 = new JMenuItem("退出");
				m21 = new JMenuItem("暂停");
				m22 = new JMenuItem("继续");
				m31 = new JMenuItem("游戏说明");
				m41 = new JMenuItem("级别1");
				m42 = new JMenuItem("级别2");
				m43 = new JMenuItem("级别3");
				m44 = new JMenuItem("级别4");
				m11.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m12.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m21.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m22.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m31.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m41.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m42.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m43.setFont(new Font("TimesRoman", Font.BOLD, 15));
				m44.setFont(new Font("TimesRoman", Font.BOLD, 15));
				
				setting.add(m1);
				setting.add(m2);
				setting.add(m3);
				setting.add(m4);
				
				m1.add(m11); m1.add(m12);
				m2.add(m21); m2.add(m22);
				m3.add(m31);
				m4.add(m41); m4.add(m42);m4.add(m43); m4.add(m44);
				
				m11.addActionListener(this);
				m11.setActionCommand("NewGame");
				m12.addActionListener(this);
				m12.setActionCommand("Exit");
				m21.addActionListener(this);
				m21.setActionCommand("Pause");
				m22.addActionListener(this);
				m22.setActionCommand("Continue");
				m31.addActionListener(this);
				m31.setActionCommand("Help");
				m41.addActionListener(this);
				m41.setActionCommand("Level1");
				m42.addActionListener(this);
				m42.setActionCommand("Level2");
				m43.addActionListener(this);
				m43.setActionCommand("Level3");
				m44.addActionListener(this);
				m44.setActionCommand("Level4");
				
	}
	
	public void setKeyListener() {
		this.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
//				switch(e.getKeyCode()) {
//				case KEY_UP:
//					HERO_UP = true;
//					break;
//				case KEY_DOWN:
//					HERO_DOWN = true;
//					break;
//				case KEY_LEFT:
//					HERO_LEFT = true;
//					break;
//				case KEY_RIGHT:
//					HERO_RIGHT = true;
//					break;
//				case KEY_SHOOT:
//					ElementManager.getElementManager().getCeThread().addHeroBulletToList();
//					break;
//				default:
//					
//					break;
//				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()) {
				case KEY_UP:
					HERO_UP = false;
					break;
				case KEY_DOWN:
					HERO_DOWN = false;
					break;
				case KEY_LEFT:
					HERO_LEFT = false;
					break;
				case KEY_RIGHT:
					HERO_RIGHT = false;
					break;
				default:
					
					break;
				}
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				switch(e.getKeyCode()) {
				case KEY_UP:
					HERO_UP = true;
					break;
				case KEY_DOWN:
					HERO_DOWN = true;
					break;
				case KEY_LEFT:
					HERO_LEFT = true;
					break;
				case KEY_RIGHT:
					HERO_RIGHT = true;
					break;
				case KEY_SHOOT:
	//				System.out.println("press");
					ElementManager.getElementManager().getCeThread().addHeroBulletToList();
					break;
				default:
					
					break;
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("NewGame")) {
			FLAG = false;
			Object[] options = {	"确定" , "取消"};
			int response = JOptionPane.showOptionDialog
					(this, "开始新游戏？", "提示", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if(response==0) {
				
				ElementManager.getElementManager().ceThread = null;
				ElementManager.getElementManager().enemyTankBullet.clear();
				ElementManager.getElementManager().enemyTankList.clear();
				ElementManager.getElementManager().heroTank = null;
				ElementManager.getElementManager().heroTankBullet.clear();
				ElementManager.getElementManager().home = null;
				ElementManager.getElementManager().homeWallList.clear();
				ElementManager.getElementManager().metalWallList.clear();
				ElementManager.getElementManager().otherWallList.clear();
				ElementManager.getElementManager().treeList.clear();
				
				MyJPanel.SUCCESSFLAG = false;
				MyJPanel.FAILFLAG =false;
				FLAG = true;
				
				ElementManager.getElementManager().setCeThread(new CreateElementThread());
				ElementManager.getElementManager().getCeThread().start();
				
				
			}else {
				FLAG = true;
			}
		}
		else if(e.getActionCommand().equals("Exit")) {
			FLAG = false;
			Object[] options = { "确定", "取消" };
			int response = JOptionPane.showOptionDialog(this, "您确认要退出吗", "",
					JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE, null,
					options, options[0]);
			if (response == 0) {
				//System.out.println("退出");
				System.exit(0);
			} else {
				FLAG = true;
				new Thread((Runnable)new MyJPanel()).start();

			}
		}
		else if(e.getActionCommand().equals("Pause")) {
			FLAG = false;
		}
		else if(e.getActionCommand().equals("Continue")) {
			if(!FLAG) {
				FLAG = true;
				//new Thread((Runnable)new MyJPanel()).start();
			}
		}
		else if(e.getActionCommand().equals("Help")) {
			FLAG = false;
			JOptionPane.showMessageDialog(null, "用  ↑  ↓  ←  →  控制方向，F键开火！",
					"提示！", JOptionPane.INFORMATION_MESSAGE);
			this.setVisible(true);
			FLAG = true;
			new Thread((Runnable)new MyJPanel()).start();
		}
		else if(e.getActionCommand().equals("Level1")) {
			
		}
		else if(e.getActionCommand().equals("Level2")) {
			
		}
		else if(e.getActionCommand().equals("Level3")) {
			
		}
		else if(e.getActionCommand().equals("Level4")) {
			
		}
	}
	



}
