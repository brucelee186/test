<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://ww.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	$(function() {
			$('#dd').hide();
		initAdmDatagrid();
		// 部门变更触发查询事件
	/* 	$('#dep_com').combobox({
			editable : false,
			required : false,
			onSelect : function(rec) {
				var opt = $('#datagrid').datagrid('options');
				// flag=d 查询部门汇总信息
				opt.url = '${pageContext.request.contextPath}/office/attenRecord/doSearch.do?flag=d&departmentId='+rec.value;
				$('#datagrid').datagrid('options', opt);
				$('#datagrid').datagrid('loadData', []);
				$('#datagrid').datagrid('load'); 
				$('#datagrid').datagrid('clearSelections');
				$('#hid_depId').val(rec.value);
			}
		}); */
	});
	
	// 行政部明细
	function initAdmDatagrid(){
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/attendance/attenRecord/doSearch.do?tag=${attenRecord.tag}&typeRecord=${attenRecord.typeRecord}',
			fit:true,
			pagination : true,
			collapsible:true,
			title:'',
			idField : 'id',
			pageSize : 10,
			pageList : [10, 50, 100, 200 ],
			sortName : 'id',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			rownumbers : true,
			columns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}
			] ],
			columns : [ [ 
			{
				title : '类型',
				field : 'typeRecord',
				sortable : true,
				width : 150,
				formatter : function (val, row, index) {
					if ('a' == val) {
						return '考勤';
					} else if ('v' == val) {
						return '请假';
					}
				}
			}, 
			{
				title : '状态',
				field : 'department',
				sortable : true,
				width : 150
			}, 
			{
				title : '档期',
				field : 'applyMonth',
				sortable : true,
				width : 150
			}, 
			{
				title : '添加时间',
				field : 'addDate',
				sortable : true,
				width : 150
			}, 
			{
				title : '修改时间',
				field : 'modifiedDate',
				sortable : true,
				width : 150
			}, 
			/* {
				title : '<s:message code="office.rowName.status" />',
				field : 'approveState',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 'save'){
						return '<s:message code="office.itemLable.saved" />';
					} else if (value == 'submit') {
						return '<s:message code="office.itemLable.submitted" />';
					} else if (value == 'approve2') {
						return '<s:message code="office.itemLable.confirmed" />';
					} else if (value == 'approve1') {
						return '<s:message code="office.itemLable.depManagerApproved" />';
					} else if (value == 'disable') {
						return '<s:message code="office.itemLable.disable" />';
					} else if (value == 'reject') {
						return '<s:message code="office.itemLable.depManagerRejected" />';
					}
				},
				styler: function(value, row, index){
					if (value == 0){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			} */ ] ],
			toolbar :'#datagrid_toolbar'
			<c:if test='${sessionInfo.userLever == "2"}'>
			,
			onClickRow: function (){
				var row = $('#datagrid').datagrid('getSelected');
				if(null == row){
					$('#depDatagrid').datagrid('reload');
					return;
				}
				var depOfficeId = row.id;
				//根据id,刷新部门DataGrid
				//initDepDatagrid(depOfficeId);
			},
			onLoadSuccess: function () {
				$('#datagrid').datagrid('selectRow', 0);
				var row = $('#datagrid').datagrid('getSelected');
				if (row != undefined) {
					//initDepDatagrid(row.id);
				}
			}
			</c:if>
		});
		
	}
	
	// 初始化部门明细
	function initDepDatagrid(depOfficeId){
		//console.info(depOfficeId);
		var url = '';
		if (depOfficeId != -1){
			url = '${pageContext.request.contextPath}/office/attenRecord/doSearch.do?flag=d&pid='+depOfficeId;
		}
		$('#depDatagrid').datagrid({
			title:'<s:message code="office.title.de" />',
			url:url,
			nowrap: true,
			striped: true,
			pagination : true,
			collapsible:true,
			idField : 'id',
			sortName : 'showAddDate',
			sortOrder: 'desc',
			pageSize : 10,
			pageList : [10,20,30],
			remoteSort: false,
			singleSelect: true, 
			rownumbers : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				hidden : true
			}
			] ],
			columns : [ [ {
				title : '<s:message code="office.item.department" />',
				field : 'department',
				sortable : true,
				width : 100
			}, {
				title : '<s:message code="office.item.ApproveDate" />',
				field : 'showAddDate',
				sortable : true,
				width : 100
			}, {
				title : '<s:message code="office.rowName.status" />',
				field : 'approveState',
				sortable : true,
				formatter : function(value, row, index) {
					if (value == 'save'){
						return '<s:message code="office.itemLable.saved" />';
					} else if (value == 'submit') {
						return '<s:message code="office.itemLable.submitted" />';
					} else if (value == 'approve2') {
						return '<s:message code="office.itemLable.confirmed" />';
					} else if (value == 'approve1') {
						return '<s:message code="office.itemLable.depManagerApproved" />';
					} else if (value == 'disable') {
						return '<s:message code="office.itemLable.disable" />';
					} else if (value == 'reject') {
						return '<s:message code="office.itemLable.depManagerRejected" />';
					}
				},
				styler: function(value, row, index){
					if (value == 0){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 1) {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			} ] ],
			toolbar: [{
				iconCls: 'icon-remove',
				text:'<s:message code="office.button.decheckCost" />',
				handler: function(){
					var checkedRows = $('#depDatagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
					}
					
					var id = checkedRows[0].id;
					var departmentId = checkedRows[0].departmentId;
					var applyMonth = checkedRows[0].applyMonth;
					
					/*console.info("id::"+id);
				 	  console.info("departmentId::"+departmentId);
					console.info("applyMonth::"+applyMonth); */
					var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpAmountListOld.cpt&__bypagesize__=false&departmentId=" + departmentId + "&applyMonth=" + applyMonth + "&depOfficeId=" +id;
					window.location.href = url;
				}
			},
			{
				iconCls: 'icon-remove',
				text:'<s:message code="office.button.decheck" />',
				handler: function(){
					var checkedRows = $('#depDatagrid').datagrid('getSelections');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
					}
					
					var id = checkedRows[0].id;
					var departmentId = checkedRows[0].departmentId;
					var applyMonth = checkedRows[0].applyMonth;
					
					var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpAmountListNoCost.cpt&__bypagesize__=false&departmentId=" + departmentId + "&applyMonth=" + applyMonth + "&depOfficeId=" +id;
					window.location.href = url;
				}
			}]

			
		});
	}
	
	
	// 申请表审批
	function approve(){
		var userLevel = '${sessionInfo.userLever}';
		var depId = $('#hid_depId').val();
		if (depId == null || depId == undefined || depId == ''){
			depId ='${sessionInfo.divisionId}';
		}
		var tag = '${attenRecord.tag}';
		var typeRecord = '${attenRecord.typeRecord}';
		url = "";
		if ('a' == typeRecord) {
			if ("ap1" == tag) {
				url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAll1.cpt&op=write&applyMonth=${sessionInfo.nowMonth}&tag=${attenRecord.tag}&divisions=${divisions}&divisionIds=${divisionIds}&serverIp=${pageContext.request.contextPath}";		
			} 
			else if ("ap2" == tag) {
				url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAll2.cpt&__bypagesize__=false&attenCollectDateStart=${attenCollectDateStart}&attenCollectDateEnd=${attenCollectDateEnd}&tag=${attenRecord.tag}&serverIp=${pageContext.request.contextPath}&statusWidget=ap&&applyMonth=${sessionInfo.nowMonth}";		
			}
		} else if ('v' == typeRecord) {
				url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttenVacateApprove.cpt&op=write&applyMonth=${sessionInfo.nowMonth}&tag=${attenRecord.tag}&divisions=${divisions}&divisionIds=${divisionIds}&serverIp=${pageContext.request.contextPath}";		
		}
		//url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpByDep.cpt";	
		window.location.href = url;
	}
	
	//  查看审批完成的申请表
	function check(){
		var userLevel = '${sessionInfo.userLever}';
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		} else if (checkedRows.length > 1) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
			return;
		} 
		var attendRecordIdAp = checkedRows[0].id;
		var tag = '${attenRecord.tag}';
		var applyMonth = checkedRows[0].applyMonth;
		url = "";
		if ("ap1" == tag) {
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAllCheck1.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&attendRecordIdAp1=" + attendRecordIdAp;
		}
		if ("ap2" == tag) {
			var attenCollectDateStart =  checkedRows[0].attenCollectDateStart;
			var attenCollectDateEnd =  checkedRows[0].attenCollectDateEnd;
				//	attenCollectDateStart=${attenCollectDateStart}&attenCollectDateEnd=${attenCollectDateEnd}&tag=${attenRecord.tag}&serverIp=${pageContext.request.contextPath}&statusWidget=ap&&applyMonth=${sessionInfo.nowMonth}";		
			//url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAll2.cpt&__bypagesize__=false&
			//var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAllCheck2.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&attendRecordIdAp2=" + attendRecordIdAp;
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceAll2.cpt&__bypagesize__=false&applyMonth=" + applyMonth + "&tag=${attenRecord.tag}&serverIp=${pageContext.request.contextPath}&statusWidget=sh"
			+ "&attenCollectDateStart=" + attenCollectDateStart + "&attenCollectDateEnd=" + attenCollectDateEnd;
		}
		window.location.href = url;
	}
	
	//  加班统计
	function countWorkExtra(){
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		} else if (checkedRows.length > 1) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
			return;
		} 
		var applyMonth = checkedRows[0].applyMonth;
		var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showCountWorkExtraV3.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&applyMonth=" + applyMonth;
		window.location.href = url;
	}
	
	//  加班统计明细 
	function countWorkExtraDetail(){
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		} else if (checkedRows.length > 1) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
			return;
		} 
		var applyMonth = checkedRows[0].applyMonth;
		//var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showCountWorkExtraDetailV3.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&applyMonth=" + applyMonth;
		var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showCountWorkExtraDetailV4.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&applyMonth=" + applyMonth;
		window.location.href = url;
	}
	
	function countRegist(){
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		} else if (checkedRows.length > 1) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
			return;
		} 
		
		var applyMonth = checkedRows[0].applyMonth;
		var attenCollectDateStart =  checkedRows[0].attenCollectDateStart;
		var attenCollectDateEnd =  checkedRows[0].attenCollectDateEnd;
		var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showRegistList.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&applyMonth=" + applyMonth + "&attenCollectDateStart=" + attenCollectDateStart + "&attenCollectDateEnd=" + attenCollectDateEnd;
		window.location.href = url;
	}
	

	function checkAll(){
			var checkedRows = $('#datagrid').datagrid('getSelections');
			if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
				return;
			} else if (checkedRows.length > 1) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
				return;
			} 
			var depId = checkedRows[0].id;
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showPurchaseOld.cpt&__bypagesize__=false&depId=" + depId;
			window.location.href = url;
		/* var userLevel = '${sessionInfo.userLever}';
		if (userLevel == 2) {
		} */
		
	}
	
	function countAttendance(param){
		
		if ('attRecWorkExtraAve' == param) {
			var checkedRows = $('#datagrid').datagrid('getSelections');
			if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
				return;
			} else if (checkedRows.length > 1) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
				return;
			} 
			var applyMonth = checkedRows[0].applyMonth;
			var attenCollectDateStart =  checkedRows[0].attenCollectDateStart;
			var attenCollectDateEnd =  checkedRows[0].attenCollectDateEnd;
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=attRecWorkExtraAve.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&applyMonth=" + applyMonth + "&attenCollectDateStart=" + attenCollectDateStart + "&attenCollectDateEnd=" + attenCollectDateEnd;
		}
		if ('y' == param) {
			var attenCollectDateStart =  '2016-01-01';
			var attenCollectDateEnd =  '2016-06-30';
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showAttendanceUserYear.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}" + "&attenCollectDateStart=" + attenCollectDateStart + "&attenCollectDateEnd=" + attenCollectDateEnd;
		}
			window.location.href = url;
	}
</script>
</head>
<body>

	<div id="datagrid"></div>
	<div id="depDatagrid"></div>
	<input id="hid_depId" type="hidden" />
	<div id="datagrid_toolbar">
		<table cellspacing="0" cellpadding="0">
			<tr>
				<td><div class="datagrid-btn-separator"></div></td>
				<td id="dd"><select id="dep_com" panelHeight="auto"
					style="width:120px">
						<c:forEach items="${divisionList}" var="division"
							varStatus="status">
							<option value="${division.divisionId}"
								<c:if test="${division.divisionId == sessionInfo.divisionId}">selected="selected"</c:if>>${division.divisionName}</option>
						</c:forEach>
				</select></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:approve()"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-tick l-btn-icon-left"><s:message
									code="office.itemLable.approval" /></span></span></a></td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:check()"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-zoom l-btn-icon-left">考勤统计</span></span></a></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:countAttendance('y')"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-zoom l-btn-icon-left">全年考勤统计</span></span></a></td>
									
				<%-- <td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:countWorkExtra()"><span class="l-btn-left"><span
							class="l-btn-text icon-remove l-btn-icon-left">加班统计</span></span></a></td> --%>
									
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:countWorkExtraDetail()"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-chart_curve l-btn-icon-left">加班统计</span></span></a></td>
				<%-- <td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:countAttendance('attRecWorkExtraAve')"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-chart_pie l-btn-icon-left">加班时长统计</span></span></a></td> --%>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:countRegist()"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-chart_line l-btn-icon-left">补签统计</span></span></a></td>
			</tr>
		</table>
	</div>
</body>
</html>
