package 常见问题测试;

public class TestEquals {
	
	public static void main(String[] args) {
		Double double1 = new Double(10);
		Double double2 = new Double(10.0);
		Double double3 = new Double(10);
		System.err.println(double2);
		System.err.println(double3);
		System.err.println(double1 == double2);
		System.err.println(double1 == double3);
		System.err.println(double1.equals(double2));
		System.err.println(double1.equals(double1));
		Integer integer1 = new Integer(10);
		System.err.println("integer1: " + integer1);
		System.err.println("integer1.equals(double1): " + integer1.equals(double1));
		Long long1 = new Long(10);
		System.err.println("long1: " + long1);
		System.err.println("long1.equals(integer1): " + long1.equals(integer1));
		//System.err.println(long1 == integer1);
		System.err.println("long1.intValue() == integer1.intValue(): " + (long1.intValue() == integer1.intValue()));
		String string = "test";
		String string2 = "test";
		String string3 = new String("test");
		System.err.println(string == string2);
		System.err.println(string2 == string3);
	}
}
