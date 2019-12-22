package framework.Spring.transaction.dao;

import java.util.List;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.bean.Person;


public interface PersonDaoB {
	public List<Person> search();
	
	public void saveObjectB() throws Exception;
	
	public void saveDepartmentB(Department department) throws Exception;
	
	public void savePersonB(Department department) throws Exception;
}
