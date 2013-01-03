package example.stg;

import java.awt.Image;

public class Player extends GameObject {

	public Player(Image image) {
		super(image);
	}

	@Override
	public void move() {
		KeyManager key = KeyManager.getInstance();
		if (key.isKeyPressed(Key.LEFT)) {
			x--;
		}
		if (key.isKeyPressed(Key.RIGHT)) {
			x++;
		}
		if (key.isKeyPressed(Key.UP)) {
			y--;
		}
		if (key.isKeyPressed(Key.DOWN)) {
			y++;
		}
	}

}
