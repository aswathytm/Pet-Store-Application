<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PetStore</title>
			<style>
				table{
					border-collapse:collapse;
					}
			</style>
	</head>
<body>
	<div align="center">
 		<table border="1" cellpadding="5">
			<caption>LOGIN Page</caption>
			<form action="login" method ="post">
				<tr>
					<th>User Name:</th>
					<td><input type = "text" name = "username" required><br></td>
				</tr>
				<tr>
					<th>Password:</th>
					<td><input type = "text" name = "password" required><br></td>
				<tr>
					<th>submit:</th>
					<td><input type = "submit" value = "submit"></td>
				</tr>
			</form>
		</table>
	</div>
</body>
</html>

