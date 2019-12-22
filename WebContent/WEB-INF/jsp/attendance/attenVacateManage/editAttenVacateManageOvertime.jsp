<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
</script>
<div id="dialog" class="easyui-dialog" style="width:500px;height:500px;" data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
	<form id="form" method="post">
		<input id="id" type="hidden" name="id" />
		<input id="editState" type="hidden" name="editState" />
		<input id="typeData" type="hidden" name="typeData" value="v" />
		<input id="dayVacateAhead" type="hidden" name="dayVacateAhead"/>
		<input id="code" type="hidden" name="code"/>
		<input id="nameVacate" type="hidden" name="nameVacate"/>
		<input id="nameVacateDetail" type="hidden" name="nameVacateDetail"/>
		<input id="tagPageCode" type="hidden" name="tagPageCode" value="${tagPageCode}"/>
		<input id="tagStatus" type="hidden" name="tagStatus" value="n"/>
		<input id="divisionName" type="hidden" name="divisionName" value="${attenVacateManage.divisionName}" />
		<input id="workOvertimeBeforeRule" type="hidden" name="workOvertimeBeforeRule"/>
		<input id="workOvertimeAfterRule" type="hidden" name="workOvertimeAfterRule"/>
		<input id="workOvertimeRule" type="hidden" name="workOvertimeRule"/>
		<input id="dateWeek" type="hidden" name="dateWeek"/>
		<table class="tableForm">
			<tr style="display: none;">
				<th width="150px">加班类别 : </th>
				<td><select id="idVacate" name="idVacate" class="easyui-combobox" style="width:250px" data-options="required: 'true', valueField:'id', textField:'name', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListAttenVacateDetail.do?tagType=m',
				onLoadSuccess:function(){
					var data = $('#idVacate').combobox('getData');
 					$('#idVacate').combobox('select',data[0].id);
				},
				onChange:function(val) {
					changeSelectVacate(val);
				}"></select></td>
			</tr>
			<tr style="display: none;">
				<th width="150px">子类别 : </th>
				<td><select id="idVacateDetail" name="idVacateDetail" class="easyui-combobox" style="width:250px" data-options="required: 'true', valueField:'id', textField:'nameDetail', panelHeight:'auto', editable:false,
				onChange:function(val) {
					changeSelectVacateDetail(val);
				}"></select></td>
			</tr>
			<tr style="display: none;">
				<th width="150px">加班方式 : </th>
				<td>
					<select id="typeVacateDate" name="typeVacateDate" class="easyui-combobox" style="width:250px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false,url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=qjfs',
					onChange:function(value){
						//changeTypeVacateDate(value);
					}">
					</select>
				</td>
			</tr>
			<c:if test="${tagPageCode == '16200100' || tagPageCode == '16200400'}">
			<tr>
				<th width="150px">申请部门 : </th>
				<td>
						<c:if test="${tagPageCode == '16200100'}">
						<select id="divisionId" name="divisionId" class="easyui-combobox" style="width:250px;" data-options="required:false, value:'', valueField:'divisionId', textField:'divisionName', panelHeight:'200', editable:false,
							url:'${pageContext.request.contextPath}/common/droplist/doListDivisionByManager.do?tag=d',
							onChange:function(value){
								changeDivision(value);
						}">
						</select>
						</c:if>
						<c:if test="${tagPageCode == '16200400'}">
						<select id="divisionId" name="divisionId" class="easyui-combobox" style="width:250px;" data-options="required:false, value:'', valueField:'id', textField:'name', panelHeight:'200', editable:false,
							url:'${pageContext.request.contextPath}/common/droplist/doListDivisionAll.do?tag=d&level=3',
							onChange:function(value){
								changeDivision(value);
						}">
						</select>
						</c:if>
				</td>
			</tr>
			<tr>
				<th width="150px">申请员工 : </th>
				<td>
				<input type="checkbox" id="selectAllUser" onclick="selAllUser();"  >全选</input>
				</td>
			</tr>			
			<tr>
				<th width="150px"></th>
				<td id="tdUserList">
					
				</td>
			</tr>	
			</c:if>
			<c:if test="${tagPageCode == '16200200'}">
			<tr>
				<th width="150px">申请部门 : </th>
				<td>
						${attenVacateManage.divisionName}
						<input type="hidden"  id="divisionId" name="divisionId" value="${attenVacateManage.divisionId}"/>
				</td>
			</tr>			
			<tr>
				<th width="150px">申请员工 : </th>
				<td>
						${attenVacateManage.userName}
						<input type="hidden"  id="userId" name="userId" value="${attenVacateManage.userId}"/>					
						<input type="hidden"  id="userName" name="userName" value="${attenVacateManage.userName}"/>					
						<input type="hidden"  id="userIdList" name="userIdList" value="${attenVacateManage.userIdList}"/>	
						<input type="hidden"  id="userNameList" name="userNameList" value="${attenVacateManage.userNameList}"/>	
				</td>
			</tr>			
			</c:if>
			<tr>
				<th>开始时间 : </th>
				<td>
					<input id="dateStart" class="easyui-datebox" name="dateStart" style="width:100px" data-options="required:true, panelHeight:'auto',editable:false,
					onChange:function(val){
						changeDateStart(val);
					}"></input>
					<select id="hourStart" name="hourStart" disabled="disabled" class="easyui-combobox" style="width:50px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListHour.do',
					onLoadSuccess:function(){
						//$('#hourStart').combobox('setValue','00');
					},
					onChange:function(){
						calculateDuration();
					}"></select>
					时
					<select id="minuteStart" name="minuteStart" disabled="disabled" class="easyui-combobox" style="width:50px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListMinute.do?type=ha',
					onLoadSuccess:function(){
						//$('#minuteStart').combobox('setValue','00');
					},
					onChange:function(){
						calculateDuration();
					}"></select>
					分
				</td>
			</tr>
			<tr>
				<th>结束时间 : </th>
				<td>
					<input id="dateEnd" class="easyui-datebox" name="dateEnd" style="width:100px" data-options="required:true, panelHeight:'auto',editable:false,
					onChange:function(){
						calculateDuration();
					}"></input>
					<select id="hourEnd" name="hourEnd" disabled="disabled" class="easyui-combobox" style="width:50px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListHour.do',
					onLoadSuccess:function(){
						//$('#hourEnd').combobox('setValue','00');
					},
					onChange:function(){
						calculateDuration();
					}
					"></select>
					时
					<select id="minuteEnd" name="minuteEnd" disabled="disabled" class="easyui-combobox" style="width:50px" data-options="valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/droplist/doListMinute.do?type=ha',
					onLoadSuccess:function(){
						//$('#minuteEnd').combobox('setValue','00');
					},
					onChange:function(){
						calculateDuration();
					}"></select>
					分
				</td>
			</tr>
			<tr>
				<th>工作时段 : </th>
				<input id="rangeArea" name="rangeArea" type="hidden" />
				<td id="td_rangeArea"></td>
			</tr>
			<tr>
				<th>合计时长 : </th>
				<td><input id="duration" name="duration" type="text" class="easyui-numberbox" style="width: 50px;" data-options="validType:'length[1,6]', precision : '2'" /><a id="div_typeVacateDate"></a></td>
			</tr>
			<tr>
			<c:if test="${tagPageCode == '16200100' || tagPageCode == '16200200'}">
				<th width="150px">加班原因 : </th>
				<td>
					<select id="remarkCode" name="remarkCode" class="easyui-combobox" style="width: 250px;" data-options=" value:'${userDetail.educationalStatus1}', valueField:'first', textField:'second', panelHeight:'auto', required: true,editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jbyy',"></select>
					<input id="remarkText" name="remarkText" type="hidden" />
				</td>
			</c:if>
			<c:if test="${tagPageCode == '16200400'}">
			<th width="150px">修正原因 : </th>
				<td>
					<select id="remarkCode" name="remarkCode" class="easyui-combobox" style="width: 250px;" data-options=" value:'${userDetail.educationalStatus1}', valueField:'first', textField:'second', panelHeight:'auto', required: true,editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=xzyy',"></select>
					<input id="remarkText" name="remarkText" type="hidden" />
				</td>			
			</c:if>
			</tr>			
			<tr id="tr_durationRemain" style="display: none;">
				<th>可用时长 : </th>
				<td><input id="durationRemain" name="durationRemain" type="text" class="easyui-numberbox" style="width: 50px;" data-options="editable:false, validType:'length[1,5]', precision : '2'" /><a id="div_typeVacateDate"></a></td>
			</tr>
			<tr>
				<th>备注 : </th>
				<td><textarea id="remark" name="remark" data-options="validType:'length[1,255]', multiline:true" class="easyui-textbox" class="easyui-validatebox" style="width: 250px;height:60px;"></textarea></td>
			</tr>
		</table>
	</form>
</div>

<div id="dialog_buttons">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm();"><s:message code="common.button.submit" /></a>
</div>
<div data-options="region:'center',border:false">
	<table id="datagrid"></table>
</div>