<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<input>动态引用相当于本页添加了一部门代码,两者合为一体,不同引用页之间代码独立,并可传参数,静态引用只是单纯的一个引用,不同页之间的操作,相互关联,不可传参</input>
	<jsp:include page="nonStaticInclude.jsp" flush="true">
		<jsp:param value="1" name="p1"/>
	</jsp:include>
	
	<%@include file="staticInclude.jsp" %>
</body>
</html>