package com.mtf.framework.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.AttenRuleImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 考勤规则
 * 作者:     Auto
 * 日期:     2015/4/24
**********************************************
*/
public interface AttenRuleService {
	/**
	 * 新增实体对象
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public AttenRuleImpl insert(AttenRuleImpl attenRule) throws PmException;

	/**
	 * 删除实体对象
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public int delete(AttenRuleImpl attenRule) throws PmException;

	/**
	 * 更新实体对象
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public boolean update(AttenRuleImpl attenRule) throws PmException;

	/**
	 * 查询实体列表
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public List<AttenRuleImpl> select(AttenRuleImpl attenRule) throws PmException;

	/**
	 * 取得单一对象
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public AttenRuleImpl get(AttenRuleImpl attenRule) throws PmException;

	/**
	 * 查询实体分页列表
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenRuleImpl> search(AttenRuleImpl attenRule) throws PmException;
	
	/**
	 * 考勤数据采集
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenRuleImpl> doMonitorCollection(AttenRuleImpl attenRule) throws PmException;
	
	/**
	 * 根据部门日期既得上班时间段
	 * @param attenRule
	 * @return
	 * @throws PmException
	 */
	public DataGrid<AttenRuleImpl> doGetWorkHourRange(AttenRuleImpl attenRule) throws PmException;
	

}