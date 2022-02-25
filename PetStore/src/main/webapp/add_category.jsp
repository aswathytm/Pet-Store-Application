<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add  category Data</title>
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
<caption>Add Category Details</caption>
<form action=AddCategory method ="post">
<tr>
	<th>Category name:</th>
	<td><input type = "text" name = "name" required><br></td>
</tr>

	<th>submit:</th>
	<td><input type = "submit" value = "submit"></td>
</tr>
</form>
</table>
</div>
</body>
</html>

