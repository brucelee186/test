package framework.hibernate.collections.array;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session s = new Configuration()
				.configure("/framework/hibernate/collections/array/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Department department = new Department();
		department.setName("department Name");
		Employee employee = new Employee();
		employee.setName("employee name 1");
		Employee employee2 = new Employee();
		employee2.setName("employee name 2");
		Employee[] employeeArray = new Employee[2];
		employeeArray[0] = employee;
		employeeArray[1] = employee2;
		department.setEmployeeArray(employeeArray);
		s.save(department);
		s.save(employee);
		s.save(employee2);
		t.commit();
		s.close();
		query(department.getId());
	}

	static private void query(int departmentId) {
		Session session = new Configuration()
				.configure("/framework/hibernate/collections/array/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Department department = (Department) session.get(Department.class, departmentId);
		transaction.commit();
		session.close();
		for (int i = 0; i < department.getEmployeeArray().length; i++) {
			System.err.println(department.getEmployeeArray()[i]);
		}
	}
}
