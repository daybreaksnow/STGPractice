package example.stg;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ゲーム用ウィンドウクラス
 */
public class GameScreen extends JFrame {

	public GameScreen(final Game game) {
		// ウィンドウクローズ時にシャットダウンする
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// タイトルバーの文字列設定
		setTitle("STGサンプル");

		// 描画領域のサイズ
		Dimension screenSize = new Dimension(game.getWidth(), game.getHeight());

		// 画面のオフセットサイズを確定させる
		// 描画前だとpackを呼ばないとタイトル部などのオフセットサイズが取得できない
		pack();

		// オフセットを加味したウィンドウサイズを計算
		Dimension frameSize = getFrameSize(this, screenSize);

		// ウィンドウサイズを設定
		setSize(frameSize);

		// 画面中央にウィンドウを配置
		setLocationRelativeTo(null);

		// ゲーム描画用パネル配置
		setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// paintComponentsではないので注意
				super.paintComponent(g);
				// 描画を任せる
				game.draw(g);
			}

		});

		// キー入力取得アダプタ追加
		KeyHolder keyListener = new KeyHolder();
		KeyManager.getInstance().setKeyHolder(keyListener);
		this.addKeyListener(keyListener);
	}

	// タイトルバーなどの長さを考慮して、描画領域が指定したサイズになるようなウィンドウサイズを返します
	private Dimension getFrameSize(JFrame frame, Dimension screenSize) {
		Dimension frameSize = new Dimension(screenSize.width
				+ frame.getInsets().left + frame.getInsets().right,
				screenSize.height + frame.getInsets().top
						+ frame.getInsets().bottom);
		return frameSize;
	}
}
