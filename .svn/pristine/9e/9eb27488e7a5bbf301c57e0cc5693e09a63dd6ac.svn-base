<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>财务审核</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-datagrid-detailview.js?v=20141016" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/datagrid-detailview.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/jquery.edatagrid.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript">
var p_itemDiv = ${itemDivisionsJson};
/* var p_signers = ${signersJson}; */
$(function(){
	$('#dtg_reimbursement').datagrid({
		fit : true,
		border : false,
		url : '${pageContext.request.contextPath}/office/reimbursement/reimbursement/doSearch.do',
		pagination : true,
		idField : 'id',
		pageSize : 50,
		pageList : [10, 20, 50, 100, 200 ],
		sortName : 'createDatetime',
		sortOrder : 'desc',
		checkOnSelect : true,
		selectOnCheck : true,
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		queryParams: {
			statusGroup : '${reimbursement.statusGroup}',
			applicationDateFrom : getlastMonth(),
			applicationDateTo : getNow()
		},
		frozenColumns : [ [ {
			title : '',
			field : 'ck',
			width : 25,
			checkbox : true
		},{
			title : 'ID',
			field : 'id',
			width : 0,
			hidden : true
		} ] ],
		rowStyler: function(index,row){
			return {"class":"mtfblue0bg"};
		},
		columns : [ [{
			title : 'No.',
			field : 'no',
			sortable : true,
			width : 150
		},{
			title : '申请人',
			field : 'applicantName',
			sortable : true,
			width : 75
		},{
			title : '收款人',
			field : 'payeeName',
			sortable : true,
			width : 75
		},{
			title : '申请部门',
			field : 'applicantDivisionName',
			sortable : true,
			width : 120
		},{
			title : '申请日期',
			field : 'applicantDivisionDate',
			align : 'center',
			sortable : true,
			width : 110
		},{
			title : '审批日期',
			field : 'auditDate',
			align : 'center',
			sortable : true,
			width : 110
			
		},{
			title : '总金额',
			field : 'totalAmount',
			sortable : true,
			align : 'right',
			width : 120,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			}
		},{
			title : '币种',
			field : 'currencyId',
			align : 'center',
			width : 70,
			formatter : function(value, row, index) {
				if(value == 1){
					return 'RMB';
				}else if(value == 2){
					return 'USD';
				}else if(value == 3){
			     return 'HKD';
			    }
			}
		},{
			title : '汇率',
			field : 'exchangeRate',
			sortable : true,
			align : 'right',
			width : 150,
			hiddable : true,
			hidden : true,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 4);
				}
			}
		},{
			title : '换算总金额',
			field : 'totalRmbAmount',
			sortable : true,
			align : 'right',
			width : 150,
			hiddable : true,
			hidden : true,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			}
		},{
			title : '实际总金额',
			field : 'actualTotalAmount',
			sortable : true,
			align : 'right',
			width : 150,
			hiddable : true,
			hidden : true,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			}
		},{
			title : '签字人',
			field : 'signerName',
			sortable : true,
			width : 80
		},{
			title : '报销状态',
			field : 'status',
			sortable : true,
			width : 100,
			formatter : function(value, row, index) {
				if(value == 0){
					return '草稿';
				}else if(value == 1){
					return '已提交';
				}else if(value == 2){
					return '已审核通过';
				}else if(value == 3){
					return '审核未通过';
				}else if(value == 9){
					return '取消';
				}else{
					return '无';
				}
			},
			styler : function(value, row, index) {
				if (value == 1 ){
					return 'background-color:#FFEB9C;color:#9C6500;';
				}else if (value == 2){
					return 'background-color:#C6EFCE; color:#006100';
				} else if (value == 3 || value == 9) {
					return 'background-color:#FFC7CE; color:#9C0006';
				}
			}
		},{
			title : '导出状态',
			field : 'isExportFlex',
			sortable : false,
			align : 'center',
			width : 80,
			formatter : function(value, row, index) {
				if(value == 0){
					return '未导出';
				}else if(value == 1){
					return '已导出';
				}else{
					return '无';
				}
			},
			styler : function(value, row, index) {
				if (value == 1 ){
					return 'background-color:#C6EFCE; color:#006100';
				}
			}
		},{
			title : '创建时间',
			field : 'createDatetime',
			width : 150,
			sortable : true,
			hiddable : true,
			hidden : true
		},{
			title : '创建人',
			field : 'createUserName',
			width : 150,
			sortable : true,
			hiddable : true,
			hidden : true
		},{
			title : '更新时间',
			field : 'updateDatetime',
			width : 150,
			sortable : true,
			hiddable : true,
			hidden : true
		},{
			title : '更新人',
			field : 'updateUserName',
			width : 150,
			sortable : true,
			hiddable : true,
			hidden : true
		} ] ],
		onLoadSuccess : function(data) {
			$(this).datagrid('clearSelections');
			
			var rows = $(this).datagrid('getRows');
			var tds = $('td[field="_expander"]');
			for(var i = 0; i < rows.length; i++){
				if(rows[i].listReimbursementItem.length == 0){
					$(tds[i]).html('<div style="text-align:center;height:16px;height:16px;" class="datagrid-cell undefined"><span class="datagrid-row-expander" style="display:inline-block;width:16px;height:16px;"></span></div>');
				}
			}
			
			
			
			//$('td[field="_expander"]').addClass("mtfblue0bg");
		},
		onSelect : function(index, row) {
			$('.datagrid-row[id^="datagrid-row"]').addClass('mtfblue0bg');
			$('.datagrid-row.datagrid-row-checked.datagrid-row-selected').removeClass('mtfblue0bg');
		},
		onUnselect : function(index, row) {
			$('.datagrid-row[id^="datagrid-row"]').addClass('mtfblue0bg');
		},
		onCheck : function(index, row) {
			$('.datagrid-row[id^="datagrid-row"]').addClass('mtfblue0bg');
			$('.datagrid-row.datagrid-row-checked.datagrid-row-selected').removeClass('mtfblue0bg');
		},
		onUncheck : function(index, row) {
			$('.datagrid-row[id^="datagrid-row"]').addClass('mtfblue0bg');
			$('.datagrid-row.datagrid-row-checked.datagrid-row-selected').removeClass('mtfblue0bg');
		},
		toolbar : [{
				iconCls : 'ext-icon-user_edit',
				text : '确认报销',
				handler : function() {
					//var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					var checkedRows = $('#dtg_reimbursement').datagrid('getChecked');
					if(checkedRows[0] == undefined){
						return;
					}
					if(checkedRows.length > 1){
						for(var i = 0; i < checkedRows.length; i++){
							if(checkedRows[i].currencyId == 2){
								$.messager.alert('<s:message code="common.dialog.tip" />', '币种为[USD]的数据需要单独确认！', 'warning');
								return;
							}
						}
					}
					
					//批量添加信息
					var arr = [];
					for(var i = 0; i < checkedRows.length; i++){
						if(checkedRows[i].status == 2){
							$.messager.alert('<s:message code="common.dialog.tip" />', '已确认报销，不能再确认！', 'warning');
							return;
						}
						
						if(checkedRows[i].status != 1){
							$.messager.alert('<s:message code="common.dialog.tip" />', '只有【已提交】状态可以确认报销！', 'warning');
							return;
						}
						
						arr.push(checkedRows[i].id);
					}
					var idsStr = JSON.stringify(arr);
					$('#frm_reimbursement').form('clear');
					
					$('#hid_ids').val(idsStr);
					
					var $dtg = $('#dtg_signers');
					var opt = $dtg.datagrid('options');
					if (opt.url == undefined || opt.url == null || opt.url == '') {
						opt.url = '${pageContext.request.contextPath}/maintenance/user/doSearchForSigners.do'
						$dtg.datagrid('options', opt);
					}
					$dtg.datagrid('load');
					
					//美元时显示 
					if(checkedRows[0].currencyId == 2){
						$('#tbl_amount').show();
					}else if(checkedRows[0].currencyId == 1){
						$('#tbl_amount').hide();
					}
					
					//加载列表数据
					$('#nbx_totalAmount').numberbox('setValue', checkedRows[0].totalAmount);
					//$('#nbx_totalAmount').next().css('border', 0);
					//$('#nbx_totalRmbAmount').next().css('border', 0);
					
					$.post('${pageContext.request.contextPath}/maintenance/currency/doSearchForRatio.do', { 'id' : checkedRows[0].currencyId }, function(result) {
						$.messager.progress('close');// hide progress dialog
						try {
							var r = result;
							if (r.success) {
								$('#nbx_exchangeRate').numberbox('setValue', r.obj);
							} else {
								$.messager.alert('<s:message code="common.error" />', '汇率信息查找失败！', 'error');
							}
						} catch (e) {
							$.messager.alert('<s:message code="common.error" />', result, 'error');
						}
					}, 'json');
					
					//隐藏输入框边框
					$('#nbx_totalRmbAmount').next().css('border', '0px');
					$('#nbx_totalRmbAmount').parent().css('border-bottom', 'thin solid #95B8E7');
					$('#nbx_totalAmount').next().css('border', '0px');
					$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
					
					$('#dlg_reimbursement').dialog('setTitle', '确认报销').dialog('open').dialog('center');
				}
			} 
			, '-',{
				iconCls : 'ext-icon-cross',
				text : '驳回报销',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getChecked');
					if(checkedRows[0] == undefined){
						return;
					}
					var arr = [];
					for(var i = 0; i < checkedRows.length; i++){
						if(checkedRows[0].status == 3){
							$.messager.alert('<s:message code="common.dialog.tip" />', '已驳回报销！', 'warning');
							return;
						}
						
						if(checkedRows[0].status != 1  && checkedRows[0].status != 2){
							$.messager.alert('<s:message code="common.dialog.tip" />', '只有【已提交】和【已审核通过】状态可以驳回报销！', 'warning');
							return;
						}
						arr.push(checkedRows[i].id);
					}
					
					var idsStr = JSON.stringify(arr);
					
					$.messager.confirm('<s:message code="common.confirm" />', '确认驳回报销？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/reimbursement/doBatchEditStatusForReject.do', {ids : idsStr}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '驳回报销成功！', 'info', function(rr) {
											$('#dtg_reimbursement').datagrid('reload');
										});
										
									} else {
										var msg = j.msg;
										if (!msg && j.obj) {
											msg = formatErrorMessage(j.obj);
										}
										$.messager.alert('<s:message code="common.error" />', msg, 'error');
									}
								} catch (e) {
									$.messager.alert('<s:message code="common.error" />', result, 'error');
								}
							}, 'json');
						}
					}); 
				}	
			}, '-',{
				iconCls : 'ext-icon-file_txt',
				text : '导出FLEX',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status != 2){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【已财务审核】状态可以导出文件！', 'warning');
						return;
					}
					//TODO
				}	
			}  
			, '-', {
				iconCls : 'ext-icon-collapse_all',
				text : '关闭所有',
				handler : function() {
					var data = $('#dtg_reimbursement').datagrid('getRows');
		 			for(var i = 0; i < data.length; i++){
						$('#dtg_reimbursement').datagrid('collapseRow', i);
					}
				}
			}, '-', {
				iconCls : 'ext-icon-expand_all',
				text : '打开所有',
				handler : function() {
					var data = $('#dtg_reimbursement').datagrid('getRows');
		 			for(var i = 0; i < data.length; i++){
						$('#dtg_reimbursement').datagrid('expandRow', i);
					}
				}
			}], 
		view: detailview,
		detailFormatter: function(rowIndex, rowData){
			var html = mtfDetailGridGenerator.generate(this, rowData, rowIndex);
			return html;
		},
		detailGrid : {
			sortName : 'index',
			sortOrder : 'desc',
			dataField : 'listReimbursementItem',
			columns : [{
				title : '主类别',
				field : 'category1Name',
				align : 'left',
				width : 140
			},{
 				title : '次类别',
				field : 'category2Name',
				align : 'left',
				width : 141
			},{
				title : '费用部门',
				field : 'divisionName',
				align : 'left',
				width : 113
			},{
				title : '客户',
				field : 'customerName',
				align : 'left',
				width : 103
			},{
				title : '金额',
				field : 'amount',
				align : 'right',
				width : 88,
				formatter : function(value, row, index) {
					if(value) {
						return numberFormat(value, 2);
					}
				}
			},{
				title : '描述',
				field : 'description',
				align : 'left',
				tooltip : true,
				width : 335
			}]
		}
	});
	
	$('#dtg_signers').datagrid({
		//url : '${pageContext.request.contextPath}/maintenance/user/doSearchForSigner.do',
		idField: 'id',
		border : false,
		fit : true,
		nowrap : true,
		rownumbers : true,
		singleSelect : true,
		autoRowHeight : false,
		//pagination : true,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			sortable : false,
			hidden : true
		}
		] ],
		columns : [ [{
			title : '<b>签字人名称</b>',
			field : 'displayName',
			width : 200
		}] ],
		onLoadSuccess : function(data) {
			$(this).datagrid('clearSelections');
			rows = $('#dtg_reimbursement').datagrid('getSelections');
			if(rows[0].signerId != null && rows[0].signerId != ''){
				$(this).datagrid('selectRecord', rows[0].signerId);
			}
		}
	});
	
	$('#frm_reimbursement').form({
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (isValid) {
				var rows = $('#dtg_signers').datagrid('getSelections');
				if(rows.length == 0){
					$.messager.alert('<s:message code="common.dialog.warn" />', '请选择签字人！', 'warning');
					return false;
				}
				$('#hid_signerId').val(rows[0].id);
				$('#hid_signerName').val(rows[0].displayName);
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
					$.messager.alert('<s:message code="common.tip" />', '确认成功！', 'info', function(rr) {
						$('#dtg_reimbursement').datagrid('reload');
						$('#dlg_reimbursement').dialog('close');
						
					});
				} else {
					$.messager.alert('<s:message code="common.error" />', r.msg, 'error');
				}
			} catch (e) {
				$.messager.alert('<s:message code="common.error" />', result, 'error');
			}
		}
	});
	
	$('#frm_search :text').keydown(function(e) {
		handleEnterKey(e, submitSearchForm);
	});

	//清空多选框里的值
	$('#cbx_statuses').combobox('clear');
	
	//设置值
	$('#dtx_applicationDateFrom').datebox('setValue',new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()-30).toString() );
	$('#dtx_applicationDateTo').datebox('setValue', new Date().toString());
	
		
	//汇率和总金额变化事件
	$('#nbx_exchangeRate').numberbox({
		onChange : function(newValue, oldValue){
			var totalAmount = $('#nbx_totalAmount').numberbox('getValue');
			if(totalAmount == '' || totalAmount == null){
				totalAmount = 0.00;
			}
			$('#nbx_totalRmbAmount').numberbox('setValue', newValue*totalAmount);
			$('#nbx_actualTotalAmount').numberbox('setValue', newValue*totalAmount);
		}
	});
	
	//汇率和总金额keyup事件
	$('#nbx_exchangeRate').numberbox({
		inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
			keyup:function(e){
				var newValue = e.target.value;
				var totalAmount = $('#nbx_totalAmount').numberbox('getValue');
				//console.info(quoteTotalAmount);
				if(totalAmount == '' || totalAmount == null){
					totalAmount = 0.00;
				}
				$('#nbx_totalRmbAmount').numberbox('setValue', newValue*totalAmount);
				$('#nbx_actualTotalAmount').numberbox('setValue', newValue*totalAmount);
			}
		})
	})
	
})

function submitSearchForm() {
	var $dtg = $('#dtg_reimbursement');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/reimbursement/doSearch.do';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search')));
}

function getItemDiv() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_itemDiv.length; i ++) {
		level.push({'id':p_itemDiv[i].id, 'text':p_itemDiv[i].name});
	}
	return level;
}


/* function getSigners() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_signers.length; i ++) {
		level.push({'id':p_signers[i].id, 'text':p_signers[i].displayName});
	}
	return level;
} */

function getNow(){
	var now = new Date();
	var nowStr = now.getFullYear() + "-" + (now.getMonth()+1) + "-" + now.getDate();
	return nowStr;
}

function getlastMonth(){
	var now = new Date();
	var lastMonthDate = new Date(now.getFullYear(), now.getMonth(), now.getDate()-30);
	var lastMonthStr =lastMonthDate.getFullYear() + "-" + (lastMonthDate.getMonth()+1) + "-" + lastMonthDate.getDate();
	return lastMonthStr;
}


</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'报销列表',border:false">
		<table id="dtg_reimbursement"></table>
	</div>
	<div data-options="region:'north',title:'搜索',border:true" style="height: 90px;overflow: hidden;" align="center">
		<form id="frm_search"  method="post">
		<input  name="statusGroup" value="${reimbursement.statusGroup}" type="hidden"/>
			<table class="mtftable">
				<tr>
					<th align="right" style="width: 80px;">NO.</th>
					<td>:</td>
					<td><input name="no" class="easyui-textbox" style="width: 200px" /></td>
					<th align="right" style="width: 80px;">申请时间</th>
					<td>:</td>
					<td><input id="dtx_applicationDateFrom" name="applicationDateFrom" class="easyui-datebox" style="width: 120px" data-options="editable:false"/> - <input id="dtx_applicationDateTo" name="applicationDateTo" class="easyui-datebox" style="width: 120px" data-options="editable:false "/></td>  
					<th align="right" style="width: 80px;">报销状态</th>
					<td>:</td>
					<td><select id="cbx_statuses" name="statuses" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, multiple:true">
					<!-- <option value=""></option> -->
					<option value="1">已提交</option>
					<option value="2">审核通过</option>
					<!-- <option value="3">审核未通过</option> -->
					</select></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th align="right">申请人</th>
					<td>:</td>
					<td><input name="applicantName" class="easyui-textbox" style="width: 200px" /></td>
					<th align="right">申请部门</th>
					<td>:</td>
					<td>
					<input name="applicantDivisionId" class="easyui-combobox" style="width:258px" data-options="valueField : 'id', textField : 'text', data : getItemDiv(), panelHeight:'auto',panelMaxHeight:'200',editable:false " />
					</td>
					<th align="right" style="width: 80px;">导出状态</th>
					<td>:</td>
					<td><select name="isExportFlex" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false ">
					<option value=""></option> 
					<option value="1">已导出</option>
					<option value="0">未导出</option></select></td>
					<td>
						<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchForm();"><s:message code="common.search" /></a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#frm_search').form('reset'); $('#cbx_statuses').combobox('clear');"><s:message code="common.reset" /></a> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg_reimbursement" class="easyui-dialog" style="width:270px;height:500px;" data-options="resizable:true,modal:true,closed: true, 
		onOpen: function() {formValidate('#frm_reimbursement', true);}, onClose: function() {formValidate('#frm_reimbursement', false);},
		buttons: [{text:'<s:message code="确认报销" />', iconCls:'icon-save', handler:function(){$('#frm_reimbursement').submit()}} ]">
		<form id="frm_reimbursement" action="${pageContext.request.contextPath}/office/reimbursement/reimbursement/doEditStatusForAudit.do" method="post">
		<!-- <form id="frm_reimbursement" > -->
			<input id="hid_ids" name="idsStr" type="hidden"/>
			<input id="hid_signerId" name="signerId" type="hidden"/>
			<input id="hid_signerName" name="signerName" type="hidden"/>
				<table id="tbl_amount" align="center" >
					<tr >
						<th align="right" style="width: 100px;">金额</th>
						<td>:</td>
						<td align="center" valign="middle"><div style="width:95%"><input id="nbx_totalAmount" name="totalAmount" type="text" class="easyui-numberbox" style="width:100px" data-options="min:0, precision:2" readonly="readonly"/></div></td>
					</tr>
					<tr>
						<th align="right" style="width: 100px;">汇率</th>
						<td>:</td>
						<td><input id="nbx_exchangeRate" name="exchangeRate" value="1.0000" class="easyui-numberbox" style="width:100px" data-options="precision:4, validType:'digitalCompare[0, 100]', required:true " /></td>
					</tr>
					<tr >
						<th align="right" style="width: 100px;">换算总金额(RMB)</th>
						<td>:</td>
						<td align="center" valign="middle"><div style="width:95%"><input id="nbx_totalRmbAmount" name="totalRmbAmount" type="text" class="easyui-numberbox"  style="width:100px" data-options="min:0, precision:2, required:true" readonly="readonly"/></div></td>
					</tr>
					<tr >
						<th align="right" style="width: 100px;">实际总金额(RMB)</th>
						<td>:</td>
						<td><input id="nbx_actualTotalAmount" name="actualTotalAmount" type="text" class="easyui-numberbox" style="width:100px" data-options="precision:2, validType:'digitalCompare[0, 300000]', required:true" /></td>
					</tr>
				</table>
		</form>
		<table id="dtg_signers"></table>
	</div>
</body>
</html>
