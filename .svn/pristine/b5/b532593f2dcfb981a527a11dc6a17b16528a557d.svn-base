package framework.hibernate.collections.list;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session s = new Configuration()
				.configure("/framework/hibernate/collections/list/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Department department = new Department();
		department.setName("department Name");
		Employee employee = new Employee();
		employee.setName("employee name 1");
		Employee employee2 = new Employee();
		employee2.setName("employee name 2");
		java.util.List<Employee> employeeList = new ArrayList<Employee>();
		employeeList.add(employee);
		employeeList.add(employee2);
		department.setEmployeeList(employeeList);
		s.save(department);
		s.save(employee);
		s.save(employee2);
		t.commit();
		s.close();
		query(department.getId());
	}

	static private void query(int departmentId) {
		Session session = new Configuration()
				.configure("/framework/hibernate/collections/list/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Department department = (Department) session.get(Department.class, departmentId);
		transaction.commit();
		session.close();
		System.err.println(department.getId());
		System.err.println(department.getName());
		System.err.println(department.getEmployeeList());
	}
}
