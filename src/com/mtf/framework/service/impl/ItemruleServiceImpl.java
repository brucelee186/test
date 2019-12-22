package com.mtf.framework.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ItemruleImpl;
import com.mtf.framework.dao.ItemruleMapper;
import com.mtf.framework.model.Itemrule;
import com.mtf.framework.service.impl.common.CommonServiceImpl;
import com.mtf.framework.service.ItemruleService;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 办公用品领取规则
 * 作者:     Auto
 * 日期:     2013/12/12
**********************************************
*/
@Service("itemRuleService")
public class ItemruleServiceImpl extends CommonServiceImpl implements ItemruleService {
	@Autowired
	private ItemruleMapper itemRuleMapper;

	@Autowired
	public ItemruleMapper getItemruleMapper() {
		return itemRuleMapper;
	}

	@Autowired
	public void setItemruleMapper(ItemruleMapper itemRuleMapper) {
		this.itemRuleMapper = itemRuleMapper;
	}

	/**
	 * 新增实体对象
	 * @param itemRule
	 */
	public ItemruleImpl insert(ItemruleImpl itemRuleImpl) throws PmException {
		this.itemRuleMapper.insert(itemRuleImpl);
		return itemRuleImpl;
	}

	/**
	 * 删除实体对象
	 * @param itemRule
	 */
	public int delete(ItemruleImpl itemRuleImpl) throws PmException {
		return this.itemRuleMapper.delete(itemRuleImpl);
	}

	/**
	 * 更新实体对象
	 * @param itemRule
	 */
	public boolean update(ItemruleImpl itemRuleImpl) throws PmException {
		boolean result = true;
		this.itemRuleMapper.update(itemRuleImpl);
		return result;
	}
	/**
	 * 查询单个实体
	 * @param itemRule
	 */
	public ItemruleImpl get(ItemruleImpl itemRuleImpl) throws PmException {
		return (ItemruleImpl) this.itemRuleMapper.get(itemRuleImpl);
	}
	/**
	 * 查询实体列表
	 * @param itemRule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ItemruleImpl> select(ItemruleImpl itemRuleImpl) throws PmException {
		DataGrid<ItemruleImpl> grid = new DataGrid<ItemruleImpl>();
		Object obj = itemRuleImpl;
		List list = itemRuleMapper.select(obj);
		grid.setRows(list);
		int count;
		count = itemRuleMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<ItemruleImpl> selectByName(ItemruleImpl itemRuleImpl) throws PmException {
		DataGrid<ItemruleImpl> grid = new DataGrid<ItemruleImpl>();
		//过滤
		/*HashMap<String, Object> param = new HashMap<String, Object>();
		if (itemRuleImpl.getStatus() != null) {
			param.put("status", itemRuleImpl.getStatus());
		}*/
		//itemRuleImpl.("sort", "C_FABRICTYPE_NAME");
		Object obj = itemRuleImpl;
		List list = itemRuleMapper.selectByName(obj);
		grid.setRows(list);
		int count;
		count = itemRuleMapper.countByName(obj);
		grid.setTotal(count);
		return grid;
	}
}