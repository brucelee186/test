package scjp.访问权限.default1;

public class 测试default修饰本包是否可以访问 {
	public static void main(String[] args) {
		// default修饰本包可以访问
		System.err.println(Target.a);
	}
}
