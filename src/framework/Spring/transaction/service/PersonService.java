package framework.Spring.transaction.service;

import java.util.List;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;

public interface PersonService {
	public List<Person> search();
	
	public void saveObject() throws Exception;
	
	public void savePerson(Department department) throws Exception;

	public void saveDepartmetn(Department department) throws Exception;
}
