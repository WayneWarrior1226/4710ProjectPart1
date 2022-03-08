<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<center>
		<title>PPS System</title>
	</center>
</head>
<body>
	<center>
		<h1>Sign Up Today!</h1>
	<h2>
		<a href = "index">Home</a>
		&nbsp;&nbsp;&nbsp;
	</h2>
	</center>
	<div align="center">
	
		<c:if test = "${pps != null }">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                        <c: if test = ${ }
                </h2>
            </caption>
               
		</table>
		</form>
	</div>
</body>
</html>