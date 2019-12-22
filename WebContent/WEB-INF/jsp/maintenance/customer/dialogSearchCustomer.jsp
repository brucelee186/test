<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<script type="text/javascript">
$(document).ready(function(){
	$("#dialogSearchCustomer").click(function(){
		$('#dialog_form_searchCustomer').form('clear');
		var opt = $('#dialog_datagridCustomer').datagrid('options');
		opt.url = '${pageContext.request.contextPath}/maintenance/customer/doDataGridSearch.do';
		$('#dialog_datagridCustomer').datagrid('options', opt);
		$('#dialog_datagridCustomer').datagrid('load', serializeObject($('#dialog_form_searchCustomer')));
		$('#dialog_winSearchCustomer').window({
			iconCls:'icon-search',
			title: 'Search',
			resizable:false,
			modal: true,
			draggable:true,
			collapsible:false,
			shadow: true,
			closed: false,
			maximizable:false,
			minimizable:false,
			width:717,
			height:437
			
		});
		 $('#dialog_winSearchCustomer').show();
	});
});

$(function() {
	$('#dialog_datagridCustomer').datagrid({
		fit : true,
		fitColumns : false,
		border : false,
		pagination : true,
		border: false,  
		idField : 'id',
		pageSize : 10,
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
				width : 100,
				sortable : true
			},{
				title : '<s:message code="p_main.maintenance.customer.customerNo"/>',
				field : 'customerNo',
				width : 100,
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
		onDblClickRow:function(rowIndex,rowData){
			//客户ID
			$('#com_customersId').val(rowData.id);
			//客户名称
			$('#com_customersName').val(rowData.name);
			//客户编号
			$('#com_customerNo').val(rowData.customerNo);
			//规模
			$('#com_customersScope').val(rowData.scope);
			//种类
			$('#com_customersKind').val(rowData.kind);
			//地址
			$('#com_customersAddress').val(rowData.address);
			//公司性质
			$('#com_customersCompanyProperty').val(rowData.companyProperty);
			//法人
			$('#com_customersCorporation').val(rowData.corporation);
			//联系方式
			$('#com_customersContact').val(rowData.contact);
			//状态
			$('#com_customersStatus').val(rowData.status);
			$("#dialog_winSearchCustomer").window('close');
			
		}
	});
});

function submit_form_customer() {
	var opt = $('#dialog_datagridCustomer').datagrid('options');
	opt.url = '${pageContext.request.contextPath}/maintenance/customer/doDataGridSearch.do';
	$('#dialog_datagridCustomer').datagrid('options', opt);
	$('#dialog_datagridCustomer').datagrid('load', serializeObject($('#dialog_form_searchCustomer')));
}

function reset_form_customer() {
	$('#dialog_form_searchCustomer').form('clear');
}
	
</script>
	
	<div id="dialog_winSearchCustomer" class="easyui-layout"  style="width:700px;display:none;height:400px;">
		<div data-options="region:'north',title:'',border:false" style=" overflow:'hidden'; height:110px;" align="center">
			<form id="dialog_form_searchCustomer" method="post">
				<table class="tableForm" fit="true">
					<tr>
						<th><s:message code="p_main.maintenance.customer.customersName"/>：</th>
						<td><input  name="name" style="width: 250px"></input></td>	
						<th><s:message code="p_main.maintenance.customer.customerNo"/>：</th>
						<td><input  class="easyui-validatebox" name="customerNo" style="width: 250px"></input></td>
					</tr>
					<tr>
						<th><s:message code="p_main.maintenance.customer.corporation"/>：</th>
						<td><input class="easyui-validatebox" name="corporation" style="width: 250px" /></td>
						<th><s:message code="p_main.maintenance.customer.status"/>：</th>
						<td><select class="easyui-combobox" name="status" style="width: 250px" data-options="panelHeight:'auto',editable:false ">
								<option value="0" selected="selected">Enabled</option>
								<option value="1">Disabled</option>
						</select></td>
					</tr>
				</table>
			</form>
				<div style="text-align: center; padding: 5px">
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form_customer();"><s:message code="common.button.search" /></a> 
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form_customer();"><s:message code="common.button.reset" /></a>
				</div>
		</div>
		<div data-options="region:'center',title:'',border:false"  align="center">
			<table id="dialog_datagridCustomer"></table>
		</div>
	</div>


