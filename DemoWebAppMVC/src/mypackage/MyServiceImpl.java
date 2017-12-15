package mypackage;

import java.util.Date;

public class MyServiceImpl implements MyService {
	
	private String property1 = "InitValue";
	private int    property2 = -1;
	
	public String getProperty1() {
		return property1;
	}

	public void setProperty1(String property1) {
		this.property1 = property1;
	}

	public int getProperty2() {
		return property2;
	}

	public void setProperty2(int property2) {
		this.property2 = property2;
	}

	public Date getTimestamp() {
		return new Date();
	}

	public String getMessage() {
		String result = String.format("property1=%s, property2=%d", property1, property2);
		return result;
	}
}
