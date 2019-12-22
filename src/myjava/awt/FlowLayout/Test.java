package myjava.awt.FlowLayout;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {
	// FlowLayout 布局类
	public static void main(String[] args) {
		//实例化对象可以调用非静态方法
		Test t = new Test();
		t.testFlowLayout();
	}
	
	public void testFlowLayout() {
		JFrame jFrame = new JFrame("my jframe");
		Container container = jFrame.getContentPane();
		JButton jButton = new JButton("Add");
		JButton jButton2 = new JButton("Edit");
		JButton jButton3 = new JButton("Delete");
		//使用flowlayout规范布局
		container.setLayout(new FlowLayout());
		container.add(jButton);
		container.add(jButton2);
		container.add(jButton3);
		jFrame.setSize(300, 200);
		jFrame.setVisible(true);
	}
}
