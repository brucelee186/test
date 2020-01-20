package 工具.quartz;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TestServletContextListerener implements ServletContextListener, Runnable {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.err.println("start");
		TestServletContextListerener testServletContextListerener = new TestServletContextListerener();
		Thread thread = new Thread(testServletContextListerener, "thread");
		thread.start();
	}

	@Override
	public void run() {
		while (true) {
//			System.err.println("serlvetContextStart");
		}
	}

}
