package example.stg.log;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * ゲーム用ウィンドウクラス。ウィンドウを作成するだけ。
 */
public class EmptyGameScreen extends JFrame {

    public EmptyGameScreen() {
        // ウィンドウクローズ時にシャットダウンする
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // タイトルバーの文字列設定
        setTitle("STGサンプル");

        // 描画領域のサイズ
        Dimension screenSize = new Dimension(640, 480);

        // 画面のオフセットサイズを確定させる
        // 描画前だとpackを呼ばないとタイトル部などのオフセットサイズが取得できない
        pack();

        // オフセットを加味したウィンドウサイズを計算
        Dimension frameSize = getFrameSize(this, screenSize);

        // ウィンドウサイズを設定
        setSize(frameSize);

        // 画面中央にウィンドウを配置
        setLocationRelativeTo(null);

        // 描画用パネル配置
        setContentPane(new JPanel());
    }

    // タイトルバーなどの長さを考慮して、描画領域が指定したサイズになるようなウィンドウサイズを返します
    private Dimension getFrameSize(JFrame frame, Dimension screenSize) {
        Dimension frameSize = new Dimension(screenSize.width
                + frame.getInsets().left + frame.getInsets().right,
                screenSize.height + frame.getInsets().top
                        + frame.getInsets().bottom);
        return frameSize;
    }

    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                EmptyGameScreen screen = new EmptyGameScreen();
                screen.setVisible(true);
            }
        });
    }
}
