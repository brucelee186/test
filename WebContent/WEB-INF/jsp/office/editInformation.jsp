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
	
	$('#formItemrule').form({
		url : '${pageContext.request.contextPath}/information/doEdit.do',
		success : function(result) {
			$.messager.progress('close');	// hide progress bar while submit successfully
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					window.location.href = '${pageContext.request.contextPath}/information/toSearch.do';
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
		<input type="hidden" name="id" value="${information.id}"/>
		<%-- <input id="hid_editState" type="hidden"  value="${param.editState}"/> --%>
			<table class="tableForm">
				<tr>
					<th>滚动标语 : </th>
					<%-- <td><input  class="easyui-validatebox" type="text" style="width: 250px" name="remarks" value="${information.remarks}"  /></td> --%>
					<td><input  class="easyui-validatebox" type="text" style="width: 250px" name="remarks" value="${information.remarks}"  /></td>
				</tr>
				<tr>
					<th><s:message code="链接标语" /> :</th>
					<td><input  class="easyui-validatebox" type="text" style="width: 250px" name="linkRemarks" value="${information.linkRemarks}" /></td>
				</tr>
				
				<tr>
					<th><s:message code="链接路径" /> :</th>
					<td><input  class="easyui-validatebox" type="text" style="width: 250px" name="url" value="${information.url}" /></td>
				</tr>
				
				<tr>
				<th><s:message code="office.rowName.status" />：</th>
				<td>
				<input name="status" type="radio" value="0" ${information.status==0?'checked':'' } /><s:message code="office.rowlable.enable" />
	 			<input name="status" type="radio" value="1" ${information.status==1?'checked':'' } /> <s:message code="office.rowlable.disable" /></td>
				</tr>
		</form>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#formItemrule').submit();"><s:message code="office.button.submit" /></a>
			</div>
	</div>
</body>
</html>