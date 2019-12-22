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
<script type="text/javascript"> 

</script>
</head>
<body>
<div class="mailbody">
<p class=MsoNormal style='margin-bottom:12.0pt'>
<br/>
<br/>

<table class="mailtableh" bordercolor="black" border="1px" cellspacing="1px" cellpadding="1px">
<tbody>
<tr><td colspan="6"><h2>审核未通过的报销列表</h2></td></tr>
<tr>
	<th width="150">报销号</th>
	<th width="200">申请部门</th>
	<th width="200">申请人</th>
	<th width="200">申请日期</th>
	<!-- <th width="150">总金额</th> -->
	<th width="150">币种</th>
	<th width="400">备注</th>
</tr>
<tr>
	<td style="text-align:right;">office_idOrderCategoryService</td>
	<td style="text-align:center;">office_divisionName</td>
	<td style="text-align:center;">office_userName</td>
	<td style="text-align:center;">office_applicantDate</td>
	<!-- <td style="text-align:right;">office_totalAmount</td> -->
	<td style="text-align:center;">office_currencyName</td>
	<td style="text-align:left; color: red;">office_remarkApprove</td>
</tr>
</tbody>
</table>

<table class="mailtableh" bordercolor="black" border="1px" cellspacing="1px" cellpadding="1px">
<tbody>
<tr>
	<th width="150">部门</th>
	<th width="200">客户</th>
	<th width="250">主类别</th>
	<th width="250">次类别</th>
	<th width="300">描述</th>
	<th width="150">金额</th>
</tr>
<office_manager/>
</tbody>
</table>
<office_link/>
<br/>
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