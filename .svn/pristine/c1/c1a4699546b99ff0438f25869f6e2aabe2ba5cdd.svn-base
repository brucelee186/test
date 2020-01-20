package myjava.lang.Thread;

public class TicketSellSystem implements Runnable{

	private int ticketNO = 5;
	public void run() {
		for (int i = 0; i < 40; i++) {
			if(ticketNO > 0){
				System.err.println(Thread.currentThread().getName() + "sell ticket NO : " + ticketNO--);
			}
		}
	}
	
	public static void main(String[] args) {
		TicketSellSystem t = new TicketSellSystem();
//		Thread t1 = new Thread(t);
//		Thread t2 = new Thread(t);
//		Thread t3 = new Thread(t);
//		t1.start();
//		t2.start();
//		t3.start();
		
		new Thread(t, "1号窗口").start();
		new Thread(t, "2号窗口").start();
		new Thread(t, "3号窗口").start();
	}

}