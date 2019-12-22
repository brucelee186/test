<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<title>404</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/csslib/mtf-css.css" type="text/css"></link>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<div class="text" style="padding:5px">
	<%
	Cookie[] cookies = request.getCookies();
	boolean isok = false;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("userLocale".equals(cookie.getName())) {
				if (cookie.getValue().startsWith("zh")) {
%>
操作失败！ <b><font color="red">页面未找到。</font></b>
<%
					isok = true;
				}
				break;
			}
		}
	}
	
	if (!isok) {
%>
Operation Failed! <b><font color="red">Page not found.</font></b>
<%
	}
%>
	<br /><br />
</div>
</body>
</html>