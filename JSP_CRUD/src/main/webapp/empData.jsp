<%@page import="empDao.EmpMySql"%>
<%@page import="java.util.ArrayList"%>
<%@page import="pojo.EmpPojo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee Data</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<link rel="stylesheet" type="text/css" href="Home.css">
<style type="text/css">
	
	td,tr{
		padding: 10px;	
	}
</style>
</head>
<body >
<div id="home">
<h1>Employee Data</h1>

<a href="Add.jsp" class="Edit">Add</a>

<table border="1"  style="margin: 10px ">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>city</th>
		<th>Salary</th>
		<th colspan="2">Action</th>
	</tr>
	<%
		List<EmpPojo> ep = new ArrayList();
		EmpMySql es = new EmpMySql();
		ep = es.ViawData();
		for(EmpPojo i:ep){
	%>
		<tr>
			<td><%= i.getId() %></td>
			<td><%= i.getName() %></td>
			<td><%= i.getCity() %></td>
			<td><%= i.getSalary() %></td>
			<td><a href="Edit.jsp?id=<%=i.getId()%>" class="Edit">update</a></td>
			<td><a href="del?id=<%=i.getId() %>"class="Edit">Delete</a> </td>
		</tr>
		
	<%
		}
	%>
</table>
</div>
</body>
</html>