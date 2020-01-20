package framework.hibernate.base;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestUpdateStud {
	
	public static void main(String[] args) {
		Student st = new Student("testUpdate", 20, 98);
		st.setId(1);
		Session session = HibernateSessionFactory.getSession();
		Transaction ts = session.beginTransaction();
		try {
			session.update(st);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}
		finally{
			session.close();
		}
	}
}
