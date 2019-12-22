<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<style type="text/css">
<!-- 
.mailbody {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; font-size: 11pt; color: #110043; text-decoration: none;}
.mailfooter {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; font-size: 9pt;font-style: italic;color:#999999}
.mailtableh {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; border-collapse:collapse;text-align: center; color:#110043}
.mailtableh th {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; padding: 3px; background-color: #C2D9F1}
.mailtableh td {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; padding: 3px;}
.mailtablev {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; border-collapse:collapse;color:#110043}
.mailtablev th {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; padding: 3px; background-color: #C2D9F1; text-align: right; }
.mailtablev td {font-family: Candara, Verdana, Arial, Helvetica, sans-serif; border-color:#6593CF;border-width:1px;border-style:solid; padding: 3px; text-align: left; }
-->
</style>
</head>
<body>
<div class="mailbody">
<p class=MsoNormal style='margin-bottom:12.0pt'>
<br/>
<br/>

<table class="mailtableh" bordercolor="black" border="1px" cellspacing="1px" cellpadding="1px">
<tbody>
<tr><td colspan="4"><h2>员工入职申请</h2></td></tr>
<tr>
	<td width="150" colspan="1" align="left">姓名</th>
	<td style="text-align:center;" colspan="3" align="left">displayName</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">性别</th>
	<td width="150"  style="text-align:center;" colspan="1" align="left">gender</td>
	<td width="150" colspan="1" align="left">出生年月日</th>
	<td width="150"  style="text-align:center;" colspan="1" align="left">birthDate</td>
</tr>
<tr>
	<td width="150" colspan="4" align="left" style="font-style:oblique;font-weight:bold">教育和工作背景</th>
</tr>
<tr>
	<td width="150" colspan="1" align="left">毕业学校</th>
	<td style="text-align:center;" colspan="1" align="left">schoolName</td>
	<td width="150" colspan="1" align="left">专业</th>
	<td style="text-align:center;" colspan="1" align="left">major</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">学位</th>
	<td style="text-align:center;" colspan="1" align="left">educationalDegree</td>
	<td width="150" colspan="1" align="left">英语等级</th>
	<td style="text-align:center;" colspan="1" align="left">englishProficiency</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">其他证书</th>
	<td style="text-align:center;" colspan="1" align="left">skills</td>
	<td width="150" colspan="1" align="left">工作经验</th>
	<td style="text-align:center;" colspan="1" align="left">workingYear年</td>
</tr>
<tr>
	<td width="150" colspan="4" align="left" style="font-style:oblique;font-weight:bold">岗位安排</th>
</tr>
<tr>
	<td width="150" colspan="1" align="left">需求部门</th>
	<td style="text-align:center;" colspan="1" align="left">departmentNameExpected</td>
	<td width="150" colspan="1" align="left">应聘职位</th>
	<td style="text-align:center;" colspan="1" align="left">targetPosition</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">预计入职时间</th>
	<td style="text-align:center;" colspan="1" align="left">entryDateExpected</td>
	<td width="150" colspan="1" align="left"></th>
	<td style="text-align:center;" colspan="1" align="left"></td>
</tr>
<tr>
	<td width="150" colspan="4" align="left" style="font-style:oblique;font-weight:bold">实习期薪酬</th>
</tr>
<tr>
	<td width="150" colspan="1" align="left">税前工资</th>
	<td style="text-align:center;" colspan="1" align="left">emolumentPreTaxPositiveBefore</td>
	<td width="150" colspan="1" align="left"></th>
	<td style="text-align:center;" colspan="1" align="left"></td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">保险公积金扣款</th>
	<td style="text-align:center;" colspan="1" align="left">withholdingPositiveBefore</td>
	<td width="150" colspan="1" align="left">税后工资</th>
	<td style="text-align:center;" colspan="1" align="left">emolumentAfterTaxPositiveBefore</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">保险基数</th>
	<td style="text-align:center;" colspan="1" align="left">socialSecurityRangePositiveBefore</td>
	<td width="150" colspan="1" align="left">公积金基数</th>
	<td style="text-align:center;" colspan="1" align="left">houseFundinRangePositiveBefore</td>
</tr>
<tr>
	<td width="150" colspan="4" align="left" style="font-style:oblique;font-weight:bold">转正后薪酬</th>
</tr>
<tr>
	<td width="150" colspan="1" align="left">税前工资</th>
	<td style="text-align:center;" colspan="1" align="left">emolumentPreTax</td>
	<td width="150" colspan="1" align="left">转正月份</th>
	<td style="text-align:center;" colspan="1" align="left">positiveMonth</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">保险公积金扣款</th>
	<td style="text-align:center;" colspan="1" align="left">withholding</td>
	<td width="150" colspan="1" align="left">税后工资</th>
	<td style="text-align:center;" colspan="1" align="left">emolumentAfterTax</td>
</tr>
<tr>
	<td width="150" colspan="1" align="left">保险基数</th>
	<td style="text-align:center;" colspan="1" align="left">socialSecurityRange</td>
	<td width="150" colspan="1" align="left">公积金基数</th>
	<td style="text-align:center;" colspan="1" align="left">houseFundinRange</td>
</tr>
</table>
</br>
</br>
<table class="mailtableh" bordercolor="black" border="1px" cellspacing="1px" cellpadding="1px">
<tbody>
<tr>
	<td width="150" colspan="6" align="left" style="font-style:oblique;font-weight:bold">组织结构</th>
</tr>
<tr>
	<th width="50">NO.</th>
	<th width="150">Given Name</th>
	<th width="150">Family Name</th>
	<th width="150">Chinese Name</th>
	<th width="300">Position</th>
	<th width="300">Immediate Superior(Dalian)</th>
</tr>
<office_detail/>
</tbody>
</table>
<span style='font-size:13.0pt;mso-ascii-font-family:Verdana;mso-hansi-font-family:
Verdana;color:#110043'>这是一封由行政管理平台自动发出的邮件，如有疑问，请问询员工所在部门负责人或行政部相关负责人</span>

<br/>
<br/>
<span style='font-size:13.0pt;mso-ascii-font-family:Verdana;mso-hansi-font-family:
Verdana;color:#110043'>行政管理平台</span>

<p class=MsoNormal><span lang=EN-US style='font-size:13.0pt;font-family:"Candara","sans-serif";
color:#110043'><o:p>&nbsp;</o:p></span></p>

<hr />
<span class="mailfooter">
<p>This message is sent from OFFICE, please do not reply!</p>
</span>
</div>
</body>
</html>