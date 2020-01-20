package myjava.awt.BoxLayout;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestCreateHorizontalBox {
	private JFrame frame;
	private Box b1, b2, b3, b4;
	public static void main(String[] args) {
		TestCreateHorizontalBox testCreateHorizontalBox = new TestCreateHorizontalBox();
		testCreateHorizontalBox.test();
	}
	
	public void test() {
		frame = new JFrame();
		Container container = frame.getContentPane();
		container.setLayout(new GridLayout(4, 1));
		
		b1 = Box.createHorizontalBox();
		b1.add(new JLabel("Box 1:"));
		b1.add(new JButton("Yes"));
		b1.add(new JButton("No"));
		b1.add(new JButton("Cancel"));
		
		b2 = Box.createHorizontalBox();
		b2.add(new JLabel("Box 2:"));
		b2.add(new JButton("Yes"));
		b2.add(new JButton("No"));
		b2.add(Box.createHorizontalGlue());
		b2.add(new JButton("Cancel"));
		
		b3 = Box.createHorizontalBox();
		b3.add(new JLabel("Box 3:"));
		b3.add(new JButton("Yes"));
		b3.add(new JButton("No"));
		b3.add(Box.createHorizontalStrut(20));
		b3.add(new JButton("Cancel"));
		
		b4 = Box.createHorizontalBox();
		b4.add(new JLabel("Box 4:"));
		b4.add(new JButton("Yes"));
		b4.add(new JButton("No"));
		b1.add(Box.createRigidArea(new Dimension(10, 10)));
		b4.add(new JButton("Cancel"));
		
		container.add(b1);
		container.add(b2);
		container.add(b3);
		container.add(b4);
		
		frame.setSize(300, 200);
		frame.setVisible(true);
		
	}
}
