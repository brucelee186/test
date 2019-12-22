<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>科目部门</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
$(function() {
	$('#trg_category').treegrid({
		url : '${pageContext.request.contextPath}/order/orderCategory/doSearchList.do',
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
		},
		{
			title : '科目名称',
			field : 'name',
			width : 250
		},
		{
			title : 'Pid',
			field : 'pid',
			width : 50,
			hidden : true,
			hiddable : true
		},
		{
			title : '父科目',
			field : 'parName',
			width : 250,
		},
		{
			title : '等级',
			field : 'level',
			width : 200
		},
		{
			title : '类型',
			field : 'typeData',
			align : 'center',
			width : 60,
			formatter : function(value, row, index) {
				if (value == 'r'){
					return '报销';
				} else if (value == 'a') {
					return '申请';
				}
			},
		},
		{
			title : '备注',
			field : 'remark',
			width : 200
		}, 
		{
			title : '状态',
			field : 'tag',
			width : 80,
			align : 'center',
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 'a'){
					return '启用';
				} else if (value == 'f') {
					return '禁用';
				}
			},
			styler : function(value, row, index) {
				if (value == 'a'){
					return 'background-color:#C6EFCE; color:#006100';
				} else if (value == 'f') {
					return 'background-color:#FFC7CE; color:#9C0006';
				}
			}
		}] ],
		onLoadSuccess : function(data) {
			$(this).treegrid('clearSelections');
		},
		toolbar : [ {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				$('#fr_category').attr('action', '${pageContext.request.contextPath}/order/orderCategory/doEdit.do?editState=i'),
				$('#fr_category').form('load', {
					id : '',
					name : '',
					typeData : '',
					remark : '',
					pid : '',
					tag : 'a',
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
				$('#fr_category').attr('action', '${pageContext.request.contextPath}/order/orderCategory/doEdit.do?editState=u'),
				$('#fr_category').form('load', {
					id : row.id,
					name : row.name,
					typeData : row.typeData,
					remark : row.remark,
					pid : row.pid==0?null:row.pid,
					tag : row.tag
				});
				$('#dlg_category').dialog('setTitle', '<s:message code="common.edit" />').dialog('open').dialog('center');
			}
		}, 
		]
		
	});
	
	
	
	$('#fr_category').form({
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
					$.messager.show({
						title:'<s:message code="common.dialog.tip" />',
						msg:'操作成功',
						timeout:2000,
						showType:'slide'
					});
					$('#dlg_category').dialog('close');
					$('#trg_category').treegrid('reload');
					$('#cbx_pid').combobox('reload');
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
	
	<div id="dlg_category" class="easyui-dialog" style="width:320px;" data-options="resizable:true,modal:true,closed: true,
		onOpen: function() {formValidate('fr_category', true);}, onClose: function() {formValidate('fr_category', false);},
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#fr_category').submit();}}]">
		<form id="fr_category" method="post">
			<input type="hidden" name="id" />
			<table class="mtftable" align="center">
				<tbody>
					<tr>
						<th style="width: 60px;">科目名称</th>
						<td>:</td>
						<td><input name="name" class="easyui-textbox" style="width:200px" maxlength="100" data-options="required:true,validType:'length[1,20]'" /></td>
					</tr>
					<tr>
						<th >父科目</th>
						<td>:</td>
						<td><di	v id="cbx_pid" name="pid" class="easyui-combobox" style="width:200px" data-options="panelHeight:'180', editable:false, url : '${pageContext.request.contextPath}/common/droplist/doListOrderCategory.do?level=1',
						valueField : 'id',textField : 'name'"></div>
						<a class="mtficon ext-icon-cross" onclick="javascript:$('#cbx_pid').combobox('clear');"></a></td>
					</tr>
					<tr>
						<th >类型</th>
						<td>:</td>
						<td><select id="type" name="typeData" class="easyui-combobox" style="width:200px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=kmfl'"></select></td>
					</tr>
					<tr>
						<th >描述</th>
						<td>:</td>
						<td><input name="remark" class="easyui-textbox" style="width:200px;height:50px;" maxlength="100" data-options="multiline:true, validType:'length[1,100]'" /></td>
					</tr>
					<tr>
						<th>状态</th>
						<td>:</td>
						<td><select id="tag" name="tag" class="easyui-combobox" style="width:200px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=xtzt'"></select></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
</body>
</html>