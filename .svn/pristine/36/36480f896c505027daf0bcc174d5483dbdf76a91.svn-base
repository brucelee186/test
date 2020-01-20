<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Resource</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#combotree_pid').combotree({
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			lines : true
		});
		$('#datagrid').datagrid({
			fit : true,
			url :'${pageContext.request.contextPath}/admin/resource/doSearch.do',
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
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
				title : 'Resource',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				sortable : true
			}, {
				title : 'Access',
				field : 'access',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0) {
						return ''
					} else if (value == 1) {
						return 'Anonymous';
					} else if (value == 2) {
						return 'Session';
					} else if (value == 3) {
						return 'Role';
					}
				}
			}, {
				title : 'URI',
				field : 'uri',
				sortable : true,
				width : 200
			}, {
				title : 'Action',
				field : 'action',
				sortable : false,
				width : 150,
				formatter : function(value, row, index) {
					if (value != null && value.id != null) {
						return value.name
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
			toolbar : [
				<c:if test="${comUtil.checkCode('1106001')}">
				{
					iconCls : 'icon-add',
					text : '<s:message code="common.button.add" />',
					handler : function() {
						$('#form').attr('action', '${pageContext.request.contextPath}/admin/resource/doAdd.do');
						$('#form').form('load', {
							id : '',
							name : '',
							uri : '',
							level : 1,
							access : 3,
							description : ''
						});
						$('#dialog').dialog('setTitle', 'Add');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1106002')}">
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
						$('#form').attr('action', '${pageContext.request.contextPath}/admin/resource/doEdit.do');
						$('#form').form('load', {
							id : checkedRows[0].id,
							name : checkedRows[0].name,
							uri : checkedRows[0].uri,
							level : checkedRows[0].level,
							access : checkedRows[0].access,
							description : checkedRows[0].description
						});
						$('#dialog').dialog('setTitle', 'Edit');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1106003')}">
				{
					iconCls : 'icon-cancel',
					text : '<s:message code="common.button.delete" />',
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
								$.post("${pageContext.request.contextPath}/admin/resource/doDelete.do", { id : checkedRows[0].id }, function(result) {
									try {
										var j = $.parseJSON(result);
										if (j.success) {
											$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
												$('#datagrid').datagrid('reload', serializeObject($('#form_search')));
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
							$('#datagrid').datagrid('reload', serializeObject($('#form_search')));
						});
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		
		// 初始加载列表
		//submit_form();
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 135px;overflow: hidden;" align="center">
		<form id="form_search">
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">Name : </th>
					<td><input name="name" class="easyui-validatebox" style="width: 200px;" /></td>
					<th style="width: 120px;">URI : </th>
					<td><input name="uri" class="easyui-validatebox" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select class="easyui-combobox" name="level" style="width:200px" data-options="panelHeight:'auto',editable:false,value:'0'">
							<option value="0" selected="selected">　</option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
							<option value="6">6</option>
							<option value="7">7</option>
							<option value="8">8</option>
							<option value="9">9</option></select></td>
					<th>Access : </th>
					<td><select class="easyui-combobox" name="access" style="width:200px" data-options="panelHeight:'auto',editable:false,value:'0'">
							<option value="0" selected="selected">　</option>
							<option value="1">Anonymous</option>
							<option value="2">Session</option>
							<option value="3">Role</option></select></td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
		</div>
		<script>
			function submit_form() {
				var opt = $('#datagrid').datagrid('options');
				opt.url = '${pageContext.request.contextPath}/admin/resource/doSearch.do';
				$('#datagrid').datagrid('options', opt);
				$('#datagrid').datagrid('load', serializeObject($('#form_search')));
			}
			function reset_form() {
				$('#form_search').form('load',{
					name : '',
					uri : '',
					level : '0',
					access : '0'
				});
			}
		</script>
	</div>
	<div id="dialog" class="easyui-dialog" style="width:400px;height:350px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
		<form id="form" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th width="150px">Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="name" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>URI : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="uri" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td>
						<select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Access : </th>
					<td>
						<select class="easyui-combobox" name="access" style="width:250px" data-options="panelHeight:'auto',editable:false">
							<option value="1">Anonymous</option>
							<option value="2">Session</option>
							<option value="3">Role</option>
							<option value="m">Menu</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Parent : </th>
					<td><input id="combotree_pid" class="easyui-combotree" name="pid" style="width:250px;" /></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea name="description" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dialog_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
</html>