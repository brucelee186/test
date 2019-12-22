<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>

<title>Insert title here</title>
<script type="text/javascript">
$(function() {
	$('#form').form({
		url : '${pageContext.request.contextPath}/information/doAdd.do',
		/* onSubmit: function() {
			var isValid = $(this).form('validate');
			if (isValid) {
				$.messager.progress();
			} else {
				$.messager.progress('close');	// hide progress bar while the form is invalid
			}
			return isValid;	// return false will stop the form submission
		}, */
		success : function(result) {
			$.messager.progress('close');	// hide progress bar while submit successfully
			try {
				var r = $.parseJSON(result);
				if (r.success) {
					$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
						//top.layout_center_closeTab();
						$('#mainList').datagrid('reload');
					});
				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});
	
	
		$('#mainList').datagrid({
			title:'',
			fit : true,
			border : false,
			url : '${pageContext.request.contextPath}/information/doSearch.do',
			pagination : true,
			collapsible:true,
			fitColumns : true,
			idField : 'id',
			pageSize : 100,
			pageList : [ 10, 20, 50, 100, 200 ],
			sortName : 'modifiedDate',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			frozenColumns : [[{
				title : 'id',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}] ],
			columns : [ [ 
			{
				title : '<s:message code="滚动标语" />',
				field : 'remarks',
				width : 300,
				sortable : true
			}, {
				title : '<s:message code="链接标语" />',
				field : 'linkRemarks',
				width : 100,
				sortable : true
			}, {
				title : '<s:message code="链接路径" />',
				field : 'url',
				width : 150,
				sortable : true
			}, {
				title : '<s:message code="office.rowName.addDate" />',
				field : 'addDate',
				width : 100,
				sortable : true
			}, {
				title : '<s:message code="office.rowName.modifiedDate" />',
				field : 'modifiedDate',
				width : 100,
				sortable : true
			}, {
				title : '<s:message code="office.rowName.status" />',
				field : 'status',
				width : 50,
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0) {
						return '<s:message code="office.rowlable.enable" />';
					} else if (value == 1) {
						return '<s:message code="office.rowlable.disable" />';
					} 
				},
				styler : function(value, row, index) {
					if (value == 0) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					} 
				}
			}
			]],
			toolbar :'#datagrid_toolbar',
			onHeaderContextMenu: function(e, field) {
				e.preventDefault();
			}
		
});
	
});

//选定滚屏语
function selectScroll(){
		var checkedRows = $('#mainList').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		}
		/*if ( checkedRows[0].status =="1") {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.disabledToEdit" />', 'warning');
			return;
		} */
		
		$.post('${pageContext.request.contextPath}/information/doUpdate.do',{id : checkedRows[0].id},function(r){
			var j = $.parseJSON(r);
			if (j.success) {
				$('#mainList').datagrid('reload');
			}
		});
}
//信息添加
function addScroll(){
		var url = "${pageContext.request.contextPath}/information/toEdit.do" ;
		window.location.href = url;
}

//信息添加
function removeScroll(){
	var checkedRows = $('#mainList').datagrid('getSelections');
	if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
		return;
	}
	$.post('${pageContext.request.contextPath}/information/doDelete.do',{id : checkedRows[0].id},function(r){
		var j = $.parseJSON(r);
		if (j.success) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="common.dialog.Delete" />', 'info');
			$('#mainList').datagrid('reload');
		}
	});
}

//信息编辑
function editScroll(){
		var checkedRows = $('#mainList').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		}
		/* if ( checkedRows[0].status =="1") {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.disabledToEdit" />', 'warning');
			return;
		} */
		var url = "${pageContext.request.contextPath}/information/toEdit.do?id=" + checkedRows[0].id  ;
		window.location.href = url;
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<%-- <div data-options="region:'north',border:false,split:true,title:'系统提示信息管理'" style="height: 80px; overflow: hidden;">
		<form id="form" method="post" >
			<table class="tableForm">
				<tr>
						<th width="200px">输入系统提示信息 : </th>
						<!-- <input  type="hidden" value="1" style="width: 300px" name="id"  /> -->
						<td><input  type="text" value="" style="width: 300px" name="remarks"  /></td>
						<th width="200px">输入链接提示信息 : </th>
						<td><input  type="text" value="" style="width: 300px" name="linkRemarks"  /></td>
						<td><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a></td>
				</tr>
			</table>
		</form>
	</div> --%>
	<div data-options="region:'center',title:'<s:message code="系统提示信息管理" />',border:false" align="center">
	<div id="mainList"  ></div>
		<div id="datagrid_toolbar">
			<table cellspacing="0" cellpadding="0">
				<tbody>
					<tr>
						<c:if test="${comUtil.checkCode('1107001')}">
							<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:addScroll()">
							<span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left"><s:message code="添加" /></span></span></a></td>
							<td><div class="datagrid-btn-separator"></div></td>
						</c:if>
						<c:if test="${comUtil.checkCode('1107002')}">
							<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:removeScroll()">
							<span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left"><s:message code="删除" /></span></span></a></td>
							<td><div class="datagrid-btn-separator"></div></td>
						</c:if>
						<c:if test="${comUtil.checkCode('1107003')}">
							<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:editScroll()">
							<span class="l-btn-left"><span class="l-btn-text icon-edit l-btn-icon-left"><s:message code="编辑" /></span></span></a></td>
							<td><div class="datagrid-btn-separator"></div></td>
						</c:if>
						<c:if test="${comUtil.checkCode('1107004')}">
							<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:selectScroll()">
							<span class="l-btn-left"><span class="l-btn-text icon-edit l-btn-icon-left"><s:message code="选定" /></span></span></a></td>
							<td><div class="datagrid-btn-separator"></div></td>
						</c:if>
					</tr>
				</tbody>
			</div>
			</table>
		</div>
	</div>
	
</body>
</html>