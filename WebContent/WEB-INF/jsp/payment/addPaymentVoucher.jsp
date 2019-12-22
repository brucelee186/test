<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML >
<html>
<head>
<title>Reimbursement Form</title>
<meta http-equiv="content-type" content="text/html;charset=UTF-8">
<!-- easyui控件 -->
<link id="easyuiTheme" rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.6/themes/<c:out value="${cookie.easyuiThemeName.value}" default="default"/>/easyui.css" type="text/css"></link>
<link rel="stylesheet" href="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.6/themes/icon.css" type="text/css"></link>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.2/jquery-1.8.0.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.6/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/mtf-util.js" charset="utf-8"></script>
<c:if test="${cookie.userLocale.value == 'zh' or cookie.userLocale.value == 'zh_CN'}">
<script type="text/javascript" src="${pageContext.request.contextPath}/jslib/jquery-easyui-1.3.6/locale/easyui-lang-zh_CN.js" charset="utf-8"></script>
</c:if>
<!-- 国际化 -->
<c:if test="${cookie.userLocale.value == 'zh' or cookie.userLocale.value == 'zh_CN'}">
<script type="text/javascript">
	loadingMsg = '加载中...';
	errorTitle = '错误';
	notMatch = '不一致。';
</script>
</c:if>
<style type="text/css">
*{
	font-size:12px;
}
body{
	font-family:'宋体', verdana,helvetica,arial,sans-serif,'Times New Roman';
	background:#fff;
}
input, textarea{
	font-family:'宋体', verdana,helvetica,arial,sans-serif,'Times New Roman';
}
input:focus{
	outline:none;
}
textarea:focus{
	outline:none;
}
#tbl td {
vertical-align:middle; 
}
#tbl label {
width:100%;
max-height: 35px;
}
#tbl td div {
width:100%;
height:35px;
max-height:35px;
}

input {
font-size:11px;

}
textarea {
font-size:11px;
}

.combo {
border:none;
}
</style>
<style type="text/css" media="print">
	.noprint {
		display: none;
	}
</style>
<script type="text/javascript">
/**
 * 将日期字符串转为Date对象
 * @param str 日期字符串（yyyy-MM-dd或MM/dd/yyyy）
 * @param nullable 允许返回空
 * @returns {Date}
 */
function parseDate(str, nullable){
	if(!str) {
		if (nullable) {
			return;
		} else {
			return new Date();
		}
	}
	
	var ymd = str.split("-");
	if(ymd.length == 3){
		return new Date(Date.parse(ymd[1]+"/"+ymd[2]+"/"+ymd[0]));
	}else{
		return new Date(Date.parse(str));
	}
}

/**
 * 格式化日期对象为字符串
 * @param date		需要格式化的日期对象
 * @param format	输出格式，默认MM/dd/yyyy
 * @returns String
 */
function formatDate(date, format) {
	if (!date) {
		return '';
	}
	
	if(format == undefined){
		format = 'yyyy/MM/dd';
	}

	var o = { 
		"M+" : date.getMonth()+1, //month 
		"d+" : date.getDate(), //day 
		"h+" : date.getHours(), //hour 
		"m+" : date.getMinutes(), //minute 
		"s+" : date.getSeconds(), //second 
		"q+" : Math.floor((date.getMonth()+3)/3), //quarter 
		"S" : date.getMilliseconds() //millisecond 
	} 

	if(/(y+)/.test(format)) { 
		format = format.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length)); 
	} 

	for(var k in o) { 
		if(new RegExp("("+ k +")").test(format)) { 
			format = format.replace(RegExp.$1, RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length)); 
		} 
	}
	
	return format; 
}

/**
 * @requires EasyUI
 * 
 * 设置datebox默认显示格式MM/dd/yyyy
 */
$.fn.datebox.defaults.formatter = formatDate;

/**
 * @requeires EasyUI
 * 
 * 设置datebox默认日期转换方式
 */
$.fn.datebox.defaults.parser = parseDate;
</script>


<script type="text/javascript">
var p_cat = ${categorysJson};
var p_valid = true;

$(function(){
	$('#tbl_recipient').mouseenter(function(){
		if (!p_valid) return;
		resetControl(0);
		$('#tbl_recipient').hide();
		$('#txt_recipient').show().focus();
	});
	$('#txt_recipient').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_recipient').html($('#txt_recipient').val());
			$('#tbl_recipient').show();
			$('#txt_recipient').hide();
		}
	});
	
	$('#tbl_description1').mouseenter(function(){
		if (!p_valid) return;
		resetControl(1);
		$('#tbl_description1').hide();
		$('#txt_description1').show().focus();
	});
	$('#txt_description1').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description1').html($('#txt_description1').val());
			$('#tbl_description1').show();
			$('#txt_description1').blur().hide();
		}
	});
	
	$('#tbl_description2').mouseenter(function(){
		if (!p_valid) return;
		resetControl(2);
		$('#tbl_description2').hide();
		$('#txt_description2').show().focus();
	});
	$('#txt_description2').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description2').html($('#txt_description2').val());
			$('#tbl_description2').show();
			$('#txt_description2').blur().hide();
		}
	});
	
	$('#tbl_description3').mouseenter(function(){
		if (!p_valid) return;
		resetControl(3);
		$('#tbl_description3').hide();
		$('#txt_description3').show().focus();
	});
	$('#txt_description3').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description3').html($('#txt_description3').val());
			$('#tbl_description3').show();
			$('#txt_description3').blur().hide();
		}
	});
	
	$('#tbl_description4').mouseenter(function(){
		if (!p_valid) return;
		resetControl(4);
		$('#tbl_description4').hide();
		$('#txt_description4').show().focus();
	});
	$('#txt_description4').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description4').html($('#txt_description4').val());
			$('#tbl_description4').show();
			$('#txt_description4').blur().hide();
		}
	});
	
	$('#tbl_description5').mouseenter(function(){
		if (!p_valid) return;
		resetControl(5);
		$('#tbl_description5').hide();
		$('#txt_description5').show().focus();
	});
	$('#txt_description5').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description5').html($('#txt_description5').val());
			$('#tbl_description5').show();
			$('#txt_description5').blur().hide();
		}
	});
	
	$('#tbl_description6').mouseenter(function(){
		if (!p_valid) return;
		resetControl(6);
		$('#tbl_description6').hide();
		$('#txt_description6').show().focus();
	});
	$('#txt_description6').mouseout(function(){
		p_valid = $(this).validatebox('isValid');
		if (p_valid) {
			$('#lbl_description6').html($('#txt_description6').val());
			$('#tbl_description6').show();
			$('#txt_description6').blur().hide();
		}
	});
	
	for (var i = 1; i <= 6; i ++) {
		$('#cbx_cat' + i).combobox('loadData', getCat(0));
	}
	$('#dtb_applicationDate').datebox('setValue', formatDate(new Date()));
});

function resetControl(item) {
	for (var i = 1; i <= 6; i ++) {
		if (i != item) {
			$('#txt_description' + i).mouseout();
		}
	}
	if (item != 0) {
		$('#txt_recipient').mouseout();
	}
}

function getCat(pid) {
	if(pid === ''){
		return [];
	}
	
	var level = [];
	level.push({id:'', name:''});
	for (var i = 0; i < p_cat.length; i ++) {
		if (p_cat[i].pid == pid) {
			level.push({'id':p_cat[i].id, 'name':p_cat[i].categoryName + '/'});
		}
	}
	return level;
}

function getAmountCn() {
	var amount1 = $('#nbx_amount1').numberbox('getValue');
	var amount2 = $('#nbx_amount2').numberbox('getValue');
	var amount3 = $('#nbx_amount3').numberbox('getValue');
	var amount4 = $('#nbx_amount4').numberbox('getValue');
	var amount5 = $('#nbx_amount5').numberbox('getValue');
	var amount6 = $('#nbx_amount6').numberbox('getValue');
	
	if(amount1==='' && amount2==='' && amount3==='' && amount4==='' && amount5==='' && amount6===''){
		$('#nbx_amountTotal').numberbox('setValue', '');
		$('#td_amountTotalCn').html('');
		return;
	}

	if (amount1 == '') amount1 = 0.0;
	if (amount2 == '') amount2 = 0.0;
	if (amount3 == '') amount3 = 0.0;
	if (amount4 == '') amount4 = 0.0;
	if (amount5 == '') amount5 = 0.0;
	if (amount6 == '') amount6 = 0.0;
	
	var amountTotal = parseFloat(amount1) + parseFloat(amount2) + parseFloat(amount3) + parseFloat(amount4) + parseFloat(amount5) + parseFloat(amount6);
	$('#nbx_amountTotal').numberbox('setValue', amountTotal);
	
	cn = chineseNumber($('#nbx_amountTotal').numberbox('getValue'));

	$('#td_amountTotalCn').html(cn);
}

function chineseNumber(num) {
	if (isNaN(num) || num > Math.pow(10, 12))
		return "";
	if(num == 0){
		return "零元整";
	}
	
	var cn = "零壹贰叁肆伍陆柒捌玖";
	var unit = new Array("拾百千", "分角");
	var unit1 = new Array("万亿", "");
	var numArray = num.toString().split(".");
	var start = new Array(numArray[0].length - 1, 2);

	function toChinese(num, index) {
		var num = num.replace(/\d/g, function($1) {
			return cn.charAt($1) + unit[index].charAt(start-- % 4 ? start % 4 : -1);
		})
		return num;
	}

	for (var i = 0; i < numArray.length; i++) {
		var tmp = ""
		for (var j = 0; j * 4 < numArray[i].length; j++) {
			var strIndex = numArray[i].length - (j + 1) * 4;
			var str = numArray[i].substring(strIndex, strIndex + 4);
			var start = i ? 2 : str.length - 1;
			var tmp1 = toChinese(str, i);
			tmp1 = tmp1.replace(/(零.)+/g, "零").replace(/零+$/, "");
			tmp1 = tmp1.replace(/^壹拾/, "拾");
			tmp = (tmp1 + unit1[i].charAt(j - 1)) + tmp;
		}
		numArray[i] = tmp
	}

	numArray[1] = numArray[1] ? numArray[1] : "";
	numArray[0] = numArray[0] ? numArray[0] + "元" : numArray[0], numArray[1] = numArray[1].replace(/^零+/, "");
	numArray[1] = numArray[1].match(/分/) ? numArray[1] : numArray[1] + "整";
	return numArray[0] + numArray[1];
}


function doSubmit() {
	if (!p_valid) {
		$.messager.alert('<s:message code="common.dialog.error" />', '表单有错误项！', 'error');
		return;
	}
	var cpvNo = ${number};
	var applicationDate = $('#dtb_applicationDate').datebox('getValue');
	var recipient = $('#txt_recipient').val();
	var currencyId = $('#cbx_currency').combobox('getValue');
	var currencyName = $('#cbx_currency').combobox('getText');
	var totalAmount = $('#nbx_amountTotal').numberbox('getValue');
	var applicantDeptId = 'ab817736-8197-462e-a15b-910ec799efdb';
	var applicantDeptName = '行政部';
	
	if (recipient == undefined || recipient == null || recipient == '') {
		$.messager.alert('<s:message code="common.dialog.error" />', '收款人不能为空！', 'error', function() {
			$('#tbl_recipient').mouseenter();
		});
		return;
	}
	if (applicationDate == undefined || applicationDate == null || applicationDate == '') {
		$.messager.alert('<s:message code="common.dialog.error" />', '申请日期不能为空！', 'error', function() {
			$('#dtx_applicationDate').datebox('showPanel');
		});
		return;
	}
	if (currencyId == '') {
		$.messager.alert('<s:message code="common.dialog.error" />', '货币种类不能为空！', 'error', function() {
			$('#nbx_currency').combobox('showPanel');
		});
		return;
	}
	var form = {
		'cpvNo' : cpvNo,
		'recipient' : recipient,
		'applicantDeptId' : applicantDeptId,
		'applicantDeptName' : applicantDeptName,
		'applicationDate' : applicationDate,
		'currencyId' : currencyId,
		'currencyName' : currencyName,
		'totalAmount' : totalAmount,
		'totalAmountWord' : $('#td_amountTotalCn').html()
	};
	
	var items = [];
	for (var i = 1; i <= 6; i ++) {
		var level1CategoryId = $('#cbx_cat' + i).combobox('getValue');
		var level1CategoryName = $('#cbx_cat' + i).combobox('getText');
		var level2CategoryId = $('#cbx_subcat' + i).combobox('getValue');
		var level2CategoryName = $('#cbx_subcat' + i).combobox('getText');
		var description = $('#txt_description' + i).val();
		var amount = $('#nbx_amount' + i).numberbox('getValue');
		
		var code = 0;
		if (level1CategoryId != '') {
			code += 8;
		}
		if (level2CategoryId != '') {
			code += 4;
		}
		if (description != '') {
			code += 2;
		}
		if (amount != '') {
			code += 1;
		}
		if (code > 0 && code != 1+2+4+8) {
			if ((code | 8) != code) {
				$.messager.alert('<s:message code="common.dialog.error" />', '项目 ' + i + ' 分类1不能为空！', 'error', function() {
					$('#cbx_cat' + i).combobox('showPanel');
				});
				return;
			}
			if ((code | 4) != code) {
				$.messager.alert('<s:message code="common.dialog.error" />', '项目 ' + i + ' 分类2不能为空！', 'error', function() {
					$('#cbx_subcat' + i).combobox('showPanel');
				});
				return;
			}
			if ((code | 2) != code) {
				$.messager.alert('<s:message code="common.dialog.error" />', '项目 ' + i + ' 描述不能为空！', 'error', function() {
					$('#tbl_description' + i).mouseenter();
				});
				return;
			}
			if ((code | 1) != code) {
				$.messager.alert('<s:message code="common.dialog.error" />', '项目 ' + i + ' 金额不能为空！', 'error', function() {
					$('#nbx_amount' + i).focus();
				});
				return;
			}
		}
		if (code == 1+2+4+8) {
			items.push({
				'level1CategoryId' : level1CategoryId,
				'level1CategoryName' : level1CategoryName,
				'level2CategoryId' : level2CategoryId,
				'level2CategoryName' : level2CategoryName,
				'description' : description,
				'amount' : amount,
				'index' : i
			});
		}
	}
	form.itemStr = JSON.stringify(items);
	$.messager.confirm('<s:message code="common.dialog.confirm" />', '确认要提交吗？', function(rr) {
		if (rr) {
			$.messager.progress();
			$.post('${pageContext.request.contextPath}/payment/paymentVoucher/doAdd.do', form, function(result) {
				$.messager.progress('close');// hide progress dialog
				try {
					var j = result;
					if (j.success) {
						$.messager.alert('<s:message code="common.dialog.tip" />', 'OK', 'info');
					} else {
						var msg = j.msg;
						if (!msg && j.obj) {
							msg = formatErrorMessage(j.obj);
						}
						$.messager.alert('<s:message code="common.dialog.error" />', msg, 'error');
					}
				} catch (e) {
					$.messager.alert('<s:message code="common.dialog.error" />', result, 'error');
				}
			}, 'json');
		}
	});
}

function doPdfReport(){
	var cpvNo = ${number};
	var applicationDate = $('#dtb_applicationDate').datebox('getValue');
	var recipient = $('#txt_recipient').val();
	var currencyId = $('#cbx_currency').combobox('getValue');
	var currencyName = $('#cbx_currency').combobox('getText');
	var totalAmount = $('#nbx_amountTotal').numberbox('getValue');
	var applicantDeptId = 'ab817736-8197-462e-a15b-910ec799efdb';
	var applicantDeptName = '行政部';
	
	var paymentVoucher = {
		'cpvNo' : cpvNo,
		'recipient' : recipient,
		'applicantDeptId' : applicantDeptId,
		'applicantDeptName' : applicantDeptName,
		'applicationDate' : applicationDate,
		'currencyId' : currencyId,
		'currencyName' : currencyName,
		'totalAmount' : totalAmount,
		'totalAmountWord' : $('#td_amountTotalCn').html()=='&nbsp;'?'':$('#td_amountTotalCn').html()
	};
	
	var items = [];
	for (var i = 1; i <= 6; i ++) {
		var level1CategoryId = $('#cbx_cat' + i).combobox('getValue');
		var level1CategoryName = $('#cbx_cat' + i).combobox('getText');
		var level2CategoryId = $('#cbx_subcat' + i).combobox('getValue');
		var level2CategoryName = $('#cbx_subcat' + i).combobox('getText');
		var description = $('#txt_description' + i).val();
		var amount = $('#nbx_amount' + i).numberbox('getValue');
		
		items.push({
			'level1CategoryId' : level1CategoryId,
			'level1CategoryName' : level1CategoryName,
			'level2CategoryId' : level2CategoryId,
			'level2CategoryName' : level2CategoryName,
			'description' : description,
			'amount' : amount,
			'index' : i
		});
	}

	$('#hid_paymentVoucherStr').val(JSON.stringify(paymentVoucher));
	$('#hid_paymentVoucherItemStr').val(JSON.stringify(items));
	$('#frm_pdfReport').submit();
}
</script>
</head>
<body>
<div style="width:800px;font-family: SimSun; margin:10px;">
	<div style="height:25px;width:100%;text-align:center;font-size:18px;">费用报销审批申请单</div>
	<div style="width:100%;text-align:center;font-size:18px;">Cash Payment Voucher</div>
	<table id="tbl" cellspacing="0" cellpadding="0">
		<tr>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
			<td style="width:100px"></td>
		</tr>
		<tr>
			<td>No.:</td>
			<td><input id="txt_number" type="text" style="border:none;width:80px;" value="${number}" readonly="readonly"/></td>
			<td></td>
			<td></td>
			<td></td>
			<td style="border:solid 1px #000; border-right:none;border-bottom:none;">CPV No.:</td>
			<td colspan="2" style="border:solid 1px #000; border-left:none;border-bottom:none;"><input type="text" style="width:98px;border:none" readonly="readonly" /></td>
		</tr>
		<tr style="height:35px;">
			<td colspan="5" style="text-align:left;border:solid 1px #000; border-right:none;border-bottom:none;">时代万恒（辽宁）民族贸易有限公司<br>Manchu Times Fashion Inc.</td>
			<td style="border:solid 1px #000; border-right:none;border-bottom:none;">日期 Date:</td>
			<td colspan="2" style="border:solid 1px #000; border-left:none; border-bottom:none"><input id="dtb_applicationDate" type="text" class="easyui-datebox" style="width:180px;border:none" data-options="hasDownArrow:false,editable:false"></td>
		</tr>
		<tr style="height:35px;">
			<td style="border:solid 1px #000; border-right:none;border-bottom:none;">报销部门<br>Department:</td>
			<td colspan="2" style="border:solid 1px #000; border-bottom:none;">行政部</td>
			<td style="border-top:solid 1px #000;">收款人<br>Payee Name:</td>
			<td colspan="2" style="border-top:solid 1px #000;border-left:solid 1px #000;"><div id="div_recipient" style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_recipient" style="border:none;width:100%;height:100%;"><tr><td id="lbl_recipient" style="text-align: left;"></td></tr></table><textarea id="txt_recipient" class="easyui-validatebox" data-options="validType:{length:[0, 50]}" style="width: 192px;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-left:solid 1px #000;">货币<br>Currency:</td>
			<td style="border-top:solid 1px #000;border-left:solid 1px #000;border-right:solid 1px #000;"><select id="cbx_currency" class="easyui-combobox" style="width:98px;border:none;height:33px;" data-options="panelHeight:'auto',hasDownArrow:false,editable:false">
				<option value="1">RMB</option>
				<option value="2">USD</option>
			</select></td>
		</tr>
		<tr style="height:35px;">
			<td colspan="7" style="text-align:center;border:solid 1px #000;border-bottom:none;border-right:none;">用   途<br>Explanation</td>
			<td style="text-align:center;border:solid 1px #000;border-bottom:none;">金 额<br>Amount</td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat1" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat1').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat1" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description1" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description1" style="text-align: left;"></td></tr></table><textarea id="txt_description1" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount1" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat2" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat2').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat2" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description2" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description2" style="text-align: left;"></td></tr></table><textarea id="txt_description2" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount2" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat3" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat3').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat3" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description3" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description3" style="text-align: left;"></td></tr></table><textarea id="txt_description3" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount3" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat4" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat4').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat4" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description4" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description4" style="text-align: left;"></td></tr></table><textarea id="txt_description4" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount4" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat5" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat5').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat5" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description5" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description5" style="text-align: left;"></td></tr></table><textarea id="txt_description5" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount5" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td style="border-top:solid 1px #000;border-left:solid 1px #000"><input id="cbx_cat6" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name', onSelect:function(rec){$('#cbx_subcat6').combobox('setValue', '').combobox('loadData', getCat(rec.id));}" /></td>
			<td style="border-top:solid 1px #000"><input id="cbx_subcat6" class="easyui-combobox" style="width:99px;border:none;height:33px;" data-options="hasDownArrow:false,editable:false,panelWidth:'120',valueField:'id', textField:'name'" /></td>
			<td colspan="5" style="border-top:solid 1px #000"><div style="width: 100%;height:35px; max-height: 35px;vertical-align: middle;"><table id="tbl_description6" style="border:none;width:100%;height:100%;"><tr><td id="lbl_description6" style="text-align: left;"></td></tr></table><textarea id="txt_description6" class="easyui-validatebox" data-options="validType:{length:[0, 100]}" style="width: 99%;height:100%;border:none;display:none;resize: none;"></textarea></div></td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000;border-left:solid 1px #000"><input id="nbx_amount6" class="easyui-numberbox" style="width:98px;border:none;text-align:right;" data-options="precision:2, min:0, max:999999.99, onChange : function(oldVal, newVal) {getAmountCn();}" /></td>
		</tr>
		<tr style="height:35px;">
			<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000">总计金额(大写)<br>Total Amount (In words):</td>
			<td id="td_amountTotalCn" colspan="4" style="text-align:left;border-top:solid 1px #000;">&nbsp;</td>
			<td style="border-top:solid 1px #000;border-left:solid 1px #000">合计 Total:</td>
			<td style="border-top:solid 1px #000;border-right:solid 1px #000"><input id="nbx_amountTotal" class="easyui-numberbox" style="width:98px;border:none;text-align:right;font-weight: bold;" data-options="precision:2" /></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000"><table style="width: 100%"><tr><td>批准人 Noted by:</td></tr><tr><td style="height:30px;"></td></tr><tr><td>首席执行官/首席营运官<br>CEO/COO</td></tr></table></td>
			<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000"><table style="width: 100%"><tr><td>审批人 Approved by:</td></tr><tr><td style="height:30px;"></td></tr><tr><td>行政部/部门负责人<br>Admin./Department Manager</td></tr></table></td>
			<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000;border-bottom:solid 1px #000"><table style="width: 100%"><tr><td>审查人 Checked by:</td></tr><tr><td style="height:30px;"></td></tr><tr><td>行政部/直属上级<br>Admin./Applicant Manager</td></tr></table></td>
			<td colspan="2" style="text-align:left;border-top:solid 1px #000;border-left:solid 1px #000;border-right:solid 1px #000;border-bottom:solid 1px #000"><table style="width: 100%"><tr><td>申请人 Applicant:</td></tr><tr><td style="height:30px;text-align: center">${sessionInfo.displayName }</td></tr><tr><td>填报人<br>Applicant</td></tr></table></td>
		</tr>
	</table>
</div>
<div class="noprint" style="width: 800px;text-align:center">
	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:window.print();" data-options="iconCls:'icon-print'">打印</a>  
	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:doSubmit();" data-options="iconCls:'icon-save'">提交</a>
	<a href="javascript:void(0);" class="easyui-linkbutton" onclick="javascript:doPdfReport();" data-options="iconCls:'icon-save'">PDF</a>
</div>
<form id="frm_pdfReport" method="post" action="${pageContext.request.contextPath}/payment/paymentVoucher/doPdfReport.do" target="_blank">
	<input id="hid_paymentVoucherStr" name="paymentVoucherStr" value="" type="hidden"/>
	<input id="hid_paymentVoucherItemStr" name="paymentVoucherItemStr" value="" type="hidden"/>
</form>
</body>
</html>
