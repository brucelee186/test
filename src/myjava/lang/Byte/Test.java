package myjava.lang.Byte;

public class Test {
	public static void main(String[] args) {
		byte[] b = new byte[32];
		String s = "test";
		b = s.getBytes();
		System.err.println(new String(b));
	}
}
