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
		$('#datagrid').datagrid({
			fit : true,
			//url :'${pageContext.request.contextPath}/attendance/attendance/doSearch.do?tagSearch=${attendance.tagSearch}',
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
				width : 150,
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
				width : 100,
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
				width : 150,
				sortable : true,
			},
			{	
				title : '考勤编号',
				field : 'id',
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
					// 红
					//return 'background-color:#FFC7CE;color:#9C0006;';
					// 绿
					//return 'background-color:#C6EFCE;color:#006100;';
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
					/* var typeDate = row.typeDate;
					if ('f' == typeDate) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else {
						var late = row.late
						if (late == '0'){
							return 'background-color:#C6EFCE;color:#006100;';
						} 
						else if (late == '1') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						} 
						else if (late == '2') {
							return 'background-color:#ffff99;color:#ff9900;';
						} 
						else if (late == '3') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
						else if (late == 'ns') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
					} */
					
				},
				formatter : function(value, row, index) {
					//var typeDate = row.typeDate;
					var statusAttendance = row.statusAttendance;
					if ("no" == statusAttendance) {
						return '';
					} else {
						return value;
					}
					/* if ('f' == typeDate) {
						return '';
					} else {
						if (value != 'ns') {
							return value;
						} else {
							return '未打卡';
						}
					} */
				},
			},
			{
				title : '签出时间',
				field : 'dayEnd',
				width : 100,
				sortable : true	,
				styler: function(value, row, index){
					// 红
					//return 'background-color:#FFC7CE;color:#9C0006;';
					// 绿
					//return 'background-color:#C6EFCE;color:#006100;';
					/* var statusAttendance = row.statusAttendance;
					if ("no" != statusAttendance) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					} else {
						var leaveEarly = row.leaveEarly
						if (leaveEarly == '0'){
							return 'background-color:#FFC7CE;color:#9C0006;';
						} 
						else if (leaveEarly == '1') {
							return 'background-color:#C6EFCE;color:#006100;';
						} 
					} */
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
					/* var typeDate = row.typeDate;
					if ('f' == typeDate) {
						return 'background-color:#C6EFCE;color:#006100;';
					} else {
						var leaveEarly = row.leaveEarly
						if (leaveEarly == '0'){
							return 'background-color:#C6EFCE;color:#006100;';
						} 
						else if (leaveEarly == '1') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						} 
						else if (leaveEarly == '2') {
							return 'background-color:#ffff99;color:#ff9900;';
						} 
						else if (leaveEarly == '3') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
						else if (leaveEarly == 'ns') {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
					} */
				},
				formatter : function(value, row, index) {
					//var typeDate = row.typeDate;
					var statusAttendance = row.statusAttendance;
					if ("no" == statusAttendance) {
						return '';
					} else {
						return value;
					}
					/* var typeDate = row.typeDate;
					if ('f' == typeDate) {
						return '';
					} else {
						if (value != 'ns') {
							return value;
						} else {
							return '未打卡';
						}
					} */
				},
			},
			{	
				title : '迟到',
				field : 'late',
				width : 150,
				sortable : true,
			},
			{	
				title : '早退',
				field : 'leaveEarly',
				width : 150,
				sortable : true,
			},
			{	
				title : '半勤',
				field : 'attendHalf',
				width : 150,
				sortable : true,
			},
			{	
				title : '旷工',
				field : 'absenteeism',
				width : 150,
				sortable : true,
			},
			{
				title : '考勤状态',
				field : 'statusAttendance',
				width : 60,
				align : 'center',
				sortable : true	,
				formatter : function(value, row, index) {
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
					else if (value == 'ns') {
						return '未补签';
					}  
					else if (value == 're') {
						return '已补签';
					}  
				},
				styler: function(value, row, index){
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
						return 'background-color:#ffff99;color:#ff9900;';
					} 
					else if (value == 're2') {
						return 'background-color:#ffff99;color:#ff9900;';
					} 
					else if (value == 'ns') {
						return 'background-color:#ffff99;color:#ff9900;';
					} 
				}
			},
			{	
				title : '备注',  
				field : 'remark',    
				align : 'left',   
				width : 212,  
				formatter : function(value, row, index) {
					var statusAttendance = row.statusAttendance;
					var tagRecheck = row.tagRecheck;
					var str = '';
					if (value == null) {
						value = '';
					}
					//if (statusAttendance == 'le' || statusAttendance == 'la' || statusAttendance == 'lale' || statusAttendance == 're1' || statusAttendance == 're2' || statusAttendance == 'ns') {
						if ('en' == tagRecheck && statusAttendance == 'ns' ) {
							str = '<input id="remark' + index + '" type="text" value="' + value + '" style="width:200px;" />';
						}
						else {
							str = value;
						}
					return str;
				}
			},
			<c:if test="${attendance.tagSearch == 're' || attendance.tagSearch == 'ap1'}">
				{	
					title : '操作',  
					field : 'addIp',       
					width : 50,  
					formatter : function(value, row, index) {
						var tagRecheck = row.tagRecheck;
						var str = '';
						if ('en' == tagRecheck) {
							var statusAttendance = row.statusAttendance;
							//if (statusAttendance == 'ns' || statusAttendance == 'la' || statusAttendance == 'lale' || statusAttendance == 're1' || statusAttendance == 're2' || statusAttendance == 'ns') {
							if (statusAttendance == 'ns' ) {
								str = '<input type="button" value="补签" onclick="reCheckin(' + index + ')" />';
							}
							str += '';
						}
						return str;
					}
				},
			</c:if>
		
		]],
			onLoadSuccess : function(data) {
				
			},
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
		submit_form();
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
	var row = $('#datagrid').datagrid('getRows')[index];
	var id = row.id;
	var remark = $('#remark' + index).val();
	$.post('${pageContext.request.contextPath}/attendance/attendance/reCheckin.do?tagSearch=re', {id : id, remark : remark}, function(result){
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
	opt.url = '${pageContext.request.contextPath}/attendance/attendance/doSearch.do?tagSearch=${attendance.tagSearch}&statusVacate=a';
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
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'north',title:'<s:message code="common.title.search" />',border:false" style="height: 135px;overflow: hidden;" align="center">
		<form id="form">
			<table class="tableForm">
				<tr>
					<th style="width: 120px;">开始日期 : </th>
					<td><input name="dateStart" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">结束日期 : </th>
					<td><input name="dateEnd" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
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
						<c:if test="${attendance.tagSearch == 'ap1' || attendance.tagSearch == 'ap2'}">
							<th>部门 : </th>
							<td><input id="combotree_division" class="easyui-combobox" name="divisionId" style="width:200px;" data-options="editable: false" /></td>
						</c:if>
					</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submit_form();"><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="reset_form();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div data-options="region:'center',border:false">
		<table id="datagrid"></table>
	</div>
</body>

</html>
