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
//地点格式化信息
var listArraySigninLocation = '${jsonArraySigninLocation}';
var jsonArraySigninLocation = jQuery.parseJSON(listArraySigninLocation)[0];
function formatterSigninLocation(value, rowData, rowIndex) {
	return formatterDate(value, rowData, rowIndex, jsonArraySigninLocation, 'code', 'name');
}

//	时间格式化信息
var listArraySigninDate = '${jsonArraySigninDate}';
var jsonArraySigninDate = jQuery.parseJSON(listArraySigninDate)[0];
function formatterSigninDate(value, rowData, rowIndex) {
	return formatterDate(value, rowData, rowIndex, jsonArraySigninDate, 'code', 'name');
}
 
// JSON formatter
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
 
 
 
function submitSearchForm() {
	var searchDateStart = $('#searchDateStart').datebox('getValue');
	var searchDateEnd = $('#searchDateEnd').datebox('getValue');
	if (searchDateStart != null && searchDateEnd != null) {
		var calDateStart = new Date(searchDateStart);
		var calDateEnd = new Date(searchDateEnd);
		if (calDateEnd < calDateStart) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '开始时间不能大于结束时间!', 'warning');
			return;
		}
	}
	var opt = $('#datagrid').datagrid('options');
	opt.url = '${pageContext.request.contextPath}/attendance/attenVacateManage/doSearch.do?tagPageCode=${tagPageCode}';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#formSearch')));
	$('#datagrid').datagrid("clearSelections");
}

function approveDetail() {

}

	$(function() {

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
		var comboUnit = [ 
		{
			"value" : "h",
			"text" : "小时"
		}, 
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
		var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.datagrid(
						{
							url : null, //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 30, //页大小
							pageList : [ 15, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowap : true, //列内容多时自动折至第二行
							border : true,
							idField : 'id', //主键
							singleSelect : false,
							sortName : 'modifiedDate',
							sortOrder : 'desc',
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
								title : '申请人',
								field : 'userName',
								width : 50,
								sortable : true,
							}, 
							{
								title : '部门',
								field : 'divisionName',
								width : 150,
								sortable : true,
							}, 
							<c:if test="${tagPageCode == '16200300'}">
							{
								title : '姓名',
								field : 'userNameList',
								width : 230,
								sortable : true,
								formatter: function (value,row,index) {
									var userNameList = '';
									if(value != null && value.length > 0){
									var userArray = value.split(',');
									for (var i = 0; i < userArray.length; i++) {
										
										if(i != 0 && i%5==0){
											userNameList += userArray[i] + '</br>'
										} 
										else if(i != (userArray.length - 1)){
											userNameList += userArray[i] + ', ';
										}
										else{
											userNameList += userArray[i];
										}
										}
									}
								    return '<div style="width=250px;word-break:break-all; word-wrap:break-word;white-space:pre-wrap;">'+userNameList+'</div>';
								}
							},
							</c:if>				
							<c:if test="${tagPageCode != '16200300'}">		
							{
								title : '工号',
								field : 'cardNo',
								align : 'center',
								width : 80,
								sortable : true,
							},
							</c:if>	 
							<c:if test="${attenVacateManage.typeData == 'a'}">
							{
								title : '日期',
								field : 'date',
								width : 150,
								sortable : true,
							},
							{
								title : '考勤日',
								field : 'typeDate',
								width : 150,
								sortable : true,
								formatter : function(value, row, index) {
									if (value == 'w'){
										return '工作日';
									} 
									else if (value == 'f') {
										return '节假日';
									} 
								},
							},
							{
								title : '签入时间',
								field : 'dayStart',
								width : 100,
								sortable : true,
								styler: function(value, row, index){
									var statusAttendance = row.statusAttendance;
									if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
										return 'background-color:#C6EFCE;color:#006100;';
									} else {
										var late = row.late
										if (late == '0'){
											return 'background-color:#C6EFCE;color:#006100;';
										} 
										else if (late == '1') {
											return 'background-color:#FFC7CE;color:#9C0006;';
										} 
									}
									
								},
								formatter : function(value, row, index) {
									var statusAttendance = row.statusAttendance;
									if ("no" == statusAttendance) {
										return '';
									} else {
										return value;
									}
								},
							},
							{
								title : '签出时间',
								field : 'dayEnd',
								width : 100,
								sortable : true	,
								styler: function(value, row, index){
									var statusAttendance = row.statusAttendance;
									if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
										return 'background-color:#C6EFCE;color:#006100;';
									} else {
										var leaveEarly = row.leaveEarly
										if (leaveEarly == '0'){
											return 'background-color:#C6EFCE;color:#006100;';
										} 
										else if (leaveEarly == '1') {
											return 'background-color:#FFC7CE;color:#9C0006;';
										} 
									}
								},
								formatter : function(value, row, index) {
									var statusAttendance = row.statusAttendance;
									if ("no" == statusAttendance) {
										return '';
									} else {
										return value;
									}
								},
							},
							</c:if>
							<c:if test="${attenVacateManage.typeData == 'v'}">
							{
								title : '考勤类型',
								field : 'nameVacate',
								align : 'center',
								width : 80,
								sortable : true,
							}, 
							<c:if test="${tagPageCode == '16200300'}">
							{
								title : '工作时段',
								field : 'rangeArea',
								align : 'center',
								width : 100,
								sortable : true,
								formatter : function(val,row,index){
									return val;
								}
							}, 							
							</c:if>
							{
								title : '开始时间',
								field : 'dateStart',
								width : 110,
								sortable : true,
								formatter : function(val,row,index){
									var typeVacateDate = row.typeVacateDate;
									var dateStart = row.dateStart;
									var hourStart = row.hourStart;
									var minuteStart = row.minuteStart;
									return dateStart + " " + hourStart + ":" + minuteStart;
									/* if ('d' == typeVacateDate) {
										return val;
									} else if ('h' == typeVacateDate) {
									} */
								}
							},
							{
								title : '结束时间',
								field : 'dateEnd',
								width : 110,
								sortable : true,
								formatter : function(val,row,index){
									var typeVacateDate = row.typeVacateDate;
									var dateEnd = row.dateEnd;
									var hourEnd = row.hourEnd;
									var minuteEnd = row.minuteEnd;
									return dateEnd + " " + hourEnd + ":" + minuteEnd;
									/* if ('d' == typeVacateDate) {
										return val;
									} else if ('h' == typeVacateDate) {
									} */
								}
							},							
							{
								title : '时长',
								field : 'duration',
								align : 'center',
								width : 50,
								sortable : true,
							}, 
							{
								title : '单位',
								field : 'typeVacateDate',
								width : 50,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									var typeData = row.typeData;
									if ('od' == typeData || 'op' == typeData) {
										return '小时'
									}
									else if ('d' == val || 'h' == val) {
										return '天'
									}  
									else if(null == val || undefined == val || '' == val) {
										return '其它';
									}
								}
							},
							</c:if>
							{
								title : '录入时间',
								field : 'addDate',
								align : 'left',
								width : 125,
							},
							<c:if test="${tagPageCode == '16200300'}">
							{
								title : '加班原因',
								field : 'remarkText',
								align : 'left',
								width : 180,
								sortable : true,
							}, 							
							</c:if>
							{
								title : '审批状态',
								field : 'approveStatus',
								width : 80,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									if ('ap1' == val) {
										return '部门审批';
									} else if ('ap2' == val) {
										return '行政审批';
									} else if ('ap3' == val) {
										return '高级审批';
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
									if ('ap1' == val){
										return 'background-color:#C6EFCE;color:#006100;';
									} else if ('ap2' == val) {
										return 'background-color:#C6EFCE;color:#006100;';
									} else if ('ap3' == val) {
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
								title : '审批时间',
								field : 'approveDate',
								align : 'left',
								width : 125,
							},
							<c:if test="${attenVacateManage.typeData == 'v'}">
							{
								title : '进度',
								field : 'tagCreateOverwork',
								width : 80,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									if ('y' == val) {
										return '已完成';
									} else {
										return '处理中';
									}
								},
								styler: function(val, row, index){
									if ('y' == val){
										return 'background-color:#C6EFCE;color:#006100;';
									} else {
										return 'background-color:#ffff99;color:#ff9900;';return 'background-color:#C6EFCE;color:#006100;';
									}
								}
							},
							{
								title : '邮件提醒',
								field : 'tagEmail',
								width : 80,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									if ('s' == val) {
										return '已发送';
									} else {
										return '未发送';
									}
								},
								styler: function(val, row, index){
									if ('s' == val){
										return 'background-color:#ffff99;color:#ff9900;';
									} else {
										return 'background-color:#C6EFCE;color:#006100;';
									}
								}
							},
							{
								title : '备注',
								field : 'remark',
								align : 'left',
								width : 250,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
									}
								}
							},
							{
								title : '审批备注',
								field : 'remarkReject',
								align : 'left',
								width : 250,
								styler: function(val, row, index){
									return 'color:red;';
								}
							</c:if>
							<c:if test="${attenVacateManage.typeData == 'a'}">
							{
								field : 'signinLocation',
								title : '地点',
								width : 300,
								align : 'left',
								//hidden : true,
								formatter : formatterSigninLocation ,
							},
							{
								field : 'signinDate',
								title : '时间',
								width : 100,
								//hidden : true,
								align : 'center',
								formatter : formatterSigninDate ,
							},	
							{
								title : '备注',
								field : 'remarkAtten',
								align : 'left',
								width : 250,
								editor : {
									type : 'validatebox',
									options : {
										validType : 'length[1,20]',
									}
								}
							},
							{
								title : '审批备注',
								field : 'remarkReject',
								align : 'left',
								width : 250,
								styler: function(val, row, index){
									return 'color:red;';
								}
							</c:if>
							},
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
								<c:if test="${attenVacateManage.tagPage == 'i'}">
									<c:if test="${comUtil.checkCode('1605001')}">
										{
											text : '添加',
											iconCls : 'icon-add',
											handler : function() {//添加列表的操作按钮添加，修改，删除等
												/* //添加时先判断是否有开启编辑的行，如果有则把开户编辑的那行结束编辑
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
												} */
												$('#form').attr('action', '${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do');
												$('#form').form('load', {
													editState : 'i',
													id : '',
													typeVacateDate : 'd',
													dateStart : '',
													hourStart : '00',
													minuteStart : '00',
													dateEnd : '',
													hourEnd : '00',
													minuteEnd : '00',
													remark : '',
												});
												// 清空时间显示
												$('#td_duration').text('');
												$('#dialog').dialog('setTitle', '<s:message code="common.button.add" />');
												$('#dialog').dialog('open');
											}
										},
										'-',
									</c:if>
									<c:if test="${comUtil.checkCode('1605002')}">
										{
											text : '修改',
											iconCls : 'icon-edit',
											handler : function() {
												var checkedRows = $('#datagrid').datagrid('getSelections');
												if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
													return;
												} else if (checkedRows.length > 1) {
													$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录', 'warning');
													return;
												}
												var row = datagrid.datagrid("getSelected");
												$('#form').attr('action', '${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do');
												$('#form').form('load', {
													editState : 'u',
													id : row.id,
													typeVacateDate : row.typeVacateDate,
													dateStart : row.dateStart,
													hourStart : row.hourStart,
													minuteStart : row.minuteStart,
													dateEnd : row.dateEnd,
													hourEnd : row.hourEnd,
													minuteEnd : row.minuteEnd,
													duration : row.duration,
													remark : row.remark,
												});
												// 赋值时长单位
												var typeVacateDateTemp = '天';
												var typeVacateDate = row.typeVacateDate;
												if ('h' == typeVacateDate) {
													typeVacateDateTemp = '小时'
												}
												$('#div_typeVacateDate').text(' ' + typeVacateDateTemp);
												$('#dialog').dialog('setTitle', '<s:message code="common.button.add" />');
												$('#dialog').dialog('open');
											}
										},
										'-',
									</c:if>
									<c:if test="${comUtil.checkCode('1605003')}">
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
																			$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=d',
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
																						datagrid.datagrid("clearSelections");
																					});
																		}
																	});
												} else {
													$.messager.alert("提示",
															"请选择要删除的单条记录!", "error");
												}
											}
										},
										'-',
									</c:if>
								</c:if>
								<c:if test="${attenVacateManage.typeData == 'v'}">
								<c:if test="${comUtil.checkCode('1605004')}">
									{
										text : '部门审批',
										iconCls : 'ext-icon-tick',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + '-' + rows[i].typeVacateDate + ',';
											}
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=ap1&typeData=${attenVacateManage.typeData}&tagPageCode=${tagPageCode}',
													{
														arrayVatateId : arrayVatateId
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														$.messager.show({
															title : '<s:message code="common.dialog.tip" />',
															msg : '审批成功',
															timeout : 2000,
															showType : 'slide'
														});
														datagrid.datagrid("clearSelections");
													});
										}
									},
									'-',
								</c:if>
								</c:if>
								<c:if test="${comUtil.checkCode('1605005')}">
									{
										text : '行政审批',
										iconCls : 'ext-icon-tick',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + '-' + rows[i].typeVacateDate + ',';
											}
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=ap2&typeData=${attenVacateManage.typeData}&tagPageCode=${tagPageCode}',
													{
														arrayVatateId : arrayVatateId
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														$.messager.show({
															title : '<s:message code="common.dialog.tip" />',
															msg : '审批成功',
															timeout : 2000,
															showType : 'slide'
														});
														datagrid.datagrid("clearSelections");
													});
										}
									},
									'-',
								</c:if>
								<c:if test="${comUtil.checkCode('1605007')}">
									{
										text : '高级审批',
										iconCls : 'ext-icon-tick',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + '-' + rows[i].typeVacateDate + ',';
											}
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=ap3&typeData=${attenVacateManage.typeData}&tagPageCode=${tagPageCode}',
													{
														arrayVatateId : arrayVatateId
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														$.messager.show({
															title : '<s:message code="common.dialog.tip" />',
															msg : '审批成功',
															timeout : 2000,
															showType : 'slide'
														});
														datagrid.datagrid("clearSelections");
													});
										}
									},
									'-',
								</c:if>
								<c:if test="${attenVacateManage.typeData == 'v'}">
								<c:if test="${comUtil.checkCode('1605006')}">
									{
										text : '部门驳回',
										iconCls : 'ext-icon-cross',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + ',';
											}
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=re1&typeData=${attenVacateManage.typeData}&tagPageCode=${tagPageCode}',
													{
														arrayVatateId : arrayVatateId
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														$.messager.show({
															title : '<s:message code="common.dialog.tip" />',
															msg : '驳回成功',
															timeout : 2000,
															showType : 'slide'
														});
														datagrid.datagrid("clearSelections");
													});
										}
									},
									'-',
								</c:if>
								</c:if>
								<c:if test="${comUtil.checkCode('1605008')}">
									{
										text : '行政驳回',
										iconCls : 'ext-icon-cross',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var remarkReject;
											$.messager.prompt("操作提示", "如有需要请输入驳回原因", function (data) {
												if (undefined != data) {
										            remarkReject = data;
										        	var arrayVatateId = '';
										        	for (var i = 0; i < rows.length; i++) {
										        		arrayVatateId += rows[i].id + ',';
										        	}
										        	$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=re2&typeData=${attenVacateManage.typeData}&tagPageCode=${tagPageCode}',
										        			{
										        				arrayVatateId : arrayVatateId,
										        				remarkReject : remarkReject,
										        			},
										        			function(result) {
										        				$('#datagrid').datagrid( 'reload');
										        				$.messager.show({
										        					title : '<s:message code="common.dialog.tip" />',
										        					msg : '驳回成功',
										        					timeout : 2000,
										        					showType : 'slide'
										        				});
										        				datagrid.datagrid("clearSelections");
										        			});
												}
											     });
										}
									},
									'-',
									<c:if test="${tagPageCode == '1606000'}">
									<c:if test="${attenVacateManage.typeData == 'v'}">
									{
										text : '发送高管邮件',
										iconCls : 'ext-icon-tick',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											var tagEamilSended = false;
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + ',';
												if ('s' == rows[i].tagEmail) {
													tagEamilSended = true;
												}
											}
											if (tagEamilSended) {
												$.messager.confirm("操作提示", "已有发送过的邮件,确定要重新发送吗", function (data) {
													if (data) {
														$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doSendMail.do',
																{
																	arrayVatateId : arrayVatateId
																},
																function(result) {
																	var r = $.parseJSON(result);
																	var success = r.success;
																	if (r.success) {
																		$('#datagrid').datagrid( 'reload');
																		$.messager.show({
																			title : '<s:message code="common.dialog.tip" />',
																			msg : '发送成功',
																			timeout : 2000,
																			showType : 'slide'
																		});
																		datagrid.datagrid("clearSelections");
																	}
																	else {
																		$.messager.alert('<s:message code="common.dialog.tip" />', r.msg, 'warning');
																		return;
																	}
																	
																});
											          
													} 
												     });
											} else {
												$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doSendMail.do',
														{
															arrayVatateId : arrayVatateId
														},
														function(result) {
															var r = $.parseJSON(result);
															var success = r.success;
															if (r.success) {
																$('#datagrid').datagrid( 'reload');
																$.messager.show({
																	title : '<s:message code="common.dialog.tip" />',
																	msg : '发送成功',
																	timeout : 2000,
																	showType : 'slide'
																});
																datagrid.datagrid("clearSelections");
															}
															else {
																$.messager.alert('<s:message code="common.dialog.tip" />', r.msg, 'warning');
																return;
															}
															
														});
											}
										}
									},
									'-',									
								</c:if>
								</c:if>
								</c:if>
								<c:if test="${comUtil.checkCode('1602004')}">
									{
										text : '确认驳回',
										iconCls : 'ext-icon-cross',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var remarkReject;
											$.messager.prompt("操作提示", "确认驳回将不可再次补签,如有需要请输入驳回原因,确定要驳回吗", function (data) {
												if (undefined != data) {
										            remarkReject = data;
										        	var arrayVatateId = '';
										        	for (var i = 0; i < rows.length; i++) {
										        		arrayVatateId += rows[i].id + ',';
										        	}
										        	$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=re4&typeData=${attenVacateManage.typeData}',
										        			{
										        				arrayVatateId : arrayVatateId,
										        				remarkReject : remarkReject,
										        			},
										        			function(result) {
										        				$('#datagrid').datagrid( 'reload');
										        				$.messager.show({
										        					title : '<s:message code="common.dialog.tip" />',
										        					msg : '驳回成功',
										        					timeout : 2000,
										        					showType : 'slide'
										        				});
										        				datagrid.datagrid("clearSelections");
										        			});
												} 
											     });
										}
									},
									'-',
								</c:if>
								<c:if test="${comUtil.checkCode('1605009')}">
									{
										text : '高级驳回',
										iconCls : 'ext-icon-cross',
										handler : function() {
											var rows = datagrid.datagrid("getSelections");
											if (rows == null || rows == undefined || rows.length == 0) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '请选择一条记录', 'warning');
												return;
											}
											var arrayVatateId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayVatateId += rows[i].id + ',';
											}
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=re3&typeData=${attenVacateManage.typeData}',
													{
														arrayVatateId : arrayVatateId
													},
													function(result) {
														$('#datagrid').datagrid( 'reload');
														$.messager.show({
															title : '<s:message code="common.dialog.tip" />',
															msg : '驳回成功',
															timeout : 2000,
															showType : 'slide'
														});
														datagrid.datagrid("clearSelections");
													});
										}
									},
									'-',
								</c:if>
									/* '-',
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
									}, '-' */ ],
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
								if (dayEnd != '' && dayEnd != null && dayStart != null && (dayEnd <= dayStart)) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '结束日期不能小于或等于开始日期!', 'warning');
									editRow = undefined;
									return;
								}
								$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=u',
									{
										id : rowData.id,
										name : rowData.name,
										duration : rowData.duration,
										unit : rowData.unit,
										proportion : rowData.proportion,
										remark : rowData.remark,
									},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : '<s:message code="common.dialog.tip" />',
													msg : '添加成功',
													timeout : 2000,
													showType : 'slide'
												});
										$('#datagrid').datagrid("clearSelections");
									});
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							/* onDblClickRow : function(rowIndex, rowData) {
								//alert('double')
								//双击开启编辑行
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
							} */
						});
		
		submitSearchForm();
	});

	function submitForm() {
		var validateResult = calculateDuration('y');
		if (false == validateResult) {
			return;
		}
		var editState = $('#editState').val();
		$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do',
				{
					id : $('#id').val(),
					editState : $('#editState').val(),
					idVacate : $('#idVacate').combobox('getValue'),
					typeVacateDate : $('#typeVacateDate').combobox('getValue'),
					dateStart :$('#dateStart').datebox('getValue'),
					hourStart :$('#hourStart').combobox('getValue'),
					minuteStart :$('#minuteStart').combobox('getValue'),
					dateEnd :$('#dateEnd').datebox('getValue'),
					hourEnd :$('#hourEnd').combobox('getValue'),
					minuteEnd :$('#minuteEnd').combobox('getValue'),
					remark : $('#remark').textbox('getValue'),
					duration : $('#duration').val(),
				},
				function(result) {
					$('#dialog').dialog('close');
					$('#datagrid').datagrid( 'reload');
					var msg = '操作完成!';
					if ('i' == editState) {
						msg = '添加成功!';
					}
					else if ('u' == editState) {
						msg = '修改成功!';
					}
							editRow = undefined;
							$.messager
									.show({
										title : '<s:message code="common.dialog.tip" />',
										msg : msg,
										timeout : 2000,
										showType : 'slide'
									});
							$('#datagrid').datagrid("clearSelections");
						});
	}

	function changeTypeVacateDate(typeVacateType) {
		if ('h' == typeVacateType) {
			var dateStart = $('#dateStart').datebox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
			$('#dateEnd').datebox({
				disabled : 'disabled'
			});
			$('#hourEnd').combobox({
				disabled : false
			});
			$('#minuteEnd').combobox({
				disabled : false
			});
			$('#hourStart').combobox({
				disabled : false
			});
			$('#minuteStart').combobox({
				disabled : false
			});
			var dateStart = $('#dateStart').datebox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
		} else if ('d' == typeVacateType) {
			$('#dateStart').datebox({
				disabled : false
			});
			$('#dateEnd').datebox({
				disabled : false
			});
			$('#hourStart').combobox({
				disabled : 'disabled'
			});
			$('#hourEnd').combobox({
				disabled : 'disabled'
			});
			$('#minuteStart').combobox({
				disabled : 'disabled'
			});
			$('#minuteEnd').combobox({
				disabled : 'disabled'
			});
		}
	}

	function changeDateStart(val) {
		var typeVacateType = $('#typeVacateDate').combobox('getValue');
		if ('h' == typeVacateType) {
			var dateStart = $('#dateStart').datebox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
		}
		calculateDuration();
	}

	function calculateDuration(validate) {
		var typeVacateDate = $('#typeVacateDate').combobox('getValue');
		if ('d' == typeVacateDate) {
			var dateStart = $('#dateStart').datebox('getValue');
			var dateEnd = $('#dateEnd').datebox('getValue');
			var dateStartTemp = new Date(dateStart);
			var dateEndTemp = new Date(dateEnd);
			var days = (dateEndTemp.getTime() - dateStartTemp.getTime()) / 24
					/ 60 / 60 / 1000;
			if (0 > days && 'y' == validate) {
				$.messager.alert('<s:message code="common.dialog.tip" />',
						'开始日期不能大于或等于结束日期!', 'error');
				return false;
			}
			if (!isNaN(days) && days >= 0) {
				$('#duration').numberbox('setValue', parseInt(days) + 1);
				$('#div_typeVacateDate').text(" 天");
			} else {
				$('#duration').val("");
				$('#div_typeVacateDate').text("");
			}
		} else if ('h' == typeVacateDate) {
			var dateStart = $('#dateStart').datebox('getValue');
			var hourStart = $('#hourStart').combobox('getValue');
			var minuteStart = $('#minuteStart').combobox('getValue');
			var dateEnd = $('#dateEnd').datebox('getValue');
			var hourEnd = $('#hourEnd').combobox('getValue');
			var minuteEnd = $('#minuteEnd').combobox('getValue');
			var dateStartTemp = new Date(dateStart + " " + hourStart + ":"
					+ minuteStart + ":00");
			var dateEndTemp = new Date(dateEnd + " " + hourEnd + ":"
					+ minuteEnd + ":00");
			var hours = (dateEndTemp.getTime() - dateStartTemp.getTime()) / 60 / 60 / 1000;
			if (0 >= hours && 'y' == validate) {
				$.messager.alert('<s:message code="common.dialog.tip" />',
						'开始时间不能大于或等于结束时间!', 'error');
				return false;
			}
			if (!isNaN(hours) && hours > 0) {
				$('#duration').numberbox('setValue', hours);
				$('#div_typeVacateDate').text(" 小时");
			} else {
				$('#duration').val("");
				$('#div_typeVacateDate').text("");
			}
		}
	}
	

	function resetSearchForm() {
		$('#formSearch').form('load',{
			cardNo : '',
			searchUserName : '',
			divisionId : '',
			searchDateStart : '',
			searchDateEnd : '',
			idVacate : '',
			approveStatus : ''
		});
	}	
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="<c:if test="${attenVacateManage.typeData == 'v'}">height: 160px;</c:if><c:if test="${attenVacateManage.typeData == 'a'}">height: 130px;</c:if>overflow: hidden;" align="center">
		<form id="formSearch" >
			<input name="typeData" value="${attenVacateManage.typeData}" type="hidden" />
			<input name="tagPage" value="${attenVacateManage.tagPage}" type="hidden" />
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">员工工号 : </th>
					<td><input name="cardNo" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th style="width: 120px;">员工姓名 : </th>
					<td><input name="searchUserName" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th style="width: 120px;">部门 : </th>
					<td><select id="divisionId" name="divisionId" class="easyui-combobox" style="width:200px;" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListDivisionByPermission.do'"></select></td>
				</tr>
				<tr>
					<th style="width: 120px;">开始日期 : </th>
					<td><input id="searchDateStart" name="searchDateStart" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">结束日期 : </th>
					<td><input id="searchDateEnd" name="searchDateEnd" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th>审批状态 : </th>
					<td>
					<select name="approveStatus" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',editable:false">
						<!-- 审批等级(approve:ap1,ap2,reject:re1,submit:s) -->
						<option value="">全部</option>
						<option value="s" <c:if test="${comUtil.checkCode('1605004') || comUtil.checkCode('1602003')}">selected="selected"</c:if>>提交</option>
						<option value="ap1" <c:if test="${comUtil.checkCode('1605005') && !comUtil.checkCode('1602003')}">selected="selected"</c:if>>部门审批</option>
						<option value="ap2" <c:if test="${comUtil.checkCode('1605007')}">selected="selected"</c:if>>行政审批</option>
						<option value="ap3">高级审批</option>
						<option value="re1">部门驳回</option>
						<option value="re2">行政驳回</option>
						<option value="re3">高级驳回</option>
					</select>
					</td>
				</tr>
				<c:if test="${attenVacateManage.typeData == 'v'}">
					<tr>
						<th>假别 : </th>
						<td><select id="idVacate" name="idVacate" class="easyui-combobox" style="width:200px;" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListAttenVacate.do'"></select></td>
					</tr>
				</c:if>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submitSearchForm();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="resetSearchForm();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid" data-options="url:'${pageContext.request.contextPath}/attendance/attenVacateManage/doSearch.do?tagPageCode=${tagPageCode}'"></table>
	</div>
	<%-- <jsp:include page="editAttenVacateManage.jsp"></jsp:include> --%>
</body>

</html>
