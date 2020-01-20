<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Supplier</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">

$(function() {
	$('#form').form('clear');
	$('#dialog_updateCustomer').dialog({
		
		resizable:true,
		modal:true,
		closed: true,
		hidden:true,
		buttons: '#buttons_submit_updateCustomer',
		onClose : function(){ 
			$('#datagrid').datagrid('reload');
		}
	});
	
//弹出dialog的form	
	$('#form_searchCustomer').form({
		//url : '${pageContext.request.contextPath}/maintenance/customer/doEdit.do',
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
					$.messager.show({
						title:'<s:message code="common.dialog.tip" />',
						msg:'OK!',
						timeout:5000,
						showType:'slide'
					});

				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});
	

	var dg=$('#datagrid').datagrid({
		url :'${pageContext.request.contextPath}/maintenance/customer/doDataGridSearch.do',
		fit : true,
		fitColumns : true,
		border : false,
		pagination : true,
		border: false,  
		idField : 'id',
		pageSize : 20,
		pageList : [ 10, 20, 50, 100, 200 ],
		sortName : 'Name',
		sortOrder : 'asc',
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		nowrap : true,
		rownumbers : true,
		striped: true,
		frozenColumns : [ [
			{
				title : 'Id',
				field : 'id',
				width : 1,
				sortable : false,
				hidden : true
			},{
				title : '<s:message code="p_main.maintenance.customer.customersName"/> ',
				field : 'name',
				width : 200,
				sortable : true
			},{
				title : '<s:message code="p_main.maintenance.customer.customerNo"/>',
				field : 'customerNo',
				width : 200,
				sortable : true
			}] ],
			 columns : [ [{
				title : '<s:message code="p_main.maintenance.customer.kind"/>',
				field : 'kind',
				width : 100,
				sortable : true
			},{
				title : '<s:message code="p_main.maintenance.customer.address"/>',
				field : 'address',
				width : 100,
				sortable : false
			},{
				title : '<s:message code="p_main.maintenance.customer.scope"/>',
				field : 'scope',
				width : 100,
				sortable : true
			},{
				title : '<s:message code="p_main.maintenance.customer.companyProperty"/>',
				field : 'companyProperty',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0) {
						return '<s:message code="p_main.maintenance.customer.national" />';
					} else if (value == 1) {
						return '<s:message code="p_main.maintenance.customer.private" />';
					} ;
				}
			},{
				title : '<s:message code="p_main.maintenance.customer.corporation"/>',
				field : 'corporation',
				width : 100,
				sortable : true
			},{
				title : '<s:message code="p_main.maintenance.customer.contact"/>',
				field : 'contact',
				width : 100,
				sortable : false
			},{
				title : '<s:message code="p_main.maintenance.customer.status"/>',
				field : 'status',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0) {
						return '<s:message code="common.status.enabled" />';
					} else if (value == 1) {
						return '<s:message code="common.status.disabled" />';
					} ;
				},
				styler : function(value, row, index) {
					if (value == 0) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
		}]],
		toolbar : [{
			iconCls : 'icon-add',
			text : '<s:message code="common.button.add" />',
			handler : function() {
				$('#form_searchCustomer').attr('action', '${pageContext.request.contextPath}/maintenance/customer/doAdd.do');
				$('#form_searchCustomer').form('clear');
				
				var opt=$('#dialog_updateCustomer').dialog('options');
				opt.iconCls="icon-add";
				//console.info(options);
				$('#dialog_updateCustomer').dialog('options',opt);
				$('#dialog_updateCustomer').dialog('setTitle','<s:message code="p_main.maintenance.customer.title.addCustomer"/>');
				$('#dialog_updateCustomer').dialog('open');
			}
		},'-',{
			iconCls : 'icon-edit',
			text : '<s:message code="common.button.edit" />',
			handler : function() {
				var row=undefined;	
				row = $('#datagrid').datagrid('getSelected');
				if (row == undefined) {
					$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="common.dialog.updateTip" />', 'warning');
					return;
				}
				$('#form_searchCustomer').attr('action', '${pageContext.request.contextPath}/maintenance/customer/doEdit.do');
				$('#form_searchCustomer').form('load',{
					id : row.id,
					name : row.name,
					customerNo : row.customerNo,
					scope: row.scope,
					kind: row.kind,
					address: row.address,
					companyProperty: row.companyProperty,
					scope: row.scope,
					corporation: row.corporation,
					contact : row.contact,
					status : row.status
				});
				 $('#dialog_updateCustomer').dialog('setTitle','<s:message code="p_main.maintenance.customer.title.editCustomer"/>');
				 $('#dialog_updateCustomer').dialog('open'); 
			}
		},'-',{
			iconCls : 'icon-remove',
			text : '<s:message code="common.button.delete" />',
			handler : function() {
				
				var checkedRows = $('#datagrid').datagrid('getSelections');
				if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
					$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="common.dialog.deleteTip" />', 'warning');
					return;
				} 
				$.messager.confirm('<s:message code="common.dialog.tip" />', formatString('<s:message code="p_main.maintenance.customer.message.deleteCustomer" /><br><s:message code="p_main.maintenance.customer.customersName"/>:{0}<br><s:message code="p_main.maintenance.customer.customerNo"/>:{1}',checkedRows[0].name,checkedRows[0].customerNo), function(r){
					if (r){
						var id=$('#idForCustomer').val(checkedRows[0].id);
						 $('#form_deleteCustomer').form('submit',{
							url:'${pageContext.request.contextPath}/maintenance/customer/doDelete.do?id='+id,
							success : function(result) {
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										//$.messager.alert('<s:message code="common.dialog.tip" />', r.msg);
										$.messager.show({
											title:'<s:message code="common.dialog.tip" />',
											msg: r.msg ,
											timeout:5000,
											showType:'slide'
										});
									} else {
										$.messager.alert('<s:message code="common.dialog.tip" />', r.msg);
									}
								} catch (e) {
									$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
								}
							}
						}); 
						 $('#datagrid').datagrid('unselectAll');
						$('#datagrid').datagrid('load');
					}
				});
			}
		}]
	});
});
	
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="p_main.tree.maintenance.customers.management"/>',border:false" style=" overflow:'hidden'; height:135px;" align="center">
		<form id="form" method="post">
			<table class="tableForm" fit="true">

				<tr>
					<th><s:message code="p_main.maintenance.customer.customersName"/>：</th>
					<td><input  name="name" style="width: 250px"></input></td>
					
					
					<th><s:message code="p_main.maintenance.customer.customerNo"/>：</th>
					<td><input  class="easyui-validatebox" name="customerNo" style="width: 250px"></input></td>
					
				</tr>
				<tr>
					<th><s:message code="p_main.maintenance.customer.corporation"/>：</th>
					<td><input class="corporation" name="typeId" style="width: 250px" /></td>
					

					<th><s:message code="p_main.maintenance.customer.status"/>：</th>
					<td><select class="easyui-combobox" name="status" style="width: 250px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" ><s:message code="common.status.enabled" /></option>
							<option value="1"><s:message code="common.status.disabled" /></option>
					</select></td>
					
					
				</tr>
			</table>
		</form>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> 
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
	</div>		
	<div data-options="region:'center',title:'',border:false"  align="center">
		<table id="datagrid" fit="true"></table>
		<script>
			function submit_form() {
				var opt = $('#datagrid').datagrid('options');
				opt.url = '${pageContext.request.contextPath}/maintenance/customer/doDataGridSearch.do';
				$('#datagrid').datagrid('options', opt);
				$('#datagrid').datagrid('load', serializeObject($('#form')));
			}
			function reset_form() {
				$('#form').form('clear');
			}
		</script>
	</div>
	<div id="dialog_updateCustomer" class="easyui-dialog"  style="width: 450px; height: 400px; overflow:'hidden';">
		<form id="form_searchCustomer" method="post">
			<!-- 1 -->
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.customersName"/> ：</th>
					<td><input name="name" class="easyui-validatebox" type="text" style="width: 250px"  data-options="required:true" /></td>
				</tr>
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.customerNo"/> ：</th>
					<td><input name="customerNo" class="easyui-validatebox" type="text" style="width: 250px" data-options="required:true" /></td>
				</tr>
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.scope"/>：</th>
					<td><input name="scope" class="easyui-numberbox" type="text" style="width: 250px" data-options="min:0,precision:0,required:true" /></td>
				</tr>
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.corporation"/>：</th>
					<td><input name="corporation" class="easyui-validatebox" type="text" style="width: 250px" data-options="required:true" /></td>
				</tr>
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.kind"/>：</th>
					<td><input name="kind" class="easyui-validatebox" type="text" style="width: 250px" data-options="required:true" /></td>
				</tr>
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.address"/>：</th>
					<td><input name="address" class="easyui-validatebox" type="text" style="width: 250px" data-options="required:true" /></td>
				</tr>
				
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.contact"/>：</th>
					<td><input name="contact" class="easyui-numberbox" type="text" style="width: 250px" data-options="min:0,precision:0,required:true" /></td>
				</tr>
				
				
				<tr>
					<th style="width: 100px;"><s:message code="p_main.maintenance.customer.companyProperty"/>：</th>
					<td><select class="easyui-combobox" name="companyProperty" style="width: 250px" data-options="panelHeight:'auto',editable:false,required:true ">
								<option value="0" selected="selected"><s:message code="p_main.maintenance.customer.national" /></option>
								<option value="1"><s:message code="p_main.maintenance.customer.private" /></option>
						</select></td>
				</tr>
				
				<tr>
					<th><s:message code="p_main.maintenance.customer.status"/>：</th>
					<td><select  class="easyui-combobox" name="status" style="width: 250px" data-options="panelHeight:'auto',editable:false,required:true ">
							<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
							<option value="1"><s:message code="common.status.disabled" /></option>
					</select></td>
				</tr>

			</table>
		</form>
		
	</div>
	<div><form id="form_deleteCustomer">
	<input type="hidden" id="idForCustomer" name="id"/>
	</form></div>
	<div id="buttons_submit_updateCustomer">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_searchCustomer').submit();"><s:message code="common.button.submit" /></a>
	</div>
</body>
</html>
