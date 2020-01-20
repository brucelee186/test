package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.MailMapper;
import com.mtf.framework.dao.PurchaseItemMapper;
import com.mtf.framework.dao.ReimbursementGenMapper;
import com.mtf.framework.dao.ReimbursementItemMapper;
import com.mtf.framework.dao.ReimbursementMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.ReimbursementGen;
import com.mtf.framework.model.ReimbursementItem;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PurchaseItemImpl;
import com.mtf.framework.model.impl.ReimbursementImpl;
import com.mtf.framework.model.impl.ReimbursementItemImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.ReimbursementService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.UUIDUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 报销表
 * 作者:     Auto
 * 日期:     2015/3/16
**********************************************
*/
@Service("reimbursementService")
public class ReimbursementServiceImpl extends CommonServiceImpl implements ReimbursementService {
	private ReimbursementMapper			reimbursementMapper;
	private ReimbursementItemMapper		reimbursementItemMapper;
	private ReimbursementGenMapper		reimbursementGenMapper;
	private PurchaseItemMapper			purchaseItemMapper;
	private MailMapper					mailMapper;
	private UserMapper					userMapper;
	
	@Autowired
	private UserConditionMapper			userConditionMapper;


	@Autowired
	public UserConditionMapper getUserConditionMapper() {
		return userConditionMapper;
	}

	@Autowired
	public void setUserConditionMapper(UserConditionMapper userConditionMapper) {
		this.userConditionMapper = userConditionMapper;
	}

	@Autowired
	public void setReimbursementMapper(ReimbursementMapper reimbursementMapper) {
		this.reimbursementMapper = reimbursementMapper;
	}
	
	@Autowired
	public void setReimbursementItemMapper(ReimbursementItemMapper reimbursementItemMapper) {
		this.reimbursementItemMapper = reimbursementItemMapper;
	}

	@Autowired
	public void setReimbursementGenMapper(ReimbursementGenMapper reimbursementGenMapper) {
		this.reimbursementGenMapper = reimbursementGenMapper;
	}
	
	@Autowired
	public void setPurchaseItemMapper(PurchaseItemMapper purchaseItemMapper) {
		this.purchaseItemMapper = purchaseItemMapper;
	}
	
	@Autowired
	public void setMailMapper(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	/**
	 * 新增实体对象
	 * @param reimbursement
	 */
	public ReimbursementImpl insert(ReimbursementImpl reimbursement, List<ReimbursementItemImpl> itemList, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}
		
		String uuid = UUIDUtils.genUUID();
		
		Date now = new Date();
		reimbursement.setId(uuid);
		reimbursement.setNo(genReimbursementNo(session));
		reimbursement.setApplicantId(sessionInfo.getUserId());
		reimbursement.setApplicantName(sessionInfo.getDisplayName());
		reimbursement.setApplicantDivisionDate(now);
		reimbursement.setApplicantDivisionId(reimbursement.getApplicantDivisionId());
		reimbursement.setApplicantDivisionName(reimbursement.getApplicantDivisionName());
		
		
		//double totalAmount = 0.0;
		for(int i = 0; i < itemList.size(); i++){
			ReimbursementItemImpl item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setReimbursementId(uuid);
			//totalAmount += item.getAmount();
			this.reimbursementItemMapper.insert(item);
			
		}
		//if(StringUtils.equals(reimbursement.getCurrencyId(), "1")){
		//	reimbursement.setActualTotalAmount(totalAmount);
		//}
		//reimbursement.setTotalAmount(totalAmount);
		reimbursement.setCreateUserId(sessionInfo.getUserId());
		reimbursement.setCreateUserName(sessionInfo.getDisplayName());
		reimbursement.setCreateDatetime(now);
		this.reimbursementMapper.insert(reimbursement);
		
		//检索reimbursement下item含有purchaseItemId信息改变其信息
		ReimbursementItemImpl reimbursementItemParam = new ReimbursementItemImpl();
		reimbursementItemParam.setReimbursementId(reimbursement.getId());
		List<ReimbursementItemImpl> ReimbursementItems = (List<ReimbursementItemImpl>)this.reimbursementItemMapper.select(reimbursementItemParam);
		for (ReimbursementItemImpl reimbursementItem : ReimbursementItems) {
			if(UUIDUtils.isValidUUID(reimbursementItem.getPurchaseItemId()) ){
				PurchaseItemImpl PurchaseItemParm = new PurchaseItemImpl();
				PurchaseItemParm.setId(reimbursementItem.getPurchaseItemId());
				PurchaseItemParm.setIsReimbursed(1);
				this.purchaseItemMapper.update(PurchaseItemParm);
				
			}
		}
		
		
		return reimbursement;
	}


	/**
	 * 更新实体对象
	 * @param reimbursement
	 */
	public ReimbursementImpl update(ReimbursementImpl reimbursement, List<ReimbursementItemImpl> itemList, HttpSession session) throws PmException {
		if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}
		
		ReimbursementImpl purchaseParam = new ReimbursementImpl();
		purchaseParam.setId(reimbursement.getId());
		ReimbursementImpl dbReimbursement = (ReimbursementImpl) this.reimbursementMapper.get(purchaseParam);
		//清空
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date now = new Date();
		
		dbReimbursement.setApplicantId(sessionInfo.getUserId());
		dbReimbursement.setApplicantName(sessionInfo.getDisplayName());
		dbReimbursement.setApplicantDivisionDate(now);
		dbReimbursement.setApplicantDivisionId(reimbursement.getApplicantDivisionId());
		dbReimbursement.setApplicantDivisionName(reimbursement.getApplicantDivisionName());
		dbReimbursement.setPayeeName(reimbursement.getPayeeName());
		dbReimbursement.setCurrencyId(reimbursement.getCurrencyId());
		
		dbReimbursement.setStatus(reimbursement.getStatus());
		
	
		//Delete
		ReimbursementItemImpl itemPram = new ReimbursementItemImpl();
		itemPram.setReimbursementId(dbReimbursement.getId());
		this.reimbursementItemMapper.deleteByReimbursementId(itemPram);
		//Insert
		double totalAmount = 0.0;
		for(int i = 0; i < itemList.size(); i++){
			ReimbursementItem item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setReimbursementId(dbReimbursement.getId());
			totalAmount += item.getAmount();
			this.reimbursementItemMapper.insert(item);
		}
		if(StringUtils.equals(reimbursement.getCurrencyId(), "1")){
			dbReimbursement.setActualTotalAmount(totalAmount);
		}
		dbReimbursement.setTotalAmount(totalAmount);
		//汇率相关字段插入
		dbReimbursement.setExchangeRate(reimbursement.getExchangeRate());
		dbReimbursement.setTotalRmbAmount(reimbursement.getTotalRmbAmount());
		dbReimbursement.setActualTotalAmount(reimbursement.getActualTotalAmount());
		
		dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
		dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
		dbReimbursement.setUpdateDatetime(now);
		this.reimbursementMapper.update(dbReimbursement);
		
		return reimbursement;
	}
	
	@Override
	public boolean updateStatusForSubmit(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		boolean result = true;
		
		if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}else if(UUIDUtils.isValidUUID(reimbursement.getId()) == false){
			throw new PmException("Paramater 'id' is invalid!");
		}
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		
		Date now = new Date();
		ReimbursementImpl reimbursementParam = new ReimbursementImpl();
		reimbursementParam.setId(reimbursement.getId());
		ReimbursementImpl dbReimbursement = (ReimbursementImpl)this.reimbursementMapper.get(reimbursementParam);
		dbReimbursement.setApplicantDivisionDate(now);
		dbReimbursement.setStatus(ReimbursementImpl.STATUS_SUBMIT);
		dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
		dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
		dbReimbursement.setUpdateDatetime(now);
		
		this.reimbursementMapper.update(dbReimbursement);
		
		
		//检索reimbursement下item含有purchaseItemId信息改变其信息
		ReimbursementItemImpl reimbursementItemParam = new ReimbursementItemImpl();
		reimbursementItemParam.setReimbursementId(reimbursement.getId());
		List<ReimbursementItemImpl> ReimbursementItems = (List<ReimbursementItemImpl>)this.reimbursementItemMapper.select(reimbursementItemParam);
		for (ReimbursementItemImpl reimbursementItem : ReimbursementItems) {
			if(UUIDUtils.isValidUUID(reimbursementItem.getPurchaseItemId()) ){
				PurchaseItemImpl PurchaseItemParm = new PurchaseItemImpl();
				PurchaseItemParm.setId(reimbursementItem.getPurchaseItemId());
				PurchaseItemParm.setIsReimbursed(1);
				this.purchaseItemMapper.update(PurchaseItemParm);
			}
		}
		
		return result;
	}
	
	@Override
	public boolean updateStatusForDelete(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		boolean result = true;
		
		if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}else if(UUIDUtils.isValidUUID(reimbursement.getId()) == false){
			throw new PmException("Paramater 'id' is invalid!");
		}
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		
		Date now = new Date();
		ReimbursementImpl reimbursementParam = new ReimbursementImpl();
		reimbursementParam.setId(reimbursement.getId());
		ReimbursementImpl dbReimbursement = (ReimbursementImpl)this.reimbursementMapper.get(reimbursementParam);
		
		dbReimbursement.setStatus(ReimbursementImpl.STATUS_CANCEL);
		dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
		dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
		dbReimbursement.setUpdateDatetime(now);
		
		this.reimbursementMapper.update(dbReimbursement);
		
		return result;
	}
	
	@Override
	public boolean updateStatusForReject(ReimbursementImpl reimbursement, HttpSession session) throws PmException {
		boolean result = true;
		
		if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}else if(UUIDUtils.isValidUUID(reimbursement.getId()) == false){
			throw new PmException("Paramater 'id' is invalid!");
		}
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		
		Date now = new Date();
		ReimbursementImpl reimbursementParam = new ReimbursementImpl();
		reimbursementParam.setId(reimbursement.getId());
		ReimbursementImpl dbReimbursement = (ReimbursementImpl)this.reimbursementMapper.get(reimbursementParam);
		
		dbReimbursement.setStatus(ReimbursementImpl.STATUS_AUDITFAIL);
		dbReimbursement.setAuditorId(sessionInfo.getUserId());
		dbReimbursement.setAuditorName(sessionInfo.getDisplayName());
		dbReimbursement.setAuditDate(now);
		
		dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
		dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
		dbReimbursement.setUpdateDatetime(now);
		
		this.reimbursementMapper.update(dbReimbursement);
		
		if(NumberUtils.compare(dbReimbursement.getStatus(), ReimbursementImpl.STATUS_AUDITFAIL)){
			//增加邮件方法
			sendMailForReject(dbReimbursement);
		}
		
		return result;
	}
	
	@Override
	public boolean updateBatchStatusForReject(List<String> ids, HttpSession session) throws PmException {
		boolean result = true;
		for (String reimbursememtId : ids) {
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			
			Date now = new Date();
			ReimbursementImpl reimbursementParam = new ReimbursementImpl();
			reimbursementParam.setId(reimbursememtId);
			ReimbursementImpl dbReimbursement = (ReimbursementImpl)this.reimbursementMapper.get(reimbursementParam);
			
			dbReimbursement.setStatus(ReimbursementImpl.STATUS_AUDITFAIL);
			
			//增加汇率
			//dbReimbursement.setTotalAmount(reimbursement.getTotalAmount());
			dbReimbursement.setExchangeRate(0.0);
			dbReimbursement.setTotalRmbAmount(0.0);
			dbReimbursement.setActualTotalAmount(0.0);
			
			dbReimbursement.setAuditorId(sessionInfo.getUserId());
			dbReimbursement.setAuditorName(sessionInfo.getDisplayName());
			dbReimbursement.setAuditDate(now);
			
			dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
			dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
			dbReimbursement.setUpdateDatetime(now);
			
			this.reimbursementMapper.update(dbReimbursement);
			
			if(NumberUtils.compare(dbReimbursement.getStatus(), ReimbursementImpl.STATUS_AUDITFAIL)){
				//增加邮件方法
				sendMailForReject(dbReimbursement);
			}
		}
		
		return result;
	}
	
	
	@Override
	public boolean updateForAudit(ReimbursementImpl reimbursement, List<String> idsList, HttpSession session) throws PmException {
		boolean result = true;
		
		/*if(reimbursement == null){
			throw new PmException("Paramater is invalid!");
		}else if(UUIDUtils.isValidUUID(reimbursement.getId()) == false){
			throw new PmException("Paramater 'id' is invalid!");
		}*/
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		for(String reimbursementId :idsList){
			Date now = new Date();
			ReimbursementImpl reimbursementParam = new ReimbursementImpl();
			reimbursementParam.setId(reimbursementId);
			ReimbursementImpl dbReimbursement = (ReimbursementImpl)this.reimbursementMapper.get(reimbursementParam);
			dbReimbursement.setStatus(ReimbursementImpl.STATUS_AUDITPASS);
			
			//增加汇率
			//dbReimbursement.setTotalAmount(reimbursement.getTotalAmount());
			dbReimbursement.setExchangeRate(reimbursement.getExchangeRate());
			dbReimbursement.setTotalRmbAmount(reimbursement.getTotalRmbAmount());
			dbReimbursement.setActualTotalAmount(reimbursement.getActualTotalAmount());
			
			dbReimbursement.setSignerId(reimbursement.getSignerId());
			dbReimbursement.setSignerName(reimbursement.getSignerName());
			
			dbReimbursement.setAuditorId(sessionInfo.getUserId());
			dbReimbursement.setAuditorName(sessionInfo.getDisplayName());
			dbReimbursement.setAuditDate(now);
			
			dbReimbursement.setUpdateUserId(sessionInfo.getUserId());
			dbReimbursement.setUpdateUserName(sessionInfo.getDisplayName());
			dbReimbursement.setUpdateDatetime(now);
			
			this.reimbursementMapper.update(dbReimbursement);
		}
		
		return result;
	}
	/**
	 * 查询单个实体
	 * @param reimbursement
	 */
	public ReimbursementImpl get(ReimbursementImpl reimbursement) throws PmException {
		return (ReimbursementImpl) this.reimbursementMapper.get(reimbursement);
	}
	/**
	 * 查询实体列表
	 * @param purchase
	 */
	@SuppressWarnings("unchecked")
	public DataGrid<ReimbursementImpl> selectWithItem(ReimbursementImpl reimbursement, String statuses, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<ReimbursementImpl> result = new DataGrid<ReimbursementImpl>();
		
		String[] statusesArr = null;
		if(statuses != null ){
			statusesArr = statuses.split(",");
		}
		
		List<ReimbursementImpl> rList = (List<ReimbursementImpl>)this.reimbursementMapper.selectWithItem(reimbursement, statusesArr);
		List<ReimbursementImpl> rList1 = (List<ReimbursementImpl>)this.reimbursementMapper.selectByStatuses(reimbursement, statusesArr);
		if (rList1 != null && rList1.size() > 0) {
			result.setRows(rList);
			result.setTotal(rList1.size());
		}
		
		return result;
	}
	
	/**
	 * 查询实体列表
	 * @param purchase
	 */
	public DataGrid<ReimbursementImpl> selectForReport(ReimbursementImpl reimbursement, String categoryIds, String applicantDivisionIds, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<ReimbursementImpl> result = new DataGrid<ReimbursementImpl>();
		//reimbursement.setUserId(sessionInfo.getUserId());
		
		/*String[] statusesArr = null;
		if(statuses != null ){
			statusesArr = statuses.split(",");
		}*/
		
		String[] categoryIdsArr = null;
		if(categoryIds != null ){
			categoryIdsArr = categoryIds.split(",");
		}
		
		String[] applicantDivisionIdsArr = null;
		if(applicantDivisionIds != null ){
			applicantDivisionIdsArr = applicantDivisionIds.split(",");
		}
		
		
		List<ReimbursementImpl> rList = (List<ReimbursementImpl>)this.reimbursementMapper.selectForReport(reimbursement, categoryIdsArr, applicantDivisionIdsArr);
		if (rList != null && rList.size() > 0) {
			result.setRows(rList);
		}
		
		double sumTatalAmount = 0.0;
		for(ReimbursementImpl rbs : rList){
			sumTatalAmount += rbs.getSumTotalAmount();
		}
		
		Map<String,String> reimbursementMap = new HashMap<String, String>();
		reimbursementMap.put("category2Name", "<b>合计：</b>");
		reimbursementMap.put("sumTotalAmount", sumTatalAmount + "");
		
		List<Map<String,String>> reimbursementlist = new ArrayList<Map<String,String>>();
		reimbursementlist.add(reimbursementMap);
		
		result.setRows(rList);
		result.setTotal(rList.size());
		result.setFooter(reimbursementlist);
		return result;
	}
	
	
	@Override
	public List<ReimbursementImpl> selectForCustomerReport(ReimbursementImpl reimbursement) throws PmException {
		List<ReimbursementImpl> list = this.reimbursementMapper.selectForWeekReportByCustomer(reimbursement);
		if (list == null) {
			list = new ArrayList<ReimbursementImpl>();
		}
		return list;
	}
	
	@Override
	public List<ReimbursementImpl> selectForDivisionReport(ReimbursementImpl reimbursement) throws PmException {
		List<ReimbursementImpl> list = this.reimbursementMapper.selectForWeekReportByDivision(reimbursement);
		if (list == null) {
			list = new ArrayList<ReimbursementImpl>();
		}
		return list;
	}
	
	@Override
	public List<ReimbursementImpl> selectForDetail(ReimbursementImpl reimbursement) throws PmException {
		List<ReimbursementImpl> list = this.reimbursementMapper.selectForDetail(reimbursement);
		if (list == null) {
			list = new ArrayList<ReimbursementImpl>();
		}
		return list;
	}
	

	private void addMail(Mail mail) throws PmException{
		// mail bean
		mail.setId(UUIDUtils.genUUID());
		mail.setType(Mail.TYPE_REIMBURSEMENT);
		mail.setPriority(Mail.PRIORITY_NORMAL);
		mail.setIsHtml(1);
		mail.setStatus(Mail.STATUS_WAITTING);
		mail.setRetry(0);
		mail.setCreateDateTime(new Date());
		mail.setSubject("【报销单提醒】");
		
		this.mailMapper.insert(mail);
	}
	
	private int genReimbursementNo(HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date date = new Date();
		long tick = date.getTime();
		
		ReimbursementGen reimbursementGen = new ReimbursementGen();
		reimbursementGen.setTick(tick);
		reimbursementGen.setUserId(sessionInfo.getUserId());
		reimbursementGen.setUserName(sessionInfo.getDisplayName());
		reimbursementGen.setDateTime(date);
		
		
		this.reimbursementGenMapper.insert(reimbursementGen);
		int number = this.reimbursementGenMapper.selectNumber(reimbursementGen);
		
		return number;
	}

	private void sendMailForReject(ReimbursementImpl dbReimbursement) throws PmException{
		Mail mailParam = new Mail();
		UserImpl userParam = new UserImpl();
		userParam.setId(dbReimbursement.getApplicantId());
		UserImpl user = (UserImpl)this.userConditionMapper.getForEmail(userParam);
		
		mailParam.setTos(user.getEmail());
		//System.out.println(user.getEmail());
		//mailParam.setContent("<html><head></head><body><h1>你有一条报销信息没通过！</h1></body></html>");
		StringBuffer sb = new StringBuffer();
		sb.append(ConfigUtil.getMailBodyHeader());
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><td colspan=\"6\"><h2>审核未通过的报销列表</h2></td></tr>\r\n");
		sb.append("<tr><th width=\"100\" >报销号</th><th width=\"250\">申请部门</th><th width=\"240\">申请人</th><th width=\"210\">申请日期</th><th width=\"150\">总金额</th><th width=\"50\">币种</th></tr>\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String totalAmount = "0.00";
		String currencyName ="";
		if(dbReimbursement.getTotalAmount() != null){
			totalAmount =String.format("%.2f", dbReimbursement.getTotalAmount());
		}
		if(StringUtils.isBlank(dbReimbursement.getCurrencyId()) == false){
			if(StringUtils.equals(dbReimbursement.getCurrencyId(), "1")){
				currencyName = "RMB";
			}else if(StringUtils.equals(dbReimbursement.getCurrencyId(), "2")){
				currencyName = "USD";
			}
		}
		sb.append("<tr><td style=\"text-align:center;\">" + dbReimbursement.getNo() + "</td><td style=\"text-align:center;\">" + dbReimbursement.getApplicantDivisionName() + "</td><td style=\"text-align:center;\">" + dbReimbursement.getApplicantName() + "</td><td style=\"text-align:center;\">" + sdf.format(dbReimbursement.getApplicantDivisionDate())+ "</td><td style=\"text-align:right;\">" + totalAmount + "</td><td style=\"text-align:center;\">" + currencyName + "</td></tr>\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><th width=\"100\">部门</th><th width=\"120\">客户</th><th width=\"130\">主类别</th><th width=\"130\">次类别</th><th width=\"380\">描述</th><th width=\"140\">金额</th></tr>\r\n");
		
		ReimbursementItemImpl ReimbursementItemParam = new ReimbursementItemImpl();
		ReimbursementItemParam.setReimbursementId(dbReimbursement.getId());
		
		List<ReimbursementItemImpl> items = (List<ReimbursementItemImpl>)this.reimbursementItemMapper.select(ReimbursementItemParam);
		for(int i = 0; i < items.size(); i++){
			ReimbursementItemImpl item = items.get(i);
			String customerName = "";
			String quoteAmount = "0.00";
			if(StringUtils.isBlank(item.getCustomerName()) == false){
				customerName = item.getCustomerName();
			}
			if(item.getAmount() != null){
				quoteAmount =String.format("%.2f", item.getAmount());
			}
			sb.append("<tr><td width=\"100\" style=\"text-align:left;\">" + item.getDivisionName() + "</td><td width=\"120\" style=\"text-align:left;\">" + customerName + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory1Name() + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory2Name() + "</td><td width=\"380\" style=\"text-align:left;\">" + item.getDescription()+ "</td><td width=\"140\" style=\"text-align:right;\">" + quoteAmount + "</td></tr>\r\n");
		}
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		sb.append(ConfigUtil.getMailBodyFooter());
		
		mailParam.setContent(sb.toString());
		
		//增加邮件
		addMail(mailParam);
	}

}