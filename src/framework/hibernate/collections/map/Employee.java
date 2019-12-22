package framework.hibernate.collections.map;

public class Employee {
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "id: " + this.id + " name: " + this.name;
	}
	
}
