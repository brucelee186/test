package myjava.awt.BorderLayout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		t.testBoderLayLayout();
	}
	
	public void testBoderLayLayout() {
		JButton be, bw, bn, bs, bc;
		JFrame jFrame = new JFrame();
		Container container = jFrame.getContentPane();
		container.setLayout(new BorderLayout());
		be = new JButton("east");
		bw = new JButton("west");
		bn = new JButton("north");
		bs = new JButton("south");
		bc = new JButton("center");
		container.add(be, BorderLayout.EAST);
		container.add(bw, BorderLayout.WEST);
		container.add(bn, BorderLayout.NORTH);
		container.add(bs, BorderLayout.SOUTH);
		container.add(bc, BorderLayout.CENTER);
		jFrame.setSize(350, 200);
		jFrame.setVisible(true);
	}
}
