<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Add Action</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var goEditResources = false;
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/admin/action/doAdd.do',
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
							level : '1',
							system : 0,
							description : '',
							status : 0
						});
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							if (goEditResources) {
								var content = formatString('<iframe src="${pageContext.request.contextPath}/admin/action/toEditResources.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', r.obj.id);
								top.layout_center_addTab({
									title : formatString('Edit Action [{0}] Resources', r.obj.name),
									closable : true,
									iconCls : 'icon-lightning-go',
									content : content
								});
							}
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
	<div data-options="region:'center',title:'Action Info',border:false" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
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
					<th>System : </th>
					<td><select id="combobox_system" class="easyui-combobox" name="system" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" selected="selected"><s:message code="common.choose.no" /></option>
						<option value="1"><s:message code="common.choose.yes" /></option></select></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select id="combobox_status" class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false,disabled:true ">
						<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit_form(false);"><s:message code="common.button.submit" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit_form(true);">Continue to Edit Resources</a>
			</div>
		</form>
		<script type="text/javascript" charset="utf-8">
			function submit_form(opt) {
				goEditResources = opt;
				$('#form').submit();
			}
		</script>
	</div>
</body>
</html>