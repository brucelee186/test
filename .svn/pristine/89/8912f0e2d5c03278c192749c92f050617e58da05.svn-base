package framework.Spring.transaction.action;

import framework.Spring.transaction.bean.Department;
import framework.Spring.transaction.service.PersonService;


public class PersonAction {
	private PersonService personServiceA;
	
	public PersonService getPersonService() {
		return personServiceA;
	}

	public void setPersonService(PersonService personService) {
		this.personServiceA = personService;
	}
	
	public String searchPerson() {
		String res = "searchPerson";
		personServiceA.search();
		return res;
	}
	
	public void execute() throws Exception {
		personServiceA.savePerson(new Department());
	}
}
