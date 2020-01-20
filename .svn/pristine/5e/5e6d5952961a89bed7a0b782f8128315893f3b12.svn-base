<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="dlg_categoryService" class="easyui-dialog" 
<c:if test="${orderCategoryService.tagPageCode != '1809500'}">  
	style="width:1200px;height:334px;" 
</c:if>
<c:if test="${orderCategoryService.tagPageCode == '1809500'}">  
	style="width:1600px;height:300px;" 
</c:if>
	data-options="resizable:true,modal:true,closed: true, buttons: '#dialog_buttons'">
	<form id="frm_categoryService" method="post">
			<input id="hid_categoryServiceId" name="categoryServiceId" type="hidden"/>
			<input id="hid_editStatus" name="editStatus" type="hidden"/>
			<input id="status_edit" name="status" type="hidden"/>
			<input id="payeeName" name="payeeName" type="hidden"/>
			<input id="payeeId" name="payeeId" type="hidden"/>
			<input id="payeeType" name="payeeType" type="hidden"/>
			<input id="idOrderCategoryService" name="id" type="hidden"/>
			<input id="bankName" name="bankName" type="hidden"/>
			<input id="bankCard" name="bankCard" type="hidden"/>
			<input type="hidden" name="jsonListString" id="jsonListString" />
			<input type="hidden" id="typeData" name="typeData" value="${orderCategoryService.typeData}"/>
		<%-- 	<c:if test="${orderCategoryService.tagPageCode != '1809500'}">   --%>
			<table class="mtftable" align="center">
				<tbody>
					<tr>
					<th align="right" style="width: 80px;">申请报销部门</th>
					<td>:</td>
					<td>
						<select id="cbx_applicantDivisionId" name="applicantDivisionId" class="easyui-combobox" style="width:150px;" 
							data-options="required:true, panelHeight:'auto',panelMaxHeight:'200', editable:false, valueField : 'id', textField : 'name' , url:'${pageContext.request.contextPath}/common/droplist/doListDivisionByUser.do?tagPageCode=1809500',
							onChange:function(rec){
								//alert($(this).combobox('getText'));
							}"  
							<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
							></select>
					</td>
					<th align="right" style="width: 80px;">总金额</th>
					<td>:</td>
					<td align="center" valign="middle"><div><input id="totalAmount" name="totalAmount" type="text" class="easyui-numberbox" readonly="readonly" style="width:150px" data-options=" precision:2, validType:'digitalCompare[0, 300000]', required:false" 
						<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
					/></div></td>					
					<th align="right" style="width: 80px;">收款人</th>
					<td>:</td>
					<%-- <td><input id="txt_payeeName" class="easyui-combobox" style="width:150px" data-options="required:true, value : '${payeeName}', panelHeight:'auto',panelMaxHeight:'200',editable:true, required:true, valueField:'content', textField:'content',url:'${pageContext.request.contextPath}/common/droplist/doListPayeeName.do'"/></td> --%>
					<td><input id="txt_payeeName" class="easyui-combobox" style="width:150px" 
						<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
					/></td>
					<c:if test="${orderCategoryService.tagPageCode != '1809500'}">
					<td>
						<a href="javascript:void(0)" id="addSuppliers"  class="easyui-linkbutton" iconCls="ext-icon-plus1"></a>
						<a href="javascript:void(0)" id="searchSuppliers"  class="easyui-linkbutton" iconCls="ext-icon-zoom"></a>
					</td>
					</c:if>
					<td></td>
					</tr>
			
					<tr>
					<th align="right"style="width: 80px;">货币</th>
					<td>:</td>
					<td>
						<%-- <select id="cbx_currencyId" name="currencyId" class="easyui-combobox" style="width:150px" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, required:true">
						<option value="1">RMB</option>
						<option value="2">USD</option>
						<option value="3">HKD</option>
						</select> --%>
						<select id="cbx_currencyId" name="currencyCode" class="easyui-combobox" style="width:150px;" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, required:true, valueField:'code', textField:'name',url:'${pageContext.request.contextPath}/common/droplist/doListUserInfo.do?type=cu'"
							<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
						></select>
					</td>
					<th align="right"style="width: 80px;">付款方式</th>
						<td>:</td>
					<td>
						<select id="typePaymentCode" name="typePaymentCode" class="easyui-combobox" style="width:150px;" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, required:true, valueField:'code', textField:'name',url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=fkfs'"
							<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
						></select>
						<input id="typePaymentName" name="typePaymentName" type="hidden" />
					</td>
					<th align="right"style="width: 80px;">发票类型</th>
						<td>:</td>
					<td>
						<select id="typeInvoiceCode" name="typeInvoiceCode" class="easyui-combobox" style="width:150px;" data-options="panelHeight:'auto',panelMaxHeight:'200',editable:false, required:true, valueField:'code', textField:'name',url:'${pageContext.request.contextPath}/common/droplist/doListUserInfoDetail.do?type=fplx'"
							<c:if test="${orderCategoryService.tagPageCode == '1809500'}">disabled="disabled"</c:if>
						></select>
						<input id="typeInvoiceName" name="typeInvoiceName" type="hidden" />
					</td>
					</tr>
				</tbody>
			</table>
			<%-- </c:if> --%>
		</form>
		<table id="edatagridDetail"></table>
</div>

<div id="dialog_buttons">
	<c:if test="${orderCategoryService.tagPageCode != '1809500'}"> 
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'ext-icon-pencil'" onclick="submitForm('d');">保存草稿</a>
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitForm('s');">保存提交</a>
	</c:if>
	<c:if test="${orderCategoryService.tagPageCode == '1809500'}">
	<a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-save'" onclick="submitFormCode('1809500');">保存审批人</a>
	</c:if> 
</div>
