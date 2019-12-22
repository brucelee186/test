package myjava.lang.Thread;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sleep1Second implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.err.println(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));
		}
	}
	
	public static void main(String[] args) {
		new Thread(new Sleep1Second(), "时间线程").start();
	}
}
