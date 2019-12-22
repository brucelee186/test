<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>search Version</title>
<jsp:include page="../../inc.jsp"></jsp:include>
<script type="text/javascript" charset="utf-8">
$(function() {
	console.info("${history.userIds}");
	var userIds=$('#hid_userIds').val();
	console.info(userIds);
	$('#mainList').datagrid({
		title:'',
		fit:true,
		border:false,
		 url : '${pageContext.request.contextPath}/maintenance/history/doSearch.do?userIds='+userIds, 
		/* url : '${pageContext.request.contextPath}/maintenance/history/doSearch.do', */
		pagination : true,
		collapsible:true,
		fitColumns : false,
		idField : 'id',
		pageSize : 100,
		pageList : [ 10, 20, 50, 100, 200 ],
		sortName : 'versionNO',
		sortOrder : 'desc',
		singleSelect : true,
		checkOnSelect : false,
		selectOnCheck : false,
		nowrap : true,
		rownumbers : true,
		frozenColumns : [ [ {
			title : 'ID',
			field : 'userIds',
			width : 200,
			sortable : false,
			hidden : true
		}] ],
		columns : [ [ 
		{
			title : '类型',
			field : 'type',
			width : 50,
			sortable : true,
			align:'center',
			formatter : function(value, row, index) {
				if (value == 'r' ) {
					return '角色';
				} else if(value == 'd' ){
					return '部门';
				}
			} 
		}, 
		{
			title : '创建时间',
			field : 'addDate',
			width : 130,
			sortable : true,
			align:'center',
			formatter : function(value,row,index){
				var date = new Date(value);
				return date.getFullYear() + '-' + (date.getMonth() + 1) + '-' + date.getDate()+ '    ' + date.getHours() + ':' + date.getMinutes()  + ':' + date.getSeconds();
				
			}
		}, {
			title : '版本号',
			field : 'versionNO',
			width : 80,
			sortable : true,
			align:'center'
		}, {
			title : '位置',
			field : 'codeId',
			width : 200,
			sortable : true ,
			formatter : function(value,row,index){
				if (value == '2c3b2f7e-e023-4ea8-80a7-e2ced921c13f' ) {
					return '临时用户';
				} else if(value == '403d43f9-424c-4ed9-ada5-96c09dfdd0b0' ){
					return 'AdminMenu(系统管理员菜单)';
				} else if(value == '465ba1bc-f2b9-4ef2-9d9b-a74b0809e5fb' ){
					return 'Merchandiser(业务部经理)';
				}else if(value == '57488731-ccfc-4f88-9327-5ff11429e623' ){
					return 'Admin(管理员)';
				}else if(value == '90aa9f03-e835-474c-af96-fd2e080ac955' ){
					return 'MaintenanceMenu(维护人员菜单)';
				}else if(value == '9678860e-d0b3-4e53-8661-89f0f2adf42f' ){
					return 'WorkGroupMenu(员工)';
				}else if(value == 'a59687d4-4b99-461a-913c-70106d858454' ){
					return '高管人员';
				}else if(value == 'a59ce063-ad5a-4d0e-ae72-af2be527ad9b' ){
					return '单证员';
				}else if(value == 'cabb21a2-fb07-4a81-89a6-a94a1872cb18' ){
					return '总经理(GeneralManager)';
				}else if(value == 'e5ae7cb8-cee4-4a5d-a9da-5a387edf5dd7' ){
					return '业务员';
				}else if(value == 'f9867248-f2f5-41d5-bb04-ea4daf7ba34a' ){
					return 'Sys Admin(系统管理员)';
				}else if(value == 'fd20733b-35e9-4499-8003-7b78811b0076' ){
					return 'Business Manager(事业部经理)';
				}else if(value == '01bf2e7b-c5b5-4dab-a2f5-6bf6f1f34a63' ){
					return '物流部';
				}else if(value == '04720162-354e-47dc-96d0-c4a5ae6b3692' ){
					return '验厂部';
				}else if(value == '0ce0d560-dbef-4231-a2ce-01a12a11f3fa' ){
					return '事业部';
				}else if(value == '115ddbc2-925a-4305-8907-d7b22840d445' ){
					return '业务4部';
				}else if(value == '22b34a63-8540-4566-b6da-89084b549f44' ){
					return 'QA';
				}else if(value == '252f7a6f-c187-40d3-9635-2a2d6807ea92' ){
					return '业务5部';
				}else if(value == '46f1d3a5-eca0-45f9-8079-d0e996ccb8df' ){
					return '高管部';
				}else if(value == '47147768-0ebb-49ce-96db-949db38ea686' ){
					return '裁剪车间';
				}else if(value == '49b49d0e-dbbb-4cb3-8aac-972dcb73a21e' ){
					return '样品仓库';
				}else if(value == '571efe1a-8e5d-44e7-b382-e43c0dd6bc0a' ){
					return '设计开发部';
				}else if(value == '5ea67a15-3cf0-4ce4-8041-534a32b2ed16' ){
					return '实验室';
				}else if(value == '68b41588-e1b6-4878-8b3a-0eae0e6311d4' ){
					return '信息技术部';
				}else if(value == '718ebbab-aa4d-4d63-a037-020c71240c68' ){
					return '业务1部';
				}else if(value == '8dde82b7-4f7c-4d1b-9e6a-76ba179a9f5e' ){
					return '纸型车间';
				}else if(value == '49b49d0e-dbbb-4cb3-8aac-972dcb73a21e' ){
					return '样品仓库';
				}else if(value == '8dfc2bfb-35bc-482e-ae9f-6cb710a2f601' ){
					return '业务2部';
				}else if(value == 'a7987d2a-1c2f-4c0a-93d9-27552b33efec' ){
					return '财务部';
				}else if(value == 'ab817736-8197-462e-a15b-910ec799efdb' ){
					return '行政部';
				}else if(value == 'c7a5d699-5c6b-42ff-a2de-ad11e032e849' ){
					return '单证部';
				}else if(value == 'd6b256b1-3a83-4797-bfeb-4f01f45460ab' ){
					return '技术部';
				}else if(value == 'da3ea261-f04f-4ca9-b96d-d95528d76590' ){
					return '设计技术组';
				}else if(value == 'e126cbf6-e2dd-4bea-a608-6e76133583b8' ){
					return '业务3部';
				}else if(value == 'f19e2ea3-6ea0-4122-99b4-514cf395aedb' ){
					return '样品车间';
				}
			} 
		}, 
		{
			title : '原位置',
			field : 'preCodeId',
			width : 200,
			sortable : true,
			formatter : function(value,row,index){
				if (value == '2c3b2f7e-e023-4ea8-80a7-e2ced921c13f' ) {
					return '临时用户';
				} else if(value == '403d43f9-424c-4ed9-ada5-96c09dfdd0b0' ){
					return 'AdminMenu(系统管理员菜单)';
				} else if(value == '465ba1bc-f2b9-4ef2-9d9b-a74b0809e5fb' ){
					return 'Merchandiser(业务部经理)';
				}else if(value == '57488731-ccfc-4f88-9327-5ff11429e623' ){
					return 'Admin(管理员)';
				}else if(value == '90aa9f03-e835-474c-af96-fd2e080ac955' ){
					return 'MaintenanceMenu(维护人员菜单)';
				}else if(value == '9678860e-d0b3-4e53-8661-89f0f2adf42f' ){
					return 'WorkGroupMenu(员工)';
				}else if(value == 'a59687d4-4b99-461a-913c-70106d858454' ){
					return '高管人员';
				}else if(value == 'a59ce063-ad5a-4d0e-ae72-af2be527ad9b' ){
					return '单证员';
				}else if(value == 'cabb21a2-fb07-4a81-89a6-a94a1872cb18' ){
					return '总经理(GeneralManager)';
				}else if(value == 'e5ae7cb8-cee4-4a5d-a9da-5a387edf5dd7' ){
					return '业务员';
				}else if(value == 'f9867248-f2f5-41d5-bb04-ea4daf7ba34a' ){
					return 'Sys Admin(系统管理员)';
				}else if(value == 'fd20733b-35e9-4499-8003-7b78811b0076' ){
					return 'Business Manager(事业部经理)';
				}else if(value == '01bf2e7b-c5b5-4dab-a2f5-6bf6f1f34a63' ){
					return '物流部';
				}else if(value == '04720162-354e-47dc-96d0-c4a5ae6b3692' ){
					return '验厂部';
				}else if(value == '0ce0d560-dbef-4231-a2ce-01a12a11f3fa' ){
					return '事业部';
				}else if(value == '115ddbc2-925a-4305-8907-d7b22840d445' ){
					return '业务4部';
				}else if(value == '22b34a63-8540-4566-b6da-89084b549f44' ){
					return 'QA';
				}else if(value == '252f7a6f-c187-40d3-9635-2a2d6807ea92' ){
					return '业务5部';
				}else if(value == '46f1d3a5-eca0-45f9-8079-d0e996ccb8df' ){
					return '高管部';
				}else if(value == '47147768-0ebb-49ce-96db-949db38ea686' ){
					return '裁剪车间';
				}else if(value == '49b49d0e-dbbb-4cb3-8aac-972dcb73a21e' ){
					return '样品仓库';
				}else if(value == '571efe1a-8e5d-44e7-b382-e43c0dd6bc0a' ){
					return '设计开发部';
				}else if(value == '5ea67a15-3cf0-4ce4-8041-534a32b2ed16' ){
					return '实验室';
				}else if(value == '68b41588-e1b6-4878-8b3a-0eae0e6311d4' ){
					return '信息技术部';
				}else if(value == '718ebbab-aa4d-4d63-a037-020c71240c68' ){
					return '业务1部';
				}else if(value == '8dde82b7-4f7c-4d1b-9e6a-76ba179a9f5e' ){
					return '纸型车间';
				}else if(value == '49b49d0e-dbbb-4cb3-8aac-972dcb73a21e' ){
					return '样品仓库';
				}else if(value == '8dfc2bfb-35bc-482e-ae9f-6cb710a2f601' ){
					return '业务2部';
				}else if(value == 'a7987d2a-1c2f-4c0a-93d9-27552b33efec' ){
					return '财务部';
				}else if(value == 'ab817736-8197-462e-a15b-910ec799efdb' ){
					return '行政部';
				}else if(value == 'c7a5d699-5c6b-42ff-a2de-ad11e032e849' ){
					return '单证部';
				}else if(value == 'd6b256b1-3a83-4797-bfeb-4f01f45460ab' ){
					return '技术部';
				}else if(value == 'da3ea261-f04f-4ca9-b96d-d95528d76590' ){
					return '设计技术组';
				}else if(value == 'e126cbf6-e2dd-4bea-a608-6e76133583b8' ){
					return '业务3部';
				}else if(value == 'f19e2ea3-6ea0-4122-99b4-514cf395aedb' ){
					return '样品车间';
				}
			}
		}, 
		]],
		/* queryParams: {
			userId : '${history.id}'
		}, */
		toolbar :'#datagrid_toolbar',
		onHeaderContextMenu: function(e, field) {
			e.preventDefault();
		}
	});
});
</script>
</head>
<body class="easyui-layout" data-options="fit : true,border : false">
	<div data-options="region:'center',border:false">
		<div id="mainList" ></div>
		<input type="hidden" id="hid_userIds" value="${history.userIds}"/>
		<%-- <h1>${history.userId}</h1> --%>
</body>
</html>