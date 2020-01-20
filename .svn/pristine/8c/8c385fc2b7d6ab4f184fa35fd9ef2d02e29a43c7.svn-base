package myjava.awt.BoxLayout;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
 * 将容器中的组件,按水平排成一行,或按垂直方向排成一列
 */
public class Test {
	private JFrame jFrame;
	private JPanel pv, ph;
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	
	public void test() {
		jFrame = new JFrame();
		Container container = jFrame.getContentPane();
		pv = new JPanel();
		pv.setLayout(new BoxLayout(pv, BoxLayout.Y_AXIS));
		pv.add(new JLabel("Monday"));
		pv.add(new JLabel("Tuesday"));
		pv.add(new JLabel("Wednesday"));
		pv.add(new JLabel("Thursday"));
		pv.add(new JLabel("Friday"));
		pv.add(new JLabel("Saturday"));
		pv.add(new JLabel("Sunday"));
		container.add(pv, BorderLayout.CENTER);
		
		ph = new JPanel();
		ph.setLayout(new BoxLayout(ph, BoxLayout.Y_AXIS));
		ph.add(new JButton("yes"));
		ph.add(new JButton("no"));
		ph.add(new JButton("cancel"));
		container.add(ph, BorderLayout.SOUTH);
		
		jFrame.pack();
		jFrame.setVisible(true);
	}
}
