<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>货币维护</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#dtg_currency').datagrid({
			fit : true,
			border : false,
			url : '${pageContext.request.contextPath}/maintenance/currency/doSearch.do',
			pagination : false,
			idField : 'id',
			sortName : 'id',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : false,
			autoRowHeight : false,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 30,
				align : 'center',
				sortable : false,
				hidden : false
			} ] ],
			columns : [ [ {
				title : 'Name',
				field : 'name',
				width : 100,
				sortable : true
			},{
				title : 'Ratio',
				field : 'ratio',
				width : 200,
				sortable : true
			},  {
				title : 'Status',
				field : 'status',
				width : 80,
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.status.enabled" />';
					} else if (value == 1) {
						return '<s:message code="common.status.disabled" />';
					}
				},
				styler : function(value, row, index) {
					if (value == 0){
						return { 'class' : 'mtfgood' };
					} else if (value == 1) {
						return { 'class' : 'mtfbad' };
					}
				}
			},{
				title : '创建时间',
				field : 'createDatetime',
				width : 150,
				sortable : true,
				hiddable : true,
				hidden : true
			},{
				title : '创建人',
				field : 'createUserName',
				width : 150,
				sortable : true,
				hiddable : true,
				hidden : true
			},{
				title : '更新时间',
				field : 'updateDatetime',
				width : 150,
				sortable : true,
				hiddable : true,
				hidden : true
			},{
				title : '更新人',
				field : 'updateUserName',
				width : 150,
				sortable : true,
				hiddable : true,
				hidden : true
			} ] ],
			onDblClickRow : function(index, row) {
				$('#frm_currency').attr('action', '${pageContext.request.contextPath}/maintenance/currency/doEdit.do'),
				$('#frm_currency').form('load', row);
				$('#dlg_currency').dialog('setTitle', '<s:message code="common.edit" />').dialog('open').dialog('center');
			},
			onLoadSuccess : function(data) {
				$(this).datagrid('clearSelections');
			},
			toolbar : [ {
				iconCls : 'icon-add',
				text : '<s:message code="common.add" />',
				handler : function() {
					$('#frm_currency').attr('action', '${pageContext.request.contextPath}/maintenance/currency/doAdd.do'),
					$('#frm_currency').form('load', {
						name : '',
						ratio : '',
						status : 0,
					});
					$('#dlg_currency').dialog('setTitle', '<s:message code="common.add" />').dialog('open').dialog('center');
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '<s:message code="common.edit" />',
				handler : function() {
					var row = $('#dtg_currency').datagrid('getSelected');
					if (row == null || row == undefined) {
						return;
					}
					$('#frm_currency').attr('action', '${pageContext.request.contextPath}/maintenance/currency/doEdit.do'),
					$('#frm_currency').form('load', row);
					$('#dlg_currency').dialog('setTitle', '<s:message code="common.edit" />').dialog('open').dialog('center');
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.delete" />',
				handler : function() {
					var row = $('#dtg_currency').datagrid('getSelected');
					if (row == null || row == undefined) {
						return;
					}
					$.messager.alert('<s:message code="common.warn" />', '暂不支持删除功能！', 'warning');
				}
			}]
		});
		
		$('#frm_currency').form({
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
							$('#dlg_currency').dialog('close');
							$('#dtg_currency').datagrid('reload');
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
	<div data-options="region:'center',title:'Currency List',border:false">
		<table id="dtg_currency"></table>
	</div>
	
	<div id="dlg_currency" class="easyui-dialog" style="width:250px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('#frm_currency', true);}, onClose: function() {formValidate('#frm_currency', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_currency').submit();}}]">
		<form id="frm_currency" method="post">
			<input type="hidden" name="id" />
			<table class="mtftable" align="center">
				<tbody>
					<%-- <tr>
						<th style="width: 50px;">ID</th>
						<td>:</td>
						<td><select name="id" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',editable:false ">
							<option value="0">1</option>
							<option value="1">2</option>
							<option value="0">3</option>
							<option value="1">4</option>
							<option value="0">5</option>
							<option value="1">6</option>
							<option value="0">7</option>
							<option value="1">8</option>
							<option value="1">9</option>
							</select></td>
					</tr> --%>
					<tr>
						<th >名称</th>
						<td>:</td>
						<td><input name="name" class="easyui-textbox" style="width:150px" maxlength="100" data-options="required:true,validType:'length[1,100]'" /></td>
					</tr>
					<tr>
						<th>汇率</th>
						<td>:</td>
						<td><input name="ratio" class="easyui-numberbox" style="width:150px" maxlength="100" data-options="min:0,max:1000,precision:4" /></td>
					</tr>
					<tr>
						<th>状态</th>
						<td>:</td>
						<td><select name="status" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',editable:false ">
							<option value="0"><s:message code="common.status.enabled" /></option>
							<option value="1"><s:message code="common.status.disabled" /></option></select></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>