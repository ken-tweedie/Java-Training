package mypackage;

public class Employee {

    private String name;
	private int id;
	private double salary;

	public Employee() {
	}

	public Employee(int id) {
		this.id = id;
		this.name = "Employee" + id;
		this.salary = 90000;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
}
