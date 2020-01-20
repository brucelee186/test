package framework.Spring.transaction.service.impl;

import java.util.List;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;
import framework.Spring.transaction.dao.PersonDaoA;
import framework.Spring.transaction.dao.PersonDaoB;
import framework.Spring.transaction.service.PersonService;

public class PersonServiceImpl implements PersonService {
	private PersonDaoA personDaoA;
	
	private PersonDaoB personDaoB;

	public PersonDaoA getPersonDaoA() {
		return personDaoA;
	}


	public void setPersonDaoA(PersonDaoA personDaoA) {
		this.personDaoA = personDaoA;
	}


	public PersonDaoB getPersonDaoB() {
		return personDaoB;
	}


	public void setPersonDaoB(PersonDaoB personDaoB) {
		this.personDaoB = personDaoB;
	}


	@Override
	public List<Person> search() {
		return personDaoA.search();
	}


	@Override
	public void saveObject() throws Exception{
		personDaoA.saveObjectA();
	}

	public void savePerson(Department department) throws Exception {
		personDaoA.savePersonA(department);
	}

	public void saveDepartmetn(Department department) throws Exception {
		personDaoA.saveDepartmentA(department);
	}
}
