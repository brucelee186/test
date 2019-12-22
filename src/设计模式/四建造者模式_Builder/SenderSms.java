package 设计模式.四建造者模式_Builder;

public class SenderSms implements Sender {
	@Override
	public void send() {
		System.err.println("produce sms already");
	}
}
