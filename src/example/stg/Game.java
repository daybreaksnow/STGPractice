package example.stg;

import java.awt.Graphics;

public class Game {

	private Player player;

	public Game() {
		ImageManager imageManager = ImageManager.getInstance();
		imageManager.load("player");
		player = new Player(imageManager.get("player"));
	}

	public void move() {
		// TODO プレイヤーの移動、敵の生成、衝突判定など
		KeyManager.getInstance().update();
		player.move();
	}

	public void draw(Graphics g) {
		// TODO 画面のクリア、オブジェクトの描画
		player.draw(g);
	}

	public int getWidth() {
		return 640;
	}

	public int getHeight() {
		return 480;
	}
}
