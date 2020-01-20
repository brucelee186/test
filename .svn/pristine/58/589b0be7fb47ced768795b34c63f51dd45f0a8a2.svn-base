package myjava.lang.Thread;

public class TestCommonBeanProductorCustomerThreadDeadLock {
	public static void main(String[] args) {
		CommonBean commonBean = new CommonBean();
		Productor p = new Productor(commonBean);
		Customer c =new Customer(commonBean);
		Thread tp = new Thread(p, "productor");
		Thread tc = new Thread(c, "customer");
		tp.start();
		tc.start();
	}
}

class CommonBean {
	private String name = "jim";
	private int age = 20;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class Productor implements Runnable {

	private CommonBean threadDeadLock;

	public CommonBean getThreadDeadLock() {
		return threadDeadLock;
	}

	public void setThreadDeadLock(CommonBean threadDeadLock) {
		this.threadDeadLock = threadDeadLock;
	}

	public Productor(CommonBean threadDeadLock) {
		super();
		this.threadDeadLock = threadDeadLock;
	}

	@Override
	public void run() {
		boolean flg = false;
		for (int i = 0; i < 25; i++) {
			if(flg) {
				threadDeadLock.setAge(20);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				threadDeadLock.setName("jim");
				flg = false;
			} else {
				threadDeadLock.setAge(30);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				threadDeadLock.setName("neo");
				flg = true;
			}
		}
	}
}

class Customer implements Runnable{
	
	public Customer(CommonBean threadDeadLock) {
		super();
		this.threadDeadLock = threadDeadLock;
	}

	private CommonBean threadDeadLock;
	
	public CommonBean getThreadDeakLock() {
		return threadDeadLock;
	}

	public void setThreadDeakLock(CommonBean threadDeakLock) {
		this.threadDeadLock = threadDeakLock;
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println(Thread.currentThread().getName() + "name: " + threadDeadLock.getName() + " age: " +threadDeadLock.getAge());
		}
	}
	
}