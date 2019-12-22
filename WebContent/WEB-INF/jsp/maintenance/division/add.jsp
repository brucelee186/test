<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Add Division</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/division/doAdd.do',
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
							description : '',
							status : 0
						});
						$('#combotree_pid').combotree('clear');
						$('#combotree_pid').combotree('reload');
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		$('#combotree_pid').combotree({
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			lines : true
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'Division Info',border:false" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Name CH : </th>
					<td><input id="txt_name" class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
					<td></td>
				</tr>
				<tr>
					<th style="width: 150px;">Name EN: </th>
					<td><input id="txt_name" class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
					<td></td>
				</tr>
				<tr>
					<th>Parent Division : </th>
					<td><input id="combotree_pid" class="easyui-combotree" name="pid" style="width:250px;" /></td>
					<td><img src="${pageContext.request.contextPath}/images/icons/cancel.png" onclick="$('#combotree_pid').combotree('clear');" /></td>
				</tr>
				<tr>
					<th>Tag : </th>
					<td><select class="easyui-combobox" name="tag" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" selected="selected">[General]</option>
						<option value="100">CFT</option>
						<option value="101">PM</option>
						<option value="102">MS</option></select></td>
					<td></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false,disabled:true ">
						<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td>
					<td></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
			</div>
		</form>
	</div>
</body>
</html>