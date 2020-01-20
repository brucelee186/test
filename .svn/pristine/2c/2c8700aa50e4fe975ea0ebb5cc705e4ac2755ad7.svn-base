<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Search User</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-datagrid-detailview.js?v=20141016" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/datagrid-detailview.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.4/jquery.edatagrid.js?v=20140516" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/order/orderCategoryService/searchOrderCategoryService.js" charset="utf-8"></script>

<script type="text/javascript">
var payeeComboboxInit = false;
var common_button_add = '<s:message code="common.button.add" />';
var common_button_edit = '<s:message code="common.edit" />';
var common_button_remove = '<s:message code="common.remove" />'
var common_error = '<s:message code="common.error" />';
var common_dialog_error = '<s:message code="common.dialog.error" />';
var common_dialog_tip = '<s:message code="common.dialog.tip" />';

var jsonArrayLevel1 = '${jsonArrayLevel1}';
var jsonArrayLevel2 = '${jsonArrayLevel2}';
var categoryLevel1 = ${jsonArrayLevel1};
var categoryLevel2 = ${jsonArrayLevel2};
var listArrayDivision = '${jsonArrayDivision}';
var jsonArrayCustomer = ${jsonArrayCustomer};

var p_itemDiv = "{id: '', name : ''}";
</script>
<script type="text/javascript">


var tagInit = false;
//部门格式化信息
var jsonArrayDivision = jQuery.parseJSON(listArrayDivision)[0];
function formatterDropListDivision(value, rowData, rowIndex) {
return formatterJsonDropList(value, rowData, rowIndex, jsonArrayDivision, 'id', 'name');
}





function getDataCustomer(customerId, customerId2) {
	if(pid === ''){
		return [];
	}
	
	var arrayTree = [];
	arrayTree.push({id:'0', text:'- -', pid : ''});
	for (var i = 0; i < jsonArrayCustomer.length; i ++) {
		var id = jsonArrayCustomer[i].id;
		var pid = jsonArrayCustomer[i].pid;
		if(pid == null || pid == ''){
			
			if(id == customerId && customerId2 != null){
				arrayTree.push({'id':jsonArrayCustomer[i].id, 'text':jsonArrayCustomer[i].name, 'pid':jsonArrayCustomer[i].pid, 'state' : 'open'});
			}
			else{
				arrayTree.push({'id':jsonArrayCustomer[i].id, 'text':jsonArrayCustomer[i].name, 'pid':jsonArrayCustomer[i].pid, 'state' : 'closed'});
			}
		}
		else{
			arrayTree.push({'id':jsonArrayCustomer[i].id, 'text':jsonArrayCustomer[i].name, 'pid':jsonArrayCustomer[i].pid});
		}
	}
	return arrayTree;
}


function getCategoryLevel1(pid) {
	if(pid === ''){
		return [];
	}
	
	var level = [];
	level.push({id:'', text:'- -'});
	for (var i = 0; i < categoryLevel1.length; i ++) {
		level.push({'id':categoryLevel1[i].id, 'text':categoryLevel1[i].name});
	}
	return level;
}

function getCategoryLevel2(pid) {
	var level = [];
	// level.push({id:'', text:'- -'});
	for (var i = 0; i < categoryLevel2.length; i ++) {
		if (categoryLevel2[i].pid == pid) {
			level.push({'id':categoryLevel2[i].id, 'text':categoryLevel2[i].name});
		}
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

function initData(){
var datagrid; //定义全局变量datagrid
		var editRow = undefined; //定义全局变量：当前编辑的行
		datagrid = $("#datagrid")
				.edatagrid(
						{
							url : contextPath + '/order/orderCategoryService/doSearch.do?tagPage=${orderCategoryService.tagPage}&tagPageCode=${orderCategoryService.tagPageCode}' + '&typeData=' + $('#typeData').val(), //请求的数据源
							iconCls : 'icon-save', //图标
							pagination : true, //显示分页
							height : 700,
							//width : 1000,
							pageSize : 20, //页大小
							pageList : [20, 50, 100 ], //页大小下拉选项此项各value是pageSize的倍数
							//fit : true, //datagrid自适应宽度
							fitColumn : true, //列自适应宽度
							//striped : true, //行背景交换
							//nowap : true, //列内容多时自动折至第二行
							border : false,
							idField : 'id', //主键
							singleSelect : false,
							rownumbers : true,
							sortName : 'id',
							sortOrder : 'desc',
						/*	frozenColumns : [ [ {
								title : 'ID',
								field : 'id',
								width : 0,
								hidden : true
							} ] ],*/
							columns : [ [
								{
									field : 'id',
									sortable : true,
									width : 0,
									hidden : false,
									checkbox : true,
								} ,
								{
									title : 'No.',
									field : 'idOrderCategoryService',
									sortable : true,
									align : 'right',
									width : 50,
									hidden : false,
									<c:if test="${orderCategoryService.tagPageCode == '1809500'}"> 
									formatter : function(value, row, index) {
										return '<a href="javascript:void(0);" onclick="showOrderCategoryServiceModify(' + row.id + ', 0);">' + value + '</a>';
									}
									</c:if>
								} ,
								{
									title : '申请人',
									field : 'applicantName',
									sortable : true,
									width : 75
								},
								{
									title : '收款人',
									field : 'payeeName',
									sortable : true,
									width : 180
								},
								{
									title : '申请部门',
									field : 'applicantDivisionName',
									sortable : true,
									width : 150
								},{
									title : '申请日期',
									field : 'applicantDate',
									sortable : true,
									align : 'center',
									width : 110,
									formatter : function(val){
										if(null != val && '' != val){
											return dateFormat(val);
										}
									}
								},
								{
									title : '币种',
									field : 'currencyName',
									align : 'center',
									width : 70,
								},
								{
									title : '历史汇率',
									field : 'exchangeRate',
									sortable : true,
									align : 'right',
									width : 100,
									formatter : function(value, row, index) {
										if(value) {
											return numberFormat(value, 4);
										}
									}
								},
								{
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
								},
								{
									title : '人民币总金额',
									field : 'totalAmountRmb',
									sortable : true,
									align : 'right',
									width : 100,
									formatter : function(value, row, index) {
										if(value) {
											return numberFormat(value, 2);
										}
									}
								},
								{
									title : '发票类型',
									field : 'typeInvoiceName',
									align : 'center',
									width : 80,
								},
								{
									title : '付款方式',
									field : 'typePaymentName',
									align : 'center',
									width : 80,
								},
								{
									title : '附件数',
									field : 'countAttachment',
									align : 'right',
									width : 45,
								},
								{
									title : '状态',
									field : 'status',
									sortable : true,
									align : 'center',
									width : 60,
									formatter : function(value, row, index) {
										var status = row.status;
										var countApprovePercent = row.countApprovePercent;
										
										if(100 == countApprovePercent &&　value == 'ap'){
											return '财务待审';
										}
										else if(100 == countApprovePercent &&　value == 'af'){
											return '财务审核';
										}
										else if(value == 'c'){
											return '审批完成';
										}
										else if(value == 'd'){
											return '草稿';
										}
										else if(value == 's'){
											return '已提交';
										}
										else{
											return '审批中';
										}
									},
									styler : function(value, row, index) {
										var status = row.status;
										var countApprovePercent = row.countApprovePercent;
										if(value == 'd'){
											return 'background-color:#FFEB9C;color:#9C6500;';
										}
										else if(value == 's'){
											return 'background-color:#ccffff;color:#3333ff;';
										}
										else if(value == 'af'){
											return 'background-color:#C6EFCE; color:#006100';
										}
										else if(value == 'c'){
											return 'background-color:#C6EFCE; color:#006100';
										}
										else if(value == 're'){
											return 'background-color:#ccffff;color:#3333ff;';
										}
										else if(value != 're1' && null != countApprovePercent || status == 're1' || status == 're2' || status == 're3'){
											return 'background-color:#ccffff;color:#3333ff;';
										} 
										else if (100 == countApprovePercent){
											return 'background-color:#C6EFCE; color:#006100';
										} else{
											return 'background-color:#ccffff;color:#3333ff;';
										}
										
									}
								}, 
								/* {
									title : '进度',
									field : 'countApprovePercent',
									sortable : true,
									align : 'right',
									width : 75,
									formatter : function(value, row, index) {
										var status = row.status;
										if(null == value || '' == value){
											value = 0;
										}
										return value + '%';
									},
									styler : function(value, row, index) {
										var countApprovePercent = row.countApprovePercent;
										var status = row.status
										if (100 == countApprovePercent){
											return 'background-color:#C6EFCE; color:#006100';
										}
										else if(status == 'd' && null == countApprovePercent){
											return 'background-color:#FFEB9C;color:#9C6500;';
										}
										else if(status == 's' && null == countApprovePercent || status == 're' || status == 're1' || status == 're2' || status == 're3'){
											return 'background-color:#ccffff;color:#3333ff;';
										}
										else if(status != 're1' && null != countApprovePercent){
											return 'background-color:#ccffff;color:#3333ff;';
										}
									}
								},*/
								{
									title : '审批备注',
									field : 'remarkApprove',
									align : 'left',
									width : 300,
									styler: function(val, row, index){
										return 'color:red;';
									}
								},
							/* 	{
									title : '创建时间',
									field : 'createDatetime',
									width : 150,
									sortable : true,
									hiddable : true,
									hidden : true
								},
								{
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
								} */
							] ],
							queryParams : {
								action : 'query'
							}, //查询参数
							toolbar : [
								// m:管理,a:审批
							<c:if test="${orderCategoryService.tagPage == 'm'}" >
								{
									iconCls : 'icon-add',
									text : '添加',
									handler : function() {
										$('#dlg_categoryService').dialog('setTitle', '添加报销').dialog('open').dialog('center');	
										$('#edatagridDetail').edatagrid('cancelRow');
										$('#edatagridDetail').datagrid('loadData',[]);
										
										$('#frm_categoryService').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=i');
										$('#frm_categoryService').form('load', {
											'applicantDivisionId' : '${divisionMainId}',
											'currencyCode' : 'cu1',
											'payeeName' : '',
											'applicantDate' : '',
											'totalAmount' : '',
											'exchangeRate' : '',
											'totalAmountRmb' : '',
											'typePaymentCode' : '',
											'typeInvoiceCode' : '',
											'actualTotalAmount' : '',
											'bankCard' : '',
											'bankName' : '',
											'payeeId' : '',
											'payeeName' : '',
											//'payeeType' : '',
										}); 
											// 默认收款人
									/*	$('#txt_payeeName').combobox({
											url : '${pageContext.request.contextPath}/common/droplist/doListPayeeName.do',
											valueField : 'id',
											textField : 'content',
											editable : true,
											multiple : false, 
											required:true,
											panelHeight:'auto',
											panelMaxHeight:'200',
											onLoadSuccess: function () { 
											 	var data = $('#txt_payeeName').combobox('getData');
												if(data.length > 0){
 													$('#txt_payeeName').combobox('select',data[0].content);
												}
											}
										}); */
										$('#txt_payeeName').combobox({
											url : contextPath + '/common/droplist/doListUserBank.do',
											valueField : 'userId',
											textField : 'uniqueName',
											editable : true,
											multiple : false,
											required : true, 
											onLoadSuccess: function (data) {
												// 取得上一个付款人
												/* $.post(contextPath + '/order/orderCategoryService/getOrderCategoryServiceLast.do', {}, function(r) {
													$('#txt_payeeName').combobox('select', r.obj.payeeName);
													$('#txt_payeeName').combobox('setValue', r.obj.payeeId);
												}, 'json'); */
												// 默认收款人赋值给自己
												$('#txt_payeeName').combobox('select', '${userName}');
												$('#txt_payeeName').combobox('setValue', '${userId}');
											}
										});
									
									
									
									}
								}, 
								'-',
								{
									text : '修改',
									iconCls : 'icon-edit',
									handler : function() {
										var checkedRows = $('#datagrid').datagrid('getSelections');
										if(checkedRows[0] == undefined || checkedRows.length > 1){
											$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
											return;
										};
										if(checkedRows[0].status == 's' || checkedRows[0].status == 'c' || checkedRows[0].status == 'a' || checkedRows[0].status == 'ap'){
											$.messager.alert(common_dialog_tip, '只有【草稿】和【驳回】状态可以编辑！', 'warning');
											return;
										}
										
										$('#frm_categoryService').form('clear');
										$('#dlg_categoryService').dialog('setTitle', '编辑报销').dialog('open').dialog('center');	
										$('#edatagridDetail').edatagrid('cancelRow');
										$('#edatagridDetail').datagrid('loadData',[]);
										$.post(contextPath + '/order/orderCategoryService/doSearchJson.do', { 'id' : checkedRows[0].id }, function(result) {
											$.messager.progress('close');// hide progress dialog
											try {
												var r = result;
												if (r.success) {
										
													 $('#frm_categoryService').form('load', {
														'id' : r.obj.id,
														'applicantDivisionId' : r.obj.applicantDivisionId,
														'currencyCode' : r.obj.currencyCode,
														'payeeName' : r.obj.payeeName,
														'payeeId' : r.obj.payeeId,
														'applicantDate' : r.obj.applicantDate,
														'totalAmount' : r.obj.totalAmount,
														'exchangeRate' : r.obj.exchangeRate,
														'totalAmountRmb' : r.obj.totalAmountRmb,
														'typePaymentCode' : r.obj.typePaymentCode,
														'typePaymentName' : r.obj.typePaymentName,
														'actualTotalAmount' : r.obj.actualTotalAmount,
														'typeInvoiceCode' : r.obj.typeInvoiceCode,
														'typeInvoiceName' : r.obj.typeInvoiceName,
														'bankCard' : r.obj.bankCard,
														'bankName' : r.obj.bankName,
														'payeeType' : r.obj.payeeType,
													});
													$('#txt_payeeName').combobox({
														url : contextPath + '/common/droplist/doListUserBank.do',
														valueField : 'userId',
														textField : 'uniqueName',
														editable : true,
														required : true, 
														multiple : false, 
														onLoadSuccess: function (data) {
															$('#txt_payeeName').combobox('setValue',r.obj.payeeId);
															$('#txt_payeeName').combobox('select',r.obj.payeeName);
													
													}
												}); 
													$('#edatagridDetail').datagrid('loadData', r.obj.listOrderCategoryServiceDetail);
												} else {
													$.messager.alert(common_error, '报销相关信息查找失败！', 'error');
												}
											} catch (e) {
												$.messager.alert(common_error, result, 'error');
											}
										}, 'json');
										
										$('#frm_categoryService').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=u');
										//编辑状态1：添加，2：编辑
										//$('#hid_editStatus').val(2);
										
										
										//隐藏输入框边框
										$('#nbx_totalAmount').next().css('border', '0px');
										$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
									}
								},
								'-',
									{
										text : '删除',
										iconCls : 'icon-remove',
										handler : function() {
											//删除时先获取选择行
											var rows = datagrid
													.datagrid("getSelections");
											//选择要删除的行
											if(rows[0] == undefined || rows.length > 1){
												$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
												return;
											};
											if(rows[0].status != 'd'){
												$.messager.alert(common_dialog_tip, '只有【草稿】状态可以删除！', 'warning');
												return;
											}
											if (rows.length == 1) {
												$.messager
														.confirm(
																"提示",
																"你确定要删除吗?",
																function(r) {
																	if (r) {
																		$.post(contextPath + '/order/orderCategoryService/doEdit.do?editState=d',
																				{
																					id : rows[0].id
																				},
																				function(result) {
																					$('#datagrid').datagrid( 'reload');
																					$.messager.show({
																						title : common_dialog_tip,
																						msg : '删除成功',
																						timeout : 2000,
																						showType : 'slide'
																					});
																				});
																	}
																});
											} else {
												$.messager.alert("提示",
														"请选择要删除的行", "error");
											}
										}
									},
									'-',
									/* {
										text : '保存',
										iconCls : 'icon-save',
										handler : function() {
											//保存时结束当前编辑的行，自动触发onAfterEdit事件如果要与后台交互可将数据通过Ajax提交后台
											datagrid.datagrid("endEdit",
													editRow);
										}
									}, 
									'-',  */
									{
										text : '提交',
										iconCls : 'icon-save',
										handler : function() {
											var rows = datagrid
											.datagrid("getSelections");
									//选择要删除的行
										if(rows[0] == undefined || rows.length > 1){
												$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
												return;
											};
									if (rows.length == 1) {
										if(rows[0].status == 're'){
											$.messager.alert(common_dialog_tip, '【驳回】状态请修改后再提交！', 'warning');
											return;
										}
										if(rows[0].status != 'd'){
											$.messager.alert(common_dialog_tip, '只有【草稿】状态可以提交！', 'warning');
											return;
										}
										var typeInvoiceCode = rows[0].typeInvoiceCode;
										if(null == typeInvoiceCode || '' == typeInvoiceCode){
											$.messager.alert(common_dialog_tip, '只有补全信息后才可提交！', 'warning');
											return;
										}
										
										$.messager
												.confirm(
														"提示",
														"提交后的数据将无法修改,确定要提交吗?",
														function(r) {
															if (r) {
																$.post(contextPath + '/order/orderCategoryService/doEdit.do',
																		{
																			editState : 'u',
																			id : rows[0].id,
																			status : 's',
																			tagPageCode : '${orderCategoryService.tagPageCode}',
																		},
																		function(result) {
																			$('#datagrid').datagrid( 'reload');
																			$.messager.show({
																				title : common_dialog_tip,
																				msg : '提交成功',
																				timeout : 2000,
																				showType : 'slide'
																			});
																		});
															}
														});
									} else {
										$.messager.alert("提示",
												"请选择要删除的行", "error");
									}
										}
									}, 
									'-',
									</c:if>
									<c:if test="${orderCategoryService.tagPage == 'a'}" >
										<c:choose>
										<c:when test="${orderCategoryService.tagPageCode == '1808600'}">  
										{
											iconCls : 'ext-icon-tick',
											text : '审核',
											handler : function() {
											var rows = $('#datagrid').datagrid('getChecked');
											var arrayId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayId += rows[i].id + ',';
											}
											$.post(contextPath + '/order/orderCategoryService/doEdit.do', 
											{
												editState : 'af', 
												arrayId :arrayId, 
												tagPageCode : '${orderCategoryService.tagPageCode}',
												status : 'af'
											}, function(result){
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
   										</c:when>
										<c:when test="${orderCategoryService.tagPageCode == '1809500'}">  
										{
									text : '修正审批人',
									iconCls : 'icon-edit',
									handler : function() {
										var checkedRows = $('#datagrid').datagrid('getSelections');
										if(checkedRows[0] == undefined || checkedRows.length > 1){
											$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
											return;
										};
										
										$('#frm_categoryService').form('clear');
										$('#dlg_categoryService').dialog('setTitle', '修正审批人').dialog('open').dialog('center');	
										$('#edatagridDetail').edatagrid('cancelRow');
										$('#edatagridDetail').datagrid('loadData',[]);
										$.post(contextPath + '/order/orderCategoryService/doSearchJson.do', { 'id' : checkedRows[0].id }, function(result) {
											$.messager.progress('close');// hide progress dialog
											try {
												var r = result;
												if (r.success) {
										
													 $('#frm_categoryService').form('load', {
														'id' : r.obj.id,
														'applicantDivisionId' : r.obj.applicantDivisionId,
														'currencyCode' : r.obj.currencyCode,
														'payeeName' : r.obj.payeeName,
														'payeeId' : r.obj.payeeId,
														'applicantDate' : r.obj.applicantDate,
														'totalAmount' : r.obj.totalAmount,
														'exchangeRate' : r.obj.exchangeRate,
														'totalAmountRmb' : r.obj.totalAmountRmb,
														'typePaymentCode' : r.obj.typePaymentCode,
														'typePaymentName' : r.obj.typePaymentName,
														'actualTotalAmount' : r.obj.actualTotalAmount,
														'typeInvoiceCode' : r.obj.typeInvoiceCode,
														'typeInvoiceName' : r.obj.typeInvoiceName,
														'bankCard' : r.obj.bankCard,
														'bankName' : r.obj.bankName,
														'payeeType' : r.obj.payeeType,
													});
													$('#txt_payeeName').combobox({
														url : contextPath + '/common/droplist/doListUserBank.do',
														valueField : 'userId',
														textField : 'uniqueName',
														editable : true,
														required : true, 
														multiple : false, 
														onLoadSuccess: function (data) {
															$('#txt_payeeName').combobox('setValue',r.obj.payeeId);
															$('#txt_payeeName').combobox('select',r.obj.payeeName);
													
													}
												}); 
													$('#edatagridDetail').datagrid('loadData', r.obj.listOrderCategoryServiceDetail);
												} else {
													$.messager.alert(common_error, '报销相关信息查找失败！', 'error');
												}
											} catch (e) {
												$.messager.alert(common_error, result, 'error');
											}
										}, 'json');
										
										$('#frm_categoryService').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=ma&tagPageCode=1809500');
										//编辑状态1：添加，2：编辑
										//$('#hid_editStatus').val(2);
										
										
										//隐藏输入框边框
										$('#nbx_totalAmount').next().css('border', '0px');
										$('#nbx_totalAmount').parent().css('border-bottom', 'thin solid #95B8E7');
									}
								},
								'-',
   										</c:when>
   										<c:otherwise>
   										{
											iconCls : 'ext-icon-tick',
											text : '审批',
											handler : function() {
											var rows = $('#datagrid').datagrid('getChecked');
											var arrayId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayId += rows[i].id + ',';
											}
											$.post(contextPath + '/order/orderCategoryService/doEdit.do', 
											{
												editState : 'a', 
												arrayId :arrayId, 
												tagPageCode : '${orderCategoryService.tagPageCode}',
												status : 'ap'
											}, function(result){
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
   										</c:otherwise>
   										</c:choose>
   									<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
									{
										iconCls : 'ext-icon-cross',
										text : '驳回',
										handler : function() {
											var rows = $('#datagrid').datagrid('getChecked');
											var arrayId = '';
											for (var i = 0; i < rows.length; i++) {
												arrayId += rows[i].id + ',';
											}
											$.messager.prompt("操作提示", "如有需要请输入驳回原因", function (data) {
												if (undefined != data) {
													if(data.length > 50){
														$.messager.alert(common_dialog_tip, '请输入低于50个字！', 'warning');
														return;
													}
													$.post(contextPath + '/order/orderCategoryService/doEdit.do', 
													{editState : 'a', 
													arrayId : arrayId,
													tagPageCode : '${orderCategoryService.tagPageCode}', 
													remarkApprove : data,
													status : 're'}, 
													function(result){
														$('#datagrid').datagrid('reload');
														$.messager.show({
															title:'<s:message code="common.dialog.tip" />',
															msg:'驳回成功',
															timeout:5000,
															showType:'slide'
													});
												});
													$('#datagrid').datagrid("clearSelections");
											}});
										}
									},'-',
									</c:if>
									</c:if>
																		{
									iconCls : 'ext-icon-attach',
									text : '附件',
									handler : function() {
									//删除时先获取选择行
											var rows = datagrid
													.datagrid("getSelections");
											//选择要删除的行
											if(rows[0] == undefined || rows.length > 1){
												$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
												return;
											};
											/*if(rows[0].status != 'd'){
												$.messager.alert(common_dialog_tip, '只有【草稿】状态可以上传附件！', 'warning');
												return;
											}*/
										$('#dlg_categoryServiceAttach').dialog('setTitle', '附件管理').dialog('open').dialog('center');	
										$('#relevanceId').val(rows[0].id);
										$('#statusAtt').val(rows[0].status);
										initAttachList(rows[0].id);
										//$('#formFileUploader').attr('action', contextPath + '/order/orderCategoryService/doEdit.do?editState=i');
										$('#formFileUploader').form('load', {
										}); 
									
									}
								}, 
								'-',
									{
										iconCls : 'ext-icon-printer',
										text : '打印报销单',
										handler : function() {
											var checkedRows = $('#datagrid').datagrid('getSelections');
										if(checkedRows[0] == undefined || checkedRows.length > 1){
											$.messager.alert(common_dialog_tip, '请选择一条记录！', 'warning');
											return;
										};
										var pid = checkedRows[0].id;
										var content = '<iframe src="${pageContext.request.contextPath}/ReportServer?reportlet=searchOrderServiceReimbursement.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&pid=' + pid + '&tagPageCode=${orderCategoryService.tagPageCode}" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>'; 
										top.layout_center_addTab({
											title : '费用报销申请单',
											closable : true,
											iconCls : 'ext-icon-user_edit',
											content : content
										});
										//var url = "${pageContext.request.contextPath}/ReportServer?reportlet=searchOrderServiceReimbursement.cpt&__bypagesize__=false&serverIp=${pageContext.request.contextPath}&pid=" + pid + '&tagPageCode=${orderCategoryService.tagPageCode}';
										//window.location.href = url;
										}
									},'-'
									,{
										iconCls : 'ext-icon-collapse_all',
										text : '关闭所有',
										handler : function() {
											var data = $('#datagrid').datagrid('getRows');
								 			for(var i = 0; i < data.length; i++){
												$('#datagrid').datagrid('collapseRow', i);
											}
										}
									}, 
									'-', {
										iconCls : 'ext-icon-expand_all',
										text : '打开所有',
										handler : function() {
											var data = $('#datagrid').datagrid('getRows');
								 			for(var i = 0; i < data.length; i++){
												$('#datagrid').datagrid('expandRow', i);
											}
										}
									},
									'-', {
										iconCls : 'ext-icon-help',
										text : '帮助',
										handler : function() {
											var url = '${pageContext.request.contextPath}/upload/help/HelpOrderCategoryService.docx';
											window.location.href = url;
										}
									},
									],
									view: detailview,
									detailFormatter: function(rowIndex, rowData){
										var html = mtfDetailGridGenerator.generate(this, rowData, rowIndex);
										return html;
									},
									detailGrid : {
										sortName : 'index',
										sortOrder : 'desc',
										dataField : 'listOrderCategoryServiceDetail',
										columns : [
										{
											title : 'DNo.',
											field : 'idOrderCategoryServiceDetail',
											align : 'right',
											width : 50,
											<c:if test="${orderCategoryService.tagPageCode == '1809500'}"> 
											formatter : function(value, row, index) {
												return '<a href="javascript:void(0);" onclick="showOrderCategoryServiceModify(' + row.idOrderCategoryService + ', ' + value + ');">' + value + '</a>';
											}
											</c:if>										
										},
										{
											title : '主类别',
											field : 'nameCategoryLevel1',
											align : 'left',
											width : 148
										},
										{
							 				title : '次类别',
											field : 'nameCategoryLevel2',
											align : 'left',
											width : 150
										},{
											title : '费用部门',
											field : 'divisionName',
											align : 'left',
											width : 110
										},{
											title : '客户',
											field : 'customerName1',
											align : 'left',
											width : 110
										},
										{
											title : '金额',
											field : 'amount',
											align : 'right',
											width : 110,
											formatter : function(value, row, index) {
												if(value) {
													return numberFormat(value, 2);
												}
											}
										},
										{
											title : '人民币金额',
											field : 'amountRmb',
											align : 'right',
											width : 110,
											formatter : function(value, row, index) {
												if(value) {
													return numberFormat(value, 2);
												}
											}
										},
										/*{
											title : '付款方式',
											field : 'typeInvoiceName',
											align : 'left',
											width : 80,
										},*/										
										{
											title : '一级审批',
											field : 'approveStatus1',
											sortable : true,
											align : 'center',
											width : 100,
											formatter : function(value, row, index) {
												var approverName = row.approverName1;
												var approveStatus = ''
												if(row.approveNeed1 == 'y'){
													if(value == 'na'){
														approveStatus = '未审批';
													}else if(value == 'ap'){
														approveStatus = '已审批';
													}else if(value == 're'){
														approveStatus = '驳回';
													}else{
														approveStatus = '其它';
													}
												}
												return approveStatus + '(' + approverName + ')';
											},
											styler : function(value, row, index) {
												if(row.approveNeed1 == 'y'){
													if (value == 'na' ){
														return 'background-color:#ffff99;color:#ff9900;';
													}else if (value == 'ap'){
														return 'background-color:#C6EFCE; color:#006100';
													} else if (value == 're' ) {
														return 'background-color:#FFC7CE; color:#9C0006';
													} else  {
														return 'background-color:#ffff99;color:#ff9900;';
													}
												}
											}
										},
										{
											title : '二级审批',
											field : 'approveStatus2',
											sortable : true,
											align : 'center',
											width : 100,
											formatter : function(value, row, index) {
											var approverName = row.approverName2;
												var approveStatus = ''
												if(row.approveNeed2 == 'y'){
													if(value == 'na'){
														approveStatus = '未审批';
													}else if(value == 'ap'){
														approveStatus = '已审批';
													}else if(value == 're'){
														approveStatus = '驳回';
													}else{
														approveStatus = '其它';
													}
													return approveStatus + '(' + approverName + ')';
												} 
												else {
													return '无';
												}
											},
											styler : function(value, row, index) {
												if(row.approveNeed2 == 'y'){
													if (value == 'na' ){
														return 'background-color:#ffff99;color:#ff9900;';
													}else if (value == 'ap'){
														return 'background-color:#C6EFCE; color:#006100';
													} else if (value == 're' ) {
														return 'background-color:#FFC7CE; color:#9C0006';
													} else  {
														return 'background-color:#ffff99;color:#ff9900;';
													}
												}
											}
										},
										{
											title : '三级审批',
											field : 'approveStatus3',
											sortable : true,
											align : 'center',
											width : 100,
											formatter : function(value, row, index) {
												var approveStatus = ''
												if(row.approveNeed3 == 'y'){
													if(value == 'na'){
														approveStatus = '未审批';
													}else if(value == 'ap'){
														approveStatus = '已审批';
													}else if(value == 're'){
														approveStatus = '驳回';
													}else{
														approveStatus = '其它';
													}
													return approveStatus + '(刘锡铭)';
												} 
												else {
													return '无';
												}
											},
											styler : function(value, row, index) {
												if(row.approveNeed3 == 'y'){
													if (value == 'na' ){
														return 'background-color:#ffff99;color:#ff9900;';
													}else if (value == 'ap'){
														return 'background-color:#C6EFCE; color:#006100';
													} else if (value == 're' ) {
														return 'background-color:#FFC7CE; color:#9C0006';
													} else  {
														return 'background-color:#ffff99;color:#ff9900;';
													}
												}
											}
										},
										{
											title : '财务审核',
											field : 'approveStatus4',
											sortable : true,
											align : 'center',
											width : 100,
											formatter : function(value, row, index) {
											var approverName = row.approverName4;
												var approveStatus = ''
												if(row.approveNeed4 == 'y'){
													if(value == 'na'){
														approveStatus = '未审批';
													}else if(value == 'ap'){
														approveStatus = '已审批';
													}else if(value == 're'){
														approveStatus = '驳回';
													}else{
														approveStatus = '其它';
													}
													return approveStatus + '(' + approverName + ')';
												} 
												else {
													return '无';
												}
											},
											styler : function(value, row, index) {
												if(row.approveNeed4 == 'y'){
													if (value == 'na' ){
														return 'background-color:#ffff99;color:#ff9900;';
													}else if (value == 'ap'){
														return 'background-color:#C6EFCE; color:#006100';
													} else if (value == 're' ) {
														return 'background-color:#FFC7CE; color:#9C0006';
													} else  {
														return 'background-color:#ffff99;color:#ff9900;';
													}
												}
											}
										},
										/* {
											title : '进度',
											field : 'countApprovePercent',
											sortable : true,
											align : 'right',
											width : 75,
											formatter : function(value, row, index) {
												if(null == value || '' == value){
													value = 0;
												}
												return value + '%';
											},
											styler : function(value, row, index) {
												if (value != 100 ){
													return 'background-color:#FFEB9C;color:#9C6500;';
												}else {
													return 'background-color:#C6EFCE; color:#006100';
												}
											}
										}, */
										{
											title : '描述',
											field : 'remark',
											align : 'left',
											tooltip : true,
											width : 250
										},
										]
									},
								onAfterEdit : function(rowIndex, rowData, changes) {
								var changes = datagrid.datagrid("getChanges")
								//alert(changes)
								//return;
								//endEdit该方法触发此事件
								console.info(rowData);
								//alert(rowData.name)
								//editRow = undefined;
								//提交后台处理
								$.post(contextPath + '/order/ordercategoryService/doEdit.do?editState=u',
									{
										idString : rowData.id,
										name : rowData.name,
										origin : rowData.origin,
										destination : rowData.destination,
										mileage : rowData.mileage,
										expense : rowData.expense,
										remark : rowData.remark,
										tag : rowData.tag,
									},
									function(result) {
										$('#datagrid').datagrid( 'reload');
										editRow = undefined;
										$.messager
												.show({
													title : common_dialog_tip,
													msg : '修改成功',
													timeout : 2000,
													showType : 'slide'
												});
									});
							},
							onLoadError : function (data) {
								editRow = undefined;
							},
							onLoadSuccess : function () {
										var data = $('#datagrid').datagrid('getRows');
								 			for(var i = 0; i < data.length; i++){
												$('#datagrid').datagrid('expandRow', i);
											}
								// 清空选项
								$(this).datagrid('clearChecked')
							},
							/* onDblClickRow : function(rowIndex, rowData) {
								//alert('double')
								//双击开启编辑行
								if (editRow != undefined) {
									datagrid.datagrid("endEdit", editRow);
								}
								if (editRow == undefined) {
									datagrid.datagrid("beginEdit", rowIndex);
									editRow = rowIndex;
								}
							} */
						});

		
		
		

}

	$(function() {
		
	
	initData();
	
		$('#edatagridDetail').edatagrid({
			fit : true,
			weight :1000,
			height : 360, 
			border : false,
			idField : 'id',
			nowrap : true,
			rownumbers : true,
			autoRowHeight : false,
			frozenColumns : [ [ 
			{
				title : 'No.',
				field : 'id',
				align : 'right',
				width : 50,
				formatter : function(value, row, index) {
					return '<a href="javascript:void(0);" onclick="showOrderCategoryServiceModify(' + row.id + ', ' + 0 + ');">' + value + '</a>';
				},
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				hidden : true
				</c:if>										
			},
			{
				title : 'DNo.',
				align : 'right',
				field : 'idOrderCategoryServiceDetail',
				width : 50,
				formatter : function(value, row, index) {
					return '<a href="javascript:void(0);" onclick="showOrderCategoryServiceModify(' + row.id + ', ' + value + ');">' + value + '</a>';
				},
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				hidden : true
				</c:if>
			} ] ],
			columns : [ [ 
			{
				title : '主类别',
				field : 'idCategoryLeve1',
				width : 180,
				formatter : function(value, row, index) {
					return row.nameCategoryLevel1;
				},
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				editor : 
					{ type : 'combobox',  
						options : {valueField : 'id', textField : 'text', panelHeight:'auto',panelMaxHeight:'200', editable:false, required : true,
						data : getCategoryLevel1(0), 
						onSelect:function(rec){
							var row = $('#edatagridDetail').datagrid('getSelected');
							var rowIndex = $('#edatagridDetail').datagrid('getRowIndex',row);
							var target = $('#edatagridDetail').datagrid('getEditor', {'index':rowIndex,'field':'idCategoryLevel2'}).target;
							target.combobox('clear');
							target.combobox('loadData', getCategoryLevel2(rec.id));
						}
						}
					}
				</c:if>
			} ,
			{
				title : '次类别',
				field : 'idCategoryLevel2',
				width : 180,
				formatter : function(value, row, index) {
					return row.nameCategoryLevel2;
				},
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				editor : { type : 'combobox',  options : {valueField : 'id', textField : 'text', panelHeight:'auto', panelMaxHeight:'200',editable:false, required : true,}  }
				</c:if>
			} ,
			{
				title : '描述',
				field : 'remark',
				width : 300,
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">
				editor : { type : 'textbox',options : {validType:'length[0,100]', required : true,}}
				</c:if>
			} ,
			{
				title : '金额',
				field : 'amount',
				align : 'right',
				width : 90,
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">
				editor : 
					{
						type : 'numberbox',  
						options : {
						precision : '2',
						min : 0,
						required : true,
						onChange:function(rec){
							var allRows = $('#edatagridDetail').edatagrid('getRows');
							var totalAmount = 0.0;
							for(var i = 0; i < allRows.length; i++ ){
								totalAmount += allRows[i].amount*1.0;
								//console.info(allRows[i].amount);
							}
							//console.info(totalAmount*1.00);
							$('#totalAmount').numberbox('setValue',totalAmount*1.00);
						}
					},
				}
				</c:if>
			} ,
			/* {
				title : '付款方式',
				field : 'typeInvoiceId',
				width : 100,
				align : 'left',
				formatter : function(value, row, index) {
					return row.typeInvoiceName;
				}, 
				editor : {
					type : 'combobox',
					options : {
						url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=fplx',
						valueField : 'code',
						textField : 'name',
						required : true,
						editable : false,
				 }
				}
			},*/
			{
				title : '费用部门',
				field : 'divisionId',
				width : 100,
				formatter : formatterDropListDivision,
				align : 'left',
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">
				editor : {
					type : 'combobox',
					options : {
						data : jsonArrayDivision,
						valueField : 'id',
						textField : 'name',
						required : true,
						editable : false,
				 }
				}
				</c:if>
			},
			{
				title : '客户',
				field : 'customerId',
				width : 300,
				formatter : function(value, row, index) {
					var customerName1 = row.customerName1;
					var customerName2 = row.customerName2;
					var customerName = '';
					if(null != customerName2 && '' != customerName2){
						customerName = customerName1 + ' - ' + customerName2;
					} 
					else {
						customerName = customerName1;
					}
					return customerName;
				}, 
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">
				editor : { 
					type : 'combotree', 
					options : {
						data : getDataCustomer(0, 0), 
						valueField : 'id',
						textField : 'text',
						parentField : 'pid',
						panelWidth : '200',
						required : true,
						editable : false,
						lines : true,
						onSelect(row){
							var id = row.id
							var pid = row.pid
							if(pid == ''){
								$('#customerId1').val(id);
								$('#customerId2').val(null);
							} else {
								$('#customerId1').val(pid);
								$('#customerId2').val(id);
							}
						}
					},
					
				}
				</c:if>
			},
			<c:if test="${orderCategoryService.tagPageCode == '1809500'}">  
			{
				title : '一级审批',
				field : 'approverId1',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
				 	var approveStatus = row.approveStatus1;
				 	//if('ap' == approveStatus){
					//	this.editor = null;
				 	//}
					return row.approverName1;
					
				}, 
				editor : {
					type : 'combobox',
					options : {
						url:'${pageContext.request.contextPath}/common/droplist/doListUserApprover.do?level=1',
						valueField : 'id',
						textField : 'displayName',
						required : true,
						editable : false,
				 	}
				},
				styler : function(value, row, index) {
					var approveStatus = row.approveStatus1;
					if (approveStatus == 'ap'){
						return 'background-color:#C6EFCE; color:#006100';
					}
				}
			},
			{
				title : '二级审批',
				field : 'approverId2',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					var approveStatus = row.approveStatus2;
				 	//if('ap' == approveStatus){
					//	this.editor = null;
				 	//}
					return row.approverName2;
				}, 
				editor : {
					type : 'combobox',
					options : {
						url:'${pageContext.request.contextPath}/common/droplist/doListUserApprover.do?level=2',
						valueField : 'id',
						textField : 'displayName',
						required : true,
						editable : false,
				 }
				},
				styler : function(value, row, index) {
					var approveStatus = row.approveStatus2;
					if (approveStatus == 'ap'){
						return 'background-color:#C6EFCE; color:#006100';
					}
				}				
			},
			{
				title : '三级审批',
				field : 'approverId3',
				width : 80,
				align : 'center',
				formatter : function(value, row, index) {
					var approveStatus = row.approveStatus3;
				 	//if('ap' == approveStatus){
					//	this.editor = null;
				 	//}
					return row.approverName3;
				}, 
				editor : {
					type : 'combobox',
					options : {
						url:'${pageContext.request.contextPath}/common/droplist/doListUserApprover.do?level=3',
						valueField : 'id',
						textField : 'displayName',
						required : true,
						editable : false,
				 }
				},
				styler : function(value, row, index) {
					var approveStatus = row.approveStatus3;
					if (approveStatus == 'ap'){
						return 'background-color:#C6EFCE; color:#006100';
					}
				}					
			},
			</c:if>
			 ] ],
			onBeforeSave : function(index) {
				var rows = $(this).datagrid('getRows');
				
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				var category1Editor = $(this).datagrid('getEditor', {index : index, field : 'idCategoryLeve1'});
				var idCategoryLeve1 = $(category1Editor.target[0]).combobox('getValue');			
				var nameCategoryLevel1 = $(category1Editor.target[0]).combobox('getText');			
				rows[index].idCategoryLeve1 = idCategoryLeve1;
				rows[index].nameCategoryLevel1 = nameCategoryLevel1;
				
				var category2Editor = $(this).datagrid('getEditor', {index : index, field : 'idCategoryLevel2'});
				var idCategoryLevel2 = $(category2Editor.target[0]).combobox('getValue');			
				var nameCategoryLevel2 = $(category2Editor.target[0]).combobox('getText');			
				rows[index].idCategoryLevel2 = idCategoryLevel2;
				rows[index].nameCategoryLevel2 = nameCategoryLevel2;
				
				var divisionEditor = $(this).datagrid('getEditor', {index : index, field : 'divisionId'});
				var divisionName = $(divisionEditor.target[0]).combobox('getText');			
				rows[index].divisionName = divisionName;
				
				var customerEditor = $(this).datagrid('getEditor', {index : index, field : 'customerId'});
				var customerTarget = customerEditor.target;
				//combotree
				var customerName = $(customerEditor.target[0]).combobox('getText');	
				rows[index].customerName = customerName;
				rows[index].customerName1 = customerName;
				var customerId1 = $('#customerId1').val();
				var customerId2 = $('#customerId2').val();
				rows[index].customerId1 = customerId1;
				rows[index].customerId2 = customerId2;
				if(customerId1 != null && customerId1 != ''){
					customerName1 = getCustomerName(customerId1);
					rows[index].customerName1 = customerName1;
				}
				if(customerId2 != null && customerId2 != ''){
					customerName2 = getCustomerName(customerId2);
					rows[index].customerName2 = customerName2;
				}else{
					rows[index].customerName2 = null
				}
				var customerId = $(customerEditor.target[0]).combobox('getValue');
				$('#customerId1').val(null);
				$('#customerId2').val(null);
				
				//赋值发票类型
				//var typeInvoiceIdEditor = $(this).datagrid('getEditor', {index : index, field : 'typeInvoiceId'});
				//var typeInvoiceId = $(typeInvoiceIdEditor.target[0]).combobox('getValue');			
				//var typeInvoiceName = $(typeInvoiceIdEditor.target[0]).combobox('getText');	
				//rows[index].typeInvoiceName = typeInvoiceName;
				</c:if>
				<c:if test="${orderCategoryService.tagPageCode == '1809500'}">
				// 赋值一二三级审批人姓名
				// approverName1
				var approverId1Editor = $(this).datagrid('getEditor', {index : index, field : 'approverId1'});
				if(null != approverId1Editor){
					var approverName1 = $(approverId1Editor.target[0]).combobox('getText');			
					var approverId1 = $(approverId1Editor.target[0]).combobox('getValue');			
					rows[index].approverName1 = approverName1;
					rows[index].approverId1 = approverId1;
				}
				
				var approverId2Editor = $(this).datagrid('getEditor', {index : index, field : 'approverId2'});
				if(null != approverId2Editor){
					var approverName2 = $(approverId2Editor.target[0]).combobox('getText');	
					var approverId2 = $(approverId2Editor.target[0]).combobox('getValue');			
					rows[index].approverName2 = approverName2;
					rows[index].approverId2 = approverId2;
				}
				
				var approverId3Editor = $(this).datagrid('getEditor', {index : index, field : 'approverId3'});
				if(null != approverId3Editor){
					var approverName3 = $(approverId3Editor.target[0]).combobox('getText');	
					var approverId3 = $(approverId3Editor.target[0]).combobox('getValue');			
					rows[index].approverName3 = approverName3;
					rows[index].approverId3 = approverId3;
				}
				</c:if>
			},
			onSelect : function(index, row) {
				//编辑后取消提交需要
				$('#edatagridDetail').edatagrid('editRow', index);
				var row = $('#edatagridDetail').datagrid('getSelected');
				var rowIndex = $('#edatagridDetail').datagrid('getRowIndex',row);
				
				<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
				// 打开客户对应的子节点
				var customerIdTarget = $('#edatagridDetail').datagrid('getEditor', {'index':index,'field':'customerId'}).target;
				var customerId1 = row.customerId1;
				var customerId2 = row.customerId2;
				var customerId = row.customerId;
				//target.combobox('clear');
				customerIdTarget.combotree('loadData', getDataCustomer(customerId1,customerId2));
				//getDataCustomer
				var idCategoryLevel2Target = $('#edatagridDetail').datagrid('getEditor', {'index':index,'field':'idCategoryLevel2'}).target;
				//target.combobox('clear');
				if(row.idCategoryLeve1 != null && row.idCategoryLeve1 != ''){
					idCategoryLevel2Target.combobox('loadData', getCategoryLevel2(row.idCategoryLeve1)).combobox('setValue', row.idCategoryLevel2);
				}
				//绑定报销金额
				var amountTarget = $('#edatagridDetail').datagrid('getEditor', {'index':index,'field':'amount'}).target;
				amountTarget.numberbox({
					onChange : function(newValue, oldValue){
						var allRows = $('#edatagridDetail').edatagrid('getRows');
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
							var allRows = $('#edatagridDetail').edatagrid('getRows');
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
							$('#totalAmount').numberbox('setValue',totalAmount*1.00);
						}
					})
				});
				
				</c:if>
				<c:if test="${orderCategoryService.tagPageCode == '1809500'}">
				//var approverId2Target = $('#edatagridDetail').datagrid('getEditor', {'index':index,'field':'approverId2'}).target;
				</c:if>
			},
			<c:if test="${orderCategoryService.tagPageCode != '1809500'}"> 
			toolbar : [  
			    {
				iconCls : 'icon-add',
				text : common_button_add,
				handler : function() {
					$('#edatagridDetail').edatagrid('saveRow');
					var rows = $('#edatagridDetail').datagrid('getRows');
					var lastRowIndex = rows.length;
					if(lastRowIndex > 5){
						$.messager.alert(common_dialog_tip, '最多添加6项报销记录！', 'warning'); 
						return;
					}
				 	$('#edatagridDetail').datagrid('appendRow',{divisionId: '${divisionMainId}'});
					$('#edatagridDetail').edatagrid('editRow', lastRowIndex);	
					$('#edatagridDetail').edatagrid('selectRow', lastRowIndex);	
				}
			}, 
			'-',  {
				iconCls : 'icon-edit',
				text : common_button_edit,
				handler : function() {
					var selectedRow = $('#edatagridDetail').edatagrid('getSelected');
					if(!selectedRow){
						return;
					}
					var selectedIndex = $('#edatagridDetail').edatagrid('getRowIndex', selectedRow);
					$('#edatagridDetail').edatagrid('editRow', selectedIndex);
					$('#edatagridDetail').edatagrid('selectRow', selectedIndex);
				}
			}, 
			'-',  {
				iconCls : 'icon-remove',
				text : common_button_remove,
				handler : function() {
					var rows = $('#edatagridDetail').edatagrid('getRows');
					 if(rows.length < 2){
						return;
					} 
					
					var selectedRow = $('#edatagridDetail').edatagrid('getSelected');
					if(!selectedRow){
						return;
					}
					
					var selectedIndex = $('#edatagridDetail').edatagrid('getRowIndex', selectedRow);
					$('#edatagridDetail').edatagrid('deleteRow', selectedIndex);
					
					//var rows = $('#edatagridDetail').datagrid('getRows');
					if(rows.length == 0){
						return;
					}
					if(selectedIndex < rows.length){
						$('#edatagridDetail').edatagrid('editRow', selectedIndex);
						$('#edatagridDetail').edatagrid('selectRow', selectedIndex);
					}else{
						$('#edatagridDetail').edatagrid('editRow', rows.length - 1);
						$('#edatagridDetail').edatagrid('selectRow', rows.length - 1);
					}
					
					//删除时重新计算总金额
					var allRows = $('#edatagridDetail').edatagrid('getRows');
					var totalAmount = 0.0;
					for(var i = 0; i < allRows.length; i++ ){
						totalAmount += allRows[i].amount*1.0;
						//console.info(allRows[i].amount);
					}
					//console.info(totalAmount*1.00);
					$('#nbx_totalAmount').numberbox('setValue',totalAmount*1.00);
				}
			}, 
			'-',  
			]
			</c:if>
		});
		
		$('#frm_categoryService').form({
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
					$('#edatagridDetail').edatagrid('saveRow');
					var data = $('#edatagridDetail').datagrid('getRows');
					var jsonListString = JSON.stringify(data);
					$('#jsonListString').val(jsonListString);
				} else {
					$.messager.progress('close');	// hide progress bar while the form is invalid
					$.messager.alert(common_dialog_tip, '请完整填写！', 'warning'); 
				}
				return isValid;	// return false will stop the form submission
			},
			success : function(result) {
				$.messager.progress('close');
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$('#dlg_categoryService').dialog('close');
						$('#datagrid').datagrid('reload', serializeObject($('#formSearch')));
						$.messager.show({
							title : common_dialog_error,
							msg : '操作成功',
							timeout : 2000,
							showType : 'slide'
						});
						$('#datagrid').datagrid("clearSelections");
					} else {
						$.messager.alert(common_dialog_error, r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert(common_dialog_error, result, 'error');
				}
			}
		});
		
		
	});

function submitForm(status){
	var payeeId = $('#txt_payeeName').combobox('getValue');
	var payName = $('#txt_payeeName').combobox('getText');
	var payeeType = $('#payeeType').val();
	// 如果是外来人员,不需要验证
	if(null == payeeId || '' == payeeId){
		$('#payeeId').val('');
		$('#payeeName').val('');
		$.messager.alert(common_dialog_tip, '请填写正确的收款人!', 'warning');
		return;
	}
	if(payeeId.length >=1 && payeeId.length < 36 ){
		payeeId = ''
	}
	// 如果是内部员工需要验证
	else if (payeeId.length == 36 ){
		$("#bankName").val('');
	    $("#bankCard").val('');
	
		$('#payeeId').val(payeeId);
		$('#payeeName').val(payName);
	}
	$('#status_edit').val(status);
	// 赋值付款方式名称
	var typePaymentName = $('#typePaymentCode').combobox('getText');
	$('#typePaymentName').val(typePaymentName);
	// 赋值发票类型
	var typeInvoiceName = $('#typeInvoiceCode').combobox('getText');
	$('#typeInvoiceName').val(typeInvoiceName);
	$('#frm_categoryService').submit();
	submitSearchForm();
}

// 提交修改的审批人
function submitFormCode(code){
	$('#frm_categoryService').submit();
	submitSearchForm();
}

function submitSearchForm() {
	var searchDateStart = $('#searchDateStart').datebox('getValue');
	var searchDateEnd = $('#searchDateEnd').datebox('getValue');
	if (searchDateStart != null && searchDateEnd != null) {
		var calDateStart = new Date(searchDateStart);
		var calDateEnd = new Date(searchDateEnd);
		if (calDateEnd < calDateStart) {
			$.messager.alert(common_dialog_tip, '开始时间不能大于结束时间!', 'warning');
			return;
		}
	}
	var opt = $('#datagrid').datagrid('options');
	opt.url = contextPath + '/order/orderCategoryService/doSearch.do';
	$('#datagrid').datagrid('options', opt);
	$('#datagrid').datagrid('load', serializeObject($('#formSearch')));
}

function resetSearchForm(){
	//$('#formSearch').form('clear');
	$('#searchDateStart').datebox('setValue', '');
	$('#searchDateEnd').datebox('setValue', '');
	$('#applicantDivisionId').combobox('setValue', '');
	$('#customerId').combotree('setValue', '');
	$('#idCategoryLeve1').combobox('setValue', '');
	$('#status').combobox('setValue', '');
	$('#applicantName').textbox('setValue', '');
	$('#seaApplicantName').textbox('setValue', '');
	$('#seaPayeeName').textbox('setValue', '');
	$('#seaOrderCategory').combotree('setValue', '');
	$('#id').textbox('setValue', '');
	$('#seaTypePaymentCode').combobox('setValue', '');
	$('#seaTypeInvoiceCode').combobox('setValue', '');
}
	// 回车事件
	function submitFormMain(event){
		  if(event.keyCode==13){
			event.target.blur();
			submitSearchForm();
         }
	}
	
function uploadFile(attachFiled, attachIndex) {
	// edit attach 变更状态为上传附件
	$('#attachIndex').val(attachIndex);
	$('#typeImage').val(attachFiled);
	// 赋值需要上传附件的字段
	$('#attachFiled').val(attachFiled);
	// 上传类型为file
	$('#typeAttach').val('f');
	var file = $('#file_' + attachFiled).val();
	if (file == '') {
		$.messager.alert('<s:message code="common.dialog.tip" />',
				'请选择上传文件', 'warning');
		return;
	}
	$('#formMain').submit();
}	

function showOrderCategoryServiceModify1(mainId, detailId){

	var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryServiceModify.cpt' + '&serverIp=${pageContext.request.contextPath}&mainId=' + mainId + '&detailId='+ detailId;
	var content = formatString('<iframe src="' + url + '" frameborder="0" style="border : 0; width : 100%; height : 99%;"></iframe>', '');
	top.layout_center_addTab({
		title : formatString('报销修正日志', ''),
		closable : true,
		iconCls : 'ext-icon-user_edit',
		content : content
	});
}

function showOrderCategoryServiceModify(columnIdMain, columnId){
	var url = '${pageContext.request.contextPath}/ReportServer?reportlet=showOrderCategoryServiceModify.cpt' + '&serverIp=${pageContext.request.contextPath}&__showtoolbar__=false&columnId=' + columnId + '&columnIdMain='+ columnIdMain;
	$('#dia_showOrderCategoryServiceModify').dialog({
 	   title: '报销修正日志',
 	   width:1000,
 	   height:600,
 	   modal:true,
 	   content:"<iframe scrolling='auto' frameborder='0' src='" + url + "' style='width:100%; height:100%; display:block;'></iframe>"
	});
	$('#dia_showOrderCategoryServiceModify').dialog('open').dialog('center');
}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false" onkeydown="submitFormMain(event);">
<div data-options="title:'<s:message code="common.title.search" />',border:false" style="height: auto;" align="center">
		<input type="hidden" id="customerId1" />
		<input type="hidden" id="customerId2" />
		<form id="formSearch" >
			<table class="tableForm">
				<input type="hidden" name="tagPage" value="${orderCategoryService.tagPage}"/>
				<input type="hidden" name="tagPageCode" value="${orderCategoryService.tagPageCode}"/>
				<input type="hidden" name="typeData" value="${orderCategoryService.typeData}"/>
				<input type="hidden" id="editStateDetail" />
				<tr>
					<th style="width: 120px;">报销科目:  </th>
					<td>
						<select id="seaOrderCategory" name="seaOrderCategory" class="easyui-combotree" style="width:200px;" 
							data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'200', editable:false, parentField : 'pid',multiple:true,
							url : '${pageContext.request.contextPath}/common/droplist/doListOrderCategory.do?typeData=r&tag=a'">
						</select>
					</td>
					<th style="width: 120px;">客户:  </th>
					<td>
						<select id="customerId" name="customerId" class="easyui-combotree" style="width:200px;" 
							data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'200', editable:false, parentField : 'pid',
							<!-- url:'${pageContext.request.contextPath}/common/droplist/doListCustomer.do?tag=c&level=1'-->
							<!-- data : getDataCustomer(0, 0), -->
							url : '${pageContext.request.contextPath}/common/droplist/doListCustomerTree.do?tag=c'">
						</select>
					</td>
					<th width="120px">申请人: </th>
					<td><input id="seaApplicantName" name="seaApplicantName" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
					<th width="120px">收款人: </th>
					<td><input id="seaPayeeName" name="seaPayeeName" style="width: 200px;" class="easyui-textbox" data-options="validType:'length[1,10]'"/></td>
				</tr>
				<tr>
					<th style="width: 120px;">开始日期: </th>
					<td><input id="searchDateStart" name="searchDateStart" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">结束日期: </th>
					<td><input id="searchDateEnd" name="searchDateEnd" style="width: 200px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th style="width: 120px;">申请部门:  </th>
					<td><select id="applicantDivisionId" name="applicantDivisionId" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'200', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListCustomer.do?tag=d'"></select></td>
					<th width="120px">状态: </th>
					<td><select id="status" name="status" class="easyui-combobox" style="width:200px;" data-options="required:false, value:'${status}', valueField:'codeDetail', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doMapUserInfoDetail.do?type=sqglzt&&tagPageCode=${orderCategoryService.tagPageCode}'"></select></td>
				</tr>
				<tr>
					<th style="width: 120px;">报销ID: </th>
					<td><input id="id" name="id" style="width: 200px;" class="easyui-textbox" data-options="editable:true"/></td>
					<th width="120px">发票类型: </th>
					<td><select id="seaTypeInvoiceCode" name="seaTypeInvoiceCode" class="easyui-combobox" style="width:200px;" data-options="required:false, valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doMapUserInfoDetail.do?type=fplx'"></select></td>
					<th width="120px">付款方式: </th>
					<td><select id="seaTypePaymentCode" name="seaTypePaymentCode" class="easyui-combobox" style="width:200px;" data-options="required:false, valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doMapUserInfoDetail.do?type=fkfs'"></select></td>
				</tr>
				<tr>
				</tr>
			</table>
			<div style="text-align: center; padding: 5px">
				<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'" onclick="submitSearchForm();" ><s:message code="common.button.search" /></a> <a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="resetSearchForm();"><s:message code="common.button.reset" /></a>
			</div>
		</form>
	</div>
	<div  style="height:1000px;">
		<table id="datagrid" ></table>
	</div>
	<jsp:include page="attachOrderCategoryService.jsp"></jsp:include>
	<jsp:include page="editOrderCategoryService.jsp"></jsp:include>
	<jsp:include page="diaUser.jsp"></jsp:include>
	<div id="dia_showOrderCategoryServiceModify" class="easyui-dialog" closed="true"></div>
</body>
</html>
