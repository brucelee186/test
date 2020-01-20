

// 	客户格式化信息
var jsonArrayDivision = jQuery.parseJSON(listArrayDivision)[0];
 function formatterListArrayDivision(value, rowData, rowIndex) {
	 return formatterDate(value, rowData, rowIndex, jsonArrayDivision, 'id', 'name');
}
 
// 	部门格式化信息
 var jsonArrayDivisionDep = jQuery.parseJSON(listArrayDivisionDep)[0];
 function formatterListArrayDivisionDep(value, rowData, rowIndex) {
	 return formatterDate(value, rowData, rowIndex, jsonArrayDivisionDep, 'id', 'name');
 }
 
// id,name形式的formatter
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

// 	司机信息格式化信息

var jsonArrayDriver = jQuery.parseJSON(listArrayDriver)[0];
 function formatterListArrayDriver(value, rowData, rowIndex) {
	 return formatterDate(value, rowData, rowIndex, jsonArrayDriver, 'userId', 'displayName');
}
 
// 用车类别格式化信息

var jsonArrayUserInfor = jQuery.parseJSON(listArrayUserInfor)[0];
 function formatterListArrayUserInforType(value, rowData, rowIndex) {
	 return formatterDate(value, rowData, rowIndex, jsonArrayUserInfor, 'code', 'name');
}
 
// 用计费别格式化信息

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
					} else {
						$.messager.alert(common_dialog_error, r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert(common_dialog_error, result, 'error');
				}
			}
		});
		//loadDetailGrid();
	});
	
	function loadGrid() {
		
		var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.datagrid(
						{
							url : contextPath + '/order/orderService/doSearch.do?tagModule=' + $('#tagModule').val(), //请求的数据源
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
							{
								title : '部门',
								field : 'deptRequester',
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
								width : 100,
								formatter : formatterListArrayDivision,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : jsonArrayDivision,
										valueField : "id",
										textField : "name",
										required : true,
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
								/*editor : {
									type : 'validatebox',
									options : {
										required : true,
										validType : 'length[1,10]',
									}
								}*/
							},
							{
								title : '出发时间',
								field : 'timeTrip',
								width : 100,
								align : 'center',
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
								title : '车辆牌照',
								field : 'vehiclePlateNo',
								width : 100,
								formatter : formatterListArrayDriver,
								align : 'center',
								editor : {
									type : 'validatebox',
									options : {
										required : false,
										validType : 'length[1,20]',
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
								field : 'typeExpense',
								title : '计费类别',
								width : 100,
								formatter : formatterListArrayUserInforTypeExpense,
								align : 'center',
								/*editor : {
									type : 'combobox',
									options : {
										data : jsonArrayTypeExpense,
										valueField : "code",
										textField : "name",
										required : true,
										editable : false,
									}
								}*/
							},
							{
								title : '状态',
								field : 'statusOrder',
								width : 80,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									if ('d' == val) {
										return '草稿';
									} else if ('s' == val) {
										return '提交';
									} else if ('a' == val) {
										return '已派车';
									}
									else if ('re1' == val) {
										return '部门驳回';
									} else if ('re2' == val) {
										return '行政驳回';
									} else if ('re3' == val) {
										return '高级驳回';
									} 
									else if ('s' == val) {
										return '提交';
									} else {
										return '其它';
									}
								},
								styler: function(val, row, index){
									if ('d' == val){
										return 'background-color:#C6EFCE;color:#006100;';
									} else if ('s' == val) {
										return 'background-color:#C6EFCE;color:#006100;';
									} else if ('a' == val) {
										return 'background-color:#C6EFCE;color:#006100;';
									} else if ('re1' == val || 're2' == val || 're3' == val) {
										return 'background-color:#FFC7CE;color:#9C0006;';
									} else if ('s' == val) {
										return 'background-color:#ffff99;color:#ff9900;';
									} 
									else {
										return 'background-color:#ffff99;color:#ff9900;';
									} 
								}
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
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
									{
										text : '添加申请',
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

										}
									},
									{
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
											$('#id').val(checkedRows[0].id);
											loadDetailGrid(checkedRows[0].id, 'datagridDetailEdit', false);
											$('#dialog').dialog('setTitle', 'Edit');
											$('#dialog').dialog('open');
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
									$.messager.alert(common_dialog_tip, '结束日期不能小于或等于开始日期!', 'warning');
									editRow = undefined;
									return;
								} */
								$.post( contextPath + '/order/orderService/doEdit.do?editState=u',
									{
										id : rowData.id,
										vehiclePlateNo : rowData.vehiclePlateNo,
										driverId : rowData.driverId,
										unit : rowData.unit,	
										proportion : rowData.proportion,
										remark : rowData.remark,
										tag : rowData.tag,
										code : rowData.code,
										tagTimeOff : rowData.tagTimeOff,
										tagInstead : rowData.tagInstead,
										approveLevel : rowData.approveLevel,
										dayVacateAhead : rowData.dayVacateAhead,
										tagProve : rowData.tagProve,
										tagBreakOff : rowData.tagBreakOff,
										tagType : 'm',
										tagModule : 'a',
										statusOrder : 'a',
										
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
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							onLoadSuccess : function (data){
								// 隐藏列
								$('#datagrid').datagrid('selectRow',0);
								if ('o' == tagModule) {
									$('div.datagrid-toolbar').eq(1).hide();
									$("#datagrid").datagrid('hideColumn', 'vehiclePlateNo');
									$("#datagrid").datagrid('hideColumn', 'driverId');
								}
								
							},
							onSelect : function(rowIndex, rowData) {
								var idMain = rowData.id;
								loadDetailGrid(idMain, 'datagridDetail' ,false);
								$('div.datagrid-toolbar').eq(1).hide();
							},
							onDblClickRow : function(rowIndex, rowData) {
								// 取得模块状态
								var tagModule = $('#tagModule').val();
								//双击开启编辑行
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
							}
							/*	if ('a' == tagModule) {
							}*/
						});
	}
	
