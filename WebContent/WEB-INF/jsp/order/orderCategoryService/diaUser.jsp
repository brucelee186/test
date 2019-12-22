<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

	<script type="text/javascript" src="${pageContext.request.contextPath}/js/order/orderCategoryService/diaUser.js" charset="utf-8"></script>

    <!-- 弹出对话框 -->
	<div id="initAddSuppliers" class="easyui-window" title="添加收款人或支票" style="width:700px;height:200px;top:150px;background: #fafafa;display:none;" shadow="true" draggable="false" maximizable="false" collapsible="false" minimizable="false" closed="false" modal="true">
			<fieldset style="border-color: #E0ECFF;">
		    <legend>
		    	<div style="color: red;">支票情况下 开户行和银行账号请填写为【支票】</div>
		    </legend>
			<form id="suppliersDialogForm">
				<table width="100%" border="0" cellpadding="0" cellspacing="5" style="font-size:12px;">
				  <tr>
				    <td width="120" align="right"><span style="color:#ff0000">*</span>收款人或支票：</td>
				    <td><input type="text" name="userName" id="dia_userName" style="width:120px;" class="easyui-textbox" validType="length[0,30]" required="true"/></td>
				  	<td width="80" align="right"><span style="color:#ff0000">*</span>开户行：</td>
				    <td><input type="text" name="bankName" id="dia_bankName" style="width:120px" class="easyui-textbox" validType="length[0,30]" required="true"/></td>
				    <td width="80" align="right"><span style="color:#ff0000">*</span>银行帐号：</td>
				    <td><input type="text" name="bankCode" id="dia_bankCode" style="width:120px" class="easyui-textbox" validType="length[0,30]" required="true"/></td>
				  </tr>
				   <tr>
				  	<td width="80" align="right">手机：</td>
				    <td><input type="text" name="mobileNo" id="dia_mobileNo" style="width:120px" class="easyui-textbox" validType="validType:'phone'"/></td>
				    <td width="80" align="right">邮箱：</td>
				    <td><input type="text" name="email" id="dia_email" style="width:120px" class="easyui-textbox" data-options="validType: 'email'"/></td>
				    <td width="80" align="right">状态：</td>
				    <td>
				    	<select id="dia_statusUser" name="status" style="width:120px" class="easyui-combobox">
							<option value="a">启用</option>
							<option value="f">禁用</option>
						</select>
				    </td>
				  </tr>
				  <input type="hidden" name="copewithBalance" id="copewithBalance"/>
					<input type="hidden" name="balanceMoney" id="balanceMoney"/>
				</table>
			</form>
			</fieldset>
			<table align="center">
		         <tr>	
				    <td align="center" >&nbsp;
		       			&nbsp;<input type="button" value="添加" style="background:transparent;border-width:1px" onclick="insertSuppliers()"/>	
			   			&nbsp;<input type="button" value="重置" style="background:transparent;border-width:1px" onclick="suppliersResize()"/>
		            </td>
		         </tr>
		   </table>
	</div>
	<div id="initSearchSuppliers" class="easyui-window" title="收款人管理(支票情况下 开户行和银行账号请填写为【支票】)" style="display:none;width:815px;height:375px;top:100px;background: #fafafa;" shadow="true" draggable="false" maximizable="false" collapsible="false" minimizable="false" closed="false" modal="true">
				<!-- 
				<table width="800" border="0" cellpadding="0" cellspacing="4" style="font-size:12px;">
				
				  <tr>
				    <td width="80" align="right">名称：</td>
				    <td><input type="text" name="suppliersName_s" id="suppliersName_s" style="width:120px;"/></td>
					<td width="80" align="right">卡号：</td>
				    <td><input type="text" name="mnemonic_s" id="mnemonic_s" style="width:120px"/></td>
					<td width="40" align="center" colspan="2"><input type="button" value="查询" onclick="searchSuppliersByCond()"/></td>
				  </tr>
				</table>
				-->
				<table id="suppliers" style="height:auto"></table>
	</div>
