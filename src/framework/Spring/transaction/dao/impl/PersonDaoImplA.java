package framework.Spring.transaction.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;
import framework.Spring.transaction.dao.PersonDaoA;
import framework.Spring.transaction.dao.PersonDaoB;

public class PersonDaoImplA implements PersonDaoA {
	private JdbcTemplate jdbcTemplate;
	private PersonDaoB personDaoB;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public PersonDaoB getPersonDaoB() {
		return personDaoB;
	}

	public void setPersonDaoB(PersonDaoB personDaoB) {
		this.personDaoB = personDaoB;
	}

	public List<Person> search() {
		List<Person> personList = null;
		System.err.println(personList);
		return personList;
	}

	public void saveObjectA() throws Exception{
	}
	
	public void saveDepartmentA(Department department) throws Exception{
		department.setName("technology");
		jdbcTemplate.update("insert into department values(1, '2')");
		jdbcTemplate.update("insert into level values(1, '2')");
	}
	
	public void savePersonA(Department department) throws Exception{
/*		jdbcTemplate.update("insert into person values(1, '2', 2)");
		jdbcTemplate.update("insert into user values(1, 'test')");*/
//		throw new RuntimeException();
		List list = jdbcTemplate.queryForList("select * from user where name like 'ppgogo%'");
		System.err.println(list.size());
		list = jdbcTemplate.queryForList("select * from user where id = 5");
		System.err.println(list.get(0));
//		jdbcTemplate.update("update user set name = 'ppgogotest' where id = 5");
		personDaoB.saveDepartmentB(department);
		list = jdbcTemplate.queryForList("select * from user where id = 5");
		System.err.println(list.get(0));
		list = jdbcTemplate.queryForList("select * from user where name like 'ppgogo%'");
		System.err.println(list.size());
	}
}
