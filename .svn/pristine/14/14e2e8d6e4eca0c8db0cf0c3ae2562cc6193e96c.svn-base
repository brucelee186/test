package myjava.awt.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * 将容器中的组件,按水平排成一行,或按垂直方向排成一列
 */
public class TestBox {
	private JFrame jFrame;
	private Box bv, bh;
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	
	public void test() {
		jFrame = new JFrame();
		Container container = jFrame.getContentPane();
		bv = Box.createVerticalBox();
		bv.add(new JLabel("Monday"));
		bv.add(new JLabel("Tuesday"));
		bv.add(new JLabel("Wednesday"));
		bv.add(new JLabel("Thursday"));
		bv.add(new JLabel("Friday"));
		bv.add(new JLabel("Saturday"));
		bv.add(new JLabel("Sunday"));
		container.add(bv, BorderLayout.CENTER);
		
		bh = Box.createHorizontalBox();
		bh.add(new JButton("yes"));
		bh.add(new JButton("no"));
		bh.add(new JButton("cancel"));
		container.add(bh, BorderLayout.SOUTH);
		
		jFrame.setSize(500, 600);
		jFrame.setVisible(true);
	}
}
