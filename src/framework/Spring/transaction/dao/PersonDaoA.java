package framework.Spring.transaction.dao;

import java.util.List;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;


public interface PersonDaoA {
	public List<Person> search();
	
	public void saveObjectA() throws Exception;
	
	public void saveDepartmentA(Department department) throws Exception;
	
	public void savePersonA(Department department) throws Exception;
}
