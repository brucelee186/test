<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Add User</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	$('#formFileUploader').form({
		url : '${pageContext.request.contextPath}/upload/attachment/fileUploader.do?type=image',
		success : function(result) {
			var j = $.parseJSON(result);
			var success = j.success;
			if (success == undefined) {
				$.messager.alert('<s:message code="common.dialog.error" />', '上传文件请不要超过30M', 'error');
			}else if (success == true) {
				var savePathFile = j.obj.savePathFile;
				$('#image').attr('src', '${pageContext.request.contextPath}' + savePathFile);
				$('#signature').val('${pageContext.request.contextPath}' + savePathFile);
				$.messager.show({
					title:'<s:message code="common.dialog.tip" />',
					msg:'上传附件成功',
					timeout:2500,
					showType:'fade'
				});
			}
		}
	});
	$('#form').form({
		url : '${pageContext.request.contextPath}/maintenance/user/doAdd.do',
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
					$('#form').form('load',{
						loginName : '',
						displayName : '',
						password : '123456',
						'userProfile.fullname' : '',
						'userProfile.email' : '',
						'userProfile.language' : 'en',
						status : '0'
					});
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});

	$('#txt_loginname').change(function() {
		if ($('#txt_email').val() == '') {
			$('#txt_email').val($(this).val() + "@manchutimesfashion.com");
		}
		if ($('#txt_displayname').val() == '') {
			$('#txt_displayname').val($(this).val());
		}
	}); 
});
	
//上传附件提交
function submitFormFileUploader() {
	var file = $('#file').val();
	if (file == '') {
		$.messager.alert('<s:message code="common.dialog.tip" />', '请选择上传文件', 'warning');
		return;
	}
	var suffix=file.substring(file.indexOf('.')+1,file.length);
	suffix=suffix.toLowerCase();
	if(suffix=="jpg"||suffix=="png"||suffix=="gif"||suffix=="jpeg"||suffix=="xls"||suffix=="xlsx"||suffix=="xlsm"||suffix=="xltm"||suffix=="xlam"||suffix=="xlsb"||suffix=="doc"||suffix=="docx"){
		$('#formFileUploader').submit();
	}else{
		$.messager.alert('<s:message code="common.dialog.tip" />', '上传文件类型不符合', 'warning');
		
		return;
	}
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'User Info',border:false" align="center">
		<form id="form" method="post">
			<!-- <input type="hidden" id="signature" name="signature" /> -->
			<table class="tableForm">
				<tr>
					<th width="120px">Login Name :</th>
					<td><input id="txt_loginname" class="easyui-validatebox" type="text" style="width: 250px" name="loginName" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
				<tr>
					<th>Display Name : </th>
					<td><input id="txt_displayname" class="easyui-validatebox" type="text" style="width: 250px" name="displayName" data-options="required:true, validType:'length[1,30]'" /></td>
				</tr>
				<tr>
					<th>Password :</th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="password" value="123456" data-options="required:true, validType:'length[6,30]'" /></td>
				</tr>
				<tr>
					<th>Full Name : </th>
					<td><input class="easyui-validatebox" type="text" style="width: 250px" name="userProfile.fullname" data-options="required:true, validType:'length[1,30]'" /></td>
				</tr>
				<tr>
					<th>Email : </th>
					<td><input id="txt_email" class="easyui-validatebox" type="text" style="width: 250px" name="userProfile.email" data-options="validType:'email'" /></td>
				</tr>
				<tr>
					<th>Language : </th>
					<td><select id="combobox_language" class="easyui-combobox" name="userProfile.language" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<%-- <option value="en" ><s:message code="common.language.english"/></option> --%>
						<option value="zh" selected="selected"><s:message code="common.language.chinese"/></option></select></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select id="combobox_status" class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" selected="selected"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option>
						<option value="2"><s:message code="common.status.register" /></option></select></td>
				</tr>
		</form>
		<form id="formFileUploader" method="post" enctype="multipart/form-data">
				<tr>
					<th>Signature : </th>
					<td>
						<img id="image" alt="" src="" width="116" height="116" />
					<br>		
					<input type="file" id="file" name="listFile[0]" style="background:transparent;border-width:1px;" onchange="submitFormFileUploader();" />
					</td>		
					
				</tr>
		</form>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
			</div>
	</div>
</body>
</html>