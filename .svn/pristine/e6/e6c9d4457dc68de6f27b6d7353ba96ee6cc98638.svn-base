<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>edit item rule</title>
<jsp:include page="../inc.jsp"></jsp:include>

<script type="text/javascript" charset="utf-8">
$(function() {
	var hid_editState =$("#hid_editState").val(); 
	if('u'==hid_editState){
		$("#txt_type"). attr("readonly","readonly");
		$("#txt_unit"). attr("readonly","readonly");
		$("#txt_specification"). attr("readonly","readonly");
		$("#txt_price"). attr("readonly","readonly");
		
	}
	
	$('#formItemrule').form({
		url : '${pageContext.request.contextPath}/office/itemrule/doEdit.do',
		onSubmit: function() {
			if($('#amountDefault').val() > $('#amountMax').val()){
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.amountDefaultBigger" />', 'error');
				return false;
			}
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
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					window.location.href = '${pageContext.request.contextPath}/office/itemrule/toSearch.do';
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
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'<s:message code="office.title.itemInput" />',border:false" align="center">
		<form id="formItemrule" method="post">
		<input type="hidden" name="id" value="${itemrule.id}"/>
		<input id="hid_editState" type="hidden"  value="${param.editState}"/>
			<table class="tableForm">
				<tr>
					<th><s:message code="office.rowName.type" /> : </th>
					<td><input id="txt_type" class="easyui-validatebox" type="text" style="width: 250px" name="type" value="${itemrule.type}" data-options="required:true, validType:'length[1,20]'" /></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.specification" /> :</th>
					<td><input id="txt_specification" class="easyui-validatebox" type="text" style="width: 250px" name="specification" value="${itemrule.specification}"  data-options="required:true, validType:'length[1,20]'" /></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.unit" /> : </th>
					<td><input id="txt_unit" class="easyui-validatebox" type="text" style="width: 250px" name="unit" value="${itemrule.unit}" data-options="required:true, validType:'length[1,20]'" /></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.price" /> : </th>
					<td><input id="txt_price" class="easyui-numberbox" precision="2" type="text" style="width: 250px" name="price" value="${itemrule.price}" validType:'length[1,7]'/></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.supplier" /> : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="supplier" value="${itemrule.supplier}" data-options=" validType:'length[1,20]'" /></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.remarks" /> : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="remarks" value="${itemrule.remarks}" data-options=" validType:'length[1,20]'" /></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.amountDefault" /> : </th>
					<td><input  class="easyui-numberbox" precision="0" type="text" style="width: 250px" id="amountDefault" name="amountDefault" value="${itemrule.amountDefault}" validType:'length[1,2]' maxlength=2/></td>
				</tr>
				<tr>
					<th><s:message code="office.rowName.amountMax" /> : </th>
					<td><input  class="easyui-numberbox"  precision="0" type="text" style="width: 250px" id="amountMax" name="amountMax" value="${itemrule.amountMax}" validType:'length[1,2]' maxlength=2/></td>
				</tr>
				<!-- <tr>
					<th>状态：</th>
						<td><select class="easyui-combobox" name="status" style="width: 255px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" selected="selected" >可用</option>
							<option value="1"  >禁用</option>
							</select></td>
				</tr> -->
				<tr>
				<th><s:message code="office.rowName.status" />：</th>
				<td>
				<input name="status" type="radio" value="0" ${itemrule.status==0?'checked':'' } /><s:message code="office.rowlable.enable" />
	 			<input name="status" type="radio" value="1" ${itemrule.status==1?'checked':'' } /> <s:message code="office.rowlable.disable" /></td>
				</tr>
		</form>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#formItemrule').submit();"><s:message code="office.button.submit" /></a>
			</div>
	</div>
</body>
</html>