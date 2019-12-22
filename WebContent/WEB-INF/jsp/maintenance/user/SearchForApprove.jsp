<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search Item rule</title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	$('#mainList').datagrid({
		title:'',
		fit:true,
		border:false,
		url : '${pageContext.request.contextPath}/maintenance/user/doSearchForApprove.do',
		pagination : true,
		collapsible:true,
		fitColumns : true,
		idField : 'id',
		pageSize : 100,
		pageList : [ 10, 20, 50, 100, 200 ],
		sortName : 'loginName',
		sortOrder : 'asc',
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
			title : '<s:message code="loginName" />',
			field : 'loginName',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="displayName" />',
			field : 'displayName',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="Email" />',
			field : 'email',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="Gender" />',
			field : 'gender',
			width : 100,
			sortable : true
		}, {
			title : '<s:message code="EntryDate" />',
			field : 'entryDate',
			width : 100,
			sortable : true,
			formatter : function(value,row,index){
				var date = new Date(value);
				return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
				
			}
		}, {
			title : '<s:message code="InitialDate" />',
			field : 'initialDate',
			width : 100,
			sortable : true,
			formatter : function(value,row,index){
				var date = new Date(value);
				return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate();
				
			}
		},{
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
			title : '<s:message code="ApproveStatus" />',
			field : 'approveStatus',
			width : 100,
			sortable : true,
			formatter : function(value, row, index) {
				if (value == 'a') {
					return '<s:message code="office.rowlable.enable" />';
				} else if (value == 'r') {
					return '<s:message code="office.rowlable.disable" />';
				} 
			},
			styler : function(value, row, index) {
				if (value == 'a') {
					return 'background-color:#C6EFCE;color:#006100;';
				} else if (value == 'r') {
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

//审批
function approve(){
		var row = $('#mainList').datagrid('getSelected');
		if(null == row){
			return;
		}
		var loginName=row.loginName;
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=approveRegistration.cpt&loginName='+loginName ;
		window.location.href = url;
}

</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',border:false">
		<div id="mainList" ></div>
		<div id="datagrid_toolbar">
			<table cellspacing="0" cellpadding="0">
			<tbody>
			<tr>
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approve()">
			<span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left"><s:message code="审批" /></span></span></a></td>
			</tr>
			</tbody>
			</div>
			</table>
		</div>
</body>
</html>