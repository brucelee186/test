package framework.hibernate.extend.unionSubclass;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
		Session s = new Configuration()
				.configure("/framework/hibernate/extend/unionSubclass/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		
		Department department = new Department();
		department.setName("godd department");
		
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setName("godd employee");
		
		Skiller employee1 = new Skiller();
		employee1.setDepartment(department);
		employee1.setName("bad employee1");
		employee1.setSkill("thief");
		
		Saler employee2 = new Saler();
		employee2.setDepartment(department);
		employee2.setName("god");
		employee2.setSaleAmount(3000);
		
		s.save(department);
		s.save(employee);
		s.save(employee1);
		s.save(employee2);
		t.commit();
		s.close();
		query(employee.getId());
	}

	static private void query(int empoyeeId) {
		Session s = new Configuration()
				.configure("/framework/hibernate/extend/unionSubclass/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction t = s.beginTransaction();
		Employee e = (Employee) s.get(Employee.class, empoyeeId);
		System.err.println(e.getClass());
		t.commit();
		s.close();
	}
}
