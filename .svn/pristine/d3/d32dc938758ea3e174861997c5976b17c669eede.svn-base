<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr id="attach_career1">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="工作经验1" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<input id="index_career" name="indexCareer" value="${userDetail.indexCareer}" type="hidden" />
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="careerFrom1" value="${userDetail.careerFrom1}" data-options="required: false, editable:false" style="width: 280px;" class="easyui-datebox " /></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="careerEnd1" value="${userDetail.careerEnd1}" data-options="required: false, editable:false" style="width: 280px;" class="easyui-datebox" /></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>公司名称：</th>
					<td><input name="careerCompany1" value="${userDetail.careerCompany1}" data-options="required: false, validType:'length[2,30]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>行业：</th>
					<td><input name="industry1" value="${userDetail.industry1}" data-options="required: false, validType:'length[2,30]' "style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th>岗位：</th>
					<td><input name="careerPosition1" value="${userDetail.careerPosition1}" data-options="required: false, validType:'length[2,30]'" style="width: 280px;" class="easyui-textbox" /></td>
					<c:if test="${userDetail.statusInit == 'a'}">
						<th>是否提供离职证明：</th>
						<td><input type="radio" name="careerRequired1" <c:if test="${userDetail.careerRequired1 == null }">checked="checked"</c:if><c:if test="${userDetail.careerRequired1 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="careerRequired1" <c:if test="${userDetail.careerRequired1 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</c:if>
				</tr>
			</table>
		</div>
	</td>
</tr>
<tr id="attach_career2" style="<c:if test="${userDetail.indexCareer < 2 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="工作经验2" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="careerFrom2" value="${userDetail.careerFrom2}" style="width: 280px;" class="easyui-datebox date_career2" data-options=" editable:false"/></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="careerEnd2" value="${userDetail.careerEnd2}" style="width: 280px;" class="easyui-datebox date_career2" data-options="editable:false"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>公司名称：</th>
					<td><input name="careerCompany2" value="${userDetail.careerCompany2}" style="width: 280px;" class="easyui-textbox text_career2" /></td>
					<th>行业：</th>
					<td><input name="industry2" value="${userDetail.industry2}" style="width: 280px;" class="easyui-textbox text_career2" /></td>
				</tr>
				<tr style="">
					<th>岗位：</th>
					<td><input name="careerPosition2" value="${userDetail.careerPosition2}" style="width: 280px;" class="easyui-textbox text_career2" /></td>
					<c:if test="${userDetail.statusInit == 'a'}">
						<th>是否提供离职证明：</th>
						<td><input type="radio" name="careerRequired2" <c:if test="${userDetail.careerRequired2 == null }">checked="checked"</c:if><c:if test="${userDetail.careerRequired2 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="careerRequired2" <c:if test="${userDetail.careerRequired2 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</c:if>
				</tr>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('career', 2);"><s:message code="common.button.delete" /></a></td>
				</tr>						
			</table>
		</div>
	</td>
</tr>
<tr id="attach_career3" style="<c:if test="${userDetail.indexCareer < 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="工作经验3" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">起始时间 ：</th>
					<td style="width:300px;text-align: left;"><input id="" name="careerFrom3" value="${userDetail.careerFrom3}" style="width: 280px;" class="easyui-datebox date_career3" data-options=" editable:false"/></td>
					<th style="width:150px;text-align: left;">截止时间：</th>
					<td style="width:150px;text-align: left;"><input id="" name="careerEnd3" value="${userDetail.careerEnd3}" style="width: 280px;" class="easyui-datebox date_career3" data-options="editable:false"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr style="">
					<th>公司名称：</th>
					<td><input name="careerCompany3" value="${userDetail.careerCompany3}" style="width: 280px;" class="easyui-textbox text_career3" /></td>
					<th>行业：</th>
					<td><input name="industry3" value="${userDetail.industry3}" style="width: 280px;" class="easyui-textbox text_career3" /></td>
				</tr>
				<tr style="">
					<th>岗位：</th>
					<td><input name="careerPosition3" value="${userDetail.careerPosition3}" style="width: 280px;" class="easyui-textbox text_career3" /></td>
					<c:if test="${userDetail.statusInit == 'a'}">
						<th>是否提供离职证明：</th>
						<td><input type="radio" name="careerRequired3" <c:if test="${userDetail.careerRequired3 == null }">checked="checked"</c:if><c:if test="${userDetail.careerRequired3 == 'y'}">checked="checked"</c:if> value="y" >是</input> <input type="radio" name="careerRequired3" <c:if test="${userDetail.careerRequired3 == 'n'}">checked="checked"</c:if> value="n">否</input></td>
					</c:if>
				</tr>
				<tr style="">
					<th></th>
					<td></td>
					<th></th>
					<td></td>
					<td ><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-cancel'" onclick="delAttach('career', 3);"><s:message code="common.button.delete" /></a></td>
				</tr>						
			</table>
		</div>
	</td>
</tr>
<tr id="tr_add_career" style="<c:if test="${userDetail.indexCareer == 3 }">display: none;</c:if>">
	<td style="vertical-align: top;">
			<table class="mtftable">
				<tr>
					<th style="width:881px;text-align: right;"><a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-add'" onclick="addAttach('career');"><s:message code="common.button.add" /></a></th>
				</tr>
			</table>
	</td>
</tr>	
