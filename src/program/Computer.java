package program;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Computer extends JFrame implements ActionListener {
	private static final long serialVersionUID = 3579513741141219813L;
	// 状态:当前数字是否为小数
	private String stateDecimal = "integer";
	// 状态:计算符号
	private String stateCaculate = "";
	// 状态:当前是否为计算符号按下状态false:不是
	private boolean stateCaculateJudgement = false;
	protected Container con = getContentPane();// 指向内容面板
	protected JMenuBar a = new JMenuBar();// 菜单条
	protected JMenu a1 = new JMenu("编辑(E)");// 菜单1
	protected JMenu a2 = new JMenu("查看(V)");// 菜单2
	protected JMenu a3 = new JMenu("帮助(H)");// 菜单3
	protected JMenuItem a11 = new JMenuItem("复制(C)", 'C');// 菜单1的菜单项
	protected JMenuItem a12 = new JMenuItem("粘贴(P)", 'P');// 菜单1的菜单项
	protected JMenuItem a21 = new JMenuItem("标准型(T)", 'T');// 菜单2的菜单项
	protected JMenuItem a22 = new JMenuItem("科学型(S)", 'S');// 菜单2的菜单项
	protected JMenuItem a31 = new JMenuItem("帮助主题(H)", 'H');// 菜单3的菜单项

	protected JTextField jtf1 = new JTextField(30);// 文本框
	protected JTextField jtf2 = new JTextField(30);// 文本框
	protected JButton[] jb = new JButton[27];
	protected String[] arr = { "Backspace", "CE", "C", "MC", "7", "8", "9",
			"/", "sqrt", "MR", "4", "5", "6", "*", "%", "MS", "1", "2", "3",
			"-", "1/x", "M+", "0", "+/-", ".", "+", "=" };
	protected JTextField jtf3 = new JTextField(1);// 文本框
	protected JPanel jp = new JPanel();// 主面板
	protected JPanel m = new JPanel();// 次面板
	protected JPanel m1 = new JPanel();// 次次面板
	protected JPanel m2 = new JPanel();// 次次面板
	protected JPanel m3 = new JPanel();// 次次面板
	protected JPanel m4 = new JPanel();// 次次面板
	protected JPanel m5 = new JPanel();// 次次面板
	protected JPanel m6 = new JPanel();// 次次面板
	protected JPanel m7 = new JPanel();// 次次面板
	protected JPanel m8 = new JPanel();// 次次面板

	protected GridLayout glo = new GridLayout(8, 1, 3, 3);// 主网格布局
	protected GridLayout glo1 = new GridLayout(1, 3, 3, 3);// 次网格布局
	protected GridLayout glo2 = new GridLayout(1, 6, 3, 3);// 次网格布局

	protected Computer(String s) {
		super(s);
		a1.setMnemonic('E');
		a1.add(a11);
		a1.add(a12);
		a2.setMnemonic('V');
		a2.add(a21);
		a2.add(a22);
		a3.setMnemonic('H');
		a3.add(a31);
		a.add(a1);
		a.add(a2);
		a.add(a3);
		this.setJMenuBar(a);// 菜单条完成

		for (int i = 0; i < 27; i++) {
			jb[i] = new JButton(arr[i]);
			jb[i].addActionListener(this);
		}

		jp.setLayout(glo);
		
		jp.add(m1);
		m1.add(jtf1);
		jtf1.setEditable(false);
		jtf1.setText("0.");
		jtf1.setForeground(Color.BLUE);
		jtf1.setBackground(Color.WHITE);
		jtf1.setHorizontalAlignment(JTextField.RIGHT);// 文本显示在右边
		
		jp.add(jtf3);
		
		jp.add(m3);
		m3.add(jtf2);
		jtf2.setEditable(false);
		jtf2.setText("");
		jtf2.setForeground(Color.BLUE);
		jtf2.setBackground(Color.WHITE);
		jtf2.setHorizontalAlignment(JTextField.RIGHT);// 文本显示在右边

		jp.add(m4);
		m4.setLayout(glo1);
		m4.add(jb[0]);
		m4.add(jb[1]);
		m4.add(jb[2]);

		jp.add(m5);
		m5.setLayout(glo2);
		m5.add(jb[3]);
		m5.add(jb[4]);
		m5.add(jb[5]);
		m5.add(jb[6]);
		m5.add(jb[7]);
		m5.add(jb[8]);

		jp.add(m6);
		m6.setLayout(glo2);
		m6.add(jb[9]);
		m6.add(jb[10]);
		m6.add(jb[11]);
		m6.add(jb[12]);
		m6.add(jb[13]);
		m6.add(jb[14]);

		jp.add(m7);
		m7.setLayout(glo2);
		m7.add(jb[15]);
		m7.add(jb[16]);
		m7.add(jb[17]);
		m7.add(jb[18]);
		m7.add(jb[19]);
		m7.add(jb[20]);

		jp.add(m8);
		m8.setLayout(glo2);
		m8.add(jb[21]);
		m8.add(jb[22]);
		m8.add(jb[23]);
		m8.add(jb[24]);
		m8.add(jb[25]);
		m8.add(jb[26]);

		m.add(jp);
		con.add(m);

		this.setResizable(false);// 不能用鼠标拉伸窗体
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 可以关闭窗体
		this.setSize(380, 320);
		this.setVisible(true);

	}

	protected Computer() {
		this("Computer");
	}

	public static void main(String[] args) {
		new Computer("Computer");
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String command = actionEvent.getActionCommand();
		String text1 = jtf1.getText();
		String text2 = jtf2.getText();
/*		if ("Backspace".equals(command)) {
			System.err.println(text);
			// String变char位数减一
			char[] charArray = text.toCharArray();
			char[] newChararray = new char[1];
			int charArrayLength = charArray.length;
			if (charArrayLength > 1) {
				newChararray = new char[charArrayLength - 1];
				System.arraycopy(charArray, 0, newChararray, 0, charArrayLength - 1);
			} else {
				text = "";
			}
			jtf1.setText(text);
		}*/
		switch (command) {
		case "+/-":{
			stateCaculate = "+";
			jtf3.setText("+/-");
			jtf2.setText("");
			if ("".equals(stateCaculate)) {
	
				
			}
			break;
		}
		case "+":{
			stateCaculate = "+";
			jtf3.setText("PLUS");
			jtf2.setText("");
			break;
		}
		case "-":{
			stateCaculate = "-";
			jtf3.setText("SUBTRACT");
			jtf2.setText("");
			break;
		}
		case "*":{
			stateCaculate = "*";
			jtf3.setText("MULTIPLY");
			jtf2.setText("");
			break;
		}
		case "/":{
			stateCaculate = "/";
			jtf3.setText("DIVIDE");
			jtf2.setText("");
			break;
		}
		case "=":{
			switch (stateCaculate) {
				case "+":{
					BigDecimal decimal1 = new BigDecimal(text1);
					BigDecimal decimal2 = new BigDecimal(text2);
					BigDecimal decimalResult = decimal1.add(decimal2);
					jtf2.setText(decimalResult.toString() + ".");
					break;
				}
				case "-":{
					BigDecimal decimal1 = new BigDecimal(text1);
					BigDecimal decimal2 = new BigDecimal(text2);
					BigDecimal decimalResult = decimal1.subtract(decimal2);
					jtf2.setText(decimalResult.toString() + ".");
					break;
				}
				case "*":{
					BigDecimal decimal1 = new BigDecimal(text1);
					BigDecimal decimal2 = new BigDecimal(text2);
					BigDecimal decimalResult = decimal1.multiply(decimal2);
					jtf2.setText(decimalResult.toString() + ".");
					break;
				}
				case "/":{
					BigDecimal decimal1 = new BigDecimal(text1);
					BigDecimal decimal2 = new BigDecimal(text2);
					BigDecimal decimalResult = decimal1.divide(decimal2);
					jtf2.setText(decimalResult.toString() + ".");
					break;
				}
			}
			break;
		}
		case "C":{
			stateDecimal = "integer";
			jtf2.setText("0.");
			break;
		}
		case "CE":{
			stateDecimal = "integer";
			stateCaculate = "";
			jtf1.setText("0.");
			jtf2.setText("0.");
			break;
		}
		case ".":{
			stateDecimal = "decimal";
			break;
		}
		case "0":{
			if ("0.".equals(text1)) {
				jtf1.setText("0.");
			} else {
				pressDigits(text1, text2, command, stateCaculate);
			}
			break;
		}
		case "1":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "2":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "3":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "4":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "5":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "6":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "7":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "8":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}
		case "9":{
			pressDigits(text1, text2, command, stateCaculate);
			break;
		}

		}
		// 赋值当前编辑状态
	}
	public void pressDigits(String text1, String text2, String buttonCommand, String stateCaculate) {
		stateCaculateJudjement();
		if (stateCaculateJudgement) {
			// 如果是小数,那么住小数位之后添加数字
			if (stateDecimal.equals("integer")) {
				// 首位如果为零那么去掉零
				// 取得首位
				if (text2.equals("0.")) {
					text2 = ".";
				}
				// 取得小数点之后的长度
				int decimalDigits = text2.substring(text2.indexOf(".") + 1, text2.length()).length();
				text2 = text2.replace(".", "");
				//如果长度为零,不做小数后累加处理
				char[] charArray = text2.toCharArray();
				int charArrayLength = charArray.length;
				int newCharArrayLength = charArrayLength + 1;
				char[] newChararray = new char[newCharArrayLength];
				System.arraycopy(charArray, 0, newChararray, 0, charArrayLength);
				newChararray[newCharArrayLength - 1] = buttonCommand.toCharArray()[0];
				String test = new String(newChararray);
				if (decimalDigits == 0) {
					jtf2.setText(test + ".");
				} else {
					jtf2.setText(test);
				}
			} else if (stateDecimal.equals("decimal")) {
				char[] charArray = text2.toCharArray();
				int charArrayLength = charArray.length;
				int newCharArrayLength = charArrayLength + 1;
				char[] newChararray = new char[newCharArrayLength];
				System.arraycopy(charArray, 0, newChararray, 0, charArrayLength);
				newChararray[newCharArrayLength - 1] = buttonCommand.toCharArray()[0];
				String test = new String(newChararray);
				jtf2.setText(test);
			}
		} else {
			// 如果是小数,那么住小数位之后添加数字
			if (stateDecimal.equals("integer")) {
				// 首位如果为零那么去掉零
				// 取得首位
				if (text1.equals("0.")) {
					text1 = ".";
				}
				// 取得小数点之后的长度
				int decimalDigits = text1.substring(text1.indexOf(".") + 1, text1.length()).length();
				text1 = text1.replace(".", "");
				//如果长度为零,不做小数后累加处理
				char[] charArray = text1.toCharArray();
				int charArrayLength = charArray.length;
				int newCharArrayLength = charArrayLength + 1;
				char[] newChararray = new char[newCharArrayLength];
				System.arraycopy(charArray, 0, newChararray, 0, charArrayLength);
				newChararray[newCharArrayLength - 1] = buttonCommand.toCharArray()[0];
				String test = new String(newChararray);
				if (decimalDigits == 0) {
					jtf1.setText(test + ".");
				} else {
					jtf1.setText(test);
				}
			} else if (stateDecimal.equals("decimal")) {
				char[] charArray = text1.toCharArray();
				int charArrayLength = charArray.length;
				int newCharArrayLength = charArrayLength + 1;
				char[] newChararray = new char[newCharArrayLength];
				System.arraycopy(charArray, 0, newChararray, 0, charArrayLength);
				newChararray[newCharArrayLength - 1] = buttonCommand.toCharArray()[0];
				String test = new String(newChararray);
				jtf1.setText(test);
			}
		}
	}
	
	public void stateCaculateJudjement() {
		if (stateCaculate.equals("+") || stateCaculate.equals("-") || stateCaculate.equals("*") || stateCaculate.equals("/")) {
			stateCaculateJudgement = true;
		}
	}
	
	// 取相反数
	public String judgePlusMinus(String text) {
		stateCaculateJudjement();
		if (stateCaculateJudgement) {
			//判断当前数字是否为正数
			Long long1 = Long.valueOf(text);
			if (long1 > 0) {
				jtf1.setText("-" + text);
			} else {
				jtf1.setText(text.replace("-", ""));
			}
			
		}
		String res = "positive";
		return res;
	}
}