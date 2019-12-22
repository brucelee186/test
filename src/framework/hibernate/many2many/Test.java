package framework.hibernate.many2many;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
	public static void main(String[] args) {
//		int teacherId = insert().getId();
		query(1);
	}

	static private Teacher insert() {
		Session session = new Configuration() .configure("/framework/hibernate/many2many/hiberante.cfg.xml") .buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		
		
		Student student = new Student();
		student.setName("neo");
		Student student2 = new Student();
		student2.setName("tom");
		Set<Student> studentSet = new HashSet<Student>();
		studentSet.add(student);
		studentSet.add(student2);
		
		Teacher teacher = new Teacher();
		teacher.setName("cock master");
		Teacher teacher2 = new Teacher();
		teacher2.setName("shit face");
		Set<Teacher> teacherSet = new HashSet<Teacher>();
		teacherSet.add(teacher);
		teacherSet.add(teacher2);
		teacher.setStudents(studentSet);
		teacher2.setStudents(studentSet);
		session.save(teacher);
		session.save(teacher2);
		session.save(student);
		session.save(student2);
		transaction.commit();
		session.close();
		return teacher;
	}
	
	static private void query(int teacherId) {
		Session session = new Configuration()
				.configure("/framework/hibernate/many2many/hiberante.cfg.xml")
				.buildSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();
		Teacher t = (Teacher)session.get(Teacher.class, teacherId);
		transaction.commit();
		session.close();
		// 如果配置文件中没有加载laxy="false"那么不会查询关联的集合查询,会报org.hibernate.laxyInitalizationException
		System.err.println("student.size() = " + t.getStudents().size());
	}
}
