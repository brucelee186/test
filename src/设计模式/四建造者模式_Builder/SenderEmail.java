package 设计模式.四建造者模式_Builder;

public class SenderEmail implements Sender {

	@Override
	public void send() {
		System.err.println("produce email already");
	}

}
