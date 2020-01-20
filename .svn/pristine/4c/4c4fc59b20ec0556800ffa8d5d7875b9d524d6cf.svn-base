package framework.hibernate.test;

import org.hibernate.Hibernate;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		org.hibernate.Session s = new Configuration().configure("/framework/hibernate/test/hibernate.cfg.xml").buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Customer c = new Customer();
		c.setEmail("www.brucelee186@163.com");
		c.setName("neo");
		s.save(c);
		t.commit();
		s.close();
		Test te = new Test();
		te.get(c.getId());
	}
	
	public void get(int employeeId) {
		org.hibernate.Session s = new Configuration().configure("/framework/hibernate/test/hibernate.cfg.xml").buildSessionFactory().openSession();
		Customer c = (Customer) s.load(Customer.class, 5);
		System.err.println(c.getClass());
		System.err.println(c.getName());
		Hibernate.initialize(c);
		System.err.println("customer email = " + c.getEmail());
	}
}
