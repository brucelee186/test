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
import com.mtf.framework.dao.PermissionConditionMapper;
import com.mtf.framework.dao.PurchaseCommentMapper;
import com.mtf.framework.dao.PurchaseGenMapper;
import com.mtf.framework.dao.PurchaseItemMapper;
import com.mtf.framework.dao.PurchaseMapper;
import com.mtf.framework.dao.PurchaseWatcherMapper;
import com.mtf.framework.dao.UserConditionMapper;
import com.mtf.framework.dao.UserMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Mail;
import com.mtf.framework.model.PurchaseComment;
import com.mtf.framework.model.PurchaseGen;
import com.mtf.framework.model.PurchaseItem;
import com.mtf.framework.model.User;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.PermissionImpl;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.PurchaseItemImpl;
import com.mtf.framework.model.impl.PurchaseWatcherImpl;
import com.mtf.framework.model.impl.UserImpl;
import com.mtf.framework.service.PurchaseService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.util.ConfigUtil;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.NumberUtils;
import com.mtf.framework.util.UUIDUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 采购表
 * 作者:     Auto
 * 日期:     2015/3/5
**********************************************
*/
@Service("purchaseService")
public class PurchaseServiceImpl extends CommonServiceImpl implements PurchaseService {
	private PurchaseMapper				purchaseMapper;
	private PurchaseItemMapper			purchaseItemMapper;
	private PurchaseGenMapper			purchaseGenMapper;
	private PurchaseCommentMapper		purchaseCommentMapper;
	private PurchaseWatcherMapper		purchaseWatcherMapper;
	private MailMapper					mailMapper;
	private UserMapper					userMapper;
	private UserConditionMapper			userConditionMapper;
	private PermissionConditionMapper	permissionConditionMapper;
	
	
	@Autowired
	public void setPurchaseMapper(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}
	@Autowired
	public void setPurchaseItemMapper(PurchaseItemMapper purchaseItemMapper) {
		this.purchaseItemMapper = purchaseItemMapper;
	}
	
	@Autowired
	public void setPurchaseGenMapper(PurchaseGenMapper purchaseGenMapper) {
		this.purchaseGenMapper = purchaseGenMapper;
	}
	
	@Autowired
	public void setPurchaseCommentMapper(PurchaseCommentMapper purchaseCommentMapper) {
		this.purchaseCommentMapper = purchaseCommentMapper;
	}
	
	@Autowired
	public void setPurchaseWatcherMapper(PurchaseWatcherMapper purchaseWatcherMapper) {
		this.purchaseWatcherMapper = purchaseWatcherMapper;
	}
	
	@Autowired
	public void setMailMapper(MailMapper mailMapper) {
		this.mailMapper = mailMapper;
	}
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}
	
	@Autowired
	public void setUserConditionMapper(UserConditionMapper userConditionMapper) {
		this.userConditionMapper = userConditionMapper;
	}
	
	@Autowired
	public void setPermissionConditionMapper(PermissionConditionMapper permissionConditionMapper) {
		this.permissionConditionMapper = permissionConditionMapper;
	}
	
	public PurchaseImpl get(PurchaseImpl purchase) throws PmException{
		return (PurchaseImpl)this.purchaseMapper.get(purchase);
	}
	
	public PurchaseImpl insert(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}
		
		String uuid = UUIDUtils.genUUID();
		
		Date now = new Date();
		purchase.setId(uuid);
		purchase.setNo(genPurchaseNo(session));
		purchase.setApplicantId(sessionInfo.getUserId());
		purchase.setApplicantName(sessionInfo.getDisplayName());
		purchase.setApplicantDatetime(now);
		
		purchase.setCreateUserId(sessionInfo.getUserId());
		purchase.setCreateUserName(sessionInfo.getDisplayName());
		purchase.setCreateDatetime(now);
		//放在最后
		//this.purchaseMapper.insert(purchase);
		
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setPurchaseId(uuid);
			item.setIsPurchased(0);
			item.setIsReimbursed(0);
			this.purchaseItemMapper.insert(item);
		}
		
		genComment(purchase, null, session);
		
		//增加邮件方法
		if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
			//1.确定申请审批人
			purchase = applicationHandling(purchase, itemList);
			//2.发送邮件
			sendMailForApp(purchase.getMailAddress(), purchase, itemList);
		}
		//最后插入
		this.purchaseMapper.insert(purchase);
		
		return purchase;
	}
	
	
	public PurchaseImpl insertForQuote(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}
		
		String uuid = UUIDUtils.genUUID();
		
		Date now = new Date();
		purchase.setId(uuid);
		purchase.setNo(genPurchaseNo(session));
		purchase.setApplicantId(sessionInfo.getUserId());
		purchase.setApplicantName(sessionInfo.getDisplayName());
		purchase.setApplicantDatetime(now);
		
		purchase.setIsQuoted(1);
		purchase.setCreateUserId(sessionInfo.getUserId());
		purchase.setCreateUserName(sessionInfo.getDisplayName());
		purchase.setCreateDatetime(now);
		//放在最后
		//this.purchaseMapper.insert(purchase);
		double quoteTotalAmount = 0.0;
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setPurchaseId(uuid);
			item.setIsPurchased(0);
			item.setIsReimbursed(0);
			quoteTotalAmount += item.getQuoteAmount();
			this.purchaseItemMapper.insert(item);
		}
		
		purchase.setQuoteTotalAmount(quoteTotalAmount);
		purchase.setQuoteCurrencyId(purchase.getQuoteCurrencyId());
		purchase.setQuoteUserId(sessionInfo.getUserId());
		purchase.setQuoteUserName(sessionInfo.getDisplayName());
		purchase.setQuoteDatetime(now);
		
		genComment(purchase, null, session);
		
		//增加邮件方法
		if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
			//1.确定采购审批人
			purchase = quoteHandling(purchase, itemList);
			//2.添加邮件
			sendMailForPur(purchase.getMailAddress(), purchase, itemList);
		}
		
		//最后插入
		this.purchaseMapper.insert(purchase);
		
		return purchase;
	}
	
	public PurchaseImpl update(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException {
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}
		
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		
		//驳回时清空
		dbPurchase.setApprovelV1UserId(null);
		dbPurchase.setApprovelv1UserName(null);
		dbPurchase.setApproveLv1UserDatetime(null);
		dbPurchase.setQuoteUserId(null);
		dbPurchase.setQuoteUserName(null);
		dbPurchase.setQuoteDatetime(null);
		dbPurchase.setSpecifiedlv1ApproveUserIds(null);
		dbPurchase.setSpecifiedlv1ApproveUserNames(null);
		dbPurchase.setSpecifiedlv2ApproveUserIds(null);
		dbPurchase.setSpecifiedlv2ApproveUserNames(null);
		dbPurchase.setApprovelV2UserId(null);
		dbPurchase.setApprovelv2UserName(null);
		dbPurchase.setApproveLv2UserDatetime(null);
		dbPurchase.setReqLevel(0);
		dbPurchase.setAppLevel(0);
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date now = new Date();
		
		dbPurchase.setApplicantId(sessionInfo.getUserId());
		dbPurchase.setApplicantName(sessionInfo.getDisplayName());
		dbPurchase.setApplicantDatetime(now);
		dbPurchase.setApplicantdivisionId(purchase.getApplicantdivisionId());
		dbPurchase.setApplicantdivisionName(purchase.getApplicantdivisionName());
		
		
		if(purchase.getStatus().equals(1) == false ){
			dbPurchase.setStatus(0);
		}else{
			dbPurchase.setStatus(1);
		}
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		//放在最后
		//this.purchaseMapper.update(dbPurchase);
		//Delete
		PurchaseItemImpl itemPram = new PurchaseItemImpl();
		itemPram.setPurchaseId(dbPurchase.getId());
		this.purchaseItemMapper.deleteByPurchaseId(itemPram);
		//Insert
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setPurchaseId(dbPurchase.getId());
			item.setIsPurchased(0);
			item.setIsReimbursed(0);
			this.purchaseItemMapper.insert(item);
		}
		genComment(purchase, null, session);
		
		//增加邮件方法
		if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
			//1.确定申请审批人
			dbPurchase = applicationHandling(dbPurchase, itemList);
			//2.发送邮件
			sendMailForApp(dbPurchase.getMailAddress(), dbPurchase, itemList);
			
		}
		this.purchaseMapper.update(dbPurchase);
		return dbPurchase;
	}
	
	public PurchaseImpl updateForQuote(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException {
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}
		
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		
		//驳回时清空
		dbPurchase.setSpecifiedlv1ApproveUserIds(null);
		dbPurchase.setSpecifiedlv1ApproveUserNames(null);
		dbPurchase.setSpecifiedlv2ApproveUserIds(null);
		dbPurchase.setSpecifiedlv2ApproveUserNames(null);
		dbPurchase.setApprovelV2UserId(null);
		dbPurchase.setApprovelv2UserName(null);
		dbPurchase.setApproveLv2UserDatetime(null);
		dbPurchase.setReqLevel(0);
		dbPurchase.setAppLevel(0);
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date now = new Date();
		
		dbPurchase.setApplicantId(sessionInfo.getUserId());
		dbPurchase.setApplicantName(sessionInfo.getDisplayName());
		dbPurchase.setApplicantDatetime(now);
		dbPurchase.setApplicantdivisionId(purchase.getApplicantdivisionId());
		dbPurchase.setApplicantdivisionName(purchase.getApplicantdivisionName());
		dbPurchase.setApplicantDatetime(now);
		
		if(purchase.getStatus().equals(3) == false ){
			dbPurchase.setStatus(0);
		}else{
			dbPurchase.setStatus(3);
		}
		
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		//放在最后
		//this.purchaseMapper.update(dbPurchase);
		//Delete
		PurchaseItemImpl itemPram = new PurchaseItemImpl();
		itemPram.setPurchaseId(dbPurchase.getId());
		this.purchaseItemMapper.deleteByPurchaseId(itemPram);
		//Insert
		double quoteTotalAmount = 0.0;
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			item.setId(UUIDUtils.genUUID());
			item.setPurchaseId(dbPurchase.getId());
			item.setIsPurchased(0);
			item.setIsReimbursed(0);
			quoteTotalAmount += item.getQuoteAmount();
			this.purchaseItemMapper.insert(item);
		}
		
		dbPurchase.setQuoteTotalAmount(quoteTotalAmount);
		dbPurchase.setQuoteCurrencyId(purchase.getQuoteCurrencyId());
		dbPurchase.setQuoteUserId(sessionInfo.getUserId());
		dbPurchase.setQuoteUserName(sessionInfo.getDisplayName());
		dbPurchase.setQuoteDatetime(now);
		
		genComment(purchase, null, session);
		
		if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
			//1.确定采购审批人
			dbPurchase = quoteHandling(dbPurchase, itemList);
			//2.添加邮件
			sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
		}
		
		this.purchaseMapper.update(dbPurchase);
		return dbPurchase;
	}
	
	public PurchaseImpl updateQuoteAmount(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}
		
		Date now = new Date();
		
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl)this.purchaseMapper.get(purchaseParam);
		
		PurchaseItemImpl PurchaseItemPram = new PurchaseItemImpl();
		PurchaseItemPram.setPurchaseId(purchase.getId());
		@SuppressWarnings("unchecked")
		List<PurchaseItem> dbPurchaseItemList = (List<PurchaseItem>)this.purchaseItemMapper.select(PurchaseItemPram);
		//相同就更新价格
		double quotetotalAmount = 0.0;
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl pui = itemList.get(i);
			for(int j = 0; j < dbPurchaseItemList.size(); j++){
				PurchaseItem dbPui = dbPurchaseItemList.get(j);
				if(dbPui.getId().equalsIgnoreCase(pui.getId()) ){
					dbPui.setQuoteAmount(pui.getQuoteAmount());
					quotetotalAmount += pui.getQuoteAmount();
					this.purchaseItemMapper.update(dbPui);
					break;
				}
			}
		}
		dbPurchase.setQuoteTotalAmount(quotetotalAmount);
		dbPurchase.setQuoteCurrencyId(purchase.getQuoteCurrencyId());
		dbPurchase.setTotalRmbAmount(purchase.getTotalRmbAmount());
		dbPurchase.setExchangeRate(purchase.getExchangeRate());
		
		dbPurchase.setQuoteUserId(sessionInfo.getUserId());
		dbPurchase.setQuoteUserName(sessionInfo.getDisplayName());
		dbPurchase.setQuoteDatetime(now);
		
		
		dbPurchase.setStatus(3);
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		//放在最后
		//this.purchaseMapper.update(dbPurchase);
			
		genComment(dbPurchase, null, session);
		
		if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
			//1.确定采购审批人
			dbPurchase = quoteHandling(dbPurchase, itemList);
			//2.添加邮件
			sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
		}
		this.purchaseMapper.update(dbPurchase);
		return dbPurchase;
	}

	
	
	@Override
	public boolean updateForStatus(PurchaseImpl purchase, HttpSession session) throws PmException {
		boolean result = true;
		
		if(purchase == null){
			throw new PmException("Paramater is invalid!");
		}else if(UUIDUtils.isValidUUID(purchase.getId()) == false){
			throw new PmException("Paramater 'id' is invalid!");
		}
		
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		Date now = new Date();
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		dbPurchase.setStatus(purchase.getStatus());
		List<PurchaseItemImpl> itemList = new ArrayList<>();
		PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
		
		if(purchase.getStatus() == PurchaseImpl.STATUS_COMPLETE){
			
			for (PurchaseItemImpl purchaseItem : itemList) {
				purchaseItem.setIsPurchased(1);
				purchaseItem.setPurchaseCompleteDate(now);
				this.purchaseItemMapper.update(purchaseItem);
			}
		}
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		
		//放在最后
		//this.purchaseMapper.update(dbPurchase);
		
		genComment(purchase, null, session);
		//增加邮件方法
		
		if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
			//修改更新日期
			dbPurchase.setApplicantDatetime(now);
			//1.确定申请审批人
			dbPurchase = applicationHandling(dbPurchase, itemList);
			//2.发送邮件
			sendMailForApp(dbPurchase.getMailAddress(), dbPurchase, itemList);
		}else if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
			//修改估值日期
			dbPurchase.setQuoteDatetime(now);
			//1.确定采购审批人
			dbPurchase = quoteHandling(dbPurchase, itemList);
			//2.发送邮件
			sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
		}
		
		this.purchaseMapper.update(dbPurchase);
		return result;
	}
	
	@Override
	public boolean updateBatchForStatus(PurchaseImpl purchase,  List<String> ids, HttpSession session) throws PmException {
		boolean result = true;
		for(String purchaseId : ids){
			if(purchase == null){
				throw new PmException("Paramater is invalid!");
			}
			if(UUIDUtils.isValidUUID(purchaseId) == false){
				throw new PmException("Paramater 'purchaseId' is invalid!");
			}
			
			SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			
			Date now = new Date();
			PurchaseImpl purchaseParam = new PurchaseImpl();
			purchaseParam.setId(purchaseId);
			PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
			dbPurchase.setStatus(purchase.getStatus());
			//完成操作没有多选
			/*if(purchase.getStatus() == PurchaseImpl.STATUS_COMPLETE){
				PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
				purchaseItemParam.setPurchaseId(purchaseId);
				List<PurchaseItemImpl> itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
				for (PurchaseItemImpl purchaseItem : itemList) {
					purchaseItem.setIsPurchased(1);
					purchaseItem.setPurchaseCompleteDate(now);
					this.purchaseItemMapper.update(purchaseItem);
				}
			}*/
			dbPurchase.setUpdateUserId(sessionInfo.getUserId());
			dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
			dbPurchase.setUpdateDatetime(now);
			
			PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
			purchaseItemParam.setPurchaseId(purchaseId);
			List<PurchaseItemImpl> itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
			
			//放在最后
			//this.purchaseMapper.update(dbPurchase);
			genComment(dbPurchase, null, session);
			//增加邮件方法
			if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
				//1.确定申请审批人
				purchase = applicationHandling(purchase, itemList);
				//2.发送邮件
				sendMailForApp(dbPurchase.getMailAddress(), dbPurchase, itemList);
			}
			
			this.purchaseMapper.update(dbPurchase);
		}
		
		
		return result;
	}
	
	@Override
	public boolean updateForStatusLv1(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		Date now = new Date();
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		//dbPurchase.setStatus(PurchaseImpl.STATUS_LV1);
		
		dbPurchase.setApprovelV1UserId(sessionInfo.getUserId());
		dbPurchase.setApprovelv1UserName(sessionInfo.getDisplayName());
		dbPurchase.setApproveLv1UserDatetime(now);
		
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		
		dbPurchase.setReqLevel(dbPurchase.getReqLevel()+1);
		
		//this.purchaseMapper.update(dbPurchase);
		PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		List<PurchaseItemImpl> itemList = new ArrayList<PurchaseItemImpl>();
		
		itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
		
		genComment(dbPurchase, comment, session);
		
		if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
			//1.确定采购审批人
			dbPurchase = lv1Handling(dbPurchase, itemList);
			//2.添加邮件
			if(NumberUtils.compare(dbPurchase.getStatus(),PurchaseImpl.STATUS_LV1) == false){
				sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
			}
		}
		this.purchaseMapper.update(dbPurchase);
		return result;
	}
	
	@Override
	public boolean updateBatchForStatusLv1(List<String> ids, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		for(String purchaseId : ids){
			Date now = new Date();
			PurchaseImpl purchaseParam = new PurchaseImpl();
			//purchaseParam.setId(purchase.getId());
			purchaseParam.setId(purchaseId);
			PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
			//dbPurchase.setStatus(PurchaseImpl.STATUS_LV1);
			
			dbPurchase.setApprovelV1UserId(sessionInfo.getUserId());
			dbPurchase.setApprovelv1UserName(sessionInfo.getDisplayName());
			dbPurchase.setApproveLv1UserDatetime(now);
			
			dbPurchase.setUpdateUserId(sessionInfo.getUserId());
			dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
			dbPurchase.setUpdateDatetime(now);
			
			dbPurchase.setReqLevel(dbPurchase.getReqLevel()+1);
			
			//this.purchaseMapper.update(dbPurchase);
			PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
			purchaseItemParam.setPurchaseId(purchaseId);
			List<PurchaseItemImpl> itemList = new ArrayList<PurchaseItemImpl>();
			
			itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
			
			genComment(dbPurchase, null, session);
			
			if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_SUBMIT)){
				//1.确定采购审批人
				dbPurchase = lv1Handling(dbPurchase, itemList);
				//2.添加邮件
				if(NumberUtils.compare(dbPurchase.getStatus(),PurchaseImpl.STATUS_LV1) == false){
					sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
				}
			}
			this.purchaseMapper.update(dbPurchase);
		}
		
		return result;
	}
	
	@Override
	public boolean updateForStatusLv2(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		Date now = new Date();
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		//dbPurchase.setStatus(PurchaseImpl.STATUS_LV2);
		String sessionUserId = sessionInfo.getUserId();
		dbPurchase.setApprovelV2UserId(sessionUserId);
		dbPurchase.setApprovelv2UserName(sessionInfo.getDisplayName());
		dbPurchase.setApproveLv2UserDatetime(now);
		
		dbPurchase.setUpdateUserId(sessionUserId);
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		
		dbPurchase.setAppLevel(dbPurchase.getAppLevel()+1);
		
		PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		List<PurchaseItemImpl> itemList = (List<PurchaseItemImpl>) this.purchaseItemMapper.select(purchaseItemParam);
		
		if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
			//1.确定采购审批人
			dbPurchase = lv2Handling(dbPurchase, itemList, sessionUserId);
			//2.添加邮件
			if(NumberUtils.compare(dbPurchase.getStatus(),PurchaseImpl.STATUS_LV2) == false){
				sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
			}
		}
		
		this.purchaseMapper.update(dbPurchase);
		
		genComment(dbPurchase, comment, session);
		
		return result;
	}
	
	@Override
	public boolean updateBatchForStatusLv2(List<String> ids, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		
		for(String purchaseId : ids){
			Date now = new Date();
			PurchaseImpl purchaseParam = new PurchaseImpl();
			purchaseParam.setId(purchaseId);
			PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
			//dbPurchase.setStatus(PurchaseImpl.STATUS_LV2);
			String sessionUserId = sessionInfo.getUserId();
			dbPurchase.setApprovelV2UserId(sessionUserId);
			dbPurchase.setApprovelv2UserName(sessionInfo.getDisplayName());
			dbPurchase.setApproveLv2UserDatetime(now);
			
			dbPurchase.setUpdateUserId(sessionUserId);
			dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
			dbPurchase.setUpdateDatetime(now);
			
			dbPurchase.setAppLevel(dbPurchase.getAppLevel()+1);
			
			PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
			purchaseItemParam.setPurchaseId(purchaseId);
			List<PurchaseItemImpl> itemList = (List<PurchaseItemImpl>) this.purchaseItemMapper.select(purchaseItemParam);
			
			if(NumberUtils.compare(dbPurchase.getStatus(), PurchaseImpl.STATUS_QUOTE)){
				//1.确定采购审批人
				dbPurchase = lv2Handling(dbPurchase, itemList, sessionUserId);
				//2.添加邮件
				if(NumberUtils.compare(dbPurchase.getStatus(),PurchaseImpl.STATUS_LV2) == false){
					sendMailForPur(dbPurchase.getMailAddress(), dbPurchase, itemList);
				}
			}
			
			this.purchaseMapper.update(dbPurchase);
			
			genComment(dbPurchase, null, session);
		}
		
		
		return result;
	}
	
	@Override
	public boolean updateForStatusReject(PurchaseImpl purchase, String comment, HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		Date now = new Date();
		PurchaseImpl purchaseParam = new PurchaseImpl();
		purchaseParam.setId(purchase.getId());
		PurchaseImpl dbPurchase = (PurchaseImpl) this.purchaseMapper.get(purchaseParam);
		dbPurchase.setStatus(PurchaseImpl.STATUS_REJECT);
		
		dbPurchase.setApprovelV2UserId(sessionInfo.getUserId());
		dbPurchase.setApprovelv2UserName(sessionInfo.getDisplayName());
		dbPurchase.setApproveLv2UserDatetime(now);
		
		dbPurchase.setUpdateUserId(sessionInfo.getUserId());
		dbPurchase.setUpdateUserName(sessionInfo.getDisplayName());
		dbPurchase.setUpdateDatetime(now);
		
		this.purchaseMapper.update(dbPurchase);
		
		genComment(dbPurchase, comment, session);
		
		if(NumberUtils.compare(purchase.getStatus(), PurchaseImpl.STATUS_REJECT)){
			//1.添加邮件
			sendMailForReject(dbPurchase);
		}
		return result;
	}
	
	
	/**
	 * 查询实体列表
	 * @param purchase
	 */
	@SuppressWarnings("unchecked")
	public List<PurchaseImpl> select(PurchaseImpl purchase) throws PmException {
		return (List<PurchaseImpl>) this.purchaseMapper.select(purchase);
	}
	/**
	 * 查询实体列表
	 * @param purchase
	 * @param statuses
	 * @param session
	 */
	public DataGrid<PurchaseImpl> selectWithItem(PurchaseImpl purchase, String statuses, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<PurchaseImpl> result = new DataGrid<PurchaseImpl>();
		int statusGroup = purchase.getStatusGroup();
		if(NumberUtils.compare(statusGroup, 3)){
			purchase.setSpecifiedlv2ApproveUserIds(sessionInfo.getUserId());
		}else if(NumberUtils.compare(statusGroup, 2)){
			purchase.setSpecifiedlv1ApproveUserIds(sessionInfo.getUserId());
		}else if(NumberUtils.compare(statusGroup, 4)){
			//本人的历史审批
			purchase.setApprovelV2UserId(sessionInfo.getUserId());
			purchase.setApprovelV1UserId(sessionInfo.getUserId());
			/*String code = ConfigUtil.getPermissionPurMaxCode();
			double amount = this.permissionConditionMapper.getAmountByCode(code);
			List<User> maxUserList = this.userConditionMapper.selectByCode(code, amount);
			if(maxUserList.isEmpty() == false){
				if(StringUtils.equals(maxUserList.get(0).getId(), sessionInfo.getUserId())){
					purchase.setQuoteTotalAmount(amount);
				}
			}*/
		}else if(NumberUtils.compare(statusGroup, 9)){
			String code = ConfigUtil.getPermissionPurMaxCode();
			double amount = this.permissionConditionMapper.getAmountByCode(code);
			purchase.setTotalRmbAmount(amount);
		}
		
		
		String[] statusesArr = null;
		if(statuses != null ){
			statusesArr = statuses.split(",");
		}
		
		String codes = ConfigUtil.getPermissionAdminCodes();
		String[] codesArr = codes.split(",");
		
		//行政审批
		List<String> categoryIdList = null;
		//String[] categoryIdArr = null;
		if(NumberUtils.compare(statusGroup, 5) || NumberUtils.compare(statusGroup, 6) || NumberUtils.compare(statusGroup, 7)){
			categoryIdList = this.userConditionMapper.selectCategoryIdByUserIdAndCodes(sessionInfo.getUserId(), codesArr);
			//categoryIdArr = (String[])categoryIdList.toArray(new String[categoryIdList.size()]);
		}
		//国内机票查看条件
		String category2Id = null;
		if(NumberUtils.compare(statusGroup, 9)){
			category2Id = ConfigUtil.getPermissionDomesticCategoryId();
		}
		
		List<PurchaseImpl> pList = (List<PurchaseImpl>)this.purchaseMapper.selectWithItem(purchase, statusesArr, categoryIdList, category2Id);
		if (pList != null && pList.size() > 0) {
			result.setRows(pList);
		}
		result.setRows(pList);
		result.setTotal(pList.size());
		return result;
	}
	
	/**
	 * 查询实体列表
	 * @param purchase
	 * @param statuses
	 * @param session
	 */
	public DataGrid<PurchaseImpl> selectForMyWatch(PurchaseImpl purchase,String statuses, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<PurchaseImpl> result = new DataGrid<PurchaseImpl>();
		purchase.setUserId(sessionInfo.getUserId());
		
		String[] statusesArr = null;
		if(statuses != null ){
			statusesArr = statuses.split(",");
		}
		
		List<PurchaseImpl> pList = (List<PurchaseImpl>)this.purchaseMapper.selectByUserId(purchase, statusesArr);
		if (pList != null && pList.size() > 0) {
			result.setRows(pList);
		}
		result.setRows(pList);
		result.setTotal(pList.size());
		return result;
	}
	
	/**
	 * 查询实体列表
	 * @param purchase
	 */
	public DataGrid<PurchaseImpl> selectForReport(PurchaseImpl purchase, String categoryIds, String applicantdivisionIds, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		DataGrid<PurchaseImpl> result = new DataGrid<PurchaseImpl>();
		purchase.setUserId(sessionInfo.getUserId());
		
		/*String[] statusesArr = null;
		if(statuses != null ){
			statusesArr = statuses.split(",");
		}*/
		
		String[] categoryIdsArr = null;
		if(categoryIds != null ){
			categoryIdsArr = categoryIds.split(",");
		}
		
		String[] applicantdivisionIdsArr = null;
		if(applicantdivisionIds != null ){
			applicantdivisionIdsArr = applicantdivisionIds.split(",");
		}
		
		
		List<PurchaseImpl> pList = (List<PurchaseImpl>)this.purchaseMapper.selectForReport(purchase, categoryIdsArr, applicantdivisionIdsArr);
		if (pList != null && pList.size() > 0) {
			result.setRows(pList);
		}
		
		double sumTatalAmount = 0.0;
		for(PurchaseImpl pur : pList){
			sumTatalAmount += pur.getTotalAmount();
		}
		
		Map<String,String> purchaseMap = new HashMap<String, String>();
		purchaseMap.put("category2Name", "<b>合计：</b>");
		
		purchaseMap.put("totalAmount", sumTatalAmount + "");
			
		List<Map<String,String>> purchaselist = new ArrayList<Map<String,String>>();
		purchaselist.add(purchaseMap);
		
		result.setRows(pList);
		result.setTotal(pList.size());
		result.setFooter(purchaselist);
		return result;
	}
	
	/**
	 * 新增实体对象
	 * @param idsList
	 * @param session
	 */
	public void insert(List<String> idsList, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		String userId = sessionInfo.getUserId();
		
		for(String purchaseId :idsList){
			PurchaseWatcherImpl purchaseWatcherParam = new PurchaseWatcherImpl();
			purchaseWatcherParam.setUserId(userId);
			purchaseWatcherParam.setPurchaseId(purchaseId);
			int count = this.purchaseWatcherMapper.count(purchaseWatcherParam);
			
			if(count == 0){
				purchaseWatcherParam.setId(UUIDUtils.genUUID());
				this.purchaseWatcherMapper.insert(purchaseWatcherParam);
			}
			
		}
	}

	/**
	 * 删除实体对象
	 * @param idsList
	 */
	public void delete(List<String> idsList) throws PmException{
		for(String purchaseId :idsList){
			PurchaseWatcherImpl PurchaseWatcherParam = new PurchaseWatcherImpl();
			PurchaseWatcherParam.setPurchaseId(purchaseId);
			
			this.purchaseWatcherMapper.deleteByPurchaseId(PurchaseWatcherParam);
		}
		
	}
	
	
	//公用方法
	private void addMail(Mail mail) throws PmException{
		// mail bean
		mail.setId(UUIDUtils.genUUID());
		mail.setType(Mail.TYPE_PURCHASE);
		mail.setPriority(Mail.PRIORITY_NORMAL);
		mail.setIsHtml(1);
		mail.setStatus(Mail.STATUS_WAITTING);
		mail.setRetry(0);
		mail.setCreateDateTime(new Date());
		//mail.setSubject("【申请采购单提醒】");
		this.mailMapper.insert(mail);
	}
	

	private int genPurchaseNo(HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date date = new Date();
		long tick = date.getTime();
		
		PurchaseGen purchaseGen = new PurchaseGen();
		purchaseGen.setTick(tick);
		purchaseGen.setUserId(sessionInfo.getUserId());
		purchaseGen.setUserName(sessionInfo.getDisplayName());
		purchaseGen.setDateTime(date);
		
		//int number = 0;
		this.purchaseGenMapper.insert(purchaseGen);
		int number = this.purchaseGenMapper.selectNumber(purchaseGen);
		
		return number;
	}
	
	private void genComment(PurchaseImpl purchase, String comment, HttpSession session){
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
	
		//comment
		//0 : 草稿，1：已提交， 2：申请审批完成， 3： 已估价， 4：采购审批完成， 5：已采购，6：采购完成,  8：拒绝， 9：取消
		String sysComment = "sysComment";
		PurchaseComment purchaseCommentParam = new PurchaseComment();
		int status = purchase.getStatus();
		
		if(comment == null){
			comment= "";
		}
		
		if(status == 0){
			sysComment = "【草稿】";
			purchaseCommentParam.setComment(sysComment);
		}else if(status == 1){
			sysComment = "【已提交】";
			purchaseCommentParam.setComment(sysComment + comment);
		}else if(status == 2){
			sysComment = "【申请审批完成】";
			purchaseCommentParam.setComment(sysComment + comment);
		}else if(status == 3){
			sysComment = "【已估价】";
			purchaseCommentParam.setComment(sysComment + comment);
		}else if(status == 4){
			sysComment = "【采购审批完成】";
			purchaseCommentParam.setComment(sysComment + comment);
		}else if(status == 5){
			sysComment = "【已采购】";
			purchaseCommentParam.setComment(sysComment);
		}else if(status == 6){
			sysComment = "【采购完成】";
			purchaseCommentParam.setComment(sysComment);
		}else if(status == 8){
			sysComment = "【拒绝】";
			purchaseCommentParam.setComment(sysComment + comment);
		}else if(status == 9){
			sysComment = "【取消】";
			purchaseCommentParam.setComment(sysComment);
		}
		purchaseCommentParam.setId(UUIDUtils.genUUID());
		purchaseCommentParam.setPurchaseId(purchase.getId());
		purchaseCommentParam.setCreateUserId(sessionInfo.getUserId());
		purchaseCommentParam.setCreateUserName(sessionInfo.getDisplayName());
		purchaseCommentParam.setCreateDatetime(new Date());
		
		this.purchaseCommentMapper.insert(purchaseCommentParam);
	}
	
	private void sendMailForApp(String mailSbStr, PurchaseImpl purchase, List<PurchaseItemImpl> itemList) throws PmException{
		Mail mailParam = new Mail();
		mailParam.setTos(mailSbStr);
		//
		StringBuffer sb = new StringBuffer();
		sb.append(ConfigUtil.getMailBodyHeader());
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><td colspan=\"4\"><h2>申请审批列表</h2></td></tr>\r\n");
		sb.append("<tr><th width=\"100\" >采购号</th><th width=\"250\">申请部门</th><th width=\"240\">申请人</th><th width=\"217\">申请日期</th></tr>\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		sb.append("<tr><td style=\"text-align:center;\">" + purchase.getNo() + "</td><td style=\"text-align:center;\">" + purchase.getApplicantdivisionName() + "</td><td style=\"text-align:center;\">" + purchase.getApplicantName() + "</td><td style=\"text-align:center;\">" + sdf.format(purchase.getApplicantDatetime())  + "</td></tr>\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><th width=\"150\">部门</th><th width=\"100\">客户</th><th width=\"100\">主类别</th><th width=\"100\">次类别</th><th width=\"357\">描述</th></tr>\r\n");
		
	
		for(int i = 0; i < itemList.size(); i++){
			PurchaseItemImpl item = itemList.get(i);
			String customerName = "";
			if(StringUtils.isBlank(item.getCustomerName()) == false){
				customerName = item.getCustomerName();
			}
			sb.append("<tr><td width=\"150\" style=\"text-align:left;\">" + item.getDivisionName() + "</td><td width=\"100\" style=\"text-align:left;\">" + customerName + "</td><td width=\"100\" style=\"text-align:left;\">" + item.getCategory1Name() + "</td><td width=\"100\" style=\"text-align:left;\">" + item.getCategory2Name() + "</td><td width=\"357\" style=\"text-align:left;\">" + item.getDescription() + "</td></tr>\r\n");
		}
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		sb.append(ConfigUtil.getMailBodyFooter());
		
		mailParam.setContent(sb.toString());
		
		mailParam.setSubject("【申请单提醒】");
		//增加邮件
		addMail(mailParam);
	}
	
	private void sendMailForPur(String mailSbStr, PurchaseImpl dbPurchase, List<PurchaseItemImpl> itemList) throws PmException{
		Mail mailParam = new Mail();
		mailParam.setTos(mailSbStr);
		
		//TODO
		if(StringUtils.equals(mailSbStr, "LiuXiMing@ManchuTimesFashion.com")){
			//mailParam.setTos("BillQi@ManchuTimesFashion.com");
			mailParam.setTos("JoeZhou@ManchuTimesFashion.com");
		}
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConfigUtil.getMailBodyHeader());
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><td colspan=\"6\"><h2>采购审批列表</h2></td></tr>\r\n");
		sb.append("<tr><th width=\"100\" >采购号</th><th width=\"250\">申请部门</th><th width=\"240\">申请人</th><th width=\"210\">申请日期</th><th width=\"150\">估算总金额</th><th width=\"50\">币种</th></tr>\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String currencyName ="";
		if(StringUtils.isBlank(dbPurchase.getQuoteCurrencyId()) == false){
			if(StringUtils.equals(dbPurchase.getQuoteCurrencyId(), "1")){
				currencyName = "RMB";
			}else if(StringUtils.equals(dbPurchase.getQuoteCurrencyId(), "2")){
				currencyName = "USD";
			}
		}
		String quoteTotalAmount = "0.00";
		quoteTotalAmount = String.format("%.2f", dbPurchase.getQuoteTotalAmount());
		
		sb.append("<tr><td style=\"text-align:center;\">" + dbPurchase.getNo() + "</td><td style=\"text-align:center;\">" + dbPurchase.getApplicantdivisionName() + "</td><td style=\"text-align:center;\">" + dbPurchase.getApplicantName() + "</td><td style=\"text-align:center;\">" + sdf.format(dbPurchase.getApplicantDatetime())+ "</td><td style=\"text-align:right;\">" + quoteTotalAmount  + "</td><td style=\"text-align:center;\">" + currencyName + "</td></tr>\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><th width=\"100\">部门</th><th width=\"120\">客户</th><th width=\"130\">主类别</th><th width=\"130\">次类别</th><th width=\"380\">描述</th><th width=\"140\">估算金额</th></tr>\r\n");
		
		PurchaseItemImpl purchaseItemParam1 = new PurchaseItemImpl();
		purchaseItemParam1.setPurchaseId(dbPurchase.getId());
		
		List<PurchaseItemImpl> items = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam1);
		for(int i = 0; i < items.size(); i++){
			PurchaseItemImpl item = items.get(i);
			String customerName = "";
			String quoteAmount = "0.00";
			if(StringUtils.isBlank(item.getCustomerName()) == false){
				customerName = item.getCustomerName();
			}
			if(item.getQuoteAmount() != null){
				quoteAmount =String.format("%.2f", item.getQuoteAmount());
			} 
			item.getQuoteAmount();
			sb.append("<tr><td width=\"100\" style=\"text-align:left;\">" + item.getDivisionName() + "</td><td width=\"120\" style=\"text-align:left;\">" + customerName + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory1Name() + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory2Name() + "</td><td width=\"380\" style=\"text-align:left;\">" + item.getDescription()+ "</td><td width=\"140\" style=\"text-align:right;\">" + quoteAmount + "</td></tr>\r\n");
		}
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		sb.append(ConfigUtil.getMailBodyFooter());
		
		mailParam.setContent(sb.toString());
		
		mailParam.setSubject("【采购单提醒】");
		//增加邮件
		addMail(mailParam);
	}
	
	private void sendMailForReject(PurchaseImpl dbPurchase) throws PmException{
		Mail mailParam = new Mail();
		UserImpl userParam = new UserImpl();
		userParam.setId(dbPurchase.getApplicantId());
		UserImpl user = (UserImpl)this.userConditionMapper.getForEmail(userParam);
		mailParam.setTos(user.getEmail());
		
		StringBuffer sb = new StringBuffer();
		sb.append(ConfigUtil.getMailBodyHeader());
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><td colspan=\"6\"><h2>驳回的申请采购列表</h2></td></tr>\r\n");
		sb.append("<tr><th width=\"100\" >采购号</th><th width=\"250\">申请部门</th><th width=\"240\">申请人</th><th width=\"210\">申请日期</th><th width=\"150\">估算总金额</th><th width=\"50\">币种</th></tr>\r\n");
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		String quoteTotalAmount = "0.00";
		String currencyName ="";
		if(dbPurchase.getTotalRmbAmount() != 0.0){
			quoteTotalAmount =String.format("%.2f", dbPurchase.getQuoteTotalAmount());
		}
		if(StringUtils.isBlank(dbPurchase.getQuoteCurrencyId()) == false){
			if(StringUtils.equals(dbPurchase.getQuoteCurrencyId(), "1")){
				currencyName = "RMB";
			}else if(StringUtils.equals(dbPurchase.getQuoteCurrencyId(), "2")){
				currencyName = "USD";
			}
		}
		sb.append("<tr><td style=\"text-align:center;\">" + dbPurchase.getNo() + "</td><td style=\"text-align:center;\">" + dbPurchase.getApplicantdivisionName() + "</td><td style=\"text-align:center;\">" + dbPurchase.getApplicantName() + "</td><td style=\"text-align:center;\">" + sdf.format(dbPurchase.getApplicantDatetime())+ "</td><td style=\"text-align:right;\">" + quoteTotalAmount + "</td><td style=\"text-align:center;\">" + currencyName + "</td></tr>\r\n");
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		
		sb.append("<table class=\"mailtableh\" width=\"1000\" bordercolor=\"black\" border=\"1px\" cellspacing=\"1px\" cellpadding=\"1px\">\r\n");
		sb.append("<tbody>\r\n");
		sb.append("<tr><th width=\"100\">部门</th><th width=\"120\">客户</th><th width=\"130\">主类别</th><th width=\"130\">次类别</th><th width=\"380\">描述</th><th width=\"140\">估算金额</th></tr>\r\n");
		
		PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(dbPurchase.getId());
		
		List<PurchaseItemImpl> items = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);
		for(int i = 0; i < items.size(); i++){
			PurchaseItemImpl item = items.get(i);
			String customerName = "";
			String quoteAmount = "0.00";
			if(StringUtils.isBlank(item.getCustomerName()) == false){
				customerName = item.getCustomerName();
			}
			if(item.getQuoteAmount() != null){
				quoteAmount =String.format("%.2f", item.getQuoteAmount());
			}
			sb.append("<tr><td width=\"100\" style=\"text-align:left;\">" + item.getDivisionName() + "</td><td width=\"120\" style=\"text-align:left;\">" + customerName + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory1Name() + "</td><td width=\"130\" style=\"text-align:left;\">" + item.getCategory2Name() + "</td><td width=\"380\" style=\"text-align:left;\">" + item.getDescription()+ "</td><td width=\"140\" style=\"text-align:right;\">" + quoteAmount + "</td></tr>\r\n");
		}
		sb.append("</tbody>\r\n");
		sb.append("</table>\r\n");
		
		sb.append(ConfigUtil.getMailBodyFooter());
		
		mailParam.setContent(sb.toString());
		
		mailParam.setSubject("【驳回申请采购提醒】");
		//增加邮件
		addMail(mailParam);
	}
	
	/**
	 * 申请流程处理
	 */
	private PurchaseImpl applicationHandling(PurchaseImpl purchase, List<PurchaseItemImpl> itemList) throws PmException{
		int reqlevel = 0;
		if(NumberUtils.between(purchase.getReqLevel(), 0, 10)){
			reqlevel = purchase.getReqLevel();
		}else{
			reqlevel = 0;
		}
		
		//int reqlevel = 0;
		String pid =purchase.getApplicantdivisionId();
		//TODO TODELETE
		//PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		//purchaseItemParam.setPurchaseId(uuid);
		String categoryId = itemList.get(0).getCategory2Id();
		
		String codes = null;
		String domId = null;
		String interId = null;
		//domId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidDomCode());
		//interId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidInterCode());
		
		/*//国内机票
		if( NumberUtils.compare(categoryId, domId) ){
			codes = ConfigUtil.getPermissionAppDomesticCodes();
		//国际机票
		}else if( NumberUtils.compare(categoryId, interId) ){
			codes = ConfigUtil.getPermissionAppInternationalCodes();
		//普通申请
		}else{
			codes = ConfigUtil.getPermissionAppCodes();
		}*/
		//申请不区分是否是国内机票
		codes = ConfigUtil.getPermissionAppCodes();
		String[] codesArr = codes.split(",");
		
		List<UserImpl> userList = this.userConditionMapper.selectUserIdByCategoryIdAndLevel(categoryId, pid, reqlevel, codesArr);
		if(userList.isEmpty()){
			throw new PmException("没有匹配的申请审批人！");
		}
		
		StringBuilder mailSb = new StringBuilder();
		if(userList.isEmpty() == false){
			//获得审批人信息
			String[] userIds = new String[userList.size()];
			String[] userNames = new String[userList.size()];
			String[] userMails = new String[userList.size()];
			StringBuilder idSb = new StringBuilder();
			StringBuilder nameSb = new StringBuilder();
			
			for(int i = 0; i < userList.size(); i++){
				userIds[i] = userList.get(i).getId();
				userNames[i] = userList.get(i).getDisplayName();
				userMails[i] = userList.get(i).getEmail();
				if((i+1) == userList.size()){
					idSb.append(userIds[i]);
					nameSb.append(userNames[i]);
					mailSb.append(userMails[i]);
				}else{
					idSb.append(userIds[i] + ",");
					nameSb.append(userNames[i] + ",");
					mailSb.append(userMails[i] + ";");
				}
			}
			//临时插入
			purchase.setMailAddress(mailSb.toString());
			
			purchase.setSpecifiedlv1ApproveUserIds(idSb.toString());
			purchase.setSpecifiedlv1ApproveUserNames(nameSb.toString());
		}
		return purchase;
	}
	
	
	/**
	 * 采购流程处理
	 */
	private PurchaseImpl quoteHandling(PurchaseImpl purchase, List<PurchaseItemImpl> itemList) throws PmException{
		//审批人权限金额
		double amount = -1;
		boolean isNeedMaxFlag = true;
		String codes = null;
		String pid = purchase.getApplicantdivisionId();
		List<UserImpl> userList = new ArrayList<>();
		String code = ConfigUtil.getPermissionPurMaxCode();
		double quoteTotalAmount = purchase.getQuoteTotalAmount();
		
		PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		itemList = (List<PurchaseItemImpl>) this.purchaseItemMapper.select(purchaseItemParam);
		String categoryId = itemList.get(0).getCategory2Id();
		
		String domId = null;
		String interId = null;
		//domId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidDomCode());
		//interId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidInterCode());
		domId = ConfigUtil.getPermissionDomesticCategoryId();
		
		//国内机票
		if( NumberUtils.compare(categoryId, domId) ){
			codes = ConfigUtil.getPermissionPurDomesticCodes();
			quoteTotalAmount = 4;
			isNeedMaxFlag = false;
		//普通采购
		}else{
			codes = ConfigUtil.getPermissionPurCodes();
		}
		String[] codesArr = codes.split(",");
		
		List<UserImpl> maxUserList = this.userConditionMapper.selectByCode(code, purchase.getTotalRmbAmount());
			
		int countMinAmount = this.permissionConditionMapper.countMinAmountByAmount(amount, categoryId, pid, codesArr);
		double minPermissionAmount = 0.0;
		if(countMinAmount > 0){
			minPermissionAmount = this.permissionConditionMapper.getMinAmountByAmount(amount, categoryId, pid, codesArr);
			if(minPermissionAmount <= quoteTotalAmount){
				userList = this.userConditionMapper.selectUserIdByCategoryIdAndAmount(categoryId, pid, minPermissionAmount, codesArr);
			}
		}
		
		//NEW
		if(userList.isEmpty()){
			maxUserList = this.userConditionMapper.selectByCode(code, purchase.getTotalRmbAmount());
			if(maxUserList.isEmpty() == false && isNeedMaxFlag == true){
				userList = maxUserList;
			}
		}
		
		if(userList.isEmpty() ){
			throw new PmException("没有匹配的申请审批人！");
		}
		StringBuilder mailSb = new StringBuilder();
		if(userList.isEmpty() == false){
			//获得审批人信息
			String[] userIds = new String[userList.size()];
			String[] userNames = new String[userList.size()];
			String[] userMails = new String[userList.size()];
			StringBuilder idSb = new StringBuilder();
			StringBuilder nameSb = new StringBuilder();
			
			for(int i = 0; i < userList.size(); i++){
				userIds[i] = userList.get(i).getId();
				userNames[i] = userList.get(i).getDisplayName();
				userMails[i] = userList.get(i).getEmail();
				if((i+1) == userList.size()){
					idSb.append(userIds[i]);
					nameSb.append(userNames[i]);
					mailSb.append(userMails[i]);
				}else{
					idSb.append(userIds[i] + ",");
					nameSb.append(userNames[i] + ",");
					mailSb.append(userMails[i] + ";");
				}
			}
			purchase.setSpecifiedlv2ApproveUserIds(idSb.toString());
			purchase.setSpecifiedlv2ApproveUserNames(nameSb.toString());
			purchase.setSpecifiedlv1ApproveUserIds(null);
			purchase.setSpecifiedlv1ApproveUserNames(null);
			purchase.setMailAddress(mailSb.toString());
		}
		return purchase;
	}
	
	/**
	 * 申请审批流程处理
	 */
	private PurchaseImpl lv1Handling(PurchaseImpl purchase, List<PurchaseItemImpl> itemList) throws PmException{
		//1.确定申请审批人
		int reqlevel = purchase.getReqLevel();
		String pid = purchase.getApplicantdivisionId();
		
		/*PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		List<PurchaseItemImpl> itemList = new ArrayList<PurchaseItemImpl>();
		
		itemList = (List<PurchaseItemImpl>)this.purchaseItemMapper.select(purchaseItemParam);*/
		String categoryId = itemList.get(0).getCategory2Id();
		
		String codes = null;
		String domId = null;
		String interId = null;
		//domId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidDomCode());
		//interId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidInterCode());
		
		/*//国内机票
		if( NumberUtils.compare(categoryId, domId) ){
			codes = ConfigUtil.getPermissionAppDomesticCodes();
		//国际机票
		}else if( NumberUtils.compare(categoryId, interId) ){
			codes = ConfigUtil.getPermissionAppInternationalCodes();
		//普通申请
		}else{
			codes = ConfigUtil.getPermissionAppCodes();
		}*/
		//申请不区分是否是国内机票
		codes = ConfigUtil.getPermissionAppCodes();
		String[] codesArr = codes.split(",");
		
		List<UserImpl> userList = this.userConditionMapper.selectUserIdByCategoryIdAndLevel(categoryId, pid, reqlevel, codesArr);
		StringBuilder mailSb = new StringBuilder();
		if(userList.isEmpty() == false){
			//获得审批人信息
			String[] userIds = new String[userList.size()];
			String[] userNames = new String[userList.size()];
			String[] userMails = new String[userList.size()];
			StringBuilder idSb = new StringBuilder();
			StringBuilder nameSb = new StringBuilder();
			
			for(int i = 0; i < userList.size(); i++){
				userIds[i] = userList.get(i).getId();
				userNames[i] = userList.get(i).getDisplayName();
				userMails[i] = userList.get(i).getEmail();
				if((i+1) == userList.size()){
					idSb.append(userIds[i]);
					nameSb.append(userNames[i]);
					mailSb.append(userMails[i]);
				}else{
					idSb.append(userIds[i] + ",");
					nameSb.append(userNames[i] + ",");
					mailSb.append(userMails[i] + ";");
				}
			}
			purchase.setSpecifiedlv1ApproveUserIds(idSb.toString());
			purchase.setSpecifiedlv1ApproveUserNames(nameSb.toString());
			//临时插入
			purchase.setMailAddress(mailSb.toString());
		}else{
			// 申请审批完成
			purchase.setStatus(PurchaseImpl.STATUS_LV1);
		}
		return purchase;
	}
	
	/**
	 * 采购审批流程处理
	 */
	private PurchaseImpl lv2Handling(PurchaseImpl purchase, List<PurchaseItemImpl> itemList, String sessioinUserId) throws PmException{
		//1.确定申请审批人
		//审批人权限金额
		double amount = 0.0;
		boolean isNeedMaxFlag = true;
		String pid = purchase.getApplicantdivisionId();
		double quoteTotalAmount = purchase.getTotalRmbAmount();
		/*PurchaseItemImpl purchaseItemParam = new PurchaseItemImpl();
		purchaseItemParam.setPurchaseId(purchase.getId());
		List<PurchaseItemImpl> itemList = (List<PurchaseItemImpl>) this.purchaseItemMapper.select(purchaseItemParam);*/
		List<UserImpl> userList = new ArrayList<UserImpl>();
		String code = ConfigUtil.getPermissionPurMaxCode();
		String categoryId = itemList.get(0).getCategory2Id();
		String codes = null;
		String domId = null;
		String interId = null;
		//domId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidDomCode());
		//interId = this.permissionConditionMapper.getValueByCode(ConfigUtil.getPermissionCidInterCode());
		domId = ConfigUtil.getPermissionDomesticCategoryId();
		//国内机票
		if( NumberUtils.compare(categoryId, domId) ){
			codes = ConfigUtil.getPermissionPurDomesticCodes();
			quoteTotalAmount = 4;
			isNeedMaxFlag = false;
		//普通采购
		}else{
			codes = ConfigUtil.getPermissionPurCodes();
		}
		String[] codesArr = codes.split(",");
		
		List<UserImpl> maxUserList = this.userConditionMapper.selectByCode(code, purchase.getTotalRmbAmount());
		String maxId = "" ;
		if(maxUserList.isEmpty() == false ){
			maxId = maxUserList.get(0).getId();
		}
		
		if(StringUtils.equals(sessioinUserId, maxId) == false){
			PermissionImpl permission = this.permissionConditionMapper.getAmountByUserId(sessioinUserId, categoryId, pid, codesArr);
			if(permission != null){
				amount = permission.getAmount();
			}
			//判断最小的一个或多个人
			int countMinAmount = this.permissionConditionMapper.countMinAmountByAmount(amount, categoryId, pid, codesArr);
			double minPermissionAmount = 0.0;
			if(countMinAmount > 0){
				minPermissionAmount = this.permissionConditionMapper.getMinAmountByAmount(amount, categoryId, pid, codesArr);
				if(minPermissionAmount <= quoteTotalAmount){
					userList = this.userConditionMapper.selectUserIdByCategoryIdAndAmount(categoryId, pid, minPermissionAmount, codesArr);
				}
			}
			//NEW
			if(userList.isEmpty()){
				maxUserList = this.userConditionMapper.selectByCode(code, purchase.getTotalRmbAmount());
				if(maxUserList.isEmpty() == false && isNeedMaxFlag == true){
					userList = maxUserList;
				}
			}
		}
		/*if(userList.isEmpty()){
			throw new PmException("没有匹配的申请审批人！");
		}*/
		StringBuilder mailSb = new StringBuilder();
		if(userList.isEmpty() == false){
			//获得审批人信息
			String[] userIds = new String[userList.size()];
			String[] userNames = new String[userList.size()];
			String[] userMails = new String[userList.size()];
			StringBuilder idSb = new StringBuilder();
			StringBuilder nameSb = new StringBuilder();
			
			for(int i = 0; i < userList.size(); i++){
				userIds[i] = userList.get(i).getId();
				userNames[i] = userList.get(i).getDisplayName();
				userMails[i] = userList.get(i).getEmail();
				if((i+1) == userList.size()){
					idSb.append(userIds[i]);
					nameSb.append(userNames[i]);
					mailSb.append(userMails[i]);
				}else{
					idSb.append(userIds[i] + ",");
					nameSb.append(userNames[i] + ",");
					mailSb.append(userMails[i] + ";");
				}
			}
			purchase.setSpecifiedlv2ApproveUserIds(idSb.toString());
			purchase.setSpecifiedlv2ApproveUserNames(nameSb.toString());
			//临时插入
			purchase.setMailAddress(mailSb.toString());
		}else{
			// 采购审批完成
			purchase.setStatus(PurchaseImpl.STATUS_LV2);
		}
		return purchase;
	}
	
	@Override
	public List<PurchaseImpl> selectForApplicantReport(PurchaseImpl purchase) throws PmException {
		List<PurchaseImpl> list = this.purchaseMapper.selectForMonthReportByApplicant(purchase);
		if (list == null) {
			list = new ArrayList<PurchaseImpl>();
		}
		return list;
	}
	
	@Override
	public List<PurchaseImpl> selectForCustomerReport(PurchaseImpl purchase) throws PmException {
		List<PurchaseImpl> list = this.purchaseMapper.selectForMonthReportByCustomer(purchase);
		if (list == null) {
			list = new ArrayList<PurchaseImpl>();
		}
		return list;
	}
	
}