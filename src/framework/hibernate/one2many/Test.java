package framework.hibernate.one2many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		int departmentId = insert().getId();
		query(departmentId);
	}

	static private Department insert() {
		Session session = new Configuration() .configure("/framework/hibernate/one2many/hiberante.cfg.xml") .buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		Department department = new Department();
		department.setName("Department New");
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setName("tom");
		Employee employee2 = new Employee();
		employee2.setDepartment(department);
		employee2.setName("neo");
		
		session.save(department);
		session.save(employee);
		session.save(employee2);
		transaction.commit();
		session.close();
		return department;
	}
	
	static private void query(int departmentId) {
		Session session = new Configuration()
				.configure("/framework/hibernate/one2many/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Department d = (Department)session.get(Department.class, departmentId);
		System.err.println("employees.size() = " + d.getEmployees().size());
		transaction.commit();
		session.close();
	}
}
