<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email </title>
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	
	$('#email').form({
		url : '${pageContext.request.contextPath}/office/email/doSend.do',
		success : function(result) {
			$.messager.progress('close');	// hide progress bar while submit successfully
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});
});	

function reset_form() {
	$('#email').form('clear');
}
</script>
</head>
<body>
<form id= "email" method="post"><p align="center">填写邮件内容</p>
<div align="center"> 
	<table border="1">
	<tr>
	<td><div align="center">选择收件人</div></td>
	<td><select style="width:120px" name="flag">
	<option value="0">所有员工</option>
	<option value="1">所有部门经理</option>
	<option value="4">所有高管人员</option>
	</select></td>
	</tr>
	<tr> 
	<td><div align="center">主题</div></td><td>
	<input name="theme" type="text" id="subject" size="70" maxlength="30"></td>
	</tr>
	<tr> 
	<td colspan="2"><div align="center"> 
	<textarea class="ckeditor" cols="80" id="content" name="content" rows="10">
	</textarea> 
	</div></td>
	</tr>
	<tr> 
	<td colspan="2"><div align="center"> 
	<input type="button" name="Submit" value="发送" onclick="$('#email').submit();">&nbsp;&nbsp;&nbsp;&nbsp; 
	<input name="Reset" type="button" id="Reset" value="清空" onclick="reset_form()"></div></td>
	</tr>
	</table>
</div> 
	</form> 
	
</body>
</html>