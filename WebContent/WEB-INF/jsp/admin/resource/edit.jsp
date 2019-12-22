<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Resource</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/admin/resource/doEdit.do',
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
	<div data-options="region:'center',title:'Edit Resource',border:false" align="center">
		<form id="form" method="post">
			<input type="hidden" name="id" value="${resource.id}" />
			<input type="hidden" name="actionId" value="${resource.actionId}" />
			<table class="tableForm">
				<tr>
					<th width="150px">Name : </th>
					<td><input class="easyui-validatebox" type="text" value="${resource.name}" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>URI : </th>
					<td><input class="easyui-validatebox" type="text" value="${resource.uri}" style="width: 250px" name="uri" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="1" <c:if test="${resource.level == 1}">selected="selected"</c:if>>1</option>
						<option value="2" <c:if test="${resource.level == 2}">selected="selected"</c:if>>2</option>
						<option value="3" <c:if test="${resource.level == 3}">selected="selected"</c:if>>3</option>
						<option value="4" <c:if test="${resource.level == 4}">selected="selected"</c:if>>4</option>
						<option value="5" <c:if test="${resource.level == 5}">selected="selected"</c:if>>5</option>
						<option value="6" <c:if test="${resource.level == 6}">selected="selected"</c:if>>6</option>
						<option value="7" <c:if test="${resource.level == 7}">selected="selected"</c:if>>7</option>
						<option value="8" <c:if test="${resource.level == 8}">selected="selected"</c:if>>8</option>
						<option value="9" <c:if test="${resource.level == 9}">selected="selected"</c:if>>9</option></select></td>
				</tr>
				<tr>
					<th>Access : </th>
					<td><select class="easyui-combobox" name="access" style="width:250px" data-options="panelHeight:'auto',editable:false">
							<option value="1" <c:if test="${resource.access == 1}">selected="selected"</c:if>>Anonymous</option>
							<option value="2" <c:if test="${resource.access == 2}">selected="selected"</c:if>>Session</option>
							<option value="3" <c:if test="${resource.access == 3}">selected="selected"</c:if>>Role</option></select></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;">${resource.description}</textarea></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
			</div>
		</form>
	</div>
</body>
</html>