<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Division [${division.name}]</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/division/doEdit.do',
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
			<input type="hidden" name="id" value="${division.id}" />
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Chinese Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" value="${division.name}" data-options="required:true" /></td>
					<td></td>
				</tr>
				<tr>
					<th style="width: 150px;">English Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="nameEng" value="${division.name}" data-options="required:false" /></td>
					<td></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;">${division.description}</textarea></td>
					<td></td>
				</tr>
				<tr>
					<th>Parent Division : </th>
					<td><input id="combotree_pid" class="easyui-combotree" name="pid" value="${division.pid}" style="width:250px;" /></td>
					<td><img src="${pageContext.request.contextPath}/images/icons/cancel.png" onclick="$('#combotree_pid').combotree('clear');" /></td>
				</tr>
				<tr>
					<th>Tag : </th>
					<td><select class="easyui-combobox" name="tag" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" <c:if test="${division.tag == 0}">selected="selected"</c:if>>[General]</option>
						<option value="100" <c:if test="${division.tag == 100}">selected="selected"</c:if>>CFT</option>
						<option value="101" <c:if test="${division.tag == 101}">selected="selected"</c:if>>PM</option>
						<option value="102" <c:if test="${division.tag == 102}">selected="selected"</c:if>>MS</option></select></td>
					<td></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false,disabled:true ">
						<option value="0" <c:if test="${division.status == 0}">selected="selected"</c:if>><s:message code="common.status.enabled" /></option>
						<option value="1" <c:if test="${division.status == 1}">selected="selected"</c:if>><s:message code="common.status.disabled" /></option></select>
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