package framework.hibernate.many2one;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session session = new Configuration()
				.configure("/framework/hibernate/many2one/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Department department = new Department();
		department.setName("techonlogy");
		Employee employee = new Employee();
		employee.setName("neo");
		employee.setDepartment(department);
		session.save(employee);
		session.save(department);
		transaction.commit();
		session.close();
		query(employee.getId());
		// 2
//		System.err.println("department name: " + employee.getDepartment().getName());
	}

	static private void query(int empoyeeId) {
		Session session = new Configuration()
				.configure("/framework/hibernate/many2one/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Employee employee = new Employee();
		employee = (Employee) session.get(Employee.class, empoyeeId);
		// 默认懒加载是开启的,所以只有在想得到对象的子对象时才会查询,否则不查询
		
//		System.err.println("department_name: " + employee.getDepartment().getName());// 1
		System.out.println("depart class:" + employee.getDepartment().getClass()); // 4
		System.out.println("depart id:" + employee.getDepartment().getId()); // 5
		Hibernate.initialize(employee.getDepartment()); // 3
		transaction.commit();
		session.close();
		System.err.println(employee.getId());
		System.err.println(employee.getName());
	}
}
