package 设计模式.二抽象工厂模式_AbstractFactory;


public class FactoryProduceEmail implements Factory {

	@Override
	public Sender produce() {
		return new SendEmail();
	}
}
