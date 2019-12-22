package framework.hibernate.collections.array;



public class Department {
	private int id;
	private String name;
	private Employee[] employeeArray;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Employee[] getEmployeeArray() {
		return employeeArray;
	}
	public void setEmployeeArray(Employee[] employeeArray) {
		this.employeeArray = employeeArray;
	}
	
}
