package example.stg;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * AWTに依存したキー入力受付クラス。
 */
public class KeyHolder extends KeyAdapter {
	private Set<Integer> keyPressed = new LinkedHashSet<Integer>();

	public boolean isPressed(int keyCode) {
		return keyPressed.contains(keyCode);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keyPressed.add(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keyPressed.remove(e.getKeyCode());
	}

	public boolean isKeyPressed(int keyCode) {
		return keyPressed.contains(keyCode);
	}

	public Collection<? extends Integer> getKeyPressed() {
		return keyPressed;
	}
}
