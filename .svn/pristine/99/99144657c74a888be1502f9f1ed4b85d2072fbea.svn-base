<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>

<title>Insert title here</title>
<script type="text/javascript">
	var unitData = ${unitData};
	$(function() {
		$('#datagrid').datagrid({
			url:'${pageContext.request.contextPath}/maintenance/goods/doSearch.do',
			fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
			sortName : 'GoodsName',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			columns : [ [
					{
						title : 'Id',
						field : 'id',
						width : 0.2,
						sortable : false,
						hidden : true
					},{
						title : '<s:message code="p_main.maintenance.goods.goodsName"/>',
						field : 'commodity',
						width : 0.2,
						sortable : true,
						
					},{
						title : '<s:message code="p_main.maintenacte.goods.specification"/>',
						field : 'specification',
						width : 0.2,
						sortable : false,
					},{
						title : '<s:message code="p_main.maintenacte.goods.quantity"/>',
						field : 'quantity',
						width : 0.2,
						sortable : false
					},
					//{
						//title : 'USPrice',
						//field : 'unitPriceUS',
						//width : 0.2,
						//sortable : false
				//},,
					{
						title : '<s:message code="p_main.maintenacte.goods.unit"/>',
						field : 'unit',
						width : 0.2,
						sortable : false
					},
					{
						title : '<s:message code="p_main.maintenacte.goods.unitprice"/>',
						field : 'unitPrice',
						width : 0.2,
						sortable : false
					},{
						title : '<s:message code="p_main.maintenacte.goods.status"/>',
						field : 'status',
						width : 0.25,
						sortable : false,
						formatter : function(value, row, index) {
							if (value == 0) {
								return '<s:message code="common.status.enabled" />';
							} else if (value == 1) {
								return '<s:message code="common.status.disabled" />';
							} else if (value == 2) {
								return '<s:message code="common.status.deprecated" />';
							};
						},
						styler : function(value, row, index) {
							if (value == 0) {
								return 'background-color:#C6EFCE;color:#006100;';
							} else if (value == 1) {
								return 'background-color:#FFC7CE;color:#9C0006;';
							} 
						}
					} ] ],toolbar : [{
						iconCls : 'icon-add',
						text : '<s:message code="common.button.add" />',
						handler : function() {
							showAddDialog();
						}
					},'-',{
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
							$('#form_Goods').attr('action', '${pageContext.request.contextPath}/maintenance/goods/doEdit.do');
							$('#form_Goods').form('load', {
								id: checkedRows[0].id,
								commodity : checkedRows[0].commodity,
								specification : checkedRows[0].specification,
								quantity : checkedRows[0].quantity,
								unitPriceUS:checkedRows[0].unitPriceUS,
								unitPrice:checkedRows[0].unitPrice,
								unit_id:checkedRows[0].unit,
								status : checkedRows[0].status
							});
							$('#dialog_Goods').dialog('setTitle','Edit Goods');
							$('#dialog_Goods').dialog('open');
						}
					},'-',{
						iconCls : 'icon-remove',
						text : '<s:message code="common.button.delete" />',
						handler : function() {
							var checkedRows = $('#datagrid').datagrid('getSelections');
							if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
								$.messager.alert('<s:message code="common.dialog.tip" />', '请选择要删除的信息', 'warning');
								return;
							} else if (checkedRows.length > 1) {
								$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
								return;
							}
							$.messager.confirm('My Title', 'Sure you want to delete this record?', function(r){
								if (r){
									$('#id').val(checkedRows[0].id);
									$('#deleteform').form('submit',{
										url:'${pageContext.request.contextPath}/maintenance/goods/doDelete.do',
										success : function(result) {
											try {
												var r = $.parseJSON(result);
												if (r.success) {
													$.messager.alert('提示', r.msg);
							
												} else {
													$.messager.alert('提示', r.msg);
												}
											} catch (e) {
												$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
											}
										}
									});
									$('#datagrid').datagrid('reload');
							
								}
							});
							
						}
					}],
			onHeaderContextMenu : function(e, field) {
				e.preventDefault();
			}
		});
		$('#form_Goods').form({
			success : function(result) {
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.show({
							title:'My Title',
							msg:r.msg,
							timeout:1000,
							showType:'slide'
						});
							$('#dialog_Goods').dialog('close');
							$('#datagrid').datagrid('reload');
						
					} else {
						$.messager.show({
							title:'error',
							msg:r.msg,
							timeout:1000,
							showType:'slide'
						});
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		
	});
	/* 提交方法 */
	function submit_form() {
		var opt = $('#datagrid').datagrid('options');
		opt.url = '${pageContext.request.contextPath}/maintenance/goods/doSearch.do';
		$('#datagrid').datagrid('options', opt);
		$('#datagrid').datagrid('load', serializeObject($('#form')));
	}
	function reset_form() {
		$('#form').form('clear');
	}

/* 显示添加货品窗口 */
	function showAddDialog() {
		$('#form_Goods').attr('action', '${pageContext.request.contextPath}/maintenance/goods/doAdd.do');
		$('#form_Goods').form('load', {
			commodity : '',
			specification : '',
			quantity : '',
			unitPriceUS:'',
			unitPrice:'',
			unit_id:'',
			status:0
		});
			$('#dialog_Goods').dialog('setTitle','Add Goods');
			$('#dialog_Goods').dialog('open');
		}


	
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 70px;overflow: hidden;" align="center">
		<form id="form" method="post">
			<table class="tableForm">
				<tr>
					<td><s:message code="p_main.maintenance.goods.goodsName"/>:</td>
					<td><input id="goodsName" name="commodity" class="easyui-validatebox" style="width: 100px"></td>
					<td><s:message code="p_main.maintenacte.goods.status"/>:</td>
					<td><select id="combobox_status" class="easyui-combobox" name="status" style="width: 100px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
							<option value="1"><s:message code="common.status.disabled" /></option>
					</select></td>
					<td>
							<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a>
							<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a> 
					</td>
				</tr>
			</table>
		</form>
		</div>
		<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
		</div>
		
		
		
			<div id="dialog_Goods" class="easyui-dialog" style="width:400px;height:300px;" data-options="iconCls:'icon-add',resizable:true,modal:true,closed: true,buttons: '#dialog_add_buttons'">
			<form id="form_Goods" method="post">
				<input id="id" name="id" type="hidden"/>
				<table class="tableForm" align="center">
					<tr>
						<td><s:message code="p_main.maintenance.goods.goodsName"/>:</td>
						<td><input id="commodity" name="commodity" class="easyui-validatebox" data-options="required:true" style="width: 180px"></td>
					</tr>
					<tr>
						<td><s:message code="p_main.maintenacte.goods.specification"/>:</td>
						<td><input id="specification" name="specification" class="easyui-validatebox" data-options="required:true" style="width:180px"/></td>
					</tr>
					<tr>
						<td><s:message code="p_main.maintenacte.goods.quantity"/>:</td>
						<td><input id="quantity" name="quantity" class="easyui-numberbox" data-options="min:0" style="width: 100px"/>
						<input id="unit_id" name="unit_id" class="easyui-combobox" style="width: 80px" data-options="valueField:'first',textField:'second',data:unitData"/>
						</td>	
					</tr>
					<%--<tr>
						<td><s:message code="p_main.maintenacte.goods.unitpriceus"/>:</td>
						<td><input id="unitPriceUS" name="unitPriceUS" class="easyui-numberbox" data-options="min:0,precision:6" style="width: 180px"/></td>
					</tr>
					--%><tr>
						<td><s:message code="p_main.maintenacte.goods.unitprice"/>:</td>
						<td><input id="unitPrice" name="unitPrice" class="easyui-numberbox" data-options="min:0,precision:6" style="width: 180px"/></td>
					</tr>
					<tr>
						<td><s:message code="p_main.maintenacte.goods.status"/>：</td>
						<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
							<option value="1"><s:message code="common.status.disabled" /></option>
							</select></td>
					</tr>
				</table>
				<div id="dialog_add_buttons">
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_Goods').submit();"><s:message code="common.button.submit" /></a>
				</div>
			</form>
		</div>
		<div>
		<form id="deleteform" method="post">
		<input id="id" name="id" type="hidden"/>
		</form>
		</div>
</body>
</html>