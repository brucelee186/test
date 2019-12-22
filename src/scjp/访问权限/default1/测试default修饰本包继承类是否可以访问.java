package scjp.访问权限.default1;

public class 测试default修饰本包继承类是否可以访问 extends Target {
	// default继承类可以访问
	public static void main(String[] args) {
		System.err.println(Target.a);
	}
}
