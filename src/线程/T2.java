package 线程;

public class T2 implements Runnable{

	public T2(Factory fatory) {
		super();
		this.fatory = fatory;
	}
	private Factory fatory;
	
	@Override
	public void run() {
		fatory.reduce();
		while(true){
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
