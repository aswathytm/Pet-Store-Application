<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show pet details</title>
<style>
table{
border-collapse:collapse;
}
</style>
</head>
<body>
<div>     
       <a href="list.jsp">Cancel</a> <br>  
</div>
<div align="center">
 <table border="1" cellpadding="5">
<caption>show Pet Details</caption>
<form action=selectpet.jsp method ="get">
<tr>
	<th>id:</th>
	<td><input type = "text"   value = "<c:out value="${param.id}"/>" name = "id" required><br></td>
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

