package mycallbacks;

import java.sql.ResultSet;
import java.sql.SQLException;

import mydomainmodel.Employee;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNumber) throws SQLException {

		return new Employee(rs.getInt("EmployeeID"),
				            rs.getString("LastnameName"),
				            rs.getString("City"));
	}
}
