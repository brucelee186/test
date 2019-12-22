package myjava.lang.SimpleType;

public class Test {
	
	private static int tInt1;
	private static Short tShort1;
	private static Long tLong1;
	private static boolean tBoolean1;
	private static byte tByte1;
	private static char tChar1;
	private static double tDouble1;
	private static float tFloat1;
	
	public static void main(String[] args) {
		System.err.println("默认初始值 开始");
		System.err.println("tInt: " + tInt1);
		System.err.println("tShort: " + tShort1);
		System.err.println("tLong: " + tLong1);
		System.err.println("tBoolean: " + tBoolean1);
		System.err.println("tByte: " + tByte1);
		System.err.println("tChar: " + tChar1);
		System.err.println("tDouble: " + tDouble1);
		System.err.println("tFloat: " + tFloat1);
		System.err.println("默认初始值 结束");
		//mian方法设置的局部变量在运行前不会自动赋默认值,所以在这里要赋值,而全局变量不用赋值,系统就会给与默认值
		// 基本类型无构造
		int tInt = 1234567890;
		Short tShort = 12345;
		tShort = null;
		//Short可存单个字符
		tShort = 'I';
		Long tLong = 1234567890123456789L;
		boolean tBoolean = true;
		byte tByte = 123;
		char tChar = 12345;
		double tDouble = 1234567890;
		float tFloat = 1234567890;
		System.err.println("tInt: " + tInt);
		System.err.println("tShort: " + tShort);
		System.err.println("tLong: " + tLong);
		System.err.println("tBoolean: " + tBoolean);
		System.err.println("tByte: " + tByte);
		System.err.println("tChar: " + tChar);
		System.err.println("tDouble: " + tDouble);
		System.err.println("tFloat: " + tFloat);
	}
}
