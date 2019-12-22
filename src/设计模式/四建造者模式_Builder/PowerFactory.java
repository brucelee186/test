package 设计模式.四建造者模式_Builder;

import java.util.ArrayList;
import java.util.List;

public class PowerFactory {
	static private List<Sender> listSenders = new ArrayList<>();
	
	public List<Sender> builderSenderEmailList(int count) {
		for (int i = 0; i < count; i++) {
			listSenders.add(new SenderEmail());
		}
		return listSenders;
	}
	
	public List<Sender> buildSenderSmsList(int count) {
		for (int i = 0; i < count; i++) {
			listSenders.add(new SenderSms());
		}
		return listSenders;
	}
	
	public static void main(String[] args) {
		System.err.println("test" == "test");
		PowerFactory powerFactory = new PowerFactory();
		List<Sender> listSenderEmail = powerFactory.builderSenderEmailList(10);
		List<Sender> listSenderSms = powerFactory.buildSenderSmsList(5);
		System.err.println(listSenderEmail.size());
		System.err.println(listSenderSms.size());
	}
}
