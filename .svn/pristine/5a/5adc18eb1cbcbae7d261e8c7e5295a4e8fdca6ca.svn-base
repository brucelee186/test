<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>编辑用户 [${user.loginName}] 部门</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	//
	$(function() {
		$('#tree').treegrid({
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do',
			idField: 'id',
			treeField: 'name',
			parentField : 'pid',
			fit:true,
			columns:[[
				{title:'Division Tree', field:'name', width:400, formatter:function(value, row, index){
					var checkboxhtml ='<input name="divisionIds" type="checkbox" value="' + row.id + '" onclick = "divisionIdsClick(this);"';
					if(row.status == 1){
						checkboxhtml += ' disabled="disabled" ';
					}
					checkboxhtml += '/>';
					checkboxhtml += value;
					return checkboxhtml ;
				}},
				{field:'leaderIds',title:'Leader',align:'center',width:80,formatter:function(value, row, index){
					var checkboxhtml ='<input name="leaderIds" type="checkbox" value="' + row.id + '" onclick = "leaderIdsClick(this);"';
					if(row.status == 1){
						checkboxhtml += ' disabled="disabled" ';
					}
					checkboxhtml += '/>';
					return checkboxhtml;
				}},				
				{field:'description',title:'Description',width:250},
				{field:'status',title:'Status',width:60,align:'center',formatter:function(value, row, index){
						if (value == 0){
							return 'Enabled';
						} else if (value == 1) {
							return 'Disabled';
							var ckbox = $(":checkbox[value='" + row.id + "']");
							for(var box in ckbox){
								box.enabled = true;
							}
						}
					},
					styler: function(value, row, index){
						if (value == 0){
							return 'background-color:#C6EFCE;color:#006100;';
						} else if (value == 1) {
							return 'background-color:#FFC7CE;color:#9C0006;';
						}
					}
				}]],
			onLoadSuccess:function(){
				//$('span[class^="tree-icon"]').removeClass(); //remove treegrid's icon
				<c:forEach var="division" items="${userDivisions}">
					$("input[name='divisionIds'][value='${division.divisionId}']").attr("checked",true);
					<c:if test="${division.index==1}">
					$("input[name='leaderIds'][value='${division.divisionId}']").attr("checked",true);
					</c:if>
				</c:forEach>
				
				<c:forEach var="division" items="${hasLeaderDivisions}">
					$("input[name='leaderIds'][value='${division.divisionId}']").attr("disabled",true);
				</c:forEach>
			}
		});
		
	});
	
	function divisionIdsClick(obj){
		if(!obj.checked){
			var leaderIds = $("input[name='leaderIds'][value='" + obj.value + "']");
			if(leaderIds.length == 1){
				leaderIds[0].checked = false;
			} 
		}
	}
	
	function leaderIdsClick(obj){
		if(obj.checked){
			var divisionIds = $("input[name='divisionIds'][value='" + obj.value + "']");
			if(divisionIds.length == 1){
				divisionIds[0].checked = true;
			} 
		}
	}
	
	function saveDivisions(){
		var divisionArray = [] ;
		var leaderArray = [] ;

		$("input:checked[name='divisionIds']").each(function(){
			divisionArray.push($(this).val());
		});
		
		$("input:checked[name='leaderIds']").each(function(){
			leaderArray.push($(this).val());
		});
	
		$.post(
			"${pageContext.request.contextPath}/maintenance/user2division/doEditDivisions.do",
			{ userId:'${userId}', divisionIds: divisionArray.join(","), leaderIds: leaderArray.join(",")},
			function(result){
				try {
					var r = $.parseJSON(result);
					if (r.success) {
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info', function(rr) {
							top.layout_center_closeTab();
						});
					} else {
						var msg ="Message:<br><font style='color:red'>" + r.msg + "</font>";
						$.messager.alert('<s:message code="common.dialog.error" />', msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}
		); 
	}
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',title:'编辑用户 [${user.loginName}] 部门', border:false" align="left">
		<input name="userId" type="hidden" value="${userId}" />
		<table id="tree"></table>
	</div>
</body>
</html>