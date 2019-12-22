<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>待估价</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-datagrid-detailview.js?v=20141016" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/datagrid-detailview.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/jquery.edatagrid.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript">
var p_div = ${divisionsJson};

$(function(){
	$('#dtg_purchase').datagrid({
		fit : true,
		border : false,
		url : '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearch.do',
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
			statusGroup : '${purchase.statusGroup}'
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
			width : 160
		},{
			title : '申请人',
			field : 'applicantName',
			sortable : true,
			width : 160
		},{
			title : '申请部门',
			field : 'applicantdivisionName',
			sortable : true,
			width : 160
		},{
			title : '申请日期',
			field : 'applicantDatetime',
			align : 'center',
			sortable : true,
			width : 120
		},{
			title : '估算总金额',
			field : 'quoteTotalAmount',
			sortable : true,
			align : 'right',
			width : 150,
			hidden : true,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			}
		},{
			title : '币种',
			field : 'quoteCurrencyId',
			align : 'center',
			width : 70,
			hidden : true,
			formatter : function(value, row, index) {
				if(value == 1){
					return 'RMB';
				}else if(value == 2){
					return 'USD';
				}else if(value == 3){
				     return 'HKD';
			    }else{
					return '';
				}
			}
		},{
			title : '申请审批',
			field : 'reqLevel',
			sortable : false,
			width : 65,
			align : 'center',
			hiddable : true,
			hidden : true,
			formatter : function(value, row, index) {
				if(value == 1){
					return '1级';
				}else if(value == 2){
					return '2级';
				}else if(value == 3){
					return '3级';
				}else{
					return '';
				}
			}
		},{
			title : '状态',
			field : 'status',
			sortable : true,
			width : 100,
			hidden : true,
			formatter : function(value, row, index) {
				if(value == 0){
					return '草稿';
				}else if(value == 1){
					return '已提交';
				}else if(value == 2){
					return '申请审批完成';
				}else if(value == 3){
					return '已估价';
				}else if(value == 4){
					return '采购审批完成';
				}else if(value == 5){
					return '已采购';
				}else if(value == 6){
					return '采购完成';
				}else if(value == 8){
					return '拒绝';
				}else if(value == 9){
					return '取消';
				}else{
					return '无';
				}
			},
			styler : function(value, row, index) {
				if (value == 1){
					return 'background-color:#FFEB9C;color:#9C6500;';
				}else if (value == 2 || value == 4){
					return 'background-color:#C6EFCE; color:#006100';
				}else if (value == 3){
					return 'background-color:#E0ECFF;color:#000061;';
				}else if (value == 5 || value == 6){
					return 'background-color:#C6EFCE; color:#006100';
				} else if (value == 8 || value == 9) {
					return 'background-color:#FFC7CE; color:#9C0006';
				}  
			}
		}, {
			title : '',
			field : 'comment',
			align : 'center',
			sortable : false,
			width : 36,
			formatter : function(value, row, index) {
				return '<a class="mtficon ext-icon-error" title="评论" onclick="openCommentDialog(\'' + row.id + '\')"></a>';
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
				if(rows[i].listPurchaseItem.length == 0){
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
				iconCls : 'ext-icon-calculator',
				text : '估算价格并提交',
				handler : function() {
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status == 3){
						$.messager.alert('<s:message code="common.dialog.tip" />', '已估算价格！', 'warning');
						return;
					}
					
					if(checkedRows[0].status != 2){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【申请审批完成】状态可以估算价格！', 'warning');
						return;
					}
					
					$('#frm_purchase').form('clear');
					$('#cbx_quoteCurrencyId').combobox('selectIndex',0);
					//$('#cbx_quoteCurrencyId').combobox('setValue', 1);
					
					$('#dlg_purchase').dialog('setTitle', '估算价格').dialog('open').dialog('center');	
					//$('#dtg_purchaseItem').datagrid('cancelRow');
					$('#dtg_purchaseItem').datagrid('loadData',[]);
					
					//$('#dtg_purchaseItem').edatagrid('editRow', 1);
					//$('#dtg_purchaseItem').edatagrid('selectRow', 1);
					
					var $dtg = $('#dtg_purchaseItem');
					var opt = $dtg.datagrid('options');
					opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearch.do?purchaseId=' + checkedRows[0].id;
					$dtg.datagrid('options', opt);
					
					$dtg.datagrid('load');
					
					//编辑状态1：添加，2：编辑
					$('#hid_editStatus').val(2);
					
					//隐藏输入框边框
					$('#nbx_totalRmbAmount').next().css('border', '0px');
					$('#nbx_totalRmbAmount').parent().css('border-bottom', 'thin solid #95B8E7');
				}
			}, '-',  {
				iconCls : 'ext-icon-heart_add',
				text : '增加关注',
				handler : function() {
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					//批量添加信息
					var arr = [];
					
					for(var i = 0;i < checkedRows.length;i++){
						 var row = {
								'id' : checkedRows[i].id
							};
						arr.push(checkedRows[i].id);
					}
				
				var idsStr = JSON.stringify(arr);
				$.messager.confirm('<s:message code="common.confirm" />', '确认增加关注？', function(rr) {
					if(rr){
						$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doAddForWatcher.do', {idsStr : idsStr}, function(result){
							$.messager.progress('close');// hide progress dialog
							try {
								var j = result;
								if (j.success) {
									$.messager.alert('<s:message code="common.tip" />', '关注成功！', 'info', function(rr) {
										$('#dtg_purchase').datagrid('reload');
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
			}, '-', {
				iconCls : 'ext-icon-collapse_all',
				text : '关闭所有',
				handler : function() {
					var data = $('#dtg_purchase').datagrid('getRows');
		 			for(var i = 0; i < data.length; i++){
						$('#dtg_purchase').datagrid('collapseRow', i);
					}
				}
			}, '-', {
				iconCls : 'ext-icon-expand_all',
				text : '打开所有',
				handler : function() {
					var data = $('#dtg_purchase').datagrid('getRows');
		 			for(var i = 0; i < data.length; i++){
						$('#dtg_purchase').datagrid('expandRow', i);
					}
				}
			}], 
		view: detailview,
		detailFormatter: function(rowIndex, rowData){
			var html = mtfDetailGridGenerator.generate(this, rowData, rowIndex);
			return html;
		},
		detailGrid : {
			//width:800,
			sortName : 'index',
			sortOrder : 'desc',
			dataField : 'listPurchaseItem',
			columns :[{
				title : '采购部门',
				field : 'divisionName',
				align : 'left',
				width : 100
			},{
				title : '客户',
				field : 'customerName',
				align : 'left',
				width : 100
			},{
				title : '主类别',
				field : 'category1Name',
				align : 'left',
				width : 100
			},{
				title : '次类别',
				field : 'category2Name',
				align : 'left',
				width : 100
			},{
				title : '描述',
				field : 'description',
				align : 'left',
				tooltip : true,
				width : 225
			}/* ,{
				title : '金额',
				field : 'quoteAmount',
				align : 'right',
				width : 100,
				formatter : function(value, row, index) {
					if(value) {
						return numberFormat(value, 2);
					}
				}
			} */]
		}
	});
	
//edatagrid purchase item
$('#dtg_purchaseItem').datagrid({
		fit : true,
		//url : '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearch.do' ,
		weight :550,
		height : 360, 
		border : false,
		idField : 'id',
		sortName : '`index`',
		sortOrder : 'asc',
		nowrap : true,
		//rownumbers : true,
		autoRowHeight : false,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			hidden : true
		} ] ],
		columns : [ [{
			title : '主类别',
			field : 'category1Id',
			width : 100,
			formatter : function(value, row, index) {
				return row.category1Name;
			}
		},{
			title : '次类别',
			field : 'category2Id',
			width : 100,
			formatter : function(value, row, index) {
				return row.category2Name;
			}
		},{
			title : '部门',
			field : 'divisionName',
			width : 100
		},{
			title : '客户',
			field : 'customerName',
			width : 100
		} ,{
			title : '描述',
			field : 'description',
			width : 300
		}] ],
		onLoadSuccess : function(data) {
			$(this).datagrid('tooltip', ['description']);
		}
	});
	
$('#frm_purchase').form({
	onSubmit : function() {
		var isValid = $(this).form('validate');
		if (isValid) {
			var checkedRows = $('#dtg_purchase').datagrid('getSelections');
			if(checkedRows[0] != undefined){
				$('#hid_purchaseId').val(checkedRows[0].id);
			} 
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
				$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
					$('#dtg_purchase').datagrid('reload');
					$('#dlg_purchase').dialog('close');
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
	
	//汇率和总金额keyup事件
	$('#nbx_exchangeRate').numberbox({
		inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
			keyup:function(e){
				var newValue = e.target.value;
				var quoteAmount = $('#nbx_quoteTotalAmount').numberbox('getValue');
				//console.info(quoteTotalAmount);
				if(quoteAmount == '' || quoteAmount == null){
					quoteAmount = 0.00;
				}
				$('#nbx_totalRmbAmount').numberbox('setValue', newValue*quoteAmount);
			}
		})
	})
	
	$('#nbx_quoteTotalAmount').numberbox({
		inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
			keyup:function(e){
				var newValue = e.target.value;
				var exchangeRate = $('#nbx_exchangeRate').numberbox('getValue');
				if(exchangeRate == '' || exchangeRate == null){
					exchangeRate = 0.00;
				}
				var totalRmbAmount = numberFormat(Number(newValue) * Number(exchangeRate), 2);
				$('#nbx_totalRmbAmount').numberbox('setValue', totalRmbAmount);
			}
		})
	})
	
	//汇率和总金额变化事件
	$('#nbx_exchangeRate').numberbox({
		onChange : function(newValue, oldValue){
			var quoteTotalAmount = $('#nbx_quoteTotalAmount').numberbox('getValue');
			//console.info(quoteTotalAmount);
			if(quoteTotalAmount == '' || quoteTotalAmount == null){
				quoteTotalAmount = 0.00;
			}
			$('#nbx_totalRmbAmount').numberbox('setValue', newValue*quoteTotalAmount);
		}
	});
	/* $('#nbx_quoteTotalAmount').numberbox({
		onChange : function(newValue, oldValue){
			console.info(2);
			console.info(newValue);
			var exchangeRate = $('#nbx_exchangeRate').numberbox('getValue');
			if(exchangeRate == '' || exchangeRate == null){
				exchangeRate = 0.00;
			}
			$('#nbx_totalRmbAmount').numberbox('setValue', newValue*exchangeRate);
		}
	}); */
	
})


function doSubmit() {
	var isValid = $('#frm_purchase').form('validate');
	if (isValid == false) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写！', 'warning'); 
		return;
	}
	
	var rows = $('#dtg_purchaseItem').datagrid('getRows');
	
	/* for(var i = 0; i < rows.length; i++){
		if( rows[i].quoteAmount == null || rows[i].quoteAmount == ""){
			$.messager.alert('<s:message code="common.dialog.warn" />', '请全部估算价格！', 'warning');
			return;
		}
	} */
	
	var url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doEditQuoteAmount.do';
	var checkedRows = $('#dtg_purchase').datagrid('getSelections');
	//公用信息
	var form = {
		'id' : checkedRows[0].id,
		'quoteCurrencyId' : $('#cbx_quoteCurrencyId').combobox('getValue'),
		'exchangeRate' : $('#nbx_exchangeRate').numberbox('getValue'),
		'totalRmbAmount' : $('#nbx_totalRmbAmount').numberbox('getValue')
	};
	//批量添加信息
	var arr = [];
	rows = $('#dtg_purchaseItem').datagrid('getRows');
	
	 var row = {
			'id' : rows[0].id,
			'quoteAmount' : $('#nbx_quoteTotalAmount').numberbox('getValue'),
		};
	arr.push(row);

	form.purchaseItemStr = JSON.stringify(arr);
	
	$.messager.confirm('<s:message code="common.confirm" />', '确认提交估算价格？', function(rr) {
		if (rr) {
			$.messager.progress();
			$.post(url, form, function(result) {
				$.messager.progress('close');// hide progress dialog
				try {
					var j = result;
					if (j.success) {
						$.messager.alert('<s:message code="common.tip" />', 'OK', 'info', function(rr) {
							$('#dlg_purchase').dialog('close');
							$('#dtg_purchase').datagrid('reload');
							//$('#dtg_purchaseItem').edatagrid('loadData',[]); 
							arr = [];
							row = {};
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
	
	$('#frm_search :text').keydown(function(e) {
		handleEnterKey(e, submitSearchForm);
	});
}

function openCommentDialog(purchaseId){
	var url = formatString('${pageContext.request.contextPath}/workgroup/purchase/purchaseComment/toSearch.do?purchaseId={0}', purchaseId);
	$('#ifr_comment').attr('src', url); 
	$('#dlg_comment').dialog('setTitle', '评论').dialog('open').dialog('center');
}

function submitSearchForm() {
	var $dtg = $('#dtg_purchase');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearch.do';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search')));
}

function getDiv() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_div.length; i ++) {
		level.push({'id':p_div[i].id, 'text':p_div[i].name});
	}
	return level;
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'待估价列表',border:false">
		<table id="dtg_purchase"></table>
	</div>
	<div data-options="region:'north',title:'搜索',border:true" style="height: 90px;overflow: hidden;" align="center">
		<form id="frm_search"  method="post">
		<input  name="statusGroup" value="${purchase.statusGroup}" type="hidden"/>
			<table class="mtftable">
				<tr>
					<th align="right" style="width: 80px;">NO.</th>
					<td>:</td>
					<td><input name="no" class="easyui-textbox" style="width: 200px"/></td>
					<th align="right" style="width: 80px;">申请时间</th>
					<td>:</td>
					<td><input name="applicationDateFrom" class="easyui-datebox" style="width: 120px" data-options="editable:false"/> - <input name="applicationDateTo" class="easyui-datebox" style="width: 120px" data-options="editable:false "/></td>  
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th align="right">申请人</th>
					<td>:</td>
					<td><input name="applicantName" class="easyui-textbox" style="width: 200px" /></td>
					
					<th align="right">申请部门</th>
					<td>:</td>
					<td><div name="applicantdivisionId" class="easyui-combobox" style="width:257px" data-options="panelHeight:'auto', panelMaxHeight:'200',editable:false, valueField : 'id', textField : 'text', data : getDiv() "/>
					</td>
					<td>
						<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchForm();"><s:message code="common.search" /></a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#frm_search').form('reset');"><s:message code="common.reset" /></a> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<div id="dlg_comment" class="easyui-dialog" style="width:750px;height:400px;" data-options="resizable:true,modal:true,closed: true">
		<iframe id="ifr_comment" style="border: 0; width: 100%; height: 100%; display: block" frameBorder="0" ></iframe>
	</div>
	
	<div id="dlg_purchase" class="easyui-dialog" style="width:730px;height:200px;" data-options="resizable:true,modal:true,closed: true, 
		onOpen: function() {formValidate('#frm_purchase', true);}, onClose: function() {formValidate('#frm_purchase', false);},
		<%-- buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){$('#frm_purchase').submit();}}]"> --%>
		buttons: [{text:'<s:message code="common.submit" />', iconCls:'icon-save', handler:function(){doSubmit();}}]">
		<form id="frm_purchase" method="post">
		<input id="hid_purchaseId" name="purchaseId" type="hidden"/>
		<input id="hid_editStatus" name="editStatus" type="hidden"/>
		
		<table class="mtftable" align="center">
			<tbody>
				<tr>
				<th align="right" style="width: 30px;">币种</th>
				<td>:</td>
				<td><select id="cbx_quoteCurrencyId" name="quoteCurrencyId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false,
				 onSelect: function(rec){ 
						$.post('${pageContext.request.contextPath}/maintenance/currency/doSearchForRatio.do', { 'id' : rec.value }, function(result) {
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
						<%-- 汇率行的隐藏和显示 --%>
						if(rec.value == 1){
							$('#tr_exchangeRate').prop('hidden',true);
						}else{
							$('#tr_exchangeRate').prop('hidden', false);
						}
					 }
				 ">
					<option value="1">RMB</option>
					<option value="2">USD</option>
					<option value="3">HKD</option>
					</select></td>
					
					<th align="right" style="width: 120px;">总金额</th>
					<td>:</td>
					<td align="center" valign="middle"><div style="width:95%"><input id="nbx_quoteTotalAmount" name="quoteTotalAmount" type="text" class="easyui-numberbox" style="width:150px" data-options=" precision:2, validType:'digitalCompare[0, 300000]', required:true" /></div></td>
						
				</tr>
				<tr id="tr_exchangeRate">
					<th align="right" style="width: 30px;">汇率</th>
					<td>:</td>
					<td><input id="nbx_exchangeRate" name="exchangeRate" class="easyui-numberbox" style="width:150px" data-options=" precision:4, validType:'digitalCompare[0, 100]', required:true " /></td>
					
					<th align="right" style="width: 120px;">换算总金额(RMB)</th>
					<td>:</td>
					<td align="center" valign="middle"><div style="width:95%"></div><input id="nbx_totalRmbAmount" name="totalRmbAmount" type="text" class="easyui-numberbox" readonly="readonly" style="width:150px" data-options="min:0, precision:2, required:true" /><div></td>
				</tr>
			</tbody>
		</table>
		</form>
		<table id="dtg_purchaseItem"></table>
	</div>
	
</body>
</html>
