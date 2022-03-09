<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<center>
	<title>PPS System</title>
</center>
</head>
<body>
	<center>
		<h1>Sign In!</h1>
		<h2>
			<a href="index.jsp">Home</a> &nbsp;&nbsp;&nbsp;
		</h2>
	</center>
	<div align="center">
		<form method="post" action="controllerServlet">
			<table border="1" cellpadding="5">
				<tr>
					<th>User Name</th>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="pass" /></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Log in" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>