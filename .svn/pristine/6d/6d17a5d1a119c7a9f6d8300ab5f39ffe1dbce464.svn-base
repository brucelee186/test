<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Role [${role.name}] Actions</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/role/doEditActions.do',
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
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});

		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/maintenance/role/doSearchActions.do',
			fit : true,
			fitColumns : true,
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
				width : 50,
				sortable : false,
				checkbox : true
			}, {
				title : 'Action',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : false,
				width : 50
			}, {
				title : 'Description',
				field : 'description',
				sortable : false,
				width : 200
			} ] ],
			queryParams: {
				id : '${role.id}'
			},
			toolbar : [{
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.remove" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getChecked').slice(0);
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var i = 0;
					for (i = 0; i < checkedRows.length; i ++) {
						var rowIndex = $('#datagrid').datagrid('getRowIndex', checkedRows[i]);
						$('#datagrid').datagrid('deleteRow', rowIndex);
					}
				}
			}, '-', {
				iconCls : 'icon-save',
				text : '<s:message code="common.button.save" />',
				handler : function() {
					var actionIds='';
					var resources = $('#datagrid').datagrid('getRows');
					for (var i = 0; i < resources.length; i ++) {
						actionIds = actionIds + resources[i].id + ","
					}
					$('#txt_actionIds').val(actionIds);
					$('#form').submit();
				}
			}]
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
				width : 50,
				sortable : false,
				checkbox : true
			}, {
				title : 'Action',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : true,
				width : 50
			}, {
				title : 'Description',
				field : 'description',
				sortable : true,
				width : 100
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : 'Add to role',
				handler : function() {
					var checkedRows = $('#datagrid_action').datagrid('getChecked');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rows = $('#datagrid').datagrid('getRows');
					var countSkiped = 0;
					var countAdded = 0;
					var isExists = false;
					for (var i = 0; i < checkedRows.length; i ++) {
						isExists = false;
						for(var j = 0; j < rows.length; j++) {
							if (rows[j].id == checkedRows[i].id) {
								isExists = true;
								countSkiped ++;
								break;
							}
						}
						if (isExists == false) {
							$('#datagrid').datagrid('appendRow', checkedRows[i]);
							countAdded ++;
						}
					}
					$.messager.alert('<s:message code="common.dialog.tip" />', formatString('{0} Added, {1} Skip', countAdded, countSkiped), 'info');
				}
			}]
		});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'Role [${role.name}] Actions',border:false" align="center">
		<form id="form" method="post" style="visibility: hidden;">
			<input type="hidden" name="id" value="${role.id}">
			<input id="txt_actionIds" type="hidden" name="actionIds" value="${actionIds}">
		</form>
		<table id="datagrid"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'Action List'" style="width: 550px; overflow: hidden;">
		<table id="datagrid_action"></table>
	</div>
</body>
</html>