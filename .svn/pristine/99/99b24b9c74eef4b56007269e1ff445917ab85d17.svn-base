<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<script type="text/javascript">
</script>
<div id="dialog" class="easyui-dialog" style="width:800px;height:380px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
	<form id="form" method="post">
		<input type="hidden" name="id" />
		<table class="tableForm">
			<tr>
				<th width="150px">权限名称 : </th>
				<td><input class="easyui-textbox" type="text" style="width: 250px" name="name" data-options="required:true, validType:'length[1,20]'" data-options="validType:'length[1,20]', multiline:true" /></td>
				<th>权限编号 : </th>
				<td><input class="easyui-textbox" type="text" style="width: 250px" name="code" data-options="required:true, validType:'length[7,7]'" /></td>
			</tr>
			<tr>
				<th>层级 : </th>
				<td>
					<select id="combobox_level" class="easyui-combobox" name="level" style="width:250px" data-options="required:true, panelHeight:'auto',editable:false,
						onChange:function(level) {
							operateSelectionLevel(level);
						}">
						<option value="1" selected="selected">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
					</select>
				</td>
				<th class="parentCode" style="display: none;">父权限 : </th>
				<td class="parentCode" style="display: none;"><select id="combotree_parentCode" name="parentCode" class="easyui-combobox" style="width:250px" data-options="required:true, valueField:'first', textField:'second', panelHeight:'200', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListPermission.do'"></select></td>
				</div>
			</tr>
			<tr>
				<th>权限类型 : </th>
				<td>
					<%-- <select class="easyui-combobox" name="typePermission" style="width:250px" data-options="required:true, panelHeight:'auto',editable:false, 
						onChange: function(value) {
							if ('a' != value) {
								$('#permissionValue1').hide();
							} else {
								$('#permissionValue1').show();
							}
						}, ">
						<option value="m" selected="selected">菜单</option>
						<option value="b">按钮</option>
						<option value="l">链接</option>
						<option value="a">审批</option>
						<option value="at">考勤</option>
					</select> --%>
					
					<select id="typePermission" class="easyui-combobox" name="typePermission" style="width:250px;text-align:right;" data-options="valueField:'first',textField:'second',panelWidth:300,editable:false,required:true,url:'${pageContext.request.contextPath}/common/droplist/doListPermissionType.do',formatter: function(row){
							return '<b>' + row.second},
							onChange:function (value) {
								operateSelection(value);
							}"
							>
					</select>
				</td>
				<th>权限数据类型 : </th>
				<td>
					<select class="easyui-combobox" name="typeData" style="width:250px" data-options="required:true, panelHeight:'auto',editable:false">
						<option value="c" selected="selected">Chekcbox</option>
						<option value="t">Text</option>
					</select>
				</td>
			</tr>
			<tr id="permissionValue1" style="display: none;">
				<th id="tdPermissionValue1">权限值1 : </th>
				<td><select id="permissionSelectValue1" name="value1" class="easyui-combobox" style="width:250px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/division/doListPair.do'"></select></td>
			</tr>
			<tr id="permissionValue2" style="display: none;">
				<th id="tdPermissionValue2">权限值2 : </th>
				<td><select id="permissionSelectValue2" name="value2" class="easyui-combobox" style="width:250px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListAttenRule.do'"></select></td>
			</tr>
			<tr>
				<th>备注 : </th>
				<td><textarea name="remark" data-options="validType:'length[1,255]', multiline:true" class="easyui-textbox" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
			</tr>
		</table>
	</form>
</div>

<div id="dialog_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="$('#form').submit();"><s:message code="common.button.submit" /></a>
</div>
<div data-options="region:'center',border:false">
	<table id="datagrid"></table>
</div>