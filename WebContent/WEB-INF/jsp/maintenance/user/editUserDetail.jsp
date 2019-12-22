<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit UserInfo</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	
	
	$("input",$("#emolumentPreTaxPositiveBefore").next("span")).keyup(function(event){
		calPay(event, 'emolumentPreTaxPositiveBefore', 'withholdingPositiveBefore', 'emolumentAfterTaxPositiveBefore');
	});
	$("input",$("#withholdingPositiveBefore").next("span")).keyup(function(event){
		calPay(event, 'emolumentPreTaxPositiveBefore', 'withholdingPositiveBefore', 'emolumentAfterTaxPositiveBefore');
	});
	$("input",$("#emolumentPreTax").next("span")).keyup(function(event){
		calPay(event, 'emolumentPreTax', 'withholding', 'emolumentAfterTax');
	});
	$("input",$("#withholding").next("span")).keyup(function(event){
		calPay(event, 'emolumentPreTax', 'withholding', 'emolumentAfterTax');
	});
	function calPay(event, beforeId, deductId, resId){
		if(event.keyCode == 13){
			event.target.blur();
	   		//事件处理代码     
	    	var before = $('#' + beforeId).numberbox('getValue');
	    
	    	var deduct = $('#' + deductId).numberbox('getValue');
	    	if(before > 0 && deduct > 0){
	    		var res = before - deduct;
	    		$('#' + resId).numberbox('setValue', res);
	    	}
		}  
	}
	$('#combotree_division').combotree({
		url : '${pageContext.request.contextPath}/common/division/doList.do?tag=d',
		valueField : 'id',
		textField : 'name',
		parentField : 'pid',
		panelWidth : '300',
		editable : false,
		lines : true
	});
	$('#combotree_division_entry').combotree({
		url : '${pageContext.request.contextPath}/common/division/doList.do?tag=d',
		valueField : 'id',
		textField : 'name',
		parentField : 'pid',
		panelWidth : '300',
		editable : false,
		lines : true
	});
	
	$('#formMain').form({
		url : '${pageContext.request.contextPath}/maintenance/userDetail/doEdit.do',
		onSubmit: function() {
			var editState = $('#editState').val();
			// 如果不是附件(edit attach)的情况下再验证
			/* if (editState == 'ea') {
				$("#birthDate").datebox({ disabled: true });
			} */
			
			if (editState != 'ea') {
				var isValid = $(this).form('validate');
				return isValid;
			}
		},
		success : function(result) {
			// 除掉日期禁止disable状态
			/* $("#birthDate").datebox({ disabled: false }); */
			var editState = $('#editState').val();
			// 如果是上传附件状态
			if ('ea' == editState) {
				var j = $.parseJSON(result);
				var success = j.success;
				if (success == undefined) {
					$.messager.alert('<s:message code="common.dialog.error" />', '上传文件请不要超过30M', 'error');
				} else if (success == true) {
					var obj = j.obj;
					// 如果是图片类型附件做图片引用处理
					var typeAttach = obj.typeAttach;
					var attachFiled = obj.attachFiled;
					var attachmentId = obj.attachmentId;
					var userId = obj.userId;
					$('#userId').val(userId);
					$('#field_' + attachFiled).val(attachmentId);
					var message = '附件上传成功'
					// 如果是图片类型
					if ("i" == typeAttach) {
						var savePathFile = obj.savePathFile;
						var savePathFileTrue = '${pageContext.request.contextPath}' + savePathFile;
						var typeImage = $('#typeImage').val();
						$('#image_' + typeImage).attr('src', savePathFileTrue);
						$('#'+ typeImage).attr('value', savePathFileTrue);
						message = '图片上传成功';
					}
					// 如果是文件类型
					else if ("f" == typeAttach) {
						var attachFileName = obj.attachFileName;
						$('#fileName_' + attachFiled).textbox('setValue', attachFileName);
						//$('#fileName_attachEducationalDegree1').val();
						
					}
					// 设置附件上传完毕之后的默认状态是更新状态
					$('#editState').val('u');
				}
			}
			
			if ("u" == editState) {
				message = '用户信息录入完成';
				// 根据用户状态跳转到对应页面
				var statusInit = $('#statusInit').val();
				if ("a" != statusInit) {
					// 注册完成跳转到登录页面
					if ("7" == statusInit) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '注册成功', 'info', function(rr) {
							$.getJSON('${pageContext.request.contextPath}/user/doLogout.do?rnd=' + (new Date().getTime()), function(result) {
								window.location = '${pageContext.request.contextPath}';
							});
						});
					} else {
						window.location = '${pageContext.request.contextPath}/maintenance/userDetail/toEdit.do?editState=u&statusInit=' + statusInit + '&userId=' + $('#userId').val();
					}
					
				}
			}
			
			$.messager.show({
				title:'<s:message code="common.dialog.tip" />',
				msg:message,
				timeout:2500,
				showType:'fade'
			});
		}
	});

	// 加载添加附件验证
	/* index_education
	index_emergency
	index_skill
	index_career */
	var stringArray = new Array('education', 'emergency', 'skill', 'career');
	for ( var int = 0; int < stringArray.length; int++) {
		var typeAttach = stringArray[int];
		var indexMax = $('#index_' + typeAttach).val();
		for ( var i = 2; i <= indexMax; i++) {
			var index = i;
			if ('education' != typeAttach) {
				$('.date_' + (typeAttach + index)).datebox({required: true});
				$('.text_' + (typeAttach + index)).textbox({required: true, validType:'length[2, 20]'});
				$('.combo_' + (typeAttach + index)).textbox({required: true});
			} else {
				$('.text_' + (typeAttach + index)).textbox({validType:'length[2, 20]'});
			}
		}
	}
});

// 清空选择上传文件
function fileClean() {

	$.post("${pageContext.request.contextPath}/upload/attachment/doDeleteFile.do",
		{
			userId : userId
		},
		function(result) {
			try {
				var j = $.parseJSON(result);
				if (j.success) {
					//$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {});
				} else {
					//$.messager.alert('<s:message code="common.dialog.error" />', j.msg, 'error');
				}
			} catch (e) {
				$.messager
						.alert(
								'<s:message code="common.dialog.error" />',
								result, 'error');
			}
		});
	$('#id_personalPhoto').val("");
	$('#image_personalPhoto').attr('src', '');
	$('#formMain').form('load', {
		loginName : '',
		displayName : '',
		id_pass : '',
		qr_pass : '',
		password : '',
		email : '',
		status : 0,
		language : 'zh'
	});

}


// 图片上传
function uploadImage(type, attachIndex) {
	// edit attach 变更状态为上传附件
	$('#editState').val('ea');
	$('#typeImage').val(type);
	$('#attachIndex').val(attachIndex);
	// 赋值需要上传附件的字段
	$('#attachFiled').val(type);
	// 上传类型为image
	$('#typeAttach').val('i');
	var file = $('#file_' + type).val();
	if (file == '') {
		$.messager.alert('<s:message code="common.dialog.tip" />',
				'请选择上传文件', 'warning');
		return;
	}
	$('#formMain').submit();
	/* var suffix=file.substring(file.indexOf('.')+1,file.length);
	 suffix=suffix.toLowerCase();
	 if(suffix=="jpg"||suffix=="png"||suffix=="gif"||suffix=="jpeg"||suffix=="xls"||suffix=="xlsx"||suffix=="xlsm"||suffix=="xltm"||suffix=="xlam"||suffix=="xlsb"||suffix=="doc"||suffix=="docx"){
	 }else{
	 $.messager.alert('<s:message code="common.dialog.tip" />', '上传文件类型不符合', 'warning');
	
	 return;
	 } */
}

// 文件上传
function uploadFile(attachFiled, attachIndex) {
	// edit attach 变更状态为上传附件
	$('#editState').val('ea');
	$('#attachIndex').val(attachIndex);
	$('#typeImage').val(attachFiled);
	// 赋值需要上传附件的字段
	$('#attachFiled').val(attachFiled);
	// 上传类型为file
	$('#typeAttach').val('f');
	var file = $('#file_' + attachFiled).val();
	if (file == '') {
		$.messager.alert('<s:message code="common.dialog.tip" />',
				'请选择上传文件', 'warning');
		return;
	}
	$('#formMain').submit();
}

// 表单1提交
function submitForm(stepSubmit) {
	// 设置编辑状态
	$('#editState').val('u');
	
	// 取得当前步骤
	var statusInit = $('#statusInit').val();
	if ('n' == stepSubmit || 'e' == stepSubmit) {
		statusInit = Number(statusInit) + 1;
	}
	if ('p' == stepSubmit) {
		statusInit = Number(statusInit) - 1;
	}
	$('#statusInit').val(statusInit);
	$('#formMain').submit();
	// 更新上个标签页
	//var p =  parent.$('#tabs').tabs('select', '用户管理'); 
    //var tab = top.$('#layout_center_tabs').tabs('getSelected');
	//var tabIndex =  top.$('#layout_center_tabs').tabs('getTabIndex', tab);
	//top.$('#layout_center_tabs').tabs('close', tabIndex);
	//取得选中tab的标题名称
	//var menuName=parent.$('#layout_center_tabs').tabs('getSelected').panel('options').title;
	var previousTab = parent.$('#layout_center_tabs').tabs('getTab','用户管理');
	refreshTab(previousTab) 
						 
						
	
}

// 添加附件
function addAttach(typeAttach) {
	// var attach = $('#attach_' + typeAttach).html();
	var index = $('#index_' + typeAttach).val();
	var indexNext = Number(index) + 1;
	// attach = attach.replace(/\_officeX/g, indexNext);
	// $('#attach_' + (typeAttach + index)).after(attach);
	$('#attach_' + (typeAttach + indexNext)).show();
	// 赋值index
	$('#index_' + typeAttach).val(indexNext);
	if (3 == indexNext) {
		$('#tr_add_' + typeAttach).hide();
	}
	// 添加验证
//	$('.' + (typeAttach + indexNext)).datebox({required: true});
	//$("input[class='easyui-datebox education2']").datebox({required: true});
	//$('.easyui-datebox ' + (typeAttach + indexNext)).datebox({required: true});
	// $('.easyui-textbox, ' + (typeAttach + indexNext)).textbox({required: true});
		$('.text_' + (typeAttach + indexNext)).textbox({validType:'length[2, 20]'});
	if ('education' != typeAttach) {
		$('.date_' + (typeAttach + indexNext)).datebox({required: true});
		$('.text_' + (typeAttach + indexNext)).textbox({required: true, validType:'length[2, 20]'});
		$('.combo_' + (typeAttach + indexNext)).textbox({required: true});
	}
}

// 删除附件
function delAttach(typeAttach, indexCurrent) {
	
	var index = $('#index_' + typeAttach).val();
	var indexNext = Number(index) - 1;
	//$('#attach_' + (typeAttach + indexCurrent)).hide();
	// 赋值index
	$('#index_' + typeAttach).val(indexNext);
	$('#tr_add_' + typeAttach).show();
	if ('education' != typeAttach) {
		// 取消验证
		$('.date_' + (typeAttach + indexCurrent)).datebox({required: false});
		$('.text_' + (typeAttach + indexCurrent)).textbox({required: false});
		$('.combo_' + (typeAttach + indexCurrent)).textbox({required: false});
	}
	// 隐藏
	$('#attach_' + (typeAttach + indexCurrent)).hide();
}

</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',border:false" align="center">
<form id="formMain" method="post" enctype="multipart/form-data">
<!-- **********  隐藏变量   ********** -->
		<input type="hidden" id="userLever" value="${sessionInfo.userLever}">
			<input type="hidden" id="submitType" />
			<input type="hidden" name="attachFiled" id="attachFiled" />
			<input type="hidden" name="attachIndex" id="attachIndex" />
			<input type="hidden" id="userId" name="userId" value="${userDetail.userId}"/>
			<input type="hidden" id="userDetailId" name="id" value="${userDetail.id}"/>
			<input type="hidden" id="typeImage" />
			<!-- 附件类型 image file -->
			<input type="hidden" id="typeAttach" name="typeAttach" />
			<input type="hidden" id="personalPhoto" name="personalPhoto" value="${user.personalPhoto}" />
			<input type="hidden" id="editState" name="editState" value="${userDetail.editState}"/>
			<input type="hidden" id="statusInit" name="statusInit" value="${userDetail.statusInit}"/>
	<table>
		<tr>
			<th style="width:120px; font-size: x-large;margin-top: 120px;"></th>
			<td></td>
			<td></td>
			<th style="width:120px; font-size: x-large;"></th>
			<td></td>
			<td></td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<th style="width:120px; font-size: x-large;margin-top: 120px;">员工信息</th>
			<td></td>
			<td></td>
			<th style="width:120px; font-size: x-large;"></th>
			<td></td>
			<td></td>
			<td>&nbsp;</td>
		</tr>
		<c:if test="${userDetail.statusInit == '0'}">
			<jsp:include page="_positionInformation.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '1'}">
			<jsp:include page="_personalInformation.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '2'}">
			<jsp:include page="_educationInformation.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '3'}">
			<jsp:include page="_workExperience.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '4'}">
			<jsp:include page="_otherSkill.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '5'}">
			<jsp:include page="_emergency.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == '6'}">
			<jsp:include page="_personalInformation.jsp"></jsp:include>
			<jsp:include page="_educationInformation.jsp"></jsp:include>
			<jsp:include page="_workExperience.jsp"></jsp:include>
			<jsp:include page="_otherSkill.jsp"></jsp:include>
			<jsp:include page="_emergency.jsp"></jsp:include>
		</c:if>
		<c:if test="${userDetail.statusInit == 'a'}">
			<jsp:include page="_entryInformation.jsp"></jsp:include>
			<jsp:include page="_positionInformation.jsp"></jsp:include>
			<jsp:include page="_personalInformation.jsp"></jsp:include>
			<jsp:include page="_educationInformation.jsp"></jsp:include>
			<jsp:include page="_workExperience.jsp"></jsp:include>
			<jsp:include page="_otherSkill.jsp"></jsp:include>
			<jsp:include page="_emergency.jsp"></jsp:include>
		</c:if>
	
		<tr>
			<td colspan="2">
				<table id="dtg_scan"></table>
			</td>
		</tr>
	</table>
</form>
		<div style="text-align: center; padding: 5px">
			<c:if test="${userDetail.statusInit != 'a'}">
				<c:if test="${userDetail.statusInit != '1'}">
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'ext-icon-resultset_previous'" onclick="submitForm('p');"><s:message code="common.button.submit.previous" /></a>
				</c:if>
				<c:if test="${userDetail.statusInit != '6'}">
					<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'ext-icon-resultset_next'" onclick="submitForm('n');"><s:message code="common.button.submit.next" /></a>
				</c:if>
			</c:if>
			<c:if test="${userDetail.statusInit == 'a'}">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm('s');"><s:message code="common.button.submit" /></a>
			</c:if>
			<c:if test="${userDetail.statusInit == '6' }">
				<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm('e');"><s:message code="common.button.submit" /></a>
			</c:if>
			<%-- <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="fileClean();"><s:message code="common.button.reset" /></a> --%>
		</div>
	</div>
</body>
</html>