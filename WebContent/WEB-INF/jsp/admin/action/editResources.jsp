<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Action [${action.name}] Resources</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/admin/action/doEditResources.do',
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

		$('#datagrid_action_resource').datagrid({
			url : '${pageContext.request.contextPath}/admin/action/doSearchResources.do',
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
				title : 'Resource',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : false,
				width : 50
			} ] ],
			queryParams: {
				id : '${action.id}'
			},
			toolbar : [{
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.remove" />',
				handler : function() {
					var checkedRows = $('#datagrid_action_resource').datagrid('getChecked').slice(0);
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var i = 0;
					for (i = 0; i < checkedRows.length; i ++) {
						var rowIndex = $('#datagrid_action_resource').datagrid('getRowIndex', checkedRows[i]);
						$('#datagrid_action_resource').datagrid('deleteRow', rowIndex);
					}
				}
			}, '-', {
				iconCls : 'icon-save',
				text : '<s:message code="common.button.save" />',
				handler : function() {
					var resourceIds = '';
					var resources = $('#datagrid_action_resource').datagrid('getRows');
					for (var i = 0; i < resources.length; i ++) {
						resourceIds = resourceIds + resources[i].id + ","
					}
					$('#txt_resourceIds').val(resourceIds);
					$('#form').submit();
				}
			}]
		});
		
		$('#datagrid_resource').datagrid({
			url : '${pageContext.request.contextPath}/admin/resource/doSearch4Action.do',
			fit : true,
			fitColumns : true,
			border : false,
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
			} ] ],
			columns : [ [ {
				title : 'Resource',
				field : 'name',
				width : 100,
				sortable : true
			}, {
				title : 'Level',
				field : 'level',
				sortable : true,
				width : 50
			}, {
				title : 'URI',
				field : 'uri',
				sortable : true,
				width : 100
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : 'Add to Action',
				handler : function() {
					var checkedRows = $('#datagrid_resource').datagrid('getChecked');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rows = $('#datagrid_action_resource').datagrid('getRows');
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
							$('#datagrid_action_resource').datagrid('appendRow', checkedRows[i]);
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
	<div data-options="region:'center',title:'Action [${action.name }] Resources',border:false" align="center">
		<table id="datagrid_action_resource"></table>
		<form id="form" method="post" style="visibility: hidden;">
			<input type="hidden" name="id" value="${action.id}" />
			<input id="txt_resourceIds" type="hidden" name="resourceIds" value="${resourceIds}" />
		</form>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'Available Resources'" style="width: 500px; overflow: hidden;">
		<table id="datagrid_resource"></table>
	</div>
</body>
</html>