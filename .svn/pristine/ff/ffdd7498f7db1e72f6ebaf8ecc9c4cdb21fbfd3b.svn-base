package com.mtf.framework.service.impl;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fr.data.core.db.dml.Insert;
import com.fr.third.org.apache.poi.hssf.record.formula.IntPtg;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.DepofficeImpl;
import com.mtf.framework.model.impl.ItemImpl;
import com.mtf.framework.model.impl.ItemruleImpl;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.dao.DepofficeMapper;
import com.mtf.framework.dao.ItemMapper;
import com.mtf.framework.dao.ItemruleMapper;
import com.mtf.framework.dao.OfficeMapper;
import com.mtf.framework.model.Action;
import com.mtf.framework.model.Item;
import com.mtf.framework.model.Role;
import com.mtf.framework.model.Role2Action;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.ItemService;
import com.mtf.framework.util.Constants;
import com.mtf.framework.util.DateComparaUtil;
import com.mtf.framework.util.TextUtils;
import com.sybase.jdbc2.jdbc.Convert;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品明细
 * 作者:     Auto
 * 日期:     2013-12-12
**********************************************
*/
@Service("itemService")
public class ItemServiceImpl extends CommonServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	
	@Autowired
	private OfficeMapper officeMapper;
	
	@Autowired
	private ItemruleMapper itemRuleMapper;
	
	@Autowired
	private DepofficeMapper depofficeMapper;
	

	@Autowired
	public ItemMapper getItemMapper() {
		return itemMapper;
	}

	@Autowired
	public void setItemMapper(ItemMapper itemMapper) {
		this.itemMapper = itemMapper;
	}

	@Autowired
	public OfficeMapper getOfficeMapper() {
		return officeMapper;
	}

	@Autowired
	public void setOfficeMapper(OfficeMapper officeMapper) {
		this.officeMapper = officeMapper;
	}
	
	@Autowired
	public ItemruleMapper getItemRuleMapper() {
		return itemRuleMapper;
	}

	@Autowired
	public void setItemRuleMapper(ItemruleMapper itemRuleMapper) {
		this.itemRuleMapper = itemRuleMapper;
	}
	
	@Autowired
	public DepofficeMapper getDepofficeMapper() {
		return depofficeMapper;
	}

	@Autowired
	public void setDepofficeMapper(DepofficeMapper depofficeMapper) {
		this.depofficeMapper = depofficeMapper;
	}

	/**
	 * 新增实体对象
	 * @param item
	 */
	public ItemImpl insert(ItemImpl itemImpl) throws PmException {
		itemMapper.insert(itemImpl);
		return itemImpl;
	}

	/**
	 * 删除实体对象
	 * @param item
	 */
	public int delete(ItemImpl itemImpl) throws PmException {
		return this.itemMapper.delete(itemImpl);
	}

	/**
	 * 更新实体对象
	 * @param item
	 */
	public boolean update(String[] ruleId ,String[] amount,ItemImpl itemImpl,HttpSession session) throws PmException {
		boolean result = true;
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
			// 删除之前办公用品明细数据
			int userLevel = itemImpl.getUserLevel();
			if (!"".equals(itemImpl.getOfficeId())) {
				itemMapper.delete(itemImpl);
			}
			// 更新office表状态
			OfficeImpl officeImpl = new OfficeImpl();
			officeImpl.setId(itemImpl.getOfficeId());
			// 如果用户为高管，编辑后状态为部门确认
			if (userLevel == 4) {
				officeImpl.setApproveState("approve1");
			}else {
				officeImpl.setApproveState("submit");
			}
			// 更新修改时间
			officeImpl.setModifiedDate(new Date());
			//更新部门
			officeImpl.setDepartment(sessionInfo.getDivisionName());
			officeImpl.setDepartmentId(sessionInfo.getDivisionId());
			officeMapper.update(officeImpl);
			if (ruleId != null && ruleId.length > 0) {
				// 插入办公用品明细
				insetItem(ruleId, amount, userLevel, officeImpl);

			}

		return result;
	}
	/**
	 * 查询单个实体
	 * @param item
	 */
	public ItemImpl get(ItemImpl itemImpl) throws PmException {
		return (ItemImpl) this.itemMapper.get(itemImpl);
	}
	/**
	 * 查询实体列表
	 * @param item
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ItemImpl> select(ItemImpl itemImpl) throws PmException {
		DataGrid<ItemImpl> grid = new DataGrid<ItemImpl>();
		Object obj = itemImpl;
		List list = itemMapper.select(obj);
		grid.setRows(list);
		int count;
		count = itemMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}

	//　添加办公用品申请
	@Override
	public void insertItemRule(String[] ruleId ,String[] amount,OfficeImpl officeImpl,HttpSession session) throws PmException{
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		int userLevel = sessionInfo.getUserLever();
		// 插入office表中当前信息
		if (null == officeImpl.getId()) {
			officeMapper.insert(officeImpl);
		}
		if (ruleId != null && ruleId.length > 0) {
			// 插入办公用品明细
			insetItem(ruleId, amount, userLevel, officeImpl);
			if (userLevel == 4) {
				mangaerApprove(officeImpl, session);
			}

		}
		
	}
	
	// 添加办公用品
	private void insetItem(String[] ruleId,String[] amount,int userLevel,OfficeImpl officeImpl) throws PmException{
		for (int i = 0; i < ruleId.length; i++) {
			// 验证前台传到后台的数据是否符合要求的最大值
			ItemruleImpl itemRule = new ItemruleImpl();
			itemRule.setId(Long.parseLong(ruleId[i]));
			itemRule = (ItemruleImpl) itemRuleMapper.get(itemRule);
			// 5：临时用户
			if (userLevel !=5) {
				if (Integer.parseInt(amount[i]) > itemRule.getAmountMax()) {
					throw new PmException("超过最大上限",2);
				}
			}
			ItemImpl item = new ItemImpl();
			item.setAmount(Integer.parseInt(amount[i]));
			item.setRuleId(Long.parseLong(ruleId[i]));
			item.setOfficeId(officeImpl.getId());
			itemMapper.insert(item);
		}
	}
	
	
	// 高管提交
	public void mangaerApprove(OfficeImpl office,HttpSession session){
		SessionInfo sessionInfo = (SessionInfo) session.getAttribute(Constants.SESSION_INFO);
		int userLevel = sessionInfo.getUserLever();
		Date addDate = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
		OfficeImpl officeImpl = new OfficeImpl();
		officeImpl.setUserLevel(userLevel);
		// 查看部门表是否有记录
			DepofficeImpl depoffice = new DepofficeImpl();
			depoffice.setApplyMonth(sdf.format(addDate));
			depoffice.setDepartmentId(sessionInfo.getDivisionId());
			// 查询当前记录是否是审批过的二次审批
			DepofficeImpl deoff = (DepofficeImpl) depofficeMapper.get(depoffice);
			DateComparaUtil dateComparaUtil = DateComparaUtil.getInstance();
			// 第一次审批
			if (null == deoff) {
				depoffice.setApplyMonth(dateComparaUtil.dateCompara());
				depoffice.setDepartmentId(sessionInfo.getDivisionId());
				depoffice.setDepartment(sessionInfo.getDivisionName());
				depoffice.setAddDate(addDate);
				depoffice.setModifiedDate(addDate);
				depoffice.setApproveState("approve1");
				depofficeMapper.insert(depoffice);
				officeImpl.setDepOfficeId(depoffice.getId());
			}else {
				officeImpl.setDepOfficeId(deoff.getId());
			}
				// 第二次审批
		
				officeImpl.setDepartmentId(sessionInfo.getDivisionId());
				officeImpl.setApplyMonth(DateComparaUtil.dateCompara());
				// 申请表更新
				officeMapper.updateApprove(officeImpl);
			
			
	}

}