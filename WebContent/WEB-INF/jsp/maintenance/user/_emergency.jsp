<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr>
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="紧急联络人1" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<input id="index_emergency" name="indexEmergency" value="${userDetail.indexEmergency}" type="hidden" />
					<th style="width:150px;text-align: left;">联络人名字：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyName1" value="${userDetail.emergencyName1}" data-options="required: true, validType:'length[2,10]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th style="width:150px;text-align: left;"></th>
					<td style="width:300px;text-align: left;"></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">关系：</th>
					<td><select name="emergencyRelationship1" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.emergencyRelationship1}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jjlrr'"></select></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">联系电话：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyPhoneNo1" value="${userDetail.emergencyPhoneNo1}" data-options="required: true, validType:'phone'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
			</table>
		</div>
	</td>
</tr>
<tr id="attach_emergency2" style="<c:if test="${userDetail.indexEmergency < 2 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="紧急联络人2" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">联络人名字：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyName2" value="${userDetail.emergencyName2}" style="width: 280px;" class="easyui-textbox text_emergency2" /></td>
					<th style="width:150px;text-align: left;"></th>
					<td style="width:300px;text-align: left;"></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">关系：</th>
					<td><select name="emergencyRelationship2" class="easyui-combobox text_emergency2" style="width:280px;" data-options="value:'${userDetail.emergencyRelationship2}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jjlrr'"></select></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">联系电话：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyPhoneNo2" value="${userDetail.emergencyPhoneNo2}" style="width: 280px;" class="easyui-textbox text_emergency2" /></td>
				</tr>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('emergency', 2);"><s:message code="common.button.delete" /></a></td>
				</tr>						
			</table>
		</div>
	</td>
</tr>
<tr id="attach_emergency3" style="<c:if test="${userDetail.indexEmergency < 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="紧急联络人3" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">联络人名字：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyName3" value="${userDetail.emergencyName3}" style="width: 280px;" class="easyui-textbox text_emergency3" /></td>
					<th style="width:150px;text-align: left;"></th>
					<td style="width:300px;text-align: left;"></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">关系：</th>
					<td><select name="emergencyRelationship3" class="easyui-combobox text_emergency3" style="width:280px;" data-options="value:'${userDetail.emergencyRelationship3}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jjlrr'"></select></td>
				</tr>
				<tr style="">
					<th style="width:150px;text-align: left;">联系电话：</th>
					<td style="width:300px;text-align: left;"><input name="emergencyPhoneNo3" value="${userDetail.emergencyPhoneNo3}" style="width: 280px;" class="easyui-textbox text_emergency3" /></td>
				</tr>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('emergency', 3);"><s:message code="common.button.delete" /></a></td>
				</tr>
			</table>
		</div>
	</td>
</tr>
<tr id="tr_add_emergency" style="<c:if test="${userDetail.indexEmergency == 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<table class="mtftable">
			<tr>
				<th style="width:881px;text-align: right;"><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addAttach('emergency');"><s:message code="common.button.add" /></a></th>
			</tr>
		</table>
	</td>
</tr>