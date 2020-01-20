<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<tr>
	<td style="vertical-align: top;">
		<div class="easyui-panel" title="试用信息" style="width: 900px; height: 'auto'; padding: 10px;" data-options="">
			<table class="mtftable">
				<tr style="">
					<th style="width:150px;text-align: left;">需求部门：</th>
					<td style="width:300px;text-align: left;"><input id="combotree_division_entry" name="departmentIdExpected" class="easyui-combobox" style="width:280px" data-options="required: true,value:'${userDetail.departmentIdExpected}', valueField:'code', textField:'name',  panelHeight:'auto', editable:false, "></input></td>
					<th style="width:150px;text-align: left;">预计入职日期：</th>
					<td style="width:300px;text-align: left;"><input id="entryDateExpected" name="entryDateExpected" value="${userDetail.entryDateExpected}" style="width: 280px;" class="easyui-datebox" data-options="editable:false"/></td>
					<td style="width:60px;text-align: left;"></td>
				</tr>
				<tr>
					<th>税前工资：</th>
					<td><input id="emolumentPreTaxPositiveBefore" name="emolumentPreTaxPositiveBefore" value="${userDetail.emolumentPreTaxPositiveBefore}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
					<th>扣款：</th>
					<td><input id="withholdingPositiveBefore" name="withholdingPositiveBefore" value="${userDetail.withholdingPositiveBefore}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<th>税后工资：</th>
					<td><input id="emolumentAfterTaxPositiveBefore" name="emolumentAfterTaxPositiveBefore" value="${userDetail.emolumentAfterTaxPositiveBefore}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
				</tr>
				<tr>
					<th>保险基数：</th>
					<td><input name="socialSecurityRangePositiveBefore" value="${userDetail.socialSecurityRangePositiveBefore}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
					<th>公积金基数：</th>
					<td><input name="houseFundinRangePositiveBefore" value="${userDetail.houseFundinRangePositiveBefore}" data-options="required: false, validType:'length[1,10]',min:0, precision:2" style="width: 280px;" class="easyui-numberbox" /></td>
				</tr>
			</table>
		</div>
	</td>
</tr>
