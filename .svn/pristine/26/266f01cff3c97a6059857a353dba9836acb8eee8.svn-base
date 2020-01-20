package framework.hibernate.base;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestDeleteStud {
	public static void main(String[] args) {
		Student stud = new Student();
		stud.setId(1);
		Session s = HibernateSessionFactory.getSession();
		Transaction ts = s.beginTransaction();
		try {
			s.delete(stud);
			ts.commit();
		} catch (Exception e) {
			ts.rollback();
			e.printStackTrace();
		}
		finally{
			s.close();
		}
		
	}
}
