package 线程.问题;

public class TestRun extends Thread {
	static String sName = "vandeleur";
	@Override
	public void run() {
		for (int i = 0; i < 4; i++) {
			sName = sName + " " + i;
		}
	}
	
	public void piggy(String sName) {
		sName = sName + "wiggy";
		start();
	}
	
	public static void main(String[] args) {
		TestRun t = new TestRun();
		t.piggy(sName);
		System.err.println(sName);
	}
}
