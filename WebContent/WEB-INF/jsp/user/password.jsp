<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Update Password</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/user/doPassword.do',
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
						$('#form').form('load', {
							pwdOld : '',
							pwdNew : '',
							pwdNew1 : ''
						});
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							top.layout_center_closeTab();
						});
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
	<div data-options="region:'center',title:'Update [${sessionInfo.displayName}] Password',border:false" align="center">
		<form id="form" method="post">
			<input type="hidden" name="id" value="${sessionInfo.userId}" />
			<table class="tableForm">
				<tr>
					<th width="200px">Name : </th>
					<td><input class="easyui-validatebox" type="text" readonly="readonly" value="${sessionInfo.displayName}" style="width: 250px" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
				<tr>
					<th>Current Password : </th>
					<td><input class="easyui-validatebox" type="password" style="width: 250px" name="pwdOld" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
				<tr>
					<th>New Password : </th>
					<td><input id="txt_pwdNew" class="easyui-validatebox" type="password" style="width: 250px" name="pwdNew" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
				<tr>
					<th>Confirm Password : </th>
					<td><input class="easyui-validatebox" type="password" style="width: 250px" name="pwdNew1" required="required" validType="equals['#txt_pwdNew']" /></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
		</div>
	</div>
</body>
</html>