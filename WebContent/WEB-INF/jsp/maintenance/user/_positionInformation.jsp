<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr>
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="员工信息" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">员工编号：</th>
					<td style="width:300px;text-align: left;"><input name="staffCode" value="${userDetail.staffCode}" style="width: 280px;" class="easyui-textbox" data-options="required: true, validType:'length[4,20]'" /></td>
					<th style="width:150px;text-align: left;">所属部门：</th>
					<td style="width:300px;text-align: left;"><input id="combotree_division" name="departmentId" class="easyui-combobox" style="width:280px" data-options="required: true,value:'${userDetail.departmentId}', valueField:'code', textField:'name',  panelHeight:'auto', editable:false, disabled:true"></input></td>
<%-- 					<td style="width:300px;text-align: left;"><select id="combotree_division" name="departmentId" class="easyui-combobox" style="width:280px" data-options="required: true,value:'${userDetail.departmentId}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/division/doListPair.do'"></select></td> --%>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr>
					<th>员工工号：</th>
					<td><input name="badgenumber" value="${userDetail.badgenumber}" data-options="required: true, validType:'length[1,12]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>硬件卡号：</th>
					<td><input name="cardNo" value="${userDetail.cardNo}" data-options="required: true, validType:'length[1,12]'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr style="">
					<th>岗位名称：</th>
					<td><select name="positionId" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.positionId}', valueField:'first', textField:'second', panelHeight:'200', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=zwmc'"></select></td>
					<th>岗位等级：</th>
					<td><select name="rank" class="easyui-combobox" style="width:280px;" data-options="value:'${userDetail.rank}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=gwdj'"></select></td>
				</tr>
				<tr>
					<th>直属领导：</th>
					<td><select name="immediateSuperiorId" class="easyui-combobox" style="width:280px;" data-options="required: false, value:'${userDetail.immediateSuperiorId}', valueField:'id', textField:'displayName', panelHeight:'200', editable:true, disabled:true, url:'${pageContext.request.contextPath}/common/droplist/doListUser.do'"></select></td>
					<th>办公邮件：</th>
					<td><input name="email" value="${userDetail.email}" data-options="required: true, validType: 'email'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<th>雇主：</th>
					<td><select name="employer" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.employer}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=gz'"></select></td>
					<th>客户：</th>
					<td><input name="workGroupDetailName" value="${userDetail.workGroupDetailName}" style="width: 280px;" class="easyui-textbox" data-options="required: false, validType:'length[1,30]'" /></td>
				</tr>
				<tr>
					<th>显示姓名：</th>
					<td><input name="displayName" value="${userDetail.displayName}" style="width: 280px;" class="easyui-textbox" data-options="required: true, validType:'length[1,30]'" /></td>
					<th>系统语言：</th>
					<td><select id='language' name="language" class="easyui-combobox" style="width:280px;" data-options="required: true, value:'${userDetail.language}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=xtyy',
					    onLoadSuccess: function (data) {
            				var language = '${userDetail.language}';
            				if(null == language || language == ''){
            					$('#language').combobox('setValue','zh');
            				}
       					 },
					"></select></td>
				</tr>
				<tr>
					<th>办公电话：</th>
					<td><input name="officialTelNo" value="${userDetail.officialTelNo}" data-options="validType:'phone'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>内部电话：</th>
					<td><input name="VNetNo" value="${userDetail.VNetNo}" data-options="validType:'phoneInterior'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
			
				<tr style="">
					<th>入职日期：</th>
					<td><input id="entryDate" name="entryDate" value="${userDetail.entryDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th>离职时间：</th>
					<td><input id="departedDate" name="departedDate" value="${userDetail.departedDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
				</tr>
				<tr style="">
					<th>转正日期：</th>
					<td><input id="positiveDate" name="positiveDate" value="${userDetail.positiveDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
					<th>加班费：</th>
					<td style="width:300px;text-align: left;"><input type="radio" name="extraWorkPay" <c:if test="${userDetail.extraWorkPay == 'y'}">checked="checked"</c:if> value="y" >有</input> <input type="radio" name="extraWorkPay" <c:if test="${userDetail.extraWorkPay != 'y'}">checked="checked"</c:if> value="n">无</input></td>
				</tr>
				<tr style="">
					<th>司龄：</th>
					<td><input name="seniority" value="${userDetail.seniorityShow}" data-options="editable:false" style="width: 280px;" class="easyui-textbox" /></td>
					<th>缴费单位：</th>
					<td><select name="contractor" class="easyui-combobox" style="width:280px;" data-options="value:'${userDetail.contractor}', valueField:'first', textField:'second', panelHeight:'auto', editable:false, url:'${pageContext.request.contextPath}/common/common/listUserInfo.do?type=jfdw'"></select></td>
				</tr>
				<tr>
					<th>合同编号：</th>
					<td><input name="contractNo" value="${userDetail.contractNo}" data-options="required: false, validType:'length[1,40]'" style="width: 280px;" class="easyui-textbox" /></td>
					<th>合同期限：</th>
					<td><input name="contractPeriod" value="${userDetail.contractPeriod}" data-options="required: false, validType:'length[1,2]'" style="width: 280px;" class="easyui-textbox" /></td>
				</tr>
				<tr>
					<th>开始时间：</th>
					<td><input id="contractCommenceDate" name="contractCommenceDate" value="${userDetail.contractCommenceDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>				
					<th>结束时间：</th>
					<td><input id="contracTerminationDate" name="contracTerminationDate" value="${userDetail.contracTerminationDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
				</tr>
				<tr>
					<th>续签次数：</th>
					<td><input name="turns" value="${userDetail.turns}" data-options="validType:'length[1,2]'" style="width: 280px;" class="easyui-numberbox" data-options="" /></td>
				</tr>
				<tr>
					<th>社会保险：</th>
					<td style="width:300px;text-align: left;"><input type="radio" name="socialSecurityPermission" <c:if test="${userDetail.socialSecurityPermission == 'y'}">checked="checked"</c:if> value="y" >有</input> <input type="radio" name="socialSecurityPermission" <c:if test="${userDetail.socialSecurityPermission != 'y'}">checked="checked"</c:if> value="n">无</input></td>
					<th>保险编号：</th>
					<td><input name="socialSecurityNo" value="${userDetail.socialSecurityNo}" style="width: 280px;" class="easyui-textbox" data-options="validType:'length[1,20]'" /></td>					
				</tr>
				<tr>
					<th>开始时间：</th>
					<td><input id="socialSecurityCommenceDate" name="socialSecurityCommenceDate" value="${userDetail.socialSecurityCommenceDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>				
					<th>结束时间：</th>
					<td><input id="socialSecurityTerminationDate" name="socialSecurityTerminationDate" value="${userDetail.socialSecurityTerminationDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
				</tr>
				<tr>
					<th>保险基数：</th>
					<td><input id="socialSecurityRange" name="socialSecurityRange" value="${userDetail.socialSecurityRange}" class="easyui-numberbox" data-options="min:0, validType:'length[1,4]'" style="width: 280px;" /></td>
				</tr>				
				<tr>
					<th>公积金：</th>
					<td style="width:300px;text-align: left;"><input type="radio" name="houseFundingPermission" <c:if test="${userDetail.houseFundingPermission == 'y'}">checked="checked"</c:if> value="y" >有</input> <input type="radio" name="houseFundingPermission" <c:if test="${userDetail.houseFundingPermission != 'y'}">checked="checked"</c:if> value="n">无</input></td>					
					<th>公积金编号：</th>
					<td><input name="houseFundingNo" value="${userDetail.houseFundingNo}" style="width: 280px;" class="easyui-textbox" data-options="validType:'length[1,20]'" /></td>					
				</tr>
				<tr>
					<th>公积金基数：</th>
					<td><input name="houseFundinRange" value="${userDetail.houseFundinRange}" class="easyui-numberbox" data-options="min:0, validType:'length[1,4]'" style="width: 280px;" /></td>
				</tr>				
				<tr>
					<th>开始时间：</th>
					<td><input id="houseFundingCommenceDate" name="houseFundingCommenceDate" value="${userDetail.houseFundingCommenceDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>				
					<th>结束时间：</th>
					<td><input id="houseFundingTerminationDate" name="houseFundingTerminationDate" value="${userDetail.houseFundingTerminationDate}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
				</tr>
				<tr>
					<th>税前工资：</th>
					<td><input id="emolumentPreTax" name="emolumentPreTax" value="${userDetail.emolumentPreTax}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
					<th>扣款：</th>
					<td><input id="withholding" name="withholding" value="${userDetail.withholding}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<th>税后工资：</th>
					<td><input id="emolumentAfterTax" name="emolumentAfterTax" value="${userDetail.emolumentAfterTax}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<th>车牌号：</th>
					<td><input name="vehiclePlateNo" value="${userDetail.vehiclePlateNo}" style="width: 280px;" class="easyui-textbox" data-options="validType:'length[1,20]'" /></td>				
					<th>采暖：</th>
					<td style="width:300px;text-align: left;"><input type="radio" name="heating" <c:if test="${userDetail.heating == 'y'}">checked="checked"</c:if> value="y" >有</input> <input type="radio" name="heating" <c:if test="${userDetail.heating != 'y'}">checked="checked"</c:if> value="n">无</input></td>
				</tr>
			</table>
		</div>
	</td>
</tr>
