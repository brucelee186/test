<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr id="attach_skill1">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="其他技能1" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<input id="index_skill" name="indexSkill" value="${userDetail.indexSkill}" type="hidden" />
					<th style="width:150px;text-align: left;">获得时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="certificatedDate1" value="${userDetail.certificatedDate1}" style="width: 280px;" class="easyui-datebox" data-options="required: false, editable:false"/></td>
					<th style="width:150px;text-align: left;">技能名称：</th>
					<td style="width:300px;text-align: left;"><input name="skills1" data-options="required: false, validType:'length[2,30]'" value="${userDetail.skills1}" style="width: 280px;" class="easyui-textbox" /></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>证书附件：</th>
					<td><input id="fileName_certificatesOrLicenses1" value="${userDetail.certificatesOrLicensesFileName1}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_certificatesOrLicenses1" name="certificatesOrLicenses1" type="hidden" /><input id="file_certificatesOrLicenses1" name="listFile[8]" type="file" onchange="uploadFile('certificatesOrLicenses1', 8);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th style="width:150px;text-align: left;">是否提供证明：</th>
						<td style="width:300px;text-align: left;"><input type="radio" name="skillsProve1" <c:if test="${userDetail.skillsProve1 == null }">checked="checked"</c:if><c:if test="${userDetail.skillsProve1 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="skillsProve1" <c:if test="${userDetail.skillsProve1 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>
				</c:if>
			</table>
		</div>
	</td>
</tr>
<tr id="attach_skill2" style="<c:if test="${userDetail.indexSkill < 2 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="其他技能2" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">获得时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="certificatedDate2" value="${userDetail.certificatedDate2}" style="width: 280px;" class="easyui-datebox date_skill2" data-options=" editable:false"/></td>
					<th style="width:150px;text-align: left;">技能名称：</th>
					<td style="width:300px;text-align: left;"><input name="skills2" value="${userDetail.skills2}" style="width: 280px;" class="easyui-textbox text_skill2" /></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>证书附件：</th>
					<td><input id="fileName_certificatesOrLicenses2" value="${userDetail.certificatesOrLicensesFileName2}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_certificatesOrLicenses2" name="certificatesOrLicenses2" type="hidden" /><input id="file_certificatesOrLicenses2" name="listFile[9]" type="file" onchange="uploadFile('certificatesOrLicenses2', 9);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th style="width:150px;text-align: left;">是否提供证明：</th>
						<td style="width:300px;text-align: left;"><input type="radio" name="skillsProve2" <c:if test="${userDetail.skillsProve2 == null }">checked="checked"</c:if><c:if test="${userDetail.skillsProve2 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="skillsProve2" <c:if test="${userDetail.skillsProve2 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>
				</c:if>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('skill', 2);"><s:message code="common.button.delete" /></a></td>
				</tr>							
			</table>
		</div>
	</td>
</tr>
<tr id="attach_skill3" style="<c:if test="${userDetail.indexSkill < 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="其他技能3" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">获得时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="certificatedDate3" value="${userDetail.certificatedDate3}" style="width: 280px;" class="easyui-datebox date_skill3" data-options=" editable:false"/></td>
					<th style="width:150px;text-align: left;">技能名称：</th>
					<td style="width:300px;text-align: left;"><input name="skills3" value="${userDetail.skills3}" style="width: 280px;" class="easyui-textbox text_skill3" /></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>证书附件：</th>
					<td><input id="fileName_certificatesOrLicenses3" value="${userDetail.certificatesOrLicensesFileName3}" style="width: 280px;" class="easyui-textbox" data-options="editable:false" /></td>
					<th style="width:150px;text-align: left;">上传：</th>
					<td style="width:300px;text-align: left;"><input id="field_certificatesOrLicenses3" name="certificatesOrLicenses3" type="hidden" /><input id="file_certificatesOrLicenses3" name="listFile[10]" type="file" onchange="uploadFile('certificatesOrLicenses3', 10);"  ></input></td>
				</tr>
				<c:if test="${userDetail.statusInit == 'a'}">
					<tr style="">
						<th style="width:150px;text-align: left;">是否提供证明：</th>
						<td style="width:300px;text-align: left;"><input type="radio" name="skillsProve3" <c:if test="${userDetail.skillsProve3 == null }">checked="checked"</c:if><c:if test="${userDetail.skillsProve3 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="skillsProve3" <c:if test="${userDetail.skillsProve3 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</tr>
				</c:if>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('skill', 3);"><s:message code="common.button.delete" /></a></td>
				</tr>							
			</table>
		</div>
	</td>
</tr>
<tr id="tr_add_skill" style="<c:if test="${userDetail.indexSkill == 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<table class="mtftable">
			<tr>
				<th style="width:881px;text-align: right;"><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addAttach('skill');"><s:message code="common.button.add" /></a></th>
			</tr>
		</table>
	</td>
</tr>
