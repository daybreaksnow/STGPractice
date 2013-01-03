package example.stg;

import java.awt.Graphics;
import java.awt.Image;

public abstract class GameObject {
	protected int x;
	protected int y;
	private Image image;
	protected int w;
	protected int h;

	public GameObject(Image image) {
		this.image = image;
		this.w = image.getWidth(null);
		this.h = image.getHeight(null);
	}

	public abstract void move();

	public void draw(Graphics g) {
		g.drawImage(image, x, y, null);
	}
}
