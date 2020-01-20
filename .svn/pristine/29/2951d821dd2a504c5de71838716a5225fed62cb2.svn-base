package com.mtf.framework.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.BudgetImpl;
import com.mtf.framework.model.impl.ContractImpl;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 合同
 * 作者:     Auto
 * 日期:     2013-09-26
**********************************************
*/
public interface BudgetService {
	/**
	 * 新增预算
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl insert(BudgetImpl budgetImpl, ContractImpl contractImpl) throws PmException;
	
	/**
	 * 合同复制
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl insert(ContractImpl contract, List<BudgetImpl> listBudget) throws PmException;
	
	/**
	 * 新增实体对象
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl insert(BudgetImpl budgetImpl) throws PmException;
	/**
	 * 删除实体对象
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public int delete(BudgetImpl budgetImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public boolean update(BudgetImpl budgetImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public DataGrid<BudgetImpl> select(BudgetImpl budgetImpl) throws PmException;
	
	/**
	 * 查询实体数量
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public List<BudgetImpl> search(BudgetImpl budgetImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl get(BudgetImpl budgetImpl) throws PmException;
	
	/**
	 * 复制预算为决算
	 * @param BudgetImpl
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl copyBudget2Current(BudgetImpl budgetImpl) throws PmException;
	
	/**
	 * 取得预算对应的明细
	 * @param budget
	 * @return
	 * @throws PmException
	 */
	public BudgetImpl getBudgetDetail(BudgetImpl budget) throws PmException;
	
	/**
	 * 合同变更
	 * @param contractImpl
	 * @param session
	 * @return
	 * @throws PmException
	 */
	public ModelAndView modifyContract(ContractImpl contract, List<BudgetImpl> listBudget) throws PmException;
}