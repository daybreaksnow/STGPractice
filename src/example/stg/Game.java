package example.stg;

import java.awt.Graphics;

public class Game {

	public void move() {
		// TODO プレイヤーの移動、敵の生成、衝突判定など
		KeyManager.getInstance().update();
		if (KeyManager.getInstance().isKeyPressed(Key.SHOT)) {
			System.out.println("shot key pressed");
		}
		if (KeyManager.getInstance().isKeyPressedNow(Key.SHOT)) {
			System.out.println("shot key pressed now");
		}
		// System.out.println("move");
	}

	public void draw(Graphics g) {
		// TODO 画面のクリア、オブジェクトの描画
		// System.out.println("draw");
	}

	public int getWidth() {
		return 640;
	}

	public int getHeight() {
		return 480;
	}
}
