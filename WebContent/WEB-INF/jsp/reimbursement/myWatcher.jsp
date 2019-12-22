<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>我关注的采购</title>
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
		url : '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearchForMyWatcher.do',
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
			applicationDateFrom :  getlastMonth(),
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
			width : 150
		},{
			title : '申请部门',
			field : 'applicantdivisionName',
			sortable : true,
			width : 150
		},{
			title : '申请日期',
			field : 'applicantDatetime',
			sortable : true,
			align : 'center',
			width : 110
		},{
			title : '估算总金额',
			field : 'quoteTotalAmount',
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
				}
			}
		},{
			title : '申请审批',
			field : 'reqLevel',
			sortable : false,
			width : 65,
			align : 'center',
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
		toolbar : [ {
			iconCls : 'ext-icon-note_add',
			text : '增加评论',
			handler : function() {
				var checkedRows = $('#dtg_purchase').datagrid('getSelections');
				if(checkedRows[0] == undefined){
					return;
				}
				
				$('#frm_comment_add').form('clear');
				$('#dlg_comment_add').dialog('setTitle', '增加评论').dialog('open').dialog('center');	
			}
		}, '-',{
			iconCls : 'ext-icon-heart_delete',
			text : '取消关注',
			handler : function() {
				var checkedRows = $('#dtg_purchase').datagrid('getSelections');
				if(checkedRows[0] == undefined){
					return;
				}
				//批量添加删除项信息
				var arr = [];
				
				for(var i = 0;i < checkedRows.length;i++){
					 var row = {
							'id' : checkedRows[i].id
						};
					arr.push(checkedRows[i].id);
				}
			
			var idsStr = JSON.stringify(arr);
			$.messager.confirm('<s:message code="common.confirm" />', '确定取消关注？', function(rr) {
				if(rr){
					$.post('${pageContext.request.contextPath}/office/reimbursement/purchase/doDeleteForWatcher.do', {idsStr : idsStr}, function(result){
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
			//width:1179,
			sortName : 'index',
			sortOrder : 'desc',
			dataField : 'listPurchaseItem',
			columns :[{
				title : '采购部门',
				field : 'divisionName',
				align : 'left',
				width : 110
			},{
				title : '客户',
				field : 'customerName',
				align : 'left',
				width : 110
			},{
				title : '主类别',
				field : 'category1Name',
				align : 'left',
				width : 115
			},{
				title : '次类别',
				field : 'category2Name',
				align : 'left',
				width : 110
			},{
				title : '描述',
				field : 'description',
				align : 'left',
				tooltip : true,
				width : 450
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
	

	$('#frm_comment_add').form({
		onSubmit : function() {
			var isValid = $(this).form('validate');
			if (isValid) {
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
					$.messager.alert('<s:message code="common.tip" />', '增加评论成功！', 'info', function(rr) {
						$('#dtg_purchase').datagrid('reload');
						$('#dlg_approve').dialog('close');
						
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

function doSubmit() {
	var checkedRows = $('#dtg_purchase').datagrid('getSelections');
	if(checkedRows[0] == undefined){
		return;
	}
	
	var url = '${pageContext.request.contextPath}/workgroup/purchase/purchaseComment/addComment.do';
	
	var comment = $('#txt_comment').textbox('getValue');
	
	$.messager.confirm('<s:message code="common.confirm" />', '确定提交评论？', function(rr) {
		if (rr) {
			$.messager.progress();
			$.post(url, {purchaseId : checkedRows[0].id, comment : comment}, function(result) {
				$.messager.progress('close');// hide progress dialog
				try {
					var j = result;
					if (j.success) {
						$.messager.alert('<s:message code="common.tip" />', '提交评论成功！', 'info', function(rr) {
							$('#dlg_comment_add').dialog('close');
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

function openCommentDialog(purchaseId){
	var url = formatString('${pageContext.request.contextPath}/workgroup/purchase/purchaseComment/toSearch.do?purchaseId={0}', purchaseId);
	$('#ifr_comment').attr('src', url); 
	$('#dlg_comment').dialog('setTitle', '评论').dialog('open').dialog('center');
}

function submitSearchForm() {
	var $dtg = $('#dtg_purchase');
	var opt = $dtg.datagrid('options');
	if (opt.url == undefined || opt.url == null || opt.url == '') {
		opt.url = '${pageContext.request.contextPath}/office/reimbursement/purchase/doSearchForMyWatcher.do';
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
	<div data-options="region:'center',title:'关注的采购',border:false">
		<table id="dtg_purchase"></table>
	</div>
	<div data-options="region:'north',title:'搜索',border:true" style="height: 90px;overflow: hidden;" align="center">
		<form id="frm_search"  method="post">
			<table class="mtftable">
				<tr>
					<th align="right" style="width: 80px;">NO.</th>
					<td>:</td>
					<td><input name="no" class="easyui-textbox" style="width: 150px"/></td>
					<th align="right" style="width: 80px;">申请人</th>
					<td>:</td>
					<td><input name="applicantName" class="easyui-textbox" style="width: 150px" /></td>
					<th align="right" style="width: 80px;">申请时间(From)</th>
					<td>:</td>
					<td><input id="dtx_applicationDateFrom" name="applicationDateFrom" class="easyui-datebox" style="width: 120px" data-options="editable:false"/></td>
					<td>&nbsp;</td>
				</tr>
				<tr>
					<th align="right" style="width: 80px;">采购状态</th>
					<td>:</td>
					<td><select id="cbx_statuses" name="statuses" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, multiple:true">
					<option value="0">草稿</option>
					<option value="1">已提交</option>
					<option value="2">申请审批完成</option>
					<option value="3">已估价</option>
					<option value="4">采购审批完成</option>
					<option value="5">已采购</option>
					<option value="6">采购完成</option>
					<option value="8">拒绝</option>
					<option value="9">取消</option>
					</select></td>
					<th align="right" style="width: 80px;">申请部门</th>
					<td>:</td>
					<td><div name="applicantdivisionId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', text : 'name', data : getDiv() "/>
					</td>
					<th align="right" style="width: 120px;">申请时间(To)</th>
					<td>:</td>
					<td><input id="dtx_applicationDateTo" name="applicationDateTo" class="easyui-datebox" style="width: 120px" data-options="editable:false "/></td>
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
	<div id="dlg_comment_add" class="easyui-dialog" style="width:524px;height:280px;" data-options="resizable:true,modal:true,closed: true, 
		onOpen: function() {formValidate('#frm_comment_add', true);}, onClose: function() {formValidate('#frm_comment_add', false);},
		buttons: [{text:'提交', iconCls:'ext-icon-tick', handler:function(){doSubmit();}}]">
		<form id="frm_comment_add" method="post">
		<input id="hid_purchaseId" name="purchaseId" type="hidden"/>
			<table class="mtftable">
				<tbody>
					<tr>
						<td><input id="txt_comment" name="comment" class="easyui-textbox" style="width: 503px;height:200px;border-style:none;" maxlength="255" data-options="prompt:'Enter comment...',multiline:true,validType:'length[0,255]'"/></td>
					</tr>
				</tbody>	
			</table>
		</form>
	</div>
	
</body>
</html>
