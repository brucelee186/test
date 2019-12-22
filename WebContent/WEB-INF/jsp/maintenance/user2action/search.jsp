<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit User [${user.loginName}] Actions</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			fitColumns : true,
			url : '${pageContext.request.contextPath}/maintenance/user2action/doSearch.do',
			border : false,
			pagination : false,
			idField : 'id',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				hidden : true
			}, {
				title : 'Action',
				field : 'actionId',
				width : 250,
				sortable : false,
				formatter : function(value, row, index) {
					return row.action.name;
				},
			}, {
				title : 'Allow',
				field : 'allow',
				sortable : true,
				width : 150,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.choose.no" />';
					} else if (value == 1) {
						return '<s:message code="common.choose.yes" />';
					}
				},
				styler: function(value, row, index){
					if (value == 1){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 0) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : false,
				formatter : function(value, row, index) {
					return row.action.level;
				},
			}, {
				title : 'Description',
				field : 'description',
				sortable : false,
				width : 250,
				formatter : function(value, row, index) {
					return row.action.description;
				},
			} ] ],
			queryParams: {
				userId : '${user.id}'
			},
			toolbar : [{
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.remove" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					} else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					}
					$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
						if (r) {
							$.post("${pageContext.request.contextPath}/maintenance/user2action/doDelete.do", { id : checkedRows[0].id }, function(result) {
								try {
									var j = $.parseJSON(result);
									if (j.success) {
										$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
											$('#datagrid').datagrid("reload");
										});
									} else {
										$.messager.alert('<s:message code="common.dialog.error" />', j.msg, 'error');
									}
								} catch (e) {
									$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
								}
							});
						}
					});
				}
			}, '-', {
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
					$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/user2action/doEdit.do');
					$('#form').form('load', {
						id : checkedRows[0].id,
						userId : '${user.id}',
						actionId : checkedRows[0].action.id,
						actionName : checkedRows[0].action.name,
						allow : checkedRows[0].allow
					});
					$('#dialog').dialog('setTitle', 'Edit');
					$('#dialog').dialog('open');
				}
			}],
			queryParams: {
				userId : '${user.id}'
			}
		});
		
		$('#datagrid_action').datagrid({
			fit : true,
			fitColumns : true,
			border : false,
			url : '${pageContext.request.contextPath}/maintenance/action/doSearchNonSystem.do',
			pagination : false,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				hidden : true
			}, {
				title : 'Action',
				field : 'name',
				width : 200,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : true
			}, {
				title : 'Description',
				field : 'description',
				sortable : true,
				width : 100
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : 'Add to User',
				handler : function() {
					var checkedRows = $('#datagrid_action').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rows = $('#datagrid').datagrid('getRows');
					var isExists = false;
					for(var j = 0; j < rows.length; j++) {
						if (rows[j].action.id == checkedRows[0].id) {
							isExists = true;
							break;
						}
					}
					if (isExists) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '不能重复添加', 'info');
					} else {
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/user2action/doAdd.do'),
						$('#form').form('load', {
							id : '',
							userId : '${user.id}',
							actionId : checkedRows[0].id,
							actionName : checkedRows[0].name,
							allow : 0
						});
						$('#dialog').dialog('setTitle', 'Add');
						$('#dialog').dialog('open');
					}
				}
			}]
		});
		
		$('#form').form({
			success : function(result) {
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
	<div id="dialog" class="easyui-dialog" style="width:400px;height:150px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
		<form id="form" method="post">
			<input type="hidden" name="id" />
			<input type="hidden" name="userId" value="${user.id}" />
			<input type="hidden" name="actionId" />
			<table class="tableForm">
				<tbody>
					<tr>
						<th style="width: 150px;">Action : </th>
						<td><input class="easyui-validatebox" name="actionName" readonly="readonly" style="width:250px" /></td>
					</tr>
					<tr>
						<th>Allow : </th>
						<td><select class="easyui-combobox" name="allow" style="width:250px" data-options="panelHeight:'auto',editable:false ">
							<option value="1"><s:message code="common.choose.yes" /></option>
							<option value="0"><s:message code="common.choose.no" /></option></select></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="dialog_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<div data-options="region:'center',title:'User [${user.loginName}] Actions',border:false" align="center">
		<table id="datagrid"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'Action List'" style="width: 550px; overflow: hidden;">
		<table id="datagrid_action"></table>
	</div>
</body>
</html>