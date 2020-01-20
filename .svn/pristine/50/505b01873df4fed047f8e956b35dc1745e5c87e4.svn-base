package 线程;

public class Thread1 implements Runnable {
    public void run() {
    	//同一时间只执行一个线程,只有这个线程执行完之后才能执行下一个线程
         synchronized(this) {
              for (int i = 0; i < 5; i++) { 
                   System.out.println(Thread.currentThread().getName() + " synchronized loop " + i); 
              } 
         } 
    } 
    public static void main(String[] args) { 
         Thread1 t1 = new Thread1(); 
         Thread ta = new Thread(t1, "A"); 
         Thread tb = new Thread(t1, "B"); 
         ta.start(); 
         tb.start(); 
    }
}