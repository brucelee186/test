package 线程;

public class T1 implements Runnable{
	
	Factory factory = null;
	
	
	
	public T1(Factory factory) {
		super();
		this.factory = factory;
	}



	@Override
	public void run() {
		while(true){
			factory.add();
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
