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

var listAttenVacate = '${jsonListAttenVacate}';
var jsonListAttenVacate = jQuery.parseJSON(listAttenVacate)[0];
 function formatterListAttenVacate(value, rowData, rowIndex) {
	if (value == 0) {
		return;
	}

	for ( var i = 0; i < jsonListAttenVacate.length; i++) {
		if (jsonListAttenVacate[i].id == value) {
			return jsonListAttenVacate[i].name;
		}
	}
}
 
var listArrayUser = '${jsonArrayUser}';
var jsonListArrayUser = jQuery.parseJSON(listArrayUser)[0];
 function formatterListArrayUser(value, rowData, rowIndex) {
	if (value == 0) {
		return;
	}

	for ( var i = 0; i < jsonListArrayUser.length; i++) {
		if (jsonListArrayUser[i].id == value) {
			return jsonListArrayUser[i].displayName;
		}
	}
}
 

function unitformatter(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}

		for ( var i = 0; i < comboTypeDate.length; i++) {
			if (comboTypeDate[i].value == value) {
				return comboTypeDate[i].text;
			}
		}
}
function unitformatterComboUnit(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}

		for ( var i = 0; i < comboUnit.length; i++) {
			if (comboUnit[i].value == value) {
				return comboUnit[i].text;
			}
		}
}

var comboYesNo = [ {
	"value" : "y",
	"text" : "是"
}, {
	"value" : "n",
	"text" : "否"
} ];
function formatterYesNo(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}

		for ( var i = 0; i < comboYesNo.length; i++) {
			if (comboYesNo[i].value == value) {
				return comboYesNo[i].text;
			}
		}
}

var comboApproveLevel = [ 
   {
	"value" : "ap1",
	"text" : "经理审批"
}, 
{
	"value" : "ap2",
	"text" : "高管审批"
}, 
];
function formatterApproveLevel(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}
		for ( var i = 0; i < comboApproveLevel.length; i++) {
			if (comboApproveLevel[i].value == value) {
				return comboApproveLevel[i].text;
			}
		}
}
var comboTagScope = [ 
   {
	"value" : "a",
	"text" : "全局"
}, 
{
	"value" : "p",
	"text" : "个人"
}, 
];
function formatterTagScope(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}
		for ( var i = 0; i < comboTagScope.length; i++) {
			if (comboTagScope[i].value == value) {
				return comboTagScope[i].text;
			}
		}
}

var comboDayVacateAhead = [ 
   {
	"value" : "-1",
	"text" : "延后一天"
}, 
   {
	"value" : "1",
	"text" : "提前一天"
}, 
{
	"value" : "2",
	"text" : "提前两天"
}, 
{
	"value" : "3",
	"text" : "提前三天"
}, 
{
	"value" : "-30",
	"text" : "延后一个月"
}, 
{
	"value" : "30",
	"text" : "提前一个月"
}, 
];
function formatterDayVacateAhead(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}
		for ( var i = 0; i < comboDayVacateAhead.length; i++) {
			if (comboDayVacateAhead[i].value == value) {
				return comboDayVacateAhead[i].text;
			}
		}
}

var comboTagType = [ 
   {
	"value" : "m",
	"text" : "主类别"
}, 
   {
	"value" : "d",
	"text" : "次类别"
}, 
];
function formatterTagType(value, rowData, rowIndex) {
		if (value == 0) {
			return;
		}
		for ( var i = 0; i < comboTagType.length; i++) {
			if (comboTagType[i].value == value) {
				return comboTagType[i].text;
			}
		}
}
	var comboUnit = [ 
/* 	{
		"value" : "h",
		"text" : "小时"
	},  */
	{
		"value" : "w",
		"text" : "工作日"
	},
	{
		"value" : "c",
		"text" : "日历日"
	},	
	];
	
	var comboLoopYear = [ {
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
	$(function() {
		loadGrid();
		//loadDetailGrid();
	});
	
	function loadGrid() {
		var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.datagrid(
						{
							url : '${pageContext.request.contextPath}/attendance/attenVacateRule/doSearch.do?tagType=m', //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 10, //页大小
							pageList : [ 10, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowap : true, //列内容多时自动折至第二行
							border : false,
							idField : 'id', //主键
							singleSelect : true,
							sortName : 'modifiedDate',
							sortOrder : 'asc',
							rownumbers : true,
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
								field : 'idAttenVacate',
								title : '假别',
								width : 100,
								formatter : formatterListAttenVacate,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenVacate,
										valueField : "id",
										textField : "name",
										required : true,
										editable : false,
									}
								}
							},
							{
								field : 'tagScope',
								title : '使用范围',
								width : 100,
								formatter : formatterTagScope,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : comboTagScope,
										valueField : "value",
										textField : "text",
										required : true,
										editable : false,
									}
								}
							},
							{
								field : 'userId',
								title : '用户',
								width : 100,
								formatter : formatterListArrayUser,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : jsonListArrayUser,
										valueField : "id",
										textField : "displayName",
										required : false,
										editable : true,
									}
								}
							},
							{
								title : '时长',
								field : 'duration',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : true,
										validType : 'length[1,3]',
									}
								}
							},
							{
								title : '单位',
								field : 'modifiedDate',
								width : 40,
								align : 'center',
								sortable : true,
								formatter : function(){
									return '天'
								}
							},
							{
								title : '备注',
								field : 'remark',
								align : 'left',
								width : 212,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
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
									/* '-',
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
																		$.post('${pageContext.request.contextPath}/attendance/attenVacateRule/doEdit.do?editState=d',
																				{
																					id : rows[0].id
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
									}, */
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
								var dayStart = rowData.dayStart;
								var dayEnd = rowData.dayEnd;
								/* if (dayEnd != '' && dayEnd != null && dayStart != null && (dayEnd <= dayStart)) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '结束日期不能小于或等于开始日期!', 'warning');
									editRow = undefined;
									return;
								} */
								$.post('${pageContext.request.contextPath}/attendance/attenVacateRule/doEdit.do?editState=u',
									{
										id : rowData.id,
										//name : rowData.name,
										idAttenVacate : rowData.idAttenVacate,
										duration : rowData.duration,
										userId : rowData.userId,
										duration : rowData.duration,
										remark : rowData.remark,
										tag : rowData.tag,
										tagScope : rowData.tagScope,
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
							onLoadSuccess : function (data){
							},
							onSelect : function(rowIndex, rowData) {
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
	}

</script>
</head>
<body class="easyui-layout" >
	<%-- <div id="dialog_password" class="easyui-dialog" title="Reset Password" style="width:400px;height:150px;" data-options="iconCls:'icon-lock-edit',resizable:true,modal:true,closed: true, buttons: '#dialog_password_buttons'">
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
	</div> --%>
	<div style="height:350px;">
		<table id="datagrid"></table>
	</div>
	<div style="height:350px;">
		<table id="datagridDetail"></table>
	</div>
	<!-- <div >
		<table id="datagridDetail"></table>
	</div> -->
	<!-- <div id="dialog_roles" class="easyui-dialog" title="Roles" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_roles"></table>
	</div>
	<div id="dialog_divisions" class="easyui-dialog" title="Divisions" style="width:300px;height:300px;" data-options="iconCls:'icon-ok',resizable:true,modal:true,closed: true">
		<table id="datagrid_divisions"></table>
	</div> -->
</body>

</html>
