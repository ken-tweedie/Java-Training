package myapp;

import myrepositories.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoConfig {

	public static void main(String[] args) {

		try {
			ApplicationContext  ctx = new ClassPathXmlApplicationContext("config.xml");
			EmployeesRepository rep = (EmployeesRepository) ctx.getBean("employeesRepository");
			
			int numEmps = rep.getEmployeesCount();
			System.out.println("[Config] Number of employees: " + numEmps);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
