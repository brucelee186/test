package 设计模式.一工厂模式_FactoryMethod;

public class Test {
	public static void main(String[] args) {
		// 普通工厂模式
		SenderFactory sf = new SenderFactory();
		SenderImterface sender = sf.produce("sms");
		sender.send();
		sender = sf.produce("email");
		sender.send();
		
		// 多个工厂方法模式
		sender = sf.produceEmail();
		sender.send();
		sender = sf.produceSms();
		sender.send();
		
		// 多个静态工厂方法模式
		sender = SenderFactory.produceEmailStatic();
		sender.send();
		sender = SenderFactory.produceSmsStatic();
		sender.send();
	}
}
