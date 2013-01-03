package example.stg;

import java.awt.event.KeyEvent;

public enum Key {
	/** ショット */
	SHOT(KeyEvent.VK_Z),
	/** 決定 */
	DECIDE(KeyEvent.VK_Z),
	/** ボム */
	BOMB(KeyEvent.VK_X),
	/** キャンセル */
	CANCEL(KeyEvent.VK_X),
	/** ゲーム終了 */
	ESC(KeyEvent.VK_ESCAPE),
	/** 上移動 */
	UP(KeyEvent.VK_UP),
	/** 下移動 */
	DOWN(KeyEvent.VK_DOWN),
	/** 右移動 */
	RIGHT(KeyEvent.VK_RIGHT),
	/** 左移動 */
	LEFT(KeyEvent.VK_LEFT);

	/** AWTで対応するキーコード */
	private int keyCode;

	private Key(int keyCode) {
		this.keyCode = keyCode;
	}

	public int getKeyCode() {
		return keyCode;
	}
}
