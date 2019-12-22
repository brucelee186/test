package 测试.变态;

import java.util.Date;

class A extends Date {
	private static final long serialVersionUID = 2919531293333407466L;}
class B extends Date {
	private static final long serialVersionUID = -8302613369157231805L;}
public class Test {
	public static void main(String[] args) {
		// 1。变态指数4
		int x = 4;
		System.err.println("value: " + (x > 4 ? 99.9:9));
		
		System.err.println("2 ***********************************************");
		// 2.变态指数5
		int x2 = 4;
		java.util.Date date = (x > 4 ? new A() : new B());
		System.err.println(date);
		System.err.println("3 ***********************************************");
		String a = new String("abc");
		System.err.println(a);
		System.err.println("4 ***********************************************");
		System.err.println("const是关键字");
		System.err.println("5 ***********************************************");
		short s1 = 1;
		// 报错,类型只能向下转换
		// s1 = s1 + 1;
		System.err.println("6 ***********************************************");
		/*
		 * 上海贝尔的面试题:你认为效率最高的方法,实现从1加到100.
		       答案1-100的累加相当于加50次101，这样循环次数从100次降为50次
		 */
		for (int i = 0, j = 0; j < 100; i++,j++) {
			
		}
		System.err.println("7 ***********************************************");
		System.out.println(5.0942*1000);
		System.out.println(5.0943*1000);
		System.out.println(5.0944*1000);
		
	}
}
