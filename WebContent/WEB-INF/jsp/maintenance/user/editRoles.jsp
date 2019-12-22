<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$('#form').form({
			url : '${pageContext.request.contextPath}/maintenance/user/doEditRoles.do',
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

		$('#datagrid_user_role').datagrid({
			url : '${pageContext.request.contextPath}/maintenance/user/doSearchRoles.do',
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
				title : 'Role',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : false,
				width : 50
			}, 
			{field:'mainIndex',title:'Main',align:'center',width:80,formatter:function(value, row, index){
				var checkboxhtml ='<input id="mainIndex_' + row.id + '" name="mainIds" type="checkbox" value="' + row.id + '" onclick = "mainClick(this);"';
				if (1 == value) {
					checkboxhtml += ' checked="checked" '; 
					checkboxhtml += '/>';
				}
				return checkboxhtml;
			}},	
			{
				title : 'System',
				field : 'system',
				sortable : false,
				width : 50,
				formatter : function(value, row, index) {
					if (value == 1) {
						return '<s:message code="common.choose.yes" />'
					} else {
						return '';
					}
				}
			}, {
				title : 'Description',
				field : 'description',
				sortable : false,
				width : 200
			} ] ],
			queryParams: {
				id : '${user.id}',
				divisionId : '${user.divisionId}'
			},
			toolbar : [{
				iconCls : 'icon-remove',
				text : 'Remove',
				handler : function() {
					var checkedRows = $('#datagrid_user_role').datagrid('getChecked').slice(0);
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var i = 0;
					for (i = 0; i < checkedRows.length; i ++) {
						var rowIndex = $('#datagrid_user_role').datagrid('getRowIndex', checkedRows[i]);
						$('#datagrid_user_role').datagrid('deleteRow', rowIndex);
					}
				}
			}, '-', {
				iconCls : 'icon-save',
				text : 'Save',
				handler : function() {
					var roleIds = [];
					var roles = $('#datagrid_user_role').datagrid('getRows');
					var tagMainIndex = 0;
					for (var i = 0; i < roles.length; i ++) {
						var mainIndex = 0;
						if('checked' == $('#mainIndex_' + roles[i].id).attr('checked')){
							mainIndex = 1;
							tagMainIndex = 1;
						}
						roleIds.push(roles[i].id + "." + mainIndex);
					}
					if (0 == tagMainIndex && roles.length > 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '请选择主角色!', 'warning');
						return;
					}
					$('#txt_roleIds').val(roleIds.join(","));
					$('#form').submit();
				}
			}]
		});
		
		$('#datagrid_roles').datagrid({
			fit : true,
			fitColumns : true,
			border : false,
			url : '${pageContext.request.contextPath}/maintenance/role/doSearch4User.do',
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
				title : 'Role',
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
				title : 'System',
				field : 'system',
				sortable : false,
				width : 50,
				formatter : function(value, row, index) {
					if (value == 1) {
						return '<s:message code="common.choose.yes" />'
					} else {
						return '';
					}
				}
			}, {
				title : 'Description',
				field : 'description',
				sortable : false,
				width : 200
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : 'Add to User',
				handler : function() {
					var checkedRows = $('#datagrid_roles').datagrid('getChecked');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rows = $('#datagrid_user_role').datagrid('getRows');
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
							$('#datagrid_user_role').datagrid('appendRow', checkedRows[i]);
							countAdded ++;
						}
					}
					$.messager.alert('<s:message code="common.dialog.tip" />', formatString('{0} Added, {1} Skip', countAdded, countSkiped), 'info');
				}
			}]
		});
	});

function mainClick(obj) {
	if (obj.checked) {
		$("input[name='mainIds']").removeAttr('checked');
	}
	$("input[name='mainIds'][value='" + obj.value + "']").attr('checked', 'checked');
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',border:false,
		<c:if test="${user.loginName != null}">title:'User [${user.loginName}] Roles'</c:if>
		<c:if test="${user.divisionId != null}">title:'Division Roles'</c:if>
		" align="center">
		<form id="form" method="post" style="visibility: hidden;">
			<input type="hidden" name="divisionId" value="${user.divisionId}">
			<input type="hidden" name="id" value="${user.id}">
			<input id="txt_roleIds" type="hidden" name="roleIds">
		</form>
		<table id="datagrid_user_role"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'Role List'" style="width: 550px; overflow: hidden;">
		<table id="datagrid_roles"></table>
	</div>
</body>
</html>