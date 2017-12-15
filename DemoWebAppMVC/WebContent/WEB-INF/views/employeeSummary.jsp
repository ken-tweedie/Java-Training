<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Confirmation Page</title>
	<style> 
	.readonly { 
		background-color: lightblue; 
	} 
	</style> 

</head>
<body>

<h3>Thanks, here are the details you provided </h3>

<form:form commandName="employeeSummary">

	<table>
		<tr>
			<td> Name: </td>
			<td> <form:input path="name" readonly="true" cssClass="readonly" /> </td>
		</tr>
		<tr>
			<td> ID: </td>
			<td> <form:input path="id" readonly="true" cssClass="readonly" /> </td>
		</tr>
		<tr>
			<td> Salary: </td>
			<td> <form:input path="salary" readonly="true" cssClass="readonly" /> </td>
		</tr>
		<tr>
			<td> <a href="employee.htm">Home</a> </td>
		</tr>

	</table>
</form:form>
</body>
</html>