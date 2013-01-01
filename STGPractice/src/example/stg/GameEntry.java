package example.stg;

import javax.swing.SwingUtilities;

public class GameEntry {
	private static GameScreen screen;

	private static final class GameRun implements Runnable {
		private final Game game;

		private GameRun(Game game) {
			this.game = game;
		}

		@Override
		public void run() {
			while (true) {
				try {
					game.move();
					SwingUtilities.invokeAndWait(new Runnable() {
						@Override
						public void run() {
							screen.repaint();
						}
					});
					// TODO 1秒に60回実行されるよう適切にウェイトをかける
					Thread.sleep(16);

				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		final Game game = new Game();
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				screen = new GameScreen(game);
				screen.setVisible(true);
			}
		});

		Thread thread = new Thread(new GameRun(game));
		thread.run();

	}

}
