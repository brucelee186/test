<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>reportEmp</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showPurchase.cpt&__bypagesize__=false";
	window.location.href = url;
</script>
</head>
<body>
</body>
</html>