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
var userId = '${user.id}';
$(function() {
	//$('#qr_pass_div').hide();
	var userLever=$('#userLever').val();
	$('#formFileUploader').form({
		url : '${pageContext.request.contextPath}/upload/attachment/fileUploader.do?type=image&userId='+ userId,
		success : function(result) {
			var j = $.parseJSON(result);
			var success = j.success;
			if (success == undefined) {
				$.messager.alert('<s:message code="common.dialog.error" />', '上传文件请不要超过30M', 'error');
			}else if (success == true) {
				
				var savePathFile = j.obj.savePathFile;
				var savePathFileTrue = '${pageContext.request.contextPath}' + savePathFile;
				var typeImage = $('#typeImage').val();
				$('#image_' + typeImage).attr('src', savePathFileTrue);
				$('#'+ typeImage).attr('value', savePathFileTrue);
				$.messager.show({
					title:'<s:message code="common.dialog.tip" />',
					msg:'上传图片成功',
					timeout:2500,
					showType:'fade'
				});
			}
		}
	});
	$('#form').form({
		url : '${pageContext.request.contextPath}/maintenance/user/doEdit.do',
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
				var obj = r.obj;
				if (r.success) {
					var stateInit = obj.stateInit;
					if ('r' != stateInit) {
						if (userLever == '9') {
							$.messager.show({
								title:'<s:message code="common.dialog.tip" />',
								msg:'用户信息修改成功',
								timeout:2500,
								showType:'fade'
							});
						}else {
						$.messager.confirm('<s:message code="common.dialog.tip" />', '<s:message code="officeTree.dashboard.successAndReLogin" />', function(result){
							if (result){
								$.getJSON('${pageContext.request.contextPath}/user/doLogout.do?rnd=' + (new Date().getTime()), function(result) {
									location.reload();
								});
							} else {
								$.getJSON('${pageContext.request.contextPath}/user/doLogout.do?rnd=' + (new Date().getTime()), function(result) {
									location.reload();
								});
							}
						});
						}
					}
					// 如果为新用户注册情况下, 跳转页面
					else if ('r' == stateInit) {
						var userId = obj.id;
						window.location = '${pageContext.request.contextPath}/maintenance/userDetail/toEdit.do?editState=u&userId=' + userId;
						
					}
				} 
					else {
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
// passowrd赋值
function passwordTemp(){
	var id_pass = $('#id_pass').val();
	$('#ch_pass').val(id_pass);
}
// 清空密码
function passwordClean(){
	$('#id_pass').val("");
	$('#qr_pass').val("");

}
function passwordAffirm(){
	var oldPass = $('#ch_pass').val();
	var newPass = $('#qr_pass').val();
	if (oldPass == newPass) {
		return;
	}else {
		$.messager.alert('<s:message code="common.dialog.error" />', '<s:message code="officeTree.dashboard.pwdNoMatch" />', 'error');
	}
}

// 清空选择上传文件
function fileClean(){
	
			 $.post("${pageContext.request.contextPath}/upload/attachment/doDeleteFile.do", { userId : userId }, function(result) {
				try {
					var j = $.parseJSON(result);
					if (j.success) {
						//$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {});
					} else {
						//$.messager.alert('<s:message code="common.dialog.error" />', j.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}); 
	$('#id_personalPhoto').val("");
	$('#image_personalPhoto').attr('src','');
	$('#form').form('load', {
		loginName : '',
		displayName : '',
		id_pass : '',
		qr_pass : '',
		password:'',
		email:'',
		status:0,
		language : 'zh'
	});
	
	
}
	
//上传附件提交
function submitFormFileUploader(type) {
	$('#typeImage').val(type);
	var file = $('#file_' + type).val();
	/* if (type == 'personalPhoto') {
		$('#file_cachet').val(null);
	} else {
		$('#file_signature').val(null);
	} */ 
	if (file == '') {
		$.messager.alert('<s:message code="common.dialog.tip" />', '请选择上传文件', 'warning');
		return;
	}
		$('#formFileUploader').submit();
/* 	var suffix=file.substring(file.indexOf('.')+1,file.length);
	suffix=suffix.toLowerCase();
	if(suffix=="jpg"||suffix=="png"||suffix=="gif"||suffix=="jpeg"||suffix=="xls"||suffix=="xlsx"||suffix=="xlsm"||suffix=="xltm"||suffix=="xlam"||suffix=="xlsb"||suffix=="doc"||suffix=="docx"){
	}else{
		$.messager.alert('<s:message code="common.dialog.tip" />', '上传文件类型不符合', 'warning');
		
		return;
	} */
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'<c:if test="${user.editState =='i' }">添加新用户</c:if><c:if test="${user.editState =='u' }"><s:message code="common.editInfo"/></c:if>',border:false" align="center">
		<form id="form" method="post">
			<input type="hidden" id="userLever" value="${sessionInfo.userLever}">
			<input type="hidden" id="typeImage" />
			<input type="hidden" id="personalPhoto" name="personalPhoto" value="${user.personalPhoto}" />
			<input type="hidden" name="id" id="hid_id" value="${user.id}" />
			<input type="hidden" name="editState" value="${user.editState}" />
			<input type="hidden" name="stateInit" value="${user.stateInit}" />
			<table class="tableForm">
				<tr>
					<th width="120px"><s:message code="common.loginname"/>: </th>
					<td><input class="easyui-validatebox" type="text" value="${user.loginName}" style="width: 250px" name="loginName" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
				<tr>
					<th><s:message code="common.displayname"/>: </th>
					<td><input class="easyui-validatebox" type="text" value="${user.displayName}" style="width: 250px" name="displayName" data-options="required:true, validType:'length[1,30]'"/></td>
				</tr>
				<tr>
					<th><s:message code="common.password"/> :</th>
					<td><input  id="id_pass" name="id_pass" class="easyui-validatebox" type="password" style="width: 250px" onchange="passwordTemp();" onclick="passwordClean();" data-options="validType:'length[6,30]'" />
					<input  id="ch_pass" class="easyui-validatebox" type="hidden" style="width: 250px" name="password"/>
					</td>
				</tr>
				<tr>
					<th><s:message code="common.confirmPassword"/>：</th>
					<td>
					<input id="qr_pass" name="qr_pass" class="easyui-validatebox" type="password" style="width: 250px" onchange="passwordAffirm();" data-options="validType:'length[6,30]'"/>
					</td>
				</tr>
				<tr>
					<th><s:message code="common.email"/> : </th>
					<td><input class="easyui-validatebox" type="text" value="${user.email}" style="width: 250px" name="email" data-options="required:true" /></td>
				</tr>
				<tr>
					<th><s:message code="common.language"/> : </th>
					<td><select id="combobox_language" class="easyui-combobox" name="language" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="en" <c:if test="${user.language == 'en' or user.language == 'en_US'}"> selected="selected" </c:if>><s:message code="common.language.english"/></option>
						<option value="zh" <c:if test="${user.language == 'zh' or user.language == 'zh_CN'}"> selected="selected" </c:if>><s:message code="common.language.chinese"/></option></select></td>
				</tr>
				<c:if test="${sessionInfo.userLever != '9'}">
				<input type="hidden" name="status" value="${user.status}"/>
				</c:if>
				<c:if test="${sessionInfo.userLever == '9'}">
				<tr>
					<th><s:message code="common.status"/> : </th>
					<td><select id="combobox_status" class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0" <c:if test="${user.status == 0}"> selected="selected" </c:if>><s:message code="common.status.enabled" /></option>
						<option value="1" <c:if test="${user.status == 1}"> selected="selected" </c:if>><s:message code="common.status.disabled" /></option>
						<option value="2" <c:if test="${user.status == 2}"> selected="selected" </c:if>><s:message code="common.status.register" /></option></select>
						</td>
				</tr>
				</c:if>
		</form>
		
		<form id="formFileUploader" method="post" enctype="multipart/form-data">
		<th>个人照片 : </th>
			<td>
				<img id="image_personalPhoto" alt="" src="${user.personalPhoto}" width="116" height="116" /> 
			<br>
			<input id="id_personalPhoto" type="file" id="file_personalPhoto" name="listFile[0]" style="background:transparent;border-width:1px;" onchange="submitFormFileUploader('personalPhoto');" />
			</td>		
		</form>
		
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="fileClean();"><s:message code="common.button.reset" /></a>
			</div>
	</div>
</body>
</html>
