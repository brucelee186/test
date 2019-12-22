<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% Object obj = new Object(); 
session.setAttribute("test", "hello,EL");
%>

<!-- isErrorPage的作用设置当前页面为错误页面，当在别的页面设置errorPage="error.jsp" 后，在设置页面出现问题后就自动会跳转到当前的错误页面 -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Compute error</title>
	</head>
	<body bgcolor="#FFFFFF">
		<div align="center">
			<br>
			<br>
			<h1>
				错误信息<%=obj %>
				EL:${sessionScope.test}
			</h1>
			<hr>
			<p>
			<h3><%=exception.toString()%></h3>
			<br>
			<br>
			<br>
			<a href="javascript: history.back();">返回</a>
		</div>
	</body>
</html>
