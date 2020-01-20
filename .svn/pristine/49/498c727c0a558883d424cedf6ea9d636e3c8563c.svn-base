package myjava.awt.CardLayout;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Test extends MouseAdapter {
	CardLayout cardLayout = new CardLayout();
	JFrame jFrame = new JFrame();
	Container container = jFrame.getContentPane();
	
	public static void main(String[] args) {
		Test t = new Test();
		t.test();
	}
	
	public void test() {
		JPanel p1, p2, p3, p4, p5;
		JLabel l1, l2, l3, l4, l5;
		container.setLayout(cardLayout);
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		
		l1 = new JLabel("first label");
		p1.add(l1);
		p1.setBackground(Color.yellow);
		l2 = new JLabel("secend label");
		p2.add(l2);
		p2.setBackground(Color.black);
		l3 = new JLabel("third label");
		p3.add(l3);
		p3.setBackground(Color.BLUE);
		l4 = new JLabel("forth label");
		p4.add(l4);
		p4.setBackground(Color.orange);
		l5 = new JLabel("firth label");
		p5.add(l5);
		p5.setBackground(Color.GRAY);
		
		// 设置鼠标监听
		p1.addMouseListener(this);
		p2.addMouseListener(this);
		p3.addMouseListener(this);
		p4.addMouseListener(this);
		p5.addMouseListener(this);
		
		// 把卡片总局放入到JFrame容器中
		container.add(p1, "first");
		container.add(p2, "second");
		container.add(p3, "thrid");
		container.add(p4, "forth");
		container.add(p5, "fifth");
		
		// 显示第一张图片
		cardLayout.show(container, "first");
		
		jFrame.setSize(200, 300);
		jFrame.show();
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		cardLayout.next(container);
	}
}
