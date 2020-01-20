<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="dialog" class="easyui-dialog" style="width:1000px;height:622px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
	<form id="form" method="post">
		<input type="hidden" name="id" id="id" />
		<input type="hidden" name="editState" id="editState" />
		<input type="hidden" name="statusOrder" id="statusOrder" />
		<input type="hidden" name="tagModule" id="tagModule" value="${orderService.tagModule}" />
		<input type="hidden" name="jsonListString" id="jsonListString" />
		<table class="tableForm">
			<c:if test="${orderService.tagModule == 'a'}">
				<tr>
					<th width="200px">使用车辆牌照Vehicle Plate No. : </th>
					<td><input id="vehiclePlateNo" class="easyui-textbox" type="text" style="width: 250px" name="vehiclePlateNo" data-options="required:true, validType:'length[1,20]'" /></td>
					<th>司机姓名Driver : </th>
					<td><select id="driverId" name="driverId" class="easyui-combobox" style="width:250px;" data-options="required:true, value:'', valueField:'userId', textField:'displayName', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListPermissionUser.do?code=1701003'"></select></td>
				</tr>
			</c:if>
			<tr>
				<th width="200px">用车部门Dept.of Requester : </th>
				<td><select id="deptRequester" name="deptRequester" class="easyui-combobox" style="width:250px;" data-options="required:true, value:'', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListDivision.do'"></select></td>
				<th width="200px">出行时间Date of Trip : </th>
				<td><input id="timeTrip" name="timeTrip" class="easyui-datetimebox" type="text" style="width: 250px" data-options="required:true, editable: false, showSeconds:false, validType:'length[1,20]',
				onChange:function(time){
					changeTimeTrip(time);
				}" /></td>
			</tr>
			<tr>
				<th>费用Expense: </th>
				<td><input id="expenseActual" class="easyui-textbox" type="text" style="width: 250px" name="expenseActual" data-options="required:false, validType:'length[1,10]'" /></td>
				<th>随行人Passenger : </th>
				<td><input id="passenger" class="easyui-textbox" type="text" style="width: 250px" name="passenger" data-options="required:false, validType:'length[1,30]'" /></td>
			</tr>
			<tr>
				<th width="200px">客户Customer: </th>
				<td><select id="customer" name="customer" class="easyui-combobox" style="width:250px;" data-options="required:true, value:'', valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListCustomer.do?tag=c'"></select></td>
				<th width="200px">类别Type: </th>
				<td><select id="type" name="type" class="easyui-combobox" style="width:250px;" data-options="required:true, value:'', valueField:'code', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=yclx'"></select></td>
			</tr>
			<tr>
				<th width="200px">出行类别Type of Trip : </th>
				<td><select id="typeExpense" name="typeExpense" class="easyui-combobox" style="width:250px;" data-options="required:true, value:'', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jflb',
				onChange:function(val){
					changeTypeExpense(val)
				},
				onLoadSuccess:function(val){
					changeTypeExpense(val)
				},
				
				"></select></td>
				<th class="type_jflb1">路线Path : </th>
				<td class="type_jflb1"><select id="idOrderServicePath" name="idOrderServicePath" class="easyui-combobox" style="width:250px;" data-options="required:true, valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListOrderServicePath.do',
				onSelect:function(rec){
					changeOrderServicePath(rec)
				},"></select></td>
			</tr>
			<!-- <tr class="type_jflb1">
				<th>始发地Depart From : </th>
				<td><input id="origin" class="easyui-textbox"style="width: 250px" name="origin" data-options="required:false, validType:'length[1,10]'" /></td>
				<th>目的地Destination : </th>
				<td><input id="destination" class="easyui-textbox" style="width: 250px" name="destination" data-options="required:false, validType:'length[1,10]'" /></td>
			</tr> -->
		</table>
		<div style="height:350px;">
			<table id="datagridDetailEdit"></table>
		</div>
	</form>
</div>

<div id="dialog_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'ext-icon-pencil'" onclick="submitFormMain('d');">保存草稿</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitFormMain('s');">保存提交</a>
</div>
