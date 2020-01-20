<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Forbidden</title>
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
操作失败， <b><font color="red">${errorMsg}</font></b><br />
请联系管理员以进行授权设置！<br /><br />

信息:<br />
<table>
<tr><td style="width:60px">资源</td><td>: ${uri}</td></tr>
<tr><td>时间</td><td>: ${datetime}</td></tr>
<tr><td>代码</td><td>: ${errorCode}</td></tr>
<tr><td>消息</td><td>: ${errorMsg}</td></tr>
</table>
<%
					isok = true;
				}
				break;
			}
		}
	}
	
	if (!isok) {
%>
Operation Canceled, <b><font color="red">${errorMsg}</font></b><br />
Contact your administrator for authorization setting!<br /><br />

Detail:<br />
<table>
<tr><td style="width:60px">Resource</td><td>: ${uri}</td></tr>
<tr><td>Datetime</td><td>: ${datetime}</td></tr>
<tr><td>Checkcode</td><td>: ${errorCode}</td></tr>
<tr><td>Message</td><td>: ${errorMsg}</td></tr>
</table>
<%
	}
%>
</div>
</body>
</html>