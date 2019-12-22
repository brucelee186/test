<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search User</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">

//地点格式化信息
var listUserInfor = '${jsonListUserInfor}';
var jsonListUserInfor = jQuery.parseJSON(listUserInfor)[0];
function formatterListUserInfor(value, rowData, rowIndex) {
	return formatterDate(value, rowData, rowIndex, jsonListUserInfor, 'code', 'name');
}

function formatterListUserInforEng(value, rowData, rowIndex) {
	return formatterDate(value, rowData, rowIndex, jsonListUserInfor, 'code', 'nameEng');
}

//JSON formatter
function formatterDate(value, rowData, rowIndex, jsonArray,typeId,typeName) {
	if (value == null) {
		return'';
	}
	for ( var i = 0; i < jsonArray.length; i++) {
		if (eval('jsonArray[i].' + typeId) == value) {
			return eval('jsonArray[i].' + typeName);
		}
	}
}
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			url :'${pageContext.request.contextPath}/maintenance/userDetail/doSearch.do',
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
			sortName : 'a.modifiedDate',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			striped: true,
			frozenColumns : [ [ 
			{
				title : 'Staff Code',
				field : 'staffCode',
				width : 70,
				align : 'right',
				sortable : true,
				hidden : false
			},
			{
				title : 'LoginName',
				field : 'loginName',
				width : 90,
				sortable : true
			} ,
			{
				title : 'Display Name',
				field : 'displayName',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Email',
				field : 'email',
				sortable : true,
				width : 100,
				formatter : function(value, row, index) {
					if (value != null && value != undefined && value != '' && value.length > 0) {
						return formatString('<a href="mailto:{0}">{1}</a>', value, value.replace('@manchutimesfashion.com', '@...'));
					} else {
						return '';
					}
				}
			},
			{
				title : 'Card No',
				field : 'cardNo',
				width : 80,
				sortable : true,
				align : 'right',
				hidden : false
			}, 
			{
				title : 'Language',
				field : 'language',
				sortable : false,
				width : 70,
				align : 'center',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				}
			},
			{
				title : 'Gender',
				field : 'gender',
				width : 50,
				align :'center',
				sortable : true,
				hidden : false,
				formatter:function(value, row, index){
					if (value == 'm'){
						return '男';
					}else if (value == 'f'){
						return '女';
					}else {
						return '';
					}
				}
			}, 
			{
				title : 'Status',
				field : 'status',
				sortable : true,
				align : 'center',
				width : 60,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.status.onjob" />';
					} else if (value == 1) {
						return '<s:message code="common.status.dimission" />';
					} else if (value == 2) {
						return '<s:message code="common.status.register" />';
					} else if (value == 3) {
						return '<s:message code="common.status.rejectEntry" />';
					} else if (value == 4) {
						return '<s:message code="common.status.ontrial" />';
					}  
				},
				styler: function(value, row, index){
					if (value == 0){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					} else if (value == '2') {
						return 'background-color:#ffff99;color:#ff9900;';
					} else if (value == '3') {
						return 'background-color:#FFC7CE;color:#9C0006;';
					} else if (value == '4') {
						return 'background-color:#C6EFCE;color:#006100;';
					} 
				}
			},
			{
				title : 'Positive Date',
				field : 'positiveDate',
				align : 'center',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				} 
			},			
			{
				title : 'Roles',
				field : 'roleName',
				sortable : true,
				width : 200,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				}
			},
			{
				title : 'Primary Department',
				field : 'primaryDepartment',
				width : 150,
				sortable : true,
				formatter : function(value, row, index) {
						if( null == value || '' == value){
							value = '';
						}
						return value;
				} 
			},
			{
				title : 'Secondary Department',
				field : 'divisionName',
				width : 180,
				sortable : true,
				formatter : function(value, row, index) {
						if( null == value || '' == value){
							value = '';
						}
						return value;
				} 
			},
			{
				title : 'Work Group',
				field : 'workGroupDetailName',
				width : 150,
				sortable : true,
				formatter : function(value, row, index) {
						if( null == value || '' == value){
							value = '';
						}
						return value;
				} 
			},
			{
				title : 'Position',
				field : 'positionId',
				width : 150,
				sortable : true,
				align : 'left',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				}
			},
			{
				title : 'Immediate Superior',
				field : 'immediateSuperiorName',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Rank',
				field : 'rank',
				width : 100,
				sortable : true,
				align : 'left',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				},
			},
			{
				title : 'On-Board Date',
				field : 'entryDate',
				align : 'center',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				} 
			},
			{
				title : 'Seniority',
				field : 'seniority',
				width : 70,
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Birth Date',
				field : 'birthDate',
				width : 80,
				sortable : true,
				align : 'center',
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				} 
			},
			{
				title : 'Age',
				field : 'age',
				width : 30,
				align : 'center',
				sortable : true,
			},
			{
				title : 'Ethic',
				field : 'ethnicGroup',
				width : 60,
				sortable : true,
				align : 'center',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				},
			},
			{
				title : 'Education',
				field : 'educationalDegree1',
				width : 100,
				sortable : true,
				align : 'left',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				}
			},
			{
				title : 'School',
				field : 'schoolName1',
				width : 150,
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Major',
				field : 'major1',
				width : 100,
				sortable : true,
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				},
			},
			{
				title : 'English Efficiency',
				field : 'englishProficiency',
				width : 150,
				sortable : true,
				align : 'left',
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				},
			},
			{
				title : 'Residential Registration',
				field : 'resgisteredResidence',
				width : 180,
				sortable : true,
				hidden : false,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Office Tel',
				field : 'officialTelNo',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Mobile#',
				field : 'phoneNo',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Employer',
				field : 'employer',
				width : 60,
				sortable : true,
				formatter : formatterListUserInfor,
				editor : {
					type : 'combobox',
					options : {
						data : jsonListUserInfor,
						valueField : "code",
						textField : "name",
						required : false,
						editable : false,
					}
				},
			},
			{
				title : 'Contract No.',
				field : 'contractNo',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Commence Date',
				field : 'contractCommenceDate',
				width : 100,
				align : 'left',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				} 
				
			},
			{
				title : 'Termination Date',
				field : 'contracTerminationDate',
				width : 110,
				align : 'left',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				} 
			},
			{
				title : 'Turns',
				field : 'turns',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'Social Security',
				field : 'socialSecurityPermission',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if('y' == value){
						value = '*';
					}
					else {
						value = '';
					}
					return value;
				} 
			},
			{
				title : 'House Funding',
				field : 'houseFundingPermission',
				width : 100,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if('y' == value){
						value = '*';
					}
					else {
						value = '';
					}
					return value;
				} 
			},
			] ],
			toolbar : [
				<c:if test="${comUtil.checkCode('1101001')}">
				/* {
					iconCls : 'ext-icon-user_add',
					text : 'Add User',
					handler : function() {
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toAdd.do" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>');
						top.layout_center_addTab({
							title : formatString('Add User'),
							closable : true,
							iconCls : 'ext-icon-user_add',
							content : content
						});
					}
				},'-', */
				{
					iconCls : 'ext-icon-user_edit',
					text : 'Edit User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toEdit.do?id={0}&stateInit=" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}]', checkedRows[0].loginName),
							closable : true,
							iconCls : 'ext-icon-user_edit',
							content : content
						});
					}
				},'-',
				{
					iconCls : 'ext-icon-user_edit',
					text : 'Edit UserInfo',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/userDetail/toEdit.do?userId={0}&editState=u" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit UserInfo [{0}]', checkedRows[0].displayName),
							closable : true,
							iconCls : 'ext-icon-user_edit',
							content : content
						});
					}
				},'-',
				{
					iconCls : 'ext-icon-tick',
					text : 'Print UserInfo',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						}
						var userId = checkedRows[0].userId;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showUserInfor.cpt&serverIp=${pageContext.request.contextPath}&userId='+userId ;
						window.location.href = url;
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101002')}">
				{
					iconCls : 'ext-icon-lock_edit',
					text : 'Reset Password',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						$('#form_password').form('load', {
							id : checkedRows[0].userId,
							loginName : checkedRows[0].loginName,
							password : '123456'
						});
						$('#dialog_password').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101003')}">
				{
					iconCls : 'ext-icon-user_delete',
					text : 'Delete User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101004')}">
				{
					text : 'Roles Setting',
					iconCls : 'ext-icon-ruby_key',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toEditRoles.do?id=' + checkedRows[0].userId + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Roles', checkedRows[0].loginName),
							closable : true,
							iconCls : 'ext-icon-ruby_key',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101005')}">
				{
					iconCls : 'ext-icon-lightning_go',
					text : 'Actions Setting',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user2action/toSearch.do?userId={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Actions', checkedRows[0].loginName),
							closable : true,
							iconCls : 'ext-icon-lightning_go',
							content : content
						}); 
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101006')}">
				{
					iconCls : 'ext-icon-group',
					text : 'Divisions Setting',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var a = checkedRows[0].userId;
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user2division/toEditDivisions.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Divisions', checkedRows[0].loginName),
							closable : true,
							iconCls : 'ext-icon_group',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101007')}">
				{
					iconCls : 'ext-icon-tick',
					text : 'approve',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						/* if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var status = checkedRows[0].status;
						//console.info(status);
						if('0'==status || '3'==status){
							$.messager.alert('<s:message code="common.dialog.tip" />', '已经完成审批!', 'warning');
							return;
						}
						if('1'==status ){
							$.messager.alert('<s:message code="common.dialog.tip" />', '已经禁用!', 'warning');
							return;
						} */
						var loginName = checkedRows[0].loginName;
						var entryDate = checkedRows[0].entryDate;
						var positiveDate = checkedRows[0].positiveDate;
						var departedDate = checkedRows[0].departedDate;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=approveRegistration.cpt&serverIp=${pageContext.request.contextPath}&loginName='+loginName + '&entryDate=' + entryDate + '&positiveDate=' + positiveDate + '&departedDate=' + departedDate;
						window.location.href = url;
					}
				},'-',
				</c:if>
				/* <c:if test="${comUtil.checkCode('1101008')}">
				{
					iconCls : 'icon-edit',
					text : 'Edit User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var modifyUser = '${sessionInfo.loginName}';
						var loginName = checkedRows[0].loginName;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=editRegistration.cpt&op=write&loginName='+loginName+'&modifyUser='+modifyUser ;
						window.location.href = url;
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101009')}">
				{
					iconCls : 'icon-search',
					text : 'Check User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var loginName = checkedRows[0].loginName;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=checkRegistration.cpt&loginName='+loginName;
						window.location.href = url;
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101010')}">
				{
					iconCls : 'icon-search',
					text : 'Check Application ',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var loginName = checkedRows[0].loginName;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=checkAddRegistration.cpt&loginName='+loginName;
						window.location.href = url;
					}
				},'-',
				</c:if> */
				<c:if test="${comUtil.checkCode('1101011')}">
				{
					iconCls : 'icon-search',
					text : 'History',
					handler : function() {
						 var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						/* var userId = checkedRows[0].userId;
						var url = '${pageContext.request.contextPath}/maintenance/history/toSearch.do?userIds='+userId;
						window.location.href = url;  */
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/history/toSearch.do?userIds={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : 'History',
							closable : true,
							iconCls : 'icon-search',
							content : content
						});
					}
				}
				</c:if>
				/* ,'-',{
				iconCls : 'icon-remove',
				text : 'Remove Picture',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					} else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					}
					$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除图片?', function(r) {
						if (r) {
							$.post("${pageContext.request.contextPath}/upload/attachment/doDeleteFile.do", { userId : checkedRows[0].userId }, function(result) {
								try {
									var j = $.parseJSON(result);
									if (j.success) {
										$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
										});
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
			} */
			]
		});
		
		$('#combotree_division').combotree({
			url : '${pageContext.request.contextPath}/common/division/doList.do?tag=d',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			panelWidth : '300',
			editable : false,
			lines : true,
			onChange : function (){}
		});
		
		$('#combobox_role').combobox({
			url : '${pageContext.request.contextPath}/common/role/doListPair.do',
			valueField : 'first',
			textField : 'second',
			panelWidth : '250',
			editable : false,
			panelHeight : '500',
		});
		
		$('#datagrid_roles').datagrid({
			fit : true,
			fitColumns : true,
			border : false,
			pagination : false,
			idField : 'id',
			rownumbers : true,
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			showHeader : false,
			nowrap : true,
			columns : [ [ {
				title : 'Role',
				field : 'name',
				width : 100,
				sortable : true
			} ] ],
			onHeaderContextMenu: function(e, field) {
				e.preventDefault();
			}
		});
		
		$('#datagrid_divisions').datagrid({
			fit : true,
			fitColumns : true,
			border : false,
			pagination : false,
			idField : 'id',
			rownumbers : true,
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			showHeader : false,
			nowrap : true,
			columns : [ [ {
				title : 'Divison',
				field : 'name',
				width : 100,
				sortable : true
			},{
				title : 'Leader',
				field : 'leader',
				width : 50,
				sortable : true,
				styler : function(value,row,index){
					if (value == 'Leader'){
						return 'color:red;';
					}
				}
			} ] ],
			onHeaderContextMenu: function(e, field) {
				e.preventDefault();
			}
		});
		
		$('#form_password').form({
			url : '${pageContext.request.contextPath}/maintenance/user/doPassword.do',
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
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							$('#dialog_password').dialog('close');
							$('#datagrid').datagrid('reload');
						});
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		
		// 默认加载列表
		//submit_form();
	});

	function show_roles_dialog(index) {
		var rows = $('#datagrid').datagrid('getRows');
		var row = rows[index];
		if (row == undefined || row.roles == undefined || row.roles.length == 0) {
			return;
		}
		$('#datagrid_roles').datagrid('loadData', row.roles);
		
		$('#dialog_roles').dialog('open');
	}
	
	function show_divisions_dialog(index) {
		var rows = $('#datagrid').datagrid('getRows');
		var row = rows[index];
		if (row == undefined || row.user2Divisions == undefined || row.user2Divisions.length == 0) {
			return;
		}
		
		var showDivisionRows = [];
		for(var index in row.user2Divisions){
			showDivisionRows.push({'name':row.user2Divisions[index].division.name,'leader':row.user2Divisions[index].index==1?'Leader':'Employee'})
		}
		
		$('#datagrid_divisions').datagrid('loadData', showDivisionRows);
		
		$('#dialog_divisions').dialog('open');
	}

	
	function submit_form() {
		var opt = $('#datagrid').datagrid('options');
		opt.url = '${pageContext.request.contextPath}/maintenance/userDetail/doSearch.do';
		$('#datagrid').datagrid('options', opt);
		$('#datagrid').datagrid('load', serializeObject($('#form')));
	}
	
	function reset_form() {
		$('#form').form('clear');
	}
	
	// 回车事件
	function submitForm(event){
		  if(event.keyCode==13){
			event.target.blur();
			submit_form();
         }
	}	
</script>
</head>
<body id="idBody" class="easyui-layout" data-options="fit : true,border : false" onkeydown="submitForm(event);">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 195px;overflow: hidden;" align="center">
		<form id="form">
			<table class="tableForm" >
				<tr>
					<th style="width: 130px;">Login Name : </th>
					<td><input id="searchLoginName" name="searchLoginName" style="width: 200px;" class="easyui-textbox" /></td>
					<!-- data-options="
						keyup:function(event) {
							submit_form();
						}" -->
						
					<th style="width: 130px;">Display Name : </th>
					<td><input name="searchDisplayName" style="width: 200px;" class="easyui-textbox" /></td>
					<th>Staff Code : </th>
					<td><input name="staffCode" style="width: 200px;" class="easyui-textbox" /></td>
					<th>Superior : </th>
					<td><input name="searchImmediateSuperior" style="width: 200px;" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<th style="width: 130px;">Status : </th>
					<td><select id="searchStatus" name="searchStatus" class="easyui-combobox" style="width:200px;" data-options="required:false, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=xtzu'"></select></td>
					<th>Division : </th>
					<td><input id="combotree_division" class="easyui-combobox" name="searchDivision" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true," /></td>
					<input id="searchDivision" name="searchDivision" type="hidden"/>
					<th>Role : </th>
					<td><input id="combobox_role" class="easyui-combobox" name="searchRole" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true," /></td>
					<th>English Efficien : </th>
					<td><select id="type" name="searchEnglishEfficien" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=e'"></select></td>
				</tr>
				<tr>
					<th style="width: 130px;">Major : </th>
					<td><select id="type" name="searchMajor" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=z'"></select></td>
					<th style="width: 130px;">Education : </th>
					<td><select id="type" name="searchEducation" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=xl'"></select></td>
					<th style="width: 130px;">Rank : </th>
					<td><select id="searchRank" name="searchRank" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=gwdj'"></select></td>
					<th>Position : </th>
					<td><select id="type" name="searchPosition" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'500', editable:false, multiple:true, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=zwmc'"></select></td>
				</tr>
				<tr>
					<th style="width: 130px;">Termination Date : </th>
					<td><input name="terminationDateEnd" style="width: 200px;" class="easyui-datebox" /></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a id="submitFormA" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();" ><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
	
	<div id="dialog_password" class="easyui-dialog" title="Reset Password" style="width:400px;height:150px;" data-options="iconCls:'icon-lock-edit',resizable:true,modal:true,closed: true, buttons: '#dialog_password_buttons'">
		<form id="form_password" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th width="120px">Login Name : </th>
					<td><input class="easyui-validatebox" type="text" readonly="readonly" style="width: 250px" name="loginName" data-options="required:true, validType:'length[3,30]'" onkeypress="alert(1)" /></td>
				</tr>
				<tr>
					<th>Password : </th>
					<td><input class="easyui-validatebox" type="text" value="123456" style="width: 250px" name="password" data-options="required:true, validType:'length[3,30]'" /></td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dialog_password_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_password').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<div id="dialog_roles" class="easyui-dialog" title="Roles" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_roles"></table>
	</div>
	<div id="dialog_divisions" class="easyui-dialog" title="Divisions" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_divisions"></table>
	</div>
</body>

</html>
