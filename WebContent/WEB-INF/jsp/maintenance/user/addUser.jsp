<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<!-- saved from url=(0058)file:///F:/remove/html%E6%A8%A1%E6%9D%BF/login4/index.html -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新用户注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimum-scale=1.0, maximum-scale=1.0">
<link href="${pageContext.request.contextPath}/css/maintenance/user/style.css" rel="stylesheet" type="text/css">
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/jquery.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/jquery.i18n.properties-1.0.9.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/jquery.validate.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/md5.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/user/page_regist.js"></script> --%>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
var userId = '${user.id}';
$(function() {
	//$('#qr_pass_div').hide();
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
					// 如果为新用户注册情况下, 跳转页面
					if ('r' == stateInit) {
						var userId = obj.id;
						// 作登录处理
						var loginName = obj.loginName;
						var password = obj.password;
						$.post( "${pageContext.request.contextPath}/user/doLogin.do",
							// 取得新注册用户session
							{status:"2", uid:loginName, pwd:password, cookieRemember:"unchecked",statusRegist : 'n'},
							function(result){
								try {
									var r = $.parseJSON(result);
									if (r.success) {
										window.location = '${pageContext.request.contextPath}/maintenance/userDetail/toEdit.do?editState=u&statusInit=1&userId=' + userId;
									} else {
										$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
										
									}
								} catch (e) {
									$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
								}
							}
						)
						
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


function hideMessige(modelId) {
	$('#lab_' + modelId).hide();
/* 	$('#lab_' + modelId).hide();
	for ( var i = 1; i <=4; i++) {
		var input_value = $('#inp_' + i);
		if (null != input_value && '' != input_value && input_value.length > 0) {
			$('#lab_' + i).hide();
		} else {
			$('#lab_' + i).show();
		}
	} */
	
}
	
//上传附件提交

</script>

</head>
<body class="loginbody">
<div class="dataEye">
	<div class="loginbox registbox">
		<div class="logo-a">
		</div>
		<div class="login-content reg-content">
			<div class="loginbox-title">
				<h3>新用户注册</h3>
			</div>
			<form id="form" method="post">
				<table class="">
					<input type="hidden" id="typeImage" />
					<input type="hidden" id="personalPhoto" name="personalPhoto" value="${user.personalPhoto}" />
					<input type="hidden" name="id" id="userId" value="${user.id}" />
					<input type="hidden" name="editState" value="${user.editState}" />
					<input type="hidden" name="stateInit" value="${user.stateInit}" />
					<input type="hidden" name="language" value="zh"/>
					<div class="login-error" style="display: none;"></div>
					<tr>
						<th width="85px" align="right"><s:message code="common.loginname"/>: </th>
						<td><input class="easyui-validatebox" type="text" value="${user.loginName}" style="width: 250px" name="loginName" data-options="required:true, validType:'length[3,30]'" /></td>
					</tr>
					<tr>
						<td></td>
						<td><span class="txt-tips loginbox-title" style="color:#8E8E8E; font-size:12px;">使用英文字符(例如:英文名加中文姓,TomWang)</span></td>
					</tr>
					<%-- <tr>
						<th width="85px" align="right">姓名: </th>
						<td><input class="easyui-validatebox" type="text" value="${user.displayName}" style="width: 250px" name="displayName" data-options="required:true, validType:'length[2,30]'" /></td>
					</tr> --%>
					<tr>
						<th width="85px" align="right">中文姓: </th>
						<td><input class="easyui-validatebox" type="text" value="${user.lastName}" style="width: 250px" name="lastName" data-options="required:true, validType:'length[1,20]'" /></td>
					</tr>
					<tr>
						<td></td>
						<td><span class="txt-tips loginbox-title" style="color:#8E8E8E; font-size:12px;">使用中文字符(例如:姓名王强,请填写"王")</span></td>
					</tr>
					<tr>
						<th width="85px" align="right">中文名: </th>
						<td><input class="easyui-validatebox" type="text" value="${user.firstName}" style="width: 250px" name="firstName" data-options="required:true, validType:'length[1,20]'" /></td>
					</tr>
					<tr>
						<td></td>
						<td><span class="txt-tips loginbox-title" style="color:#8E8E8E; font-size:12px;">使用中文字符(例如:姓名王强,请填写"强")</span></td>
					</tr>
					<tr>
						<th align="right"><s:message code="common.password"/>: </th>
						<td><input  id="id_pass" name="id_pass" class="easyui-validatebox" type="password" style="width: 250px" onchange="passwordTemp();" onclick="passwordClean();" data-options="required:true, validType:'length[6,30]'" />
						<input  id="ch_pass" class="easyui-validatebox" type="hidden" style="width: 250px" name="password"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td></td>
					</tr>
					<tr>
						<th align="right"><s:message code="common.confirmPassword"/>: </th>
						<td>
						<input id="qr_pass" name="qr_pass" class="easyui-validatebox" type="password" style="width: 250px" onchange="passwordAffirm();" data-options="required:true, validType:'length[6,30]'"/>
						</td>
					</tr>
					<tr>
						<td>&nbsp;</td>
						<td></td>
					</tr>
					<tr>
						<th align="right"><s:message code="common.email"/>: </th>
						<td><input class="easyui-validatebox" type="text" value="${user.email}" style="width: 250px" name="email" data-options="required:true, validType:'email'" /></td>
					</tr>
				</table>
			</form>
			<table class="tableForm">
				<tr>
					<div class="row btnArea">
						<a class="login-btn" id="submit" onclick="$('#form').submit();">下一步</a>
					</div>
				</tr>
			
			</table>
		</div>
	</div>
</div>



</body></html>