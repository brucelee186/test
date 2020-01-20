<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search Item rule</title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	$('#mainList').datagrid({
		title:'',
		fit:true,
		border:false,
		url : '${pageContext.request.contextPath}/office/itemrule/doSearch.do',
		pagination : true,
		collapsible:true,
		fitColumns : true,
		idField : 'id',
		pageSize : 100,
		pageList : [ 10, 20, 50, 100, 200 ],
		sortName : 'modifiedDate',
		sortOrder : 'desc',
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		nowrap : true,
		rownumbers : true,
		frozenColumns : [[{
			title : 'id',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		}] ],
		columns : [ [ 
		{
			title : '<s:message code="office.rowName.type" />',
			field : 'type',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.specification" />',
			field : 'specification',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.unit" />',
			field : 'unit',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.price" />',
			field : 'price',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.supplier" />',
			field : 'supplier',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.remarks" />',
			field : 'remarks',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.amountDefault" />',
			field : 'amountDefault',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.amountMax" />',
			field : 'amountMax',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.addDate" />',
			field : 'addDate',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.modifiedDate" />',
			field : 'modifiedDate',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="office.rowName.status" />',
			field : 'status',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 0) {
					return '<s:message code="office.rowlable.enable" />';
				} else if (value == 1) {
					return '<s:message code="office.rowlable.disable" />';
				} 
			},
			styler : function(value, row, index) {
				if (value == 0) {
					return 'background-color:#C6EFCE;color:#006100;';
				} else if (value == 1) {
					return 'background-color:#FFC7CE;color:#9C0006;';
				} 
			}
		}
		]],
		toolbar :'#datagrid_toolbar',
		onHeaderContextMenu: function(e, field) {
			e.preventDefault();
		},
		onClickRow: function (){
			var row = $('#mainList').datagrid('getSelected');
			if(null == row){
				//$('#detailList').datagrid('reload');
				return;
			}
			//var contractId = row.id;
			var id=row.id;
			//根据订单编号,刷新明细DataGrid
			
		}
	});
});

//办公用品添加
function addItemrule(){
		var url = "${pageContext.request.contextPath}/office/itemrule/toEdit.do" ;
		window.location.href = url;
}

//办公用品编辑
function editItemrule(){
		var checkedRows = $('#mainList').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		}
		if ( checkedRows[0].status =="1") {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.disabledToEdit" />', 'warning');
			return;
		}
		var url = "${pageContext.request.contextPath}/office/itemrule/toEdit.do?id=" + checkedRows[0].id + "&editState=u" ;
		window.location.href = url;
}

//办公用品编辑导出
function printItemrule() {
				var opt = $('#mainList').datagrid('options');
				var sortName = opt.sortName;
				var sortOrder = opt.sortOrder;
				var pager = $('#mainList').datagrid('getPager');
				var pagerOpt = pager.pagination('options');
				var pageNumber = pagerOpt.pageNumber;
				var pageSize = pagerOpt.pageSize;
				
				var condition = serializeObject($('#form'));
				
				$('#frm_print').form('load', condition);
				$('#frm_print').form('load', {
					'sort' : sortName,
					'order' : sortOrder,
					'page' : pageNumber,
					'rows' : pageSize
				});
				$('#frm_print').submit();
				$.messager.show({
					title:'<s:message code="common.dialog.tip" />',
					msg:'<s:message code="office.dialogue.exportFile" />',
					timeout:5000,
					showType:'slide'
				});
			}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="office.title.itemManagementList" />',border:false" style="height: 100px;overflow: hidden;" align="center">
		<form id="frm_print" method="POST" action="${pageContext.request.contextPath}/office/itemrule/doPrint.do" style="display: none">
			<input type="hidden" name="type">
			<input type="hidden" name="status">
			<input type="hidden" name="page">
			<input type="hidden" name="rows">
			<input type="hidden" name="sort">
			<input type="hidden" name="order">
		</form>
		<form id="form" >
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">名称 : </th>
					<td><input name="type" style="width: 200px;" class="easyui-validatebox" /></td>
					<th style="width: 120px;">状态 : </th>
					<td><select class="easyui-combobox" name="status" style="width:200px" data-options="panelHeight:'auto',editable:false ">
						<option value="0"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option>
						</select></td>
					<td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
		<script>
			function submit_form() {
				var opt = $('#mainList').datagrid('options');
				opt.url = '${pageContext.request.contextPath}/office/itemrule/doSearchByName.do';
				$('#mainList').datagrid('options', opt);
				$('#mainList').datagrid('load', serializeObject($('#form')));
			}
			function reset_form() {
				$('#form').form('clear');
			}
		</script>
	</div>
	<div data-options="region:'center',border:false">
		<div id="mainList" ></div>
		<div id="datagrid_toolbar">
			<table cellspacing="0" cellpadding="0">
			<tbody>
			<tr>
			 <c:if test="${comUtil.checkCode('1204001')}">
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:addItemrule()">
				<span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left"><s:message code="office.button.add" /></span></span></a></td>
			</c:if>
			 <c:if test="${comUtil.checkCode('1204002')}">
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:editItemrule()">
				<span class="l-btn-left"><span class="l-btn-text icon-edit l-btn-icon-left"><s:message code="office.button.modify" /></span></span></a></td>
			</c:if>
			 <c:if test="${comUtil.checkCode('1204003')}">
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:printItemrule()">
				<span class="l-btn-left"><span class="l-btn-text icon-save l-btn-icon-left"><s:message code="office.dialogue.exportFile" /></span></span></a></td>
			</c:if>
			</tr>
			</tbody>
			</div>
			</table>
		</div>
</body>
</html>