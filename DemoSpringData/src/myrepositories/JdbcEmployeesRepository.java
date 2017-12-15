package myrepositories;

import java.util.List;
import java.util.Map;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import mycallbacks.EmployeeRowMapper;
import mycallbacks.EmployeesReportWriter;
import mydomainmodel.Employee;
import mydomainmodel.Category;


public class JdbcEmployeesRepository implements EmployeesRepository {

	private JdbcTemplate template;

	public JdbcEmployeesRepository(DataSource ds) {
		this.template = new JdbcTemplate(ds);
	}

	// Demonstrate queryForObject(), to get an int.
	public int getEmployeesCount() {
		return template.queryForObject("SELECT COUNT(*) FROM Employees", Integer.class);
	}

	// Demonstrate queryForObject(), to get a long.
	public long getRevenue() {
		return template.queryForObject("SELECT SUM(UnitPrice * Quantity) Revenue FROM order_details", Long.class);
	}
	
	// Demonstrate queryForMap().
	public Map<String,Object> getEmployeeAsMap(int empID) {
		String sql = "SELECT * FROM Employees WHERE EmployeeID=?";
		return template.queryForMap(sql, empID);
	}
	
	// Demonstrate queryForList().
	public List<Map<String,Object>> getAllEmployees() {
		return template.queryForList("SELECT * FROM Employees");
	}

	// Demonstrate queryForObject(sql, RowMapper).
	public Employee getEmployeeAsObject(int empID) {
		String sql = "SELECT * FROM Employees WHERE EmployeeID=?";
		return template.queryForObject(sql, new EmployeeRowMapper(), empID);
	}

	// Demonstrate query(sql, RowMapper).
	public List<Employee> getAllEmployeesAsObjects() {
		String sql = "SELECT * FROM Employees";
		return template.query(sql, new EmployeeRowMapper());
	}

	// Demonstrate query(sql, RowCallbackHandler).
	public void generateReport() {
		String sql = "SELECT * FROM Employees";
		template.query(sql, new EmployeesReportWriter());
	}

	// Demonstrate update() to do an insert.
	public boolean insertEmployee(Category c) {
		String sql = "INSERT INTO Categories (CategoryName, Description) VALUES (?, ?)";
		return 1 == template.update(sql, c.getName(), c.getDescription());
	}

	// Demonstrate update() to do an update.
	public boolean updateEmployee(Category c) {
		String sql = "UPDATE Categories SET CategoryName=?, Description=? WHERE CategoryID=?";
		return 1 == template.update(sql, c.getName(), c.getDescription(), c.getId());
	}
	
	// Demonstrate update() to do an update.
	public boolean deleteEmployee(int categoryID) {
		String sql = "DELETE FROM Categories WHERE CategoryID=?";
		return 1 == template.update(sql, categoryID);
	}
}
