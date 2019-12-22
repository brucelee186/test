package 设计模式.一工厂模式_FactoryMethod;

public class SenderFactory {
	
	/**
	 * 普通工厂模式
	 * @param type
	 * @return
	 */
	public SenderImterface produce(String type) {
		if (type.equals("email")) {
			return new SenderEmail();
		} else if (type.equals("sms")) {
			return new SenderSms();
		} else {
			System.err.println("请输入正确类型");
			return null;
		}
	}
	
	/**
	 * 多个工厂方法模式
	 * @return
	 */
	public SenderImterface produceEmail() {
		return new SenderEmail();
	}
	
	public SenderImterface produceSms() {
		return new SenderSms();
	}
	
	/**
	 * 多个静态工厂方法模式
	 * @return
	 */
	public static SenderImterface produceEmailStatic() {
		return new SenderEmail();
	}
	
	public static SenderImterface produceSmsStatic() {
		return new SenderSms();
	}
}
