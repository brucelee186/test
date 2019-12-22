package 设计模式.二抽象工厂模式_AbstractFactory;

public class Test {
	public static void main(String[] args) {
		Sender sendEmail = new FactoryProduceEmail().produce();
		sendEmail.send();
		Sender sendSms = new FactoryProduceSms().produce();
		sendSms.send();
	}
}
