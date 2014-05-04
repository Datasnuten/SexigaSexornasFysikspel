package entityfunctions;

public class Vector {

	private float x;
	private float y;

	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float imageCenterX(float x, float picWidth) {
		return x + (picWidth / 2);
	}

	public float imageCenterY(float y, float picHeigth) {
		return y + (picHeigth / 2);
	}

	public float length() {
		return (float) Math.sqrt(getX() * getX() + getY() * getY());
	}

	public void normalize() {
		float f = length();
		if (f != 0) {
			f = 1 / f;
		}
		setX(getX() * f);
		setY(getY() * f);
	}

	public void multBy(float f) {
		setX(getX() * f);
		setY(getY() * f);
	}
}
