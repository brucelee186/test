package 线程.实现线程的几种方式;

import java.util.Timer;
import java.util.TimerTask;

class TimerTask3Second extends TimerTask {
	@Override
	public void run() {
		System.err.println("3secondExecute");
		new Timer().schedule(new TimerTask2Second(), 2000);
	}
}

class TimerTask2Second extends TimerTask {
	@Override
	public void run() {
		System.err.println("2secondExecute");
		new Timer().schedule(new TimerTask3Second(), 3000);
	}
}

public class Timer3Second2SecondCirculate {
	public static void main(String[] args) {
		Timer timer = new Timer();
		timer.schedule(new TimerTask3Second(), 3000);
	}
}
