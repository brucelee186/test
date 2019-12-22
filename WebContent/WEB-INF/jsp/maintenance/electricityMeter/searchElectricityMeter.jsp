<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search User</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc3.jsp"></jsp:include>
<script type="text/javascript">
//var listArrayDivision = '${jsonArrayDivision}';
var listArrayDivisionDep = '${jsonArrayDivisionDep}';
var listArrayDriver = '${jsonArrayDriver}';
var listArrayUserInfor = '${jsonArrayUserInfor}';
var jsonArrayTypeExpense = '${jsonArrayTypeExpense}';
var jsonArrayOrderServicePath = '${jsonArrayOrderServicePath}';
var common_button_add = '<s:message code="common.button.add" />';
var common_dialog_error = '<s:message code="common.dialog.error" />';
var common_dialog_tip = '<s:message code="common.dialog.tip" />';
var userName = '${userNameString}';
var tagModule = '${orderService.tagModule}';
</script>
<script type="text/javascript">

// 默认编辑状态
var tagEditState = 'd';
//定义全局变量：当前编辑的行
var editRow = undefined; 
//	客户格式化信息
var jsonArrayDivision = eval(${jsonArrayDivision});
function formatterListArrayDivision(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayDivision, 'id', 'name');
}

//	部门格式化信息
var jsonArrayDivisionDep = jQuery.parseJSON(listArrayDivisionDep)[0];
function formatterListArrayDivisionDep(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayDivisionDep, 'id', 'name');
}

//	路径格式化信息
var jsonArrayOrderServicePath = jQuery.parseJSON(jsonArrayOrderServicePath)[0];
function formatterArrayOrderServicePath(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayOrderServicePath, 'id', 'name');
}

//id,name形式的formatter
function formatterDate(value, rowData, rowIndex, jsonArray,typeId,typeName) {
if (value == 0) {
	return;
}
for ( var i = 0; i < jsonArray.length; i++) {
	if (eval('jsonArray[i].' + typeId) == value) {
		return eval('jsonArray[i].' + typeName);
	}
}
}

//	司机信息格式化信息

var jsonArrayDriver = jQuery.parseJSON(listArrayDriver)[0];
function formatterListArrayDriver(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayDriver, 'userId', 'displayName');
}

//用车类别格式化信息

var jsonArrayUserInfor = jQuery.parseJSON(listArrayUserInfor)[0];
function formatterListArrayUserInforType(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayUserInfor, 'code', 'name');
}

//用计费别格式化信息

var jsonArrayTypeExpense = jQuery.parseJSON(jsonArrayTypeExpense)[0];
function formatterListArrayUserInforTypeExpense(value, rowData, rowIndex) {
 return formatterDate(value, rowData, rowIndex, jsonArrayTypeExpense, 'code', 'name');
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

//statusOrder	订车状态(d:draft 草稿,s:提交,a:分配)
var comboStatusOrder = [
	{
		"value" : "d",
		"text" : "草稿"
	}, 
	{
		"value" : "s",
		"text" : "提交"
	},
	{
		"value" : "a",
		"text" : "已派车"
	},
];
function formatterStatusOrder(value, rowData, rowIndex) {
	if (value == 0) {
		return;
	}

	for ( var i = 0; i < comboStatusOrder.length; i++) {
		if (comboStatusOrder[i].value == value) {
			return comboStatusOrder[i].text;
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
	// 隐藏明细按钮
	// 主表单提交
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
					$('#dialog').dialog('close');
					$('#datagrid').datagrid('reload', serializeObject($('#form_search')));
					$.messager.show({
						title : common_dialog_error,
						msg : '修改成功',
						timeout : 2000,
						showType : 'slide'
					});
					$('#datagrid').datagrid("clearSelections");
				} else {
					$.messager.alert(common_dialog_error, r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert(common_dialog_error, result, 'error');
			}
		}
	});
	//loadDetailGrid();
	
	submitSearchForm();
});

function loadGrid() {
	
	var datagrid; //定义全局变量datagrid

	datagrid = $("#datagrid")
			.datagrid(
					{
						url : null, //请求的数据源
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
						<c:if test="${orderService.tagModule == 'ap'}">
							singleSelect : false,
						</c:if>
						<c:if test="${orderService.tagModule == 'o' || orderService.tagModule == 'a'}">
							singleSelect : true,
						</c:if>
						sortName : 'modifiedDate',
						sortOrder : 'desc',
						rownumbers : true,
						columns : [ [//显示的列
						{
							field : 'id',
							sortable : false,
							checkbox : true,
						}, 
						{
							title : '序号',
							field : 'idOrderService',
							align : 'right',
							width : 60,
							sortable : true,
							checkbox : false,
						}, 
						<c:if test="${orderService.tagModule == 'o' || orderService.tagModule == 'ap'}">
						{
							title : '部门',
							field : 'divisionId',
							width : 150,
							sortable : true,
							formatter : formatterListArrayDivisionDep,
							align : 'left',
							/* editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDivisionDep,
									valueField : "id",
									textField : "name",
									required : true,
									editable : false,
							 }
							}*/
						}, 
						{
							title : '客户',
							field : 'customer',
							width : 200,
							align : 'left',
							/* editor : { type : 'combotree', options : {
								url : contextPath + '/common/division/doList.do?tag=c',
								valueField : 'id',
								textField : 'name',
								parentField : 'pid',
								required : false,
								editable : false,
								} 
							}, */
							formatter : formatterListArrayDivision,
							editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDivision,
									valueField : "id",
									textField : "name",
									required : false,
									editable : false,
								}
							}
						}, 
						{
							title : '类别',
							field : 'type',
							width : 60,
							formatter : formatterListArrayUserInforType,
							align : 'center',
							editor : {
								type : 'combobox',
								options : {
									data : jsonArrayUserInfor,
									valueField : "code",
									textField : "name",
									required : true,
									editable : false,
								}
							}
						}, 
						 {
							title : '用车人',
							field : 'userName',
							width : 80,
							align : 'center',
							sortable : true,
							formatter : function(val,row,index){
								return val;
							},
						},
						{
							title : '出发时间',
							field : 'timeTrip',
							width : 180,
							align : 'center',
							sortable : true,
							editor : {
								type : 'datetimebox',
								options : {
									required : true,
									editable : false,
									showSeconds : false,
								}
							}
						},
						{
							title : '日期',
							field : 'departDate',
							width : 100,
							align : 'center',
							sortable : true,
						/* 	editor : {
								type : 'datetimebox',
								options : {
									required : true,
									editable : false,
								}
							}, */
						},
						{
							title : '月份',
							field : 'departMonth',
							width : 100,
							align : 'center',
							sortable : true,
							/*editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,3]',
								}
							}*/
						},
						{
							title : '司机姓名',
							field : 'driverId',
							width : 100,
							formatter : formatterListArrayDriver,
							align : 'center',
						/* 	editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDriver,
									valueField : 'userId',
									textField : 'displayName',
									required : true,
									editable : false,
								}
							} */
						},
						{
							title : '始发地',
							field : 'origin',
							width : 150,
							sortable : true,
							editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,10]',
								}
							}
						}, 
						{
							title : '目的地',
							field : 'destination',
							width : 150,
							sortable : true,
							editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,10]',
								}
							}
						}, 
						{
							field : 'mileage',
							title : '公里表数',
							width : 100,
							align : 'right',
							sortable : true,
						},
						{
							title : '状态',
							field : 'statusOrder',
							width : 110,
							align : 'center',
							sortable : true,
							formatter : function(val,row,index){
								if ('d' == val) {
									return '草稿';
								} 
								else if ('s' == val) {
									return '提交';
								} 
								else if ('ap1' == val) {
									return '部门审批';
								} 
								else if ('da' == val) {
									return '派车中';
								}
								else if ('sa' == val) {
									return '已派车';
								}
								else if ('asa' == val) {
									return '派车确认';
								}
								else if ('dia' == val) {
									return '派车单录入中';
								}
								else if ('sia' == val) {
									return '派车单录入完成';
								}
								else if ('aia' == val) {
									return '派车单确认';
								}
								else if ('ap2' == val) {
									return '行政审批';
								} 
								else if ('ap3' == val) {
									return '高级审批';
								} 
								else if ('re1' == val) {
									return '部门驳回';
								} 
								else if ('re2' == val) {
									return '行政驳回';
								} 
								else if ('re3' == val) {
									return '高级驳回';
								} 
								else if ('rd' == val) {
									return '行政审批';
								} 
								else {
									return '其它';
								}
							},
							styler: function(val, row, index){
								if ('d' == val){
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('s' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('ap1' == val || 'ap2' == val || 'rd' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('a' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} else if ('re1' == val || 're2' == val || 're3' == val) {
									return 'background-color:#FFC7CE;color:#9C0006;';
								} else if ('s' == val) {
									return 'background-color:#ffff99;color:#ff9900;';
								} 
								else {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
							}
						},
						</c:if>
						<c:if test="${orderService.tagModule == 'a'}">
						{
							title : '部门',
							field : 'divisionId',
							width : 150,
							sortable : true,
							formatter : formatterListArrayDivisionDep,
							align : 'left',
							/*editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDivisionDep,
									valueField : "id",
									textField : "name",
									required : true,
									editable : false,
								}
							}*/
						}, 
						{
							title : '客户',
							field : 'customer',
							width : 200,
							formatter : formatterListArrayDivision,
							align : 'center',
							/*editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDivision,
									valueField : "id",
									textField : "name",
									required : true,
									editable : false,
								}
							}*/
						}, 
						{
							title : '类别',
							field : 'type',
							width : 60,
							formatter : formatterListArrayUserInforType,
							align : 'center',
							/*editor : {
								type : 'combobox',
								options : {
									data : jsonArrayUserInfor,
									valueField : "code",
									textField : "name",
									required : true,
									editable : false,
								}
							}*/
						}, 
						 {
							title : '用车人',
							field : 'userName',
							width : 80,
							align : 'center',
							sortable : true,
						},
						{
							title : '出发时间',
							field : 'timeTrip',
							width : 180,
							align : 'center',
							sortable : true,
							hidden : true,
						},
						{
							title : '日期',
							field : 'departDate',
							width : 180,
							align : 'center',
							sortable : true,
							/*editor : {
								type : 'datetimebox',
								options : {
									required : true,
									editable : false,
								}
							},*/
						},
						{
							title : '出发时间',
							field : 'departTime',
							width : 100,
							align : 'center',
							sortable : true,
							/*editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,3]',
								}
							}*/
						},
						{
							title : '月份',
							field : 'departMonth',
							width : 100,
							align : 'center',
							sortable : true,
							/*editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,3]',
								}
							}*/
						},
						{
							title : '始发地',
							field : 'origin',
							width : 150,
							sortable : true,
							/*editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,10]',
								}
							}*/
						}, 
						{
							title : '目的地',
							field : 'destination',
							width : 150,
							sortable : true,
							/*editor : {
								type : 'validatebox',
								options : {
									required : true,
									validType : 'length[1,10]',
								}
							}*/
						}, 
						{
							title : '状态',
							field : 'statusOrder',
							width : 110,
							align : 'center',
							sortable : true,
							formatter : function(val,row,index){
								if ('d' == val) {
									return '草稿';
								} 
								else if ('s' == val) {
									return '提交';
								} 
								else if ('ap1' == val) {
									return '部门审批';
								} 
								else if ('da' == val) {
									return '派车中';
								}
								else if ('sa' == val) {
									return '已派车';
								}
								else if ('asa' == val) {
									return '派车确认';
								}
								else if ('dia' == val) {
									return '派车单录入中';
								}
								else if ('sia' == val) {
									return '派车单录入完成';
								}
								else if ('aia' == val) {
									return '派车单确认';
								}
								else if ('ap2' == val) {
									return '行政审批';
								} 
								else if ('ap3' == val) {
									return '高级审批';
								} 
								else if ('re1' == val) {
									return '部门驳回';
								} 
								else if ('re2' == val) {
									return '行政驳回';
								} 
								else if ('re3' == val) {
									return '高级驳回';
								} 
								else if ('rd' == val) {
									return '行政审批';
								} 
								else {
									return '其它';
								}
							},
							styler: function(val, row, index){
								if ('d' == val){
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('s' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('ap1' == val || 'ap2' == val || 'rd' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if ('a' == val) {
									return 'background-color:#C6EFCE;color:#006100;';
								} else if ('re1' == val || 're2' == val || 're3' == val) {
									return 'background-color:#FFC7CE;color:#9C0006;';
								} else if ('s' == val) {
									return 'background-color:#ffff99;color:#ff9900;';
								} 
								else {
									return 'background-color:#C6EFCE;color:#006100;';
								} 
							}
						},
						{
							title : '司机姓名',
							field : 'driverId',
							width : 100,
							formatter : formatterListArrayDriver,
							align : 'center',
							editor : {
								type : 'combobox',
								options : {
									data : jsonArrayDriver,
									valueField : 'userId',
									textField : 'displayName',
									required : true,
									editable : false,
								}
							}
						},
							{
								title : '车辆牌照',
								field : 'vehiclePlateNo',
								width : 100,
								align : 'center',
								editor : false,
							},
							{
								field : 'typeExpense',
								title : '计费类别',
								width : 100,
								formatter : formatterListArrayUserInforTypeExpense,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : jsonArrayTypeExpense,
										valueField : "code",
										textField : "name",
										required : false,
										editable : false,
										onChange:function(typeExpense){
											//$('#datagridDetail').datagrid('loadData', { total: 0, rows: [] })
											// 固定金额
											if ('jflb1' == typeExpense) {
												$('div.datagrid-toolbar').eq(1).hide();
											}
											// 公里数
											if ('jflb2' == typeExpense) {
												$('div.datagrid-toolbar').eq(1).show();
									            //var td=$('.datagrid-body td[field="idOrderServicePath"]')[editRow];
											}
											$('#tagTypeExpense').val(typeExpense);
										}
									}
								}
							},
							{
								field : 'idOrderServicePath',
								title : '固定路线',
								width : 100,
								formatter : formatterArrayOrderServicePath,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : jsonArrayOrderServicePath,
										valueField : "id",
										textField : "name",
										required : false,
										editable : false,
										onSelect:function(rec){
											var textSelect = $(this).combobox('getText');
											//var row = $('#datagrid').datagrid('getSelections')[editRow];
											var checkedRows = $('#datagrid').datagrid('getChecked');
											// 计费类别
											var tagTypeExpense = $('#tagTypeExpense').val();
											
											/* String typeExpense = checkedRows[0].typeExpense;
											alert(typeExpense); */
											// 固定金额: jflb1  公里数:jflb2
											if (textSelect != '- -' && 'jflb2' == tagTypeExpense) {
												$.messager.alert(common_dialog_tip, '计费类别为公里数的情况下,不可以选择固定路线!', 'warning');
												$(this).val('- -')
												
											}
											var timeTrip = checkedRows[0].timeTrip;
											var origin = rec.origin;
											var destination = rec.destination;
											// 公里数
											var mileage = rec.mileage;
											$('#datagridDetail').datagrid('loadData', { total: 0, rows: [] })
											$('#datagridDetail').datagrid('insertRow',{
												index: 0,	
												row: { 
													id : '',
													location : origin,
													timeDepart : timeTrip,
													mileageDeparture : mileage,
												}
												});
											var data = $('#datagridDetail').datagrid('getRows');
											var jsonListString = JSON.stringify(data);
											$('#jsonListString').val(jsonListString);
										},
									}
								}
							},
							/* {
								title : '单位',
								field : 'unit',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
									}
								}
							}, */
							{
								field : 'timeHandIn',
								title : '交车时间',
								width : 180,
								align : 'center',
								sortable : true,
								editor : {
									type : 'datetimebox',
									options : {
										required : false,
										editable : false,
									}
								},
							},
							{
								field : 'mileage',
								title : '公里表数',
								width : 100,
								align : 'right',
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,10]',
									}
								}
							},
							{
								field : 'expenseActual',
								title : '实际费用',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,10]',
									}
								}
							},
							{
								title : '通行费',
								field : 'expensePass',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,10]',
									}
								}
							},
							{
								title : '其它费用',
								field : 'expenseOther',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,10]',
									}
								}
							},
							{
								title : '合计',
								field : 'expenseTotal',
								width : 100,
								sortable : true,
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,10]',
									}
								}
							},
							{
								title : '报销日期',
								field : 'timeReimbursement',
								width : 180,
								align : 'center',
								sortable : true,
								editor : {
									type : 'datebox',
									options : {
										required : false,
										editable : false,
									}
								},
							},
						</c:if>
						{
							title : '备注',
							field : 'remark',
							width : 150,
							sortable : true,
							editor : {
								type : 'validatebox',
								options : {
									required : false,
									validType : 'length[1,50]',
								}
							}
						},
						{
							title : '审批备注',
							field : 'remarkApprove',
							width : 150,
							sortable : true,
							styler: function(val, row, index){
									return 'color:red;';
							}
						},
						] ],
						queryParams : {
							action : 'query'
						}, //查询参数
						toolbar : [
						<!-- 订车 o:order, 派车 a:allocatio) -->
						<c:if test="${orderService.tagModule == 'o'}">
								/* 订车模块 */
								{
									text : '添加订车',
									iconCls : 'icon-add',
									handler : function() {
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
										$('#editState').val('i');
										// 选中第一行防止验证bug
										datagrid.datagrid("selectRow",
													0);
									}
								},
								'-',
								{
									text : '修改订车',
									iconCls : 'icon-edit',
									handler : function() {
										//修改时要获取选择到的行
										var rows = datagrid
												.datagrid("getSelections");
										//如果只选择了一行则可以进行修改，否则不操作
										if (rows.length == 1) {
											var statusOrder = rows[0].statusOrder;
											var tagModule = $('#tagModule').val();
											if ('d' != statusOrder && 're1' != statusOrder && 're2' != statusOrder && 'a' != tagModule) {
												$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
												return;
											}
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
								</c:if>
								/* 派车模块 */
								<!-- 订车 o:order, 派车 a:allocatio) -->
								<c:if test="${orderService.tagModule == 'a'}">
								/* {
									text : '添加',
									iconCls : 'icon-add',
									handler : function() {
										$('#form').attr('action', contextPath + '/order/orderService/doEdit.do?editState=i');
										$('#form').form('load', {
											id : '',
											vehiclePlateNo : '',
											jsonListString : '',
											driverId : '',
											deptRequester : '',
											timeTrip : '',
											typeExpense : 'jflb1',
											idOrderServicePath : '',
											expenseActual : '',
											passenger : '',
											customer : '',
											origin : '',
											destination : '',
											type : '',
											editState : 'i',
											remark : '',
										});
										$('#id').val('');
										loadDetailGrid('', 'datagridDetailEdit', false);
										// 默认去掉明细按钮
										changeTypeExpense('jflb1');
										$('#dialog').dialog('setTitle', common_button_add);
										$('#dialog').dialog('open');
									}
								},
								'-', 
								{
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										var checkedRows = $('#datagrid').datagrid('getSelections');
										if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
											return;
										} else if (checkedRows.length > 1) {
											$.messager.alert(common_dialog_tip, '只能同时编辑一条记录', 'warning');
											return;
										}
										var statusOrder = checkedRows[0].statusOrder;
										if ('s' == statusOrder) {
											$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
											return;
										}
										var typeExpense = checkedRows[0].typeExpense;
										changeTypeExpense(typeExpense) 
										$('#form').attr('action', contextPath + '/order/orderService/doEdit.do?editState=u');
										$('#form').form('load', {
											vehiclePlateNo : checkedRows[0].vehiclePlateNo,
											driverId : checkedRows[0].driverId,
											type : checkedRows[0].type,
											deptRequester : checkedRows[0].deptRequester,
											timeTrip : checkedRows[0].timeTrip,
											typeExpense : checkedRows[0].typeExpense,
											idOrderServicePath : checkedRows[0].idOrderServicePath,
											expenseActual : checkedRows[0].expenseActual,
											customer : checkedRows[0].customer,
											passenger : checkedRows[0].passenger,
											origin : checkedRows[0].origin,
											destination : checkedRows[0].destination,
										});
										$('#editState').val('u');
										$('#id').val(checkedRows[0].id);
										loadDetailGrid(checkedRows[0].id, 'datagridDetailEdit', false);
										$('#dialog').dialog('setTitle', 'Edit');
										$('#dialog').dialog('open');
									}
								},*/
								</c:if>
								<!-- 订车 o:order, 派车 a:allocatio) -->
								<c:if test="${orderService.tagModule == 'a' || orderService.tagModule == 'o'}">
								'-',
								{
									text : '保存草稿',
									iconCls : 'icon-save',
									handler : function() {
										// statusOrder	订车状态(d:draft 草稿,s:提交,a:分配)
										tagEditState = 'd';
										//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
										datagrid.datagrid("endEdit",
												editRow);
										if (undefined == editRow) {
											var checkedRows = $('#datagrid').datagrid('getChecked');
											if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
												return;
											}
											if (checkedRows.length > 1) {
												$.messager.alert(common_dialog_tip, '只能同时编辑一条记录', 'warning');
												return;
											}
											var statusOrder = checkedRows[0].statusOrder;
											var tagModule = $('#tagModule').val();
											if (undefined != editRow && 'd' != statusOrder && 'a' != tagModule) {
												$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
												return;
											}
											if ('a' != tagModule && ('s' == statusOrder || 'da' == statusOrder || 'sa' == statusOrder || 'asa' == statusOrder 
													|| 'dia' == statusOrder || 'sia' == statusOrder || 'aia' == statusOrder || 'ap1' == statusOrder || 'ap2' == statusOrder)) {
												$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
												return;
											}
											
											var idOrderService = checkedRows[0].id;
											$.post( contextPath + '/order/orderService/doEdit.do',
													{
														id : idOrderService,
														statusOrder : checkedRows[0].statusOrder,
														tagModule : '${orderService.tagModule}',
														tagEditState : 'd',
														editState : 'u',
														
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														editRow = undefined;
														$.messager
																.show({
																	title : common_dialog_tip,
																	msg : '修改成功',
																	timeout : 2000,
																	showType : 'slide'
																});
														$('#datagrid').datagrid("clearSelections");
													}); 
										}
									}
								}, 
								'-',
								{
									text : '保存提交',
									iconCls : 'icon-save',
									handler : function() {
										// statusOrder	订车状态(d:draft 草稿,s:提交,a:分配)
										tagEditState = 's';
										//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
										datagrid.datagrid("endEdit",
												editRow);
										if (undefined == editRow) {
											var checkedRows = $('#datagrid').datagrid('getChecked');
											if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
												return;
											}
											if (checkedRows.length > 1) {
												$.messager.alert(common_dialog_tip, '只能同时编辑一条记录', 'warning');
												return;
											}
											var statusOrder = checkedRows[0].statusOrder;
											var tagModule = $('#tagModule').val();
											if (undefined != editRow && 'd' != statusOrder && 'a' != tagModule) {
												$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
												return;
											}
											
											if ('a' != tagModule && ('s' == statusOrder || 'da' == statusOrder || 'sa' == statusOrder || 'asa' == statusOrder 
													|| 'dia' == statusOrder || 'sia' == statusOrder || 'aia' == statusOrder || 'ap1' == statusOrder || 'ap2' == statusOrder)) {
												$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
												return;
											}
											
											var idOrderService = checkedRows[0].id;
											
											$.post( contextPath + '/order/orderService/doEdit.do',
													{
														id : idOrderService,
														statusOrder : checkedRows[0].statusOrder,
														tagModule : '${orderService.tagModule}',
														tagEditState : 's',
														editState : 'u',
														
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														editRow = undefined;
														$.messager
																.show({
																	title : common_dialog_tip,
																	msg : '修改成功',
																	timeout : 2000,
																	showType : 'slide'
																});
														$('#datagrid').datagrid("clearSelections");
													}); 
										}
									}
								}, 
								'-', {
									text : '取消编辑',
									iconCls : 'icon-redo',
									handler : function() {
										//取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
										editRow = undefined;
										datagrid.datagrid("rejectChanges");
										datagrid.datagrid("unselectAll");
										$('#editState').val('');
									}
								}, 
								</c:if>
								<c:if test="${orderService.tagModule == 'o'}">
								/* {
									text : '保存草稿',
									iconCls : 'icon-save',
									handler : function() {
										// statusOrder	订车状态(d:draft 草稿,s:提交,a:分配)
										tagEditState = 'd';
										//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
										datagrid.datagrid("endEdit",
												editRow);
									}
								},  */
								'-',
								{
									iconCls: 'ext-icon-table',
									text: '打印派车单',
									handler: function(){
										var checkedRows = $('#datagrid').datagrid('getChecked');
										if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
											return;
										}
										if (checkedRows.length > 1) {
											$.messager.alert(common_dialog_tip, '只能同时编辑一条记录', 'warning');
											return;
										}
										
										var idOrderService = checkedRows[0].id;
										var content = '<iframe src="${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServicePersional.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&idOrderService=' + idOrderService + '" frameborder="0" style="border: 0; width: 100%; height: 100%; display: block"></iframe>';
										top.layout_center_addTab({
											title : formatString('打印派车单', checkedRows.id),
											closable : true,
											iconCls : 'ext-icon-table',
											content : content
										});
										//var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServicePersional.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&idOrderService=" + idOrderService;
										//window.location.href = url;
									}
								},
								'-',
								{
									id: 'statusOrderSa',
									iconCls: 'ext-icon-tick',
									text: '确认派车',
									handler: function(){
										var rows = datagrid.datagrid("getSelections");
										if (rows == null || rows == undefined || rows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
											return;
										}
										var statusOrder = rows[0].statusOrder;
										if('sa' != statusOrder){
											$.messager.alert('<s:message code="common.dialog.tip" />', '只有已派车状态才可确认', 'warning');
											return;
										}
										$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=u&approveStatus=af&tagModule=${orderService.tagModule}',
												{
													id: rows[0].id,
													statusOrder: rows[0].statusOrder,
												},
												function(result) {
													$('#datagrid').datagrid( 'reload');
													$.messager.show({
														title : '<s:message code="common.dialog.tip" />',
														msg : '已确认',
														timeout : 2000,
														showType : 'slide'
													});
													$('#datagrid').datagrid("clearSelections");
												});
									}
								},
								</c:if>
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
																	$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=d',
																			{
																				id : rows[0].id
																			},
																			function(result) {

																				$('#datagrid').datagrid( 'reload');
																				$.messager.show({
																					title : common_dialog_tip,
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
								<c:if test="${orderService.tagModule == 'ap' || orderService.tagModule == 'a'}">
								<c:if test="${comUtil.checkCode('1804002')}">
								'-',
								{
									text : '部门审批',
									iconCls : 'ext-icon-tick',
									handler : function() {
										var rows = datagrid.datagrid("getSelections");
										if (rows == null || rows == undefined || rows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
											return;
										}
										var idString = '';
										for (var i = 0; i < rows.length; i++) {
											if(undefined != rows[i]){
												idString += rows[i].id + ',';
											}
										}
										$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=a&approveStatus=ap1&tagModule=${orderService.tagModule}',
												{
													idString : idString
												},
												function(result) {
													$('#datagrid').datagrid( 'reload');
													$.messager.show({
														title : '<s:message code="common.dialog.tip" />',
														msg : '审批成功',
														timeout : 2000,
														showType : 'slide'
													});
													$('#datagrid').datagrid("clearSelections");
												});
									}
								},
								</c:if>
								<c:if test="${comUtil.checkCode('1804003') || orderService.tagModule == 'a'}">
								{
									text : '行政审批',
									iconCls : 'ext-icon-tick',
									handler : function() {
										var rows = datagrid.datagrid("getSelections");
										if (rows == null || rows == undefined || rows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
											return;
										}
										var idString = '';
										for (var i = 0; i < rows.length; i++) {
											if(undefined != rows[i]){
												idString += rows[i].id + ',';
											}
										}
										$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=a&approveStatus=ap2&tagModule=${orderService.tagModule}',
												{
													idString : idString
												},
												function(result) {
													$('#datagrid').datagrid( 'reload');
													$.messager.show({
														title : '<s:message code="common.dialog.tip" />',
														msg : '审批成功',
														timeout : 2000,
														showType : 'slide'
													});
													$('#datagrid').datagrid("clearSelections");
												});
									}
								},
								</c:if>
								<c:if test="${comUtil.checkCode('1804004')}">
								{
									text : '部门驳回',
									iconCls : 'ext-icon-cross',
									handler : function() {
										var rows = datagrid.datagrid("getSelections");
										if (rows == null || rows == undefined || rows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
											return;
										}
										var idString = '';
										for (var i = 0; i < rows.length; i++) {
											if(undefined != rows[i]){
												idString += rows[i].id + ',';
											}
											
										}
										$.messager.prompt("操作提示", "如有需要请输入驳回原因", function (data) {
											if (undefined != data) {
												$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=a&approveStatus=re1&tagModule=${orderService.tagModule}',
														{
															idString : idString,
															remarkApprove : data,
														},
														function(result) {
															$('#datagrid').datagrid( 'reload');
															$.messager.show({
																title : '<s:message code="common.dialog.tip" />',
																msg : '驳回成功',
																timeout : 2000,
																showType : 'slide'
															});
															$('#datagrid').datagrid("clearSelections");
														});
												}
										});
									}
								},
								'-',
								</c:if>
								<c:if test="${comUtil.checkCode('1804005') || orderService.tagModule == 'a'}">
								{
									text : '行政驳回',
									iconCls : 'ext-icon-cross',
									handler : function() {
										var rows = datagrid.datagrid("getSelections");
										if (rows == null || rows == undefined || rows.length == 0) {
											$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
											return;
										}
										var idString = '';
										for (var i = 0; i < rows.length; i++) {
											if(undefined != rows[i]){
												idString += rows[i].id + ',';
											}
										}
										$.messager.prompt("操作提示", "如有需要请输入驳回原因", function (data) {
											if (undefined != data) {
												$.post('${pageContext.request.contextPath}/order/orderService/doEdit.do?editState=a&approveStatus=re2&tagModule=${orderService.tagModule}',
														{
															idString : idString,
															remarkApprove : data,
														},
														function(result) {
															$('#datagrid').datagrid( 'reload');
															$.messager.show({
																title : '<s:message code="common.dialog.tip" />',
																msg : '驳回成功',
																timeout : 2000,
																showType : 'slide'
															});
															$('#datagrid').datagrid("clearSelections");
														});
												}
										});
									}
								},
								'-',
								</c:if>
								</c:if>
								],
						onAfterEdit : function(rowIndex, rowData, changes) {
							var changes = datagrid.datagrid("getChanges")
							//alert(changes)
							//return;
							//endEdit该方法触发此事件
							console.info(rowData);
							//alert(rowData.name)
							//editRow = undefined;
							//提交后台处理
							//var dayStart = rowData.dayStart;
							//var dayEnd = rowData.dayEnd;
							/* if (dayEnd != '' && dayEnd != null && dayStart != null && (dayEnd <= dayStart)) {
								$.messager.alert(common_dialog_tip, '结束日期不能小于或等于开始日期!', 'warning');
								editRow = undefined;
								return;
							} */
							$.messager.confirm("提示", "确定保存?", function(r) {
								sumitEdit(rowData);
							});
										
							//$.messager.alert(common_dialog_tip, '确定保存?', 'warning');
						},
						onLoadError : function (data) {
							editRow = undefined;
						},
						onLoadSuccess : function (data){
							var tagModule = $('#tagModule').val();
							// 隐藏列
							$('#datagrid').datagrid('selectRow',0);
							if ('o' == tagModule || 'ap' == tagModule) {
								$('div.datagrid-toolbar').eq(1).hide();
								/* $("#datagrid").datagrid('hideColumn', 'vehiclePlateNo');
								$("#datagrid").datagrid('hideColumn', 'driverId'); */
							}
							if ('o' == tagModule){
								// 如果为订车申请状态，根据第一条记录来显隐藏按钮
								var rows = datagrid.datagrid("getSelections");
								var statusOrder = rows[0].statusOrder;
								if('sa' != statusOrder){
									$('#statusOrderSa').hide();
									//$('div.datagrid-toolbar').eq(6).hide();
								}
							}
						},
						onSelect : function(rowIndex, rowData) {
							var tagModule = $('#tagModule').val();
							if (undefined != rowData) {
								var idMain = rowData.id;
								loadDetailGrid(idMain, 'datagridDetail' ,false);
							}
							var checkedRows = $('#datagrid').datagrid('getChecked');
							var typeExpense = checkedRows[0].typeExpense;
							if ('o' == tagModule || 'ap' == tagModule || 'jflb1' == typeExpense) {
								$('div.datagrid-toolbar').eq(1).hide();
							}
							// 如果为已派车的状态，显示确认派车
							if ('o' == tagModule){
								var statusOrder = checkedRows[0].statusOrder;
								if('sa' != statusOrder){
									$('#statusOrderSa').hide();
								} else{
									$('#statusOrderSa').show();
								}						
							}

						},
						onDblClickRow : function(rowIndex, rowData) {
							if (rowData == null || rowData == undefined || rowData.length == 0) {
								return;
							} else if (rowData.length > 1) {
								$.messager.alert(common_dialog_tip, '只能同时编辑一条记录', 'warning');
								return;
							}
							var statusOrder = rowData.statusOrder;
							var tagModule = $('#tagModule').val();
							if ('d' != statusOrder && 're1' != statusOrder && 're2' != statusOrder && 'a' != tagModule) {
								$.messager.alert(common_dialog_tip, '已提交的记录,无法编辑', 'warning');
								return;
							}
							// 取得模块状态
							//双击开启编辑行
							if ('ap' != tagModule) {
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
								$('#editState').val('u');
							}
						}
						/*	if ('a' == tagModule) {
						}*/
					});
}

function sumitEdit(rowData) {
	var typeExpense = rowData.typeExpense;
	// 如何是公里数的情况，需要清空固定路线的值
	var tagModule = $('#tagModule').val();
	var idOrderServicePath = null;
	// 计费类别
	var typeExpense = rowData.typeExpense;
	// 固定金额: jflb1  公里数:jflb2
	if ('a' == tagModule && 'jflb1' == typeExpense) {
		idOrderServicePath = rowData.idOrderServicePath;
		if('' == idOrderServicePath || null == idOrderServicePath){
			$.messager.alert(common_dialog_error, '路线不能为空', 'error');
			$('#datagrid').datagrid("beginEdit", editRow);
			return;
		}
	}
	var updateIdOrderServicePathId = '';
	if ('jflb2' == typeExpense) {
		updateIdOrderServicePathId = 'null';
	}
	$.post( contextPath + '/order/orderService/doEdit.do',
			{
				id : rowData.id,
				idOrderService : rowData.idOrderService,
				deptRequester : rowData.deptRequester,
				vehiclePlateNo : rowData.vehiclePlateNo,
				customer : rowData.customer,
				type : rowData.type,
				userName : rowData.userName,
				timeTrip : rowData.timeTrip + ':00',
				departDate : rowData.departDate,
				departMonth : rowData.departMonth,
				deptRequester : rowData.deptRequester,
				driverId : rowData.driverId,
				typeExpense : typeExpense,
				statusOrder : rowData.statusOrder,
				origin : rowData.origin,
				destination : rowData.destination,
				timeHandIn : rowData.timeHandIn,
				mileage : rowData.mileage,
				expenseActual : rowData.expenseActual,
				expensePass : rowData.expensePass,
				expenseOther : rowData.expenseOther,
				expenseTotal : rowData.expenseTotal,	
				timeReimbursement : rowData.timeReimbursement,
				remark : rowData.remark,
				tagModule : '${orderService.tagModule}',
				tagEditState : tagEditState,
				statusOrder : rowData.statusOrder,
				idOrderServicePath : idOrderServicePath,
				updateIdOrderServicePathId : updateIdOrderServicePathId,
				jsonListString : $('#jsonListString').val(),
				editState : $('#editState').val(),
				
			},
			function(result) {
				$('#datagrid').datagrid( 'reload');
				editRow = undefined;
				$.messager
						.show({
							title : common_dialog_tip,
							msg : '修改成功',
							timeout : 2000,
							showType : 'slide'
						});
			});
	
	editRow = undefined;
}

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order/orderService/searchOrderServiceDetail.js">
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order/orderService/editOrderService.js">
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="title:'<s:message code="common.title.search" />',border:false" style="height: auto;" align="center">
	<input type="hidden" id="tagTypeExpense" />      
		<form id="formSearch">
			<table class="tableForm">
				<input type="hidden" name="tagModule" value="${orderService.tagModule}"/>
				<input type="hidden" id="editStateDetail" />
				<tr>
					<th style="width: 120px;">开始日期: </th>
					<td><input id="searchDateStart" name="searchDateStart" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">结束日期: </th>
					<td><input id="searchDateEnd" name="searchDateEnd" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">部门:  </th>
					<td><select name="customer" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListCustomer.do?tag=d'"></select></td>
				</tr>
				<tr>
					<th style="width: 120px;">客户:  </th>
					<td><select name="customer" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListCustomer.do?tag=c'"></select></td>
					<th width="120px">类别: </th>
					<td><select id="type" name="type" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=yclx'"></select></td>
					<th width="120px">状态: </th>
						<%-- <td><select id="type" name="type" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=yclx'"></select></td> --%>
					<td>
					<select name="statusOrder" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',editable:false">
						<!-- 审批等级(approve:ap1,ap2,reject:re1,submit:s) -->
						<option value="" <c:if test="${orderService.tagModule == 'o'}">selected="selected"</c:if>>全部</option>
						<option value="s" <c:if test="${orderService.tagModule == 'ap' && (comUtil.checkCode('1804002') || comUtil.checkCode('1804003'))}">selected="selected"</c:if>>提交</option>
						<option value="ap1" <c:if test="${orderService.tagModule == 'ap' && comUtil.checkCode('1804003')}">selected="selected"</c:if>>部门审批</option>
						<option value="ap2" <c:if test="${orderService.tagModule == 'ap' && comUtil.checkCode('1605007')}">selected="selected"</c:if>>行政审批</option>
						<option value="ap3">高级审批</option>
						<option value="re1">部门驳回</option>
						<option value="re2">行政驳回</option>
						<option value="re3">高级驳回</option>
					</select>
					</td>
					<%-- <th width="120px">计费类别: </th>
					<td><select id="typeExpense" name="typeExpense" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jflb',"></select></td> --%>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submitSearchForm();" ><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<!-- <div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div> -->
	<div  style="height:350px;">
		<table id="datagrid"  data-options="url:'${pageContext.request.contextPath}/order/orderService/doSearch.do?tagModule=${orderService.tagModule}'"></table>
	</div>
	<div style="height:350px;">
		<table id="datagridDetail"></table>
	</div>
	<jsp:include page="editOrderService.jsp"></jsp:include>
</body>


</html>
