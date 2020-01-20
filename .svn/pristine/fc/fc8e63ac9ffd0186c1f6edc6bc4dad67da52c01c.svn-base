package 线程.练习;

public class 实现Runnable接口 implements Runnable{

	public 实现Runnable接口(String name) {
		this.name = name;
	}

	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.err.println(name + " : " + i);
		}
	}
	
	public static void main(String[] args) {
		实现Runnable接口 a = new 实现Runnable接口("A");
		实现Runnable接口 b = new 实现Runnable接口("B");
		Thread t1 = new Thread(a);
		Thread t2 = new Thread(b);
		t1.start();
		t2.start();
	}
}
