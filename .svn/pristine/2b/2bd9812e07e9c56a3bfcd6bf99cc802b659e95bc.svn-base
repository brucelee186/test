package com.mtf.framework.service;

import com.mtf.framework.exception.PmException;
import com.mtf.framework.model.common.DataGrid;
import com.mtf.framework.model.common.SessionInfo;
import com.mtf.framework.model.impl.OfficeImpl;
import com.mtf.framework.model.Office;
/*
**********************************************
 * 项目名称：contract(合同管理系统)
 * 模块名称：业务层接口 -> 办公用品申请表
 * 作者:     Auto
 * 日期:     2013-12-12
**********************************************
*/
public interface OfficeService {
	/**
	 * 新增实体对象
	 * @param office
	 * @return
	 * @throws PmException
	 */
	public OfficeImpl insert(OfficeImpl officeImpl) throws PmException;

	/**
	 * 删除实体对象
	 * @param office
	 * @return
	 * @throws PmException
	 */
	public int delete(OfficeImpl officeImpl) throws PmException;

	/**
	 * 更新实体对象
	 * @param office
	 * @return
	 * @throws PmException
	 */
	public boolean update(OfficeImpl officeImpl) throws PmException;

	/**
	 * 查询实体数量
	 * @param office
	 * @return
	 * @throws PmException
	 */
	public DataGrid<OfficeImpl> select(OfficeImpl officeImpl) throws PmException;

	/**
	 * 取得单一对象
	 * @param office
	 * @return
	 * @throws PmException
	 */
	public OfficeImpl get(OfficeImpl officeImpl) throws PmException;
	
	/**
	 * 审批
	 * 
	 */
	
	public void updateApprove(OfficeImpl officeImpl,SessionInfo sessionInfo) throws PmException;

}