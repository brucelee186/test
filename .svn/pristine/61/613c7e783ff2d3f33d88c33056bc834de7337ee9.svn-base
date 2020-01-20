package framework.Spring.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class TestAOP {
	public static void main(String[] args) {
		ApplicationContext appContext=new FileSystemXmlApplicationContext("src/framework/Spring/AOP/applicationContext.xml");
		System.err.println(appContext);
		AService aService= (AService) appContext.getBean("AServiceImpl");
		aService.barA();
	}
}
