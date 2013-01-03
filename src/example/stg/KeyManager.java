package example.stg;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * キー入力を管理します。
 */
public class KeyManager {
	private static KeyManager instance;

	private Set<Integer> prevKeyPressed = new LinkedHashSet<Integer>();
	private Set<Integer> keyPressed = new LinkedHashSet<Integer>();

	private KeyHolder holder;

	private KeyManager() {
	}

	public static KeyManager getInstance() {
		if (instance == null) {
			synchronized (KeyManager.class) {
				if (instance == null) {
					instance = new KeyManager();
				}
			}
		}
		return instance;
	}

	public void setKeyHolder(KeyHolder holder) {
		this.holder = holder;
	}

	public boolean isKeyPressed(Key key) {
		return keyPressed.contains(key.getKeyCode());
	}

	public boolean isKeyPressedNow(Key key) {
		int keyCode = key.getKeyCode();
		return !prevKeyPressed.contains(keyCode)
				&& keyPressed.contains(keyCode);
	}

	public void update() {
		prevKeyPressed.clear();
		prevKeyPressed.addAll(keyPressed);
		keyPressed.clear();
		if (holder != null) {
			keyPressed.addAll(holder.getKeyPressed());
		}
	}
}
