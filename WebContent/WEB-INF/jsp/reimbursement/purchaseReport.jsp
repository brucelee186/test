<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>采购报表</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
$(function(){
	$('#dtg_purchase').datagrid({
		fit : true,
		border : false,
		url : '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearchForReport.do',
		idField : 'id',
		/* sortName : 'customerName',
		sortOrder : 'asc', */
		checkOnSelect : false,
		selectOnCheck : false,
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		showFooter: true,
		queryParams: {
			purchaseStatus: 1,
			applicationDateFrom : getFirstDay(),
			applicationDateTo : getLastDay()
		},
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			hidden : true
		} ] ],
		columns : [ [
			{
			title : '客户',
			field : 'customerName',
			width : 200,
			align : 'left',
			sortable : false,
			hidden : true
		},{
			title : '申请部门',
			field : 'applicantdivisionName',
			width : 100,
			sortable : false
		},{
			title : '时间',
			field : 'monthApplicantDatetime',
			width : 100,
			align : 'center',
			sortable : false,
			hidden : true
		},{
			title : '时间',
			field : 'quarterApplicantDatetime',
			width : 100,
			align : 'center',
			sortable : false,
			hidden : true
		},{
			title : '时间',
			field : 'yearApplicantDatetime',
			width : 100,
			align : 'center',
			sortable : false,
			hidden : true
		},{
			title : '主类别',
			field : 'category1Name',
			width : 120,
			sortable : false,
			formatter : function(value, row, index) {
				if(row.listPurchaseItem){
					return row.listPurchaseItem[0].category1Name;
				}
			}
		},{
			title : '次类别',
			field : 'category2Name',
			width : 120,
			sortable : false,
			formatter : function(value, row, index) {
				if(row.listPurchaseItem){
					return row.listPurchaseItem[0].category2Name;
				} else if(value){
					return value;
				}
			}
		},{
			title : '总金额',
			field : 'totalAmount',
			width : 150,
			align : 'right',
			sortable : false,
			formatter : function(value, row, index) {
				return numberFormat(value,2);
			}
		}] ],
		onLoadSuccess : function(data) {
			$(this).datagrid('clearSelections');
			$(this).datagrid('tooltip', ['customerName']);
		},
		toolbar : [ {
			iconCls : 'ext-icon-file_xls',
			text : '导出  Excel',
			handler : function() {
				$('#frm_search').attr('action', '${pageContext.request.contextPath}/office/reimbursement/purchase/doExportPurchaseReport.do');
				$('#frm_search').form('submit');
			}
		}]
	});
	
	$('#frm_search').form({
		success : function(result) {
			$.messager.progress('close');	// hide progress bar while submit successfully
			try {
				var r = $.parseJSON(result);
				if (r) {
					var msg = r.msg;
					if (!msg && r.obj) {
						msg = formatErrorMessage(r.obj);
					}
					$.messager.alert('<s:message code="common.error" />', msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.error" />', result, 'error');
			}
		}
	});
	
	
	$('#frm_search :text').keydown(function(e) {
		handleEnterKey(e, submitSearchForm);
	});
	
	//设置值
	$('#dtx_applicationDateFrom').datebox('setValue',new Date(new Date().getFullYear(), new Date().getMonth(), 1).toString() );
	$('#dtx_applicationDateTo').datebox('setValue', new Date(new Date().getFullYear(), new Date().getMonth()+1, 0).toString() );
})

function submitSearchForm() {
	var $dtg = $('#dtg_purchase');
	//
	var sortTime = $('#cbx_sortTime').combobox('getValue');
	if(sortTime == 'year'){
		$dtg.datagrid('showColumn','yearApplicantDatetime');
		$dtg.datagrid('hideColumn','monthApplicantDatetime');
		$dtg.datagrid('hideColumn','quarterApplicantDatetime');
	}else if(sortTime == 'month'){
		$dtg.datagrid('showColumn','monthApplicantDatetime');
		$dtg.datagrid('hideColumn','quarterApplicantDatetime');
		$dtg.datagrid('hideColumn','yearApplicantDatetime');
	}else if(sortTime == 'quarter'){
		$dtg.datagrid('showColumn','quarterApplicantDatetime');
		$dtg.datagrid('hideColumn','monthApplicantDatetime');
		$dtg.datagrid('hideColumn','yearApplicantDatetime');
	}else{
		$dtg.datagrid('hideColumn','quarterApplicantDatetime');
		$dtg.datagrid('hideColumn','monthApplicantDatetime');
		$dtg.datagrid('hideColumn','yearApplicantDatetime');
	}
	
	
	
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearchForReport.do';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search')));
}

function getFirstDay(){
	var now = new Date();
	var nowStr = now.getFullYear() + "-" + (now.getMonth()+1) + "-01" ;
	return nowStr;
}

function getLastDay(){
	var now = new Date();
	var day = new Date(now.getFullYear(), now.getMonth()+1, 0);
	var lastMonthStr = day.getFullYear() + "-" + (day.getMonth()+1) + "-" + day.getDate();
	return lastMonthStr;
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'采购统计列表',border:false">
		<table id="dtg_purchase"></table>
	</div>
	<div data-options="region:'north',title:'搜索',border:true" style="height: 90px;overflow: hidden;" align="center">
		<form id="frm_search"  method="post">
		<%-- <input  name="statusGroup" value="${purchase.statusGroup}" type="hidden"/> --%>
			<table class="mtftable">
					<tr>
					<th align="right" style="width: 80px;">部门</th>
					<td>:</td>
					<td><input name="applicantdivisionIds" class="easyui-combotree"  style="width:180px;" 
					data-options="url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do', valueField : 'id', textField : 'name', parentField : 'pid', lines : true, multiple : true "/></td>
					<%-- <th align="right" style="width: 80px;">客户</th>
					<td>:</td>
					<td><input  name="customerIds" class="easyui-combotree" style="width:180px;" 
					data-options="url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do', valueField : 'id', textField : 'name', parentField : 'pid', lines : true, multiple : true "/></td> --%>
					<th align="right" style="width: 80px;">采购状态</th>
					<td>:</td>
					<td><select  name="purchaseStatus" class="easyui-combobox" style="width:180px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false ">
							<option value="1">采购完成</option>
							<option value="2">采购中</option>
						</select></td>
					<th align="right" style="width: 100px;">申请时间(FROM)</th>
					<td>:</td>
					<td><input id="dtx_applicationDateFrom" name="applicationDateFrom" class="easyui-datebox" style="width: 120px" data-options="editable:false"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th align="right" style="width: 80px;">类别</th>
					<td>:</td>
					<td><input name="categoryIds" class="easyui-combotree" style="width:180px;" 
					data-options="url : '${pageContext.request.contextPath}/office/reimbursement/rbsCategory/doList.do', valueField : 'id', textField : 'categoryName', parentField : 'pid', lines : true, multiple : true "/></td>
					<th align="right" style="width: 80px;">时间</th>
					<td>:</td>
					<td><select id="cbx_sortTime" name="sortTime" class="easyui-combobox" style="width:180px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false ">
							<option value=""></option>
							<option value="year">年度</option>
							<option value="quarter">季度</option>
							<option value="month">月份</option>
						</select></td>
					<th align="right" style="width: 100px;">申请时间(TO)</th>
					<td>:</td>
					<td><input id="dtx_applicationDateTo" name="applicationDateTo" class="easyui-datebox" style="width: 120px" data-options="editable:false "/></td>
					<td>&nbsp;</td>
					
					<td colspan="3" align="center">
						<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchForm();"><s:message code="common.search" /></a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#frm_search').form('reset'); $('#cbx_statuses').combobox('clear');"><s:message code="common.reset" /></a> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg_comment" class="easyui-dialog" style="width:750px;height:400px;" data-options="resizable:true,modal:true,closed: true">
		<iframe id="ifr_comment" style="border: 0; width: 100%; height: 100%; display: block" frameBorder="0" ></iframe>
	</div>
	
</body>
</html>
