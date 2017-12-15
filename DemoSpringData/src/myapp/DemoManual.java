package myapp;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DemoManual{

	public static void main(String[] args) {

		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName("org.apache.derby.jdbc.ClientDriver");
			dataSource.setUrl("jdbc:derby://localhost:1527/C:/SpringDev/Databases/Employees");
			dataSource.setUsername("user");
			dataSource.setPassword("password");

			JdbcTemplate template = new JdbcTemplate(dataSource);
			int numEmps = template.queryForObject("SELECT COUNT(*) FROM MYSCHEMA.EMPLOYEES", Integer.class);

			System.out.println("[Manual] Number of employees: " + numEmps);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
