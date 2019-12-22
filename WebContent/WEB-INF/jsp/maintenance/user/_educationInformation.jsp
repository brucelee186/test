<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr id="attach_education1">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="教育情况1" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<input id="index_education" name="indexEducation" value="${userDetail.indexEducation}" type="hidden" />
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="beginEducationalPeriod1" value="${userDetail.beginEducationalPeriod1}" data-options=" editable:false" style="width: 280px;" class="easyui-datebox" /></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="endEducationalPeriod1" value="${userDetail.endEducationalPeriod1}" data-options=" editable:false" style="width: 280px;" class="easyui-datebox"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>学校名称：</th>
					<td><input name="schoolName1" value="${userDetail.schoolName1}" data-options=" validType:'length[4, 20]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>专业：</th>
					<td><select name="major1" class="easyui-combobox" style="width:280px;" data-options=" value:'${userDetail.major1}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=z'"></select></td>
				</tr>
				<tr style="">
					<th>学历：</th>
					<td><select name="educationalDegree1" class="easyui-combobox" style="width:280px;" data-options=" value:'${userDetail.educationalDegree1}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=xl'"></select></td>
					<th>教育形式：</th>
					<td><select name="educationalStatus1" class="easyui-combobox" style="width:280px;" data-options=" value:'${userDetail.educationalStatus1}', valueField:'first', textField:'second', panelHeight:'auto', required: true,editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jyxs'"></select></td>
				</tr>
				<tr style="">
					<th>英语能力：</th>
					<td><select name="englishProficiency" class="easyui-combobox" style="width:280px;" data-options=" value:'${userDetail.englishProficiency}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=e'"></select></td>
				</tr>
				<tr style="">
					<th>学历附件：</th>
					<td><input id="fileName_attachEducationalDegree1" value="${userDetail.attachEducationalDegreeFileName1}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachEducationalDegree1" name="attachEducationalDegree1" type="hidden" /><input id="file_attachEducationalDegree1" name="listFile[2]" type="file" onchange="uploadFile('attachEducationalDegree1', 2);"  ></input></td>
				</tr>
				<tr style="">
					<th>学位附件：</th>
					<td><input id="fileName_attachDegree1" value="${userDetail.attachDegreeFileName1}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachDegree1" name="attachDegree1" type="hidden" /><input id="file_attachDegree1" name="listFile[3]" type="file" onchange="uploadFile('attachDegree1', 3);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th>提供学历证明：</th>
						<td><input type="radio" name="proveEducationalDegree1" <c:if test="${userDetail.proveEducationalDegree1 == null }">checked="checked"</c:if><c:if test="${userDetail.proveEducationalDegree1 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveEducationalDegree1" <c:if test="${userDetail.proveEducationalDegree1 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
						<th>提供学位证明：</th>
						<td><input type="radio" name="proveDegree1" <c:if test="${userDetail.proveDegree1 == null }">checked="checked"</c:if><c:if test="${userDetail.proveDegree1 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveDegree1" <c:if test="${userDetail.proveDegree1 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>					
				</c:if>
			</table>
		</div>
	</td>
</tr>

<tr id="attach_education2" style="<c:if test="${userDetail.indexEducation < 2 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="教育情况2" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
						<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="beginEducationalPeriod2" value="${userDetail.beginEducationalPeriod2}" style="width: 280px;" class="easyui-datebox date_education2" data-options="editable:false"/></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="endEducationalPeriod2" value="${userDetail.endEducationalPeriod2}" style="width: 280px;" class="easyui-datebox date_education2" data-options="editable:false"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>学校名称：</th>
					<td><input name="schoolName2" value="${userDetail.schoolName2}" style="width: 280px;" class="easyui-textbox text_education2" /></td>
					<th>专业：</th>
					<td><select name="major2" class="easyui-combobox combo_education2" style="width:280px;" data-options="value:'${userDetail.major2}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=z'"></select></td>
				</tr>
				<tr style="">
					<th>学历：</th>
					<td><select name="educationalDegree2" class="easyui-combobox combo_education2" style="width:280px;" data-options="value:'${userDetail.educationalDegree2}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=xl'"></select></td>
					<th>教育形式：</th>
					<td><select name="educationalStatus2" class="easyui-combobox combo_education2" style="width:280px;" data-options="value:'${userDetail.educationalStatus2}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jyxs'"></select></td>
				</tr>
				<tr style="">
					<th>学历附件：</th>
					<td><input id="fileName_attachEducationalDegree2" value="${userDetail.attachEducationalDegreeFileName2}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachEducationalDegree2" name="attachEducationalDegree2" type="hidden" /><input id="file_attachEducationalDegree2" name="listFile[4]" type="file" onchange="uploadFile('attachEducationalDegree2', 4);"  ></input></td>
				</tr>
				<tr style="">
					<th>学位附件：</th>
					<td><input id="fileName_attachDegree2" value="${userDetail.attachDegreeFileName2}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachDegree2" name="attachDegree2" type="hidden" /><input id="file_attachDegree2" name="listFile[5]" type="file" onchange="uploadFile('attachDegree2', 5);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th>提供学历证明：</th>
						<td><input type="radio" name="proveEducationalDegree2" <c:if test="${userDetail.proveEducationalDegree2 == null }">checked="checked"</c:if><c:if test="${userDetail.proveEducationalDegree2 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveEducationalDegree2" <c:if test="${userDetail.proveEducationalDegree2 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
						<th>提供学位证明：</th>
						<td><input type="radio" name="proveDegree2" <c:if test="${userDetail.proveDegree2 == null }">checked="checked"</c:if><c:if test="${userDetail.proveDegree2 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveDegree2" <c:if test="${userDetail.proveDegree2 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>
				</c:if>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('education', 2);"><s:message code="common.button.delete" /></a></td>
				</tr>												
			</table>
		</div>
	</td>
</tr>
<tr id="attach_education3" style="<c:if test="${userDetail.indexEducation < 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="教育情况3" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="beginEducationalPeriod3" value="${userDetail.beginEducationalPeriod3}" style="width: 280px;" class="easyui-datebox date_education3" data-options="editable:false"/></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="endEducationalPeriod3" value="${userDetail.endEducationalPeriod3}" style="width: 280px;" class="easyui-datebox date_education3" data-options="editable:false"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>学校名称：</th>
					<td><input name="schoolName3" value="${userDetail.schoolName3}" style="width: 280px;" class="easyui-textbox text_education3" /></td>
					<th>专业：</th>
					<td><select name="major3" class="easyui-combobox combo_education3" style="width:280px;" data-options="value:'${userDetail.major3}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=z'"></select></td>
				</tr>
				<tr style="">
					<th>学历：</th>
					<td><select name="educationalDegree3" class="easyui-combobox combo_education3" style="width:280px;" data-options="value:'${userDetail.educationalDegree3}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=xl'"></select></td>
					<th>教育形式：</th>
					<td><select name="educationalStatus3" class="easyui-combobox combo_education3" style="width:280px;" data-options="value:'${userDetail.educationalStatus3}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jyxs'"></select></td>
				</tr>
				<tr style="">
					<th>学历附件：</th>
					<td><input id="fileName_attachEducationalDegree3" value="${userDetail.attachEducationalDegreeFileName3}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachEducationalDegree3" name="attachEducationalDegree3" type="hidden" /><input id="file_attachEducationalDegree3" name="listFile[6]" type="file" onchange="uploadFile('attachEducationalDegree3', 6);"  ></input></td>
				</tr>
				<tr style="">
					<th>学位附件：</th>
					<td><input id="fileName_attachDegree3" value="${userDetail.attachDegreeFileName3}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_attachDegree3" name="attachDegree3" type="hidden" /><input id="file_attachDegree3" name="listFile[7]" type="file" onchange="uploadFile('attachDegree3', 7);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th>提供学历证明：</th>
						<td><input type="radio" name="proveEducationalDegree3" <c:if test="${userDetail.proveEducationalDegree3 == null }">checked="checked"</c:if><c:if test="${userDetail.proveEducationalDegree3 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveEducationalDegree3" <c:if test="${userDetail.proveEducationalDegree3 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
						<th>提供学位证明：</th>
						<td><input type="radio" name="proveDegree3" <c:if test="${userDetail.proveDegree3 == null }">checked="checked"</c:if><c:if test="${userDetail.proveDegree3 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="proveDegree3" <c:if test="${userDetail.proveDegree3 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>				
				</c:if>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('education', 3);"><s:message code="common.button.delete" /></a></td>
				</tr>												
			</table>
		</div>
	</td>
</tr>
<tr id="tr_add_education" style="<c:if test="${userDetail.indexEducation == 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
			<table class="mtftable">
				<tr>
					<th style="width:881px;text-align: right;"><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addAttach('education');"><s:message code="common.button.add" /></a></th>
				</tr>
			</table>
	</td>
</tr>
