package myjava.awt.BoxLayout;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestNullLayout {
	public static void main(String[] args) {
		JButton b1, b2, b3;
		JFrame frame = new JFrame();
		Container container = frame.getContentPane();
		container.setLayout(null);
		b1 = new JButton("yes");
		container.add(b1);
		b2 = new JButton("no");
		container.add(b2);
		b3 = new JButton("cancel");
		container.add(b3);
		
		b1.setBounds(10, 15, 50, 22);
		b2.setBounds(32, 98, 80, 92);
		b3.setBounds(70, 35, 90, 12);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}
