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
		var comboTypeDate = [ {
			"value" : "f",
			"text" : "节假日"
		}, {
			"value" : "w",
			"text" : "工作日"
		}, {
			"value" : "o",
			"text" : "其它"
		} ];
		
		var comboYesNo = [ {
			"value" : "y",
			"text" : "是"
		}, {
			"value" : "n",
			"text" : "否"
		} ];
		var comboStatus = [ {
			"value" : "n",
			"text" : "启用"
		}, {
			"value" : "d",
			"text" : "禁用"
		} ];
		function formatterCombo(value, rowData, rowIndex) {
			if (value == 0) {
				return;
			}
			for ( var i = 0; i < comboStatus.length; i++) {
				if (comboStatus[i].value == value) {
					return comboStatus[i].text;
				}
			}
		}
		var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/order/orderServicePath/doSearch.do', //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 15, //页大小
							pageList : [ 15, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowap : true, //列内容多时自动折至第二行
							border : false,
							idField : 'id', //主键
							singleSelect : true,
							rownumbers : true,
							sortName : 'modifiedDate',
							sortOrder : 'desc',
							columns : [ [//显示的列
							{
								title : 'ID',
								field : 'id',
								width : 0,
								sortable : false,
								checkbox : true,
							//hidden : true
							}, 
							{
								title : '名称	',
								field : 'name',
								width : 180,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : true,
										validType : 'length[1,20]',
									}
								}
							}, 
							{
								title : '始发地',
								field : 'origin',
								width : 180,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
									}
								}
							}, 
							{
								title : '目的地',
								field : 'destination',
								width : 180,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
									}
								}
							}, 
							{
								title : '公里数',
								field : 'mileage',
								align : 'right',
								width : 150,
								sortable : true,
								editor : {
									type : 'numberbox',
									options : {
										precision : '2',
										min : 10,
										max : 100000,
									}
								}
							}, 
							{
								title : '费用',
								field : 'expense',
								align : 'right',
								width : 100,
								sortable : true,
								editor : {
									type : 'numberbox',
									options : {
										precision : '2',
										min : 10,
										max : 100000,
										required : true,
									}
								}
							}, 
							{
								title : '备注',
								field : 'remark',
								width : 250,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,80]',
									}
								}
							},
							{
								title : '状态',
								field : 'tag',
								align : 'left',
								width : 60,
								formatter : formatterCombo,
								align : 'center',
								formatter : function(value, row, index) {
									if (value == 'n'){
										return '<s:message code="common.status.enabled" />';
									} else if (value == 'd') {
										return '<s:message code="common.status.disabled" />';
									}
								},
								styler: function(value, row, index){
									if (value == 'n'){
										return 'background-color:#C6EFCE;color:#006100;';
									} else if (value == 'd') {
										return 'background-color:#FFC7CE;color:#9C0006;';
									}
								},
								editor : {
									type : 'combobox',
									options : {
										data : comboStatus,
										valueField : "value",
										textField : "text",
										required : true,
										editable : false,
									}
								}
							},
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
									{
										text : '添加',
										iconCls : 'icon-add',
										handler : function() {//添加列表的操作按钮添加，修改，删除等
											//添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
											if (editRow != undefined) {
												datagrid.datagrid("endEdit",
														editRow);
											}
											//添加时如果没有正在编辑的行，则在datagrid的第一行插入一行
											if (editRow == undefined) {
												datagrid.datagrid("insertRow",
														{
															index : 0, // index start with 0
															row : {

															}
														});
												//将新插入的那一行开户编辑状态
												datagrid.datagrid("beginEdit",
														0);
												//给当前编辑的行赋值
												editRow = 0;
											}

										}
									},
									'-',
									{
										text : '删除',
										iconCls : 'icon-remove',
										handler : function() {
											//删除时先获取选择行
											var rows = datagrid
													.datagrid("getSelections");
											//选择要删除的行
											if (rows.length == 1) {
												$.messager
														.confirm(
																"提示",
																"你确定要删除吗?",
																function(r) {
																	if (r) {
																		$.post('${pageContext.request.contextPath}/order/orderServiceDetail/doEdit.do?editState=d',
																				{
																					idString : rows[0].id
																				},
																				function(result) {
																					$('#datagrid').datagrid( 'reload');
																					$.messager.show({
																						title : '<s:message code="common.dialog.tip" />',
																						msg : '删除成功',
																						timeout : 2000,
																						showType : 'slide'
																					});
																				});
																	}
																});
											} else {
												$.messager.alert("提示",
														"请选择要删除的行", "error");
											}
										}
									},
									'-',
									{
										text : '修改',
										iconCls : 'icon-edit',
										handler : function() {
											//修改时要获取选择到的行
											var rows = datagrid
													.datagrid("getSelections");
											//如果只选择了一行则可以进行修改，否则不操作
											if (rows.length == 1) {
												//修改之前先关闭已经开启的编辑行，当调用endEdit该方法时会触发onAfterEdit事件
												if (editRow != undefined) {
													datagrid.datagrid(
															"endEdit", editRow);
												}
												//当无编辑行时
												if (editRow == undefined) {
													//获取到当前选择行的下标
													var index = datagrid
															.datagrid(
																	"getRowIndex",
																	rows[0]);
													//开启编辑
													datagrid.datagrid(
															"beginEdit", index);
													//把当前开启编辑的行赋值给全局变量editRow
													editRow = index;
													//当开启了当前选择行的编辑状态之后，
													//应该取消当前列表的所有选择行，要不然双击之后无法再选择其他行进行编辑
													datagrid
															.datagrid("unselectAll");
												}
											}
										}
									},
									'-',
									{
										text : '保存',
										iconCls : 'icon-save',
										handler : function() {
											//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
											datagrid.datagrid("endEdit",
													editRow);
										}
									}, '-', {
										text : '取消编辑',
										iconCls : 'icon-redo',
										handler : function() {
											//取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
											editRow = undefined;
											datagrid.datagrid("rejectChanges");
											datagrid.datagrid("unselectAll");
										}
									}, '-' ],
							onAfterEdit : function(rowIndex, rowData, changes) {
								var changes = datagrid.datagrid("getChanges")
								//alert(changes)
								//return;
								//endEdit该方法触发此事件
								console.info(rowData);
								//alert(rowData.name)
								//editRow = undefined;
								//提交后台处理
								$.post('${pageContext.request.contextPath}/order/orderServicePath/doEdit.do?editState=u',
									{
										idString : rowData.id,
										name : rowData.name,
										origin : rowData.origin,
										destination : rowData.destination,
										mileage : rowData.mileage,
										expense : rowData.expense,
										remark : rowData.remark,
										tag : rowData.tag,
									},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : '<s:message code="common.dialog.tip" />',
													msg : '修改成功',
													timeout : 2000,
													showType : 'slide'
												});
									});
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							onDblClickRow : function(rowIndex, rowData) {
								//alert('double')
								//双击开启编辑行
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
							}
						});
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
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
