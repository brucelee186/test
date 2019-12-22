<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
		$('#combotree_division').combotree({
			url : '${pageContext.request.contextPath}/common/division/doList.do?tag=d',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			panelWidth : '300',
			editable : false,
			lines : true
		});
		
		$('#datagrid').datagrid({
			fit : true,
			border : false,
			url : '${pageContext.request.contextPath}/maintenance/role/doSearch.do',
			pagination : false,
			idField : 'id',
			sortName : 'name',
			sortOrder : 'DESC',
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
			}, {
				title : 'Role',
				field : 'name',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : 'Level',
				field : 'level',
				align : 'right',
				sortable : true
			}, 
			{
				title : 'System',
				field : 'system',
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 1) {
						return '<s:message code="common.choose.yes" />'
					} else {
						return '<s:message code="common.choose.no" />';
					}
				}
			}, 
			{
				title : 'Type',
				field : 'type',
				width : 50,
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 's') {
						return '系统'
					} 
					else if (value == 'd') {
						return '部门';
					}
					else if (value == 'u') {
						return '用户';
					}
				}
			}, 
			{
				title : 'Type Reference',
				field : 'typeSys',
				align : 'center',
				width : 100,
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 'r') {
						return '引用'
					} 
					else if (value == 'n') {
						return '非引用';
					}
					else {
						return '其它';
					}
				}
			}, 
			{
				title : 'Type Extends',
				field : 'typeExtends',
				width : 80,
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 'e') {
						return '继承'
					} 
					else if (value == 'u') {
						return '非继承';
					}
					else {
						return '其它';
					}
				}
			}, 
			{
				title : 'Description',
				field : 'description',
				sortable : true,
				width : 300
			}, {
				title : 'Datetime',
				field : 'datetime',
				sortable : true,
				hidden : true
			}, {
				title : 'Status',
				field : 'status',
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.status.enabled" />';
					} else if (value == 1) {
						return '<s:message code="common.status.disabled" />';
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
			toolbar : [
				<c:if test="${comUtil.checkCode('1103001')}">
				{
					iconCls : 'icon-add',
					text : '<s:message code="common.button.add" />',
					handler : function() {
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/role/doAdd.do');
						$('#form').form('load', {
							editState : 'i',
							id : '',
							name : '',
							type : 'u',
							typeId : '',
							level : 1,
							typeExtends : 'u',
							typeSys : 'n',
							system : 0,
							description : '',
							status : 0
						});
						$('#tr_division').hide();
						$('#dialog').dialog('setTitle', 'Add');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1103002')}">
				{
					iconCls : 'icon-edit',
					text : '<s:message code="common.button.edit" />',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/role/doEdit.do');
						$('#form').form('load', {
							editState : 'u',
							id : checkedRows[0].id,
							name : checkedRows[0].name,
							level : checkedRows[0].level,
							type : checkedRows[0].type,
							typeExtends : checkedRows[0].typeExtends,
							typeSys : checkedRows[0].typeSys,
							typeId : checkedRows[0].typeId,
							system : checkedRows[0].system,
							description : checkedRows[0].description,
							status : checkedRows[0].status
						});
						var type = checkedRows[0].type;
						if('s' != type){
							$('#tr_division').show();
						} else {
							$('#tr_division').hide();
						}
						$('#dialog').dialog('setTitle', 'Edit');
						$('#dialog').dialog('open');
					}
				},
				'-',
						{
					iconCls : 'ext-icon-page_copy',
					text : '复制',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/role/doEdit.do?editState=c&id=' + checkedRows[0].id);
						$.post('${pageContext.request.contextPath}/maintenance/rolePermission/doEdit.do',
							{
							editState : 'c',
							roleId : checkedRows[0].id,
							name : checkedRows[0].name,
							level : checkedRows[0].level,
							type : checkedRows[0].type,
							typeExtends : checkedRows[0].typeExtends,
							typeSys : checkedRows[0].typeSys,
							typeId : checkedRows[0].typeId,
							system : checkedRows[0].system,
							description : checkedRows[0].description,
							status : checkedRows[0].status
							},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : '<s:message code="common.dialog.tip" />',
													msg : '复制成功',
													timeout : 2000,
													showType : 'slide'
												});
									});
					}
				},'-',
				</c:if>
				/* <c:if test="${comUtil.checkCode('1103003')}">
				{
					iconCls : 'icon-lightning-go',
					text : '<s:message code="maintenance.role.actionSetting" />',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/role/toEditActions.do?id={0}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Role [{0}] Actions', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},'-',
				</c:if> */
				<c:if test="${comUtil.checkCode('1103004')}">
				{
					iconCls : 'ext-icon-link',
					text : '编辑权限',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/rolePermission/toEdit.do?roleId={0}&typeExtends=' + checkedRows[0].typeExtends + '&typeSys=' + checkedRows[0].typeSys + '&type=' + checkedRows[0].type + '&typeId=' + checkedRows[0].typeId + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Role [{0}] Actions', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},
				</c:if>
				<c:if test="${comUtil.checkCode('1103004')}">
				'-',
				{
					iconCls : 'ext-icon-link',
					text : '用户权限',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/rolePermission/toEdit.do?roleId={0}&typeS=u" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Role [{0}] Actions', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1103004')}">
				{
					iconCls : 'ext-icon-link',
					text : '系统权限',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/rolePermission/toEdit.do?roleId={0}&typeSys=s&type='  + checkedRows[0].type + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Role [{0}] Actions', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1103004')}">
				{
					iconCls : 'ext-icon-link',
					text : '部门权限',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/rolePermission/toEdit.do?roleId={0}&typeSys=d" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].id);
						top.layout_center_addTab({
							title : formatString('Edit Role [{0}] Actions', checkedRows[0].name),
							closable : true,
							iconCls : 'icon-lightning-go',
							content : content
						});
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1103005')}">
				{
					iconCls : 'icon-cancel',
					text : '<s:message code="common.button.delete" />',
					handler : function() {
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
							if (r) {
								$.post("${pageContext.request.contextPath}/maintenance/role/doDelete.do", { id : checkedRows[0].id }, function(result) {
									try {
										var j = $.parseJSON(result);
										if (j.success) {
											$.messager.show({
												title:'<s:message code="common.dialog.tip" />',
												msg: '删除成功',
												timeout:5000,
												showType:'slide'
											});
											$('#datagrid').datagrid("reload");
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
				}
				</c:if>
			]
		});
	});

function submitForm(){
	var editState = $("#editState").val();
	var url = '';
	var msg = '';
	if ("i" == editState) {
		url = '${pageContext.request.contextPath}/maintenance/role/doAdd.do';
		msg = '添加成功'
	}
	if ("u" == editState) {
		url = '${pageContext.request.contextPath}/maintenance/role/doEdit.do';
		msg = '修改成功'
	}
	$.post(url, 
			{
				id : $('#id').val(),
				name : $('#name').textbox('getValue'),
				level : $('#level').combobox('getValue'),
				type : $('#type').combobox('getValue'),
				typeExtends : $('#typeExtends').combobox('getValue'),
				typeSys : $('#typeSys').combobox('getValue'),
				typeId : $('#typeId').combobox('getValue'),
				//system : $('#system').val(),
				description : $('#description').textbox('getValue'),
				status : $('#status').combobox('getValue'),
			}, 
		function(result){
			$('#dialog').dialog('close');
			$('#datagrid').datagrid('reload');
			$.messager.show({
				title:'<s:message code="common.dialog.tip" />',
				msg:msg,
				timeout:5000,
				showType:'slide'
			});
		});
}


</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div id="dialog" class="easyui-dialog" style="width:400px;height:350px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
		<form id="form" method="post">
			<input id="id" type="hidden" name="id" />
			<input id="editState" type="hidden" name="editState" />
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Name : </th>
					<td><input id="name" class="easyui-textbox" name="name" type="text" style="width: 250px" data-options="required:true" /></td>
				</tr>
				<tr>
					<th>Level : </th>
					<td><select id="level" name="level" class="easyui-combobox" style="width:250px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=jsdj'"></select></td>
					<%-- <td><select id="level" class="easyui-combobox" name="level" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="1">0</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
						<option value="5">5</option>
						<option value="6">6</option>
						<option value="7">7</option>
						<option value="8">8</option>
						<option value="9">9</option></select></td> --%>
				</tr>
				<tr>
					<th>Type Extends : </th>
					<td><select id="typeExtends" name="typeExtends" class="easyui-combobox" style="width:250px;" 
					data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=jczt'"></select>
					</td>
				</tr>
				<tr>
					<th>Type Reference : </th>
					<td><select id="typeSys" name="typeSys" class="easyui-combobox" style="width:250px;" 
					data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=yylx'"></select>
					</td>
				</tr>
				<tr>
					<th>Type : </th>
					<td><select id="type" name="type" class="easyui-combobox" style="width:250px;" 
					data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=jslx',
					onSelect(rec){
						var typeExtends = $('#typeExtends').textbox('getValue');
						var type = $(this).combobox('getValue');
						if('e' == typeExtends && 'u' == type){
							$('#tr_division').show();
						} 
						if('s' == type) {
							$('#tr_division').hide();
						}
					}
					"></select>
					</td>
				</tr>
				<tr id="tr_division" >
					<th>Division : </th>
					<td><input id="typeId" name="typeId" class="easyui-combotree" style="width:250px" data-options="required: false, valueField:'id', textField:'name', parentField : 'pid', panelHeight:'auto', editable:false, 
					url:'${pageContext.request.contextPath}/common/division/doList.do?tag=d'"></input></td>
				</tr>
				<tr>
					<th>Description : </th>
					<td><textarea id="description" name="description" class="easyui-textbox" style="width: 250px;height:60px;"></textarea></td>
				</tr>
				<tr>
					<th>Status : </th>
					<td><select id="status" name="status" class="easyui-combobox" style="width:250px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=xtztz'"></select></td>
					<%-- <td><select id="status" class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false ">
						<option value="0"><s:message code="common.status.enabled" /></option>
						<option value="1"><s:message code="common.status.disabled" /></option></select></td> --%>
				</tr>
			</table>
		</form>
	</div>
	<div id="dialog_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm();"><s:message code="common.button.submit" /></a>
	</div>
	<div data-options="region:'center',title:'Role List',border:false" align="center">
		<table id="datagrid"></table>
	</div>
</body>
</html>