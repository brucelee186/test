package 测试.不同类型间转换;

public class Test {
	public static void main(String[] args) {
		// 布尔型 boolean
		// 字符型 char
		// 整型 byte shot long int
		// 浮点型 float double
		// 数据类型级别
		/*
		 * (byte short char) -> int -> long -> float -> double
		 * 低级变量可自动转换为高级变量,称为自动类型转换
		 */
		System.err.println("2.1自动类型转换 ********************************************");
		byte b = 0;
		short s1 = 0;
		int i0 = 0;
		// s1 = s1 + 1;
		i0 = s1 + 1;
		int i = b;
		long l = b;
		float f = b;
		double d = b;
		char c = 'c';
		int x = c;
		System.err.println(x);
		short s = 99;
		char c1 = (char) s;
		System.err.println(c1);
		System.err.println("2.2强制类型转换 ********************************************");
		int i1 = 99;
		byte b1 = (byte)i1;
		char c2 = (char)i1;
		float f2 = (float)i1;
		System.err.println("2.3包装类过渡类型转换 ********************************************");
		// 当希望把float型转换为double型时
		float f3 = 100.00f;
		Float f4 = new Float(f3);
		Double d2 = f4.doubleValue();
		// 当希望把double型转换为int型时
		double d5 = 100.00;
		Double D5 = new Double(d5);
		int i5 = D5.intValue();
		System.err.println(i5);
		
	}
}
