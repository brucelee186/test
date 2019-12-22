<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {
			// 初始化item数据
		initMainList();
		// 初始化itemRule
		initItemRule(-1);
		
	// 选项
		$('#userInfor_form').form({
			url : '${pageContext.request.contextPath}/maintenance/userInfo/doEdit.do',
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
				} else {
					$.messager.progress('close');	
				}
				return isValid;	
			},
			success : function(result) {
				$.messager.progress('close');
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.show({
							title:'<s:message code="common.dialog.tip" />',
							msg:'操作成功',
							timeout:1000,
							showType:'slide'
						});
						initMainList(-1);
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />',r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});
	
		// 选项内容
		$('#userItem_form').form({
			url : '${pageContext.request.contextPath}/maintenance/userInfo/doEdit.do',
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
				} else {
					$.messager.progress('close');	
				}
				return isValid;	
			},
			success : function(result) {
				$.messager.progress('close');
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.show({
							title:'<s:message code="common.dialog.tip" />',
							msg:'操作成功',
							timeout:1000,
							showType:'slide'
						});
						$('#datagrid_itemRule').datagrid('reload');
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />',r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});

		
		
		
	});
	
	function initMainList(){
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/maintenance/userInfo/doSearch.do?flag=s',
			//fit : true,
			fitColumns : true,
			border : false,
			pagination : true,
			pageSize : 25,
			pageList : [ 25, 50, 100, 200 ],
			sortName : 'modifiedDate',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			rownumbers:true,
			selectOnCheck : false,
			nowrap : true,
			striped: true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			} ] ],
			columns : [ [ 
				{
					title :  '<s:message code="common.name.zh" />',
					field : 'name',
					sortable : false,
					width : 100
				} ,
				{
					title :  '<s:message code="common.name.en" />',
					field : 'nameEng',
					sortable : false,
					width : 100
				} ,
				{
					title :  '类型',
					field : 'typeSystem',
					sortable : false,
					align : 'center',
					width : 20,
					formatter:function(value,row,index){
						if(value == 's'){
							return '系统';
						}else if(value == 'm'){
							return '模块';
						}
					},
				},
				{
					title :  '<s:message code="office.rowName.status" />',
					field : 'status',
					sortable : false,
					align : 'center',
					width : 20,
					formatter:function(value,row,index){
						if(value == 'a'){
							return '<s:message code="office.rowlable.enable" />';
						}else if(value == 'f'){
							return '<s:message code="office.rowlable.disable" />';
						}
					},
					styler: function(value, row, index){
							if(value == 'a'){
								return 'background-color:#C6EFCE;color:#006100;';
							}else if(value == 'f'){
								return 'background-color:#FFC7CE;color:#9C0006;';
							}
					}
				},
			] ],
			toolbar : [
						{
				iconCls : 'icon-add',
				text : '<s:message code="office.button.add" />',
				handler : function() {
					$('#txt_id').val(null);
					$('#editState').val('i');
					$('#txt_flag').val('s');
					$('#userInfor_form').submit();
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '<s:message code="office.itemLable.edit" />',
				handler : function() {
					$('#editState').val('u');
					$('#userInfor_form').submit();
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '<s:message code="office.button.delete" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelected');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var id = checkedRows.id;
					$.post('${pageContext.request.contextPath}/maintenance/userInfo/doEdit.do',{id:id,editState:'d'},function(result){
						var j = $.parseJSON(result);
						if (j.success) {
							$.messager.show({
								title:'<s:message code="common.dialog.tip" />',
								msg:j.msg,
								timeout:5000,
								showType:'slide'
							});
							initMainList(-1);
						}else {
							$.messager.alert('<s:message code="common.dialog.tip" />', j.msg, 'warning');
							return;
							}
					});
					
				}
			}],
			onClickRow:function(rowIndex,rowData){
				$('#txt_name').textbox('setValue',rowData.name);
				$('#txt_name_eng').textbox('setValue',rowData.nameEng);
				$('#txt_orderIndex').val(rowData.orderIndex);
				$('#txt_type').textbox('setValue',rowData.type);
				$('#txt_typeSystem').combobox('setValue', rowData.typeSystem);
				$('#txt_id').val(rowData.id);
				$('#txt_flag').val(rowData.flag);
				$('#item_pid').val(rowData.id);
				$('#com_type').val(rowData.type);
				$('#com_pid').val(rowData.id);
				$('#txt_select').combobox('setValue',rowData.status);
				/* if(rowData.status == 'a'){
					$('#txt_select').find("option[text='a']").attr("selected",true);
				} */
				initItemRule(rowData.id);
			}
		});
	}
	
	function initItemRule(id){
		$('#datagrid_itemRule').datagrid({
			url : '${pageContext.request.contextPath}/maintenance/userInfo/doSearch.do?flag=i&pid='+id,
			fit : true,
			fitColumns : true,
			border : false,
			pagination : false,
			singleSelect : true,
			checkOnSelect : false,
			rownumbers:true,
			selectOnCheck : false,
			nowrap : true,
			sortName : 'orderIndex',
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			} ] ],
			columns : [ [
			{
				title : '<s:message code="common.name.zh" />',
				field : 'name',
				width : 150,
				sortable : true
			},
			{
				title : '<s:message code="common.name.en" />',
				field : 'nameEng',
				width : 150,
				sortable : true
			},
			{
				title : '编码明细',
				field : 'codeDetail',
				width : 50,
				sortable : true
			},
			{
				title : '<s:message code="common.name.orderIndex" />',
				field : 'orderIndex',
				width : 150,
				sortable : true
			},
			{
				title :  '<s:message code="office.rowName.status" />',
				field : 'status',
				sortable : false,
				align : 'center',
				width : 20,
				formatter:function(value,row,index){
					if(value == 'a'){
						return '<s:message code="office.rowlable.enable" />';
					}else if(value == 'f'){
						return '<s:message code="office.rowlable.disable" />';
					}
				},
				styler: function(value, row, index){
						if(value == 'a'){
							return 'background-color:#C6EFCE;color:#006100;';
						}else if(value == 'f'){
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
				}
			}
			] ],
			toolbar : [{
				iconCls : 'icon-add',
				text : '<s:message code="office.button.add" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelected');
					var typeSystem = checkedRows.typeSystem;
					var type = 	$('#com_type').val();
					var pid = $('#com_pid').val();
					$('#item_id').val(null);
					$('#item_editState').val('i');
					$('#item_flag').val('i');
					$('#item_type').val(type);
					$('#item_typeSystem').val(typeSystem);
					$('#item_pid').val(pid);
					$('#userItem_form').submit();
				}
			}, '-', {
				iconCls : 'icon-edit',
				text : '<s:message code="office.itemLable.edit" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelected');
					var typeSystem = checkedRows.typeSystem;
					$('#item_typeSystem').val(typeSystem);
					$('#item_editState').val('u');
					$('#userItem_form').submit();
				}
			}, '-', {
				iconCls : 'icon-remove',
				text : '<s:message code="office.button.delete" />',
				handler : function() {
					var checkedRows = $('#datagrid_itemRule').datagrid('getSelected');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var id = checkedRows.id;
					$.post('${pageContext.request.contextPath}/maintenance/userInfo/doEdit.do',{id:id,editState:'d'},function(result){
						var j = $.parseJSON(result);
						if (j.success) {
							$.messager.show({
								title:'<s:message code="common.dialog.tip" />',
								msg:j.msg,
								timeout:1000,
								showType:'slide'
							});
							$('#datagrid_itemRule').datagrid('reload');
						}else {
							$.messager.alert('<s:message code="common.dialog.tip" />', j.msg, 'warning');
							return;
							}
					});
				}
			}],
			onClickRow:function(rowIndex,rowData){
				$('#item_name').textbox('setValue', rowData.name);
				$('#item_name_eng').textbox('setValue', rowData.nameEng);
				$('#item_orderIndex').textbox('setValue', rowData.orderIndex);
				$('#item_id').val(rowData.id);
				$('#item_code').textbox('setValue', rowData.code);
				$('#item_codeDetail').textbox('setValue', rowData.codeDetail);
				$('#item_flag').val(rowData.flag);
				$('#item_type').val(rowData.type);
				$('#item_select').combobox('setValue', rowData.status);
			
			}
		});
		
	}

</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<input id="com_type" type="hidden"/>
	<input id="com_pid" type="hidden"/>
	<div data-options="region:'center',title:'选项类型',border:false" >
	<form id="userInfor_form" method="post">
	<input id="txt_id" type="hidden" name="id"/>
	<input id="editState" type="hidden" name="editState"/>
	<input id="txt_flag" type="hidden" name="flag"/>
	<table>
			<tr >
				<td><s:message code="common.name.zh" />:<input id="txt_name" type="text" name="name" class="easyui-textbox" data-options="required:true" style="width: 120px;" /></td>
				<td><s:message code="common.name.en" />:<input id="txt_name_eng" type="text" name="nameEng" class="easyui-textbox" data-options="" style="width: 120px;" /></td>
				<td>编码:<input id="txt_type" type="text" name="type" class="easyui-textbox" data-options="required:true" style="width: 80px;"/></td>
				<td>类型 : </td>
				<td><select id="txt_typeSystem" name="typeSystem" class="easyui-combobox" style="width:60px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=xxlx'"></select></td>
				<%-- <td>
				<select id="txt_typeSystem" name="typeSystem">
					<option value="s">系统</option>
					<option value="m">模块</option>
				</select>
				</td> --%>
				<td>状态</td>
				<td><select id="txt_select" name="status" class="easyui-combobox" style="width:60px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=xtzt'"></select></td>
				<%-- <td>
				<select id="txt_select" name="status">
					<option value="a">启用</option>
					<option value="f">禁用</option>
				</select>
				</td> --%>
				<td><input type="button" value="清空" onclick="javascript:$('#userInfor_form').form('clear')"></td>
			</tr>
	</table>
	</form>
		<table id="datagrid"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'选项明细'" style="width: 900px; overflow: hidden;">
	<form id="userItem_form" method="post">
	<input id="item_id" type="hidden" name="id"/>
	<input id="item_editState" type="hidden" name="editState"/>
	<input id="item_pid" type="hidden" name="pid"/>
	<input id="item_type" type="hidden" name="type"/>
	<input id="item_flag" type="hidden" name="flag"/>
	<input id="item_typeSystem" type="hidden" name="typeSystem"/>
	<table>
			<tr >
				<td><s:message code="common.name.zh" />:<input id="item_name" type="text" name="name" class="easyui-textbox" data-options="required:true"  style="width: 120px;" /></td>
				<td><s:message code="common.name.en" />:<input id="item_name_eng" type="text" name="nameEng" class="easyui-textbox" data-options=""  style="width: 120px;" /></td>
				<td>编码:<input id="item_code" type="text" name="code" class="easyui-textbox" data-options="required:false" style="width: 80px"/></td>
				<td>编码明细:<input id="item_codeDetail" type="text" name="codeDetail" class="easyui-textbox" data-options="required:false" style="width: 80px"/></td>
				<td><s:message code="common.name.orderIndex" />:<input id="item_orderIndex" type="text" name="orderIndex" class="easyui-textbox" data-options="" style="width: 80px;" /></td>
				<!-- <td style="color: red;">(*新添加数据不需要输入)</td> -->
				<td><select id="item_select" name="status" class="easyui-combobox" style="width:60px;" data-options="required:true, valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=xtzt'"></select></td>
				<%-- <td>
				<select id="item_select" name="status">
					<option value="a">启用</option>
					<option value="f">禁用</option>
				</select>
				</td> --%>
				<td><input type="button" value="清空" onclick="javascript:$('#userItem_form').form('clear')"></td>
			</tr>
	</table>
	</form>
		<table id="datagrid_itemRule"></table>
	</div>

</body>
</html>
