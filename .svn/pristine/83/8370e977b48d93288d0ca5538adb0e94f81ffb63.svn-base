<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Edit Role [${role.name}] Actions</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
	$(function() {

		var officeId = '${item.officeId}';
		var editState = $('#editState').val();
		if (editState == 'u') {
			initMainList(officeId);
		}else {
			// 初始化item数据
			initMainList(-1);
		}
		// 初始化itemRule
		initItemRule();
		$('#form').form({
			url : '${pageContext.request.contextPath}/office/item/doEdit.do',
			onSubmit: function() {
				var isValid = $(this).form('validate');
				if (isValid) {
					$.messager.progress();
				} else {
					$.messager.progress('close');	
				}
				return isValid;	
			},
			success : function(result) {
				$.messager.progress('close');
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
						window.location.href ='${pageContext.request.contextPath}/office/office/toOfficeAdd.do';
					} else {
						$.messager.alert('<s:message code="common.dialog.error" />',r.msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		});

		
		
		
	});
	
	function initMainList(officeId){
		var url = '';
		if (officeId != -1) {
			url = '${pageContext.request.contextPath}/office/item/doSearch.do?officeId='+officeId;
		}
		$('#datagrid').datagrid({
			url : url,
			fit : true,
			fitColumns : true,
			border : false,
			pagination : false,
			singleSelect : true,
			checkOnSelect : false,
			rownumbers:true,
			selectOnCheck : false,
			nowrap : true,
			frozenColumns : [ [ {
				title : 'ID',
				width : 50,
				sortable : false,
				hidden : true,
				/* ,
				checkbox : true */
			}, {
				title : '<s:message code="office.rowName.type" />',
				field : 'type',
				width : 250,
				sortable : true
			} ] ],
			columns : [ [ {
				title : '<s:message code="office.rowName.specification" />',
				field : 'specification',
				sortable : false,
				width : 50
			}, {
				field : 'ruleId',
				hidden:true,
				width : 200
			}, {
				title : '<s:message code="office.item.amount" />',
				field : 'amount',
				sortable : false,
				width : 200
			} ] ],
			queryParams: {
				id : '${role.id}'
			},
			toolbar : [{
				iconCls : 'icon-remove',
				text : '<s:message code="office.button.delete" />',
				handler : function() {
					var checkedRows = $('#datagrid').datagrid('getSelected');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rowIndex = $('#datagrid').datagrid('getRowIndex', checkedRows);
					$('#datagrid').datagrid('deleteRow', rowIndex);
					
					/* var i = 0;
					for (i = 0; i < checkedRows.length; i ++) {
						var rowIndex = $('#datagrid').datagrid('getRowIndex', checkedRows[i]);
						$('#datagrid').datagrid('deleteRow', rowIndex);
					} */
				}
			}, '-', {
				iconCls : 'icon-save',
				text : '<s:message code="office.button.submitForApproval" />',
				handler : function() {
					var ruleIds='';
					var amount='';
					var resources = $('#datagrid').datagrid('getRows');
					for (var i = 0; i < resources.length; i ++) {
						ruleIds = ruleIds + resources[i].ruleId + ","
						amount = amount + resources[i].amount + ",";
					}
					$('#txt_itemRuleId').val(ruleIds);
					$('#txt_itemRuleAmount').val(amount);
					$('#form').submit();
				}
			}]
		});
	}
	
	function initItemRule(){
		
		$('#datagrid_itemRule').datagrid({
			fit : true,
			fitColumns : true,
			border : false,
			url : '${pageContext.request.contextPath}/office/itemrule/doSearch.do?status=0',
			pagination : true,
			pageSize : 200,
			pageList : [ 10, 20, 50, 100, 200 ],
			idField : 'id',
			sortName : 'type',
			sortOrder : 'asc',
			singleSelect : true,
			checkOnSelect : false,
			selectOnCheck : false,
			nowrap : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 50,
				sortable : false,
				checkbox : true
			}, {
				title : '<s:message code="office.rowName.type" />',
				field : 'type',
				width : 150,
				sortable : true
			} ] ],
			columns : [ [ {
				title : '<s:message code="office.rowName.specification" />',
				field : 'specification',
				sortable : true,
				width : 50
			},{
				title : '<s:message code="office.rowName.unit" />',
				field : 'unit',
				sortable : true,
				width : 100
			}, {
				title : '<s:message code="office.item.amount" />',
				field : 'amountMax',
				width : 100,
				sortable : true,
				 formatter : function(value, row, index){
					 <c:if test='${sessionInfo.userLever == "0" || sessionInfo.userLever == "1" || sessionInfo.userLever == "4" || sessionInfo.userLever == "7"}'>
					 if (value == 1) {
						 return "&nbsp;"+value;
					 }else {
						 var before = '<select class=se id=officeDep_'+row.id+' style="width:50px">';
						 var after = '</select>';
						 var temp = '';
						 for ( var i = 1; i<= value; i++) {
							 temp = temp + '<option value='+i+' >'+i+'</option>'
						 }
						 return before + temp + after;
						 
					 }
					</c:if>
					<c:if test='${sessionInfo.userLever == "5"}'>
					 var before = '<select class=se id=officeDep_'+row.id+' style="width:50px">';
					 var after = '</select>';
					 var temp = '';
					 for ( var i = 1; i<=50; i++) {
						 temp = temp + '<option value='+i+' >'+i+'</option>'
					 }
					 return before + temp + after;
					 </c:if>
					}
				
				
			}	] ],
			toolbar : [
				{
				iconCls : 'icon-add',
				text : '<s:message code="office.button.addOS" />',
				handler : function() {
					var checkedRows = $('#datagrid_itemRule').datagrid('getChecked');
					if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						return;
					}
					var rows = $('#datagrid').datagrid('getRows');
					var countSkiped = 0;
					var countAdded = 0;
					var isExists = false;
					var amount = 0;
					for (var i = 0; i < checkedRows.length; i ++) {
						isExists = false;
						for(var j = 0; j < rows.length; j++) {
							if (rows[j].ruleId == checkedRows[i].id) {
								isExists = true;
								countSkiped ++;
								break;
							}
						}
						<c:if test='${sessionInfo.userLever == "0" || sessionInfo.userLever == "1" || sessionInfo.userLever == "4" || sessionInfo.userLever == "7"}'>
						if (checkedRows[i].amountMax == undefined || checkedRows[i].amountMax == '' || checkedRows[i].amountMax == 1) {
							amount ="1";
						}
						else{
							amount = $("#officeDep_" + checkedRows[i].id).val();
						}
						</c:if>
						<c:if test='${sessionInfo.userLever == "5"}'>
							amount = $("#officeDep_" + checkedRows[i].id).val();
						</c:if>
						if (isExists == false) {
							$('#datagrid').datagrid('appendRow',{
								ruleId:checkedRows[i].id,
								type:checkedRows[i].type,
								specification:checkedRows[i].specification,
								amount:amount
							});
							countAdded ++;
						}
					}
					$.messager.show({
						title:'<s:message code="common.dialog.tip" />',
						msg:formatString('{0} Added, {1} Skip', countAdded, countSkiped),
						timeout:2500,
						showType:'fade'
					});
				}
			}]
		});
		
	}

</script>
<style>
.se
{
border-color:white;
padding-left:0;
margin-left:0;
font-size:100%;
}

</style>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'<s:message code="office.button.addApplicationForOS" />',border:false" align="center">
		<form id="form" method="post" style="visibility: hidden;">
			<input id="txt_itemRuleAmount" type="hidden" name="amounts" />
			<input id="txt_itemRuleId" type="hidden" name="ruleIds"/>
			<input id="officeId" type="hidden" name="officeId" value="${item.officeId}"/>
			<input id="editState" type="hidden" name="editState" value="${item.editState}"/>
		</form>
		
		<table id="datagrid"></table>
	</div>
	<div data-options="region:'east',border:false,split:true,title:'<s:message code="office.title.detailsForOS" />'" style="width: 550px; overflow: hidden;">
		<table id="datagrid_itemRule"></table>
	</div>
</body>
</html>