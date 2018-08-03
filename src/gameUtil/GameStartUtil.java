package gameUtil;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GameStartUtil {
	public static final int FrameWidth = 800;
	public static final int FrameHeight = 645;
	public static final int FrameSleep = 45;
	public static  Image screenImage = null;
	
	public static Properties getProperties(String url) {
		InputStream in = GameStartUtil.class.getResourceAsStream(url);
		Properties ps = new Properties();
		try {
			ps.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
	
}
