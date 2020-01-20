package framework.Spring.transaction.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;
import framework.Spring.transaction.dao.PersonDaoB;

public class PersonDaoImplB implements PersonDaoB {
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Person> search() {
		List<Person> personList = null;
		System.err.println(personList);
		return personList;
	}

	public void saveObjectB() throws Exception{
		Department department = new Department();
		department.setName("technology");
		Person person = new Person();
		person.setName("noe");
		person.setDepartment(department);
		jdbcTemplate.update("inser into person values(1,'2')");
	}
	
	public void saveDepartmentB(Department department) throws Exception{
//		jdbcTemplate.update("insert into department values(1, '2')");
//		jdbcTemplate.update("insert into level values(1, '2')");
//		throw new RuntimeException();
		jdbcTemplate.update("update user set name = 'ppgogotest' where id = 5");
		List list = jdbcTemplate.queryForList("select * from user where name like 'ppgogo%'");
		System.err.println(list.size());
	}
	
	public void savePersonB(Department department) throws Exception{
		Person person = new Person();
		person.setDepartment(department);
		person.setName("neo");
		jdbcTemplate.update("insert into person values(1, '2', 2)");
		jdbcTemplate.update("insert into user values(1, 'test')");
	}
}
