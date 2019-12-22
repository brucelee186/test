package framework.hibernate.one2one.uniqueForeignKey;

import java.util.Date;

public class IdCard {
	private int id;
	private Date authorizeDate;
	private Person person;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAuthorizeDate() {
		return authorizeDate;
	}
	public void setAuthorizeDate(Date authorizeDate) {
		this.authorizeDate = authorizeDate;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
}
