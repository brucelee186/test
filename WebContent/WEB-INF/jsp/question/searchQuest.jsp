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
	$(function() {
		$('#datagrid').datagrid({
			url : '${pageContext.request.contextPath}/office/quest/doSearch.do',
			fit:true,
			pagination : true,
			collapsible:true,
			title:'',
			idField : 'id',
			pageSize : 10,
			pageList : [10, 50, 100, 200 ],
		 	sortName : 'addDate',
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
			, {
				title : '标题',
				field : 'title',
				width : 250,
				sortable : true
			}
			] ],
			columns : [ [ {
				title : '描述',
				field : 'description',
				sortable : true,
				width : 150
			}
			, {
				title : '<s:message code="office.item.AddDate" />',
				field : 'showAddDate',
				sortable : true,
				width : 150
			}
			, {
				title : '问卷类型',
				field : 'type',
				sortable : true,
				width : 150,
				formatter : function(value, row, index) {
					if (value == 'd'){
						return '默认问卷';
					} else if (value == 'e') {
						return '其他问卷';
					}
				},
				styler: function(value, row, index){
					if (value == 'd'){
						return 'background-color:#C6EFCE;color:#006100;';
					} else if (value == 'e') {
						return 'background-color:#FFC7CE;color:#9C0006;';
					}
				}
			}
			 ] ],
			toolbar : [
			<c:if test="${comUtil.checkCode('1301001')}">
				{
					iconCls: 'icon-add',
					text:'新建问卷',
					handler: function(){
						var url = '${pageContext.request.contextPath}/office/quest/toEdit.do?editState=i';
						window.location.href = url;	
					}
				},'-',
			</c:if>
			<c:if test="${comUtil.checkCode('1301002')}">
				{
					iconCls: 'icon-edit',
					text:'编辑问卷',
					handler: function(){
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
							}
					var url = '${pageContext.request.contextPath}/office/quest/toEdit.do?editState=u&id=' + checkedRows[0].id;
							window.location.href = url;
					
					}
				},'-',
			</c:if>
			<c:if test="${comUtil.checkCode('1301003')}">
				{
					iconCls: 'icon-search',
					text:'问卷结果统计',
					handler: function(){
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
							}
						var url = '${pageContext.request.contextPath}/ReportServer?reportlet=userScore.cpt&quesId='+ checkedRows[0].id;
							window.location.href = url;
					
					}
				},'-',
			</c:if>
			<c:if test="${comUtil.checkCode('1301004')}">
				{
					iconCls: 'icon-key',
					text:'生成问卷链接',
					handler: function(){
						var checkedRows = $('#datagrid').datagrid('getSelections');
						if (checkedRows == null || checkedRows == undefined || checkedRows.length == 0) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
							}
					var questId = checkedRows[0].id;
					if (questId == null || questId == undefined) {
						$.messager.alert('<s:message code="common.dialog.tip" />', '<s:message code="office.dialogue.pleaseSelectOne" />', 'warning');
						return;
					}
					$.post('${pageContext.request.contextPath}/office/quest/getLink.do',{questId:questId},
							function(result){
							var r = $.parseJSON(result);
							if (r.success){
								var link = r.msg;
								$('#input_link').val(link);
							}
						
					});
						$('#dialog_link').dialog('open');
					}
				}
			</c:if>
			]
		});
	});
	
	
</script>
</head>
<body>
	<div id="datagrid" ></div>
	<div id="depDatagrid"></div>
	<div id="dialog_link" class="easyui-dialog" title="问卷链接" style="width:400px;height:200px;"  
		data-options="iconCls:'icon-save',resizable:true,modal:true,closed:true">  
		<textarea style="border: none;resize:none;" cols="40" rows="6" id="input_link" readonly="readonly"></textarea>
	</div>
	
	
</body>
</html>
