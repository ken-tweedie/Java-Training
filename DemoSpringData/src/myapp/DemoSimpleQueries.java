package myapp;

import myrepositories.*;
import java.util.Map;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoSimpleQueries {

	public static void main(String[] args) {

		try {
			ApplicationContext  ctx = new ClassPathXmlApplicationContext("config.xml");
			EmployeesRepository rep = (EmployeesRepository) ctx.getBean("employeesRepository");
			
			int numEmps = rep.getEmployeesCount();
			System.out.println("Number of employees: " + numEmps);
			
			Map<String,Object> emp = rep.getEmployeeAsMap(1);
			System.out.println("Employee 1 details: " );
			displayEmp(emp);
			
			List<Map<String,Object>> emps = rep.getAllEmployees();
			System.out.println("All Employees: " );
			for (Map<String,Object> e : emps) {
				displayEmp(e);
			}
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	private static void displayEmp(Map<String, Object> emp) {
		for (String key: emp.keySet()) {
			System.out.print(key + "==>" + emp.get(key) + "\t");
		}
		System.out.println();
	}
}
