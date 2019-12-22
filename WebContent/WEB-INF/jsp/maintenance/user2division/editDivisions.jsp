<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>编辑用户 [${user.displayName}] 部门</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript">
	//
	$(function() { 
		$('#treegrid').treegrid({
			url : '${pageContext.request.contextPath}/maintenance/division/doSearch.do?tag=${tag}',
			idField: 'id',
			treeField: 'name',
			parentField : 'pid',
			checkbox : true,
			fit:true,
			columns:[[
				{title:'Division Tree', field:'name', width:400, formatter:function(value, row, index){
					var checkboxhtml ='<input name="divisionIds" id="id-' + row.id + '" class="' + row.pid + '" type="checkbox" value="' + row.id + '" onclick = "divisionIdsClick(this);"';
					if(row.status == 1){
						checkboxhtml += ' disabled="disabled" ';
					}
					checkboxhtml += '/>';
					checkboxhtml += value;
					return checkboxhtml ;
				}},
				/* {field:'leaderIds',title:'Leader',align:'center',width:80,formatter:function(value, row, index){
					var checkboxhtml ='<input name="leaderIds" type="checkbox" value="' + row.id + '" onclick = "leaderIdsClick(this);"';
						if(row.status == 1){
						checkboxhtml += ' disabled="disabled" ';
					}
					checkboxhtml += '/>';
					return checkboxhtml;
				}},	 */
				{field:'mainIds',title:'Main',align:'center',width:80,formatter:function(value, row, index){
					var checkboxhtml ='<input name="mainIds" type="checkbox" value="' + row.id+ '" onclick = "mainClick(this);"';
						/* checkboxhtml += ' disabled="disabled" '; */
						checkboxhtml += '/>';
					return checkboxhtml;
				}},	
				{field:'positionId',title:'Position',align:'center',width:120,formatter:function(value, row, index){
					var listUserInfo = row.listBack1;
					var htmlOption = '<option></option>';
					
					for ( var i = 0; i < listUserInfo.length; i++) {
						var userInfo = listUserInfo[i];
						htmlOption += '<option value="' + userInfo.code + '">' + userInfo.name + '</option>'
					}
					var checkboxhtml ='<select id="' + row.id + '" name="positionId" class="easyui-combobox" style="width:110px;">' +
						htmlOption
					+ '</select>';
					return checkboxhtml;
				}},	
				{field:'description',title:'Description',width:350},
				{field:'level',title:'Level',width:350},
				{field:'status',title:'Status',width:60,align:'center',formatter:function(value, row, index){
						if (value == 0){
							return '<s:message code="common.status.enabled" />';
						} else if (value == 1) {
							return '<s:message code="common.status.disabled" />';
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
			toolbar : [{
				iconCls : 'icon-save',
				text : '<s:message code="common.button.save" />',
				handler : function() {
					saveDivisions();
				}
			} ,"-", {
				text : '<s:message code="common.button.collapseAll" />',
				iconCls : 'icon-collapse',
				handler : function() {
					$('#treegrid').treegrid('collapseAll');
				}
			},"-", {
				text : '<s:message code="common.button.expandAll" />',
				iconCls : 'icon-expand',
				handler : function() {
					$('#treegrid').treegrid('expandAll');
				}
			}],
			onLoadSuccess:function(){
				//$('span[class^="tree-icon"]').removeClass(); //remove treegrid's icon
				<c:forEach var="division" items="${userDivisions}">
					$("input[name='divisionIds'][value='${division.divisionId}']").attr("checked",true);
					<c:if test="${division.index==1}">
						$("input[name='leaderIds'][value='${division.divisionId}']").attr("checked",true);
					</c:if>
					<c:if test="${division.mainIndex==1}">
						$("input[name='mainIds'][value='${division.divisionId}']").attr("checked",true);
					</c:if>
					<c:if test="${division.positionId != null}">
						$("select[name='positionId'][id='${division.divisionId}']").val('${division.positionId}');
					</c:if>
				</c:forEach>
				<c:forEach var="division" items="${hasLeaderDivisions}">
					/* $("input[name='leaderIds'][value='${division.divisionId}']").attr("disabled",true); */
				</c:forEach>
				<c:forEach var="division" items="${hasLeaderMainDivisons}">
					/* $("input[name='mainIds'][value='${division.divisionId}']").attr("disabled",false); */
				</c:forEach>
			}
		});
		
	});
	
	function mainClick(obj) {
		if (obj.checked) {
			$("input[name='mainIds']").removeAttr('checked');
		}
		$("input[name='mainIds'][value='" + obj.value + "']").attr('checked', 'checked');
		$("input[name='divisionIds'][value='" + obj.value + "']").attr('checked', 'checked');
		$("#" + obj.value).val('gwmc1');
	}
	
	function divisionIdsClick(obj){
		var pid = $("#" + obj.id).attr('class');
		if(pid != null && pid != '') {
			var arrChild = $("input:checked[class='" + pid + "']");
			if(arrChild.length == 0){
				$("#id-" + pid).removeAttr('checked');
			};
		}

		if(!obj.checked){
			var leaderIds = $("input[name='leaderIds'][value='" + obj.value + "']");
			if(leaderIds.length == 1){
				leaderIds[0].checked = false;
			} 
			$("#" + obj.value).val('');
			$("#id-" + obj.id).removeAttr('checked');
			
	
		}else{
			$("#" + obj.value).val('gwmc1');
			if(pid != null && pid != '') {
				$('#id-' + pid).attr('checked', true);
			}
			$("#id-" + obj.id).attr('checked', 'checked');
		}	
		//treeChecked(obj.value, 'treegrid');
		
		
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
		var mainIndex = '';
		var arrayPosition = '';

		var arrayDivisionObj = $("input:checked[name='divisionIds']");
		if (arrayDivisionObj.size() == 0) {
			$.messager.alert('<s:message code="common.dialog.error" />', '请至少选择一个部门!', 'error');
			return;
		}
		
		var arrayMainIds = $("input:checked[name='mainIds']");
		if (arrayMainIds.size() == 0) {
			$.messager.alert('<s:message code="common.dialog.error" />', '请至少选择一个主部门!', 'error');
			return;
		}
		for ( var i = 0; i < arrayDivisionObj.size(); i++) {
			var divisionId = arrayDivisionObj[i].value;
			var positionId = $('#' + divisionId).val();
			if ("" == positionId) {
				$.messager.alert('<s:message code="common.dialog.error" />', '部门职位不可为空!', 'error');
				return;
			} else {
				divisionArray.push(divisionId + ' ' + positionId);
			}
			
		}
		$("input:checked[name='leaderIds']").each(function(){
			leaderArray.push($(this).val());
		});
		
		$("input:checked[name='mainIds']").each(function(){
			mainIndex = $(this).val();
		});
		$.post(
			"${pageContext.request.contextPath}/maintenance/user2division/doEditDivisions.do",
			{ userId:'${userId}', tag: '${tag}', divisionIds: divisionArray.join(","), leaderIds: leaderArray.join(",") ,mainIndex: mainIndex},
			function(result){
				try {var r = $.parseJSON(result);
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

function treeChecked(selected, treeMenu) {  
    var roots = $('#' + treeMenu).tree('getRoots');//返回tree的所有根节点数组  
    if (selected.checked) {  
        for ( var i = 0; i < roots.length; i++) {  
            var node = $('#' + treeMenu).tree('find', roots[i].id);//查找节点  
            $('#' + treeMenu).tree('check', node.target);//将得到的节点选中  
        }  
    } else {  
        for ( var i = 0; i < roots.length; i++) {  
            var node = $('#' + treeMenu).tree('find', roots[i].id);  
            $('#' + treeMenu).tree('uncheck', node.target);  
        }  
    }  
} 
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<form id="fm" method="post"> 
		<input name="userId" type="hidden" value="${userId}"/>
		<div data-options="region:'center',title:'编辑用户 [${user.loginName}] 部门', border:false" align="left">
			<table id="treegrid"></table>
		</div>
	</form>
</body>
</html>