package framework.hibernate.test;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

public class TestLoadGet {
	public static void main(String[] args) {
		Session s = new Configuration().configure("/framework/hibernate/test/hibernate.cfg.xml").buildSessionFactory().openSession();
		Student stuGet = (Student) s.get(Student.class, 0);
		Student studLoad = (Student) s.load(Student.class, 0);
		// 没有对象会返回null
		System.err.println(stuGet);
		// 如果没有对象会报ObjectNotfountException
		// load查找对象时会从sessionContext缓存中找是否有对象,如果没有判断是否为lazy为false,如果为false那么再对数据库查找,查到返回记录,查不到返回异常
		System.err.println(studLoad);
		s.close();
	}
}
