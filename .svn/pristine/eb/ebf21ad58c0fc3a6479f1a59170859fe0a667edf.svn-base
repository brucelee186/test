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
				var savePathFileTrue = '${pageContext.request.contextPath}' + savePathFile;
				$('#image').attr('src', savePathFileTrue);
				$('#signature').attr('value', savePathFileTrue);
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
						loginname : '',
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