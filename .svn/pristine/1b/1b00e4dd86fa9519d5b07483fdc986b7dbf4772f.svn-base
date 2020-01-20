package myjava.lang.Thread;

public class TestCustomerProductorEndSyncEnd {
	public static void main(String[] args) {
		CustomerProductorEndBean commonBean = new CustomerProductorEndBean();
		ProductorSyncEnd p = new ProductorSyncEnd(commonBean);
		CustomerSyncEnd c = new CustomerSyncEnd(commonBean);
		Thread t1 = new Thread(p, "A");
		Thread t2 = new Thread(c, "B");
		t1.start();
		t2.start();
	}
}

class CustomerProductorEndBean {
	private String name;
	private int age;
	// 执行完毕标志 get:表示可以赋值和取值,不会发生并发,set表示正在赋值与取值过程中
	String getSelFlag = "get";
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
	
	public synchronized void set(String name, int age) {
		if(getSelFlag.equals("set")){
			try {
				super.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		this.name = name;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.age = age;
		this.getSelFlag = "set";
		this.notify();
	}
	
	public synchronized void get() {
		if (getSelFlag.equals("get")) {
			try {
				super.wait();
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		System.err.println("name: " + this.name + " age: " +this.age);
		getSelFlag = "get";
		super.notify();
	}
}

class ProductorSyncEnd implements Runnable {
	private CustomerProductorEndBean customerProductorEndBean;
	
	public CustomerProductorEndBean getCustomerProductorEndBean() {
		return customerProductorEndBean;
	}

	public void setCustomerProductorEndBean(
			CustomerProductorEndBean customerProductorEndBean) {
		this.customerProductorEndBean = customerProductorEndBean;
	}

	
	public ProductorSyncEnd(CustomerProductorEndBean customerProductorEndBean) {
		super();
		this.customerProductorEndBean = customerProductorEndBean;
	}

	@Override
	public void run() {
		boolean flag = true;
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (flag) {
				this.customerProductorEndBean.set("tom", 20);
				flag = false;
			} else {
				this.customerProductorEndBean.set("neo", 30);
				flag = true;
			}
		}
	}
}

class CustomerSyncEnd implements Runnable {
	private CustomerProductorEndBean customerProductorEndBean;
	
	public CustomerProductorEndBean getCustomerProductorEndBean() {
		return customerProductorEndBean;
	}

	public void setCustomerProductorEndBean(
			CustomerProductorEndBean customerProductorEndBean) {
		this.customerProductorEndBean = customerProductorEndBean;
	}

	public CustomerSyncEnd(CustomerProductorEndBean customerProductorEndBean) {
		super();
		this.customerProductorEndBean = customerProductorEndBean;
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			customerProductorEndBean.get();
		}
	}
}
