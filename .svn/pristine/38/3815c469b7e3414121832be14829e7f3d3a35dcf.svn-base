<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Add Resource</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/admin/resource/doAdd.do',
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
						$('#form').form('load',{
							name : '',
							uri : '',
							level : '1',
							access : '3',
							description : ''
						});
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
	<div data-options="region:'center',title:'Add Resource',border:false" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<th width="150px">Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>URI : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="uri" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="1" selected="selected">0</option>
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option></select></td>
				</tr>
				<tr>
					<th>Access : </th>
					<td><select class="easyui-combobox" name="access" style="width:250px" data-options="panelHeight:'auto',editable:false">
							<option value="1">Anonymous</option>
							<option value="2">Session</option>
							<option value="3" selected="selected">Role</option></select></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
			</div>
		</form>
	</div>
</body>
</html>