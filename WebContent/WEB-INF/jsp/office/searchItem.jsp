<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search Role</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
var count = '${count}';
	$(function() {
		var userLevel = '${sessionInfo.userLever}';
		// 判断是否显示部门下拉框
		if (count == '0' || userLevel == 2){
			$('#dd').hide();
		}else {
			$('#dd').show();
		}
		initAdmDatagrid();
		// 部门变更触发查询事件
		$('#dep_com').combobox({
			editable : false,
			required : false,
			onSelect : function(rec) {
				var opt = $('#datagrid').datagrid('options');
				// flag=d 查询部门汇总信息
				opt.url = '${pageContext.request.contextPath}/office/office/doSearch.do?flag=d&departmentId='+rec.value;
				$('#datagrid').datagrid('options', opt);
				$('#datagrid').datagrid('loadData', []);
				$('#datagrid').datagrid('load'); 
				$('#datagrid').datagrid('clearSelections');
				$('#hid_depId').val(rec.value);
			}
		});
	});
	
	// 行政部明细
	function initAdmDatagrid(){
		$('#datagrid').datagrid({
			<c:if test='${sessionInfo.userLever == "0" || sessionInfo.userLever == "1" || sessionInfo.userLever == "4" || sessionInfo.userLever == "5" ||sessionInfo.userLever == "7" ||sessionInfo.userLever == "6"}'>
			url : '${pageContext.request.contextPath}/office/office/doSearch.do?flag=d',
			fit:true,
			</c:if>
			<c:if test='${sessionInfo.userLever == "2"}'>
			url : '${pageContext.request.contextPath}/office/depOffice/doSearch.do?flag=a',
			</c:if>
			pagination : true,
			collapsible:true,
			title:'',
			idField : 'id',
			pageSize : 10,
			pageList : [10, 50, 100, 200 ],
			sortName : 'showModifiedDate',
			sortOrder : 'desc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
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
				width : 150
			}
			<c:if test="${sessionInfo.userLever == '2'}">
			, {
				title : '<s:message code="office.item.Approve2Date" />',
				field : 'showModifiedDate',
				sortable : true,
				width : 150
			}
			</c:if>
			<c:if test="${sessionInfo.userLever != '2'}">
			, {
				title : '<s:message code="office.item.Approve1Date" />',
				field : 'showModifiedDate',
				sortable : true,
				width : 150
			}, 
			{
				title : '<s:message code="office.item.Approve2Date" />',
				field : 'showApprove2Date',
				sortable : true,
				width : 150
			}
			</c:if>
			, 
			{
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
				initDepDatagrid(depOfficeId);
			},
			onLoadSuccess: function () {
				$('#datagrid').datagrid('selectRow', 0);
				var row = $('#datagrid').datagrid('getSelected');
				if (row != undefined) {
					initDepDatagrid(row.id);
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
			url = '${pageContext.request.contextPath}/office/depOffice/doSearch.do?flag=d&pid='+depOfficeId;
		}
		$('#depDatagrid').datagrid({
			title:'<s:message code="office.title.de" />',
			url:url,
			nowrap: true,
			striped: true,
			pagination : true,
			collapsible:true,
			idField : 'id',
			sortName : 'showModifiedDate',
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
				field : 'showModifiedDate',
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
					var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpAmountListOld.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&departmentId=" + departmentId + "&applyMonth=" + applyMonth + "&depOfficeId=" +id;
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
					
					var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpAmountListNoCost.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&departmentId=" + departmentId + "&applyMonth=" + applyMonth + "&depOfficeId=" +id;
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
		var url = '';
		if (userLevel == 2) {
			 url = "${pageContext.request.contextPath}/ReportServer?reportlet=showDepList.cpt&__bypagesize__=false&op=write&serverIp=${pageContext.request.contextPath}";		
		} else {
			 url = "${pageContext.request.contextPath}/ReportServer?reportlet=showEmpList.cpt&__bypagesize__=false&op=write&departmentId="+depId+"&serverIp=${pageContext.request.contextPath}&approve=submit&applyMonth=${sessionInfo.nowMonth}";
		}
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
			var depId = checkedRows[0].id;
			var departmentId = checkedRows[0].departmentId;
			if (userLevel == 1 || userLevel == 7) {
				var url = "${pageContext.request.contextPath}/ReportServer?reportlet=checkEmpList.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&departmentId="+departmentId+"&bid="+depId;
				window.location.href = url;
			}
			if (userLevel == 2) {
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=checkDepList.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&depId=" + depId;
			//var url = "${pageContext.request.contextPath}/ReportServer?reportlet=AutoMatch1.cpt&op=write";
			window.location.href = url;
		}
		
	}
	
//  办公用品汇总查看
	function checkAll(){
		var userLevel = '${sessionInfo.userLever}';
		if (userLevel == 2) {
			var checkedRows = $('#datagrid').datagrid('getSelections');
			if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
				return;
			} else if (checkedRows.length > 1) {
				$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.selectOne" />', 'warning');
				return;
			} 
			var depId = checkedRows[0].id;
			var url = "${pageContext.request.contextPath}/ReportServer?reportlet=showPurchaseOld.cpt&serverIp=${pageContext.request.contextPath}&__bypagesize__=false&depId=" + depId;
			window.location.href = url;
		}
		
	}
</script>
</head>
<body>
	
	<div id="datagrid" ></div>
	<div id="depDatagrid"></div>
	<input id="hid_depId" type="hidden"/>
	<div id="datagrid_toolbar">
	<table cellspacing="0" cellpadding="0">
		<tr>
		<td><div class="datagrid-btn-separator"></div></td>
		<td id ="dd">
		<select id="dep_com" panelHeight="auto" style="width:120px">
		<c:forEach items="${divisionList}" var="division" varStatus="status">
			<option value="${division.divisionId}" <c:if test="${division.divisionId == sessionInfo.divisionId}">selected="selected"</c:if>>${division.divisionName}</option>
		</c:forEach>
		</select>
		</td>
		 <c:if test="${comUtil.checkCode('1202001')}">
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:approve()"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left"><s:message code="office.itemLable.approval" /></span></span></a></td>
			<td><div class="datagrid-btn-separator"></div></td>
		</c:if>
		<c:if test="${comUtil.checkCode('1202002')}">
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:check()"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left"><s:message code="office.itemLable.check" /></span></span></a></td>
		</c:if>
		<%-- <c:if test="${ sessionInfo.userLever == '2'}"> --%>
		<c:if test="${comUtil.checkCode('1202003')}">
			<td><a href="javascript:void(0)" class="l-btn l-btn-plain" onclick="javascript:checkAll()"><span class="l-btn-left"><span class="l-btn-text icon-remove l-btn-icon-left"><s:message code="office.button.checkAll" /></span></span></a></td>
		</c:if>
		</tr>
	</table>
	</div>
</body>
</html>
