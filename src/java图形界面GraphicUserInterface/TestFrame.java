package java图形界面GraphicUserInterface;

/**
 * TestFrame.java
 * @author Fancy
 */
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TestFrame extends JFrame {

	private int counter = 0;

	public TestFrame() {
		/* 使用匿名类添加一个窗口监听器 */
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("Exit when Closed event");
				System.exit(0); // 退出应用程序
			}

			public void windowActivated(WindowEvent e) {
				setTitle("Test Frame " + counter++); // 改变窗口标题
			}
		});

		setResizable(false); // 设置窗口为固定大小
		setSize(200, 150);
	}

	public static void main(String[] args) {
		TestFrame tf = new TestFrame();
		tf.show();
	}

}