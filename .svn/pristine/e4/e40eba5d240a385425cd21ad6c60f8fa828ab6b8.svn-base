<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<jsp:useBean id="comUtil" class="com.mtf.framework.util.CommonUtil" scope="page" />
<!DOCTYPE HTML >
<html>
<head>
<title>Search Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/office/office/doSearch.do?flag=p',
			fit:true,
			pagination : true,
			collapsible:true,
			title:'',
			idField : 'id',
			pageSize : 10,
			pageList : [10, 50, 100, 200 ],
			sortName : 'showAddDate',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}
			, {
				title : '<s:message code="office.item.receiver" />',
				field : 'userName',
				width : 250,
				sortable : true
			}
			] ],
			columns : [ [ {
				title : '<s:message code="office.item.department" />',
				field : 'department',
				sortable : true,
				width : 150
			}
			, {
				title : '<s:message code="office.item.AddDate" />',
				field : 'showAddDate',
				sortable : true,
				width : 150
			}
			, {
				title : '<s:message code="office.item.Approve1Date" />',
				field : 'showApprove1Date',
				sortable : true,
				width : 150
			}
			, {
				title : '<s:message code="office.item.Approve2Date" />',
				field : 'showApprove2Date',
				sortable : true,
				width : 150
			}
			, 
			{
				title : '<s:message code="office.rowName.status" />',
				field : 'approveState',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 'save'){
						return '<s:message code="office.itemLable.saved" />';
					} else if (value == 'submit') {
						return '<s:message code="office.itemLable.submitted" />';
					} else if (value == 'approve2') {
						return '<s:message code="office.itemLable.confirmed" />';
					} else if (value == 'approve1') {
						return '<s:message code="office.itemLable.depManagerApproved" />';
					} else if (value == 'disable') {
						return '<s:message code="office.itemLable.disable" />';
					} else if (value == 'reject') {
						return '<s:message code="office.itemLable.depManagerRejected" />';
					}
				},
				styler: function(value, row, index){
					if (value == 0){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			} ] ],
			toolbar :'#datagrid_toolbar'
		});
	});
	
	
	// 添加申请表
	function addOffice(){
		$.post('${pageContext.request.contextPath}/office/office/doGetOffice.do',null,function(result){
			var j = $.parseJSON(result);
			if (j.success) {
				var url = '${pageContext.request.contextPath}/office/office/toAdd.do?editState=i';
				window.location.href = url;
			}else {
				$.messager.alert('<s:message code="common.dialog.tip" />', j.msg, 'warning');
				return;
				}
		});
	}
	
	// 编辑申请表
	function editOffice(){
		$.post('${pageContext.request.contextPath}/office/office/doGetOffice.do',null,function(result){
			var j = $.parseJSON(result);
			if (j.success) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.wrongEdit" />', 'warning');
				return;
			}else {
				var off = j.obj;
				var url = "${pageContext.request.contextPath}/office/item/toEdit.do?editState=u&officeId=" + off.id;
				window.location.href = url;
				}
		});
	}
	
</script>
</head>
<body>
	<div id="datagrid" ></div>
	<div id="depDatagrid"></div>
	<input id="hid_depId" type="hidden"/>
	<div id="datagrid_toolbar">
	<table cellspacing="0" cellpadding="0">
		<tr>
		<c:if test="${comUtil.checkCode('1201001')}">
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:addOffice()"><span class="l-btn-left"><span class="l-btn-text icon-add l-btn-icon-left"><s:message code="office.itemLable.AddApplication" /></span></span></a></td>
			<td><div class="datagrid-btn-separator"></div></td>
		</c:if>
		<c:if test="${comUtil.checkCode('1201002')}">
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:editOffice()"><span class="l-btn-left"><span class="l-btn-text icon-edit l-btn-icon-left"><s:message code="office.itemLable.edit" /></span></span></a></td>
			<td><div class="datagrid-btn-separator"></div></td>
		</c:if>
	</table>
	</div>
</body>
</html>
