<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Action</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			border : false,
			url : '${pageContext.request.contextPath}/admin/action/doSearch.do',
			pagination : false,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			rownumbers : true,
			nowrap : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}, {
				title : 'Name',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : true
			}, {
				title : 'System',
				field : 'system',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 1) {
						return '<s:message code="common.choose.yes" />';
					} else {
						return '';
					}
				}
			}, {
				title : 'Description',
				field : 'description',
				width : 350,
				sortable : false
			}, {
				title : 'Status',
				field : 'status',
				sortable : true,
				hidden : true,
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
			toolbar : [
				<c:if test="${comUtil.checkCode('1105001')}">
				{
					iconCls : 'icon-add',
					text : '<s:message code="common.button.add" />',
					handler : function() {
						$('#form').attr('action', '${pageContext.request.contextPath}/admin/action/doAdd.do');
						$('#form').form('load', {
							id : '',
							name : '',
							level : 1,
							system : 1,
							description : '',
							status : 0
						});
						$('#dialog').dialog('setTitle', 'Add');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1105002')}">
				{
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
						$('#form').attr('action', '${pageContext.request.contextPath}/admin/action/doEdit.do');
						$('#form').form('load', {
							id : checkedRows[0].id,
							name : checkedRows[0].name,
							level : checkedRows[0].level,
							system : checkedRows[0].system,
							description : checkedRows[0].description,
							status : checkedRows[0].status
						});
						$('#dialog').dialog('setTitle', 'Edit');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1105003')}">
				{
					iconCls : 'icon-edit',
					text : '编辑资源',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/admin/action/toEditResources.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Action [{0}] Resources', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1105004')}">
				{
					iconCls : 'icon-cancel',
					text : '<s:message code="common.button.delete" />',
					handler : function() {
						$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
							if (r) {
								var checkedRows = $('#datagrid').datagrid('getSelections');
								if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
									return;
								} else if (checkedRows.length > 1) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
									return;
								}
								$.post("${pageContext.request.contextPath}/admin/action/doDelete.do", { id : checkedRows[0].id }, function(result) {
									try {
										var j = $.parseJSON(result);
										if (j.success) {
											$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
												$('#datagrid').datagrid("load");
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
				}
				</c:if>
			]
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
	<div id="dialog" class="easyui-dialog" style="width:400px;height:300px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
		<form id="form" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
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
					<th>System : </th>
					<td><select class="easyui-combobox" name="system" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0"><s:message code="common.choose.no" /></option>
						<option value="1"><s:message code="common.choose.yes" /></option></select></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false,disabled:true ">
						<option value="0"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dialog_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<div data-options="region:'center',title:'Action List',border:false" align="center">
		<table id="datagrid"></table>
	</div>
</body>
</html>