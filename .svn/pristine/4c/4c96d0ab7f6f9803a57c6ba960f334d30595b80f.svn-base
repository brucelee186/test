<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>编辑组</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
$(function() {
	$('#dtg_group').datagrid({
		url : '${pageContext.request.contextPath}/maintenance/division/doSearchForGroup.do',
		idField: 'id',
		border : false,
		fit : true,
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		singleSelect : true,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		} ] ],
		columns : [ [{
			title : '组名称',
			field : 'name',
			width : 200
		},{
			title : '描述',
			field : 'description',
			width : 300/* ,
			hidden : true,
			hiddable : true */
		}/* ,{
			title : 'Pid',
			field : 'pid',
			width : 50
		} */, {
			title : 'Status',
			field : 'status',
			width : 80,
			align : 'center',
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 0){
					return '启用';
				} else if (value == 1) {
					return '禁用';
				}
			},
			styler : function(value, row, index) {
				if (value == 0){
					return 'background-color:#C6EFCE; color:#006100';
				} else if (value == 1) {
					return 'background-color:#FFC7CE; color:#9C0006';
				}
			}
		}] ],
		onLoadSuccess : function(data) {
			$(this).treegrid('clearSelections');
		},
		onSelect : function(index, row) {
			var $dtg = $('#dtg_user');
			var opt = $dtg.datagrid('options');
			if (opt.url == undefined || opt.url == null || opt.url == '') {
				opt.url = '${pageContext.request.contextPath}/maintenance/user/doSearchByDivisionId.do'
				$dtg.datagrid('options', opt);
			}
			$dtg.datagrid('load', {divisionId : row.id});
			
		},
		toolbar : [ {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				$('#frm_group').attr('action', '${pageContext.request.contextPath}/maintenance/division/doAddForGroup.do'),
				$('#frm_group').form('load', {
					id : '',
					name : '',
					description : '',
					status : 0
				});
				//$('#combotree_pid').combotree('clear');
				$('#dlg_group').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-edit',
			text : '<s:message code="common.edit" />',
			handler : function() {
				var row = $('#dtg_group').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				$('#frm_group').attr('action', '${pageContext.request.contextPath}/maintenance/division/doEditForGroup.do'),
				//$('#frm_datagrid').form('load', row);
				$('#frm_group').form('load', {
					id : row.id,
					name : row.name,
					description : row.description,
					//pid : row.pid,
					status : row.status
				});
				
				$('#dlg_group').dialog('setTitle', '<s:message code="common.edit" />').dialog('open').dialog('center');
			}
		}]
		
	});
	
	$('#dtg_user').datagrid({
		//url : '${pageContext.request.contextPath}/maintenance/user/doSearchRoles.do',
		idField: 'id',
		border : false,
		fit : true,
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		} ] ],
		columns : [ [{
			title : '用户名',
			field : 'displayName',
			width : 300
		}] ],
		onLoadSuccess : function(data) {
			$(this).treegrid('clearSelections');
		},
		toolbar : [ {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				var groupRow = $('#dtg_group').datagrid('getSelected');
				$('#frm_user').attr('action', '${pageContext.request.contextPath}/maintenance/user2division/doAdd.do'),
				$('#frm_user').form('load', {
					divisionId : groupRow.id,
					index : 0
				}); 
				
				$('#dlg_user').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-remove',
			text : '<s:message code="common.remove" />',
			handler : function() {
				var userRow = $('#dtg_user').datagrid('getSelected');
				if (userRow == null || userRow == undefined) {
					return;
				}
				
				$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
					if (r) {
						$.post("${pageContext.request.contextPath}/maintenance/user2division/doDelete.do", { id : userRow.id }, function(result){
							try {
								var j = $.parseJSON(result);
								if (j.success) {
									$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
										$('#dtg_user').datagrid("reload");
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
		}]
		
	});
	
	$('#frm_group').form({
		onSubmit : function() {
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
					$.messager.alert('<s:message code="common.tip" />', 'OK', 'info', function(rr) {
						$('#dlg_group').dialog('close');
						$('#dtg_group').datagrid('reload');
					});
				} else {
					$.messager.alert('<s:message code="common.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.error" />', result, 'error');
			}
		}
	});
	
	$('#frm_user').form({
		onSubmit : function() {
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
					$.messager.alert('<s:message code="common.tip" />', 'OK', 'info', function(rr) {
						$('#dlg_user').dialog('close');
						$('#dtg_user').datagrid('reload');
					});
				} else {
					$.messager.alert('<s:message code="common.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.error" />', result, 'error');
			}
		}
	});
});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'Group List',border:true">
		<table id="dtg_group"></table>
	</div>
	<div data-options="region:'east',title:'User List',border:true, collapsible:false" style="width:500px;">
		<table id="dtg_user"></table>
	</div>
	
	
	<div id="dlg_group" class="easyui-dialog" style="width:330px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('frm_group', true);}, onClose: function() {formValidate('frm_group', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_group').submit();}}]">
		<form id="frm_group" method="post">
			<input type="hidden" name="id" />
			<table class="mtftable" align="center">
				<tbody>
					<tr>
						<th style="width: 60px;">组名称</th>
						<td>:</td>
						<td colspan="2"><input name="name" class="easyui-textbox" style="width:200px" maxlength="100" data-options="required:true,validType:'length[1,20]'" /></td>
					</tr>
					<tr>
						<th >描述</th>
						<td>:</td>
						<td colspan="2"><input name="description" class="easyui-textbox" style="width:200px;height:50px;" maxlength="100" data-options="multiline:true, validType:'length[1,100]'" /></td>
					</tr>
				<%-- 	<tr>
						<th>隶属部门 </th>
						<td>:</td>
						<td><input id="combotree_pid" class="easyui-combotree" name="pid" style="width:200px;"
						data-options="url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do', valueField : 'id', textField : 'name', parentField : 'pid', lines : true"	 /></td>
						<td><img src="${pageContext.request.contextPath}/images/icons/cancel.png" onclick="$('#combotree_pid').combotree('clear');" /></td>
					</tr>  --%>
					<tr>
						<th>状态</th>
						<td>:</td>
						<td colspan="2"><select name="status" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',editable:false ">
							<option value="0">启用</option>
							<option value="1">禁用</option></select></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<div id="dlg_user" class="easyui-dialog" style="width:320px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('frm_user', true);}, onClose: function() {formValidate('frm_user', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_user').submit();}}]">
		<form id="frm_user" method="post">
			<input type="hidden" name="id" />
			<input type="hidden" name="divisionId" />
			<input type="hidden" name="index" />
			<table class="mtftable" align="center">
				<tr>
					<th style="width: 150px;">用户 : </th>
					<td>
						<select id ="cbx_userId" name="userId" class="easyui-combobox" style="width:250px" data-options="url : '${pageContext.request.contextPath}/maintenance/user/doListPair.do',
							valueField : 'first', textField : 'second',editable:true"></select>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>