<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration Page</title>
</head>
<body>

<h3>Please enter your details, and then click Submit</h3>

<form:form commandName="employee" action="employee.htm">

	<table>
		<tr>
			<td> Name: </td>
			<td> <form:input path="name" /> </td>
		</tr>
		<tr>
			<td> ID: </td>
			<td> <form:input path="id" /> </td>
		</tr>
		<tr>
			<td> Salary: </td>
			<td> <form:input path="salary" /> </td>
		</tr>
		<tr>
			<td> <input type="submit" value="Submit" /> </td>
		</tr>

	</table>
</form:form>

</body>
</html>