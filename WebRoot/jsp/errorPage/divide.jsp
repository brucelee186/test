
<%@ page language="java" errorPage="error.jsp" contentType="text/html;  charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Divide</title>
	</head>
	<body bgcolor="#FFFFFF">
		<center>
			<br>
			<h1>
				<%
					int dividend = 0;
					int divisor = 0;
					int result = 0;
					try {
						dividend = Integer.parseInt(request.getParameter("value1"));
					} catch (NumberFormatException nfex) {
						throw new NumberFormatException("被除数不是整数! ");
					}
					try {
						divisor = Integer.parseInt(request.getParameter("value2"));
					} catch (NumberFormatException nfex) {
						throw new NumberFormatException("除数不是整数! ");
					} 
					result = dividend / divisor;
					out.println(dividend + " / " + divisor + " = " + result);
				%>
			</h1>
			<br>
			<br>
			<br>
			<a href="javascript: history.back();">返回</a>
		</center>
	</body>
</html>

