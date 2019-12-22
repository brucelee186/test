<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<c:forEach items="${listUserDivision}" var="userDivision" varStatus="status">
	<input type="checkbox" name="userIdList" value="${userDivision.userId}" <c:if test="${userDivision.checked == '1'}">checked="checked"</c:if> onClick="checkedSync(this)" class="classArrayUser classArrayUser${userDivision.userId}" >${userDivision.displayName}</input>
	<input type="checkbox" style="display: none;" name="userNameList" value="${userDivision.displayName}" class="classArrayUser classArrayUser${userDivision.userId}" ></input>
	<c:if test="${status.count%5==0}" >
        </br>
    </c:if>
</c:forEach>