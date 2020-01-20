<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<title>No Session</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/csslib/mtf-css.css" type="text/css"></link>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<input type="hidden" value="flag_nosession" />
<div class="text" style="padding:5px">
<%
	Cookie[] cookies = request.getCookies();
	boolean isok = false;
	if (cookies != null) {
		for (Cookie cookie : cookies) {
			if ("userLocale".equals(cookie.getName())) {
				if (cookie.getValue().startsWith("zh")) {
%>
登录超时或未登录，请先<a href="javascript:void(0)" onclick="javascript:top.location='${pageContext.request.contextPath}/';"><b>登录</b></a>。
<%
					isok = true;
				}
				break;
			}
		}
	}
	
	if (!isok) {
%>
Session timeout, Please <a href="javascript:void(0)" onclick="javascript:top.location='${pageContext.request.contextPath}/';"><b>Login</b></a> first.
<%
	}
%>
<br />
</div>
</body>
</html>