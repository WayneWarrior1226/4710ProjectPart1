<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>You are logged in</h2>
<ul>
<li>
<p><b>User Name: ${param.userid}</b>
<p><b>Password: ${param.pass}</b>
<li colspan="2" align="center"><input type="submit"value="Initialize Database" /></li>
  
</p></li>
</ul>

</body>
</html>