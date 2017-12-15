package mycallbacks;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

public class EmployeesReportWriter implements RowCallbackHandler {

	@Override
	public void processRow(ResultSet rs) throws SQLException {
		
		System.out.println("Employee: " + rs.getString("LastName") + 
				           " lives in: "   + rs.getString("City"));
	}
}
