<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<script type="text/javascript">
$(document).ready(function(){
	$("#dialogAddCustomer").click(function(){
		$('#dialog_winAddCustomer').window({
			iconCls:'icon-add',
			title: 'Add',
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
		
		//$('dialog_form_addCustomer').form('clear');
		$('#dialog_form_addCustomer').form('load',{
			id : '',
			name :  '',
			customerNo :  '',
			scope: '',
			kind : '',
			address : '',
			companyProperty:  '',
			scope:  '',
			corporation:  '',
			contact :  '',
			status : ''
			
		});
		$('#dialog_winAddCustomer').show();
	});
});

$(function() {
	$('#dialog_form_addCustomer').form({
		url : '${pageContext.request.contextPath}/maintenance/customer/doAdd.do',
		success : function(result) {
			
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					//客户名称
					$('#com_customersName').val(r.obj.name);
					//客户编号
					$('#com_customerNo').val(r.obj.customerNo);
					//规模
					$('#com_customersScope').val(r.obj.scope);
					//种类
					$('#com_customersKind').val(r.obj.kind);
					//地址
					$('#com_customersAddress').val(r.obj.address);
					//公司性质
					$('#com_customersCompanyProperty').val(r.obj.companyProperty);
					//法人
					$('#com_customersCorporation').val(r.obj.corporation);
					//联系方式
					$('#com_customersContact').val(r.obj.contact);
					//状态
					$('#com_customersStatus').val(r.obj.status);
					//alert("<s:message code="p_main.maintenance.customer.message.addCustomerSuccessfully" />");
					$.messager.show({
						title:'<s:message code="common.dialog.tip" />',
						msg: '<s:message code="p_main.maintenance.customer.message.addCustomerSuccessfully" />' ,
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
});	
</script>
	<div  id="dialog_winAddCustomer" class="easyui-layout"  style="width:700px;display:none;height:400px;">
		<div data-options="region:'center',title:'',border:false"  align="center">
			<form id="dialog_form_addCustomer" method="post">
				<table class="tableForm">
 					<tr>
						<th ><s:message code="p_main.maintenance.customer.customersName"/>：</th>
						<td>
						<input id="txt_addName" class="easyui-validatebox" name="name" style="width: 250px" data-options="required:true" /></td>
						
						<th ><s:message code="p_main.maintenance.customer.customerNo"/>：</th>
						<td><input id="txt_addNo" class="easyui-validatebox" name="customerNo" style="width: 250px" data-options="required:true" /></td>
					</tr>
					<tr>
						<th><s:message code="p_main.maintenance.customer.kind"/>：</th>
						<td><input id="txt_addKind"  class="easyui-validatebox" type="text" style="width: 250px" name="kind" data-options="required:true" /></td>
						
						<th><s:message code="p_main.maintenance.customer.scope"/>：</th>
						<td><input id="txt_addScope"  class="easyui-numberbox" type="text" style="width: 250px" name="scope" data-options="min:0,precision:0,required:true" /></td>
					</tr>
					<tr>
						<th><s:message code="p_main.maintenance.customer.corporation"/>：</th>
						<td><input id="txt_addCorporation"  class="easyui-validatebox" type="text" style="width: 250px" name="corporation" data-options="required:true" /></td>
						
						<th><s:message code="p_main.maintenance.customer.companyProperty"/>：</th>
						<td><select id="combobox_addCorporation" class="easyui-combobox" name="companyProperty" style="width: 250px" data-options="panelHeight:'auto',editable:false,required:true ">
								<option value="0" selected="selected"><s:message code="p_main.maintenance.customer.national" /></option>
								<option value="1"><s:message code="p_main.maintenance.customer.private" /></option>
						</select></td>
					</tr>
					<tr>
						<th><s:message code="p_main.maintenance.customer.contact"/>：</th>
						<td><input id="txt_addContact"  class="easyui-numberbox" type="text" style="width: 250px" name="contact" data-options="min:0,precision:0,required:true" /></td>
					
						<th><s:message code="p_main.maintenance.customer.status"/>：</th>
						<td><select id="combobox_editstatus" class="easyui-combobox" name="status" style="width: 250px" data-options="panelHeight:'auto',editable:false,required:true ">
								<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
								<option value="1"><s:message code="common.status.disabled" /></option>
						</select></td>
					</tr>
						<tr>
						<th><s:message code="p_main.maintenance.customer.address"/>：</th>
						<td colspan="3"><input id="txt_addAddress"  class="easyui-validatebox" type="text" style="width: 550px" name="address" data-options="required:true" /></td>
						</tr>
				</table>
				<!-- style="text-align: center;  padding: 5px" -->
				<div style="padding: 5px">
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#dialog_form_addCustomer').submit()"> 提交</a>
				</div>
			</form>
		</div>
	</div>

