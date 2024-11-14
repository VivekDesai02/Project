<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Data</title>
<link rel="stylesheet" type="text/css" href="Style.css">
<style type="text/css">
	
	
</style>
</head>
<body>
<div id="ide">
<h1>Add New Data</h1>

<form action="Insert">
	<input type="text" name="name" placeholder="Enter Name" class="inStyle" ><br><br>
	<input type="text" name="city" placeholder="Enter City" class="inStyle" ><br><br>
	<input type="text" name="salary" placeholder="Enter salary" class="inStyle" ><br><br>
	<input type="submit" class="Edit">
	<a href="empData.jsp" class="Edit">Back</a>
</form>
</div>
</body>
</html>