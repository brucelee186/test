<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Division</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	var pesonnelComboboxInit = false;
	
	$(function() {
		//Division Tree init
		$('#treegrid').treegrid({
			fit : true,
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do?tag=${division.tag}',
			idField : 'id',
			treeField : 'name',
			parentField : 'pid',
			border : false,
			frozenColumns : [ [ 
				{
					title : 'ID',
					field : 'id',
					width : 0,
					hidden : true
				}, 
				{
					title : 'Chinese Name',
					field : 'name',
					width : 250
				},
				{
					title : 'English Name',
					field : 'nameEng',
					width : 250
				},
				{
					title : 'Division Title',
					field : 'depTitle',
					width : 250
				} ,
				{
					title : 'Level',
					field : 'level',
					align : 'right',
					width : 50
				},
			] ],
			columns : [ [ {
				title : 'Description',
				field : 'description',
				width : 330
			},
			{
				title : 'Tag',
				field : 'tag',
				formatter : function(value, row, index) {
					if (value == 0){
						return '';
					} else if (value == 'd') {
						return '部门';
					} else if (value == 'g') {
						return '组';
					} else if (value == 'c') {
						return '客户';
					} else {
						return '' + value;
					}
				},
			},
			{
				title : 'Status',
				field : 'status',
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
			}] ],
			toolbar : [
				<c:if test="${comUtil.checkCode('1102001')}">
				{
					iconCls : 'icon-add',
					text : '<s:message code="common.button.add" />',
					handler : function() {
						var checkedRows = $('#treegrid').datagrid('getSelections');
						
						var depTitle = '';
						var level = '';
						var pid = '';
						if (null != checkedRows && checkedRows.length == 1) {
							depTitle = checkedRows[0].depTitle;
							level = checkedRows[0].level;
							pid = checkedRows[0].id;
						}
						$('#form_division').attr('action', '${pageContext.request.contextPath}/maintenance/division/doAdd.do');
						$('#form_division').form('load', {
							id : '',
							name : '',
							nameEng : '',
							depTitle : depTitle,
							level : level + 1,
							pid : pid,
							description : '',
							tag : '${division.tag}',
							status : 0
						});
						$('#combotree_pid').combotree("setValue",pid);
						$('#dialog_division').dialog('setTitle', 'Add');
						$('#dialog_division').dialog('open');
						$('#txt_name').focus();
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1102002')}">
				{
					iconCls : 'icon-edit',
					text : '<s:message code="common.button.edit" />',
					handler : function() {
						var checkedRows = $('#treegrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						$('#form_division').attr('action', '${pageContext.request.contextPath}/maintenance/division/doEdit.do');
						$('#form_division').form('load', {
							id : checkedRows[0].id,
							name : checkedRows[0].name,
							nameEng : checkedRows[0].nameEng,
							depTitle : checkedRows[0].depTitle,
							level : checkedRows[0].level,
							description : checkedRows[0].description,
							tag : checkedRows[0].tag,
							status : checkedRows[0].status
						});
	
						$('#combotree_pid').combotree("setValue",checkedRows[0].pid);
						$('#dialog_division').dialog('setTitle', 'Edit');
						$('#dialog_division').dialog('open');
					}
				}, '-',
				 </c:if>
				<c:if test="${comUtil.checkCode('1102003')}">
				{
					iconCls : 'icon-cancel',
					text : '<s:message code="common.button.delete" />',
					handler : function() {
						var checkedRows = $('#treegrid').treegrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						} else if (checkedRows[0].children){
							$.messager.alert('<s:message code="common.dialog.tip" />', '删除子部门后才能删除', 'warning');
							return;
						}
						$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
							if (r) {
								$.post("${pageContext.request.contextPath}/maintenance/division/doDelete.do", { divisionId : checkedRows[0].id }, function(result){
									try {
										var j = $.parseJSON(result);
										if (j.success) {
											$.messager.show({
												title : '<s:message code="common.dialog.tip" />',
												msg : '操作成功',
												timeout : 2000,
												showType : 'slide'
											});
											$('#treegrid').treegrid("reload");
											$('#combotree_pid').combotree('reload');
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
				} ,"-", 
				</c:if>
				{
					text : '<s:message code="common.button.collapseAll" />',
					iconCls : 'ext-icon-collapse_all',
					handler : function() {
						$('#treegrid').treegrid('collapseAll');
					}
				},"-", 
				{
					text : '<s:message code="common.button.expandAll" />',
					iconCls : 'ext-icon-expand_all',
					handler : function() {
						$('#treegrid').treegrid('expandAll');
					}
				},'-',
				{
					text : '角色设置',
					iconCls : 'ext-icon-ruby_key',
					handler : function() {
						var checkedRows = $('#treegrid').treegrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
							return;
						} else if (checkedRows.length > 1) {
							$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
							return;
						}
						var content = formatString('<iframe src="${pageContext.request.contextPath}/maintenance/user/toEditRoles.do?divisionId=' + checkedRows[0].id + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', checkedRows[0].userId);
						top.layout_center_addTab({
							title : formatString('Edit Division [{0}] Roles', checkedRows[0].name),
							closable : true,
							iconCls : 'ext-icon-ruby_key',
							content : content
						});
					}
				},
			],
			onClickRow : function(rowData) {
				var opt1 = $("body").layout('panel', 'east').panel('options');
				if (opt1.collapsed) {
					return;
				}
				var opt = $('#datagrid_personnel').datagrid('options');
				opt.url = '${pageContext.request.contextPath}/maintenance/user2division/doSearch.do?divisionId=' + rowData.id + '&level=' + rowData.level;
				$('#datagrid_personnel').datagrid('options', opt);
				$('#datagrid_personnel').datagrid('loadData', []);
				$('#datagrid_personnel').datagrid('load');
			}
		});
		
		
		//Personnel datagrid init
		$('#datagrid_personnel').datagrid({
			fit : true,
			border : false,
			pagination : false,
			idField : 'id',
			singleSelect : false,
			checkOnSelect : true,
			selectOnCheck : true,
			nowrap : true,
			rownumbers : true,
			frozenColumns : [ [ 
                   {
       				title : 'ID',
       				field : 'userId',
       				width : 0,
       				sortable : false,
       				hidden : false,
       				checkbox : true
       			},
				{
					title : 'Name',
					field : 'user',
					width : 200,
					formatter : function(value, row, index) {
						return value.displayName;
					}
				},
				
			   ] ],
			columns : [ [ {
				title : 'Main',
				field : 'mainIndex',
				align : 'center',
				formatter : function(value, row, index) {
					if (value == 0){
						return '<s:message code="common.choose.no" />';
					} else if (value == 1) {
						return '<s:message code="common.choose.yes" />';
					}
				}
			} ] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : '<s:message code="common.button.add" />',
				handler : function() {
					var checkedRows = $('#treegrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '请选择部门', 'warning');
						return;
					} else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					}
					//When open the add window for the first time,pesonnel combobox initialization
					if(!pesonnelComboboxInit){
						$('#userId').combobox({
							url : '${pageContext.request.contextPath}/maintenance/user/doListPairEnable.do',
							valueField : 'first',
							textField : 'second',
							editable : true,
							multiple : true, 
						});
						pesonnelComboboxInit = true;
					}
					
					$('#form_personel').attr('action', '${pageContext.request.contextPath}/maintenance/user2division/doAdd.do');
					$('#form_personel').form('load', {
						id : '',
						userId : '',
						stringArrayUser : '',
						mainIndex : '0',
						positionId : 'gwmc1',
						divisionId : checkedRows[0].id,
						nameEng : '',
						depTitle : '',
						level : checkedRows[0].level,
						divisionName : checkedRows[0].name,
						index : checkedRows[0].children?1:0
					});
					$('#dialog_personel').dialog('setTitle', 'Add');
					$('#dialog_personel').dialog('open');
				}
			},'-',{
				iconCls : 'icon-remove',
				text : '<s:message code="common.button.remove" />',
				handler : function() {
					var checkedRows = $('#datagrid_personnel').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					} 
					/* else if (checkedRows.length > 1) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
						return;
					} */
					//$.messager.alert('<s:message code="common.dialog.tip" />', '暂不支持删除功能!', 'warning');
					//return;
					
					$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认删除?', function(r) {
						if (r) {
							var arrayUser = [];
							for ( var i = 0; i < checkedRows.length; i++) {
								arrayUser.push(checkedRows[i].id);
							}
							$.post("${pageContext.request.contextPath}/maintenance/user2division/doDelete.do", {stringArrayUser : arrayUser.join(",")}, function(result){
								try {
									var j = $.parseJSON(result);
									if (j.success) {
										$.messager.show({
											title : '<s:message code="common.dialog.tip" />',
											msg : '操作成功',
											timeout : 2000,
											showType : 'slide'
										});
											$('#datagrid_personnel').datagrid("reload");
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
			}]
		});		

		//personnel form submit
		$('#form_personel').form({
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
						$.messager.show({
							title : '<s:message code="common.dialog.tip" />',
							msg : '操作成功',
							timeout : 2000,
							showType : 'slide'
						});
							$('#dialog_personel').dialog('close');
							$('#datagrid_personnel').datagrid('reload');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});

		//division form submit
		$('#form_division').form({
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
						$.messager.show({
							title : '<s:message code="common.dialog.tip" />',
							msg : '操作成功',
							timeout : 2000,
							showType : 'slide'
						});
						$('#dialog_division').dialog('close');
						$('#treegrid').treegrid('reload');
						$('#combotree_pid').combotree('reload');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
		
		$('#combotree_pid').combotree({
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do',
			valueField : 'id',
			textField : 'name',
			parentField : 'pid',
			lines : true
		});
	});

</script>
</head>
<body class="easyui-layout" data-options="fit:true,border:false">
	<div data-options="region:'center',title:'<c:if test="${division.tag == 'd'}">Division</c:if><c:if test="${division.tag == 'c'}">Customer</c:if> Tree',border:false" align="center">
		<table id="treegrid"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'Personnel'" style="width: 400px; overflow: hidden;">
		<table id="datagrid_personnel"></table>
	</div>
	
	
	<!-- Division add/edit dialog -->
	<div id="dialog_division" class="easyui-dialog" style="width:450px;height:380px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_division_buttons'">
		<form id="form_division" method="post">
			<input type="hidden" name="id" />
			<table class="tableForm">
				<tbody>
					<tr>
						<th style="width: 150px;">Chinese Name : </th>
						<td><input id="txt_name" class="easyui-textbox" type="text" style="width: 250px" name="name" data-options="required:true,validType:'length[1,30]'" /></td>
						<td></td>
					</tr>
					<tr>
						<th style="width: 150px;">English Name : </th>
						<td><input id="txt_nameEng" class="easyui-textbox" type="text" style="width: 250px" name="nameEng" data-options="required:true,validType:'length[1,30]'" /></td>
						<td></td>
					</tr>
					<tr>
						<th style="width: 150px;">Division Title : </th>
						<td><input id="txt_depTitle" class="easyui-textbox" type="text" style="width: 250px" name="depTitle" data-options="required:false,validType:'length[1,30]'" /></td>
						<td></td>
					</tr>
					<tr>
						<th style="width: 150px;">Level : </th>
						<td><input id="txt_level" class="easyui-numberbox" type="text" style="width: 250px" name="level" data-options="required:true,validType:'length[1,2]'" /></td>
						<td></td>
					</tr>
					<tr>
						<th>Description : </th>
						<td><textarea name="description" class="easyui-textbox" style="width: 250px;height:60px;" data-options="required:false,validType:'length[1,30]'" ></textarea></td>
						<td></td>
					</tr>
					<tr>
						<th>Parent Division : </th>
						<td><input id="combotree_pid" class="easyui-combotree" name="pid" style="width:250px;" /></td>
						<td><img src="${pageContext.request.contextPath}/images/icons/cancel.png" onclick="$('#combotree_pid').combotree('clear');" /></td>
					</tr>
					<tr>
						<th>Tag : </th>
						<td><select class="easyui-combobox" name="tag" style="width:250px" data-options="panelHeight:'auto',editable:false ">
							<option value="d" selected="selected">Division</option>
							<option value="c">Customer</option>
							<!-- <option value="g">Group</option> -->
						<td></td>
					</tr>
					<tr>
						<th>Status : </th>
						<td><select class="easyui-combobox" name="status" style="width:250px" data-options="panelHeight:'auto',editable:false">
							<option value="0" selected="selected"><s:message code="common.status.enabled"/></option>
							<option value="1"><s:message code="common.status.disabled" /></option></select></td>
						<td></td>
					</tr>
				</tbody>
			</table>
		</form>
	</div>
	<div id="dialog_division_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_division').submit();"><s:message code="common.button.submit" /></a>
	</div>
	<!-- Personnel add/edit dialog -->
	<div id="dialog_personel" class="easyui-dialog" style="width:400px; height:220px;" data-options="resizable:true, modal:true, closed:true, buttons:'#dialog_personel_buttons'">
		<form id="form_personel" method="post">
			<input type="hidden" name="id" />
			<input type="hidden" name="divisionId" />
			<input type="hidden" name="level" />
			<input type="hidden" name="tag" value="${division.tag}" />
			<table class="tableForm">
				<tr>
					<th style="width: 150px;">Division : </th>
					<td><input id="divisionName" name="divisionName" class="easyui-textbox" style="width:250px" readonly="readonly"></td>
				</tr>
				<tr>
					<th style="width: 150px;">User : </th>
					<td>
						<select id ="userId" name="stringArrayUser" class="easyui-combobox" style="width:250px" data-options="required: false, editable:true"></select>
					</td>
				</tr>
				<tr>
					<th>Main : </th>
					<td>
						<select class="easyui-combobox" name="mainIndex" style="width:250px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" selected="selected"><s:message code="common.choose.no" /></option>
							<option value="1"><s:message code="common.choose.yes" /></option>
						</select>
					</td>
				</tr>
				<tr>
					<th>Position : </th>
					<td>
						<select name="positionId" class="easyui-combobox" style="width:250px;" data-options="required:false, value:'gwmc1', valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=gwmc'"></select>
					</td>
				</tr>
				<%-- 	<td>
						<select class="easyui-combobox" name="index" style="width:250px" data-options="panelHeight:'auto',editable:false ">
							<option value="0" selected="selected"><s:message code="common.choose.no" /></option>
							<option value="1"><s:message code="common.choose.yes" /></option>
						</select>
					</td> --%>
			</table>
		</form>
	</div>
	<div id="dialog_personel_buttons">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form_personel').submit();"><s:message code="common.button.submit" /></a>
	</div>
</body>
</html>
