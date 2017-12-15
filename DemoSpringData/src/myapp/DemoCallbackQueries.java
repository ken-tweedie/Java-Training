package myapp;

import mydomainmodel.Employee;
import myrepositories.EmployeesRepository;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoCallbackQueries {

	public static void main(String[] args) {

		try {
			ApplicationContext  ctx = new ClassPathXmlApplicationContext("config.xml");
			EmployeesRepository rep = (EmployeesRepository) ctx.getBean("employeesRepository");
			
			Employee emp = rep.getEmployeeAsObject(2);
			System.out.println("Employee 2: " + emp.toString());

			List<Employee> emps = rep.getAllEmployeesAsObjects();
			System.out.println("\nAll Employees:");
			for (Employee e : emps) {
				System.out.println("Employee: " + e.toString());
			}
			
			System.out.println("\nReport on all employees:");
			rep.generateReport();

		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
