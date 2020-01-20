package myjava.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	public static void main(String[] args) {
		// JFrame - Container - JPanel - JButton
		JFrame jFrame = new JFrame("my jframe");
		Container container = jFrame.getContentPane();
		container.setBackground(Color.BLUE);
		JPanel jPanel = new JPanel();
		jPanel.setBackground(Color.yellow);
		JButton jButton = new JButton("press me");
		jPanel.add(jButton);
		//container.add()代替了jframe.add(jpanel);
		container.add(jPanel, BorderLayout.SOUTH);
		// 有container对象之后就不会jfarme.add(jPanel)了
		jFrame.setSize(200, 300);
		jFrame.setVisible(true);
	}
}
