<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>My Profile</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/user/doEditProfile.do',
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
				} else {
					$.messager.progress('close');	// hide progress bar while the form is invalid
				}
				return isValid;	// return false will stop the form submission
			},
			success : function(result) {
				$.messager.progress('close');	// hide progress bar while submit successfully
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'My Profile',border:false" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<th width="120px">Login Name :</th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" readonly="readonly" value="${user.loginName }" /></td>
				</tr>
				<tr>
					<th>Full Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="userProfile.fullname" data-options="required:true, validType:'length[1,30]'" value="${user.userProfile.fullname}"/></td>
				</tr>
				<tr>
					<th>Email : </th>
					<td><input id="txt_email" class="easyui-validatebox" type="text" style="width: 250px" name="userProfile.email" data-options="validType:'email'" value="${user.userProfile.email}" /></td>
				</tr>
				<tr>
					<th>Language : </th>
					<td><select id="combobox_language" class="easyui-combobox" name="userProfile.language" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="en" <c:if test="${user.userProfile.language == 'en' or user.userProfile.language == 'en_US'}"> selected="selected" </c:if>><s:message code="common.language.english"/></option>
						<option value="zh" <c:if test="${user.userProfile.language == 'zh' or user.userProfile.language == 'zh_CN'}"> selected="selected" </c:if>><s:message code="common.language.chinese"/></option></select></td>
				</tr>
				<tr>
					<th>Signature : </th>
					<td><select id="combobox_language" class="easyui-combobox" name="userProfile.language" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="en" <c:if test="${user.userProfile.language == 'en' or user.userProfile.language == 'en_US'}"> selected="selected" </c:if>><s:message code="common.language.english"/></option>
						<option value="zh" <c:if test="${user.userProfile.language == 'zh' or user.userProfile.language == 'zh_CN'}"> selected="selected" </c:if>><s:message code="common.language.chinese"/></option></select></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
			</div>
		</form>
	</div>
</body>
</html>