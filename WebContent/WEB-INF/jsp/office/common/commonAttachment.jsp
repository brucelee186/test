<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script  type="text/javascript" charset="utf-8">
$(function(){
	// 上传附件
	$('#formFileUploader').form({
		url : '${pageContext.request.contextPath}/contract/attachment/fileUploader.do',
		success : function(result) {
			var j = $.parseJSON(result);
			var success = j.success;
			if (success == undefined) {
				$.messager.alert('<s:message code="common.dialog.error" />', '上传文件请不要超过30M', 'error');
			}else if (success == true) {
				$.messager.show({
					title:'<s:message code="common.dialog.tip" />',
					msg:'上传附件成功',
					timeout:2500,
					showType:'fade'
				});
				var contractId = j.obj.contractId;
				initDetailList(contractId);
			}
		}
	});
	var contractId  = $('#mainId').val();
	if (contractId == undefined || contractId == '') {
		// contractId = -1 代表订单为插入状态
		contractId = -1;
	}
	
	// 加载明细列表
	initDetailList(contractId);

})

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

//初始化附件列表
function initDetailList(contractId) {
	var url = '';
	if (contractId != -1) {
		url = '${pageContext.request.contextPath}/contract/attachment/doSearch.do?contractId=' + contractId;
	}
	$('#detailList').datagrid({
		title:'附件列表',
		nowrap: true,
		striped: true,
		collapsible:true,
		sortOrder: 'desc',
		remoteSort: false,
		singleSelect: true, 
		url: url,
		rownumbers:true,
		idField:'id',
		columns:[[
					{field:'fileName', width:300, title:'文件名称',sortable:true},
					{field:'suffix', width:100, title:'类型',sortable:true, formatter:function(value, row, index){
						if (value == '.pdf') {
							return 'PDF';
						} else if (value == 'jpg' || value == 'png' || value == 'jpeg' || value == 'gif') {
							return 'IMAGE';
						} else if (value == 'xls' || value == 'xlsx' || value == 'xlsm' || value == 'xltx' || value == 'xltm' || value == 'xlsb' || value == 'xlam') {
							return 'EXCEL';
						} else if (value == 'doc' || value == 'docx') {
							return 'WORD';
						} else {
							return value;
						}
					}},
			]],
			toolbar : 
				[
					{
						iconCls : 'icon-remove',
						text : '删除',
						handler : function() {
							var checkedRows = $('#detailList').datagrid('getSelections');
							if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
								$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', '警告');
								return;
							}
							$.messager.confirm('提示','确定删除?',function(r){
								if (r){
									$.post("${pageContext.request.contextPath}/contract/attachment/doEdit.do",{id:checkedRows[0].id, editState:"d", savePathFile:checkedRows[0].savePathFile},function(result){
										try {
											var j = $.parseJSON(result);
											if (j.success) {
												$.messager.show({
													title:'<s:message code="common.dialog.tip" />',
													msg:'删除成功',
													timeout:2500,
													showType:'fade'
												});
												$('#detailList').datagrid('clearSelections');
												$('#detailList').datagrid("reload");
											} else {
												$.messager.alert('<s:message code="common.dialog.error" />', j.msg, 'error');
											}
										} catch (e) {
											$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
										}
									});
								}
							});
						}
					},
					{
						iconCls : 'icon-remove',
						text : '下载',
						handler : function() {
							var checkedRows = $('#detailList').datagrid('getSelections');
							if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
								$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', '警告');
								return;
							}
							var url = '${pageContext.request.contextPath}' + checkedRows[0].savePathFile;
							window.location.href = url;
						}
					}
				],
	});
}
</script>


	<div id="detailList"></div>
	<form id="formFileUploader" method="post" enctype="multipart/form-data">
	<input type="hidden" name="contractId" value="${contract.id}">
	<input type="hidden" name="editState" value="i">
			<table style="width: 500px;">
				<tr>
					<td>上传附件: <input type="file" id="file" name="listFile[0]" style="background:transparent;border-width:1px;" />
						<br>
					</td>
				</tr>
				<tr>
					<td ><input type="button" onclick="submitFormFileUploader();" value="确 定" style="background:transparent;border-width:1px" />	
						&nbsp;<input type="button" type="reset" onclick="$('#file').val('');" value="重 置" style="background:transparent;border-width:1px" />
					</td>
				</tr>
			</table>
	</form>





