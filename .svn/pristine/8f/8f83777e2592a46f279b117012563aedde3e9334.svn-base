<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>我的报销</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-datagrid-detailview.js?v=20141016" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/datagrid-detailview.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/jquery.edatagrid.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript">
var p_cat = ${categorysJson};
var p_div = ${divisionsJson};
var p_itemDiv = ${itemDivisionsJson};
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
			createUserId : '${sessionInfo.userId }',
			applicationDateFrom : getlastMonth(),
			applicationDateTo : getNow()
		},
		frozenColumns : [ [{
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
			width : 150
		},{
			title : '申请日期',
			field : 'applicantDivisionDate',
			sortable : true,
			align : 'center',
			width : 110
		},{
			title : '总金额',
			field : 'totalAmount',
			sortable : true,
			align : 'right',
			width : 100,
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
				}else{
					return '';
				}
			}
		},{
			title : '汇率',
			field : 'exchangeRate',
			sortable : true,
			align : 'right',
			width : 100,
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
			width : 100,
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
			width : 100,
			hiddable : true,
			hidden : true,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			}
		},{
			title : '状态',
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
			//$(this).datagrid('tooltip', ['applicantName']);
			
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
				iconCls : 'icon-add',
				text : '添加报销',
				handler : function() {
					$('#frm_reimbursement').form('clear');
					$('#dlg_reimbursement').dialog('setTitle', '添加报销').dialog('open').dialog('center');	
					$('#dtg_reimbursementItem').edatagrid('cancelRow');
					$('#dtg_reimbursementItem').datagrid('loadData',[]);
					//$('#dtg_reimbursementItem').edatagrid('editRow', 0); 
					//编辑状态1：添加，2：编辑
					$('#hid_editStatus').val(1);
					
					//默认选择
					$('#cbx_applicantDivisionId').combobox('selectIndex',1);
					$('#cbx_currencyId').combobox('selectIndex',0);
					
					//默认人民币汇率为1.0000
					$('#nbx_exchangeRate').numberbox('setValue', 1.0000);
					
					//隐藏输入框边框
					$('#nbx_totalAmount').next().css('border', '0px');
					$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
					$('#nbx_totalAmount').numberbox('setValue', '0.00');
				}
			} 
			, '-',{
				iconCls : 'icon-edit',
				text : '编辑报销',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					if(checkedRows[0].status != 0 && checkedRows[0].status != 3){
						$.messager.alert('<s:message code="common.dialog.tip" />', '【草稿】状态可以编辑，【已审核通过】可以重新编辑！', 'warning');
						return;
					}
					
					$('#frm_reimbursement').form('clear');
					$('#dlg_reimbursement').dialog('setTitle', '编辑报销').dialog('open').dialog('center');	
					$('#dtg_reimbursementItem').edatagrid('cancelRow');
					$('#dtg_reimbursementItem').datagrid('loadData',[]);
					$.post('${pageContext.request.contextPath}/office/reimbursement/reimbursement/doSearchById.do', { 'id' : checkedRows[0].id }, function(result) {
						$.messager.progress('close');// hide progress dialog
						try {
							var r = result;
							if (r.success) {
								 $('#frm_reimbursement').form('load', {
									'applicantDivisionId' : r.obj.dbReimbursement.applicantDivisionId,
									'currencyId' : r.obj.dbReimbursement.currencyId,
									'payeeName' : r.obj.dbReimbursement.payeeName,
									'applicantDivisionDate' : r.obj.dbReimbursement.applicantDivisionDate,
									'totalAmount' : r.obj.dbReimbursement.totalAmount,
									'exchangeRate' : r.obj.dbReimbursement.exchangeRate,
									'totalRmbAmount' : r.obj.dbReimbursement.totalRmbAmount,
									'actualTotalAmount' : r.obj.dbReimbursement.actualTotalAmount
								});
								$('#dtg_reimbursementItem').datagrid('loadData', r.obj.itemlist);
							} else {
								$.messager.alert('<s:message code="common.error" />', '报销相关信息查找失败！', 'error');
							}
						} catch (e) {
							$.messager.alert('<s:message code="common.error" />', result, 'error');
						}
					}, 'json');
					
					
					//编辑状态1：添加，2：编辑
					$('#hid_editStatus').val(2);
					
					
					//隐藏输入框边框
					$('#nbx_totalAmount').next().css('border', '0px');
					$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
				}
			} 
			, '-',  {
				iconCls : 'icon-save',
				text : '提交报销',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status == 1){
						$.messager.alert('<s:message code="common.dialog.tip" />', '已提交审批！', 'warning');
						return;
					}
					
					if(checkedRows[0].status != 0){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【草稿】状态可以提交审批！', 'warning');
						return;
					}
					$.messager.confirm('<s:message code="common.confirm" />', '确认提交报销？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/reimbursement/doEditStatusForSubmit.do', {id : checkedRows[0].id}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
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
			}, '-',  {
				iconCls : 'ext-icon-file_pdf',
				text : '打印报销',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status != 1 && checkedRows[0].status != 2){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【已提交】和【已审核通过】状态可以打印报销！', 'warning');
						return;
					}
					
					var no = checkedRows[0].no;
					var applicantDivisionDate = checkedRows[0].applicantDivisionDate;
					var payeeName = checkedRows[0].payeeName;
					var currencyId = checkedRows[0].currencyId;
					var totalAmount = checkedRows[0].totalAmount;
					var exchangeRate = checkedRows[0].exchangeRate;
					var totalRmbAmount = checkedRows[0].totalRmbAmount;
					var actualTotalAmount = checkedRows[0].actualTotalAmount;
					var applicantDivisionId = checkedRows[0].applicantDivisionId;
					var applicantDivisionName = checkedRows[0].applicantDivisionName;
					var amountTotalCn = chineseNumber(totalAmount);
					
					var applicantName = checkedRows[0].applicantName;
					var reimbursement = {
						'no' : no,
						'payeeName' : payeeName,
						'applicantDivisionId' : applicantDivisionId,
						'applicantDivisionName' : applicantDivisionName,
						'applicantDivisionDate' : applicantDivisionDate,
						'currencyId' : currencyId,
						'totalAmount' : totalAmount,
						'exchangeRate' : exchangeRate,
						'totalRmbAmount' : totalRmbAmount,
						'actualTotalAmount' : actualTotalAmount,
						'amountTotalCn' : amountTotalCn,
						'applicantName' : applicantName
					};
					
					var items = [];
					for (var i = 0; i < checkedRows[0].listReimbursementItem.length; i ++) {
						var category1Id = checkedRows[0].listReimbursementItem[i].category1Id;
						var category1Name = checkedRows[0].listReimbursementItem[i].category1Name;
						var category2Id = checkedRows[0].listReimbursementItem[i].category2Id;
						var category2Name = checkedRows[0].listReimbursementItem[i].category2Name;
						var description = checkedRows[0].listReimbursementItem[i].description;
						var amount = checkedRows[0].listReimbursementItem[i].amount;
						var index = checkedRows[0].listReimbursementItem[i].index;
						var divisionName = checkedRows[0].listReimbursementItem[i].divisionName;
						var customerName = checkedRows[0].listReimbursementItem[i].customerName;
						
						items.push({
							'category1Id' : category1Id,
							'category1Name' : category1Name,
							'category2Id' : category2Id,
							'category2Name' : category2Name,
							'description' : description,
							'amount' : amount,
							'index' : index,
							'divisionName' : divisionName,
							'customerName' : customerName
						});
					}

					$('#hid_reimbursementStr').val(JSON.stringify(reimbursement));
					$('#hid_reimbursementItemStr').val(JSON.stringify(items));
					
					$('#frm_pdfReport').submit();
				}
					
			}
			, '-',  {
				iconCls : 'ext-icon-cross',
				text : '取消报销',
				handler : function() {
					var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status != 0 && checkedRows[0].status != 3){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【草稿】和【未审核通过】状态可以取消报销！', 'warning');
						return;
					}
					$.messager.confirm('<s:message code="common.confirm" />', '确认取消报销？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/reimbursement/doDelete.do', {id : checkedRows[0].id}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '取消成功！', 'info', function(rr) {
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
			}, '-', {
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
				width : 148
			},{
 				title : '次类别',
				field : 'category2Name',
				align : 'left',
				width : 116
			},{
				title : '费用部门',
				field : 'divisionName',
				align : 'left',
				width : 110
			},{
				title : '客户',
				field : 'customerName',
				align : 'left',
				width : 110
			},{
				title : '金额',
				field : 'amount',
				align : 'right',
				width : 110,
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
				width : 205
			}]
		}
	});
	
//edatagrid reimbursement item
$('#dtg_reimbursementItem').edatagrid({
		fit : true,
		weight :550,
		height : 360, 
		border : false,
		idField : 'id',
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			hidden : true
		} ] ],
		columns : [ [ /* {
			title : 'purchaseItemId',
			field : 'purchaseItemId',
			width : 100
		} ,  */{
			title : '主类别',
			field : 'category1Id',
			width : 110,
			formatter : function(value, row, index) {
				return row.category1Name;
			},
			editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', data : getCat(0), panelHeight:'auto',panelMaxHeight:'200', editable:false,
							onSelect:function(rec){ 
								var row = $('#dtg_reimbursementItem').datagrid('getSelected');
								var rowIndex = $('#dtg_reimbursementItem').datagrid('getRowIndex',row);
								var target = $('#dtg_reimbursementItem').datagrid('getEditor', {'index':rowIndex,'field':'category2Id'}).target;
								target.combobox('clear');
								target.combobox('loadData', getCat(rec.id));
							}
						}
					}
		} ,{
			title : '次类别',
			field : 'category2Id',
			width : 100,
			formatter : function(value, row, index) {
				return row.category2Name;
			},
			editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', panelHeight:'auto', panelMaxHeight:'200',editable:false}  }
		} ,{
			title : '描述',
			field : 'description',
			width : 300,
			editor : { type : 'textbox',options : {validType:'length[0,100]'}}
		} ,{
			title : '金额',
			field : 'amount',
			align : 'right',
			width : 90,
			formatter : function(value, row, index) {
				if(value) {
					return numberFormat(value, 2);
				}
			},
			editor : { type : 'numberbox',options : {min:0, precision:2}}
		} ,{
			title : '费用部门',
			field : 'divisionId',
			width : 100,
			formatter : function(value, row, index) {
				return row.divisionName;
			},
			editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', data : getItemDiv(), panelHeight:'auto',panelMaxHeight:'200', editable:false}  }
		},{
			title : '客户',
			field : 'customerId',
			width : 100,
			formatter : function(value, row, index) {
				return row.customerName;
			}, 
			//editor : { type : 'combobox', options : {valueField : 'id', textField:'text', data: p_customerList, panelHeight:'auto', editable:false}  }
			editor : { type : 'combobox', options : {url : '${pageContext.request.contextPath}/maintenance/customer/doListTetrad.do?type=0&aps=1',
			valueField : 'first',textField : 'third', panelHeight:'auto',panelMaxHeight:'200', editable:false}  }
		} ] ],
		onBeforeSave : function(index) {
			var rows = $(this).datagrid('getRows');
			
			var category1Editor = $(this).datagrid('getEditor', {index : index, field : 'category1Id'});
			var category1Id = $(category1Editor.target[0]).combobox('getValue');			
			var category1Name = $(category1Editor.target[0]).combobox('getText');			
			rows[index].category1Id = category1Id;
			rows[index].category1Name = category1Name;
			
			var category2Editor = $(this).datagrid('getEditor', {index : index, field : 'category2Id'});
			var category2Id = $(category2Editor.target[0]).combobox('getValue');			
			var category2Name = $(category2Editor.target[0]).combobox('getText');			
			rows[index].category2Id = category2Id;
			rows[index].category2Name = category2Name;
			
			var divisionEditor = $(this).datagrid('getEditor', {index : index, field : 'divisionId'});
			var divisionName = $(divisionEditor.target[0]).combobox('getText');			
			rows[index].divisionName = divisionName;
			
			var customerEditor = $(this).datagrid('getEditor', {index : index, field : 'customerId'});
			var customerName = $(customerEditor.target[0]).combobox('getText');			
			rows[index].customerName = customerName;
		},
		onSelect : function(index, row) {
			//编辑后取消提交需要
			$('#dtg_reimbursementItem').edatagrid('editRow', index);
			var category2IdTarget = $('#dtg_reimbursementItem').datagrid('getEditor', {'index':index,'field':'category2Id'}).target;
			//target.combobox('clear');
			if(row.category1Id != null && row.category1Id != ''){
				category2IdTarget.combobox('loadData', getCat(row.category1Id)).combobox('setValue', row.category2Id);
			}
			
			//绑定报销金额
			var amountTarget = $('#dtg_reimbursementItem').datagrid('getEditor', {'index':index,'field':'amount'}).target;
			amountTarget.numberbox({
				onChange : function(newValue, oldValue){
					var allRows = $('#dtg_reimbursementItem').edatagrid('getRows');
					var totalAmount = 0.0;
					totalAmount = newValue*1.0;
					for(var i = 0; i < allRows.length; i++ ){
						//选择记录不是编辑状态的（编辑状态取的取新值）
						if( index != i){
							totalAmount += allRows[i].amount*1.0;
							//console.info(allRows[i].amount);
						}
					}
					//console.info(totalAmount*1.00);
					$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
				},
				inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
					keyup:function(e){
						var newValue = e.target.value;
						var allRows = $('#dtg_reimbursementItem').edatagrid('getRows');
						var totalAmount = 0.0;
						totalAmount = newValue*1.0;
						for(var i = 0; i < allRows.length; i++ ){
							//选择记录不是编辑状态的（编辑状态取的取新值）
							if( index != i){
								totalAmount += allRows[i].amount*1.0;
								//console.info(allRows[i].amount);
							}
						}
						//console.info(totalAmount*1.00);
						$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
					}
				})
				
			});
			
		},
		toolbar : [  {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				$('#dtg_reimbursementItem').edatagrid('saveRow');
				var rows = $('#dtg_reimbursementItem').datagrid('getRows');
				var lastRowIndex = rows.length;
				if(lastRowIndex > 5){
					$.messager.alert('<s:message code="common.dialog.tip" />', '最多添加6项报销记录！', 'warning'); 
					return;
				}
			 	/* if(rows.length > 0) {
					var row = rows[lastRowIndex -1];
					$('#dtg_reimbursementItem').datagrid('appendRow',{
						description : row.description
					});
				} else {
					$('#dtg_reimbursementItem').datagrid('appendRow',{
						description : ''
					});
				}  */
			 	$('#dtg_reimbursementItem').datagrid('appendRow',{});
				$('#dtg_reimbursementItem').edatagrid('editRow', lastRowIndex);	
				$('#dtg_reimbursementItem').edatagrid('selectRow', lastRowIndex);	
				
				//部门下拉如果是一项就自动填充
				var countRows = $('#dtg_reimbursementItem').datagrid('getRows').length -1;
				var divisionEditor = $('#dtg_reimbursementItem').datagrid('getEditor', {index : countRows, field : 'divisionId'});
				if($(divisionEditor.target[0]).length == 1){
					$(divisionEditor.target[0]).combobox('selectIndex', 1);
				}
			}
		}, '-',  {
			iconCls : 'icon-edit',
			text : '<s:message code="common.edit" />',
			handler : function() {
				var selectedRow = $('#dtg_reimbursementItem').edatagrid('getSelected');
				if(!selectedRow){
					return;
				}
				var selectedIndex = $('#dtg_reimbursementItem').edatagrid('getRowIndex', selectedRow);
				$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
				$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
			}
		}, '-',  {
			iconCls : 'icon-remove',
			text : '<s:message code="common.remove" />',
			handler : function() {
				var rows = $('#dtg_reimbursementItem').edatagrid('getRows');
				 if(rows.length < 2){
					return;
				} 
				
				var selectedRow = $('#dtg_reimbursementItem').edatagrid('getSelected');
				if(!selectedRow){
					return;
				}
				
				var selectedIndex = $('#dtg_reimbursementItem').edatagrid('getRowIndex', selectedRow);
				$('#dtg_reimbursementItem').edatagrid('deleteRow', selectedIndex);
				
				//var rows = $('#dtg_reimbursementItem').datagrid('getRows');
				if(rows.length == 0){
					return;
				}
				if(selectedIndex < rows.length){
					$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
					$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
				}else{
					$('#dtg_reimbursementItem').edatagrid('editRow', rows.length - 1);
					$('#dtg_reimbursementItem').edatagrid('selectRow', rows.length - 1);
				}
				
				//删除时重新计算总金额
				var allRows = $('#dtg_reimbursementItem').edatagrid('getRows');
				var totalAmount = 0.0;
				for(var i = 0; i < allRows.length; i++ ){
					totalAmount += allRows[i].amount*1.0;
					//console.info(allRows[i].amount);
				}
				//console.info(totalAmount*1.00);
				$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
			}
		}, '-',  {
			iconCls : 'icon-save',
			text : '<s:message code="导入采购信息" />',
			handler : function() {
				
				$('#frm_search_load').form('clear');
				 $('#dtg_purchaseItem_load').datagrid('loadData',[]);
				$('#dlg_purchaseItem').dialog('setTitle', '导入采购信息').dialog('open').dialog('center');
			}
		} ]
	});
	



$('#dtg_purchaseItem_load').datagrid({
	fit : true,
	border : false,
	pagination : true,
	url : '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearchWithPurchase.do',
	idField : 'id',
	//weight :550,
	//height : 200, 
	striped : true,
	border : false,
	idField : 'id',
	/* sortName : 'purchaseCompleteDate',
	sortOrder : 'desc', */
	nowrap : true,
	rownumbers : true,
	autoRowHeight : false,
	frozenColumns : [ [  {
		title : '',
		field : 'ck',
		width : 25,
		checkbox : true
	},{
		title : 'ID',
		field : 'id',
		width : 0,
		sortable : false,
		hidden : true
	} ] ],
	columns : [ [{
		title : 'NO.',
		field : 'purchase',
		width : 50,
		sortable : false ,
		formatter : function(value, row, index){
			return value.no;
		} 
	},{
		title : '部门',
		field : 'divisionName',
		width : 100,
		sortable : false
	},{
		title : '客户',
		field : 'customerName',
		width : 100,
		sortable : false
	},{
		title : '主类别',
		field : 'category1Name',
		width : 100,
		sortable : false
	},{
		title : '次类别',
		field : 'category2Name',
		width : 100,
		sortable : false
	},{
		title : '描述',
		field : 'description',
		width : 200,
		sortable : false
	},{
		title : '金额',
		field : 'quoteAmount',
		width : 70,
		align : 'right',
		sortable : false,
		formatter : function(value, row, index) {
			if(value) {
				return numberFormat(value, 2);
			}
		}
	},{
		title : '采购完成时间',
		field : 'purchaseCompleteDate',
		width : 140,
		align : 'center',
		sortable : false
	},{
		title : '已报销',
		field : 'isReimbursed',
		width : 55,
		align : 'center',
		sortable : false,
		/* hidden : true,
		hiddable : true, */
		formatter : function(value, row, index){
			if(value == 1){
				return 'Y';
			}
		}
	}] ],
	onLoadSuccess : function(data) {
		$(this).datagrid('clearSelections');
		$(this).datagrid('tooltip', ['description']);
	}
});
	
	$('#frm_reimbursement').form({
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (isValid) {
				var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
				if(checkedRows[0] != undefined){
					$('#hid_reimbursementId').val(checkedRows[0].id);
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
					$.messager.alert('<s:message code="common.tip" />', '保存成功！', 'info', function(rr) {
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
	
	$('#frm_search_load :text').keydown(function(e) {
		handleEnterKey(e, submitSearchLoadForm);
	});
	
	//清空多选框里的值
	$('#cbx_statuses').combobox('clear');
	
	//设置值
	$('#dtx_applicationDateFrom').datebox('setValue',new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()-30).toString() );
	$('#dtx_applicationDateTo').datebox('setValue', new Date().toString());
	
	
	//汇率和总金额keyup事件
	/* $('#nbx_exchangeRate').numberbox({
		inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
			keyup:function(e){
				var newValue = e.target.value;
				var quoteAmount = $('#nbx_totalAmount').numberbox('getValue');
				//console.info(quoteTotalAmount);
				if(quoteAmount == '' || quoteAmount == null){
					quoteAmount = 0.00;
				}
				$('#nbx_totalRmbAmount').numberbox('setValue', newValue*quoteAmount);
			}
		})
	}) */
	
	/* $('#nbx_totalAmount').numberbox({
		inputEvents:$.extend({},$.fn.numberbox.defaults.inputEvents,{
			keyup:function(e){
				var newValue = e.target.value;
				var exchangeRate = $('#nbx_exchangeRate').numberbox('getValue');
				if(exchangeRate == '' || exchangeRate == null){
					exchangeRate = 0.00;
				}
				$('#nbx_totalRmbAmount').numberbox('setValue', newValue*exchangeRate);
			}
		})
	}) */
	
	//汇率和总金额变化事件
	/* $('#nbx_exchangeRate').numberbox({
		onChange : function(newValue, oldValue){
			var totalAmount = $('#nbx_totalAmount').numberbox('getValue');
			if(totalAmount == '' || totalAmount == null){
				totalAmount = 0.00;
			}
			$('#nbx_totalRmbAmount').numberbox('setValue', newValue*totalAmount);
		}
	});
	$('#nbx_totalAmount').numberbox({
		onChange : function(newValue, oldValue){
			var exchangeRate = $('#nbx_exchangeRate').numberbox('getValue');
			if(exchangeRate == '' || exchangeRate == null){
				exchangeRate = 0.00;
			}
			$('#nbx_totalRmbAmount').numberbox('setValue', newValue*exchangeRate);
		}
	}); */
	
})


function doSubmit(param) {
	var isValid = $('#frm_reimbursement').form('validate');
	if (isValid == false) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写！', 'warning'); 
		return;
	}
	
	var rows = $('#dtg_reimbursementItem').datagrid('getRows');
	if(rows.length == 0){
		$.messager.alert('<s:message code="common.dialog.tip" />', '请添加报销明细！', 'warning'); 
		return;
	}
	
	if(rows.length > 6){
		$.messager.alert('<s:message code="common.dialog.tip" />', '最多提交六项！', 'warning'); 
		return;
	} 
	
	var url = undefined;
	var divisionId = $('#cbx_applicantDivisionId').combobox('getValue');
	var divisionName = $('#cbx_applicantDivisionId').combobox('getText');
	var currencyId = $('#cbx_currencyId').combobox('getValue');
	var payeeName = $('#txt_payeeName').textbox('getValue');
	
	var totalAmount = $('#nbx_totalAmount').numberbox('getValue');
	//汇率相关
	//var exchangeRate = $('#nbx_exchangeRate').numberbox('getValue');
	//var totalRmbAmount = $('#nbx_totalRmbAmount').numberbox('getValue');
	//var actualTotalAmount = $('#nbx_actualTotalAmount').numberbox('getValue');
	
	if(divisionId == null || divisionId == ""){
		$.messager.alert('<s:message code="common.dialog.tip" />', '请添加费用部门！', 'warning');
		return;
	}
	if(payeeName == null || payeeName == ""){
		$.messager.alert('<s:message code="common.dialog.tip" />', '请填写收款人！', 'warning');
		return;
	}
	/* if(currencyId != '1'){
		if(exchangeRate == null || exchangeRate == ""){
			$.messager.alert('<s:message code="common.dialog.tip" />', '请填写汇率！', 'warning');
			return;
		}
		if(totalRmbAmount == null || totalRmbAmount == ""){
			$.messager.alert('<s:message code="common.dialog.tip" />', '请填写换算总金额！', 'warning');
			return;
		}
		if(actualTotalAmount == null || actualTotalAmount == ""){
			$.messager.alert('<s:message code="common.dialog.tip" />', '请填写实际总金额！', 'warning');
			return;
		}
	}else{
		actualTotalAmount = 0.0;
	} */
	
	
	
	//若未通过，选择重新编辑
	var selectedRow = $('#dtg_reimbursementItem').edatagrid('getSelected');
	var selectedIndex = $('#dtg_reimbursementItem').edatagrid('getRowIndex', selectedRow);
	if($('#hid_editStatus').val() == 1){
		//1添加
		url = '${pageContext.request.contextPath}/office/reimbursement/reimbursement/doAdd.do';
		$('#dtg_reimbursementItem').edatagrid('saveRow');
		//公用信息
		
		
		var form = {
			'status' : param ,
			'applicantDivisionId' : divisionId,
			'applicantDivisionName' : divisionName,
			'currencyId' : currencyId,
			'payeeName' : payeeName,
			'totalAmount' : totalAmount
			//'exchangeRate' : exchangeRate,
			//'totalRmbAmount' : totalRmbAmount,
			//'actualTotalAmount' : actualTotalAmount
		};
		//批量添加信息
		var arr = [];
		
		for(var i = 0;i < rows.length;i++){
			
			
			if(rows[i].category1Id == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写主类别！', 'warning');
				$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
				$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
				return;
			}
			if(rows[i].category2Id == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写次类别！', 'warning');
				$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
				$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
				return;
			}
			var isDescExist = rows[i].hasOwnProperty('description');
			if(isDescExist == false){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请正确填写描述！', 'warning');
				return;
			}else{
				if(rows[i].description.trim() == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写描述！', 'warning');
					$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
					$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
					return;
				}
			}
			
			
			if(rows[i].amount == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写金额！', 'warning');
				$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
				$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
				return;
			}
			
			if(rows[i].divisionId == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写部门！', 'warning'); 
				$('#dtg_reimbursementItem').edatagrid('editRow', selectedIndex);
				$('#dtg_reimbursementItem').edatagrid('selectRow', selectedIndex);
				return;
			}
			
			 var row = {
					'purchaseItemId' : rows[i].purchaseItemId,
					'category1Id' : rows[i].category1Id,
					'category1Name' : rows[i].category1Name,
					'category2Id' : rows[i].category2Id,
					'category2Name' : rows[i].category2Name,
					'amount' : rows[i].amount,
					'description' : rows[i].description,
					'divisionId' : rows[i].divisionId,
					'divisionName' : rows[i].divisionName,
					'customerId' : rows[i].customerId,
					'customerName' : rows[i].customerName,
					'index' : i
				};
			arr.push(row);
		}
	}else{
		//2编辑
		url = '${pageContext.request.contextPath}/office/reimbursement/reimbursement/doEdit.do';
		var checkedRows = $('#dtg_reimbursement').datagrid('getSelections');
		$('#dtg_reimbursementItem').edatagrid('saveRow');
		//公用信息
		var form = {
			'id' : checkedRows[0].id,
			'no' : checkedRows[0].no,
			'status' : param,
			'applicantDivisionId' : divisionId,
			'applicantDivisionName' : divisionName,
			'currencyId' : currencyId,
			'payeeName' : payeeName,
			'totalAmount' : totalAmount
			//'exchangeRate' : exchangeRate,
			//'totalRmbAmount' : totalRmbAmount,
			//'actualTotalAmount' : actualTotalAmount
		};
		//批量添加信息
		var arr = [];
		
		for(var i = 0;i < rows.length;i++){
			if(rows[i].category1Id == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写主类别！', 'warning'); 
				return;
			}
			if(rows[i].category2Id == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写次类别！', 'warning'); 
				return;
			}
			if(isDescExist == false){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请正确填写描述！', 'warning');
				return;
			}else{
				if(rows[i].description.trim() == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写描述！', 'warning'); 
					return;
				}
			}
				
			if(rows[i].amount == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写金额！', 'warning'); 
				return;
			}
			
			if(rows[i].divisionId == ''){
				$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写部门！', 'warning'); 
				return;
			}
			
			var row = {
				'purchaseItemId' : rows[i].purchaseItemId,
				'category1Id' : rows[i].category1Id,
				'category1Name' : rows[i].category1Name,
				'category2Id' : rows[i].category2Id,
				'category2Name' : rows[i].category2Name,
				'amount' : rows[i].amount,
				'description' : rows[i].description,
				'divisionId' : rows[i].divisionId,
				'divisionName' : rows[i].divisionName,
				'customerId' : rows[i].customerId,
				'customerName' : rows[i].customerName,
				'index' : i
				};
			arr.push(row);
		}
	}
	
	
	form.reimbursementItemStr = JSON.stringify(arr);
	
	$.messager.confirm('<s:message code="common.confirm" />', '确认提交？', function(rr) {
		if (rr) {
			$.post(url, form, function(result) {
				try {
					var j = result;
					if (j.success) {
						$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
							$('#dlg_reimbursement').dialog('close');
							$('#dtg_reimbursement').datagrid('reload');
							//$('#dtg_reimbursementItem').edatagrid('loadData',[]); 
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
	
	
}

function getCat(pid) {
	if(pid === ''){
		return [];
	}
	
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_cat.length; i ++) {
		if (p_cat[i].pid == pid) {
			level.push({'id':p_cat[i].id, 'text':p_cat[i].categoryName});
		}
	}
	return level;
}

function getDiv() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_div.length; i ++) {
		level.push({'id':p_div[i].id, 'text':p_div[i].name});
	}
	return level;
}

function getItemDiv() {
	var level = [];
	level.push({id:'', text:''});
	for (var i = 0; i < p_itemDiv.length; i ++) {
		level.push({'id':p_itemDiv[i].id, 'text':p_itemDiv[i].name});
	}
	return level;
}

function doAddItem() {
	var checkedRows = $('#dtg_purchaseItem_load').datagrid('getChecked');
	var rows = $('#dtg_reimbursementItem').datagrid('getRows');
	if(checkedRows[0] == undefined){
		$.messager.alert('<s:message code="common.dialog.tip" />', '没有选择！', 'warning');
		return;
	}
	
	var totalRows = rows.length + checkedRows.length;
	if(totalRows > 6 ){
		$.messager.alert('<s:message code="common.dialog.tip" />', '导入项过多，最多6条报销记录！', 'warning');
		return;
	}
	
	for(var i = 0; i < checkedRows.length; i++){
		$('#dtg_reimbursementItem').datagrid('appendRow',{
			category1Id : checkedRows[i].category1Id,
			category1Name : checkedRows[i].category1Name,
			category2Id : checkedRows[i].category2Id,
			category2Name : checkedRows[i].category2Name,
			purchaseItemId : checkedRows[i].id,
			description : checkedRows[i].description,
			amount : checkedRows[i].quoteAmount,
			divisionId : checkedRows[i].divisionId,
			divisionName : checkedRows[i].divisionName,
			customerId : checkedRows[i].customerId,
			customerName : checkedRows[i].customerName,
			purchaseItemId : checkedRows[i].id
		});
	}
	
	//导入时重新计算总金额
	$('#dtg_reimbursementItem').edatagrid('saveRow');
	var allRows = $('#dtg_reimbursementItem').edatagrid('getRows');
	
	//绑定报销金额
	var totalAmount = 0.0;
	for(var i = 0; i < allRows.length; i++ ){
			totalAmount += allRows[i].amount*1.0;
			//console.info(allRows[i].amount);
	}
	//console.info(totalAmount*1.00);
	$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
	
	$('#dlg_purchaseItem').dialog('close');
}

function submitSearchForm() {
	var $dtg = $('#dtg_reimbursement');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/reimbursement/doSearch.do?createUserId=${sessionInfo.userId }';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search')));
}

function submitSearchLoadForm() {
	var $dtg = $('#dtg_purchaseItem_load');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearchWithPurchase.do';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search_load')));
}

function chineseNumber(num) {
	if (isNaN(num) || num > Math.pow(10, 12))
		return "";
	if(num == 0){
		return "零元整";
	}
	
	var cn = "零壹贰叁肆伍陆柒捌玖";
	var unit = new Array("拾百千", "分角");
	var unit1 = new Array("万亿", "");
	var numArray = num.toString().split(".");
	var start = new Array(numArray[0].length - 1, 2);

	function toChinese(num, index) {
		var num = num.replace(/\d/g, function($1) {
			return cn.charAt($1) + unit[index].charAt(start-- % 4 ? start % 4 : -1);
		})
		return num;
	}

	for (var i = 0; i < numArray.length; i++) {
		var tmp = ""
		for (var j = 0; j * 4 < numArray[i].length; j++) {
			var strIndex = numArray[i].length - (j + 1) * 4;
			var str = numArray[i].substring(strIndex, strIndex + 4);
			var start = i ? 2 : str.length - 1;
			var tmp1 = toChinese(str, i);
			tmp1 = tmp1.replace(/(零.)+/g, "零").replace(/零+$/, "");
			tmp1 = tmp1.replace(/^壹拾/, "拾");
			tmp = (tmp1 + unit1[i].charAt(j - 1)) + tmp;
		}
		numArray[i] = tmp
	}

	numArray[1] = numArray[1] ? numArray[1] : "";
	numArray[0] = numArray[0] ? numArray[0] + "元" : numArray[0], numArray[1] = numArray[1].replace(/^零+/, "");
	numArray[1] = numArray[1].match(/分/) ? numArray[1] : numArray[1] + "整";
	return numArray[0] + numArray[1];
}

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
		<input  name="createUserId" value="${sessionInfo.userId}" type="hidden"/>
			<table class="mtftable">
				<tr>
					<th align="right" style="width: 80px;">NO.</th>
					<td>:</td>
					<td><input name="no" class="easyui-textbox" style="width: 200px"/></td>
					<th align="right" style="width: 80px;">申请时间</th>
					<td>:</td>
					<td><input id="dtx_applicationDateFrom" name="applicationDateFrom" class="easyui-datebox" style="width: 120px" data-options="editable:false"/> - <input id="dtx_applicationDateTo" name="applicationDateTo" class="easyui-datebox" style="width: 120px" data-options="editable:false "/></td>  
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th align="right" style="width: 80px;">采购状态</th>
					<td>:</td>
					<td><select id="cbx_statuses" name="statuses" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto', panelMaxHeight:'200',editable:false, multiple:true">
					<option value="0">草稿</option>
					<option value="1">已提交</option>
					<option value="2">审核通过</option>
					<option value="3">审核未通过</option>
					<!-- <option value="9">取消</option> -->
					</select></td>
					
					<th align="right">申请部门</th>
					<td>:</td>
					<td><div name="applicantdivisionId" class="easyui-combobox" style="width:257px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getDiv() "></div>
					
					<td colspan="3" align="center">
						<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchForm();"><s:message code="common.search" /></a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#frm_search').form('reset'); $('#cbx_statuses').combobox('clear');"><s:message code="common.reset" /></a> 
					</td>
				</tr>
			</table>
		</form>
	</div>
	<div id="dlg_reimbursement" class="easyui-dialog" style="width:850px;height:365px;" data-options="resizable:true,modal:true,closed: true, 
		onOpen: function() {formValidate('#frm_reimbursement', true);}, onClose: function() {formValidate('#frm_reimbursement', false);},
		buttons: [{text:'<s:message code="保存为草稿" />', iconCls:'icon-save', handler:function(){doSubmit(0);}},
		{text:'<s:message code="保存并提交" />', iconCls:'icon-save', handler:function(){doSubmit(1);}} ]">
		<form id="frm_reimbursement" method="post">
			<input id="hid_reimbursementId" name="reimbursementId" type="hidden"/>
			<input id="hid_editStatus" name="editStatus" type="hidden"/>
			<table class="mtftable" align="center">
				<tbody>
					<tr>
					<th align="right" style="width: 80px;">申请报销部门</th>
					<td>:</td>
					<td><div id="cbx_applicantDivisionId" name="applicantDivisionId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getDiv() , required:true "></div>
					<th align="right" style="width: 80px;">收款人</th>
					<td>:</td>
					<td><input id="txt_payeeName" name ="payeeName" type="textbox" class="easyui-textbox" style="width:150px" data-options="required:true "/></td>
					</tr>
			
					<tr>
					<th align="right" style="width: 80px;">总金额</th>
					<td>:</td>
					<td align="center" valign="middle"><div style="width:95%"><input id="nbx_totalAmount" name="totalAmount" type="text" class="easyui-numberbox" readonly="readonly" style="width:150px" data-options=" precision:2, validType:'digitalCompare[0, 300000]', required:true" /></div></td>
					<th align="right"style="width: 80px;">货币</th>
					<td>:</td>
					<td><select id="cbx_currencyId" name="currencyId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, required:true">
						<option value="1">RMB</option>
						<option value="2">USD</option>
						<option value="3">HKD</option>
						</select></td>
					</tr>
		
				<!-- <tr id="tr_exchangeRate">
					<th align="right" style="width: 100px;">汇率</th>
					<td>:</td>
					<td><input id="nbx_exchangeRate" name="exchangeRate" value="1.0000" class="easyui-numberbox" style="width:150px" data-options="min:0, max:1000, precision:4, required:true " /></td>
					<th align="right" style="width: 100px;">换算总金额(RMB)</th>
					<td>:</td>
					<td><input id="nbx_totalRmbAmount" name="totalRmbAmount" type="text" class="easyui-numberbox"  readonly="readonly" style="width:150px" data-options="min:0, precision:2, required:true " /></td>
					<th align="right" style="width: 100px;">实际总金额(RMB)</th>
					<td>:</td>
					<td><input id="nbx_actualTotalAmount" name="actualTotalAmount" type="text" class="easyui-numberbox" style="width:150px" data-options="min:0, max:99999*7, precision:2" /></td>
				</tr> -->
				</tbody>
			</table>
		</form>
		<table id="dtg_reimbursementItem"></table>
	</div>
	
	
	<div id="dlg_purchaseItem" class="easyui-dialog" style="width:1000px;height:400px;" data-options="resizable:true,modal:true,closed: true, 
	onOpen: function() {formValidate('#frm_search_load', true); submitSearchLoadForm()}, onClose: function() {formValidate('#frm_search_load', false);},
		buttons: [{text:'<s:message code="增加" />', iconCls:'icon-add', handler:function(){doAddItem();}} ]">
		<div align="center">
			<form id="frm_search_load"  method="post">
				<table class="mtftable">
					<tr>
						<th align="right" style="width: 80px;">NO.</th>
						<td>:</td>
						<td><input name="no" class="easyui-textbox" style="width: 100px"/></td>
						
						<th align="right" style="width: 80px;">是否已报销</th>
						<td>:</td>
						<td><select name="isReimbursed" class="easyui-combobox" style="width:100px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false ">
						<option value=""></option>
						<option value="1">是</option>
						<option value="0">否</option></select></td>
						<td>
							<a id="btn_search" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="javascript:submitSearchLoadForm();"><s:message code="common.search" /></a>
							<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="javascript:$('#frm_search_load').form('reset'); "><s:message code="common.reset" /></a> 
						</td>
					</tr>
				</table>
			</form>
		</div>
		<table id="dtg_purchaseItem_load"></table>
	</div>
	<div>
		<form id="frm_pdfReport" method="post" action="${pageContext.request.contextPath}/office/reimbursement/reimbursement/doPdfReport.do" target="_blank">
			<input id="hid_reimbursementStr" name="reimbursementStr" value="" type="hidden"/>
			<input id="hid_reimbursementItemStr" name="reimbursementItemStr" value="" type="hidden"/>
		</form>
	</div>
</body>
</html>
