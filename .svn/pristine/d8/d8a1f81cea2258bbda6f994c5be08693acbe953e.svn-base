package software.BeepTimer;

import java.text.SimpleDateFormat;
import java.util.Date;


public class BeepTimer implements Runnable{@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(1000);
				String time = new SimpleDateFormat("yyyy.MM.dd.hh.mm.ss").format(new Date());
				if ("2013.06.14.05.37.06".equals(time)) {
					System.err.println("time up");
					return;
				}
				System.err.println(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		BeepTimer b = new BeepTimer();
		new Thread(b, "线程时间").start();
	}
}
