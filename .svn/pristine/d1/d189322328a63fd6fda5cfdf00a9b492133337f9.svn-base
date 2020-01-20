<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>采购评论</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
<script type="text/javascript">
	p_purchaseComment = ${purchaseComments};
	
	$(function(){
		$('#dtg_comment').datagrid({
			fit : true,
			border : true,
			/* sortName : 'createDatetime',
			sortOrder : 'desc', */
			nowrap : true,
			rownumbers : false,
			autoRowHeight : true,
			frozenColumns : [ [ {
				title : 'ID',
				field : 'id',
				width : 0,
				hidden : true
			}] ],
			columns : [ [ {
				title : 'Id',
				field : 'id',
				width : 60,
				hidden : true
			}, {
				title : '评论',
				field : 'comment',
				width : 430
			},{
				title : '创建时间',
				field : 'createDatetime',
				width : 150
			},{
				title : '创建人',
				field : 'createUserName',
				width : 150
			}] ],
			onLoadSuccess : function(data) {
				$(this).datagrid('tooltip', ['comment']);
			}
		});
		
		$('#dtg_comment').datagrid('loadData', p_purchaseComment);
	});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',border:false" >
		<table id="dtg_comment" class="easyui-datagrid"></table>
	</div>
</body>
</html>
