package com.mtf.framework.service;

import java.util.List;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.Contract;
import com.mtf.framework.model.Items;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.impl.ContractImpl;

public interface ContractService {
	
	/**
	 * 添加对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	ContractImpl insert(ContractImpl contractImpl) throws PmException;
	
	/**
	 * 添加对象
	 * @param contract
	 * @param listItems
	 * @return
	 * @throws PmException
	 */
	ContractImpl insert(ContractImpl contractImpl, List<Items> listItems) throws PmException;
	
	/**
	 * 搜索对象列表
	 * 
	 * @param uid 操作对象
	 * @param form 参数
	 * @return 对象列表
	 * @throws PmException
	 */
	DataGrid<ContractImpl> select(ContractImpl contractImpl) throws PmException;
	
	/**
	 * 取得单一对象
	 * @param Contract
	 * @return
	 * @throws PmException
	 */
	ContractImpl get(ContractImpl contractImpl) throws PmException;
	
	/**
	 * 更新单一对象
	 * @param Contract
	 * @return
	 * @throws PmException
	 */
	int update(ContractImpl contractImpl) throws PmException;
	
	/**
	 * 更新对象
	 * @param Contract
	 * @return
	 * @throws PmException
	 */
	int update(ContractImpl contractImpl, List<Items> listItems) throws PmException;
	
	/**
	 * 删除对象
	 * @param contract
	 * @return
	 * @throws PmException
	 */
	int delete(ContractImpl contractImpl) throws PmException;
}
