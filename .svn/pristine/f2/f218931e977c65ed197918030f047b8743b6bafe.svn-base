<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>add customer</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>

<script type="text/javascript" charset="utf-8">


$(function() {
	$('#form_addCustomer').form({
		url : '${pageContext.request.contextPath}/maintenance/customer/doAdd.do',
		success : function(result) {
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					alert("添加成功！");
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
<div data-options="region:'center',title:'添加客户',border:false" align="center">
<form id="form_addCustomer" method="post">
				<table class="tableForm">
 					<tr>
						<th >名称：</th>
						<td>
						<input id="txt_addName" class="easyui-validatebox" name="name" style="width: 250px" data-options="required:true" /></td>
						
						<th >编号：</th>
						<td><input id="txt_addNo" class="easyui-validatebox" name="customerNo" style="width: 250px" data-options="required:true" /></td>
					</tr>
					<tr>
						<th>品种：</th>
						<td><input id="txt_addKind"  class="easyui-validatebox" type="text" style="width: 250px" name="kind" data-options="required:true" /></td>
						
						<th>规模：</th>
						<td><input id="txt_addScope"  class="easyui-numberbox" type="text" style="width: 250px" name="scope" data-options="min:0,precision:0" /></td>
					</tr>
					<tr>
						<th>法人：</th>
						<td><input id="txt_addCorporation"  class="easyui-validatebox" type="text" style="width: 250px" name="corporation" data-options="required:true" /></td>
						
						<th>公司性质：</th>
						<td><select id="combobox_addCorporation" class="easyui-combobox" name="companyProperty" style="width: 250px" data-options="panelHeight:'auto',editable:false ">
								<option value="0" selected="selected">国有</option>
								<option value="1">私有</option>
						</select></td>
					</tr>
					<tr>
						<th>联系方式：</th>
						<td><input id="txt_addContact"  class="easyui-numberbox" type="text" style="width: 250px" name="contact" data-options="min:0,precision:0" /></td>
					
						<th>状态：</th>
						<td><select id="combobox_editstatus" class="easyui-combobox" name="status" style="width: 250px" data-options="panelHeight:'auto',editable:false ">
								<option value="0" selected="selected">Enabled</option>
								<option value="1">Disabled</option>
						</select></td>

					</tr>
						
				</table>
				<!-- style="text-align: center;  padding: 5px" -->
				<div style="padding: 5px">
					<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_addCustomer').submit()"> 提交</a>
				</div>
			</form>

</div>
</body>
</html>