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
	var listAttenDay = '${jsonListAttenDay}';
	var jsonListAttenDay = jQuery.parseJSON(listAttenDay)[0];
	
	function attenDayormatter(value, rowData, rowIndex) {
			if (value == 0) {
				return;
			}

			for ( var i = 0; i < jsonListAttenDay.length; i++) {
				if (jsonListAttenDay[i].id == value) {
					return jsonListAttenDay[i].name;
				}
			}
	}
	function unitformatterLoop(value, rowData, rowIndex) {
			if (value == 0) {
				return;
			}

			for ( var i = 0; i < comboLoop.length; i++) {
				if (comboLoop[i].value == value) {
					return comboLoop[i].text;
				}
			}
	}
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
		
		var comboLoop = [ {
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
							url : '${pageContext.request.contextPath}/attendance/attenRule/doSearch.do', //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							pageSize : 15, //页大小
							pageList : [ 15, 30, 45, 60 ], //页大小下拉选项此项各value是pageSize的倍数
							fit : true, //datagrid自适应宽度
							fitColumn : false, //列自适应宽度
							striped : true, //行背景交换
							nowrap : true, //列内容多时自动折至第二行
							border : true,
							idField : 'id', //主键
							singleSelect : true,
							rownumbers : true,
							frozenColumns : [ [//显示的列
					         	{
									title : 'ID',
									field : 'id',
									width : 0,
									rowspan : 2,
									sortable : false,
									checkbox : true,
								//hidden : true
								}, 
								{
									title : '规则',
									field : 'name',
									width : 150,
									rowspan : 2,
									align : 'center',
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
									field : 'tagAttendance',
									title : '是否记录考勤',
									width : 100,
									formatter : unitformatterLoop,
									rowspan : 2,
									align : 'center',
									editor : {
										type : 'combobox',
										options : {
											data : comboLoop,
											valueField : "value",
											textField : "text",
											required : true,
											editable : false,
										}
									}
								}, 
								{
									field : 'tagDefault',
									title : '是否为默认考勤规则',
									width : 120,
									formatter : unitformatterLoop,
									rowspan : 2,
									align : 'center',
									editor : {
										type : 'combobox',
										options : {
											data : comboLoop,
											valueField : "value",
											textField : "text",
											required : true,
											editable : false,
										}
									}
								}, 
								/* {
									title : '起始时间',
									field : 'dayStart',
									width : 150,
									rowspan : 2,
									align : 'center',
									sortable : true,
									editor : {
										type : 'datetimebox',
										options : {
											required : true,
											editable : false,
										}
									},
								}, 
								{
									title : '结束时间',
									field : 'dayEnd',
									width : 150,
									rowspan : 2,
									align : 'center',
									sortable : true,
									editor : {
										type : 'datetimebox',
										options : {
											editable : true,
										}
									},
								}, */
								{
									title : '工作日',
									width : 150,
									rowspan : 1,
									colspan : 14,
									align : 'center',
									sortable : true,
								},
							],[
							
							
							{
								title : '周一',
								field : 'dayOfWeek2',
								width : 100,
								sortable : true,
								formatter: function (value) {
				                    if (String(value) == "2") {
				                        return '工作日';
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '2'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 2,
								        off: ' '
								    }
								}
							},
							{
								title : '周一时段',
								field : 'time2',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周二',
								field : 'dayOfWeek3',
								width : 100,
								sortable : true,
								formatter: function (value) {  
				                    if (String(value) == "3") {  
				                        return '工作日';  
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '3'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 3,
								        off: ' '
								    }
								}
							},
							{
								title : '周二时段',
								field : 'time3',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周三',
								field : 'dayOfWeek4',
								width : 100,
								sortable : true,
								formatter: function (value) {  
				                    if (String(value) == "4") {  
				                        return '工作日';  
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '4'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 4,
								        off: ' '
								    }
								}
							},
							{
								title : '周三时段',
								field : 'time4',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周四',
								field : 'dayOfWeek5',
								width : 100,
								sortable : true,
								formatter: function (value) {  
				                    if (String(value) == "5") {  
				                        return '工作日';  
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '5'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 5,
								        off: ' '
								    }
								}
							},
							{
								title : '周四时段',
								field : 'time5',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周五',
								field : 'dayOfWeek6',
								width : 100,
								sortable : true,
								formatter: function (value) {  
				                    if (String(value) == "6") {  
				                        return '工作日';  
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '6'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 6,
								        off: ' '
								    }
								}
							},
							{
								title : '周五时段',
								field : 'time6',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周六',
								field : 'dayOfWeek7',
								width : 100,
								sortable : true,
								formatter: function (value) {  
				                    if (String(value) == "7") {  
				                        return '工作日';  
				                    }  
				                },
				                styler: function(value, row, index){
									if (value == '7'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 7,
								        off: ' '
								    }
								}
							},
							{
								title : '周六时段',
								field : 'time7',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
							{
								title : '周日',
								field : 'dayOfWeek1',
								width : 100,
								rowspan : 1,
								sortable : true,
								formatter: function (value) {
				                    if (String(value) == '1') {
				                        return '工作日';  
				                    }  
				                },
								styler: function(value, row, index){
									if (value == '1'){
										return 'background-color:#C6EFCE;color:#006100;';
									} 
								},
								editor: {
								    type: 'checkbox',
								    options: {
								        on: 1,
								        off: ' '
								    }
								}
							},
							{
								title : '周日时段',
								field : 'time1',
								width : 100,
								sortable : true,
								formatter : attenDayormatter,
								editor : {
									type : 'combobox',
									options : {
										data : jsonListAttenDay,
										valueField : "id",
										textField : "name",
										
										editable : false,
									}
								}
							},
						/* 	{
								field : 'typeDate',
								title : '类型',
								width : 100,
								formatter : unitformatter,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : comboTypeDate,
										valueField : "value",
										textField : "text",
										required : true,
										editable : false,
									}
								}
							}, 
							{
								field : 'loopYear',
								title : '按年循环',
								width : 100,
								formatter : unitformatterLoop,
								align : 'center',
								editor : {
									type : 'combobox',
									options : {
										data : comboLoop,
										valueField : "value",
										textField : "text",
										required : true,
										editable : false,
									}
								}
							}, */
					
							/* {
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
							},  */
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
																		$.post('${pageContext.request.contextPath}/attendance/attenRule/doEdit.do?editState=d',
																				{
																					id: rows[0].id
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
									}, '-', 
									{
										text : '取消编辑',
										iconCls : 'icon-redo',
										handler : function() {
											//取消当前编辑行把当前编辑行罢undefined回滚改变的数据,取消选择的行
											editRow = undefined;
											datagrid.datagrid("rejectChanges");
											datagrid.datagrid("unselectAll");
										}
									}, '-',
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
								var dayStart = rowData.dayStart;
								var dayEnd = rowData.dayEnd;
								if (dayEnd != null && dayStart != null && (dayEnd < dayStart)) {
									$.messager.alert('<s:message code="common.dialog.tip" />', '结束日期不能小于开始日期!', 'warning');
									editRow = undefined;
									return;
								}
								$.post('${pageContext.request.contextPath}/attendance/attenRule/doEdit.do?editState=u',
									{
										id : rowData.id,
										name : rowData.name,
										dayStartString : rowData.dayStart,
										dayEndString : rowData.dayEnd,
										dayOfWeek1 : rowData.dayOfWeek1,
										dayOfWeek2 : rowData.dayOfWeek2,
										dayOfWeek3 : rowData.dayOfWeek3,
										dayOfWeek4 : rowData.dayOfWeek4,
										dayOfWeek5 : rowData.dayOfWeek5,
										dayOfWeek6 : rowData.dayOfWeek6,
										dayOfWeek7 : rowData.dayOfWeek7,
										time1 : rowData.time1,
										time2 : rowData.time2,
										time3 : rowData.time3,
										time4 : rowData.time4,
										time5 : rowData.time5,
										time6 : rowData.time6,
										time7 : rowData.time7,
										tagAttendance : rowData.tagAttendance,
										tagDefault : rowData.tagDefault,
										//remark : rowData.remark,
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
	
function collectDateFun(tagEmail) {
	var collectDate = $('#collectDate').datebox('getValue');
	$.post('${pageContext.request.contextPath}/attendance/attenRule/doAttenCollect.do?tagEmail=' + tagEmail,
			{collectDate : collectDate},
			function(result) {
				editRow = undefined;
				/* $.messager.show({
					title : '<s:message code="common.dialog.tip" />',
					msg : '采集成功',
					timeout : 2000,
					showType : 'slide'
				}); */
				$.messager.alert('<s:message code="common.dialog.tip" />', '采集成功(' + collectDate + ')!', 'warning');
		}
	);
}
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
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 135px;overflow: hidden;" align="center">
		<form id="form">
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">采集日期 : </th>
					<td><input id="collectDate" name="collectDate" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="collectDateFun('y');">采集并发送邮件</a> </td>
					<td><a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="collectDateFun('n');">采集不发送邮件</a> </td>
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
