package mydomainmodel;

public class Employee {

	private int employeeID;
	private String name;
	private String region;
	
	public Employee(int employeeID, String name, String region) {
		this.employeeID = employeeID;
		this.name = name;
		this.region = region;
	}
	
	@Override
	public String toString() {
		return String.format("[%d] %s, £%.2f, %s", employeeID, name, region);
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
}
