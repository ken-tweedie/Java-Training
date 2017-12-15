package myapp;

import mydomainmodel.Employee;
import mydomainmodel.Category;
import myrepositories.EmployeesRepository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoUpdates {

	public static void main(String[] args) {

		try {
			ApplicationContext  ctx = new ClassPathXmlApplicationContext("config.xml");
			EmployeesRepository rep = (EmployeesRepository) ctx.getBean("employeesRepository");
			
			Category c = new Category(-1, "Vitamins", "Vitamin tablets etc");
			if (rep.insertEmployee(c)) {
				System.out.println("Category inserted OK.");
			} else {
				System.out.println("Category not inserted.");
			}

			c = new Category(1, "Drinks", "All types of beverages");
			if (rep.updateEmployee(c)) {
				System.out.println("Category updated OK.");
			} else {
				System.out.println("Category not updated.");
			}

		/*	if (rep.deleteEmployee(8)) {
				System.out.println("Category deleted OK.");
			} else {
				System.out.println("Category not deleted.");
			}
			*/
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
