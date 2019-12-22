<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>类别部门</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
$(function() {
	$('#trg_category').treegrid({
		url : '${pageContext.request.contextPath}/order/orderCategory/doSearch.do',
		idField: 'id',
		treeField: 'name',
		parentField : 'pid',
		border : false,
		fit : true,
		columns : [ [{
			title : 'ID',
			field : 'id',
			width : 50,
			align : 'center',
			hidden : true,
			hiddable : true
		},{
			title : '类别名称',
			field : 'name',
			width : 200
		},{
			title : 'Pid',
			field : 'pid',
			width : 50,
			hidden : true,
			hiddable : true
		},{
			title : '等级',
			field : 'level',
			width : 100,
			hidden : true,
			hiddable : true
		},{
			title : '描述',
			field : 'remark',
			width : 200
		}, {
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
		onSelect : function(row) {
			var $dtg = $('#dtg_group');
			var opt = $dtg.datagrid('options');
			if (opt.url == undefined || opt.url == null || opt.url == '') {
				opt.url = '${pageContext.request.contextPath}/maintenance/division/doSearchByCategoryId.do'
				$dtg.datagrid('options', opt);
			}
			if(row.pid == 0){
				$dtg.datagrid('loadData',[]);
			}else{
				$dtg.datagrid('load', {categoryId : row.id});
			}
		},
		toolbar : [ {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				$('#frm_category').attr('action', '${pageContext.request.contextPath}/maintenance/rbsCategory/doAdd.do'),
				$('#frm_category').form('load', {
					id : '',
					categoryName : '',
					categoryDescription : '',
					pid : '',
					status : 0
				});
				$('#dlg_category').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-edit',
			text : '<s:message code="common.edit" />',
			handler : function() {
				var row = $('#trg_category').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				$('#frm_category').attr('action', '${pageContext.request.contextPath}/maintenance/rbsCategory/doEdit.do'),
				//$('#frm_category').form('load', row);
				$('#frm_category').form('load', {
					id : row.id,
					categoryName : row.categoryName,
					categoryDescription : row.categoryDescription,
					pid : row.pid==0?null:row.pid,
					status : row.status
				});
				$('#dlg_category').dialog('setTitle', '<s:message code="common.edit" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-add',
			text : '编辑采购管理人员',
			handler : function() {
				var row = $('#trg_category').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				if (row.pid == 0 ) {
					$.messager.alert('<s:message code="common.dialog.warn" />', '请选择子节点！', 'warning');
					return;
				}
				
				var $dtg = $('#dtg_user');
				var opt = $dtg.datagrid('options');
				if (opt.url == undefined || opt.url == null || opt.url == '') {
					opt.url = '${pageContext.request.contextPath}/maintenance/user/doSearchAdminByCategoryId.do'
					$dtg.datagrid('options', opt);
				}
				if(row.pid == 0){
					$dtg.datagrid('loadData',[]);
				}else{
					$dtg.datagrid('load', {categoryId : row.id});
				}
				
				$('#dlg_categoryUser').dialog('setTitle', '编辑采购管理人员').dialog('open').dialog('center');
			}
		}]
		
	});
	
	$('#dtg_group').datagrid({
		//url : '${pageContext.request.contextPath}/maintenance/division/doSearchByCategoryId.do',
		idField: 'id',
		border : false,
		fit : true,
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		singleSelect:true,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		}/* ,{
			title : '',
			field : 'status',
			width : 25,
			checkbox : true
		} */ ] ],
		columns : [ [{
			title : '组名称',
			field : 'name',
			width : 200
		},{
			title : '描述',
			field : 'description',
			width : 100,
			hidden : true,
			hiddable : true
		}/* ,{
			title : 'Pid',
			field : 'pid',
			width : 50
		} */] ],
		onLoadSuccess : function(data) {
			$(this).treegrid('clearSelections');
			if(data){
				$.each(data.rows, function(index, item){
					 if(item.status == 1){
						 $('#dtg_group').datagrid('checkRow', index);
					} 
				});
			}
		},
		toolbar : [{
			iconCls : 'icon-save',
			text : '保存设置',
			handler : function() {
				var categoryRow = $('#trg_category').datagrid('getSelected');
				var checkedRows = $('#dtg_group').datagrid('getChecked');
				if (categoryRow == null || categoryRow == undefined) {
					return;
				}
				//批量操作编辑项信息
				var arr = [];
				for(var i = 0;i < checkedRows.length;i++){
					arr.push(checkedRows[i].id);
				}
				var idsStr = JSON.stringify(arr);
				
				$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认保存？', function(r) {
					if (r) {
						$.post("${pageContext.request.contextPath}/maintenance/category2division/doEdit.do", {categoryId : categoryRow.id, divisionIds : idsStr}, function(result){
							try {
								var j = $.parseJSON(result);
								if (j.success) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '保存成功！', 'info', function(rr) {
										$('#dlg_categoryUser').dialog('close');
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
		}, '-'/* {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				var categoryRow = $('#trg_category').datagrid('getSelected');
				
				if(categoryRow.pid == 0){
					$.messager.alert('<s:message code="common.dialog.warn" />', '请选择子节点！', 'warning');
					return;
				}
				
				$('#frm_group').attr('action', '${pageContext.request.contextPath}/maintenance/category2Division/doAdd.do'),
				$('#frm_group').form('load', {
					id : '',
					categoryId : categoryRow.id
				});
				$('#dlg_group').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-remove',
			text : '<s:message code="common.remove" />',
			handler : function() {
				var row = $('#dtg_group').datagrid('getSelected');
				var categoryRow = $('#trg_category').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				
				$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
					if (r) {
						$.post("${pageContext.request.contextPath}/maintenance/category2Division/doDelete.do", { id : row.id }, function(result){
							try {
								var j = $.parseJSON(result);
								if (j.success) {
									$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
										$('#dtg_group').datagrid('reload');
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
		} */]
		
	});
	
	$('#dtg_user').datagrid({
		//url : '${pageContext.request.contextPath}/maintenance/user/doSearchByCategoryId.do',
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
		},{
			title : '',
			field : 'status',
			width : 25,
			checkbox : true
		}
		] ],
		columns : [ [{
			title : '名称',
			field : 'displayName',
			width : 200
		}] ],
		onLoadSuccess : function(data) {
			$(this).datagrid('clearSelections');
			if(data){
				$.each(data.rows, function(index, item){
					 if(item.status == 1){
						 $('#dtg_user').datagrid('checkRow', index);
					} 
				});
			}
		},
		toolbar : [ {
			iconCls : 'icon-save',
			text : '保存设置',
			handler : function() {
				var categoryRow = $('#trg_category').datagrid('getSelected');
				var checkedRows = $('#dtg_user').datagrid('getChecked');
				
				//批量操作编辑项信息
				var arr = [];
				for(var i = 0;i < checkedRows.length;i++){
					arr.push(checkedRows[i].id);
				}
				var idsStr = JSON.stringify(arr);
				
				$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认保存？', function(r) {
					if (r) {
						$.post("${pageContext.request.contextPath}/maintenance/category2user/doEdit.do", {categoryId : categoryRow.id, userIds : idsStr,  }, function(result){
							try {
								var j = $.parseJSON(result);
								if (j.success) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '保存成功！', 'info', function(rr) {
										$('#dlg_categoryUser').dialog('close');
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
		}, '-' /* {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				var categoryRow = $('#trg_category').datagrid('getSelected');
				
				$('#frm_user').attr('action', '${pageContext.request.contextPath}/maintenance/category2user/doAdd.do'),
				$('#frm_user').form('load', {
					categoryId : categoryRow.id
				});
				
				$('#dlg_user').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
			}
		}, '-', {
			iconCls : 'icon-remove',
			text : '<s:message code="common.remove" />',
			handler : function() {
				var row = $('#dtg_user').datagrid('getSelected');
				var categoryRow = $('#trg_category').datagrid('getSelected');
				if (row == null || row == undefined) {
					return;
				}
				
				$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
					if (r) {
						$.post("${pageContext.request.contextPath}/maintenance/category2user/doDelete.do", { id : row.id }, function(result){
							try {
								var j = $.parseJSON(result);
								if (j.success) {
									$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
										$('#dtg_user').datagrid('reload');
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
		} */]
		
	});
	
	$('#frm_category').form({
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
						$('#dlg_category').dialog('close');
						$('#trg_category').treegrid('reload');
						$('#cbx_pid').combobox('reload');
					});
				} else {
					$.messager.alert('<s:message code="common.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.error" />', result, 'error');
			}
		}
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
	<!-- <div data-options="region:'west',title:'Category List',border:true, collapsible:false" style="width:500px;">
		<table id="trg_category"></table>
	</div> -->
	<div data-options="region:'center',title:'Category List',border:true">
		<table id="trg_category"></table>
	</div>
	<div data-options="region:'east',title:'Group List',border:true, collapsible:false" style="width:500px;">
		<table id="dtg_group"></table>
	</div>
	
	<div id="dlg_category" class="easyui-dialog" style="width:320px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('frm_category', true);}, onClose: function() {formValidate('frm_category', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_category').submit();}}]">
		<form id="frm_category" method="post">
			<input type="hidden" name="id" />
			<table class="mtftable" align="center">
				<tbody>
					<tr>
						<th style="width: 60px;">类别名称</th>
						<td>:</td>
						<td><input name="categoryName" class="easyui-textbox" style="width:200px" maxlength="100" data-options="required:true,validType:'length[1,20]'" /></td>
					</tr>
					<tr>
						<th >描述</th>
						<td>:</td>
						<td><input name="categoryDescription" class="easyui-textbox" style="width:200px;height:50px;" maxlength="100" data-options="multiline:true, validType:'length[1,100]'" /></td>
					</tr>
					<tr>
						<th >父类别</th>
						<td>:</td>
						<td><div id="cbx_pid" name="pid" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto', editable:false, url : '${pageContext.request.contextPath}/maintenance/rbsCategory/doListForLv1.do',
						valueField : 'id',textField : 'categoryName'"></div>
						<a class="mtficon ext-icon-cross" onclick="javascript:$('#cbx_pid').combobox('clear');"></a></td>
					</tr>
					<tr>
						<th>状态</th>
						<td>:</td>
						<td><select name="status" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',editable:false ">
							<option value="0">启用</option>
							<option value="1">禁用</option></select></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="dlg_group" class="easyui-dialog" style="width:320px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('frm_group', true);}, onClose: function() {formValidate('frm_group', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_group').submit();}}]">
		<form id="frm_group" method="post">
			<!-- <input type="hidden" name="id" /> -->
			<input type="hidden" name="categoryId" />
			<table class="mtftable" align="center">
				<tbody>
					<tr>
						<th style="width: 50px;">组</th>
						<td>:</td>
						<td><input class="easyui-combobox" name="divisionId" style="width:250px;" data-options="panelHeight:'auto',panelMaxHeight:'200',
						url : '${pageContext.request.contextPath}/maintenance/division/doSearchForGroup.do', valueField : 'id', textField : 'name',editable:true "/></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	
	<div id="dlg_categoryUser" class="easyui-dialog" style="width:275px;height:500px;" data-options="resizable:true,modal:true,closed: true">
		<table id="dtg_user"></table>
	</div>
	
	<div id="dlg_user" class="easyui-dialog" style="width:320px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('frm_user', true);}, onClose: function() {formValidate('frm_user', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_user').submit();}}]">
		<form id="frm_user" method="post">
			<input type="hidden" name="id" />
			<input type="hidden" name="categoryId" />
			<table class="mtftable" align="center">
				<tr>
					<th style="width: 150px;">用户 : </th>
					<td>
						<select id ="cbx_userId" name="userId" class="easyui-combobox" style="width:250px" data-options="url : '${pageContext.request.contextPath}/maintenance/user/doListPair.do',
							valueField : 'first', textField : 'second',editable:true,panelHeight:'auto', panelMaxHeight:'200'"></select>
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>