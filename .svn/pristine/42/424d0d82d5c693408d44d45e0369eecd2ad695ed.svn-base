<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Resource</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/permission/searchPermission.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/maintenance/permission/editPermission.js" charset="utf-8"></script>
<script type="text/javascript">
$(function() {
	$('#datagrid').datagrid({
		fit: true,
		url: '${pageContext.request.contextPath}/maintenance/permission/doSearch.do',
		border : false,
		pagination: true,
		idField: 'id',
		pageSize : 20,
		pageList : [ 10, 20, 50, 100, 200 ],
		rownumbers : true,
		singleSelect : true,
		columns : 
			[[
			  {
				title : '权限名称',
				field : 'name',
				sortable : true,
				width : 200
			  },
			  {
				title : '权限编码',
				field : 'code',
				sortable : true,
				width : 200
			  },
			  {
				title : '权限类型',
				field : 'typePermission',
				sortable : true,
				width : 200,
				formatter : function(value, row, index) {
					if (value == 'm') {
						return '菜单';
					} else if (value == 'b') {
						return '按钮'
					} else if (value == 'l') {
						return '链接';
					} else if (value == 'a') {
						return '审批';
					} else if (value == 'at') {
						return '考勤';
					}
				}
			  },
			  {
				title : '权限数据类型',
				field : 'typeData',
				sortable : true,
				width : 200,
				formatter : function(value, row, index) {
					if (value == 'c') {
						return 'Chekcbox';
					} else if (value == 't') {
						return 'Text';
					}
				}
			  },
			  {
				title : '父权限',
				field : 'parentCode',
				sortable : true,
				width : 200,
				hidden :true
			  },
			  {
				title : '父权限',
				field : 'parentName',
				sortable : true,
				width : 200
			  },
			  {
				title : '层级',
				field : 'level',
				sortable : true,
				width : 200
			  },
			]],
		toolbar : 
			[
				<c:if test="${comUtil.checkCode('1104001')}">
				{
					iconCls : 'icon-add',
					text : '<s:message code="common.button.add" />',
					handler : function() {
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/permission/doEdit.do?editState=i');
						$('#form').form('load', {
							id : '',
							name : '',
							code : '',
							level : '',
							value1 : '',
							typePermission : '',
							typeData : '',
							description : '',
							parentCode : '',
							remark : '',
						});
						$('#dialog').dialog('setTitle', '<s:message code="common.button.add" />');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1104002')}">
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
						$('#permissionValue1').hide();
						$('#permissionValue2').hide();
						if ('at' == checkedRows[0].typePermission) {
							operateSelection('at');
						}
						if ('1' != checkedRows[0].level) {
							operateSelectionLevel(checkedRows[0].level);
							$('#tr_parentCode').show();
						} else {
							$('#tr_parentCode').hide();
						}
						$('#form').attr('action', '${pageContext.request.contextPath}/maintenance/permission/doEdit.do?editState=u');
						$('#form').form('load', {
							id : checkedRows[0].id,
							name : checkedRows[0].name,
							code : checkedRows[0].code,
							level : checkedRows[0].level,
							value1 : checkedRows[0].value1,
							value2 : checkedRows[0].value2,
							typePermission : checkedRows[0].typePermission,
							typeData : checkedRows[0].typeData,
							description : checkedRows[0].parentCode,
							parentCode : checkedRows[0].parentCode,
							remark : checkedRows[0].remark,
						});
						if ('a' == checkedRows[0].typePermission) {
							$('#permissionValue1').show();
						}
						if ('at' == checkedRows[0].typePermission) {
							$('#permissionValue2').show();
						}
						$('#dialog').dialog('setTitle', 'Edit');
						$('#dialog').dialog('open');
					}
				},'-',
				</c:if>
				<c:if test="${comUtil.checkCode('1104003')}">
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
								$.post('${pageContext.request.contextPath}/maintenance/permission/doEdit.do?editState=d', { id : checkedRows[0].id }, function(result) {
									try {
										var j = $.parseJSON(result);
										if (j.success) {
											$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
												$('#datagrid').datagrid('reload', serializeObject($('#form_search')));
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
				}
				</c:if>
			]
		});
	
	$('#form').form({
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
						$('#dialog').dialog('close');
						$('#datagrid').datagrid('reload', serializeObject($('#form_search')));
					});
				} else {
					$.messager.alert('<s:message code="common.dialog.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
			}
		}
	});
	
});

function submit_form() {
	var opt = $('#datagrid').datagrid('options');
	opt.url = '${pageContext.request.contextPath}/maintenance/permission/doSearch.do';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#form_search')));
}

function reset_form() {
	$('#form_search').form('load',{
		name : '',
		code : '',
		level : '',
		typePermission : ''
	});
}

function operateSelection(typePermission) {
	$('#permissionValue1').hide();
	$('#permissionValue2').hide();
	// 如果是考勤权限,那么加载考勤规则与部门列表
	if ('at' == typePermission) {
			$('#permissionValue1').show();
			var url1 = '${pageContext.request.contextPath}/common/division/doListPair.do';
			$('#permissionSelectValue1').combobox('reload', url1);
			$('#permissionSelectValue1').combobox('clear');
			$('#tdPermissionValue1').text('部门 : ');
			
			$('#permissionValue2').show();
			var url2 = '${pageContext.request.contextPath}/common/droplist/doListAttenRule.do';
			$('#permissionSelectValue2').combobox('reload', url2);
			$('#permissionSelectValue2').combobox('clear');
			$('#tdPermissionValue2').text('考勤规则 : ');
	}
}

function operateSelectionLevel(level) {
	if (level != 1){
		$('.parentCode').show();
		level--;
		var url = '${pageContext.request.contextPath}/common/droplist/doListPermission.do?level=' + level;
		$('#combotree_parentCode').combobox('clear');
		$('#combotree_parentCode').combobox('reload', url);
	} else {
		$('.parentCode').hide();
	}
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 135px;overflow: hidden;" align="center">
		<form id="form_search">
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">权限名称 : </th>
					<td><input name="name" class="easyui-textbox" data-options="validType:'length[1,20]'"  style="width: 200px;" /></td>
					<th style="width: 120px;">权限编号 : </th>
					<td><input name="code" class="easyui-textbox" data-options="validType:'length[7,7]'" style="width: 200px;" /></td>
				</tr>
				<tr>
					<th>层级 : </th>
					<td><select class="easyui-combobox" name="level" style="width:200px" data-options="panelHeight:'auto',editable:false,value:'0'">
							<option value=""></option>
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
						</select>
					</td>
					<th>类型 : </th>
					<td>
						<select class="easyui-combobox" name="typePermission" style="width:200px" data-options="panelHeight:'auto',editable:false,value:'0'">
							<option value=""></option>
							<option value="m">菜单</option>
							<option value="b">按钮</option>
							<option value="l">链接</option>
							<option value="a">审批</option>
							<option value="at">考勤</option>
						</select>
					</td>
				</tr>
			</table>
		</form>
		<div style="text-align: center; padding: 5px">
			<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
		</div>
		<script>

		</script>
	</div>
	
	<jsp:include page="editPermission.jsp"></jsp:include>
	
	
</html>