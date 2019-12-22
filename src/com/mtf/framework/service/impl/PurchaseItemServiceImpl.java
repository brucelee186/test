package com.mtf.framework.service.impl;

import java.util.List;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.dao.PurchaseItemMapper;
import com.mtf.framework.dao.PurchaseMapper;
import com.mtf.framework.model.impl.PurchaseImpl;
import com.mtf.framework.model.impl.PurchaseItemImpl;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.PurchaseItemService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.UUIDUtils;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 采购子列表
 * 作者:     Auto
 * 日期:     2015/3/5
**********************************************
*/
@Service("purchaseItemService")
public class PurchaseItemServiceImpl extends CommonServiceImpl implements PurchaseItemService {
	private PurchaseItemMapper purchaseItemMapper;
	private PurchaseMapper purchaseMapper;
	
	@Autowired
	public void setPurchaseItemMapper(PurchaseItemMapper purchaseItemMapper) {
		this.purchaseItemMapper = purchaseItemMapper;
	}
	
	@Autowired
	public void setPurchaseMapper(PurchaseMapper purchaseMapper) {
		this.purchaseMapper = purchaseMapper;
	}

	/**
	 * 新增实体对象
	 * @param purchaseItem
	 */
	public PurchaseItemImpl insert(PurchaseItemImpl purchaseItem , HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		Date now = new Date();
		if(purchaseItem.getPurchaseId() == null || purchaseItem.getPurchaseId().equals("")){
			//添加采购
			PurchaseImpl purchase =new PurchaseImpl();
			String uuid = UUIDUtils.genUUID();
			purchase.setId(uuid);
			purchase.setApplicantId(sessionInfo.getUserId());
			purchase.setApplicantName(sessionInfo.getDisplayName());
			purchase.setApplicantDatetime(now);
			purchase.setApplicantdivisionId(purchaseItem.getDivisionId());
			purchase.setApplicantdivisionName(purchaseItem.getDivisionName());
			
			purchase.setStatus(0);
			
			purchase.setCreateUserId(sessionInfo.getUserId());
			purchase.setCreateUserName(sessionInfo.getDisplayName());
			purchase.setCreateDatetime(now);
			this.purchaseMapper.insert(purchase);
		}
		purchaseItem.setId(UUIDUtils.genUUID());
		this.purchaseItemMapper.insert(purchaseItem);
		return purchaseItem;
	}

	/**
	 * 查询实体列表
	 * @param purchaseItem
	 */
	@SuppressWarnings("unchecked")
	public List<PurchaseItemImpl> select(PurchaseItemImpl purchaseItem) throws PmException {
		return (List<PurchaseItemImpl>) this.purchaseItemMapper.select(purchaseItem);
	}
	
	/**
	 * 查询实体列表
	 * @param purchaseItem
	 */
	@SuppressWarnings("unchecked")
	public List<PurchaseItemImpl> selectWithPurchase(PurchaseItemImpl purchaseItem, String no, HttpSession session) throws PmException {
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		
		String userId = sessionInfo.getUserId();
		return this.purchaseItemMapper.selectWithPurchase(purchaseItem, no, userId);
	}
	
	/**
	 * 查询实体分页列表
	 * @param purchaseItem
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<PurchaseItemImpl> search(PurchaseItemImpl purchaseItem) throws PmException {
		DataGrid<PurchaseItemImpl> grid = new DataGrid<PurchaseItemImpl>();
		Object obj = purchaseItem;
		List list = purchaseItemMapper.select(obj);
		grid.setRows(list);
		int count;
		count = purchaseItemMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}