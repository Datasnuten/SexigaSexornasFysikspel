package resources;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum ImageStore {
	 
	BACKGROUND("imgs/Background.png"),
	THROWOBJECT("imgs/bulle.png");
	
	private final String ref;
	private BufferedImage img;
	
	private ImageStore(String ref) {
		this.ref = ref;
		try {
			this.img = ImageIO.read(new File(ref));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g, float x, float y, float w, float h, double angle) {
//		g.translate(x, y);
		g.rotate(Math.toRadians(angle), x+(w/2), y+(h/2));
		g.drawImage(img, (int)x, (int)y, null);
//		g.rotate(-angle);
//		g.translate(-x, -y);
	}
}