/*
 * Copyright (c) 2013 LIAONING SHIDAI_WANHENG CO.,LTD. All Rights Reserved.
 * This work contains SHIDAI_WANHENG CO.,LTD.'s unpublished
 * proprietary information which may constitute a trade secret
 * and/or be confidential. This work may be used only for the
 * purposes for which it was provided, and may not be copied
 * or disclosed to others. Copyright notice is precautionary
 * only, and does not imply publication.
 *
 */
package com.mtf.framework.task;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.common.Message;
import com.mtf.framework.model.impl.ReimbursementImpl;
import com.mtf.framework.service.IMailService;
import com.mtf.framework.service.PurchaseService;
import com.mtf.framework.service.ReimbursementService;
import com.mtf.framework.util.CommonUtil;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.PoiUtils;


/**
 * PurchaseMailTask
 *
 * @author Bill.Qi
 * @version 1.0	2015-06-23	Bill.Qi			created.
 * @version <ver>
 */

@Component("purchaseMailTask")
public class PurchaseMailTask {
	
	private static final Logger		logger	= Logger.getLogger(MailSendTask.class);
	
	private static final String[]	monthStr = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
	
	private PurchaseService 		purchaseService;
	private ReimbursementService	reimbursementService;
	private IMailService				mailService;
	
	@Autowired
	public void setPurchaseService(PurchaseService purchaseService) {
		this.purchaseService = purchaseService;
	}
	
	@Autowired
	public void setReimbursementService(ReimbursementService reimbursementService) {
		this.reimbursementService = reimbursementService;
	}
	
	@Autowired
	public void setMailService(IMailService mailService) {
		this.mailService = mailService;
	}

	public boolean sendMail() throws PmException {
		// String tagTest = CommonUtil.getConfig("tagTest");
		// 变更为绑定物理网卡形式
		if (CommonUtil.getTrueSys()) {
			//获取上周一
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			Date now = new Date();
			Calendar calendar = Calendar.getInstance();
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(now); 
			calendar.add(Calendar.WEEK_OF_YEAR, -1);// 一周 
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY); 
			String from = sdf.format(calendar.getTime());
			//获取上周日
			calendar.setFirstDayOfWeek(Calendar.MONDAY);
			calendar.setTime(now);
			calendar.add(Calendar.WEEK_OF_YEAR, -1);
			//calendar.set(Calendar.DAY_OF_WEEK, 1); 
			calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY); 
			String to = sdf.format(calendar.getTime());
			
			StringBuffer sb = new StringBuffer();
			try {
				List<ReimbursementImpl> list = new ArrayList<ReimbursementImpl>();
				List<ReimbursementImpl> divisionList = new ArrayList<ReimbursementImpl>();
				List<ReimbursementImpl> listForDivision = new ArrayList<ReimbursementImpl>();
				//获取生成文件所需要的数据
				ReimbursementImpl reimbursementParam = new ReimbursementImpl();
				reimbursementParam.setApplicationDateFrom(sdf.parse(from));
				reimbursementParam.setApplicationDateTo(sdf.parse(to));
				//填充数据
				list = this.reimbursementService.selectForCustomerReport(reimbursementParam);
				divisionList = this.reimbursementService.selectForDivisionReport(reimbursementParam);
				listForDivision = this.reimbursementService.selectForDetail(reimbursementParam);
				
				if(list.size() <= 1){
					return false;
				}
				
				sb.append(ConfigUtil.getMailBodyHeader());
				//客户报销统计报表
				sb.append("<table class=\"mailtableh\" width=\"1550\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
				sb.append("<tbody>\r\n");
				sb.append("<tr><td colspan=\"14\"><h2>客户报销统计报表（" + from + "———" + to + "）</h2></td></tr>\r\n");
				sb.append("<tr><th width=\"150\" >客户 </th>" +
						"<th width=\"100\" >打印费</th>" +
						"<th width=\"100\">低值易耗品消耗</th>" +
						"<th width=\"100\">加班费用</th>" +
						"<th width=\"100\">招待费</th>" +
						"<th width=\"100\">车费</th>" +
						"<th width=\"100\">公寓费用</th>" +
						"<th width=\"100\">涉外费</th>" +
						"<th width=\"100\">差旅费</th>" +
						"<th width=\"100\">维修费</th>" +
						"<th width=\"100\">办公费</th>" +
						"<th width=\"100\">资产</th>" +
						"<th width=\"100\">培训费用</th>" +
						"<th width=\"150\">合计（RMB）：</th></tr>\r\n");
				
				//String quoteTotalAmount = "0.00";
				//quoteTotalAmount = String.format("%.2f", dbPurchase.getQuoteTotalAmount());
				String dyf = "";
				String dzyhp = "";
				String jbfy = "";
				String zdf = "";
				String cf = "";
				String gyfy = "";
				String swf = "";
				String clf = "";
				String wxf = "";
				String bgf = "";
				String zc = "";
				String pxfy = "";
				String customerTotal = "";
				
				NumberFormat nf = NumberFormat.getInstance();
				nf.setMaximumFractionDigits(2);
				nf.setMinimumFractionDigits(2);
				for(int i = 0; i < list.size(); i++){
					ReimbursementImpl reimbursement = list.get(i);
					if(reimbursement.getDyf() == 0.0){
						dyf = "-";
					}else{
						dyf = nf.format(reimbursement.getDyf());
					}
					
					if(reimbursement.getDzyhp() == 0.0){
						dzyhp = "-";
					}else{
						dzyhp = nf.format(reimbursement.getDzyhp());
					}
					
					if(reimbursement.getJbfy() == 0.0){
						jbfy = "-";
					}else{
						jbfy = nf.format(reimbursement.getJbfy());
					}
					
					if(reimbursement.getZdf() == 0.0){
						zdf = "-";
					}else{
						zdf = nf.format(reimbursement.getZdf());
					}
					
					if(reimbursement.getCf() == 0.0){
						cf = "-";
					}else{
						cf = nf.format(reimbursement.getCf());
					}
					
					if(reimbursement.getGyfy() == 0.0){
						gyfy = "-";
					}else{
						gyfy = nf.format(reimbursement.getGyfy());
					}
					
					if(reimbursement.getSwf() == 0.0){
						swf = "-";
					}else{
						swf = nf.format(reimbursement.getSwf());
					}
					
					if(reimbursement.getClf() == 0.0){
						clf = "-";
					}else{
						clf = nf.format(reimbursement.getClf());
					}
					
					if(reimbursement.getWxf() == 0.0){
						wxf = "-";
					}else{
						wxf = nf.format(reimbursement.getWxf());
					}
					
					if(reimbursement.getBgf() == 0.0){
						bgf = "-";
					}else{
						bgf = nf.format(reimbursement.getBgf());
					}
					
					if(reimbursement.getZc() == 0.0){
						zc = "-";
					}else{
						zc = nf.format(reimbursement.getZc());
					}
					
					if(reimbursement.getPxfy() == 0.0){
						pxfy = "-";
					}else{
						pxfy = nf.format(reimbursement.getPxfy());
					}
					
					
					if(reimbursement.getCustomerTotal() == 0.0){
						customerTotal = "-";
					}else{
						customerTotal = nf.format(reimbursement.getCustomerTotal());
					}
					
					sb.append("<tr><th style=\"text-align:left;\">" + reimbursement.getCustomerName() +
							"</th><td style=\"text-align:right;\">" + dyf + "</td><td style=\"text-align:right;\">" + dzyhp +
							"</td><td style=\"text-align:right;\">" + jbfy + "</td><td style=\"text-align:right;\">" + zdf +
							"</td><td style=\"text-align:right;\">" + cf + "</td><td style=\"text-align:right;\">" + gyfy +
							"</td><td style=\"text-align:right;\">" + swf + "</td><td style=\"text-align:right;\">" + clf +
							"</td><td style=\"text-align:right;\">" + wxf + "</td><td style=\"text-align:right;\">" + bgf +
							"</td><td style=\"text-align:right;\">" + zc + "</td><td style=\"text-align:right;\">" + pxfy +
							"</td><td style=\"text-align:right;\">" + customerTotal +
							"</tr>\r\n");
				}
				sb.append("</tbody>\r\n");
				sb.append("</table>\r\n");
				
				
				
				//部门报销统计报表
				sb.append("<br/><br/><br/><br/>");
				sb.append("<table class=\"mailtableh\" width=\"1550\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
				sb.append("<tbody>\r\n");
				sb.append("<tr><td colspan=\"14\"><h2>部门报销统计报表（" + from + "———" + to + "）</h2></td></tr>\r\n");
				sb.append("<tr><th width=\"150\" >部门 </th>" +
						"<th width=\"100\" >打印费</th>" +
						"<th width=\"100\">低值易耗品消耗</th>" +
						"<th width=\"100\">加班费用</th>" +
						"<th width=\"100\">招待费</th>" +
						"<th width=\"100\">车费</th>" +
						"<th width=\"100\">公寓费用</th>" +
						"<th width=\"100\">涉外费</th>" +
						"<th width=\"100\">差旅费</th>" +
						"<th width=\"100\">维修费</th>" +
						"<th width=\"100\">办公费</th>" +
						"<th width=\"100\">资产</th>" +
						"<th width=\"100\">培训费用</th>" +
						"<th width=\"150\">合计（RMB）：</th></tr>\r\n");
				
				//String quoteTotalAmount = "0.00";
				//quoteTotalAmount = String.format("%.2f", dbPurchase.getQuoteTotalAmount());
				String dyf1 = "";
				String dzyhp1 = "";
				String jbfy1 = "";
				String zdf1 = "";
				String cf1 = "";
				String gyfy1 = "";
				String swf1 = "";
				String clf1 = "";
				String wxf1 = "";
				String bgf1 = "";
				String zc1 = "";
				String pxfy1 = "";
				String divisionTotal = "";
				
				
				for(int i = 0; i < divisionList.size(); i++){
					ReimbursementImpl reimbursement = divisionList.get(i);
					if(reimbursement.getDyf() == 0.0){
						dyf1 = "-";
					}else{
						dyf1 = nf.format(reimbursement.getDyf());
					}
					
					if(reimbursement.getDzyhp() == 0.0){
						dzyhp1 = "-";
					}else{
						dzyhp1 = nf.format(reimbursement.getDzyhp());
					}
					
					if(reimbursement.getJbfy() == 0.0){
						jbfy1 = "-";
					}else{
						jbfy1 = nf.format(reimbursement.getJbfy());
					}
					
					if(reimbursement.getZdf() == 0.0){
						zdf1 = "-";
					}else{
						zdf1 = nf.format(reimbursement.getZdf());
					}
					
					if(reimbursement.getCf() == 0.0){
						cf1 = "-";
					}else{
						cf1 = nf.format(reimbursement.getCf());
					}
					
					if(reimbursement.getGyfy() == 0.0){
						gyfy1 = "-";
					}else{
						gyfy1 = nf.format(reimbursement.getGyfy());
					}
					
					if(reimbursement.getSwf() == 0.0){
						swf1 = "-";
					}else{
						swf1 = nf.format(reimbursement.getSwf());
					}
					
					if(reimbursement.getClf() == 0.0){
						clf1 = "-";
					}else{
						clf1 = nf.format(reimbursement.getClf());
					}
					
					if(reimbursement.getWxf() == 0.0){
						wxf1 = "-";
					}else{
						wxf1 = nf.format(reimbursement.getWxf());
					}
					
					if(reimbursement.getBgf() == 0.0){
						bgf1 = "-";
					}else{
						bgf1 = nf.format(reimbursement.getBgf());
					}
					
					if(reimbursement.getZc() == 0.0){
						zc1 = "-";
					}else{
						zc1 = nf.format(reimbursement.getZc());
					}
					
					if(reimbursement.getPxfy() == 0.0){
						pxfy1 = "-";
					}else{
						pxfy1 = nf.format(reimbursement.getPxfy());
					}
					
					
					if(reimbursement.getDivisionTotal() == 0.0){
						divisionTotal = "-";
					}else{
						divisionTotal = nf.format(reimbursement.getDivisionTotal());
					}
					
					sb.append("<tr><th style=\"text-align:left;\">" + reimbursement.getDivisionName() +
							"</th><td style=\"text-align:right;\">" + dyf1 + "</td><td style=\"text-align:right;\">" + dzyhp1 +
							"</td><td style=\"text-align:right;\">" + jbfy1 + "</td><td style=\"text-align:right;\">" + zdf1 +
							"</td><td style=\"text-align:right;\">" + cf1 + "</td><td style=\"text-align:right;\">" + gyfy1 +
							"</td><td style=\"text-align:right;\">" + swf1 + "</td><td style=\"text-align:right;\">" + clf1 +
							"</td><td style=\"text-align:right;\">" + wxf1 + "</td><td style=\"text-align:right;\">" + bgf1 +
							"</td><td style=\"text-align:right;\">" + zc1 + "</td><td style=\"text-align:right;\">" + pxfy1 +
							"</td><td style=\"text-align:right;\">" + divisionTotal +
							"</tr>\r\n");
				}
				sb.append("</tbody>\r\n");
				sb.append("</table>\r\n");
				
				
				
				//详细信息
				sb.append("<br/><br/><br/><br/>");
				sb.append("<table class=\"mailtableh\" width=\"1360\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
				sb.append("<tbody>\r\n");
				sb.append("<tr><td colspan=\"11\"><h2>详细报销统计报表</h2></td></tr>\r\n");
				sb.append("<tr><th width=\"100\" >申请部门 </th>" +
						"<th width=\"120\" >申请人</th>" +
						"<th width=\"120\">收款人</th>" +
						"<th width=\"120\">申请日期</th>" +
						"<th width=\"120\">审批日期</th>" +
						"<th width=\"150\">主类别</th>" +
						"<th width=\"150\">次类别</th>" +
						"<th width=\"300\">描述</th>" +
						"<th width=\"130\">费用部门</th>" +
						"<th width=\"120\">客户</th>" +
						"<th width=\"120\">金额</th>" +
						"</tr>\r\n");
				double totalAmount = 0.0;
				for(int i = 0; i < listForDivision.size(); i++){
					ReimbursementImpl reimbursementDetail = listForDivision.get(i);
					sb.append("<tr><td style=\"text-align:left;\">" + reimbursementDetail.getApplicantDivisionName() +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getApplicantName() +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getPayeeName() +
							"</td><td style=\"text-align:center;\">" + sdf.format(reimbursementDetail.getApplicantDivisionDate()) +
							"</td><td style=\"text-align:center;\">" + sdf.format(reimbursementDetail.getAuditDate()) +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getCategory1Name() +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getCategory2Name() + 
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getDescription() +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getDivisionName() +
							"</td><td style=\"text-align:left;\">" + reimbursementDetail.getCustomerName() +
							"</td><td style=\"text-align:right;\">" + nf.format(reimbursementDetail.getAmount()) +
							"</tr>\r\n");
					//总计金额
					totalAmount += reimbursementDetail.getAmount();
				}
				sb.append("<tr><td style=\"border:0px solid white\">" + "</td><td style=\"border:0px solid white\">" + 
						"</td><td style=\"border:0px solid white\">" + "</td><td style=\"border:0px solid white\">" +
						"</td><td style=\"border:0px solid white\">" + "</td><td style=\"border:0px solid white\">" +
						"</td><td style=\"border:0px solid white\">" +  "</td><td style=\"border:0px solid white\">" +
						"</td><td colspan=\"2\" style=\"text-align:right;\"><b>总计（RMB）：</b>" +
						"</td><td style=\"text-align:right;\">" + nf.format(totalAmount) + 
						"</tr>\r\n");
				sb.append("</tbody>\r\n");
				sb.append("</table>\r\n");
				
				sb.append(ConfigUtil.getMailBodyFooter());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			Mail mail = new Mail();
			//TODO
			//mail.setSubject("Reimbursement" + monthStr[calendar.get(Calendar.MONTH)] + "-" + year);
			mail.setSubject("Reimbursement" + monthStr[calendar.get(Calendar.MONTH)]);
			//mail address
			//String mailStr = "BillQi@ManchuTimesFashion.com";
			String mailStr = ConfigUtil.getMailReimbursementReportReceiver();
			
			mail.setTos(mailStr);
			//TODO
			mail.setContent(sb.toString());
			mail.setType(Mail.TYPE_REIMBURSEMENTREPORT);
			mail.setSubject("【采购报销报表统计"+ from + "—" + to +"】");
			this.mailService.addReimbursementReport(mail);
			
		}
		return true;
	}
	
	
}