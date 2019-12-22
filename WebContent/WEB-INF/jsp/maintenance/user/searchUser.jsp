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
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			url :'${pageContext.request.contextPath}/maintenance/user/doSearch.do',
			border : false,
			pagination : true,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
			sortName : 'loginName',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			striped: true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'Id',
				width : 0,
				sortable : false,
				hidden : true
			}, {
				title : 'LoginName',
				field : 'loginName',
				width : 150,
				sortable : true
			} ,{
				title : 'Display Name',
				field : 'displayName',
				width : 100,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Email',
				field : 'email',
				sortable : false,
				width : 100,
				/* formatter : function(value, row, index) {
					if (value != '' || value != null || value != undefined) {
						return formatString('<a href="mailto:{0}">{1}</a>', value, value.replace('@manchutimesfashion.com', '@...'));
					} else {
						return '';
					}
				} */
			}, {
				title : 'Language',
				field : 'language',
				sortable : false,
				formatter : function(value, row, index) {
					return value == 'zh' ? '<s:message code="common.language.chinese" />' : '<s:message code="common.language.english" />';
				}
			},  {
				title : 'Status',
				field : 'status',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.status.enabled" />';
					} else if (value == 1) {
						return '<s:message code="common.status.disabled" />';
					} else if (value == 2) {
						return '<s:message code="common.status.register" />';
					} else if (value == 3) {
						return '<s:message code="common.status.reject" />';
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
					} 
				}
			}, {
				title : 'Roles',
				field : 'roles',
				sortable : false,
				width : 200,
				formatter : function(value, row, index) {
					if (value != undefined && value != '' && value.length > 0) {
						var txt = '';
						var count = 0;
						for (var i = 0; i < value.length; i ++) {
							
							if(value.length == 1){
								txt = txt + value[i].name + ' ';
							}else{
								if(count == (value.length-1)){
									txt = txt + value[i].name + ' ';
								}else{
									txt = txt + value[i].name + ',';
								}
								
							}
							count++;
						}
						return formatString('<a href="javascript:void(0);" onclick="show_roles_dialog(\'{0}\');">{1}</a>', index, txt);
					} else {
						return '';
					}
				}
			}, {
				title : 'Divisions',
				field : 'user2Divisions',
				sortable : false,
				width : 150,
				formatter : function(value, row, index) {
					if (value != undefined && value != '' && value.length > 0) {
						var txt = '';
						var count = 0;
						for (var i = 0; i < value.length; i ++) {
							if(value.length == 1){
								txt = txt + value[i].division.name + ' ';
							}else{
								if(count == (value.length-1)){
									txt = txt + value[i].division.name + ' ';
								}else{
									txt = txt + value[i].division.name + ',';
								}
							}
							count++;
						}
						return formatString('<a href="javascript:void(0);" onclick="show_divisions_dialog(\'{0}\');">{1}</a>', index, txt);
					} else {
						return '';
					}
				}
			}, {
				title : 'Datetime',
				field : 'datetime',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value,row,index){
					if (value == '' || value == null){
						return '';
					}else{
					return formattime(value);
						
					}

				}
			}, {
				title : 'phone',
				field : 'phoneNo',
				width : 100,
				sortable : true,
				hidden : false
			}, {
				title : 'province',
				field : 'province',
				width : 100,
				sortable : true,
				hidden : false
			}, {
				title : 'gender',
				field : 'gender',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value, row, index){
					if (value == 'm'){
						return '男';
					}else if (value == 'f'){
						return '女';
					}else {
						return 'N/A';
					}
				}
			}, {
				title : 'ethnicGroup',
				field : 'ethnicGroupName',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value, row, index){
					 if (value == null){
						 return 'N/A';
					 }else{
						 return value;
					 }
					}
			}, {
				title : 'schoolName',
				field : 'schoolName1',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value, row, index){
					 if (value == null){
						 return 'N/A';
					 }else{
						 return value;
					 }
					}
			}, {
				title : 'educationalDegree',
				field : 'educationalDegree1Name',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value, row, index){
				 if (value == null){
					 return 'N/A';
				 }else{
					 return value;
				 }
				}
			},{
				title : 'birthDate',
				field : 'birthDate',
				width : 100,
				sortable : true,
				hidden : false
		
			},{
				title : 'entryDate',
				field : 'entryDate',
				width : 100,
				sortable : true,
				hidden : false,
				formatter:function(value,row,index){
					if (value == '' || value == null){
						return '';
					}else{
					return formattime(value);
						
					}

				}
			}] ],
			toolbar : [
				<c:if test="${comUtil.checkCode('1101001')}">
				{
					iconCls : 'icon-user-add',
					text : 'Add User',
					handler : function() {
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toAdd.do" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>');
						top.layout_center_addTab({
							title : formatString('Add User'),
							closable : true,
							iconCls : 'icon-user-add',
							content : content
						});
					}
				},'-',
				{
					iconCls : 'icon-user-edit',
					text : 'Edit User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toEdit.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}]', checkedRows[0].loginName),
							closable : true,
							iconCls : 'icon-user-edit',
							content : content
						});
					}
				},'-',
				{
					iconCls : 'icon-user-edit',
					text : 'Edit User',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/userDetail/toEdit.do?userId={0}&editState=u" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}]', checkedRows[0].loginName),
							closable : true,
							iconCls : 'icon-user-edit',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101002')}">
				{
					iconCls : 'icon-lock-edit',
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
							id : checkedRows[0].id,
							loginName : checkedRows[0].loginName,
							password : '123456'
						});
						$('#dialog_password').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101003')}">
				{
					iconCls : 'icon-user-delete',
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
					iconCls : 'icon-ruby-key',
					text : 'Roles Setting',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toEditRoles.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Roles', checkedRows[0].loginName),
							closable : true,
							iconCls : 'icon-ruby-key',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101005')}">
				{
					iconCls : 'icon-lightning-go',
					text : 'Actions Setting',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user2action/toSearch.do?userId={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Actions', checkedRows[0].loginName),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						}); 
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101006')}">
				{
					iconCls : 'icon-group',
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
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user2division/toEditDivisions.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit User [{0}] Divisions', checkedRows[0].loginName),
							closable : true,
							iconCls : 'icon-user-edit',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101007')}">
				{
					iconCls : 'icon-ok',
					text : 'approve',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
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
						}
						var loginName = checkedRows[0].loginName;
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=approveRegistration.cpt&loginName='+loginName ;
						window.location.href = url;
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1101008')}">
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
				</c:if>
				<c:if test="${comUtil.checkCode('1101011')}">
				{
					iconCls : 'icon-search',
					text : 'Check Version ',
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
							title : 'Check Version ',
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
			url : '${pageContext.request.contextPath}/common/division/doList.do',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			panelWidth : '300',
			editable : false,
			lines : true
		});
		
		$('#combobox_role').combobox({
			url : '${pageContext.request.contextPath}/common/role/doListPair.do',
			valueField : 'first',
			textField : 'second',
			panelWidth : '250',
			editable : false
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
	//格式化日期格式
	function formattime(val) {
		 var time = new Date(val);
		 //alert(time);
		 var year = time.getFullYear();
		var month=(parseInt(time.getMonth())+1);
		 month=month>9?month:('0'+month);
		var day=parseInt(time.getDate());
		day=day>9?day:('0'+day);
		 return year+'/'+month+'/'+day;

		 }
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 135px;overflow: hidden;" align="center">
		<form id="form">
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">Login Name : </th>
					<td><input name="loginName" style="width: 200px;" class="easyui-validatebox" /></td>
					<th style="width: 120px;">Display Name : </th>
					<td><input name="displayName" style="width: 200px;" class="easyui-validatebox" /></td>
				</tr>
				<tr>
					<th>Division : </th>
					<td><input id="combotree_division" class="easyui-combotree" name="divisionId" style="width:200px;" data-options="editable: false" /></td>
					<th>Role : </th>
					<td><input id="combobox_role" class="easyui-combobox" name="roleId" style="width:200px;" data-options="editable: false" /></td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
		<script>
			function submit_form() {
				var opt = $('#datagrid').datagrid('options');
				opt.url = '${pageContext.request.contextPath}/maintenance/user/doSearch.do';
				$('#datagrid').datagrid('options', opt);
				$('#datagrid').datagrid('load', serializeObject($('#form')));
			}
			function reset_form() {
				$('#form').form('clear');
			}
		</script>
	</div>
	<div id="dialog_password" class="easyui-dialog" title="Reset Password" style="width:400px;height:150px;" data-options="iconCls:'icon-lock-edit',resizable:true,modal:true,closed: true, buttons: '#dialog_password_buttons'">
		<form id="form_password" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tr>
					<th width="120px">Login Name : </th>
					<td><input class="easyui-validatebox" type="text" readonly="readonly" style="width: 250px" name="loginName" data-options="required:true, validType:'length[3,30]'" /></td>
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
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
	<div id="dialog_roles" class="easyui-dialog" title="Roles" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_roles"></table>
	</div>
	<div id="dialog_divisions" class="easyui-dialog" title="Divisions" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_divisions"></table>
	</div>
</body>

</html>
