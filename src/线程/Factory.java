package 线程;

public class Factory {
	int j;
	
	public Factory() {
		j = 0;
	}
	synchronized void add(){
		j++;
		System.err.println(Thread.currentThread().getName() + ":" + j);
	}
	synchronized void reduce(){
		j--;
		System.err.println(Thread.currentThread().getName() + ":" + j);
	}
}
