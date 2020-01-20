<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search User</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc3.jsp"></jsp:include>
<script type="text/javascript">

//定义全局变量：当前编辑的行
var editRow = undefined; 
//	地点格式化信息
var listArraySigninLocation = '${jsonArraySigninLocation}';
var jsonArraySigninLocation = jQuery.parseJSON(listArraySigninLocation)[0];
function formatterSigninLocation(value, rowData, rowIndex) {
	if('no' == rowData.statusAttendance){
		value = ''
	} 
	return formatterDate(value, rowData, rowIndex, jsonArraySigninLocation, 'code', 'name');
}

//	时间格式化信息
var listArraySigninDate = '${jsonArraySigninDate}';
var jsonArraySigninDate = jQuery.parseJSON(listArraySigninDate)[0];
function formatterSigninDate(value, rowData, rowIndex) {
	if('no' == rowData.statusAttendance){
		value = ''
	} 
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
 
	$(function() {
		$('#datagrid').datagrid({
			fit : true,
			//url :'${pageContext.request.contextPath}/attendance/attendance/doSearch.do?tagSearch=${attendance.tagSearch}&tagPageCode=${tagPageCode}',
			border : true,
			pagination : true,
			idField : 'id',
			pageSize : 20,
			pageList : [ 10, 20, 50, 100, 200 ],
			sortName : 'date',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			striped: true,
			columns : [ [ 
			{
				title : 'ID',
				field : 'Id',
				width : 0,
				sortable : false,
				checkbox : true,
				//hidden : true
			}, 
			{
				title : 'userId',
				hidden : true
			},
			{
				title : '姓名',
				field : 'userName',
				width : 50,
				sortable : true
			},
			{
				title : '部门',
				field : 'divisionName',
				width : 150,
				sortable : true
			},			
			{
				title : '卡号',
				field : 'cardNo',
				width : 80,
				align : 'right',
				sortable : true,
				formatter : function(value, row, index) {
					if (value != null && value != undefined && value != '' && value.length > 0) {
						return '<a href="javascript:void(0);" onclick="show_attendance(' + index + ');">' + value + '</a>';
					} else {
						return '';
					}
				}
			},
			{
				title : '日期',
				field : 'date',
				width : 100,
				align : 'center',
				sortable : true,
			},
			<c:if test="${attendance.tagSearch == 'ab'}">
			{	
				title : '旷工',
				field : 'absenteeism',
				align : 'center',
				width : 50,
				formatter : function(value, row, index) {
					if (value == '1'){
						return '是';
					} 
					else if (value == '0') {
						return '否';
					} 
		 
				},
				styler: function(value, row, index){
					if ("0" == value) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
					
				},
			},
			{
				title : '日期',
				field : 'b_date',
				width : 100,
				align : 'center',
				sortable : true,
			},
			{	
				title : '旷工',
				field : 'b_absenteeism',
				align : 'center',
				width : 50,
				sortable : true,
				formatter : function(value, row, index) {
					if (value == '1'){
						return '是';
					} 
					else if (value == '0') {
						return '否';
					} 
		 
				},
				styler: function(value, row, index){
					if ("0" == value) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
					
				},
			},
			{
				title : '日期',
				field : 'c_date',
				width : 100,
				align : 'center',
				sortable : true,
			},
			{	
				title : '旷工',
				field : 'c_absenteeism',
				width : 50,
				align : 'center',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == '1'){
						return '是';
					} 
					else if (value == '0') {
						return '否';
					} 
		 
				},
				styler: function(value, row, index){
					if ("0" == value) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
					
				},
			},
			
			</c:if>
			/* {	
				title : '考勤编号',
				field : 'id',
				width : 150,
				sortable : true,
			}, */
			{
				title : '考勤日',
				field : 'typeDate',
				width : 60,
				sortable : true,
				align : 'center',
				styler: function(value, row, index){
					if ('f' == row.typeDate){
						return 'background-color:#ccffff;color:#3333ff;';
					}
					else if('w' == row.typeDate && 'a' == row.statusVacate){
						var statusAttendance = row.statusAttendance;
						// 如果为正常,经理审批,行政部审批,那么显示绿色
						if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
							return 'background-color:#C6EFCE;color:#006100;';
						} else {
							var late = row.late
							if (null == value) {
								return 'background-color:#FFC7CE;color:#9C0006;';
							} else{
								if (late == '0'){
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if (late == '1') {
									return 'background-color:#FFC7CE;color:#9C0006;';
								} 
							}
						}
					}
					else if('w' == row.typeDate && 'v' == row.statusVacate){
						return 'background-color:#e7e7f6;color:#3333ff;';
					}
					
				},
				formatter : function(value, row, index) {
					if('a' == row.statusVacate){
						if (value == 'w'){
							return '工作日';
						} 
						else if (value == 'f') {
							return '节假日';
						} 
					} else if('v' == row.statusVacate){
						return '请假';
					}
		 
				},
			},
			{
				title : '签入时间',
				field : 'dayStart',
				align : 'center',
				width : 80,
				sortable : true,
				styler: function(value, row, index){
					// 红
					//return 'background-color:#FFC7CE;color:#9C0006;';
					// 绿
					//return 'background-color:#C6EFCE;color:#006100;';
					if ('f' == row.typeDate){
						//return 'background-color:#ccffcc;color:#3333ff;';
						return 'background-color:#ccffff;color:#3333ff;';
					}
					else if('w' == row.typeDate && 'a' == row.statusVacate){
						var statusAttendance = row.statusAttendance;
						// 如果为正常,经理审批,行政部审批,那么显示绿色
						if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
							return 'background-color:#C6EFCE;color:#006100;';
						} else {
							var late = row.late
							if (null == value) {
								return 'background-color:#FFC7CE;color:#9C0006;';
							} else{
								if (late == '0'){
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if (late == '1') {
									return 'background-color:#FFC7CE;color:#9C0006;';
								} 
							}
						}
					}
					else if('w' == row.typeDate && 'v' == row.statusVacate){
						return 'background-color:#e7e7f6;color:#3333ff;';
					}
					
				},
				formatter : function(value, row, index) {
					if('f' == row.typeDate){
						return '--';
					}
					else if('a' == row.statusVacate && 'w' == row.typeDate){
						var statusAttendance = row.statusAttendance;
						if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
							return '正常';
						} else {
							var late = row.late
							var absenteeism = row.absenteeism;
							if ('0' == late && '1' != absenteeism) {
								return '正常';
							} else {
								return value;
							} 
						}
					} else if('v' == row.statusVacate && 'w' == row.typeDate){
						return '--';
					} 
				}
			},
			{
				title : '签出时间',
				field : 'dayEnd',
				width : 80,
				align : 'center',
				sortable : true	,
				styler: function(value, row, index){
					if ('f' == row.typeDate){
						//return 'background-color:#ccffcc;color:#3333ff;';
						return 'background-color:#ccffff;color:#3333ff;';
					}
					else if('w' == row.typeDate && 'a' == row.statusVacate){
						var statusAttendance = row.statusAttendance;
						if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance) {
							return 'background-color:#C6EFCE;color:#006100;';
						} else {
							var leaveEarly = row.leaveEarly
							if (null == value) {
								return 'background-color:#FFC7CE;color:#9C0006;';
							} else{
								if (leaveEarly == '0'){
									return 'background-color:#C6EFCE;color:#006100;';
								} 
								else if (leaveEarly == '1') {
									return 'background-color:#FFC7CE;color:#9C0006;';
								} 
							}
						}
					} 
					else if('w' == row.typeDate && 'v' == row.statusVacate){
						return 'background-color:#e7e7f6;color:#3333ff;';
					}
				},
				formatter : function(value, row, index) {
					if('f' == row.typeDate){
						return '--';
					}
					else if('a' == row.statusVacate && 'w' == row.typeDate){
						//var typeDate = row.typeDate;
						var statusAttendance = row.statusAttendance;
						if ("no" == statusAttendance || "ap1" == statusAttendance || "ap2" == statusAttendance || 'v' == row.statusVacate) {
							return '正常';
						} else {
							var leaveEarly = row.leaveEarly
							var absenteeism = row.absenteeism;
							if ('0' == leaveEarly && 1 != absenteeism) {
								return '正常';
							} else {
								return value;
							} 
				 		}
					}
					else if('v' == row.statusVacate && 'w' == row.typeDate){
						return '--';
					} 
				}
			},
			/* {	
				title : '迟到',
				field : 'late',
				width : 50,
				align : 'center',
				sortable : true,
			},
			{	
				title : '早退',
				field : 'leaveEarly',
				width : 50,
				align : 'center',
				sortable : true,
			},
			{	
				title : '半勤',
				field : 'attendHalf',
				width : 50,
				align : 'center',
				sortable : true,
			},
			{	
				title : '旷工',
				field : 'absenteeism',
				width : 50,
				align : 'center',
				sortable : true,
			}, */
			{
				title : '考勤状态',
				field : 'statusAttendance',
				width : 60,
				align : 'center',
				sortable : true	,
				formatter : function(value, row, index) {
					if('f' == row.typeDate){
						return '正常';
					}
					else if('a' == row.statusVacate && 'w' == row.typeDate){
						if (value == 'no'){
							return '正常';
						} 
						else if (value == 'ap1') {
							return '部门审批';
						}  
						else if (value == 'ap2') {
							return '行政审批';
						}  
						else if (value == 're1') {
							return '部门驳回';
						}  
						else if (value == 're2') {
							return '行政驳回';
						}  
						else if (value == 'ns' && 'a' == row.statusVacate) {
							return '未补签';
						}  
						else if (value == 'ns' && 'v' == row.statusVacate) {
							return '正常';
						}  
						else if (value == 're') {
							return '已补签';
						}  
					}
					else if('v' == row.statusVacate && 'w' == row.typeDate){
						return '正常';
					} 
				},
				styler: function(value, row, index){
					 if ('f' == row.typeDate){
						 return 'background-color:#ccffff;color:#3333ff;';
					} else if('w' == row.typeDate && 'a' == row.statusVacate){
						if (value == 'no'){
							return 'background-color:#C6EFCE;color:#006100;';
						} 
						else if (value == 're') {
							return 'background-color:#FFEB9C;color:#ff9900;';
						} 
						else if (value == 'le') {
							return 'background-color:#ffff99;color:#ff9900;';
						} 
						else if (value == 'la') {
							return 'background-color:#ffff99;color:#ff9900;';
						} 
						else if (value == 'lale') {
							return 'background-color:#ffff99;color:#ff9900;';
						}
						else if (value == 'ab') {
							return 'background-color:#ffff99;color:#ff9900;';
						}
						else if (value == 'ap1') {
							return 'background-color:#C6EFCE;color:#006100;';
						}
						else if (value == 'ap2') {
							return 'background-color:#C6EFCE;color:#006100;';
						}
						else if (value == 're1') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						} 
						else if (value == 're2') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						} 
						else if (value == 'ns') {
							return 'background-color:#ffff99;color:#ff9900;';
						} 
					} else if('w' == row.typeDate && 'v' == row.statusVacate){
                        return 'background-color:#e7e7f6;color:#3333ff;';
                    }
				}
			},
			<c:if test="${tagPageCode != '1619000'}">
				{
					field : 'signinLocation',
					title : '地点',
					width : 300,
					align : 'left',
					//hidden : true,
					formatter : formatterSigninLocation ,
					editor : {
						type : 'combobox',
						options : {
							data : jsonArraySigninLocation ,
							valueField : "code",
							textField : "name",
							required : true,
							editable : false,
						}
					}
				},
				{
					field : 'signinDate',
					title : '时间',
					width : 100,
					//hidden : true,
					align : 'center',
					formatter : formatterSigninDate ,
					editor : {
						type : 'combobox',
						options : {
							data : jsonArraySigninDate,
							valueField : "code",
							textField : "name",
							required : true,
							editable : false,
						}
					}
				},
				{	
				title : '备注',  
				field : 'remark',    
				align : 'left',   
				width : 212,  
				editor : {
					type : 'textbox',
					options : {
						required : true,
						editable : true,
						validType : 'length[1,25]',
					}
				},				
				formatter : function(value, row, index) {
					if('no' == row.statusAttendance){
						return '';
					} else {
						return value;
					}
				}
				},
				</c:if>
			<c:if test="${tagPageCode == '1619000'}">
				{	
				title : '备注',  
				field : 'remark',    
				align : 'left',   
				width : 212,  
				editor : {
					type : 'textbox',
					options : {
						required : true,
						editable : true,
						validType : 'length[1,25]',
					}
				},					
 				formatter : function(value, row, index) {
					var statusAttendance = row.statusAttendance;
					var tagRecheck = row.tagRecheck;
					var str = '';
					if (value == null) {
						value = '';
					}
						if (statusAttendance == 'ns' || statusAttendance == 're' || statusAttendance == 're1' || statusAttendance == 're2' ) {
							str = '<input id="remark' + index + '" type="text" value="' + value + '" style="width:200px;" />';
						}
						else {
							str = value;
						}
					return str;
				
			}, 
			},
				{	
					title : '操作',  
					field : 'addIp',       
					width : 50,  
					formatter : function(value, row, index) {
						//$("#datagrid").datagrid("beginEdit", index);
						var tagRecheck = row.tagRecheck;
						var tagAdjust = row.tagAdjust;
						var button = '确认';
						if('y' == tagAdjust){
							button = '撤销';
						}
						var str = '';
							var statusAttendance = row.statusAttendance;
							if (statusAttendance == 'ns' || statusAttendance == 're' || statusAttendance == 're1' || statusAttendance == 're2' || 'y' == tagAdjust) {
								str = '<input id="input_opt_' + index + '" type="button" value="'+ button +'" required="true" onclick="reCheckin(' + index + ')" />';
								//$("#datagrid").datagrid("beginEdit", index);
								//editRow = index;
							str += '';
						}
						return str;
					}
				},
			</c:if>
			<c:if test="${attendance.tagSearch == 're' || attendance.tagSearch == 'ap1'}">
				{	
					title : '操作',  
					field : 'addIp',       
					width : 50,  
					formatter : function(value, row, index) {
						$("#datagrid").datagrid("beginEdit", index);
						var tagRecheck = row.tagRecheck;
						var str = '';
						if ('en' == tagRecheck) {
							var statusAttendance = row.statusAttendance;
							//if (statusAttendance == 'ns' || statusAttendance == 'la' || statusAttendance == 'lale' || statusAttendance == 're1' || statusAttendance == 're2' || statusAttendance == 'ns') {
							if (statusAttendance == 'ns' || statusAttendance == 're1' || statusAttendance == 're2' ) {
								str = '<input id="input_opt_' + index + '" type="button" value="补签" required="true" onclick="reCheckin(' + index + ')" />';
								//$("#datagrid").datagrid("beginEdit", index);
								//editRow = index;
							}
							str += '';
						}
						return str;
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
				},
			</c:if>
		
		]],
		onLoadError : function (data) {
		},
		onLoadSuccess : function(data) {
			var rows = $('#datagrid').datagrid('getRows');
			for ( var i = 0; i < rows.length; i++) {
				var row = rows[i];
				var statusAttendance = row.statusAttendance;
				var tagRecheck = row.tagRecheck;
				var tagPageCode = '${tagPageCode}';
				if (('en' == tagRecheck || '1619000' == tagPageCode) && (statusAttendance == 'ns' || statusAttendance == 're1' || statusAttendance == 're2' ) ) {
					$("#datagrid").datagrid("beginEdit", i);
				}
			}
		},
			/* onDblClickRow : function(rowIndex, rowData) {
				//alert('double')
				//双击开启编辑行
				if (editRow != undefined) {
					$("#datagrid").datagrid("endEdit", editRow);
				}
				if (editRow == undefined) {
					$("#datagrid").datagrid("beginEdit", rowIndex);
					editRow = rowIndex;
				}
				editRow = undefined;
			}, */
			toolbar : [
				<c:if test="${attendance.tagSearch == 'ap1' || attendance.tagSearch == 'ap2'}">
					{
						iconCls : 'ext-icon-tick',
						text : '审批',
						handler : function() {
							var rows = $('#datagrid').datagrid('getChecked');
							var arrayId = '';
							for (var i = 0; i < rows.length; i++) {
								arrayId += rows[i].id + ',';
							}
							$.post('${pageContext.request.contextPath}/attendance/attendance/reCheckin.do?tagSearch=${attendance.tagSearch}', {arrayId : arrayId}, function(result){
								$('#datagrid').datagrid('reload');
								$.messager.show({
									title:'<s:message code="common.dialog.tip" />',
									msg:'审批成功',
									timeout:5000,
									showType:'slide'
								});
							});
						}
					},'-',
					{
						iconCls : 'ext-icon-cross',
						text : '驳回',
						handler : function() {
							var rows = $('#datagrid').datagrid('getChecked');
							var arrayId = '';
							for (var i = 0; i < rows.length; i++) {
								arrayId += rows[i].id + ',';
							}
							var tagSearch = '${attendance.tagSearch}';
							if ('ap1' == tagSearch) {
								tagSearch = 're1';
							} else if ('ap2' == tagSearch) {
								tagSearch = 're2';
							}
								
							$.post('${pageContext.request.contextPath}/attendance/attendance/reCheckin.do?tagSearch=' + tagSearch, {arrayId : arrayId}, function(result){
								$('#datagrid').datagrid('reload');
								$.messager.show({
									title:'<s:message code="common.dialog.tip" />',
									msg:'驳回成功',
									timeout:5000,
									showType:'slide'
								});
							});
						}
					},'-',
				</c:if>
			],
		});

		$('#combotree_division').combotree({
			url : '${pageContext.request.contextPath}/common/common/doListPermissionDivision.do',
			valueField : 'divisionId',
			textField : 'divisionName',
			parentField : 'pid',
			panelWidth : '200',
			editable : false,
			lines : true
		});
		
		// 加载列表
		var tagPageCode = '${tagPageCode}';
		if('1619000' != tagPageCode){
			submit_form();
		}
	});

//格式化日期格式

function formattime(val) {
	var time = new Date(val);
	var year = time.getFullYear();
	var month = (parseInt(time.getMonth()) + 1);
	month = month > 9 ? month : ('0' + month);
	var day = parseInt(time.getDate());
	day = day > 9 ? day : ('0' + day);
	return year + '/' + month + '/' + day;

}

function reCheckin(index) {
	$('#datagrid').datagrid("endEdit", index);
	var row = $('#datagrid').datagrid('getRows')[index];
	var signinDate = row.signinDate;
	var signinLocation = row.signinLocation;
	var remark = row.remark;
	var tagPageCode = '${tagPageCode}';
	var tagAdjust = row.tagAdjust;
	if('1619000' != tagPageCode){
		if (null == signinDate || null == signinLocation || null == remark) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '请填写完整补签信息', 'warning');
			$('#datagrid').datagrid("beginEdit", index);
			return;
		}
	}
	else{
		if (null == remark) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '请填写完整补签信息', 'warning');
			$('#datagrid').datagrid("beginEdit", index);
			return;
		}
	}
	var id = row.id;
	//$('#datagrid').datagrid("beginEdit", index);
	//$('#datagrid').datagrid('showColumn','signinLocation');
	//$('#datagrid').datagrid('showColumn','signinDate');
	//alert('double')
	//双击开启编辑行
	/* if (editRow != undefined) {
		$("#datagrid").datagrid("endEdit", editRow);
	}
	if (editRow == undefined) {
		editRow = index;
	} */
	$.post('${pageContext.request.contextPath}/attendance/attendance/reCheckin.do?tagSearch=re&tagPageCode=${tagPageCode}', 
			{
			id : id, 
			signinDate : signinDate, 
			signinLocation : signinLocation,
			tagAdjust : tagAdjust, 
			remark : remark,
			 },
		function(result){
			$('#datagrid').datagrid('reload');
			$.messager.show({
				title:'<s:message code="common.dialog.tip" />',
				msg:'补签成功',
				timeout:2000,
				showType:'slide'
			});
	});
}

function submit_form() {
	var opt = $('#datagrid').datagrid('options');
	opt.url = '${pageContext.request.contextPath}/attendance/attendance/doSearch.do?tagSearch=${attendance.tagSearch}&tagPageCode=${tagPageCode}';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#form')));
}

function reset_form() {
	$('#form').form('clear');
}

function show_attendance(index){
	var rows = $('#datagrid').datagrid('getRows');
	var row = rows[index];
	var userName = row.userName;
	var date = row.date;
	var cardNo = row.cardNo;
	var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceUserDayForSignIn.cpt' + '&serverIp=${pageContext.request.contextPath}&date=' + date + '&cardNo='+ cardNo;
	var content = formatString('<iframe src="' + url + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', '');
	top.layout_center_addTab({
		title : formatString('日考勤记录', ''),
		closable : true,
		iconCls : 'ext-icon-user_edit',
		content : content
	});
}

	// 回车事件
	function submitForm(event){
		  if(event.keyCode==13){
			event.target.blur();
			submit_form();
         }
	}	
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false" onkeydown="submitForm(event);">
	<div
		data-options="region:'north',title:'<s:message code="common.title.search" />',border:false"
		style="height: 135px;overflow: hidden;" align="center">
		<form id="form">
			<table class="tableForm">
			<c:if test="${tagPageCode == '1619000'}">
				<tr>
					<th style="width: 120px;">员工工号 : </th>
					<td><input name="cardNo" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th style="width: 120px;">员工姓名 : </th>
					<td><input name="searchUserName" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th style="width: 120px;">部门 : </th>
					<td><select id="divisionId" name="divisionId" class="easyui-combobox" style="width:200px;" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListDivisionByPermission.do'"></select></td>
				</tr>			
			</c:if>
				<tr>
					<th style="width: 120px;">开始日期 :</th>
					<td><input name="dateStart" value="${dateStart}" style="width: 200px;"
						class="easyui-datebox" data-options="editable:false" /></td>
					<th style="width: 120px;">结束日期 :</th>
					<td><input name="dateEnd" value="${dateEnd}" style="width: 200px;"
						class="easyui-datebox" data-options="editable:false" /></td>
				</tr>
				<tr>
					<c:if test="${attendance.tagSearch == 'ap2'}">
						<%-- <th>考勤状态 : </th>
						<td>
							<select name="statusAttendance" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',editable:false">
								<option value="no">正常</option>
								<option value="re" <c:if test="${attendance.tagSearch == 'ap1'}">selected="selected"</c:if>>已补签</option>
								<option value="le">早退</option>
								<option value="la">迟到</option>
								<option value="ab">旷工</option>
								<option value="ap1" <c:if test="${attendance.tagSearch == 'ap2'}">selected="selected"</c:if>>经理审批</option>
								<option value="ap2" >人事审批</option>
							</select>
						</td> --%>
					</c:if>
					<c:if
						test="${attendance.tagSearch == 'ap1' || attendance.tagSearch == 'ap2'}">
						<th>部门 :</th>
						<td><input id="combotree_division" class="easyui-combobox"
							name="divisionId" style="width:200px;"
							data-options="editable: false" /></td>
					</c:if>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton"
					data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message
						code="common.button.search" /></a> <a href="javascript:void(0);"
					class="easyui-linkbutton" data-options="iconCls:'icon-cancel'"
					onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
</body>

</html>
