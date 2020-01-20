package myjava.lang.Thread;

public class TestProductCustomerSyncBean {
	public static void main(String[] args) {
		CommonBeanSync commonBean = new CommonBeanSync();
		ProductorSync p = new ProductorSync(commonBean);
		CustomerSync c = new CustomerSync(commonBean);
		Thread t1 = new Thread(p, "A");
		Thread t2 = new Thread(c, "B");
		t1.start();
		t2.start();
	}

}

 class CommonBeanSync {
		private String name = "neo";
		private int age = 30;
		public String getName() {
			return name;
		}
		public synchronized void setName(String name) {
			this.name = name;
		}
		public int getAge() {
			return age;
		}
		public synchronized void setAge(int age) {
			this.age = age;
		}
		
		synchronized void set(String name, int age) {
			this.name = name;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.age = age;
		}
		synchronized void get() {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println("name: " + this.getName() + " age: " + this.getAge());
		}
 }
 
class ProductorSync implements Runnable {
	private CommonBeanSync commonBean;
	
	public CommonBeanSync getProductCustomerSyncBean() {
		return commonBean;
	}

	public void setProductCustomerSyncBean(
			CommonBeanSync commonBean) {
		this.commonBean = commonBean;
	}

	public ProductorSync(CommonBeanSync commonBean) {
		// 调用父类构造函数
		super();
		this.commonBean = commonBean;
	}

	@Override
	public void run() {
		boolean flg = true;
		for (int i = 0; i < 25; i++) {
			if (flg) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.commonBean.set("tom", 20);
				flg = false;
			} else {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				this.commonBean.set("neo", 30);
				flg = true;
			}
		}
	}
}

// defalut修饰下,同包下的类名不能重名
class CustomerSync implements Runnable {
	
	private CommonBeanSync commonBean;
	
	public CommonBeanSync getProductCustomerSyncBean() {
		return commonBean;
	}

	public void setProductCustomerSyncBean(
			CommonBeanSync commonBean) {
		this.commonBean = commonBean;
	}

	public CustomerSync(CommonBeanSync commonBean) {
		super();
		this.commonBean = commonBean;
	}

	@Override
	public void run() {
		for (int i = 0; i < 25; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.commonBean.get();
		}
	}
	
}