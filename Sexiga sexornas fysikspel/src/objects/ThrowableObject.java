package objects;

import java.awt.Graphics2D;

import entityfunctions.Vector;
import resources.ImageStore;

public class ThrowableObject {

	private ImageStore image;
	private Vector position;
	private float objWidth;
	private float objHeigth;
	private float objAngle;
	
	public ThrowableObject() {
		image = ImageStore.THROWOBJECT;
		objWidth = 80;
		objHeigth = 80;
		objAngle = 0;
		position = new Vector(80, 500);
		
	}
	
	public void render(Graphics2D g) {
		image.draw(g, position.getX(), position.getY(), objWidth, objHeigth, objAngle);
	}
	
	public void update(float delta) {

		objAngle = objAngle + 10;
	}
}
