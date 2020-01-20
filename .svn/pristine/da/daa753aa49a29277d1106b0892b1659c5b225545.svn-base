<%@ page language="java" pageEncoding="UTF-8"
	contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
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
	});
	
	var isCheckFlag=false;//是否选中的标志
	var rowIndexTo;//保存当前保存的是那条数据
	// 行政部明细
	function initAdmDatagrid(){
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/order/orderServiceRecord/doSearch.do?tag=${attenRecord.tag}&typeRecord=${attenRecord.typeRecord}&tagPageCode=${tagPageCode}',
			fit:true,
			pagination : true,
			collapsible:true,
			title:'',
			idField : 'id',
			pageSize : 25,
			pageList : [25, 50, 100, 200 ],
			sortName : 'id',
			sortOrder : 'desc',
			singleSelect : true,
			//checkOnSelect : true,
			//selectOnCheck : true,
			nowrap : true,
			rownumbers : true,
			/* columns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				sortable : false,
				checkbox : true,
				hidden : false
			}
			] ], */
			columns : [ [ 
			{
				title : 'No.',
				field : 'id',
				sortable : true,
				align : 'right',
				width : 70,
			},
			{
				title : '类型',
				field : 'typeRecord',
				sortable : true,
				width : 150,
				formatter : function (val, row, index) {
					if ('ov' == val) {
						return '订车';
					} else if('or' == val) {
						return '报销';
					}
				}
			}, 
			{
				title : '状态',
				field : 'approveState',
				sortable : true,
				align : 'center',
				width : 100,
				formatter : function (val, row, index) {
					return '审批完成';
				}
			}, 
			<c:if test="${tagPageCode == '1805000'}"> 
			{
				title : '档期',
				field : 'applyMonth',
				sortable : true,
				width : 150,
				align : 'center',
			}, 
			</c:if>
			<c:if test="${tagPageCode == '1808700'}"> 
			{
				title : '档期',
				field : 'month',
				sortable : true,
				width : 100,
				align : 'center',
			},
			</c:if>
			{
				title : '审批人',
				field : 'approverName',
				sortable : true,
				width : 100,
				align : 'left',
			},
			{
				title : '审批日期',
				field : 'modifiedDate',
				sortable : true,
				width : 100,
				align : 'center',
				formatter : function(value, row, index) {
					if( null == value || '' == value){
						value = '';
					} else{
						value = dateFormat(value);
					}
					return value;
				}				
			}, 
			{
				title : '生成时间',
				field : 'addDate',
				sortable : true,
				align : 'center',
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
			toolbar :'#datagrid_toolbar',
			onSelect: function (rowIndex, rowData) {
				if(!isCheckFlag){
				    isCheckFlag = true;
				    rowIndexTo=rowIndex;
				 	$('#btAp').text('合并')
				 	$('#tagPageCode').val('1808702');
				 }else if(rowIndexTo==rowIndex){
				 	$('#btAp').text('审批')
				 	$('#tagPageCode').val('1808701');
					 isCheckFlag = false;
					 $('#datagrid').datagrid("unselectRow",rowIndex);
				 }else{
					 isCheckFlag = false;
				 }
			}, 
			<c:if test='${sessionInfo.userLever == "2"}'>
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
			pageSize : 20,
			pageList : [20,50],
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
			toolbar: [
			{
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
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceRecord.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false';
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceTotal.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false';
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetail.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false';
		// var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetailGroupApprove.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false';
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetailGroup.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&statusOrder="ap2"&idOrderServiceRecord=';
		window.location.href = url;
	}
	
	// 申请表审批
	function approveRes(status){
		var userId = '${userId}';
		// 审批
		if('ap' == status){
			var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryByApproverAll.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&status="ap"' + '&userId=' + userId;
			window.location.href = url;
			// 查看
		} else if ('sh' == status){
			var checkedRows = $('#datagrid').datagrid('getSelections');
			if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
				return;
			} else if (checkedRows.length > 1) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
				return;
			} 
			var idOrderServiceRecord = checkedRows[0].id;
				var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryByApproverAll.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&status="ap"&idOrderServiceRecord=' +　idOrderServiceRecord + '&userId=' + userId;
				window.location.href = url;
			}
	}
	// 申请表审批
	function approvePrint(status){
		var userId = '${userId}';
		var tagPageCode = $('#tagPageCode').val();
		var idOrderServiceRecord = null;
		var month = null;
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows != null && checkedRows.length == 1) {
			idOrderServiceRecord = checkedRows[0].id;
			month = checkedRows[0].month;
		}
		// 审批
		if(null == tagPageCode || '' == tagPageCode){
			tagPageCode = '1808701';
		}
		// 报销签字审批: 1808701,合并报销签字: 1808702, 报销签字驳回: 1808703
		if(tagPageCode == '1808701'){
			month = '${sessionInfo.nowMonth}';
		} 
		// 审批
		if('ap' == status){
			// 取得报销单状态
			var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryApproverPrint.cpt&status=af&approveMonth=2017-12&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&op=write&status="ap"' + '&userId=' + userId + '&month=' + month + '&tagPageCode=' + tagPageCode + '&id=' + idOrderServiceRecord;
			window.location.href = url;
			// 查看(并可驳回)
		} else if ('sh' == status){
			var checkedRows = $('#datagrid').datagrid('getSelections');
			if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
				return;
			} else if (checkedRows.length > 1) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
				return;
			} 
			var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryApproverPrint.cpt&status=c&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&op=write&status="ap"&idOrderServiceRecord=' +　idOrderServiceRecord + '&userId=' + userId + '&month=' + month + '&tagPageCode=1808703';
			window.location.href = url;
		}
	}
	
	//
	function show(report){
		var userId = '${userId}';
		var checkedRows = $('#datagrid').datagrid('getSelections');
		if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
			return;
		} else if (checkedRows.length > 1) {
			$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
			return;
		} 
		var idOrderServiceRecord = checkedRows[0].id;
		var month = checkedRows[0].month
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=' + report + '&serverIp=${pageContext.request.contextPath}&__bypagesize__=true&idOrderServiceRecord=' +　idOrderServiceRecord + '&userId=' + userId + '&month=' + month ;
		window.location.href = url;
	}
	
	
	function showTest(report){
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=' + report + '&serverIp=${pageContext.request.contextPath}&__bypagesize__=true&op=write';
		window.location.href = url;
	}
	
	//  查看审批完成的列表
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
		var idOrderServiceRecord = checkedRows[0].id;
		var tag = '${attenRecord.tag}';
		var applyMonth = checkedRows[0].applyMonth;
		url = "";
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceRecordCheck.cpt&serverIp=${pageContext.request.contextPath}&idOrderServiceRecord=' +　idOrderServiceRecord;
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceTotal.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&idOrderServiceRecord=' +　idOrderServiceRecord;
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetail.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&idOrderServiceRecord=' +　idOrderServiceRecord;
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetailGroup.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&idOrderServiceRecord=' +　idOrderServiceRecord;
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetailGroup.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&codePermission=${codePermission}&userId=${userId}&idOrderServiceRecord=' +　idOrderServiceRecord;
		window.location.href = url;
	}
	
//  汇总查看
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
			var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceRecord.cpt&serverIp=${pageContext.request.contextPath}';
			window.location.href = url;
		
	}
function showReport(type) {
	var userLevel = '${sessionInfo.userLever}';
	var checkedRows = $('#datagrid').datagrid('getSelections');
	if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
		return;
	} else if (checkedRows.length > 1) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
		return;
	} 
	var idOrderServiceRecord = checkedRows[0].id;
	if ('d') {
		//var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetail.cpt&__bypagesize__=true&serverIp=${pageContext.request.contextPath}&codePermission=${codePermission}&userId=${userId}&idOrderServiceRecord=' +　idOrderServiceRecord;
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceDetailGroup.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&codePermission=${codePermission}&userId=${userId}&idOrderServiceRecord=' +　idOrderServiceRecord;
		window.location.href = url;
	}
	if ('t' == type) {
		var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderServiceTotal.cpt&__bypagesize__=true&serverIp=${pageContext.request.contextPath}&codePermission=${codePermission}&userId=${userId}&idOrderServiceRecord=' +　idOrderServiceRecord;
		window.location.href = url;
	}
}

// 生成报销单
function createReimbursement(){
	var checkedRows = $('#datagrid').datagrid('getSelections');
	if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
		return;
	} else if (checkedRows.length > 1) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
		return;
	} 
	var idOrderServiceRecord = checkedRows[0].id;
	$.post( contextPath + '/order/orderServiceRecord/doEdit.do',
			{
				id : idOrderServiceRecord,
				statusOrder : 's',
				tagModule : '${orderService.tagModule}',
				editState : 'cr',
				
			},
			function(res) {
				var j = $.parseJSON(res);
				if(j.success){
					$('#datagrid').datagrid( 'reload');
					editRow = undefined;
					$.messager
							.show({
								title : '提示信息',
								msg : '报销单草稿生成完成',
								timeout : 2000,
								showType : 'slide'
							});
					$('#datagrid').datagrid('clearSelections');
				}
				else{
					$.messager.alert('<s:message code="common.dialog.error" />', j.msg, 'error');
					editRow = undefined;
					$('#datagrid').datagrid( 'reload');
					$('#datagrid').datagrid('clearSelections');
				}
			});
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
				
				
				<c:if test="${tagPageCode == '1805000'}"> 
				<td>
				
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approve()">
						<span class="l-btn-left">
							<span class="l-btn-text icon-remove l-btn-icon-left">
								<s:message code="office.itemLable.approval" />
							</span>
						</span>
					</a>
				</td>					
							
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:showReport('d')"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-chart_curve_link l-btn-icon-left">查看出车明细</span></span></a></td>
							
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:showReport('t')"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-chart_curve_go l-btn-icon-left">查看车费统计</span></span></a></td>
				<td><a href="javascript:void(0)" class="l-btn l-btn-plain"
					onclick="javascript:createReimbursement();"><span class="l-btn-left"><span
							class="l-btn-text ext-icon-money l-btn-icon-left">生成报销单</span></span></a></td>
				</c:if>	
				
				<!-- 报销签字 1808700 -->
				<c:if test="${tagPageCode == '1808700'}"> 
				<td>
					<input type="hidden" id="tagPageCode"/>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approvePrint('ap')">
						<span class="l-btn-left">
							<span id="btAp" class="l-btn-text ext-icon-tick l-btn-icon-left">
								审批
							</span>
						</span>
					</a>
				</td>				
				<td><div class="datagrid-btn-separator"></div></td>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approvePrint('sh')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-zoom l-btn-icon-left">
								查看
							</span>
						</span>
					</a>
				</td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryApproverAll.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_bottom l-btn-icon-left">
								签字总表
							</span>
						</span>
					</a>
				</td>
				<td>
			
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_bottom l-btn-icon-left">
								经理签字表
							</span>
						</span>
					</a>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover2.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_left l-btn-icon-left">
								总监签字表
							</span>
						</span>
					</a>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover3.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_right l-btn-icon-left">
								执行签字表
							</span>
						</span>
					</a>
				</td>				
				</c:if>					
	
				<!-- 报销统计1808800 -->
				<c:if test="${tagPageCode == '1808800'}"> 
				<td><div class="datagrid-btn-separator"></div></td>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approveRes('sh')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-zoom l-btn-icon-left">
								查看
							</span>
						</span>
					</a>
				</td>
				<td><div class="datagrid-btn-separator"></div></td>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryApproverAll.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_bottom l-btn-icon-left">
								签字总表
							</span>
						</span>
					</a>
				<td>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryApproverAll.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_bottom l-btn-icon-left">
								报销汇总表
							</span>
						</span>
					</a>
				<td>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_bottom l-btn-icon-left">
								经理签字表
							</span>
						</span>
					</a>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover2.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_left l-btn-icon-left">
								总监签字表
							</span>
						</span>
					</a>
					<a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:show('showOrderCategoryByApprover3.cpt')">
						<span class="l-btn-left">
							<span class="l-btn-text ext-icon-text_padding_right l-btn-icon-left">
								执行签字表
							</span>
						</span>
					</a>
				</td>				
				</c:if>	
				
				
			</tr>
		</table>
	</div>
</body>
</html>
