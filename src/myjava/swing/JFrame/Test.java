package myjava.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	public static void main(String[] args) {
		// 建立顶级容器JFrame
		JFrame jFrame = new JFrame("my jframe");
		// 建立中间级容器JPanel
		JPanel jPanel = new JPanel();
		// 创建按钮
		JButton jButton = new JButton("press me");
		BorderLayout borderLayout = new BorderLayout();
		jPanel.setLayout(borderLayout);
		jPanel.add(jButton, BorderLayout.CENTER);
		jFrame.add(jPanel);
		jFrame.setVisible(true);
	}
}
