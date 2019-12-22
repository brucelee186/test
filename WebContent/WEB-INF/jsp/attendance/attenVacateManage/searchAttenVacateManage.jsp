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
//对Date的扩展，将 Date 转化为指定格式的String 
//月(M)、日(d)、小时(h)、分(m)、秒(s)、季度(q) 可以用 1-2 个占位符， 
//年(y)可以用 1-4 个占位符，毫秒(S)只能用 1 个占位符(是 1-3 位的数字) 
//例子： 
//(new Date()).Format("yyyy-MM-dd hh:mm:ss.S") ==> 2006-07-02 08:09:04.423 
//(new Date()).Format("yyyy-M-d h:m:s.S")      ==> 2006-7-2 8:9:4.18 
Date.prototype.Format = function(fmt) 
{ //author: meizz 
var o = { 
 "M+" : this.getMonth()+1,                 //月份 
 "d+" : this.getDate(),                    //日 
 "h+" : this.getHours(),                   //小时 
 "m+" : this.getMinutes(),                 //分 
 "s+" : this.getSeconds(),                 //秒 
 "q+" : Math.floor((this.getMonth()+3)/3), //季度 
 "S"  : this.getMilliseconds()             //毫秒 
}; 
if(/(y+)/.test(fmt)) 
 fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
for(var k in o) 
 if(new RegExp("("+ k +")").test(fmt)) 
fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length))); 
return fmt; 
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
								title : '姓名',
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
							{
								title : '工号',
								field : 'cardNo',
								align : 'center',
								width : 80,
								sortable : true,
							}, 
							{
								title : '假别',
								field : 'nameVacate',
								align : 'center',
								width : 80,
								sortable : true,
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
									if(null == val || undefined == val || '' == val) {
										return '其它';
									} else if ('d' == val || 'h' == val) {
										return '天'
									}
								}
							},
							{
								title : '开始时间',
								field : 'dateStart',
								width : 120,
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
								width : 120,
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
								title : '录入时间',
								field : 'addDate',
								align : 'left',
								width : 150,
							},
							{
								title : '审批状态',
								field : 'approveStatus',
								width : 80,
								align : 'center',
								sortable : true,
								formatter : function(val,row,index){
									if ('ap1' == val) {
										return '部门审批';
									} 
									else if ('ap2' == val) {
										return '行政审批';
									} 
									else if ('ap3' == val) {
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
									} else if ('re1' == val || 're2' == val) {
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
							},
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
								<c:if test="${comUtil.checkCode('1605001')}">
									{
										text : '添加',
										iconCls : 'icon-add',
										handler : function() {
											//添加列表的操作按钮添加，修改，删除等
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
										    var d = new Date();
										      var year = d.getFullYear();
										      var month = d.getMonth() + 1; // 记得当前月是要+1的
										      var dt = d.getDate();
										      var today = year + '-' + month + '-' + dt;
										      $('#dateStart').datebox('setValue', today)
										      $('#tr_durationRemain').hide();
										   // 移除假期验证
										  	resetSpecVacate();
											$('#form').attr('action', '${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do');
											$('#form').form('load', {
												editState : 'i',
												id : '',
												idVacate : '',
												idVacateDetail : '',
												duration : '',
												remark : '',
												typeVacateDate : 'd',
												dateStart : '',
												hourStart : '00',
												minuteStart : '00',
												dateEnd : '',
												hourEnd : '00',
												minuteEnd : '00',
												remark : '',
												duration : '',
												durationRemain : '0',
												typeData : 'v',
											});
											// 清空时间显示
											$('#td_duration').text('');
											$('#duration').numberbox('setValue', '');
											// 默认锁定天
											$('#typeVacateDate').combobox({
												disabled : 'disabled'
											});
											$('#typeVacateDate').combobox('setValue','d');
											$('#idVacateDetail').combobox('setValue', '');
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
												$.messager.alert('<s:message code="common.dialog.tip" />', '只能同时编辑一条记录!', 'warning');
												return;
											}
											$('#tagStatus').val('u');
											var row = datagrid.datagrid("getSelected");
											// 审批数据无法修改
											var approveStatus = row.approveStatus;
											if ('ap1' == approveStatus || 'ap2' == approveStatus) {
												$.messager.alert('<s:message code="common.dialog.tip" />', '审批数据无法修改!', 'warning');
												return;
											}
											$('#form').attr('action', '${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do');
											$('#form').form('load', {
												editState : 'u',
												id : row.id,
												idVacate : row.idVacate,
												typeVacateDate : row.typeVacateDate,
												dateStart : row.dateStart,
												hourStart : row.hourStart,
												minuteStart :  row.minuteStart,
												dateEnd : row.dateEnd,
												hourEnd : row.hourEnd,
												minuteEnd : row.minuteEnd,
												duration : row.duration,
												remark : row.remark,
												typeData : 'v',
												optionDirectly : row.optionDirectly,
												remarkCollateral : row.remarkCollateral,
												//idVacateDetail : row.idVacateDetail,
											});
											// 赋值时长单位
											var typeVacateDateTemp = '天';
											/* var typeVacateDate = row.typeVacateDate;
											if ('h' == typeVacateDate) {
												typeVacateDateTemp = '小时'
											} */
											changeSelectVacate(row.idVacate);
											//alert( row.dateEnd)
											$('#idVacateDetail').combobox('setValue', row.idVacateDetail)
											$('#div_typeVacateDate').text(' ' + typeVacateDateTemp);
											$('#dateStart').datebox('setValue', row.dateStart)
											$('#dateEnd').datebox('setValue', row.dateEnd)
											$('#duration').numberbox('setValue', row.duration)
											$('#hourStart').combobox('setValue', row.hourStart)
											$('#hourEnd').combobox('setValue', row.hourEnd)
											$('#minuteStart').combobox('setValue', row.minuteStart)
											$('#minuteEnd').combobox('setValue', row.minuteEnd)
											$('#dialog').dialog('setTitle', '<s:message code="common.button.edit" />');
											$('#dialog').dialog('open');
											$('#tagStatus').val('n');
											$('#optionDirectly').combobox('setValue', row.optionDirectly)
											$('#remarkCollateral').textbox('setValue', row.remarkCollateral)
											// 如果是年假的情况，重新计算可请假天数
											var durationRemain = $('#durationRemain').numberbox('getValue');
											$('#durationRemain').numberbox('setValue', parseFloat(durationRemain) + parseFloat(row.duration));
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
												// 审批数据无法修改
												var approveStatus = rows[0].approveStatus;
												if ('ap1' == approveStatus || 'ap2' == approveStatus) {
													$.messager.alert('<s:message code="common.dialog.tip" />', '审批数据不可删除!', 'warning');
													return;
												}
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
								/* <c:if test="${comUtil.checkCode('1605004')}">
									{
										text : '审批',
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
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=ap1',
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
													});
										}
									},
									'-',
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
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=ap2',
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
													});
										}
									},
									'-',
								</c:if>
								<c:if test="${comUtil.checkCode('1605006')}">
									{
										text : '驳回',
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
											$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do?editState=a&approveStatus=re1',
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
													});
										}
									},
									'-',
								</c:if> */
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
		// 验证
		var validateResult = $('#form').form('validate');
		if (false == validateResult) {
			return;
		}
		
		validateResult = calculateDuration('y');
		if (false == validateResult) {
			return;
		}
	
		// 验证不可提前请假
		/* var dayVacateAhead = $('#dayVacateAhead').val();
		if (dayVacateAhead > 0) {
			var dateStart = $('#dateStart').datebox('getValue');
			var timeStart = new Date(dateStart).Format('yyyy-MM-dd');
			var timeNow = new Date().Format('yyyy-MM-dd');
		      if (timeStart >= timeNow ) {
		    	  $.messager.alert('<s:message code="common.dialog.tip" />',
							'大于两天假期,请提前申请!', 'error');
		    	  return;
			}
		} */
		// 验证年假
		var code = $('#code').val();
		if ('YE' == code) {
			var duration = parseFloat($('#duration').numberbox('getValue'));
			var durationRemain = parseFloat($('#durationRemain').numberbox('getValue'));
			if (duration > durationRemain) {
		    	  $.messager.alert('<s:message code="common.dialog.tip" />',
							'合计时长不可大于可用时长!', 'error');
				return;				
			}
		}
		var editState = $('#editState').val();
		$.post('${pageContext.request.contextPath}/attendance/attenVacateManage/doEdit.do',
				{
					id : $('#id').val(),
					editState : $('#editState').val(),
					idVacate : $('#idVacate').combobox('getValue'),
					nameVacate : $('#idVacate').combobox('getText'),
					idVacateDetail : $('#idVacateDetail').combobox('getValue'),
					nameVacateDetail : $('#idVacateDetail').combobox('getText'),
					typeVacateDate : $('#typeVacateDate').combobox('getValue'),
					dateStart :$('#dateStart').datebox('getValue'),
					hourStart :$('#hourStart').combobox('getValue'),
					minuteStart : $('#minuteStart').combobox('getValue'),
					dateEnd :$('#dateEnd').datebox('getValue'),
					hourEnd :$('#hourEnd').combobox('getValue'),
					minuteEnd : $('#minuteEnd').datebox('getValue'),
					remark : $('#remark').textbox('getValue'),
					typeData : $('#typeData').val(),
					duration : $('#duration').numberbox('getValue'),
					optionDirectly : $('#optionDirectly').combobox('getValue'),
					remarkCollateral : $('#remarkCollateral').textbox('getValue'),
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
						});
	}

	function changeTypeVacateDate(typeVacateType) {
		//var typeVacateType = $('#typeVacateType').combobox('getValue');
		var dateStart = $('#dateStart').datebox('getValue');
		var dateEnd = $('#dateEnd').datebox('getValue');
		if ('h' == typeVacateType) {
			var hourStart = $('#hourStart').combobox('getValue');
			var hourEnd = $('#hourEnd').combobox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
			$('#dateEnd').datebox({
				disabled : 'disabled'
			});
			$('#hourEnd').combobox({
				disabled : false
			});
			/* $('#minuteEnd').combobox({
				disabled : false
			}); */
			$('#hourStart').combobox({
				disabled : false
			});
			/* $('#minuteStart').combobox({
				disabled : false
			}); */
			var dateStart = $('#dateStart').datebox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
			$('#hourStart').combobox('setValue', hourStart);
			$('#hourEnd').combobox('setValue', hourEnd);
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
			/* $('#minuteStart').combobox({
				disabled : 'disabled'
			}); */
			/* $('#minuteEnd').combobox({
				disabled : 'disabled'
			}); */
			$('#dateStart').datebox('setValue', dateStart);
			$('#dateEnd').datebox('setValue', dateEnd);
		}
	}

	function changeDateStart(val) {
		var typeVacateType = $('#typeVacateDate').combobox('getValue');
		if ('h' == typeVacateType) {
			var dateStart = $('#dateStart').datebox('getValue');
			$('#dateEnd').datebox('setValue', dateStart);
		}
		//calculateDuration();
	}

// 计算时长(validate:y 验证, null 不验证)
function calculateDuration(validate) {
	var tagStatus = $('#tagStatus').val();
	if (true) {
		// 清空时长
		var duration = $('#duration').numberbox('getValue');
		if ('y' != validate) {
			$('#duration').numberbox('setValue', '');
		}
		var typeVacateDate = $('#typeVacateDate').combobox('getValue');
		if ('d' == typeVacateDate) {
			var dateStart = $('#dateStart').datebox('getValue');
			var dateEnd = $('#dateEnd').datebox('getValue');
			var hourStart = $('#hourStart').combobox('getValue');
			var hourEnd = $('#hourEnd').combobox('getValue');
			var minuteStart = $('#minuteStart').combobox('getValue');
			var minuteEnd = $('#minuteEnd').combobox('getValue');
			var dateStartTemp = NewDate(dateStart, hourStart, minuteStart, '00');
			var dateEndTemp = NewDate(dateEnd,  hourEnd, minuteEnd, '00');
			var days = parseFloat((dateEndTemp.getTime() - dateStartTemp.getTime()) / 24
					/ 60 / 60 / 1000);
			if ('y' == validate) {
				days = duration;
			}
			if (0 > days && 'y' == validate) {
				$.messager.alert('<s:message code="common.dialog.tip" />',
						'开始日期不能大于或等于结束日期!', 'error');
				return false;
			}
			if (!isNaN(days) && days >= 0) {
				days = days + 1;
				if ('y' == validate) {
					days = duration;
				}
				$('#duration').numberbox('setValue', days);
				$('#div_typeVacateDate').text(" 天");
				var idVacateDetail_validate = $('#idVacateDetail').combobox('getValue');
				// 取得天数与假期子类别比较,并自动赋值
				var arrayData = new Array();
				arrayData = $('#idVacateDetail').combobox('getData');
				var id;
				var dayStart;
				var dayEnd;
				var typeVacateDate;
				var durationRule;
				if (arrayData != null && arrayData.length > 0) {
					for ( var i = 0; i < arrayData.length; i++) {
						var data = arrayData[i];
						id = data.id
						dayStart = data.dayStart;
						dayEnd = data.dayEnd;
						durationRule = data.durationRule;
						if (idVacateDetail_validate == id) {
							break;
						} 
					}
				}
				//$('#idVacateDetail').combobox('select', id);
				// 验证假期不能超过限定时间
				if (parseFloat(days) < parseFloat(dayStart) && 'y' == validate) {
					$.messager.alert('<s:message code="common.dialog.tip" />',
							'请假不可小于最小时长!', 'error');
					return false;
				}
				if (parseFloat(days) > parseFloat(dayEnd) && 'y' == validate) {
					$.messager.alert('<s:message code="common.dialog.tip" />',
							'请假不可超过最大时长!', 'error');
					return false;
				}
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
			// date.setUTCHours( hours[, minutes[, seconds[, milliseconds ]]] )
			/*  var date = new Date(); 
    		date.setUTCFullYear('2015', '11', '20');
			alert(date) */
			var dateStartTemp = NewDate(dateStart, hourStart, minuteStart, '00');
					//+ "00:00");
			var dateEndTemp = NewDate(dateEnd,  hourEnd, minuteEnd, '00');
					//+ "00:00");
			var hours = (dateEndTemp.getTime() - dateStartTemp.getTime()) / 60 / 60 / 1000;
			if (0 >= hours && 'y' == validate) {
				$.messager.alert('<s:message code="common.dialog.tip" />',
						'开始时间不能大于或等于结束时间!', 'error');
				return false;
			}
			if (2 > hours && 'y' == validate) {
				$.messager.alert('<s:message code="common.dialog.tip" />',
						'请假时长请大于等于两小时!', 'error');
				return false;
			}
			if (!isNaN(hours) && hours > 0) {
				if (hours > 10 && 'y' == validate) {
					$.messager.alert('<s:message code="common.dialog.tip" />',
							'按小时申请休假请勿大于8小时!', 'error');
					return false;
				}
				//var hoursRemainder = hours%2;
				/* if (1 == hoursRemainder) {
					hours += 1;
				} */
			
				//hours = hours/8;
				var day = parseFloat(hours)/8;
				if (1 < day) {
					day = 1;
				}
			/* 	if (day > 1) {
					day = 1;
				} */
				$('#duration').numberbox('setValue', day);
				$('#div_typeVacateDate').text(" 天");
			} else {
				$('#duration').val("");
				$('#div_typeVacateDate').text("");
			}
		}
	}
} 


	// 计算合计时长
/* 	function calculateDuration(validate) {
		var tagStatus = $('#tagStatus').val();
		if (true) {
			// 清空时长
			$('#duration').numberbox('setValue', '');
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
					days = parseInt(days) + 1;
					$('#duration').numberbox('setValue', days);
					$('#div_typeVacateDate').text(" 天");
					// 取得天数与假期子类别比较,并自动赋值
					var arrayData = new Array();
					arrayData = $('#idVacateDetail').combobox('getData');
					var id;
					var dayStart;
					var dayEnd;
					var typeVacateDate;
					var durationRule;
					if (arrayData != null && arrayData.length > 0) {
						for ( var i = 0; i < arrayData.length; i++) {
							var data = arrayData[i];
							id = data.id
							dayStart = data.dayStart;
							dayEnd = data.dayEnd;
							durationRule = data.durationRule;
							if (days >= dayStart && days <= dayEnd) {
								break;
							} 
						}
					}
					$('#idVacateDetail').combobox('select', id);
				} else {
					$('#duration').val("");
					$('#div_typeVacateDate').text("");
				}
			} else if ('h' == typeVacateDate) {
				var dateStart = $('#dateStart').datebox('getValue');
				var hourStart = $('#hourStart').combobox('getValue');
				//var minuteStart = $('#minuteStart').combobox('getValue');
				var dateEnd = $('#dateEnd').datebox('getValue');
				var hourEnd = $('#hourEnd').combobox('getValue');
				//var minuteEnd = $('#minuteEnd').combobox('getValue');
				var dateStartTemp = new Date(dateStart + " " + hourStart + ":"
						//+ minuteStart + ":00");
						+ "00:00");
				var dateEndTemp = new Date(dateEnd + " " + hourEnd + ":"
						//+ minuteEnd + ":00");
						+ "00:00");
				var hours = (dateEndTemp.getTime() - dateStartTemp.getTime()) / 60 / 60 / 1000;
				if (0 >= hours && 'y' == validate) {
					$.messager.alert('<s:message code="common.dialog.tip" />',
							'开始时间不能大于或等于结束时间!', 'error');
					return false;
				}
				if (!isNaN(hours) && hours > 0) {
					if (hours > 10) {
						$.messager.alert('<s:message code="common.dialog.tip" />',
								'按小时申请休假请勿大于8小时!', 'error');
						return;
					}
					var hoursRemainder = hours%2;
					if (1 == hoursRemainder) {
						hours += 1;
					}
				
					hours = hours/2;
					var day = hours*0.25;
					if (day > 1) {
						day = 1;
					}
					$('#duration').numberbox('setValue', day);
					$('#div_typeVacateDate').text(" 天");
				} else {
					$('#duration').val("");
					$('#div_typeVacateDate').text("");
				}
			}
		}
	} */
	
	function submit_form() {
		var opt = $('#datagrid').datagrid('options');
		opt.url = '${pageContext.request.contextPath}/attendance/attenVacateManage/doSearch.do?typeData=${attenVacateManage.typeData}';
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
	
function changeSelectVacate(id) {
	// 移除假期验证
	resetSpecVacate();
	// 赋值对应编号的名称
	$('#idVacate').combobox('setValue', id);
	$('#tr_durationRemain').hide();
	// 赋值可用天数
	$('#durationRemain').numberbox('setValue', 0); 
	$('#code').val('');
	$.ajax({
		type:"POST",
		async:false,
		url: '${pageContext.request.contextPath}/attendance/attenVacate/getAttenVacate.do?id=' + id,
		success: function(data) {
			var r = $.parseJSON(data);
			var code = r.obj.code;
			if ('YE' == code) {
				$('#code').val(code);
				$('#tr_durationRemain').show();
				var durationRule = r.obj.durationRule;
				var durationTotal = r.obj.durationTotal;
				var durationRemain = durationRule - durationTotal;
				if (durationRemain <= 0) {
					$('#durationRemain').numberbox('setValue', 0); 
				} else {
					$('#durationRemain').numberbox('setValue', durationRemain); 
				}
			}
		}
  });
	/* var arrayData = new Array();
	arrayData = $('#idVacate').combobox('getData');
	alert(arrayData)
	var durationRule;
	if (arrayData != null && arrayData.length > 0) {
		for ( var i = 0; i < arrayData.length; i++) {
			var data = arrayData[i];
			if (id == data.id) {
				alert(id)
				alert(data)
				alert(data.durationRule)
				dayStart = data.dayStart;
				dayEnd = data.dayEnd;
				durationRule = data.durationRule;
				break;
			}
		}
	}
	alert(durationRule)
	$('#durationRule').numberbox('setValue', durationRule); */
	$('#dayVacateAhead').val('');
	var url = '${pageContext.request.contextPath}/common/droplist/doListAttenVacateDetail.do?tagType=d&pid=' + id;
	$('#idVacateDetail').combobox('clear');
	$('#idVacateDetail').combobox('reload', url);
	
	// 清空选项
	$('#dateStart').datebox('setValue', '');
	$('#hourStart').combobox('setValue', '00');
	$('#minuteStart').combobox('setValue', '00');
	$('#dateEnd').datebox('setValue', '');
	$('#hourEnd').combobox('setValue', '00');
	$('#minuteEnd').combobox('setValue', '00');
}

//移除特殊假期验证
function resetSpecVacate() {
	$('#optionDirectly').combobox({required: false})
	$('#optionDirectly').combobox('setValue', '');
	$('#remarkCollateral').textbox({required: false})
	$('#remarkCollateral').textbox('setValue', '');
	$('#tr_optionDirectly').hide();
	$('#tr_remarkCollateral').hide();
}

function changeSelectVacateDetail(id) {
	// 移除假期验证
	resetSpecVacate();
	var arrayData = new Array();
	arrayData = $('#idVacateDetail').combobox('getData');
	/* var index = $('#idVacateDetail').combobox('getIndex'); 
	alert(index) */
	var dayStart;
	var dayEnd;
	var typeVacateDate;
	var durationRule;
	var code;
	if (arrayData != null && arrayData.length > 0) {
		for ( var i = 0; i < arrayData.length; i++) {
			var data = arrayData[i];
			if (id == data.id) {
				dayStart = data.dayStart;
				dayEnd = data.dayEnd;
				durationRule = data.durationRule;
				code = data.code
				break;
			}
		}
	}
	var combo_hourStart = '00';
	var combo_hourEnd = '00';
	//取得行号
	if (1 == dayEnd) {
		$('#typeVacateDate').combobox({disabled : 'disabled'});
		$('#typeVacateDate').combobox('setValue','h');
		//var typeVacateType = $('#typeVacateType').combobox('getValue');
		/* var dateStart = $('#dateStart').datebox('getValue');
		var dateEnd = $('#dateEnd').datebox('getValue');
		var hourStart = $('#hourStart').combobox('getValue');
		var hourEnd = $('#hourEnd').combobox('getValue');
		var minuteStart = $('#minuteStart').combobox('getValue');
		var minuteStart = $('#minuteEnd').combobox('getValue');
		$('#dateEnd').datebox('setValue', dateStart); */
		$('#dateEnd').datebox({
			disabled : 'disabled'
		});
		$('#hourStart').combobox({
			disabled : false
		});
		$('#hourEnd').combobox({
			disabled : false
		});
		$('#minuteStart').combobox({
			disabled : false
		});
		$('#minuteEnd').combobox({
			disabled : false
		});
		combo_hourStart = '08';
		combo_hourEnd = '18';
		/* var dateStart = $('#dateStart').datebox('getValue');
		$('#dateEnd').datebox('setValue', dateStart);
		$('#hourStart').combobox('setValue', hourStart);
		$('#hourEnd').combobox('setValue', hourEnd); */
		//changeSelectVacateDetail('h');
	} else {
		$('#typeVacateDate').combobox({disabled : 'disabled'});
		$('#typeVacateDate').combobox('setValue','d');
		//changeSelectVacateDetail('d');
		/* var dateStart = $('#dateStart').datebox('getValue');
		var dateEnd = $('#dateEnd').datebox('getValue'); */
		$('#dateStart').datebox({
			disabled : false
		});
		$('#dateEnd').datebox({
			disabled : false
		});
		$('#hourStart').combobox({
			disabled : false
		});
		$('#hourEnd').combobox({
			disabled : false
		});
		$('#minuteStart').combobox({
			disabled : false
		});
		$('#minuteEnd').combobox({
			disabled : false
		});
		/* $('#dateStart').datebox('setValue', dateStart);
		$('#dateEnd').datebox('setValue', dateEnd); */
	}
	//$('#durationRule').textbox('setValue', durationRule);
	// 清空选项
	$('#dateStart').datebox('setValue', '');
	$('#hourStart').combobox('setValue', combo_hourStart);
	$('#minuteStart').combobox('setValue', '00');
	$('#dateEnd').datebox('setValue', '');
	$('#hourEnd').combobox('setValue', combo_hourEnd);
	$('#minuteEnd').combobox('setValue', '00');
	if ('FU-1' == code) {
		$('#tr_optionDirectly').show();
		$('#optionDirectly').combobox({required: true})
	}
	if ('FU-2' == code) {
		$('#tr_remarkCollateral').show();
		$('#remarkCollateral').textbox({required: true})
	}
}

function changeSelectHourStart(val) {
	$('#dayVacateAhead').val('');
	var url = '${pageContext.request.contextPath}/common/droplist/doListAttenVacateList.do?tagType=d&pid=' + val;
	$('#idVacateDetail').combobox('clear');
	$('#idVacateDetail').combobox('reload', url);
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
	opt.url = '${pageContext.request.contextPath}/attendance/attenVacateManage/doSearch.do';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#formSearch')));
}

function resetSearchForm() {
	$('#formSearch').form('load',{
		cardNo : '',
		searchUserName : '',
		divisionId : '',
		searchDateStart : '',
		searchDateEnd : '',
		idVacate : '',
		idVacateSearch : '',
		approveStatus : ''
	});
}	
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 160px;overflow: hidden;" align="center">
		<form id="formSearch">
			<input name="typeData" value="${attenVacateManage.typeData}" type="hidden" />
			<input name="tagPage" value="${attenVacateManage.tagPage}" type="hidden" />
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">员工工号 : </th>
					<td><input name="cardNo" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th style="width: 120px;">员工姓名 : </th>
					<td><input name="searchUserName" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<c:if test="${attenVacateManage.typeData == 'v'}">
						<th>假别 : </th>
						<td><select id="idVacateSearch" name="idVacate" class="easyui-combobox" style="width:200px;" data-options="valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListAttenVacateDetail.do?tagType=m'"></select></td>
					</c:if>
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
						<option value=""></option>
						<option value="s">提交</option>
						<option value="ap1">部门审批</option>
						<option value="ap2">行政审批</option>
						<option value="ap3">高级审批</option>
						<option value="re1">部门驳回</option>
						<option value="re2">行政驳回</option>
						<option value="re3">高级驳回</option>
					</select>
					</td>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submitSearchForm();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="resetSearchForm();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
	<c:if test="${tagPageCode == '1607000'}">
	<jsp:include page="editAttenVacateManage.jsp"></jsp:include>
	</c:if>
	<c:if test="${tagPageCode == '16200100' || tagPageCode == '16200200'}">
	<jsp:include page="editAttenVacateManageOvertime.jsp"></jsp:include>
	</c:if>
</body>

</html>
