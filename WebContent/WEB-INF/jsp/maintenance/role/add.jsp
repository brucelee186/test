<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Add Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	var goEditActions = false;
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/role/doAdd.do',
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
							description : '',
							status : 0
						});
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							if (goEditActions) {
								var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/role/toEditActions.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', r.obj.id);
								top.layout_center_addTab({
									title : formatString('Edit Role [{0}] Actions', r.obj.name),
									closable : true,
									iconCls : 'icon-ruby-edit',
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
	<div data-options="region:'center',title:'Role Info',border:false" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" selected="selected">0</option>
						<option value="1">1</option>
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
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select id="combobox_status" class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit_form(false);"><s:message code="common.button.submit" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submit_form(true);">Continue to Edit Actions</a>
		</div>
		<script>
			function submit_form(opt) {
				goEditActions = opt;
				$('#form').submit();
			}
		</script>
	</div>
</body>
</html>