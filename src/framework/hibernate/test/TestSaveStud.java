package framework.hibernate.test;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestSaveStud {
	// 非静态类必须放到main方法里
	public static void main(String[] args) {
		Session session = HibernateSessionFactory.getSession();
		Transaction transaction = session.beginTransaction();
		Student st = new Student("test2", 20, 99);
		try {
			session.save(st);
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

}
