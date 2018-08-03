package game;

public class TankFightStart {

	public static MyJFrame mj;
	public static void main(String[] args) {
		mj = new MyJFrame();
		mj.gameShow(new MyJPanel());
		mj.setKeyListener();
	}
}
//enemy20=322:190
//enemy12=545:82
//enemy7=642:530
//enemy3=12:525