<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Unit Management</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			border : false,
			url : '${pageContext.request.contextPath}/maintenance/unit/doSearch.do',
			pagination : false,
			idField : 'id',
			sortName : 'from',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}, {
				title : '<s:message code="p_main.maintenacte.goods.unit" />',
				field : 'name',
				width : 150,
				sortable : true
			}, {
				title : '<s:message code="p_main.maintenacte.goods.status" />',
				field : 'status',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.status.enabled" />';
					} else if (value == 1) {
						return '<s:message code="common.status.disabled" />';
					}
				},
				styler: function(value, row, index){
					if (value == 0){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : '<s:message code="common.button.add" />',
				handler : function() {
					$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/unit/doAdd.do');
					$('#form').form('load', {
						id : '',
						name : '',
						status : 0
					});
					$('#dialog').dialog('setTitle', 'Add');
					$('#dialog').dialog('open');
				}
			},'-',{
				iconCls : 'icon-edit',
				text : '<s:message code="common.button.edit" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					} else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					}
					$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/unit/doEdit.do');
					$('#form').form('load', {
						id : checkedRows[0].id,
						name : checkedRows[0].name,
						status : checkedRows[0].status
					});
					$('#dialog').dialog('setTitle', 'Edit');
					$('#dialog').dialog('open');
				}
			},'-',{
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.delete" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					} else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					}
					$.messager.alert('<s:message code="common.dialog.tip" />', '暂不支持删除功能!', 'warning');
				}
			}]
		});
		
		$('#form').form({
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
							$('#dialog').dialog('close');
							$('#datagrid').datagrid('reload');
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
	<div id="dialog" class="easyui-dialog" title="Edit" style="width:400px;height:150px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
		<form id="form" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th style="width: 150px;"><s:message code="p_main.maintenacte.goods.unit" />: </th>
					<td><input class="easyui-validatebox" name="name" style="width:250px" data-options="required:true" /></td>
				</tr>
				<tr>
					<th><s:message code="p_main.maintenacte.goods.status" />: </th>
					<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dialog_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<div data-options="region:'center',title:'Unit List',border:false">
		<table id="datagrid"></table>
	</div>
</body>
</html>