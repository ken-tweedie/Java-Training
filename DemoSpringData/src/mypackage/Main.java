package mypackage;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Main {

	public static void main(String[] args) {

		try {
			DriverManagerDataSource dataSource = new DriverManagerDataSource();
			
			dataSource.setDriverClassName("com.mysql.jdbc.Driver");
			dataSource.setUrl("jdbc:mysql://localhost/northwind");
			dataSource.setUsername("root");
			dataSource.setPassword("Keep0ut01");

			JdbcTemplate template = new JdbcTemplate(dataSource);
			int numEmps = template.queryForObject("SELECT COUNT(*) FROM Employees", Integer.class);

			System.out.println("Number of employees: " + numEmps);
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
