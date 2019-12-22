<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true" %>
<%@ page import="com.mtf.framework.exception.PmException" %>
<%@ page import="org.apache.log4j.Logger" %>
<%
if (exception instanceof PmException) {
	PmException ex = (PmException) exception;
	if (ex.getCode() == PmException.CODE_NOSESSION) {
		request.getRequestDispatcher("/WEB-INF/jsp/error/nosession.jsp").forward(request, response);
		return;
	}
} else {
	Logger logger = Logger.getLogger("SystemError");
	logger.error(exception);
}
%>
<!DOCTYPE HTML >
<html>
<head>
<title>error</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/csslib/mtf-css.css" type="text/css"></link>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
</head>
<body>
<div class="text" style="padding:5px">
系统错误！<br /><br />
<font color="red">
${exception.message}
</font>
</div>
</body>
</html>