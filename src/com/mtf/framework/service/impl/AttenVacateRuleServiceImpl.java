package com.mtf.framework.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtf.framework.dao.AttenVacateRuleMapper;
import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenVacateRuleImpl;
import com.mtf.framework.service.AttenVacateRuleService;
import com.mtf.framework.service.impl.common.CommonServiceImpl;

/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：基础资料 -> 请假天数限定
 * 作者:     Auto
 * 日期:     2015/7/26
**********************************************
*/
@Service("attenVacateRuleService")
public class AttenVacateRuleServiceImpl extends CommonServiceImpl implements AttenVacateRuleService {
	@Autowired
	private AttenVacateRuleMapper attenVacateRuleMapper;

	@Autowired
	public AttenVacateRuleMapper getAttenVacateRuleMapper() {
		return attenVacateRuleMapper;
	}

	@Autowired
	public void setAttenVacateRuleMapper(AttenVacateRuleMapper attenVacateRuleMapper) {
		this.attenVacateRuleMapper = attenVacateRuleMapper;
	}

	/**
	 * 新增实体对象
	 * @param attenVacateRule
	 */
	public AttenVacateRuleImpl insert(AttenVacateRuleImpl attenVacateRule) throws PmException {
		this.attenVacateRuleMapper.insert(attenVacateRule);
		return attenVacateRule;
	}

	/**
	 * 删除实体对象
	 * @param attenVacateRule
	 */
	public int delete(AttenVacateRuleImpl attenVacateRule) throws PmException {
		return this.attenVacateRuleMapper.delete(attenVacateRule);
	}

	/**
	 * 更新实体对象
	 * @param attenVacateRule
	 */
	public boolean update(AttenVacateRuleImpl attenVacateRule) throws PmException {
		Long id = attenVacateRule.getId();
		boolean result = true;
		String tagScope = attenVacateRule.getTagScope();
		if ("a".equals(tagScope)) {
			attenVacateRule.setUserId(null);
		}
		if (null == id || "".equals(id)) {
				
			attenVacateRuleMapper.insert(attenVacateRule);
		} else {
			this.attenVacateRuleMapper.update(attenVacateRule);
		}
		return result;
	}
	/**
	 * 查询实体列表
	 * @param attenVacateRule
	 */
	@SuppressWarnings("unchecked")
	public List<AttenVacateRuleImpl> select(AttenVacateRuleImpl attenVacateRule) throws PmException {
		return (List<AttenVacateRuleImpl>) this.attenVacateRuleMapper.select(attenVacateRule);
	}
	/**
	 * 查询单个实体
	 * @param attenVacateRule
	 */
	public AttenVacateRuleImpl get(AttenVacateRuleImpl attenVacateRule) throws PmException {
		return (AttenVacateRuleImpl) this.attenVacateRuleMapper.get(attenVacateRule);
	}
	/**
	 * 查询实体分页列表
	 * @param attenVacateRule
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public DataGrid<AttenVacateRuleImpl> search(AttenVacateRuleImpl attenVacateRule) throws PmException {
		DataGrid<AttenVacateRuleImpl> grid = new DataGrid<AttenVacateRuleImpl>();
		Object obj = attenVacateRule;
		List list = attenVacateRuleMapper.select(obj);
		grid.setRows(list);
		int count;
		count = attenVacateRuleMapper.count(obj);
		grid.setTotal(count);
		return grid;
	}
}