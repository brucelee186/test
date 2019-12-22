<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>我的申请</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-datagrid-detailview.js?v=20141016" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/datagrid-detailview.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/jquery.edatagrid.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript">
var p_cat = ${categorysJson};
var p_div = ${divisionsJson};
var p_itemDiv = ${itemDivisionsJson};
var p_expandId = undefined;
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
			statusGroup : '${purchase.statusGroup}',
			createUserId : '${sessionInfo.userId}',
			applicationDateFrom : getlastMonth(),
			applicationDateTo : getNow()
		},
		frozenColumns : [ [ {
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
			width : 150
		},{
			title : '申请部门',
			field : 'applicantdivisionName',
			sortable : true,
			width : 150
		},{
			title : '申请日期',
			field : 'applicantDatetime',
			align : 'center',
			sortable : true,
			width : 110
		},{
			title : '估算总金额',
			field : 'quoteTotalAmount',
			sortable : true,
			align : 'right',
			width : 150,
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
			title : '采购审批',
			field : 'appLevel',
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
			width : 26,
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
			//$(this).datagrid('tooltip', ['applicantName']);
			
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
				iconCls : 'icon-add',
				text : '添加申请',
				handler : function() {
					$('#frm_purchase').form('clear');
					$('#dlg_purchase').dialog('setTitle', '添加申请').dialog('open').dialog('center');	
					$('#dtg_purchaseItem').edatagrid('cancelRow');
					$('#dtg_purchaseItem').datagrid('loadData',[]);
					//$('#dtg_purchaseItem').edatagrid('editRow', 0); 
					//编辑状态1：添加，2：编辑
					$('#hid_editStatus').val(1);
					
					$('#cbx_applicantdivisionId').combobox('selectIndex',1);
				}
			} 
			, '-',{
				iconCls : 'icon-edit',
				text : '编辑申请',
				handler : function() {
					
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					if(checkedRows[0].status != 0 &&checkedRows[0].status != 8){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【草稿】和【拒绝】状态可以编辑！', 'warning');
						return;
					}
					
					$('#frm_purchase').form('clear');
					$('#dlg_purchase').dialog('setTitle', '编辑申请').dialog('open').dialog('center');
					/* $('#dtg_purchaseItem').edatagrid('cancelRow');
					$('#dtg_purchaseItem').datagrid('loadData',[]); */
					
					
					$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doSearchById.do', { 'id' : checkedRows[0].id }, function(result) {
						$.messager.progress('close');// hide progress dialog
						try {
							var r = result;
							if (r.success) {
								
								 $('#frm_purchase').form('load', {
									 'applicantdivisionId' : r.obj.dbPurchase.applicantdivisionId,
									 'divisionId' : r.obj.itemlist[0].divisionId,
									 'customerId' : r.obj.itemlist[0].customerId,
									 'category1Id' : r.obj.itemlist[0].category1Id,
									 'category2Id' : r.obj.itemlist[0].category2Id,
									 'description' : r.obj.itemlist[0].description
									 
								});
								 var catId =$('#cbx_category1Id').combobox('getValue');
								 $('#cbx_category2Id').combobox('clear').combobox('loadData', getCat(catId)).combobox('setValue', r.obj.itemlist[0].category2Id);
							} else {
								$.messager.alert('<s:message code="common.error" />', '采购相关信息查找失败！', 'error');
							}
						} catch (e) {
							$.messager.alert('<s:message code="common.error" />', result, 'error');
						}
					}, 'json');
					
					
				/* 	var $dtg = $('#dtg_purchaseItem');
					var opt = $dtg.datagrid('options');
					opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearch.do?purchaseId=' + checkedRows[0].id;
					$dtg.datagrid('options', opt);
					
					$dtg.datagrid('load'); */
					
					//编辑状态1：添加，2：编辑
					$('#hid_editStatus').val(2);
					
				}
			} 
			, '-',  {
				iconCls : 'icon-save',
				text : '提交申请',
				handler : function() {
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
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
					$.messager.confirm('<s:message code="common.confirm" />', '确认提交申请？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doEditStatusSubmit.do', {id : checkedRows[0].id}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
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
			}
			, '-',  {
				iconCls : 'ext-icon-ticks',
				text : '确认完成采购',
				handler : function() {
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					if(checkedRows[0].status == 6){
						$.messager.alert('<s:message code="common.dialog.tip" />', '已确认采购！', 'warning');
						return;
					}
					
					if(checkedRows[0].status != 5){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【已采购】状态可以编辑！', 'warning');
						return;
					}
					
					$.messager.confirm('<s:message code="common.confirm" />', '确定完成采购？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doEditStatusComplete.do', {id : checkedRows[0].id}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
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
			}, '-',  {
				iconCls : 'ext-icon-cross',
				text : '取消申请',
				handler : function() {
					var checkedRows = $('#dtg_purchase').datagrid('getSelections');
					if(checkedRows[0] == undefined){
						return;
					}
					
					
					if(checkedRows[0].status != 0){
						$.messager.alert('<s:message code="common.dialog.tip" />', '只有【草稿】状态可以取消申请！', 'warning');
						return;
					}
					$.messager.confirm('<s:message code="common.confirm" />', '确认取消申请？', function(rr) {
						if(rr){
							$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doDelete.do', {id : checkedRows[0].id}, function(result){
								$.messager.progress('close');// hide progress dialog
								try {
									var j = result;
									if (j.success) {
										$.messager.alert('<s:message code="common.tip" />', '取消成功！', 'info', function(rr) {
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
				width : 305
			},{
				title : '金额',
				field : 'quoteAmount',
				align : 'right',
				width : 100,
				formatter : function(value, row, index) {
					if(value) {
						return numberFormat(value, 2);
					}
				}
			}]
		}
	});
	
//edatagrid purchase item
$('#dtg_purchaseItem').edatagrid({
		fit : true,
		//url : '${pageContext.request.contextPath}/office/reimbursement/purchaseItem/doSearch.do' ,
		weight :550,
		height : 360, 
		border : false,
		idField : 'id',
		sortName : '`index`',
		sortOrder : 'asc',
		nowrap : true,
		rownumbers : true,
		autoRowHeight : false,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'id',
			width : 0,
			hidden : true
		} ] ],
		columns : [ [ {
			title : '主类别',
			field : 'category1Id',
			width : 100,
			formatter : function(value, row, index) {
				return row.category1Name;
			},
			editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', data : getCat(0), panelHeight:'auto',panelMaxHeight:'200', editable:false,
							onSelect:function(rec){ 
								var row = $('#dtg_purchaseItem').datagrid('getSelected');
								var rowIndex = $('#dtg_purchaseItem').datagrid('getRowIndex',row);
								var target = $('#dtg_purchaseItem').datagrid('getEditor', {'index':rowIndex,'field':'category2Id'}).target;
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
			editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', panelHeight:'auto',panelMaxHeight:'200', editable:false}  }
		} , {
			title : '描述',
			field : 'description',
			width : 200,
			editor : { type : 'textbox'}
		} ,{
			title : '部门',
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
		onSelect: function(index, row) {
			var target = $('#dtg_purchaseItem').datagrid('getEditor', {'index':index,'field':'category2Id'}).target;
			//target.combobox('clear');
			target.combobox('loadData', getCat(row.category1Id)).combobox('setValue', row.category2Id);
		},
		onBeforeSave: function(index) {
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
		toolbar : [  {
			iconCls : 'icon-add',
			text : '<s:message code="common.add" />',
			handler : function() {
				$('#dtg_purchaseItem').edatagrid('saveRow');
				var rows = $('#dtg_purchaseItem').datagrid('getRows');
				var lastRowIndex = rows.length;
				
				/* if(rows.length > 0) {
					var row = rows[lastRowIndex -1];
					$('#dtg_purchaseItem').datagrid('appendRow',{
						description : row.description
					});
				} else {
					$('#dtg_purchaseItem').datagrid('appendRow',{
						description : ''
					});
				}  */
				$('#dtg_purchaseItem').datagrid('appendRow',{});
				$('#dtg_purchaseItem').edatagrid('editRow', lastRowIndex);	
				$('#dtg_purchaseItem').edatagrid('selectRow', lastRowIndex);	
			}
		}, '-',  {
			iconCls : 'icon-edit',
			text : '<s:message code="common.edit" />',
			handler : function() {
				var selectedRow = $('#dtg_purchaseItem').edatagrid('getSelected');
				if(!selectedRow){
					return;
				}
				
				var selectedIndex = $('#dtg_purchaseItem').edatagrid('getRowIndex', selectedRow);
				$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
			}
		}, '-',  {
			iconCls : 'icon-remove',
			text : '<s:message code="common.remove" />',
			handler : function() {
				var rows = $('#dtg_purchaseItem').edatagrid('getRows');
				 if(rows.length < 2){
					return;
				} 
				
				var selectedRow = $('#dtg_purchaseItem').edatagrid('getSelected');
				if(!selectedRow){
					return;
				}
				
				var selectedIndex = $('#dtg_purchaseItem').edatagrid('getRowIndex', selectedRow);
				$('#dtg_purchaseItem').edatagrid('deleteRow', selectedIndex);
				
				var rows = $('#dtg_purchaseItem').datagrid('getRows');
				if(rows.length == 0){
					return;
				}
				if(selectedIndex < rows.length){
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
				}else{
					$('#dtg_purchaseItem').edatagrid('editRow', rows.length - 1);
					$('#dtg_purchaseItem').edatagrid('selectRow', rows.length - 1);
				}
			}
		} ]
	});

	$('#frm_purchase').form({
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (isValid) {
				var checkedRows = $('#dtg_purchase').datagrid('getSelections');
				if(checkedRows[0] != undefined){
					$('#hid_purchaseId').val(checkedRows[0].id);
					//传递展开页的id
					//p_expandId = checkedRows[0].id;
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
	
	//清空多选框里的值
	$('#cbx_statuses').combobox('clear');
	
	
	//设置值
	$('#dtx_applicationDateFrom').datebox('setValue',new Date(new Date().getFullYear(), new Date().getMonth(), new Date().getDate()-30).toString() );
	$('#dtx_applicationDateTo').datebox('setValue', new Date().toString());
})


function doSubmit(param) {
	var isValid = $('#frm_purchase').form('validate');
	if (isValid == false) {
		$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写！', 'warning'); 
		return;
	}
	
	var url = undefined;
	//若未通过，选择重新编辑
	//var selectedRow = $('#dtg_purchaseItem').edatagrid('getSelected');
	//var selectedIndex = $('#dtg_purchaseItem').edatagrid('getRowIndex', selectedRow);
	
	var applicantdivisionId = $('#cbx_applicantdivisionId').combobox('getValue');
	var applicantdivisionName = $('#cbx_applicantdivisionId').combobox('getText');
	
	if($('#hid_editStatus').val() == 1){
		//1添加
		url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doAdd.do';
		//$('#dtg_purchaseItem').edatagrid('saveRow');
		//var rows = $('#dtg_purchaseItem').datagrid('getRows');
		//公用信息
		var form = {
			'status' : param,
			'applicantdivisionId': applicantdivisionId,
			'applicantdivisionName': applicantdivisionName
		};
		//批量添加信息
		var arr = [];
		var row = {
				'category1Id' : $('#cbx_category1Id').combobox('getValue'),
				'category1Name' : $('#cbx_category1Id').combobox('getText'),
				'category2Id' : $('#cbx_category2Id').combobox('getValue'),
				'category2Name' : $('#cbx_category2Id').combobox('getText'),
				'description' : $('#txt_description').textbox('getValue'),
				'divisionId' : $('#cbx_divisionId').combobox('getValue'),
				'divisionName' : $('#cbx_divisionId').combobox('getText'),
				'customerId' : $('#cbx_customerId').combobox('getValue'),
				'customerName' : $('#cbx_customerId').combobox('getText')
			};
		arr.push(row);
		/* } */
	}else{
		//2编辑
		url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doEdit.do';
		var checkedRows = $('#dtg_purchase').datagrid('getSelections');
		//$('#dtg_purchaseItem').edatagrid('saveRow');
		//var rows = $('#dtg_purchaseItem').datagrid('getRows');
		//公用信息
		var form = {
			
			'id' : checkedRows[0].id,
			'no' : checkedRows[0].no,
			'status' : param,
			'applicantdivisionId': applicantdivisionId,
			'applicantdivisionName': applicantdivisionName
			
		};
		//批量添加信息
		var arr = [];
		
		/* for(var i = 0;i < rows.length;i++){
			 	if(rows[i].category1Id == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写主类别！', 'warning'); 
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
					return;
				}
				if(rows[i].category2Id == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写次类别！', 'warning'); 
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
					return;
				}
				
				if(rows[i].description == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写描述！', 'warning'); 
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
					return;
				}
				
				if(rows[i].amount == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写金额！', 'warning'); 
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
					return;
				}
				
				if(rows[i].divisionId == ''){
					$.messager.alert('<s:message code="common.dialog.tip" />', '请完整填写部门！', 'warning'); 
					$('#dtg_purchaseItem').edatagrid('editRow', selectedIndex);
					$('#dtg_purchaseItem').edatagrid('selectRow', selectedIndex);
					return;
				} */
			
			var row = {
				 	/* 'category1Id' : rows[i].category1Id,
					'category1Name' : rows[i].category1Name,
					'category2Id' : rows[i].category2Id,
					'category2Name' : rows[i].category2Name,
					'description' : rows[i].description,
					'divisionId' : rows[i].divisionId,
					'divisionName' : rows[i].divisionName,
					'customerId' : rows[i].customerId,
					'customerName' : rows[i].customerName,
					'index' : i */
					'category1Id' : $('#cbx_category1Id').combobox('getValue'),
					'category1Name' : $('#cbx_category1Id').combobox('getText'),
					'category2Id' : $('#cbx_category2Id').combobox('getValue'),
					'category2Name' : $('#cbx_category2Id').combobox('getText'),
					'description' : $('#txt_description').textbox('getValue'),
					'divisionId' : $('#cbx_divisionId').combobox('getValue'),
					'divisionName' : $('#cbx_divisionId').combobox('getText'),
					'customerId' : $('#cbx_customerId').combobox('getValue'),
					'customerName' : $('#cbx_customerId').combobox('getText')
				};
			arr.push(row);
		/* } */
	}
	
	
	form.purchaseItemStr = JSON.stringify(arr);
	
	$.messager.confirm('<s:message code="common.confirm" />', '确认提交？', function(rr) {
		if (rr) {
			$.messager.progress();
			$.post(url, form, function(result) {
				$.messager.progress('close');// hide progress dialog
				try {
					var j = result;
					if (j.success) {
						$.messager.alert('<s:message code="common.tip" />', '提交成功！', 'info', function(rr) {
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
	//console.info("${sessionInfo.roleIds}");
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

function openCommentDialog(purchaseId){
	var url = formatString('${pageContext.request.contextPath}/workgroup/purchase/purchaseComment/toSearch.do?purchaseId={0}', purchaseId);
	$('#ifr_comment').attr('src', url); 
	$('#dlg_comment').dialog('setTitle', '评论').dialog('open').dialog('center');
}

function submitSearchForm() {
	var $dtg = $('#dtg_purchase');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearch.do?createUserId=${sessionInfo.userId }';
		$dtg.datagrid('options', opt);
	}
	$dtg.datagrid('load', serializeObject($('#frm_search')));
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
	<div data-options="region:'center',title:'申请列表',border:false">
		<table id="dtg_purchase"></table>
	</div>
	<div data-options="region:'north',title:'搜索',border:true" style="height: 90px;overflow: hidden;" align="center">
		<form id="frm_search"  method="post">
		<input name="statusGroup" value="${purchase.statusGroup}" type="hidden"/>
		<input name="createUserId" value="${sessionInfo.userId}" type="hidden"/>
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
					<td><select id="cbx_statuses" name="statuses" class="easyui-combobox" style="width:200px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, multiple:true">
					<option value="0">草稿</option>
					<option value="1">已提交</option>
					<option value="2">申请审批完成</option>
					<option value="3">已估价</option>
					<option value="4">采购审批完成</option>
					<option value="5">已采购</option>
					<option value="6">采购完成</option>
					<option value="8">拒绝</option>
					<!-- <option value="9">取消</option> -->
					</select></td>
					
					<th align="right">申请部门</th>
					<td>:</td>
					<td><div name="applicantdivisionId" class="easyui-combobox" style="width:257px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getDiv() "></div>
					</td>
					<td>
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
	
	<div id="dlg_purchase" class="easyui-dialog" style="width:479px;height:270px;" data-options="resizable:true,modal:true,closed: true, 
		onOpen: function() {formValidate('#frm_purchase', true);}, onClose: function() {formValidate('#frm_purchase', false);},
		buttons: [{text:'<s:message code="保存为草稿" />', iconCls:'icon-save', handler:function(){doSubmit(0);}},
				  {text:'<s:message code="保存并提交" />', iconCls:'ext-icon-drive_go', handler:function(){doSubmit(1);}}]">
		<form id="frm_purchase" method="post">
		<input id="hid_editStatus" name="editStatus" type="hidden"/>
		<div>
		<table class="mtftable" align="center">
		<tr><th align="right" style="width: 70px;">申请部门</th>
			<td>:</td>
			<td><div id="cbx_applicantdivisionId" name="applicantdivisionId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto', panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getDiv(),required : true"></div></td>
		</tr>
		</table>
		<table class="mtftable" align="center">
				<tbody>
					</tr>
					<tr><th align="right" style="width: 60px;">采购部门</th>
					<td>:</td>
					<td><div id="cbx_divisionId" name="divisionId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto', panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getItemDiv(),required : true"></div></td>
					<th align="right" style="width: 70px;">客户</th>
					<td>:</td>
					<td><div id="cbx_customerId" name="customerId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto', panelMaxHeight:'200', editable:false, url : '${pageContext.request.contextPath}/maintenance/customer/doListTetrad.do?type=0&aps=1',
					valueField : 'first',textField : 'third'"></div></td>
					</tr>
					
					<tr><th align="right" style="width: 60px;">主类别</th>
					<td>:</td>
					<td><div id="cbx_category1Id" name="category1Id" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', data : getCat(0), required : true,
					 onSelect:function(rec){ $('#cbx_category2Id').combobox('clear').combobox('loadData', getCat(rec.id)); }"></div></td>
					<th align="right" style="width: 70px;">次类别</th>
					<td>:</td>
					<td><div id="cbx_category2Id" name="category2Id" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'text', required : true"></div></td>
					</tr>
					<tr>
					<th align="right" style="width: 60px;">描述</th>
					<td>:</td>
					<td colspan="4"><input id="txt_description" name="description" class="easyui-textbox" style="width:388px;height:100px;" maxlength="255" data-options="multiline:true,validType:'length[0,255]', required : true" /></td>
					</tr>
				</tbody>
		</table>
		</div>
		</form>
		<!-- <table id="dtg_purchaseItem"></table> -->
	</div>
</body>
</html>
