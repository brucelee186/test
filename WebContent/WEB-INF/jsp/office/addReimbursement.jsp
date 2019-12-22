<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Reimbursement Form</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<jsp:include page="../inc.jsp"></jsp:include>
</head>
<body>
<div style="width:900px;font-family: SimSun;">
	<div style="height:25px;width:100%;text-align:center;font-size:20px;">费用报销审批申请单</div>
	<div style="width:100%;text-align:center;font-size:18px;">Cash Payment Voucher</div>
	<table style="width: 100%;" cellspacing="0" cellpadding="0">
	<tr style="height:50px;">
		<td style="width:100px"></td>
		<td style="width:100px"></td>
		<td style="width:100px"></td>
		<td style="width:100px"></td>
		<td style="width:100px"></td>
		<td style="width:100px" style="border:solid 1px #000; border-right:none;border-bottom:none;">CPV No.:</td>
		<td style="width:200px" colspan="2" style="border:solid 1px #000; border-left:none;border-bottom:none;"><input type="text" style="width:100px;border:none" readonly="readonly"></td>
	</tr>
	<tr style="height:50px;">
		<td colspan="5" style="border:solid 1px #000; border-right:none;border-bottom:none;">时代万恒（辽宁）民族贸易有限公司<br>Manchu Times Fashion Inc.</td>
		<td style="border:solid 1px #000; border-right:none;border-bottom:none;">日期 Date:</td>
		<td colspan="2" style="border:solid 1px #000; border-left:none; border-bottom:none"><input type="text" style="width:100px;border:none" readonly="readonly"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border:solid 1px #000; border-right:none;border-bottom:none;">报销部门<br>Department:</td>
		<td colspan="2"style="border:solid 1px #000; border-left:none;border-bottom:none;"><input type="text" style="width:100px;border:none" readonly="readonly"></td>
		<td style="border-top:solid 1px #000;">收款人<br>Payee Name:</td>
		<td colspan="2" style="border-top:solid 1px #000;"><input type="text" style="width:100px;border:none" readonly="readonly"></td>
		<td style="text-align:right;border-top:solid 1px #000;border-left:solid 1px #000;">货币<br>Currency:</td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;"></td>
	</tr>
	<tr style="height:50px;">
		<td colspan="7" style="text-align:center;border:solid 1px #000;border-bottom:none;border-right:none;">用   途<br>Explanation:</td>
		<td style="text-align:center;border:solid 1px #000;border-bottom:none;">金 额<br>Amount</td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td style="border-top:solid 1px #000;border-left:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000"></td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"></td>
	</tr>
	<tr style="height:50px;">
		<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000">总计金额(大写)<br>Total Amount (In words):</td>
		<td colspan="4" style="border-top:solid 1px #000;"></td>
		<td style="border-top:solid 1px #000;border-left:solid 1px #000">合计 Total:</td>
		<td style="border-top:solid 1px #000;border-right:solid 1px #000"><input type="text" style="width:100px;border:none" readonly="readonly"></td>
	</tr>
	<tr>
		<td colspan="2" style="width: 25%;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000">批准人 Noted by:<br><br><br><br>首席执行官/首席营运官<br>CEO/COO</td>
		<td colspan="2" style="width: 25%;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000">审批人 Approved by:<br><br><br><br>行政部/部门负责人<br>Admin./Department Manager</td>
		<td colspan="2" style="width: 25%;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000">审查人 Checked by:<br><br><br><br>行政部/直属上级<br>Admin./Applicant Manager</td>
		<td colspan="2" style="width: 25%;border-top:solid 1px #000;border-left:solid 1px #000;border-right:solid 1px #000;border-bottom:solid 1px #000">申请人 Applicant:<br><br><br><br>填报人<br>Applicant</td>
	</tr>
	</table>
</div>
</body>
</html>