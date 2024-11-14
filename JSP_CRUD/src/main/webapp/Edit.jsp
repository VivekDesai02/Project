<%@page import="empDao.EmpMySql"%>
<%@page import="pojo.EmpPojo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Data</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<style type="text/css">
	
	
	
	
	
	
</style>
</head>
<body>
<div id="ide">
<h1>Update Data</h1>
	<%
		EmpPojo ep = new EmpPojo();
		int id = Integer.parseInt(request.getParameter("id"));
		EmpMySql ems = new EmpMySql();
		ep = ems.IdView(id);
	%>
	
	<form action="update">
		<label>Id: </label>
		<input type="text" name="id" value=<%=ep.getId() %> readonly="readonly" class="inStyle"><br>
		<br>
		<label>Name: </label>
		<input type="text" name="name" value=<%=ep.getName() %>  class="inStyle"><br>
		<br>
		<label>City: </label>
		<input type="text" name="city" value=<%=ep.getCity() %>  class="inStyle"><br>
		<br>
		<label>Salary: </label>
		<input type="text" name="salary" value=<%= ep.getSalary() %> class="inStyle"><br><br>
		<input type="submit" value="Update" class="Edit">
		<a href="empData.jsp" class="Edit">Back</a>
		
		</form>
</div>
</body>

</html>