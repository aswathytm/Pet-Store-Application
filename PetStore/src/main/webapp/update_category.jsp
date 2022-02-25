<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Data</title>
<style>
table{
border-collapse:collapse;
}
</style>
</head>
<body>
<div>     
       <a href="category.jsp">Cancel</a> <br>  
</div>
<div align="center">
 <table border="1" cellpadding="5">
<caption>Update Category Details</caption>
<form action=UpdateCategory method ="post">
<tr>
	<th>id:</th>
	<td><input type = "text"  value ="<c:out value="${param.id}"/>"  name = "id"><br></td>
</tr>
<tr>
	<th>name:</th>
	<td><input type = "text"  value = "<c:out value="${param.name}"/> "name="name"><br></td>
</tr>
<tr>
	<th>submit:</th>
	<td><input type = "submit" value = "submit"></td>
</tr>
</form>
</table>
</div>
</body>
</html>

